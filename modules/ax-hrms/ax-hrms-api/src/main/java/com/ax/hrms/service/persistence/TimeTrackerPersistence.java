/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchTimeTrackerException;
import com.ax.hrms.model.TimeTracker;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the time tracker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TimeTrackerUtil
 * @generated
 */
@ProviderType
public interface TimeTrackerPersistence extends BasePersistence<TimeTracker> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TimeTrackerUtil} to access the time tracker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the time trackers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching time trackers
	 */
	public java.util.List<TimeTracker> findByUuid(String uuid);

	/**
	 * Returns a range of all the time trackers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @return the range of matching time trackers
	 */
	public java.util.List<TimeTracker> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the time trackers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching time trackers
	 */
	public java.util.List<TimeTracker> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
			orderByComparator);

	/**
	 * Returns an ordered range of all the time trackers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching time trackers
	 */
	public java.util.List<TimeTracker> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first time tracker in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	public TimeTracker findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
				orderByComparator)
		throws NoSuchTimeTrackerException;

	/**
	 * Returns the first time tracker in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	public TimeTracker fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
			orderByComparator);

	/**
	 * Returns the last time tracker in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	public TimeTracker findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
				orderByComparator)
		throws NoSuchTimeTrackerException;

	/**
	 * Returns the last time tracker in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	public TimeTracker fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
			orderByComparator);

	/**
	 * Returns the time trackers before and after the current time tracker in the ordered set where uuid = &#63;.
	 *
	 * @param timeTrackerId the primary key of the current time tracker
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next time tracker
	 * @throws NoSuchTimeTrackerException if a time tracker with the primary key could not be found
	 */
	public TimeTracker[] findByUuid_PrevAndNext(
			long timeTrackerId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
				orderByComparator)
		throws NoSuchTimeTrackerException;

	/**
	 * Removes all the time trackers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of time trackers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching time trackers
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the time tracker where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTimeTrackerException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	public TimeTracker findByUUID_G(String uuid, long groupId)
		throws NoSuchTimeTrackerException;

	/**
	 * Returns the time tracker where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	public TimeTracker fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the time tracker where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	public TimeTracker fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the time tracker where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the time tracker that was removed
	 */
	public TimeTracker removeByUUID_G(String uuid, long groupId)
		throws NoSuchTimeTrackerException;

	/**
	 * Returns the number of time trackers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching time trackers
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the time trackers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching time trackers
	 */
	public java.util.List<TimeTracker> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the time trackers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @return the range of matching time trackers
	 */
	public java.util.List<TimeTracker> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the time trackers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching time trackers
	 */
	public java.util.List<TimeTracker> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
			orderByComparator);

	/**
	 * Returns an ordered range of all the time trackers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching time trackers
	 */
	public java.util.List<TimeTracker> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first time tracker in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	public TimeTracker findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
				orderByComparator)
		throws NoSuchTimeTrackerException;

	/**
	 * Returns the first time tracker in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	public TimeTracker fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
			orderByComparator);

	/**
	 * Returns the last time tracker in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	public TimeTracker findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
				orderByComparator)
		throws NoSuchTimeTrackerException;

	/**
	 * Returns the last time tracker in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	public TimeTracker fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
			orderByComparator);

	/**
	 * Returns the time trackers before and after the current time tracker in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param timeTrackerId the primary key of the current time tracker
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next time tracker
	 * @throws NoSuchTimeTrackerException if a time tracker with the primary key could not be found
	 */
	public TimeTracker[] findByUuid_C_PrevAndNext(
			long timeTrackerId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
				orderByComparator)
		throws NoSuchTimeTrackerException;

	/**
	 * Removes all the time trackers where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of time trackers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching time trackers
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the time trackers where taskId = &#63; and employeeId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @return the matching time trackers
	 */
	public java.util.List<TimeTracker> findByTaskIdAndEmployeeId(
		long taskId, long employeeId);

	/**
	 * Returns a range of all the time trackers where taskId = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @return the range of matching time trackers
	 */
	public java.util.List<TimeTracker> findByTaskIdAndEmployeeId(
		long taskId, long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the time trackers where taskId = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching time trackers
	 */
	public java.util.List<TimeTracker> findByTaskIdAndEmployeeId(
		long taskId, long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
			orderByComparator);

	/**
	 * Returns an ordered range of all the time trackers where taskId = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching time trackers
	 */
	public java.util.List<TimeTracker> findByTaskIdAndEmployeeId(
		long taskId, long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first time tracker in the ordered set where taskId = &#63; and employeeId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	public TimeTracker findByTaskIdAndEmployeeId_First(
			long taskId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
				orderByComparator)
		throws NoSuchTimeTrackerException;

	/**
	 * Returns the first time tracker in the ordered set where taskId = &#63; and employeeId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	public TimeTracker fetchByTaskIdAndEmployeeId_First(
		long taskId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
			orderByComparator);

	/**
	 * Returns the last time tracker in the ordered set where taskId = &#63; and employeeId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	public TimeTracker findByTaskIdAndEmployeeId_Last(
			long taskId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
				orderByComparator)
		throws NoSuchTimeTrackerException;

	/**
	 * Returns the last time tracker in the ordered set where taskId = &#63; and employeeId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	public TimeTracker fetchByTaskIdAndEmployeeId_Last(
		long taskId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
			orderByComparator);

	/**
	 * Returns the time trackers before and after the current time tracker in the ordered set where taskId = &#63; and employeeId = &#63;.
	 *
	 * @param timeTrackerId the primary key of the current time tracker
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next time tracker
	 * @throws NoSuchTimeTrackerException if a time tracker with the primary key could not be found
	 */
	public TimeTracker[] findByTaskIdAndEmployeeId_PrevAndNext(
			long timeTrackerId, long taskId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
				orderByComparator)
		throws NoSuchTimeTrackerException;

	/**
	 * Removes all the time trackers where taskId = &#63; and employeeId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 */
	public void removeByTaskIdAndEmployeeId(long taskId, long employeeId);

	/**
	 * Returns the number of time trackers where taskId = &#63; and employeeId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @return the number of matching time trackers
	 */
	public int countByTaskIdAndEmployeeId(long taskId, long employeeId);

	/**
	 * Returns all the time trackers where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching time trackers
	 */
	public java.util.List<TimeTracker> findByTaskId(long taskId);

	/**
	 * Returns a range of all the time trackers where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @return the range of matching time trackers
	 */
	public java.util.List<TimeTracker> findByTaskId(
		long taskId, int start, int end);

	/**
	 * Returns an ordered range of all the time trackers where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching time trackers
	 */
	public java.util.List<TimeTracker> findByTaskId(
		long taskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
			orderByComparator);

	/**
	 * Returns an ordered range of all the time trackers where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching time trackers
	 */
	public java.util.List<TimeTracker> findByTaskId(
		long taskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first time tracker in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	public TimeTracker findByTaskId_First(
			long taskId,
			com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
				orderByComparator)
		throws NoSuchTimeTrackerException;

	/**
	 * Returns the first time tracker in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	public TimeTracker fetchByTaskId_First(
		long taskId,
		com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
			orderByComparator);

	/**
	 * Returns the last time tracker in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	public TimeTracker findByTaskId_Last(
			long taskId,
			com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
				orderByComparator)
		throws NoSuchTimeTrackerException;

	/**
	 * Returns the last time tracker in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	public TimeTracker fetchByTaskId_Last(
		long taskId,
		com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
			orderByComparator);

	/**
	 * Returns the time trackers before and after the current time tracker in the ordered set where taskId = &#63;.
	 *
	 * @param timeTrackerId the primary key of the current time tracker
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next time tracker
	 * @throws NoSuchTimeTrackerException if a time tracker with the primary key could not be found
	 */
	public TimeTracker[] findByTaskId_PrevAndNext(
			long timeTrackerId, long taskId,
			com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
				orderByComparator)
		throws NoSuchTimeTrackerException;

	/**
	 * Removes all the time trackers where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 */
	public void removeByTaskId(long taskId);

	/**
	 * Returns the number of time trackers where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching time trackers
	 */
	public int countByTaskId(long taskId);

	/**
	 * Caches the time tracker in the entity cache if it is enabled.
	 *
	 * @param timeTracker the time tracker
	 */
	public void cacheResult(TimeTracker timeTracker);

	/**
	 * Caches the time trackers in the entity cache if it is enabled.
	 *
	 * @param timeTrackers the time trackers
	 */
	public void cacheResult(java.util.List<TimeTracker> timeTrackers);

	/**
	 * Creates a new time tracker with the primary key. Does not add the time tracker to the database.
	 *
	 * @param timeTrackerId the primary key for the new time tracker
	 * @return the new time tracker
	 */
	public TimeTracker create(long timeTrackerId);

	/**
	 * Removes the time tracker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param timeTrackerId the primary key of the time tracker
	 * @return the time tracker that was removed
	 * @throws NoSuchTimeTrackerException if a time tracker with the primary key could not be found
	 */
	public TimeTracker remove(long timeTrackerId)
		throws NoSuchTimeTrackerException;

	public TimeTracker updateImpl(TimeTracker timeTracker);

	/**
	 * Returns the time tracker with the primary key or throws a <code>NoSuchTimeTrackerException</code> if it could not be found.
	 *
	 * @param timeTrackerId the primary key of the time tracker
	 * @return the time tracker
	 * @throws NoSuchTimeTrackerException if a time tracker with the primary key could not be found
	 */
	public TimeTracker findByPrimaryKey(long timeTrackerId)
		throws NoSuchTimeTrackerException;

	/**
	 * Returns the time tracker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param timeTrackerId the primary key of the time tracker
	 * @return the time tracker, or <code>null</code> if a time tracker with the primary key could not be found
	 */
	public TimeTracker fetchByPrimaryKey(long timeTrackerId);

	/**
	 * Returns all the time trackers.
	 *
	 * @return the time trackers
	 */
	public java.util.List<TimeTracker> findAll();

	/**
	 * Returns a range of all the time trackers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @return the range of time trackers
	 */
	public java.util.List<TimeTracker> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the time trackers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of time trackers
	 */
	public java.util.List<TimeTracker> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
			orderByComparator);

	/**
	 * Returns an ordered range of all the time trackers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of time trackers
	 */
	public java.util.List<TimeTracker> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeTracker>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the time trackers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of time trackers.
	 *
	 * @return the number of time trackers
	 */
	public int countAll();

}