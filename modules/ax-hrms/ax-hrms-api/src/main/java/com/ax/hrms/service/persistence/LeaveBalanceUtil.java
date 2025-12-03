/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.LeaveBalance;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the leave balance service. This utility wraps <code>com.ax.hrms.service.persistence.impl.LeaveBalancePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveBalancePersistence
 * @generated
 */
public class LeaveBalanceUtil {

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
	public static void clearCache(LeaveBalance leaveBalance) {
		getPersistence().clearCache(leaveBalance);
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
	public static Map<Serializable, LeaveBalance> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LeaveBalance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LeaveBalance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LeaveBalance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LeaveBalance update(LeaveBalance leaveBalance) {
		return getPersistence().update(leaveBalance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LeaveBalance update(
		LeaveBalance leaveBalance, ServiceContext serviceContext) {

		return getPersistence().update(leaveBalance, serviceContext);
	}

	/**
	 * Returns all the leave balances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave balances
	 */
	public static List<LeaveBalance> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the leave balances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @return the range of matching leave balances
	 */
	public static List<LeaveBalance> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the leave balances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave balances
	 */
	public static List<LeaveBalance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave balances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave balances
	 */
	public static List<LeaveBalance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave balance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public static LeaveBalance findByUuid_First(
			String uuid, OrderByComparator<LeaveBalance> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first leave balance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public static LeaveBalance fetchByUuid_First(
		String uuid, OrderByComparator<LeaveBalance> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last leave balance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public static LeaveBalance findByUuid_Last(
			String uuid, OrderByComparator<LeaveBalance> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last leave balance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public static LeaveBalance fetchByUuid_Last(
		String uuid, OrderByComparator<LeaveBalance> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the leave balances before and after the current leave balance in the ordered set where uuid = &#63;.
	 *
	 * @param leaveBalanceId the primary key of the current leave balance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	public static LeaveBalance[] findByUuid_PrevAndNext(
			long leaveBalanceId, String uuid,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().findByUuid_PrevAndNext(
			leaveBalanceId, uuid, orderByComparator);
	}

	/**
	 * Removes all the leave balances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of leave balances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave balances
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the leave balance where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveBalanceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public static LeaveBalance findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the leave balance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public static LeaveBalance fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the leave balance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public static LeaveBalance fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the leave balance where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave balance that was removed
	 */
	public static LeaveBalance removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of leave balances where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave balances
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the leave balances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave balances
	 */
	public static List<LeaveBalance> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the leave balances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @return the range of matching leave balances
	 */
	public static List<LeaveBalance> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the leave balances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave balances
	 */
	public static List<LeaveBalance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave balances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave balances
	 */
	public static List<LeaveBalance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave balance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public static LeaveBalance findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first leave balance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public static LeaveBalance fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LeaveBalance> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last leave balance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public static LeaveBalance findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last leave balance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public static LeaveBalance fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LeaveBalance> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the leave balances before and after the current leave balance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveBalanceId the primary key of the current leave balance
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	public static LeaveBalance[] findByUuid_C_PrevAndNext(
			long leaveBalanceId, String uuid, long companyId,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().findByUuid_C_PrevAndNext(
			leaveBalanceId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the leave balances where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of leave balances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave balances
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; or throws a <code>NoSuchLeaveBalanceException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public static LeaveBalance findByEmployeeIdAndLeaveTypeMasterId(
			long employeeId, long leaveTypeMasterId)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().findByEmployeeIdAndLeaveTypeMasterId(
			employeeId, leaveTypeMasterId);
	}

	/**
	 * Returns the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public static LeaveBalance fetchByEmployeeIdAndLeaveTypeMasterId(
		long employeeId, long leaveTypeMasterId) {

		return getPersistence().fetchByEmployeeIdAndLeaveTypeMasterId(
			employeeId, leaveTypeMasterId);
	}

	/**
	 * Returns the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public static LeaveBalance fetchByEmployeeIdAndLeaveTypeMasterId(
		long employeeId, long leaveTypeMasterId, boolean useFinderCache) {

		return getPersistence().fetchByEmployeeIdAndLeaveTypeMasterId(
			employeeId, leaveTypeMasterId, useFinderCache);
	}

	/**
	 * Removes the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the leave balance that was removed
	 */
	public static LeaveBalance removeByEmployeeIdAndLeaveTypeMasterId(
			long employeeId, long leaveTypeMasterId)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().removeByEmployeeIdAndLeaveTypeMasterId(
			employeeId, leaveTypeMasterId);
	}

	/**
	 * Returns the number of leave balances where employeeId = &#63; and leaveTypeMasterId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the number of matching leave balances
	 */
	public static int countByEmployeeIdAndLeaveTypeMasterId(
		long employeeId, long leaveTypeMasterId) {

		return getPersistence().countByEmployeeIdAndLeaveTypeMasterId(
			employeeId, leaveTypeMasterId);
	}

	/**
	 * Returns all the leave balances where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching leave balances
	 */
	public static List<LeaveBalance> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the leave balances where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @return the range of matching leave balances
	 */
	public static List<LeaveBalance> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the leave balances where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave balances
	 */
	public static List<LeaveBalance> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave balances where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave balances
	 */
	public static List<LeaveBalance> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave balance in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public static LeaveBalance findByEmployeeId_First(
			long employeeId, OrderByComparator<LeaveBalance> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first leave balance in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public static LeaveBalance fetchByEmployeeId_First(
		long employeeId, OrderByComparator<LeaveBalance> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last leave balance in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public static LeaveBalance findByEmployeeId_Last(
			long employeeId, OrderByComparator<LeaveBalance> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last leave balance in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public static LeaveBalance fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<LeaveBalance> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the leave balances before and after the current leave balance in the ordered set where employeeId = &#63;.
	 *
	 * @param leaveBalanceId the primary key of the current leave balance
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	public static LeaveBalance[] findByEmployeeId_PrevAndNext(
			long leaveBalanceId, long employeeId,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			leaveBalanceId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the leave balances where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of leave balances where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching leave balances
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the leave balances where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @return the matching leave balances
	 */
	public static List<LeaveBalance> findByEmployeeIdAndYear(
		long employeeId, int year) {

		return getPersistence().findByEmployeeIdAndYear(employeeId, year);
	}

	/**
	 * Returns a range of all the leave balances where employeeId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @return the range of matching leave balances
	 */
	public static List<LeaveBalance> findByEmployeeIdAndYear(
		long employeeId, int year, int start, int end) {

		return getPersistence().findByEmployeeIdAndYear(
			employeeId, year, start, end);
	}

	/**
	 * Returns an ordered range of all the leave balances where employeeId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave balances
	 */
	public static List<LeaveBalance> findByEmployeeIdAndYear(
		long employeeId, int year, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator) {

		return getPersistence().findByEmployeeIdAndYear(
			employeeId, year, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave balances where employeeId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave balances
	 */
	public static List<LeaveBalance> findByEmployeeIdAndYear(
		long employeeId, int year, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeIdAndYear(
			employeeId, year, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave balance in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public static LeaveBalance findByEmployeeIdAndYear_First(
			long employeeId, int year,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().findByEmployeeIdAndYear_First(
			employeeId, year, orderByComparator);
	}

	/**
	 * Returns the first leave balance in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public static LeaveBalance fetchByEmployeeIdAndYear_First(
		long employeeId, int year,
		OrderByComparator<LeaveBalance> orderByComparator) {

		return getPersistence().fetchByEmployeeIdAndYear_First(
			employeeId, year, orderByComparator);
	}

	/**
	 * Returns the last leave balance in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public static LeaveBalance findByEmployeeIdAndYear_Last(
			long employeeId, int year,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().findByEmployeeIdAndYear_Last(
			employeeId, year, orderByComparator);
	}

	/**
	 * Returns the last leave balance in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public static LeaveBalance fetchByEmployeeIdAndYear_Last(
		long employeeId, int year,
		OrderByComparator<LeaveBalance> orderByComparator) {

		return getPersistence().fetchByEmployeeIdAndYear_Last(
			employeeId, year, orderByComparator);
	}

	/**
	 * Returns the leave balances before and after the current leave balance in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param leaveBalanceId the primary key of the current leave balance
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	public static LeaveBalance[] findByEmployeeIdAndYear_PrevAndNext(
			long leaveBalanceId, long employeeId, int year,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().findByEmployeeIdAndYear_PrevAndNext(
			leaveBalanceId, employeeId, year, orderByComparator);
	}

	/**
	 * Removes all the leave balances where employeeId = &#63; and year = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 */
	public static void removeByEmployeeIdAndYear(long employeeId, int year) {
		getPersistence().removeByEmployeeIdAndYear(employeeId, year);
	}

	/**
	 * Returns the number of leave balances where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @return the number of matching leave balances
	 */
	public static int countByEmployeeIdAndYear(long employeeId, int year) {
		return getPersistence().countByEmployeeIdAndYear(employeeId, year);
	}

	/**
	 * Returns all the leave balances where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @return the matching leave balances
	 */
	public static List<LeaveBalance> findByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int year) {

		return getPersistence().findByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, year);
	}

	/**
	 * Returns a range of all the leave balances where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @return the range of matching leave balances
	 */
	public static List<LeaveBalance> findByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int year, int start, int end) {

		return getPersistence().findByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, year, start, end);
	}

	/**
	 * Returns an ordered range of all the leave balances where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave balances
	 */
	public static List<LeaveBalance> findByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int year, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator) {

		return getPersistence().findByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, year, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave balances where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave balances
	 */
	public static List<LeaveBalance> findByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int year, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, year, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first leave balance in the ordered set where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public static LeaveBalance findByLeaveTypeMasterIdAndYear_First(
			long leaveTypeMasterId, int year,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().findByLeaveTypeMasterIdAndYear_First(
			leaveTypeMasterId, year, orderByComparator);
	}

	/**
	 * Returns the first leave balance in the ordered set where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public static LeaveBalance fetchByLeaveTypeMasterIdAndYear_First(
		long leaveTypeMasterId, int year,
		OrderByComparator<LeaveBalance> orderByComparator) {

		return getPersistence().fetchByLeaveTypeMasterIdAndYear_First(
			leaveTypeMasterId, year, orderByComparator);
	}

	/**
	 * Returns the last leave balance in the ordered set where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public static LeaveBalance findByLeaveTypeMasterIdAndYear_Last(
			long leaveTypeMasterId, int year,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().findByLeaveTypeMasterIdAndYear_Last(
			leaveTypeMasterId, year, orderByComparator);
	}

	/**
	 * Returns the last leave balance in the ordered set where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public static LeaveBalance fetchByLeaveTypeMasterIdAndYear_Last(
		long leaveTypeMasterId, int year,
		OrderByComparator<LeaveBalance> orderByComparator) {

		return getPersistence().fetchByLeaveTypeMasterIdAndYear_Last(
			leaveTypeMasterId, year, orderByComparator);
	}

	/**
	 * Returns the leave balances before and after the current leave balance in the ordered set where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param leaveBalanceId the primary key of the current leave balance
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	public static LeaveBalance[] findByLeaveTypeMasterIdAndYear_PrevAndNext(
			long leaveBalanceId, long leaveTypeMasterId, int year,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().findByLeaveTypeMasterIdAndYear_PrevAndNext(
			leaveBalanceId, leaveTypeMasterId, year, orderByComparator);
	}

	/**
	 * Removes all the leave balances where leaveTypeMasterId = &#63; and year = &#63; from the database.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 */
	public static void removeByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int year) {

		getPersistence().removeByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, year);
	}

	/**
	 * Returns the number of leave balances where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @return the number of matching leave balances
	 */
	public static int countByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int year) {

		return getPersistence().countByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, year);
	}

	/**
	 * Returns all the leave balances where year = &#63;.
	 *
	 * @param year the year
	 * @return the matching leave balances
	 */
	public static List<LeaveBalance> findByYear(int year) {
		return getPersistence().findByYear(year);
	}

	/**
	 * Returns a range of all the leave balances where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @return the range of matching leave balances
	 */
	public static List<LeaveBalance> findByYear(int year, int start, int end) {
		return getPersistence().findByYear(year, start, end);
	}

	/**
	 * Returns an ordered range of all the leave balances where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave balances
	 */
	public static List<LeaveBalance> findByYear(
		int year, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator) {

		return getPersistence().findByYear(year, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave balances where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave balances
	 */
	public static List<LeaveBalance> findByYear(
		int year, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByYear(
			year, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave balance in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public static LeaveBalance findByYear_First(
			int year, OrderByComparator<LeaveBalance> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().findByYear_First(year, orderByComparator);
	}

	/**
	 * Returns the first leave balance in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public static LeaveBalance fetchByYear_First(
		int year, OrderByComparator<LeaveBalance> orderByComparator) {

		return getPersistence().fetchByYear_First(year, orderByComparator);
	}

	/**
	 * Returns the last leave balance in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public static LeaveBalance findByYear_Last(
			int year, OrderByComparator<LeaveBalance> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().findByYear_Last(year, orderByComparator);
	}

	/**
	 * Returns the last leave balance in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public static LeaveBalance fetchByYear_Last(
		int year, OrderByComparator<LeaveBalance> orderByComparator) {

		return getPersistence().fetchByYear_Last(year, orderByComparator);
	}

	/**
	 * Returns the leave balances before and after the current leave balance in the ordered set where year = &#63;.
	 *
	 * @param leaveBalanceId the primary key of the current leave balance
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	public static LeaveBalance[] findByYear_PrevAndNext(
			long leaveBalanceId, int year,
			OrderByComparator<LeaveBalance> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().findByYear_PrevAndNext(
			leaveBalanceId, year, orderByComparator);
	}

	/**
	 * Removes all the leave balances where year = &#63; from the database.
	 *
	 * @param year the year
	 */
	public static void removeByYear(int year) {
		getPersistence().removeByYear(year);
	}

	/**
	 * Returns the number of leave balances where year = &#63;.
	 *
	 * @param year the year
	 * @return the number of matching leave balances
	 */
	public static int countByYear(int year) {
		return getPersistence().countByYear(year);
	}

	/**
	 * Returns the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; and year = &#63; or throws a <code>NoSuchLeaveBalanceException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @return the matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public static LeaveBalance findByEmployeeIdLeaveTypeMasterIdAndYear(
			long employeeId, long leaveTypeMasterId, int year)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().findByEmployeeIdLeaveTypeMasterIdAndYear(
			employeeId, leaveTypeMasterId, year);
	}

	/**
	 * Returns the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; and year = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public static LeaveBalance fetchByEmployeeIdLeaveTypeMasterIdAndYear(
		long employeeId, long leaveTypeMasterId, int year) {

		return getPersistence().fetchByEmployeeIdLeaveTypeMasterIdAndYear(
			employeeId, leaveTypeMasterId, year);
	}

	/**
	 * Returns the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; and year = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public static LeaveBalance fetchByEmployeeIdLeaveTypeMasterIdAndYear(
		long employeeId, long leaveTypeMasterId, int year,
		boolean useFinderCache) {

		return getPersistence().fetchByEmployeeIdLeaveTypeMasterIdAndYear(
			employeeId, leaveTypeMasterId, year, useFinderCache);
	}

	/**
	 * Removes the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; and year = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @return the leave balance that was removed
	 */
	public static LeaveBalance removeByEmployeeIdLeaveTypeMasterIdAndYear(
			long employeeId, long leaveTypeMasterId, int year)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().removeByEmployeeIdLeaveTypeMasterIdAndYear(
			employeeId, leaveTypeMasterId, year);
	}

	/**
	 * Returns the number of leave balances where employeeId = &#63; and leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @return the number of matching leave balances
	 */
	public static int countByEmployeeIdLeaveTypeMasterIdAndYear(
		long employeeId, long leaveTypeMasterId, int year) {

		return getPersistence().countByEmployeeIdLeaveTypeMasterIdAndYear(
			employeeId, leaveTypeMasterId, year);
	}

	/**
	 * Caches the leave balance in the entity cache if it is enabled.
	 *
	 * @param leaveBalance the leave balance
	 */
	public static void cacheResult(LeaveBalance leaveBalance) {
		getPersistence().cacheResult(leaveBalance);
	}

	/**
	 * Caches the leave balances in the entity cache if it is enabled.
	 *
	 * @param leaveBalances the leave balances
	 */
	public static void cacheResult(List<LeaveBalance> leaveBalances) {
		getPersistence().cacheResult(leaveBalances);
	}

	/**
	 * Creates a new leave balance with the primary key. Does not add the leave balance to the database.
	 *
	 * @param leaveBalanceId the primary key for the new leave balance
	 * @return the new leave balance
	 */
	public static LeaveBalance create(long leaveBalanceId) {
		return getPersistence().create(leaveBalanceId);
	}

	/**
	 * Removes the leave balance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveBalanceId the primary key of the leave balance
	 * @return the leave balance that was removed
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	public static LeaveBalance remove(long leaveBalanceId)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().remove(leaveBalanceId);
	}

	public static LeaveBalance updateImpl(LeaveBalance leaveBalance) {
		return getPersistence().updateImpl(leaveBalance);
	}

	/**
	 * Returns the leave balance with the primary key or throws a <code>NoSuchLeaveBalanceException</code> if it could not be found.
	 *
	 * @param leaveBalanceId the primary key of the leave balance
	 * @return the leave balance
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	public static LeaveBalance findByPrimaryKey(long leaveBalanceId)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getPersistence().findByPrimaryKey(leaveBalanceId);
	}

	/**
	 * Returns the leave balance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveBalanceId the primary key of the leave balance
	 * @return the leave balance, or <code>null</code> if a leave balance with the primary key could not be found
	 */
	public static LeaveBalance fetchByPrimaryKey(long leaveBalanceId) {
		return getPersistence().fetchByPrimaryKey(leaveBalanceId);
	}

	/**
	 * Returns all the leave balances.
	 *
	 * @return the leave balances
	 */
	public static List<LeaveBalance> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the leave balances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @return the range of leave balances
	 */
	public static List<LeaveBalance> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the leave balances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave balances
	 */
	public static List<LeaveBalance> findAll(
		int start, int end, OrderByComparator<LeaveBalance> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave balances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave balances
	 */
	public static List<LeaveBalance> findAll(
		int start, int end, OrderByComparator<LeaveBalance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the leave balances from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of leave balances.
	 *
	 * @return the number of leave balances
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LeaveBalancePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(LeaveBalancePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile LeaveBalancePersistence _persistence;

}