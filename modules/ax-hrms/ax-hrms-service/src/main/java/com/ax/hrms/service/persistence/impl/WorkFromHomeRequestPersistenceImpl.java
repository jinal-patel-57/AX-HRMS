/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchWorkFromHomeRequestException;
import com.ax.hrms.model.WorkFromHomeRequest;
import com.ax.hrms.model.WorkFromHomeRequestTable;
import com.ax.hrms.model.impl.WorkFromHomeRequestImpl;
import com.ax.hrms.model.impl.WorkFromHomeRequestModelImpl;
import com.ax.hrms.service.persistence.WorkFromHomeRequestPersistence;
import com.ax.hrms.service.persistence.WorkFromHomeRequestUtil;
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

import java.sql.Timestamp;

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
 * The persistence implementation for the work from home request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = WorkFromHomeRequestPersistence.class)
public class WorkFromHomeRequestPersistenceImpl
	extends BasePersistenceImpl<WorkFromHomeRequest>
	implements WorkFromHomeRequestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>WorkFromHomeRequestUtil</code> to access the work from home request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		WorkFromHomeRequestImpl.class.getName();

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
	 * Returns all the work from home requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work from home requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @return the range of matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work from home requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work from home requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator,
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

		List<WorkFromHomeRequest> list = null;

		if (useFinderCache) {
			list = (List<WorkFromHomeRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkFromHomeRequest workFromHomeRequest : list) {
					if (!uuid.equals(workFromHomeRequest.getUuid())) {
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

			sb.append(_SQL_SELECT_WORKFROMHOMEREQUEST_WHERE);

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
				sb.append(WorkFromHomeRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<WorkFromHomeRequest>)QueryUtil.list(
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
	 * Returns the first work from home request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest findByUuid_First(
			String uuid,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException {

		WorkFromHomeRequest workFromHomeRequest = fetchByUuid_First(
			uuid, orderByComparator);

		if (workFromHomeRequest != null) {
			return workFromHomeRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchWorkFromHomeRequestException(sb.toString());
	}

	/**
	 * Returns the first work from home request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest fetchByUuid_First(
		String uuid, OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		List<WorkFromHomeRequest> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work from home request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest findByUuid_Last(
			String uuid,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException {

		WorkFromHomeRequest workFromHomeRequest = fetchByUuid_Last(
			uuid, orderByComparator);

		if (workFromHomeRequest != null) {
			return workFromHomeRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchWorkFromHomeRequestException(sb.toString());
	}

	/**
	 * Returns the last work from home request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest fetchByUuid_Last(
		String uuid, OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<WorkFromHomeRequest> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work from home requests before and after the current work from home request in the ordered set where uuid = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	@Override
	public WorkFromHomeRequest[] findByUuid_PrevAndNext(
			long workFromHomeRequestId, String uuid,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException {

		uuid = Objects.toString(uuid, "");

		WorkFromHomeRequest workFromHomeRequest = findByPrimaryKey(
			workFromHomeRequestId);

		Session session = null;

		try {
			session = openSession();

			WorkFromHomeRequest[] array = new WorkFromHomeRequestImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, workFromHomeRequest, uuid, orderByComparator, true);

			array[1] = workFromHomeRequest;

			array[2] = getByUuid_PrevAndNext(
				session, workFromHomeRequest, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkFromHomeRequest getByUuid_PrevAndNext(
		Session session, WorkFromHomeRequest workFromHomeRequest, String uuid,
		OrderByComparator<WorkFromHomeRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_WORKFROMHOMEREQUEST_WHERE);

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
			sb.append(WorkFromHomeRequestModelImpl.ORDER_BY_JPQL);
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
						workFromHomeRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkFromHomeRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work from home requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (WorkFromHomeRequest workFromHomeRequest :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(workFromHomeRequest);
		}
	}

	/**
	 * Returns the number of work from home requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching work from home requests
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKFROMHOMEREQUEST_WHERE);

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
		"workFromHomeRequest.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(workFromHomeRequest.uuid IS NULL OR workFromHomeRequest.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the work from home request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchWorkFromHomeRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchWorkFromHomeRequestException {

		WorkFromHomeRequest workFromHomeRequest = fetchByUUID_G(uuid, groupId);

		if (workFromHomeRequest == null) {
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

			throw new NoSuchWorkFromHomeRequestException(sb.toString());
		}

		return workFromHomeRequest;
	}

	/**
	 * Returns the work from home request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the work from home request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest fetchByUUID_G(
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

		if (result instanceof WorkFromHomeRequest) {
			WorkFromHomeRequest workFromHomeRequest =
				(WorkFromHomeRequest)result;

			if (!Objects.equals(uuid, workFromHomeRequest.getUuid()) ||
				(groupId != workFromHomeRequest.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_WORKFROMHOMEREQUEST_WHERE);

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

				List<WorkFromHomeRequest> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					WorkFromHomeRequest workFromHomeRequest = list.get(0);

					result = workFromHomeRequest;

					cacheResult(workFromHomeRequest);
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
			return (WorkFromHomeRequest)result;
		}
	}

	/**
	 * Removes the work from home request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the work from home request that was removed
	 */
	@Override
	public WorkFromHomeRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchWorkFromHomeRequestException {

		WorkFromHomeRequest workFromHomeRequest = findByUUID_G(uuid, groupId);

		return remove(workFromHomeRequest);
	}

	/**
	 * Returns the number of work from home requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching work from home requests
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKFROMHOMEREQUEST_WHERE);

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
		"workFromHomeRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(workFromHomeRequest.uuid IS NULL OR workFromHomeRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"workFromHomeRequest.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the work from home requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work from home requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @return the range of matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work from home requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work from home requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator,
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

		List<WorkFromHomeRequest> list = null;

		if (useFinderCache) {
			list = (List<WorkFromHomeRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkFromHomeRequest workFromHomeRequest : list) {
					if (!uuid.equals(workFromHomeRequest.getUuid()) ||
						(companyId != workFromHomeRequest.getCompanyId())) {

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

			sb.append(_SQL_SELECT_WORKFROMHOMEREQUEST_WHERE);

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
				sb.append(WorkFromHomeRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<WorkFromHomeRequest>)QueryUtil.list(
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
	 * Returns the first work from home request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException {

		WorkFromHomeRequest workFromHomeRequest = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (workFromHomeRequest != null) {
			return workFromHomeRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchWorkFromHomeRequestException(sb.toString());
	}

	/**
	 * Returns the first work from home request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		List<WorkFromHomeRequest> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work from home request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException {

		WorkFromHomeRequest workFromHomeRequest = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (workFromHomeRequest != null) {
			return workFromHomeRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchWorkFromHomeRequestException(sb.toString());
	}

	/**
	 * Returns the last work from home request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<WorkFromHomeRequest> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work from home requests before and after the current work from home request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	@Override
	public WorkFromHomeRequest[] findByUuid_C_PrevAndNext(
			long workFromHomeRequestId, String uuid, long companyId,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException {

		uuid = Objects.toString(uuid, "");

		WorkFromHomeRequest workFromHomeRequest = findByPrimaryKey(
			workFromHomeRequestId);

		Session session = null;

		try {
			session = openSession();

			WorkFromHomeRequest[] array = new WorkFromHomeRequestImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, workFromHomeRequest, uuid, companyId,
				orderByComparator, true);

			array[1] = workFromHomeRequest;

			array[2] = getByUuid_C_PrevAndNext(
				session, workFromHomeRequest, uuid, companyId,
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

	protected WorkFromHomeRequest getByUuid_C_PrevAndNext(
		Session session, WorkFromHomeRequest workFromHomeRequest, String uuid,
		long companyId,
		OrderByComparator<WorkFromHomeRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_WORKFROMHOMEREQUEST_WHERE);

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
			sb.append(WorkFromHomeRequestModelImpl.ORDER_BY_JPQL);
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
						workFromHomeRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkFromHomeRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work from home requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (WorkFromHomeRequest workFromHomeRequest :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(workFromHomeRequest);
		}
	}

	/**
	 * Returns the number of work from home requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching work from home requests
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKFROMHOMEREQUEST_WHERE);

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
		"workFromHomeRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(workFromHomeRequest.uuid IS NULL OR workFromHomeRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"workFromHomeRequest.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByEmployeeId;
	private FinderPath _finderPathWithoutPaginationFindByEmployeeId;
	private FinderPath _finderPathCountByEmployeeId;

	/**
	 * Returns all the work from home requests where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work from home requests where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @return the range of matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work from home requests where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work from home requests where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator,
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

		List<WorkFromHomeRequest> list = null;

		if (useFinderCache) {
			list = (List<WorkFromHomeRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkFromHomeRequest workFromHomeRequest : list) {
					if (employeeId != workFromHomeRequest.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_WORKFROMHOMEREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkFromHomeRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<WorkFromHomeRequest>)QueryUtil.list(
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
	 * Returns the first work from home request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest findByEmployeeId_First(
			long employeeId,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException {

		WorkFromHomeRequest workFromHomeRequest = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (workFromHomeRequest != null) {
			return workFromHomeRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchWorkFromHomeRequestException(sb.toString());
	}

	/**
	 * Returns the first work from home request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		List<WorkFromHomeRequest> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work from home request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException {

		WorkFromHomeRequest workFromHomeRequest = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (workFromHomeRequest != null) {
			return workFromHomeRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchWorkFromHomeRequestException(sb.toString());
	}

	/**
	 * Returns the last work from home request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<WorkFromHomeRequest> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work from home requests before and after the current work from home request in the ordered set where employeeId = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home request
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	@Override
	public WorkFromHomeRequest[] findByEmployeeId_PrevAndNext(
			long workFromHomeRequestId, long employeeId,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException {

		WorkFromHomeRequest workFromHomeRequest = findByPrimaryKey(
			workFromHomeRequestId);

		Session session = null;

		try {
			session = openSession();

			WorkFromHomeRequest[] array = new WorkFromHomeRequestImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, workFromHomeRequest, employeeId, orderByComparator,
				true);

			array[1] = workFromHomeRequest;

			array[2] = getByEmployeeId_PrevAndNext(
				session, workFromHomeRequest, employeeId, orderByComparator,
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

	protected WorkFromHomeRequest getByEmployeeId_PrevAndNext(
		Session session, WorkFromHomeRequest workFromHomeRequest,
		long employeeId,
		OrderByComparator<WorkFromHomeRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_WORKFROMHOMEREQUEST_WHERE);

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
			sb.append(WorkFromHomeRequestModelImpl.ORDER_BY_JPQL);
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
						workFromHomeRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkFromHomeRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work from home requests where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (WorkFromHomeRequest workFromHomeRequest :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(workFromHomeRequest);
		}
	}

	/**
	 * Returns the number of work from home requests where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching work from home requests
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKFROMHOMEREQUEST_WHERE);

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
		"workFromHomeRequest.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the work from home requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByStatus(long status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work from home requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @return the range of matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByStatus(
		long status, int start, int end) {

		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work from home requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByStatus(
		long status, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work from home requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByStatus(
		long status, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<WorkFromHomeRequest> list = null;

		if (useFinderCache) {
			list = (List<WorkFromHomeRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkFromHomeRequest workFromHomeRequest : list) {
					if (status != workFromHomeRequest.getStatus()) {
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

			sb.append(_SQL_SELECT_WORKFROMHOMEREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkFromHomeRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<WorkFromHomeRequest>)QueryUtil.list(
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
	 * Returns the first work from home request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest findByStatus_First(
			long status,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException {

		WorkFromHomeRequest workFromHomeRequest = fetchByStatus_First(
			status, orderByComparator);

		if (workFromHomeRequest != null) {
			return workFromHomeRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchWorkFromHomeRequestException(sb.toString());
	}

	/**
	 * Returns the first work from home request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest fetchByStatus_First(
		long status, OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		List<WorkFromHomeRequest> list = findByStatus(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work from home request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest findByStatus_Last(
			long status,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException {

		WorkFromHomeRequest workFromHomeRequest = fetchByStatus_Last(
			status, orderByComparator);

		if (workFromHomeRequest != null) {
			return workFromHomeRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchWorkFromHomeRequestException(sb.toString());
	}

	/**
	 * Returns the last work from home request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest fetchByStatus_Last(
		long status, OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<WorkFromHomeRequest> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work from home requests before and after the current work from home request in the ordered set where status = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home request
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	@Override
	public WorkFromHomeRequest[] findByStatus_PrevAndNext(
			long workFromHomeRequestId, long status,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException {

		WorkFromHomeRequest workFromHomeRequest = findByPrimaryKey(
			workFromHomeRequestId);

		Session session = null;

		try {
			session = openSession();

			WorkFromHomeRequest[] array = new WorkFromHomeRequestImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, workFromHomeRequest, status, orderByComparator, true);

			array[1] = workFromHomeRequest;

			array[2] = getByStatus_PrevAndNext(
				session, workFromHomeRequest, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkFromHomeRequest getByStatus_PrevAndNext(
		Session session, WorkFromHomeRequest workFromHomeRequest, long status,
		OrderByComparator<WorkFromHomeRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_WORKFROMHOMEREQUEST_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			sb.append(WorkFromHomeRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						workFromHomeRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkFromHomeRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work from home requests where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(long status) {
		for (WorkFromHomeRequest workFromHomeRequest :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(workFromHomeRequest);
		}
	}

	/**
	 * Returns the number of work from home requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching work from home requests
	 */
	@Override
	public int countByStatus(long status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKFROMHOMEREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

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
		"workFromHomeRequest.status = ?";

	private FinderPath _finderPathWithPaginationFindByEmployeeIdAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByEmployeeIdAndStatus;
	private FinderPath _finderPathCountByEmployeeIdAndStatus;

	/**
	 * Returns all the work from home requests where employeeId = &#63; and status = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @return the matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByEmployeeIdAndStatus(
		long employeeId, long status) {

		return findByEmployeeIdAndStatus(
			employeeId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work from home requests where employeeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @return the range of matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByEmployeeIdAndStatus(
		long employeeId, long status, int start, int end) {

		return findByEmployeeIdAndStatus(employeeId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work from home requests where employeeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByEmployeeIdAndStatus(
		long employeeId, long status, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return findByEmployeeIdAndStatus(
			employeeId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work from home requests where employeeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByEmployeeIdAndStatus(
		long employeeId, long status, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByEmployeeIdAndStatus;
				finderArgs = new Object[] {employeeId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEmployeeIdAndStatus;
			finderArgs = new Object[] {
				employeeId, status, start, end, orderByComparator
			};
		}

		List<WorkFromHomeRequest> list = null;

		if (useFinderCache) {
			list = (List<WorkFromHomeRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkFromHomeRequest workFromHomeRequest : list) {
					if ((employeeId != workFromHomeRequest.getEmployeeId()) ||
						(status != workFromHomeRequest.getStatus())) {

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

			sb.append(_SQL_SELECT_WORKFROMHOMEREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDANDSTATUS_EMPLOYEEID_2);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkFromHomeRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				queryPos.add(status);

				list = (List<WorkFromHomeRequest>)QueryUtil.list(
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
	 * Returns the first work from home request in the ordered set where employeeId = &#63; and status = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest findByEmployeeIdAndStatus_First(
			long employeeId, long status,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException {

		WorkFromHomeRequest workFromHomeRequest =
			fetchByEmployeeIdAndStatus_First(
				employeeId, status, orderByComparator);

		if (workFromHomeRequest != null) {
			return workFromHomeRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchWorkFromHomeRequestException(sb.toString());
	}

	/**
	 * Returns the first work from home request in the ordered set where employeeId = &#63; and status = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest fetchByEmployeeIdAndStatus_First(
		long employeeId, long status,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		List<WorkFromHomeRequest> list = findByEmployeeIdAndStatus(
			employeeId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work from home request in the ordered set where employeeId = &#63; and status = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest findByEmployeeIdAndStatus_Last(
			long employeeId, long status,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException {

		WorkFromHomeRequest workFromHomeRequest =
			fetchByEmployeeIdAndStatus_Last(
				employeeId, status, orderByComparator);

		if (workFromHomeRequest != null) {
			return workFromHomeRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchWorkFromHomeRequestException(sb.toString());
	}

	/**
	 * Returns the last work from home request in the ordered set where employeeId = &#63; and status = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest fetchByEmployeeIdAndStatus_Last(
		long employeeId, long status,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		int count = countByEmployeeIdAndStatus(employeeId, status);

		if (count == 0) {
			return null;
		}

		List<WorkFromHomeRequest> list = findByEmployeeIdAndStatus(
			employeeId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work from home requests before and after the current work from home request in the ordered set where employeeId = &#63; and status = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home request
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	@Override
	public WorkFromHomeRequest[] findByEmployeeIdAndStatus_PrevAndNext(
			long workFromHomeRequestId, long employeeId, long status,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException {

		WorkFromHomeRequest workFromHomeRequest = findByPrimaryKey(
			workFromHomeRequestId);

		Session session = null;

		try {
			session = openSession();

			WorkFromHomeRequest[] array = new WorkFromHomeRequestImpl[3];

			array[0] = getByEmployeeIdAndStatus_PrevAndNext(
				session, workFromHomeRequest, employeeId, status,
				orderByComparator, true);

			array[1] = workFromHomeRequest;

			array[2] = getByEmployeeIdAndStatus_PrevAndNext(
				session, workFromHomeRequest, employeeId, status,
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

	protected WorkFromHomeRequest getByEmployeeIdAndStatus_PrevAndNext(
		Session session, WorkFromHomeRequest workFromHomeRequest,
		long employeeId, long status,
		OrderByComparator<WorkFromHomeRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_WORKFROMHOMEREQUEST_WHERE);

		sb.append(_FINDER_COLUMN_EMPLOYEEIDANDSTATUS_EMPLOYEEID_2);

		sb.append(_FINDER_COLUMN_EMPLOYEEIDANDSTATUS_STATUS_2);

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
			sb.append(WorkFromHomeRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(employeeId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						workFromHomeRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkFromHomeRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work from home requests where employeeId = &#63; and status = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 */
	@Override
	public void removeByEmployeeIdAndStatus(long employeeId, long status) {
		for (WorkFromHomeRequest workFromHomeRequest :
				findByEmployeeIdAndStatus(
					employeeId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(workFromHomeRequest);
		}
	}

	/**
	 * Returns the number of work from home requests where employeeId = &#63; and status = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @return the number of matching work from home requests
	 */
	@Override
	public int countByEmployeeIdAndStatus(long employeeId, long status) {
		FinderPath finderPath = _finderPathCountByEmployeeIdAndStatus;

		Object[] finderArgs = new Object[] {employeeId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKFROMHOMEREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDANDSTATUS_EMPLOYEEID_2);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				queryPos.add(status);

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
		_FINDER_COLUMN_EMPLOYEEIDANDSTATUS_EMPLOYEEID_2 =
			"workFromHomeRequest.employeeId = ? AND ";

	private static final String _FINDER_COLUMN_EMPLOYEEIDANDSTATUS_STATUS_2 =
		"workFromHomeRequest.status = ?";

	private FinderPath _finderPathWithPaginationFindByDateRange;
	private FinderPath _finderPathWithoutPaginationFindByDateRange;
	private FinderPath _finderPathCountByDateRange;

	/**
	 * Returns all the work from home requests where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByDateRange(
		Date startDate, Date endDate) {

		return findByDateRange(
			startDate, endDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work from home requests where startDate = &#63; and endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @return the range of matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByDateRange(
		Date startDate, Date endDate, int start, int end) {

		return findByDateRange(startDate, endDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work from home requests where startDate = &#63; and endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByDateRange(
		Date startDate, Date endDate, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return findByDateRange(
			startDate, endDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work from home requests where startDate = &#63; and endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findByDateRange(
		Date startDate, Date endDate, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDateRange;
				finderArgs = new Object[] {
					_getTime(startDate), _getTime(endDate)
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDateRange;
			finderArgs = new Object[] {
				_getTime(startDate), _getTime(endDate), start, end,
				orderByComparator
			};
		}

		List<WorkFromHomeRequest> list = null;

		if (useFinderCache) {
			list = (List<WorkFromHomeRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkFromHomeRequest workFromHomeRequest : list) {
					if (!Objects.equals(
							startDate, workFromHomeRequest.getStartDate()) ||
						!Objects.equals(
							endDate, workFromHomeRequest.getEndDate())) {

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

			sb.append(_SQL_SELECT_WORKFROMHOMEREQUEST_WHERE);

			boolean bindStartDate = false;

			if (startDate == null) {
				sb.append(_FINDER_COLUMN_DATERANGE_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				sb.append(_FINDER_COLUMN_DATERANGE_STARTDATE_2);
			}

			boolean bindEndDate = false;

			if (endDate == null) {
				sb.append(_FINDER_COLUMN_DATERANGE_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				sb.append(_FINDER_COLUMN_DATERANGE_ENDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(WorkFromHomeRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStartDate) {
					queryPos.add(new Timestamp(startDate.getTime()));
				}

				if (bindEndDate) {
					queryPos.add(new Timestamp(endDate.getTime()));
				}

				list = (List<WorkFromHomeRequest>)QueryUtil.list(
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
	 * Returns the first work from home request in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest findByDateRange_First(
			Date startDate, Date endDate,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException {

		WorkFromHomeRequest workFromHomeRequest = fetchByDateRange_First(
			startDate, endDate, orderByComparator);

		if (workFromHomeRequest != null) {
			return workFromHomeRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("startDate=");
		sb.append(startDate);

		sb.append(", endDate=");
		sb.append(endDate);

		sb.append("}");

		throw new NoSuchWorkFromHomeRequestException(sb.toString());
	}

	/**
	 * Returns the first work from home request in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest fetchByDateRange_First(
		Date startDate, Date endDate,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		List<WorkFromHomeRequest> list = findByDateRange(
			startDate, endDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work from home request in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest findByDateRange_Last(
			Date startDate, Date endDate,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException {

		WorkFromHomeRequest workFromHomeRequest = fetchByDateRange_Last(
			startDate, endDate, orderByComparator);

		if (workFromHomeRequest != null) {
			return workFromHomeRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("startDate=");
		sb.append(startDate);

		sb.append(", endDate=");
		sb.append(endDate);

		sb.append("}");

		throw new NoSuchWorkFromHomeRequestException(sb.toString());
	}

	/**
	 * Returns the last work from home request in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	@Override
	public WorkFromHomeRequest fetchByDateRange_Last(
		Date startDate, Date endDate,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		int count = countByDateRange(startDate, endDate);

		if (count == 0) {
			return null;
		}

		List<WorkFromHomeRequest> list = findByDateRange(
			startDate, endDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work from home requests before and after the current work from home request in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home request
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	@Override
	public WorkFromHomeRequest[] findByDateRange_PrevAndNext(
			long workFromHomeRequestId, Date startDate, Date endDate,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException {

		WorkFromHomeRequest workFromHomeRequest = findByPrimaryKey(
			workFromHomeRequestId);

		Session session = null;

		try {
			session = openSession();

			WorkFromHomeRequest[] array = new WorkFromHomeRequestImpl[3];

			array[0] = getByDateRange_PrevAndNext(
				session, workFromHomeRequest, startDate, endDate,
				orderByComparator, true);

			array[1] = workFromHomeRequest;

			array[2] = getByDateRange_PrevAndNext(
				session, workFromHomeRequest, startDate, endDate,
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

	protected WorkFromHomeRequest getByDateRange_PrevAndNext(
		Session session, WorkFromHomeRequest workFromHomeRequest,
		Date startDate, Date endDate,
		OrderByComparator<WorkFromHomeRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_WORKFROMHOMEREQUEST_WHERE);

		boolean bindStartDate = false;

		if (startDate == null) {
			sb.append(_FINDER_COLUMN_DATERANGE_STARTDATE_1);
		}
		else {
			bindStartDate = true;

			sb.append(_FINDER_COLUMN_DATERANGE_STARTDATE_2);
		}

		boolean bindEndDate = false;

		if (endDate == null) {
			sb.append(_FINDER_COLUMN_DATERANGE_ENDDATE_1);
		}
		else {
			bindEndDate = true;

			sb.append(_FINDER_COLUMN_DATERANGE_ENDDATE_2);
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
			sb.append(WorkFromHomeRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindStartDate) {
			queryPos.add(new Timestamp(startDate.getTime()));
		}

		if (bindEndDate) {
			queryPos.add(new Timestamp(endDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						workFromHomeRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkFromHomeRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work from home requests where startDate = &#63; and endDate = &#63; from the database.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 */
	@Override
	public void removeByDateRange(Date startDate, Date endDate) {
		for (WorkFromHomeRequest workFromHomeRequest :
				findByDateRange(
					startDate, endDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(workFromHomeRequest);
		}
	}

	/**
	 * Returns the number of work from home requests where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the number of matching work from home requests
	 */
	@Override
	public int countByDateRange(Date startDate, Date endDate) {
		FinderPath finderPath = _finderPathCountByDateRange;

		Object[] finderArgs = new Object[] {
			_getTime(startDate), _getTime(endDate)
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WORKFROMHOMEREQUEST_WHERE);

			boolean bindStartDate = false;

			if (startDate == null) {
				sb.append(_FINDER_COLUMN_DATERANGE_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				sb.append(_FINDER_COLUMN_DATERANGE_STARTDATE_2);
			}

			boolean bindEndDate = false;

			if (endDate == null) {
				sb.append(_FINDER_COLUMN_DATERANGE_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				sb.append(_FINDER_COLUMN_DATERANGE_ENDDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStartDate) {
					queryPos.add(new Timestamp(startDate.getTime()));
				}

				if (bindEndDate) {
					queryPos.add(new Timestamp(endDate.getTime()));
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

	private static final String _FINDER_COLUMN_DATERANGE_STARTDATE_1 =
		"workFromHomeRequest.startDate IS NULL AND ";

	private static final String _FINDER_COLUMN_DATERANGE_STARTDATE_2 =
		"workFromHomeRequest.startDate = ? AND ";

	private static final String _FINDER_COLUMN_DATERANGE_ENDDATE_1 =
		"workFromHomeRequest.endDate IS NULL";

	private static final String _FINDER_COLUMN_DATERANGE_ENDDATE_2 =
		"workFromHomeRequest.endDate = ?";

	public WorkFromHomeRequestPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(WorkFromHomeRequest.class);

		setModelImplClass(WorkFromHomeRequestImpl.class);
		setModelPKClass(long.class);

		setTable(WorkFromHomeRequestTable.INSTANCE);
	}

	/**
	 * Caches the work from home request in the entity cache if it is enabled.
	 *
	 * @param workFromHomeRequest the work from home request
	 */
	@Override
	public void cacheResult(WorkFromHomeRequest workFromHomeRequest) {
		entityCache.putResult(
			WorkFromHomeRequestImpl.class, workFromHomeRequest.getPrimaryKey(),
			workFromHomeRequest);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				workFromHomeRequest.getUuid(), workFromHomeRequest.getGroupId()
			},
			workFromHomeRequest);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the work from home requests in the entity cache if it is enabled.
	 *
	 * @param workFromHomeRequests the work from home requests
	 */
	@Override
	public void cacheResult(List<WorkFromHomeRequest> workFromHomeRequests) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (workFromHomeRequests.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (WorkFromHomeRequest workFromHomeRequest : workFromHomeRequests) {
			if (entityCache.getResult(
					WorkFromHomeRequestImpl.class,
					workFromHomeRequest.getPrimaryKey()) == null) {

				cacheResult(workFromHomeRequest);
			}
		}
	}

	/**
	 * Clears the cache for all work from home requests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WorkFromHomeRequestImpl.class);

		finderCache.clearCache(WorkFromHomeRequestImpl.class);
	}

	/**
	 * Clears the cache for the work from home request.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkFromHomeRequest workFromHomeRequest) {
		entityCache.removeResult(
			WorkFromHomeRequestImpl.class, workFromHomeRequest);
	}

	@Override
	public void clearCache(List<WorkFromHomeRequest> workFromHomeRequests) {
		for (WorkFromHomeRequest workFromHomeRequest : workFromHomeRequests) {
			entityCache.removeResult(
				WorkFromHomeRequestImpl.class, workFromHomeRequest);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(WorkFromHomeRequestImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(WorkFromHomeRequestImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		WorkFromHomeRequestModelImpl workFromHomeRequestModelImpl) {

		Object[] args = new Object[] {
			workFromHomeRequestModelImpl.getUuid(),
			workFromHomeRequestModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, workFromHomeRequestModelImpl);
	}

	/**
	 * Creates a new work from home request with the primary key. Does not add the work from home request to the database.
	 *
	 * @param workFromHomeRequestId the primary key for the new work from home request
	 * @return the new work from home request
	 */
	@Override
	public WorkFromHomeRequest create(long workFromHomeRequestId) {
		WorkFromHomeRequest workFromHomeRequest = new WorkFromHomeRequestImpl();

		workFromHomeRequest.setNew(true);
		workFromHomeRequest.setPrimaryKey(workFromHomeRequestId);

		String uuid = PortalUUIDUtil.generate();

		workFromHomeRequest.setUuid(uuid);

		workFromHomeRequest.setCompanyId(CompanyThreadLocal.getCompanyId());

		return workFromHomeRequest;
	}

	/**
	 * Removes the work from home request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workFromHomeRequestId the primary key of the work from home request
	 * @return the work from home request that was removed
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	@Override
	public WorkFromHomeRequest remove(long workFromHomeRequestId)
		throws NoSuchWorkFromHomeRequestException {

		return remove((Serializable)workFromHomeRequestId);
	}

	/**
	 * Removes the work from home request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the work from home request
	 * @return the work from home request that was removed
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	@Override
	public WorkFromHomeRequest remove(Serializable primaryKey)
		throws NoSuchWorkFromHomeRequestException {

		Session session = null;

		try {
			session = openSession();

			WorkFromHomeRequest workFromHomeRequest =
				(WorkFromHomeRequest)session.get(
					WorkFromHomeRequestImpl.class, primaryKey);

			if (workFromHomeRequest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkFromHomeRequestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(workFromHomeRequest);
		}
		catch (NoSuchWorkFromHomeRequestException noSuchEntityException) {
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
	protected WorkFromHomeRequest removeImpl(
		WorkFromHomeRequest workFromHomeRequest) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workFromHomeRequest)) {
				workFromHomeRequest = (WorkFromHomeRequest)session.get(
					WorkFromHomeRequestImpl.class,
					workFromHomeRequest.getPrimaryKeyObj());
			}

			if (workFromHomeRequest != null) {
				session.delete(workFromHomeRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (workFromHomeRequest != null) {
			clearCache(workFromHomeRequest);
		}

		return workFromHomeRequest;
	}

	@Override
	public WorkFromHomeRequest updateImpl(
		WorkFromHomeRequest workFromHomeRequest) {

		boolean isNew = workFromHomeRequest.isNew();

		if (!(workFromHomeRequest instanceof WorkFromHomeRequestModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(workFromHomeRequest.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					workFromHomeRequest);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in workFromHomeRequest proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom WorkFromHomeRequest implementation " +
					workFromHomeRequest.getClass());
		}

		WorkFromHomeRequestModelImpl workFromHomeRequestModelImpl =
			(WorkFromHomeRequestModelImpl)workFromHomeRequest;

		if (Validator.isNull(workFromHomeRequest.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			workFromHomeRequest.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (workFromHomeRequest.getCreateDate() == null)) {
			if (serviceContext == null) {
				workFromHomeRequest.setCreateDate(date);
			}
			else {
				workFromHomeRequest.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!workFromHomeRequestModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				workFromHomeRequest.setModifiedDate(date);
			}
			else {
				workFromHomeRequest.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(workFromHomeRequest);
			}
			else {
				workFromHomeRequest = (WorkFromHomeRequest)session.merge(
					workFromHomeRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			WorkFromHomeRequestImpl.class, workFromHomeRequestModelImpl, false,
			true);

		cacheUniqueFindersCache(workFromHomeRequestModelImpl);

		if (isNew) {
			workFromHomeRequest.setNew(false);
		}

		workFromHomeRequest.resetOriginalValues();

		return workFromHomeRequest;
	}

	/**
	 * Returns the work from home request with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the work from home request
	 * @return the work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	@Override
	public WorkFromHomeRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkFromHomeRequestException {

		WorkFromHomeRequest workFromHomeRequest = fetchByPrimaryKey(primaryKey);

		if (workFromHomeRequest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkFromHomeRequestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return workFromHomeRequest;
	}

	/**
	 * Returns the work from home request with the primary key or throws a <code>NoSuchWorkFromHomeRequestException</code> if it could not be found.
	 *
	 * @param workFromHomeRequestId the primary key of the work from home request
	 * @return the work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	@Override
	public WorkFromHomeRequest findByPrimaryKey(long workFromHomeRequestId)
		throws NoSuchWorkFromHomeRequestException {

		return findByPrimaryKey((Serializable)workFromHomeRequestId);
	}

	/**
	 * Returns the work from home request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workFromHomeRequestId the primary key of the work from home request
	 * @return the work from home request, or <code>null</code> if a work from home request with the primary key could not be found
	 */
	@Override
	public WorkFromHomeRequest fetchByPrimaryKey(long workFromHomeRequestId) {
		return fetchByPrimaryKey((Serializable)workFromHomeRequestId);
	}

	/**
	 * Returns all the work from home requests.
	 *
	 * @return the work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work from home requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @return the range of work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the work from home requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findAll(
		int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work from home requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work from home requests
	 */
	@Override
	public List<WorkFromHomeRequest> findAll(
		int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator,
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

		List<WorkFromHomeRequest> list = null;

		if (useFinderCache) {
			list = (List<WorkFromHomeRequest>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_WORKFROMHOMEREQUEST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_WORKFROMHOMEREQUEST;

				sql = sql.concat(WorkFromHomeRequestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<WorkFromHomeRequest>)QueryUtil.list(
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
	 * Removes all the work from home requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WorkFromHomeRequest workFromHomeRequest : findAll()) {
			remove(workFromHomeRequest);
		}
	}

	/**
	 * Returns the number of work from home requests.
	 *
	 * @return the number of work from home requests
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
					_SQL_COUNT_WORKFROMHOMEREQUEST);

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
		return "workFromHomeRequestId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_WORKFROMHOMEREQUEST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return WorkFromHomeRequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the work from home request persistence.
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

		_finderPathWithPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status"}, true);

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Long.class.getName()}, new String[] {"status"}, true);

		_finderPathCountByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Long.class.getName()}, new String[] {"status"},
			false);

		_finderPathWithPaginationFindByEmployeeIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmployeeIdAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"employeeId", "status"}, true);

		_finderPathWithoutPaginationFindByEmployeeIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEmployeeIdAndStatus",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"employeeId", "status"}, true);

		_finderPathCountByEmployeeIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmployeeIdAndStatus",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"employeeId", "status"}, false);

		_finderPathWithPaginationFindByDateRange = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDateRange",
			new String[] {
				Date.class.getName(), Date.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"startDate", "endDate"}, true);

		_finderPathWithoutPaginationFindByDateRange = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDateRange",
			new String[] {Date.class.getName(), Date.class.getName()},
			new String[] {"startDate", "endDate"}, true);

		_finderPathCountByDateRange = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDateRange",
			new String[] {Date.class.getName(), Date.class.getName()},
			new String[] {"startDate", "endDate"}, false);

		WorkFromHomeRequestUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		WorkFromHomeRequestUtil.setPersistence(null);

		entityCache.removeCache(WorkFromHomeRequestImpl.class.getName());
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

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_WORKFROMHOMEREQUEST =
		"SELECT workFromHomeRequest FROM WorkFromHomeRequest workFromHomeRequest";

	private static final String _SQL_SELECT_WORKFROMHOMEREQUEST_WHERE =
		"SELECT workFromHomeRequest FROM WorkFromHomeRequest workFromHomeRequest WHERE ";

	private static final String _SQL_COUNT_WORKFROMHOMEREQUEST =
		"SELECT COUNT(workFromHomeRequest) FROM WorkFromHomeRequest workFromHomeRequest";

	private static final String _SQL_COUNT_WORKFROMHOMEREQUEST_WHERE =
		"SELECT COUNT(workFromHomeRequest) FROM WorkFromHomeRequest workFromHomeRequest WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "workFromHomeRequest.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No WorkFromHomeRequest exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No WorkFromHomeRequest exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		WorkFromHomeRequestPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}