/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchAppraisalMeetingInviteesException;
import com.ax.hrms.model.AppraisalMeetingInvitees;
import com.ax.hrms.model.AppraisalMeetingInviteesTable;
import com.ax.hrms.model.impl.AppraisalMeetingInviteesImpl;
import com.ax.hrms.model.impl.AppraisalMeetingInviteesModelImpl;
import com.ax.hrms.service.persistence.AppraisalMeetingInviteesPersistence;
import com.ax.hrms.service.persistence.AppraisalMeetingInviteesUtil;
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
 * The persistence implementation for the appraisal meeting invitees service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AppraisalMeetingInviteesPersistence.class)
public class AppraisalMeetingInviteesPersistenceImpl
	extends BasePersistenceImpl<AppraisalMeetingInvitees>
	implements AppraisalMeetingInviteesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AppraisalMeetingInviteesUtil</code> to access the appraisal meeting invitees persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AppraisalMeetingInviteesImpl.class.getName();

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
	 * Returns all the appraisal meeting inviteeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching appraisal meeting inviteeses
	 */
	@Override
	public List<AppraisalMeetingInvitees> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal meeting inviteeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @return the range of matching appraisal meeting inviteeses
	 */
	@Override
	public List<AppraisalMeetingInvitees> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal meeting inviteeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal meeting inviteeses
	 */
	@Override
	public List<AppraisalMeetingInvitees> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal meeting inviteeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal meeting inviteeses
	 */
	@Override
	public List<AppraisalMeetingInvitees> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator,
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

		List<AppraisalMeetingInvitees> list = null;

		if (useFinderCache) {
			list = (List<AppraisalMeetingInvitees>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppraisalMeetingInvitees appraisalMeetingInvitees : list) {
					if (!uuid.equals(appraisalMeetingInvitees.getUuid())) {
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

			sb.append(_SQL_SELECT_APPRAISALMEETINGINVITEES_WHERE);

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
				sb.append(AppraisalMeetingInviteesModelImpl.ORDER_BY_JPQL);
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

				list = (List<AppraisalMeetingInvitees>)QueryUtil.list(
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
	 * Returns the first appraisal meeting invitees in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a matching appraisal meeting invitees could not be found
	 */
	@Override
	public AppraisalMeetingInvitees findByUuid_First(
			String uuid,
			OrderByComparator<AppraisalMeetingInvitees> orderByComparator)
		throws NoSuchAppraisalMeetingInviteesException {

		AppraisalMeetingInvitees appraisalMeetingInvitees = fetchByUuid_First(
			uuid, orderByComparator);

		if (appraisalMeetingInvitees != null) {
			return appraisalMeetingInvitees;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAppraisalMeetingInviteesException(sb.toString());
	}

	/**
	 * Returns the first appraisal meeting invitees in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	@Override
	public AppraisalMeetingInvitees fetchByUuid_First(
		String uuid,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator) {

		List<AppraisalMeetingInvitees> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appraisal meeting invitees in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a matching appraisal meeting invitees could not be found
	 */
	@Override
	public AppraisalMeetingInvitees findByUuid_Last(
			String uuid,
			OrderByComparator<AppraisalMeetingInvitees> orderByComparator)
		throws NoSuchAppraisalMeetingInviteesException {

		AppraisalMeetingInvitees appraisalMeetingInvitees = fetchByUuid_Last(
			uuid, orderByComparator);

		if (appraisalMeetingInvitees != null) {
			return appraisalMeetingInvitees;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAppraisalMeetingInviteesException(sb.toString());
	}

	/**
	 * Returns the last appraisal meeting invitees in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	@Override
	public AppraisalMeetingInvitees fetchByUuid_Last(
		String uuid,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AppraisalMeetingInvitees> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appraisal meeting inviteeses before and after the current appraisal meeting invitees in the ordered set where uuid = &#63;.
	 *
	 * @param appraisalMeetingInviteeId the primary key of the current appraisal meeting invitees
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a appraisal meeting invitees with the primary key could not be found
	 */
	@Override
	public AppraisalMeetingInvitees[] findByUuid_PrevAndNext(
			long appraisalMeetingInviteeId, String uuid,
			OrderByComparator<AppraisalMeetingInvitees> orderByComparator)
		throws NoSuchAppraisalMeetingInviteesException {

		uuid = Objects.toString(uuid, "");

		AppraisalMeetingInvitees appraisalMeetingInvitees = findByPrimaryKey(
			appraisalMeetingInviteeId);

		Session session = null;

		try {
			session = openSession();

			AppraisalMeetingInvitees[] array =
				new AppraisalMeetingInviteesImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, appraisalMeetingInvitees, uuid, orderByComparator,
				true);

			array[1] = appraisalMeetingInvitees;

			array[2] = getByUuid_PrevAndNext(
				session, appraisalMeetingInvitees, uuid, orderByComparator,
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

	protected AppraisalMeetingInvitees getByUuid_PrevAndNext(
		Session session, AppraisalMeetingInvitees appraisalMeetingInvitees,
		String uuid,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator,
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

		sb.append(_SQL_SELECT_APPRAISALMEETINGINVITEES_WHERE);

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
			sb.append(AppraisalMeetingInviteesModelImpl.ORDER_BY_JPQL);
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
						appraisalMeetingInvitees)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppraisalMeetingInvitees> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appraisal meeting inviteeses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AppraisalMeetingInvitees appraisalMeetingInvitees :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(appraisalMeetingInvitees);
		}
	}

	/**
	 * Returns the number of appraisal meeting inviteeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching appraisal meeting inviteeses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPRAISALMEETINGINVITEES_WHERE);

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
		"appraisalMeetingInvitees.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(appraisalMeetingInvitees.uuid IS NULL OR appraisalMeetingInvitees.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the appraisal meeting invitees where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAppraisalMeetingInviteesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a matching appraisal meeting invitees could not be found
	 */
	@Override
	public AppraisalMeetingInvitees findByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalMeetingInviteesException {

		AppraisalMeetingInvitees appraisalMeetingInvitees = fetchByUUID_G(
			uuid, groupId);

		if (appraisalMeetingInvitees == null) {
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

			throw new NoSuchAppraisalMeetingInviteesException(sb.toString());
		}

		return appraisalMeetingInvitees;
	}

	/**
	 * Returns the appraisal meeting invitees where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	@Override
	public AppraisalMeetingInvitees fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the appraisal meeting invitees where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	@Override
	public AppraisalMeetingInvitees fetchByUUID_G(
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

		if (result instanceof AppraisalMeetingInvitees) {
			AppraisalMeetingInvitees appraisalMeetingInvitees =
				(AppraisalMeetingInvitees)result;

			if (!Objects.equals(uuid, appraisalMeetingInvitees.getUuid()) ||
				(groupId != appraisalMeetingInvitees.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_APPRAISALMEETINGINVITEES_WHERE);

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

				List<AppraisalMeetingInvitees> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					AppraisalMeetingInvitees appraisalMeetingInvitees =
						list.get(0);

					result = appraisalMeetingInvitees;

					cacheResult(appraisalMeetingInvitees);
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
			return (AppraisalMeetingInvitees)result;
		}
	}

	/**
	 * Removes the appraisal meeting invitees where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the appraisal meeting invitees that was removed
	 */
	@Override
	public AppraisalMeetingInvitees removeByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalMeetingInviteesException {

		AppraisalMeetingInvitees appraisalMeetingInvitees = findByUUID_G(
			uuid, groupId);

		return remove(appraisalMeetingInvitees);
	}

	/**
	 * Returns the number of appraisal meeting inviteeses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching appraisal meeting inviteeses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		AppraisalMeetingInvitees appraisalMeetingInvitees = fetchByUUID_G(
			uuid, groupId);

		if (appraisalMeetingInvitees == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"appraisalMeetingInvitees.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(appraisalMeetingInvitees.uuid IS NULL OR appraisalMeetingInvitees.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"appraisalMeetingInvitees.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the appraisal meeting inviteeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching appraisal meeting inviteeses
	 */
	@Override
	public List<AppraisalMeetingInvitees> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal meeting inviteeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @return the range of matching appraisal meeting inviteeses
	 */
	@Override
	public List<AppraisalMeetingInvitees> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal meeting inviteeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal meeting inviteeses
	 */
	@Override
	public List<AppraisalMeetingInvitees> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal meeting inviteeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal meeting inviteeses
	 */
	@Override
	public List<AppraisalMeetingInvitees> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator,
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

		List<AppraisalMeetingInvitees> list = null;

		if (useFinderCache) {
			list = (List<AppraisalMeetingInvitees>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppraisalMeetingInvitees appraisalMeetingInvitees : list) {
					if (!uuid.equals(appraisalMeetingInvitees.getUuid()) ||
						(companyId !=
							appraisalMeetingInvitees.getCompanyId())) {

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

			sb.append(_SQL_SELECT_APPRAISALMEETINGINVITEES_WHERE);

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
				sb.append(AppraisalMeetingInviteesModelImpl.ORDER_BY_JPQL);
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

				list = (List<AppraisalMeetingInvitees>)QueryUtil.list(
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
	 * Returns the first appraisal meeting invitees in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a matching appraisal meeting invitees could not be found
	 */
	@Override
	public AppraisalMeetingInvitees findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AppraisalMeetingInvitees> orderByComparator)
		throws NoSuchAppraisalMeetingInviteesException {

		AppraisalMeetingInvitees appraisalMeetingInvitees = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (appraisalMeetingInvitees != null) {
			return appraisalMeetingInvitees;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAppraisalMeetingInviteesException(sb.toString());
	}

	/**
	 * Returns the first appraisal meeting invitees in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	@Override
	public AppraisalMeetingInvitees fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator) {

		List<AppraisalMeetingInvitees> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appraisal meeting invitees in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a matching appraisal meeting invitees could not be found
	 */
	@Override
	public AppraisalMeetingInvitees findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AppraisalMeetingInvitees> orderByComparator)
		throws NoSuchAppraisalMeetingInviteesException {

		AppraisalMeetingInvitees appraisalMeetingInvitees = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (appraisalMeetingInvitees != null) {
			return appraisalMeetingInvitees;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAppraisalMeetingInviteesException(sb.toString());
	}

	/**
	 * Returns the last appraisal meeting invitees in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	@Override
	public AppraisalMeetingInvitees fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AppraisalMeetingInvitees> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appraisal meeting inviteeses before and after the current appraisal meeting invitees in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param appraisalMeetingInviteeId the primary key of the current appraisal meeting invitees
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a appraisal meeting invitees with the primary key could not be found
	 */
	@Override
	public AppraisalMeetingInvitees[] findByUuid_C_PrevAndNext(
			long appraisalMeetingInviteeId, String uuid, long companyId,
			OrderByComparator<AppraisalMeetingInvitees> orderByComparator)
		throws NoSuchAppraisalMeetingInviteesException {

		uuid = Objects.toString(uuid, "");

		AppraisalMeetingInvitees appraisalMeetingInvitees = findByPrimaryKey(
			appraisalMeetingInviteeId);

		Session session = null;

		try {
			session = openSession();

			AppraisalMeetingInvitees[] array =
				new AppraisalMeetingInviteesImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, appraisalMeetingInvitees, uuid, companyId,
				orderByComparator, true);

			array[1] = appraisalMeetingInvitees;

			array[2] = getByUuid_C_PrevAndNext(
				session, appraisalMeetingInvitees, uuid, companyId,
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

	protected AppraisalMeetingInvitees getByUuid_C_PrevAndNext(
		Session session, AppraisalMeetingInvitees appraisalMeetingInvitees,
		String uuid, long companyId,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator,
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

		sb.append(_SQL_SELECT_APPRAISALMEETINGINVITEES_WHERE);

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
			sb.append(AppraisalMeetingInviteesModelImpl.ORDER_BY_JPQL);
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
						appraisalMeetingInvitees)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppraisalMeetingInvitees> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appraisal meeting inviteeses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AppraisalMeetingInvitees appraisalMeetingInvitees :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(appraisalMeetingInvitees);
		}
	}

	/**
	 * Returns the number of appraisal meeting inviteeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching appraisal meeting inviteeses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_APPRAISALMEETINGINVITEES_WHERE);

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
		"appraisalMeetingInvitees.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(appraisalMeetingInvitees.uuid IS NULL OR appraisalMeetingInvitees.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"appraisalMeetingInvitees.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByAppraisalMeetingId;
	private FinderPath _finderPathWithoutPaginationFindByAppraisalMeetingId;
	private FinderPath _finderPathCountByAppraisalMeetingId;

	/**
	 * Returns all the appraisal meeting inviteeses where appraisalMeetingId = &#63;.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @return the matching appraisal meeting inviteeses
	 */
	@Override
	public List<AppraisalMeetingInvitees> findByAppraisalMeetingId(
		long appraisalMeetingId) {

		return findByAppraisalMeetingId(
			appraisalMeetingId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal meeting inviteeses where appraisalMeetingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @return the range of matching appraisal meeting inviteeses
	 */
	@Override
	public List<AppraisalMeetingInvitees> findByAppraisalMeetingId(
		long appraisalMeetingId, int start, int end) {

		return findByAppraisalMeetingId(appraisalMeetingId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal meeting inviteeses where appraisalMeetingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal meeting inviteeses
	 */
	@Override
	public List<AppraisalMeetingInvitees> findByAppraisalMeetingId(
		long appraisalMeetingId, int start, int end,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator) {

		return findByAppraisalMeetingId(
			appraisalMeetingId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal meeting inviteeses where appraisalMeetingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal meeting inviteeses
	 */
	@Override
	public List<AppraisalMeetingInvitees> findByAppraisalMeetingId(
		long appraisalMeetingId, int start, int end,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByAppraisalMeetingId;
				finderArgs = new Object[] {appraisalMeetingId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAppraisalMeetingId;
			finderArgs = new Object[] {
				appraisalMeetingId, start, end, orderByComparator
			};
		}

		List<AppraisalMeetingInvitees> list = null;

		if (useFinderCache) {
			list = (List<AppraisalMeetingInvitees>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppraisalMeetingInvitees appraisalMeetingInvitees : list) {
					if (appraisalMeetingId !=
							appraisalMeetingInvitees.getAppraisalMeetingId()) {

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

			sb.append(_SQL_SELECT_APPRAISALMEETINGINVITEES_WHERE);

			sb.append(_FINDER_COLUMN_APPRAISALMEETINGID_APPRAISALMEETINGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AppraisalMeetingInviteesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(appraisalMeetingId);

				list = (List<AppraisalMeetingInvitees>)QueryUtil.list(
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
	 * Returns the first appraisal meeting invitees in the ordered set where appraisalMeetingId = &#63;.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a matching appraisal meeting invitees could not be found
	 */
	@Override
	public AppraisalMeetingInvitees findByAppraisalMeetingId_First(
			long appraisalMeetingId,
			OrderByComparator<AppraisalMeetingInvitees> orderByComparator)
		throws NoSuchAppraisalMeetingInviteesException {

		AppraisalMeetingInvitees appraisalMeetingInvitees =
			fetchByAppraisalMeetingId_First(
				appraisalMeetingId, orderByComparator);

		if (appraisalMeetingInvitees != null) {
			return appraisalMeetingInvitees;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("appraisalMeetingId=");
		sb.append(appraisalMeetingId);

		sb.append("}");

		throw new NoSuchAppraisalMeetingInviteesException(sb.toString());
	}

	/**
	 * Returns the first appraisal meeting invitees in the ordered set where appraisalMeetingId = &#63;.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	@Override
	public AppraisalMeetingInvitees fetchByAppraisalMeetingId_First(
		long appraisalMeetingId,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator) {

		List<AppraisalMeetingInvitees> list = findByAppraisalMeetingId(
			appraisalMeetingId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appraisal meeting invitees in the ordered set where appraisalMeetingId = &#63;.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a matching appraisal meeting invitees could not be found
	 */
	@Override
	public AppraisalMeetingInvitees findByAppraisalMeetingId_Last(
			long appraisalMeetingId,
			OrderByComparator<AppraisalMeetingInvitees> orderByComparator)
		throws NoSuchAppraisalMeetingInviteesException {

		AppraisalMeetingInvitees appraisalMeetingInvitees =
			fetchByAppraisalMeetingId_Last(
				appraisalMeetingId, orderByComparator);

		if (appraisalMeetingInvitees != null) {
			return appraisalMeetingInvitees;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("appraisalMeetingId=");
		sb.append(appraisalMeetingId);

		sb.append("}");

		throw new NoSuchAppraisalMeetingInviteesException(sb.toString());
	}

	/**
	 * Returns the last appraisal meeting invitees in the ordered set where appraisalMeetingId = &#63;.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	@Override
	public AppraisalMeetingInvitees fetchByAppraisalMeetingId_Last(
		long appraisalMeetingId,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator) {

		int count = countByAppraisalMeetingId(appraisalMeetingId);

		if (count == 0) {
			return null;
		}

		List<AppraisalMeetingInvitees> list = findByAppraisalMeetingId(
			appraisalMeetingId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appraisal meeting inviteeses before and after the current appraisal meeting invitees in the ordered set where appraisalMeetingId = &#63;.
	 *
	 * @param appraisalMeetingInviteeId the primary key of the current appraisal meeting invitees
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a appraisal meeting invitees with the primary key could not be found
	 */
	@Override
	public AppraisalMeetingInvitees[] findByAppraisalMeetingId_PrevAndNext(
			long appraisalMeetingInviteeId, long appraisalMeetingId,
			OrderByComparator<AppraisalMeetingInvitees> orderByComparator)
		throws NoSuchAppraisalMeetingInviteesException {

		AppraisalMeetingInvitees appraisalMeetingInvitees = findByPrimaryKey(
			appraisalMeetingInviteeId);

		Session session = null;

		try {
			session = openSession();

			AppraisalMeetingInvitees[] array =
				new AppraisalMeetingInviteesImpl[3];

			array[0] = getByAppraisalMeetingId_PrevAndNext(
				session, appraisalMeetingInvitees, appraisalMeetingId,
				orderByComparator, true);

			array[1] = appraisalMeetingInvitees;

			array[2] = getByAppraisalMeetingId_PrevAndNext(
				session, appraisalMeetingInvitees, appraisalMeetingId,
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

	protected AppraisalMeetingInvitees getByAppraisalMeetingId_PrevAndNext(
		Session session, AppraisalMeetingInvitees appraisalMeetingInvitees,
		long appraisalMeetingId,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator,
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

		sb.append(_SQL_SELECT_APPRAISALMEETINGINVITEES_WHERE);

		sb.append(_FINDER_COLUMN_APPRAISALMEETINGID_APPRAISALMEETINGID_2);

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
			sb.append(AppraisalMeetingInviteesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(appraisalMeetingId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						appraisalMeetingInvitees)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppraisalMeetingInvitees> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appraisal meeting inviteeses where appraisalMeetingId = &#63; from the database.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 */
	@Override
	public void removeByAppraisalMeetingId(long appraisalMeetingId) {
		for (AppraisalMeetingInvitees appraisalMeetingInvitees :
				findByAppraisalMeetingId(
					appraisalMeetingId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(appraisalMeetingInvitees);
		}
	}

	/**
	 * Returns the number of appraisal meeting inviteeses where appraisalMeetingId = &#63;.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @return the number of matching appraisal meeting inviteeses
	 */
	@Override
	public int countByAppraisalMeetingId(long appraisalMeetingId) {
		FinderPath finderPath = _finderPathCountByAppraisalMeetingId;

		Object[] finderArgs = new Object[] {appraisalMeetingId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPRAISALMEETINGINVITEES_WHERE);

			sb.append(_FINDER_COLUMN_APPRAISALMEETINGID_APPRAISALMEETINGID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(appraisalMeetingId);

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
		_FINDER_COLUMN_APPRAISALMEETINGID_APPRAISALMEETINGID_2 =
			"appraisalMeetingInvitees.appraisalMeetingId = ?";

	public AppraisalMeetingInviteesPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AppraisalMeetingInvitees.class);

		setModelImplClass(AppraisalMeetingInviteesImpl.class);
		setModelPKClass(long.class);

		setTable(AppraisalMeetingInviteesTable.INSTANCE);
	}

	/**
	 * Caches the appraisal meeting invitees in the entity cache if it is enabled.
	 *
	 * @param appraisalMeetingInvitees the appraisal meeting invitees
	 */
	@Override
	public void cacheResult(AppraisalMeetingInvitees appraisalMeetingInvitees) {
		entityCache.putResult(
			AppraisalMeetingInviteesImpl.class,
			appraisalMeetingInvitees.getPrimaryKey(), appraisalMeetingInvitees);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				appraisalMeetingInvitees.getUuid(),
				appraisalMeetingInvitees.getGroupId()
			},
			appraisalMeetingInvitees);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the appraisal meeting inviteeses in the entity cache if it is enabled.
	 *
	 * @param appraisalMeetingInviteeses the appraisal meeting inviteeses
	 */
	@Override
	public void cacheResult(
		List<AppraisalMeetingInvitees> appraisalMeetingInviteeses) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (appraisalMeetingInviteeses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AppraisalMeetingInvitees appraisalMeetingInvitees :
				appraisalMeetingInviteeses) {

			if (entityCache.getResult(
					AppraisalMeetingInviteesImpl.class,
					appraisalMeetingInvitees.getPrimaryKey()) == null) {

				cacheResult(appraisalMeetingInvitees);
			}
		}
	}

	/**
	 * Clears the cache for all appraisal meeting inviteeses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AppraisalMeetingInviteesImpl.class);

		finderCache.clearCache(AppraisalMeetingInviteesImpl.class);
	}

	/**
	 * Clears the cache for the appraisal meeting invitees.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AppraisalMeetingInvitees appraisalMeetingInvitees) {
		entityCache.removeResult(
			AppraisalMeetingInviteesImpl.class, appraisalMeetingInvitees);
	}

	@Override
	public void clearCache(
		List<AppraisalMeetingInvitees> appraisalMeetingInviteeses) {

		for (AppraisalMeetingInvitees appraisalMeetingInvitees :
				appraisalMeetingInviteeses) {

			entityCache.removeResult(
				AppraisalMeetingInviteesImpl.class, appraisalMeetingInvitees);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AppraisalMeetingInviteesImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				AppraisalMeetingInviteesImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AppraisalMeetingInviteesModelImpl appraisalMeetingInviteesModelImpl) {

		Object[] args = new Object[] {
			appraisalMeetingInviteesModelImpl.getUuid(),
			appraisalMeetingInviteesModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, appraisalMeetingInviteesModelImpl);
	}

	/**
	 * Creates a new appraisal meeting invitees with the primary key. Does not add the appraisal meeting invitees to the database.
	 *
	 * @param appraisalMeetingInviteeId the primary key for the new appraisal meeting invitees
	 * @return the new appraisal meeting invitees
	 */
	@Override
	public AppraisalMeetingInvitees create(long appraisalMeetingInviteeId) {
		AppraisalMeetingInvitees appraisalMeetingInvitees =
			new AppraisalMeetingInviteesImpl();

		appraisalMeetingInvitees.setNew(true);
		appraisalMeetingInvitees.setPrimaryKey(appraisalMeetingInviteeId);

		String uuid = PortalUUIDUtil.generate();

		appraisalMeetingInvitees.setUuid(uuid);

		appraisalMeetingInvitees.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return appraisalMeetingInvitees;
	}

	/**
	 * Removes the appraisal meeting invitees with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalMeetingInviteeId the primary key of the appraisal meeting invitees
	 * @return the appraisal meeting invitees that was removed
	 * @throws NoSuchAppraisalMeetingInviteesException if a appraisal meeting invitees with the primary key could not be found
	 */
	@Override
	public AppraisalMeetingInvitees remove(long appraisalMeetingInviteeId)
		throws NoSuchAppraisalMeetingInviteesException {

		return remove((Serializable)appraisalMeetingInviteeId);
	}

	/**
	 * Removes the appraisal meeting invitees with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the appraisal meeting invitees
	 * @return the appraisal meeting invitees that was removed
	 * @throws NoSuchAppraisalMeetingInviteesException if a appraisal meeting invitees with the primary key could not be found
	 */
	@Override
	public AppraisalMeetingInvitees remove(Serializable primaryKey)
		throws NoSuchAppraisalMeetingInviteesException {

		Session session = null;

		try {
			session = openSession();

			AppraisalMeetingInvitees appraisalMeetingInvitees =
				(AppraisalMeetingInvitees)session.get(
					AppraisalMeetingInviteesImpl.class, primaryKey);

			if (appraisalMeetingInvitees == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppraisalMeetingInviteesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(appraisalMeetingInvitees);
		}
		catch (NoSuchAppraisalMeetingInviteesException noSuchEntityException) {
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
	protected AppraisalMeetingInvitees removeImpl(
		AppraisalMeetingInvitees appraisalMeetingInvitees) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appraisalMeetingInvitees)) {
				appraisalMeetingInvitees =
					(AppraisalMeetingInvitees)session.get(
						AppraisalMeetingInviteesImpl.class,
						appraisalMeetingInvitees.getPrimaryKeyObj());
			}

			if (appraisalMeetingInvitees != null) {
				session.delete(appraisalMeetingInvitees);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (appraisalMeetingInvitees != null) {
			clearCache(appraisalMeetingInvitees);
		}

		return appraisalMeetingInvitees;
	}

	@Override
	public AppraisalMeetingInvitees updateImpl(
		AppraisalMeetingInvitees appraisalMeetingInvitees) {

		boolean isNew = appraisalMeetingInvitees.isNew();

		if (!(appraisalMeetingInvitees instanceof
				AppraisalMeetingInviteesModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(appraisalMeetingInvitees.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					appraisalMeetingInvitees);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in appraisalMeetingInvitees proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AppraisalMeetingInvitees implementation " +
					appraisalMeetingInvitees.getClass());
		}

		AppraisalMeetingInviteesModelImpl appraisalMeetingInviteesModelImpl =
			(AppraisalMeetingInviteesModelImpl)appraisalMeetingInvitees;

		if (Validator.isNull(appraisalMeetingInvitees.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			appraisalMeetingInvitees.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (appraisalMeetingInvitees.getCreateDate() == null)) {
			if (serviceContext == null) {
				appraisalMeetingInvitees.setCreateDate(date);
			}
			else {
				appraisalMeetingInvitees.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!appraisalMeetingInviteesModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				appraisalMeetingInvitees.setModifiedDate(date);
			}
			else {
				appraisalMeetingInvitees.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(appraisalMeetingInvitees);
			}
			else {
				appraisalMeetingInvitees =
					(AppraisalMeetingInvitees)session.merge(
						appraisalMeetingInvitees);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AppraisalMeetingInviteesImpl.class,
			appraisalMeetingInviteesModelImpl, false, true);

		cacheUniqueFindersCache(appraisalMeetingInviteesModelImpl);

		if (isNew) {
			appraisalMeetingInvitees.setNew(false);
		}

		appraisalMeetingInvitees.resetOriginalValues();

		return appraisalMeetingInvitees;
	}

	/**
	 * Returns the appraisal meeting invitees with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the appraisal meeting invitees
	 * @return the appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a appraisal meeting invitees with the primary key could not be found
	 */
	@Override
	public AppraisalMeetingInvitees findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppraisalMeetingInviteesException {

		AppraisalMeetingInvitees appraisalMeetingInvitees = fetchByPrimaryKey(
			primaryKey);

		if (appraisalMeetingInvitees == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppraisalMeetingInviteesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return appraisalMeetingInvitees;
	}

	/**
	 * Returns the appraisal meeting invitees with the primary key or throws a <code>NoSuchAppraisalMeetingInviteesException</code> if it could not be found.
	 *
	 * @param appraisalMeetingInviteeId the primary key of the appraisal meeting invitees
	 * @return the appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a appraisal meeting invitees with the primary key could not be found
	 */
	@Override
	public AppraisalMeetingInvitees findByPrimaryKey(
			long appraisalMeetingInviteeId)
		throws NoSuchAppraisalMeetingInviteesException {

		return findByPrimaryKey((Serializable)appraisalMeetingInviteeId);
	}

	/**
	 * Returns the appraisal meeting invitees with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalMeetingInviteeId the primary key of the appraisal meeting invitees
	 * @return the appraisal meeting invitees, or <code>null</code> if a appraisal meeting invitees with the primary key could not be found
	 */
	@Override
	public AppraisalMeetingInvitees fetchByPrimaryKey(
		long appraisalMeetingInviteeId) {

		return fetchByPrimaryKey((Serializable)appraisalMeetingInviteeId);
	}

	/**
	 * Returns all the appraisal meeting inviteeses.
	 *
	 * @return the appraisal meeting inviteeses
	 */
	@Override
	public List<AppraisalMeetingInvitees> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal meeting inviteeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @return the range of appraisal meeting inviteeses
	 */
	@Override
	public List<AppraisalMeetingInvitees> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal meeting inviteeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appraisal meeting inviteeses
	 */
	@Override
	public List<AppraisalMeetingInvitees> findAll(
		int start, int end,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal meeting inviteeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of appraisal meeting inviteeses
	 */
	@Override
	public List<AppraisalMeetingInvitees> findAll(
		int start, int end,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator,
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

		List<AppraisalMeetingInvitees> list = null;

		if (useFinderCache) {
			list = (List<AppraisalMeetingInvitees>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_APPRAISALMEETINGINVITEES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_APPRAISALMEETINGINVITEES;

				sql = sql.concat(
					AppraisalMeetingInviteesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AppraisalMeetingInvitees>)QueryUtil.list(
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
	 * Removes all the appraisal meeting inviteeses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AppraisalMeetingInvitees appraisalMeetingInvitees : findAll()) {
			remove(appraisalMeetingInvitees);
		}
	}

	/**
	 * Returns the number of appraisal meeting inviteeses.
	 *
	 * @return the number of appraisal meeting inviteeses
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
					_SQL_COUNT_APPRAISALMEETINGINVITEES);

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
		return "appraisalMeetingInviteeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_APPRAISALMEETINGINVITEES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AppraisalMeetingInviteesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the appraisal meeting invitees persistence.
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

		_finderPathWithPaginationFindByAppraisalMeetingId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAppraisalMeetingId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"appraisalMeetingId"}, true);

		_finderPathWithoutPaginationFindByAppraisalMeetingId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAppraisalMeetingId", new String[] {Long.class.getName()},
			new String[] {"appraisalMeetingId"}, true);

		_finderPathCountByAppraisalMeetingId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAppraisalMeetingId", new String[] {Long.class.getName()},
			new String[] {"appraisalMeetingId"}, false);

		AppraisalMeetingInviteesUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AppraisalMeetingInviteesUtil.setPersistence(null);

		entityCache.removeCache(AppraisalMeetingInviteesImpl.class.getName());
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

	private static final String _SQL_SELECT_APPRAISALMEETINGINVITEES =
		"SELECT appraisalMeetingInvitees FROM AppraisalMeetingInvitees appraisalMeetingInvitees";

	private static final String _SQL_SELECT_APPRAISALMEETINGINVITEES_WHERE =
		"SELECT appraisalMeetingInvitees FROM AppraisalMeetingInvitees appraisalMeetingInvitees WHERE ";

	private static final String _SQL_COUNT_APPRAISALMEETINGINVITEES =
		"SELECT COUNT(appraisalMeetingInvitees) FROM AppraisalMeetingInvitees appraisalMeetingInvitees";

	private static final String _SQL_COUNT_APPRAISALMEETINGINVITEES_WHERE =
		"SELECT COUNT(appraisalMeetingInvitees) FROM AppraisalMeetingInvitees appraisalMeetingInvitees WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"appraisalMeetingInvitees.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AppraisalMeetingInvitees exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AppraisalMeetingInvitees exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AppraisalMeetingInviteesPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}