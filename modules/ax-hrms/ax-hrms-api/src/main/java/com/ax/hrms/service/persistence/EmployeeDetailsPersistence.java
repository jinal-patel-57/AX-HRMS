/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.model.EmployeeDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetailsUtil
 * @generated
 */
@ProviderType
public interface EmployeeDetailsPersistence
	extends BasePersistence<EmployeeDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeDetailsUtil} to access the employee details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee detailses
	 */
	public java.util.List<EmployeeDetails> findByUuid(String uuid);

	/**
	 * Returns a range of all the employee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of matching employee detailses
	 */
	public java.util.List<EmployeeDetails> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the employee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee detailses
	 */
	public java.util.List<EmployeeDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee detailses
	 */
	public java.util.List<EmployeeDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public EmployeeDetails findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
				orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Returns the first employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public EmployeeDetails fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

	/**
	 * Returns the last employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public EmployeeDetails findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
				orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Returns the last employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public EmployeeDetails fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

	/**
	 * Returns the employee detailses before and after the current employee details in the ordered set where uuid = &#63;.
	 *
	 * @param employeeId the primary key of the current employee details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	public EmployeeDetails[] findByUuid_PrevAndNext(
			long employeeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
				orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Removes all the employee detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of employee detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee detailses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the employee details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public EmployeeDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Returns the employee details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public EmployeeDetails fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the employee details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public EmployeeDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the employee details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee details that was removed
	 */
	public EmployeeDetails removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Returns the number of employee detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee detailses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee detailses
	 */
	public java.util.List<EmployeeDetails> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of matching employee detailses
	 */
	public java.util.List<EmployeeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee detailses
	 */
	public java.util.List<EmployeeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee detailses
	 */
	public java.util.List<EmployeeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public EmployeeDetails findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
				orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Returns the first employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public EmployeeDetails fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

	/**
	 * Returns the last employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public EmployeeDetails findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
				orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Returns the last employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public EmployeeDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

	/**
	 * Returns the employee detailses before and after the current employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	public EmployeeDetails[] findByUuid_C_PrevAndNext(
			long employeeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
				orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Removes all the employee detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee detailses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the employee details where employeeId = &#63; or throws a <code>NoSuchEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public EmployeeDetails findByEmployeeId(long employeeId)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Returns the employee details where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public EmployeeDetails fetchByEmployeeId(long employeeId);

	/**
	 * Returns the employee details where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public EmployeeDetails fetchByEmployeeId(
		long employeeId, boolean useFinderCache);

	/**
	 * Removes the employee details where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the employee details that was removed
	 */
	public EmployeeDetails removeByEmployeeId(long employeeId)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Returns the number of employee detailses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee detailses
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns the employee details where lrUserId = &#63; or throws a <code>NoSuchEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param lrUserId the lr user ID
	 * @return the matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public EmployeeDetails findByLrUserId(long lrUserId)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Returns the employee details where lrUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param lrUserId the lr user ID
	 * @return the matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public EmployeeDetails fetchByLrUserId(long lrUserId);

	/**
	 * Returns the employee details where lrUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param lrUserId the lr user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public EmployeeDetails fetchByLrUserId(
		long lrUserId, boolean useFinderCache);

	/**
	 * Removes the employee details where lrUserId = &#63; from the database.
	 *
	 * @param lrUserId the lr user ID
	 * @return the employee details that was removed
	 */
	public EmployeeDetails removeByLrUserId(long lrUserId)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Returns the number of employee detailses where lrUserId = &#63;.
	 *
	 * @param lrUserId the lr user ID
	 * @return the number of matching employee detailses
	 */
	public int countByLrUserId(long lrUserId);

	/**
	 * Returns all the employee detailses where leavingDate = &#63;.
	 *
	 * @param leavingDate the leaving date
	 * @return the matching employee detailses
	 */
	public java.util.List<EmployeeDetails> findByLeavingDate(Date leavingDate);

	/**
	 * Returns a range of all the employee detailses where leavingDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param leavingDate the leaving date
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of matching employee detailses
	 */
	public java.util.List<EmployeeDetails> findByLeavingDate(
		Date leavingDate, int start, int end);

	/**
	 * Returns an ordered range of all the employee detailses where leavingDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param leavingDate the leaving date
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee detailses
	 */
	public java.util.List<EmployeeDetails> findByLeavingDate(
		Date leavingDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee detailses where leavingDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param leavingDate the leaving date
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee detailses
	 */
	public java.util.List<EmployeeDetails> findByLeavingDate(
		Date leavingDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee details in the ordered set where leavingDate = &#63;.
	 *
	 * @param leavingDate the leaving date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public EmployeeDetails findByLeavingDate_First(
			Date leavingDate,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
				orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Returns the first employee details in the ordered set where leavingDate = &#63;.
	 *
	 * @param leavingDate the leaving date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public EmployeeDetails fetchByLeavingDate_First(
		Date leavingDate,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

	/**
	 * Returns the last employee details in the ordered set where leavingDate = &#63;.
	 *
	 * @param leavingDate the leaving date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public EmployeeDetails findByLeavingDate_Last(
			Date leavingDate,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
				orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Returns the last employee details in the ordered set where leavingDate = &#63;.
	 *
	 * @param leavingDate the leaving date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public EmployeeDetails fetchByLeavingDate_Last(
		Date leavingDate,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

	/**
	 * Returns the employee detailses before and after the current employee details in the ordered set where leavingDate = &#63;.
	 *
	 * @param employeeId the primary key of the current employee details
	 * @param leavingDate the leaving date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	public EmployeeDetails[] findByLeavingDate_PrevAndNext(
			long employeeId, Date leavingDate,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
				orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Removes all the employee detailses where leavingDate = &#63; from the database.
	 *
	 * @param leavingDate the leaving date
	 */
	public void removeByLeavingDate(Date leavingDate);

	/**
	 * Returns the number of employee detailses where leavingDate = &#63;.
	 *
	 * @param leavingDate the leaving date
	 * @return the number of matching employee detailses
	 */
	public int countByLeavingDate(Date leavingDate);

	/**
	 * Returns all the employee detailses where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @return the matching employee detailses
	 */
	public java.util.List<EmployeeDetails> findByEmployeeName(
		String firstName, String lastName);

	/**
	 * Returns a range of all the employee detailses where firstName = &#63; and lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of matching employee detailses
	 */
	public java.util.List<EmployeeDetails> findByEmployeeName(
		String firstName, String lastName, int start, int end);

	/**
	 * Returns an ordered range of all the employee detailses where firstName = &#63; and lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee detailses
	 */
	public java.util.List<EmployeeDetails> findByEmployeeName(
		String firstName, String lastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee detailses where firstName = &#63; and lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee detailses
	 */
	public java.util.List<EmployeeDetails> findByEmployeeName(
		String firstName, String lastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee details in the ordered set where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public EmployeeDetails findByEmployeeName_First(
			String firstName, String lastName,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
				orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Returns the first employee details in the ordered set where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public EmployeeDetails fetchByEmployeeName_First(
		String firstName, String lastName,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

	/**
	 * Returns the last employee details in the ordered set where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public EmployeeDetails findByEmployeeName_Last(
			String firstName, String lastName,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
				orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Returns the last employee details in the ordered set where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public EmployeeDetails fetchByEmployeeName_Last(
		String firstName, String lastName,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

	/**
	 * Returns the employee detailses before and after the current employee details in the ordered set where firstName = &#63; and lastName = &#63;.
	 *
	 * @param employeeId the primary key of the current employee details
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	public EmployeeDetails[] findByEmployeeName_PrevAndNext(
			long employeeId, String firstName, String lastName,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
				orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Removes all the employee detailses where firstName = &#63; and lastName = &#63; from the database.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 */
	public void removeByEmployeeName(String firstName, String lastName);

	/**
	 * Returns the number of employee detailses where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @return the number of matching employee detailses
	 */
	public int countByEmployeeName(String firstName, String lastName);

	/**
	 * Returns all the employee detailses where isTerminated = &#63;.
	 *
	 * @param isTerminated the is terminated
	 * @return the matching employee detailses
	 */
	public java.util.List<EmployeeDetails> findByIsTerminated(
		boolean isTerminated);

	/**
	 * Returns a range of all the employee detailses where isTerminated = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param isTerminated the is terminated
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of matching employee detailses
	 */
	public java.util.List<EmployeeDetails> findByIsTerminated(
		boolean isTerminated, int start, int end);

	/**
	 * Returns an ordered range of all the employee detailses where isTerminated = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param isTerminated the is terminated
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee detailses
	 */
	public java.util.List<EmployeeDetails> findByIsTerminated(
		boolean isTerminated, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee detailses where isTerminated = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param isTerminated the is terminated
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee detailses
	 */
	public java.util.List<EmployeeDetails> findByIsTerminated(
		boolean isTerminated, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee details in the ordered set where isTerminated = &#63;.
	 *
	 * @param isTerminated the is terminated
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public EmployeeDetails findByIsTerminated_First(
			boolean isTerminated,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
				orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Returns the first employee details in the ordered set where isTerminated = &#63;.
	 *
	 * @param isTerminated the is terminated
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public EmployeeDetails fetchByIsTerminated_First(
		boolean isTerminated,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

	/**
	 * Returns the last employee details in the ordered set where isTerminated = &#63;.
	 *
	 * @param isTerminated the is terminated
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public EmployeeDetails findByIsTerminated_Last(
			boolean isTerminated,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
				orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Returns the last employee details in the ordered set where isTerminated = &#63;.
	 *
	 * @param isTerminated the is terminated
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public EmployeeDetails fetchByIsTerminated_Last(
		boolean isTerminated,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

	/**
	 * Returns the employee detailses before and after the current employee details in the ordered set where isTerminated = &#63;.
	 *
	 * @param employeeId the primary key of the current employee details
	 * @param isTerminated the is terminated
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	public EmployeeDetails[] findByIsTerminated_PrevAndNext(
			long employeeId, boolean isTerminated,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
				orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Removes all the employee detailses where isTerminated = &#63; from the database.
	 *
	 * @param isTerminated the is terminated
	 */
	public void removeByIsTerminated(boolean isTerminated);

	/**
	 * Returns the number of employee detailses where isTerminated = &#63;.
	 *
	 * @param isTerminated the is terminated
	 * @return the number of matching employee detailses
	 */
	public int countByIsTerminated(boolean isTerminated);

	/**
	 * Caches the employee details in the entity cache if it is enabled.
	 *
	 * @param employeeDetails the employee details
	 */
	public void cacheResult(EmployeeDetails employeeDetails);

	/**
	 * Caches the employee detailses in the entity cache if it is enabled.
	 *
	 * @param employeeDetailses the employee detailses
	 */
	public void cacheResult(java.util.List<EmployeeDetails> employeeDetailses);

	/**
	 * Creates a new employee details with the primary key. Does not add the employee details to the database.
	 *
	 * @param employeeId the primary key for the new employee details
	 * @return the new employee details
	 */
	public EmployeeDetails create(long employeeId);

	/**
	 * Removes the employee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeId the primary key of the employee details
	 * @return the employee details that was removed
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	public EmployeeDetails remove(long employeeId)
		throws NoSuchEmployeeDetailsException;

	public EmployeeDetails updateImpl(EmployeeDetails employeeDetails);

	/**
	 * Returns the employee details with the primary key or throws a <code>NoSuchEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee details
	 * @return the employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	public EmployeeDetails findByPrimaryKey(long employeeId)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Returns the employee details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee details
	 * @return the employee details, or <code>null</code> if a employee details with the primary key could not be found
	 */
	public EmployeeDetails fetchByPrimaryKey(long employeeId);

	/**
	 * Returns all the employee detailses.
	 *
	 * @return the employee detailses
	 */
	public java.util.List<EmployeeDetails> findAll();

	/**
	 * Returns a range of all the employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of employee detailses
	 */
	public java.util.List<EmployeeDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee detailses
	 */
	public java.util.List<EmployeeDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee detailses
	 */
	public java.util.List<EmployeeDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee detailses.
	 *
	 * @return the number of employee detailses
	 */
	public int countAll();

}