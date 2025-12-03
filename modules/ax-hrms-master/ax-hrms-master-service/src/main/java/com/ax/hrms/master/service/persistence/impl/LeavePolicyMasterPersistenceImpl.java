/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence.impl;

import com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException;
import com.ax.hrms.master.model.LeavePolicyMaster;
import com.ax.hrms.master.model.LeavePolicyMasterTable;
import com.ax.hrms.master.model.impl.LeavePolicyMasterImpl;
import com.ax.hrms.master.model.impl.LeavePolicyMasterModelImpl;
import com.ax.hrms.master.service.persistence.LeavePolicyMasterPersistence;
import com.ax.hrms.master.service.persistence.LeavePolicyMasterUtil;
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
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the leave policy master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LeavePolicyMasterPersistence.class)
public class LeavePolicyMasterPersistenceImpl
	extends BasePersistenceImpl<LeavePolicyMaster>
	implements LeavePolicyMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LeavePolicyMasterUtil</code> to access the leave policy master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LeavePolicyMasterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByLeaveTypeMasterId;
	private FinderPath _finderPathCountByLeaveTypeMasterId;

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; or throws a <code>NoSuchLeavePolicyMasterException</code> if it could not be found.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the matching leave policy master
	 * @throws NoSuchLeavePolicyMasterException if a matching leave policy master could not be found
	 */
	@Override
	public LeavePolicyMaster findByLeaveTypeMasterId(long leaveTypeMasterId)
		throws NoSuchLeavePolicyMasterException {

		LeavePolicyMaster leavePolicyMaster = fetchByLeaveTypeMasterId(
			leaveTypeMasterId);

		if (leavePolicyMaster == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("leaveTypeMasterId=");
			sb.append(leaveTypeMasterId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLeavePolicyMasterException(sb.toString());
		}

		return leavePolicyMaster;
	}

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	@Override
	public LeavePolicyMaster fetchByLeaveTypeMasterId(long leaveTypeMasterId) {
		return fetchByLeaveTypeMasterId(leaveTypeMasterId, true);
	}

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	@Override
	public LeavePolicyMaster fetchByLeaveTypeMasterId(
		long leaveTypeMasterId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {leaveTypeMasterId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByLeaveTypeMasterId, finderArgs, this);
		}

		if (result instanceof LeavePolicyMaster) {
			LeavePolicyMaster leavePolicyMaster = (LeavePolicyMaster)result;

			if (leaveTypeMasterId != leavePolicyMaster.getLeaveTypeMasterId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_LEAVEPOLICYMASTER_WHERE);

			sb.append(_FINDER_COLUMN_LEAVETYPEMASTERID_LEAVETYPEMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(leaveTypeMasterId);

				List<LeavePolicyMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByLeaveTypeMasterId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {leaveTypeMasterId};
							}

							_log.warn(
								"LeavePolicyMasterPersistenceImpl.fetchByLeaveTypeMasterId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LeavePolicyMaster leavePolicyMaster = list.get(0);

					result = leavePolicyMaster;

					cacheResult(leavePolicyMaster);
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
			return (LeavePolicyMaster)result;
		}
	}

	/**
	 * Removes the leave policy master where leaveTypeMasterId = &#63; from the database.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the leave policy master that was removed
	 */
	@Override
	public LeavePolicyMaster removeByLeaveTypeMasterId(long leaveTypeMasterId)
		throws NoSuchLeavePolicyMasterException {

		LeavePolicyMaster leavePolicyMaster = findByLeaveTypeMasterId(
			leaveTypeMasterId);

		return remove(leavePolicyMaster);
	}

	/**
	 * Returns the number of leave policy masters where leaveTypeMasterId = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the number of matching leave policy masters
	 */
	@Override
	public int countByLeaveTypeMasterId(long leaveTypeMasterId) {
		FinderPath finderPath = _finderPathCountByLeaveTypeMasterId;

		Object[] finderArgs = new Object[] {leaveTypeMasterId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVEPOLICYMASTER_WHERE);

			sb.append(_FINDER_COLUMN_LEAVETYPEMASTERID_LEAVETYPEMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(leaveTypeMasterId);

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
		_FINDER_COLUMN_LEAVETYPEMASTERID_LEAVETYPEMASTERID_2 =
			"leavePolicyMaster.leaveTypeMasterId = ?";

	private FinderPath _finderPathFetchByLeaveTypeMasterIdAndYear;
	private FinderPath _finderPathCountByLeaveTypeMasterIdAndYear;

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; or throws a <code>NoSuchLeavePolicyMasterException</code> if it could not be found.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @return the matching leave policy master
	 * @throws NoSuchLeavePolicyMasterException if a matching leave policy master could not be found
	 */
	@Override
	public LeavePolicyMaster findByLeaveTypeMasterIdAndYear(
			long leaveTypeMasterId, int yearOfPolicy)
		throws NoSuchLeavePolicyMasterException {

		LeavePolicyMaster leavePolicyMaster = fetchByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, yearOfPolicy);

		if (leavePolicyMaster == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("leaveTypeMasterId=");
			sb.append(leaveTypeMasterId);

			sb.append(", yearOfPolicy=");
			sb.append(yearOfPolicy);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLeavePolicyMasterException(sb.toString());
		}

		return leavePolicyMaster;
	}

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @return the matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	@Override
	public LeavePolicyMaster fetchByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int yearOfPolicy) {

		return fetchByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, yearOfPolicy, true);
	}

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	@Override
	public LeavePolicyMaster fetchByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int yearOfPolicy, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {leaveTypeMasterId, yearOfPolicy};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByLeaveTypeMasterIdAndYear, finderArgs, this);
		}

		if (result instanceof LeavePolicyMaster) {
			LeavePolicyMaster leavePolicyMaster = (LeavePolicyMaster)result;

			if ((leaveTypeMasterId !=
					leavePolicyMaster.getLeaveTypeMasterId()) ||
				(yearOfPolicy != leavePolicyMaster.getYearOfPolicy())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LEAVEPOLICYMASTER_WHERE);

			sb.append(
				_FINDER_COLUMN_LEAVETYPEMASTERIDANDYEAR_LEAVETYPEMASTERID_2);

			sb.append(_FINDER_COLUMN_LEAVETYPEMASTERIDANDYEAR_YEAROFPOLICY_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(leaveTypeMasterId);

				queryPos.add(yearOfPolicy);

				List<LeavePolicyMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByLeaveTypeMasterIdAndYear,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									leaveTypeMasterId, yearOfPolicy
								};
							}

							_log.warn(
								"LeavePolicyMasterPersistenceImpl.fetchByLeaveTypeMasterIdAndYear(long, int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LeavePolicyMaster leavePolicyMaster = list.get(0);

					result = leavePolicyMaster;

					cacheResult(leavePolicyMaster);
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
			return (LeavePolicyMaster)result;
		}
	}

	/**
	 * Removes the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; from the database.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @return the leave policy master that was removed
	 */
	@Override
	public LeavePolicyMaster removeByLeaveTypeMasterIdAndYear(
			long leaveTypeMasterId, int yearOfPolicy)
		throws NoSuchLeavePolicyMasterException {

		LeavePolicyMaster leavePolicyMaster = findByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, yearOfPolicy);

		return remove(leavePolicyMaster);
	}

	/**
	 * Returns the number of leave policy masters where leaveTypeMasterId = &#63; and yearOfPolicy = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @return the number of matching leave policy masters
	 */
	@Override
	public int countByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int yearOfPolicy) {

		FinderPath finderPath = _finderPathCountByLeaveTypeMasterIdAndYear;

		Object[] finderArgs = new Object[] {leaveTypeMasterId, yearOfPolicy};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVEPOLICYMASTER_WHERE);

			sb.append(
				_FINDER_COLUMN_LEAVETYPEMASTERIDANDYEAR_LEAVETYPEMASTERID_2);

			sb.append(_FINDER_COLUMN_LEAVETYPEMASTERIDANDYEAR_YEAROFPOLICY_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(leaveTypeMasterId);

				queryPos.add(yearOfPolicy);

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
		_FINDER_COLUMN_LEAVETYPEMASTERIDANDYEAR_LEAVETYPEMASTERID_2 =
			"leavePolicyMaster.leaveTypeMasterId = ? AND ";

	private static final String
		_FINDER_COLUMN_LEAVETYPEMASTERIDANDYEAR_YEAROFPOLICY_2 =
			"leavePolicyMaster.yearOfPolicy = ?";

	private FinderPath _finderPathWithPaginationFindByYear;
	private FinderPath _finderPathWithoutPaginationFindByYear;
	private FinderPath _finderPathCountByYear;

	/**
	 * Returns all the leave policy masters where yearOfPolicy = &#63;.
	 *
	 * @param yearOfPolicy the year of policy
	 * @return the matching leave policy masters
	 */
	@Override
	public List<LeavePolicyMaster> findByYear(int yearOfPolicy) {
		return findByYear(
			yearOfPolicy, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave policy masters where yearOfPolicy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeavePolicyMasterModelImpl</code>.
	 * </p>
	 *
	 * @param yearOfPolicy the year of policy
	 * @param start the lower bound of the range of leave policy masters
	 * @param end the upper bound of the range of leave policy masters (not inclusive)
	 * @return the range of matching leave policy masters
	 */
	@Override
	public List<LeavePolicyMaster> findByYear(
		int yearOfPolicy, int start, int end) {

		return findByYear(yearOfPolicy, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave policy masters where yearOfPolicy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeavePolicyMasterModelImpl</code>.
	 * </p>
	 *
	 * @param yearOfPolicy the year of policy
	 * @param start the lower bound of the range of leave policy masters
	 * @param end the upper bound of the range of leave policy masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave policy masters
	 */
	@Override
	public List<LeavePolicyMaster> findByYear(
		int yearOfPolicy, int start, int end,
		OrderByComparator<LeavePolicyMaster> orderByComparator) {

		return findByYear(yearOfPolicy, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave policy masters where yearOfPolicy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeavePolicyMasterModelImpl</code>.
	 * </p>
	 *
	 * @param yearOfPolicy the year of policy
	 * @param start the lower bound of the range of leave policy masters
	 * @param end the upper bound of the range of leave policy masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave policy masters
	 */
	@Override
	public List<LeavePolicyMaster> findByYear(
		int yearOfPolicy, int start, int end,
		OrderByComparator<LeavePolicyMaster> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByYear;
				finderArgs = new Object[] {yearOfPolicy};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByYear;
			finderArgs = new Object[] {
				yearOfPolicy, start, end, orderByComparator
			};
		}

		List<LeavePolicyMaster> list = null;

		if (useFinderCache) {
			list = (List<LeavePolicyMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeavePolicyMaster leavePolicyMaster : list) {
					if (yearOfPolicy != leavePolicyMaster.getYearOfPolicy()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_LEAVEPOLICYMASTER_WHERE);

			sb.append(_FINDER_COLUMN_YEAR_YEAROFPOLICY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LeavePolicyMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(yearOfPolicy);

				list = (List<LeavePolicyMaster>)QueryUtil.list(
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
	 * Returns the first leave policy master in the ordered set where yearOfPolicy = &#63;.
	 *
	 * @param yearOfPolicy the year of policy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave policy master
	 * @throws NoSuchLeavePolicyMasterException if a matching leave policy master could not be found
	 */
	@Override
	public LeavePolicyMaster findByYear_First(
			int yearOfPolicy,
			OrderByComparator<LeavePolicyMaster> orderByComparator)
		throws NoSuchLeavePolicyMasterException {

		LeavePolicyMaster leavePolicyMaster = fetchByYear_First(
			yearOfPolicy, orderByComparator);

		if (leavePolicyMaster != null) {
			return leavePolicyMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("yearOfPolicy=");
		sb.append(yearOfPolicy);

		sb.append("}");

		throw new NoSuchLeavePolicyMasterException(sb.toString());
	}

	/**
	 * Returns the first leave policy master in the ordered set where yearOfPolicy = &#63;.
	 *
	 * @param yearOfPolicy the year of policy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	@Override
	public LeavePolicyMaster fetchByYear_First(
		int yearOfPolicy,
		OrderByComparator<LeavePolicyMaster> orderByComparator) {

		List<LeavePolicyMaster> list = findByYear(
			yearOfPolicy, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave policy master in the ordered set where yearOfPolicy = &#63;.
	 *
	 * @param yearOfPolicy the year of policy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave policy master
	 * @throws NoSuchLeavePolicyMasterException if a matching leave policy master could not be found
	 */
	@Override
	public LeavePolicyMaster findByYear_Last(
			int yearOfPolicy,
			OrderByComparator<LeavePolicyMaster> orderByComparator)
		throws NoSuchLeavePolicyMasterException {

		LeavePolicyMaster leavePolicyMaster = fetchByYear_Last(
			yearOfPolicy, orderByComparator);

		if (leavePolicyMaster != null) {
			return leavePolicyMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("yearOfPolicy=");
		sb.append(yearOfPolicy);

		sb.append("}");

		throw new NoSuchLeavePolicyMasterException(sb.toString());
	}

	/**
	 * Returns the last leave policy master in the ordered set where yearOfPolicy = &#63;.
	 *
	 * @param yearOfPolicy the year of policy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	@Override
	public LeavePolicyMaster fetchByYear_Last(
		int yearOfPolicy,
		OrderByComparator<LeavePolicyMaster> orderByComparator) {

		int count = countByYear(yearOfPolicy);

		if (count == 0) {
			return null;
		}

		List<LeavePolicyMaster> list = findByYear(
			yearOfPolicy, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave policy masters before and after the current leave policy master in the ordered set where yearOfPolicy = &#63;.
	 *
	 * @param leavePolicyMasterId the primary key of the current leave policy master
	 * @param yearOfPolicy the year of policy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave policy master
	 * @throws NoSuchLeavePolicyMasterException if a leave policy master with the primary key could not be found
	 */
	@Override
	public LeavePolicyMaster[] findByYear_PrevAndNext(
			long leavePolicyMasterId, int yearOfPolicy,
			OrderByComparator<LeavePolicyMaster> orderByComparator)
		throws NoSuchLeavePolicyMasterException {

		LeavePolicyMaster leavePolicyMaster = findByPrimaryKey(
			leavePolicyMasterId);

		Session session = null;

		try {
			session = openSession();

			LeavePolicyMaster[] array = new LeavePolicyMasterImpl[3];

			array[0] = getByYear_PrevAndNext(
				session, leavePolicyMaster, yearOfPolicy, orderByComparator,
				true);

			array[1] = leavePolicyMaster;

			array[2] = getByYear_PrevAndNext(
				session, leavePolicyMaster, yearOfPolicy, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeavePolicyMaster getByYear_PrevAndNext(
		Session session, LeavePolicyMaster leavePolicyMaster, int yearOfPolicy,
		OrderByComparator<LeavePolicyMaster> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LEAVEPOLICYMASTER_WHERE);

		sb.append(_FINDER_COLUMN_YEAR_YEAROFPOLICY_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(LeavePolicyMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(yearOfPolicy);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						leavePolicyMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeavePolicyMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave policy masters where yearOfPolicy = &#63; from the database.
	 *
	 * @param yearOfPolicy the year of policy
	 */
	@Override
	public void removeByYear(int yearOfPolicy) {
		for (LeavePolicyMaster leavePolicyMaster :
				findByYear(
					yearOfPolicy, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leavePolicyMaster);
		}
	}

	/**
	 * Returns the number of leave policy masters where yearOfPolicy = &#63;.
	 *
	 * @param yearOfPolicy the year of policy
	 * @return the number of matching leave policy masters
	 */
	@Override
	public int countByYear(int yearOfPolicy) {
		FinderPath finderPath = _finderPathCountByYear;

		Object[] finderArgs = new Object[] {yearOfPolicy};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVEPOLICYMASTER_WHERE);

			sb.append(_FINDER_COLUMN_YEAR_YEAROFPOLICY_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(yearOfPolicy);

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

	private static final String _FINDER_COLUMN_YEAR_YEAROFPOLICY_2 =
		"leavePolicyMaster.yearOfPolicy = ?";

	private FinderPath
		_finderPathFetchByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths;
	private FinderPath
		_finderPathCountByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths;

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; and eligibleAfterMonths = &#63; or throws a <code>NoSuchLeavePolicyMasterException</code> if it could not be found.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @param eligibleAfterMonths the eligible after months
	 * @return the matching leave policy master
	 * @throws NoSuchLeavePolicyMasterException if a matching leave policy master could not be found
	 */
	@Override
	public LeavePolicyMaster
			findByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
				long leaveTypeMasterId, int yearOfPolicy,
				int eligibleAfterMonths)
		throws NoSuchLeavePolicyMasterException {

		LeavePolicyMaster leavePolicyMaster =
			fetchByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
				leaveTypeMasterId, yearOfPolicy, eligibleAfterMonths);

		if (leavePolicyMaster == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("leaveTypeMasterId=");
			sb.append(leaveTypeMasterId);

			sb.append(", yearOfPolicy=");
			sb.append(yearOfPolicy);

			sb.append(", eligibleAfterMonths=");
			sb.append(eligibleAfterMonths);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLeavePolicyMasterException(sb.toString());
		}

		return leavePolicyMaster;
	}

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; and eligibleAfterMonths = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @param eligibleAfterMonths the eligible after months
	 * @return the matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	@Override
	public LeavePolicyMaster
		fetchByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
			long leaveTypeMasterId, int yearOfPolicy, int eligibleAfterMonths) {

		return fetchByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
			leaveTypeMasterId, yearOfPolicy, eligibleAfterMonths, true);
	}

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; and eligibleAfterMonths = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @param eligibleAfterMonths the eligible after months
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	@Override
	public LeavePolicyMaster
		fetchByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
			long leaveTypeMasterId, int yearOfPolicy, int eligibleAfterMonths,
			boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				leaveTypeMasterId, yearOfPolicy, eligibleAfterMonths
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths,
				finderArgs, this);
		}

		if (result instanceof LeavePolicyMaster) {
			LeavePolicyMaster leavePolicyMaster = (LeavePolicyMaster)result;

			if ((leaveTypeMasterId !=
					leavePolicyMaster.getLeaveTypeMasterId()) ||
				(yearOfPolicy != leavePolicyMaster.getYearOfPolicy()) ||
				(eligibleAfterMonths !=
					leavePolicyMaster.getEligibleAfterMonths())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_LEAVEPOLICYMASTER_WHERE);

			sb.append(
				_FINDER_COLUMN_LEAVETYPEMASTERIDANDYEAROFPOLICYANDELIGIBLEAFTERMONTHS_LEAVETYPEMASTERID_2);

			sb.append(
				_FINDER_COLUMN_LEAVETYPEMASTERIDANDYEAROFPOLICYANDELIGIBLEAFTERMONTHS_YEAROFPOLICY_2);

			sb.append(
				_FINDER_COLUMN_LEAVETYPEMASTERIDANDYEAROFPOLICYANDELIGIBLEAFTERMONTHS_ELIGIBLEAFTERMONTHS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(leaveTypeMasterId);

				queryPos.add(yearOfPolicy);

				queryPos.add(eligibleAfterMonths);

				List<LeavePolicyMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									leaveTypeMasterId, yearOfPolicy,
									eligibleAfterMonths
								};
							}

							_log.warn(
								"LeavePolicyMasterPersistenceImpl.fetchByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(long, int, int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LeavePolicyMaster leavePolicyMaster = list.get(0);

					result = leavePolicyMaster;

					cacheResult(leavePolicyMaster);
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
			return (LeavePolicyMaster)result;
		}
	}

	/**
	 * Removes the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; and eligibleAfterMonths = &#63; from the database.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @param eligibleAfterMonths the eligible after months
	 * @return the leave policy master that was removed
	 */
	@Override
	public LeavePolicyMaster
			removeByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
				long leaveTypeMasterId, int yearOfPolicy,
				int eligibleAfterMonths)
		throws NoSuchLeavePolicyMasterException {

		LeavePolicyMaster leavePolicyMaster =
			findByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
				leaveTypeMasterId, yearOfPolicy, eligibleAfterMonths);

		return remove(leavePolicyMaster);
	}

	/**
	 * Returns the number of leave policy masters where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; and eligibleAfterMonths = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @param eligibleAfterMonths the eligible after months
	 * @return the number of matching leave policy masters
	 */
	@Override
	public int countByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
		long leaveTypeMasterId, int yearOfPolicy, int eligibleAfterMonths) {

		FinderPath finderPath =
			_finderPathCountByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths;

		Object[] finderArgs = new Object[] {
			leaveTypeMasterId, yearOfPolicy, eligibleAfterMonths
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_LEAVEPOLICYMASTER_WHERE);

			sb.append(
				_FINDER_COLUMN_LEAVETYPEMASTERIDANDYEAROFPOLICYANDELIGIBLEAFTERMONTHS_LEAVETYPEMASTERID_2);

			sb.append(
				_FINDER_COLUMN_LEAVETYPEMASTERIDANDYEAROFPOLICYANDELIGIBLEAFTERMONTHS_YEAROFPOLICY_2);

			sb.append(
				_FINDER_COLUMN_LEAVETYPEMASTERIDANDYEAROFPOLICYANDELIGIBLEAFTERMONTHS_ELIGIBLEAFTERMONTHS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(leaveTypeMasterId);

				queryPos.add(yearOfPolicy);

				queryPos.add(eligibleAfterMonths);

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
		_FINDER_COLUMN_LEAVETYPEMASTERIDANDYEAROFPOLICYANDELIGIBLEAFTERMONTHS_LEAVETYPEMASTERID_2 =
			"leavePolicyMaster.leaveTypeMasterId = ? AND ";

	private static final String
		_FINDER_COLUMN_LEAVETYPEMASTERIDANDYEAROFPOLICYANDELIGIBLEAFTERMONTHS_YEAROFPOLICY_2 =
			"leavePolicyMaster.yearOfPolicy = ? AND ";

	private static final String
		_FINDER_COLUMN_LEAVETYPEMASTERIDANDYEAROFPOLICYANDELIGIBLEAFTERMONTHS_ELIGIBLEAFTERMONTHS_2 =
			"leavePolicyMaster.eligibleAfterMonths = ?";

	public LeavePolicyMasterPersistenceImpl() {
		setModelClass(LeavePolicyMaster.class);

		setModelImplClass(LeavePolicyMasterImpl.class);
		setModelPKClass(long.class);

		setTable(LeavePolicyMasterTable.INSTANCE);
	}

	/**
	 * Caches the leave policy master in the entity cache if it is enabled.
	 *
	 * @param leavePolicyMaster the leave policy master
	 */
	@Override
	public void cacheResult(LeavePolicyMaster leavePolicyMaster) {
		entityCache.putResult(
			LeavePolicyMasterImpl.class, leavePolicyMaster.getPrimaryKey(),
			leavePolicyMaster);

		finderCache.putResult(
			_finderPathFetchByLeaveTypeMasterId,
			new Object[] {leavePolicyMaster.getLeaveTypeMasterId()},
			leavePolicyMaster);

		finderCache.putResult(
			_finderPathFetchByLeaveTypeMasterIdAndYear,
			new Object[] {
				leavePolicyMaster.getLeaveTypeMasterId(),
				leavePolicyMaster.getYearOfPolicy()
			},
			leavePolicyMaster);

		finderCache.putResult(
			_finderPathFetchByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths,
			new Object[] {
				leavePolicyMaster.getLeaveTypeMasterId(),
				leavePolicyMaster.getYearOfPolicy(),
				leavePolicyMaster.getEligibleAfterMonths()
			},
			leavePolicyMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the leave policy masters in the entity cache if it is enabled.
	 *
	 * @param leavePolicyMasters the leave policy masters
	 */
	@Override
	public void cacheResult(List<LeavePolicyMaster> leavePolicyMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (leavePolicyMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LeavePolicyMaster leavePolicyMaster : leavePolicyMasters) {
			if (entityCache.getResult(
					LeavePolicyMasterImpl.class,
					leavePolicyMaster.getPrimaryKey()) == null) {

				cacheResult(leavePolicyMaster);
			}
		}
	}

	/**
	 * Clears the cache for all leave policy masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LeavePolicyMasterImpl.class);

		finderCache.clearCache(LeavePolicyMasterImpl.class);
	}

	/**
	 * Clears the cache for the leave policy master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeavePolicyMaster leavePolicyMaster) {
		entityCache.removeResult(
			LeavePolicyMasterImpl.class, leavePolicyMaster);
	}

	@Override
	public void clearCache(List<LeavePolicyMaster> leavePolicyMasters) {
		for (LeavePolicyMaster leavePolicyMaster : leavePolicyMasters) {
			entityCache.removeResult(
				LeavePolicyMasterImpl.class, leavePolicyMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LeavePolicyMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LeavePolicyMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LeavePolicyMasterModelImpl leavePolicyMasterModelImpl) {

		Object[] args = new Object[] {
			leavePolicyMasterModelImpl.getLeaveTypeMasterId()
		};

		finderCache.putResult(
			_finderPathCountByLeaveTypeMasterId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByLeaveTypeMasterId, args,
			leavePolicyMasterModelImpl);

		args = new Object[] {
			leavePolicyMasterModelImpl.getLeaveTypeMasterId(),
			leavePolicyMasterModelImpl.getYearOfPolicy()
		};

		finderCache.putResult(
			_finderPathCountByLeaveTypeMasterIdAndYear, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByLeaveTypeMasterIdAndYear, args,
			leavePolicyMasterModelImpl);

		args = new Object[] {
			leavePolicyMasterModelImpl.getLeaveTypeMasterId(),
			leavePolicyMasterModelImpl.getYearOfPolicy(),
			leavePolicyMasterModelImpl.getEligibleAfterMonths()
		};

		finderCache.putResult(
			_finderPathCountByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths,
			args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths,
			args, leavePolicyMasterModelImpl);
	}

	/**
	 * Creates a new leave policy master with the primary key. Does not add the leave policy master to the database.
	 *
	 * @param leavePolicyMasterId the primary key for the new leave policy master
	 * @return the new leave policy master
	 */
	@Override
	public LeavePolicyMaster create(long leavePolicyMasterId) {
		LeavePolicyMaster leavePolicyMaster = new LeavePolicyMasterImpl();

		leavePolicyMaster.setNew(true);
		leavePolicyMaster.setPrimaryKey(leavePolicyMasterId);

		leavePolicyMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return leavePolicyMaster;
	}

	/**
	 * Removes the leave policy master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leavePolicyMasterId the primary key of the leave policy master
	 * @return the leave policy master that was removed
	 * @throws NoSuchLeavePolicyMasterException if a leave policy master with the primary key could not be found
	 */
	@Override
	public LeavePolicyMaster remove(long leavePolicyMasterId)
		throws NoSuchLeavePolicyMasterException {

		return remove((Serializable)leavePolicyMasterId);
	}

	/**
	 * Removes the leave policy master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave policy master
	 * @return the leave policy master that was removed
	 * @throws NoSuchLeavePolicyMasterException if a leave policy master with the primary key could not be found
	 */
	@Override
	public LeavePolicyMaster remove(Serializable primaryKey)
		throws NoSuchLeavePolicyMasterException {

		Session session = null;

		try {
			session = openSession();

			LeavePolicyMaster leavePolicyMaster =
				(LeavePolicyMaster)session.get(
					LeavePolicyMasterImpl.class, primaryKey);

			if (leavePolicyMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeavePolicyMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(leavePolicyMaster);
		}
		catch (NoSuchLeavePolicyMasterException noSuchEntityException) {
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
	protected LeavePolicyMaster removeImpl(
		LeavePolicyMaster leavePolicyMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leavePolicyMaster)) {
				leavePolicyMaster = (LeavePolicyMaster)session.get(
					LeavePolicyMasterImpl.class,
					leavePolicyMaster.getPrimaryKeyObj());
			}

			if (leavePolicyMaster != null) {
				session.delete(leavePolicyMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (leavePolicyMaster != null) {
			clearCache(leavePolicyMaster);
		}

		return leavePolicyMaster;
	}

	@Override
	public LeavePolicyMaster updateImpl(LeavePolicyMaster leavePolicyMaster) {
		boolean isNew = leavePolicyMaster.isNew();

		if (!(leavePolicyMaster instanceof LeavePolicyMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(leavePolicyMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					leavePolicyMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in leavePolicyMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LeavePolicyMaster implementation " +
					leavePolicyMaster.getClass());
		}

		LeavePolicyMasterModelImpl leavePolicyMasterModelImpl =
			(LeavePolicyMasterModelImpl)leavePolicyMaster;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (leavePolicyMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				leavePolicyMaster.setCreateDate(date);
			}
			else {
				leavePolicyMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!leavePolicyMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				leavePolicyMaster.setModifiedDate(date);
			}
			else {
				leavePolicyMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(leavePolicyMaster);
			}
			else {
				leavePolicyMaster = (LeavePolicyMaster)session.merge(
					leavePolicyMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LeavePolicyMasterImpl.class, leavePolicyMasterModelImpl, false,
			true);

		cacheUniqueFindersCache(leavePolicyMasterModelImpl);

		if (isNew) {
			leavePolicyMaster.setNew(false);
		}

		leavePolicyMaster.resetOriginalValues();

		return leavePolicyMaster;
	}

	/**
	 * Returns the leave policy master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave policy master
	 * @return the leave policy master
	 * @throws NoSuchLeavePolicyMasterException if a leave policy master with the primary key could not be found
	 */
	@Override
	public LeavePolicyMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeavePolicyMasterException {

		LeavePolicyMaster leavePolicyMaster = fetchByPrimaryKey(primaryKey);

		if (leavePolicyMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeavePolicyMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return leavePolicyMaster;
	}

	/**
	 * Returns the leave policy master with the primary key or throws a <code>NoSuchLeavePolicyMasterException</code> if it could not be found.
	 *
	 * @param leavePolicyMasterId the primary key of the leave policy master
	 * @return the leave policy master
	 * @throws NoSuchLeavePolicyMasterException if a leave policy master with the primary key could not be found
	 */
	@Override
	public LeavePolicyMaster findByPrimaryKey(long leavePolicyMasterId)
		throws NoSuchLeavePolicyMasterException {

		return findByPrimaryKey((Serializable)leavePolicyMasterId);
	}

	/**
	 * Returns the leave policy master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leavePolicyMasterId the primary key of the leave policy master
	 * @return the leave policy master, or <code>null</code> if a leave policy master with the primary key could not be found
	 */
	@Override
	public LeavePolicyMaster fetchByPrimaryKey(long leavePolicyMasterId) {
		return fetchByPrimaryKey((Serializable)leavePolicyMasterId);
	}

	/**
	 * Returns all the leave policy masters.
	 *
	 * @return the leave policy masters
	 */
	@Override
	public List<LeavePolicyMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave policy masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeavePolicyMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave policy masters
	 * @param end the upper bound of the range of leave policy masters (not inclusive)
	 * @return the range of leave policy masters
	 */
	@Override
	public List<LeavePolicyMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave policy masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeavePolicyMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave policy masters
	 * @param end the upper bound of the range of leave policy masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave policy masters
	 */
	@Override
	public List<LeavePolicyMaster> findAll(
		int start, int end,
		OrderByComparator<LeavePolicyMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave policy masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeavePolicyMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave policy masters
	 * @param end the upper bound of the range of leave policy masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave policy masters
	 */
	@Override
	public List<LeavePolicyMaster> findAll(
		int start, int end,
		OrderByComparator<LeavePolicyMaster> orderByComparator,
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

		List<LeavePolicyMaster> list = null;

		if (useFinderCache) {
			list = (List<LeavePolicyMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LEAVEPOLICYMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVEPOLICYMASTER;

				sql = sql.concat(LeavePolicyMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LeavePolicyMaster>)QueryUtil.list(
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
	 * Removes all the leave policy masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LeavePolicyMaster leavePolicyMaster : findAll()) {
			remove(leavePolicyMaster);
		}
	}

	/**
	 * Returns the number of leave policy masters.
	 *
	 * @return the number of leave policy masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LEAVEPOLICYMASTER);

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
		return "leavePolicyMasterId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEAVEPOLICYMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LeavePolicyMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leave policy master persistence.
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

		_finderPathFetchByLeaveTypeMasterId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByLeaveTypeMasterId",
			new String[] {Long.class.getName()},
			new String[] {"leaveTypeMasterId"}, true);

		_finderPathCountByLeaveTypeMasterId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLeaveTypeMasterId", new String[] {Long.class.getName()},
			new String[] {"leaveTypeMasterId"}, false);

		_finderPathFetchByLeaveTypeMasterIdAndYear = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByLeaveTypeMasterIdAndYear",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"leaveTypeMasterId", "yearOfPolicy"}, true);

		_finderPathCountByLeaveTypeMasterIdAndYear = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLeaveTypeMasterIdAndYear",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"leaveTypeMasterId", "yearOfPolicy"}, false);

		_finderPathWithPaginationFindByYear = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByYear",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"yearOfPolicy"}, true);

		_finderPathWithoutPaginationFindByYear = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByYear",
			new String[] {Integer.class.getName()},
			new String[] {"yearOfPolicy"}, true);

		_finderPathCountByYear = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByYear",
			new String[] {Integer.class.getName()},
			new String[] {"yearOfPolicy"}, false);

		_finderPathFetchByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName()
				},
				new String[] {
					"leaveTypeMasterId", "yearOfPolicy", "eligibleAfterMonths"
				},
				true);

		_finderPathCountByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName()
				},
				new String[] {
					"leaveTypeMasterId", "yearOfPolicy", "eligibleAfterMonths"
				},
				false);

		LeavePolicyMasterUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		LeavePolicyMasterUtil.setPersistence(null);

		entityCache.removeCache(LeavePolicyMasterImpl.class.getName());
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

	private static final String _SQL_SELECT_LEAVEPOLICYMASTER =
		"SELECT leavePolicyMaster FROM LeavePolicyMaster leavePolicyMaster";

	private static final String _SQL_SELECT_LEAVEPOLICYMASTER_WHERE =
		"SELECT leavePolicyMaster FROM LeavePolicyMaster leavePolicyMaster WHERE ";

	private static final String _SQL_COUNT_LEAVEPOLICYMASTER =
		"SELECT COUNT(leavePolicyMaster) FROM LeavePolicyMaster leavePolicyMaster";

	private static final String _SQL_COUNT_LEAVEPOLICYMASTER_WHERE =
		"SELECT COUNT(leavePolicyMaster) FROM LeavePolicyMaster leavePolicyMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "leavePolicyMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LeavePolicyMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LeavePolicyMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LeavePolicyMasterPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}