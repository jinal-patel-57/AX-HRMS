/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchTimeTrackerException;
import com.ax.hrms.model.TimeTracker;
import com.ax.hrms.model.TimeTrackerTable;
import com.ax.hrms.model.impl.TimeTrackerImpl;
import com.ax.hrms.model.impl.TimeTrackerModelImpl;
import com.ax.hrms.service.persistence.TimeTrackerPersistence;
import com.ax.hrms.service.persistence.TimeTrackerUtil;
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
 * The persistence implementation for the time tracker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TimeTrackerPersistence.class)
public class TimeTrackerPersistenceImpl
	extends BasePersistenceImpl<TimeTracker> implements TimeTrackerPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TimeTrackerUtil</code> to access the time tracker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TimeTrackerImpl.class.getName();

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
	 * Returns all the time trackers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching time trackers
	 */
	@Override
	public List<TimeTracker> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the time trackers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @return the range of matching time trackers
	 */
	@Override
	public List<TimeTracker> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the time trackers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching time trackers
	 */
	@Override
	public List<TimeTracker> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TimeTracker> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the time trackers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching time trackers
	 */
	@Override
	public List<TimeTracker> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TimeTracker> orderByComparator,
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

		List<TimeTracker> list = null;

		if (useFinderCache) {
			list = (List<TimeTracker>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TimeTracker timeTracker : list) {
					if (!uuid.equals(timeTracker.getUuid())) {
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

			sb.append(_SQL_SELECT_TIMETRACKER_WHERE);

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
				sb.append(TimeTrackerModelImpl.ORDER_BY_JPQL);
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

				list = (List<TimeTracker>)QueryUtil.list(
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
	 * Returns the first time tracker in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	@Override
	public TimeTracker findByUuid_First(
			String uuid, OrderByComparator<TimeTracker> orderByComparator)
		throws NoSuchTimeTrackerException {

		TimeTracker timeTracker = fetchByUuid_First(uuid, orderByComparator);

		if (timeTracker != null) {
			return timeTracker;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTimeTrackerException(sb.toString());
	}

	/**
	 * Returns the first time tracker in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	@Override
	public TimeTracker fetchByUuid_First(
		String uuid, OrderByComparator<TimeTracker> orderByComparator) {

		List<TimeTracker> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last time tracker in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	@Override
	public TimeTracker findByUuid_Last(
			String uuid, OrderByComparator<TimeTracker> orderByComparator)
		throws NoSuchTimeTrackerException {

		TimeTracker timeTracker = fetchByUuid_Last(uuid, orderByComparator);

		if (timeTracker != null) {
			return timeTracker;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTimeTrackerException(sb.toString());
	}

	/**
	 * Returns the last time tracker in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	@Override
	public TimeTracker fetchByUuid_Last(
		String uuid, OrderByComparator<TimeTracker> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TimeTracker> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the time trackers before and after the current time tracker in the ordered set where uuid = &#63;.
	 *
	 * @param timeTrackerId the primary key of the current time tracker
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next time tracker
	 * @throws NoSuchTimeTrackerException if a time tracker with the primary key could not be found
	 */
	@Override
	public TimeTracker[] findByUuid_PrevAndNext(
			long timeTrackerId, String uuid,
			OrderByComparator<TimeTracker> orderByComparator)
		throws NoSuchTimeTrackerException {

		uuid = Objects.toString(uuid, "");

		TimeTracker timeTracker = findByPrimaryKey(timeTrackerId);

		Session session = null;

		try {
			session = openSession();

			TimeTracker[] array = new TimeTrackerImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, timeTracker, uuid, orderByComparator, true);

			array[1] = timeTracker;

			array[2] = getByUuid_PrevAndNext(
				session, timeTracker, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TimeTracker getByUuid_PrevAndNext(
		Session session, TimeTracker timeTracker, String uuid,
		OrderByComparator<TimeTracker> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TIMETRACKER_WHERE);

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
			sb.append(TimeTrackerModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(timeTracker)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TimeTracker> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the time trackers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TimeTracker timeTracker :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(timeTracker);
		}
	}

	/**
	 * Returns the number of time trackers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching time trackers
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TIMETRACKER_WHERE);

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
		"timeTracker.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(timeTracker.uuid IS NULL OR timeTracker.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the time tracker where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTimeTrackerException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	@Override
	public TimeTracker findByUUID_G(String uuid, long groupId)
		throws NoSuchTimeTrackerException {

		TimeTracker timeTracker = fetchByUUID_G(uuid, groupId);

		if (timeTracker == null) {
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

			throw new NoSuchTimeTrackerException(sb.toString());
		}

		return timeTracker;
	}

	/**
	 * Returns the time tracker where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	@Override
	public TimeTracker fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the time tracker where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	@Override
	public TimeTracker fetchByUUID_G(
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

		if (result instanceof TimeTracker) {
			TimeTracker timeTracker = (TimeTracker)result;

			if (!Objects.equals(uuid, timeTracker.getUuid()) ||
				(groupId != timeTracker.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TIMETRACKER_WHERE);

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

				List<TimeTracker> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					TimeTracker timeTracker = list.get(0);

					result = timeTracker;

					cacheResult(timeTracker);
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
			return (TimeTracker)result;
		}
	}

	/**
	 * Removes the time tracker where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the time tracker that was removed
	 */
	@Override
	public TimeTracker removeByUUID_G(String uuid, long groupId)
		throws NoSuchTimeTrackerException {

		TimeTracker timeTracker = findByUUID_G(uuid, groupId);

		return remove(timeTracker);
	}

	/**
	 * Returns the number of time trackers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching time trackers
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TIMETRACKER_WHERE);

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
		"timeTracker.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(timeTracker.uuid IS NULL OR timeTracker.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"timeTracker.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the time trackers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching time trackers
	 */
	@Override
	public List<TimeTracker> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the time trackers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @return the range of matching time trackers
	 */
	@Override
	public List<TimeTracker> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the time trackers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching time trackers
	 */
	@Override
	public List<TimeTracker> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TimeTracker> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the time trackers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching time trackers
	 */
	@Override
	public List<TimeTracker> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TimeTracker> orderByComparator,
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

		List<TimeTracker> list = null;

		if (useFinderCache) {
			list = (List<TimeTracker>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TimeTracker timeTracker : list) {
					if (!uuid.equals(timeTracker.getUuid()) ||
						(companyId != timeTracker.getCompanyId())) {

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

			sb.append(_SQL_SELECT_TIMETRACKER_WHERE);

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
				sb.append(TimeTrackerModelImpl.ORDER_BY_JPQL);
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

				list = (List<TimeTracker>)QueryUtil.list(
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
	 * Returns the first time tracker in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	@Override
	public TimeTracker findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TimeTracker> orderByComparator)
		throws NoSuchTimeTrackerException {

		TimeTracker timeTracker = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (timeTracker != null) {
			return timeTracker;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTimeTrackerException(sb.toString());
	}

	/**
	 * Returns the first time tracker in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	@Override
	public TimeTracker fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TimeTracker> orderByComparator) {

		List<TimeTracker> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last time tracker in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	@Override
	public TimeTracker findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TimeTracker> orderByComparator)
		throws NoSuchTimeTrackerException {

		TimeTracker timeTracker = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (timeTracker != null) {
			return timeTracker;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTimeTrackerException(sb.toString());
	}

	/**
	 * Returns the last time tracker in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	@Override
	public TimeTracker fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TimeTracker> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TimeTracker> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the time trackers before and after the current time tracker in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param timeTrackerId the primary key of the current time tracker
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next time tracker
	 * @throws NoSuchTimeTrackerException if a time tracker with the primary key could not be found
	 */
	@Override
	public TimeTracker[] findByUuid_C_PrevAndNext(
			long timeTrackerId, String uuid, long companyId,
			OrderByComparator<TimeTracker> orderByComparator)
		throws NoSuchTimeTrackerException {

		uuid = Objects.toString(uuid, "");

		TimeTracker timeTracker = findByPrimaryKey(timeTrackerId);

		Session session = null;

		try {
			session = openSession();

			TimeTracker[] array = new TimeTrackerImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, timeTracker, uuid, companyId, orderByComparator, true);

			array[1] = timeTracker;

			array[2] = getByUuid_C_PrevAndNext(
				session, timeTracker, uuid, companyId, orderByComparator,
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

	protected TimeTracker getByUuid_C_PrevAndNext(
		Session session, TimeTracker timeTracker, String uuid, long companyId,
		OrderByComparator<TimeTracker> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TIMETRACKER_WHERE);

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
			sb.append(TimeTrackerModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(timeTracker)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TimeTracker> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the time trackers where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TimeTracker timeTracker :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(timeTracker);
		}
	}

	/**
	 * Returns the number of time trackers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching time trackers
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TIMETRACKER_WHERE);

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
		"timeTracker.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(timeTracker.uuid IS NULL OR timeTracker.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"timeTracker.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByTaskIdAndEmployeeId;
	private FinderPath _finderPathWithoutPaginationFindByTaskIdAndEmployeeId;
	private FinderPath _finderPathCountByTaskIdAndEmployeeId;

	/**
	 * Returns all the time trackers where taskId = &#63; and employeeId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @return the matching time trackers
	 */
	@Override
	public List<TimeTracker> findByTaskIdAndEmployeeId(
		long taskId, long employeeId) {

		return findByTaskIdAndEmployeeId(
			taskId, employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the time trackers where taskId = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @return the range of matching time trackers
	 */
	@Override
	public List<TimeTracker> findByTaskIdAndEmployeeId(
		long taskId, long employeeId, int start, int end) {

		return findByTaskIdAndEmployeeId(taskId, employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the time trackers where taskId = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching time trackers
	 */
	@Override
	public List<TimeTracker> findByTaskIdAndEmployeeId(
		long taskId, long employeeId, int start, int end,
		OrderByComparator<TimeTracker> orderByComparator) {

		return findByTaskIdAndEmployeeId(
			taskId, employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the time trackers where taskId = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching time trackers
	 */
	@Override
	public List<TimeTracker> findByTaskIdAndEmployeeId(
		long taskId, long employeeId, int start, int end,
		OrderByComparator<TimeTracker> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTaskIdAndEmployeeId;
				finderArgs = new Object[] {taskId, employeeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTaskIdAndEmployeeId;
			finderArgs = new Object[] {
				taskId, employeeId, start, end, orderByComparator
			};
		}

		List<TimeTracker> list = null;

		if (useFinderCache) {
			list = (List<TimeTracker>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TimeTracker timeTracker : list) {
					if ((taskId != timeTracker.getTaskId()) ||
						(employeeId != timeTracker.getEmployeeId())) {

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

			sb.append(_SQL_SELECT_TIMETRACKER_WHERE);

			sb.append(_FINDER_COLUMN_TASKIDANDEMPLOYEEID_TASKID_2);

			sb.append(_FINDER_COLUMN_TASKIDANDEMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TimeTrackerModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(taskId);

				queryPos.add(employeeId);

				list = (List<TimeTracker>)QueryUtil.list(
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
	 * Returns the first time tracker in the ordered set where taskId = &#63; and employeeId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	@Override
	public TimeTracker findByTaskIdAndEmployeeId_First(
			long taskId, long employeeId,
			OrderByComparator<TimeTracker> orderByComparator)
		throws NoSuchTimeTrackerException {

		TimeTracker timeTracker = fetchByTaskIdAndEmployeeId_First(
			taskId, employeeId, orderByComparator);

		if (timeTracker != null) {
			return timeTracker;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taskId=");
		sb.append(taskId);

		sb.append(", employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchTimeTrackerException(sb.toString());
	}

	/**
	 * Returns the first time tracker in the ordered set where taskId = &#63; and employeeId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	@Override
	public TimeTracker fetchByTaskIdAndEmployeeId_First(
		long taskId, long employeeId,
		OrderByComparator<TimeTracker> orderByComparator) {

		List<TimeTracker> list = findByTaskIdAndEmployeeId(
			taskId, employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last time tracker in the ordered set where taskId = &#63; and employeeId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	@Override
	public TimeTracker findByTaskIdAndEmployeeId_Last(
			long taskId, long employeeId,
			OrderByComparator<TimeTracker> orderByComparator)
		throws NoSuchTimeTrackerException {

		TimeTracker timeTracker = fetchByTaskIdAndEmployeeId_Last(
			taskId, employeeId, orderByComparator);

		if (timeTracker != null) {
			return timeTracker;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taskId=");
		sb.append(taskId);

		sb.append(", employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchTimeTrackerException(sb.toString());
	}

	/**
	 * Returns the last time tracker in the ordered set where taskId = &#63; and employeeId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	@Override
	public TimeTracker fetchByTaskIdAndEmployeeId_Last(
		long taskId, long employeeId,
		OrderByComparator<TimeTracker> orderByComparator) {

		int count = countByTaskIdAndEmployeeId(taskId, employeeId);

		if (count == 0) {
			return null;
		}

		List<TimeTracker> list = findByTaskIdAndEmployeeId(
			taskId, employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the time trackers before and after the current time tracker in the ordered set where taskId = &#63; and employeeId = &#63;.
	 *
	 * @param timeTrackerId the primary key of the current time tracker
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next time tracker
	 * @throws NoSuchTimeTrackerException if a time tracker with the primary key could not be found
	 */
	@Override
	public TimeTracker[] findByTaskIdAndEmployeeId_PrevAndNext(
			long timeTrackerId, long taskId, long employeeId,
			OrderByComparator<TimeTracker> orderByComparator)
		throws NoSuchTimeTrackerException {

		TimeTracker timeTracker = findByPrimaryKey(timeTrackerId);

		Session session = null;

		try {
			session = openSession();

			TimeTracker[] array = new TimeTrackerImpl[3];

			array[0] = getByTaskIdAndEmployeeId_PrevAndNext(
				session, timeTracker, taskId, employeeId, orderByComparator,
				true);

			array[1] = timeTracker;

			array[2] = getByTaskIdAndEmployeeId_PrevAndNext(
				session, timeTracker, taskId, employeeId, orderByComparator,
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

	protected TimeTracker getByTaskIdAndEmployeeId_PrevAndNext(
		Session session, TimeTracker timeTracker, long taskId, long employeeId,
		OrderByComparator<TimeTracker> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TIMETRACKER_WHERE);

		sb.append(_FINDER_COLUMN_TASKIDANDEMPLOYEEID_TASKID_2);

		sb.append(_FINDER_COLUMN_TASKIDANDEMPLOYEEID_EMPLOYEEID_2);

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
			sb.append(TimeTrackerModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(taskId);

		queryPos.add(employeeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(timeTracker)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TimeTracker> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the time trackers where taskId = &#63; and employeeId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByTaskIdAndEmployeeId(long taskId, long employeeId) {
		for (TimeTracker timeTracker :
				findByTaskIdAndEmployeeId(
					taskId, employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(timeTracker);
		}
	}

	/**
	 * Returns the number of time trackers where taskId = &#63; and employeeId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @return the number of matching time trackers
	 */
	@Override
	public int countByTaskIdAndEmployeeId(long taskId, long employeeId) {
		FinderPath finderPath = _finderPathCountByTaskIdAndEmployeeId;

		Object[] finderArgs = new Object[] {taskId, employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TIMETRACKER_WHERE);

			sb.append(_FINDER_COLUMN_TASKIDANDEMPLOYEEID_TASKID_2);

			sb.append(_FINDER_COLUMN_TASKIDANDEMPLOYEEID_EMPLOYEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(taskId);

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

	private static final String _FINDER_COLUMN_TASKIDANDEMPLOYEEID_TASKID_2 =
		"timeTracker.taskId = ? AND ";

	private static final String
		_FINDER_COLUMN_TASKIDANDEMPLOYEEID_EMPLOYEEID_2 =
			"timeTracker.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByTaskId;
	private FinderPath _finderPathWithoutPaginationFindByTaskId;
	private FinderPath _finderPathCountByTaskId;

	/**
	 * Returns all the time trackers where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching time trackers
	 */
	@Override
	public List<TimeTracker> findByTaskId(long taskId) {
		return findByTaskId(taskId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the time trackers where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @return the range of matching time trackers
	 */
	@Override
	public List<TimeTracker> findByTaskId(long taskId, int start, int end) {
		return findByTaskId(taskId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the time trackers where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching time trackers
	 */
	@Override
	public List<TimeTracker> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<TimeTracker> orderByComparator) {

		return findByTaskId(taskId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the time trackers where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching time trackers
	 */
	@Override
	public List<TimeTracker> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<TimeTracker> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTaskId;
				finderArgs = new Object[] {taskId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTaskId;
			finderArgs = new Object[] {taskId, start, end, orderByComparator};
		}

		List<TimeTracker> list = null;

		if (useFinderCache) {
			list = (List<TimeTracker>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TimeTracker timeTracker : list) {
					if (taskId != timeTracker.getTaskId()) {
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

			sb.append(_SQL_SELECT_TIMETRACKER_WHERE);

			sb.append(_FINDER_COLUMN_TASKID_TASKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TimeTrackerModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(taskId);

				list = (List<TimeTracker>)QueryUtil.list(
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
	 * Returns the first time tracker in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	@Override
	public TimeTracker findByTaskId_First(
			long taskId, OrderByComparator<TimeTracker> orderByComparator)
		throws NoSuchTimeTrackerException {

		TimeTracker timeTracker = fetchByTaskId_First(
			taskId, orderByComparator);

		if (timeTracker != null) {
			return timeTracker;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taskId=");
		sb.append(taskId);

		sb.append("}");

		throw new NoSuchTimeTrackerException(sb.toString());
	}

	/**
	 * Returns the first time tracker in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	@Override
	public TimeTracker fetchByTaskId_First(
		long taskId, OrderByComparator<TimeTracker> orderByComparator) {

		List<TimeTracker> list = findByTaskId(taskId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last time tracker in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	@Override
	public TimeTracker findByTaskId_Last(
			long taskId, OrderByComparator<TimeTracker> orderByComparator)
		throws NoSuchTimeTrackerException {

		TimeTracker timeTracker = fetchByTaskId_Last(taskId, orderByComparator);

		if (timeTracker != null) {
			return timeTracker;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taskId=");
		sb.append(taskId);

		sb.append("}");

		throw new NoSuchTimeTrackerException(sb.toString());
	}

	/**
	 * Returns the last time tracker in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	@Override
	public TimeTracker fetchByTaskId_Last(
		long taskId, OrderByComparator<TimeTracker> orderByComparator) {

		int count = countByTaskId(taskId);

		if (count == 0) {
			return null;
		}

		List<TimeTracker> list = findByTaskId(
			taskId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the time trackers before and after the current time tracker in the ordered set where taskId = &#63;.
	 *
	 * @param timeTrackerId the primary key of the current time tracker
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next time tracker
	 * @throws NoSuchTimeTrackerException if a time tracker with the primary key could not be found
	 */
	@Override
	public TimeTracker[] findByTaskId_PrevAndNext(
			long timeTrackerId, long taskId,
			OrderByComparator<TimeTracker> orderByComparator)
		throws NoSuchTimeTrackerException {

		TimeTracker timeTracker = findByPrimaryKey(timeTrackerId);

		Session session = null;

		try {
			session = openSession();

			TimeTracker[] array = new TimeTrackerImpl[3];

			array[0] = getByTaskId_PrevAndNext(
				session, timeTracker, taskId, orderByComparator, true);

			array[1] = timeTracker;

			array[2] = getByTaskId_PrevAndNext(
				session, timeTracker, taskId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TimeTracker getByTaskId_PrevAndNext(
		Session session, TimeTracker timeTracker, long taskId,
		OrderByComparator<TimeTracker> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TIMETRACKER_WHERE);

		sb.append(_FINDER_COLUMN_TASKID_TASKID_2);

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
			sb.append(TimeTrackerModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(taskId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(timeTracker)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TimeTracker> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the time trackers where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 */
	@Override
	public void removeByTaskId(long taskId) {
		for (TimeTracker timeTracker :
				findByTaskId(
					taskId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(timeTracker);
		}
	}

	/**
	 * Returns the number of time trackers where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching time trackers
	 */
	@Override
	public int countByTaskId(long taskId) {
		FinderPath finderPath = _finderPathCountByTaskId;

		Object[] finderArgs = new Object[] {taskId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TIMETRACKER_WHERE);

			sb.append(_FINDER_COLUMN_TASKID_TASKID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(taskId);

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

	private static final String _FINDER_COLUMN_TASKID_TASKID_2 =
		"timeTracker.taskId = ?";

	public TimeTrackerPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TimeTracker.class);

		setModelImplClass(TimeTrackerImpl.class);
		setModelPKClass(long.class);

		setTable(TimeTrackerTable.INSTANCE);
	}

	/**
	 * Caches the time tracker in the entity cache if it is enabled.
	 *
	 * @param timeTracker the time tracker
	 */
	@Override
	public void cacheResult(TimeTracker timeTracker) {
		entityCache.putResult(
			TimeTrackerImpl.class, timeTracker.getPrimaryKey(), timeTracker);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {timeTracker.getUuid(), timeTracker.getGroupId()},
			timeTracker);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the time trackers in the entity cache if it is enabled.
	 *
	 * @param timeTrackers the time trackers
	 */
	@Override
	public void cacheResult(List<TimeTracker> timeTrackers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (timeTrackers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TimeTracker timeTracker : timeTrackers) {
			if (entityCache.getResult(
					TimeTrackerImpl.class, timeTracker.getPrimaryKey()) ==
						null) {

				cacheResult(timeTracker);
			}
		}
	}

	/**
	 * Clears the cache for all time trackers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TimeTrackerImpl.class);

		finderCache.clearCache(TimeTrackerImpl.class);
	}

	/**
	 * Clears the cache for the time tracker.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TimeTracker timeTracker) {
		entityCache.removeResult(TimeTrackerImpl.class, timeTracker);
	}

	@Override
	public void clearCache(List<TimeTracker> timeTrackers) {
		for (TimeTracker timeTracker : timeTrackers) {
			entityCache.removeResult(TimeTrackerImpl.class, timeTracker);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TimeTrackerImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TimeTrackerImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TimeTrackerModelImpl timeTrackerModelImpl) {

		Object[] args = new Object[] {
			timeTrackerModelImpl.getUuid(), timeTrackerModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, timeTrackerModelImpl);
	}

	/**
	 * Creates a new time tracker with the primary key. Does not add the time tracker to the database.
	 *
	 * @param timeTrackerId the primary key for the new time tracker
	 * @return the new time tracker
	 */
	@Override
	public TimeTracker create(long timeTrackerId) {
		TimeTracker timeTracker = new TimeTrackerImpl();

		timeTracker.setNew(true);
		timeTracker.setPrimaryKey(timeTrackerId);

		String uuid = PortalUUIDUtil.generate();

		timeTracker.setUuid(uuid);

		timeTracker.setCompanyId(CompanyThreadLocal.getCompanyId());

		return timeTracker;
	}

	/**
	 * Removes the time tracker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param timeTrackerId the primary key of the time tracker
	 * @return the time tracker that was removed
	 * @throws NoSuchTimeTrackerException if a time tracker with the primary key could not be found
	 */
	@Override
	public TimeTracker remove(long timeTrackerId)
		throws NoSuchTimeTrackerException {

		return remove((Serializable)timeTrackerId);
	}

	/**
	 * Removes the time tracker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the time tracker
	 * @return the time tracker that was removed
	 * @throws NoSuchTimeTrackerException if a time tracker with the primary key could not be found
	 */
	@Override
	public TimeTracker remove(Serializable primaryKey)
		throws NoSuchTimeTrackerException {

		Session session = null;

		try {
			session = openSession();

			TimeTracker timeTracker = (TimeTracker)session.get(
				TimeTrackerImpl.class, primaryKey);

			if (timeTracker == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTimeTrackerException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(timeTracker);
		}
		catch (NoSuchTimeTrackerException noSuchEntityException) {
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
	protected TimeTracker removeImpl(TimeTracker timeTracker) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(timeTracker)) {
				timeTracker = (TimeTracker)session.get(
					TimeTrackerImpl.class, timeTracker.getPrimaryKeyObj());
			}

			if (timeTracker != null) {
				session.delete(timeTracker);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (timeTracker != null) {
			clearCache(timeTracker);
		}

		return timeTracker;
	}

	@Override
	public TimeTracker updateImpl(TimeTracker timeTracker) {
		boolean isNew = timeTracker.isNew();

		if (!(timeTracker instanceof TimeTrackerModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(timeTracker.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(timeTracker);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in timeTracker proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TimeTracker implementation " +
					timeTracker.getClass());
		}

		TimeTrackerModelImpl timeTrackerModelImpl =
			(TimeTrackerModelImpl)timeTracker;

		if (Validator.isNull(timeTracker.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			timeTracker.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (timeTracker.getCreateDate() == null)) {
			if (serviceContext == null) {
				timeTracker.setCreateDate(date);
			}
			else {
				timeTracker.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!timeTrackerModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				timeTracker.setModifiedDate(date);
			}
			else {
				timeTracker.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(timeTracker);
			}
			else {
				timeTracker = (TimeTracker)session.merge(timeTracker);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TimeTrackerImpl.class, timeTrackerModelImpl, false, true);

		cacheUniqueFindersCache(timeTrackerModelImpl);

		if (isNew) {
			timeTracker.setNew(false);
		}

		timeTracker.resetOriginalValues();

		return timeTracker;
	}

	/**
	 * Returns the time tracker with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the time tracker
	 * @return the time tracker
	 * @throws NoSuchTimeTrackerException if a time tracker with the primary key could not be found
	 */
	@Override
	public TimeTracker findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTimeTrackerException {

		TimeTracker timeTracker = fetchByPrimaryKey(primaryKey);

		if (timeTracker == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTimeTrackerException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return timeTracker;
	}

	/**
	 * Returns the time tracker with the primary key or throws a <code>NoSuchTimeTrackerException</code> if it could not be found.
	 *
	 * @param timeTrackerId the primary key of the time tracker
	 * @return the time tracker
	 * @throws NoSuchTimeTrackerException if a time tracker with the primary key could not be found
	 */
	@Override
	public TimeTracker findByPrimaryKey(long timeTrackerId)
		throws NoSuchTimeTrackerException {

		return findByPrimaryKey((Serializable)timeTrackerId);
	}

	/**
	 * Returns the time tracker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param timeTrackerId the primary key of the time tracker
	 * @return the time tracker, or <code>null</code> if a time tracker with the primary key could not be found
	 */
	@Override
	public TimeTracker fetchByPrimaryKey(long timeTrackerId) {
		return fetchByPrimaryKey((Serializable)timeTrackerId);
	}

	/**
	 * Returns all the time trackers.
	 *
	 * @return the time trackers
	 */
	@Override
	public List<TimeTracker> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the time trackers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @return the range of time trackers
	 */
	@Override
	public List<TimeTracker> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the time trackers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of time trackers
	 */
	@Override
	public List<TimeTracker> findAll(
		int start, int end, OrderByComparator<TimeTracker> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the time trackers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of time trackers
	 */
	@Override
	public List<TimeTracker> findAll(
		int start, int end, OrderByComparator<TimeTracker> orderByComparator,
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

		List<TimeTracker> list = null;

		if (useFinderCache) {
			list = (List<TimeTracker>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TIMETRACKER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TIMETRACKER;

				sql = sql.concat(TimeTrackerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TimeTracker>)QueryUtil.list(
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
	 * Removes all the time trackers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TimeTracker timeTracker : findAll()) {
			remove(timeTracker);
		}
	}

	/**
	 * Returns the number of time trackers.
	 *
	 * @return the number of time trackers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TIMETRACKER);

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
		return "timeTrackerId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TIMETRACKER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TimeTrackerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the time tracker persistence.
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

		_finderPathWithPaginationFindByTaskIdAndEmployeeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTaskIdAndEmployeeId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"taskId", "employeeId"}, true);

		_finderPathWithoutPaginationFindByTaskIdAndEmployeeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTaskIdAndEmployeeId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"taskId", "employeeId"}, true);

		_finderPathCountByTaskIdAndEmployeeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTaskIdAndEmployeeId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"taskId", "employeeId"}, false);

		_finderPathWithPaginationFindByTaskId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTaskId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"taskId"}, true);

		_finderPathWithoutPaginationFindByTaskId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTaskId",
			new String[] {Long.class.getName()}, new String[] {"taskId"}, true);

		_finderPathCountByTaskId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTaskId",
			new String[] {Long.class.getName()}, new String[] {"taskId"},
			false);

		TimeTrackerUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		TimeTrackerUtil.setPersistence(null);

		entityCache.removeCache(TimeTrackerImpl.class.getName());
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

	private static final String _SQL_SELECT_TIMETRACKER =
		"SELECT timeTracker FROM TimeTracker timeTracker";

	private static final String _SQL_SELECT_TIMETRACKER_WHERE =
		"SELECT timeTracker FROM TimeTracker timeTracker WHERE ";

	private static final String _SQL_COUNT_TIMETRACKER =
		"SELECT COUNT(timeTracker) FROM TimeTracker timeTracker";

	private static final String _SQL_COUNT_TIMETRACKER_WHERE =
		"SELECT COUNT(timeTracker) FROM TimeTracker timeTracker WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "timeTracker.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TimeTracker exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TimeTracker exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TimeTrackerPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}