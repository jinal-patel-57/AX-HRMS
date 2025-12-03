/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.LeaveBalanceHistory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the leave balance history service. This utility wraps <code>com.ax.hrms.service.persistence.impl.LeaveBalanceHistoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveBalanceHistoryPersistence
 * @generated
 */
public class LeaveBalanceHistoryUtil {

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
	public static void clearCache(LeaveBalanceHistory leaveBalanceHistory) {
		getPersistence().clearCache(leaveBalanceHistory);
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
	public static Map<Serializable, LeaveBalanceHistory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LeaveBalanceHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LeaveBalanceHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LeaveBalanceHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LeaveBalanceHistory update(
		LeaveBalanceHistory leaveBalanceHistory) {

		return getPersistence().update(leaveBalanceHistory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LeaveBalanceHistory update(
		LeaveBalanceHistory leaveBalanceHistory,
		ServiceContext serviceContext) {

		return getPersistence().update(leaveBalanceHistory, serviceContext);
	}

	/**
	 * Returns all the leave balance histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave balance histories
	 */
	public static List<LeaveBalanceHistory> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the leave balance histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @return the range of matching leave balance histories
	 */
	public static List<LeaveBalanceHistory> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the leave balance histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave balance histories
	 */
	public static List<LeaveBalanceHistory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave balance histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave balance histories
	 */
	public static List<LeaveBalanceHistory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave balance history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory findByUuid_First(
			String uuid,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceHistoryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first leave balance history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory fetchByUuid_First(
		String uuid, OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last leave balance history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory findByUuid_Last(
			String uuid,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceHistoryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last leave balance history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory fetchByUuid_Last(
		String uuid, OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the leave balance histories before and after the current leave balance history in the ordered set where uuid = &#63;.
	 *
	 * @param leaveBalanceHistoryId the primary key of the current leave balance history
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a leave balance history with the primary key could not be found
	 */
	public static LeaveBalanceHistory[] findByUuid_PrevAndNext(
			long leaveBalanceHistoryId, String uuid,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceHistoryException {

		return getPersistence().findByUuid_PrevAndNext(
			leaveBalanceHistoryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the leave balance histories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of leave balance histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave balance histories
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the leave balance history where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveBalanceHistoryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceHistoryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the leave balance history where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the leave balance history where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the leave balance history where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave balance history that was removed
	 */
	public static LeaveBalanceHistory removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceHistoryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of leave balance histories where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave balance histories
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the leave balance histories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave balance histories
	 */
	public static List<LeaveBalanceHistory> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the leave balance histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @return the range of matching leave balance histories
	 */
	public static List<LeaveBalanceHistory> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the leave balance histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave balance histories
	 */
	public static List<LeaveBalanceHistory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave balance histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave balance histories
	 */
	public static List<LeaveBalanceHistory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave balance history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceHistoryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first leave balance history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last leave balance history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceHistoryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last leave balance history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the leave balance histories before and after the current leave balance history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveBalanceHistoryId the primary key of the current leave balance history
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a leave balance history with the primary key could not be found
	 */
	public static LeaveBalanceHistory[] findByUuid_C_PrevAndNext(
			long leaveBalanceHistoryId, String uuid, long companyId,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceHistoryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			leaveBalanceHistoryId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the leave balance histories where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of leave balance histories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave balance histories
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the leave balance histories where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching leave balance histories
	 */
	public static List<LeaveBalanceHistory> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the leave balance histories where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @return the range of matching leave balance histories
	 */
	public static List<LeaveBalanceHistory> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the leave balance histories where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave balance histories
	 */
	public static List<LeaveBalanceHistory> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave balance histories where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave balance histories
	 */
	public static List<LeaveBalanceHistory> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave balance history in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory findByEmployeeId_First(
			long employeeId,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceHistoryException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first leave balance history in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last leave balance history in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceHistoryException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last leave balance history in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the leave balance histories before and after the current leave balance history in the ordered set where employeeId = &#63;.
	 *
	 * @param leaveBalanceHistoryId the primary key of the current leave balance history
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a leave balance history with the primary key could not be found
	 */
	public static LeaveBalanceHistory[] findByEmployeeId_PrevAndNext(
			long leaveBalanceHistoryId, long employeeId,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceHistoryException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			leaveBalanceHistoryId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the leave balance histories where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of leave balance histories where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching leave balance histories
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the leave balance histories where year = &#63;.
	 *
	 * @param year the year
	 * @return the matching leave balance histories
	 */
	public static List<LeaveBalanceHistory> findByYear(int year) {
		return getPersistence().findByYear(year);
	}

	/**
	 * Returns a range of all the leave balance histories where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @return the range of matching leave balance histories
	 */
	public static List<LeaveBalanceHistory> findByYear(
		int year, int start, int end) {

		return getPersistence().findByYear(year, start, end);
	}

	/**
	 * Returns an ordered range of all the leave balance histories where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave balance histories
	 */
	public static List<LeaveBalanceHistory> findByYear(
		int year, int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return getPersistence().findByYear(year, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave balance histories where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave balance histories
	 */
	public static List<LeaveBalanceHistory> findByYear(
		int year, int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByYear(
			year, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave balance history in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory findByYear_First(
			int year, OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceHistoryException {

		return getPersistence().findByYear_First(year, orderByComparator);
	}

	/**
	 * Returns the first leave balance history in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory fetchByYear_First(
		int year, OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return getPersistence().fetchByYear_First(year, orderByComparator);
	}

	/**
	 * Returns the last leave balance history in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory findByYear_Last(
			int year, OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceHistoryException {

		return getPersistence().findByYear_Last(year, orderByComparator);
	}

	/**
	 * Returns the last leave balance history in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory fetchByYear_Last(
		int year, OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return getPersistence().fetchByYear_Last(year, orderByComparator);
	}

	/**
	 * Returns the leave balance histories before and after the current leave balance history in the ordered set where year = &#63;.
	 *
	 * @param leaveBalanceHistoryId the primary key of the current leave balance history
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a leave balance history with the primary key could not be found
	 */
	public static LeaveBalanceHistory[] findByYear_PrevAndNext(
			long leaveBalanceHistoryId, int year,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceHistoryException {

		return getPersistence().findByYear_PrevAndNext(
			leaveBalanceHistoryId, year, orderByComparator);
	}

	/**
	 * Removes all the leave balance histories where year = &#63; from the database.
	 *
	 * @param year the year
	 */
	public static void removeByYear(int year) {
		getPersistence().removeByYear(year);
	}

	/**
	 * Returns the number of leave balance histories where year = &#63;.
	 *
	 * @param year the year
	 * @return the number of matching leave balance histories
	 */
	public static int countByYear(int year) {
		return getPersistence().countByYear(year);
	}

	/**
	 * Returns all the leave balance histories where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @return the matching leave balance histories
	 */
	public static List<LeaveBalanceHistory> findByEmployeeIdAndYear(
		long employeeId, int year) {

		return getPersistence().findByEmployeeIdAndYear(employeeId, year);
	}

	/**
	 * Returns a range of all the leave balance histories where employeeId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @return the range of matching leave balance histories
	 */
	public static List<LeaveBalanceHistory> findByEmployeeIdAndYear(
		long employeeId, int year, int start, int end) {

		return getPersistence().findByEmployeeIdAndYear(
			employeeId, year, start, end);
	}

	/**
	 * Returns an ordered range of all the leave balance histories where employeeId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave balance histories
	 */
	public static List<LeaveBalanceHistory> findByEmployeeIdAndYear(
		long employeeId, int year, int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return getPersistence().findByEmployeeIdAndYear(
			employeeId, year, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave balance histories where employeeId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave balance histories
	 */
	public static List<LeaveBalanceHistory> findByEmployeeIdAndYear(
		long employeeId, int year, int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeIdAndYear(
			employeeId, year, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave balance history in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory findByEmployeeIdAndYear_First(
			long employeeId, int year,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceHistoryException {

		return getPersistence().findByEmployeeIdAndYear_First(
			employeeId, year, orderByComparator);
	}

	/**
	 * Returns the first leave balance history in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory fetchByEmployeeIdAndYear_First(
		long employeeId, int year,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return getPersistence().fetchByEmployeeIdAndYear_First(
			employeeId, year, orderByComparator);
	}

	/**
	 * Returns the last leave balance history in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory findByEmployeeIdAndYear_Last(
			long employeeId, int year,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceHistoryException {

		return getPersistence().findByEmployeeIdAndYear_Last(
			employeeId, year, orderByComparator);
	}

	/**
	 * Returns the last leave balance history in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory fetchByEmployeeIdAndYear_Last(
		long employeeId, int year,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return getPersistence().fetchByEmployeeIdAndYear_Last(
			employeeId, year, orderByComparator);
	}

	/**
	 * Returns the leave balance histories before and after the current leave balance history in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param leaveBalanceHistoryId the primary key of the current leave balance history
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a leave balance history with the primary key could not be found
	 */
	public static LeaveBalanceHistory[] findByEmployeeIdAndYear_PrevAndNext(
			long leaveBalanceHistoryId, long employeeId, int year,
			OrderByComparator<LeaveBalanceHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceHistoryException {

		return getPersistence().findByEmployeeIdAndYear_PrevAndNext(
			leaveBalanceHistoryId, employeeId, year, orderByComparator);
	}

	/**
	 * Removes all the leave balance histories where employeeId = &#63; and year = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 */
	public static void removeByEmployeeIdAndYear(long employeeId, int year) {
		getPersistence().removeByEmployeeIdAndYear(employeeId, year);
	}

	/**
	 * Returns the number of leave balance histories where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @return the number of matching leave balance histories
	 */
	public static int countByEmployeeIdAndYear(long employeeId, int year) {
		return getPersistence().countByEmployeeIdAndYear(employeeId, year);
	}

	/**
	 * Caches the leave balance history in the entity cache if it is enabled.
	 *
	 * @param leaveBalanceHistory the leave balance history
	 */
	public static void cacheResult(LeaveBalanceHistory leaveBalanceHistory) {
		getPersistence().cacheResult(leaveBalanceHistory);
	}

	/**
	 * Caches the leave balance histories in the entity cache if it is enabled.
	 *
	 * @param leaveBalanceHistories the leave balance histories
	 */
	public static void cacheResult(
		List<LeaveBalanceHistory> leaveBalanceHistories) {

		getPersistence().cacheResult(leaveBalanceHistories);
	}

	/**
	 * Creates a new leave balance history with the primary key. Does not add the leave balance history to the database.
	 *
	 * @param leaveBalanceHistoryId the primary key for the new leave balance history
	 * @return the new leave balance history
	 */
	public static LeaveBalanceHistory create(long leaveBalanceHistoryId) {
		return getPersistence().create(leaveBalanceHistoryId);
	}

	/**
	 * Removes the leave balance history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveBalanceHistoryId the primary key of the leave balance history
	 * @return the leave balance history that was removed
	 * @throws NoSuchLeaveBalanceHistoryException if a leave balance history with the primary key could not be found
	 */
	public static LeaveBalanceHistory remove(long leaveBalanceHistoryId)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceHistoryException {

		return getPersistence().remove(leaveBalanceHistoryId);
	}

	public static LeaveBalanceHistory updateImpl(
		LeaveBalanceHistory leaveBalanceHistory) {

		return getPersistence().updateImpl(leaveBalanceHistory);
	}

	/**
	 * Returns the leave balance history with the primary key or throws a <code>NoSuchLeaveBalanceHistoryException</code> if it could not be found.
	 *
	 * @param leaveBalanceHistoryId the primary key of the leave balance history
	 * @return the leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a leave balance history with the primary key could not be found
	 */
	public static LeaveBalanceHistory findByPrimaryKey(
			long leaveBalanceHistoryId)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceHistoryException {

		return getPersistence().findByPrimaryKey(leaveBalanceHistoryId);
	}

	/**
	 * Returns the leave balance history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveBalanceHistoryId the primary key of the leave balance history
	 * @return the leave balance history, or <code>null</code> if a leave balance history with the primary key could not be found
	 */
	public static LeaveBalanceHistory fetchByPrimaryKey(
		long leaveBalanceHistoryId) {

		return getPersistence().fetchByPrimaryKey(leaveBalanceHistoryId);
	}

	/**
	 * Returns all the leave balance histories.
	 *
	 * @return the leave balance histories
	 */
	public static List<LeaveBalanceHistory> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the leave balance histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @return the range of leave balance histories
	 */
	public static List<LeaveBalanceHistory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the leave balance histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave balance histories
	 */
	public static List<LeaveBalanceHistory> findAll(
		int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave balance histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave balance histories
	 */
	public static List<LeaveBalanceHistory> findAll(
		int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the leave balance histories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of leave balance histories.
	 *
	 * @return the number of leave balance histories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LeaveBalanceHistoryPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		LeaveBalanceHistoryPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile LeaveBalanceHistoryPersistence _persistence;

}