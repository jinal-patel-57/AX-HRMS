/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchLeaveInformToTeamDetailException;
import com.ax.hrms.model.LeaveInformToTeamDetail;
import com.ax.hrms.model.LeaveInformToTeamDetailTable;
import com.ax.hrms.model.impl.LeaveInformToTeamDetailImpl;
import com.ax.hrms.model.impl.LeaveInformToTeamDetailModelImpl;
import com.ax.hrms.service.persistence.LeaveInformToTeamDetailPersistence;
import com.ax.hrms.service.persistence.LeaveInformToTeamDetailUtil;
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
 * The persistence implementation for the leave inform to team detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LeaveInformToTeamDetailPersistence.class)
public class LeaveInformToTeamDetailPersistenceImpl
	extends BasePersistenceImpl<LeaveInformToTeamDetail>
	implements LeaveInformToTeamDetailPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LeaveInformToTeamDetailUtil</code> to access the leave inform to team detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LeaveInformToTeamDetailImpl.class.getName();

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
	 * Returns all the leave inform to team details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave inform to team details
	 */
	@Override
	public List<LeaveInformToTeamDetail> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave inform to team details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @return the range of matching leave inform to team details
	 */
	@Override
	public List<LeaveInformToTeamDetail> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave inform to team details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave inform to team details
	 */
	@Override
	public List<LeaveInformToTeamDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave inform to team details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave inform to team details
	 */
	@Override
	public List<LeaveInformToTeamDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator,
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

		List<LeaveInformToTeamDetail> list = null;

		if (useFinderCache) {
			list = (List<LeaveInformToTeamDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveInformToTeamDetail leaveInformToTeamDetail : list) {
					if (!uuid.equals(leaveInformToTeamDetail.getUuid())) {
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

			sb.append(_SQL_SELECT_LEAVEINFORMTOTEAMDETAIL_WHERE);

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
				sb.append(LeaveInformToTeamDetailModelImpl.ORDER_BY_JPQL);
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

				list = (List<LeaveInformToTeamDetail>)QueryUtil.list(
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
	 * Returns the first leave inform to team detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a matching leave inform to team detail could not be found
	 */
	@Override
	public LeaveInformToTeamDetail findByUuid_First(
			String uuid,
			OrderByComparator<LeaveInformToTeamDetail> orderByComparator)
		throws NoSuchLeaveInformToTeamDetailException {

		LeaveInformToTeamDetail leaveInformToTeamDetail = fetchByUuid_First(
			uuid, orderByComparator);

		if (leaveInformToTeamDetail != null) {
			return leaveInformToTeamDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLeaveInformToTeamDetailException(sb.toString());
	}

	/**
	 * Returns the first leave inform to team detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	@Override
	public LeaveInformToTeamDetail fetchByUuid_First(
		String uuid,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator) {

		List<LeaveInformToTeamDetail> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave inform to team detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a matching leave inform to team detail could not be found
	 */
	@Override
	public LeaveInformToTeamDetail findByUuid_Last(
			String uuid,
			OrderByComparator<LeaveInformToTeamDetail> orderByComparator)
		throws NoSuchLeaveInformToTeamDetailException {

		LeaveInformToTeamDetail leaveInformToTeamDetail = fetchByUuid_Last(
			uuid, orderByComparator);

		if (leaveInformToTeamDetail != null) {
			return leaveInformToTeamDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLeaveInformToTeamDetailException(sb.toString());
	}

	/**
	 * Returns the last leave inform to team detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	@Override
	public LeaveInformToTeamDetail fetchByUuid_Last(
		String uuid,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<LeaveInformToTeamDetail> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave inform to team details before and after the current leave inform to team detail in the ordered set where uuid = &#63;.
	 *
	 * @param leaveInformId the primary key of the current leave inform to team detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a leave inform to team detail with the primary key could not be found
	 */
	@Override
	public LeaveInformToTeamDetail[] findByUuid_PrevAndNext(
			long leaveInformId, String uuid,
			OrderByComparator<LeaveInformToTeamDetail> orderByComparator)
		throws NoSuchLeaveInformToTeamDetailException {

		uuid = Objects.toString(uuid, "");

		LeaveInformToTeamDetail leaveInformToTeamDetail = findByPrimaryKey(
			leaveInformId);

		Session session = null;

		try {
			session = openSession();

			LeaveInformToTeamDetail[] array =
				new LeaveInformToTeamDetailImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, leaveInformToTeamDetail, uuid, orderByComparator,
				true);

			array[1] = leaveInformToTeamDetail;

			array[2] = getByUuid_PrevAndNext(
				session, leaveInformToTeamDetail, uuid, orderByComparator,
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

	protected LeaveInformToTeamDetail getByUuid_PrevAndNext(
		Session session, LeaveInformToTeamDetail leaveInformToTeamDetail,
		String uuid,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator,
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

		sb.append(_SQL_SELECT_LEAVEINFORMTOTEAMDETAIL_WHERE);

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
			sb.append(LeaveInformToTeamDetailModelImpl.ORDER_BY_JPQL);
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
						leaveInformToTeamDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveInformToTeamDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave inform to team details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (LeaveInformToTeamDetail leaveInformToTeamDetail :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leaveInformToTeamDetail);
		}
	}

	/**
	 * Returns the number of leave inform to team details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave inform to team details
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVEINFORMTOTEAMDETAIL_WHERE);

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
		"leaveInformToTeamDetail.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(leaveInformToTeamDetail.uuid IS NULL OR leaveInformToTeamDetail.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the leave inform to team detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveInformToTeamDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a matching leave inform to team detail could not be found
	 */
	@Override
	public LeaveInformToTeamDetail findByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveInformToTeamDetailException {

		LeaveInformToTeamDetail leaveInformToTeamDetail = fetchByUUID_G(
			uuid, groupId);

		if (leaveInformToTeamDetail == null) {
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

			throw new NoSuchLeaveInformToTeamDetailException(sb.toString());
		}

		return leaveInformToTeamDetail;
	}

	/**
	 * Returns the leave inform to team detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	@Override
	public LeaveInformToTeamDetail fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the leave inform to team detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	@Override
	public LeaveInformToTeamDetail fetchByUUID_G(
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

		if (result instanceof LeaveInformToTeamDetail) {
			LeaveInformToTeamDetail leaveInformToTeamDetail =
				(LeaveInformToTeamDetail)result;

			if (!Objects.equals(uuid, leaveInformToTeamDetail.getUuid()) ||
				(groupId != leaveInformToTeamDetail.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LEAVEINFORMTOTEAMDETAIL_WHERE);

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

				List<LeaveInformToTeamDetail> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					LeaveInformToTeamDetail leaveInformToTeamDetail = list.get(
						0);

					result = leaveInformToTeamDetail;

					cacheResult(leaveInformToTeamDetail);
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
			return (LeaveInformToTeamDetail)result;
		}
	}

	/**
	 * Removes the leave inform to team detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave inform to team detail that was removed
	 */
	@Override
	public LeaveInformToTeamDetail removeByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveInformToTeamDetailException {

		LeaveInformToTeamDetail leaveInformToTeamDetail = findByUUID_G(
			uuid, groupId);

		return remove(leaveInformToTeamDetail);
	}

	/**
	 * Returns the number of leave inform to team details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave inform to team details
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVEINFORMTOTEAMDETAIL_WHERE);

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
		"leaveInformToTeamDetail.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(leaveInformToTeamDetail.uuid IS NULL OR leaveInformToTeamDetail.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"leaveInformToTeamDetail.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the leave inform to team details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave inform to team details
	 */
	@Override
	public List<LeaveInformToTeamDetail> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave inform to team details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @return the range of matching leave inform to team details
	 */
	@Override
	public List<LeaveInformToTeamDetail> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave inform to team details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave inform to team details
	 */
	@Override
	public List<LeaveInformToTeamDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave inform to team details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave inform to team details
	 */
	@Override
	public List<LeaveInformToTeamDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator,
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

		List<LeaveInformToTeamDetail> list = null;

		if (useFinderCache) {
			list = (List<LeaveInformToTeamDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveInformToTeamDetail leaveInformToTeamDetail : list) {
					if (!uuid.equals(leaveInformToTeamDetail.getUuid()) ||
						(companyId != leaveInformToTeamDetail.getCompanyId())) {

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

			sb.append(_SQL_SELECT_LEAVEINFORMTOTEAMDETAIL_WHERE);

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
				sb.append(LeaveInformToTeamDetailModelImpl.ORDER_BY_JPQL);
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

				list = (List<LeaveInformToTeamDetail>)QueryUtil.list(
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
	 * Returns the first leave inform to team detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a matching leave inform to team detail could not be found
	 */
	@Override
	public LeaveInformToTeamDetail findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LeaveInformToTeamDetail> orderByComparator)
		throws NoSuchLeaveInformToTeamDetailException {

		LeaveInformToTeamDetail leaveInformToTeamDetail = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (leaveInformToTeamDetail != null) {
			return leaveInformToTeamDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLeaveInformToTeamDetailException(sb.toString());
	}

	/**
	 * Returns the first leave inform to team detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	@Override
	public LeaveInformToTeamDetail fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator) {

		List<LeaveInformToTeamDetail> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave inform to team detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a matching leave inform to team detail could not be found
	 */
	@Override
	public LeaveInformToTeamDetail findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LeaveInformToTeamDetail> orderByComparator)
		throws NoSuchLeaveInformToTeamDetailException {

		LeaveInformToTeamDetail leaveInformToTeamDetail = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (leaveInformToTeamDetail != null) {
			return leaveInformToTeamDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLeaveInformToTeamDetailException(sb.toString());
	}

	/**
	 * Returns the last leave inform to team detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	@Override
	public LeaveInformToTeamDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<LeaveInformToTeamDetail> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave inform to team details before and after the current leave inform to team detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveInformId the primary key of the current leave inform to team detail
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a leave inform to team detail with the primary key could not be found
	 */
	@Override
	public LeaveInformToTeamDetail[] findByUuid_C_PrevAndNext(
			long leaveInformId, String uuid, long companyId,
			OrderByComparator<LeaveInformToTeamDetail> orderByComparator)
		throws NoSuchLeaveInformToTeamDetailException {

		uuid = Objects.toString(uuid, "");

		LeaveInformToTeamDetail leaveInformToTeamDetail = findByPrimaryKey(
			leaveInformId);

		Session session = null;

		try {
			session = openSession();

			LeaveInformToTeamDetail[] array =
				new LeaveInformToTeamDetailImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, leaveInformToTeamDetail, uuid, companyId,
				orderByComparator, true);

			array[1] = leaveInformToTeamDetail;

			array[2] = getByUuid_C_PrevAndNext(
				session, leaveInformToTeamDetail, uuid, companyId,
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

	protected LeaveInformToTeamDetail getByUuid_C_PrevAndNext(
		Session session, LeaveInformToTeamDetail leaveInformToTeamDetail,
		String uuid, long companyId,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator,
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

		sb.append(_SQL_SELECT_LEAVEINFORMTOTEAMDETAIL_WHERE);

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
			sb.append(LeaveInformToTeamDetailModelImpl.ORDER_BY_JPQL);
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
						leaveInformToTeamDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveInformToTeamDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave inform to team details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (LeaveInformToTeamDetail leaveInformToTeamDetail :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(leaveInformToTeamDetail);
		}
	}

	/**
	 * Returns the number of leave inform to team details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave inform to team details
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LEAVEINFORMTOTEAMDETAIL_WHERE);

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
		"leaveInformToTeamDetail.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(leaveInformToTeamDetail.uuid IS NULL OR leaveInformToTeamDetail.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"leaveInformToTeamDetail.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByLeaveRequestId;
	private FinderPath _finderPathWithoutPaginationFindByLeaveRequestId;
	private FinderPath _finderPathCountByLeaveRequestId;

	/**
	 * Returns all the leave inform to team details where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @return the matching leave inform to team details
	 */
	@Override
	public List<LeaveInformToTeamDetail> findByLeaveRequestId(
		long leaveRequestId) {

		return findByLeaveRequestId(
			leaveRequestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave inform to team details where leaveRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param leaveRequestId the leave request ID
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @return the range of matching leave inform to team details
	 */
	@Override
	public List<LeaveInformToTeamDetail> findByLeaveRequestId(
		long leaveRequestId, int start, int end) {

		return findByLeaveRequestId(leaveRequestId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave inform to team details where leaveRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param leaveRequestId the leave request ID
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave inform to team details
	 */
	@Override
	public List<LeaveInformToTeamDetail> findByLeaveRequestId(
		long leaveRequestId, int start, int end,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator) {

		return findByLeaveRequestId(
			leaveRequestId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave inform to team details where leaveRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param leaveRequestId the leave request ID
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave inform to team details
	 */
	@Override
	public List<LeaveInformToTeamDetail> findByLeaveRequestId(
		long leaveRequestId, int start, int end,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByLeaveRequestId;
				finderArgs = new Object[] {leaveRequestId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByLeaveRequestId;
			finderArgs = new Object[] {
				leaveRequestId, start, end, orderByComparator
			};
		}

		List<LeaveInformToTeamDetail> list = null;

		if (useFinderCache) {
			list = (List<LeaveInformToTeamDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LeaveInformToTeamDetail leaveInformToTeamDetail : list) {
					if (leaveRequestId !=
							leaveInformToTeamDetail.getLeaveRequestId()) {

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

			sb.append(_SQL_SELECT_LEAVEINFORMTOTEAMDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LeaveInformToTeamDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(leaveRequestId);

				list = (List<LeaveInformToTeamDetail>)QueryUtil.list(
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
	 * Returns the first leave inform to team detail in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a matching leave inform to team detail could not be found
	 */
	@Override
	public LeaveInformToTeamDetail findByLeaveRequestId_First(
			long leaveRequestId,
			OrderByComparator<LeaveInformToTeamDetail> orderByComparator)
		throws NoSuchLeaveInformToTeamDetailException {

		LeaveInformToTeamDetail leaveInformToTeamDetail =
			fetchByLeaveRequestId_First(leaveRequestId, orderByComparator);

		if (leaveInformToTeamDetail != null) {
			return leaveInformToTeamDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("leaveRequestId=");
		sb.append(leaveRequestId);

		sb.append("}");

		throw new NoSuchLeaveInformToTeamDetailException(sb.toString());
	}

	/**
	 * Returns the first leave inform to team detail in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	@Override
	public LeaveInformToTeamDetail fetchByLeaveRequestId_First(
		long leaveRequestId,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator) {

		List<LeaveInformToTeamDetail> list = findByLeaveRequestId(
			leaveRequestId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leave inform to team detail in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a matching leave inform to team detail could not be found
	 */
	@Override
	public LeaveInformToTeamDetail findByLeaveRequestId_Last(
			long leaveRequestId,
			OrderByComparator<LeaveInformToTeamDetail> orderByComparator)
		throws NoSuchLeaveInformToTeamDetailException {

		LeaveInformToTeamDetail leaveInformToTeamDetail =
			fetchByLeaveRequestId_Last(leaveRequestId, orderByComparator);

		if (leaveInformToTeamDetail != null) {
			return leaveInformToTeamDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("leaveRequestId=");
		sb.append(leaveRequestId);

		sb.append("}");

		throw new NoSuchLeaveInformToTeamDetailException(sb.toString());
	}

	/**
	 * Returns the last leave inform to team detail in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	@Override
	public LeaveInformToTeamDetail fetchByLeaveRequestId_Last(
		long leaveRequestId,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator) {

		int count = countByLeaveRequestId(leaveRequestId);

		if (count == 0) {
			return null;
		}

		List<LeaveInformToTeamDetail> list = findByLeaveRequestId(
			leaveRequestId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leave inform to team details before and after the current leave inform to team detail in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveInformId the primary key of the current leave inform to team detail
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a leave inform to team detail with the primary key could not be found
	 */
	@Override
	public LeaveInformToTeamDetail[] findByLeaveRequestId_PrevAndNext(
			long leaveInformId, long leaveRequestId,
			OrderByComparator<LeaveInformToTeamDetail> orderByComparator)
		throws NoSuchLeaveInformToTeamDetailException {

		LeaveInformToTeamDetail leaveInformToTeamDetail = findByPrimaryKey(
			leaveInformId);

		Session session = null;

		try {
			session = openSession();

			LeaveInformToTeamDetail[] array =
				new LeaveInformToTeamDetailImpl[3];

			array[0] = getByLeaveRequestId_PrevAndNext(
				session, leaveInformToTeamDetail, leaveRequestId,
				orderByComparator, true);

			array[1] = leaveInformToTeamDetail;

			array[2] = getByLeaveRequestId_PrevAndNext(
				session, leaveInformToTeamDetail, leaveRequestId,
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

	protected LeaveInformToTeamDetail getByLeaveRequestId_PrevAndNext(
		Session session, LeaveInformToTeamDetail leaveInformToTeamDetail,
		long leaveRequestId,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator,
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

		sb.append(_SQL_SELECT_LEAVEINFORMTOTEAMDETAIL_WHERE);

		sb.append(_FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_2);

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
			sb.append(LeaveInformToTeamDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(leaveRequestId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						leaveInformToTeamDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LeaveInformToTeamDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leave inform to team details where leaveRequestId = &#63; from the database.
	 *
	 * @param leaveRequestId the leave request ID
	 */
	@Override
	public void removeByLeaveRequestId(long leaveRequestId) {
		for (LeaveInformToTeamDetail leaveInformToTeamDetail :
				findByLeaveRequestId(
					leaveRequestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(leaveInformToTeamDetail);
		}
	}

	/**
	 * Returns the number of leave inform to team details where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @return the number of matching leave inform to team details
	 */
	@Override
	public int countByLeaveRequestId(long leaveRequestId) {
		FinderPath finderPath = _finderPathCountByLeaveRequestId;

		Object[] finderArgs = new Object[] {leaveRequestId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEAVEINFORMTOTEAMDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(leaveRequestId);

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

	private static final String _FINDER_COLUMN_LEAVEREQUESTID_LEAVEREQUESTID_2 =
		"leaveInformToTeamDetail.leaveRequestId = ?";

	public LeaveInformToTeamDetailPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(LeaveInformToTeamDetail.class);

		setModelImplClass(LeaveInformToTeamDetailImpl.class);
		setModelPKClass(long.class);

		setTable(LeaveInformToTeamDetailTable.INSTANCE);
	}

	/**
	 * Caches the leave inform to team detail in the entity cache if it is enabled.
	 *
	 * @param leaveInformToTeamDetail the leave inform to team detail
	 */
	@Override
	public void cacheResult(LeaveInformToTeamDetail leaveInformToTeamDetail) {
		entityCache.putResult(
			LeaveInformToTeamDetailImpl.class,
			leaveInformToTeamDetail.getPrimaryKey(), leaveInformToTeamDetail);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				leaveInformToTeamDetail.getUuid(),
				leaveInformToTeamDetail.getGroupId()
			},
			leaveInformToTeamDetail);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the leave inform to team details in the entity cache if it is enabled.
	 *
	 * @param leaveInformToTeamDetails the leave inform to team details
	 */
	@Override
	public void cacheResult(
		List<LeaveInformToTeamDetail> leaveInformToTeamDetails) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (leaveInformToTeamDetails.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LeaveInformToTeamDetail leaveInformToTeamDetail :
				leaveInformToTeamDetails) {

			if (entityCache.getResult(
					LeaveInformToTeamDetailImpl.class,
					leaveInformToTeamDetail.getPrimaryKey()) == null) {

				cacheResult(leaveInformToTeamDetail);
			}
		}
	}

	/**
	 * Clears the cache for all leave inform to team details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LeaveInformToTeamDetailImpl.class);

		finderCache.clearCache(LeaveInformToTeamDetailImpl.class);
	}

	/**
	 * Clears the cache for the leave inform to team detail.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveInformToTeamDetail leaveInformToTeamDetail) {
		entityCache.removeResult(
			LeaveInformToTeamDetailImpl.class, leaveInformToTeamDetail);
	}

	@Override
	public void clearCache(
		List<LeaveInformToTeamDetail> leaveInformToTeamDetails) {

		for (LeaveInformToTeamDetail leaveInformToTeamDetail :
				leaveInformToTeamDetails) {

			entityCache.removeResult(
				LeaveInformToTeamDetailImpl.class, leaveInformToTeamDetail);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LeaveInformToTeamDetailImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				LeaveInformToTeamDetailImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LeaveInformToTeamDetailModelImpl leaveInformToTeamDetailModelImpl) {

		Object[] args = new Object[] {
			leaveInformToTeamDetailModelImpl.getUuid(),
			leaveInformToTeamDetailModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, leaveInformToTeamDetailModelImpl);
	}

	/**
	 * Creates a new leave inform to team detail with the primary key. Does not add the leave inform to team detail to the database.
	 *
	 * @param leaveInformId the primary key for the new leave inform to team detail
	 * @return the new leave inform to team detail
	 */
	@Override
	public LeaveInformToTeamDetail create(long leaveInformId) {
		LeaveInformToTeamDetail leaveInformToTeamDetail =
			new LeaveInformToTeamDetailImpl();

		leaveInformToTeamDetail.setNew(true);
		leaveInformToTeamDetail.setPrimaryKey(leaveInformId);

		String uuid = PortalUUIDUtil.generate();

		leaveInformToTeamDetail.setUuid(uuid);

		leaveInformToTeamDetail.setCompanyId(CompanyThreadLocal.getCompanyId());

		return leaveInformToTeamDetail;
	}

	/**
	 * Removes the leave inform to team detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveInformId the primary key of the leave inform to team detail
	 * @return the leave inform to team detail that was removed
	 * @throws NoSuchLeaveInformToTeamDetailException if a leave inform to team detail with the primary key could not be found
	 */
	@Override
	public LeaveInformToTeamDetail remove(long leaveInformId)
		throws NoSuchLeaveInformToTeamDetailException {

		return remove((Serializable)leaveInformId);
	}

	/**
	 * Removes the leave inform to team detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave inform to team detail
	 * @return the leave inform to team detail that was removed
	 * @throws NoSuchLeaveInformToTeamDetailException if a leave inform to team detail with the primary key could not be found
	 */
	@Override
	public LeaveInformToTeamDetail remove(Serializable primaryKey)
		throws NoSuchLeaveInformToTeamDetailException {

		Session session = null;

		try {
			session = openSession();

			LeaveInformToTeamDetail leaveInformToTeamDetail =
				(LeaveInformToTeamDetail)session.get(
					LeaveInformToTeamDetailImpl.class, primaryKey);

			if (leaveInformToTeamDetail == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveInformToTeamDetailException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(leaveInformToTeamDetail);
		}
		catch (NoSuchLeaveInformToTeamDetailException noSuchEntityException) {
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
	protected LeaveInformToTeamDetail removeImpl(
		LeaveInformToTeamDetail leaveInformToTeamDetail) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveInformToTeamDetail)) {
				leaveInformToTeamDetail = (LeaveInformToTeamDetail)session.get(
					LeaveInformToTeamDetailImpl.class,
					leaveInformToTeamDetail.getPrimaryKeyObj());
			}

			if (leaveInformToTeamDetail != null) {
				session.delete(leaveInformToTeamDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (leaveInformToTeamDetail != null) {
			clearCache(leaveInformToTeamDetail);
		}

		return leaveInformToTeamDetail;
	}

	@Override
	public LeaveInformToTeamDetail updateImpl(
		LeaveInformToTeamDetail leaveInformToTeamDetail) {

		boolean isNew = leaveInformToTeamDetail.isNew();

		if (!(leaveInformToTeamDetail instanceof
				LeaveInformToTeamDetailModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(leaveInformToTeamDetail.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					leaveInformToTeamDetail);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in leaveInformToTeamDetail proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LeaveInformToTeamDetail implementation " +
					leaveInformToTeamDetail.getClass());
		}

		LeaveInformToTeamDetailModelImpl leaveInformToTeamDetailModelImpl =
			(LeaveInformToTeamDetailModelImpl)leaveInformToTeamDetail;

		if (Validator.isNull(leaveInformToTeamDetail.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			leaveInformToTeamDetail.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (leaveInformToTeamDetail.getCreateDate() == null)) {
			if (serviceContext == null) {
				leaveInformToTeamDetail.setCreateDate(date);
			}
			else {
				leaveInformToTeamDetail.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!leaveInformToTeamDetailModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				leaveInformToTeamDetail.setModifiedDate(date);
			}
			else {
				leaveInformToTeamDetail.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(leaveInformToTeamDetail);
			}
			else {
				leaveInformToTeamDetail =
					(LeaveInformToTeamDetail)session.merge(
						leaveInformToTeamDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LeaveInformToTeamDetailImpl.class, leaveInformToTeamDetailModelImpl,
			false, true);

		cacheUniqueFindersCache(leaveInformToTeamDetailModelImpl);

		if (isNew) {
			leaveInformToTeamDetail.setNew(false);
		}

		leaveInformToTeamDetail.resetOriginalValues();

		return leaveInformToTeamDetail;
	}

	/**
	 * Returns the leave inform to team detail with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave inform to team detail
	 * @return the leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a leave inform to team detail with the primary key could not be found
	 */
	@Override
	public LeaveInformToTeamDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveInformToTeamDetailException {

		LeaveInformToTeamDetail leaveInformToTeamDetail = fetchByPrimaryKey(
			primaryKey);

		if (leaveInformToTeamDetail == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveInformToTeamDetailException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return leaveInformToTeamDetail;
	}

	/**
	 * Returns the leave inform to team detail with the primary key or throws a <code>NoSuchLeaveInformToTeamDetailException</code> if it could not be found.
	 *
	 * @param leaveInformId the primary key of the leave inform to team detail
	 * @return the leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a leave inform to team detail with the primary key could not be found
	 */
	@Override
	public LeaveInformToTeamDetail findByPrimaryKey(long leaveInformId)
		throws NoSuchLeaveInformToTeamDetailException {

		return findByPrimaryKey((Serializable)leaveInformId);
	}

	/**
	 * Returns the leave inform to team detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveInformId the primary key of the leave inform to team detail
	 * @return the leave inform to team detail, or <code>null</code> if a leave inform to team detail with the primary key could not be found
	 */
	@Override
	public LeaveInformToTeamDetail fetchByPrimaryKey(long leaveInformId) {
		return fetchByPrimaryKey((Serializable)leaveInformId);
	}

	/**
	 * Returns all the leave inform to team details.
	 *
	 * @return the leave inform to team details
	 */
	@Override
	public List<LeaveInformToTeamDetail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave inform to team details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @return the range of leave inform to team details
	 */
	@Override
	public List<LeaveInformToTeamDetail> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave inform to team details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave inform to team details
	 */
	@Override
	public List<LeaveInformToTeamDetail> findAll(
		int start, int end,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave inform to team details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave inform to team details
	 */
	@Override
	public List<LeaveInformToTeamDetail> findAll(
		int start, int end,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator,
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

		List<LeaveInformToTeamDetail> list = null;

		if (useFinderCache) {
			list = (List<LeaveInformToTeamDetail>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LEAVEINFORMTOTEAMDETAIL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVEINFORMTOTEAMDETAIL;

				sql = sql.concat(
					LeaveInformToTeamDetailModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LeaveInformToTeamDetail>)QueryUtil.list(
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
	 * Removes all the leave inform to team details from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LeaveInformToTeamDetail leaveInformToTeamDetail : findAll()) {
			remove(leaveInformToTeamDetail);
		}
	}

	/**
	 * Returns the number of leave inform to team details.
	 *
	 * @return the number of leave inform to team details
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
					_SQL_COUNT_LEAVEINFORMTOTEAMDETAIL);

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
		return "leaveInformId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEAVEINFORMTOTEAMDETAIL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LeaveInformToTeamDetailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leave inform to team detail persistence.
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

		_finderPathWithPaginationFindByLeaveRequestId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLeaveRequestId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"leaveRequestId"}, true);

		_finderPathWithoutPaginationFindByLeaveRequestId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLeaveRequestId",
			new String[] {Long.class.getName()},
			new String[] {"leaveRequestId"}, true);

		_finderPathCountByLeaveRequestId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLeaveRequestId",
			new String[] {Long.class.getName()},
			new String[] {"leaveRequestId"}, false);

		LeaveInformToTeamDetailUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		LeaveInformToTeamDetailUtil.setPersistence(null);

		entityCache.removeCache(LeaveInformToTeamDetailImpl.class.getName());
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

	private static final String _SQL_SELECT_LEAVEINFORMTOTEAMDETAIL =
		"SELECT leaveInformToTeamDetail FROM LeaveInformToTeamDetail leaveInformToTeamDetail";

	private static final String _SQL_SELECT_LEAVEINFORMTOTEAMDETAIL_WHERE =
		"SELECT leaveInformToTeamDetail FROM LeaveInformToTeamDetail leaveInformToTeamDetail WHERE ";

	private static final String _SQL_COUNT_LEAVEINFORMTOTEAMDETAIL =
		"SELECT COUNT(leaveInformToTeamDetail) FROM LeaveInformToTeamDetail leaveInformToTeamDetail";

	private static final String _SQL_COUNT_LEAVEINFORMTOTEAMDETAIL_WHERE =
		"SELECT COUNT(leaveInformToTeamDetail) FROM LeaveInformToTeamDetail leaveInformToTeamDetail WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"leaveInformToTeamDetail.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LeaveInformToTeamDetail exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LeaveInformToTeamDetail exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LeaveInformToTeamDetailPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}