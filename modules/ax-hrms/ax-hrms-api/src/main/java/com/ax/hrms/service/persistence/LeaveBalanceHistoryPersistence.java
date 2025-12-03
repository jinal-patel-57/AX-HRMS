/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchLeaveBalanceHistoryException;
import com.ax.hrms.model.LeaveBalanceHistory;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the leave balance history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveBalanceHistoryUtil
 * @generated
 */
@ProviderType
public interface LeaveBalanceHistoryPersistence
	extends BasePersistence<LeaveBalanceHistory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveBalanceHistoryUtil} to access the leave balance history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the leave balance histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave balance histories
	 */
	public java.util.List<LeaveBalanceHistory> findByUuid(String uuid);

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
	public java.util.List<LeaveBalanceHistory> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<LeaveBalanceHistory> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalanceHistory>
			orderByComparator);

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
	public java.util.List<LeaveBalanceHistory> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalanceHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave balance history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException;

	/**
	 * Returns the first leave balance history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalanceHistory>
			orderByComparator);

	/**
	 * Returns the last leave balance history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException;

	/**
	 * Returns the last leave balance history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalanceHistory>
			orderByComparator);

	/**
	 * Returns the leave balance histories before and after the current leave balance history in the ordered set where uuid = &#63;.
	 *
	 * @param leaveBalanceHistoryId the primary key of the current leave balance history
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a leave balance history with the primary key could not be found
	 */
	public LeaveBalanceHistory[] findByUuid_PrevAndNext(
			long leaveBalanceHistoryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException;

	/**
	 * Removes all the leave balance histories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of leave balance histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave balance histories
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the leave balance history where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveBalanceHistoryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory findByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveBalanceHistoryException;

	/**
	 * Returns the leave balance history where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the leave balance history where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the leave balance history where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave balance history that was removed
	 */
	public LeaveBalanceHistory removeByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveBalanceHistoryException;

	/**
	 * Returns the number of leave balance histories where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave balance histories
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the leave balance histories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave balance histories
	 */
	public java.util.List<LeaveBalanceHistory> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<LeaveBalanceHistory> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<LeaveBalanceHistory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalanceHistory>
			orderByComparator);

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
	public java.util.List<LeaveBalanceHistory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalanceHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave balance history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException;

	/**
	 * Returns the first leave balance history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalanceHistory>
			orderByComparator);

	/**
	 * Returns the last leave balance history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException;

	/**
	 * Returns the last leave balance history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalanceHistory>
			orderByComparator);

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
	public LeaveBalanceHistory[] findByUuid_C_PrevAndNext(
			long leaveBalanceHistoryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException;

	/**
	 * Removes all the leave balance histories where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of leave balance histories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave balance histories
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the leave balance histories where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching leave balance histories
	 */
	public java.util.List<LeaveBalanceHistory> findByEmployeeId(
		long employeeId);

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
	public java.util.List<LeaveBalanceHistory> findByEmployeeId(
		long employeeId, int start, int end);

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
	public java.util.List<LeaveBalanceHistory> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalanceHistory>
			orderByComparator);

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
	public java.util.List<LeaveBalanceHistory> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalanceHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave balance history in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException;

	/**
	 * Returns the first leave balance history in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalanceHistory>
			orderByComparator);

	/**
	 * Returns the last leave balance history in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException;

	/**
	 * Returns the last leave balance history in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalanceHistory>
			orderByComparator);

	/**
	 * Returns the leave balance histories before and after the current leave balance history in the ordered set where employeeId = &#63;.
	 *
	 * @param leaveBalanceHistoryId the primary key of the current leave balance history
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a leave balance history with the primary key could not be found
	 */
	public LeaveBalanceHistory[] findByEmployeeId_PrevAndNext(
			long leaveBalanceHistoryId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException;

	/**
	 * Removes all the leave balance histories where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of leave balance histories where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching leave balance histories
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the leave balance histories where year = &#63;.
	 *
	 * @param year the year
	 * @return the matching leave balance histories
	 */
	public java.util.List<LeaveBalanceHistory> findByYear(int year);

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
	public java.util.List<LeaveBalanceHistory> findByYear(
		int year, int start, int end);

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
	public java.util.List<LeaveBalanceHistory> findByYear(
		int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalanceHistory>
			orderByComparator);

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
	public java.util.List<LeaveBalanceHistory> findByYear(
		int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalanceHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave balance history in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory findByYear_First(
			int year,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException;

	/**
	 * Returns the first leave balance history in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory fetchByYear_First(
		int year,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalanceHistory>
			orderByComparator);

	/**
	 * Returns the last leave balance history in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory findByYear_Last(
			int year,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException;

	/**
	 * Returns the last leave balance history in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory fetchByYear_Last(
		int year,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalanceHistory>
			orderByComparator);

	/**
	 * Returns the leave balance histories before and after the current leave balance history in the ordered set where year = &#63;.
	 *
	 * @param leaveBalanceHistoryId the primary key of the current leave balance history
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a leave balance history with the primary key could not be found
	 */
	public LeaveBalanceHistory[] findByYear_PrevAndNext(
			long leaveBalanceHistoryId, int year,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException;

	/**
	 * Removes all the leave balance histories where year = &#63; from the database.
	 *
	 * @param year the year
	 */
	public void removeByYear(int year);

	/**
	 * Returns the number of leave balance histories where year = &#63;.
	 *
	 * @param year the year
	 * @return the number of matching leave balance histories
	 */
	public int countByYear(int year);

	/**
	 * Returns all the leave balance histories where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @return the matching leave balance histories
	 */
	public java.util.List<LeaveBalanceHistory> findByEmployeeIdAndYear(
		long employeeId, int year);

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
	public java.util.List<LeaveBalanceHistory> findByEmployeeIdAndYear(
		long employeeId, int year, int start, int end);

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
	public java.util.List<LeaveBalanceHistory> findByEmployeeIdAndYear(
		long employeeId, int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalanceHistory>
			orderByComparator);

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
	public java.util.List<LeaveBalanceHistory> findByEmployeeIdAndYear(
		long employeeId, int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalanceHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave balance history in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory findByEmployeeIdAndYear_First(
			long employeeId, int year,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException;

	/**
	 * Returns the first leave balance history in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory fetchByEmployeeIdAndYear_First(
		long employeeId, int year,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalanceHistory>
			orderByComparator);

	/**
	 * Returns the last leave balance history in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory findByEmployeeIdAndYear_Last(
			long employeeId, int year,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException;

	/**
	 * Returns the last leave balance history in the ordered set where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public LeaveBalanceHistory fetchByEmployeeIdAndYear_Last(
		long employeeId, int year,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalanceHistory>
			orderByComparator);

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
	public LeaveBalanceHistory[] findByEmployeeIdAndYear_PrevAndNext(
			long leaveBalanceHistoryId, long employeeId, int year,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveBalanceHistory> orderByComparator)
		throws NoSuchLeaveBalanceHistoryException;

	/**
	 * Removes all the leave balance histories where employeeId = &#63; and year = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 */
	public void removeByEmployeeIdAndYear(long employeeId, int year);

	/**
	 * Returns the number of leave balance histories where employeeId = &#63; and year = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param year the year
	 * @return the number of matching leave balance histories
	 */
	public int countByEmployeeIdAndYear(long employeeId, int year);

	/**
	 * Caches the leave balance history in the entity cache if it is enabled.
	 *
	 * @param leaveBalanceHistory the leave balance history
	 */
	public void cacheResult(LeaveBalanceHistory leaveBalanceHistory);

	/**
	 * Caches the leave balance histories in the entity cache if it is enabled.
	 *
	 * @param leaveBalanceHistories the leave balance histories
	 */
	public void cacheResult(
		java.util.List<LeaveBalanceHistory> leaveBalanceHistories);

	/**
	 * Creates a new leave balance history with the primary key. Does not add the leave balance history to the database.
	 *
	 * @param leaveBalanceHistoryId the primary key for the new leave balance history
	 * @return the new leave balance history
	 */
	public LeaveBalanceHistory create(long leaveBalanceHistoryId);

	/**
	 * Removes the leave balance history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveBalanceHistoryId the primary key of the leave balance history
	 * @return the leave balance history that was removed
	 * @throws NoSuchLeaveBalanceHistoryException if a leave balance history with the primary key could not be found
	 */
	public LeaveBalanceHistory remove(long leaveBalanceHistoryId)
		throws NoSuchLeaveBalanceHistoryException;

	public LeaveBalanceHistory updateImpl(
		LeaveBalanceHistory leaveBalanceHistory);

	/**
	 * Returns the leave balance history with the primary key or throws a <code>NoSuchLeaveBalanceHistoryException</code> if it could not be found.
	 *
	 * @param leaveBalanceHistoryId the primary key of the leave balance history
	 * @return the leave balance history
	 * @throws NoSuchLeaveBalanceHistoryException if a leave balance history with the primary key could not be found
	 */
	public LeaveBalanceHistory findByPrimaryKey(long leaveBalanceHistoryId)
		throws NoSuchLeaveBalanceHistoryException;

	/**
	 * Returns the leave balance history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveBalanceHistoryId the primary key of the leave balance history
	 * @return the leave balance history, or <code>null</code> if a leave balance history with the primary key could not be found
	 */
	public LeaveBalanceHistory fetchByPrimaryKey(long leaveBalanceHistoryId);

	/**
	 * Returns all the leave balance histories.
	 *
	 * @return the leave balance histories
	 */
	public java.util.List<LeaveBalanceHistory> findAll();

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
	public java.util.List<LeaveBalanceHistory> findAll(int start, int end);

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
	public java.util.List<LeaveBalanceHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalanceHistory>
			orderByComparator);

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
	public java.util.List<LeaveBalanceHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveBalanceHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the leave balance histories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of leave balance histories.
	 *
	 * @return the number of leave balance histories
	 */
	public int countAll();

}