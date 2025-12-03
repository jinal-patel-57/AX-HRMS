/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchEmployeeDepartmentException;
import com.ax.hrms.model.EmployeeDepartment;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee department service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDepartmentUtil
 * @generated
 */
@ProviderType
public interface EmployeeDepartmentPersistence
	extends BasePersistence<EmployeeDepartment> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeDepartmentUtil} to access the employee department persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee departments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee departments
	 */
	public java.util.List<EmployeeDepartment> findByUuid(String uuid);

	/**
	 * Returns a range of all the employee departments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @return the range of matching employee departments
	 */
	public java.util.List<EmployeeDepartment> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the employee departments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee departments
	 */
	public java.util.List<EmployeeDepartment> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee departments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee departments
	 */
	public java.util.List<EmployeeDepartment> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee department in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	public EmployeeDepartment findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
				orderByComparator)
		throws NoSuchEmployeeDepartmentException;

	/**
	 * Returns the first employee department in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public EmployeeDepartment fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
			orderByComparator);

	/**
	 * Returns the last employee department in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	public EmployeeDepartment findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
				orderByComparator)
		throws NoSuchEmployeeDepartmentException;

	/**
	 * Returns the last employee department in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public EmployeeDepartment fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
			orderByComparator);

	/**
	 * Returns the employee departments before and after the current employee department in the ordered set where uuid = &#63;.
	 *
	 * @param employeeDepartmentId the primary key of the current employee department
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee department
	 * @throws NoSuchEmployeeDepartmentException if a employee department with the primary key could not be found
	 */
	public EmployeeDepartment[] findByUuid_PrevAndNext(
			long employeeDepartmentId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
				orderByComparator)
		throws NoSuchEmployeeDepartmentException;

	/**
	 * Removes all the employee departments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of employee departments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee departments
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the employee department where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeDepartmentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	public EmployeeDepartment findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDepartmentException;

	/**
	 * Returns the employee department where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public EmployeeDepartment fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the employee department where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public EmployeeDepartment fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the employee department where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee department that was removed
	 */
	public EmployeeDepartment removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDepartmentException;

	/**
	 * Returns the number of employee departments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee departments
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the employee departments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee departments
	 */
	public java.util.List<EmployeeDepartment> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the employee departments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @return the range of matching employee departments
	 */
	public java.util.List<EmployeeDepartment> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the employee departments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee departments
	 */
	public java.util.List<EmployeeDepartment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee departments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee departments
	 */
	public java.util.List<EmployeeDepartment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee department in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	public EmployeeDepartment findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
				orderByComparator)
		throws NoSuchEmployeeDepartmentException;

	/**
	 * Returns the first employee department in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public EmployeeDepartment fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
			orderByComparator);

	/**
	 * Returns the last employee department in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	public EmployeeDepartment findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
				orderByComparator)
		throws NoSuchEmployeeDepartmentException;

	/**
	 * Returns the last employee department in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public EmployeeDepartment fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
			orderByComparator);

	/**
	 * Returns the employee departments before and after the current employee department in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeeDepartmentId the primary key of the current employee department
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee department
	 * @throws NoSuchEmployeeDepartmentException if a employee department with the primary key could not be found
	 */
	public EmployeeDepartment[] findByUuid_C_PrevAndNext(
			long employeeDepartmentId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
				orderByComparator)
		throws NoSuchEmployeeDepartmentException;

	/**
	 * Removes all the employee departments where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of employee departments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee departments
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the employee department where employeeId = &#63; or throws a <code>NoSuchEmployeeDepartmentException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	public EmployeeDepartment findByEmployeeId(long employeeId)
		throws NoSuchEmployeeDepartmentException;

	/**
	 * Returns the employee department where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public EmployeeDepartment fetchByEmployeeId(long employeeId);

	/**
	 * Returns the employee department where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public EmployeeDepartment fetchByEmployeeId(
		long employeeId, boolean useFinderCache);

	/**
	 * Removes the employee department where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the employee department that was removed
	 */
	public EmployeeDepartment removeByEmployeeId(long employeeId)
		throws NoSuchEmployeeDepartmentException;

	/**
	 * Returns the number of employee departments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee departments
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the employee departments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee departments
	 */
	public java.util.List<EmployeeDepartment> findByEmployeeIdGetDepartments(
		long employeeId);

	/**
	 * Returns a range of all the employee departments where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @return the range of matching employee departments
	 */
	public java.util.List<EmployeeDepartment> findByEmployeeIdGetDepartments(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee departments where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee departments
	 */
	public java.util.List<EmployeeDepartment> findByEmployeeIdGetDepartments(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee departments where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee departments
	 */
	public java.util.List<EmployeeDepartment> findByEmployeeIdGetDepartments(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee department in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	public EmployeeDepartment findByEmployeeIdGetDepartments_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
				orderByComparator)
		throws NoSuchEmployeeDepartmentException;

	/**
	 * Returns the first employee department in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public EmployeeDepartment fetchByEmployeeIdGetDepartments_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
			orderByComparator);

	/**
	 * Returns the last employee department in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	public EmployeeDepartment findByEmployeeIdGetDepartments_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
				orderByComparator)
		throws NoSuchEmployeeDepartmentException;

	/**
	 * Returns the last employee department in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public EmployeeDepartment fetchByEmployeeIdGetDepartments_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
			orderByComparator);

	/**
	 * Returns the employee departments before and after the current employee department in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeDepartmentId the primary key of the current employee department
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee department
	 * @throws NoSuchEmployeeDepartmentException if a employee department with the primary key could not be found
	 */
	public EmployeeDepartment[] findByEmployeeIdGetDepartments_PrevAndNext(
			long employeeDepartmentId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
				orderByComparator)
		throws NoSuchEmployeeDepartmentException;

	/**
	 * Removes all the employee departments where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeIdGetDepartments(long employeeId);

	/**
	 * Returns the number of employee departments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee departments
	 */
	public int countByEmployeeIdGetDepartments(long employeeId);

	/**
	 * Returns all the employee departments where departmentMasterId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @return the matching employee departments
	 */
	public java.util.List<EmployeeDepartment> findBydepartmentMasterId(
		long departmentMasterId);

	/**
	 * Returns a range of all the employee departments where departmentMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param departmentMasterId the department master ID
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @return the range of matching employee departments
	 */
	public java.util.List<EmployeeDepartment> findBydepartmentMasterId(
		long departmentMasterId, int start, int end);

	/**
	 * Returns an ordered range of all the employee departments where departmentMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param departmentMasterId the department master ID
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee departments
	 */
	public java.util.List<EmployeeDepartment> findBydepartmentMasterId(
		long departmentMasterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee departments where departmentMasterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param departmentMasterId the department master ID
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee departments
	 */
	public java.util.List<EmployeeDepartment> findBydepartmentMasterId(
		long departmentMasterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee department in the ordered set where departmentMasterId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	public EmployeeDepartment findBydepartmentMasterId_First(
			long departmentMasterId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
				orderByComparator)
		throws NoSuchEmployeeDepartmentException;

	/**
	 * Returns the first employee department in the ordered set where departmentMasterId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public EmployeeDepartment fetchBydepartmentMasterId_First(
		long departmentMasterId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
			orderByComparator);

	/**
	 * Returns the last employee department in the ordered set where departmentMasterId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	public EmployeeDepartment findBydepartmentMasterId_Last(
			long departmentMasterId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
				orderByComparator)
		throws NoSuchEmployeeDepartmentException;

	/**
	 * Returns the last employee department in the ordered set where departmentMasterId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public EmployeeDepartment fetchBydepartmentMasterId_Last(
		long departmentMasterId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
			orderByComparator);

	/**
	 * Returns the employee departments before and after the current employee department in the ordered set where departmentMasterId = &#63;.
	 *
	 * @param employeeDepartmentId the primary key of the current employee department
	 * @param departmentMasterId the department master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee department
	 * @throws NoSuchEmployeeDepartmentException if a employee department with the primary key could not be found
	 */
	public EmployeeDepartment[] findBydepartmentMasterId_PrevAndNext(
			long employeeDepartmentId, long departmentMasterId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
				orderByComparator)
		throws NoSuchEmployeeDepartmentException;

	/**
	 * Removes all the employee departments where departmentMasterId = &#63; from the database.
	 *
	 * @param departmentMasterId the department master ID
	 */
	public void removeBydepartmentMasterId(long departmentMasterId);

	/**
	 * Returns the number of employee departments where departmentMasterId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @return the number of matching employee departments
	 */
	public int countBydepartmentMasterId(long departmentMasterId);

	/**
	 * Returns the employee department where departmentMasterId = &#63; and status = &#63; and employeeId = &#63; or throws a <code>NoSuchEmployeeDepartmentException</code> if it could not be found.
	 *
	 * @param departmentMasterId the department master ID
	 * @param status the status
	 * @param employeeId the employee ID
	 * @return the matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	public EmployeeDepartment findByEmployeeIdAndStatusAndDepartmentMasterId(
			long departmentMasterId, boolean status, long employeeId)
		throws NoSuchEmployeeDepartmentException;

	/**
	 * Returns the employee department where departmentMasterId = &#63; and status = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param departmentMasterId the department master ID
	 * @param status the status
	 * @param employeeId the employee ID
	 * @return the matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public EmployeeDepartment fetchByEmployeeIdAndStatusAndDepartmentMasterId(
		long departmentMasterId, boolean status, long employeeId);

	/**
	 * Returns the employee department where departmentMasterId = &#63; and status = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param departmentMasterId the department master ID
	 * @param status the status
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public EmployeeDepartment fetchByEmployeeIdAndStatusAndDepartmentMasterId(
		long departmentMasterId, boolean status, long employeeId,
		boolean useFinderCache);

	/**
	 * Removes the employee department where departmentMasterId = &#63; and status = &#63; and employeeId = &#63; from the database.
	 *
	 * @param departmentMasterId the department master ID
	 * @param status the status
	 * @param employeeId the employee ID
	 * @return the employee department that was removed
	 */
	public EmployeeDepartment removeByEmployeeIdAndStatusAndDepartmentMasterId(
			long departmentMasterId, boolean status, long employeeId)
		throws NoSuchEmployeeDepartmentException;

	/**
	 * Returns the number of employee departments where departmentMasterId = &#63; and status = &#63; and employeeId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @param status the status
	 * @param employeeId the employee ID
	 * @return the number of matching employee departments
	 */
	public int countByEmployeeIdAndStatusAndDepartmentMasterId(
		long departmentMasterId, boolean status, long employeeId);

	/**
	 * Caches the employee department in the entity cache if it is enabled.
	 *
	 * @param employeeDepartment the employee department
	 */
	public void cacheResult(EmployeeDepartment employeeDepartment);

	/**
	 * Caches the employee departments in the entity cache if it is enabled.
	 *
	 * @param employeeDepartments the employee departments
	 */
	public void cacheResult(
		java.util.List<EmployeeDepartment> employeeDepartments);

	/**
	 * Creates a new employee department with the primary key. Does not add the employee department to the database.
	 *
	 * @param employeeDepartmentId the primary key for the new employee department
	 * @return the new employee department
	 */
	public EmployeeDepartment create(long employeeDepartmentId);

	/**
	 * Removes the employee department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDepartmentId the primary key of the employee department
	 * @return the employee department that was removed
	 * @throws NoSuchEmployeeDepartmentException if a employee department with the primary key could not be found
	 */
	public EmployeeDepartment remove(long employeeDepartmentId)
		throws NoSuchEmployeeDepartmentException;

	public EmployeeDepartment updateImpl(EmployeeDepartment employeeDepartment);

	/**
	 * Returns the employee department with the primary key or throws a <code>NoSuchEmployeeDepartmentException</code> if it could not be found.
	 *
	 * @param employeeDepartmentId the primary key of the employee department
	 * @return the employee department
	 * @throws NoSuchEmployeeDepartmentException if a employee department with the primary key could not be found
	 */
	public EmployeeDepartment findByPrimaryKey(long employeeDepartmentId)
		throws NoSuchEmployeeDepartmentException;

	/**
	 * Returns the employee department with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDepartmentId the primary key of the employee department
	 * @return the employee department, or <code>null</code> if a employee department with the primary key could not be found
	 */
	public EmployeeDepartment fetchByPrimaryKey(long employeeDepartmentId);

	/**
	 * Returns all the employee departments.
	 *
	 * @return the employee departments
	 */
	public java.util.List<EmployeeDepartment> findAll();

	/**
	 * Returns a range of all the employee departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @return the range of employee departments
	 */
	public java.util.List<EmployeeDepartment> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee departments
	 */
	public java.util.List<EmployeeDepartment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee departments
	 */
	public java.util.List<EmployeeDepartment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDepartment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee departments from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee departments.
	 *
	 * @return the number of employee departments
	 */
	public int countAll();

}