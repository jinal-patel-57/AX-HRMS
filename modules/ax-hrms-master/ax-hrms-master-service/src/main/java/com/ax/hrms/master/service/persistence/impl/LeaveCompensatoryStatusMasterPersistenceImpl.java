/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence.impl;

import com.ax.hrms.master.exception.NoSuchLeaveCompensatoryStatusMasterException;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMasterTable;
import com.ax.hrms.master.model.impl.LeaveCompensatoryStatusMasterImpl;
import com.ax.hrms.master.model.impl.LeaveCompensatoryStatusMasterModelImpl;
import com.ax.hrms.master.service.persistence.LeaveCompensatoryStatusMasterPersistence;
import com.ax.hrms.master.service.persistence.LeaveCompensatoryStatusMasterUtil;
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
 * The persistence implementation for the leave compensatory status master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LeaveCompensatoryStatusMasterPersistence.class)
public class LeaveCompensatoryStatusMasterPersistenceImpl
	extends BasePersistenceImpl<LeaveCompensatoryStatusMaster>
	implements LeaveCompensatoryStatusMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LeaveCompensatoryStatusMasterUtil</code> to access the leave compensatory status master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LeaveCompensatoryStatusMasterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByLeaveCompensatoryStatus;
	private FinderPath _finderPathCountByLeaveCompensatoryStatus;

	/**
	 * Returns the leave compensatory status master where leaveCompensatoryStatus = &#63; or throws a <code>NoSuchLeaveCompensatoryStatusMasterException</code> if it could not be found.
	 *
	 * @param leaveCompensatoryStatus the leave compensatory status
	 * @return the matching leave compensatory status master
	 * @throws NoSuchLeaveCompensatoryStatusMasterException if a matching leave compensatory status master could not be found
	 */
	@Override
	public LeaveCompensatoryStatusMaster findByLeaveCompensatoryStatus(
			String leaveCompensatoryStatus)
		throws NoSuchLeaveCompensatoryStatusMasterException {

		LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster =
			fetchByLeaveCompensatoryStatus(leaveCompensatoryStatus);

		if (leaveCompensatoryStatusMaster == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("leaveCompensatoryStatus=");
			sb.append(leaveCompensatoryStatus);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLeaveCompensatoryStatusMasterException(
				sb.toString());
		}

		return leaveCompensatoryStatusMaster;
	}

	/**
	 * Returns the leave compensatory status master where leaveCompensatoryStatus = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveCompensatoryStatus the leave compensatory status
	 * @return the matching leave compensatory status master, or <code>null</code> if a matching leave compensatory status master could not be found
	 */
	@Override
	public LeaveCompensatoryStatusMaster fetchByLeaveCompensatoryStatus(
		String leaveCompensatoryStatus) {

		return fetchByLeaveCompensatoryStatus(leaveCompensatoryStatus, true);
	}

	/**
	 * Returns the leave compensatory status master where leaveCompensatoryStatus = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveCompensatoryStatus the leave compensatory status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave compensatory status master, or <code>null</code> if a matching leave compensatory status master could not be found
	 */
	@Override
	public LeaveCompensatoryStatusMaster fetchByLeaveCompensatoryStatus(
		String leaveCompensatoryStatus, boolean useFinderCache) {

		leaveCompensatoryStatus = Objects.toString(leaveCompensatoryStatus, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {leaveCompensatoryStatus};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByLeaveCompensatoryStatus, finderArgs, this);
		}

		if (result instanceof LeaveCompensatoryStatusMaster) {
			LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster =
				(LeaveCompensatoryStatusMaster)result;

			if (!Objects.equals(
					leaveCompensatoryStatus,
					leaveCompensatoryStatusMaster.
						getLeaveCompensatoryStatus())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_LEAVECOMPENSATORYSTATUSMASTER_WHERE);

			boolean bindLeaveCompensatoryStatus = false;

			if (leaveCompensatoryStatus.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_LEAVECOMPENSATORYSTATUS_LEAVECOMPENSATORYSTATUS_3);
			}
			else {
				bindLeaveCompensatoryStatus = true;

				sb.append(
					_FINDER_COLUMN_LEAVECOMPENSATORYSTATUS_LEAVECOMPENSATORYSTATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLeaveCompensatoryStatus) {
					queryPos.add(
						StringUtil.toLowerCase(leaveCompensatoryStatus));
				}

				List<LeaveCompensatoryStatusMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByLeaveCompensatoryStatus,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									leaveCompensatoryStatus
								};
							}

							_log.warn(
								"LeaveCompensatoryStatusMasterPersistenceImpl.fetchByLeaveCompensatoryStatus(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LeaveCompensatoryStatusMaster
						leaveCompensatoryStatusMaster = list.get(0);

					result = leaveCompensatoryStatusMaster;

					cacheResult(leaveCompensatoryStatusMaster);
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
			return (LeaveCompensatoryStatusMaster)result;
		}
	}

	/**
	 * Removes the leave compensatory status master where leaveCompensatoryStatus = &#63; from the database.
	 *
	 * @param leaveCompensatoryStatus the leave compensatory status
	 * @return the leave compensatory status master that was removed
	 */
	@Override
	public LeaveCompensatoryStatusMaster removeByLeaveCompensatoryStatus(
			String leaveCompensatoryStatus)
		throws NoSuchLeaveCompensatoryStatusMasterException {

		LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster =
			findByLeaveCompensatoryStatus(leaveCompensatoryStatus);

		return remove(leaveCompensatoryStatusMaster);
	}

	/**
	 * Returns the number of leave compensatory status masters where leaveCompensatoryStatus = &#63;.
	 *
	 * @param leaveCompensatoryStatus the leave compensatory status
	 * @return the number of matching leave compensatory status masters
	 */
	@Override
	public int countByLeaveCompensatoryStatus(String leaveCompensatoryStatus) {
		leaveCompensatoryStatus = Objects.toString(leaveCompensatoryStatus, "");

		FinderPath finderPath = _finderPathCountByLeaveCompensatoryStatus;

		Object[] finderArgs = new Object[] {leaveCompensatoryStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVECOMPENSATORYSTATUSMASTER_WHERE);

			boolean bindLeaveCompensatoryStatus = false;

			if (leaveCompensatoryStatus.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_LEAVECOMPENSATORYSTATUS_LEAVECOMPENSATORYSTATUS_3);
			}
			else {
				bindLeaveCompensatoryStatus = true;

				sb.append(
					_FINDER_COLUMN_LEAVECOMPENSATORYSTATUS_LEAVECOMPENSATORYSTATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLeaveCompensatoryStatus) {
					queryPos.add(
						StringUtil.toLowerCase(leaveCompensatoryStatus));
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

	private static final String
		_FINDER_COLUMN_LEAVECOMPENSATORYSTATUS_LEAVECOMPENSATORYSTATUS_2 =
			"lower(leaveCompensatoryStatusMaster.leaveCompensatoryStatus) = ?";

	private static final String
		_FINDER_COLUMN_LEAVECOMPENSATORYSTATUS_LEAVECOMPENSATORYSTATUS_3 =
			"(leaveCompensatoryStatusMaster.leaveCompensatoryStatus IS NULL OR leaveCompensatoryStatusMaster.leaveCompensatoryStatus = '')";

	private FinderPath _finderPathFetchByLeaveCompensatoryStatusById;
	private FinderPath _finderPathCountByLeaveCompensatoryStatusById;

	/**
	 * Returns the leave compensatory status master where leaveCompensatoryStatusMasterId = &#63; or throws a <code>NoSuchLeaveCompensatoryStatusMasterException</code> if it could not be found.
	 *
	 * @param leaveCompensatoryStatusMasterId the leave compensatory status master ID
	 * @return the matching leave compensatory status master
	 * @throws NoSuchLeaveCompensatoryStatusMasterException if a matching leave compensatory status master could not be found
	 */
	@Override
	public LeaveCompensatoryStatusMaster findByLeaveCompensatoryStatusById(
			long leaveCompensatoryStatusMasterId)
		throws NoSuchLeaveCompensatoryStatusMasterException {

		LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster =
			fetchByLeaveCompensatoryStatusById(leaveCompensatoryStatusMasterId);

		if (leaveCompensatoryStatusMaster == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("leaveCompensatoryStatusMasterId=");
			sb.append(leaveCompensatoryStatusMasterId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLeaveCompensatoryStatusMasterException(
				sb.toString());
		}

		return leaveCompensatoryStatusMaster;
	}

	/**
	 * Returns the leave compensatory status master where leaveCompensatoryStatusMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveCompensatoryStatusMasterId the leave compensatory status master ID
	 * @return the matching leave compensatory status master, or <code>null</code> if a matching leave compensatory status master could not be found
	 */
	@Override
	public LeaveCompensatoryStatusMaster fetchByLeaveCompensatoryStatusById(
		long leaveCompensatoryStatusMasterId) {

		return fetchByLeaveCompensatoryStatusById(
			leaveCompensatoryStatusMasterId, true);
	}

	/**
	 * Returns the leave compensatory status master where leaveCompensatoryStatusMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveCompensatoryStatusMasterId the leave compensatory status master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave compensatory status master, or <code>null</code> if a matching leave compensatory status master could not be found
	 */
	@Override
	public LeaveCompensatoryStatusMaster fetchByLeaveCompensatoryStatusById(
		long leaveCompensatoryStatusMasterId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {leaveCompensatoryStatusMasterId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByLeaveCompensatoryStatusById, finderArgs,
				this);
		}

		if (result instanceof LeaveCompensatoryStatusMaster) {
			LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster =
				(LeaveCompensatoryStatusMaster)result;

			if (leaveCompensatoryStatusMasterId !=
					leaveCompensatoryStatusMaster.
						getLeaveCompensatoryStatusMasterId()) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_LEAVECOMPENSATORYSTATUSMASTER_WHERE);

			sb.append(
				_FINDER_COLUMN_LEAVECOMPENSATORYSTATUSBYID_LEAVECOMPENSATORYSTATUSMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(leaveCompensatoryStatusMasterId);

				List<LeaveCompensatoryStatusMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByLeaveCompensatoryStatusById,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									leaveCompensatoryStatusMasterId
								};
							}

							_log.warn(
								"LeaveCompensatoryStatusMasterPersistenceImpl.fetchByLeaveCompensatoryStatusById(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LeaveCompensatoryStatusMaster
						leaveCompensatoryStatusMaster = list.get(0);

					result = leaveCompensatoryStatusMaster;

					cacheResult(leaveCompensatoryStatusMaster);
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
			return (LeaveCompensatoryStatusMaster)result;
		}
	}

	/**
	 * Removes the leave compensatory status master where leaveCompensatoryStatusMasterId = &#63; from the database.
	 *
	 * @param leaveCompensatoryStatusMasterId the leave compensatory status master ID
	 * @return the leave compensatory status master that was removed
	 */
	@Override
	public LeaveCompensatoryStatusMaster removeByLeaveCompensatoryStatusById(
			long leaveCompensatoryStatusMasterId)
		throws NoSuchLeaveCompensatoryStatusMasterException {

		LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster =
			findByLeaveCompensatoryStatusById(leaveCompensatoryStatusMasterId);

		return remove(leaveCompensatoryStatusMaster);
	}

	/**
	 * Returns the number of leave compensatory status masters where leaveCompensatoryStatusMasterId = &#63;.
	 *
	 * @param leaveCompensatoryStatusMasterId the leave compensatory status master ID
	 * @return the number of matching leave compensatory status masters
	 */
	@Override
	public int countByLeaveCompensatoryStatusById(
		long leaveCompensatoryStatusMasterId) {

		FinderPath finderPath = _finderPathCountByLeaveCompensatoryStatusById;

		Object[] finderArgs = new Object[] {leaveCompensatoryStatusMasterId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVECOMPENSATORYSTATUSMASTER_WHERE);

			sb.append(
				_FINDER_COLUMN_LEAVECOMPENSATORYSTATUSBYID_LEAVECOMPENSATORYSTATUSMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(leaveCompensatoryStatusMasterId);

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
		_FINDER_COLUMN_LEAVECOMPENSATORYSTATUSBYID_LEAVECOMPENSATORYSTATUSMASTERID_2 =
			"leaveCompensatoryStatusMaster.leaveCompensatoryStatusMasterId = ?";

	public LeaveCompensatoryStatusMasterPersistenceImpl() {
		setModelClass(LeaveCompensatoryStatusMaster.class);

		setModelImplClass(LeaveCompensatoryStatusMasterImpl.class);
		setModelPKClass(long.class);

		setTable(LeaveCompensatoryStatusMasterTable.INSTANCE);
	}

	/**
	 * Caches the leave compensatory status master in the entity cache if it is enabled.
	 *
	 * @param leaveCompensatoryStatusMaster the leave compensatory status master
	 */
	@Override
	public void cacheResult(
		LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster) {

		entityCache.putResult(
			LeaveCompensatoryStatusMasterImpl.class,
			leaveCompensatoryStatusMaster.getPrimaryKey(),
			leaveCompensatoryStatusMaster);

		finderCache.putResult(
			_finderPathFetchByLeaveCompensatoryStatus,
			new Object[] {
				leaveCompensatoryStatusMaster.getLeaveCompensatoryStatus()
			},
			leaveCompensatoryStatusMaster);

		finderCache.putResult(
			_finderPathFetchByLeaveCompensatoryStatusById,
			new Object[] {
				leaveCompensatoryStatusMaster.
					getLeaveCompensatoryStatusMasterId()
			},
			leaveCompensatoryStatusMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the leave compensatory status masters in the entity cache if it is enabled.
	 *
	 * @param leaveCompensatoryStatusMasters the leave compensatory status masters
	 */
	@Override
	public void cacheResult(
		List<LeaveCompensatoryStatusMaster> leaveCompensatoryStatusMasters) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (leaveCompensatoryStatusMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster :
				leaveCompensatoryStatusMasters) {

			if (entityCache.getResult(
					LeaveCompensatoryStatusMasterImpl.class,
					leaveCompensatoryStatusMaster.getPrimaryKey()) == null) {

				cacheResult(leaveCompensatoryStatusMaster);
			}
		}
	}

	/**
	 * Clears the cache for all leave compensatory status masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LeaveCompensatoryStatusMasterImpl.class);

		finderCache.clearCache(LeaveCompensatoryStatusMasterImpl.class);
	}

	/**
	 * Clears the cache for the leave compensatory status master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster) {

		entityCache.removeResult(
			LeaveCompensatoryStatusMasterImpl.class,
			leaveCompensatoryStatusMaster);
	}

	@Override
	public void clearCache(
		List<LeaveCompensatoryStatusMaster> leaveCompensatoryStatusMasters) {

		for (LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster :
				leaveCompensatoryStatusMasters) {

			entityCache.removeResult(
				LeaveCompensatoryStatusMasterImpl.class,
				leaveCompensatoryStatusMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LeaveCompensatoryStatusMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				LeaveCompensatoryStatusMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LeaveCompensatoryStatusMasterModelImpl
			leaveCompensatoryStatusMasterModelImpl) {

		Object[] args = new Object[] {
			leaveCompensatoryStatusMasterModelImpl.getLeaveCompensatoryStatus()
		};

		finderCache.putResult(
			_finderPathCountByLeaveCompensatoryStatus, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByLeaveCompensatoryStatus, args,
			leaveCompensatoryStatusMasterModelImpl);

		args = new Object[] {
			leaveCompensatoryStatusMasterModelImpl.
				getLeaveCompensatoryStatusMasterId()
		};

		finderCache.putResult(
			_finderPathCountByLeaveCompensatoryStatusById, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByLeaveCompensatoryStatusById, args,
			leaveCompensatoryStatusMasterModelImpl);
	}

	/**
	 * Creates a new leave compensatory status master with the primary key. Does not add the leave compensatory status master to the database.
	 *
	 * @param leaveCompensatoryStatusMasterId the primary key for the new leave compensatory status master
	 * @return the new leave compensatory status master
	 */
	@Override
	public LeaveCompensatoryStatusMaster create(
		long leaveCompensatoryStatusMasterId) {

		LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster =
			new LeaveCompensatoryStatusMasterImpl();

		leaveCompensatoryStatusMaster.setNew(true);
		leaveCompensatoryStatusMaster.setPrimaryKey(
			leaveCompensatoryStatusMasterId);

		leaveCompensatoryStatusMaster.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return leaveCompensatoryStatusMaster;
	}

	/**
	 * Removes the leave compensatory status master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveCompensatoryStatusMasterId the primary key of the leave compensatory status master
	 * @return the leave compensatory status master that was removed
	 * @throws NoSuchLeaveCompensatoryStatusMasterException if a leave compensatory status master with the primary key could not be found
	 */
	@Override
	public LeaveCompensatoryStatusMaster remove(
			long leaveCompensatoryStatusMasterId)
		throws NoSuchLeaveCompensatoryStatusMasterException {

		return remove((Serializable)leaveCompensatoryStatusMasterId);
	}

	/**
	 * Removes the leave compensatory status master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave compensatory status master
	 * @return the leave compensatory status master that was removed
	 * @throws NoSuchLeaveCompensatoryStatusMasterException if a leave compensatory status master with the primary key could not be found
	 */
	@Override
	public LeaveCompensatoryStatusMaster remove(Serializable primaryKey)
		throws NoSuchLeaveCompensatoryStatusMasterException {

		Session session = null;

		try {
			session = openSession();

			LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster =
				(LeaveCompensatoryStatusMaster)session.get(
					LeaveCompensatoryStatusMasterImpl.class, primaryKey);

			if (leaveCompensatoryStatusMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveCompensatoryStatusMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(leaveCompensatoryStatusMaster);
		}
		catch (NoSuchLeaveCompensatoryStatusMasterException
					noSuchEntityException) {

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
	protected LeaveCompensatoryStatusMaster removeImpl(
		LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveCompensatoryStatusMaster)) {
				leaveCompensatoryStatusMaster =
					(LeaveCompensatoryStatusMaster)session.get(
						LeaveCompensatoryStatusMasterImpl.class,
						leaveCompensatoryStatusMaster.getPrimaryKeyObj());
			}

			if (leaveCompensatoryStatusMaster != null) {
				session.delete(leaveCompensatoryStatusMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (leaveCompensatoryStatusMaster != null) {
			clearCache(leaveCompensatoryStatusMaster);
		}

		return leaveCompensatoryStatusMaster;
	}

	@Override
	public LeaveCompensatoryStatusMaster updateImpl(
		LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster) {

		boolean isNew = leaveCompensatoryStatusMaster.isNew();

		if (!(leaveCompensatoryStatusMaster instanceof
				LeaveCompensatoryStatusMasterModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					leaveCompensatoryStatusMaster.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					leaveCompensatoryStatusMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in leaveCompensatoryStatusMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LeaveCompensatoryStatusMaster implementation " +
					leaveCompensatoryStatusMaster.getClass());
		}

		LeaveCompensatoryStatusMasterModelImpl
			leaveCompensatoryStatusMasterModelImpl =
				(LeaveCompensatoryStatusMasterModelImpl)
					leaveCompensatoryStatusMaster;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (leaveCompensatoryStatusMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				leaveCompensatoryStatusMaster.setCreateDate(date);
			}
			else {
				leaveCompensatoryStatusMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!leaveCompensatoryStatusMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				leaveCompensatoryStatusMaster.setModifiedDate(date);
			}
			else {
				leaveCompensatoryStatusMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(leaveCompensatoryStatusMaster);
			}
			else {
				leaveCompensatoryStatusMaster =
					(LeaveCompensatoryStatusMaster)session.merge(
						leaveCompensatoryStatusMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LeaveCompensatoryStatusMasterImpl.class,
			leaveCompensatoryStatusMasterModelImpl, false, true);

		cacheUniqueFindersCache(leaveCompensatoryStatusMasterModelImpl);

		if (isNew) {
			leaveCompensatoryStatusMaster.setNew(false);
		}

		leaveCompensatoryStatusMaster.resetOriginalValues();

		return leaveCompensatoryStatusMaster;
	}

	/**
	 * Returns the leave compensatory status master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave compensatory status master
	 * @return the leave compensatory status master
	 * @throws NoSuchLeaveCompensatoryStatusMasterException if a leave compensatory status master with the primary key could not be found
	 */
	@Override
	public LeaveCompensatoryStatusMaster findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchLeaveCompensatoryStatusMasterException {

		LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster =
			fetchByPrimaryKey(primaryKey);

		if (leaveCompensatoryStatusMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveCompensatoryStatusMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return leaveCompensatoryStatusMaster;
	}

	/**
	 * Returns the leave compensatory status master with the primary key or throws a <code>NoSuchLeaveCompensatoryStatusMasterException</code> if it could not be found.
	 *
	 * @param leaveCompensatoryStatusMasterId the primary key of the leave compensatory status master
	 * @return the leave compensatory status master
	 * @throws NoSuchLeaveCompensatoryStatusMasterException if a leave compensatory status master with the primary key could not be found
	 */
	@Override
	public LeaveCompensatoryStatusMaster findByPrimaryKey(
			long leaveCompensatoryStatusMasterId)
		throws NoSuchLeaveCompensatoryStatusMasterException {

		return findByPrimaryKey((Serializable)leaveCompensatoryStatusMasterId);
	}

	/**
	 * Returns the leave compensatory status master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveCompensatoryStatusMasterId the primary key of the leave compensatory status master
	 * @return the leave compensatory status master, or <code>null</code> if a leave compensatory status master with the primary key could not be found
	 */
	@Override
	public LeaveCompensatoryStatusMaster fetchByPrimaryKey(
		long leaveCompensatoryStatusMasterId) {

		return fetchByPrimaryKey((Serializable)leaveCompensatoryStatusMasterId);
	}

	/**
	 * Returns all the leave compensatory status masters.
	 *
	 * @return the leave compensatory status masters
	 */
	@Override
	public List<LeaveCompensatoryStatusMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave compensatory status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveCompensatoryStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave compensatory status masters
	 * @param end the upper bound of the range of leave compensatory status masters (not inclusive)
	 * @return the range of leave compensatory status masters
	 */
	@Override
	public List<LeaveCompensatoryStatusMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave compensatory status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveCompensatoryStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave compensatory status masters
	 * @param end the upper bound of the range of leave compensatory status masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave compensatory status masters
	 */
	@Override
	public List<LeaveCompensatoryStatusMaster> findAll(
		int start, int end,
		OrderByComparator<LeaveCompensatoryStatusMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave compensatory status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveCompensatoryStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave compensatory status masters
	 * @param end the upper bound of the range of leave compensatory status masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave compensatory status masters
	 */
	@Override
	public List<LeaveCompensatoryStatusMaster> findAll(
		int start, int end,
		OrderByComparator<LeaveCompensatoryStatusMaster> orderByComparator,
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

		List<LeaveCompensatoryStatusMaster> list = null;

		if (useFinderCache) {
			list = (List<LeaveCompensatoryStatusMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LEAVECOMPENSATORYSTATUSMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVECOMPENSATORYSTATUSMASTER;

				sql = sql.concat(
					LeaveCompensatoryStatusMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LeaveCompensatoryStatusMaster>)QueryUtil.list(
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
	 * Removes all the leave compensatory status masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster :
				findAll()) {

			remove(leaveCompensatoryStatusMaster);
		}
	}

	/**
	 * Returns the number of leave compensatory status masters.
	 *
	 * @return the number of leave compensatory status masters
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
					_SQL_COUNT_LEAVECOMPENSATORYSTATUSMASTER);

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
		return "leaveCompensatoryStatusMasterId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEAVECOMPENSATORYSTATUSMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LeaveCompensatoryStatusMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leave compensatory status master persistence.
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

		_finderPathFetchByLeaveCompensatoryStatus = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByLeaveCompensatoryStatus",
			new String[] {String.class.getName()},
			new String[] {"leaveCompensatoryStatus"}, true);

		_finderPathCountByLeaveCompensatoryStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLeaveCompensatoryStatus",
			new String[] {String.class.getName()},
			new String[] {"leaveCompensatoryStatus"}, false);

		_finderPathFetchByLeaveCompensatoryStatusById = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByLeaveCompensatoryStatusById",
			new String[] {Long.class.getName()},
			new String[] {"leaveCompensatoryStatusMasterId"}, true);

		_finderPathCountByLeaveCompensatoryStatusById = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLeaveCompensatoryStatusById",
			new String[] {Long.class.getName()},
			new String[] {"leaveCompensatoryStatusMasterId"}, false);

		LeaveCompensatoryStatusMasterUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		LeaveCompensatoryStatusMasterUtil.setPersistence(null);

		entityCache.removeCache(
			LeaveCompensatoryStatusMasterImpl.class.getName());
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

	private static final String _SQL_SELECT_LEAVECOMPENSATORYSTATUSMASTER =
		"SELECT leaveCompensatoryStatusMaster FROM LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster";

	private static final String
		_SQL_SELECT_LEAVECOMPENSATORYSTATUSMASTER_WHERE =
			"SELECT leaveCompensatoryStatusMaster FROM LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster WHERE ";

	private static final String _SQL_COUNT_LEAVECOMPENSATORYSTATUSMASTER =
		"SELECT COUNT(leaveCompensatoryStatusMaster) FROM LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster";

	private static final String _SQL_COUNT_LEAVECOMPENSATORYSTATUSMASTER_WHERE =
		"SELECT COUNT(leaveCompensatoryStatusMaster) FROM LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"leaveCompensatoryStatusMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LeaveCompensatoryStatusMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LeaveCompensatoryStatusMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LeaveCompensatoryStatusMasterPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}