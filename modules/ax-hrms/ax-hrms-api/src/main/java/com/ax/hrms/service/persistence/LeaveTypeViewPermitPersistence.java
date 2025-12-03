/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchLeaveTypeViewPermitException;
import com.ax.hrms.model.LeaveTypeViewPermit;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the leave type view permit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTypeViewPermitUtil
 * @generated
 */
@ProviderType
public interface LeaveTypeViewPermitPersistence
	extends BasePersistence<LeaveTypeViewPermit> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveTypeViewPermitUtil} to access the leave type view permit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the leave type view permits where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave type view permits
	 */
	public java.util.List<LeaveTypeViewPermit> findByUuid(String uuid);

	/**
	 * Returns a range of all the leave type view permits where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeViewPermitModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave type view permits
	 * @param end the upper bound of the range of leave type view permits (not inclusive)
	 * @return the range of matching leave type view permits
	 */
	public java.util.List<LeaveTypeViewPermit> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the leave type view permits where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeViewPermitModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave type view permits
	 * @param end the upper bound of the range of leave type view permits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave type view permits
	 */
	public java.util.List<LeaveTypeViewPermit> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypeViewPermit>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave type view permits where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeViewPermitModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave type view permits
	 * @param end the upper bound of the range of leave type view permits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave type view permits
	 */
	public java.util.List<LeaveTypeViewPermit> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypeViewPermit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave type view permit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type view permit
	 * @throws NoSuchLeaveTypeViewPermitException if a matching leave type view permit could not be found
	 */
	public LeaveTypeViewPermit findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveTypeViewPermit> orderByComparator)
		throws NoSuchLeaveTypeViewPermitException;

	/**
	 * Returns the first leave type view permit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type view permit, or <code>null</code> if a matching leave type view permit could not be found
	 */
	public LeaveTypeViewPermit fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypeViewPermit>
			orderByComparator);

	/**
	 * Returns the last leave type view permit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type view permit
	 * @throws NoSuchLeaveTypeViewPermitException if a matching leave type view permit could not be found
	 */
	public LeaveTypeViewPermit findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveTypeViewPermit> orderByComparator)
		throws NoSuchLeaveTypeViewPermitException;

	/**
	 * Returns the last leave type view permit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type view permit, or <code>null</code> if a matching leave type view permit could not be found
	 */
	public LeaveTypeViewPermit fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypeViewPermit>
			orderByComparator);

	/**
	 * Returns the leave type view permits before and after the current leave type view permit in the ordered set where uuid = &#63;.
	 *
	 * @param leaveTypeViewPermitId the primary key of the current leave type view permit
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave type view permit
	 * @throws NoSuchLeaveTypeViewPermitException if a leave type view permit with the primary key could not be found
	 */
	public LeaveTypeViewPermit[] findByUuid_PrevAndNext(
			long leaveTypeViewPermitId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveTypeViewPermit> orderByComparator)
		throws NoSuchLeaveTypeViewPermitException;

	/**
	 * Removes all the leave type view permits where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of leave type view permits where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave type view permits
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the leave type view permit where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveTypeViewPermitException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave type view permit
	 * @throws NoSuchLeaveTypeViewPermitException if a matching leave type view permit could not be found
	 */
	public LeaveTypeViewPermit findByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveTypeViewPermitException;

	/**
	 * Returns the leave type view permit where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave type view permit, or <code>null</code> if a matching leave type view permit could not be found
	 */
	public LeaveTypeViewPermit fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the leave type view permit where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave type view permit, or <code>null</code> if a matching leave type view permit could not be found
	 */
	public LeaveTypeViewPermit fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the leave type view permit where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave type view permit that was removed
	 */
	public LeaveTypeViewPermit removeByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveTypeViewPermitException;

	/**
	 * Returns the number of leave type view permits where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave type view permits
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the leave type view permits where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave type view permits
	 */
	public java.util.List<LeaveTypeViewPermit> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the leave type view permits where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeViewPermitModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave type view permits
	 * @param end the upper bound of the range of leave type view permits (not inclusive)
	 * @return the range of matching leave type view permits
	 */
	public java.util.List<LeaveTypeViewPermit> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the leave type view permits where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeViewPermitModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave type view permits
	 * @param end the upper bound of the range of leave type view permits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave type view permits
	 */
	public java.util.List<LeaveTypeViewPermit> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypeViewPermit>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave type view permits where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeViewPermitModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave type view permits
	 * @param end the upper bound of the range of leave type view permits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave type view permits
	 */
	public java.util.List<LeaveTypeViewPermit> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypeViewPermit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave type view permit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type view permit
	 * @throws NoSuchLeaveTypeViewPermitException if a matching leave type view permit could not be found
	 */
	public LeaveTypeViewPermit findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveTypeViewPermit> orderByComparator)
		throws NoSuchLeaveTypeViewPermitException;

	/**
	 * Returns the first leave type view permit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type view permit, or <code>null</code> if a matching leave type view permit could not be found
	 */
	public LeaveTypeViewPermit fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypeViewPermit>
			orderByComparator);

	/**
	 * Returns the last leave type view permit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type view permit
	 * @throws NoSuchLeaveTypeViewPermitException if a matching leave type view permit could not be found
	 */
	public LeaveTypeViewPermit findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveTypeViewPermit> orderByComparator)
		throws NoSuchLeaveTypeViewPermitException;

	/**
	 * Returns the last leave type view permit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type view permit, or <code>null</code> if a matching leave type view permit could not be found
	 */
	public LeaveTypeViewPermit fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypeViewPermit>
			orderByComparator);

	/**
	 * Returns the leave type view permits before and after the current leave type view permit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveTypeViewPermitId the primary key of the current leave type view permit
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave type view permit
	 * @throws NoSuchLeaveTypeViewPermitException if a leave type view permit with the primary key could not be found
	 */
	public LeaveTypeViewPermit[] findByUuid_C_PrevAndNext(
			long leaveTypeViewPermitId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveTypeViewPermit> orderByComparator)
		throws NoSuchLeaveTypeViewPermitException;

	/**
	 * Removes all the leave type view permits where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of leave type view permits where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave type view permits
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the leave type view permit where employeeId = &#63; and leaveTypeMasterId = &#63; or throws a <code>NoSuchLeaveTypeViewPermitException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the matching leave type view permit
	 * @throws NoSuchLeaveTypeViewPermitException if a matching leave type view permit could not be found
	 */
	public LeaveTypeViewPermit findByEmployeeIdAndLeaveTypeMasterId(
			long employeeId, long leaveTypeMasterId)
		throws NoSuchLeaveTypeViewPermitException;

	/**
	 * Returns the leave type view permit where employeeId = &#63; and leaveTypeMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the matching leave type view permit, or <code>null</code> if a matching leave type view permit could not be found
	 */
	public LeaveTypeViewPermit fetchByEmployeeIdAndLeaveTypeMasterId(
		long employeeId, long leaveTypeMasterId);

	/**
	 * Returns the leave type view permit where employeeId = &#63; and leaveTypeMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave type view permit, or <code>null</code> if a matching leave type view permit could not be found
	 */
	public LeaveTypeViewPermit fetchByEmployeeIdAndLeaveTypeMasterId(
		long employeeId, long leaveTypeMasterId, boolean useFinderCache);

	/**
	 * Removes the leave type view permit where employeeId = &#63; and leaveTypeMasterId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the leave type view permit that was removed
	 */
	public LeaveTypeViewPermit removeByEmployeeIdAndLeaveTypeMasterId(
			long employeeId, long leaveTypeMasterId)
		throws NoSuchLeaveTypeViewPermitException;

	/**
	 * Returns the number of leave type view permits where employeeId = &#63; and leaveTypeMasterId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the number of matching leave type view permits
	 */
	public int countByEmployeeIdAndLeaveTypeMasterId(
		long employeeId, long leaveTypeMasterId);

	/**
	 * Caches the leave type view permit in the entity cache if it is enabled.
	 *
	 * @param leaveTypeViewPermit the leave type view permit
	 */
	public void cacheResult(LeaveTypeViewPermit leaveTypeViewPermit);

	/**
	 * Caches the leave type view permits in the entity cache if it is enabled.
	 *
	 * @param leaveTypeViewPermits the leave type view permits
	 */
	public void cacheResult(
		java.util.List<LeaveTypeViewPermit> leaveTypeViewPermits);

	/**
	 * Creates a new leave type view permit with the primary key. Does not add the leave type view permit to the database.
	 *
	 * @param leaveTypeViewPermitId the primary key for the new leave type view permit
	 * @return the new leave type view permit
	 */
	public LeaveTypeViewPermit create(long leaveTypeViewPermitId);

	/**
	 * Removes the leave type view permit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveTypeViewPermitId the primary key of the leave type view permit
	 * @return the leave type view permit that was removed
	 * @throws NoSuchLeaveTypeViewPermitException if a leave type view permit with the primary key could not be found
	 */
	public LeaveTypeViewPermit remove(long leaveTypeViewPermitId)
		throws NoSuchLeaveTypeViewPermitException;

	public LeaveTypeViewPermit updateImpl(
		LeaveTypeViewPermit leaveTypeViewPermit);

	/**
	 * Returns the leave type view permit with the primary key or throws a <code>NoSuchLeaveTypeViewPermitException</code> if it could not be found.
	 *
	 * @param leaveTypeViewPermitId the primary key of the leave type view permit
	 * @return the leave type view permit
	 * @throws NoSuchLeaveTypeViewPermitException if a leave type view permit with the primary key could not be found
	 */
	public LeaveTypeViewPermit findByPrimaryKey(long leaveTypeViewPermitId)
		throws NoSuchLeaveTypeViewPermitException;

	/**
	 * Returns the leave type view permit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveTypeViewPermitId the primary key of the leave type view permit
	 * @return the leave type view permit, or <code>null</code> if a leave type view permit with the primary key could not be found
	 */
	public LeaveTypeViewPermit fetchByPrimaryKey(long leaveTypeViewPermitId);

	/**
	 * Returns all the leave type view permits.
	 *
	 * @return the leave type view permits
	 */
	public java.util.List<LeaveTypeViewPermit> findAll();

	/**
	 * Returns a range of all the leave type view permits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeViewPermitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave type view permits
	 * @param end the upper bound of the range of leave type view permits (not inclusive)
	 * @return the range of leave type view permits
	 */
	public java.util.List<LeaveTypeViewPermit> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the leave type view permits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeViewPermitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave type view permits
	 * @param end the upper bound of the range of leave type view permits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave type view permits
	 */
	public java.util.List<LeaveTypeViewPermit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypeViewPermit>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave type view permits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeViewPermitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave type view permits
	 * @param end the upper bound of the range of leave type view permits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave type view permits
	 */
	public java.util.List<LeaveTypeViewPermit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypeViewPermit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the leave type view permits from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of leave type view permits.
	 *
	 * @return the number of leave type view permits
	 */
	public int countAll();

}