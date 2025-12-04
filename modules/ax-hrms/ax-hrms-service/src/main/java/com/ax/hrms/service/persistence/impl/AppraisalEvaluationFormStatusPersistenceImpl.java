/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchAppraisalEvaluationFormStatusException;
import com.ax.hrms.model.AppraisalEvaluationFormStatus;
import com.ax.hrms.model.AppraisalEvaluationFormStatusTable;
import com.ax.hrms.model.impl.AppraisalEvaluationFormStatusImpl;
import com.ax.hrms.model.impl.AppraisalEvaluationFormStatusModelImpl;
import com.ax.hrms.service.persistence.AppraisalEvaluationFormStatusPersistence;
import com.ax.hrms.service.persistence.AppraisalEvaluationFormStatusUtil;
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
 * The persistence implementation for the appraisal evaluation form status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AppraisalEvaluationFormStatusPersistence.class)
public class AppraisalEvaluationFormStatusPersistenceImpl
	extends BasePersistenceImpl<AppraisalEvaluationFormStatus>
	implements AppraisalEvaluationFormStatusPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AppraisalEvaluationFormStatusUtil</code> to access the appraisal evaluation form status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AppraisalEvaluationFormStatusImpl.class.getName();

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
	 * Returns all the appraisal evaluation form statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching appraisal evaluation form statuses
	 */
	@Override
	public List<AppraisalEvaluationFormStatus> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal evaluation form statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @return the range of matching appraisal evaluation form statuses
	 */
	@Override
	public List<AppraisalEvaluationFormStatus> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal evaluation form statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal evaluation form statuses
	 */
	@Override
	public List<AppraisalEvaluationFormStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal evaluation form statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal evaluation form statuses
	 */
	@Override
	public List<AppraisalEvaluationFormStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator,
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

		List<AppraisalEvaluationFormStatus> list = null;

		if (useFinderCache) {
			list = (List<AppraisalEvaluationFormStatus>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppraisalEvaluationFormStatus
						appraisalEvaluationFormStatus : list) {

					if (!uuid.equals(appraisalEvaluationFormStatus.getUuid())) {
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

			sb.append(_SQL_SELECT_APPRAISALEVALUATIONFORMSTATUS_WHERE);

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
				sb.append(AppraisalEvaluationFormStatusModelImpl.ORDER_BY_JPQL);
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

				list = (List<AppraisalEvaluationFormStatus>)QueryUtil.list(
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
	 * Returns the first appraisal evaluation form status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus findByUuid_First(
			String uuid,
			OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException {

		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus =
			fetchByUuid_First(uuid, orderByComparator);

		if (appraisalEvaluationFormStatus != null) {
			return appraisalEvaluationFormStatus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAppraisalEvaluationFormStatusException(sb.toString());
	}

	/**
	 * Returns the first appraisal evaluation form status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus fetchByUuid_First(
		String uuid,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator) {

		List<AppraisalEvaluationFormStatus> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus findByUuid_Last(
			String uuid,
			OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException {

		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus =
			fetchByUuid_Last(uuid, orderByComparator);

		if (appraisalEvaluationFormStatus != null) {
			return appraisalEvaluationFormStatus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAppraisalEvaluationFormStatusException(sb.toString());
	}

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus fetchByUuid_Last(
		String uuid,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AppraisalEvaluationFormStatus> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appraisal evaluation form statuses before and after the current appraisal evaluation form status in the ordered set where uuid = &#63;.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key of the current appraisal evaluation form status
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a appraisal evaluation form status with the primary key could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus[] findByUuid_PrevAndNext(
			long appraisalEvaluationFormStatusId, String uuid,
			OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException {

		uuid = Objects.toString(uuid, "");

		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus =
			findByPrimaryKey(appraisalEvaluationFormStatusId);

		Session session = null;

		try {
			session = openSession();

			AppraisalEvaluationFormStatus[] array =
				new AppraisalEvaluationFormStatusImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, appraisalEvaluationFormStatus, uuid, orderByComparator,
				true);

			array[1] = appraisalEvaluationFormStatus;

			array[2] = getByUuid_PrevAndNext(
				session, appraisalEvaluationFormStatus, uuid, orderByComparator,
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

	protected AppraisalEvaluationFormStatus getByUuid_PrevAndNext(
		Session session,
		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus,
		String uuid,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator,
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

		sb.append(_SQL_SELECT_APPRAISALEVALUATIONFORMSTATUS_WHERE);

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
			sb.append(AppraisalEvaluationFormStatusModelImpl.ORDER_BY_JPQL);
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
						appraisalEvaluationFormStatus)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppraisalEvaluationFormStatus> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appraisal evaluation form statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AppraisalEvaluationFormStatus appraisalEvaluationFormStatus :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(appraisalEvaluationFormStatus);
		}
	}

	/**
	 * Returns the number of appraisal evaluation form statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching appraisal evaluation form statuses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPRAISALEVALUATIONFORMSTATUS_WHERE);

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
		"appraisalEvaluationFormStatus.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(appraisalEvaluationFormStatus.uuid IS NULL OR appraisalEvaluationFormStatus.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the appraisal evaluation form status where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAppraisalEvaluationFormStatusException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus findByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalEvaluationFormStatusException {

		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus =
			fetchByUUID_G(uuid, groupId);

		if (appraisalEvaluationFormStatus == null) {
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

			throw new NoSuchAppraisalEvaluationFormStatusException(
				sb.toString());
		}

		return appraisalEvaluationFormStatus;
	}

	/**
	 * Returns the appraisal evaluation form status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus fetchByUUID_G(
		String uuid, long groupId) {

		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the appraisal evaluation form status where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus fetchByUUID_G(
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

		if (result instanceof AppraisalEvaluationFormStatus) {
			AppraisalEvaluationFormStatus appraisalEvaluationFormStatus =
				(AppraisalEvaluationFormStatus)result;

			if (!Objects.equals(
					uuid, appraisalEvaluationFormStatus.getUuid()) ||
				(groupId != appraisalEvaluationFormStatus.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_APPRAISALEVALUATIONFORMSTATUS_WHERE);

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

				List<AppraisalEvaluationFormStatus> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					AppraisalEvaluationFormStatus
						appraisalEvaluationFormStatus = list.get(0);

					result = appraisalEvaluationFormStatus;

					cacheResult(appraisalEvaluationFormStatus);
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
			return (AppraisalEvaluationFormStatus)result;
		}
	}

	/**
	 * Removes the appraisal evaluation form status where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the appraisal evaluation form status that was removed
	 */
	@Override
	public AppraisalEvaluationFormStatus removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchAppraisalEvaluationFormStatusException {

		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus =
			findByUUID_G(uuid, groupId);

		return remove(appraisalEvaluationFormStatus);
	}

	/**
	 * Returns the number of appraisal evaluation form statuses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching appraisal evaluation form statuses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus =
			fetchByUUID_G(uuid, groupId);

		if (appraisalEvaluationFormStatus == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"appraisalEvaluationFormStatus.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(appraisalEvaluationFormStatus.uuid IS NULL OR appraisalEvaluationFormStatus.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"appraisalEvaluationFormStatus.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the appraisal evaluation form statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching appraisal evaluation form statuses
	 */
	@Override
	public List<AppraisalEvaluationFormStatus> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal evaluation form statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @return the range of matching appraisal evaluation form statuses
	 */
	@Override
	public List<AppraisalEvaluationFormStatus> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal evaluation form statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal evaluation form statuses
	 */
	@Override
	public List<AppraisalEvaluationFormStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal evaluation form statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal evaluation form statuses
	 */
	@Override
	public List<AppraisalEvaluationFormStatus> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator,
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

		List<AppraisalEvaluationFormStatus> list = null;

		if (useFinderCache) {
			list = (List<AppraisalEvaluationFormStatus>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppraisalEvaluationFormStatus
						appraisalEvaluationFormStatus : list) {

					if (!uuid.equals(appraisalEvaluationFormStatus.getUuid()) ||
						(companyId !=
							appraisalEvaluationFormStatus.getCompanyId())) {

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

			sb.append(_SQL_SELECT_APPRAISALEVALUATIONFORMSTATUS_WHERE);

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
				sb.append(AppraisalEvaluationFormStatusModelImpl.ORDER_BY_JPQL);
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

				list = (List<AppraisalEvaluationFormStatus>)QueryUtil.list(
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
	 * Returns the first appraisal evaluation form status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException {

		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (appraisalEvaluationFormStatus != null) {
			return appraisalEvaluationFormStatus;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAppraisalEvaluationFormStatusException(sb.toString());
	}

	/**
	 * Returns the first appraisal evaluation form status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator) {

		List<AppraisalEvaluationFormStatus> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException {

		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (appraisalEvaluationFormStatus != null) {
			return appraisalEvaluationFormStatus;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAppraisalEvaluationFormStatusException(sb.toString());
	}

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AppraisalEvaluationFormStatus> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appraisal evaluation form statuses before and after the current appraisal evaluation form status in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key of the current appraisal evaluation form status
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a appraisal evaluation form status with the primary key could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus[] findByUuid_C_PrevAndNext(
			long appraisalEvaluationFormStatusId, String uuid, long companyId,
			OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException {

		uuid = Objects.toString(uuid, "");

		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus =
			findByPrimaryKey(appraisalEvaluationFormStatusId);

		Session session = null;

		try {
			session = openSession();

			AppraisalEvaluationFormStatus[] array =
				new AppraisalEvaluationFormStatusImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, appraisalEvaluationFormStatus, uuid, companyId,
				orderByComparator, true);

			array[1] = appraisalEvaluationFormStatus;

			array[2] = getByUuid_C_PrevAndNext(
				session, appraisalEvaluationFormStatus, uuid, companyId,
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

	protected AppraisalEvaluationFormStatus getByUuid_C_PrevAndNext(
		Session session,
		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus,
		String uuid, long companyId,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator,
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

		sb.append(_SQL_SELECT_APPRAISALEVALUATIONFORMSTATUS_WHERE);

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
			sb.append(AppraisalEvaluationFormStatusModelImpl.ORDER_BY_JPQL);
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
						appraisalEvaluationFormStatus)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppraisalEvaluationFormStatus> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appraisal evaluation form statuses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AppraisalEvaluationFormStatus appraisalEvaluationFormStatus :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(appraisalEvaluationFormStatus);
		}
	}

	/**
	 * Returns the number of appraisal evaluation form statuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching appraisal evaluation form statuses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_APPRAISALEVALUATIONFORMSTATUS_WHERE);

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
		"appraisalEvaluationFormStatus.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(appraisalEvaluationFormStatus.uuid IS NULL OR appraisalEvaluationFormStatus.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"appraisalEvaluationFormStatus.companyId = ?";

	private FinderPath
		_finderPathWithPaginationFindByAppraisalProcessIdAndAppraisalFormTemplateId;
	private FinderPath
		_finderPathWithoutPaginationFindByAppraisalProcessIdAndAppraisalFormTemplateId;
	private FinderPath
		_finderPathCountByAppraisalProcessIdAndAppraisalFormTemplateId;

	/**
	 * Returns all the appraisal evaluation form statuses where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @return the matching appraisal evaluation form statuses
	 */
	@Override
	public List<AppraisalEvaluationFormStatus>
		findByAppraisalProcessIdAndAppraisalFormTemplateId(
			long appraisalProcessId, long appraisalFormTemplateId) {

		return findByAppraisalProcessIdAndAppraisalFormTemplateId(
			appraisalProcessId, appraisalFormTemplateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal evaluation form statuses where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @return the range of matching appraisal evaluation form statuses
	 */
	@Override
	public List<AppraisalEvaluationFormStatus>
		findByAppraisalProcessIdAndAppraisalFormTemplateId(
			long appraisalProcessId, long appraisalFormTemplateId, int start,
			int end) {

		return findByAppraisalProcessIdAndAppraisalFormTemplateId(
			appraisalProcessId, appraisalFormTemplateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal evaluation form statuses where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal evaluation form statuses
	 */
	@Override
	public List<AppraisalEvaluationFormStatus>
		findByAppraisalProcessIdAndAppraisalFormTemplateId(
			long appraisalProcessId, long appraisalFormTemplateId, int start,
			int end,
			OrderByComparator<AppraisalEvaluationFormStatus>
				orderByComparator) {

		return findByAppraisalProcessIdAndAppraisalFormTemplateId(
			appraisalProcessId, appraisalFormTemplateId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal evaluation form statuses where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal evaluation form statuses
	 */
	@Override
	public List<AppraisalEvaluationFormStatus>
		findByAppraisalProcessIdAndAppraisalFormTemplateId(
			long appraisalProcessId, long appraisalFormTemplateId, int start,
			int end,
			OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator,
			boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByAppraisalProcessIdAndAppraisalFormTemplateId;
				finderArgs = new Object[] {
					appraisalProcessId, appraisalFormTemplateId
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByAppraisalProcessIdAndAppraisalFormTemplateId;
			finderArgs = new Object[] {
				appraisalProcessId, appraisalFormTemplateId, start, end,
				orderByComparator
			};
		}

		List<AppraisalEvaluationFormStatus> list = null;

		if (useFinderCache) {
			list = (List<AppraisalEvaluationFormStatus>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppraisalEvaluationFormStatus
						appraisalEvaluationFormStatus : list) {

					if ((appraisalProcessId !=
							appraisalEvaluationFormStatus.
								getAppraisalProcessId()) ||
						(appraisalFormTemplateId !=
							appraisalEvaluationFormStatus.
								getAppraisalFormTemplateId())) {

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

			sb.append(_SQL_SELECT_APPRAISALEVALUATIONFORMSTATUS_WHERE);

			sb.append(
				_FINDER_COLUMN_APPRAISALPROCESSIDANDAPPRAISALFORMTEMPLATEID_APPRAISALPROCESSID_2);

			sb.append(
				_FINDER_COLUMN_APPRAISALPROCESSIDANDAPPRAISALFORMTEMPLATEID_APPRAISALFORMTEMPLATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AppraisalEvaluationFormStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(appraisalProcessId);

				queryPos.add(appraisalFormTemplateId);

				list = (List<AppraisalEvaluationFormStatus>)QueryUtil.list(
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
	 * Returns the first appraisal evaluation form status in the ordered set where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus
			findByAppraisalProcessIdAndAppraisalFormTemplateId_First(
				long appraisalProcessId, long appraisalFormTemplateId,
				OrderByComparator<AppraisalEvaluationFormStatus>
					orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException {

		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus =
			fetchByAppraisalProcessIdAndAppraisalFormTemplateId_First(
				appraisalProcessId, appraisalFormTemplateId, orderByComparator);

		if (appraisalEvaluationFormStatus != null) {
			return appraisalEvaluationFormStatus;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("appraisalProcessId=");
		sb.append(appraisalProcessId);

		sb.append(", appraisalFormTemplateId=");
		sb.append(appraisalFormTemplateId);

		sb.append("}");

		throw new NoSuchAppraisalEvaluationFormStatusException(sb.toString());
	}

	/**
	 * Returns the first appraisal evaluation form status in the ordered set where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus
		fetchByAppraisalProcessIdAndAppraisalFormTemplateId_First(
			long appraisalProcessId, long appraisalFormTemplateId,
			OrderByComparator<AppraisalEvaluationFormStatus>
				orderByComparator) {

		List<AppraisalEvaluationFormStatus> list =
			findByAppraisalProcessIdAndAppraisalFormTemplateId(
				appraisalProcessId, appraisalFormTemplateId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus
			findByAppraisalProcessIdAndAppraisalFormTemplateId_Last(
				long appraisalProcessId, long appraisalFormTemplateId,
				OrderByComparator<AppraisalEvaluationFormStatus>
					orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException {

		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus =
			fetchByAppraisalProcessIdAndAppraisalFormTemplateId_Last(
				appraisalProcessId, appraisalFormTemplateId, orderByComparator);

		if (appraisalEvaluationFormStatus != null) {
			return appraisalEvaluationFormStatus;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("appraisalProcessId=");
		sb.append(appraisalProcessId);

		sb.append(", appraisalFormTemplateId=");
		sb.append(appraisalFormTemplateId);

		sb.append("}");

		throw new NoSuchAppraisalEvaluationFormStatusException(sb.toString());
	}

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus
		fetchByAppraisalProcessIdAndAppraisalFormTemplateId_Last(
			long appraisalProcessId, long appraisalFormTemplateId,
			OrderByComparator<AppraisalEvaluationFormStatus>
				orderByComparator) {

		int count = countByAppraisalProcessIdAndAppraisalFormTemplateId(
			appraisalProcessId, appraisalFormTemplateId);

		if (count == 0) {
			return null;
		}

		List<AppraisalEvaluationFormStatus> list =
			findByAppraisalProcessIdAndAppraisalFormTemplateId(
				appraisalProcessId, appraisalFormTemplateId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appraisal evaluation form statuses before and after the current appraisal evaluation form status in the ordered set where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key of the current appraisal evaluation form status
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a appraisal evaluation form status with the primary key could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus[]
			findByAppraisalProcessIdAndAppraisalFormTemplateId_PrevAndNext(
				long appraisalEvaluationFormStatusId, long appraisalProcessId,
				long appraisalFormTemplateId,
				OrderByComparator<AppraisalEvaluationFormStatus>
					orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException {

		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus =
			findByPrimaryKey(appraisalEvaluationFormStatusId);

		Session session = null;

		try {
			session = openSession();

			AppraisalEvaluationFormStatus[] array =
				new AppraisalEvaluationFormStatusImpl[3];

			array[0] =
				getByAppraisalProcessIdAndAppraisalFormTemplateId_PrevAndNext(
					session, appraisalEvaluationFormStatus, appraisalProcessId,
					appraisalFormTemplateId, orderByComparator, true);

			array[1] = appraisalEvaluationFormStatus;

			array[2] =
				getByAppraisalProcessIdAndAppraisalFormTemplateId_PrevAndNext(
					session, appraisalEvaluationFormStatus, appraisalProcessId,
					appraisalFormTemplateId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AppraisalEvaluationFormStatus
		getByAppraisalProcessIdAndAppraisalFormTemplateId_PrevAndNext(
			Session session,
			AppraisalEvaluationFormStatus appraisalEvaluationFormStatus,
			long appraisalProcessId, long appraisalFormTemplateId,
			OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator,
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

		sb.append(_SQL_SELECT_APPRAISALEVALUATIONFORMSTATUS_WHERE);

		sb.append(
			_FINDER_COLUMN_APPRAISALPROCESSIDANDAPPRAISALFORMTEMPLATEID_APPRAISALPROCESSID_2);

		sb.append(
			_FINDER_COLUMN_APPRAISALPROCESSIDANDAPPRAISALFORMTEMPLATEID_APPRAISALFORMTEMPLATEID_2);

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
			sb.append(AppraisalEvaluationFormStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(appraisalProcessId);

		queryPos.add(appraisalFormTemplateId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						appraisalEvaluationFormStatus)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppraisalEvaluationFormStatus> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appraisal evaluation form statuses where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63; from the database.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 */
	@Override
	public void removeByAppraisalProcessIdAndAppraisalFormTemplateId(
		long appraisalProcessId, long appraisalFormTemplateId) {

		for (AppraisalEvaluationFormStatus appraisalEvaluationFormStatus :
				findByAppraisalProcessIdAndAppraisalFormTemplateId(
					appraisalProcessId, appraisalFormTemplateId,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(appraisalEvaluationFormStatus);
		}
	}

	/**
	 * Returns the number of appraisal evaluation form statuses where appraisalProcessId = &#63; and appraisalFormTemplateId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param appraisalFormTemplateId the appraisal form template ID
	 * @return the number of matching appraisal evaluation form statuses
	 */
	@Override
	public int countByAppraisalProcessIdAndAppraisalFormTemplateId(
		long appraisalProcessId, long appraisalFormTemplateId) {

		FinderPath finderPath =
			_finderPathCountByAppraisalProcessIdAndAppraisalFormTemplateId;

		Object[] finderArgs = new Object[] {
			appraisalProcessId, appraisalFormTemplateId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_APPRAISALEVALUATIONFORMSTATUS_WHERE);

			sb.append(
				_FINDER_COLUMN_APPRAISALPROCESSIDANDAPPRAISALFORMTEMPLATEID_APPRAISALPROCESSID_2);

			sb.append(
				_FINDER_COLUMN_APPRAISALPROCESSIDANDAPPRAISALFORMTEMPLATEID_APPRAISALFORMTEMPLATEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(appraisalProcessId);

				queryPos.add(appraisalFormTemplateId);

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
		_FINDER_COLUMN_APPRAISALPROCESSIDANDAPPRAISALFORMTEMPLATEID_APPRAISALPROCESSID_2 =
			"appraisalEvaluationFormStatus.appraisalProcessId = ? AND ";

	private static final String
		_FINDER_COLUMN_APPRAISALPROCESSIDANDAPPRAISALFORMTEMPLATEID_APPRAISALFORMTEMPLATEID_2 =
			"appraisalEvaluationFormStatus.appraisalFormTemplateId = ?";

	private FinderPath _finderPathWithPaginationFindByStatusAndSubmissionDate;
	private FinderPath
		_finderPathWithoutPaginationFindByStatusAndSubmissionDate;
	private FinderPath _finderPathCountByStatusAndSubmissionDate;

	/**
	 * Returns all the appraisal evaluation form statuses where submissionDate = &#63; and status = &#63;.
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @return the matching appraisal evaluation form statuses
	 */
	@Override
	public List<AppraisalEvaluationFormStatus> findByStatusAndSubmissionDate(
		Date submissionDate, boolean status) {

		return findByStatusAndSubmissionDate(
			submissionDate, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal evaluation form statuses where submissionDate = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @return the range of matching appraisal evaluation form statuses
	 */
	@Override
	public List<AppraisalEvaluationFormStatus> findByStatusAndSubmissionDate(
		Date submissionDate, boolean status, int start, int end) {

		return findByStatusAndSubmissionDate(
			submissionDate, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal evaluation form statuses where submissionDate = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal evaluation form statuses
	 */
	@Override
	public List<AppraisalEvaluationFormStatus> findByStatusAndSubmissionDate(
		Date submissionDate, boolean status, int start, int end,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator) {

		return findByStatusAndSubmissionDate(
			submissionDate, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal evaluation form statuses where submissionDate = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal evaluation form statuses
	 */
	@Override
	public List<AppraisalEvaluationFormStatus> findByStatusAndSubmissionDate(
		Date submissionDate, boolean status, int start, int end,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByStatusAndSubmissionDate;
				finderArgs = new Object[] {_getTime(submissionDate), status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatusAndSubmissionDate;
			finderArgs = new Object[] {
				_getTime(submissionDate), status, start, end, orderByComparator
			};
		}

		List<AppraisalEvaluationFormStatus> list = null;

		if (useFinderCache) {
			list = (List<AppraisalEvaluationFormStatus>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppraisalEvaluationFormStatus
						appraisalEvaluationFormStatus : list) {

					if (!Objects.equals(
							submissionDate,
							appraisalEvaluationFormStatus.
								getSubmissionDate()) ||
						(status != appraisalEvaluationFormStatus.isStatus())) {

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

			sb.append(_SQL_SELECT_APPRAISALEVALUATIONFORMSTATUS_WHERE);

			boolean bindSubmissionDate = false;

			if (submissionDate == null) {
				sb.append(
					_FINDER_COLUMN_STATUSANDSUBMISSIONDATE_SUBMISSIONDATE_1);
			}
			else {
				bindSubmissionDate = true;

				sb.append(
					_FINDER_COLUMN_STATUSANDSUBMISSIONDATE_SUBMISSIONDATE_2);
			}

			sb.append(_FINDER_COLUMN_STATUSANDSUBMISSIONDATE_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AppraisalEvaluationFormStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSubmissionDate) {
					queryPos.add(new Timestamp(submissionDate.getTime()));
				}

				queryPos.add(status);

				list = (List<AppraisalEvaluationFormStatus>)QueryUtil.list(
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
	 * Returns the first appraisal evaluation form status in the ordered set where submissionDate = &#63; and status = &#63;.
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus findByStatusAndSubmissionDate_First(
			Date submissionDate, boolean status,
			OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException {

		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus =
			fetchByStatusAndSubmissionDate_First(
				submissionDate, status, orderByComparator);

		if (appraisalEvaluationFormStatus != null) {
			return appraisalEvaluationFormStatus;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("submissionDate=");
		sb.append(submissionDate);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchAppraisalEvaluationFormStatusException(sb.toString());
	}

	/**
	 * Returns the first appraisal evaluation form status in the ordered set where submissionDate = &#63; and status = &#63;.
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus fetchByStatusAndSubmissionDate_First(
		Date submissionDate, boolean status,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator) {

		List<AppraisalEvaluationFormStatus> list =
			findByStatusAndSubmissionDate(
				submissionDate, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where submissionDate = &#63; and status = &#63;.
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a matching appraisal evaluation form status could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus findByStatusAndSubmissionDate_Last(
			Date submissionDate, boolean status,
			OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException {

		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus =
			fetchByStatusAndSubmissionDate_Last(
				submissionDate, status, orderByComparator);

		if (appraisalEvaluationFormStatus != null) {
			return appraisalEvaluationFormStatus;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("submissionDate=");
		sb.append(submissionDate);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchAppraisalEvaluationFormStatusException(sb.toString());
	}

	/**
	 * Returns the last appraisal evaluation form status in the ordered set where submissionDate = &#63; and status = &#63;.
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus fetchByStatusAndSubmissionDate_Last(
		Date submissionDate, boolean status,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator) {

		int count = countByStatusAndSubmissionDate(submissionDate, status);

		if (count == 0) {
			return null;
		}

		List<AppraisalEvaluationFormStatus> list =
			findByStatusAndSubmissionDate(
				submissionDate, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appraisal evaluation form statuses before and after the current appraisal evaluation form status in the ordered set where submissionDate = &#63; and status = &#63;.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key of the current appraisal evaluation form status
	 * @param submissionDate the submission date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a appraisal evaluation form status with the primary key could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus[]
			findByStatusAndSubmissionDate_PrevAndNext(
				long appraisalEvaluationFormStatusId, Date submissionDate,
				boolean status,
				OrderByComparator<AppraisalEvaluationFormStatus>
					orderByComparator)
		throws NoSuchAppraisalEvaluationFormStatusException {

		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus =
			findByPrimaryKey(appraisalEvaluationFormStatusId);

		Session session = null;

		try {
			session = openSession();

			AppraisalEvaluationFormStatus[] array =
				new AppraisalEvaluationFormStatusImpl[3];

			array[0] = getByStatusAndSubmissionDate_PrevAndNext(
				session, appraisalEvaluationFormStatus, submissionDate, status,
				orderByComparator, true);

			array[1] = appraisalEvaluationFormStatus;

			array[2] = getByStatusAndSubmissionDate_PrevAndNext(
				session, appraisalEvaluationFormStatus, submissionDate, status,
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

	protected AppraisalEvaluationFormStatus
		getByStatusAndSubmissionDate_PrevAndNext(
			Session session,
			AppraisalEvaluationFormStatus appraisalEvaluationFormStatus,
			Date submissionDate, boolean status,
			OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator,
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

		sb.append(_SQL_SELECT_APPRAISALEVALUATIONFORMSTATUS_WHERE);

		boolean bindSubmissionDate = false;

		if (submissionDate == null) {
			sb.append(_FINDER_COLUMN_STATUSANDSUBMISSIONDATE_SUBMISSIONDATE_1);
		}
		else {
			bindSubmissionDate = true;

			sb.append(_FINDER_COLUMN_STATUSANDSUBMISSIONDATE_SUBMISSIONDATE_2);
		}

		sb.append(_FINDER_COLUMN_STATUSANDSUBMISSIONDATE_STATUS_2);

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
			sb.append(AppraisalEvaluationFormStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindSubmissionDate) {
			queryPos.add(new Timestamp(submissionDate.getTime()));
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						appraisalEvaluationFormStatus)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppraisalEvaluationFormStatus> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appraisal evaluation form statuses where submissionDate = &#63; and status = &#63; from the database.
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 */
	@Override
	public void removeByStatusAndSubmissionDate(
		Date submissionDate, boolean status) {

		for (AppraisalEvaluationFormStatus appraisalEvaluationFormStatus :
				findByStatusAndSubmissionDate(
					submissionDate, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(appraisalEvaluationFormStatus);
		}
	}

	/**
	 * Returns the number of appraisal evaluation form statuses where submissionDate = &#63; and status = &#63;.
	 *
	 * @param submissionDate the submission date
	 * @param status the status
	 * @return the number of matching appraisal evaluation form statuses
	 */
	@Override
	public int countByStatusAndSubmissionDate(
		Date submissionDate, boolean status) {

		FinderPath finderPath = _finderPathCountByStatusAndSubmissionDate;

		Object[] finderArgs = new Object[] {_getTime(submissionDate), status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_APPRAISALEVALUATIONFORMSTATUS_WHERE);

			boolean bindSubmissionDate = false;

			if (submissionDate == null) {
				sb.append(
					_FINDER_COLUMN_STATUSANDSUBMISSIONDATE_SUBMISSIONDATE_1);
			}
			else {
				bindSubmissionDate = true;

				sb.append(
					_FINDER_COLUMN_STATUSANDSUBMISSIONDATE_SUBMISSIONDATE_2);
			}

			sb.append(_FINDER_COLUMN_STATUSANDSUBMISSIONDATE_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSubmissionDate) {
					queryPos.add(new Timestamp(submissionDate.getTime()));
				}

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
		_FINDER_COLUMN_STATUSANDSUBMISSIONDATE_SUBMISSIONDATE_1 =
			"appraisalEvaluationFormStatus.submissionDate IS NULL AND ";

	private static final String
		_FINDER_COLUMN_STATUSANDSUBMISSIONDATE_SUBMISSIONDATE_2 =
			"appraisalEvaluationFormStatus.submissionDate = ? AND ";

	private static final String
		_FINDER_COLUMN_STATUSANDSUBMISSIONDATE_STATUS_2 =
			"appraisalEvaluationFormStatus.status = ?";

	public AppraisalEvaluationFormStatusPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AppraisalEvaluationFormStatus.class);

		setModelImplClass(AppraisalEvaluationFormStatusImpl.class);
		setModelPKClass(long.class);

		setTable(AppraisalEvaluationFormStatusTable.INSTANCE);
	}

	/**
	 * Caches the appraisal evaluation form status in the entity cache if it is enabled.
	 *
	 * @param appraisalEvaluationFormStatus the appraisal evaluation form status
	 */
	@Override
	public void cacheResult(
		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus) {

		entityCache.putResult(
			AppraisalEvaluationFormStatusImpl.class,
			appraisalEvaluationFormStatus.getPrimaryKey(),
			appraisalEvaluationFormStatus);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				appraisalEvaluationFormStatus.getUuid(),
				appraisalEvaluationFormStatus.getGroupId()
			},
			appraisalEvaluationFormStatus);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the appraisal evaluation form statuses in the entity cache if it is enabled.
	 *
	 * @param appraisalEvaluationFormStatuses the appraisal evaluation form statuses
	 */
	@Override
	public void cacheResult(
		List<AppraisalEvaluationFormStatus> appraisalEvaluationFormStatuses) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (appraisalEvaluationFormStatuses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AppraisalEvaluationFormStatus appraisalEvaluationFormStatus :
				appraisalEvaluationFormStatuses) {

			if (entityCache.getResult(
					AppraisalEvaluationFormStatusImpl.class,
					appraisalEvaluationFormStatus.getPrimaryKey()) == null) {

				cacheResult(appraisalEvaluationFormStatus);
			}
		}
	}

	/**
	 * Clears the cache for all appraisal evaluation form statuses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AppraisalEvaluationFormStatusImpl.class);

		finderCache.clearCache(AppraisalEvaluationFormStatusImpl.class);
	}

	/**
	 * Clears the cache for the appraisal evaluation form status.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus) {

		entityCache.removeResult(
			AppraisalEvaluationFormStatusImpl.class,
			appraisalEvaluationFormStatus);
	}

	@Override
	public void clearCache(
		List<AppraisalEvaluationFormStatus> appraisalEvaluationFormStatuses) {

		for (AppraisalEvaluationFormStatus appraisalEvaluationFormStatus :
				appraisalEvaluationFormStatuses) {

			entityCache.removeResult(
				AppraisalEvaluationFormStatusImpl.class,
				appraisalEvaluationFormStatus);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AppraisalEvaluationFormStatusImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				AppraisalEvaluationFormStatusImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AppraisalEvaluationFormStatusModelImpl
			appraisalEvaluationFormStatusModelImpl) {

		Object[] args = new Object[] {
			appraisalEvaluationFormStatusModelImpl.getUuid(),
			appraisalEvaluationFormStatusModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			appraisalEvaluationFormStatusModelImpl);
	}

	/**
	 * Creates a new appraisal evaluation form status with the primary key. Does not add the appraisal evaluation form status to the database.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key for the new appraisal evaluation form status
	 * @return the new appraisal evaluation form status
	 */
	@Override
	public AppraisalEvaluationFormStatus create(
		long appraisalEvaluationFormStatusId) {

		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus =
			new AppraisalEvaluationFormStatusImpl();

		appraisalEvaluationFormStatus.setNew(true);
		appraisalEvaluationFormStatus.setPrimaryKey(
			appraisalEvaluationFormStatusId);

		String uuid = PortalUUIDUtil.generate();

		appraisalEvaluationFormStatus.setUuid(uuid);

		appraisalEvaluationFormStatus.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return appraisalEvaluationFormStatus;
	}

	/**
	 * Removes the appraisal evaluation form status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key of the appraisal evaluation form status
	 * @return the appraisal evaluation form status that was removed
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a appraisal evaluation form status with the primary key could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus remove(
			long appraisalEvaluationFormStatusId)
		throws NoSuchAppraisalEvaluationFormStatusException {

		return remove((Serializable)appraisalEvaluationFormStatusId);
	}

	/**
	 * Removes the appraisal evaluation form status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the appraisal evaluation form status
	 * @return the appraisal evaluation form status that was removed
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a appraisal evaluation form status with the primary key could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus remove(Serializable primaryKey)
		throws NoSuchAppraisalEvaluationFormStatusException {

		Session session = null;

		try {
			session = openSession();

			AppraisalEvaluationFormStatus appraisalEvaluationFormStatus =
				(AppraisalEvaluationFormStatus)session.get(
					AppraisalEvaluationFormStatusImpl.class, primaryKey);

			if (appraisalEvaluationFormStatus == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppraisalEvaluationFormStatusException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(appraisalEvaluationFormStatus);
		}
		catch (NoSuchAppraisalEvaluationFormStatusException
					noSuchEntityException) {

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
	protected AppraisalEvaluationFormStatus removeImpl(
		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appraisalEvaluationFormStatus)) {
				appraisalEvaluationFormStatus =
					(AppraisalEvaluationFormStatus)session.get(
						AppraisalEvaluationFormStatusImpl.class,
						appraisalEvaluationFormStatus.getPrimaryKeyObj());
			}

			if (appraisalEvaluationFormStatus != null) {
				session.delete(appraisalEvaluationFormStatus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (appraisalEvaluationFormStatus != null) {
			clearCache(appraisalEvaluationFormStatus);
		}

		return appraisalEvaluationFormStatus;
	}

	@Override
	public AppraisalEvaluationFormStatus updateImpl(
		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus) {

		boolean isNew = appraisalEvaluationFormStatus.isNew();

		if (!(appraisalEvaluationFormStatus instanceof
				AppraisalEvaluationFormStatusModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					appraisalEvaluationFormStatus.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					appraisalEvaluationFormStatus);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in appraisalEvaluationFormStatus proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AppraisalEvaluationFormStatus implementation " +
					appraisalEvaluationFormStatus.getClass());
		}

		AppraisalEvaluationFormStatusModelImpl
			appraisalEvaluationFormStatusModelImpl =
				(AppraisalEvaluationFormStatusModelImpl)
					appraisalEvaluationFormStatus;

		if (Validator.isNull(appraisalEvaluationFormStatus.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			appraisalEvaluationFormStatus.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (appraisalEvaluationFormStatus.getCreateDate() == null)) {
			if (serviceContext == null) {
				appraisalEvaluationFormStatus.setCreateDate(date);
			}
			else {
				appraisalEvaluationFormStatus.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!appraisalEvaluationFormStatusModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				appraisalEvaluationFormStatus.setModifiedDate(date);
			}
			else {
				appraisalEvaluationFormStatus.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(appraisalEvaluationFormStatus);
			}
			else {
				appraisalEvaluationFormStatus =
					(AppraisalEvaluationFormStatus)session.merge(
						appraisalEvaluationFormStatus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AppraisalEvaluationFormStatusImpl.class,
			appraisalEvaluationFormStatusModelImpl, false, true);

		cacheUniqueFindersCache(appraisalEvaluationFormStatusModelImpl);

		if (isNew) {
			appraisalEvaluationFormStatus.setNew(false);
		}

		appraisalEvaluationFormStatus.resetOriginalValues();

		return appraisalEvaluationFormStatus;
	}

	/**
	 * Returns the appraisal evaluation form status with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the appraisal evaluation form status
	 * @return the appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a appraisal evaluation form status with the primary key could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchAppraisalEvaluationFormStatusException {

		AppraisalEvaluationFormStatus appraisalEvaluationFormStatus =
			fetchByPrimaryKey(primaryKey);

		if (appraisalEvaluationFormStatus == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppraisalEvaluationFormStatusException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return appraisalEvaluationFormStatus;
	}

	/**
	 * Returns the appraisal evaluation form status with the primary key or throws a <code>NoSuchAppraisalEvaluationFormStatusException</code> if it could not be found.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key of the appraisal evaluation form status
	 * @return the appraisal evaluation form status
	 * @throws NoSuchAppraisalEvaluationFormStatusException if a appraisal evaluation form status with the primary key could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus findByPrimaryKey(
			long appraisalEvaluationFormStatusId)
		throws NoSuchAppraisalEvaluationFormStatusException {

		return findByPrimaryKey((Serializable)appraisalEvaluationFormStatusId);
	}

	/**
	 * Returns the appraisal evaluation form status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key of the appraisal evaluation form status
	 * @return the appraisal evaluation form status, or <code>null</code> if a appraisal evaluation form status with the primary key could not be found
	 */
	@Override
	public AppraisalEvaluationFormStatus fetchByPrimaryKey(
		long appraisalEvaluationFormStatusId) {

		return fetchByPrimaryKey((Serializable)appraisalEvaluationFormStatusId);
	}

	/**
	 * Returns all the appraisal evaluation form statuses.
	 *
	 * @return the appraisal evaluation form statuses
	 */
	@Override
	public List<AppraisalEvaluationFormStatus> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal evaluation form statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @return the range of appraisal evaluation form statuses
	 */
	@Override
	public List<AppraisalEvaluationFormStatus> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal evaluation form statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appraisal evaluation form statuses
	 */
	@Override
	public List<AppraisalEvaluationFormStatus> findAll(
		int start, int end,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal evaluation form statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of appraisal evaluation form statuses
	 */
	@Override
	public List<AppraisalEvaluationFormStatus> findAll(
		int start, int end,
		OrderByComparator<AppraisalEvaluationFormStatus> orderByComparator,
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

		List<AppraisalEvaluationFormStatus> list = null;

		if (useFinderCache) {
			list = (List<AppraisalEvaluationFormStatus>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_APPRAISALEVALUATIONFORMSTATUS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_APPRAISALEVALUATIONFORMSTATUS;

				sql = sql.concat(
					AppraisalEvaluationFormStatusModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AppraisalEvaluationFormStatus>)QueryUtil.list(
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
	 * Removes all the appraisal evaluation form statuses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AppraisalEvaluationFormStatus appraisalEvaluationFormStatus :
				findAll()) {

			remove(appraisalEvaluationFormStatus);
		}
	}

	/**
	 * Returns the number of appraisal evaluation form statuses.
	 *
	 * @return the number of appraisal evaluation form statuses
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
					_SQL_COUNT_APPRAISALEVALUATIONFORMSTATUS);

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
		return "appraisalEvaluationFormStatusId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_APPRAISALEVALUATIONFORMSTATUS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AppraisalEvaluationFormStatusModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the appraisal evaluation form status persistence.
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

		_finderPathWithPaginationFindByAppraisalProcessIdAndAppraisalFormTemplateId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByAppraisalProcessIdAndAppraisalFormTemplateId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"appraisalProcessId", "appraisalFormTemplateId"},
				true);

		_finderPathWithoutPaginationFindByAppraisalProcessIdAndAppraisalFormTemplateId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByAppraisalProcessIdAndAppraisalFormTemplateId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"appraisalProcessId", "appraisalFormTemplateId"},
				true);

		_finderPathCountByAppraisalProcessIdAndAppraisalFormTemplateId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByAppraisalProcessIdAndAppraisalFormTemplateId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"appraisalProcessId", "appraisalFormTemplateId"},
				false);

		_finderPathWithPaginationFindByStatusAndSubmissionDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStatusAndSubmissionDate",
			new String[] {
				Date.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"submissionDate", "status"}, true);

		_finderPathWithoutPaginationFindByStatusAndSubmissionDate =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByStatusAndSubmissionDate",
				new String[] {Date.class.getName(), Boolean.class.getName()},
				new String[] {"submissionDate", "status"}, true);

		_finderPathCountByStatusAndSubmissionDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStatusAndSubmissionDate",
			new String[] {Date.class.getName(), Boolean.class.getName()},
			new String[] {"submissionDate", "status"}, false);

		AppraisalEvaluationFormStatusUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AppraisalEvaluationFormStatusUtil.setPersistence(null);

		entityCache.removeCache(
			AppraisalEvaluationFormStatusImpl.class.getName());
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

	private static final String _SQL_SELECT_APPRAISALEVALUATIONFORMSTATUS =
		"SELECT appraisalEvaluationFormStatus FROM AppraisalEvaluationFormStatus appraisalEvaluationFormStatus";

	private static final String
		_SQL_SELECT_APPRAISALEVALUATIONFORMSTATUS_WHERE =
			"SELECT appraisalEvaluationFormStatus FROM AppraisalEvaluationFormStatus appraisalEvaluationFormStatus WHERE ";

	private static final String _SQL_COUNT_APPRAISALEVALUATIONFORMSTATUS =
		"SELECT COUNT(appraisalEvaluationFormStatus) FROM AppraisalEvaluationFormStatus appraisalEvaluationFormStatus";

	private static final String _SQL_COUNT_APPRAISALEVALUATIONFORMSTATUS_WHERE =
		"SELECT COUNT(appraisalEvaluationFormStatus) FROM AppraisalEvaluationFormStatus appraisalEvaluationFormStatus WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"appraisalEvaluationFormStatus.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AppraisalEvaluationFormStatus exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AppraisalEvaluationFormStatus exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AppraisalEvaluationFormStatusPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}