/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence.impl;

import com.ax.hrms.exception.NoSuchTaskReviewException;
import com.ax.hrms.model.TaskReview;
import com.ax.hrms.model.TaskReviewTable;
import com.ax.hrms.model.impl.TaskReviewImpl;
import com.ax.hrms.model.impl.TaskReviewModelImpl;
import com.ax.hrms.service.persistence.TaskReviewPersistence;
import com.ax.hrms.service.persistence.TaskReviewUtil;
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
 * The persistence implementation for the task review service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TaskReviewPersistence.class)
public class TaskReviewPersistenceImpl
	extends BasePersistenceImpl<TaskReview> implements TaskReviewPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TaskReviewUtil</code> to access the task review persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TaskReviewImpl.class.getName();

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
	 * Returns all the task reviews where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching task reviews
	 */
	@Override
	public List<TaskReview> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the task reviews where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskReviewModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of task reviews
	 * @param end the upper bound of the range of task reviews (not inclusive)
	 * @return the range of matching task reviews
	 */
	@Override
	public List<TaskReview> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the task reviews where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskReviewModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of task reviews
	 * @param end the upper bound of the range of task reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching task reviews
	 */
	@Override
	public List<TaskReview> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TaskReview> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the task reviews where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskReviewModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of task reviews
	 * @param end the upper bound of the range of task reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching task reviews
	 */
	@Override
	public List<TaskReview> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TaskReview> orderByComparator,
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

		List<TaskReview> list = null;

		if (useFinderCache) {
			list = (List<TaskReview>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TaskReview taskReview : list) {
					if (!uuid.equals(taskReview.getUuid())) {
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

			sb.append(_SQL_SELECT_TASKREVIEW_WHERE);

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
				sb.append(TaskReviewModelImpl.ORDER_BY_JPQL);
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

				list = (List<TaskReview>)QueryUtil.list(
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
	 * Returns the first task review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	@Override
	public TaskReview findByUuid_First(
			String uuid, OrderByComparator<TaskReview> orderByComparator)
		throws NoSuchTaskReviewException {

		TaskReview taskReview = fetchByUuid_First(uuid, orderByComparator);

		if (taskReview != null) {
			return taskReview;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTaskReviewException(sb.toString());
	}

	/**
	 * Returns the first task review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review, or <code>null</code> if a matching task review could not be found
	 */
	@Override
	public TaskReview fetchByUuid_First(
		String uuid, OrderByComparator<TaskReview> orderByComparator) {

		List<TaskReview> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last task review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	@Override
	public TaskReview findByUuid_Last(
			String uuid, OrderByComparator<TaskReview> orderByComparator)
		throws NoSuchTaskReviewException {

		TaskReview taskReview = fetchByUuid_Last(uuid, orderByComparator);

		if (taskReview != null) {
			return taskReview;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTaskReviewException(sb.toString());
	}

	/**
	 * Returns the last task review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review, or <code>null</code> if a matching task review could not be found
	 */
	@Override
	public TaskReview fetchByUuid_Last(
		String uuid, OrderByComparator<TaskReview> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TaskReview> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the task reviews before and after the current task review in the ordered set where uuid = &#63;.
	 *
	 * @param taskReviewId the primary key of the current task review
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task review
	 * @throws NoSuchTaskReviewException if a task review with the primary key could not be found
	 */
	@Override
	public TaskReview[] findByUuid_PrevAndNext(
			long taskReviewId, String uuid,
			OrderByComparator<TaskReview> orderByComparator)
		throws NoSuchTaskReviewException {

		uuid = Objects.toString(uuid, "");

		TaskReview taskReview = findByPrimaryKey(taskReviewId);

		Session session = null;

		try {
			session = openSession();

			TaskReview[] array = new TaskReviewImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, taskReview, uuid, orderByComparator, true);

			array[1] = taskReview;

			array[2] = getByUuid_PrevAndNext(
				session, taskReview, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TaskReview getByUuid_PrevAndNext(
		Session session, TaskReview taskReview, String uuid,
		OrderByComparator<TaskReview> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TASKREVIEW_WHERE);

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
			sb.append(TaskReviewModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(taskReview)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TaskReview> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the task reviews where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TaskReview taskReview :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(taskReview);
		}
	}

	/**
	 * Returns the number of task reviews where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching task reviews
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TASKREVIEW_WHERE);

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
		"taskReview.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(taskReview.uuid IS NULL OR taskReview.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the task review where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTaskReviewException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	@Override
	public TaskReview findByUUID_G(String uuid, long groupId)
		throws NoSuchTaskReviewException {

		TaskReview taskReview = fetchByUUID_G(uuid, groupId);

		if (taskReview == null) {
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

			throw new NoSuchTaskReviewException(sb.toString());
		}

		return taskReview;
	}

	/**
	 * Returns the task review where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching task review, or <code>null</code> if a matching task review could not be found
	 */
	@Override
	public TaskReview fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the task review where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching task review, or <code>null</code> if a matching task review could not be found
	 */
	@Override
	public TaskReview fetchByUUID_G(
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

		if (result instanceof TaskReview) {
			TaskReview taskReview = (TaskReview)result;

			if (!Objects.equals(uuid, taskReview.getUuid()) ||
				(groupId != taskReview.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TASKREVIEW_WHERE);

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

				List<TaskReview> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					TaskReview taskReview = list.get(0);

					result = taskReview;

					cacheResult(taskReview);
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
			return (TaskReview)result;
		}
	}

	/**
	 * Removes the task review where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the task review that was removed
	 */
	@Override
	public TaskReview removeByUUID_G(String uuid, long groupId)
		throws NoSuchTaskReviewException {

		TaskReview taskReview = findByUUID_G(uuid, groupId);

		return remove(taskReview);
	}

	/**
	 * Returns the number of task reviews where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching task reviews
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TASKREVIEW_WHERE);

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
		"taskReview.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(taskReview.uuid IS NULL OR taskReview.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"taskReview.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the task reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching task reviews
	 */
	@Override
	public List<TaskReview> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the task reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskReviewModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of task reviews
	 * @param end the upper bound of the range of task reviews (not inclusive)
	 * @return the range of matching task reviews
	 */
	@Override
	public List<TaskReview> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the task reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskReviewModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of task reviews
	 * @param end the upper bound of the range of task reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching task reviews
	 */
	@Override
	public List<TaskReview> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TaskReview> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the task reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskReviewModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of task reviews
	 * @param end the upper bound of the range of task reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching task reviews
	 */
	@Override
	public List<TaskReview> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TaskReview> orderByComparator,
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

		List<TaskReview> list = null;

		if (useFinderCache) {
			list = (List<TaskReview>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TaskReview taskReview : list) {
					if (!uuid.equals(taskReview.getUuid()) ||
						(companyId != taskReview.getCompanyId())) {

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

			sb.append(_SQL_SELECT_TASKREVIEW_WHERE);

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
				sb.append(TaskReviewModelImpl.ORDER_BY_JPQL);
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

				list = (List<TaskReview>)QueryUtil.list(
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
	 * Returns the first task review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	@Override
	public TaskReview findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TaskReview> orderByComparator)
		throws NoSuchTaskReviewException {

		TaskReview taskReview = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (taskReview != null) {
			return taskReview;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTaskReviewException(sb.toString());
	}

	/**
	 * Returns the first task review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review, or <code>null</code> if a matching task review could not be found
	 */
	@Override
	public TaskReview fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TaskReview> orderByComparator) {

		List<TaskReview> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last task review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	@Override
	public TaskReview findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TaskReview> orderByComparator)
		throws NoSuchTaskReviewException {

		TaskReview taskReview = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (taskReview != null) {
			return taskReview;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTaskReviewException(sb.toString());
	}

	/**
	 * Returns the last task review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review, or <code>null</code> if a matching task review could not be found
	 */
	@Override
	public TaskReview fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TaskReview> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TaskReview> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the task reviews before and after the current task review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param taskReviewId the primary key of the current task review
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task review
	 * @throws NoSuchTaskReviewException if a task review with the primary key could not be found
	 */
	@Override
	public TaskReview[] findByUuid_C_PrevAndNext(
			long taskReviewId, String uuid, long companyId,
			OrderByComparator<TaskReview> orderByComparator)
		throws NoSuchTaskReviewException {

		uuid = Objects.toString(uuid, "");

		TaskReview taskReview = findByPrimaryKey(taskReviewId);

		Session session = null;

		try {
			session = openSession();

			TaskReview[] array = new TaskReviewImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, taskReview, uuid, companyId, orderByComparator, true);

			array[1] = taskReview;

			array[2] = getByUuid_C_PrevAndNext(
				session, taskReview, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TaskReview getByUuid_C_PrevAndNext(
		Session session, TaskReview taskReview, String uuid, long companyId,
		OrderByComparator<TaskReview> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TASKREVIEW_WHERE);

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
			sb.append(TaskReviewModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(taskReview)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TaskReview> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the task reviews where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TaskReview taskReview :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(taskReview);
		}
	}

	/**
	 * Returns the number of task reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching task reviews
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TASKREVIEW_WHERE);

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
		"taskReview.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(taskReview.uuid IS NULL OR taskReview.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"taskReview.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByTaskId;
	private FinderPath _finderPathWithoutPaginationFindByTaskId;
	private FinderPath _finderPathCountByTaskId;

	/**
	 * Returns all the task reviews where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching task reviews
	 */
	@Override
	public List<TaskReview> findByTaskId(long taskId) {
		return findByTaskId(taskId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the task reviews where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskReviewModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of task reviews
	 * @param end the upper bound of the range of task reviews (not inclusive)
	 * @return the range of matching task reviews
	 */
	@Override
	public List<TaskReview> findByTaskId(long taskId, int start, int end) {
		return findByTaskId(taskId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the task reviews where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskReviewModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of task reviews
	 * @param end the upper bound of the range of task reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching task reviews
	 */
	@Override
	public List<TaskReview> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<TaskReview> orderByComparator) {

		return findByTaskId(taskId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the task reviews where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskReviewModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of task reviews
	 * @param end the upper bound of the range of task reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching task reviews
	 */
	@Override
	public List<TaskReview> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<TaskReview> orderByComparator,
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

		List<TaskReview> list = null;

		if (useFinderCache) {
			list = (List<TaskReview>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TaskReview taskReview : list) {
					if (taskId != taskReview.getTaskId()) {
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

			sb.append(_SQL_SELECT_TASKREVIEW_WHERE);

			sb.append(_FINDER_COLUMN_TASKID_TASKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TaskReviewModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(taskId);

				list = (List<TaskReview>)QueryUtil.list(
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
	 * Returns the first task review in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	@Override
	public TaskReview findByTaskId_First(
			long taskId, OrderByComparator<TaskReview> orderByComparator)
		throws NoSuchTaskReviewException {

		TaskReview taskReview = fetchByTaskId_First(taskId, orderByComparator);

		if (taskReview != null) {
			return taskReview;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taskId=");
		sb.append(taskId);

		sb.append("}");

		throw new NoSuchTaskReviewException(sb.toString());
	}

	/**
	 * Returns the first task review in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review, or <code>null</code> if a matching task review could not be found
	 */
	@Override
	public TaskReview fetchByTaskId_First(
		long taskId, OrderByComparator<TaskReview> orderByComparator) {

		List<TaskReview> list = findByTaskId(taskId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last task review in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	@Override
	public TaskReview findByTaskId_Last(
			long taskId, OrderByComparator<TaskReview> orderByComparator)
		throws NoSuchTaskReviewException {

		TaskReview taskReview = fetchByTaskId_Last(taskId, orderByComparator);

		if (taskReview != null) {
			return taskReview;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taskId=");
		sb.append(taskId);

		sb.append("}");

		throw new NoSuchTaskReviewException(sb.toString());
	}

	/**
	 * Returns the last task review in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review, or <code>null</code> if a matching task review could not be found
	 */
	@Override
	public TaskReview fetchByTaskId_Last(
		long taskId, OrderByComparator<TaskReview> orderByComparator) {

		int count = countByTaskId(taskId);

		if (count == 0) {
			return null;
		}

		List<TaskReview> list = findByTaskId(
			taskId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the task reviews before and after the current task review in the ordered set where taskId = &#63;.
	 *
	 * @param taskReviewId the primary key of the current task review
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task review
	 * @throws NoSuchTaskReviewException if a task review with the primary key could not be found
	 */
	@Override
	public TaskReview[] findByTaskId_PrevAndNext(
			long taskReviewId, long taskId,
			OrderByComparator<TaskReview> orderByComparator)
		throws NoSuchTaskReviewException {

		TaskReview taskReview = findByPrimaryKey(taskReviewId);

		Session session = null;

		try {
			session = openSession();

			TaskReview[] array = new TaskReviewImpl[3];

			array[0] = getByTaskId_PrevAndNext(
				session, taskReview, taskId, orderByComparator, true);

			array[1] = taskReview;

			array[2] = getByTaskId_PrevAndNext(
				session, taskReview, taskId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TaskReview getByTaskId_PrevAndNext(
		Session session, TaskReview taskReview, long taskId,
		OrderByComparator<TaskReview> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TASKREVIEW_WHERE);

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
			sb.append(TaskReviewModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(taskId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(taskReview)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TaskReview> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the task reviews where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 */
	@Override
	public void removeByTaskId(long taskId) {
		for (TaskReview taskReview :
				findByTaskId(
					taskId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(taskReview);
		}
	}

	/**
	 * Returns the number of task reviews where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching task reviews
	 */
	@Override
	public int countByTaskId(long taskId) {
		FinderPath finderPath = _finderPathCountByTaskId;

		Object[] finderArgs = new Object[] {taskId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TASKREVIEW_WHERE);

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
		"taskReview.taskId = ?";

	private FinderPath _finderPathWithPaginationFindByReviewerId;
	private FinderPath _finderPathWithoutPaginationFindByReviewerId;
	private FinderPath _finderPathCountByReviewerId;

	/**
	 * Returns all the task reviews where reviewerId = &#63;.
	 *
	 * @param reviewerId the reviewer ID
	 * @return the matching task reviews
	 */
	@Override
	public List<TaskReview> findByReviewerId(long reviewerId) {
		return findByReviewerId(
			reviewerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the task reviews where reviewerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskReviewModelImpl</code>.
	 * </p>
	 *
	 * @param reviewerId the reviewer ID
	 * @param start the lower bound of the range of task reviews
	 * @param end the upper bound of the range of task reviews (not inclusive)
	 * @return the range of matching task reviews
	 */
	@Override
	public List<TaskReview> findByReviewerId(
		long reviewerId, int start, int end) {

		return findByReviewerId(reviewerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the task reviews where reviewerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskReviewModelImpl</code>.
	 * </p>
	 *
	 * @param reviewerId the reviewer ID
	 * @param start the lower bound of the range of task reviews
	 * @param end the upper bound of the range of task reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching task reviews
	 */
	@Override
	public List<TaskReview> findByReviewerId(
		long reviewerId, int start, int end,
		OrderByComparator<TaskReview> orderByComparator) {

		return findByReviewerId(
			reviewerId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the task reviews where reviewerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskReviewModelImpl</code>.
	 * </p>
	 *
	 * @param reviewerId the reviewer ID
	 * @param start the lower bound of the range of task reviews
	 * @param end the upper bound of the range of task reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching task reviews
	 */
	@Override
	public List<TaskReview> findByReviewerId(
		long reviewerId, int start, int end,
		OrderByComparator<TaskReview> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByReviewerId;
				finderArgs = new Object[] {reviewerId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByReviewerId;
			finderArgs = new Object[] {
				reviewerId, start, end, orderByComparator
			};
		}

		List<TaskReview> list = null;

		if (useFinderCache) {
			list = (List<TaskReview>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TaskReview taskReview : list) {
					if (reviewerId != taskReview.getReviewerId()) {
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

			sb.append(_SQL_SELECT_TASKREVIEW_WHERE);

			sb.append(_FINDER_COLUMN_REVIEWERID_REVIEWERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TaskReviewModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(reviewerId);

				list = (List<TaskReview>)QueryUtil.list(
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
	 * Returns the first task review in the ordered set where reviewerId = &#63;.
	 *
	 * @param reviewerId the reviewer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	@Override
	public TaskReview findByReviewerId_First(
			long reviewerId, OrderByComparator<TaskReview> orderByComparator)
		throws NoSuchTaskReviewException {

		TaskReview taskReview = fetchByReviewerId_First(
			reviewerId, orderByComparator);

		if (taskReview != null) {
			return taskReview;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("reviewerId=");
		sb.append(reviewerId);

		sb.append("}");

		throw new NoSuchTaskReviewException(sb.toString());
	}

	/**
	 * Returns the first task review in the ordered set where reviewerId = &#63;.
	 *
	 * @param reviewerId the reviewer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review, or <code>null</code> if a matching task review could not be found
	 */
	@Override
	public TaskReview fetchByReviewerId_First(
		long reviewerId, OrderByComparator<TaskReview> orderByComparator) {

		List<TaskReview> list = findByReviewerId(
			reviewerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last task review in the ordered set where reviewerId = &#63;.
	 *
	 * @param reviewerId the reviewer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	@Override
	public TaskReview findByReviewerId_Last(
			long reviewerId, OrderByComparator<TaskReview> orderByComparator)
		throws NoSuchTaskReviewException {

		TaskReview taskReview = fetchByReviewerId_Last(
			reviewerId, orderByComparator);

		if (taskReview != null) {
			return taskReview;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("reviewerId=");
		sb.append(reviewerId);

		sb.append("}");

		throw new NoSuchTaskReviewException(sb.toString());
	}

	/**
	 * Returns the last task review in the ordered set where reviewerId = &#63;.
	 *
	 * @param reviewerId the reviewer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review, or <code>null</code> if a matching task review could not be found
	 */
	@Override
	public TaskReview fetchByReviewerId_Last(
		long reviewerId, OrderByComparator<TaskReview> orderByComparator) {

		int count = countByReviewerId(reviewerId);

		if (count == 0) {
			return null;
		}

		List<TaskReview> list = findByReviewerId(
			reviewerId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the task reviews before and after the current task review in the ordered set where reviewerId = &#63;.
	 *
	 * @param taskReviewId the primary key of the current task review
	 * @param reviewerId the reviewer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task review
	 * @throws NoSuchTaskReviewException if a task review with the primary key could not be found
	 */
	@Override
	public TaskReview[] findByReviewerId_PrevAndNext(
			long taskReviewId, long reviewerId,
			OrderByComparator<TaskReview> orderByComparator)
		throws NoSuchTaskReviewException {

		TaskReview taskReview = findByPrimaryKey(taskReviewId);

		Session session = null;

		try {
			session = openSession();

			TaskReview[] array = new TaskReviewImpl[3];

			array[0] = getByReviewerId_PrevAndNext(
				session, taskReview, reviewerId, orderByComparator, true);

			array[1] = taskReview;

			array[2] = getByReviewerId_PrevAndNext(
				session, taskReview, reviewerId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TaskReview getByReviewerId_PrevAndNext(
		Session session, TaskReview taskReview, long reviewerId,
		OrderByComparator<TaskReview> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TASKREVIEW_WHERE);

		sb.append(_FINDER_COLUMN_REVIEWERID_REVIEWERID_2);

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
			sb.append(TaskReviewModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(reviewerId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(taskReview)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TaskReview> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the task reviews where reviewerId = &#63; from the database.
	 *
	 * @param reviewerId the reviewer ID
	 */
	@Override
	public void removeByReviewerId(long reviewerId) {
		for (TaskReview taskReview :
				findByReviewerId(
					reviewerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(taskReview);
		}
	}

	/**
	 * Returns the number of task reviews where reviewerId = &#63;.
	 *
	 * @param reviewerId the reviewer ID
	 * @return the number of matching task reviews
	 */
	@Override
	public int countByReviewerId(long reviewerId) {
		FinderPath finderPath = _finderPathCountByReviewerId;

		Object[] finderArgs = new Object[] {reviewerId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TASKREVIEW_WHERE);

			sb.append(_FINDER_COLUMN_REVIEWERID_REVIEWERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(reviewerId);

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

	private static final String _FINDER_COLUMN_REVIEWERID_REVIEWERID_2 =
		"taskReview.reviewerId = ?";

	public TaskReviewPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TaskReview.class);

		setModelImplClass(TaskReviewImpl.class);
		setModelPKClass(long.class);

		setTable(TaskReviewTable.INSTANCE);
	}

	/**
	 * Caches the task review in the entity cache if it is enabled.
	 *
	 * @param taskReview the task review
	 */
	@Override
	public void cacheResult(TaskReview taskReview) {
		entityCache.putResult(
			TaskReviewImpl.class, taskReview.getPrimaryKey(), taskReview);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {taskReview.getUuid(), taskReview.getGroupId()},
			taskReview);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the task reviews in the entity cache if it is enabled.
	 *
	 * @param taskReviews the task reviews
	 */
	@Override
	public void cacheResult(List<TaskReview> taskReviews) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (taskReviews.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TaskReview taskReview : taskReviews) {
			if (entityCache.getResult(
					TaskReviewImpl.class, taskReview.getPrimaryKey()) == null) {

				cacheResult(taskReview);
			}
		}
	}

	/**
	 * Clears the cache for all task reviews.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TaskReviewImpl.class);

		finderCache.clearCache(TaskReviewImpl.class);
	}

	/**
	 * Clears the cache for the task review.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaskReview taskReview) {
		entityCache.removeResult(TaskReviewImpl.class, taskReview);
	}

	@Override
	public void clearCache(List<TaskReview> taskReviews) {
		for (TaskReview taskReview : taskReviews) {
			entityCache.removeResult(TaskReviewImpl.class, taskReview);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TaskReviewImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TaskReviewImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TaskReviewModelImpl taskReviewModelImpl) {

		Object[] args = new Object[] {
			taskReviewModelImpl.getUuid(), taskReviewModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, taskReviewModelImpl);
	}

	/**
	 * Creates a new task review with the primary key. Does not add the task review to the database.
	 *
	 * @param taskReviewId the primary key for the new task review
	 * @return the new task review
	 */
	@Override
	public TaskReview create(long taskReviewId) {
		TaskReview taskReview = new TaskReviewImpl();

		taskReview.setNew(true);
		taskReview.setPrimaryKey(taskReviewId);

		String uuid = PortalUUIDUtil.generate();

		taskReview.setUuid(uuid);

		taskReview.setCompanyId(CompanyThreadLocal.getCompanyId());

		return taskReview;
	}

	/**
	 * Removes the task review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskReviewId the primary key of the task review
	 * @return the task review that was removed
	 * @throws NoSuchTaskReviewException if a task review with the primary key could not be found
	 */
	@Override
	public TaskReview remove(long taskReviewId)
		throws NoSuchTaskReviewException {

		return remove((Serializable)taskReviewId);
	}

	/**
	 * Removes the task review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the task review
	 * @return the task review that was removed
	 * @throws NoSuchTaskReviewException if a task review with the primary key could not be found
	 */
	@Override
	public TaskReview remove(Serializable primaryKey)
		throws NoSuchTaskReviewException {

		Session session = null;

		try {
			session = openSession();

			TaskReview taskReview = (TaskReview)session.get(
				TaskReviewImpl.class, primaryKey);

			if (taskReview == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaskReviewException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(taskReview);
		}
		catch (NoSuchTaskReviewException noSuchEntityException) {
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
	protected TaskReview removeImpl(TaskReview taskReview) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(taskReview)) {
				taskReview = (TaskReview)session.get(
					TaskReviewImpl.class, taskReview.getPrimaryKeyObj());
			}

			if (taskReview != null) {
				session.delete(taskReview);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (taskReview != null) {
			clearCache(taskReview);
		}

		return taskReview;
	}

	@Override
	public TaskReview updateImpl(TaskReview taskReview) {
		boolean isNew = taskReview.isNew();

		if (!(taskReview instanceof TaskReviewModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(taskReview.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(taskReview);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in taskReview proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TaskReview implementation " +
					taskReview.getClass());
		}

		TaskReviewModelImpl taskReviewModelImpl =
			(TaskReviewModelImpl)taskReview;

		if (Validator.isNull(taskReview.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			taskReview.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (taskReview.getCreateDate() == null)) {
			if (serviceContext == null) {
				taskReview.setCreateDate(date);
			}
			else {
				taskReview.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!taskReviewModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				taskReview.setModifiedDate(date);
			}
			else {
				taskReview.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(taskReview);
			}
			else {
				taskReview = (TaskReview)session.merge(taskReview);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TaskReviewImpl.class, taskReviewModelImpl, false, true);

		cacheUniqueFindersCache(taskReviewModelImpl);

		if (isNew) {
			taskReview.setNew(false);
		}

		taskReview.resetOriginalValues();

		return taskReview;
	}

	/**
	 * Returns the task review with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the task review
	 * @return the task review
	 * @throws NoSuchTaskReviewException if a task review with the primary key could not be found
	 */
	@Override
	public TaskReview findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTaskReviewException {

		TaskReview taskReview = fetchByPrimaryKey(primaryKey);

		if (taskReview == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTaskReviewException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return taskReview;
	}

	/**
	 * Returns the task review with the primary key or throws a <code>NoSuchTaskReviewException</code> if it could not be found.
	 *
	 * @param taskReviewId the primary key of the task review
	 * @return the task review
	 * @throws NoSuchTaskReviewException if a task review with the primary key could not be found
	 */
	@Override
	public TaskReview findByPrimaryKey(long taskReviewId)
		throws NoSuchTaskReviewException {

		return findByPrimaryKey((Serializable)taskReviewId);
	}

	/**
	 * Returns the task review with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskReviewId the primary key of the task review
	 * @return the task review, or <code>null</code> if a task review with the primary key could not be found
	 */
	@Override
	public TaskReview fetchByPrimaryKey(long taskReviewId) {
		return fetchByPrimaryKey((Serializable)taskReviewId);
	}

	/**
	 * Returns all the task reviews.
	 *
	 * @return the task reviews
	 */
	@Override
	public List<TaskReview> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the task reviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskReviewModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of task reviews
	 * @param end the upper bound of the range of task reviews (not inclusive)
	 * @return the range of task reviews
	 */
	@Override
	public List<TaskReview> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the task reviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskReviewModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of task reviews
	 * @param end the upper bound of the range of task reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of task reviews
	 */
	@Override
	public List<TaskReview> findAll(
		int start, int end, OrderByComparator<TaskReview> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the task reviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskReviewModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of task reviews
	 * @param end the upper bound of the range of task reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of task reviews
	 */
	@Override
	public List<TaskReview> findAll(
		int start, int end, OrderByComparator<TaskReview> orderByComparator,
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

		List<TaskReview> list = null;

		if (useFinderCache) {
			list = (List<TaskReview>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TASKREVIEW);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TASKREVIEW;

				sql = sql.concat(TaskReviewModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TaskReview>)QueryUtil.list(
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
	 * Removes all the task reviews from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TaskReview taskReview : findAll()) {
			remove(taskReview);
		}
	}

	/**
	 * Returns the number of task reviews.
	 *
	 * @return the number of task reviews
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TASKREVIEW);

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
		return "taskReviewId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TASKREVIEW;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TaskReviewModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the task review persistence.
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

		_finderPathWithPaginationFindByReviewerId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByReviewerId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"reviewerId"}, true);

		_finderPathWithoutPaginationFindByReviewerId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReviewerId",
			new String[] {Long.class.getName()}, new String[] {"reviewerId"},
			true);

		_finderPathCountByReviewerId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByReviewerId",
			new String[] {Long.class.getName()}, new String[] {"reviewerId"},
			false);

		TaskReviewUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		TaskReviewUtil.setPersistence(null);

		entityCache.removeCache(TaskReviewImpl.class.getName());
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

	private static final String _SQL_SELECT_TASKREVIEW =
		"SELECT taskReview FROM TaskReview taskReview";

	private static final String _SQL_SELECT_TASKREVIEW_WHERE =
		"SELECT taskReview FROM TaskReview taskReview WHERE ";

	private static final String _SQL_COUNT_TASKREVIEW =
		"SELECT COUNT(taskReview) FROM TaskReview taskReview";

	private static final String _SQL_COUNT_TASKREVIEW_WHERE =
		"SELECT COUNT(taskReview) FROM TaskReview taskReview WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "taskReview.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TaskReview exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TaskReview exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TaskReviewPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}