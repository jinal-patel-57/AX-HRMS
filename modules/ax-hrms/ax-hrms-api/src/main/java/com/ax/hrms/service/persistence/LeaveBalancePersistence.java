/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchLeaveBalanceException;
import com.ax.hrms.model.LeaveBalance;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the leave balance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveBalanceUtil
 * @generated
 */
@ProviderType
public interface LeaveBalancePersistence extends BasePersistence<LeaveBalance> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveBalanceUtil} to access the leave balance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the leave balances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave balances
	 */
	public java.util.List<LeaveBalance> findByUuid(String uuid);

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
	public java.util.List<LeaveBalance> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<LeaveBalance> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator);

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
	public java.util.List<LeaveBalance> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave balance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public LeaveBalance findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
				orderByComparator)
		throws NoSuchLeaveBalanceException;

	/**
	 * Returns the first leave balance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public LeaveBalance fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator);

	/**
	 * Returns the last leave balance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public LeaveBalance findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
				orderByComparator)
		throws NoSuchLeaveBalanceException;

	/**
	 * Returns the last leave balance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public LeaveBalance fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator);

	/**
	 * Returns the leave balances before and after the current leave balance in the ordered set where uuid = &#63;.
	 *
	 * @param leaveBalanceId the primary key of the current leave balance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	public LeaveBalance[] findByUuid_PrevAndNext(
			long leaveBalanceId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
				orderByComparator)
		throws NoSuchLeaveBalanceException;

	/**
	 * Removes all the leave balances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of leave balances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave balances
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the leave balance where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveBalanceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public LeaveBalance findByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveBalanceException;

	/**
	 * Returns the leave balance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public LeaveBalance fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the leave balance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public LeaveBalance fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the leave balance where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave balance that was removed
	 */
	public LeaveBalance removeByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveBalanceException;

	/**
	 * Returns the number of leave balances where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave balances
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the leave balances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave balances
	 */
	public java.util.List<LeaveBalance> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<LeaveBalance> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<LeaveBalance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator);

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
	public java.util.List<LeaveBalance> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave balance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public LeaveBalance findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
				orderByComparator)
		throws NoSuchLeaveBalanceException;

	/**
	 * Returns the first leave balance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public LeaveBalance fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator);

	/**
	 * Returns the last leave balance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public LeaveBalance findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
				orderByComparator)
		throws NoSuchLeaveBalanceException;

	/**
	 * Returns the last leave balance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public LeaveBalance fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator);

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
	public LeaveBalance[] findByUuid_C_PrevAndNext(
			long leaveBalanceId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
				orderByComparator)
		throws NoSuchLeaveBalanceException;

	/**
	 * Removes all the leave balances where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of leave balances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave balances
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; or throws a <code>NoSuchLeaveBalanceException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public LeaveBalance findByEmployeeIdAndLeaveTypeMasterId(
			long employeeId, long leaveTypeMasterId)
		throws NoSuchLeaveBalanceException;

	/**
	 * Returns the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public LeaveBalance fetchByEmployeeIdAndLeaveTypeMasterId(
		long employeeId, long leaveTypeMasterId);

	/**
	 * Returns the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public LeaveBalance fetchByEmployeeIdAndLeaveTypeMasterId(
		long employeeId, long leaveTypeMasterId, boolean useFinderCache);

	/**
	 * Removes the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the leave balance that was removed
	 */
	public LeaveBalance removeByEmployeeIdAndLeaveTypeMasterId(
			long employeeId, long leaveTypeMasterId)
		throws NoSuchLeaveBalanceException;

	/**
	 * Returns the number of leave balances where employeeId = &#63; and leaveTypeMasterId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the number of matching leave balances
	 */
	public int countByEmployeeIdAndLeaveTypeMasterId(
		long employeeId, long leaveTypeMasterId);

	/**
	 * Returns all the leave balances where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching leave balances
	 */
	public java.util.List<LeaveBalance> findByEmployeeId(long employeeId);

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
	public java.util.List<LeaveBalance> findByEmployeeId(
		long employeeId, int start, int end);

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
	public java.util.List<LeaveBalance> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator);

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
	public java.util.List<LeaveBalance> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave balance in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public LeaveBalance findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
				orderByComparator)
		throws NoSuchLeaveBalanceException;

	/**
	 * Returns the first leave balance in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public LeaveBalance fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator);

	/**
	 * Returns the last leave balance in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public LeaveBalance findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
				orderByComparator)
		throws NoSuchLeaveBalanceException;

	/**
	 * Returns the last leave balance in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public LeaveBalance fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator);

	/**
	 * Returns the leave balances before and after the current leave balance in the ordered set where employeeId = &#63;.
	 *
	 * @param leaveBalanceId the primary key of the current leave balance
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	public LeaveBalance[] findByEmployeeId_PrevAndNext(
			long leaveBalanceId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
				orderByComparator)
		throws NoSuchLeaveBalanceException;

	/**
	 * Removes all the leave balances where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of leave balances where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching leave balances
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the leave balances where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @return the matching leave balances
	 */
	public java.util.List<LeaveBalance> findByEmployeeIdAndYear(
		long employeeId, int year);

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
	public java.util.List<LeaveBalance> findByEmployeeIdAndYear(
		long employeeId, int year, int start, int end);

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
	public java.util.List<LeaveBalance> findByEmployeeIdAndYear(
		long employeeId, int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator);

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
	public java.util.List<LeaveBalance> findByEmployeeIdAndYear(
		long employeeId, int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave balance in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public LeaveBalance findByEmployeeIdAndYear_First(
			long employeeId, int year,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
				orderByComparator)
		throws NoSuchLeaveBalanceException;

	/**
	 * Returns the first leave balance in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public LeaveBalance fetchByEmployeeIdAndYear_First(
		long employeeId, int year,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator);

	/**
	 * Returns the last leave balance in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public LeaveBalance findByEmployeeIdAndYear_Last(
			long employeeId, int year,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
				orderByComparator)
		throws NoSuchLeaveBalanceException;

	/**
	 * Returns the last leave balance in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public LeaveBalance fetchByEmployeeIdAndYear_Last(
		long employeeId, int year,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator);

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
	public LeaveBalance[] findByEmployeeIdAndYear_PrevAndNext(
			long leaveBalanceId, long employeeId, int year,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
				orderByComparator)
		throws NoSuchLeaveBalanceException;

	/**
	 * Removes all the leave balances where employeeId = &#63; and year = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 */
	public void removeByEmployeeIdAndYear(long employeeId, int year);

	/**
	 * Returns the number of leave balances where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @return the number of matching leave balances
	 */
	public int countByEmployeeIdAndYear(long employeeId, int year);

	/**
	 * Returns all the leave balances where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @return the matching leave balances
	 */
	public java.util.List<LeaveBalance> findByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int year);

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
	public java.util.List<LeaveBalance> findByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int year, int start, int end);

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
	public java.util.List<LeaveBalance> findByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator);

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
	public java.util.List<LeaveBalance> findByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave balance in the ordered set where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public LeaveBalance findByLeaveTypeMasterIdAndYear_First(
			long leaveTypeMasterId, int year,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
				orderByComparator)
		throws NoSuchLeaveBalanceException;

	/**
	 * Returns the first leave balance in the ordered set where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public LeaveBalance fetchByLeaveTypeMasterIdAndYear_First(
		long leaveTypeMasterId, int year,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator);

	/**
	 * Returns the last leave balance in the ordered set where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public LeaveBalance findByLeaveTypeMasterIdAndYear_Last(
			long leaveTypeMasterId, int year,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
				orderByComparator)
		throws NoSuchLeaveBalanceException;

	/**
	 * Returns the last leave balance in the ordered set where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public LeaveBalance fetchByLeaveTypeMasterIdAndYear_Last(
		long leaveTypeMasterId, int year,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator);

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
	public LeaveBalance[] findByLeaveTypeMasterIdAndYear_PrevAndNext(
			long leaveBalanceId, long leaveTypeMasterId, int year,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
				orderByComparator)
		throws NoSuchLeaveBalanceException;

	/**
	 * Removes all the leave balances where leaveTypeMasterId = &#63; and year = &#63; from the database.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 */
	public void removeByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int year);

	/**
	 * Returns the number of leave balances where leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @return the number of matching leave balances
	 */
	public int countByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int year);

	/**
	 * Returns all the leave balances where year = &#63;.
	 *
	 * @param year the year
	 * @return the matching leave balances
	 */
	public java.util.List<LeaveBalance> findByYear(int year);

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
	public java.util.List<LeaveBalance> findByYear(
		int year, int start, int end);

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
	public java.util.List<LeaveBalance> findByYear(
		int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator);

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
	public java.util.List<LeaveBalance> findByYear(
		int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave balance in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public LeaveBalance findByYear_First(
			int year,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
				orderByComparator)
		throws NoSuchLeaveBalanceException;

	/**
	 * Returns the first leave balance in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public LeaveBalance fetchByYear_First(
		int year,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator);

	/**
	 * Returns the last leave balance in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public LeaveBalance findByYear_Last(
			int year,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
				orderByComparator)
		throws NoSuchLeaveBalanceException;

	/**
	 * Returns the last leave balance in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public LeaveBalance fetchByYear_Last(
		int year,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator);

	/**
	 * Returns the leave balances before and after the current leave balance in the ordered set where year = &#63;.
	 *
	 * @param leaveBalanceId the primary key of the current leave balance
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	public LeaveBalance[] findByYear_PrevAndNext(
			long leaveBalanceId, int year,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
				orderByComparator)
		throws NoSuchLeaveBalanceException;

	/**
	 * Removes all the leave balances where year = &#63; from the database.
	 *
	 * @param year the year
	 */
	public void removeByYear(int year);

	/**
	 * Returns the number of leave balances where year = &#63;.
	 *
	 * @param year the year
	 * @return the number of matching leave balances
	 */
	public int countByYear(int year);

	/**
	 * Returns the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; and year = &#63; or throws a <code>NoSuchLeaveBalanceException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @return the matching leave balance
	 * @throws NoSuchLeaveBalanceException if a matching leave balance could not be found
	 */
	public LeaveBalance findByEmployeeIdLeaveTypeMasterIdAndYear(
			long employeeId, long leaveTypeMasterId, int year)
		throws NoSuchLeaveBalanceException;

	/**
	 * Returns the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; and year = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public LeaveBalance fetchByEmployeeIdLeaveTypeMasterIdAndYear(
		long employeeId, long leaveTypeMasterId, int year);

	/**
	 * Returns the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; and year = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public LeaveBalance fetchByEmployeeIdLeaveTypeMasterIdAndYear(
		long employeeId, long leaveTypeMasterId, int year,
		boolean useFinderCache);

	/**
	 * Removes the leave balance where employeeId = &#63; and leaveTypeMasterId = &#63; and year = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @return the leave balance that was removed
	 */
	public LeaveBalance removeByEmployeeIdLeaveTypeMasterIdAndYear(
			long employeeId, long leaveTypeMasterId, int year)
		throws NoSuchLeaveBalanceException;

	/**
	 * Returns the number of leave balances where employeeId = &#63; and leaveTypeMasterId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @param year the year
	 * @return the number of matching leave balances
	 */
	public int countByEmployeeIdLeaveTypeMasterIdAndYear(
		long employeeId, long leaveTypeMasterId, int year);

	/**
	 * Caches the leave balance in the entity cache if it is enabled.
	 *
	 * @param leaveBalance the leave balance
	 */
	public void cacheResult(LeaveBalance leaveBalance);

	/**
	 * Caches the leave balances in the entity cache if it is enabled.
	 *
	 * @param leaveBalances the leave balances
	 */
	public void cacheResult(java.util.List<LeaveBalance> leaveBalances);

	/**
	 * Creates a new leave balance with the primary key. Does not add the leave balance to the database.
	 *
	 * @param leaveBalanceId the primary key for the new leave balance
	 * @return the new leave balance
	 */
	public LeaveBalance create(long leaveBalanceId);

	/**
	 * Removes the leave balance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveBalanceId the primary key of the leave balance
	 * @return the leave balance that was removed
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	public LeaveBalance remove(long leaveBalanceId)
		throws NoSuchLeaveBalanceException;

	public LeaveBalance updateImpl(LeaveBalance leaveBalance);

	/**
	 * Returns the leave balance with the primary key or throws a <code>NoSuchLeaveBalanceException</code> if it could not be found.
	 *
	 * @param leaveBalanceId the primary key of the leave balance
	 * @return the leave balance
	 * @throws NoSuchLeaveBalanceException if a leave balance with the primary key could not be found
	 */
	public LeaveBalance findByPrimaryKey(long leaveBalanceId)
		throws NoSuchLeaveBalanceException;

	/**
	 * Returns the leave balance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveBalanceId the primary key of the leave balance
	 * @return the leave balance, or <code>null</code> if a leave balance with the primary key could not be found
	 */
	public LeaveBalance fetchByPrimaryKey(long leaveBalanceId);

	/**
	 * Returns all the leave balances.
	 *
	 * @return the leave balances
	 */
	public java.util.List<LeaveBalance> findAll();

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
	public java.util.List<LeaveBalance> findAll(int start, int end);

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
	public java.util.List<LeaveBalance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator);

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
	public java.util.List<LeaveBalance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalance>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the leave balances from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of leave balances.
	 *
	 * @return the number of leave balances
	 */
	public int countAll();

}