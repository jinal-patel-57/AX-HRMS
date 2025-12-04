/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchAppraisalHistoryException;
import com.ax.hrms.model.AppraisalHistory;
import com.ax.hrms.model.AppraisalHistoryTable;
import com.ax.hrms.model.impl.AppraisalHistoryImpl;
import com.ax.hrms.model.impl.AppraisalHistoryModelImpl;
import com.ax.hrms.service.persistence.AppraisalHistoryPersistence;
import com.ax.hrms.service.persistence.AppraisalHistoryUtil;
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
 * The persistence implementation for the appraisal history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AppraisalHistoryPersistence.class)
public class AppraisalHistoryPersistenceImpl
	extends BasePersistenceImpl<AppraisalHistory>
	implements AppraisalHistoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AppraisalHistoryUtil</code> to access the appraisal history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AppraisalHistoryImpl.class.getName();

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
	 * Returns all the appraisal histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching appraisal histories
	 */
	@Override
	public List<AppraisalHistory> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal histories
	 * @param end the upper bound of the range of appraisal histories (not inclusive)
	 * @return the range of matching appraisal histories
	 */
	@Override
	public List<AppraisalHistory> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal histories
	 * @param end the upper bound of the range of appraisal histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal histories
	 */
	@Override
	public List<AppraisalHistory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppraisalHistory> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal histories
	 * @param end the upper bound of the range of appraisal histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal histories
	 */
	@Override
	public List<AppraisalHistory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppraisalHistory> orderByComparator,
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

		List<AppraisalHistory> list = null;

		if (useFinderCache) {
			list = (List<AppraisalHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppraisalHistory appraisalHistory : list) {
					if (!uuid.equals(appraisalHistory.getUuid())) {
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

			sb.append(_SQL_SELECT_APPRAISALHISTORY_WHERE);

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
				sb.append(AppraisalHistoryModelImpl.ORDER_BY_JPQL);
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

				list = (List<AppraisalHistory>)QueryUtil.list(
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
	 * Returns the first appraisal history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal history
	 * @throws NoSuchAppraisalHistoryException if a matching appraisal history could not be found
	 */
	@Override
	public AppraisalHistory findByUuid_First(
			String uuid, OrderByComparator<AppraisalHistory> orderByComparator)
		throws NoSuchAppraisalHistoryException {

		AppraisalHistory appraisalHistory = fetchByUuid_First(
			uuid, orderByComparator);

		if (appraisalHistory != null) {
			return appraisalHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAppraisalHistoryException(sb.toString());
	}

	/**
	 * Returns the first appraisal history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal history, or <code>null</code> if a matching appraisal history could not be found
	 */
	@Override
	public AppraisalHistory fetchByUuid_First(
		String uuid, OrderByComparator<AppraisalHistory> orderByComparator) {

		List<AppraisalHistory> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appraisal history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal history
	 * @throws NoSuchAppraisalHistoryException if a matching appraisal history could not be found
	 */
	@Override
	public AppraisalHistory findByUuid_Last(
			String uuid, OrderByComparator<AppraisalHistory> orderByComparator)
		throws NoSuchAppraisalHistoryException {

		AppraisalHistory appraisalHistory = fetchByUuid_Last(
			uuid, orderByComparator);

		if (appraisalHistory != null) {
			return appraisalHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAppraisalHistoryException(sb.toString());
	}

	/**
	 * Returns the last appraisal history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal history, or <code>null</code> if a matching appraisal history could not be found
	 */
	@Override
	public AppraisalHistory fetchByUuid_Last(
		String uuid, OrderByComparator<AppraisalHistory> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AppraisalHistory> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appraisal histories before and after the current appraisal history in the ordered set where uuid = &#63;.
	 *
	 * @param appraisalId the primary key of the current appraisal history
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal history
	 * @throws NoSuchAppraisalHistoryException if a appraisal history with the primary key could not be found
	 */
	@Override
	public AppraisalHistory[] findByUuid_PrevAndNext(
			long appraisalId, String uuid,
			OrderByComparator<AppraisalHistory> orderByComparator)
		throws NoSuchAppraisalHistoryException {

		uuid = Objects.toString(uuid, "");

		AppraisalHistory appraisalHistory = findByPrimaryKey(appraisalId);

		Session session = null;

		try {
			session = openSession();

			AppraisalHistory[] array = new AppraisalHistoryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, appraisalHistory, uuid, orderByComparator, true);

			array[1] = appraisalHistory;

			array[2] = getByUuid_PrevAndNext(
				session, appraisalHistory, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AppraisalHistory getByUuid_PrevAndNext(
		Session session, AppraisalHistory appraisalHistory, String uuid,
		OrderByComparator<AppraisalHistory> orderByComparator,
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

		sb.append(_SQL_SELECT_APPRAISALHISTORY_WHERE);

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
			sb.append(AppraisalHistoryModelImpl.ORDER_BY_JPQL);
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
						appraisalHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppraisalHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appraisal histories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AppraisalHistory appraisalHistory :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(appraisalHistory);
		}
	}

	/**
	 * Returns the number of appraisal histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching appraisal histories
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APPRAISALHISTORY_WHERE);

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
		"appraisalHistory.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(appraisalHistory.uuid IS NULL OR appraisalHistory.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the appraisal history where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAppraisalHistoryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal history
	 * @throws NoSuchAppraisalHistoryException if a matching appraisal history could not be found
	 */
	@Override
	public AppraisalHistory findByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalHistoryException {

		AppraisalHistory appraisalHistory = fetchByUUID_G(uuid, groupId);

		if (appraisalHistory == null) {
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

			throw new NoSuchAppraisalHistoryException(sb.toString());
		}

		return appraisalHistory;
	}

	/**
	 * Returns the appraisal history where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal history, or <code>null</code> if a matching appraisal history could not be found
	 */
	@Override
	public AppraisalHistory fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the appraisal history where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal history, or <code>null</code> if a matching appraisal history could not be found
	 */
	@Override
	public AppraisalHistory fetchByUUID_G(
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

		if (result instanceof AppraisalHistory) {
			AppraisalHistory appraisalHistory = (AppraisalHistory)result;

			if (!Objects.equals(uuid, appraisalHistory.getUuid()) ||
				(groupId != appraisalHistory.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_APPRAISALHISTORY_WHERE);

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

				List<AppraisalHistory> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					AppraisalHistory appraisalHistory = list.get(0);

					result = appraisalHistory;

					cacheResult(appraisalHistory);
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
			return (AppraisalHistory)result;
		}
	}

	/**
	 * Removes the appraisal history where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the appraisal history that was removed
	 */
	@Override
	public AppraisalHistory removeByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalHistoryException {

		AppraisalHistory appraisalHistory = findByUUID_G(uuid, groupId);

		return remove(appraisalHistory);
	}

	/**
	 * Returns the number of appraisal histories where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching appraisal histories
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		AppraisalHistory appraisalHistory = fetchByUUID_G(uuid, groupId);

		if (appraisalHistory == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"appraisalHistory.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(appraisalHistory.uuid IS NULL OR appraisalHistory.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"appraisalHistory.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the appraisal histories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching appraisal histories
	 */
	@Override
	public List<AppraisalHistory> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal histories
	 * @param end the upper bound of the range of appraisal histories (not inclusive)
	 * @return the range of matching appraisal histories
	 */
	@Override
	public List<AppraisalHistory> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal histories
	 * @param end the upper bound of the range of appraisal histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal histories
	 */
	@Override
	public List<AppraisalHistory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalHistory> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal histories
	 * @param end the upper bound of the range of appraisal histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal histories
	 */
	@Override
	public List<AppraisalHistory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalHistory> orderByComparator,
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

		List<AppraisalHistory> list = null;

		if (useFinderCache) {
			list = (List<AppraisalHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppraisalHistory appraisalHistory : list) {
					if (!uuid.equals(appraisalHistory.getUuid()) ||
						(companyId != appraisalHistory.getCompanyId())) {

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

			sb.append(_SQL_SELECT_APPRAISALHISTORY_WHERE);

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
				sb.append(AppraisalHistoryModelImpl.ORDER_BY_JPQL);
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

				list = (List<AppraisalHistory>)QueryUtil.list(
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
	 * Returns the first appraisal history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal history
	 * @throws NoSuchAppraisalHistoryException if a matching appraisal history could not be found
	 */
	@Override
	public AppraisalHistory findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AppraisalHistory> orderByComparator)
		throws NoSuchAppraisalHistoryException {

		AppraisalHistory appraisalHistory = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (appraisalHistory != null) {
			return appraisalHistory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAppraisalHistoryException(sb.toString());
	}

	/**
	 * Returns the first appraisal history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal history, or <code>null</code> if a matching appraisal history could not be found
	 */
	@Override
	public AppraisalHistory fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AppraisalHistory> orderByComparator) {

		List<AppraisalHistory> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appraisal history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal history
	 * @throws NoSuchAppraisalHistoryException if a matching appraisal history could not be found
	 */
	@Override
	public AppraisalHistory findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AppraisalHistory> orderByComparator)
		throws NoSuchAppraisalHistoryException {

		AppraisalHistory appraisalHistory = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (appraisalHistory != null) {
			return appraisalHistory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAppraisalHistoryException(sb.toString());
	}

	/**
	 * Returns the last appraisal history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal history, or <code>null</code> if a matching appraisal history could not be found
	 */
	@Override
	public AppraisalHistory fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AppraisalHistory> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AppraisalHistory> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appraisal histories before and after the current appraisal history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param appraisalId the primary key of the current appraisal history
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal history
	 * @throws NoSuchAppraisalHistoryException if a appraisal history with the primary key could not be found
	 */
	@Override
	public AppraisalHistory[] findByUuid_C_PrevAndNext(
			long appraisalId, String uuid, long companyId,
			OrderByComparator<AppraisalHistory> orderByComparator)
		throws NoSuchAppraisalHistoryException {

		uuid = Objects.toString(uuid, "");

		AppraisalHistory appraisalHistory = findByPrimaryKey(appraisalId);

		Session session = null;

		try {
			session = openSession();

			AppraisalHistory[] array = new AppraisalHistoryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, appraisalHistory, uuid, companyId, orderByComparator,
				true);

			array[1] = appraisalHistory;

			array[2] = getByUuid_C_PrevAndNext(
				session, appraisalHistory, uuid, companyId, orderByComparator,
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

	protected AppraisalHistory getByUuid_C_PrevAndNext(
		Session session, AppraisalHistory appraisalHistory, String uuid,
		long companyId, OrderByComparator<AppraisalHistory> orderByComparator,
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

		sb.append(_SQL_SELECT_APPRAISALHISTORY_WHERE);

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
			sb.append(AppraisalHistoryModelImpl.ORDER_BY_JPQL);
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
						appraisalHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AppraisalHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appraisal histories where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AppraisalHistory appraisalHistory :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(appraisalHistory);
		}
	}

	/**
	 * Returns the number of appraisal histories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching appraisal histories
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_APPRAISALHISTORY_WHERE);

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
		"appraisalHistory.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(appraisalHistory.uuid IS NULL OR appraisalHistory.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"appraisalHistory.companyId = ?";

	public AppraisalHistoryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AppraisalHistory.class);

		setModelImplClass(AppraisalHistoryImpl.class);
		setModelPKClass(long.class);

		setTable(AppraisalHistoryTable.INSTANCE);
	}

	/**
	 * Caches the appraisal history in the entity cache if it is enabled.
	 *
	 * @param appraisalHistory the appraisal history
	 */
	@Override
	public void cacheResult(AppraisalHistory appraisalHistory) {
		entityCache.putResult(
			AppraisalHistoryImpl.class, appraisalHistory.getPrimaryKey(),
			appraisalHistory);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				appraisalHistory.getUuid(), appraisalHistory.getGroupId()
			},
			appraisalHistory);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the appraisal histories in the entity cache if it is enabled.
	 *
	 * @param appraisalHistories the appraisal histories
	 */
	@Override
	public void cacheResult(List<AppraisalHistory> appraisalHistories) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (appraisalHistories.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AppraisalHistory appraisalHistory : appraisalHistories) {
			if (entityCache.getResult(
					AppraisalHistoryImpl.class,
					appraisalHistory.getPrimaryKey()) == null) {

				cacheResult(appraisalHistory);
			}
		}
	}

	/**
	 * Clears the cache for all appraisal histories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AppraisalHistoryImpl.class);

		finderCache.clearCache(AppraisalHistoryImpl.class);
	}

	/**
	 * Clears the cache for the appraisal history.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AppraisalHistory appraisalHistory) {
		entityCache.removeResult(AppraisalHistoryImpl.class, appraisalHistory);
	}

	@Override
	public void clearCache(List<AppraisalHistory> appraisalHistories) {
		for (AppraisalHistory appraisalHistory : appraisalHistories) {
			entityCache.removeResult(
				AppraisalHistoryImpl.class, appraisalHistory);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AppraisalHistoryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AppraisalHistoryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AppraisalHistoryModelImpl appraisalHistoryModelImpl) {

		Object[] args = new Object[] {
			appraisalHistoryModelImpl.getUuid(),
			appraisalHistoryModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, appraisalHistoryModelImpl);
	}

	/**
	 * Creates a new appraisal history with the primary key. Does not add the appraisal history to the database.
	 *
	 * @param appraisalId the primary key for the new appraisal history
	 * @return the new appraisal history
	 */
	@Override
	public AppraisalHistory create(long appraisalId) {
		AppraisalHistory appraisalHistory = new AppraisalHistoryImpl();

		appraisalHistory.setNew(true);
		appraisalHistory.setPrimaryKey(appraisalId);

		String uuid = PortalUUIDUtil.generate();

		appraisalHistory.setUuid(uuid);

		appraisalHistory.setCompanyId(CompanyThreadLocal.getCompanyId());

		return appraisalHistory;
	}

	/**
	 * Removes the appraisal history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalId the primary key of the appraisal history
	 * @return the appraisal history that was removed
	 * @throws NoSuchAppraisalHistoryException if a appraisal history with the primary key could not be found
	 */
	@Override
	public AppraisalHistory remove(long appraisalId)
		throws NoSuchAppraisalHistoryException {

		return remove((Serializable)appraisalId);
	}

	/**
	 * Removes the appraisal history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the appraisal history
	 * @return the appraisal history that was removed
	 * @throws NoSuchAppraisalHistoryException if a appraisal history with the primary key could not be found
	 */
	@Override
	public AppraisalHistory remove(Serializable primaryKey)
		throws NoSuchAppraisalHistoryException {

		Session session = null;

		try {
			session = openSession();

			AppraisalHistory appraisalHistory = (AppraisalHistory)session.get(
				AppraisalHistoryImpl.class, primaryKey);

			if (appraisalHistory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppraisalHistoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(appraisalHistory);
		}
		catch (NoSuchAppraisalHistoryException noSuchEntityException) {
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
	protected AppraisalHistory removeImpl(AppraisalHistory appraisalHistory) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appraisalHistory)) {
				appraisalHistory = (AppraisalHistory)session.get(
					AppraisalHistoryImpl.class,
					appraisalHistory.getPrimaryKeyObj());
			}

			if (appraisalHistory != null) {
				session.delete(appraisalHistory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (appraisalHistory != null) {
			clearCache(appraisalHistory);
		}

		return appraisalHistory;
	}

	@Override
	public AppraisalHistory updateImpl(AppraisalHistory appraisalHistory) {
		boolean isNew = appraisalHistory.isNew();

		if (!(appraisalHistory instanceof AppraisalHistoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(appraisalHistory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					appraisalHistory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in appraisalHistory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AppraisalHistory implementation " +
					appraisalHistory.getClass());
		}

		AppraisalHistoryModelImpl appraisalHistoryModelImpl =
			(AppraisalHistoryModelImpl)appraisalHistory;

		if (Validator.isNull(appraisalHistory.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			appraisalHistory.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (appraisalHistory.getCreateDate() == null)) {
			if (serviceContext == null) {
				appraisalHistory.setCreateDate(date);
			}
			else {
				appraisalHistory.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!appraisalHistoryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				appraisalHistory.setModifiedDate(date);
			}
			else {
				appraisalHistory.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(appraisalHistory);
			}
			else {
				appraisalHistory = (AppraisalHistory)session.merge(
					appraisalHistory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AppraisalHistoryImpl.class, appraisalHistoryModelImpl, false, true);

		cacheUniqueFindersCache(appraisalHistoryModelImpl);

		if (isNew) {
			appraisalHistory.setNew(false);
		}

		appraisalHistory.resetOriginalValues();

		return appraisalHistory;
	}

	/**
	 * Returns the appraisal history with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the appraisal history
	 * @return the appraisal history
	 * @throws NoSuchAppraisalHistoryException if a appraisal history with the primary key could not be found
	 */
	@Override
	public AppraisalHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppraisalHistoryException {

		AppraisalHistory appraisalHistory = fetchByPrimaryKey(primaryKey);

		if (appraisalHistory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppraisalHistoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return appraisalHistory;
	}

	/**
	 * Returns the appraisal history with the primary key or throws a <code>NoSuchAppraisalHistoryException</code> if it could not be found.
	 *
	 * @param appraisalId the primary key of the appraisal history
	 * @return the appraisal history
	 * @throws NoSuchAppraisalHistoryException if a appraisal history with the primary key could not be found
	 */
	@Override
	public AppraisalHistory findByPrimaryKey(long appraisalId)
		throws NoSuchAppraisalHistoryException {

		return findByPrimaryKey((Serializable)appraisalId);
	}

	/**
	 * Returns the appraisal history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalId the primary key of the appraisal history
	 * @return the appraisal history, or <code>null</code> if a appraisal history with the primary key could not be found
	 */
	@Override
	public AppraisalHistory fetchByPrimaryKey(long appraisalId) {
		return fetchByPrimaryKey((Serializable)appraisalId);
	}

	/**
	 * Returns all the appraisal histories.
	 *
	 * @return the appraisal histories
	 */
	@Override
	public List<AppraisalHistory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal histories
	 * @param end the upper bound of the range of appraisal histories (not inclusive)
	 * @return the range of appraisal histories
	 */
	@Override
	public List<AppraisalHistory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal histories
	 * @param end the upper bound of the range of appraisal histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appraisal histories
	 */
	@Override
	public List<AppraisalHistory> findAll(
		int start, int end,
		OrderByComparator<AppraisalHistory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal histories
	 * @param end the upper bound of the range of appraisal histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of appraisal histories
	 */
	@Override
	public List<AppraisalHistory> findAll(
		int start, int end,
		OrderByComparator<AppraisalHistory> orderByComparator,
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

		List<AppraisalHistory> list = null;

		if (useFinderCache) {
			list = (List<AppraisalHistory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_APPRAISALHISTORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_APPRAISALHISTORY;

				sql = sql.concat(AppraisalHistoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AppraisalHistory>)QueryUtil.list(
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
	 * Removes all the appraisal histories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AppraisalHistory appraisalHistory : findAll()) {
			remove(appraisalHistory);
		}
	}

	/**
	 * Returns the number of appraisal histories.
	 *
	 * @return the number of appraisal histories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_APPRAISALHISTORY);

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
		return "appraisalId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_APPRAISALHISTORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AppraisalHistoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the appraisal history persistence.
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

		AppraisalHistoryUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AppraisalHistoryUtil.setPersistence(null);

		entityCache.removeCache(AppraisalHistoryImpl.class.getName());
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

	private static final String _SQL_SELECT_APPRAISALHISTORY =
		"SELECT appraisalHistory FROM AppraisalHistory appraisalHistory";

	private static final String _SQL_SELECT_APPRAISALHISTORY_WHERE =
		"SELECT appraisalHistory FROM AppraisalHistory appraisalHistory WHERE ";

	private static final String _SQL_COUNT_APPRAISALHISTORY =
		"SELECT COUNT(appraisalHistory) FROM AppraisalHistory appraisalHistory";

	private static final String _SQL_COUNT_APPRAISALHISTORY_WHERE =
		"SELECT COUNT(appraisalHistory) FROM AppraisalHistory appraisalHistory WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "appraisalHistory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AppraisalHistory exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AppraisalHistory exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AppraisalHistoryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}