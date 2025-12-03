/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence.impl;

import com.ax.hrms.master.exception.NoSuchAppraisalStatusMasterException;
import com.ax.hrms.master.model.AppraisalStatusMaster;
import com.ax.hrms.master.model.AppraisalStatusMasterTable;
import com.ax.hrms.master.model.impl.AppraisalStatusMasterImpl;
import com.ax.hrms.master.model.impl.AppraisalStatusMasterModelImpl;
import com.ax.hrms.master.service.persistence.AppraisalStatusMasterPersistence;
import com.ax.hrms.master.service.persistence.AppraisalStatusMasterUtil;
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
 * The persistence implementation for the appraisal status master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AppraisalStatusMasterPersistence.class)
public class AppraisalStatusMasterPersistenceImpl
	extends BasePersistenceImpl<AppraisalStatusMaster>
	implements AppraisalStatusMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AppraisalStatusMasterUtil</code> to access the appraisal status master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AppraisalStatusMasterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBystatus;
	private FinderPath _finderPathCountBystatus;

	/**
	 * Returns the appraisal status master where status = &#63; or throws a <code>NoSuchAppraisalStatusMasterException</code> if it could not be found.
	 *
	 * @param status the status
	 * @return the matching appraisal status master
	 * @throws NoSuchAppraisalStatusMasterException if a matching appraisal status master could not be found
	 */
	@Override
	public AppraisalStatusMaster findBystatus(String status)
		throws NoSuchAppraisalStatusMasterException {

		AppraisalStatusMaster appraisalStatusMaster = fetchBystatus(status);

		if (appraisalStatusMaster == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("status=");
			sb.append(status);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAppraisalStatusMasterException(sb.toString());
		}

		return appraisalStatusMaster;
	}

	/**
	 * Returns the appraisal status master where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param status the status
	 * @return the matching appraisal status master, or <code>null</code> if a matching appraisal status master could not be found
	 */
	@Override
	public AppraisalStatusMaster fetchBystatus(String status) {
		return fetchBystatus(status, true);
	}

	/**
	 * Returns the appraisal status master where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal status master, or <code>null</code> if a matching appraisal status master could not be found
	 */
	@Override
	public AppraisalStatusMaster fetchBystatus(
		String status, boolean useFinderCache) {

		status = Objects.toString(status, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {status};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBystatus, finderArgs, this);
		}

		if (result instanceof AppraisalStatusMaster) {
			AppraisalStatusMaster appraisalStatusMaster =
				(AppraisalStatusMaster)result;

			if (!Objects.equals(status, appraisalStatusMaster.getStatus())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_APPRAISALSTATUSMASTER_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatus) {
					queryPos.add(StringUtil.toLowerCase(status));
				}

				List<AppraisalStatusMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBystatus, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {status};
							}

							_log.warn(
								"AppraisalStatusMasterPersistenceImpl.fetchBystatus(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AppraisalStatusMaster appraisalStatusMaster = list.get(0);

					result = appraisalStatusMaster;

					cacheResult(appraisalStatusMaster);
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
			return (AppraisalStatusMaster)result;
		}
	}

	/**
	 * Removes the appraisal status master where status = &#63; from the database.
	 *
	 * @param status the status
	 * @return the appraisal status master that was removed
	 */
	@Override
	public AppraisalStatusMaster removeBystatus(String status)
		throws NoSuchAppraisalStatusMasterException {

		AppraisalStatusMaster appraisalStatusMaster = findBystatus(status);

		return remove(appraisalStatusMaster);
	}

	/**
	 * Returns the number of appraisal status masters where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching appraisal status masters
	 */
	@Override
	public int countBystatus(String status) {
		status = Objects.toString(status, "");

		FinderPath finderPath = _finderPathCountBystatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPRAISALSTATUSMASTER_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatus) {
					queryPos.add(StringUtil.toLowerCase(status));
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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"lower(appraisalStatusMaster.status) = ?";

	private static final String _FINDER_COLUMN_STATUS_STATUS_3 =
		"(appraisalStatusMaster.status IS NULL OR appraisalStatusMaster.status = '')";

	public AppraisalStatusMasterPersistenceImpl() {
		setModelClass(AppraisalStatusMaster.class);

		setModelImplClass(AppraisalStatusMasterImpl.class);
		setModelPKClass(long.class);

		setTable(AppraisalStatusMasterTable.INSTANCE);
	}

	/**
	 * Caches the appraisal status master in the entity cache if it is enabled.
	 *
	 * @param appraisalStatusMaster the appraisal status master
	 */
	@Override
	public void cacheResult(AppraisalStatusMaster appraisalStatusMaster) {
		entityCache.putResult(
			AppraisalStatusMasterImpl.class,
			appraisalStatusMaster.getPrimaryKey(), appraisalStatusMaster);

		finderCache.putResult(
			_finderPathFetchBystatus,
			new Object[] {appraisalStatusMaster.getStatus()},
			appraisalStatusMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the appraisal status masters in the entity cache if it is enabled.
	 *
	 * @param appraisalStatusMasters the appraisal status masters
	 */
	@Override
	public void cacheResult(
		List<AppraisalStatusMaster> appraisalStatusMasters) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (appraisalStatusMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AppraisalStatusMaster appraisalStatusMaster :
				appraisalStatusMasters) {

			if (entityCache.getResult(
					AppraisalStatusMasterImpl.class,
					appraisalStatusMaster.getPrimaryKey()) == null) {

				cacheResult(appraisalStatusMaster);
			}
		}
	}

	/**
	 * Clears the cache for all appraisal status masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AppraisalStatusMasterImpl.class);

		finderCache.clearCache(AppraisalStatusMasterImpl.class);
	}

	/**
	 * Clears the cache for the appraisal status master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AppraisalStatusMaster appraisalStatusMaster) {
		entityCache.removeResult(
			AppraisalStatusMasterImpl.class, appraisalStatusMaster);
	}

	@Override
	public void clearCache(List<AppraisalStatusMaster> appraisalStatusMasters) {
		for (AppraisalStatusMaster appraisalStatusMaster :
				appraisalStatusMasters) {

			entityCache.removeResult(
				AppraisalStatusMasterImpl.class, appraisalStatusMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AppraisalStatusMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				AppraisalStatusMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AppraisalStatusMasterModelImpl appraisalStatusMasterModelImpl) {

		Object[] args = new Object[] {
			appraisalStatusMasterModelImpl.getStatus()
		};

		finderCache.putResult(_finderPathCountBystatus, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBystatus, args, appraisalStatusMasterModelImpl);
	}

	/**
	 * Creates a new appraisal status master with the primary key. Does not add the appraisal status master to the database.
	 *
	 * @param appraisalStatusMasterId the primary key for the new appraisal status master
	 * @return the new appraisal status master
	 */
	@Override
	public AppraisalStatusMaster create(long appraisalStatusMasterId) {
		AppraisalStatusMaster appraisalStatusMaster =
			new AppraisalStatusMasterImpl();

		appraisalStatusMaster.setNew(true);
		appraisalStatusMaster.setPrimaryKey(appraisalStatusMasterId);

		appraisalStatusMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return appraisalStatusMaster;
	}

	/**
	 * Removes the appraisal status master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalStatusMasterId the primary key of the appraisal status master
	 * @return the appraisal status master that was removed
	 * @throws NoSuchAppraisalStatusMasterException if a appraisal status master with the primary key could not be found
	 */
	@Override
	public AppraisalStatusMaster remove(long appraisalStatusMasterId)
		throws NoSuchAppraisalStatusMasterException {

		return remove((Serializable)appraisalStatusMasterId);
	}

	/**
	 * Removes the appraisal status master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the appraisal status master
	 * @return the appraisal status master that was removed
	 * @throws NoSuchAppraisalStatusMasterException if a appraisal status master with the primary key could not be found
	 */
	@Override
	public AppraisalStatusMaster remove(Serializable primaryKey)
		throws NoSuchAppraisalStatusMasterException {

		Session session = null;

		try {
			session = openSession();

			AppraisalStatusMaster appraisalStatusMaster =
				(AppraisalStatusMaster)session.get(
					AppraisalStatusMasterImpl.class, primaryKey);

			if (appraisalStatusMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppraisalStatusMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(appraisalStatusMaster);
		}
		catch (NoSuchAppraisalStatusMasterException noSuchEntityException) {
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
	protected AppraisalStatusMaster removeImpl(
		AppraisalStatusMaster appraisalStatusMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appraisalStatusMaster)) {
				appraisalStatusMaster = (AppraisalStatusMaster)session.get(
					AppraisalStatusMasterImpl.class,
					appraisalStatusMaster.getPrimaryKeyObj());
			}

			if (appraisalStatusMaster != null) {
				session.delete(appraisalStatusMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (appraisalStatusMaster != null) {
			clearCache(appraisalStatusMaster);
		}

		return appraisalStatusMaster;
	}

	@Override
	public AppraisalStatusMaster updateImpl(
		AppraisalStatusMaster appraisalStatusMaster) {

		boolean isNew = appraisalStatusMaster.isNew();

		if (!(appraisalStatusMaster instanceof
				AppraisalStatusMasterModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(appraisalStatusMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					appraisalStatusMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in appraisalStatusMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AppraisalStatusMaster implementation " +
					appraisalStatusMaster.getClass());
		}

		AppraisalStatusMasterModelImpl appraisalStatusMasterModelImpl =
			(AppraisalStatusMasterModelImpl)appraisalStatusMaster;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (appraisalStatusMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				appraisalStatusMaster.setCreateDate(date);
			}
			else {
				appraisalStatusMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!appraisalStatusMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				appraisalStatusMaster.setModifiedDate(date);
			}
			else {
				appraisalStatusMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(appraisalStatusMaster);
			}
			else {
				appraisalStatusMaster = (AppraisalStatusMaster)session.merge(
					appraisalStatusMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AppraisalStatusMasterImpl.class, appraisalStatusMasterModelImpl,
			false, true);

		cacheUniqueFindersCache(appraisalStatusMasterModelImpl);

		if (isNew) {
			appraisalStatusMaster.setNew(false);
		}

		appraisalStatusMaster.resetOriginalValues();

		return appraisalStatusMaster;
	}

	/**
	 * Returns the appraisal status master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the appraisal status master
	 * @return the appraisal status master
	 * @throws NoSuchAppraisalStatusMasterException if a appraisal status master with the primary key could not be found
	 */
	@Override
	public AppraisalStatusMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppraisalStatusMasterException {

		AppraisalStatusMaster appraisalStatusMaster = fetchByPrimaryKey(
			primaryKey);

		if (appraisalStatusMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppraisalStatusMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return appraisalStatusMaster;
	}

	/**
	 * Returns the appraisal status master with the primary key or throws a <code>NoSuchAppraisalStatusMasterException</code> if it could not be found.
	 *
	 * @param appraisalStatusMasterId the primary key of the appraisal status master
	 * @return the appraisal status master
	 * @throws NoSuchAppraisalStatusMasterException if a appraisal status master with the primary key could not be found
	 */
	@Override
	public AppraisalStatusMaster findByPrimaryKey(long appraisalStatusMasterId)
		throws NoSuchAppraisalStatusMasterException {

		return findByPrimaryKey((Serializable)appraisalStatusMasterId);
	}

	/**
	 * Returns the appraisal status master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalStatusMasterId the primary key of the appraisal status master
	 * @return the appraisal status master, or <code>null</code> if a appraisal status master with the primary key could not be found
	 */
	@Override
	public AppraisalStatusMaster fetchByPrimaryKey(
		long appraisalStatusMasterId) {

		return fetchByPrimaryKey((Serializable)appraisalStatusMasterId);
	}

	/**
	 * Returns all the appraisal status masters.
	 *
	 * @return the appraisal status masters
	 */
	@Override
	public List<AppraisalStatusMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal status masters
	 * @param end the upper bound of the range of appraisal status masters (not inclusive)
	 * @return the range of appraisal status masters
	 */
	@Override
	public List<AppraisalStatusMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal status masters
	 * @param end the upper bound of the range of appraisal status masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appraisal status masters
	 */
	@Override
	public List<AppraisalStatusMaster> findAll(
		int start, int end,
		OrderByComparator<AppraisalStatusMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal status masters
	 * @param end the upper bound of the range of appraisal status masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of appraisal status masters
	 */
	@Override
	public List<AppraisalStatusMaster> findAll(
		int start, int end,
		OrderByComparator<AppraisalStatusMaster> orderByComparator,
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

		List<AppraisalStatusMaster> list = null;

		if (useFinderCache) {
			list = (List<AppraisalStatusMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_APPRAISALSTATUSMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_APPRAISALSTATUSMASTER;

				sql = sql.concat(AppraisalStatusMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AppraisalStatusMaster>)QueryUtil.list(
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
	 * Removes all the appraisal status masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AppraisalStatusMaster appraisalStatusMaster : findAll()) {
			remove(appraisalStatusMaster);
		}
	}

	/**
	 * Returns the number of appraisal status masters.
	 *
	 * @return the number of appraisal status masters
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
					_SQL_COUNT_APPRAISALSTATUSMASTER);

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
		return "appraisalStatusMasterId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_APPRAISALSTATUSMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AppraisalStatusMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the appraisal status master persistence.
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

		_finderPathFetchBystatus = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBystatus",
			new String[] {String.class.getName()}, new String[] {"status"},
			true);

		_finderPathCountBystatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
			new String[] {String.class.getName()}, new String[] {"status"},
			false);

		AppraisalStatusMasterUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AppraisalStatusMasterUtil.setPersistence(null);

		entityCache.removeCache(AppraisalStatusMasterImpl.class.getName());
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

	private static final String _SQL_SELECT_APPRAISALSTATUSMASTER =
		"SELECT appraisalStatusMaster FROM AppraisalStatusMaster appraisalStatusMaster";

	private static final String _SQL_SELECT_APPRAISALSTATUSMASTER_WHERE =
		"SELECT appraisalStatusMaster FROM AppraisalStatusMaster appraisalStatusMaster WHERE ";

	private static final String _SQL_COUNT_APPRAISALSTATUSMASTER =
		"SELECT COUNT(appraisalStatusMaster) FROM AppraisalStatusMaster appraisalStatusMaster";

	private static final String _SQL_COUNT_APPRAISALSTATUSMASTER_WHERE =
		"SELECT COUNT(appraisalStatusMaster) FROM AppraisalStatusMaster appraisalStatusMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"appraisalStatusMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AppraisalStatusMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AppraisalStatusMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AppraisalStatusMasterPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}