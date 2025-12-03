/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.TimeTracker;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the time tracker service. This utility wraps <code>com.ax.hrms.service.persistence.impl.TimeTrackerPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TimeTrackerPersistence
 * @generated
 */
public class TimeTrackerUtil {

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
	public static void clearCache(TimeTracker timeTracker) {
		getPersistence().clearCache(timeTracker);
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
	public static Map<Serializable, TimeTracker> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TimeTracker> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TimeTracker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TimeTracker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TimeTracker> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TimeTracker update(TimeTracker timeTracker) {
		return getPersistence().update(timeTracker);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TimeTracker update(
		TimeTracker timeTracker, ServiceContext serviceContext) {

		return getPersistence().update(timeTracker, serviceContext);
	}

	/**
	 * Returns all the time trackers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching time trackers
	 */
	public static List<TimeTracker> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<TimeTracker> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<TimeTracker> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TimeTracker> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<TimeTracker> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TimeTracker> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first time tracker in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	public static TimeTracker findByUuid_First(
			String uuid, OrderByComparator<TimeTracker> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTimeTrackerException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first time tracker in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	public static TimeTracker fetchByUuid_First(
		String uuid, OrderByComparator<TimeTracker> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last time tracker in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	public static TimeTracker findByUuid_Last(
			String uuid, OrderByComparator<TimeTracker> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTimeTrackerException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last time tracker in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	public static TimeTracker fetchByUuid_Last(
		String uuid, OrderByComparator<TimeTracker> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the time trackers before and after the current time tracker in the ordered set where uuid = &#63;.
	 *
	 * @param timeTrackerId the primary key of the current time tracker
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next time tracker
	 * @throws NoSuchTimeTrackerException if a time tracker with the primary key could not be found
	 */
	public static TimeTracker[] findByUuid_PrevAndNext(
			long timeTrackerId, String uuid,
			OrderByComparator<TimeTracker> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTimeTrackerException {

		return getPersistence().findByUuid_PrevAndNext(
			timeTrackerId, uuid, orderByComparator);
	}

	/**
	 * Removes all the time trackers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of time trackers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching time trackers
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the time tracker where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTimeTrackerException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	public static TimeTracker findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchTimeTrackerException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the time tracker where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	public static TimeTracker fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the time tracker where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	public static TimeTracker fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the time tracker where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the time tracker that was removed
	 */
	public static TimeTracker removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchTimeTrackerException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of time trackers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching time trackers
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the time trackers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching time trackers
	 */
	public static List<TimeTracker> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<TimeTracker> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<TimeTracker> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TimeTracker> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<TimeTracker> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TimeTracker> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first time tracker in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	public static TimeTracker findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TimeTracker> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTimeTrackerException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first time tracker in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	public static TimeTracker fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TimeTracker> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last time tracker in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	public static TimeTracker findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TimeTracker> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTimeTrackerException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last time tracker in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	public static TimeTracker fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TimeTracker> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static TimeTracker[] findByUuid_C_PrevAndNext(
			long timeTrackerId, String uuid, long companyId,
			OrderByComparator<TimeTracker> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTimeTrackerException {

		return getPersistence().findByUuid_C_PrevAndNext(
			timeTrackerId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the time trackers where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of time trackers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching time trackers
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the time trackers where taskId = &#63; and employeeId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @return the matching time trackers
	 */
	public static List<TimeTracker> findByTaskIdAndEmployeeId(
		long taskId, long employeeId) {

		return getPersistence().findByTaskIdAndEmployeeId(taskId, employeeId);
	}

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
	public static List<TimeTracker> findByTaskIdAndEmployeeId(
		long taskId, long employeeId, int start, int end) {

		return getPersistence().findByTaskIdAndEmployeeId(
			taskId, employeeId, start, end);
	}

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
	public static List<TimeTracker> findByTaskIdAndEmployeeId(
		long taskId, long employeeId, int start, int end,
		OrderByComparator<TimeTracker> orderByComparator) {

		return getPersistence().findByTaskIdAndEmployeeId(
			taskId, employeeId, start, end, orderByComparator);
	}

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
	public static List<TimeTracker> findByTaskIdAndEmployeeId(
		long taskId, long employeeId, int start, int end,
		OrderByComparator<TimeTracker> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTaskIdAndEmployeeId(
			taskId, employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first time tracker in the ordered set where taskId = &#63; and employeeId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	public static TimeTracker findByTaskIdAndEmployeeId_First(
			long taskId, long employeeId,
			OrderByComparator<TimeTracker> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTimeTrackerException {

		return getPersistence().findByTaskIdAndEmployeeId_First(
			taskId, employeeId, orderByComparator);
	}

	/**
	 * Returns the first time tracker in the ordered set where taskId = &#63; and employeeId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	public static TimeTracker fetchByTaskIdAndEmployeeId_First(
		long taskId, long employeeId,
		OrderByComparator<TimeTracker> orderByComparator) {

		return getPersistence().fetchByTaskIdAndEmployeeId_First(
			taskId, employeeId, orderByComparator);
	}

	/**
	 * Returns the last time tracker in the ordered set where taskId = &#63; and employeeId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	public static TimeTracker findByTaskIdAndEmployeeId_Last(
			long taskId, long employeeId,
			OrderByComparator<TimeTracker> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTimeTrackerException {

		return getPersistence().findByTaskIdAndEmployeeId_Last(
			taskId, employeeId, orderByComparator);
	}

	/**
	 * Returns the last time tracker in the ordered set where taskId = &#63; and employeeId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	public static TimeTracker fetchByTaskIdAndEmployeeId_Last(
		long taskId, long employeeId,
		OrderByComparator<TimeTracker> orderByComparator) {

		return getPersistence().fetchByTaskIdAndEmployeeId_Last(
			taskId, employeeId, orderByComparator);
	}

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
	public static TimeTracker[] findByTaskIdAndEmployeeId_PrevAndNext(
			long timeTrackerId, long taskId, long employeeId,
			OrderByComparator<TimeTracker> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTimeTrackerException {

		return getPersistence().findByTaskIdAndEmployeeId_PrevAndNext(
			timeTrackerId, taskId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the time trackers where taskId = &#63; and employeeId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 */
	public static void removeByTaskIdAndEmployeeId(
		long taskId, long employeeId) {

		getPersistence().removeByTaskIdAndEmployeeId(taskId, employeeId);
	}

	/**
	 * Returns the number of time trackers where taskId = &#63; and employeeId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param employeeId the employee ID
	 * @return the number of matching time trackers
	 */
	public static int countByTaskIdAndEmployeeId(long taskId, long employeeId) {
		return getPersistence().countByTaskIdAndEmployeeId(taskId, employeeId);
	}

	/**
	 * Returns all the time trackers where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching time trackers
	 */
	public static List<TimeTracker> findByTaskId(long taskId) {
		return getPersistence().findByTaskId(taskId);
	}

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
	public static List<TimeTracker> findByTaskId(
		long taskId, int start, int end) {

		return getPersistence().findByTaskId(taskId, start, end);
	}

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
	public static List<TimeTracker> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<TimeTracker> orderByComparator) {

		return getPersistence().findByTaskId(
			taskId, start, end, orderByComparator);
	}

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
	public static List<TimeTracker> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<TimeTracker> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTaskId(
			taskId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first time tracker in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	public static TimeTracker findByTaskId_First(
			long taskId, OrderByComparator<TimeTracker> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTimeTrackerException {

		return getPersistence().findByTaskId_First(taskId, orderByComparator);
	}

	/**
	 * Returns the first time tracker in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	public static TimeTracker fetchByTaskId_First(
		long taskId, OrderByComparator<TimeTracker> orderByComparator) {

		return getPersistence().fetchByTaskId_First(taskId, orderByComparator);
	}

	/**
	 * Returns the last time tracker in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker
	 * @throws NoSuchTimeTrackerException if a matching time tracker could not be found
	 */
	public static TimeTracker findByTaskId_Last(
			long taskId, OrderByComparator<TimeTracker> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTimeTrackerException {

		return getPersistence().findByTaskId_Last(taskId, orderByComparator);
	}

	/**
	 * Returns the last time tracker in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	public static TimeTracker fetchByTaskId_Last(
		long taskId, OrderByComparator<TimeTracker> orderByComparator) {

		return getPersistence().fetchByTaskId_Last(taskId, orderByComparator);
	}

	/**
	 * Returns the time trackers before and after the current time tracker in the ordered set where taskId = &#63;.
	 *
	 * @param timeTrackerId the primary key of the current time tracker
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next time tracker
	 * @throws NoSuchTimeTrackerException if a time tracker with the primary key could not be found
	 */
	public static TimeTracker[] findByTaskId_PrevAndNext(
			long timeTrackerId, long taskId,
			OrderByComparator<TimeTracker> orderByComparator)
		throws com.ax.hrms.exception.NoSuchTimeTrackerException {

		return getPersistence().findByTaskId_PrevAndNext(
			timeTrackerId, taskId, orderByComparator);
	}

	/**
	 * Removes all the time trackers where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 */
	public static void removeByTaskId(long taskId) {
		getPersistence().removeByTaskId(taskId);
	}

	/**
	 * Returns the number of time trackers where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching time trackers
	 */
	public static int countByTaskId(long taskId) {
		return getPersistence().countByTaskId(taskId);
	}

	/**
	 * Caches the time tracker in the entity cache if it is enabled.
	 *
	 * @param timeTracker the time tracker
	 */
	public static void cacheResult(TimeTracker timeTracker) {
		getPersistence().cacheResult(timeTracker);
	}

	/**
	 * Caches the time trackers in the entity cache if it is enabled.
	 *
	 * @param timeTrackers the time trackers
	 */
	public static void cacheResult(List<TimeTracker> timeTrackers) {
		getPersistence().cacheResult(timeTrackers);
	}

	/**
	 * Creates a new time tracker with the primary key. Does not add the time tracker to the database.
	 *
	 * @param timeTrackerId the primary key for the new time tracker
	 * @return the new time tracker
	 */
	public static TimeTracker create(long timeTrackerId) {
		return getPersistence().create(timeTrackerId);
	}

	/**
	 * Removes the time tracker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param timeTrackerId the primary key of the time tracker
	 * @return the time tracker that was removed
	 * @throws NoSuchTimeTrackerException if a time tracker with the primary key could not be found
	 */
	public static TimeTracker remove(long timeTrackerId)
		throws com.ax.hrms.exception.NoSuchTimeTrackerException {

		return getPersistence().remove(timeTrackerId);
	}

	public static TimeTracker updateImpl(TimeTracker timeTracker) {
		return getPersistence().updateImpl(timeTracker);
	}

	/**
	 * Returns the time tracker with the primary key or throws a <code>NoSuchTimeTrackerException</code> if it could not be found.
	 *
	 * @param timeTrackerId the primary key of the time tracker
	 * @return the time tracker
	 * @throws NoSuchTimeTrackerException if a time tracker with the primary key could not be found
	 */
	public static TimeTracker findByPrimaryKey(long timeTrackerId)
		throws com.ax.hrms.exception.NoSuchTimeTrackerException {

		return getPersistence().findByPrimaryKey(timeTrackerId);
	}

	/**
	 * Returns the time tracker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param timeTrackerId the primary key of the time tracker
	 * @return the time tracker, or <code>null</code> if a time tracker with the primary key could not be found
	 */
	public static TimeTracker fetchByPrimaryKey(long timeTrackerId) {
		return getPersistence().fetchByPrimaryKey(timeTrackerId);
	}

	/**
	 * Returns all the time trackers.
	 *
	 * @return the time trackers
	 */
	public static List<TimeTracker> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<TimeTracker> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<TimeTracker> findAll(
		int start, int end, OrderByComparator<TimeTracker> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<TimeTracker> findAll(
		int start, int end, OrderByComparator<TimeTracker> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the time trackers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of time trackers.
	 *
	 * @return the number of time trackers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TimeTrackerPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(TimeTrackerPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile TimeTrackerPersistence _persistence;

}