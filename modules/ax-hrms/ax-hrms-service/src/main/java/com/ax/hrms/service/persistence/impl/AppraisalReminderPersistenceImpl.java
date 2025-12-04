/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchAppraisalReminderException;
import com.ax.hrms.model.AppraisalReminder;
import com.ax.hrms.model.AppraisalReminderTable;
import com.ax.hrms.model.impl.AppraisalReminderImpl;
import com.ax.hrms.model.impl.AppraisalReminderModelImpl;
import com.ax.hrms.service.persistence.AppraisalReminderPersistence;
import com.ax.hrms.service.persistence.AppraisalReminderUtil;
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
 * The persistence implementation for the appraisal reminder service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AppraisalReminderPersistence.class)
public class AppraisalReminderPersistenceImpl
	extends BasePersistenceImpl<AppraisalReminder>
	implements AppraisalReminderPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AppraisalReminderUtil</code> to access the appraisal reminder persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AppraisalReminderImpl.class.getName();

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
	 * Returns all the appraisal reminders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching appraisal reminders
	 */
	@Override
	public List<AppraisalReminder> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal reminders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalReminderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal reminders
	 * @param end the upper bound of the range of appraisal reminders (not inclusive)
	 * @return the range of matching appraisal reminders
	 */
	@Override
	public List<AppraisalReminder> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal reminders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalReminderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal reminders
	 * @param end the upper bound of the range of appraisal reminders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal reminders
	 */
	@Override
	public List<AppraisalReminder> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppraisalReminder> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal reminders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalReminderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal reminders
	 * @param end the upper bound of the range of appraisal reminders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal reminders
	 */
	@Override
	public List<AppraisalReminder> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppraisalReminder> orderByComparator,
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

		List<AppraisalReminder> list = null;

		if (useFinderCache) {
			list = (List<AppraisalReminder>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppraisalReminder appraisalReminder : list) {
					if (!uuid.equals(appraisalReminder.getUuid())) {
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

			sb.append(_SQL_SELECT_APPRAISALREMINDER_WHERE);

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
				sb.append(AppraisalReminderModelImpl.ORDER_BY_JPQL);
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

				list = (List<AppraisalReminder>)QueryUtil.list(
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
	 * Returns the first appraisal reminder in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a matching appraisal reminder could not be found
	 */
	@Override
	public AppraisalReminder findByUuid_First(
			String uuid, OrderByComparator<AppraisalReminder> orderByComparator)
		throws NoSuchAppraisalReminderException {

		AppraisalReminder appraisalReminder = fetchByUuid_First(
			uuid, orderByComparator);

		if (appraisalReminder != null) {
			return appraisalReminder;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAppraisalReminderException(sb.toString());
	}

	/**
	 * Returns the first appraisal reminder in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	@Override
	public AppraisalReminder fetchByUuid_First(
		String uuid, OrderByComparator<AppraisalReminder> orderByComparator) {

		List<AppraisalReminder> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appraisal reminder in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a matching appraisal reminder could not be found
	 */
	@Override
	public AppraisalReminder findByUuid_Last(
			String uuid, OrderByComparator<AppraisalReminder> orderByComparator)
		throws NoSuchAppraisalReminderException {

		AppraisalReminder appraisalReminder = fetchByUuid_Last(
			uuid, orderByComparator);

		if (appraisalReminder != null) {
			return appraisalReminder;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAppraisalReminderException(sb.toString());
	}

	/**
	 * Returns the last appraisal reminder in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	@Override
	public AppraisalReminder fetchByUuid_Last(
		String uuid, OrderByComparator<AppraisalReminder> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AppraisalReminder> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appraisal reminders before and after the current appraisal reminder in the ordered set where uuid = &#63;.
	 *
	 * @param appraisalRemainderId the primary key of the current appraisal reminder
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a appraisal reminder with the primary key could not be found
	 */
	@Override
	public AppraisalReminder[] findByUuid_PrevAndNext(
			long appraisalRemainderId, String uuid,
			OrderByComparator<AppraisalReminder> orderByComparator)
		throws NoSuchAppraisalReminderException {

		uuid = Objects.toString(uuid, "");

		AppraisalReminder appraisalReminder = findByPrimaryKey(
			appraisalRemainderId);

		Session session = null;

		try {
			session = openSession();

			AppraisalReminder[] array = new AppraisalReminderImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, appraisalReminder, uuid, orderByComparator, true);

			array[1] = appraisalReminder;

			array[2] = getByUuid_PrevAndNext(
				session, appraisalReminder, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AppraisalReminder getByUuid_PrevAndNext(
		Session session, AppraisalReminder appraisalReminder, String uuid,
		OrderByComparator<AppraisalReminder> orderByComparator,
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

		sb.append(_SQL_SELECT_APPRAISALREMINDER_WHERE);

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
			sb.append(AppraisalReminderModelImpl.ORDER_BY_JPQL);
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
						appraisalReminder)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppraisalReminder> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appraisal reminders where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AppraisalReminder appraisalReminder :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(appraisalReminder);
		}
	}

	/**
	 * Returns the number of appraisal reminders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching appraisal reminders
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPRAISALREMINDER_WHERE);

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
		"appraisalReminder.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(appraisalReminder.uuid IS NULL OR appraisalReminder.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the appraisal reminder where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAppraisalReminderException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a matching appraisal reminder could not be found
	 */
	@Override
	public AppraisalReminder findByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalReminderException {

		AppraisalReminder appraisalReminder = fetchByUUID_G(uuid, groupId);

		if (appraisalReminder == null) {
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

			throw new NoSuchAppraisalReminderException(sb.toString());
		}

		return appraisalReminder;
	}

	/**
	 * Returns the appraisal reminder where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	@Override
	public AppraisalReminder fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the appraisal reminder where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	@Override
	public AppraisalReminder fetchByUUID_G(
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

		if (result instanceof AppraisalReminder) {
			AppraisalReminder appraisalReminder = (AppraisalReminder)result;

			if (!Objects.equals(uuid, appraisalReminder.getUuid()) ||
				(groupId != appraisalReminder.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_APPRAISALREMINDER_WHERE);

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

				List<AppraisalReminder> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					AppraisalReminder appraisalReminder = list.get(0);

					result = appraisalReminder;

					cacheResult(appraisalReminder);
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
			return (AppraisalReminder)result;
		}
	}

	/**
	 * Removes the appraisal reminder where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the appraisal reminder that was removed
	 */
	@Override
	public AppraisalReminder removeByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalReminderException {

		AppraisalReminder appraisalReminder = findByUUID_G(uuid, groupId);

		return remove(appraisalReminder);
	}

	/**
	 * Returns the number of appraisal reminders where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching appraisal reminders
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		AppraisalReminder appraisalReminder = fetchByUUID_G(uuid, groupId);

		if (appraisalReminder == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"appraisalReminder.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(appraisalReminder.uuid IS NULL OR appraisalReminder.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"appraisalReminder.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the appraisal reminders where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching appraisal reminders
	 */
	@Override
	public List<AppraisalReminder> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal reminders where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalReminderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal reminders
	 * @param end the upper bound of the range of appraisal reminders (not inclusive)
	 * @return the range of matching appraisal reminders
	 */
	@Override
	public List<AppraisalReminder> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal reminders where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalReminderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal reminders
	 * @param end the upper bound of the range of appraisal reminders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal reminders
	 */
	@Override
	public List<AppraisalReminder> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalReminder> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal reminders where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalReminderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal reminders
	 * @param end the upper bound of the range of appraisal reminders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal reminders
	 */
	@Override
	public List<AppraisalReminder> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalReminder> orderByComparator,
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

		List<AppraisalReminder> list = null;

		if (useFinderCache) {
			list = (List<AppraisalReminder>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppraisalReminder appraisalReminder : list) {
					if (!uuid.equals(appraisalReminder.getUuid()) ||
						(companyId != appraisalReminder.getCompanyId())) {

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

			sb.append(_SQL_SELECT_APPRAISALREMINDER_WHERE);

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
				sb.append(AppraisalReminderModelImpl.ORDER_BY_JPQL);
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

				list = (List<AppraisalReminder>)QueryUtil.list(
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
	 * Returns the first appraisal reminder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a matching appraisal reminder could not be found
	 */
	@Override
	public AppraisalReminder findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AppraisalReminder> orderByComparator)
		throws NoSuchAppraisalReminderException {

		AppraisalReminder appraisalReminder = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (appraisalReminder != null) {
			return appraisalReminder;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAppraisalReminderException(sb.toString());
	}

	/**
	 * Returns the first appraisal reminder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	@Override
	public AppraisalReminder fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AppraisalReminder> orderByComparator) {

		List<AppraisalReminder> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appraisal reminder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a matching appraisal reminder could not be found
	 */
	@Override
	public AppraisalReminder findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AppraisalReminder> orderByComparator)
		throws NoSuchAppraisalReminderException {

		AppraisalReminder appraisalReminder = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (appraisalReminder != null) {
			return appraisalReminder;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAppraisalReminderException(sb.toString());
	}

	/**
	 * Returns the last appraisal reminder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	@Override
	public AppraisalReminder fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AppraisalReminder> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AppraisalReminder> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appraisal reminders before and after the current appraisal reminder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param appraisalRemainderId the primary key of the current appraisal reminder
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a appraisal reminder with the primary key could not be found
	 */
	@Override
	public AppraisalReminder[] findByUuid_C_PrevAndNext(
			long appraisalRemainderId, String uuid, long companyId,
			OrderByComparator<AppraisalReminder> orderByComparator)
		throws NoSuchAppraisalReminderException {

		uuid = Objects.toString(uuid, "");

		AppraisalReminder appraisalReminder = findByPrimaryKey(
			appraisalRemainderId);

		Session session = null;

		try {
			session = openSession();

			AppraisalReminder[] array = new AppraisalReminderImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, appraisalReminder, uuid, companyId, orderByComparator,
				true);

			array[1] = appraisalReminder;

			array[2] = getByUuid_C_PrevAndNext(
				session, appraisalReminder, uuid, companyId, orderByComparator,
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

	protected AppraisalReminder getByUuid_C_PrevAndNext(
		Session session, AppraisalReminder appraisalReminder, String uuid,
		long companyId, OrderByComparator<AppraisalReminder> orderByComparator,
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

		sb.append(_SQL_SELECT_APPRAISALREMINDER_WHERE);

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
			sb.append(AppraisalReminderModelImpl.ORDER_BY_JPQL);
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
						appraisalReminder)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppraisalReminder> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appraisal reminders where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AppraisalReminder appraisalReminder :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(appraisalReminder);
		}
	}

	/**
	 * Returns the number of appraisal reminders where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching appraisal reminders
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_APPRAISALREMINDER_WHERE);

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
		"appraisalReminder.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(appraisalReminder.uuid IS NULL OR appraisalReminder.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"appraisalReminder.companyId = ?";

	private FinderPath _finderPathFetchByAppraisalProcessId;

	/**
	 * Returns the appraisal reminder where appraisalProcessId = &#63; or throws a <code>NoSuchAppraisalReminderException</code> if it could not be found.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the matching appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a matching appraisal reminder could not be found
	 */
	@Override
	public AppraisalReminder findByAppraisalProcessId(long appraisalProcessId)
		throws NoSuchAppraisalReminderException {

		AppraisalReminder appraisalReminder = fetchByAppraisalProcessId(
			appraisalProcessId);

		if (appraisalReminder == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("appraisalProcessId=");
			sb.append(appraisalProcessId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAppraisalReminderException(sb.toString());
		}

		return appraisalReminder;
	}

	/**
	 * Returns the appraisal reminder where appraisalProcessId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	@Override
	public AppraisalReminder fetchByAppraisalProcessId(
		long appraisalProcessId) {

		return fetchByAppraisalProcessId(appraisalProcessId, true);
	}

	/**
	 * Returns the appraisal reminder where appraisalProcessId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	@Override
	public AppraisalReminder fetchByAppraisalProcessId(
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

		if (result instanceof AppraisalReminder) {
			AppraisalReminder appraisalReminder = (AppraisalReminder)result;

			if (appraisalProcessId !=
					appraisalReminder.getAppraisalProcessId()) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_APPRAISALREMINDER_WHERE);

			sb.append(_FINDER_COLUMN_APPRAISALPROCESSID_APPRAISALPROCESSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(appraisalProcessId);

				List<AppraisalReminder> list = query.list();

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
								"AppraisalReminderPersistenceImpl.fetchByAppraisalProcessId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AppraisalReminder appraisalReminder = list.get(0);

					result = appraisalReminder;

					cacheResult(appraisalReminder);
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
			return (AppraisalReminder)result;
		}
	}

	/**
	 * Removes the appraisal reminder where appraisalProcessId = &#63; from the database.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the appraisal reminder that was removed
	 */
	@Override
	public AppraisalReminder removeByAppraisalProcessId(long appraisalProcessId)
		throws NoSuchAppraisalReminderException {

		AppraisalReminder appraisalReminder = findByAppraisalProcessId(
			appraisalProcessId);

		return remove(appraisalReminder);
	}

	/**
	 * Returns the number of appraisal reminders where appraisalProcessId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the number of matching appraisal reminders
	 */
	@Override
	public int countByAppraisalProcessId(long appraisalProcessId) {
		AppraisalReminder appraisalReminder = fetchByAppraisalProcessId(
			appraisalProcessId);

		if (appraisalReminder == null) {
			return 0;
		}

		return 1;
	}

	private static final String
		_FINDER_COLUMN_APPRAISALPROCESSID_APPRAISALPROCESSID_2 =
			"appraisalReminder.appraisalProcessId = ?";

	public AppraisalReminderPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AppraisalReminder.class);

		setModelImplClass(AppraisalReminderImpl.class);
		setModelPKClass(long.class);

		setTable(AppraisalReminderTable.INSTANCE);
	}

	/**
	 * Caches the appraisal reminder in the entity cache if it is enabled.
	 *
	 * @param appraisalReminder the appraisal reminder
	 */
	@Override
	public void cacheResult(AppraisalReminder appraisalReminder) {
		entityCache.putResult(
			AppraisalReminderImpl.class, appraisalReminder.getPrimaryKey(),
			appraisalReminder);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				appraisalReminder.getUuid(), appraisalReminder.getGroupId()
			},
			appraisalReminder);

		finderCache.putResult(
			_finderPathFetchByAppraisalProcessId,
			new Object[] {appraisalReminder.getAppraisalProcessId()},
			appraisalReminder);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the appraisal reminders in the entity cache if it is enabled.
	 *
	 * @param appraisalReminders the appraisal reminders
	 */
	@Override
	public void cacheResult(List<AppraisalReminder> appraisalReminders) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (appraisalReminders.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AppraisalReminder appraisalReminder : appraisalReminders) {
			if (entityCache.getResult(
					AppraisalReminderImpl.class,
					appraisalReminder.getPrimaryKey()) == null) {

				cacheResult(appraisalReminder);
			}
		}
	}

	/**
	 * Clears the cache for all appraisal reminders.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AppraisalReminderImpl.class);

		finderCache.clearCache(AppraisalReminderImpl.class);
	}

	/**
	 * Clears the cache for the appraisal reminder.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AppraisalReminder appraisalReminder) {
		entityCache.removeResult(
			AppraisalReminderImpl.class, appraisalReminder);
	}

	@Override
	public void clearCache(List<AppraisalReminder> appraisalReminders) {
		for (AppraisalReminder appraisalReminder : appraisalReminders) {
			entityCache.removeResult(
				AppraisalReminderImpl.class, appraisalReminder);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AppraisalReminderImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AppraisalReminderImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AppraisalReminderModelImpl appraisalReminderModelImpl) {

		Object[] args = new Object[] {
			appraisalReminderModelImpl.getUuid(),
			appraisalReminderModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, appraisalReminderModelImpl);

		args = new Object[] {
			appraisalReminderModelImpl.getAppraisalProcessId()
		};

		finderCache.putResult(
			_finderPathFetchByAppraisalProcessId, args,
			appraisalReminderModelImpl);
	}

	/**
	 * Creates a new appraisal reminder with the primary key. Does not add the appraisal reminder to the database.
	 *
	 * @param appraisalRemainderId the primary key for the new appraisal reminder
	 * @return the new appraisal reminder
	 */
	@Override
	public AppraisalReminder create(long appraisalRemainderId) {
		AppraisalReminder appraisalReminder = new AppraisalReminderImpl();

		appraisalReminder.setNew(true);
		appraisalReminder.setPrimaryKey(appraisalRemainderId);

		String uuid = PortalUUIDUtil.generate();

		appraisalReminder.setUuid(uuid);

		appraisalReminder.setCompanyId(CompanyThreadLocal.getCompanyId());

		return appraisalReminder;
	}

	/**
	 * Removes the appraisal reminder with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalRemainderId the primary key of the appraisal reminder
	 * @return the appraisal reminder that was removed
	 * @throws NoSuchAppraisalReminderException if a appraisal reminder with the primary key could not be found
	 */
	@Override
	public AppraisalReminder remove(long appraisalRemainderId)
		throws NoSuchAppraisalReminderException {

		return remove((Serializable)appraisalRemainderId);
	}

	/**
	 * Removes the appraisal reminder with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the appraisal reminder
	 * @return the appraisal reminder that was removed
	 * @throws NoSuchAppraisalReminderException if a appraisal reminder with the primary key could not be found
	 */
	@Override
	public AppraisalReminder remove(Serializable primaryKey)
		throws NoSuchAppraisalReminderException {

		Session session = null;

		try {
			session = openSession();

			AppraisalReminder appraisalReminder =
				(AppraisalReminder)session.get(
					AppraisalReminderImpl.class, primaryKey);

			if (appraisalReminder == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppraisalReminderException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(appraisalReminder);
		}
		catch (NoSuchAppraisalReminderException noSuchEntityException) {
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
	protected AppraisalReminder removeImpl(
		AppraisalReminder appraisalReminder) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appraisalReminder)) {
				appraisalReminder = (AppraisalReminder)session.get(
					AppraisalReminderImpl.class,
					appraisalReminder.getPrimaryKeyObj());
			}

			if (appraisalReminder != null) {
				session.delete(appraisalReminder);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (appraisalReminder != null) {
			clearCache(appraisalReminder);
		}

		return appraisalReminder;
	}

	@Override
	public AppraisalReminder updateImpl(AppraisalReminder appraisalReminder) {
		boolean isNew = appraisalReminder.isNew();

		if (!(appraisalReminder instanceof AppraisalReminderModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(appraisalReminder.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					appraisalReminder);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in appraisalReminder proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AppraisalReminder implementation " +
					appraisalReminder.getClass());
		}

		AppraisalReminderModelImpl appraisalReminderModelImpl =
			(AppraisalReminderModelImpl)appraisalReminder;

		if (Validator.isNull(appraisalReminder.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			appraisalReminder.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (appraisalReminder.getCreateDate() == null)) {
			if (serviceContext == null) {
				appraisalReminder.setCreateDate(date);
			}
			else {
				appraisalReminder.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!appraisalReminderModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				appraisalReminder.setModifiedDate(date);
			}
			else {
				appraisalReminder.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(appraisalReminder);
			}
			else {
				appraisalReminder = (AppraisalReminder)session.merge(
					appraisalReminder);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AppraisalReminderImpl.class, appraisalReminderModelImpl, false,
			true);

		cacheUniqueFindersCache(appraisalReminderModelImpl);

		if (isNew) {
			appraisalReminder.setNew(false);
		}

		appraisalReminder.resetOriginalValues();

		return appraisalReminder;
	}

	/**
	 * Returns the appraisal reminder with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the appraisal reminder
	 * @return the appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a appraisal reminder with the primary key could not be found
	 */
	@Override
	public AppraisalReminder findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppraisalReminderException {

		AppraisalReminder appraisalReminder = fetchByPrimaryKey(primaryKey);

		if (appraisalReminder == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppraisalReminderException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return appraisalReminder;
	}

	/**
	 * Returns the appraisal reminder with the primary key or throws a <code>NoSuchAppraisalReminderException</code> if it could not be found.
	 *
	 * @param appraisalRemainderId the primary key of the appraisal reminder
	 * @return the appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a appraisal reminder with the primary key could not be found
	 */
	@Override
	public AppraisalReminder findByPrimaryKey(long appraisalRemainderId)
		throws NoSuchAppraisalReminderException {

		return findByPrimaryKey((Serializable)appraisalRemainderId);
	}

	/**
	 * Returns the appraisal reminder with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalRemainderId the primary key of the appraisal reminder
	 * @return the appraisal reminder, or <code>null</code> if a appraisal reminder with the primary key could not be found
	 */
	@Override
	public AppraisalReminder fetchByPrimaryKey(long appraisalRemainderId) {
		return fetchByPrimaryKey((Serializable)appraisalRemainderId);
	}

	/**
	 * Returns all the appraisal reminders.
	 *
	 * @return the appraisal reminders
	 */
	@Override
	public List<AppraisalReminder> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal reminders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalReminderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal reminders
	 * @param end the upper bound of the range of appraisal reminders (not inclusive)
	 * @return the range of appraisal reminders
	 */
	@Override
	public List<AppraisalReminder> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal reminders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalReminderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal reminders
	 * @param end the upper bound of the range of appraisal reminders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appraisal reminders
	 */
	@Override
	public List<AppraisalReminder> findAll(
		int start, int end,
		OrderByComparator<AppraisalReminder> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal reminders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalReminderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal reminders
	 * @param end the upper bound of the range of appraisal reminders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of appraisal reminders
	 */
	@Override
	public List<AppraisalReminder> findAll(
		int start, int end,
		OrderByComparator<AppraisalReminder> orderByComparator,
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

		List<AppraisalReminder> list = null;

		if (useFinderCache) {
			list = (List<AppraisalReminder>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_APPRAISALREMINDER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_APPRAISALREMINDER;

				sql = sql.concat(AppraisalReminderModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AppraisalReminder>)QueryUtil.list(
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
	 * Removes all the appraisal reminders from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AppraisalReminder appraisalReminder : findAll()) {
			remove(appraisalReminder);
		}
	}

	/**
	 * Returns the number of appraisal reminders.
	 *
	 * @return the number of appraisal reminders
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_APPRAISALREMINDER);

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
		return "appraisalRemainderId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_APPRAISALREMINDER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AppraisalReminderModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the appraisal reminder persistence.
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

		_finderPathFetchByAppraisalProcessId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByAppraisalProcessId",
			new String[] {Long.class.getName()},
			new String[] {"appraisalProcessId"}, true);

		AppraisalReminderUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AppraisalReminderUtil.setPersistence(null);

		entityCache.removeCache(AppraisalReminderImpl.class.getName());
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

	private static final String _SQL_SELECT_APPRAISALREMINDER =
		"SELECT appraisalReminder FROM AppraisalReminder appraisalReminder";

	private static final String _SQL_SELECT_APPRAISALREMINDER_WHERE =
		"SELECT appraisalReminder FROM AppraisalReminder appraisalReminder WHERE ";

	private static final String _SQL_COUNT_APPRAISALREMINDER =
		"SELECT COUNT(appraisalReminder) FROM AppraisalReminder appraisalReminder";

	private static final String _SQL_COUNT_APPRAISALREMINDER_WHERE =
		"SELECT COUNT(appraisalReminder) FROM AppraisalReminder appraisalReminder WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "appraisalReminder.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AppraisalReminder exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AppraisalReminder exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AppraisalReminderPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}