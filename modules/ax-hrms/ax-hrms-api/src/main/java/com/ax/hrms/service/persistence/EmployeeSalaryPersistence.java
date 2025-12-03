/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchEmployeeSalaryException;
import com.ax.hrms.model.EmployeeSalary;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee salary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeSalaryUtil
 * @generated
 */
@ProviderType
public interface EmployeeSalaryPersistence
	extends BasePersistence<EmployeeSalary> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeSalaryUtil} to access the employee salary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee salaries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee salaries
	 */
	public java.util.List<EmployeeSalary> findByUuid(String uuid);

	/**
	 * Returns a range of all the employee salaries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @return the range of matching employee salaries
	 */
	public java.util.List<EmployeeSalary> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the employee salaries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee salaries
	 */
	public java.util.List<EmployeeSalary> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeSalary>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee salaries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee salaries
	 */
	public java.util.List<EmployeeSalary> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeSalary>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee salary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee salary
	 * @throws NoSuchEmployeeSalaryException if a matching employee salary could not be found
	 */
	public EmployeeSalary findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeSalary>
				orderByComparator)
		throws NoSuchEmployeeSalaryException;

	/**
	 * Returns the first employee salary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	public EmployeeSalary fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeSalary>
			orderByComparator);

	/**
	 * Returns the last employee salary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee salary
	 * @throws NoSuchEmployeeSalaryException if a matching employee salary could not be found
	 */
	public EmployeeSalary findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeSalary>
				orderByComparator)
		throws NoSuchEmployeeSalaryException;

	/**
	 * Returns the last employee salary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	public EmployeeSalary fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeSalary>
			orderByComparator);

	/**
	 * Returns the employee salaries before and after the current employee salary in the ordered set where uuid = &#63;.
	 *
	 * @param salaryId the primary key of the current employee salary
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee salary
	 * @throws NoSuchEmployeeSalaryException if a employee salary with the primary key could not be found
	 */
	public EmployeeSalary[] findByUuid_PrevAndNext(
			long salaryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeSalary>
				orderByComparator)
		throws NoSuchEmployeeSalaryException;

	/**
	 * Removes all the employee salaries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of employee salaries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee salaries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the employee salary where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeSalaryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee salary
	 * @throws NoSuchEmployeeSalaryException if a matching employee salary could not be found
	 */
	public EmployeeSalary findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeSalaryException;

	/**
	 * Returns the employee salary where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	public EmployeeSalary fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the employee salary where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	public EmployeeSalary fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the employee salary where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee salary that was removed
	 */
	public EmployeeSalary removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeSalaryException;

	/**
	 * Returns the number of employee salaries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee salaries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the employee salaries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee salaries
	 */
	public java.util.List<EmployeeSalary> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the employee salaries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @return the range of matching employee salaries
	 */
	public java.util.List<EmployeeSalary> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the employee salaries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee salaries
	 */
	public java.util.List<EmployeeSalary> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeSalary>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee salaries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee salaries
	 */
	public java.util.List<EmployeeSalary> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeSalary>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee salary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee salary
	 * @throws NoSuchEmployeeSalaryException if a matching employee salary could not be found
	 */
	public EmployeeSalary findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeSalary>
				orderByComparator)
		throws NoSuchEmployeeSalaryException;

	/**
	 * Returns the first employee salary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	public EmployeeSalary fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeSalary>
			orderByComparator);

	/**
	 * Returns the last employee salary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee salary
	 * @throws NoSuchEmployeeSalaryException if a matching employee salary could not be found
	 */
	public EmployeeSalary findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeSalary>
				orderByComparator)
		throws NoSuchEmployeeSalaryException;

	/**
	 * Returns the last employee salary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	public EmployeeSalary fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeSalary>
			orderByComparator);

	/**
	 * Returns the employee salaries before and after the current employee salary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param salaryId the primary key of the current employee salary
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee salary
	 * @throws NoSuchEmployeeSalaryException if a employee salary with the primary key could not be found
	 */
	public EmployeeSalary[] findByUuid_C_PrevAndNext(
			long salaryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeSalary>
				orderByComparator)
		throws NoSuchEmployeeSalaryException;

	/**
	 * Removes all the employee salaries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of employee salaries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee salaries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the employee salary where employeeId = &#63; and status = &#63; or throws a <code>NoSuchEmployeeSalaryException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @return the matching employee salary
	 * @throws NoSuchEmployeeSalaryException if a matching employee salary could not be found
	 */
	public EmployeeSalary findByEmployeeIdAndStatus(
			long employeeId, boolean status)
		throws NoSuchEmployeeSalaryException;

	/**
	 * Returns the employee salary where employeeId = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @return the matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	public EmployeeSalary fetchByEmployeeIdAndStatus(
		long employeeId, boolean status);

	/**
	 * Returns the employee salary where employeeId = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	public EmployeeSalary fetchByEmployeeIdAndStatus(
		long employeeId, boolean status, boolean useFinderCache);

	/**
	 * Removes the employee salary where employeeId = &#63; and status = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @return the employee salary that was removed
	 */
	public EmployeeSalary removeByEmployeeIdAndStatus(
			long employeeId, boolean status)
		throws NoSuchEmployeeSalaryException;

	/**
	 * Returns the number of employee salaries where employeeId = &#63; and status = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @return the number of matching employee salaries
	 */
	public int countByEmployeeIdAndStatus(long employeeId, boolean status);

	/**
	 * Caches the employee salary in the entity cache if it is enabled.
	 *
	 * @param employeeSalary the employee salary
	 */
	public void cacheResult(EmployeeSalary employeeSalary);

	/**
	 * Caches the employee salaries in the entity cache if it is enabled.
	 *
	 * @param employeeSalaries the employee salaries
	 */
	public void cacheResult(java.util.List<EmployeeSalary> employeeSalaries);

	/**
	 * Creates a new employee salary with the primary key. Does not add the employee salary to the database.
	 *
	 * @param salaryId the primary key for the new employee salary
	 * @return the new employee salary
	 */
	public EmployeeSalary create(long salaryId);

	/**
	 * Removes the employee salary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param salaryId the primary key of the employee salary
	 * @return the employee salary that was removed
	 * @throws NoSuchEmployeeSalaryException if a employee salary with the primary key could not be found
	 */
	public EmployeeSalary remove(long salaryId)
		throws NoSuchEmployeeSalaryException;

	public EmployeeSalary updateImpl(EmployeeSalary employeeSalary);

	/**
	 * Returns the employee salary with the primary key or throws a <code>NoSuchEmployeeSalaryException</code> if it could not be found.
	 *
	 * @param salaryId the primary key of the employee salary
	 * @return the employee salary
	 * @throws NoSuchEmployeeSalaryException if a employee salary with the primary key could not be found
	 */
	public EmployeeSalary findByPrimaryKey(long salaryId)
		throws NoSuchEmployeeSalaryException;

	/**
	 * Returns the employee salary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param salaryId the primary key of the employee salary
	 * @return the employee salary, or <code>null</code> if a employee salary with the primary key could not be found
	 */
	public EmployeeSalary fetchByPrimaryKey(long salaryId);

	/**
	 * Returns all the employee salaries.
	 *
	 * @return the employee salaries
	 */
	public java.util.List<EmployeeSalary> findAll();

	/**
	 * Returns a range of all the employee salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @return the range of employee salaries
	 */
	public java.util.List<EmployeeSalary> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee salaries
	 */
	public java.util.List<EmployeeSalary> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeSalary>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee salaries
	 */
	public java.util.List<EmployeeSalary> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeSalary>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee salaries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee salaries.
	 *
	 * @return the number of employee salaries
	 */
	public int countAll();

}