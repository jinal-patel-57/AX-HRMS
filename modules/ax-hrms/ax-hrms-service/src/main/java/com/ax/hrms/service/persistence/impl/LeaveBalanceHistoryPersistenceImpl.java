/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchLeaveBalanceHistoryException;
import com.ax.hrms.model.LeaveBalanceHistory;
import com.ax.hrms.model.LeaveBalanceHistoryTable;
import com.ax.hrms.model.impl.LeaveBalanceHistoryImpl;
import com.ax.hrms.model.impl.LeaveBalanceHistoryModelImpl;
import com.ax.hrms.service.persistence.LeaveBalanceHistoryPersistence;
import com.ax.hrms.service.persistence.LeaveBalanceHistoryUtil;
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the leave balance history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LeaveBalanceHistoryPersistence.class)
public class LeaveBalanceHistoryPersistenceImpl
	extends BasePersistenceImpl<LeaveBalanceHistory>
	implements LeaveBalanceHistoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LeaveBalanceHistoryUtil</code> to access the leave balance history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LeaveBalanceHistoryImpl.class.getName();

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
	 * Returns all the leave balance histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave balance histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @return the range of matching leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave balance histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave balance histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator,
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

		List<LeaveBalanceHistory> list = null;

		if (useFinderCache) {
			list = (List<LeaveBalanceHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveBalanceHistory leaveBalanceHistory : list) {
					if (!uuid.equals(leaveBalanceHistory.getUuid())) {
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

			sb.append(_SQL_SELECT_LEAVEBALANCEHISTORY_WHERE);

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
				sb.append(LeaveBalanceHistoryModelImpl.ORDER_BY_JPQL);
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

				list = (List<LeaveBalanceHistory>)QueryUtil.list(
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
	 * Returns the first leave balance history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory findByUuid_First(
			String uuid,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException {

		LeaveBalanceHistory leaveBalanceHistory = fetchByUuid_First(
			uuid, orderByComparator);

		if (leaveBalanceHistory != null) {
			return leaveBalanceHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLeaveBalanceHistoryException(sb.toString());
	}

	/**
	 * Returns the first leave balance history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory fetchByUuid_First(
		String uuid, OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		List<LeaveBalanceHistory> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave balance history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory findByUuid_Last(
			String uuid,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException {

		LeaveBalanceHistory leaveBalanceHistory = fetchByUuid_Last(
			uuid, orderByComparator);

		if (leaveBalanceHistory != null) {
			return leaveBalanceHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLeaveBalanceHistoryException(sb.toString());
	}

	/**
	 * Returns the last leave balance history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory fetchByUuid_Last(
		String uuid, OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<LeaveBalanceHistory> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave balance histories before and after the current leave balance history in the ordered set where uuid = &#63;.
	 *
	 * @param leaveBalanceHistoryId the primary key of the current leave balance history
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a leave balance history with the primary key could not be found
	 */
	@Override
	public LeaveBalanceHistory[] findByUuid_PrevAndNext(
			long leaveBalanceHistoryId, String uuid,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException {

		uuid = Objects.toString(uuid, "");

		LeaveBalanceHistory leaveBalanceHistory = findByPrimaryKey(
			leaveBalanceHistoryId);

		Session session = null;

		try {
			session = openSession();

			LeaveBalanceHistory[] array = new LeaveBalanceHistoryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, leaveBalanceHistory, uuid, orderByComparator, true);

			array[1] = leaveBalanceHistory;

			array[2] = getByUuid_PrevAndNext(
				session, leaveBalanceHistory, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveBalanceHistory getByUuid_PrevAndNext(
		Session session, LeaveBalanceHistory leaveBalanceHistory, String uuid,
		OrderByComparator<LeaveBalanceHistory> orderByComparator,
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

		sb.append(_SQL_SELECT_LEAVEBALANCEHISTORY_WHERE);

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
			sb.append(LeaveBalanceHistoryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						leaveBalanceHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveBalanceHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave balance histories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (LeaveBalanceHistory leaveBalanceHistory :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leaveBalanceHistory);
		}
	}

	/**
	 * Returns the number of leave balance histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave balance histories
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVEBALANCEHISTORY_WHERE);

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
		"leaveBalanceHistory.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(leaveBalanceHistory.uuid IS NULL OR leaveBalanceHistory.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the leave balance history where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveBalanceHistoryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory findByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveBalanceHistoryException {

		LeaveBalanceHistory leaveBalanceHistory = fetchByUUID_G(uuid, groupId);

		if (leaveBalanceHistory == null) {
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

			throw new NoSuchLeaveBalanceHistoryException(sb.toString());
		}

		return leaveBalanceHistory;
	}

	/**
	 * Returns the leave balance history where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the leave balance history where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory fetchByUUID_G(
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

		if (result instanceof LeaveBalanceHistory) {
			LeaveBalanceHistory leaveBalanceHistory =
				(LeaveBalanceHistory)result;

			if (!Objects.equals(uuid, leaveBalanceHistory.getUuid()) ||
				(groupId != leaveBalanceHistory.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LEAVEBALANCEHISTORY_WHERE);

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

				List<LeaveBalanceHistory> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					LeaveBalanceHistory leaveBalanceHistory = list.get(0);

					result = leaveBalanceHistory;

					cacheResult(leaveBalanceHistory);
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
			return (LeaveBalanceHistory)result;
		}
	}

	/**
	 * Removes the leave balance history where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave balance history that was removed
	 */
	@Override
	public LeaveBalanceHistory removeByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveBalanceHistoryException {

		LeaveBalanceHistory leaveBalanceHistory = findByUUID_G(uuid, groupId);

		return remove(leaveBalanceHistory);
	}

	/**
	 * Returns the number of leave balance histories where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave balance histories
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		LeaveBalanceHistory leaveBalanceHistory = fetchByUUID_G(uuid, groupId);

		if (leaveBalanceHistory == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"leaveBalanceHistory.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(leaveBalanceHistory.uuid IS NULL OR leaveBalanceHistory.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"leaveBalanceHistory.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the leave balance histories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave balance histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @return the range of matching leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave balance histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave balance histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator,
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

		List<LeaveBalanceHistory> list = null;

		if (useFinderCache) {
			list = (List<LeaveBalanceHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveBalanceHistory leaveBalanceHistory : list) {
					if (!uuid.equals(leaveBalanceHistory.getUuid()) ||
						(companyId != leaveBalanceHistory.getCompanyId())) {

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

			sb.append(_SQL_SELECT_LEAVEBALANCEHISTORY_WHERE);

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
				sb.append(LeaveBalanceHistoryModelImpl.ORDER_BY_JPQL);
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

				list = (List<LeaveBalanceHistory>)QueryUtil.list(
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
	 * Returns the first leave balance history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException {

		LeaveBalanceHistory leaveBalanceHistory = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (leaveBalanceHistory != null) {
			return leaveBalanceHistory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLeaveBalanceHistoryException(sb.toString());
	}

	/**
	 * Returns the first leave balance history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		List<LeaveBalanceHistory> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave balance history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException {

		LeaveBalanceHistory leaveBalanceHistory = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (leaveBalanceHistory != null) {
			return leaveBalanceHistory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLeaveBalanceHistoryException(sb.toString());
	}

	/**
	 * Returns the last leave balance history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<LeaveBalanceHistory> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave balance histories before and after the current leave balance history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveBalanceHistoryId the primary key of the current leave balance history
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a leave balance history with the primary key could not be found
	 */
	@Override
	public LeaveBalanceHistory[] findByUuid_C_PrevAndNext(
			long leaveBalanceHistoryId, String uuid, long companyId,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException {

		uuid = Objects.toString(uuid, "");

		LeaveBalanceHistory leaveBalanceHistory = findByPrimaryKey(
			leaveBalanceHistoryId);

		Session session = null;

		try {
			session = openSession();

			LeaveBalanceHistory[] array = new LeaveBalanceHistoryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, leaveBalanceHistory, uuid, companyId,
				orderByComparator, true);

			array[1] = leaveBalanceHistory;

			array[2] = getByUuid_C_PrevAndNext(
				session, leaveBalanceHistory, uuid, companyId,
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

	protected LeaveBalanceHistory getByUuid_C_PrevAndNext(
		Session session, LeaveBalanceHistory leaveBalanceHistory, String uuid,
		long companyId,
		OrderByComparator<LeaveBalanceHistory> orderByComparator,
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

		sb.append(_SQL_SELECT_LEAVEBALANCEHISTORY_WHERE);

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
			sb.append(LeaveBalanceHistoryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						leaveBalanceHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveBalanceHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave balance histories where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (LeaveBalanceHistory leaveBalanceHistory :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(leaveBalanceHistory);
		}
	}

	/**
	 * Returns the number of leave balance histories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave balance histories
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVEBALANCEHISTORY_WHERE);

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
		"leaveBalanceHistory.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(leaveBalanceHistory.uuid IS NULL OR leaveBalanceHistory.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"leaveBalanceHistory.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByEmployeeId;
	private FinderPath _finderPathWithoutPaginationFindByEmployeeId;
	private FinderPath _finderPathCountByEmployeeId;

	/**
	 * Returns all the leave balance histories where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave balance histories where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @return the range of matching leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave balance histories where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave balance histories where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator,
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

		List<LeaveBalanceHistory> list = null;

		if (useFinderCache) {
			list = (List<LeaveBalanceHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveBalanceHistory leaveBalanceHistory : list) {
					if (employeeId != leaveBalanceHistory.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_LEAVEBALANCEHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LeaveBalanceHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<LeaveBalanceHistory>)QueryUtil.list(
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
	 * Returns the first leave balance history in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory findByEmployeeId_First(
			long employeeId,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException {

		LeaveBalanceHistory leaveBalanceHistory = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (leaveBalanceHistory != null) {
			return leaveBalanceHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchLeaveBalanceHistoryException(sb.toString());
	}

	/**
	 * Returns the first leave balance history in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		List<LeaveBalanceHistory> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave balance history in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException {

		LeaveBalanceHistory leaveBalanceHistory = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (leaveBalanceHistory != null) {
			return leaveBalanceHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchLeaveBalanceHistoryException(sb.toString());
	}

	/**
	 * Returns the last leave balance history in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<LeaveBalanceHistory> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave balance histories before and after the current leave balance history in the ordered set where employeeId = &#63;.
	 *
	 * @param leaveBalanceHistoryId the primary key of the current leave balance history
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a leave balance history with the primary key could not be found
	 */
	@Override
	public LeaveBalanceHistory[] findByEmployeeId_PrevAndNext(
			long leaveBalanceHistoryId, long employeeId,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException {

		LeaveBalanceHistory leaveBalanceHistory = findByPrimaryKey(
			leaveBalanceHistoryId);

		Session session = null;

		try {
			session = openSession();

			LeaveBalanceHistory[] array = new LeaveBalanceHistoryImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, leaveBalanceHistory, employeeId, orderByComparator,
				true);

			array[1] = leaveBalanceHistory;

			array[2] = getByEmployeeId_PrevAndNext(
				session, leaveBalanceHistory, employeeId, orderByComparator,
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

	protected LeaveBalanceHistory getByEmployeeId_PrevAndNext(
		Session session, LeaveBalanceHistory leaveBalanceHistory,
		long employeeId,
		OrderByComparator<LeaveBalanceHistory> orderByComparator,
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

		sb.append(_SQL_SELECT_LEAVEBALANCEHISTORY_WHERE);

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
			sb.append(LeaveBalanceHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(employeeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						leaveBalanceHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveBalanceHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave balance histories where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (LeaveBalanceHistory leaveBalanceHistory :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leaveBalanceHistory);
		}
	}

	/**
	 * Returns the number of leave balance histories where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching leave balance histories
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVEBALANCEHISTORY_WHERE);

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
		"leaveBalanceHistory.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByYear;
	private FinderPath _finderPathWithoutPaginationFindByYear;
	private FinderPath _finderPathCountByYear;

	/**
	 * Returns all the leave balance histories where year = &#63;.
	 *
	 * @param year the year
	 * @return the matching leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findByYear(int year) {
		return findByYear(year, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave balance histories where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @return the range of matching leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findByYear(int year, int start, int end) {
		return findByYear(year, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave balance histories where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findByYear(
		int year, int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return findByYear(year, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave balance histories where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findByYear(
		int year, int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator,
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

		List<LeaveBalanceHistory> list = null;

		if (useFinderCache) {
			list = (List<LeaveBalanceHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveBalanceHistory leaveBalanceHistory : list) {
					if (year != leaveBalanceHistory.getYear()) {
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

			sb.append(_SQL_SELECT_LEAVEBALANCEHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_YEAR_YEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LeaveBalanceHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(year);

				list = (List<LeaveBalanceHistory>)QueryUtil.list(
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
	 * Returns the first leave balance history in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory findByYear_First(
			int year, OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException {

		LeaveBalanceHistory leaveBalanceHistory = fetchByYear_First(
			year, orderByComparator);

		if (leaveBalanceHistory != null) {
			return leaveBalanceHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("year=");
		sb.append(year);

		sb.append("}");

		throw new NoSuchLeaveBalanceHistoryException(sb.toString());
	}

	/**
	 * Returns the first leave balance history in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory fetchByYear_First(
		int year, OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		List<LeaveBalanceHistory> list = findByYear(
			year, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave balance history in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory findByYear_Last(
			int year, OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException {

		LeaveBalanceHistory leaveBalanceHistory = fetchByYear_Last(
			year, orderByComparator);

		if (leaveBalanceHistory != null) {
			return leaveBalanceHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("year=");
		sb.append(year);

		sb.append("}");

		throw new NoSuchLeaveBalanceHistoryException(sb.toString());
	}

	/**
	 * Returns the last leave balance history in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory fetchByYear_Last(
		int year, OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		int count = countByYear(year);

		if (count == 0) {
			return null;
		}

		List<LeaveBalanceHistory> list = findByYear(
			year, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave balance histories before and after the current leave balance history in the ordered set where year = &#63;.
	 *
	 * @param leaveBalanceHistoryId the primary key of the current leave balance history
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a leave balance history with the primary key could not be found
	 */
	@Override
	public LeaveBalanceHistory[] findByYear_PrevAndNext(
			long leaveBalanceHistoryId, int year,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException {

		LeaveBalanceHistory leaveBalanceHistory = findByPrimaryKey(
			leaveBalanceHistoryId);

		Session session = null;

		try {
			session = openSession();

			LeaveBalanceHistory[] array = new LeaveBalanceHistoryImpl[3];

			array[0] = getByYear_PrevAndNext(
				session, leaveBalanceHistory, year, orderByComparator, true);

			array[1] = leaveBalanceHistory;

			array[2] = getByYear_PrevAndNext(
				session, leaveBalanceHistory, year, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveBalanceHistory getByYear_PrevAndNext(
		Session session, LeaveBalanceHistory leaveBalanceHistory, int year,
		OrderByComparator<LeaveBalanceHistory> orderByComparator,
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

		sb.append(_SQL_SELECT_LEAVEBALANCEHISTORY_WHERE);

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
			sb.append(LeaveBalanceHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(year);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						leaveBalanceHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveBalanceHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave balance histories where year = &#63; from the database.
	 *
	 * @param year the year
	 */
	@Override
	public void removeByYear(int year) {
		for (LeaveBalanceHistory leaveBalanceHistory :
				findByYear(year, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leaveBalanceHistory);
		}
	}

	/**
	 * Returns the number of leave balance histories where year = &#63;.
	 *
	 * @param year the year
	 * @return the number of matching leave balance histories
	 */
	@Override
	public int countByYear(int year) {
		FinderPath finderPath = _finderPathCountByYear;

		Object[] finderArgs = new Object[] {year};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVEBALANCEHISTORY_WHERE);

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
		"leaveBalanceHistory.year = ?";

	private FinderPath _finderPathWithPaginationFindByEmployeeIdAndYear;
	private FinderPath _finderPathWithoutPaginationFindByEmployeeIdAndYear;
	private FinderPath _finderPathCountByEmployeeIdAndYear;

	/**
	 * Returns all the leave balance histories where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @return the matching leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findByEmployeeIdAndYear(
		long employeeId, int year) {

		return findByEmployeeIdAndYear(
			employeeId, year, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave balance histories where employeeId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @return the range of matching leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findByEmployeeIdAndYear(
		long employeeId, int year, int start, int end) {

		return findByEmployeeIdAndYear(employeeId, year, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave balance histories where employeeId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findByEmployeeIdAndYear(
		long employeeId, int year, int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return findByEmployeeIdAndYear(
			employeeId, year, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave balance histories where employeeId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findByEmployeeIdAndYear(
		long employeeId, int year, int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator,
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

		List<LeaveBalanceHistory> list = null;

		if (useFinderCache) {
			list = (List<LeaveBalanceHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveBalanceHistory leaveBalanceHistory : list) {
					if ((employeeId != leaveBalanceHistory.getEmployeeId()) ||
						(year != leaveBalanceHistory.getYear())) {

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

			sb.append(_SQL_SELECT_LEAVEBALANCEHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDANDYEAR_EMPLOYEEID_2);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDANDYEAR_YEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LeaveBalanceHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				queryPos.add(year);

				list = (List<LeaveBalanceHistory>)QueryUtil.list(
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
	 * Returns the first leave balance history in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory findByEmployeeIdAndYear_First(
			long employeeId, int year,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException {

		LeaveBalanceHistory leaveBalanceHistory =
			fetchByEmployeeIdAndYear_First(employeeId, year, orderByComparator);

		if (leaveBalanceHistory != null) {
			return leaveBalanceHistory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append(", year=");
		sb.append(year);

		sb.append("}");

		throw new NoSuchLeaveBalanceHistoryException(sb.toString());
	}

	/**
	 * Returns the first leave balance history in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory fetchByEmployeeIdAndYear_First(
		long employeeId, int year,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		List<LeaveBalanceHistory> list = findByEmployeeIdAndYear(
			employeeId, year, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave balance history in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory findByEmployeeIdAndYear_Last(
			long employeeId, int year,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException {

		LeaveBalanceHistory leaveBalanceHistory = fetchByEmployeeIdAndYear_Last(
			employeeId, year, orderByComparator);

		if (leaveBalanceHistory != null) {
			return leaveBalanceHistory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append(", year=");
		sb.append(year);

		sb.append("}");

		throw new NoSuchLeaveBalanceHistoryException(sb.toString());
	}

	/**
	 * Returns the last leave balance history in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory fetchByEmployeeIdAndYear_Last(
		long employeeId, int year,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		int count = countByEmployeeIdAndYear(employeeId, year);

		if (count == 0) {
			return null;
		}

		List<LeaveBalanceHistory> list = findByEmployeeIdAndYear(
			employeeId, year, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave balance histories before and after the current leave balance history in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param leaveBalanceHistoryId the primary key of the current leave balance history
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a leave balance history with the primary key could not be found
	 */
	@Override
	public LeaveBalanceHistory[] findByEmployeeIdAndYear_PrevAndNext(
			long leaveBalanceHistoryId, long employeeId, int year,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException {

		LeaveBalanceHistory leaveBalanceHistory = findByPrimaryKey(
			leaveBalanceHistoryId);

		Session session = null;

		try {
			session = openSession();

			LeaveBalanceHistory[] array = new LeaveBalanceHistoryImpl[3];

			array[0] = getByEmployeeIdAndYear_PrevAndNext(
				session, leaveBalanceHistory, employeeId, year,
				orderByComparator, true);

			array[1] = leaveBalanceHistory;

			array[2] = getByEmployeeIdAndYear_PrevAndNext(
				session, leaveBalanceHistory, employeeId, year,
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

	protected LeaveBalanceHistory getByEmployeeIdAndYear_PrevAndNext(
		Session session, LeaveBalanceHistory leaveBalanceHistory,
		long employeeId, int year,
		OrderByComparator<LeaveBalanceHistory> orderByComparator,
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

		sb.append(_SQL_SELECT_LEAVEBALANCEHISTORY_WHERE);

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
			sb.append(LeaveBalanceHistoryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						leaveBalanceHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveBalanceHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave balance histories where employeeId = &#63; and year = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 */
	@Override
	public void removeByEmployeeIdAndYear(long employeeId, int year) {
		for (LeaveBalanceHistory leaveBalanceHistory :
				findByEmployeeIdAndYear(
					employeeId, year, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(leaveBalanceHistory);
		}
	}

	/**
	 * Returns the number of leave balance histories where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @return the number of matching leave balance histories
	 */
	@Override
	public int countByEmployeeIdAndYear(long employeeId, int year) {
		FinderPath finderPath = _finderPathCountByEmployeeIdAndYear;

		Object[] finderArgs = new Object[] {employeeId, year};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVEBALANCEHISTORY_WHERE);

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
		"leaveBalanceHistory.employeeId = ? AND ";

	private static final String _FINDER_COLUMN_EMPLOYEEIDANDYEAR_YEAR_2 =
		"leaveBalanceHistory.year = ?";

	public LeaveBalanceHistoryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(LeaveBalanceHistory.class);

		setModelImplClass(LeaveBalanceHistoryImpl.class);
		setModelPKClass(long.class);

		setTable(LeaveBalanceHistoryTable.INSTANCE);
	}

	/**
	 * Caches the leave balance history in the entity cache if it is enabled.
	 *
	 * @param leaveBalanceHistory the leave balance history
	 */
	@Override
	public void cacheResult(LeaveBalanceHistory leaveBalanceHistory) {
		entityCache.putResult(
			LeaveBalanceHistoryImpl.class, leaveBalanceHistory.getPrimaryKey(),
			leaveBalanceHistory);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				leaveBalanceHistory.getUuid(), leaveBalanceHistory.getGroupId()
			},
			leaveBalanceHistory);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the leave balance histories in the entity cache if it is enabled.
	 *
	 * @param leaveBalanceHistories the leave balance histories
	 */
	@Override
	public void cacheResult(List<LeaveBalanceHistory> leaveBalanceHistories) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (leaveBalanceHistories.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LeaveBalanceHistory leaveBalanceHistory : leaveBalanceHistories) {
			if (entityCache.getResult(
					LeaveBalanceHistoryImpl.class,
					leaveBalanceHistory.getPrimaryKey()) == null) {

				cacheResult(leaveBalanceHistory);
			}
		}
	}

	/**
	 * Clears the cache for all leave balance histories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LeaveBalanceHistoryImpl.class);

		finderCache.clearCache(LeaveBalanceHistoryImpl.class);
	}

	/**
	 * Clears the cache for the leave balance history.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveBalanceHistory leaveBalanceHistory) {
		entityCache.removeResult(
			LeaveBalanceHistoryImpl.class, leaveBalanceHistory);
	}

	@Override
	public void clearCache(List<LeaveBalanceHistory> leaveBalanceHistories) {
		for (LeaveBalanceHistory leaveBalanceHistory : leaveBalanceHistories) {
			entityCache.removeResult(
				LeaveBalanceHistoryImpl.class, leaveBalanceHistory);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LeaveBalanceHistoryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LeaveBalanceHistoryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LeaveBalanceHistoryModelImpl leaveBalanceHistoryModelImpl) {

		Object[] args = new Object[] {
			leaveBalanceHistoryModelImpl.getUuid(),
			leaveBalanceHistoryModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, leaveBalanceHistoryModelImpl);
	}

	/**
	 * Creates a new leave balance history with the primary key. Does not add the leave balance history to the database.
	 *
	 * @param leaveBalanceHistoryId the primary key for the new leave balance history
	 * @return the new leave balance history
	 */
	@Override
	public LeaveBalanceHistory create(long leaveBalanceHistoryId) {
		LeaveBalanceHistory leaveBalanceHistory = new LeaveBalanceHistoryImpl();

		leaveBalanceHistory.setNew(true);
		leaveBalanceHistory.setPrimaryKey(leaveBalanceHistoryId);

		String uuid = PortalUUIDUtil.generate();

		leaveBalanceHistory.setUuid(uuid);

		leaveBalanceHistory.setCompanyId(CompanyThreadLocal.getCompanyId());

		return leaveBalanceHistory;
	}

	/**
	 * Removes the leave balance history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveBalanceHistoryId the primary key of the leave balance history
	 * @return the leave balance history that was removed
	 * @throws NoSuchLeaveBalanceHistoryException if a leave balance history with the primary key could not be found
	 */
	@Override
	public LeaveBalanceHistory remove(long leaveBalanceHistoryId)
		throws NoSuchLeaveBalanceHistoryException {

		return remove((Serializable)leaveBalanceHistoryId);
	}

	/**
	 * Removes the leave balance history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave balance history
	 * @return the leave balance history that was removed
	 * @throws NoSuchLeaveBalanceHistoryException if a leave balance history with the primary key could not be found
	 */
	@Override
	public LeaveBalanceHistory remove(Serializable primaryKey)
		throws NoSuchLeaveBalanceHistoryException {

		Session session = null;

		try {
			session = openSession();

			LeaveBalanceHistory leaveBalanceHistory =
				(LeaveBalanceHistory)session.get(
					LeaveBalanceHistoryImpl.class, primaryKey);

			if (leaveBalanceHistory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveBalanceHistoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(leaveBalanceHistory);
		}
		catch (NoSuchLeaveBalanceHistoryException noSuchEntityException) {
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
	protected LeaveBalanceHistory removeImpl(
		LeaveBalanceHistory leaveBalanceHistory) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveBalanceHistory)) {
				leaveBalanceHistory = (LeaveBalanceHistory)session.get(
					LeaveBalanceHistoryImpl.class,
					leaveBalanceHistory.getPrimaryKeyObj());
			}

			if (leaveBalanceHistory != null) {
				session.delete(leaveBalanceHistory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (leaveBalanceHistory != null) {
			clearCache(leaveBalanceHistory);
		}

		return leaveBalanceHistory;
	}

	@Override
	public LeaveBalanceHistory updateImpl(
		LeaveBalanceHistory leaveBalanceHistory) {

		boolean isNew = leaveBalanceHistory.isNew();

		if (!(leaveBalanceHistory instanceof LeaveBalanceHistoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(leaveBalanceHistory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					leaveBalanceHistory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in leaveBalanceHistory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LeaveBalanceHistory implementation " +
					leaveBalanceHistory.getClass());
		}

		LeaveBalanceHistoryModelImpl leaveBalanceHistoryModelImpl =
			(LeaveBalanceHistoryModelImpl)leaveBalanceHistory;

		if (Validator.isNull(leaveBalanceHistory.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			leaveBalanceHistory.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (leaveBalanceHistory.getCreateDate() == null)) {
			if (serviceContext == null) {
				leaveBalanceHistory.setCreateDate(date);
			}
			else {
				leaveBalanceHistory.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!leaveBalanceHistoryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				leaveBalanceHistory.setModifiedDate(date);
			}
			else {
				leaveBalanceHistory.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(leaveBalanceHistory);
			}
			else {
				leaveBalanceHistory = (LeaveBalanceHistory)session.merge(
					leaveBalanceHistory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LeaveBalanceHistoryImpl.class, leaveBalanceHistoryModelImpl, false,
			true);

		cacheUniqueFindersCache(leaveBalanceHistoryModelImpl);

		if (isNew) {
			leaveBalanceHistory.setNew(false);
		}

		leaveBalanceHistory.resetOriginalValues();

		return leaveBalanceHistory;
	}

	/**
	 * Returns the leave balance history with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave balance history
	 * @return the leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a leave balance history with the primary key could not be found
	 */
	@Override
	public LeaveBalanceHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveBalanceHistoryException {

		LeaveBalanceHistory leaveBalanceHistory = fetchByPrimaryKey(primaryKey);

		if (leaveBalanceHistory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveBalanceHistoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return leaveBalanceHistory;
	}

	/**
	 * Returns the leave balance history with the primary key or throws a <code>NoSuchLeaveBalanceHistoryException</code> if it could not be found.
	 *
	 * @param leaveBalanceHistoryId the primary key of the leave balance history
	 * @return the leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a leave balance history with the primary key could not be found
	 */
	@Override
	public LeaveBalanceHistory findByPrimaryKey(long leaveBalanceHistoryId)
		throws NoSuchLeaveBalanceHistoryException {

		return findByPrimaryKey((Serializable)leaveBalanceHistoryId);
	}

	/**
	 * Returns the leave balance history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveBalanceHistoryId the primary key of the leave balance history
	 * @return the leave balance history, or <code>null</code> if a leave balance history with the primary key could not be found
	 */
	@Override
	public LeaveBalanceHistory fetchByPrimaryKey(long leaveBalanceHistoryId) {
		return fetchByPrimaryKey((Serializable)leaveBalanceHistoryId);
	}

	/**
	 * Returns all the leave balance histories.
	 *
	 * @return the leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave balance histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @return the range of leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave balance histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findAll(
		int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave balance histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> findAll(
		int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator,
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

		List<LeaveBalanceHistory> list = null;

		if (useFinderCache) {
			list = (List<LeaveBalanceHistory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LEAVEBALANCEHISTORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVEBALANCEHISTORY;

				sql = sql.concat(LeaveBalanceHistoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LeaveBalanceHistory>)QueryUtil.list(
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
	 * Removes all the leave balance histories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LeaveBalanceHistory leaveBalanceHistory : findAll()) {
			remove(leaveBalanceHistory);
		}
	}

	/**
	 * Returns the number of leave balance histories.
	 *
	 * @return the number of leave balance histories
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
					_SQL_COUNT_LEAVEBALANCEHISTORY);

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
		return "leaveBalanceHistoryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEAVEBALANCEHISTORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LeaveBalanceHistoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leave balance history persistence.
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

		LeaveBalanceHistoryUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		LeaveBalanceHistoryUtil.setPersistence(null);

		entityCache.removeCache(LeaveBalanceHistoryImpl.class.getName());
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

	private static final String _SQL_SELECT_LEAVEBALANCEHISTORY =
		"SELECT leaveBalanceHistory FROM LeaveBalanceHistory leaveBalanceHistory";

	private static final String _SQL_SELECT_LEAVEBALANCEHISTORY_WHERE =
		"SELECT leaveBalanceHistory FROM LeaveBalanceHistory leaveBalanceHistory WHERE ";

	private static final String _SQL_COUNT_LEAVEBALANCEHISTORY =
		"SELECT COUNT(leaveBalanceHistory) FROM LeaveBalanceHistory leaveBalanceHistory";

	private static final String _SQL_COUNT_LEAVEBALANCEHISTORY_WHERE =
		"SELECT COUNT(leaveBalanceHistory) FROM LeaveBalanceHistory leaveBalanceHistory WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveBalanceHistory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LeaveBalanceHistory exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LeaveBalanceHistory exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LeaveBalanceHistoryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}