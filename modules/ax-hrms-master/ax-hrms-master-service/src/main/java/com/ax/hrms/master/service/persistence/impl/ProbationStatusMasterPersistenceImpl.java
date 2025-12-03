/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence.impl;

import com.ax.hrms.master.exception.NoSuchProbationStatusMasterException;
import com.ax.hrms.master.model.ProbationStatusMaster;
import com.ax.hrms.master.model.ProbationStatusMasterTable;
import com.ax.hrms.master.model.impl.ProbationStatusMasterImpl;
import com.ax.hrms.master.model.impl.ProbationStatusMasterModelImpl;
import com.ax.hrms.master.service.persistence.ProbationStatusMasterPersistence;
import com.ax.hrms.master.service.persistence.ProbationStatusMasterUtil;
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
 * The persistence implementation for the probation status master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProbationStatusMasterPersistence.class)
public class ProbationStatusMasterPersistenceImpl
	extends BasePersistenceImpl<ProbationStatusMaster>
	implements ProbationStatusMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProbationStatusMasterUtil</code> to access the probation status master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProbationStatusMasterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByStatusType;
	private FinderPath _finderPathCountByStatusType;

	/**
	 * Returns the probation status master where statusType = &#63; or throws a <code>NoSuchProbationStatusMasterException</code> if it could not be found.
	 *
	 * @param statusType the status type
	 * @return the matching probation status master
	 * @throws NoSuchProbationStatusMasterException if a matching probation status master could not be found
	 */
	@Override
	public ProbationStatusMaster findByStatusType(String statusType)
		throws NoSuchProbationStatusMasterException {

		ProbationStatusMaster probationStatusMaster = fetchByStatusType(
			statusType);

		if (probationStatusMaster == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("statusType=");
			sb.append(statusType);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProbationStatusMasterException(sb.toString());
		}

		return probationStatusMaster;
	}

	/**
	 * Returns the probation status master where statusType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param statusType the status type
	 * @return the matching probation status master, or <code>null</code> if a matching probation status master could not be found
	 */
	@Override
	public ProbationStatusMaster fetchByStatusType(String statusType) {
		return fetchByStatusType(statusType, true);
	}

	/**
	 * Returns the probation status master where statusType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param statusType the status type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching probation status master, or <code>null</code> if a matching probation status master could not be found
	 */
	@Override
	public ProbationStatusMaster fetchByStatusType(
		String statusType, boolean useFinderCache) {

		statusType = Objects.toString(statusType, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {statusType};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByStatusType, finderArgs, this);
		}

		if (result instanceof ProbationStatusMaster) {
			ProbationStatusMaster probationStatusMaster =
				(ProbationStatusMaster)result;

			if (!Objects.equals(
					statusType, probationStatusMaster.getStatusType())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PROBATIONSTATUSMASTER_WHERE);

			boolean bindStatusType = false;

			if (statusType.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUSTYPE_STATUSTYPE_3);
			}
			else {
				bindStatusType = true;

				sb.append(_FINDER_COLUMN_STATUSTYPE_STATUSTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatusType) {
					queryPos.add(StringUtil.toLowerCase(statusType));
				}

				List<ProbationStatusMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByStatusType, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {statusType};
							}

							_log.warn(
								"ProbationStatusMasterPersistenceImpl.fetchByStatusType(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProbationStatusMaster probationStatusMaster = list.get(0);

					result = probationStatusMaster;

					cacheResult(probationStatusMaster);
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
			return (ProbationStatusMaster)result;
		}
	}

	/**
	 * Removes the probation status master where statusType = &#63; from the database.
	 *
	 * @param statusType the status type
	 * @return the probation status master that was removed
	 */
	@Override
	public ProbationStatusMaster removeByStatusType(String statusType)
		throws NoSuchProbationStatusMasterException {

		ProbationStatusMaster probationStatusMaster = findByStatusType(
			statusType);

		return remove(probationStatusMaster);
	}

	/**
	 * Returns the number of probation status masters where statusType = &#63;.
	 *
	 * @param statusType the status type
	 * @return the number of matching probation status masters
	 */
	@Override
	public int countByStatusType(String statusType) {
		statusType = Objects.toString(statusType, "");

		FinderPath finderPath = _finderPathCountByStatusType;

		Object[] finderArgs = new Object[] {statusType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROBATIONSTATUSMASTER_WHERE);

			boolean bindStatusType = false;

			if (statusType.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUSTYPE_STATUSTYPE_3);
			}
			else {
				bindStatusType = true;

				sb.append(_FINDER_COLUMN_STATUSTYPE_STATUSTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatusType) {
					queryPos.add(StringUtil.toLowerCase(statusType));
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

	private static final String _FINDER_COLUMN_STATUSTYPE_STATUSTYPE_2 =
		"lower(probationStatusMaster.statusType) = ?";

	private static final String _FINDER_COLUMN_STATUSTYPE_STATUSTYPE_3 =
		"(probationStatusMaster.statusType IS NULL OR probationStatusMaster.statusType = '')";

	public ProbationStatusMasterPersistenceImpl() {
		setModelClass(ProbationStatusMaster.class);

		setModelImplClass(ProbationStatusMasterImpl.class);
		setModelPKClass(long.class);

		setTable(ProbationStatusMasterTable.INSTANCE);
	}

	/**
	 * Caches the probation status master in the entity cache if it is enabled.
	 *
	 * @param probationStatusMaster the probation status master
	 */
	@Override
	public void cacheResult(ProbationStatusMaster probationStatusMaster) {
		entityCache.putResult(
			ProbationStatusMasterImpl.class,
			probationStatusMaster.getPrimaryKey(), probationStatusMaster);

		finderCache.putResult(
			_finderPathFetchByStatusType,
			new Object[] {probationStatusMaster.getStatusType()},
			probationStatusMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the probation status masters in the entity cache if it is enabled.
	 *
	 * @param probationStatusMasters the probation status masters
	 */
	@Override
	public void cacheResult(
		List<ProbationStatusMaster> probationStatusMasters) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (probationStatusMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProbationStatusMaster probationStatusMaster :
				probationStatusMasters) {

			if (entityCache.getResult(
					ProbationStatusMasterImpl.class,
					probationStatusMaster.getPrimaryKey()) == null) {

				cacheResult(probationStatusMaster);
			}
		}
	}

	/**
	 * Clears the cache for all probation status masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProbationStatusMasterImpl.class);

		finderCache.clearCache(ProbationStatusMasterImpl.class);
	}

	/**
	 * Clears the cache for the probation status master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProbationStatusMaster probationStatusMaster) {
		entityCache.removeResult(
			ProbationStatusMasterImpl.class, probationStatusMaster);
	}

	@Override
	public void clearCache(List<ProbationStatusMaster> probationStatusMasters) {
		for (ProbationStatusMaster probationStatusMaster :
				probationStatusMasters) {

			entityCache.removeResult(
				ProbationStatusMasterImpl.class, probationStatusMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProbationStatusMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProbationStatusMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProbationStatusMasterModelImpl probationStatusMasterModelImpl) {

		Object[] args = new Object[] {
			probationStatusMasterModelImpl.getStatusType()
		};

		finderCache.putResult(
			_finderPathCountByStatusType, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByStatusType, args, probationStatusMasterModelImpl);
	}

	/**
	 * Creates a new probation status master with the primary key. Does not add the probation status master to the database.
	 *
	 * @param probationStatusMasterId the primary key for the new probation status master
	 * @return the new probation status master
	 */
	@Override
	public ProbationStatusMaster create(long probationStatusMasterId) {
		ProbationStatusMaster probationStatusMaster =
			new ProbationStatusMasterImpl();

		probationStatusMaster.setNew(true);
		probationStatusMaster.setPrimaryKey(probationStatusMasterId);

		probationStatusMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return probationStatusMaster;
	}

	/**
	 * Removes the probation status master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param probationStatusMasterId the primary key of the probation status master
	 * @return the probation status master that was removed
	 * @throws NoSuchProbationStatusMasterException if a probation status master with the primary key could not be found
	 */
	@Override
	public ProbationStatusMaster remove(long probationStatusMasterId)
		throws NoSuchProbationStatusMasterException {

		return remove((Serializable)probationStatusMasterId);
	}

	/**
	 * Removes the probation status master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the probation status master
	 * @return the probation status master that was removed
	 * @throws NoSuchProbationStatusMasterException if a probation status master with the primary key could not be found
	 */
	@Override
	public ProbationStatusMaster remove(Serializable primaryKey)
		throws NoSuchProbationStatusMasterException {

		Session session = null;

		try {
			session = openSession();

			ProbationStatusMaster probationStatusMaster =
				(ProbationStatusMaster)session.get(
					ProbationStatusMasterImpl.class, primaryKey);

			if (probationStatusMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProbationStatusMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(probationStatusMaster);
		}
		catch (NoSuchProbationStatusMasterException noSuchEntityException) {
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
	protected ProbationStatusMaster removeImpl(
		ProbationStatusMaster probationStatusMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(probationStatusMaster)) {
				probationStatusMaster = (ProbationStatusMaster)session.get(
					ProbationStatusMasterImpl.class,
					probationStatusMaster.getPrimaryKeyObj());
			}

			if (probationStatusMaster != null) {
				session.delete(probationStatusMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (probationStatusMaster != null) {
			clearCache(probationStatusMaster);
		}

		return probationStatusMaster;
	}

	@Override
	public ProbationStatusMaster updateImpl(
		ProbationStatusMaster probationStatusMaster) {

		boolean isNew = probationStatusMaster.isNew();

		if (!(probationStatusMaster instanceof
				ProbationStatusMasterModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(probationStatusMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					probationStatusMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in probationStatusMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProbationStatusMaster implementation " +
					probationStatusMaster.getClass());
		}

		ProbationStatusMasterModelImpl probationStatusMasterModelImpl =
			(ProbationStatusMasterModelImpl)probationStatusMaster;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (probationStatusMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				probationStatusMaster.setCreateDate(date);
			}
			else {
				probationStatusMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!probationStatusMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				probationStatusMaster.setModifiedDate(date);
			}
			else {
				probationStatusMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(probationStatusMaster);
			}
			else {
				probationStatusMaster = (ProbationStatusMaster)session.merge(
					probationStatusMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProbationStatusMasterImpl.class, probationStatusMasterModelImpl,
			false, true);

		cacheUniqueFindersCache(probationStatusMasterModelImpl);

		if (isNew) {
			probationStatusMaster.setNew(false);
		}

		probationStatusMaster.resetOriginalValues();

		return probationStatusMaster;
	}

	/**
	 * Returns the probation status master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the probation status master
	 * @return the probation status master
	 * @throws NoSuchProbationStatusMasterException if a probation status master with the primary key could not be found
	 */
	@Override
	public ProbationStatusMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProbationStatusMasterException {

		ProbationStatusMaster probationStatusMaster = fetchByPrimaryKey(
			primaryKey);

		if (probationStatusMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProbationStatusMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return probationStatusMaster;
	}

	/**
	 * Returns the probation status master with the primary key or throws a <code>NoSuchProbationStatusMasterException</code> if it could not be found.
	 *
	 * @param probationStatusMasterId the primary key of the probation status master
	 * @return the probation status master
	 * @throws NoSuchProbationStatusMasterException if a probation status master with the primary key could not be found
	 */
	@Override
	public ProbationStatusMaster findByPrimaryKey(long probationStatusMasterId)
		throws NoSuchProbationStatusMasterException {

		return findByPrimaryKey((Serializable)probationStatusMasterId);
	}

	/**
	 * Returns the probation status master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param probationStatusMasterId the primary key of the probation status master
	 * @return the probation status master, or <code>null</code> if a probation status master with the primary key could not be found
	 */
	@Override
	public ProbationStatusMaster fetchByPrimaryKey(
		long probationStatusMasterId) {

		return fetchByPrimaryKey((Serializable)probationStatusMasterId);
	}

	/**
	 * Returns all the probation status masters.
	 *
	 * @return the probation status masters
	 */
	@Override
	public List<ProbationStatusMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the probation status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProbationStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of probation status masters
	 * @param end the upper bound of the range of probation status masters (not inclusive)
	 * @return the range of probation status masters
	 */
	@Override
	public List<ProbationStatusMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the probation status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProbationStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of probation status masters
	 * @param end the upper bound of the range of probation status masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of probation status masters
	 */
	@Override
	public List<ProbationStatusMaster> findAll(
		int start, int end,
		OrderByComparator<ProbationStatusMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the probation status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProbationStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of probation status masters
	 * @param end the upper bound of the range of probation status masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of probation status masters
	 */
	@Override
	public List<ProbationStatusMaster> findAll(
		int start, int end,
		OrderByComparator<ProbationStatusMaster> orderByComparator,
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

		List<ProbationStatusMaster> list = null;

		if (useFinderCache) {
			list = (List<ProbationStatusMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROBATIONSTATUSMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROBATIONSTATUSMASTER;

				sql = sql.concat(ProbationStatusMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProbationStatusMaster>)QueryUtil.list(
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
	 * Removes all the probation status masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProbationStatusMaster probationStatusMaster : findAll()) {
			remove(probationStatusMaster);
		}
	}

	/**
	 * Returns the number of probation status masters.
	 *
	 * @return the number of probation status masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_PROBATIONSTATUSMASTER);

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
		return "probationStatusMasterId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROBATIONSTATUSMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProbationStatusMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the probation status master persistence.
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

		_finderPathFetchByStatusType = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByStatusType",
			new String[] {String.class.getName()}, new String[] {"statusType"},
			true);

		_finderPathCountByStatusType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatusType",
			new String[] {String.class.getName()}, new String[] {"statusType"},
			false);

		ProbationStatusMasterUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ProbationStatusMasterUtil.setPersistence(null);

		entityCache.removeCache(ProbationStatusMasterImpl.class.getName());
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

	private static final String _SQL_SELECT_PROBATIONSTATUSMASTER =
		"SELECT probationStatusMaster FROM ProbationStatusMaster probationStatusMaster";

	private static final String _SQL_SELECT_PROBATIONSTATUSMASTER_WHERE =
		"SELECT probationStatusMaster FROM ProbationStatusMaster probationStatusMaster WHERE ";

	private static final String _SQL_COUNT_PROBATIONSTATUSMASTER =
		"SELECT COUNT(probationStatusMaster) FROM ProbationStatusMaster probationStatusMaster";

	private static final String _SQL_COUNT_PROBATIONSTATUSMASTER_WHERE =
		"SELECT COUNT(probationStatusMaster) FROM ProbationStatusMaster probationStatusMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"probationStatusMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProbationStatusMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProbationStatusMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProbationStatusMasterPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}