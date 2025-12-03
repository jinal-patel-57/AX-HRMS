/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchEmployeeProbationDetailsException;
import com.ax.hrms.model.EmployeeProbationDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee probation details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeProbationDetailsUtil
 * @generated
 */
@ProviderType
public interface EmployeeProbationDetailsPersistence
	extends BasePersistence<EmployeeProbationDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeProbationDetailsUtil} to access the employee probation details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee probation detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee probation detailses
	 */
	public java.util.List<EmployeeProbationDetails> findByUuid(String uuid);

	/**
	 * Returns a range of all the employee probation detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee probation detailses
	 * @param end the upper bound of the range of employee probation detailses (not inclusive)
	 * @return the range of matching employee probation detailses
	 */
	public java.util.List<EmployeeProbationDetails> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the employee probation detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee probation detailses
	 * @param end the upper bound of the range of employee probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee probation detailses
	 */
	public java.util.List<EmployeeProbationDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeProbationDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the employee probation detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee probation detailses
	 * @param end the upper bound of the range of employee probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee probation detailses
	 */
	public java.util.List<EmployeeProbationDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeProbationDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee probation details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee probation details
	 * @throws NoSuchEmployeeProbationDetailsException if a matching employee probation details could not be found
	 */
	public EmployeeProbationDetails findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeProbationDetails> orderByComparator)
		throws NoSuchEmployeeProbationDetailsException;

	/**
	 * Returns the first employee probation details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee probation details, or <code>null</code> if a matching employee probation details could not be found
	 */
	public EmployeeProbationDetails fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeProbationDetails> orderByComparator);

	/**
	 * Returns the last employee probation details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee probation details
	 * @throws NoSuchEmployeeProbationDetailsException if a matching employee probation details could not be found
	 */
	public EmployeeProbationDetails findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeProbationDetails> orderByComparator)
		throws NoSuchEmployeeProbationDetailsException;

	/**
	 * Returns the last employee probation details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee probation details, or <code>null</code> if a matching employee probation details could not be found
	 */
	public EmployeeProbationDetails fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeProbationDetails> orderByComparator);

	/**
	 * Returns the employee probation detailses before and after the current employee probation details in the ordered set where uuid = &#63;.
	 *
	 * @param probationDetailId the primary key of the current employee probation details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee probation details
	 * @throws NoSuchEmployeeProbationDetailsException if a employee probation details with the primary key could not be found
	 */
	public EmployeeProbationDetails[] findByUuid_PrevAndNext(
			long probationDetailId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeProbationDetails> orderByComparator)
		throws NoSuchEmployeeProbationDetailsException;

	/**
	 * Removes all the employee probation detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of employee probation detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee probation detailses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the employee probation details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeProbationDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee probation details
	 * @throws NoSuchEmployeeProbationDetailsException if a matching employee probation details could not be found
	 */
	public EmployeeProbationDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeProbationDetailsException;

	/**
	 * Returns the employee probation details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee probation details, or <code>null</code> if a matching employee probation details could not be found
	 */
	public EmployeeProbationDetails fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the employee probation details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee probation details, or <code>null</code> if a matching employee probation details could not be found
	 */
	public EmployeeProbationDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the employee probation details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee probation details that was removed
	 */
	public EmployeeProbationDetails removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeProbationDetailsException;

	/**
	 * Returns the number of employee probation detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee probation detailses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the employee probation detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee probation detailses
	 */
	public java.util.List<EmployeeProbationDetails> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the employee probation detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee probation detailses
	 * @param end the upper bound of the range of employee probation detailses (not inclusive)
	 * @return the range of matching employee probation detailses
	 */
	public java.util.List<EmployeeProbationDetails> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the employee probation detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee probation detailses
	 * @param end the upper bound of the range of employee probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee probation detailses
	 */
	public java.util.List<EmployeeProbationDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeProbationDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the employee probation detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee probation detailses
	 * @param end the upper bound of the range of employee probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee probation detailses
	 */
	public java.util.List<EmployeeProbationDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeProbationDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee probation details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee probation details
	 * @throws NoSuchEmployeeProbationDetailsException if a matching employee probation details could not be found
	 */
	public EmployeeProbationDetails findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeProbationDetails> orderByComparator)
		throws NoSuchEmployeeProbationDetailsException;

	/**
	 * Returns the first employee probation details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee probation details, or <code>null</code> if a matching employee probation details could not be found
	 */
	public EmployeeProbationDetails fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeProbationDetails> orderByComparator);

	/**
	 * Returns the last employee probation details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee probation details
	 * @throws NoSuchEmployeeProbationDetailsException if a matching employee probation details could not be found
	 */
	public EmployeeProbationDetails findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeProbationDetails> orderByComparator)
		throws NoSuchEmployeeProbationDetailsException;

	/**
	 * Returns the last employee probation details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee probation details, or <code>null</code> if a matching employee probation details could not be found
	 */
	public EmployeeProbationDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeProbationDetails> orderByComparator);

	/**
	 * Returns the employee probation detailses before and after the current employee probation details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param probationDetailId the primary key of the current employee probation details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee probation details
	 * @throws NoSuchEmployeeProbationDetailsException if a employee probation details with the primary key could not be found
	 */
	public EmployeeProbationDetails[] findByUuid_C_PrevAndNext(
			long probationDetailId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeProbationDetails> orderByComparator)
		throws NoSuchEmployeeProbationDetailsException;

	/**
	 * Removes all the employee probation detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of employee probation detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee probation detailses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the employee probation details where employeeId = &#63; or throws a <code>NoSuchEmployeeProbationDetailsException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee probation details
	 * @throws NoSuchEmployeeProbationDetailsException if a matching employee probation details could not be found
	 */
	public EmployeeProbationDetails findByEmployeeId(long employeeId)
		throws NoSuchEmployeeProbationDetailsException;

	/**
	 * Returns the employee probation details where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee probation details, or <code>null</code> if a matching employee probation details could not be found
	 */
	public EmployeeProbationDetails fetchByEmployeeId(long employeeId);

	/**
	 * Returns the employee probation details where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee probation details, or <code>null</code> if a matching employee probation details could not be found
	 */
	public EmployeeProbationDetails fetchByEmployeeId(
		long employeeId, boolean useFinderCache);

	/**
	 * Removes the employee probation details where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the employee probation details that was removed
	 */
	public EmployeeProbationDetails removeByEmployeeId(long employeeId)
		throws NoSuchEmployeeProbationDetailsException;

	/**
	 * Returns the number of employee probation detailses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee probation detailses
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee probation details in the entity cache if it is enabled.
	 *
	 * @param employeeProbationDetails the employee probation details
	 */
	public void cacheResult(EmployeeProbationDetails employeeProbationDetails);

	/**
	 * Caches the employee probation detailses in the entity cache if it is enabled.
	 *
	 * @param employeeProbationDetailses the employee probation detailses
	 */
	public void cacheResult(
		java.util.List<EmployeeProbationDetails> employeeProbationDetailses);

	/**
	 * Creates a new employee probation details with the primary key. Does not add the employee probation details to the database.
	 *
	 * @param probationDetailId the primary key for the new employee probation details
	 * @return the new employee probation details
	 */
	public EmployeeProbationDetails create(long probationDetailId);

	/**
	 * Removes the employee probation details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param probationDetailId the primary key of the employee probation details
	 * @return the employee probation details that was removed
	 * @throws NoSuchEmployeeProbationDetailsException if a employee probation details with the primary key could not be found
	 */
	public EmployeeProbationDetails remove(long probationDetailId)
		throws NoSuchEmployeeProbationDetailsException;

	public EmployeeProbationDetails updateImpl(
		EmployeeProbationDetails employeeProbationDetails);

	/**
	 * Returns the employee probation details with the primary key or throws a <code>NoSuchEmployeeProbationDetailsException</code> if it could not be found.
	 *
	 * @param probationDetailId the primary key of the employee probation details
	 * @return the employee probation details
	 * @throws NoSuchEmployeeProbationDetailsException if a employee probation details with the primary key could not be found
	 */
	public EmployeeProbationDetails findByPrimaryKey(long probationDetailId)
		throws NoSuchEmployeeProbationDetailsException;

	/**
	 * Returns the employee probation details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param probationDetailId the primary key of the employee probation details
	 * @return the employee probation details, or <code>null</code> if a employee probation details with the primary key could not be found
	 */
	public EmployeeProbationDetails fetchByPrimaryKey(long probationDetailId);

	/**
	 * Returns all the employee probation detailses.
	 *
	 * @return the employee probation detailses
	 */
	public java.util.List<EmployeeProbationDetails> findAll();

	/**
	 * Returns a range of all the employee probation detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee probation detailses
	 * @param end the upper bound of the range of employee probation detailses (not inclusive)
	 * @return the range of employee probation detailses
	 */
	public java.util.List<EmployeeProbationDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee probation detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee probation detailses
	 * @param end the upper bound of the range of employee probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee probation detailses
	 */
	public java.util.List<EmployeeProbationDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeProbationDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the employee probation detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee probation detailses
	 * @param end the upper bound of the range of employee probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee probation detailses
	 */
	public java.util.List<EmployeeProbationDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeProbationDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee probation detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee probation detailses.
	 *
	 * @return the number of employee probation detailses
	 */
	public int countAll();

}