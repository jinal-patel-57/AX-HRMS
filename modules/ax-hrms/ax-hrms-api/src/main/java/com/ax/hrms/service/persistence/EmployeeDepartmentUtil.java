/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.EmployeeDepartment;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the employee department service. This utility wraps <code>com.ax.hrms.service.persistence.impl.EmployeeDepartmentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDepartmentPersistence
 * @generated
 */
public class EmployeeDepartmentUtil {

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
	public static void clearCache(EmployeeDepartment employeeDepartment) {
		getPersistence().clearCache(employeeDepartment);
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
	public static Map<Serializable, EmployeeDepartment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeDepartment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeDepartment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeDepartment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeDepartment update(
		EmployeeDepartment employeeDepartment) {

		return getPersistence().update(employeeDepartment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeDepartment update(
		EmployeeDepartment employeeDepartment, ServiceContext serviceContext) {

		return getPersistence().update(employeeDepartment, serviceContext);
	}

	/**
	 * Returns all the employee departments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee departments
	 */
	public static List<EmployeeDepartment> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<EmployeeDepartment> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<EmployeeDepartment> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<EmployeeDepartment> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeDepartment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee department in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	public static EmployeeDepartment findByUuid_First(
			String uuid,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first employee department in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public static EmployeeDepartment fetchByUuid_First(
		String uuid, OrderByComparator<EmployeeDepartment> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee department in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	public static EmployeeDepartment findByUuid_Last(
			String uuid,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee department in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public static EmployeeDepartment fetchByUuid_Last(
		String uuid, OrderByComparator<EmployeeDepartment> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the employee departments before and after the current employee department in the ordered set where uuid = &#63;.
	 *
	 * @param employeeDepartmentId the primary key of the current employee department
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee department
	 * @throws NoSuchEmployeeDepartmentException if a employee department with the primary key could not be found
	 */
	public static EmployeeDepartment[] findByUuid_PrevAndNext(
			long employeeDepartmentId, String uuid,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return getPersistence().findByUuid_PrevAndNext(
			employeeDepartmentId, uuid, orderByComparator);
	}

	/**
	 * Removes all the employee departments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of employee departments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee departments
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the employee department where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeDepartmentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	public static EmployeeDepartment findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee department where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public static EmployeeDepartment fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee department where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public static EmployeeDepartment fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the employee department where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee department that was removed
	 */
	public static EmployeeDepartment removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of employee departments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee departments
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the employee departments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee departments
	 */
	public static List<EmployeeDepartment> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<EmployeeDepartment> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<EmployeeDepartment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<EmployeeDepartment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeDepartment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee department in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	public static EmployeeDepartment findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first employee department in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public static EmployeeDepartment fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee department in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	public static EmployeeDepartment findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee department in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public static EmployeeDepartment fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static EmployeeDepartment[] findByUuid_C_PrevAndNext(
			long employeeDepartmentId, String uuid, long companyId,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return getPersistence().findByUuid_C_PrevAndNext(
			employeeDepartmentId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the employee departments where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of employee departments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee departments
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the employee department where employeeId = &#63; or throws a <code>NoSuchEmployeeDepartmentException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	public static EmployeeDepartment findByEmployeeId(long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns the employee department where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public static EmployeeDepartment fetchByEmployeeId(long employeeId) {
		return getPersistence().fetchByEmployeeId(employeeId);
	}

	/**
	 * Returns the employee department where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public static EmployeeDepartment fetchByEmployeeId(
		long employeeId, boolean useFinderCache) {

		return getPersistence().fetchByEmployeeId(employeeId, useFinderCache);
	}

	/**
	 * Removes the employee department where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the employee department that was removed
	 */
	public static EmployeeDepartment removeByEmployeeId(long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee departments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee departments
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the employee departments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee departments
	 */
	public static List<EmployeeDepartment> findByEmployeeIdGetDepartments(
		long employeeId) {

		return getPersistence().findByEmployeeIdGetDepartments(employeeId);
	}

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
	public static List<EmployeeDepartment> findByEmployeeIdGetDepartments(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeIdGetDepartments(
			employeeId, start, end);
	}

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
	public static List<EmployeeDepartment> findByEmployeeIdGetDepartments(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		return getPersistence().findByEmployeeIdGetDepartments(
			employeeId, start, end, orderByComparator);
	}

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
	public static List<EmployeeDepartment> findByEmployeeIdGetDepartments(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDepartment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeIdGetDepartments(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee department in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	public static EmployeeDepartment findByEmployeeIdGetDepartments_First(
			long employeeId,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return getPersistence().findByEmployeeIdGetDepartments_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee department in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public static EmployeeDepartment fetchByEmployeeIdGetDepartments_First(
		long employeeId,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		return getPersistence().fetchByEmployeeIdGetDepartments_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee department in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	public static EmployeeDepartment findByEmployeeIdGetDepartments_Last(
			long employeeId,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return getPersistence().findByEmployeeIdGetDepartments_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee department in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public static EmployeeDepartment fetchByEmployeeIdGetDepartments_Last(
		long employeeId,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		return getPersistence().fetchByEmployeeIdGetDepartments_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee departments before and after the current employee department in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeDepartmentId the primary key of the current employee department
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee department
	 * @throws NoSuchEmployeeDepartmentException if a employee department with the primary key could not be found
	 */
	public static EmployeeDepartment[]
			findByEmployeeIdGetDepartments_PrevAndNext(
				long employeeDepartmentId, long employeeId,
				OrderByComparator<EmployeeDepartment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return getPersistence().findByEmployeeIdGetDepartments_PrevAndNext(
			employeeDepartmentId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee departments where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeIdGetDepartments(long employeeId) {
		getPersistence().removeByEmployeeIdGetDepartments(employeeId);
	}

	/**
	 * Returns the number of employee departments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee departments
	 */
	public static int countByEmployeeIdGetDepartments(long employeeId) {
		return getPersistence().countByEmployeeIdGetDepartments(employeeId);
	}

	/**
	 * Returns all the employee departments where departmentMasterId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @return the matching employee departments
	 */
	public static List<EmployeeDepartment> findBydepartmentMasterId(
		long departmentMasterId) {

		return getPersistence().findBydepartmentMasterId(departmentMasterId);
	}

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
	public static List<EmployeeDepartment> findBydepartmentMasterId(
		long departmentMasterId, int start, int end) {

		return getPersistence().findBydepartmentMasterId(
			departmentMasterId, start, end);
	}

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
	public static List<EmployeeDepartment> findBydepartmentMasterId(
		long departmentMasterId, int start, int end,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		return getPersistence().findBydepartmentMasterId(
			departmentMasterId, start, end, orderByComparator);
	}

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
	public static List<EmployeeDepartment> findBydepartmentMasterId(
		long departmentMasterId, int start, int end,
		OrderByComparator<EmployeeDepartment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydepartmentMasterId(
			departmentMasterId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee department in the ordered set where departmentMasterId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	public static EmployeeDepartment findBydepartmentMasterId_First(
			long departmentMasterId,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return getPersistence().findBydepartmentMasterId_First(
			departmentMasterId, orderByComparator);
	}

	/**
	 * Returns the first employee department in the ordered set where departmentMasterId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public static EmployeeDepartment fetchBydepartmentMasterId_First(
		long departmentMasterId,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		return getPersistence().fetchBydepartmentMasterId_First(
			departmentMasterId, orderByComparator);
	}

	/**
	 * Returns the last employee department in the ordered set where departmentMasterId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	public static EmployeeDepartment findBydepartmentMasterId_Last(
			long departmentMasterId,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return getPersistence().findBydepartmentMasterId_Last(
			departmentMasterId, orderByComparator);
	}

	/**
	 * Returns the last employee department in the ordered set where departmentMasterId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public static EmployeeDepartment fetchBydepartmentMasterId_Last(
		long departmentMasterId,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		return getPersistence().fetchBydepartmentMasterId_Last(
			departmentMasterId, orderByComparator);
	}

	/**
	 * Returns the employee departments before and after the current employee department in the ordered set where departmentMasterId = &#63;.
	 *
	 * @param employeeDepartmentId the primary key of the current employee department
	 * @param departmentMasterId the department master ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee department
	 * @throws NoSuchEmployeeDepartmentException if a employee department with the primary key could not be found
	 */
	public static EmployeeDepartment[] findBydepartmentMasterId_PrevAndNext(
			long employeeDepartmentId, long departmentMasterId,
			OrderByComparator<EmployeeDepartment> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return getPersistence().findBydepartmentMasterId_PrevAndNext(
			employeeDepartmentId, departmentMasterId, orderByComparator);
	}

	/**
	 * Removes all the employee departments where departmentMasterId = &#63; from the database.
	 *
	 * @param departmentMasterId the department master ID
	 */
	public static void removeBydepartmentMasterId(long departmentMasterId) {
		getPersistence().removeBydepartmentMasterId(departmentMasterId);
	}

	/**
	 * Returns the number of employee departments where departmentMasterId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @return the number of matching employee departments
	 */
	public static int countBydepartmentMasterId(long departmentMasterId) {
		return getPersistence().countBydepartmentMasterId(departmentMasterId);
	}

	/**
	 * Returns the employee department where departmentMasterId = &#63; and status = &#63; and employeeId = &#63; or throws a <code>NoSuchEmployeeDepartmentException</code> if it could not be found.
	 *
	 * @param departmentMasterId the department master ID
	 * @param status the status
	 * @param employeeId the employee ID
	 * @return the matching employee department
	 * @throws NoSuchEmployeeDepartmentException if a matching employee department could not be found
	 */
	public static EmployeeDepartment
			findByEmployeeIdAndStatusAndDepartmentMasterId(
				long departmentMasterId, boolean status, long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return getPersistence().findByEmployeeIdAndStatusAndDepartmentMasterId(
			departmentMasterId, status, employeeId);
	}

	/**
	 * Returns the employee department where departmentMasterId = &#63; and status = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param departmentMasterId the department master ID
	 * @param status the status
	 * @param employeeId the employee ID
	 * @return the matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public static EmployeeDepartment
		fetchByEmployeeIdAndStatusAndDepartmentMasterId(
			long departmentMasterId, boolean status, long employeeId) {

		return getPersistence().fetchByEmployeeIdAndStatusAndDepartmentMasterId(
			departmentMasterId, status, employeeId);
	}

	/**
	 * Returns the employee department where departmentMasterId = &#63; and status = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param departmentMasterId the department master ID
	 * @param status the status
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public static EmployeeDepartment
		fetchByEmployeeIdAndStatusAndDepartmentMasterId(
			long departmentMasterId, boolean status, long employeeId,
			boolean useFinderCache) {

		return getPersistence().fetchByEmployeeIdAndStatusAndDepartmentMasterId(
			departmentMasterId, status, employeeId, useFinderCache);
	}

	/**
	 * Removes the employee department where departmentMasterId = &#63; and status = &#63; and employeeId = &#63; from the database.
	 *
	 * @param departmentMasterId the department master ID
	 * @param status the status
	 * @param employeeId the employee ID
	 * @return the employee department that was removed
	 */
	public static EmployeeDepartment
			removeByEmployeeIdAndStatusAndDepartmentMasterId(
				long departmentMasterId, boolean status, long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return getPersistence().
			removeByEmployeeIdAndStatusAndDepartmentMasterId(
				departmentMasterId, status, employeeId);
	}

	/**
	 * Returns the number of employee departments where departmentMasterId = &#63; and status = &#63; and employeeId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @param status the status
	 * @param employeeId the employee ID
	 * @return the number of matching employee departments
	 */
	public static int countByEmployeeIdAndStatusAndDepartmentMasterId(
		long departmentMasterId, boolean status, long employeeId) {

		return getPersistence().countByEmployeeIdAndStatusAndDepartmentMasterId(
			departmentMasterId, status, employeeId);
	}

	/**
	 * Caches the employee department in the entity cache if it is enabled.
	 *
	 * @param employeeDepartment the employee department
	 */
	public static void cacheResult(EmployeeDepartment employeeDepartment) {
		getPersistence().cacheResult(employeeDepartment);
	}

	/**
	 * Caches the employee departments in the entity cache if it is enabled.
	 *
	 * @param employeeDepartments the employee departments
	 */
	public static void cacheResult(
		List<EmployeeDepartment> employeeDepartments) {

		getPersistence().cacheResult(employeeDepartments);
	}

	/**
	 * Creates a new employee department with the primary key. Does not add the employee department to the database.
	 *
	 * @param employeeDepartmentId the primary key for the new employee department
	 * @return the new employee department
	 */
	public static EmployeeDepartment create(long employeeDepartmentId) {
		return getPersistence().create(employeeDepartmentId);
	}

	/**
	 * Removes the employee department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDepartmentId the primary key of the employee department
	 * @return the employee department that was removed
	 * @throws NoSuchEmployeeDepartmentException if a employee department with the primary key could not be found
	 */
	public static EmployeeDepartment remove(long employeeDepartmentId)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return getPersistence().remove(employeeDepartmentId);
	}

	public static EmployeeDepartment updateImpl(
		EmployeeDepartment employeeDepartment) {

		return getPersistence().updateImpl(employeeDepartment);
	}

	/**
	 * Returns the employee department with the primary key or throws a <code>NoSuchEmployeeDepartmentException</code> if it could not be found.
	 *
	 * @param employeeDepartmentId the primary key of the employee department
	 * @return the employee department
	 * @throws NoSuchEmployeeDepartmentException if a employee department with the primary key could not be found
	 */
	public static EmployeeDepartment findByPrimaryKey(long employeeDepartmentId)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return getPersistence().findByPrimaryKey(employeeDepartmentId);
	}

	/**
	 * Returns the employee department with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDepartmentId the primary key of the employee department
	 * @return the employee department, or <code>null</code> if a employee department with the primary key could not be found
	 */
	public static EmployeeDepartment fetchByPrimaryKey(
		long employeeDepartmentId) {

		return getPersistence().fetchByPrimaryKey(employeeDepartmentId);
	}

	/**
	 * Returns all the employee departments.
	 *
	 * @return the employee departments
	 */
	public static List<EmployeeDepartment> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<EmployeeDepartment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<EmployeeDepartment> findAll(
		int start, int end,
		OrderByComparator<EmployeeDepartment> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<EmployeeDepartment> findAll(
		int start, int end,
		OrderByComparator<EmployeeDepartment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee departments from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee departments.
	 *
	 * @return the number of employee departments
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeDepartmentPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		EmployeeDepartmentPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile EmployeeDepartmentPersistence _persistence;

}