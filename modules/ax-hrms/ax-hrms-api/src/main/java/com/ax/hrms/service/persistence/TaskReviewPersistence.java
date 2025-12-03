/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchTaskReviewException;
import com.ax.hrms.model.TaskReview;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the task review service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskReviewUtil
 * @generated
 */
@ProviderType
public interface TaskReviewPersistence extends BasePersistence<TaskReview> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaskReviewUtil} to access the task review persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the task reviews where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching task reviews
	 */
	public java.util.List<TaskReview> findByUuid(String uuid);

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
	public java.util.List<TaskReview> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<TaskReview> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
			orderByComparator);

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
	public java.util.List<TaskReview> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first task review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	public TaskReview findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
				orderByComparator)
		throws NoSuchTaskReviewException;

	/**
	 * Returns the first task review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review, or <code>null</code> if a matching task review could not be found
	 */
	public TaskReview fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
			orderByComparator);

	/**
	 * Returns the last task review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	public TaskReview findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
				orderByComparator)
		throws NoSuchTaskReviewException;

	/**
	 * Returns the last task review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review, or <code>null</code> if a matching task review could not be found
	 */
	public TaskReview fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
			orderByComparator);

	/**
	 * Returns the task reviews before and after the current task review in the ordered set where uuid = &#63;.
	 *
	 * @param taskReviewId the primary key of the current task review
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task review
	 * @throws NoSuchTaskReviewException if a task review with the primary key could not be found
	 */
	public TaskReview[] findByUuid_PrevAndNext(
			long taskReviewId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
				orderByComparator)
		throws NoSuchTaskReviewException;

	/**
	 * Removes all the task reviews where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of task reviews where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching task reviews
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the task review where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTaskReviewException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	public TaskReview findByUUID_G(String uuid, long groupId)
		throws NoSuchTaskReviewException;

	/**
	 * Returns the task review where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching task review, or <code>null</code> if a matching task review could not be found
	 */
	public TaskReview fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the task review where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching task review, or <code>null</code> if a matching task review could not be found
	 */
	public TaskReview fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the task review where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the task review that was removed
	 */
	public TaskReview removeByUUID_G(String uuid, long groupId)
		throws NoSuchTaskReviewException;

	/**
	 * Returns the number of task reviews where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching task reviews
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the task reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching task reviews
	 */
	public java.util.List<TaskReview> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<TaskReview> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<TaskReview> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
			orderByComparator);

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
	public java.util.List<TaskReview> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first task review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	public TaskReview findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
				orderByComparator)
		throws NoSuchTaskReviewException;

	/**
	 * Returns the first task review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review, or <code>null</code> if a matching task review could not be found
	 */
	public TaskReview fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
			orderByComparator);

	/**
	 * Returns the last task review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	public TaskReview findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
				orderByComparator)
		throws NoSuchTaskReviewException;

	/**
	 * Returns the last task review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review, or <code>null</code> if a matching task review could not be found
	 */
	public TaskReview fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
			orderByComparator);

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
	public TaskReview[] findByUuid_C_PrevAndNext(
			long taskReviewId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
				orderByComparator)
		throws NoSuchTaskReviewException;

	/**
	 * Removes all the task reviews where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of task reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching task reviews
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the task reviews where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching task reviews
	 */
	public java.util.List<TaskReview> findByTaskId(long taskId);

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
	public java.util.List<TaskReview> findByTaskId(
		long taskId, int start, int end);

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
	public java.util.List<TaskReview> findByTaskId(
		long taskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
			orderByComparator);

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
	public java.util.List<TaskReview> findByTaskId(
		long taskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first task review in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	public TaskReview findByTaskId_First(
			long taskId,
			com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
				orderByComparator)
		throws NoSuchTaskReviewException;

	/**
	 * Returns the first task review in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review, or <code>null</code> if a matching task review could not be found
	 */
	public TaskReview fetchByTaskId_First(
		long taskId,
		com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
			orderByComparator);

	/**
	 * Returns the last task review in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	public TaskReview findByTaskId_Last(
			long taskId,
			com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
				orderByComparator)
		throws NoSuchTaskReviewException;

	/**
	 * Returns the last task review in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review, or <code>null</code> if a matching task review could not be found
	 */
	public TaskReview fetchByTaskId_Last(
		long taskId,
		com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
			orderByComparator);

	/**
	 * Returns the task reviews before and after the current task review in the ordered set where taskId = &#63;.
	 *
	 * @param taskReviewId the primary key of the current task review
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task review
	 * @throws NoSuchTaskReviewException if a task review with the primary key could not be found
	 */
	public TaskReview[] findByTaskId_PrevAndNext(
			long taskReviewId, long taskId,
			com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
				orderByComparator)
		throws NoSuchTaskReviewException;

	/**
	 * Removes all the task reviews where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 */
	public void removeByTaskId(long taskId);

	/**
	 * Returns the number of task reviews where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching task reviews
	 */
	public int countByTaskId(long taskId);

	/**
	 * Returns all the task reviews where reviewerId = &#63;.
	 *
	 * @param reviewerId the reviewer ID
	 * @return the matching task reviews
	 */
	public java.util.List<TaskReview> findByReviewerId(long reviewerId);

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
	public java.util.List<TaskReview> findByReviewerId(
		long reviewerId, int start, int end);

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
	public java.util.List<TaskReview> findByReviewerId(
		long reviewerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
			orderByComparator);

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
	public java.util.List<TaskReview> findByReviewerId(
		long reviewerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first task review in the ordered set where reviewerId = &#63;.
	 *
	 * @param reviewerId the reviewer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	public TaskReview findByReviewerId_First(
			long reviewerId,
			com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
				orderByComparator)
		throws NoSuchTaskReviewException;

	/**
	 * Returns the first task review in the ordered set where reviewerId = &#63;.
	 *
	 * @param reviewerId the reviewer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task review, or <code>null</code> if a matching task review could not be found
	 */
	public TaskReview fetchByReviewerId_First(
		long reviewerId,
		com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
			orderByComparator);

	/**
	 * Returns the last task review in the ordered set where reviewerId = &#63;.
	 *
	 * @param reviewerId the reviewer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review
	 * @throws NoSuchTaskReviewException if a matching task review could not be found
	 */
	public TaskReview findByReviewerId_Last(
			long reviewerId,
			com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
				orderByComparator)
		throws NoSuchTaskReviewException;

	/**
	 * Returns the last task review in the ordered set where reviewerId = &#63;.
	 *
	 * @param reviewerId the reviewer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task review, or <code>null</code> if a matching task review could not be found
	 */
	public TaskReview fetchByReviewerId_Last(
		long reviewerId,
		com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
			orderByComparator);

	/**
	 * Returns the task reviews before and after the current task review in the ordered set where reviewerId = &#63;.
	 *
	 * @param taskReviewId the primary key of the current task review
	 * @param reviewerId the reviewer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task review
	 * @throws NoSuchTaskReviewException if a task review with the primary key could not be found
	 */
	public TaskReview[] findByReviewerId_PrevAndNext(
			long taskReviewId, long reviewerId,
			com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
				orderByComparator)
		throws NoSuchTaskReviewException;

	/**
	 * Removes all the task reviews where reviewerId = &#63; from the database.
	 *
	 * @param reviewerId the reviewer ID
	 */
	public void removeByReviewerId(long reviewerId);

	/**
	 * Returns the number of task reviews where reviewerId = &#63;.
	 *
	 * @param reviewerId the reviewer ID
	 * @return the number of matching task reviews
	 */
	public int countByReviewerId(long reviewerId);

	/**
	 * Caches the task review in the entity cache if it is enabled.
	 *
	 * @param taskReview the task review
	 */
	public void cacheResult(TaskReview taskReview);

	/**
	 * Caches the task reviews in the entity cache if it is enabled.
	 *
	 * @param taskReviews the task reviews
	 */
	public void cacheResult(java.util.List<TaskReview> taskReviews);

	/**
	 * Creates a new task review with the primary key. Does not add the task review to the database.
	 *
	 * @param taskReviewId the primary key for the new task review
	 * @return the new task review
	 */
	public TaskReview create(long taskReviewId);

	/**
	 * Removes the task review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskReviewId the primary key of the task review
	 * @return the task review that was removed
	 * @throws NoSuchTaskReviewException if a task review with the primary key could not be found
	 */
	public TaskReview remove(long taskReviewId)
		throws NoSuchTaskReviewException;

	public TaskReview updateImpl(TaskReview taskReview);

	/**
	 * Returns the task review with the primary key or throws a <code>NoSuchTaskReviewException</code> if it could not be found.
	 *
	 * @param taskReviewId the primary key of the task review
	 * @return the task review
	 * @throws NoSuchTaskReviewException if a task review with the primary key could not be found
	 */
	public TaskReview findByPrimaryKey(long taskReviewId)
		throws NoSuchTaskReviewException;

	/**
	 * Returns the task review with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskReviewId the primary key of the task review
	 * @return the task review, or <code>null</code> if a task review with the primary key could not be found
	 */
	public TaskReview fetchByPrimaryKey(long taskReviewId);

	/**
	 * Returns all the task reviews.
	 *
	 * @return the task reviews
	 */
	public java.util.List<TaskReview> findAll();

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
	public java.util.List<TaskReview> findAll(int start, int end);

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
	public java.util.List<TaskReview> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
			orderByComparator);

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
	public java.util.List<TaskReview> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskReview>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the task reviews from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of task reviews.
	 *
	 * @return the number of task reviews
	 */
	public int countAll();

}