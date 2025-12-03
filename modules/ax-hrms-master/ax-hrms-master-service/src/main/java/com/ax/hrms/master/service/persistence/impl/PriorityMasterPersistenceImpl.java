/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence.impl;

import com.ax.hrms.master.exception.NoSuchPriorityMasterException;
import com.ax.hrms.master.model.PriorityMaster;
import com.ax.hrms.master.model.PriorityMasterTable;
import com.ax.hrms.master.model.impl.PriorityMasterImpl;
import com.ax.hrms.master.model.impl.PriorityMasterModelImpl;
import com.ax.hrms.master.service.persistence.PriorityMasterPersistence;
import com.ax.hrms.master.service.persistence.PriorityMasterUtil;
import com.ax.hrms.master.service.persistence.impl.constants.ax_masterPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the priority master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PriorityMasterPersistence.class)
public class PriorityMasterPersistenceImpl
	extends BasePersistenceImpl<PriorityMaster>
	implements PriorityMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PriorityMasterUtil</code> to access the priority master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PriorityMasterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByPriorityName;
	private FinderPath _finderPathCountByPriorityName;

	/**
	 * Returns the priority master where priorityName = &#63; or throws a <code>NoSuchPriorityMasterException</code> if it could not be found.
	 *
	 * @param priorityName the priority name
	 * @return the matching priority master
	 * @throws NoSuchPriorityMasterException if a matching priority master could not be found
	 */
	@Override
	public PriorityMaster findByPriorityName(String priorityName)
		throws NoSuchPriorityMasterException {

		PriorityMaster priorityMaster = fetchByPriorityName(priorityName);

		if (priorityMaster == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("priorityName=");
			sb.append(priorityName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPriorityMasterException(sb.toString());
		}

		return priorityMaster;
	}

	/**
	 * Returns the priority master where priorityName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param priorityName the priority name
	 * @return the matching priority master, or <code>null</code> if a matching priority master could not be found
	 */
	@Override
	public PriorityMaster fetchByPriorityName(String priorityName) {
		return fetchByPriorityName(priorityName, true);
	}

	/**
	 * Returns the priority master where priorityName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param priorityName the priority name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching priority master, or <code>null</code> if a matching priority master could not be found
	 */
	@Override
	public PriorityMaster fetchByPriorityName(
		String priorityName, boolean useFinderCache) {

		priorityName = Objects.toString(priorityName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {priorityName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByPriorityName, finderArgs, this);
		}

		if (result instanceof PriorityMaster) {
			PriorityMaster priorityMaster = (PriorityMaster)result;

			if (!Objects.equals(
					priorityName, priorityMaster.getPriorityName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PRIORITYMASTER_WHERE);

			boolean bindPriorityName = false;

			if (priorityName.isEmpty()) {
				sb.append(_FINDER_COLUMN_PRIORITYNAME_PRIORITYNAME_3);
			}
			else {
				bindPriorityName = true;

				sb.append(_FINDER_COLUMN_PRIORITYNAME_PRIORITYNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPriorityName) {
					queryPos.add(StringUtil.toLowerCase(priorityName));
				}

				List<PriorityMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByPriorityName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {priorityName};
							}

							_log.warn(
								"PriorityMasterPersistenceImpl.fetchByPriorityName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PriorityMaster priorityMaster = list.get(0);

					result = priorityMaster;

					cacheResult(priorityMaster);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (PriorityMaster)result;
		}
	}

	/**
	 * Removes the priority master where priorityName = &#63; from the database.
	 *
	 * @param priorityName the priority name
	 * @return the priority master that was removed
	 */
	@Override
	public PriorityMaster removeByPriorityName(String priorityName)
		throws NoSuchPriorityMasterException {

		PriorityMaster priorityMaster = findByPriorityName(priorityName);

		return remove(priorityMaster);
	}

	/**
	 * Returns the number of priority masters where priorityName = &#63;.
	 *
	 * @param priorityName the priority name
	 * @return the number of matching priority masters
	 */
	@Override
	public int countByPriorityName(String priorityName) {
		priorityName = Objects.toString(priorityName, "");

		FinderPath finderPath = _finderPathCountByPriorityName;

		Object[] finderArgs = new Object[] {priorityName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRIORITYMASTER_WHERE);

			boolean bindPriorityName = false;

			if (priorityName.isEmpty()) {
				sb.append(_FINDER_COLUMN_PRIORITYNAME_PRIORITYNAME_3);
			}
			else {
				bindPriorityName = true;

				sb.append(_FINDER_COLUMN_PRIORITYNAME_PRIORITYNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPriorityName) {
					queryPos.add(StringUtil.toLowerCase(priorityName));
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PRIORITYNAME_PRIORITYNAME_2 =
		"lower(priorityMaster.priorityName) = ?";

	private static final String _FINDER_COLUMN_PRIORITYNAME_PRIORITYNAME_3 =
		"(priorityMaster.priorityName IS NULL OR priorityMaster.priorityName = '')";

	public PriorityMasterPersistenceImpl() {
		setModelClass(PriorityMaster.class);

		setModelImplClass(PriorityMasterImpl.class);
		setModelPKClass(long.class);

		setTable(PriorityMasterTable.INSTANCE);
	}

	/**
	 * Caches the priority master in the entity cache if it is enabled.
	 *
	 * @param priorityMaster the priority master
	 */
	@Override
	public void cacheResult(PriorityMaster priorityMaster) {
		entityCache.putResult(
			PriorityMasterImpl.class, priorityMaster.getPrimaryKey(),
			priorityMaster);

		finderCache.putResult(
			_finderPathFetchByPriorityName,
			new Object[] {priorityMaster.getPriorityName()}, priorityMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the priority masters in the entity cache if it is enabled.
	 *
	 * @param priorityMasters the priority masters
	 */
	@Override
	public void cacheResult(List<PriorityMaster> priorityMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (priorityMasters.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PriorityMaster priorityMaster : priorityMasters) {
			if (entityCache.getResult(
					PriorityMasterImpl.class, priorityMaster.getPrimaryKey()) ==
						null) {

				cacheResult(priorityMaster);
			}
		}
	}

	/**
	 * Clears the cache for all priority masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PriorityMasterImpl.class);

		finderCache.clearCache(PriorityMasterImpl.class);
	}

	/**
	 * Clears the cache for the priority master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PriorityMaster priorityMaster) {
		entityCache.removeResult(PriorityMasterImpl.class, priorityMaster);
	}

	@Override
	public void clearCache(List<PriorityMaster> priorityMasters) {
		for (PriorityMaster priorityMaster : priorityMasters) {
			entityCache.removeResult(PriorityMasterImpl.class, priorityMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PriorityMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PriorityMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PriorityMasterModelImpl priorityMasterModelImpl) {

		Object[] args = new Object[] {
			priorityMasterModelImpl.getPriorityName()
		};

		finderCache.putResult(
			_finderPathCountByPriorityName, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByPriorityName, args, priorityMasterModelImpl);
	}

	/**
	 * Creates a new priority master with the primary key. Does not add the priority master to the database.
	 *
	 * @param priorityMasterId the primary key for the new priority master
	 * @return the new priority master
	 */
	@Override
	public PriorityMaster create(long priorityMasterId) {
		PriorityMaster priorityMaster = new PriorityMasterImpl();

		priorityMaster.setNew(true);
		priorityMaster.setPrimaryKey(priorityMasterId);

		priorityMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return priorityMaster;
	}

	/**
	 * Removes the priority master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param priorityMasterId the primary key of the priority master
	 * @return the priority master that was removed
	 * @throws NoSuchPriorityMasterException if a priority master with the primary key could not be found
	 */
	@Override
	public PriorityMaster remove(long priorityMasterId)
		throws NoSuchPriorityMasterException {

		return remove((Serializable)priorityMasterId);
	}

	/**
	 * Removes the priority master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the priority master
	 * @return the priority master that was removed
	 * @throws NoSuchPriorityMasterException if a priority master with the primary key could not be found
	 */
	@Override
	public PriorityMaster remove(Serializable primaryKey)
		throws NoSuchPriorityMasterException {

		Session session = null;

		try {
			session = openSession();

			PriorityMaster priorityMaster = (PriorityMaster)session.get(
				PriorityMasterImpl.class, primaryKey);

			if (priorityMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPriorityMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(priorityMaster);
		}
		catch (NoSuchPriorityMasterException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PriorityMaster removeImpl(PriorityMaster priorityMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(priorityMaster)) {
				priorityMaster = (PriorityMaster)session.get(
					PriorityMasterImpl.class,
					priorityMaster.getPrimaryKeyObj());
			}

			if (priorityMaster != null) {
				session.delete(priorityMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (priorityMaster != null) {
			clearCache(priorityMaster);
		}

		return priorityMaster;
	}

	@Override
	public PriorityMaster updateImpl(PriorityMaster priorityMaster) {
		boolean isNew = priorityMaster.isNew();

		if (!(priorityMaster instanceof PriorityMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(priorityMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					priorityMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in priorityMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PriorityMaster implementation " +
					priorityMaster.getClass());
		}

		PriorityMasterModelImpl priorityMasterModelImpl =
			(PriorityMasterModelImpl)priorityMaster;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (priorityMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				priorityMaster.setCreateDate(date);
			}
			else {
				priorityMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!priorityMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				priorityMaster.setModifiedDate(date);
			}
			else {
				priorityMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(priorityMaster);
			}
			else {
				priorityMaster = (PriorityMaster)session.merge(priorityMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PriorityMasterImpl.class, priorityMasterModelImpl, false, true);

		cacheUniqueFindersCache(priorityMasterModelImpl);

		if (isNew) {
			priorityMaster.setNew(false);
		}

		priorityMaster.resetOriginalValues();

		return priorityMaster;
	}

	/**
	 * Returns the priority master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the priority master
	 * @return the priority master
	 * @throws NoSuchPriorityMasterException if a priority master with the primary key could not be found
	 */
	@Override
	public PriorityMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPriorityMasterException {

		PriorityMaster priorityMaster = fetchByPrimaryKey(primaryKey);

		if (priorityMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPriorityMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return priorityMaster;
	}

	/**
	 * Returns the priority master with the primary key or throws a <code>NoSuchPriorityMasterException</code> if it could not be found.
	 *
	 * @param priorityMasterId the primary key of the priority master
	 * @return the priority master
	 * @throws NoSuchPriorityMasterException if a priority master with the primary key could not be found
	 */
	@Override
	public PriorityMaster findByPrimaryKey(long priorityMasterId)
		throws NoSuchPriorityMasterException {

		return findByPrimaryKey((Serializable)priorityMasterId);
	}

	/**
	 * Returns the priority master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param priorityMasterId the primary key of the priority master
	 * @return the priority master, or <code>null</code> if a priority master with the primary key could not be found
	 */
	@Override
	public PriorityMaster fetchByPrimaryKey(long priorityMasterId) {
		return fetchByPrimaryKey((Serializable)priorityMasterId);
	}

	/**
	 * Returns all the priority masters.
	 *
	 * @return the priority masters
	 */
	@Override
	public List<PriorityMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the priority masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of priority masters
	 * @param end the upper bound of the range of priority masters (not inclusive)
	 * @return the range of priority masters
	 */
	@Override
	public List<PriorityMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the priority masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of priority masters
	 * @param end the upper bound of the range of priority masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of priority masters
	 */
	@Override
	public List<PriorityMaster> findAll(
		int start, int end,
		OrderByComparator<PriorityMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the priority masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of priority masters
	 * @param end the upper bound of the range of priority masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of priority masters
	 */
	@Override
	public List<PriorityMaster> findAll(
		int start, int end, OrderByComparator<PriorityMaster> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<PriorityMaster> list = null;

		if (useFinderCache) {
			list = (List<PriorityMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRIORITYMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRIORITYMASTER;

				sql = sql.concat(PriorityMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PriorityMaster>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the priority masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PriorityMaster priorityMaster : findAll()) {
			remove(priorityMaster);
		}
	}

	/**
	 * Returns the number of priority masters.
	 *
	 * @return the number of priority masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PRIORITYMASTER);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "priorityMasterId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PRIORITYMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PriorityMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the priority master persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByPriorityName = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByPriorityName",
			new String[] {String.class.getName()},
			new String[] {"priorityName"}, true);

		_finderPathCountByPriorityName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPriorityName",
			new String[] {String.class.getName()},
			new String[] {"priorityName"}, false);

		PriorityMasterUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		PriorityMasterUtil.setPersistence(null);

		entityCache.removeCache(PriorityMasterImpl.class.getName());
	}

	@Override
	@Reference(
		target = ax_masterPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = ax_masterPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ax_masterPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PRIORITYMASTER =
		"SELECT priorityMaster FROM PriorityMaster priorityMaster";

	private static final String _SQL_SELECT_PRIORITYMASTER_WHERE =
		"SELECT priorityMaster FROM PriorityMaster priorityMaster WHERE ";

	private static final String _SQL_COUNT_PRIORITYMASTER =
		"SELECT COUNT(priorityMaster) FROM PriorityMaster priorityMaster";

	private static final String _SQL_COUNT_PRIORITYMASTER_WHERE =
		"SELECT COUNT(priorityMaster) FROM PriorityMaster priorityMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "priorityMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PriorityMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PriorityMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PriorityMasterPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}