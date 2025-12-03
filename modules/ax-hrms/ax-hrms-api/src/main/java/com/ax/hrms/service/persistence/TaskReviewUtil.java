/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.TaskReview;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the task review service. This utility wraps <code>com.ax.hrms.service.persistence.impl.TaskReviewPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskReviewPersistence
 * @generated
 */
public class TaskReviewUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TaskReview taskReview) {
		getPersistence().clearCache(taskReview);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, TaskReview> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TaskReview> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TaskReview> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TaskReview> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TaskReview> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TaskReview update(TaskReview taskReview) {
		return getPersistence().update(taskReview);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TaskReview update(
		TaskReview taskReview, ServiceContext serviceContext) {

		return getPersistence().update(taskReview, serviceContext);
	}

	/**
	 * Returns all the task reviews where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching task reviews
	 */
	public static List<TaskReview> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<TaskReview> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<TaskReview> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TaskReview> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<TaskReview> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TaskReview> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first task review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	public static TaskReview findByUuid_First(
			String uuid, OrderByComparator<TaskReview> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTaskReviewException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first task review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review, or <code>null</code> if a matching task review could not be found
	 */
	public static TaskReview fetchByUuid_First(
		String uuid, OrderByComparator<TaskReview> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last task review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	public static TaskReview findByUuid_Last(
			String uuid, OrderByComparator<TaskReview> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTaskReviewException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last task review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review, or <code>null</code> if a matching task review could not be found
	 */
	public static TaskReview fetchByUuid_Last(
		String uuid, OrderByComparator<TaskReview> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static TaskReview[] findByUuid_PrevAndNext(
			long taskReviewId, String uuid,
			OrderByComparator<TaskReview> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTaskReviewException {

		return getPersistence().findByUuid_PrevAndNext(
			taskReviewId, uuid, orderByComparator);
	}

	/**
	 * Removes all the task reviews where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of task reviews where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching task reviews
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the task review where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTaskReviewException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	public static TaskReview findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchTaskReviewException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the task review where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching task review, or <code>null</code> if a matching task review could not be found
	 */
	public static TaskReview fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the task review where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching task review, or <code>null</code> if a matching task review could not be found
	 */
	public static TaskReview fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the task review where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the task review that was removed
	 */
	public static TaskReview removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchTaskReviewException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of task reviews where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching task reviews
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the task reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching task reviews
	 */
	public static List<TaskReview> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<TaskReview> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<TaskReview> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TaskReview> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public static List<TaskReview> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TaskReview> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
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
	public static TaskReview findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TaskReview> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTaskReviewException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first task review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review, or <code>null</code> if a matching task review could not be found
	 */
	public static TaskReview fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TaskReview> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
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
	public static TaskReview findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TaskReview> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTaskReviewException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last task review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review, or <code>null</code> if a matching task review could not be found
	 */
	public static TaskReview fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TaskReview> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
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
	public static TaskReview[] findByUuid_C_PrevAndNext(
			long taskReviewId, String uuid, long companyId,
			OrderByComparator<TaskReview> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTaskReviewException {

		return getPersistence().findByUuid_C_PrevAndNext(
			taskReviewId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the task reviews where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of task reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching task reviews
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the task reviews where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching task reviews
	 */
	public static List<TaskReview> findByTaskId(long taskId) {
		return getPersistence().findByTaskId(taskId);
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
	public static List<TaskReview> findByTaskId(
		long taskId, int start, int end) {

		return getPersistence().findByTaskId(taskId, start, end);
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
	public static List<TaskReview> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<TaskReview> orderByComparator) {

		return getPersistence().findByTaskId(
			taskId, start, end, orderByComparator);
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
	public static List<TaskReview> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<TaskReview> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTaskId(
			taskId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first task review in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	public static TaskReview findByTaskId_First(
			long taskId, OrderByComparator<TaskReview> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTaskReviewException {

		return getPersistence().findByTaskId_First(taskId, orderByComparator);
	}

	/**
	 * Returns the first task review in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review, or <code>null</code> if a matching task review could not be found
	 */
	public static TaskReview fetchByTaskId_First(
		long taskId, OrderByComparator<TaskReview> orderByComparator) {

		return getPersistence().fetchByTaskId_First(taskId, orderByComparator);
	}

	/**
	 * Returns the last task review in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	public static TaskReview findByTaskId_Last(
			long taskId, OrderByComparator<TaskReview> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTaskReviewException {

		return getPersistence().findByTaskId_Last(taskId, orderByComparator);
	}

	/**
	 * Returns the last task review in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review, or <code>null</code> if a matching task review could not be found
	 */
	public static TaskReview fetchByTaskId_Last(
		long taskId, OrderByComparator<TaskReview> orderByComparator) {

		return getPersistence().fetchByTaskId_Last(taskId, orderByComparator);
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
	public static TaskReview[] findByTaskId_PrevAndNext(
			long taskReviewId, long taskId,
			OrderByComparator<TaskReview> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTaskReviewException {

		return getPersistence().findByTaskId_PrevAndNext(
			taskReviewId, taskId, orderByComparator);
	}

	/**
	 * Removes all the task reviews where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 */
	public static void removeByTaskId(long taskId) {
		getPersistence().removeByTaskId(taskId);
	}

	/**
	 * Returns the number of task reviews where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching task reviews
	 */
	public static int countByTaskId(long taskId) {
		return getPersistence().countByTaskId(taskId);
	}

	/**
	 * Returns all the task reviews where reviewerId = &#63;.
	 *
	 * @param reviewerId the reviewer ID
	 * @return the matching task reviews
	 */
	public static List<TaskReview> findByReviewerId(long reviewerId) {
		return getPersistence().findByReviewerId(reviewerId);
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
	public static List<TaskReview> findByReviewerId(
		long reviewerId, int start, int end) {

		return getPersistence().findByReviewerId(reviewerId, start, end);
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
	public static List<TaskReview> findByReviewerId(
		long reviewerId, int start, int end,
		OrderByComparator<TaskReview> orderByComparator) {

		return getPersistence().findByReviewerId(
			reviewerId, start, end, orderByComparator);
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
	public static List<TaskReview> findByReviewerId(
		long reviewerId, int start, int end,
		OrderByComparator<TaskReview> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByReviewerId(
			reviewerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first task review in the ordered set where reviewerId = &#63;.
	 *
	 * @param reviewerId the reviewer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	public static TaskReview findByReviewerId_First(
			long reviewerId, OrderByComparator<TaskReview> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTaskReviewException {

		return getPersistence().findByReviewerId_First(
			reviewerId, orderByComparator);
	}

	/**
	 * Returns the first task review in the ordered set where reviewerId = &#63;.
	 *
	 * @param reviewerId the reviewer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review, or <code>null</code> if a matching task review could not be found
	 */
	public static TaskReview fetchByReviewerId_First(
		long reviewerId, OrderByComparator<TaskReview> orderByComparator) {

		return getPersistence().fetchByReviewerId_First(
			reviewerId, orderByComparator);
	}

	/**
	 * Returns the last task review in the ordered set where reviewerId = &#63;.
	 *
	 * @param reviewerId the reviewer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	public static TaskReview findByReviewerId_Last(
			long reviewerId, OrderByComparator<TaskReview> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTaskReviewException {

		return getPersistence().findByReviewerId_Last(
			reviewerId, orderByComparator);
	}

	/**
	 * Returns the last task review in the ordered set where reviewerId = &#63;.
	 *
	 * @param reviewerId the reviewer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review, or <code>null</code> if a matching task review could not be found
	 */
	public static TaskReview fetchByReviewerId_Last(
		long reviewerId, OrderByComparator<TaskReview> orderByComparator) {

		return getPersistence().fetchByReviewerId_Last(
			reviewerId, orderByComparator);
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
	public static TaskReview[] findByReviewerId_PrevAndNext(
			long taskReviewId, long reviewerId,
			OrderByComparator<TaskReview> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTaskReviewException {

		return getPersistence().findByReviewerId_PrevAndNext(
			taskReviewId, reviewerId, orderByComparator);
	}

	/**
	 * Removes all the task reviews where reviewerId = &#63; from the database.
	 *
	 * @param reviewerId the reviewer ID
	 */
	public static void removeByReviewerId(long reviewerId) {
		getPersistence().removeByReviewerId(reviewerId);
	}

	/**
	 * Returns the number of task reviews where reviewerId = &#63;.
	 *
	 * @param reviewerId the reviewer ID
	 * @return the number of matching task reviews
	 */
	public static int countByReviewerId(long reviewerId) {
		return getPersistence().countByReviewerId(reviewerId);
	}

	/**
	 * Caches the task review in the entity cache if it is enabled.
	 *
	 * @param taskReview the task review
	 */
	public static void cacheResult(TaskReview taskReview) {
		getPersistence().cacheResult(taskReview);
	}

	/**
	 * Caches the task reviews in the entity cache if it is enabled.
	 *
	 * @param taskReviews the task reviews
	 */
	public static void cacheResult(List<TaskReview> taskReviews) {
		getPersistence().cacheResult(taskReviews);
	}

	/**
	 * Creates a new task review with the primary key. Does not add the task review to the database.
	 *
	 * @param taskReviewId the primary key for the new task review
	 * @return the new task review
	 */
	public static TaskReview create(long taskReviewId) {
		return getPersistence().create(taskReviewId);
	}

	/**
	 * Removes the task review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskReviewId the primary key of the task review
	 * @return the task review that was removed
	 * @throws NoSuchTaskReviewException if a task review with the primary key could not be found
	 */
	public static TaskReview remove(long taskReviewId)
		throws com.ax.hrms.exception.NoSuchTaskReviewException {

		return getPersistence().remove(taskReviewId);
	}

	public static TaskReview updateImpl(TaskReview taskReview) {
		return getPersistence().updateImpl(taskReview);
	}

	/**
	 * Returns the task review with the primary key or throws a <code>NoSuchTaskReviewException</code> if it could not be found.
	 *
	 * @param taskReviewId the primary key of the task review
	 * @return the task review
	 * @throws NoSuchTaskReviewException if a task review with the primary key could not be found
	 */
	public static TaskReview findByPrimaryKey(long taskReviewId)
		throws com.ax.hrms.exception.NoSuchTaskReviewException {

		return getPersistence().findByPrimaryKey(taskReviewId);
	}

	/**
	 * Returns the task review with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskReviewId the primary key of the task review
	 * @return the task review, or <code>null</code> if a task review with the primary key could not be found
	 */
	public static TaskReview fetchByPrimaryKey(long taskReviewId) {
		return getPersistence().fetchByPrimaryKey(taskReviewId);
	}

	/**
	 * Returns all the task reviews.
	 *
	 * @return the task reviews
	 */
	public static List<TaskReview> findAll() {
		return getPersistence().findAll();
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
	public static List<TaskReview> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<TaskReview> findAll(
		int start, int end, OrderByComparator<TaskReview> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<TaskReview> findAll(
		int start, int end, OrderByComparator<TaskReview> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the task reviews from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of task reviews.
	 *
	 * @return the number of task reviews
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TaskReviewPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(TaskReviewPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile TaskReviewPersistence _persistence;

}