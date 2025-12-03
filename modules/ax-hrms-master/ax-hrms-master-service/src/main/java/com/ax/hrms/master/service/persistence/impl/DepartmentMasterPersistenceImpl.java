/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence.impl;

import com.ax.hrms.master.exception.NoSuchDepartmentMasterException;
import com.ax.hrms.master.model.DepartmentMaster;
import com.ax.hrms.master.model.DepartmentMasterTable;
import com.ax.hrms.master.model.impl.DepartmentMasterImpl;
import com.ax.hrms.master.model.impl.DepartmentMasterModelImpl;
import com.ax.hrms.master.service.persistence.DepartmentMasterPersistence;
import com.ax.hrms.master.service.persistence.DepartmentMasterUtil;
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
 * The persistence implementation for the department master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DepartmentMasterPersistence.class)
public class DepartmentMasterPersistenceImpl
	extends BasePersistenceImpl<DepartmentMaster>
	implements DepartmentMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DepartmentMasterUtil</code> to access the department master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DepartmentMasterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByDepartmentName;
	private FinderPath _finderPathCountByDepartmentName;

	/**
	 * Returns the department master where departmentName = &#63; or throws a <code>NoSuchDepartmentMasterException</code> if it could not be found.
	 *
	 * @param departmentName the department name
	 * @return the matching department master
	 * @throws NoSuchDepartmentMasterException if a matching department master could not be found
	 */
	@Override
	public DepartmentMaster findByDepartmentName(String departmentName)
		throws NoSuchDepartmentMasterException {

		DepartmentMaster departmentMaster = fetchByDepartmentName(
			departmentName);

		if (departmentMaster == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("departmentName=");
			sb.append(departmentName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDepartmentMasterException(sb.toString());
		}

		return departmentMaster;
	}

	/**
	 * Returns the department master where departmentName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param departmentName the department name
	 * @return the matching department master, or <code>null</code> if a matching department master could not be found
	 */
	@Override
	public DepartmentMaster fetchByDepartmentName(String departmentName) {
		return fetchByDepartmentName(departmentName, true);
	}

	/**
	 * Returns the department master where departmentName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param departmentName the department name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department master, or <code>null</code> if a matching department master could not be found
	 */
	@Override
	public DepartmentMaster fetchByDepartmentName(
		String departmentName, boolean useFinderCache) {

		departmentName = Objects.toString(departmentName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {departmentName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDepartmentName, finderArgs, this);
		}

		if (result instanceof DepartmentMaster) {
			DepartmentMaster departmentMaster = (DepartmentMaster)result;

			if (!Objects.equals(
					departmentName, departmentMaster.getDepartmentName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DEPARTMENTMASTER_WHERE);

			boolean bindDepartmentName = false;

			if (departmentName.isEmpty()) {
				sb.append(_FINDER_COLUMN_DEPARTMENTNAME_DEPARTMENTNAME_3);
			}
			else {
				bindDepartmentName = true;

				sb.append(_FINDER_COLUMN_DEPARTMENTNAME_DEPARTMENTNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDepartmentName) {
					queryPos.add(StringUtil.toLowerCase(departmentName));
				}

				List<DepartmentMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDepartmentName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {departmentName};
							}

							_log.warn(
								"DepartmentMasterPersistenceImpl.fetchByDepartmentName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DepartmentMaster departmentMaster = list.get(0);

					result = departmentMaster;

					cacheResult(departmentMaster);
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
			return (DepartmentMaster)result;
		}
	}

	/**
	 * Removes the department master where departmentName = &#63; from the database.
	 *
	 * @param departmentName the department name
	 * @return the department master that was removed
	 */
	@Override
	public DepartmentMaster removeByDepartmentName(String departmentName)
		throws NoSuchDepartmentMasterException {

		DepartmentMaster departmentMaster = findByDepartmentName(
			departmentName);

		return remove(departmentMaster);
	}

	/**
	 * Returns the number of department masters where departmentName = &#63;.
	 *
	 * @param departmentName the department name
	 * @return the number of matching department masters
	 */
	@Override
	public int countByDepartmentName(String departmentName) {
		departmentName = Objects.toString(departmentName, "");

		FinderPath finderPath = _finderPathCountByDepartmentName;

		Object[] finderArgs = new Object[] {departmentName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DEPARTMENTMASTER_WHERE);

			boolean bindDepartmentName = false;

			if (departmentName.isEmpty()) {
				sb.append(_FINDER_COLUMN_DEPARTMENTNAME_DEPARTMENTNAME_3);
			}
			else {
				bindDepartmentName = true;

				sb.append(_FINDER_COLUMN_DEPARTMENTNAME_DEPARTMENTNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDepartmentName) {
					queryPos.add(StringUtil.toLowerCase(departmentName));
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

	private static final String _FINDER_COLUMN_DEPARTMENTNAME_DEPARTMENTNAME_2 =
		"lower(departmentMaster.departmentName) = ?";

	private static final String _FINDER_COLUMN_DEPARTMENTNAME_DEPARTMENTNAME_3 =
		"(departmentMaster.departmentName IS NULL OR departmentMaster.departmentName = '')";

	private FinderPath _finderPathFetchByDepartmentNameById;
	private FinderPath _finderPathCountByDepartmentNameById;

	/**
	 * Returns the department master where departmentMasterId = &#63; or throws a <code>NoSuchDepartmentMasterException</code> if it could not be found.
	 *
	 * @param departmentMasterId the department master ID
	 * @return the matching department master
	 * @throws NoSuchDepartmentMasterException if a matching department master could not be found
	 */
	@Override
	public DepartmentMaster findByDepartmentNameById(long departmentMasterId)
		throws NoSuchDepartmentMasterException {

		DepartmentMaster departmentMaster = fetchByDepartmentNameById(
			departmentMasterId);

		if (departmentMaster == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("departmentMasterId=");
			sb.append(departmentMasterId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDepartmentMasterException(sb.toString());
		}

		return departmentMaster;
	}

	/**
	 * Returns the department master where departmentMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param departmentMasterId the department master ID
	 * @return the matching department master, or <code>null</code> if a matching department master could not be found
	 */
	@Override
	public DepartmentMaster fetchByDepartmentNameById(long departmentMasterId) {
		return fetchByDepartmentNameById(departmentMasterId, true);
	}

	/**
	 * Returns the department master where departmentMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param departmentMasterId the department master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department master, or <code>null</code> if a matching department master could not be found
	 */
	@Override
	public DepartmentMaster fetchByDepartmentNameById(
		long departmentMasterId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {departmentMasterId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDepartmentNameById, finderArgs, this);
		}

		if (result instanceof DepartmentMaster) {
			DepartmentMaster departmentMaster = (DepartmentMaster)result;

			if (departmentMasterId !=
					departmentMaster.getDepartmentMasterId()) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DEPARTMENTMASTER_WHERE);

			sb.append(_FINDER_COLUMN_DEPARTMENTNAMEBYID_DEPARTMENTMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(departmentMasterId);

				List<DepartmentMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDepartmentNameById, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {departmentMasterId};
							}

							_log.warn(
								"DepartmentMasterPersistenceImpl.fetchByDepartmentNameById(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DepartmentMaster departmentMaster = list.get(0);

					result = departmentMaster;

					cacheResult(departmentMaster);
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
			return (DepartmentMaster)result;
		}
	}

	/**
	 * Removes the department master where departmentMasterId = &#63; from the database.
	 *
	 * @param departmentMasterId the department master ID
	 * @return the department master that was removed
	 */
	@Override
	public DepartmentMaster removeByDepartmentNameById(long departmentMasterId)
		throws NoSuchDepartmentMasterException {

		DepartmentMaster departmentMaster = findByDepartmentNameById(
			departmentMasterId);

		return remove(departmentMaster);
	}

	/**
	 * Returns the number of department masters where departmentMasterId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @return the number of matching department masters
	 */
	@Override
	public int countByDepartmentNameById(long departmentMasterId) {
		FinderPath finderPath = _finderPathCountByDepartmentNameById;

		Object[] finderArgs = new Object[] {departmentMasterId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DEPARTMENTMASTER_WHERE);

			sb.append(_FINDER_COLUMN_DEPARTMENTNAMEBYID_DEPARTMENTMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(departmentMasterId);

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

	private static final String
		_FINDER_COLUMN_DEPARTMENTNAMEBYID_DEPARTMENTMASTERID_2 =
			"departmentMaster.departmentMasterId = ?";

	public DepartmentMasterPersistenceImpl() {
		setModelClass(DepartmentMaster.class);

		setModelImplClass(DepartmentMasterImpl.class);
		setModelPKClass(long.class);

		setTable(DepartmentMasterTable.INSTANCE);
	}

	/**
	 * Caches the department master in the entity cache if it is enabled.
	 *
	 * @param departmentMaster the department master
	 */
	@Override
	public void cacheResult(DepartmentMaster departmentMaster) {
		entityCache.putResult(
			DepartmentMasterImpl.class, departmentMaster.getPrimaryKey(),
			departmentMaster);

		finderCache.putResult(
			_finderPathFetchByDepartmentName,
			new Object[] {departmentMaster.getDepartmentName()},
			departmentMaster);

		finderCache.putResult(
			_finderPathFetchByDepartmentNameById,
			new Object[] {departmentMaster.getDepartmentMasterId()},
			departmentMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the department masters in the entity cache if it is enabled.
	 *
	 * @param departmentMasters the department masters
	 */
	@Override
	public void cacheResult(List<DepartmentMaster> departmentMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (departmentMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DepartmentMaster departmentMaster : departmentMasters) {
			if (entityCache.getResult(
					DepartmentMasterImpl.class,
					departmentMaster.getPrimaryKey()) == null) {

				cacheResult(departmentMaster);
			}
		}
	}

	/**
	 * Clears the cache for all department masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DepartmentMasterImpl.class);

		finderCache.clearCache(DepartmentMasterImpl.class);
	}

	/**
	 * Clears the cache for the department master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DepartmentMaster departmentMaster) {
		entityCache.removeResult(DepartmentMasterImpl.class, departmentMaster);
	}

	@Override
	public void clearCache(List<DepartmentMaster> departmentMasters) {
		for (DepartmentMaster departmentMaster : departmentMasters) {
			entityCache.removeResult(
				DepartmentMasterImpl.class, departmentMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DepartmentMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DepartmentMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DepartmentMasterModelImpl departmentMasterModelImpl) {

		Object[] args = new Object[] {
			departmentMasterModelImpl.getDepartmentName()
		};

		finderCache.putResult(
			_finderPathCountByDepartmentName, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDepartmentName, args, departmentMasterModelImpl);

		args = new Object[] {departmentMasterModelImpl.getDepartmentMasterId()};

		finderCache.putResult(
			_finderPathCountByDepartmentNameById, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDepartmentNameById, args,
			departmentMasterModelImpl);
	}

	/**
	 * Creates a new department master with the primary key. Does not add the department master to the database.
	 *
	 * @param departmentMasterId the primary key for the new department master
	 * @return the new department master
	 */
	@Override
	public DepartmentMaster create(long departmentMasterId) {
		DepartmentMaster departmentMaster = new DepartmentMasterImpl();

		departmentMaster.setNew(true);
		departmentMaster.setPrimaryKey(departmentMasterId);

		departmentMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return departmentMaster;
	}

	/**
	 * Removes the department master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param departmentMasterId the primary key of the department master
	 * @return the department master that was removed
	 * @throws NoSuchDepartmentMasterException if a department master with the primary key could not be found
	 */
	@Override
	public DepartmentMaster remove(long departmentMasterId)
		throws NoSuchDepartmentMasterException {

		return remove((Serializable)departmentMasterId);
	}

	/**
	 * Removes the department master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the department master
	 * @return the department master that was removed
	 * @throws NoSuchDepartmentMasterException if a department master with the primary key could not be found
	 */
	@Override
	public DepartmentMaster remove(Serializable primaryKey)
		throws NoSuchDepartmentMasterException {

		Session session = null;

		try {
			session = openSession();

			DepartmentMaster departmentMaster = (DepartmentMaster)session.get(
				DepartmentMasterImpl.class, primaryKey);

			if (departmentMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDepartmentMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(departmentMaster);
		}
		catch (NoSuchDepartmentMasterException noSuchEntityException) {
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
	protected DepartmentMaster removeImpl(DepartmentMaster departmentMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(departmentMaster)) {
				departmentMaster = (DepartmentMaster)session.get(
					DepartmentMasterImpl.class,
					departmentMaster.getPrimaryKeyObj());
			}

			if (departmentMaster != null) {
				session.delete(departmentMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (departmentMaster != null) {
			clearCache(departmentMaster);
		}

		return departmentMaster;
	}

	@Override
	public DepartmentMaster updateImpl(DepartmentMaster departmentMaster) {
		boolean isNew = departmentMaster.isNew();

		if (!(departmentMaster instanceof DepartmentMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(departmentMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					departmentMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in departmentMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DepartmentMaster implementation " +
					departmentMaster.getClass());
		}

		DepartmentMasterModelImpl departmentMasterModelImpl =
			(DepartmentMasterModelImpl)departmentMaster;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (departmentMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				departmentMaster.setCreateDate(date);
			}
			else {
				departmentMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!departmentMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				departmentMaster.setModifiedDate(date);
			}
			else {
				departmentMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(departmentMaster);
			}
			else {
				departmentMaster = (DepartmentMaster)session.merge(
					departmentMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DepartmentMasterImpl.class, departmentMasterModelImpl, false, true);

		cacheUniqueFindersCache(departmentMasterModelImpl);

		if (isNew) {
			departmentMaster.setNew(false);
		}

		departmentMaster.resetOriginalValues();

		return departmentMaster;
	}

	/**
	 * Returns the department master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the department master
	 * @return the department master
	 * @throws NoSuchDepartmentMasterException if a department master with the primary key could not be found
	 */
	@Override
	public DepartmentMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDepartmentMasterException {

		DepartmentMaster departmentMaster = fetchByPrimaryKey(primaryKey);

		if (departmentMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDepartmentMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return departmentMaster;
	}

	/**
	 * Returns the department master with the primary key or throws a <code>NoSuchDepartmentMasterException</code> if it could not be found.
	 *
	 * @param departmentMasterId the primary key of the department master
	 * @return the department master
	 * @throws NoSuchDepartmentMasterException if a department master with the primary key could not be found
	 */
	@Override
	public DepartmentMaster findByPrimaryKey(long departmentMasterId)
		throws NoSuchDepartmentMasterException {

		return findByPrimaryKey((Serializable)departmentMasterId);
	}

	/**
	 * Returns the department master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param departmentMasterId the primary key of the department master
	 * @return the department master, or <code>null</code> if a department master with the primary key could not be found
	 */
	@Override
	public DepartmentMaster fetchByPrimaryKey(long departmentMasterId) {
		return fetchByPrimaryKey((Serializable)departmentMasterId);
	}

	/**
	 * Returns all the department masters.
	 *
	 * @return the department masters
	 */
	@Override
	public List<DepartmentMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the department masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department masters
	 * @param end the upper bound of the range of department masters (not inclusive)
	 * @return the range of department masters
	 */
	@Override
	public List<DepartmentMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the department masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department masters
	 * @param end the upper bound of the range of department masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of department masters
	 */
	@Override
	public List<DepartmentMaster> findAll(
		int start, int end,
		OrderByComparator<DepartmentMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the department masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department masters
	 * @param end the upper bound of the range of department masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of department masters
	 */
	@Override
	public List<DepartmentMaster> findAll(
		int start, int end,
		OrderByComparator<DepartmentMaster> orderByComparator,
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

		List<DepartmentMaster> list = null;

		if (useFinderCache) {
			list = (List<DepartmentMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DEPARTMENTMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DEPARTMENTMASTER;

				sql = sql.concat(DepartmentMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DepartmentMaster>)QueryUtil.list(
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
	 * Removes all the department masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DepartmentMaster departmentMaster : findAll()) {
			remove(departmentMaster);
		}
	}

	/**
	 * Returns the number of department masters.
	 *
	 * @return the number of department masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DEPARTMENTMASTER);

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
		return "departmentMasterId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DEPARTMENTMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DepartmentMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the department master persistence.
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

		_finderPathFetchByDepartmentName = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDepartmentName",
			new String[] {String.class.getName()},
			new String[] {"departmentName"}, true);

		_finderPathCountByDepartmentName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDepartmentName",
			new String[] {String.class.getName()},
			new String[] {"departmentName"}, false);

		_finderPathFetchByDepartmentNameById = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDepartmentNameById",
			new String[] {Long.class.getName()},
			new String[] {"departmentMasterId"}, true);

		_finderPathCountByDepartmentNameById = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDepartmentNameById", new String[] {Long.class.getName()},
			new String[] {"departmentMasterId"}, false);

		DepartmentMasterUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		DepartmentMasterUtil.setPersistence(null);

		entityCache.removeCache(DepartmentMasterImpl.class.getName());
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

	private static final String _SQL_SELECT_DEPARTMENTMASTER =
		"SELECT departmentMaster FROM DepartmentMaster departmentMaster";

	private static final String _SQL_SELECT_DEPARTMENTMASTER_WHERE =
		"SELECT departmentMaster FROM DepartmentMaster departmentMaster WHERE ";

	private static final String _SQL_COUNT_DEPARTMENTMASTER =
		"SELECT COUNT(departmentMaster) FROM DepartmentMaster departmentMaster";

	private static final String _SQL_COUNT_DEPARTMENTMASTER_WHERE =
		"SELECT COUNT(departmentMaster) FROM DepartmentMaster departmentMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "departmentMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DepartmentMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DepartmentMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DepartmentMasterPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}