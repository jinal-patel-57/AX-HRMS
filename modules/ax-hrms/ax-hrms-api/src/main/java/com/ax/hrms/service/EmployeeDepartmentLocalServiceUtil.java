/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.EmployeeDepartment;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for EmployeeDepartment. This utility wraps
 * <code>com.ax.hrms.service.impl.EmployeeDepartmentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDepartmentLocalService
 * @generated
 */
public class EmployeeDepartmentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.EmployeeDepartmentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the employee department to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDepartmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDepartment the employee department
	 * @return the employee department that was added
	 */
	public static EmployeeDepartment addEmployeeDepartment(
		EmployeeDepartment employeeDepartment) {

		return getService().addEmployeeDepartment(employeeDepartment);
	}

	/**
	 * Creates a new employee department with the primary key. Does not add the employee department to the database.
	 *
	 * @param employeeDepartmentId the primary key for the new employee department
	 * @return the new employee department
	 */
	public static EmployeeDepartment createEmployeeDepartment(
		long employeeDepartmentId) {

		return getService().createEmployeeDepartment(employeeDepartmentId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the employee department from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDepartmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDepartment the employee department
	 * @return the employee department that was removed
	 */
	public static EmployeeDepartment deleteEmployeeDepartment(
		EmployeeDepartment employeeDepartment) {

		return getService().deleteEmployeeDepartment(employeeDepartment);
	}

	/**
	 * Deletes the employee department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDepartmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDepartmentId the primary key of the employee department
	 * @return the employee department that was removed
	 * @throws PortalException if a employee department with the primary key could not be found
	 */
	public static EmployeeDepartment deleteEmployeeDepartment(
			long employeeDepartmentId)
		throws PortalException {

		return getService().deleteEmployeeDepartment(employeeDepartmentId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static EmployeeDepartment fetchEmployeeDepartment(
		long employeeDepartmentId) {

		return getService().fetchEmployeeDepartment(employeeDepartmentId);
	}

	/**
	 * Returns the employee department matching the UUID and group.
	 *
	 * @param uuid the employee department's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	public static EmployeeDepartment fetchEmployeeDepartmentByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchEmployeeDepartmentByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<EmployeeDepartment> findBydepartmentMasterId(
		long departmentMasterId) {

		return getService().findBydepartmentMasterId(departmentMasterId);
	}

	public static EmployeeDepartment findByEmployeeId(long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return getService().findByEmployeeId(employeeId);
	}

	public static EmployeeDepartment
			findByEmployeeIdAndStatusAndDepartmentMasterId(
				long departmentMasterId, boolean status, long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return getService().findByEmployeeIdAndStatusAndDepartmentMasterId(
			departmentMasterId, status, employeeId);
	}

	public static List<EmployeeDepartment> findByEmployeeIdGetDepartments(
		long employeeId) {

		return getService().findByEmployeeIdGetDepartments(employeeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the employee department with the primary key.
	 *
	 * @param employeeDepartmentId the primary key of the employee department
	 * @return the employee department
	 * @throws PortalException if a employee department with the primary key could not be found
	 */
	public static EmployeeDepartment getEmployeeDepartment(
			long employeeDepartmentId)
		throws PortalException {

		return getService().getEmployeeDepartment(employeeDepartmentId);
	}

	/**
	 * Returns the employee department matching the UUID and group.
	 *
	 * @param uuid the employee department's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee department
	 * @throws PortalException if a matching employee department could not be found
	 */
	public static EmployeeDepartment getEmployeeDepartmentByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getEmployeeDepartmentByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the employee departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeDepartmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @return the range of employee departments
	 */
	public static List<EmployeeDepartment> getEmployeeDepartments(
		int start, int end) {

		return getService().getEmployeeDepartments(start, end);
	}

	/**
	 * Returns all the employee departments matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee departments
	 * @param companyId the primary key of the company
	 * @return the matching employee departments, or an empty list if no matches were found
	 */
	public static List<EmployeeDepartment>
		getEmployeeDepartmentsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getEmployeeDepartmentsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of employee departments matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee departments
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee departments
	 * @param end the upper bound of the range of employee departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee departments, or an empty list if no matches were found
	 */
	public static List<EmployeeDepartment>
		getEmployeeDepartmentsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<EmployeeDepartment> orderByComparator) {

		return getService().getEmployeeDepartmentsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee departments.
	 *
	 * @return the number of employee departments
	 */
	public static int getEmployeeDepartmentsCount() {
		return getService().getEmployeeDepartmentsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee department in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDepartmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDepartment the employee department
	 * @return the employee department that was updated
	 */
	public static EmployeeDepartment updateEmployeeDepartment(
		EmployeeDepartment employeeDepartment) {

		return getService().updateEmployeeDepartment(employeeDepartment);
	}

	public static EmployeeDepartmentLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<EmployeeDepartmentLocalService>
		_serviceSnapshot = new Snapshot<>(
			EmployeeDepartmentLocalServiceUtil.class,
			EmployeeDepartmentLocalService.class);

}