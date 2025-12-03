/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchAppraisalMeetingException;
import com.ax.hrms.model.AppraisalMeeting;
import com.ax.hrms.model.AppraisalMeetingTable;
import com.ax.hrms.model.impl.AppraisalMeetingImpl;
import com.ax.hrms.model.impl.AppraisalMeetingModelImpl;
import com.ax.hrms.service.persistence.AppraisalMeetingPersistence;
import com.ax.hrms.service.persistence.AppraisalMeetingUtil;
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
 * The persistence implementation for the appraisal meeting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AppraisalMeetingPersistence.class)
public class AppraisalMeetingPersistenceImpl
	extends BasePersistenceImpl<AppraisalMeeting>
	implements AppraisalMeetingPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AppraisalMeetingUtil</code> to access the appraisal meeting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AppraisalMeetingImpl.class.getName();

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
	 * Returns all the appraisal meetings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching appraisal meetings
	 */
	@Override
	public List<AppraisalMeeting> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal meetings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal meetings
	 * @param end the upper bound of the range of appraisal meetings (not inclusive)
	 * @return the range of matching appraisal meetings
	 */
	@Override
	public List<AppraisalMeeting> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal meetings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal meetings
	 * @param end the upper bound of the range of appraisal meetings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal meetings
	 */
	@Override
	public List<AppraisalMeeting> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppraisalMeeting> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal meetings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal meetings
	 * @param end the upper bound of the range of appraisal meetings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal meetings
	 */
	@Override
	public List<AppraisalMeeting> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppraisalMeeting> orderByComparator,
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

		List<AppraisalMeeting> list = null;

		if (useFinderCache) {
			list = (List<AppraisalMeeting>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppraisalMeeting appraisalMeeting : list) {
					if (!uuid.equals(appraisalMeeting.getUuid())) {
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

			sb.append(_SQL_SELECT_APPRAISALMEETING_WHERE);

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
				sb.append(AppraisalMeetingModelImpl.ORDER_BY_JPQL);
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

				list = (List<AppraisalMeeting>)QueryUtil.list(
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
	 * Returns the first appraisal meeting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a matching appraisal meeting could not be found
	 */
	@Override
	public AppraisalMeeting findByUuid_First(
			String uuid, OrderByComparator<AppraisalMeeting> orderByComparator)
		throws NoSuchAppraisalMeetingException {

		AppraisalMeeting appraisalMeeting = fetchByUuid_First(
			uuid, orderByComparator);

		if (appraisalMeeting != null) {
			return appraisalMeeting;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAppraisalMeetingException(sb.toString());
	}

	/**
	 * Returns the first appraisal meeting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	@Override
	public AppraisalMeeting fetchByUuid_First(
		String uuid, OrderByComparator<AppraisalMeeting> orderByComparator) {

		List<AppraisalMeeting> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appraisal meeting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a matching appraisal meeting could not be found
	 */
	@Override
	public AppraisalMeeting findByUuid_Last(
			String uuid, OrderByComparator<AppraisalMeeting> orderByComparator)
		throws NoSuchAppraisalMeetingException {

		AppraisalMeeting appraisalMeeting = fetchByUuid_Last(
			uuid, orderByComparator);

		if (appraisalMeeting != null) {
			return appraisalMeeting;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAppraisalMeetingException(sb.toString());
	}

	/**
	 * Returns the last appraisal meeting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	@Override
	public AppraisalMeeting fetchByUuid_Last(
		String uuid, OrderByComparator<AppraisalMeeting> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AppraisalMeeting> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appraisal meetings before and after the current appraisal meeting in the ordered set where uuid = &#63;.
	 *
	 * @param appraisalMeetingId the primary key of the current appraisal meeting
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a appraisal meeting with the primary key could not be found
	 */
	@Override
	public AppraisalMeeting[] findByUuid_PrevAndNext(
			long appraisalMeetingId, String uuid,
			OrderByComparator<AppraisalMeeting> orderByComparator)
		throws NoSuchAppraisalMeetingException {

		uuid = Objects.toString(uuid, "");

		AppraisalMeeting appraisalMeeting = findByPrimaryKey(
			appraisalMeetingId);

		Session session = null;

		try {
			session = openSession();

			AppraisalMeeting[] array = new AppraisalMeetingImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, appraisalMeeting, uuid, orderByComparator, true);

			array[1] = appraisalMeeting;

			array[2] = getByUuid_PrevAndNext(
				session, appraisalMeeting, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AppraisalMeeting getByUuid_PrevAndNext(
		Session session, AppraisalMeeting appraisalMeeting, String uuid,
		OrderByComparator<AppraisalMeeting> orderByComparator,
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

		sb.append(_SQL_SELECT_APPRAISALMEETING_WHERE);

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
			sb.append(AppraisalMeetingModelImpl.ORDER_BY_JPQL);
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
						appraisalMeeting)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppraisalMeeting> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appraisal meetings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AppraisalMeeting appraisalMeeting :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(appraisalMeeting);
		}
	}

	/**
	 * Returns the number of appraisal meetings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching appraisal meetings
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPRAISALMEETING_WHERE);

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
		"appraisalMeeting.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(appraisalMeeting.uuid IS NULL OR appraisalMeeting.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the appraisal meeting where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAppraisalMeetingException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a matching appraisal meeting could not be found
	 */
	@Override
	public AppraisalMeeting findByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalMeetingException {

		AppraisalMeeting appraisalMeeting = fetchByUUID_G(uuid, groupId);

		if (appraisalMeeting == null) {
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

			throw new NoSuchAppraisalMeetingException(sb.toString());
		}

		return appraisalMeeting;
	}

	/**
	 * Returns the appraisal meeting where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	@Override
	public AppraisalMeeting fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the appraisal meeting where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	@Override
	public AppraisalMeeting fetchByUUID_G(
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

		if (result instanceof AppraisalMeeting) {
			AppraisalMeeting appraisalMeeting = (AppraisalMeeting)result;

			if (!Objects.equals(uuid, appraisalMeeting.getUuid()) ||
				(groupId != appraisalMeeting.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_APPRAISALMEETING_WHERE);

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

				List<AppraisalMeeting> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					AppraisalMeeting appraisalMeeting = list.get(0);

					result = appraisalMeeting;

					cacheResult(appraisalMeeting);
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
			return (AppraisalMeeting)result;
		}
	}

	/**
	 * Removes the appraisal meeting where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the appraisal meeting that was removed
	 */
	@Override
	public AppraisalMeeting removeByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalMeetingException {

		AppraisalMeeting appraisalMeeting = findByUUID_G(uuid, groupId);

		return remove(appraisalMeeting);
	}

	/**
	 * Returns the number of appraisal meetings where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching appraisal meetings
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_APPRAISALMEETING_WHERE);

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
		"appraisalMeeting.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(appraisalMeeting.uuid IS NULL OR appraisalMeeting.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"appraisalMeeting.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the appraisal meetings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching appraisal meetings
	 */
	@Override
	public List<AppraisalMeeting> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal meetings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal meetings
	 * @param end the upper bound of the range of appraisal meetings (not inclusive)
	 * @return the range of matching appraisal meetings
	 */
	@Override
	public List<AppraisalMeeting> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal meetings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal meetings
	 * @param end the upper bound of the range of appraisal meetings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal meetings
	 */
	@Override
	public List<AppraisalMeeting> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalMeeting> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal meetings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal meetings
	 * @param end the upper bound of the range of appraisal meetings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal meetings
	 */
	@Override
	public List<AppraisalMeeting> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalMeeting> orderByComparator,
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

		List<AppraisalMeeting> list = null;

		if (useFinderCache) {
			list = (List<AppraisalMeeting>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppraisalMeeting appraisalMeeting : list) {
					if (!uuid.equals(appraisalMeeting.getUuid()) ||
						(companyId != appraisalMeeting.getCompanyId())) {

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

			sb.append(_SQL_SELECT_APPRAISALMEETING_WHERE);

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
				sb.append(AppraisalMeetingModelImpl.ORDER_BY_JPQL);
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

				list = (List<AppraisalMeeting>)QueryUtil.list(
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
	 * Returns the first appraisal meeting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a matching appraisal meeting could not be found
	 */
	@Override
	public AppraisalMeeting findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AppraisalMeeting> orderByComparator)
		throws NoSuchAppraisalMeetingException {

		AppraisalMeeting appraisalMeeting = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (appraisalMeeting != null) {
			return appraisalMeeting;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAppraisalMeetingException(sb.toString());
	}

	/**
	 * Returns the first appraisal meeting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	@Override
	public AppraisalMeeting fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AppraisalMeeting> orderByComparator) {

		List<AppraisalMeeting> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appraisal meeting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a matching appraisal meeting could not be found
	 */
	@Override
	public AppraisalMeeting findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AppraisalMeeting> orderByComparator)
		throws NoSuchAppraisalMeetingException {

		AppraisalMeeting appraisalMeeting = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (appraisalMeeting != null) {
			return appraisalMeeting;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAppraisalMeetingException(sb.toString());
	}

	/**
	 * Returns the last appraisal meeting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	@Override
	public AppraisalMeeting fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AppraisalMeeting> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AppraisalMeeting> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appraisal meetings before and after the current appraisal meeting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param appraisalMeetingId the primary key of the current appraisal meeting
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a appraisal meeting with the primary key could not be found
	 */
	@Override
	public AppraisalMeeting[] findByUuid_C_PrevAndNext(
			long appraisalMeetingId, String uuid, long companyId,
			OrderByComparator<AppraisalMeeting> orderByComparator)
		throws NoSuchAppraisalMeetingException {

		uuid = Objects.toString(uuid, "");

		AppraisalMeeting appraisalMeeting = findByPrimaryKey(
			appraisalMeetingId);

		Session session = null;

		try {
			session = openSession();

			AppraisalMeeting[] array = new AppraisalMeetingImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, appraisalMeeting, uuid, companyId, orderByComparator,
				true);

			array[1] = appraisalMeeting;

			array[2] = getByUuid_C_PrevAndNext(
				session, appraisalMeeting, uuid, companyId, orderByComparator,
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

	protected AppraisalMeeting getByUuid_C_PrevAndNext(
		Session session, AppraisalMeeting appraisalMeeting, String uuid,
		long companyId, OrderByComparator<AppraisalMeeting> orderByComparator,
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

		sb.append(_SQL_SELECT_APPRAISALMEETING_WHERE);

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
			sb.append(AppraisalMeetingModelImpl.ORDER_BY_JPQL);
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
						appraisalMeeting)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppraisalMeeting> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appraisal meetings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AppraisalMeeting appraisalMeeting :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(appraisalMeeting);
		}
	}

	/**
	 * Returns the number of appraisal meetings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching appraisal meetings
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_APPRAISALMEETING_WHERE);

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
		"appraisalMeeting.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(appraisalMeeting.uuid IS NULL OR appraisalMeeting.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"appraisalMeeting.companyId = ?";

	private FinderPath _finderPathFetchByAppraisalProcessId;
	private FinderPath _finderPathCountByAppraisalProcessId;

	/**
	 * Returns the appraisal meeting where appraisalProcessId = &#63; or throws a <code>NoSuchAppraisalMeetingException</code> if it could not be found.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the matching appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a matching appraisal meeting could not be found
	 */
	@Override
	public AppraisalMeeting findByAppraisalProcessId(long appraisalProcessId)
		throws NoSuchAppraisalMeetingException {

		AppraisalMeeting appraisalMeeting = fetchByAppraisalProcessId(
			appraisalProcessId);

		if (appraisalMeeting == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("appraisalProcessId=");
			sb.append(appraisalProcessId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAppraisalMeetingException(sb.toString());
		}

		return appraisalMeeting;
	}

	/**
	 * Returns the appraisal meeting where appraisalProcessId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	@Override
	public AppraisalMeeting fetchByAppraisalProcessId(long appraisalProcessId) {
		return fetchByAppraisalProcessId(appraisalProcessId, true);
	}

	/**
	 * Returns the appraisal meeting where appraisalProcessId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	@Override
	public AppraisalMeeting fetchByAppraisalProcessId(
		long appraisalProcessId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {appraisalProcessId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByAppraisalProcessId, finderArgs, this);
		}

		if (result instanceof AppraisalMeeting) {
			AppraisalMeeting appraisalMeeting = (AppraisalMeeting)result;

			if (appraisalProcessId !=
					appraisalMeeting.getAppraisalProcessId()) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_APPRAISALMEETING_WHERE);

			sb.append(_FINDER_COLUMN_APPRAISALPROCESSID_APPRAISALPROCESSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(appraisalProcessId);

				List<AppraisalMeeting> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByAppraisalProcessId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {appraisalProcessId};
							}

							_log.warn(
								"AppraisalMeetingPersistenceImpl.fetchByAppraisalProcessId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AppraisalMeeting appraisalMeeting = list.get(0);

					result = appraisalMeeting;

					cacheResult(appraisalMeeting);
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
			return (AppraisalMeeting)result;
		}
	}

	/**
	 * Removes the appraisal meeting where appraisalProcessId = &#63; from the database.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the appraisal meeting that was removed
	 */
	@Override
	public AppraisalMeeting removeByAppraisalProcessId(long appraisalProcessId)
		throws NoSuchAppraisalMeetingException {

		AppraisalMeeting appraisalMeeting = findByAppraisalProcessId(
			appraisalProcessId);

		return remove(appraisalMeeting);
	}

	/**
	 * Returns the number of appraisal meetings where appraisalProcessId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the number of matching appraisal meetings
	 */
	@Override
	public int countByAppraisalProcessId(long appraisalProcessId) {
		FinderPath finderPath = _finderPathCountByAppraisalProcessId;

		Object[] finderArgs = new Object[] {appraisalProcessId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPRAISALMEETING_WHERE);

			sb.append(_FINDER_COLUMN_APPRAISALPROCESSID_APPRAISALPROCESSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(appraisalProcessId);

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
		_FINDER_COLUMN_APPRAISALPROCESSID_APPRAISALPROCESSID_2 =
			"appraisalMeeting.appraisalProcessId = ?";

	public AppraisalMeetingPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AppraisalMeeting.class);

		setModelImplClass(AppraisalMeetingImpl.class);
		setModelPKClass(long.class);

		setTable(AppraisalMeetingTable.INSTANCE);
	}

	/**
	 * Caches the appraisal meeting in the entity cache if it is enabled.
	 *
	 * @param appraisalMeeting the appraisal meeting
	 */
	@Override
	public void cacheResult(AppraisalMeeting appraisalMeeting) {
		entityCache.putResult(
			AppraisalMeetingImpl.class, appraisalMeeting.getPrimaryKey(),
			appraisalMeeting);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				appraisalMeeting.getUuid(), appraisalMeeting.getGroupId()
			},
			appraisalMeeting);

		finderCache.putResult(
			_finderPathFetchByAppraisalProcessId,
			new Object[] {appraisalMeeting.getAppraisalProcessId()},
			appraisalMeeting);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the appraisal meetings in the entity cache if it is enabled.
	 *
	 * @param appraisalMeetings the appraisal meetings
	 */
	@Override
	public void cacheResult(List<AppraisalMeeting> appraisalMeetings) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (appraisalMeetings.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AppraisalMeeting appraisalMeeting : appraisalMeetings) {
			if (entityCache.getResult(
					AppraisalMeetingImpl.class,
					appraisalMeeting.getPrimaryKey()) == null) {

				cacheResult(appraisalMeeting);
			}
		}
	}

	/**
	 * Clears the cache for all appraisal meetings.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AppraisalMeetingImpl.class);

		finderCache.clearCache(AppraisalMeetingImpl.class);
	}

	/**
	 * Clears the cache for the appraisal meeting.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AppraisalMeeting appraisalMeeting) {
		entityCache.removeResult(AppraisalMeetingImpl.class, appraisalMeeting);
	}

	@Override
	public void clearCache(List<AppraisalMeeting> appraisalMeetings) {
		for (AppraisalMeeting appraisalMeeting : appraisalMeetings) {
			entityCache.removeResult(
				AppraisalMeetingImpl.class, appraisalMeeting);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AppraisalMeetingImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AppraisalMeetingImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AppraisalMeetingModelImpl appraisalMeetingModelImpl) {

		Object[] args = new Object[] {
			appraisalMeetingModelImpl.getUuid(),
			appraisalMeetingModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, appraisalMeetingModelImpl);

		args = new Object[] {appraisalMeetingModelImpl.getAppraisalProcessId()};

		finderCache.putResult(
			_finderPathCountByAppraisalProcessId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByAppraisalProcessId, args,
			appraisalMeetingModelImpl);
	}

	/**
	 * Creates a new appraisal meeting with the primary key. Does not add the appraisal meeting to the database.
	 *
	 * @param appraisalMeetingId the primary key for the new appraisal meeting
	 * @return the new appraisal meeting
	 */
	@Override
	public AppraisalMeeting create(long appraisalMeetingId) {
		AppraisalMeeting appraisalMeeting = new AppraisalMeetingImpl();

		appraisalMeeting.setNew(true);
		appraisalMeeting.setPrimaryKey(appraisalMeetingId);

		String uuid = PortalUUIDUtil.generate();

		appraisalMeeting.setUuid(uuid);

		appraisalMeeting.setCompanyId(CompanyThreadLocal.getCompanyId());

		return appraisalMeeting;
	}

	/**
	 * Removes the appraisal meeting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalMeetingId the primary key of the appraisal meeting
	 * @return the appraisal meeting that was removed
	 * @throws NoSuchAppraisalMeetingException if a appraisal meeting with the primary key could not be found
	 */
	@Override
	public AppraisalMeeting remove(long appraisalMeetingId)
		throws NoSuchAppraisalMeetingException {

		return remove((Serializable)appraisalMeetingId);
	}

	/**
	 * Removes the appraisal meeting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the appraisal meeting
	 * @return the appraisal meeting that was removed
	 * @throws NoSuchAppraisalMeetingException if a appraisal meeting with the primary key could not be found
	 */
	@Override
	public AppraisalMeeting remove(Serializable primaryKey)
		throws NoSuchAppraisalMeetingException {

		Session session = null;

		try {
			session = openSession();

			AppraisalMeeting appraisalMeeting = (AppraisalMeeting)session.get(
				AppraisalMeetingImpl.class, primaryKey);

			if (appraisalMeeting == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppraisalMeetingException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(appraisalMeeting);
		}
		catch (NoSuchAppraisalMeetingException noSuchEntityException) {
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
	protected AppraisalMeeting removeImpl(AppraisalMeeting appraisalMeeting) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appraisalMeeting)) {
				appraisalMeeting = (AppraisalMeeting)session.get(
					AppraisalMeetingImpl.class,
					appraisalMeeting.getPrimaryKeyObj());
			}

			if (appraisalMeeting != null) {
				session.delete(appraisalMeeting);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (appraisalMeeting != null) {
			clearCache(appraisalMeeting);
		}

		return appraisalMeeting;
	}

	@Override
	public AppraisalMeeting updateImpl(AppraisalMeeting appraisalMeeting) {
		boolean isNew = appraisalMeeting.isNew();

		if (!(appraisalMeeting instanceof AppraisalMeetingModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(appraisalMeeting.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					appraisalMeeting);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in appraisalMeeting proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AppraisalMeeting implementation " +
					appraisalMeeting.getClass());
		}

		AppraisalMeetingModelImpl appraisalMeetingModelImpl =
			(AppraisalMeetingModelImpl)appraisalMeeting;

		if (Validator.isNull(appraisalMeeting.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			appraisalMeeting.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (appraisalMeeting.getCreateDate() == null)) {
			if (serviceContext == null) {
				appraisalMeeting.setCreateDate(date);
			}
			else {
				appraisalMeeting.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!appraisalMeetingModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				appraisalMeeting.setModifiedDate(date);
			}
			else {
				appraisalMeeting.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(appraisalMeeting);
			}
			else {
				appraisalMeeting = (AppraisalMeeting)session.merge(
					appraisalMeeting);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AppraisalMeetingImpl.class, appraisalMeetingModelImpl, false, true);

		cacheUniqueFindersCache(appraisalMeetingModelImpl);

		if (isNew) {
			appraisalMeeting.setNew(false);
		}

		appraisalMeeting.resetOriginalValues();

		return appraisalMeeting;
	}

	/**
	 * Returns the appraisal meeting with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the appraisal meeting
	 * @return the appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a appraisal meeting with the primary key could not be found
	 */
	@Override
	public AppraisalMeeting findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppraisalMeetingException {

		AppraisalMeeting appraisalMeeting = fetchByPrimaryKey(primaryKey);

		if (appraisalMeeting == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppraisalMeetingException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return appraisalMeeting;
	}

	/**
	 * Returns the appraisal meeting with the primary key or throws a <code>NoSuchAppraisalMeetingException</code> if it could not be found.
	 *
	 * @param appraisalMeetingId the primary key of the appraisal meeting
	 * @return the appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a appraisal meeting with the primary key could not be found
	 */
	@Override
	public AppraisalMeeting findByPrimaryKey(long appraisalMeetingId)
		throws NoSuchAppraisalMeetingException {

		return findByPrimaryKey((Serializable)appraisalMeetingId);
	}

	/**
	 * Returns the appraisal meeting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalMeetingId the primary key of the appraisal meeting
	 * @return the appraisal meeting, or <code>null</code> if a appraisal meeting with the primary key could not be found
	 */
	@Override
	public AppraisalMeeting fetchByPrimaryKey(long appraisalMeetingId) {
		return fetchByPrimaryKey((Serializable)appraisalMeetingId);
	}

	/**
	 * Returns all the appraisal meetings.
	 *
	 * @return the appraisal meetings
	 */
	@Override
	public List<AppraisalMeeting> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal meetings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal meetings
	 * @param end the upper bound of the range of appraisal meetings (not inclusive)
	 * @return the range of appraisal meetings
	 */
	@Override
	public List<AppraisalMeeting> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal meetings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal meetings
	 * @param end the upper bound of the range of appraisal meetings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appraisal meetings
	 */
	@Override
	public List<AppraisalMeeting> findAll(
		int start, int end,
		OrderByComparator<AppraisalMeeting> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal meetings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal meetings
	 * @param end the upper bound of the range of appraisal meetings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of appraisal meetings
	 */
	@Override
	public List<AppraisalMeeting> findAll(
		int start, int end,
		OrderByComparator<AppraisalMeeting> orderByComparator,
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

		List<AppraisalMeeting> list = null;

		if (useFinderCache) {
			list = (List<AppraisalMeeting>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_APPRAISALMEETING);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_APPRAISALMEETING;

				sql = sql.concat(AppraisalMeetingModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AppraisalMeeting>)QueryUtil.list(
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
	 * Removes all the appraisal meetings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AppraisalMeeting appraisalMeeting : findAll()) {
			remove(appraisalMeeting);
		}
	}

	/**
	 * Returns the number of appraisal meetings.
	 *
	 * @return the number of appraisal meetings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_APPRAISALMEETING);

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
		return "appraisalMeetingId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_APPRAISALMEETING;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AppraisalMeetingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the appraisal meeting persistence.
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

		_finderPathFetchByAppraisalProcessId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByAppraisalProcessId",
			new String[] {Long.class.getName()},
			new String[] {"appraisalProcessId"}, true);

		_finderPathCountByAppraisalProcessId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAppraisalProcessId", new String[] {Long.class.getName()},
			new String[] {"appraisalProcessId"}, false);

		AppraisalMeetingUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AppraisalMeetingUtil.setPersistence(null);

		entityCache.removeCache(AppraisalMeetingImpl.class.getName());
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

	private static final String _SQL_SELECT_APPRAISALMEETING =
		"SELECT appraisalMeeting FROM AppraisalMeeting appraisalMeeting";

	private static final String _SQL_SELECT_APPRAISALMEETING_WHERE =
		"SELECT appraisalMeeting FROM AppraisalMeeting appraisalMeeting WHERE ";

	private static final String _SQL_COUNT_APPRAISALMEETING =
		"SELECT COUNT(appraisalMeeting) FROM AppraisalMeeting appraisalMeeting";

	private static final String _SQL_COUNT_APPRAISALMEETING_WHERE =
		"SELECT COUNT(appraisalMeeting) FROM AppraisalMeeting appraisalMeeting WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "appraisalMeeting.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AppraisalMeeting exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AppraisalMeeting exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AppraisalMeetingPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}