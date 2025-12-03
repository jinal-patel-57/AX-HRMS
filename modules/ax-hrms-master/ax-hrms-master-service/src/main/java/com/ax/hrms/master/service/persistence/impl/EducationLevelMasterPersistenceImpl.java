/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence.impl;

import com.ax.hrms.master.exception.NoSuchEducationLevelMasterException;
import com.ax.hrms.master.model.EducationLevelMaster;
import com.ax.hrms.master.model.EducationLevelMasterTable;
import com.ax.hrms.master.model.impl.EducationLevelMasterImpl;
import com.ax.hrms.master.model.impl.EducationLevelMasterModelImpl;
import com.ax.hrms.master.service.persistence.EducationLevelMasterPersistence;
import com.ax.hrms.master.service.persistence.EducationLevelMasterUtil;
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
 * The persistence implementation for the education level master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EducationLevelMasterPersistence.class)
public class EducationLevelMasterPersistenceImpl
	extends BasePersistenceImpl<EducationLevelMaster>
	implements EducationLevelMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EducationLevelMasterUtil</code> to access the education level master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EducationLevelMasterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByLevelName;
	private FinderPath _finderPathCountByLevelName;

	/**
	 * Returns the education level master where levelName = &#63; or throws a <code>NoSuchEducationLevelMasterException</code> if it could not be found.
	 *
	 * @param levelName the level name
	 * @return the matching education level master
	 * @throws NoSuchEducationLevelMasterException if a matching education level master could not be found
	 */
	@Override
	public EducationLevelMaster findByLevelName(String levelName)
		throws NoSuchEducationLevelMasterException {

		EducationLevelMaster educationLevelMaster = fetchByLevelName(levelName);

		if (educationLevelMaster == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("levelName=");
			sb.append(levelName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEducationLevelMasterException(sb.toString());
		}

		return educationLevelMaster;
	}

	/**
	 * Returns the education level master where levelName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param levelName the level name
	 * @return the matching education level master, or <code>null</code> if a matching education level master could not be found
	 */
	@Override
	public EducationLevelMaster fetchByLevelName(String levelName) {
		return fetchByLevelName(levelName, true);
	}

	/**
	 * Returns the education level master where levelName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param levelName the level name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching education level master, or <code>null</code> if a matching education level master could not be found
	 */
	@Override
	public EducationLevelMaster fetchByLevelName(
		String levelName, boolean useFinderCache) {

		levelName = Objects.toString(levelName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {levelName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByLevelName, finderArgs, this);
		}

		if (result instanceof EducationLevelMaster) {
			EducationLevelMaster educationLevelMaster =
				(EducationLevelMaster)result;

			if (!Objects.equals(
					levelName, educationLevelMaster.getLevelName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_EDUCATIONLEVELMASTER_WHERE);

			boolean bindLevelName = false;

			if (levelName.isEmpty()) {
				sb.append(_FINDER_COLUMN_LEVELNAME_LEVELNAME_3);
			}
			else {
				bindLevelName = true;

				sb.append(_FINDER_COLUMN_LEVELNAME_LEVELNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLevelName) {
					queryPos.add(StringUtil.toLowerCase(levelName));
				}

				List<EducationLevelMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByLevelName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {levelName};
							}

							_log.warn(
								"EducationLevelMasterPersistenceImpl.fetchByLevelName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EducationLevelMaster educationLevelMaster = list.get(0);

					result = educationLevelMaster;

					cacheResult(educationLevelMaster);
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
			return (EducationLevelMaster)result;
		}
	}

	/**
	 * Removes the education level master where levelName = &#63; from the database.
	 *
	 * @param levelName the level name
	 * @return the education level master that was removed
	 */
	@Override
	public EducationLevelMaster removeByLevelName(String levelName)
		throws NoSuchEducationLevelMasterException {

		EducationLevelMaster educationLevelMaster = findByLevelName(levelName);

		return remove(educationLevelMaster);
	}

	/**
	 * Returns the number of education level masters where levelName = &#63;.
	 *
	 * @param levelName the level name
	 * @return the number of matching education level masters
	 */
	@Override
	public int countByLevelName(String levelName) {
		levelName = Objects.toString(levelName, "");

		FinderPath finderPath = _finderPathCountByLevelName;

		Object[] finderArgs = new Object[] {levelName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EDUCATIONLEVELMASTER_WHERE);

			boolean bindLevelName = false;

			if (levelName.isEmpty()) {
				sb.append(_FINDER_COLUMN_LEVELNAME_LEVELNAME_3);
			}
			else {
				bindLevelName = true;

				sb.append(_FINDER_COLUMN_LEVELNAME_LEVELNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLevelName) {
					queryPos.add(StringUtil.toLowerCase(levelName));
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

	private static final String _FINDER_COLUMN_LEVELNAME_LEVELNAME_2 =
		"lower(educationLevelMaster.levelName) = ?";

	private static final String _FINDER_COLUMN_LEVELNAME_LEVELNAME_3 =
		"(educationLevelMaster.levelName IS NULL OR educationLevelMaster.levelName = '')";

	public EducationLevelMasterPersistenceImpl() {
		setModelClass(EducationLevelMaster.class);

		setModelImplClass(EducationLevelMasterImpl.class);
		setModelPKClass(long.class);

		setTable(EducationLevelMasterTable.INSTANCE);
	}

	/**
	 * Caches the education level master in the entity cache if it is enabled.
	 *
	 * @param educationLevelMaster the education level master
	 */
	@Override
	public void cacheResult(EducationLevelMaster educationLevelMaster) {
		entityCache.putResult(
			EducationLevelMasterImpl.class,
			educationLevelMaster.getPrimaryKey(), educationLevelMaster);

		finderCache.putResult(
			_finderPathFetchByLevelName,
			new Object[] {educationLevelMaster.getLevelName()},
			educationLevelMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the education level masters in the entity cache if it is enabled.
	 *
	 * @param educationLevelMasters the education level masters
	 */
	@Override
	public void cacheResult(List<EducationLevelMaster> educationLevelMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (educationLevelMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EducationLevelMaster educationLevelMaster :
				educationLevelMasters) {

			if (entityCache.getResult(
					EducationLevelMasterImpl.class,
					educationLevelMaster.getPrimaryKey()) == null) {

				cacheResult(educationLevelMaster);
			}
		}
	}

	/**
	 * Clears the cache for all education level masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EducationLevelMasterImpl.class);

		finderCache.clearCache(EducationLevelMasterImpl.class);
	}

	/**
	 * Clears the cache for the education level master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EducationLevelMaster educationLevelMaster) {
		entityCache.removeResult(
			EducationLevelMasterImpl.class, educationLevelMaster);
	}

	@Override
	public void clearCache(List<EducationLevelMaster> educationLevelMasters) {
		for (EducationLevelMaster educationLevelMaster :
				educationLevelMasters) {

			entityCache.removeResult(
				EducationLevelMasterImpl.class, educationLevelMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EducationLevelMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				EducationLevelMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EducationLevelMasterModelImpl educationLevelMasterModelImpl) {

		Object[] args = new Object[] {
			educationLevelMasterModelImpl.getLevelName()
		};

		finderCache.putResult(
			_finderPathCountByLevelName, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByLevelName, args, educationLevelMasterModelImpl);
	}

	/**
	 * Creates a new education level master with the primary key. Does not add the education level master to the database.
	 *
	 * @param educationLevelMasterId the primary key for the new education level master
	 * @return the new education level master
	 */
	@Override
	public EducationLevelMaster create(long educationLevelMasterId) {
		EducationLevelMaster educationLevelMaster =
			new EducationLevelMasterImpl();

		educationLevelMaster.setNew(true);
		educationLevelMaster.setPrimaryKey(educationLevelMasterId);

		educationLevelMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return educationLevelMaster;
	}

	/**
	 * Removes the education level master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param educationLevelMasterId the primary key of the education level master
	 * @return the education level master that was removed
	 * @throws NoSuchEducationLevelMasterException if a education level master with the primary key could not be found
	 */
	@Override
	public EducationLevelMaster remove(long educationLevelMasterId)
		throws NoSuchEducationLevelMasterException {

		return remove((Serializable)educationLevelMasterId);
	}

	/**
	 * Removes the education level master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the education level master
	 * @return the education level master that was removed
	 * @throws NoSuchEducationLevelMasterException if a education level master with the primary key could not be found
	 */
	@Override
	public EducationLevelMaster remove(Serializable primaryKey)
		throws NoSuchEducationLevelMasterException {

		Session session = null;

		try {
			session = openSession();

			EducationLevelMaster educationLevelMaster =
				(EducationLevelMaster)session.get(
					EducationLevelMasterImpl.class, primaryKey);

			if (educationLevelMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEducationLevelMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(educationLevelMaster);
		}
		catch (NoSuchEducationLevelMasterException noSuchEntityException) {
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
	protected EducationLevelMaster removeImpl(
		EducationLevelMaster educationLevelMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(educationLevelMaster)) {
				educationLevelMaster = (EducationLevelMaster)session.get(
					EducationLevelMasterImpl.class,
					educationLevelMaster.getPrimaryKeyObj());
			}

			if (educationLevelMaster != null) {
				session.delete(educationLevelMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (educationLevelMaster != null) {
			clearCache(educationLevelMaster);
		}

		return educationLevelMaster;
	}

	@Override
	public EducationLevelMaster updateImpl(
		EducationLevelMaster educationLevelMaster) {

		boolean isNew = educationLevelMaster.isNew();

		if (!(educationLevelMaster instanceof EducationLevelMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(educationLevelMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					educationLevelMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in educationLevelMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EducationLevelMaster implementation " +
					educationLevelMaster.getClass());
		}

		EducationLevelMasterModelImpl educationLevelMasterModelImpl =
			(EducationLevelMasterModelImpl)educationLevelMaster;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (educationLevelMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				educationLevelMaster.setCreateDate(date);
			}
			else {
				educationLevelMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!educationLevelMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				educationLevelMaster.setModifiedDate(date);
			}
			else {
				educationLevelMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(educationLevelMaster);
			}
			else {
				educationLevelMaster = (EducationLevelMaster)session.merge(
					educationLevelMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EducationLevelMasterImpl.class, educationLevelMasterModelImpl,
			false, true);

		cacheUniqueFindersCache(educationLevelMasterModelImpl);

		if (isNew) {
			educationLevelMaster.setNew(false);
		}

		educationLevelMaster.resetOriginalValues();

		return educationLevelMaster;
	}

	/**
	 * Returns the education level master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the education level master
	 * @return the education level master
	 * @throws NoSuchEducationLevelMasterException if a education level master with the primary key could not be found
	 */
	@Override
	public EducationLevelMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEducationLevelMasterException {

		EducationLevelMaster educationLevelMaster = fetchByPrimaryKey(
			primaryKey);

		if (educationLevelMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEducationLevelMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return educationLevelMaster;
	}

	/**
	 * Returns the education level master with the primary key or throws a <code>NoSuchEducationLevelMasterException</code> if it could not be found.
	 *
	 * @param educationLevelMasterId the primary key of the education level master
	 * @return the education level master
	 * @throws NoSuchEducationLevelMasterException if a education level master with the primary key could not be found
	 */
	@Override
	public EducationLevelMaster findByPrimaryKey(long educationLevelMasterId)
		throws NoSuchEducationLevelMasterException {

		return findByPrimaryKey((Serializable)educationLevelMasterId);
	}

	/**
	 * Returns the education level master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param educationLevelMasterId the primary key of the education level master
	 * @return the education level master, or <code>null</code> if a education level master with the primary key could not be found
	 */
	@Override
	public EducationLevelMaster fetchByPrimaryKey(long educationLevelMasterId) {
		return fetchByPrimaryKey((Serializable)educationLevelMasterId);
	}

	/**
	 * Returns all the education level masters.
	 *
	 * @return the education level masters
	 */
	@Override
	public List<EducationLevelMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the education level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EducationLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of education level masters
	 * @param end the upper bound of the range of education level masters (not inclusive)
	 * @return the range of education level masters
	 */
	@Override
	public List<EducationLevelMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the education level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EducationLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of education level masters
	 * @param end the upper bound of the range of education level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of education level masters
	 */
	@Override
	public List<EducationLevelMaster> findAll(
		int start, int end,
		OrderByComparator<EducationLevelMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the education level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EducationLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of education level masters
	 * @param end the upper bound of the range of education level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of education level masters
	 */
	@Override
	public List<EducationLevelMaster> findAll(
		int start, int end,
		OrderByComparator<EducationLevelMaster> orderByComparator,
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

		List<EducationLevelMaster> list = null;

		if (useFinderCache) {
			list = (List<EducationLevelMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EDUCATIONLEVELMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EDUCATIONLEVELMASTER;

				sql = sql.concat(EducationLevelMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EducationLevelMaster>)QueryUtil.list(
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
	 * Removes all the education level masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EducationLevelMaster educationLevelMaster : findAll()) {
			remove(educationLevelMaster);
		}
	}

	/**
	 * Returns the number of education level masters.
	 *
	 * @return the number of education level masters
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
					_SQL_COUNT_EDUCATIONLEVELMASTER);

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
		return "educationLevelMasterId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EDUCATIONLEVELMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EducationLevelMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the education level master persistence.
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

		_finderPathFetchByLevelName = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByLevelName",
			new String[] {String.class.getName()}, new String[] {"levelName"},
			true);

		_finderPathCountByLevelName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLevelName",
			new String[] {String.class.getName()}, new String[] {"levelName"},
			false);

		EducationLevelMasterUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		EducationLevelMasterUtil.setPersistence(null);

		entityCache.removeCache(EducationLevelMasterImpl.class.getName());
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

	private static final String _SQL_SELECT_EDUCATIONLEVELMASTER =
		"SELECT educationLevelMaster FROM EducationLevelMaster educationLevelMaster";

	private static final String _SQL_SELECT_EDUCATIONLEVELMASTER_WHERE =
		"SELECT educationLevelMaster FROM EducationLevelMaster educationLevelMaster WHERE ";

	private static final String _SQL_COUNT_EDUCATIONLEVELMASTER =
		"SELECT COUNT(educationLevelMaster) FROM EducationLevelMaster educationLevelMaster";

	private static final String _SQL_COUNT_EDUCATIONLEVELMASTER_WHERE =
		"SELECT COUNT(educationLevelMaster) FROM EducationLevelMaster educationLevelMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"educationLevelMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EducationLevelMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EducationLevelMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EducationLevelMasterPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}