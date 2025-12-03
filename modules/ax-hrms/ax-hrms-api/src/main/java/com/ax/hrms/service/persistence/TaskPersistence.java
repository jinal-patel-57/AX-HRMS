/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchTaskException;
import com.ax.hrms.model.Task;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskUtil
 * @generated
 */
@ProviderType
public interface TaskPersistence extends BasePersistence<Task> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaskUtil} to access the task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the tasks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching tasks
	 */
	public java.util.List<Task> findByUuid(String uuid);

	/**
	 * Returns a range of all the tasks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of matching tasks
	 */
	public java.util.List<Task> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the tasks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tasks
	 */
	public java.util.List<Task> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tasks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tasks
	 */
	public java.util.List<Task> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public Task findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Returns the first task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task, or <code>null</code> if a matching task could not be found
	 */
	public Task fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns the last task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public Task findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Returns the last task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task, or <code>null</code> if a matching task could not be found
	 */
	public Task fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns the tasks before and after the current task in the ordered set where uuid = &#63;.
	 *
	 * @param taskId the primary key of the current task
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	public Task[] findByUuid_PrevAndNext(
			long taskId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Removes all the tasks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of tasks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching tasks
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the task where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTaskException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public Task findByUUID_G(String uuid, long groupId)
		throws NoSuchTaskException;

	/**
	 * Returns the task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching task, or <code>null</code> if a matching task could not be found
	 */
	public Task fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching task, or <code>null</code> if a matching task could not be found
	 */
	public Task fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the task where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the task that was removed
	 */
	public Task removeByUUID_G(String uuid, long groupId)
		throws NoSuchTaskException;

	/**
	 * Returns the number of tasks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching tasks
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the tasks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching tasks
	 */
	public java.util.List<Task> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the tasks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of matching tasks
	 */
	public java.util.List<Task> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the tasks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tasks
	 */
	public java.util.List<Task> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tasks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tasks
	 */
	public java.util.List<Task> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first task in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public Task findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Returns the first task in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task, or <code>null</code> if a matching task could not be found
	 */
	public Task fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns the last task in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public Task findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Returns the last task in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task, or <code>null</code> if a matching task could not be found
	 */
	public Task fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns the tasks before and after the current task in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param taskId the primary key of the current task
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	public Task[] findByUuid_C_PrevAndNext(
			long taskId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Removes all the tasks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of tasks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching tasks
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the tasks where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching tasks
	 */
	public java.util.List<Task> findByProjectId(long projectId);

	/**
	 * Returns a range of all the tasks where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of matching tasks
	 */
	public java.util.List<Task> findByProjectId(
		long projectId, int start, int end);

	/**
	 * Returns an ordered range of all the tasks where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tasks
	 */
	public java.util.List<Task> findByProjectId(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tasks where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tasks
	 */
	public java.util.List<Task> findByProjectId(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first task in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public Task findByProjectId_First(
			long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Returns the first task in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task, or <code>null</code> if a matching task could not be found
	 */
	public Task fetchByProjectId_First(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns the last task in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public Task findByProjectId_Last(
			long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Returns the last task in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task, or <code>null</code> if a matching task could not be found
	 */
	public Task fetchByProjectId_Last(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns the tasks before and after the current task in the ordered set where projectId = &#63;.
	 *
	 * @param taskId the primary key of the current task
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	public Task[] findByProjectId_PrevAndNext(
			long taskId, long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Removes all the tasks where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	public void removeByProjectId(long projectId);

	/**
	 * Returns the number of tasks where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching tasks
	 */
	public int countByProjectId(long projectId);

	/**
	 * Returns all the tasks where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @return the matching tasks
	 */
	public java.util.List<Task> findByManagerId(long managerId);

	/**
	 * Returns a range of all the tasks where managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of matching tasks
	 */
	public java.util.List<Task> findByManagerId(
		long managerId, int start, int end);

	/**
	 * Returns an ordered range of all the tasks where managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tasks
	 */
	public java.util.List<Task> findByManagerId(
		long managerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tasks where managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tasks
	 */
	public java.util.List<Task> findByManagerId(
		long managerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first task in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public Task findByManagerId_First(
			long managerId,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Returns the first task in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task, or <code>null</code> if a matching task could not be found
	 */
	public Task fetchByManagerId_First(
		long managerId,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns the last task in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public Task findByManagerId_Last(
			long managerId,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Returns the last task in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task, or <code>null</code> if a matching task could not be found
	 */
	public Task fetchByManagerId_Last(
		long managerId,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns the tasks before and after the current task in the ordered set where managerId = &#63;.
	 *
	 * @param taskId the primary key of the current task
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	public Task[] findByManagerId_PrevAndNext(
			long taskId, long managerId,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Removes all the tasks where managerId = &#63; from the database.
	 *
	 * @param managerId the manager ID
	 */
	public void removeByManagerId(long managerId);

	/**
	 * Returns the number of tasks where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @return the number of matching tasks
	 */
	public int countByManagerId(long managerId);

	/**
	 * Returns all the tasks where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @return the matching tasks
	 */
	public java.util.List<Task> findByAssignedTo(long assignedTo);

	/**
	 * Returns a range of all the tasks where assignedTo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param assignedTo the assigned to
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of matching tasks
	 */
	public java.util.List<Task> findByAssignedTo(
		long assignedTo, int start, int end);

	/**
	 * Returns an ordered range of all the tasks where assignedTo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param assignedTo the assigned to
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tasks
	 */
	public java.util.List<Task> findByAssignedTo(
		long assignedTo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tasks where assignedTo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param assignedTo the assigned to
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tasks
	 */
	public java.util.List<Task> findByAssignedTo(
		long assignedTo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first task in the ordered set where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public Task findByAssignedTo_First(
			long assignedTo,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Returns the first task in the ordered set where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task, or <code>null</code> if a matching task could not be found
	 */
	public Task fetchByAssignedTo_First(
		long assignedTo,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns the last task in the ordered set where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public Task findByAssignedTo_Last(
			long assignedTo,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Returns the last task in the ordered set where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task, or <code>null</code> if a matching task could not be found
	 */
	public Task fetchByAssignedTo_Last(
		long assignedTo,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns the tasks before and after the current task in the ordered set where assignedTo = &#63;.
	 *
	 * @param taskId the primary key of the current task
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	public Task[] findByAssignedTo_PrevAndNext(
			long taskId, long assignedTo,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Removes all the tasks where assignedTo = &#63; from the database.
	 *
	 * @param assignedTo the assigned to
	 */
	public void removeByAssignedTo(long assignedTo);

	/**
	 * Returns the number of tasks where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @return the number of matching tasks
	 */
	public int countByAssignedTo(long assignedTo);

	/**
	 * Returns all the tasks where projectId = &#63; and managerId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param managerId the manager ID
	 * @return the matching tasks
	 */
	public java.util.List<Task> findByProjectIdAndManagerId(
		long projectId, long managerId);

	/**
	 * Returns a range of all the tasks where projectId = &#63; and managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of matching tasks
	 */
	public java.util.List<Task> findByProjectIdAndManagerId(
		long projectId, long managerId, int start, int end);

	/**
	 * Returns an ordered range of all the tasks where projectId = &#63; and managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tasks
	 */
	public java.util.List<Task> findByProjectIdAndManagerId(
		long projectId, long managerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tasks where projectId = &#63; and managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tasks
	 */
	public java.util.List<Task> findByProjectIdAndManagerId(
		long projectId, long managerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first task in the ordered set where projectId = &#63; and managerId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public Task findByProjectIdAndManagerId_First(
			long projectId, long managerId,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Returns the first task in the ordered set where projectId = &#63; and managerId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task, or <code>null</code> if a matching task could not be found
	 */
	public Task fetchByProjectIdAndManagerId_First(
		long projectId, long managerId,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns the last task in the ordered set where projectId = &#63; and managerId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public Task findByProjectIdAndManagerId_Last(
			long projectId, long managerId,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Returns the last task in the ordered set where projectId = &#63; and managerId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task, or <code>null</code> if a matching task could not be found
	 */
	public Task fetchByProjectIdAndManagerId_Last(
		long projectId, long managerId,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns the tasks before and after the current task in the ordered set where projectId = &#63; and managerId = &#63;.
	 *
	 * @param taskId the primary key of the current task
	 * @param projectId the project ID
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	public Task[] findByProjectIdAndManagerId_PrevAndNext(
			long taskId, long projectId, long managerId,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Removes all the tasks where projectId = &#63; and managerId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @param managerId the manager ID
	 */
	public void removeByProjectIdAndManagerId(long projectId, long managerId);

	/**
	 * Returns the number of tasks where projectId = &#63; and managerId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param managerId the manager ID
	 * @return the number of matching tasks
	 */
	public int countByProjectIdAndManagerId(long projectId, long managerId);

	/**
	 * Returns all the tasks where projectId = &#63; and assignedTo = &#63;.
	 *
	 * @param projectId the project ID
	 * @param assignedTo the assigned to
	 * @return the matching tasks
	 */
	public java.util.List<Task> findByProjectIdAndAssigneeId(
		long projectId, long assignedTo);

	/**
	 * Returns a range of all the tasks where projectId = &#63; and assignedTo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param assignedTo the assigned to
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of matching tasks
	 */
	public java.util.List<Task> findByProjectIdAndAssigneeId(
		long projectId, long assignedTo, int start, int end);

	/**
	 * Returns an ordered range of all the tasks where projectId = &#63; and assignedTo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param assignedTo the assigned to
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tasks
	 */
	public java.util.List<Task> findByProjectIdAndAssigneeId(
		long projectId, long assignedTo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tasks where projectId = &#63; and assignedTo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param assignedTo the assigned to
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tasks
	 */
	public java.util.List<Task> findByProjectIdAndAssigneeId(
		long projectId, long assignedTo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first task in the ordered set where projectId = &#63; and assignedTo = &#63;.
	 *
	 * @param projectId the project ID
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public Task findByProjectIdAndAssigneeId_First(
			long projectId, long assignedTo,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Returns the first task in the ordered set where projectId = &#63; and assignedTo = &#63;.
	 *
	 * @param projectId the project ID
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task, or <code>null</code> if a matching task could not be found
	 */
	public Task fetchByProjectIdAndAssigneeId_First(
		long projectId, long assignedTo,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns the last task in the ordered set where projectId = &#63; and assignedTo = &#63;.
	 *
	 * @param projectId the project ID
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public Task findByProjectIdAndAssigneeId_Last(
			long projectId, long assignedTo,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Returns the last task in the ordered set where projectId = &#63; and assignedTo = &#63;.
	 *
	 * @param projectId the project ID
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task, or <code>null</code> if a matching task could not be found
	 */
	public Task fetchByProjectIdAndAssigneeId_Last(
		long projectId, long assignedTo,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns the tasks before and after the current task in the ordered set where projectId = &#63; and assignedTo = &#63;.
	 *
	 * @param taskId the primary key of the current task
	 * @param projectId the project ID
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	public Task[] findByProjectIdAndAssigneeId_PrevAndNext(
			long taskId, long projectId, long assignedTo,
			com.liferay.portal.kernel.util.OrderByComparator<Task>
				orderByComparator)
		throws NoSuchTaskException;

	/**
	 * Removes all the tasks where projectId = &#63; and assignedTo = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @param assignedTo the assigned to
	 */
	public void removeByProjectIdAndAssigneeId(long projectId, long assignedTo);

	/**
	 * Returns the number of tasks where projectId = &#63; and assignedTo = &#63;.
	 *
	 * @param projectId the project ID
	 * @param assignedTo the assigned to
	 * @return the number of matching tasks
	 */
	public int countByProjectIdAndAssigneeId(long projectId, long assignedTo);

	/**
	 * Caches the task in the entity cache if it is enabled.
	 *
	 * @param task the task
	 */
	public void cacheResult(Task task);

	/**
	 * Caches the tasks in the entity cache if it is enabled.
	 *
	 * @param tasks the tasks
	 */
	public void cacheResult(java.util.List<Task> tasks);

	/**
	 * Creates a new task with the primary key. Does not add the task to the database.
	 *
	 * @param taskId the primary key for the new task
	 * @return the new task
	 */
	public Task create(long taskId);

	/**
	 * Removes the task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskId the primary key of the task
	 * @return the task that was removed
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	public Task remove(long taskId) throws NoSuchTaskException;

	public Task updateImpl(Task task);

	/**
	 * Returns the task with the primary key or throws a <code>NoSuchTaskException</code> if it could not be found.
	 *
	 * @param taskId the primary key of the task
	 * @return the task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	public Task findByPrimaryKey(long taskId) throws NoSuchTaskException;

	/**
	 * Returns the task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskId the primary key of the task
	 * @return the task, or <code>null</code> if a task with the primary key could not be found
	 */
	public Task fetchByPrimaryKey(long taskId);

	/**
	 * Returns all the tasks.
	 *
	 * @return the tasks
	 */
	public java.util.List<Task> findAll();

	/**
	 * Returns a range of all the tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of tasks
	 */
	public java.util.List<Task> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tasks
	 */
	public java.util.List<Task> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tasks
	 */
	public java.util.List<Task> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Task>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the tasks from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of tasks.
	 *
	 * @return the number of tasks
	 */
	public int countAll();

}