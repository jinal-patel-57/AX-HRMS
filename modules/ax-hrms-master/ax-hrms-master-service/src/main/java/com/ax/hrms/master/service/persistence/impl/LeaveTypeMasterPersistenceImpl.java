/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence.impl;

import com.ax.hrms.master.exception.NoSuchLeaveTypeMasterException;
import com.ax.hrms.master.model.LeaveTypeMaster;
import com.ax.hrms.master.model.LeaveTypeMasterTable;
import com.ax.hrms.master.model.impl.LeaveTypeMasterImpl;
import com.ax.hrms.master.model.impl.LeaveTypeMasterModelImpl;
import com.ax.hrms.master.service.persistence.LeaveTypeMasterPersistence;
import com.ax.hrms.master.service.persistence.LeaveTypeMasterUtil;
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
 * The persistence implementation for the leave type master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LeaveTypeMasterPersistence.class)
public class LeaveTypeMasterPersistenceImpl
	extends BasePersistenceImpl<LeaveTypeMaster>
	implements LeaveTypeMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LeaveTypeMasterUtil</code> to access the leave type master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LeaveTypeMasterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByLeaveTypeName;
	private FinderPath _finderPathCountByLeaveTypeName;

	/**
	 * Returns the leave type master where leaveTypeName = &#63; or throws a <code>NoSuchLeaveTypeMasterException</code> if it could not be found.
	 *
	 * @param leaveTypeName the leave type name
	 * @return the matching leave type master
	 * @throws NoSuchLeaveTypeMasterException if a matching leave type master could not be found
	 */
	@Override
	public LeaveTypeMaster findByLeaveTypeName(String leaveTypeName)
		throws NoSuchLeaveTypeMasterException {

		LeaveTypeMaster leaveTypeMaster = fetchByLeaveTypeName(leaveTypeName);

		if (leaveTypeMaster == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("leaveTypeName=");
			sb.append(leaveTypeName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLeaveTypeMasterException(sb.toString());
		}

		return leaveTypeMaster;
	}

	/**
	 * Returns the leave type master where leaveTypeName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveTypeName the leave type name
	 * @return the matching leave type master, or <code>null</code> if a matching leave type master could not be found
	 */
	@Override
	public LeaveTypeMaster fetchByLeaveTypeName(String leaveTypeName) {
		return fetchByLeaveTypeName(leaveTypeName, true);
	}

	/**
	 * Returns the leave type master where leaveTypeName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveTypeName the leave type name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave type master, or <code>null</code> if a matching leave type master could not be found
	 */
	@Override
	public LeaveTypeMaster fetchByLeaveTypeName(
		String leaveTypeName, boolean useFinderCache) {

		leaveTypeName = Objects.toString(leaveTypeName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {leaveTypeName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByLeaveTypeName, finderArgs, this);
		}

		if (result instanceof LeaveTypeMaster) {
			LeaveTypeMaster leaveTypeMaster = (LeaveTypeMaster)result;

			if (!Objects.equals(
					leaveTypeName, leaveTypeMaster.getLeaveTypeName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_LEAVETYPEMASTER_WHERE);

			boolean bindLeaveTypeName = false;

			if (leaveTypeName.isEmpty()) {
				sb.append(_FINDER_COLUMN_LEAVETYPENAME_LEAVETYPENAME_3);
			}
			else {
				bindLeaveTypeName = true;

				sb.append(_FINDER_COLUMN_LEAVETYPENAME_LEAVETYPENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLeaveTypeName) {
					queryPos.add(StringUtil.toLowerCase(leaveTypeName));
				}

				List<LeaveTypeMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByLeaveTypeName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {leaveTypeName};
							}

							_log.warn(
								"LeaveTypeMasterPersistenceImpl.fetchByLeaveTypeName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LeaveTypeMaster leaveTypeMaster = list.get(0);

					result = leaveTypeMaster;

					cacheResult(leaveTypeMaster);
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
			return (LeaveTypeMaster)result;
		}
	}

	/**
	 * Removes the leave type master where leaveTypeName = &#63; from the database.
	 *
	 * @param leaveTypeName the leave type name
	 * @return the leave type master that was removed
	 */
	@Override
	public LeaveTypeMaster removeByLeaveTypeName(String leaveTypeName)
		throws NoSuchLeaveTypeMasterException {

		LeaveTypeMaster leaveTypeMaster = findByLeaveTypeName(leaveTypeName);

		return remove(leaveTypeMaster);
	}

	/**
	 * Returns the number of leave type masters where leaveTypeName = &#63;.
	 *
	 * @param leaveTypeName the leave type name
	 * @return the number of matching leave type masters
	 */
	@Override
	public int countByLeaveTypeName(String leaveTypeName) {
		leaveTypeName = Objects.toString(leaveTypeName, "");

		FinderPath finderPath = _finderPathCountByLeaveTypeName;

		Object[] finderArgs = new Object[] {leaveTypeName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVETYPEMASTER_WHERE);

			boolean bindLeaveTypeName = false;

			if (leaveTypeName.isEmpty()) {
				sb.append(_FINDER_COLUMN_LEAVETYPENAME_LEAVETYPENAME_3);
			}
			else {
				bindLeaveTypeName = true;

				sb.append(_FINDER_COLUMN_LEAVETYPENAME_LEAVETYPENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLeaveTypeName) {
					queryPos.add(StringUtil.toLowerCase(leaveTypeName));
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

	private static final String _FINDER_COLUMN_LEAVETYPENAME_LEAVETYPENAME_2 =
		"lower(leaveTypeMaster.leaveTypeName) = ?";

	private static final String _FINDER_COLUMN_LEAVETYPENAME_LEAVETYPENAME_3 =
		"(leaveTypeMaster.leaveTypeName IS NULL OR leaveTypeMaster.leaveTypeName = '')";

	private FinderPath _finderPathFetchByLeaveTypeMasterId;
	private FinderPath _finderPathCountByLeaveTypeMasterId;

	/**
	 * Returns the leave type master where leaveTypeMasterId = &#63; or throws a <code>NoSuchLeaveTypeMasterException</code> if it could not be found.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the matching leave type master
	 * @throws NoSuchLeaveTypeMasterException if a matching leave type master could not be found
	 */
	@Override
	public LeaveTypeMaster findByLeaveTypeMasterId(long leaveTypeMasterId)
		throws NoSuchLeaveTypeMasterException {

		LeaveTypeMaster leaveTypeMaster = fetchByLeaveTypeMasterId(
			leaveTypeMasterId);

		if (leaveTypeMaster == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("leaveTypeMasterId=");
			sb.append(leaveTypeMasterId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLeaveTypeMasterException(sb.toString());
		}

		return leaveTypeMaster;
	}

	/**
	 * Returns the leave type master where leaveTypeMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the matching leave type master, or <code>null</code> if a matching leave type master could not be found
	 */
	@Override
	public LeaveTypeMaster fetchByLeaveTypeMasterId(long leaveTypeMasterId) {
		return fetchByLeaveTypeMasterId(leaveTypeMasterId, true);
	}

	/**
	 * Returns the leave type master where leaveTypeMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave type master, or <code>null</code> if a matching leave type master could not be found
	 */
	@Override
	public LeaveTypeMaster fetchByLeaveTypeMasterId(
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

		if (result instanceof LeaveTypeMaster) {
			LeaveTypeMaster leaveTypeMaster = (LeaveTypeMaster)result;

			if (leaveTypeMasterId != leaveTypeMaster.getLeaveTypeMasterId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_LEAVETYPEMASTER_WHERE);

			sb.append(_FINDER_COLUMN_LEAVETYPEMASTERID_LEAVETYPEMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(leaveTypeMasterId);

				List<LeaveTypeMaster> list = query.list();

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
								"LeaveTypeMasterPersistenceImpl.fetchByLeaveTypeMasterId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LeaveTypeMaster leaveTypeMaster = list.get(0);

					result = leaveTypeMaster;

					cacheResult(leaveTypeMaster);
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
			return (LeaveTypeMaster)result;
		}
	}

	/**
	 * Removes the leave type master where leaveTypeMasterId = &#63; from the database.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the leave type master that was removed
	 */
	@Override
	public LeaveTypeMaster removeByLeaveTypeMasterId(long leaveTypeMasterId)
		throws NoSuchLeaveTypeMasterException {

		LeaveTypeMaster leaveTypeMaster = findByLeaveTypeMasterId(
			leaveTypeMasterId);

		return remove(leaveTypeMaster);
	}

	/**
	 * Returns the number of leave type masters where leaveTypeMasterId = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the number of matching leave type masters
	 */
	@Override
	public int countByLeaveTypeMasterId(long leaveTypeMasterId) {
		FinderPath finderPath = _finderPathCountByLeaveTypeMasterId;

		Object[] finderArgs = new Object[] {leaveTypeMasterId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVETYPEMASTER_WHERE);

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
			"leaveTypeMaster.leaveTypeMasterId = ?";

	private FinderPath _finderPathWithPaginationFindByActiveAndAppearForAll;
	private FinderPath _finderPathWithoutPaginationFindByActiveAndAppearForAll;
	private FinderPath _finderPathCountByActiveAndAppearForAll;

	/**
	 * Returns all the leave type masters where isActive = &#63; and isAppearForAll = &#63;.
	 *
	 * @param isActive the is active
	 * @param isAppearForAll the is appear for all
	 * @return the matching leave type masters
	 */
	@Override
	public List<LeaveTypeMaster> findByActiveAndAppearForAll(
		boolean isActive, boolean isAppearForAll) {

		return findByActiveAndAppearForAll(
			isActive, isAppearForAll, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the leave type masters where isActive = &#63; and isAppearForAll = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param isAppearForAll the is appear for all
	 * @param start the lower bound of the range of leave type masters
	 * @param end the upper bound of the range of leave type masters (not inclusive)
	 * @return the range of matching leave type masters
	 */
	@Override
	public List<LeaveTypeMaster> findByActiveAndAppearForAll(
		boolean isActive, boolean isAppearForAll, int start, int end) {

		return findByActiveAndAppearForAll(
			isActive, isAppearForAll, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave type masters where isActive = &#63; and isAppearForAll = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param isAppearForAll the is appear for all
	 * @param start the lower bound of the range of leave type masters
	 * @param end the upper bound of the range of leave type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave type masters
	 */
	@Override
	public List<LeaveTypeMaster> findByActiveAndAppearForAll(
		boolean isActive, boolean isAppearForAll, int start, int end,
		OrderByComparator<LeaveTypeMaster> orderByComparator) {

		return findByActiveAndAppearForAll(
			isActive, isAppearForAll, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave type masters where isActive = &#63; and isAppearForAll = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param isAppearForAll the is appear for all
	 * @param start the lower bound of the range of leave type masters
	 * @param end the upper bound of the range of leave type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave type masters
	 */
	@Override
	public List<LeaveTypeMaster> findByActiveAndAppearForAll(
		boolean isActive, boolean isAppearForAll, int start, int end,
		OrderByComparator<LeaveTypeMaster> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByActiveAndAppearForAll;
				finderArgs = new Object[] {isActive, isAppearForAll};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByActiveAndAppearForAll;
			finderArgs = new Object[] {
				isActive, isAppearForAll, start, end, orderByComparator
			};
		}

		List<LeaveTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<LeaveTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveTypeMaster leaveTypeMaster : list) {
					if ((isActive != leaveTypeMaster.isIsActive()) ||
						(isAppearForAll !=
							leaveTypeMaster.isIsAppearForAll())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_LEAVETYPEMASTER_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVEANDAPPEARFORALL_ISACTIVE_2);

			sb.append(_FINDER_COLUMN_ACTIVEANDAPPEARFORALL_ISAPPEARFORALL_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LeaveTypeMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isActive);

				queryPos.add(isAppearForAll);

				list = (List<LeaveTypeMaster>)QueryUtil.list(
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
	 * Returns the first leave type master in the ordered set where isActive = &#63; and isAppearForAll = &#63;.
	 *
	 * @param isActive the is active
	 * @param isAppearForAll the is appear for all
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type master
	 * @throws NoSuchLeaveTypeMasterException if a matching leave type master could not be found
	 */
	@Override
	public LeaveTypeMaster findByActiveAndAppearForAll_First(
			boolean isActive, boolean isAppearForAll,
			OrderByComparator<LeaveTypeMaster> orderByComparator)
		throws NoSuchLeaveTypeMasterException {

		LeaveTypeMaster leaveTypeMaster = fetchByActiveAndAppearForAll_First(
			isActive, isAppearForAll, orderByComparator);

		if (leaveTypeMaster != null) {
			return leaveTypeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isActive=");
		sb.append(isActive);

		sb.append(", isAppearForAll=");
		sb.append(isAppearForAll);

		sb.append("}");

		throw new NoSuchLeaveTypeMasterException(sb.toString());
	}

	/**
	 * Returns the first leave type master in the ordered set where isActive = &#63; and isAppearForAll = &#63;.
	 *
	 * @param isActive the is active
	 * @param isAppearForAll the is appear for all
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type master, or <code>null</code> if a matching leave type master could not be found
	 */
	@Override
	public LeaveTypeMaster fetchByActiveAndAppearForAll_First(
		boolean isActive, boolean isAppearForAll,
		OrderByComparator<LeaveTypeMaster> orderByComparator) {

		List<LeaveTypeMaster> list = findByActiveAndAppearForAll(
			isActive, isAppearForAll, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave type master in the ordered set where isActive = &#63; and isAppearForAll = &#63;.
	 *
	 * @param isActive the is active
	 * @param isAppearForAll the is appear for all
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type master
	 * @throws NoSuchLeaveTypeMasterException if a matching leave type master could not be found
	 */
	@Override
	public LeaveTypeMaster findByActiveAndAppearForAll_Last(
			boolean isActive, boolean isAppearForAll,
			OrderByComparator<LeaveTypeMaster> orderByComparator)
		throws NoSuchLeaveTypeMasterException {

		LeaveTypeMaster leaveTypeMaster = fetchByActiveAndAppearForAll_Last(
			isActive, isAppearForAll, orderByComparator);

		if (leaveTypeMaster != null) {
			return leaveTypeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isActive=");
		sb.append(isActive);

		sb.append(", isAppearForAll=");
		sb.append(isAppearForAll);

		sb.append("}");

		throw new NoSuchLeaveTypeMasterException(sb.toString());
	}

	/**
	 * Returns the last leave type master in the ordered set where isActive = &#63; and isAppearForAll = &#63;.
	 *
	 * @param isActive the is active
	 * @param isAppearForAll the is appear for all
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type master, or <code>null</code> if a matching leave type master could not be found
	 */
	@Override
	public LeaveTypeMaster fetchByActiveAndAppearForAll_Last(
		boolean isActive, boolean isAppearForAll,
		OrderByComparator<LeaveTypeMaster> orderByComparator) {

		int count = countByActiveAndAppearForAll(isActive, isAppearForAll);

		if (count == 0) {
			return null;
		}

		List<LeaveTypeMaster> list = findByActiveAndAppearForAll(
			isActive, isAppearForAll, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave type masters before and after the current leave type master in the ordered set where isActive = &#63; and isAppearForAll = &#63;.
	 *
	 * @param leaveTypeMasterId the primary key of the current leave type master
	 * @param isActive the is active
	 * @param isAppearForAll the is appear for all
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave type master
	 * @throws NoSuchLeaveTypeMasterException if a leave type master with the primary key could not be found
	 */
	@Override
	public LeaveTypeMaster[] findByActiveAndAppearForAll_PrevAndNext(
			long leaveTypeMasterId, boolean isActive, boolean isAppearForAll,
			OrderByComparator<LeaveTypeMaster> orderByComparator)
		throws NoSuchLeaveTypeMasterException {

		LeaveTypeMaster leaveTypeMaster = findByPrimaryKey(leaveTypeMasterId);

		Session session = null;

		try {
			session = openSession();

			LeaveTypeMaster[] array = new LeaveTypeMasterImpl[3];

			array[0] = getByActiveAndAppearForAll_PrevAndNext(
				session, leaveTypeMaster, isActive, isAppearForAll,
				orderByComparator, true);

			array[1] = leaveTypeMaster;

			array[2] = getByActiveAndAppearForAll_PrevAndNext(
				session, leaveTypeMaster, isActive, isAppearForAll,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveTypeMaster getByActiveAndAppearForAll_PrevAndNext(
		Session session, LeaveTypeMaster leaveTypeMaster, boolean isActive,
		boolean isAppearForAll,
		OrderByComparator<LeaveTypeMaster> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LEAVETYPEMASTER_WHERE);

		sb.append(_FINDER_COLUMN_ACTIVEANDAPPEARFORALL_ISACTIVE_2);

		sb.append(_FINDER_COLUMN_ACTIVEANDAPPEARFORALL_ISAPPEARFORALL_2);

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
			sb.append(LeaveTypeMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isActive);

		queryPos.add(isAppearForAll);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						leaveTypeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveTypeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave type masters where isActive = &#63; and isAppearForAll = &#63; from the database.
	 *
	 * @param isActive the is active
	 * @param isAppearForAll the is appear for all
	 */
	@Override
	public void removeByActiveAndAppearForAll(
		boolean isActive, boolean isAppearForAll) {

		for (LeaveTypeMaster leaveTypeMaster :
				findByActiveAndAppearForAll(
					isActive, isAppearForAll, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(leaveTypeMaster);
		}
	}

	/**
	 * Returns the number of leave type masters where isActive = &#63; and isAppearForAll = &#63;.
	 *
	 * @param isActive the is active
	 * @param isAppearForAll the is appear for all
	 * @return the number of matching leave type masters
	 */
	@Override
	public int countByActiveAndAppearForAll(
		boolean isActive, boolean isAppearForAll) {

		FinderPath finderPath = _finderPathCountByActiveAndAppearForAll;

		Object[] finderArgs = new Object[] {isActive, isAppearForAll};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVETYPEMASTER_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVEANDAPPEARFORALL_ISACTIVE_2);

			sb.append(_FINDER_COLUMN_ACTIVEANDAPPEARFORALL_ISAPPEARFORALL_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isActive);

				queryPos.add(isAppearForAll);

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
		_FINDER_COLUMN_ACTIVEANDAPPEARFORALL_ISACTIVE_2 =
			"leaveTypeMaster.isActive = ? AND ";

	private static final String
		_FINDER_COLUMN_ACTIVEANDAPPEARFORALL_ISAPPEARFORALL_2 =
			"leaveTypeMaster.isAppearForAll = ?";

	public LeaveTypeMasterPersistenceImpl() {
		setModelClass(LeaveTypeMaster.class);

		setModelImplClass(LeaveTypeMasterImpl.class);
		setModelPKClass(long.class);

		setTable(LeaveTypeMasterTable.INSTANCE);
	}

	/**
	 * Caches the leave type master in the entity cache if it is enabled.
	 *
	 * @param leaveTypeMaster the leave type master
	 */
	@Override
	public void cacheResult(LeaveTypeMaster leaveTypeMaster) {
		entityCache.putResult(
			LeaveTypeMasterImpl.class, leaveTypeMaster.getPrimaryKey(),
			leaveTypeMaster);

		finderCache.putResult(
			_finderPathFetchByLeaveTypeName,
			new Object[] {leaveTypeMaster.getLeaveTypeName()}, leaveTypeMaster);

		finderCache.putResult(
			_finderPathFetchByLeaveTypeMasterId,
			new Object[] {leaveTypeMaster.getLeaveTypeMasterId()},
			leaveTypeMaster);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the leave type masters in the entity cache if it is enabled.
	 *
	 * @param leaveTypeMasters the leave type masters
	 */
	@Override
	public void cacheResult(List<LeaveTypeMaster> leaveTypeMasters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (leaveTypeMasters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LeaveTypeMaster leaveTypeMaster : leaveTypeMasters) {
			if (entityCache.getResult(
					LeaveTypeMasterImpl.class,
					leaveTypeMaster.getPrimaryKey()) == null) {

				cacheResult(leaveTypeMaster);
			}
		}
	}

	/**
	 * Clears the cache for all leave type masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LeaveTypeMasterImpl.class);

		finderCache.clearCache(LeaveTypeMasterImpl.class);
	}

	/**
	 * Clears the cache for the leave type master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveTypeMaster leaveTypeMaster) {
		entityCache.removeResult(LeaveTypeMasterImpl.class, leaveTypeMaster);
	}

	@Override
	public void clearCache(List<LeaveTypeMaster> leaveTypeMasters) {
		for (LeaveTypeMaster leaveTypeMaster : leaveTypeMasters) {
			entityCache.removeResult(
				LeaveTypeMasterImpl.class, leaveTypeMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LeaveTypeMasterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LeaveTypeMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LeaveTypeMasterModelImpl leaveTypeMasterModelImpl) {

		Object[] args = new Object[] {
			leaveTypeMasterModelImpl.getLeaveTypeName()
		};

		finderCache.putResult(
			_finderPathCountByLeaveTypeName, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByLeaveTypeName, args, leaveTypeMasterModelImpl);

		args = new Object[] {leaveTypeMasterModelImpl.getLeaveTypeMasterId()};

		finderCache.putResult(
			_finderPathCountByLeaveTypeMasterId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByLeaveTypeMasterId, args,
			leaveTypeMasterModelImpl);
	}

	/**
	 * Creates a new leave type master with the primary key. Does not add the leave type master to the database.
	 *
	 * @param leaveTypeMasterId the primary key for the new leave type master
	 * @return the new leave type master
	 */
	@Override
	public LeaveTypeMaster create(long leaveTypeMasterId) {
		LeaveTypeMaster leaveTypeMaster = new LeaveTypeMasterImpl();

		leaveTypeMaster.setNew(true);
		leaveTypeMaster.setPrimaryKey(leaveTypeMasterId);

		leaveTypeMaster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return leaveTypeMaster;
	}

	/**
	 * Removes the leave type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveTypeMasterId the primary key of the leave type master
	 * @return the leave type master that was removed
	 * @throws NoSuchLeaveTypeMasterException if a leave type master with the primary key could not be found
	 */
	@Override
	public LeaveTypeMaster remove(long leaveTypeMasterId)
		throws NoSuchLeaveTypeMasterException {

		return remove((Serializable)leaveTypeMasterId);
	}

	/**
	 * Removes the leave type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave type master
	 * @return the leave type master that was removed
	 * @throws NoSuchLeaveTypeMasterException if a leave type master with the primary key could not be found
	 */
	@Override
	public LeaveTypeMaster remove(Serializable primaryKey)
		throws NoSuchLeaveTypeMasterException {

		Session session = null;

		try {
			session = openSession();

			LeaveTypeMaster leaveTypeMaster = (LeaveTypeMaster)session.get(
				LeaveTypeMasterImpl.class, primaryKey);

			if (leaveTypeMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveTypeMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(leaveTypeMaster);
		}
		catch (NoSuchLeaveTypeMasterException noSuchEntityException) {
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
	protected LeaveTypeMaster removeImpl(LeaveTypeMaster leaveTypeMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveTypeMaster)) {
				leaveTypeMaster = (LeaveTypeMaster)session.get(
					LeaveTypeMasterImpl.class,
					leaveTypeMaster.getPrimaryKeyObj());
			}

			if (leaveTypeMaster != null) {
				session.delete(leaveTypeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (leaveTypeMaster != null) {
			clearCache(leaveTypeMaster);
		}

		return leaveTypeMaster;
	}

	@Override
	public LeaveTypeMaster updateImpl(LeaveTypeMaster leaveTypeMaster) {
		boolean isNew = leaveTypeMaster.isNew();

		if (!(leaveTypeMaster instanceof LeaveTypeMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(leaveTypeMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					leaveTypeMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in leaveTypeMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LeaveTypeMaster implementation " +
					leaveTypeMaster.getClass());
		}

		LeaveTypeMasterModelImpl leaveTypeMasterModelImpl =
			(LeaveTypeMasterModelImpl)leaveTypeMaster;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (leaveTypeMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				leaveTypeMaster.setCreateDate(date);
			}
			else {
				leaveTypeMaster.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!leaveTypeMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				leaveTypeMaster.setModifiedDate(date);
			}
			else {
				leaveTypeMaster.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(leaveTypeMaster);
			}
			else {
				leaveTypeMaster = (LeaveTypeMaster)session.merge(
					leaveTypeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LeaveTypeMasterImpl.class, leaveTypeMasterModelImpl, false, true);

		cacheUniqueFindersCache(leaveTypeMasterModelImpl);

		if (isNew) {
			leaveTypeMaster.setNew(false);
		}

		leaveTypeMaster.resetOriginalValues();

		return leaveTypeMaster;
	}

	/**
	 * Returns the leave type master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave type master
	 * @return the leave type master
	 * @throws NoSuchLeaveTypeMasterException if a leave type master with the primary key could not be found
	 */
	@Override
	public LeaveTypeMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveTypeMasterException {

		LeaveTypeMaster leaveTypeMaster = fetchByPrimaryKey(primaryKey);

		if (leaveTypeMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveTypeMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return leaveTypeMaster;
	}

	/**
	 * Returns the leave type master with the primary key or throws a <code>NoSuchLeaveTypeMasterException</code> if it could not be found.
	 *
	 * @param leaveTypeMasterId the primary key of the leave type master
	 * @return the leave type master
	 * @throws NoSuchLeaveTypeMasterException if a leave type master with the primary key could not be found
	 */
	@Override
	public LeaveTypeMaster findByPrimaryKey(long leaveTypeMasterId)
		throws NoSuchLeaveTypeMasterException {

		return findByPrimaryKey((Serializable)leaveTypeMasterId);
	}

	/**
	 * Returns the leave type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveTypeMasterId the primary key of the leave type master
	 * @return the leave type master, or <code>null</code> if a leave type master with the primary key could not be found
	 */
	@Override
	public LeaveTypeMaster fetchByPrimaryKey(long leaveTypeMasterId) {
		return fetchByPrimaryKey((Serializable)leaveTypeMasterId);
	}

	/**
	 * Returns all the leave type masters.
	 *
	 * @return the leave type masters
	 */
	@Override
	public List<LeaveTypeMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave type masters
	 * @param end the upper bound of the range of leave type masters (not inclusive)
	 * @return the range of leave type masters
	 */
	@Override
	public List<LeaveTypeMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave type masters
	 * @param end the upper bound of the range of leave type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave type masters
	 */
	@Override
	public List<LeaveTypeMaster> findAll(
		int start, int end,
		OrderByComparator<LeaveTypeMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave type masters
	 * @param end the upper bound of the range of leave type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave type masters
	 */
	@Override
	public List<LeaveTypeMaster> findAll(
		int start, int end,
		OrderByComparator<LeaveTypeMaster> orderByComparator,
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

		List<LeaveTypeMaster> list = null;

		if (useFinderCache) {
			list = (List<LeaveTypeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LEAVETYPEMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVETYPEMASTER;

				sql = sql.concat(LeaveTypeMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LeaveTypeMaster>)QueryUtil.list(
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
	 * Removes all the leave type masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LeaveTypeMaster leaveTypeMaster : findAll()) {
			remove(leaveTypeMaster);
		}
	}

	/**
	 * Returns the number of leave type masters.
	 *
	 * @return the number of leave type masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LEAVETYPEMASTER);

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
		return "leaveTypeMasterId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEAVETYPEMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LeaveTypeMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leave type master persistence.
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

		_finderPathFetchByLeaveTypeName = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByLeaveTypeName",
			new String[] {String.class.getName()},
			new String[] {"leaveTypeName"}, true);

		_finderPathCountByLeaveTypeName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLeaveTypeName",
			new String[] {String.class.getName()},
			new String[] {"leaveTypeName"}, false);

		_finderPathFetchByLeaveTypeMasterId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByLeaveTypeMasterId",
			new String[] {Long.class.getName()},
			new String[] {"leaveTypeMasterId"}, true);

		_finderPathCountByLeaveTypeMasterId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLeaveTypeMasterId", new String[] {Long.class.getName()},
			new String[] {"leaveTypeMasterId"}, false);

		_finderPathWithPaginationFindByActiveAndAppearForAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByActiveAndAppearForAll",
			new String[] {
				Boolean.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"isActive", "isAppearForAll"}, true);

		_finderPathWithoutPaginationFindByActiveAndAppearForAll =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByActiveAndAppearForAll",
				new String[] {Boolean.class.getName(), Boolean.class.getName()},
				new String[] {"isActive", "isAppearForAll"}, true);

		_finderPathCountByActiveAndAppearForAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByActiveAndAppearForAll",
			new String[] {Boolean.class.getName(), Boolean.class.getName()},
			new String[] {"isActive", "isAppearForAll"}, false);

		LeaveTypeMasterUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		LeaveTypeMasterUtil.setPersistence(null);

		entityCache.removeCache(LeaveTypeMasterImpl.class.getName());
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

	private static final String _SQL_SELECT_LEAVETYPEMASTER =
		"SELECT leaveTypeMaster FROM LeaveTypeMaster leaveTypeMaster";

	private static final String _SQL_SELECT_LEAVETYPEMASTER_WHERE =
		"SELECT leaveTypeMaster FROM LeaveTypeMaster leaveTypeMaster WHERE ";

	private static final String _SQL_COUNT_LEAVETYPEMASTER =
		"SELECT COUNT(leaveTypeMaster) FROM LeaveTypeMaster leaveTypeMaster";

	private static final String _SQL_COUNT_LEAVETYPEMASTER_WHERE =
		"SELECT COUNT(leaveTypeMaster) FROM LeaveTypeMaster leaveTypeMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveTypeMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LeaveTypeMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LeaveTypeMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LeaveTypeMasterPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}