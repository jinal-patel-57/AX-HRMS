/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EmployeeDepartmentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDepartmentLocalService
 * @generated
 */
public class EmployeeDepartmentLocalServiceWrapper
	implements EmployeeDepartmentLocalService,
			   ServiceWrapper<EmployeeDepartmentLocalService> {

	public EmployeeDepartmentLocalServiceWrapper() {
		this(null);
	}

	public EmployeeDepartmentLocalServiceWrapper(
		EmployeeDepartmentLocalService employeeDepartmentLocalService) {

		_employeeDepartmentLocalService = employeeDepartmentLocalService;
	}

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
	@Override
	public com.ax.hrms.model.EmployeeDepartment addEmployeeDepartment(
		com.ax.hrms.model.EmployeeDepartment employeeDepartment) {

		return _employeeDepartmentLocalService.addEmployeeDepartment(
			employeeDepartment);
	}

	/**
	 * Creates a new employee department with the primary key. Does not add the employee department to the database.
	 *
	 * @param employeeDepartmentId the primary key for the new employee department
	 * @return the new employee department
	 */
	@Override
	public com.ax.hrms.model.EmployeeDepartment createEmployeeDepartment(
		long employeeDepartmentId) {

		return _employeeDepartmentLocalService.createEmployeeDepartment(
			employeeDepartmentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDepartmentLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.ax.hrms.model.EmployeeDepartment deleteEmployeeDepartment(
		com.ax.hrms.model.EmployeeDepartment employeeDepartment) {

		return _employeeDepartmentLocalService.deleteEmployeeDepartment(
			employeeDepartment);
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
	@Override
	public com.ax.hrms.model.EmployeeDepartment deleteEmployeeDepartment(
			long employeeDepartmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDepartmentLocalService.deleteEmployeeDepartment(
			employeeDepartmentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDepartmentLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _employeeDepartmentLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _employeeDepartmentLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeDepartmentLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _employeeDepartmentLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _employeeDepartmentLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _employeeDepartmentLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _employeeDepartmentLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _employeeDepartmentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.EmployeeDepartment fetchEmployeeDepartment(
		long employeeDepartmentId) {

		return _employeeDepartmentLocalService.fetchEmployeeDepartment(
			employeeDepartmentId);
	}

	/**
	 * Returns the employee department matching the UUID and group.
	 *
	 * @param uuid the employee department's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee department, or <code>null</code> if a matching employee department could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeDepartment
		fetchEmployeeDepartmentByUuidAndGroupId(String uuid, long groupId) {

		return _employeeDepartmentLocalService.
			fetchEmployeeDepartmentByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.EmployeeDepartment>
		findBydepartmentMasterId(long departmentMasterId) {

		return _employeeDepartmentLocalService.findBydepartmentMasterId(
			departmentMasterId);
	}

	@Override
	public com.ax.hrms.model.EmployeeDepartment findByEmployeeId(
			long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return _employeeDepartmentLocalService.findByEmployeeId(employeeId);
	}

	@Override
	public com.ax.hrms.model.EmployeeDepartment
			findByEmployeeIdAndStatusAndDepartmentMasterId(
				long departmentMasterId, boolean status, long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeDepartmentException {

		return _employeeDepartmentLocalService.
			findByEmployeeIdAndStatusAndDepartmentMasterId(
				departmentMasterId, status, employeeId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.EmployeeDepartment>
		findByEmployeeIdGetDepartments(long employeeId) {

		return _employeeDepartmentLocalService.findByEmployeeIdGetDepartments(
			employeeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeDepartmentLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the employee department with the primary key.
	 *
	 * @param employeeDepartmentId the primary key of the employee department
	 * @return the employee department
	 * @throws PortalException if a employee department with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeDepartment getEmployeeDepartment(
			long employeeDepartmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDepartmentLocalService.getEmployeeDepartment(
			employeeDepartmentId);
	}

	/**
	 * Returns the employee department matching the UUID and group.
	 *
	 * @param uuid the employee department's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee department
	 * @throws PortalException if a matching employee department could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeDepartment
			getEmployeeDepartmentByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDepartmentLocalService.
			getEmployeeDepartmentByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeDepartment>
		getEmployeeDepartments(int start, int end) {

		return _employeeDepartmentLocalService.getEmployeeDepartments(
			start, end);
	}

	/**
	 * Returns all the employee departments matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee departments
	 * @param companyId the primary key of the company
	 * @return the matching employee departments, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeDepartment>
		getEmployeeDepartmentsByUuidAndCompanyId(String uuid, long companyId) {

		return _employeeDepartmentLocalService.
			getEmployeeDepartmentsByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeDepartment>
		getEmployeeDepartmentsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.EmployeeDepartment> orderByComparator) {

		return _employeeDepartmentLocalService.
			getEmployeeDepartmentsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee departments.
	 *
	 * @return the number of employee departments
	 */
	@Override
	public int getEmployeeDepartmentsCount() {
		return _employeeDepartmentLocalService.getEmployeeDepartmentsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _employeeDepartmentLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeDepartmentLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDepartmentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDepartmentLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.ax.hrms.model.EmployeeDepartment updateEmployeeDepartment(
		com.ax.hrms.model.EmployeeDepartment employeeDepartment) {

		return _employeeDepartmentLocalService.updateEmployeeDepartment(
			employeeDepartment);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _employeeDepartmentLocalService.getBasePersistence();
	}

	@Override
	public EmployeeDepartmentLocalService getWrappedService() {
		return _employeeDepartmentLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeDepartmentLocalService employeeDepartmentLocalService) {

		_employeeDepartmentLocalService = employeeDepartmentLocalService;
	}

	private EmployeeDepartmentLocalService _employeeDepartmentLocalService;

}