/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchLeaveBalanceException;
import com.ax.hrms.model.LeaveBalance;
import com.ax.hrms.model.LeaveBalanceTable;
import com.ax.hrms.model.impl.LeaveBalanceImpl;
import com.ax.hrms.model.impl.LeaveBalanceModelImpl;
import com.ax.hrms.service.persistence.LeaveBalancePersistence;
import com.ax.hrms.service.persistence.LeaveBalanceUtil;
import com.ax.hrms.service.persistence.impl.constants.axPersistenceConstants;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
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
 * The persistence implementation for the leave balance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LeaveBalancePersistence.class)
public class LeaveBalancePersistenceImpl
	extends BasePersistenceImpl<LeaveBalance>
	implements LeaveBalancePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LeaveBalanceUtil</code> to access the leave balance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LeaveBalanceImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the leave balances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave balances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @return the range of matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave balances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave balances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<LeaveBalance> list = null;

		if (useFinderCache) {
			list = (List<LeaveBalance>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveBalance leaveBalance : list) {
					if (!uuid.equals(leaveBalance.getUuid())) {
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

			sb.append(_SQL_SELECT_LEAVEBALANCE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LeaveBalanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<LeaveBalance>)QueryUtil.list(
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
	 * Returns the first leave balance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance findByUuid_First(
			String uuid, OrderByComparator<LeaveBalance> orderByComparator)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = fetchByUuid_First(uuid, orderByComparator);

		if (leaveBalance != null) {
			return leaveBalance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLeaveBalanceException(sb.toString());
	}

	/**
	 * Returns the first leave balance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance fetchByUuid_First(
		String uuid, OrderByComparator<LeaveBalance> orderByComparator) {

		List<LeaveBalance> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave balance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance findByUuid_Last(
			String uuid, OrderByComparator<LeaveBalance> orderByComparator)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = fetchByUuid_Last(uuid, orderByComparator);

		if (leaveBalance != null) {
			return leaveBalance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLeaveBalanceException(sb.toString());
	}

	/**
	 * Returns the last leave balance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance fetchByUuid_Last(
		String uuid, OrderByComparator<LeaveBalance> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<LeaveBalance> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave balances before and after the current leave balance in the ordered set where uuid = &#63;.
	 *
	 * @param leaveBalanceId the primary key of the current leave balance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	@Override
	public LeaveBalance[] findByUuid_PrevAndNext(
			long leaveBalanceId, String uuid,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws NoSuchLeaveBalanceException {

		uuid = Objects.toString(uuid, "");

		LeaveBalance leaveBalance = findByPrimaryKey(leaveBalanceId);

		Session session = null;

		try {
			session = openSession();

			LeaveBalance[] array = new LeaveBalanceImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, leaveBalance, uuid, orderByComparator, true);

			array[1] = leaveBalance;

			array[2] = getByUuid_PrevAndNext(
				session, leaveBalance, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveBalance getByUuid_PrevAndNext(
		Session session, LeaveBalance leaveBalance, String uuid,
		OrderByComparator<LeaveBalance> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LEAVEBALANCE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

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
			sb.append(LeaveBalanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(leaveBalance)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveBalance> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave balances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (LeaveBalance leaveBalance :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leaveBalance);
		}
	}

	/**
	 * Returns the number of leave balances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave balances
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVEBALANCE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"leaveBalance.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(leaveBalance.uuid IS NULL OR leaveBalance.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the leave balance where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveBalanceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance findByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = fetchByUUID_G(uuid, groupId);

		if (leaveBalance == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLeaveBalanceException(sb.toString());
		}

		return leaveBalance;
	}

	/**
	 * Returns the leave balance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the leave balance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof LeaveBalance) {
			LeaveBalance leaveBalance = (LeaveBalance)result;

			if (!Objects.equals(uuid, leaveBalance.getUuid()) ||
				(groupId != leaveBalance.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LEAVEBALANCE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<LeaveBalance> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					LeaveBalance leaveBalance = list.get(0);

					result = leaveBalance;

					cacheResult(leaveBalance);
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
			return (LeaveBalance)result;
		}
	}

	/**
	 * Removes the leave balance where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave balance that was removed
	 */
	@Override
	public LeaveBalance removeByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = findByUUID_G(uuid, groupId);

		return remove(leaveBalance);
	}

	/**
	 * Returns the number of leave balances where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave balances
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVEBALANCE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"leaveBalance.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(leaveBalance.uuid IS NULL OR leaveBalance.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"leaveBalance.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the leave balances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave balances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @return the range of matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave balances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave balances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<LeaveBalance> list = null;

		if (useFinderCache) {
			list = (List<LeaveBalance>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveBalance leaveBalance : list) {
					if (!uuid.equals(leaveBalance.getUuid()) ||
						(companyId != leaveBalance.getCompanyId())) {

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

			sb.append(_SQL_SELECT_LEAVEBALANCE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LeaveBalanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<LeaveBalance>)QueryUtil.list(
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
	 * Returns the first leave balance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (leaveBalance != null) {
			return leaveBalance;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLeaveBalanceException(sb.toString());
	}

	/**
	 * Returns the first leave balance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LeaveBalance> orderByComparator) {

		List<LeaveBalance> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave balance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (leaveBalance != null) {
			return leaveBalance;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLeaveBalanceException(sb.toString());
	}

	/**
	 * Returns the last leave balance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LeaveBalance> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<LeaveBalance> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave balances before and after the current leave balance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveBalanceId the primary key of the current leave balance
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	@Override
	public LeaveBalance[] findByUuid_C_PrevAndNext(
			long leaveBalanceId, String uuid, long companyId,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws NoSuchLeaveBalanceException {

		uuid = Objects.toString(uuid, "");

		LeaveBalance leaveBalance = findByPrimaryKey(leaveBalanceId);

		Session session = null;

		try {
			session = openSession();

			LeaveBalance[] array = new LeaveBalanceImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, leaveBalance, uuid, companyId, orderByComparator,
				true);

			array[1] = leaveBalance;

			array[2] = getByUuid_C_PrevAndNext(
				session, leaveBalance, uuid, companyId, orderByComparator,
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

	protected LeaveBalance getByUuid_C_PrevAndNext(
		Session session, LeaveBalance leaveBalance, String uuid, long companyId,
		OrderByComparator<LeaveBalance> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LEAVEBALANCE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(LeaveBalanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(leaveBalance)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveBalance> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave balances where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (LeaveBalance leaveBalance :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(leaveBalance);
		}
	}

	/**
	 * Returns the number of leave balances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave balances
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVEBALANCE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"leaveBalance.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(leaveBalance.uuid IS NULL OR leaveBalance.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"leaveBalance.companyId = ?";

	private FinderPath _finderPathFetchByEmployeeIdAndLeaveTypeMasterId;
	private FinderPath _finderPathCountByEmployeeIdAndLeaveTypeMasterId;

	/**
	 * Returns the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; or throws a <code>NoSuchLeaveBalanceException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance findByEmployeeIdAndLeaveTypeMasterId(
			long employeeId, long leaveTypeMasterId)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = fetchByEmployeeIdAndLeaveTypeMasterId(
			employeeId, leaveTypeMasterId);

		if (leaveBalance == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("employeeId=");
			sb.append(employeeId);

			sb.append(", leaveTypeMasterId=");
			sb.append(leaveTypeMasterId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLeaveBalanceException(sb.toString());
		}

		return leaveBalance;
	}

	/**
	 * Returns the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance fetchByEmployeeIdAndLeaveTypeMasterId(
		long employeeId, long leaveTypeMasterId) {

		return fetchByEmployeeIdAndLeaveTypeMasterId(
			employeeId, leaveTypeMasterId, true);
	}

	/**
	 * Returns the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance fetchByEmployeeIdAndLeaveTypeMasterId(
		long employeeId, long leaveTypeMasterId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {employeeId, leaveTypeMasterId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByEmployeeIdAndLeaveTypeMasterId, finderArgs,
				this);
		}

		if (result instanceof LeaveBalance) {
			LeaveBalance leaveBalance = (LeaveBalance)result;

			if ((employeeId != leaveBalance.getEmployeeId()) ||
				(leaveTypeMasterId != leaveBalance.getLeaveTypeMasterId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LEAVEBALANCE_WHERE);

			sb.append(
				_FINDER_COLUMN_EMPLOYEEIDANDLEAVETYPEMASTERID_EMPLOYEEID_2);

			sb.append(
				_FINDER_COLUMN_EMPLOYEEIDANDLEAVETYPEMASTERID_LEAVETYPEMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				queryPos.add(leaveTypeMasterId);

				List<LeaveBalance> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByEmployeeIdAndLeaveTypeMasterId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									employeeId, leaveTypeMasterId
								};
							}

							_log.warn(
								"LeaveBalancePersistenceImpl.fetchByEmployeeIdAndLeaveTypeMasterId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LeaveBalance leaveBalance = list.get(0);

					result = leaveBalance;

					cacheResult(leaveBalance);
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
			return (LeaveBalance)result;
		}
	}

	/**
	 * Removes the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the leave balance that was removed
	 */
	@Override
	public LeaveBalance removeByEmployeeIdAndLeaveTypeMasterId(
			long employeeId, long leaveTypeMasterId)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = findByEmployeeIdAndLeaveTypeMasterId(
			employeeId, leaveTypeMasterId);

		return remove(leaveBalance);
	}

	/**
	 * Returns the number of leave balances where employeeId = &#63; and leaveTypeMasterId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the number of matching leave balances
	 */
	@Override
	public int countByEmployeeIdAndLeaveTypeMasterId(
		long employeeId, long leaveTypeMasterId) {

		FinderPath finderPath =
			_finderPathCountByEmployeeIdAndLeaveTypeMasterId;

		Object[] finderArgs = new Object[] {employeeId, leaveTypeMasterId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVEBALANCE_WHERE);

			sb.append(
				_FINDER_COLUMN_EMPLOYEEIDANDLEAVETYPEMASTERID_EMPLOYEEID_2);

			sb.append(
				_FINDER_COLUMN_EMPLOYEEIDANDLEAVETYPEMASTERID_LEAVETYPEMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

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
		_FINDER_COLUMN_EMPLOYEEIDANDLEAVETYPEMASTERID_EMPLOYEEID_2 =
			"leaveBalance.employeeId = ? AND ";

	private static final String
		_FINDER_COLUMN_EMPLOYEEIDANDLEAVETYPEMASTERID_LEAVETYPEMASTERID_2 =
			"leaveBalance.leaveTypeMasterId = ?";

	private FinderPath _finderPathWithPaginationFindByEmployeeId;
	private FinderPath _finderPathWithoutPaginationFindByEmployeeId;
	private FinderPath _finderPathCountByEmployeeId;

	/**
	 * Returns all the leave balances where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave balances where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @return the range of matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave balances where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave balances where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEmployeeId;
				finderArgs = new Object[] {employeeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEmployeeId;
			finderArgs = new Object[] {
				employeeId, start, end, orderByComparator
			};
		}

		List<LeaveBalance> list = null;

		if (useFinderCache) {
			list = (List<LeaveBalance>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveBalance leaveBalance : list) {
					if (employeeId != leaveBalance.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_LEAVEBALANCE_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LeaveBalanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<LeaveBalance>)QueryUtil.list(
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
	 * Returns the first leave balance in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance findByEmployeeId_First(
			long employeeId, OrderByComparator<LeaveBalance> orderByComparator)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (leaveBalance != null) {
			return leaveBalance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchLeaveBalanceException(sb.toString());
	}

	/**
	 * Returns the first leave balance in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance fetchByEmployeeId_First(
		long employeeId, OrderByComparator<LeaveBalance> orderByComparator) {

		List<LeaveBalance> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave balance in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance findByEmployeeId_Last(
			long employeeId, OrderByComparator<LeaveBalance> orderByComparator)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (leaveBalance != null) {
			return leaveBalance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchLeaveBalanceException(sb.toString());
	}

	/**
	 * Returns the last leave balance in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<LeaveBalance> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<LeaveBalance> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave balances before and after the current leave balance in the ordered set where employeeId = &#63;.
	 *
	 * @param leaveBalanceId the primary key of the current leave balance
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	@Override
	public LeaveBalance[] findByEmployeeId_PrevAndNext(
			long leaveBalanceId, long employeeId,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = findByPrimaryKey(leaveBalanceId);

		Session session = null;

		try {
			session = openSession();

			LeaveBalance[] array = new LeaveBalanceImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, leaveBalance, employeeId, orderByComparator, true);

			array[1] = leaveBalance;

			array[2] = getByEmployeeId_PrevAndNext(
				session, leaveBalance, employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveBalance getByEmployeeId_PrevAndNext(
		Session session, LeaveBalance leaveBalance, long employeeId,
		OrderByComparator<LeaveBalance> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LEAVEBALANCE_WHERE);

		sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

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
			sb.append(LeaveBalanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(employeeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(leaveBalance)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveBalance> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave balances where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (LeaveBalance leaveBalance :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leaveBalance);
		}
	}

	/**
	 * Returns the number of leave balances where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching leave balances
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVEBALANCE_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 =
		"leaveBalance.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByEmployeeIdAndYear;
	private FinderPath _finderPathWithoutPaginationFindByEmployeeIdAndYear;
	private FinderPath _finderPathCountByEmployeeIdAndYear;

	/**
	 * Returns all the leave balances where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @return the matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByEmployeeIdAndYear(
		long employeeId, int year) {

		return findByEmployeeIdAndYear(
			employeeId, year, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave balances where employeeId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @return the range of matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByEmployeeIdAndYear(
		long employeeId, int year, int start, int end) {

		return findByEmployeeIdAndYear(employeeId, year, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave balances where employeeId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByEmployeeIdAndYear(
		long employeeId, int year, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator) {

		return findByEmployeeIdAndYear(
			employeeId, year, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave balances where employeeId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByEmployeeIdAndYear(
		long employeeId, int year, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByEmployeeIdAndYear;
				finderArgs = new Object[] {employeeId, year};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEmployeeIdAndYear;
			finderArgs = new Object[] {
				employeeId, year, start, end, orderByComparator
			};
		}

		List<LeaveBalance> list = null;

		if (useFinderCache) {
			list = (List<LeaveBalance>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveBalance leaveBalance : list) {
					if ((employeeId != leaveBalance.getEmployeeId()) ||
						(year != leaveBalance.getYear())) {

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

			sb.append(_SQL_SELECT_LEAVEBALANCE_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDANDYEAR_EMPLOYEEID_2);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDANDYEAR_YEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LeaveBalanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				queryPos.add(year);

				list = (List<LeaveBalance>)QueryUtil.list(
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
	 * Returns the first leave balance in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance findByEmployeeIdAndYear_First(
			long employeeId, int year,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = fetchByEmployeeIdAndYear_First(
			employeeId, year, orderByComparator);

		if (leaveBalance != null) {
			return leaveBalance;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append(", year=");
		sb.append(year);

		sb.append("}");

		throw new NoSuchLeaveBalanceException(sb.toString());
	}

	/**
	 * Returns the first leave balance in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance fetchByEmployeeIdAndYear_First(
		long employeeId, int year,
		OrderByComparator<LeaveBalance> orderByComparator) {

		List<LeaveBalance> list = findByEmployeeIdAndYear(
			employeeId, year, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave balance in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance findByEmployeeIdAndYear_Last(
			long employeeId, int year,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = fetchByEmployeeIdAndYear_Last(
			employeeId, year, orderByComparator);

		if (leaveBalance != null) {
			return leaveBalance;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append(", year=");
		sb.append(year);

		sb.append("}");

		throw new NoSuchLeaveBalanceException(sb.toString());
	}

	/**
	 * Returns the last leave balance in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance fetchByEmployeeIdAndYear_Last(
		long employeeId, int year,
		OrderByComparator<LeaveBalance> orderByComparator) {

		int count = countByEmployeeIdAndYear(employeeId, year);

		if (count == 0) {
			return null;
		}

		List<LeaveBalance> list = findByEmployeeIdAndYear(
			employeeId, year, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave balances before and after the current leave balance in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param leaveBalanceId the primary key of the current leave balance
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	@Override
	public LeaveBalance[] findByEmployeeIdAndYear_PrevAndNext(
			long leaveBalanceId, long employeeId, int year,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = findByPrimaryKey(leaveBalanceId);

		Session session = null;

		try {
			session = openSession();

			LeaveBalance[] array = new LeaveBalanceImpl[3];

			array[0] = getByEmployeeIdAndYear_PrevAndNext(
				session, leaveBalance, employeeId, year, orderByComparator,
				true);

			array[1] = leaveBalance;

			array[2] = getByEmployeeIdAndYear_PrevAndNext(
				session, leaveBalance, employeeId, year, orderByComparator,
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

	protected LeaveBalance getByEmployeeIdAndYear_PrevAndNext(
		Session session, LeaveBalance leaveBalance, long employeeId, int year,
		OrderByComparator<LeaveBalance> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LEAVEBALANCE_WHERE);

		sb.append(_FINDER_COLUMN_EMPLOYEEIDANDYEAR_EMPLOYEEID_2);

		sb.append(_FINDER_COLUMN_EMPLOYEEIDANDYEAR_YEAR_2);

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
			sb.append(LeaveBalanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(employeeId);

		queryPos.add(year);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(leaveBalance)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveBalance> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave balances where employeeId = &#63; and year = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 */
	@Override
	public void removeByEmployeeIdAndYear(long employeeId, int year) {
		for (LeaveBalance leaveBalance :
				findByEmployeeIdAndYear(
					employeeId, year, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(leaveBalance);
		}
	}

	/**
	 * Returns the number of leave balances where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @return the number of matching leave balances
	 */
	@Override
	public int countByEmployeeIdAndYear(long employeeId, int year) {
		FinderPath finderPath = _finderPathCountByEmployeeIdAndYear;

		Object[] finderArgs = new Object[] {employeeId, year};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVEBALANCE_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDANDYEAR_EMPLOYEEID_2);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDANDYEAR_YEAR_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				queryPos.add(year);

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

	private static final String _FINDER_COLUMN_EMPLOYEEIDANDYEAR_EMPLOYEEID_2 =
		"leaveBalance.employeeId = ? AND ";

	private static final String _FINDER_COLUMN_EMPLOYEEIDANDYEAR_YEAR_2 =
		"leaveBalance.year = ?";

	private FinderPath _finderPathWithPaginationFindByLeaveTypeMasterIdAndYear;
	private FinderPath
		_finderPathWithoutPaginationFindByLeaveTypeMasterIdAndYear;
	private FinderPath _finderPathCountByLeaveTypeMasterIdAndYear;

	/**
	 * Returns all the leave balances where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @return the matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int year) {

		return findByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, year, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the leave balances where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @return the range of matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int year, int start, int end) {

		return findByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, year, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave balances where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int year, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator) {

		return findByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, year, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave balances where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int year, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByLeaveTypeMasterIdAndYear;
				finderArgs = new Object[] {leaveTypeMasterId, year};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByLeaveTypeMasterIdAndYear;
			finderArgs = new Object[] {
				leaveTypeMasterId, year, start, end, orderByComparator
			};
		}

		List<LeaveBalance> list = null;

		if (useFinderCache) {
			list = (List<LeaveBalance>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveBalance leaveBalance : list) {
					if ((leaveTypeMasterId !=
							leaveBalance.getLeaveTypeMasterId()) ||
						(year != leaveBalance.getYear())) {

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

			sb.append(_SQL_SELECT_LEAVEBALANCE_WHERE);

			sb.append(
				_FINDER_COLUMN_LEAVETYPEMASTERIDANDYEAR_LEAVETYPEMASTERID_2);

			sb.append(_FINDER_COLUMN_LEAVETYPEMASTERIDANDYEAR_YEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LeaveBalanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(leaveTypeMasterId);

				queryPos.add(year);

				list = (List<LeaveBalance>)QueryUtil.list(
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
	 * Returns the first leave balance in the ordered set where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance findByLeaveTypeMasterIdAndYear_First(
			long leaveTypeMasterId, int year,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = fetchByLeaveTypeMasterIdAndYear_First(
			leaveTypeMasterId, year, orderByComparator);

		if (leaveBalance != null) {
			return leaveBalance;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("leaveTypeMasterId=");
		sb.append(leaveTypeMasterId);

		sb.append(", year=");
		sb.append(year);

		sb.append("}");

		throw new NoSuchLeaveBalanceException(sb.toString());
	}

	/**
	 * Returns the first leave balance in the ordered set where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance fetchByLeaveTypeMasterIdAndYear_First(
		long leaveTypeMasterId, int year,
		OrderByComparator<LeaveBalance> orderByComparator) {

		List<LeaveBalance> list = findByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, year, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave balance in the ordered set where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance findByLeaveTypeMasterIdAndYear_Last(
			long leaveTypeMasterId, int year,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = fetchByLeaveTypeMasterIdAndYear_Last(
			leaveTypeMasterId, year, orderByComparator);

		if (leaveBalance != null) {
			return leaveBalance;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("leaveTypeMasterId=");
		sb.append(leaveTypeMasterId);

		sb.append(", year=");
		sb.append(year);

		sb.append("}");

		throw new NoSuchLeaveBalanceException(sb.toString());
	}

	/**
	 * Returns the last leave balance in the ordered set where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance fetchByLeaveTypeMasterIdAndYear_Last(
		long leaveTypeMasterId, int year,
		OrderByComparator<LeaveBalance> orderByComparator) {

		int count = countByLeaveTypeMasterIdAndYear(leaveTypeMasterId, year);

		if (count == 0) {
			return null;
		}

		List<LeaveBalance> list = findByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, year, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave balances before and after the current leave balance in the ordered set where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param leaveBalanceId the primary key of the current leave balance
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	@Override
	public LeaveBalance[] findByLeaveTypeMasterIdAndYear_PrevAndNext(
			long leaveBalanceId, long leaveTypeMasterId, int year,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = findByPrimaryKey(leaveBalanceId);

		Session session = null;

		try {
			session = openSession();

			LeaveBalance[] array = new LeaveBalanceImpl[3];

			array[0] = getByLeaveTypeMasterIdAndYear_PrevAndNext(
				session, leaveBalance, leaveTypeMasterId, year,
				orderByComparator, true);

			array[1] = leaveBalance;

			array[2] = getByLeaveTypeMasterIdAndYear_PrevAndNext(
				session, leaveBalance, leaveTypeMasterId, year,
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

	protected LeaveBalance getByLeaveTypeMasterIdAndYear_PrevAndNext(
		Session session, LeaveBalance leaveBalance, long leaveTypeMasterId,
		int year, OrderByComparator<LeaveBalance> orderByComparator,
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

		sb.append(_SQL_SELECT_LEAVEBALANCE_WHERE);

		sb.append(_FINDER_COLUMN_LEAVETYPEMASTERIDANDYEAR_LEAVETYPEMASTERID_2);

		sb.append(_FINDER_COLUMN_LEAVETYPEMASTERIDANDYEAR_YEAR_2);

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
			sb.append(LeaveBalanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(leaveTypeMasterId);

		queryPos.add(year);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(leaveBalance)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveBalance> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave balances where leaveTypeMasterId = &#63; and year = &#63; from the database.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 */
	@Override
	public void removeByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int year) {

		for (LeaveBalance leaveBalance :
				findByLeaveTypeMasterIdAndYear(
					leaveTypeMasterId, year, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(leaveBalance);
		}
	}

	/**
	 * Returns the number of leave balances where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @return the number of matching leave balances
	 */
	@Override
	public int countByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int year) {

		FinderPath finderPath = _finderPathCountByLeaveTypeMasterIdAndYear;

		Object[] finderArgs = new Object[] {leaveTypeMasterId, year};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVEBALANCE_WHERE);

			sb.append(
				_FINDER_COLUMN_LEAVETYPEMASTERIDANDYEAR_LEAVETYPEMASTERID_2);

			sb.append(_FINDER_COLUMN_LEAVETYPEMASTERIDANDYEAR_YEAR_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(leaveTypeMasterId);

				queryPos.add(year);

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
			"leaveBalance.leaveTypeMasterId = ? AND ";

	private static final String _FINDER_COLUMN_LEAVETYPEMASTERIDANDYEAR_YEAR_2 =
		"leaveBalance.year = ?";

	private FinderPath _finderPathWithPaginationFindByYear;
	private FinderPath _finderPathWithoutPaginationFindByYear;
	private FinderPath _finderPathCountByYear;

	/**
	 * Returns all the leave balances where year = &#63;.
	 *
	 * @param year the year
	 * @return the matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByYear(int year) {
		return findByYear(year, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave balances where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @return the range of matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByYear(int year, int start, int end) {
		return findByYear(year, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave balances where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByYear(
		int year, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator) {

		return findByYear(year, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave balances where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave balances
	 */
	@Override
	public List<LeaveBalance> findByYear(
		int year, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByYear;
				finderArgs = new Object[] {year};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByYear;
			finderArgs = new Object[] {year, start, end, orderByComparator};
		}

		List<LeaveBalance> list = null;

		if (useFinderCache) {
			list = (List<LeaveBalance>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveBalance leaveBalance : list) {
					if (year != leaveBalance.getYear()) {
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

			sb.append(_SQL_SELECT_LEAVEBALANCE_WHERE);

			sb.append(_FINDER_COLUMN_YEAR_YEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LeaveBalanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(year);

				list = (List<LeaveBalance>)QueryUtil.list(
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
	 * Returns the first leave balance in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance findByYear_First(
			int year, OrderByComparator<LeaveBalance> orderByComparator)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = fetchByYear_First(year, orderByComparator);

		if (leaveBalance != null) {
			return leaveBalance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("year=");
		sb.append(year);

		sb.append("}");

		throw new NoSuchLeaveBalanceException(sb.toString());
	}

	/**
	 * Returns the first leave balance in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance fetchByYear_First(
		int year, OrderByComparator<LeaveBalance> orderByComparator) {

		List<LeaveBalance> list = findByYear(year, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave balance in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance findByYear_Last(
			int year, OrderByComparator<LeaveBalance> orderByComparator)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = fetchByYear_Last(year, orderByComparator);

		if (leaveBalance != null) {
			return leaveBalance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("year=");
		sb.append(year);

		sb.append("}");

		throw new NoSuchLeaveBalanceException(sb.toString());
	}

	/**
	 * Returns the last leave balance in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance fetchByYear_Last(
		int year, OrderByComparator<LeaveBalance> orderByComparator) {

		int count = countByYear(year);

		if (count == 0) {
			return null;
		}

		List<LeaveBalance> list = findByYear(
			year, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave balances before and after the current leave balance in the ordered set where year = &#63;.
	 *
	 * @param leaveBalanceId the primary key of the current leave balance
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	@Override
	public LeaveBalance[] findByYear_PrevAndNext(
			long leaveBalanceId, int year,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = findByPrimaryKey(leaveBalanceId);

		Session session = null;

		try {
			session = openSession();

			LeaveBalance[] array = new LeaveBalanceImpl[3];

			array[0] = getByYear_PrevAndNext(
				session, leaveBalance, year, orderByComparator, true);

			array[1] = leaveBalance;

			array[2] = getByYear_PrevAndNext(
				session, leaveBalance, year, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveBalance getByYear_PrevAndNext(
		Session session, LeaveBalance leaveBalance, int year,
		OrderByComparator<LeaveBalance> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LEAVEBALANCE_WHERE);

		sb.append(_FINDER_COLUMN_YEAR_YEAR_2);

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
			sb.append(LeaveBalanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(year);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(leaveBalance)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveBalance> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave balances where year = &#63; from the database.
	 *
	 * @param year the year
	 */
	@Override
	public void removeByYear(int year) {
		for (LeaveBalance leaveBalance :
				findByYear(year, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leaveBalance);
		}
	}

	/**
	 * Returns the number of leave balances where year = &#63;.
	 *
	 * @param year the year
	 * @return the number of matching leave balances
	 */
	@Override
	public int countByYear(int year) {
		FinderPath finderPath = _finderPathCountByYear;

		Object[] finderArgs = new Object[] {year};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVEBALANCE_WHERE);

			sb.append(_FINDER_COLUMN_YEAR_YEAR_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(year);

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

	private static final String _FINDER_COLUMN_YEAR_YEAR_2 =
		"leaveBalance.year = ?";

	private FinderPath _finderPathFetchByEmployeeIdLeaveTypeMasterIdAndYear;
	private FinderPath _finderPathCountByEmployeeIdLeaveTypeMasterIdAndYear;

	/**
	 * Returns the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; and year = &#63; or throws a <code>NoSuchLeaveBalanceException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @return the matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance findByEmployeeIdLeaveTypeMasterIdAndYear(
			long employeeId, long leaveTypeMasterId, int year)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = fetchByEmployeeIdLeaveTypeMasterIdAndYear(
			employeeId, leaveTypeMasterId, year);

		if (leaveBalance == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("employeeId=");
			sb.append(employeeId);

			sb.append(", leaveTypeMasterId=");
			sb.append(leaveTypeMasterId);

			sb.append(", year=");
			sb.append(year);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLeaveBalanceException(sb.toString());
		}

		return leaveBalance;
	}

	/**
	 * Returns the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; and year = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance fetchByEmployeeIdLeaveTypeMasterIdAndYear(
		long employeeId, long leaveTypeMasterId, int year) {

		return fetchByEmployeeIdLeaveTypeMasterIdAndYear(
			employeeId, leaveTypeMasterId, year, true);
	}

	/**
	 * Returns the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; and year = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	@Override
	public LeaveBalance fetchByEmployeeIdLeaveTypeMasterIdAndYear(
		long employeeId, long leaveTypeMasterId, int year,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {employeeId, leaveTypeMasterId, year};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByEmployeeIdLeaveTypeMasterIdAndYear,
				finderArgs, this);
		}

		if (result instanceof LeaveBalance) {
			LeaveBalance leaveBalance = (LeaveBalance)result;

			if ((employeeId != leaveBalance.getEmployeeId()) ||
				(leaveTypeMasterId != leaveBalance.getLeaveTypeMasterId()) ||
				(year != leaveBalance.getYear())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_LEAVEBALANCE_WHERE);

			sb.append(
				_FINDER_COLUMN_EMPLOYEEIDLEAVETYPEMASTERIDANDYEAR_EMPLOYEEID_2);

			sb.append(
				_FINDER_COLUMN_EMPLOYEEIDLEAVETYPEMASTERIDANDYEAR_LEAVETYPEMASTERID_2);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDLEAVETYPEMASTERIDANDYEAR_YEAR_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				queryPos.add(leaveTypeMasterId);

				queryPos.add(year);

				List<LeaveBalance> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByEmployeeIdLeaveTypeMasterIdAndYear,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									employeeId, leaveTypeMasterId, year
								};
							}

							_log.warn(
								"LeaveBalancePersistenceImpl.fetchByEmployeeIdLeaveTypeMasterIdAndYear(long, long, int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LeaveBalance leaveBalance = list.get(0);

					result = leaveBalance;

					cacheResult(leaveBalance);
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
			return (LeaveBalance)result;
		}
	}

	/**
	 * Removes the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; and year = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @return the leave balance that was removed
	 */
	@Override
	public LeaveBalance removeByEmployeeIdLeaveTypeMasterIdAndYear(
			long employeeId, long leaveTypeMasterId, int year)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = findByEmployeeIdLeaveTypeMasterIdAndYear(
			employeeId, leaveTypeMasterId, year);

		return remove(leaveBalance);
	}

	/**
	 * Returns the number of leave balances where employeeId = &#63; and leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @return the number of matching leave balances
	 */
	@Override
	public int countByEmployeeIdLeaveTypeMasterIdAndYear(
		long employeeId, long leaveTypeMasterId, int year) {

		FinderPath finderPath =
			_finderPathCountByEmployeeIdLeaveTypeMasterIdAndYear;

		Object[] finderArgs = new Object[] {
			employeeId, leaveTypeMasterId, year
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_LEAVEBALANCE_WHERE);

			sb.append(
				_FINDER_COLUMN_EMPLOYEEIDLEAVETYPEMASTERIDANDYEAR_EMPLOYEEID_2);

			sb.append(
				_FINDER_COLUMN_EMPLOYEEIDLEAVETYPEMASTERIDANDYEAR_LEAVETYPEMASTERID_2);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDLEAVETYPEMASTERIDANDYEAR_YEAR_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				queryPos.add(leaveTypeMasterId);

				queryPos.add(year);

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
		_FINDER_COLUMN_EMPLOYEEIDLEAVETYPEMASTERIDANDYEAR_EMPLOYEEID_2 =
			"leaveBalance.employeeId = ? AND ";

	private static final String
		_FINDER_COLUMN_EMPLOYEEIDLEAVETYPEMASTERIDANDYEAR_LEAVETYPEMASTERID_2 =
			"leaveBalance.leaveTypeMasterId = ? AND ";

	private static final String
		_FINDER_COLUMN_EMPLOYEEIDLEAVETYPEMASTERIDANDYEAR_YEAR_2 =
			"leaveBalance.year = ?";

	public LeaveBalancePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(LeaveBalance.class);

		setModelImplClass(LeaveBalanceImpl.class);
		setModelPKClass(long.class);

		setTable(LeaveBalanceTable.INSTANCE);
	}

	/**
	 * Caches the leave balance in the entity cache if it is enabled.
	 *
	 * @param leaveBalance the leave balance
	 */
	@Override
	public void cacheResult(LeaveBalance leaveBalance) {
		entityCache.putResult(
			LeaveBalanceImpl.class, leaveBalance.getPrimaryKey(), leaveBalance);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {leaveBalance.getUuid(), leaveBalance.getGroupId()},
			leaveBalance);

		finderCache.putResult(
			_finderPathFetchByEmployeeIdAndLeaveTypeMasterId,
			new Object[] {
				leaveBalance.getEmployeeId(),
				leaveBalance.getLeaveTypeMasterId()
			},
			leaveBalance);

		finderCache.putResult(
			_finderPathFetchByEmployeeIdLeaveTypeMasterIdAndYear,
			new Object[] {
				leaveBalance.getEmployeeId(),
				leaveBalance.getLeaveTypeMasterId(), leaveBalance.getYear()
			},
			leaveBalance);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the leave balances in the entity cache if it is enabled.
	 *
	 * @param leaveBalances the leave balances
	 */
	@Override
	public void cacheResult(List<LeaveBalance> leaveBalances) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (leaveBalances.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LeaveBalance leaveBalance : leaveBalances) {
			if (entityCache.getResult(
					LeaveBalanceImpl.class, leaveBalance.getPrimaryKey()) ==
						null) {

				cacheResult(leaveBalance);
			}
		}
	}

	/**
	 * Clears the cache for all leave balances.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LeaveBalanceImpl.class);

		finderCache.clearCache(LeaveBalanceImpl.class);
	}

	/**
	 * Clears the cache for the leave balance.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveBalance leaveBalance) {
		entityCache.removeResult(LeaveBalanceImpl.class, leaveBalance);
	}

	@Override
	public void clearCache(List<LeaveBalance> leaveBalances) {
		for (LeaveBalance leaveBalance : leaveBalances) {
			entityCache.removeResult(LeaveBalanceImpl.class, leaveBalance);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LeaveBalanceImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LeaveBalanceImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LeaveBalanceModelImpl leaveBalanceModelImpl) {

		Object[] args = new Object[] {
			leaveBalanceModelImpl.getUuid(), leaveBalanceModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, leaveBalanceModelImpl);

		args = new Object[] {
			leaveBalanceModelImpl.getEmployeeId(),
			leaveBalanceModelImpl.getLeaveTypeMasterId()
		};

		finderCache.putResult(
			_finderPathCountByEmployeeIdAndLeaveTypeMasterId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByEmployeeIdAndLeaveTypeMasterId, args,
			leaveBalanceModelImpl);

		args = new Object[] {
			leaveBalanceModelImpl.getEmployeeId(),
			leaveBalanceModelImpl.getLeaveTypeMasterId(),
			leaveBalanceModelImpl.getYear()
		};

		finderCache.putResult(
			_finderPathCountByEmployeeIdLeaveTypeMasterIdAndYear, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByEmployeeIdLeaveTypeMasterIdAndYear, args,
			leaveBalanceModelImpl);
	}

	/**
	 * Creates a new leave balance with the primary key. Does not add the leave balance to the database.
	 *
	 * @param leaveBalanceId the primary key for the new leave balance
	 * @return the new leave balance
	 */
	@Override
	public LeaveBalance create(long leaveBalanceId) {
		LeaveBalance leaveBalance = new LeaveBalanceImpl();

		leaveBalance.setNew(true);
		leaveBalance.setPrimaryKey(leaveBalanceId);

		String uuid = PortalUUIDUtil.generate();

		leaveBalance.setUuid(uuid);

		leaveBalance.setCompanyId(CompanyThreadLocal.getCompanyId());

		return leaveBalance;
	}

	/**
	 * Removes the leave balance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveBalanceId the primary key of the leave balance
	 * @return the leave balance that was removed
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	@Override
	public LeaveBalance remove(long leaveBalanceId)
		throws NoSuchLeaveBalanceException {

		return remove((Serializable)leaveBalanceId);
	}

	/**
	 * Removes the leave balance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave balance
	 * @return the leave balance that was removed
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	@Override
	public LeaveBalance remove(Serializable primaryKey)
		throws NoSuchLeaveBalanceException {

		Session session = null;

		try {
			session = openSession();

			LeaveBalance leaveBalance = (LeaveBalance)session.get(
				LeaveBalanceImpl.class, primaryKey);

			if (leaveBalance == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveBalanceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(leaveBalance);
		}
		catch (NoSuchLeaveBalanceException noSuchEntityException) {
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
	protected LeaveBalance removeImpl(LeaveBalance leaveBalance) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveBalance)) {
				leaveBalance = (LeaveBalance)session.get(
					LeaveBalanceImpl.class, leaveBalance.getPrimaryKeyObj());
			}

			if (leaveBalance != null) {
				session.delete(leaveBalance);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (leaveBalance != null) {
			clearCache(leaveBalance);
		}

		return leaveBalance;
	}

	@Override
	public LeaveBalance updateImpl(LeaveBalance leaveBalance) {
		boolean isNew = leaveBalance.isNew();

		if (!(leaveBalance instanceof LeaveBalanceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(leaveBalance.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					leaveBalance);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in leaveBalance proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LeaveBalance implementation " +
					leaveBalance.getClass());
		}

		LeaveBalanceModelImpl leaveBalanceModelImpl =
			(LeaveBalanceModelImpl)leaveBalance;

		if (Validator.isNull(leaveBalance.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			leaveBalance.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (leaveBalance.getCreateDate() == null)) {
			if (serviceContext == null) {
				leaveBalance.setCreateDate(date);
			}
			else {
				leaveBalance.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!leaveBalanceModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				leaveBalance.setModifiedDate(date);
			}
			else {
				leaveBalance.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(leaveBalance);
			}
			else {
				leaveBalance = (LeaveBalance)session.merge(leaveBalance);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LeaveBalanceImpl.class, leaveBalanceModelImpl, false, true);

		cacheUniqueFindersCache(leaveBalanceModelImpl);

		if (isNew) {
			leaveBalance.setNew(false);
		}

		leaveBalance.resetOriginalValues();

		return leaveBalance;
	}

	/**
	 * Returns the leave balance with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave balance
	 * @return the leave balance
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	@Override
	public LeaveBalance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveBalanceException {

		LeaveBalance leaveBalance = fetchByPrimaryKey(primaryKey);

		if (leaveBalance == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveBalanceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return leaveBalance;
	}

	/**
	 * Returns the leave balance with the primary key or throws a <code>NoSuchLeaveBalanceException</code> if it could not be found.
	 *
	 * @param leaveBalanceId the primary key of the leave balance
	 * @return the leave balance
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	@Override
	public LeaveBalance findByPrimaryKey(long leaveBalanceId)
		throws NoSuchLeaveBalanceException {

		return findByPrimaryKey((Serializable)leaveBalanceId);
	}

	/**
	 * Returns the leave balance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveBalanceId the primary key of the leave balance
	 * @return the leave balance, or <code>null</code> if a leave balance with the primary key could not be found
	 */
	@Override
	public LeaveBalance fetchByPrimaryKey(long leaveBalanceId) {
		return fetchByPrimaryKey((Serializable)leaveBalanceId);
	}

	/**
	 * Returns all the leave balances.
	 *
	 * @return the leave balances
	 */
	@Override
	public List<LeaveBalance> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave balances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @return the range of leave balances
	 */
	@Override
	public List<LeaveBalance> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave balances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave balances
	 */
	@Override
	public List<LeaveBalance> findAll(
		int start, int end, OrderByComparator<LeaveBalance> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave balances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave balances
	 */
	@Override
	public List<LeaveBalance> findAll(
		int start, int end, OrderByComparator<LeaveBalance> orderByComparator,
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

		List<LeaveBalance> list = null;

		if (useFinderCache) {
			list = (List<LeaveBalance>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LEAVEBALANCE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVEBALANCE;

				sql = sql.concat(LeaveBalanceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LeaveBalance>)QueryUtil.list(
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
	 * Removes all the leave balances from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LeaveBalance leaveBalance : findAll()) {
			remove(leaveBalance);
		}
	}

	/**
	 * Returns the number of leave balances.
	 *
	 * @return the number of leave balances
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LEAVEBALANCE);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "leaveBalanceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEAVEBALANCE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LeaveBalanceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leave balance persistence.
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

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathFetchByEmployeeIdAndLeaveTypeMasterId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByEmployeeIdAndLeaveTypeMasterId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"employeeId", "leaveTypeMasterId"}, true);

		_finderPathCountByEmployeeIdAndLeaveTypeMasterId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmployeeIdAndLeaveTypeMasterId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"employeeId", "leaveTypeMasterId"}, false);

		_finderPathWithPaginationFindByEmployeeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmployeeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"employeeId"}, true);

		_finderPathWithoutPaginationFindByEmployeeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmployeeId",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			true);

		_finderPathCountByEmployeeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeId",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			false);

		_finderPathWithPaginationFindByEmployeeIdAndYear = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmployeeIdAndYear",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"employeeId", "year"}, true);

		_finderPathWithoutPaginationFindByEmployeeIdAndYear = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEmployeeIdAndYear",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"employeeId", "year"}, true);

		_finderPathCountByEmployeeIdAndYear = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmployeeIdAndYear",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"employeeId", "year"}, false);

		_finderPathWithPaginationFindByLeaveTypeMasterIdAndYear =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByLeaveTypeMasterIdAndYear",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"leaveTypeMasterId", "year"}, true);

		_finderPathWithoutPaginationFindByLeaveTypeMasterIdAndYear =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByLeaveTypeMasterIdAndYear",
				new String[] {Long.class.getName(), Integer.class.getName()},
				new String[] {"leaveTypeMasterId", "year"}, true);

		_finderPathCountByLeaveTypeMasterIdAndYear = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLeaveTypeMasterIdAndYear",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"leaveTypeMasterId", "year"}, false);

		_finderPathWithPaginationFindByYear = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByYear",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"year"}, true);

		_finderPathWithoutPaginationFindByYear = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByYear",
			new String[] {Integer.class.getName()}, new String[] {"year"},
			true);

		_finderPathCountByYear = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByYear",
			new String[] {Integer.class.getName()}, new String[] {"year"},
			false);

		_finderPathFetchByEmployeeIdLeaveTypeMasterIdAndYear = new FinderPath(
			FINDER_CLASS_NAME_ENTITY,
			"fetchByEmployeeIdLeaveTypeMasterIdAndYear",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			new String[] {"employeeId", "leaveTypeMasterId", "year"}, true);

		_finderPathCountByEmployeeIdLeaveTypeMasterIdAndYear = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmployeeIdLeaveTypeMasterIdAndYear",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			new String[] {"employeeId", "leaveTypeMasterId", "year"}, false);

		LeaveBalanceUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		LeaveBalanceUtil.setPersistence(null);

		entityCache.removeCache(LeaveBalanceImpl.class.getName());
	}

	@Override
	@Reference(
		target = axPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = axPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = axPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_LEAVEBALANCE =
		"SELECT leaveBalance FROM LeaveBalance leaveBalance";

	private static final String _SQL_SELECT_LEAVEBALANCE_WHERE =
		"SELECT leaveBalance FROM LeaveBalance leaveBalance WHERE ";

	private static final String _SQL_COUNT_LEAVEBALANCE =
		"SELECT COUNT(leaveBalance) FROM LeaveBalance leaveBalance";

	private static final String _SQL_COUNT_LEAVEBALANCE_WHERE =
		"SELECT COUNT(leaveBalance) FROM LeaveBalance leaveBalance WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveBalance.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LeaveBalance exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LeaveBalance exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LeaveBalancePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}