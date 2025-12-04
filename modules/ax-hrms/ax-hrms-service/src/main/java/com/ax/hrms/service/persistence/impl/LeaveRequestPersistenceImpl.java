/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchLeaveRequestException;
import com.ax.hrms.model.LeaveRequest;
import com.ax.hrms.model.LeaveRequestTable;
import com.ax.hrms.model.impl.LeaveRequestImpl;
import com.ax.hrms.model.impl.LeaveRequestModelImpl;
import com.ax.hrms.service.persistence.LeaveRequestPersistence;
import com.ax.hrms.service.persistence.LeaveRequestUtil;
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
 * The persistence implementation for the leave request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LeaveRequestPersistence.class)
public class LeaveRequestPersistenceImpl
	extends BasePersistenceImpl<LeaveRequest>
	implements LeaveRequestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LeaveRequestUtil</code> to access the leave request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LeaveRequestImpl.class.getName();

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
	 * Returns all the leave requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave requests
	 */
	@Override
	public List<LeaveRequest> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave requests
	 * @param end the upper bound of the range of leave requests (not inclusive)
	 * @return the range of matching leave requests
	 */
	@Override
	public List<LeaveRequest> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave requests
	 * @param end the upper bound of the range of leave requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave requests
	 */
	@Override
	public List<LeaveRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveRequest> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave requests
	 * @param end the upper bound of the range of leave requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave requests
	 */
	@Override
	public List<LeaveRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveRequest> orderByComparator,
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

		List<LeaveRequest> list = null;

		if (useFinderCache) {
			list = (List<LeaveRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveRequest leaveRequest : list) {
					if (!uuid.equals(leaveRequest.getUuid())) {
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

			sb.append(_SQL_SELECT_LEAVEREQUEST_WHERE);

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
				sb.append(LeaveRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<LeaveRequest>)QueryUtil.list(
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
	 * Returns the first leave request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave request
	 * @throws NoSuchLeaveRequestException if a matching leave request could not be found
	 */
	@Override
	public LeaveRequest findByUuid_First(
			String uuid, OrderByComparator<LeaveRequest> orderByComparator)
		throws NoSuchLeaveRequestException {

		LeaveRequest leaveRequest = fetchByUuid_First(uuid, orderByComparator);

		if (leaveRequest != null) {
			return leaveRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLeaveRequestException(sb.toString());
	}

	/**
	 * Returns the first leave request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave request, or <code>null</code> if a matching leave request could not be found
	 */
	@Override
	public LeaveRequest fetchByUuid_First(
		String uuid, OrderByComparator<LeaveRequest> orderByComparator) {

		List<LeaveRequest> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave request
	 * @throws NoSuchLeaveRequestException if a matching leave request could not be found
	 */
	@Override
	public LeaveRequest findByUuid_Last(
			String uuid, OrderByComparator<LeaveRequest> orderByComparator)
		throws NoSuchLeaveRequestException {

		LeaveRequest leaveRequest = fetchByUuid_Last(uuid, orderByComparator);

		if (leaveRequest != null) {
			return leaveRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLeaveRequestException(sb.toString());
	}

	/**
	 * Returns the last leave request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave request, or <code>null</code> if a matching leave request could not be found
	 */
	@Override
	public LeaveRequest fetchByUuid_Last(
		String uuid, OrderByComparator<LeaveRequest> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<LeaveRequest> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave requests before and after the current leave request in the ordered set where uuid = &#63;.
	 *
	 * @param leaveRequestId the primary key of the current leave request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave request
	 * @throws NoSuchLeaveRequestException if a leave request with the primary key could not be found
	 */
	@Override
	public LeaveRequest[] findByUuid_PrevAndNext(
			long leaveRequestId, String uuid,
			OrderByComparator<LeaveRequest> orderByComparator)
		throws NoSuchLeaveRequestException {

		uuid = Objects.toString(uuid, "");

		LeaveRequest leaveRequest = findByPrimaryKey(leaveRequestId);

		Session session = null;

		try {
			session = openSession();

			LeaveRequest[] array = new LeaveRequestImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, leaveRequest, uuid, orderByComparator, true);

			array[1] = leaveRequest;

			array[2] = getByUuid_PrevAndNext(
				session, leaveRequest, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveRequest getByUuid_PrevAndNext(
		Session session, LeaveRequest leaveRequest, String uuid,
		OrderByComparator<LeaveRequest> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LEAVEREQUEST_WHERE);

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
			sb.append(LeaveRequestModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(leaveRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (LeaveRequest leaveRequest :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leaveRequest);
		}
	}

	/**
	 * Returns the number of leave requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave requests
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVEREQUEST_WHERE);

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
		"leaveRequest.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(leaveRequest.uuid IS NULL OR leaveRequest.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the leave request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave request
	 * @throws NoSuchLeaveRequestException if a matching leave request could not be found
	 */
	@Override
	public LeaveRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveRequestException {

		LeaveRequest leaveRequest = fetchByUUID_G(uuid, groupId);

		if (leaveRequest == null) {
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

			throw new NoSuchLeaveRequestException(sb.toString());
		}

		return leaveRequest;
	}

	/**
	 * Returns the leave request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave request, or <code>null</code> if a matching leave request could not be found
	 */
	@Override
	public LeaveRequest fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the leave request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave request, or <code>null</code> if a matching leave request could not be found
	 */
	@Override
	public LeaveRequest fetchByUUID_G(
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

		if (result instanceof LeaveRequest) {
			LeaveRequest leaveRequest = (LeaveRequest)result;

			if (!Objects.equals(uuid, leaveRequest.getUuid()) ||
				(groupId != leaveRequest.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LEAVEREQUEST_WHERE);

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

				List<LeaveRequest> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					LeaveRequest leaveRequest = list.get(0);

					result = leaveRequest;

					cacheResult(leaveRequest);
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
			return (LeaveRequest)result;
		}
	}

	/**
	 * Removes the leave request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave request that was removed
	 */
	@Override
	public LeaveRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveRequestException {

		LeaveRequest leaveRequest = findByUUID_G(uuid, groupId);

		return remove(leaveRequest);
	}

	/**
	 * Returns the number of leave requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave requests
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		LeaveRequest leaveRequest = fetchByUUID_G(uuid, groupId);

		if (leaveRequest == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"leaveRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(leaveRequest.uuid IS NULL OR leaveRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"leaveRequest.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the leave requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave requests
	 */
	@Override
	public List<LeaveRequest> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave requests
	 * @param end the upper bound of the range of leave requests (not inclusive)
	 * @return the range of matching leave requests
	 */
	@Override
	public List<LeaveRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave requests
	 * @param end the upper bound of the range of leave requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave requests
	 */
	@Override
	public List<LeaveRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveRequest> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave requests
	 * @param end the upper bound of the range of leave requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave requests
	 */
	@Override
	public List<LeaveRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveRequest> orderByComparator,
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

		List<LeaveRequest> list = null;

		if (useFinderCache) {
			list = (List<LeaveRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveRequest leaveRequest : list) {
					if (!uuid.equals(leaveRequest.getUuid()) ||
						(companyId != leaveRequest.getCompanyId())) {

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

			sb.append(_SQL_SELECT_LEAVEREQUEST_WHERE);

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
				sb.append(LeaveRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<LeaveRequest>)QueryUtil.list(
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
	 * Returns the first leave request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave request
	 * @throws NoSuchLeaveRequestException if a matching leave request could not be found
	 */
	@Override
	public LeaveRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LeaveRequest> orderByComparator)
		throws NoSuchLeaveRequestException {

		LeaveRequest leaveRequest = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (leaveRequest != null) {
			return leaveRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLeaveRequestException(sb.toString());
	}

	/**
	 * Returns the first leave request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave request, or <code>null</code> if a matching leave request could not be found
	 */
	@Override
	public LeaveRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LeaveRequest> orderByComparator) {

		List<LeaveRequest> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave request
	 * @throws NoSuchLeaveRequestException if a matching leave request could not be found
	 */
	@Override
	public LeaveRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LeaveRequest> orderByComparator)
		throws NoSuchLeaveRequestException {

		LeaveRequest leaveRequest = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (leaveRequest != null) {
			return leaveRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLeaveRequestException(sb.toString());
	}

	/**
	 * Returns the last leave request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave request, or <code>null</code> if a matching leave request could not be found
	 */
	@Override
	public LeaveRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LeaveRequest> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<LeaveRequest> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave requests before and after the current leave request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveRequestId the primary key of the current leave request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave request
	 * @throws NoSuchLeaveRequestException if a leave request with the primary key could not be found
	 */
	@Override
	public LeaveRequest[] findByUuid_C_PrevAndNext(
			long leaveRequestId, String uuid, long companyId,
			OrderByComparator<LeaveRequest> orderByComparator)
		throws NoSuchLeaveRequestException {

		uuid = Objects.toString(uuid, "");

		LeaveRequest leaveRequest = findByPrimaryKey(leaveRequestId);

		Session session = null;

		try {
			session = openSession();

			LeaveRequest[] array = new LeaveRequestImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, leaveRequest, uuid, companyId, orderByComparator,
				true);

			array[1] = leaveRequest;

			array[2] = getByUuid_C_PrevAndNext(
				session, leaveRequest, uuid, companyId, orderByComparator,
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

	protected LeaveRequest getByUuid_C_PrevAndNext(
		Session session, LeaveRequest leaveRequest, String uuid, long companyId,
		OrderByComparator<LeaveRequest> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LEAVEREQUEST_WHERE);

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
			sb.append(LeaveRequestModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(leaveRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (LeaveRequest leaveRequest :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(leaveRequest);
		}
	}

	/**
	 * Returns the number of leave requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave requests
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVEREQUEST_WHERE);

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
		"leaveRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(leaveRequest.uuid IS NULL OR leaveRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"leaveRequest.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByEmployeeId;
	private FinderPath _finderPathWithoutPaginationFindByEmployeeId;
	private FinderPath _finderPathCountByEmployeeId;

	/**
	 * Returns all the leave requests where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching leave requests
	 */
	@Override
	public List<LeaveRequest> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave requests where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of leave requests
	 * @param end the upper bound of the range of leave requests (not inclusive)
	 * @return the range of matching leave requests
	 */
	@Override
	public List<LeaveRequest> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave requests where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of leave requests
	 * @param end the upper bound of the range of leave requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave requests
	 */
	@Override
	public List<LeaveRequest> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<LeaveRequest> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave requests where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of leave requests
	 * @param end the upper bound of the range of leave requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave requests
	 */
	@Override
	public List<LeaveRequest> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<LeaveRequest> orderByComparator,
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

		List<LeaveRequest> list = null;

		if (useFinderCache) {
			list = (List<LeaveRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveRequest leaveRequest : list) {
					if (employeeId != leaveRequest.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_LEAVEREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LeaveRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<LeaveRequest>)QueryUtil.list(
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
	 * Returns the first leave request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave request
	 * @throws NoSuchLeaveRequestException if a matching leave request could not be found
	 */
	@Override
	public LeaveRequest findByEmployeeId_First(
			long employeeId, OrderByComparator<LeaveRequest> orderByComparator)
		throws NoSuchLeaveRequestException {

		LeaveRequest leaveRequest = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (leaveRequest != null) {
			return leaveRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchLeaveRequestException(sb.toString());
	}

	/**
	 * Returns the first leave request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave request, or <code>null</code> if a matching leave request could not be found
	 */
	@Override
	public LeaveRequest fetchByEmployeeId_First(
		long employeeId, OrderByComparator<LeaveRequest> orderByComparator) {

		List<LeaveRequest> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave request
	 * @throws NoSuchLeaveRequestException if a matching leave request could not be found
	 */
	@Override
	public LeaveRequest findByEmployeeId_Last(
			long employeeId, OrderByComparator<LeaveRequest> orderByComparator)
		throws NoSuchLeaveRequestException {

		LeaveRequest leaveRequest = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (leaveRequest != null) {
			return leaveRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchLeaveRequestException(sb.toString());
	}

	/**
	 * Returns the last leave request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave request, or <code>null</code> if a matching leave request could not be found
	 */
	@Override
	public LeaveRequest fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<LeaveRequest> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<LeaveRequest> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave requests before and after the current leave request in the ordered set where employeeId = &#63;.
	 *
	 * @param leaveRequestId the primary key of the current leave request
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave request
	 * @throws NoSuchLeaveRequestException if a leave request with the primary key could not be found
	 */
	@Override
	public LeaveRequest[] findByEmployeeId_PrevAndNext(
			long leaveRequestId, long employeeId,
			OrderByComparator<LeaveRequest> orderByComparator)
		throws NoSuchLeaveRequestException {

		LeaveRequest leaveRequest = findByPrimaryKey(leaveRequestId);

		Session session = null;

		try {
			session = openSession();

			LeaveRequest[] array = new LeaveRequestImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, leaveRequest, employeeId, orderByComparator, true);

			array[1] = leaveRequest;

			array[2] = getByEmployeeId_PrevAndNext(
				session, leaveRequest, employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveRequest getByEmployeeId_PrevAndNext(
		Session session, LeaveRequest leaveRequest, long employeeId,
		OrderByComparator<LeaveRequest> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LEAVEREQUEST_WHERE);

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
			sb.append(LeaveRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(employeeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(leaveRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave requests where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (LeaveRequest leaveRequest :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leaveRequest);
		}
	}

	/**
	 * Returns the number of leave requests where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching leave requests
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVEREQUEST_WHERE);

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
		"leaveRequest.employeeId = ?";

	private FinderPath _finderPathFetchByleaveRequestId;

	/**
	 * Returns the leave request where leaveRequestId = &#63; or throws a <code>NoSuchLeaveRequestException</code> if it could not be found.
	 *
	 * @param leaveRequestId the leave request ID
	 * @return the matching leave request
	 * @throws NoSuchLeaveRequestException if a matching leave request could not be found
	 */
	@Override
	public LeaveRequest findByleaveRequestId(long leaveRequestId)
		throws NoSuchLeaveRequestException {

		LeaveRequest leaveRequest = fetchByleaveRequestId(leaveRequestId);

		if (leaveRequest == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("leaveRequestId=");
			sb.append(leaveRequestId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLeaveRequestException(sb.toString());
		}

		return leaveRequest;
	}

	/**
	 * Returns the leave request where leaveRequestId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveRequestId the leave request ID
	 * @return the matching leave request, or <code>null</code> if a matching leave request could not be found
	 */
	@Override
	public LeaveRequest fetchByleaveRequestId(long leaveRequestId) {
		return fetchByleaveRequestId(leaveRequestId, true);
	}

	/**
	 * Returns the leave request where leaveRequestId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave request, or <code>null</code> if a matching leave request could not be found
	 */
	@Override
	public LeaveRequest fetchByleaveRequestId(
		long leaveRequestId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {leaveRequestId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByleaveRequestId, finderArgs, this);
		}

		if (result instanceof LeaveRequest) {
			LeaveRequest leaveRequest = (LeaveRequest)result;

			if (leaveRequestId != leaveRequest.getLeaveRequestId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_LEAVEREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(leaveRequestId);

				List<LeaveRequest> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByleaveRequestId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {leaveRequestId};
							}

							_log.warn(
								"LeaveRequestPersistenceImpl.fetchByleaveRequestId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LeaveRequest leaveRequest = list.get(0);

					result = leaveRequest;

					cacheResult(leaveRequest);
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
			return (LeaveRequest)result;
		}
	}

	/**
	 * Removes the leave request where leaveRequestId = &#63; from the database.
	 *
	 * @param leaveRequestId the leave request ID
	 * @return the leave request that was removed
	 */
	@Override
	public LeaveRequest removeByleaveRequestId(long leaveRequestId)
		throws NoSuchLeaveRequestException {

		LeaveRequest leaveRequest = findByleaveRequestId(leaveRequestId);

		return remove(leaveRequest);
	}

	/**
	 * Returns the number of leave requests where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @return the number of matching leave requests
	 */
	@Override
	public int countByleaveRequestId(long leaveRequestId) {
		LeaveRequest leaveRequest = fetchByleaveRequestId(leaveRequestId);

		if (leaveRequest == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_2 =
		"leaveRequest.leaveRequestId = ?";

	public LeaveRequestPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(LeaveRequest.class);

		setModelImplClass(LeaveRequestImpl.class);
		setModelPKClass(long.class);

		setTable(LeaveRequestTable.INSTANCE);
	}

	/**
	 * Caches the leave request in the entity cache if it is enabled.
	 *
	 * @param leaveRequest the leave request
	 */
	@Override
	public void cacheResult(LeaveRequest leaveRequest) {
		entityCache.putResult(
			LeaveRequestImpl.class, leaveRequest.getPrimaryKey(), leaveRequest);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {leaveRequest.getUuid(), leaveRequest.getGroupId()},
			leaveRequest);

		finderCache.putResult(
			_finderPathFetchByleaveRequestId,
			new Object[] {leaveRequest.getLeaveRequestId()}, leaveRequest);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the leave requests in the entity cache if it is enabled.
	 *
	 * @param leaveRequests the leave requests
	 */
	@Override
	public void cacheResult(List<LeaveRequest> leaveRequests) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (leaveRequests.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LeaveRequest leaveRequest : leaveRequests) {
			if (entityCache.getResult(
					LeaveRequestImpl.class, leaveRequest.getPrimaryKey()) ==
						null) {

				cacheResult(leaveRequest);
			}
		}
	}

	/**
	 * Clears the cache for all leave requests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LeaveRequestImpl.class);

		finderCache.clearCache(LeaveRequestImpl.class);
	}

	/**
	 * Clears the cache for the leave request.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveRequest leaveRequest) {
		entityCache.removeResult(LeaveRequestImpl.class, leaveRequest);
	}

	@Override
	public void clearCache(List<LeaveRequest> leaveRequests) {
		for (LeaveRequest leaveRequest : leaveRequests) {
			entityCache.removeResult(LeaveRequestImpl.class, leaveRequest);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LeaveRequestImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LeaveRequestImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LeaveRequestModelImpl leaveRequestModelImpl) {

		Object[] args = new Object[] {
			leaveRequestModelImpl.getUuid(), leaveRequestModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, leaveRequestModelImpl);

		args = new Object[] {leaveRequestModelImpl.getLeaveRequestId()};

		finderCache.putResult(
			_finderPathFetchByleaveRequestId, args, leaveRequestModelImpl);
	}

	/**
	 * Creates a new leave request with the primary key. Does not add the leave request to the database.
	 *
	 * @param leaveRequestId the primary key for the new leave request
	 * @return the new leave request
	 */
	@Override
	public LeaveRequest create(long leaveRequestId) {
		LeaveRequest leaveRequest = new LeaveRequestImpl();

		leaveRequest.setNew(true);
		leaveRequest.setPrimaryKey(leaveRequestId);

		String uuid = PortalUUIDUtil.generate();

		leaveRequest.setUuid(uuid);

		leaveRequest.setCompanyId(CompanyThreadLocal.getCompanyId());

		return leaveRequest;
	}

	/**
	 * Removes the leave request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveRequestId the primary key of the leave request
	 * @return the leave request that was removed
	 * @throws NoSuchLeaveRequestException if a leave request with the primary key could not be found
	 */
	@Override
	public LeaveRequest remove(long leaveRequestId)
		throws NoSuchLeaveRequestException {

		return remove((Serializable)leaveRequestId);
	}

	/**
	 * Removes the leave request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave request
	 * @return the leave request that was removed
	 * @throws NoSuchLeaveRequestException if a leave request with the primary key could not be found
	 */
	@Override
	public LeaveRequest remove(Serializable primaryKey)
		throws NoSuchLeaveRequestException {

		Session session = null;

		try {
			session = openSession();

			LeaveRequest leaveRequest = (LeaveRequest)session.get(
				LeaveRequestImpl.class, primaryKey);

			if (leaveRequest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveRequestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(leaveRequest);
		}
		catch (NoSuchLeaveRequestException noSuchEntityException) {
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
	protected LeaveRequest removeImpl(LeaveRequest leaveRequest) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveRequest)) {
				leaveRequest = (LeaveRequest)session.get(
					LeaveRequestImpl.class, leaveRequest.getPrimaryKeyObj());
			}

			if (leaveRequest != null) {
				session.delete(leaveRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (leaveRequest != null) {
			clearCache(leaveRequest);
		}

		return leaveRequest;
	}

	@Override
	public LeaveRequest updateImpl(LeaveRequest leaveRequest) {
		boolean isNew = leaveRequest.isNew();

		if (!(leaveRequest instanceof LeaveRequestModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(leaveRequest.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					leaveRequest);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in leaveRequest proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LeaveRequest implementation " +
					leaveRequest.getClass());
		}

		LeaveRequestModelImpl leaveRequestModelImpl =
			(LeaveRequestModelImpl)leaveRequest;

		if (Validator.isNull(leaveRequest.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			leaveRequest.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (leaveRequest.getCreateDate() == null)) {
			if (serviceContext == null) {
				leaveRequest.setCreateDate(date);
			}
			else {
				leaveRequest.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!leaveRequestModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				leaveRequest.setModifiedDate(date);
			}
			else {
				leaveRequest.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(leaveRequest);
			}
			else {
				leaveRequest = (LeaveRequest)session.merge(leaveRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LeaveRequestImpl.class, leaveRequestModelImpl, false, true);

		cacheUniqueFindersCache(leaveRequestModelImpl);

		if (isNew) {
			leaveRequest.setNew(false);
		}

		leaveRequest.resetOriginalValues();

		return leaveRequest;
	}

	/**
	 * Returns the leave request with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave request
	 * @return the leave request
	 * @throws NoSuchLeaveRequestException if a leave request with the primary key could not be found
	 */
	@Override
	public LeaveRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveRequestException {

		LeaveRequest leaveRequest = fetchByPrimaryKey(primaryKey);

		if (leaveRequest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveRequestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return leaveRequest;
	}

	/**
	 * Returns the leave request with the primary key or throws a <code>NoSuchLeaveRequestException</code> if it could not be found.
	 *
	 * @param leaveRequestId the primary key of the leave request
	 * @return the leave request
	 * @throws NoSuchLeaveRequestException if a leave request with the primary key could not be found
	 */
	@Override
	public LeaveRequest findByPrimaryKey(long leaveRequestId)
		throws NoSuchLeaveRequestException {

		return findByPrimaryKey((Serializable)leaveRequestId);
	}

	/**
	 * Returns the leave request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveRequestId the primary key of the leave request
	 * @return the leave request, or <code>null</code> if a leave request with the primary key could not be found
	 */
	@Override
	public LeaveRequest fetchByPrimaryKey(long leaveRequestId) {
		return fetchByPrimaryKey((Serializable)leaveRequestId);
	}

	/**
	 * Returns all the leave requests.
	 *
	 * @return the leave requests
	 */
	@Override
	public List<LeaveRequest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave requests
	 * @param end the upper bound of the range of leave requests (not inclusive)
	 * @return the range of leave requests
	 */
	@Override
	public List<LeaveRequest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave requests
	 * @param end the upper bound of the range of leave requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave requests
	 */
	@Override
	public List<LeaveRequest> findAll(
		int start, int end, OrderByComparator<LeaveRequest> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave requests
	 * @param end the upper bound of the range of leave requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave requests
	 */
	@Override
	public List<LeaveRequest> findAll(
		int start, int end, OrderByComparator<LeaveRequest> orderByComparator,
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

		List<LeaveRequest> list = null;

		if (useFinderCache) {
			list = (List<LeaveRequest>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LEAVEREQUEST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVEREQUEST;

				sql = sql.concat(LeaveRequestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LeaveRequest>)QueryUtil.list(
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
	 * Removes all the leave requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LeaveRequest leaveRequest : findAll()) {
			remove(leaveRequest);
		}
	}

	/**
	 * Returns the number of leave requests.
	 *
	 * @return the number of leave requests
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LEAVEREQUEST);

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
		return "leaveRequestId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEAVEREQUEST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LeaveRequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leave request persistence.
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

		_finderPathFetchByleaveRequestId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByleaveRequestId",
			new String[] {Long.class.getName()},
			new String[] {"leaveRequestId"}, true);

		LeaveRequestUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		LeaveRequestUtil.setPersistence(null);

		entityCache.removeCache(LeaveRequestImpl.class.getName());
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

	private static final String _SQL_SELECT_LEAVEREQUEST =
		"SELECT leaveRequest FROM LeaveRequest leaveRequest";

	private static final String _SQL_SELECT_LEAVEREQUEST_WHERE =
		"SELECT leaveRequest FROM LeaveRequest leaveRequest WHERE ";

	private static final String _SQL_COUNT_LEAVEREQUEST =
		"SELECT COUNT(leaveRequest) FROM LeaveRequest leaveRequest";

	private static final String _SQL_COUNT_LEAVEREQUEST_WHERE =
		"SELECT COUNT(leaveRequest) FROM LeaveRequest leaveRequest WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveRequest.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LeaveRequest exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LeaveRequest exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LeaveRequestPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}