/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.EmployeeSalary;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the employee salary service. This utility wraps <code>com.ax.hrms.service.persistence.impl.EmployeeSalaryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeSalaryPersistence
 * @generated
 */
public class EmployeeSalaryUtil {

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
	public static void clearCache(EmployeeSalary employeeSalary) {
		getPersistence().clearCache(employeeSalary);
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
	public static Map<Serializable, EmployeeSalary> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeSalary> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeSalary> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeSalary> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeSalary> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeSalary update(EmployeeSalary employeeSalary) {
		return getPersistence().update(employeeSalary);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeSalary update(
		EmployeeSalary employeeSalary, ServiceContext serviceContext) {

		return getPersistence().update(employeeSalary, serviceContext);
	}

	/**
	 * Returns all the employee salaries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee salaries
	 */
	public static List<EmployeeSalary> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<EmployeeSalary> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<EmployeeSalary> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeSalary> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<EmployeeSalary> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeSalary> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee salary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee salary
	 * @throws NoSuchEmployeeSalaryException if a matching employee salary could not be found
	 */
	public static EmployeeSalary findByUuid_First(
			String uuid, OrderByComparator<EmployeeSalary> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeSalaryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first employee salary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	public static EmployeeSalary fetchByUuid_First(
		String uuid, OrderByComparator<EmployeeSalary> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee salary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee salary
	 * @throws NoSuchEmployeeSalaryException if a matching employee salary could not be found
	 */
	public static EmployeeSalary findByUuid_Last(
			String uuid, OrderByComparator<EmployeeSalary> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeSalaryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee salary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	public static EmployeeSalary fetchByUuid_Last(
		String uuid, OrderByComparator<EmployeeSalary> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the employee salaries before and after the current employee salary in the ordered set where uuid = &#63;.
	 *
	 * @param salaryId the primary key of the current employee salary
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee salary
	 * @throws NoSuchEmployeeSalaryException if a employee salary with the primary key could not be found
	 */
	public static EmployeeSalary[] findByUuid_PrevAndNext(
			long salaryId, String uuid,
			OrderByComparator<EmployeeSalary> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeSalaryException {

		return getPersistence().findByUuid_PrevAndNext(
			salaryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the employee salaries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of employee salaries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee salaries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the employee salary where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeSalaryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee salary
	 * @throws NoSuchEmployeeSalaryException if a matching employee salary could not be found
	 */
	public static EmployeeSalary findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeSalaryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee salary where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	public static EmployeeSalary fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee salary where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	public static EmployeeSalary fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the employee salary where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee salary that was removed
	 */
	public static EmployeeSalary removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeSalaryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of employee salaries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee salaries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the employee salaries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee salaries
	 */
	public static List<EmployeeSalary> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<EmployeeSalary> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<EmployeeSalary> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeSalary> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<EmployeeSalary> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeSalary> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee salary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee salary
	 * @throws NoSuchEmployeeSalaryException if a matching employee salary could not be found
	 */
	public static EmployeeSalary findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeSalary> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeSalaryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first employee salary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	public static EmployeeSalary fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeSalary> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee salary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee salary
	 * @throws NoSuchEmployeeSalaryException if a matching employee salary could not be found
	 */
	public static EmployeeSalary findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeSalary> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeSalaryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee salary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	public static EmployeeSalary fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeSalary> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static EmployeeSalary[] findByUuid_C_PrevAndNext(
			long salaryId, String uuid, long companyId,
			OrderByComparator<EmployeeSalary> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeSalaryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			salaryId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the employee salaries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of employee salaries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee salaries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the employee salary where employeeId = &#63; and status = &#63; or throws a <code>NoSuchEmployeeSalaryException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @return the matching employee salary
	 * @throws NoSuchEmployeeSalaryException if a matching employee salary could not be found
	 */
	public static EmployeeSalary findByEmployeeIdAndStatus(
			long employeeId, boolean status)
		throws com.ax.hrms.exception.NoSuchEmployeeSalaryException {

		return getPersistence().findByEmployeeIdAndStatus(employeeId, status);
	}

	/**
	 * Returns the employee salary where employeeId = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @return the matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	public static EmployeeSalary fetchByEmployeeIdAndStatus(
		long employeeId, boolean status) {

		return getPersistence().fetchByEmployeeIdAndStatus(employeeId, status);
	}

	/**
	 * Returns the employee salary where employeeId = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	public static EmployeeSalary fetchByEmployeeIdAndStatus(
		long employeeId, boolean status, boolean useFinderCache) {

		return getPersistence().fetchByEmployeeIdAndStatus(
			employeeId, status, useFinderCache);
	}

	/**
	 * Removes the employee salary where employeeId = &#63; and status = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @return the employee salary that was removed
	 */
	public static EmployeeSalary removeByEmployeeIdAndStatus(
			long employeeId, boolean status)
		throws com.ax.hrms.exception.NoSuchEmployeeSalaryException {

		return getPersistence().removeByEmployeeIdAndStatus(employeeId, status);
	}

	/**
	 * Returns the number of employee salaries where employeeId = &#63; and status = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @return the number of matching employee salaries
	 */
	public static int countByEmployeeIdAndStatus(
		long employeeId, boolean status) {

		return getPersistence().countByEmployeeIdAndStatus(employeeId, status);
	}

	/**
	 * Caches the employee salary in the entity cache if it is enabled.
	 *
	 * @param employeeSalary the employee salary
	 */
	public static void cacheResult(EmployeeSalary employeeSalary) {
		getPersistence().cacheResult(employeeSalary);
	}

	/**
	 * Caches the employee salaries in the entity cache if it is enabled.
	 *
	 * @param employeeSalaries the employee salaries
	 */
	public static void cacheResult(List<EmployeeSalary> employeeSalaries) {
		getPersistence().cacheResult(employeeSalaries);
	}

	/**
	 * Creates a new employee salary with the primary key. Does not add the employee salary to the database.
	 *
	 * @param salaryId the primary key for the new employee salary
	 * @return the new employee salary
	 */
	public static EmployeeSalary create(long salaryId) {
		return getPersistence().create(salaryId);
	}

	/**
	 * Removes the employee salary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param salaryId the primary key of the employee salary
	 * @return the employee salary that was removed
	 * @throws NoSuchEmployeeSalaryException if a employee salary with the primary key could not be found
	 */
	public static EmployeeSalary remove(long salaryId)
		throws com.ax.hrms.exception.NoSuchEmployeeSalaryException {

		return getPersistence().remove(salaryId);
	}

	public static EmployeeSalary updateImpl(EmployeeSalary employeeSalary) {
		return getPersistence().updateImpl(employeeSalary);
	}

	/**
	 * Returns the employee salary with the primary key or throws a <code>NoSuchEmployeeSalaryException</code> if it could not be found.
	 *
	 * @param salaryId the primary key of the employee salary
	 * @return the employee salary
	 * @throws NoSuchEmployeeSalaryException if a employee salary with the primary key could not be found
	 */
	public static EmployeeSalary findByPrimaryKey(long salaryId)
		throws com.ax.hrms.exception.NoSuchEmployeeSalaryException {

		return getPersistence().findByPrimaryKey(salaryId);
	}

	/**
	 * Returns the employee salary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param salaryId the primary key of the employee salary
	 * @return the employee salary, or <code>null</code> if a employee salary with the primary key could not be found
	 */
	public static EmployeeSalary fetchByPrimaryKey(long salaryId) {
		return getPersistence().fetchByPrimaryKey(salaryId);
	}

	/**
	 * Returns all the employee salaries.
	 *
	 * @return the employee salaries
	 */
	public static List<EmployeeSalary> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<EmployeeSalary> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<EmployeeSalary> findAll(
		int start, int end,
		OrderByComparator<EmployeeSalary> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<EmployeeSalary> findAll(
		int start, int end, OrderByComparator<EmployeeSalary> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee salaries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee salaries.
	 *
	 * @return the number of employee salaries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeSalaryPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(EmployeeSalaryPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile EmployeeSalaryPersistence _persistence;

}