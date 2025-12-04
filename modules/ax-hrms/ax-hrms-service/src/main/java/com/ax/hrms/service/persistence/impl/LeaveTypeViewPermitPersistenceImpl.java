/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchLeaveTypeViewPermitException;
import com.ax.hrms.model.LeaveTypeViewPermit;
import com.ax.hrms.model.LeaveTypeViewPermitTable;
import com.ax.hrms.model.impl.LeaveTypeViewPermitImpl;
import com.ax.hrms.model.impl.LeaveTypeViewPermitModelImpl;
import com.ax.hrms.service.persistence.LeaveTypeViewPermitPersistence;
import com.ax.hrms.service.persistence.LeaveTypeViewPermitUtil;
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
 * The persistence implementation for the leave type view permit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LeaveTypeViewPermitPersistence.class)
public class LeaveTypeViewPermitPersistenceImpl
	extends BasePersistenceImpl<LeaveTypeViewPermit>
	implements LeaveTypeViewPermitPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LeaveTypeViewPermitUtil</code> to access the leave type view permit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LeaveTypeViewPermitImpl.class.getName();

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
	 * Returns all the leave type view permits where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave type view permits
	 */
	@Override
	public List<LeaveTypeViewPermit> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave type view permits where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeViewPermitModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave type view permits
	 * @param end the upper bound of the range of leave type view permits (not inclusive)
	 * @return the range of matching leave type view permits
	 */
	@Override
	public List<LeaveTypeViewPermit> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave type view permits where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeViewPermitModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave type view permits
	 * @param end the upper bound of the range of leave type view permits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave type view permits
	 */
	@Override
	public List<LeaveTypeViewPermit> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveTypeViewPermit> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave type view permits where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeViewPermitModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave type view permits
	 * @param end the upper bound of the range of leave type view permits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave type view permits
	 */
	@Override
	public List<LeaveTypeViewPermit> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveTypeViewPermit> orderByComparator,
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

		List<LeaveTypeViewPermit> list = null;

		if (useFinderCache) {
			list = (List<LeaveTypeViewPermit>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveTypeViewPermit leaveTypeViewPermit : list) {
					if (!uuid.equals(leaveTypeViewPermit.getUuid())) {
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

			sb.append(_SQL_SELECT_LEAVETYPEVIEWPERMIT_WHERE);

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
				sb.append(LeaveTypeViewPermitModelImpl.ORDER_BY_JPQL);
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

				list = (List<LeaveTypeViewPermit>)QueryUtil.list(
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
	 * Returns the first leave type view permit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type view permit
	 * @throws NoSuchLeaveTypeViewPermitException if a matching leave type view permit could not be found
	 */
	@Override
	public LeaveTypeViewPermit findByUuid_First(
			String uuid,
			OrderByComparator<LeaveTypeViewPermit> orderByComparator)
		throws NoSuchLeaveTypeViewPermitException {

		LeaveTypeViewPermit leaveTypeViewPermit = fetchByUuid_First(
			uuid, orderByComparator);

		if (leaveTypeViewPermit != null) {
			return leaveTypeViewPermit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLeaveTypeViewPermitException(sb.toString());
	}

	/**
	 * Returns the first leave type view permit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type view permit, or <code>null</code> if a matching leave type view permit could not be found
	 */
	@Override
	public LeaveTypeViewPermit fetchByUuid_First(
		String uuid, OrderByComparator<LeaveTypeViewPermit> orderByComparator) {

		List<LeaveTypeViewPermit> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave type view permit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type view permit
	 * @throws NoSuchLeaveTypeViewPermitException if a matching leave type view permit could not be found
	 */
	@Override
	public LeaveTypeViewPermit findByUuid_Last(
			String uuid,
			OrderByComparator<LeaveTypeViewPermit> orderByComparator)
		throws NoSuchLeaveTypeViewPermitException {

		LeaveTypeViewPermit leaveTypeViewPermit = fetchByUuid_Last(
			uuid, orderByComparator);

		if (leaveTypeViewPermit != null) {
			return leaveTypeViewPermit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLeaveTypeViewPermitException(sb.toString());
	}

	/**
	 * Returns the last leave type view permit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type view permit, or <code>null</code> if a matching leave type view permit could not be found
	 */
	@Override
	public LeaveTypeViewPermit fetchByUuid_Last(
		String uuid, OrderByComparator<LeaveTypeViewPermit> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<LeaveTypeViewPermit> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave type view permits before and after the current leave type view permit in the ordered set where uuid = &#63;.
	 *
	 * @param leaveTypeViewPermitId the primary key of the current leave type view permit
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave type view permit
	 * @throws NoSuchLeaveTypeViewPermitException if a leave type view permit with the primary key could not be found
	 */
	@Override
	public LeaveTypeViewPermit[] findByUuid_PrevAndNext(
			long leaveTypeViewPermitId, String uuid,
			OrderByComparator<LeaveTypeViewPermit> orderByComparator)
		throws NoSuchLeaveTypeViewPermitException {

		uuid = Objects.toString(uuid, "");

		LeaveTypeViewPermit leaveTypeViewPermit = findByPrimaryKey(
			leaveTypeViewPermitId);

		Session session = null;

		try {
			session = openSession();

			LeaveTypeViewPermit[] array = new LeaveTypeViewPermitImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, leaveTypeViewPermit, uuid, orderByComparator, true);

			array[1] = leaveTypeViewPermit;

			array[2] = getByUuid_PrevAndNext(
				session, leaveTypeViewPermit, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LeaveTypeViewPermit getByUuid_PrevAndNext(
		Session session, LeaveTypeViewPermit leaveTypeViewPermit, String uuid,
		OrderByComparator<LeaveTypeViewPermit> orderByComparator,
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

		sb.append(_SQL_SELECT_LEAVETYPEVIEWPERMIT_WHERE);

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
			sb.append(LeaveTypeViewPermitModelImpl.ORDER_BY_JPQL);
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
						leaveTypeViewPermit)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveTypeViewPermit> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave type view permits where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (LeaveTypeViewPermit leaveTypeViewPermit :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leaveTypeViewPermit);
		}
	}

	/**
	 * Returns the number of leave type view permits where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave type view permits
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVETYPEVIEWPERMIT_WHERE);

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
		"leaveTypeViewPermit.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(leaveTypeViewPermit.uuid IS NULL OR leaveTypeViewPermit.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the leave type view permit where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveTypeViewPermitException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave type view permit
	 * @throws NoSuchLeaveTypeViewPermitException if a matching leave type view permit could not be found
	 */
	@Override
	public LeaveTypeViewPermit findByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveTypeViewPermitException {

		LeaveTypeViewPermit leaveTypeViewPermit = fetchByUUID_G(uuid, groupId);

		if (leaveTypeViewPermit == null) {
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

			throw new NoSuchLeaveTypeViewPermitException(sb.toString());
		}

		return leaveTypeViewPermit;
	}

	/**
	 * Returns the leave type view permit where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave type view permit, or <code>null</code> if a matching leave type view permit could not be found
	 */
	@Override
	public LeaveTypeViewPermit fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the leave type view permit where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave type view permit, or <code>null</code> if a matching leave type view permit could not be found
	 */
	@Override
	public LeaveTypeViewPermit fetchByUUID_G(
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

		if (result instanceof LeaveTypeViewPermit) {
			LeaveTypeViewPermit leaveTypeViewPermit =
				(LeaveTypeViewPermit)result;

			if (!Objects.equals(uuid, leaveTypeViewPermit.getUuid()) ||
				(groupId != leaveTypeViewPermit.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LEAVETYPEVIEWPERMIT_WHERE);

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

				List<LeaveTypeViewPermit> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					LeaveTypeViewPermit leaveTypeViewPermit = list.get(0);

					result = leaveTypeViewPermit;

					cacheResult(leaveTypeViewPermit);
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
			return (LeaveTypeViewPermit)result;
		}
	}

	/**
	 * Removes the leave type view permit where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave type view permit that was removed
	 */
	@Override
	public LeaveTypeViewPermit removeByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveTypeViewPermitException {

		LeaveTypeViewPermit leaveTypeViewPermit = findByUUID_G(uuid, groupId);

		return remove(leaveTypeViewPermit);
	}

	/**
	 * Returns the number of leave type view permits where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave type view permits
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		LeaveTypeViewPermit leaveTypeViewPermit = fetchByUUID_G(uuid, groupId);

		if (leaveTypeViewPermit == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"leaveTypeViewPermit.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(leaveTypeViewPermit.uuid IS NULL OR leaveTypeViewPermit.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"leaveTypeViewPermit.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the leave type view permits where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave type view permits
	 */
	@Override
	public List<LeaveTypeViewPermit> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave type view permits where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeViewPermitModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave type view permits
	 * @param end the upper bound of the range of leave type view permits (not inclusive)
	 * @return the range of matching leave type view permits
	 */
	@Override
	public List<LeaveTypeViewPermit> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave type view permits where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeViewPermitModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave type view permits
	 * @param end the upper bound of the range of leave type view permits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave type view permits
	 */
	@Override
	public List<LeaveTypeViewPermit> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveTypeViewPermit> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave type view permits where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeViewPermitModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave type view permits
	 * @param end the upper bound of the range of leave type view permits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave type view permits
	 */
	@Override
	public List<LeaveTypeViewPermit> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveTypeViewPermit> orderByComparator,
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

		List<LeaveTypeViewPermit> list = null;

		if (useFinderCache) {
			list = (List<LeaveTypeViewPermit>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveTypeViewPermit leaveTypeViewPermit : list) {
					if (!uuid.equals(leaveTypeViewPermit.getUuid()) ||
						(companyId != leaveTypeViewPermit.getCompanyId())) {

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

			sb.append(_SQL_SELECT_LEAVETYPEVIEWPERMIT_WHERE);

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
				sb.append(LeaveTypeViewPermitModelImpl.ORDER_BY_JPQL);
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

				list = (List<LeaveTypeViewPermit>)QueryUtil.list(
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
	 * Returns the first leave type view permit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type view permit
	 * @throws NoSuchLeaveTypeViewPermitException if a matching leave type view permit could not be found
	 */
	@Override
	public LeaveTypeViewPermit findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LeaveTypeViewPermit> orderByComparator)
		throws NoSuchLeaveTypeViewPermitException {

		LeaveTypeViewPermit leaveTypeViewPermit = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (leaveTypeViewPermit != null) {
			return leaveTypeViewPermit;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLeaveTypeViewPermitException(sb.toString());
	}

	/**
	 * Returns the first leave type view permit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type view permit, or <code>null</code> if a matching leave type view permit could not be found
	 */
	@Override
	public LeaveTypeViewPermit fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LeaveTypeViewPermit> orderByComparator) {

		List<LeaveTypeViewPermit> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave type view permit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type view permit
	 * @throws NoSuchLeaveTypeViewPermitException if a matching leave type view permit could not be found
	 */
	@Override
	public LeaveTypeViewPermit findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LeaveTypeViewPermit> orderByComparator)
		throws NoSuchLeaveTypeViewPermitException {

		LeaveTypeViewPermit leaveTypeViewPermit = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (leaveTypeViewPermit != null) {
			return leaveTypeViewPermit;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLeaveTypeViewPermitException(sb.toString());
	}

	/**
	 * Returns the last leave type view permit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type view permit, or <code>null</code> if a matching leave type view permit could not be found
	 */
	@Override
	public LeaveTypeViewPermit fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LeaveTypeViewPermit> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<LeaveTypeViewPermit> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave type view permits before and after the current leave type view permit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveTypeViewPermitId the primary key of the current leave type view permit
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave type view permit
	 * @throws NoSuchLeaveTypeViewPermitException if a leave type view permit with the primary key could not be found
	 */
	@Override
	public LeaveTypeViewPermit[] findByUuid_C_PrevAndNext(
			long leaveTypeViewPermitId, String uuid, long companyId,
			OrderByComparator<LeaveTypeViewPermit> orderByComparator)
		throws NoSuchLeaveTypeViewPermitException {

		uuid = Objects.toString(uuid, "");

		LeaveTypeViewPermit leaveTypeViewPermit = findByPrimaryKey(
			leaveTypeViewPermitId);

		Session session = null;

		try {
			session = openSession();

			LeaveTypeViewPermit[] array = new LeaveTypeViewPermitImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, leaveTypeViewPermit, uuid, companyId,
				orderByComparator, true);

			array[1] = leaveTypeViewPermit;

			array[2] = getByUuid_C_PrevAndNext(
				session, leaveTypeViewPermit, uuid, companyId,
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

	protected LeaveTypeViewPermit getByUuid_C_PrevAndNext(
		Session session, LeaveTypeViewPermit leaveTypeViewPermit, String uuid,
		long companyId,
		OrderByComparator<LeaveTypeViewPermit> orderByComparator,
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

		sb.append(_SQL_SELECT_LEAVETYPEVIEWPERMIT_WHERE);

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
			sb.append(LeaveTypeViewPermitModelImpl.ORDER_BY_JPQL);
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
						leaveTypeViewPermit)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveTypeViewPermit> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave type view permits where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (LeaveTypeViewPermit leaveTypeViewPermit :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(leaveTypeViewPermit);
		}
	}

	/**
	 * Returns the number of leave type view permits where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave type view permits
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVETYPEVIEWPERMIT_WHERE);

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
		"leaveTypeViewPermit.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(leaveTypeViewPermit.uuid IS NULL OR leaveTypeViewPermit.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"leaveTypeViewPermit.companyId = ?";

	private FinderPath _finderPathFetchByEmployeeIdAndLeaveTypeMasterId;

	/**
	 * Returns the leave type view permit where employeeId = &#63; and leaveTypeMasterId = &#63; or throws a <code>NoSuchLeaveTypeViewPermitException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the matching leave type view permit
	 * @throws NoSuchLeaveTypeViewPermitException if a matching leave type view permit could not be found
	 */
	@Override
	public LeaveTypeViewPermit findByEmployeeIdAndLeaveTypeMasterId(
			long employeeId, long leaveTypeMasterId)
		throws NoSuchLeaveTypeViewPermitException {

		LeaveTypeViewPermit leaveTypeViewPermit =
			fetchByEmployeeIdAndLeaveTypeMasterId(
				employeeId, leaveTypeMasterId);

		if (leaveTypeViewPermit == null) {
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

			throw new NoSuchLeaveTypeViewPermitException(sb.toString());
		}

		return leaveTypeViewPermit;
	}

	/**
	 * Returns the leave type view permit where employeeId = &#63; and leaveTypeMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the matching leave type view permit, or <code>null</code> if a matching leave type view permit could not be found
	 */
	@Override
	public LeaveTypeViewPermit fetchByEmployeeIdAndLeaveTypeMasterId(
		long employeeId, long leaveTypeMasterId) {

		return fetchByEmployeeIdAndLeaveTypeMasterId(
			employeeId, leaveTypeMasterId, true);
	}

	/**
	 * Returns the leave type view permit where employeeId = &#63; and leaveTypeMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave type view permit, or <code>null</code> if a matching leave type view permit could not be found
	 */
	@Override
	public LeaveTypeViewPermit fetchByEmployeeIdAndLeaveTypeMasterId(
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

		if (result instanceof LeaveTypeViewPermit) {
			LeaveTypeViewPermit leaveTypeViewPermit =
				(LeaveTypeViewPermit)result;

			if ((employeeId != leaveTypeViewPermit.getEmployeeId()) ||
				(leaveTypeMasterId !=
					leaveTypeViewPermit.getLeaveTypeMasterId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LEAVETYPEVIEWPERMIT_WHERE);

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

				List<LeaveTypeViewPermit> list = query.list();

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
								"LeaveTypeViewPermitPersistenceImpl.fetchByEmployeeIdAndLeaveTypeMasterId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LeaveTypeViewPermit leaveTypeViewPermit = list.get(0);

					result = leaveTypeViewPermit;

					cacheResult(leaveTypeViewPermit);
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
			return (LeaveTypeViewPermit)result;
		}
	}

	/**
	 * Removes the leave type view permit where employeeId = &#63; and leaveTypeMasterId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the leave type view permit that was removed
	 */
	@Override
	public LeaveTypeViewPermit removeByEmployeeIdAndLeaveTypeMasterId(
			long employeeId, long leaveTypeMasterId)
		throws NoSuchLeaveTypeViewPermitException {

		LeaveTypeViewPermit leaveTypeViewPermit =
			findByEmployeeIdAndLeaveTypeMasterId(employeeId, leaveTypeMasterId);

		return remove(leaveTypeViewPermit);
	}

	/**
	 * Returns the number of leave type view permits where employeeId = &#63; and leaveTypeMasterId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the number of matching leave type view permits
	 */
	@Override
	public int countByEmployeeIdAndLeaveTypeMasterId(
		long employeeId, long leaveTypeMasterId) {

		LeaveTypeViewPermit leaveTypeViewPermit =
			fetchByEmployeeIdAndLeaveTypeMasterId(
				employeeId, leaveTypeMasterId);

		if (leaveTypeViewPermit == null) {
			return 0;
		}

		return 1;
	}

	private static final String
		_FINDER_COLUMN_EMPLOYEEIDANDLEAVETYPEMASTERID_EMPLOYEEID_2 =
			"leaveTypeViewPermit.employeeId = ? AND ";

	private static final String
		_FINDER_COLUMN_EMPLOYEEIDANDLEAVETYPEMASTERID_LEAVETYPEMASTERID_2 =
			"leaveTypeViewPermit.leaveTypeMasterId = ?";

	public LeaveTypeViewPermitPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(LeaveTypeViewPermit.class);

		setModelImplClass(LeaveTypeViewPermitImpl.class);
		setModelPKClass(long.class);

		setTable(LeaveTypeViewPermitTable.INSTANCE);
	}

	/**
	 * Caches the leave type view permit in the entity cache if it is enabled.
	 *
	 * @param leaveTypeViewPermit the leave type view permit
	 */
	@Override
	public void cacheResult(LeaveTypeViewPermit leaveTypeViewPermit) {
		entityCache.putResult(
			LeaveTypeViewPermitImpl.class, leaveTypeViewPermit.getPrimaryKey(),
			leaveTypeViewPermit);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				leaveTypeViewPermit.getUuid(), leaveTypeViewPermit.getGroupId()
			},
			leaveTypeViewPermit);

		finderCache.putResult(
			_finderPathFetchByEmployeeIdAndLeaveTypeMasterId,
			new Object[] {
				leaveTypeViewPermit.getEmployeeId(),
				leaveTypeViewPermit.getLeaveTypeMasterId()
			},
			leaveTypeViewPermit);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the leave type view permits in the entity cache if it is enabled.
	 *
	 * @param leaveTypeViewPermits the leave type view permits
	 */
	@Override
	public void cacheResult(List<LeaveTypeViewPermit> leaveTypeViewPermits) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (leaveTypeViewPermits.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LeaveTypeViewPermit leaveTypeViewPermit : leaveTypeViewPermits) {
			if (entityCache.getResult(
					LeaveTypeViewPermitImpl.class,
					leaveTypeViewPermit.getPrimaryKey()) == null) {

				cacheResult(leaveTypeViewPermit);
			}
		}
	}

	/**
	 * Clears the cache for all leave type view permits.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LeaveTypeViewPermitImpl.class);

		finderCache.clearCache(LeaveTypeViewPermitImpl.class);
	}

	/**
	 * Clears the cache for the leave type view permit.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveTypeViewPermit leaveTypeViewPermit) {
		entityCache.removeResult(
			LeaveTypeViewPermitImpl.class, leaveTypeViewPermit);
	}

	@Override
	public void clearCache(List<LeaveTypeViewPermit> leaveTypeViewPermits) {
		for (LeaveTypeViewPermit leaveTypeViewPermit : leaveTypeViewPermits) {
			entityCache.removeResult(
				LeaveTypeViewPermitImpl.class, leaveTypeViewPermit);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LeaveTypeViewPermitImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LeaveTypeViewPermitImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LeaveTypeViewPermitModelImpl leaveTypeViewPermitModelImpl) {

		Object[] args = new Object[] {
			leaveTypeViewPermitModelImpl.getUuid(),
			leaveTypeViewPermitModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, leaveTypeViewPermitModelImpl);

		args = new Object[] {
			leaveTypeViewPermitModelImpl.getEmployeeId(),
			leaveTypeViewPermitModelImpl.getLeaveTypeMasterId()
		};

		finderCache.putResult(
			_finderPathFetchByEmployeeIdAndLeaveTypeMasterId, args,
			leaveTypeViewPermitModelImpl);
	}

	/**
	 * Creates a new leave type view permit with the primary key. Does not add the leave type view permit to the database.
	 *
	 * @param leaveTypeViewPermitId the primary key for the new leave type view permit
	 * @return the new leave type view permit
	 */
	@Override
	public LeaveTypeViewPermit create(long leaveTypeViewPermitId) {
		LeaveTypeViewPermit leaveTypeViewPermit = new LeaveTypeViewPermitImpl();

		leaveTypeViewPermit.setNew(true);
		leaveTypeViewPermit.setPrimaryKey(leaveTypeViewPermitId);

		String uuid = PortalUUIDUtil.generate();

		leaveTypeViewPermit.setUuid(uuid);

		leaveTypeViewPermit.setCompanyId(CompanyThreadLocal.getCompanyId());

		return leaveTypeViewPermit;
	}

	/**
	 * Removes the leave type view permit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveTypeViewPermitId the primary key of the leave type view permit
	 * @return the leave type view permit that was removed
	 * @throws NoSuchLeaveTypeViewPermitException if a leave type view permit with the primary key could not be found
	 */
	@Override
	public LeaveTypeViewPermit remove(long leaveTypeViewPermitId)
		throws NoSuchLeaveTypeViewPermitException {

		return remove((Serializable)leaveTypeViewPermitId);
	}

	/**
	 * Removes the leave type view permit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave type view permit
	 * @return the leave type view permit that was removed
	 * @throws NoSuchLeaveTypeViewPermitException if a leave type view permit with the primary key could not be found
	 */
	@Override
	public LeaveTypeViewPermit remove(Serializable primaryKey)
		throws NoSuchLeaveTypeViewPermitException {

		Session session = null;

		try {
			session = openSession();

			LeaveTypeViewPermit leaveTypeViewPermit =
				(LeaveTypeViewPermit)session.get(
					LeaveTypeViewPermitImpl.class, primaryKey);

			if (leaveTypeViewPermit == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveTypeViewPermitException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(leaveTypeViewPermit);
		}
		catch (NoSuchLeaveTypeViewPermitException noSuchEntityException) {
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
	protected LeaveTypeViewPermit removeImpl(
		LeaveTypeViewPermit leaveTypeViewPermit) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveTypeViewPermit)) {
				leaveTypeViewPermit = (LeaveTypeViewPermit)session.get(
					LeaveTypeViewPermitImpl.class,
					leaveTypeViewPermit.getPrimaryKeyObj());
			}

			if (leaveTypeViewPermit != null) {
				session.delete(leaveTypeViewPermit);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (leaveTypeViewPermit != null) {
			clearCache(leaveTypeViewPermit);
		}

		return leaveTypeViewPermit;
	}

	@Override
	public LeaveTypeViewPermit updateImpl(
		LeaveTypeViewPermit leaveTypeViewPermit) {

		boolean isNew = leaveTypeViewPermit.isNew();

		if (!(leaveTypeViewPermit instanceof LeaveTypeViewPermitModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(leaveTypeViewPermit.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					leaveTypeViewPermit);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in leaveTypeViewPermit proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LeaveTypeViewPermit implementation " +
					leaveTypeViewPermit.getClass());
		}

		LeaveTypeViewPermitModelImpl leaveTypeViewPermitModelImpl =
			(LeaveTypeViewPermitModelImpl)leaveTypeViewPermit;

		if (Validator.isNull(leaveTypeViewPermit.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			leaveTypeViewPermit.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (leaveTypeViewPermit.getCreateDate() == null)) {
			if (serviceContext == null) {
				leaveTypeViewPermit.setCreateDate(date);
			}
			else {
				leaveTypeViewPermit.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!leaveTypeViewPermitModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				leaveTypeViewPermit.setModifiedDate(date);
			}
			else {
				leaveTypeViewPermit.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(leaveTypeViewPermit);
			}
			else {
				leaveTypeViewPermit = (LeaveTypeViewPermit)session.merge(
					leaveTypeViewPermit);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LeaveTypeViewPermitImpl.class, leaveTypeViewPermitModelImpl, false,
			true);

		cacheUniqueFindersCache(leaveTypeViewPermitModelImpl);

		if (isNew) {
			leaveTypeViewPermit.setNew(false);
		}

		leaveTypeViewPermit.resetOriginalValues();

		return leaveTypeViewPermit;
	}

	/**
	 * Returns the leave type view permit with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave type view permit
	 * @return the leave type view permit
	 * @throws NoSuchLeaveTypeViewPermitException if a leave type view permit with the primary key could not be found
	 */
	@Override
	public LeaveTypeViewPermit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveTypeViewPermitException {

		LeaveTypeViewPermit leaveTypeViewPermit = fetchByPrimaryKey(primaryKey);

		if (leaveTypeViewPermit == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveTypeViewPermitException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return leaveTypeViewPermit;
	}

	/**
	 * Returns the leave type view permit with the primary key or throws a <code>NoSuchLeaveTypeViewPermitException</code> if it could not be found.
	 *
	 * @param leaveTypeViewPermitId the primary key of the leave type view permit
	 * @return the leave type view permit
	 * @throws NoSuchLeaveTypeViewPermitException if a leave type view permit with the primary key could not be found
	 */
	@Override
	public LeaveTypeViewPermit findByPrimaryKey(long leaveTypeViewPermitId)
		throws NoSuchLeaveTypeViewPermitException {

		return findByPrimaryKey((Serializable)leaveTypeViewPermitId);
	}

	/**
	 * Returns the leave type view permit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveTypeViewPermitId the primary key of the leave type view permit
	 * @return the leave type view permit, or <code>null</code> if a leave type view permit with the primary key could not be found
	 */
	@Override
	public LeaveTypeViewPermit fetchByPrimaryKey(long leaveTypeViewPermitId) {
		return fetchByPrimaryKey((Serializable)leaveTypeViewPermitId);
	}

	/**
	 * Returns all the leave type view permits.
	 *
	 * @return the leave type view permits
	 */
	@Override
	public List<LeaveTypeViewPermit> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave type view permits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeViewPermitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave type view permits
	 * @param end the upper bound of the range of leave type view permits (not inclusive)
	 * @return the range of leave type view permits
	 */
	@Override
	public List<LeaveTypeViewPermit> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave type view permits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeViewPermitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave type view permits
	 * @param end the upper bound of the range of leave type view permits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave type view permits
	 */
	@Override
	public List<LeaveTypeViewPermit> findAll(
		int start, int end,
		OrderByComparator<LeaveTypeViewPermit> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave type view permits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeViewPermitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave type view permits
	 * @param end the upper bound of the range of leave type view permits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave type view permits
	 */
	@Override
	public List<LeaveTypeViewPermit> findAll(
		int start, int end,
		OrderByComparator<LeaveTypeViewPermit> orderByComparator,
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

		List<LeaveTypeViewPermit> list = null;

		if (useFinderCache) {
			list = (List<LeaveTypeViewPermit>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LEAVETYPEVIEWPERMIT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVETYPEVIEWPERMIT;

				sql = sql.concat(LeaveTypeViewPermitModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LeaveTypeViewPermit>)QueryUtil.list(
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
	 * Removes all the leave type view permits from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LeaveTypeViewPermit leaveTypeViewPermit : findAll()) {
			remove(leaveTypeViewPermit);
		}
	}

	/**
	 * Returns the number of leave type view permits.
	 *
	 * @return the number of leave type view permits
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
					_SQL_COUNT_LEAVETYPEVIEWPERMIT);

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
		return "leaveTypeViewPermitId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEAVETYPEVIEWPERMIT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LeaveTypeViewPermitModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leave type view permit persistence.
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

		_finderPathFetchByEmployeeIdAndLeaveTypeMasterId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByEmployeeIdAndLeaveTypeMasterId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"employeeId", "leaveTypeMasterId"}, true);

		LeaveTypeViewPermitUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		LeaveTypeViewPermitUtil.setPersistence(null);

		entityCache.removeCache(LeaveTypeViewPermitImpl.class.getName());
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

	private static final String _SQL_SELECT_LEAVETYPEVIEWPERMIT =
		"SELECT leaveTypeViewPermit FROM LeaveTypeViewPermit leaveTypeViewPermit";

	private static final String _SQL_SELECT_LEAVETYPEVIEWPERMIT_WHERE =
		"SELECT leaveTypeViewPermit FROM LeaveTypeViewPermit leaveTypeViewPermit WHERE ";

	private static final String _SQL_COUNT_LEAVETYPEVIEWPERMIT =
		"SELECT COUNT(leaveTypeViewPermit) FROM LeaveTypeViewPermit leaveTypeViewPermit";

	private static final String _SQL_COUNT_LEAVETYPEVIEWPERMIT_WHERE =
		"SELECT COUNT(leaveTypeViewPermit) FROM LeaveTypeViewPermit leaveTypeViewPermit WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveTypeViewPermit.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LeaveTypeViewPermit exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LeaveTypeViewPermit exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LeaveTypeViewPermitPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}