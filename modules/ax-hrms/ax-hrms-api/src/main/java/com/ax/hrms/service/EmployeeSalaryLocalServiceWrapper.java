/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EmployeeSalaryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeSalaryLocalService
 * @generated
 */
public class EmployeeSalaryLocalServiceWrapper
	implements EmployeeSalaryLocalService,
			   ServiceWrapper<EmployeeSalaryLocalService> {

	public EmployeeSalaryLocalServiceWrapper() {
		this(null);
	}

	public EmployeeSalaryLocalServiceWrapper(
		EmployeeSalaryLocalService employeeSalaryLocalService) {

		_employeeSalaryLocalService = employeeSalaryLocalService;
	}

	/**
	 * Adds the employee salary to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeSalaryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeSalary the employee salary
	 * @return the employee salary that was added
	 */
	@Override
	public com.ax.hrms.model.EmployeeSalary addEmployeeSalary(
		com.ax.hrms.model.EmployeeSalary employeeSalary) {

		return _employeeSalaryLocalService.addEmployeeSalary(employeeSalary);
	}

	/**
	 * Creates a new employee salary with the primary key. Does not add the employee salary to the database.
	 *
	 * @param salaryId the primary key for the new employee salary
	 * @return the new employee salary
	 */
	@Override
	public com.ax.hrms.model.EmployeeSalary createEmployeeSalary(
		long salaryId) {

		return _employeeSalaryLocalService.createEmployeeSalary(salaryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeSalaryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the employee salary from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeSalaryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeSalary the employee salary
	 * @return the employee salary that was removed
	 */
	@Override
	public com.ax.hrms.model.EmployeeSalary deleteEmployeeSalary(
		com.ax.hrms.model.EmployeeSalary employeeSalary) {

		return _employeeSalaryLocalService.deleteEmployeeSalary(employeeSalary);
	}

	/**
	 * Deletes the employee salary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeSalaryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salaryId the primary key of the employee salary
	 * @return the employee salary that was removed
	 * @throws PortalException if a employee salary with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeSalary deleteEmployeeSalary(long salaryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeSalaryLocalService.deleteEmployeeSalary(salaryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeSalaryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _employeeSalaryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _employeeSalaryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeSalaryLocalService.dynamicQuery();
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

		return _employeeSalaryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeSalaryModelImpl</code>.
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

		return _employeeSalaryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeSalaryModelImpl</code>.
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

		return _employeeSalaryLocalService.dynamicQuery(
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

		return _employeeSalaryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeSalaryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.EmployeeSalary fetchEmployeeSalary(long salaryId) {
		return _employeeSalaryLocalService.fetchEmployeeSalary(salaryId);
	}

	/**
	 * Returns the employee salary matching the UUID and group.
	 *
	 * @param uuid the employee salary's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeSalary fetchEmployeeSalaryByUuidAndGroupId(
		String uuid, long groupId) {

		return _employeeSalaryLocalService.fetchEmployeeSalaryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.ax.hrms.model.EmployeeSalary findByEmployeeIdAndStatus(
			long employeeId, boolean status)
		throws com.ax.hrms.exception.NoSuchEmployeeSalaryException {

		return _employeeSalaryLocalService.findByEmployeeIdAndStatus(
			employeeId, status);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeSalaryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the employee salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @return the range of employee salaries
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeSalary> getEmployeeSalaries(
		int start, int end) {

		return _employeeSalaryLocalService.getEmployeeSalaries(start, end);
	}

	/**
	 * Returns all the employee salaries matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee salaries
	 * @param companyId the primary key of the company
	 * @return the matching employee salaries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeSalary>
		getEmployeeSalariesByUuidAndCompanyId(String uuid, long companyId) {

		return _employeeSalaryLocalService.
			getEmployeeSalariesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of employee salaries matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee salaries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee salaries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeSalary>
		getEmployeeSalariesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.EmployeeSalary> orderByComparator) {

		return _employeeSalaryLocalService.
			getEmployeeSalariesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee salaries.
	 *
	 * @return the number of employee salaries
	 */
	@Override
	public int getEmployeeSalariesCount() {
		return _employeeSalaryLocalService.getEmployeeSalariesCount();
	}

	/**
	 * Returns the employee salary with the primary key.
	 *
	 * @param salaryId the primary key of the employee salary
	 * @return the employee salary
	 * @throws PortalException if a employee salary with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeSalary getEmployeeSalary(long salaryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeSalaryLocalService.getEmployeeSalary(salaryId);
	}

	/**
	 * Returns the employee salary matching the UUID and group.
	 *
	 * @param uuid the employee salary's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee salary
	 * @throws PortalException if a matching employee salary could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeSalary getEmployeeSalaryByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeSalaryLocalService.getEmployeeSalaryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _employeeSalaryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeSalaryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeSalaryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeSalaryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee salary in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeSalaryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeSalary the employee salary
	 * @return the employee salary that was updated
	 */
	@Override
	public com.ax.hrms.model.EmployeeSalary updateEmployeeSalary(
		com.ax.hrms.model.EmployeeSalary employeeSalary) {

		return _employeeSalaryLocalService.updateEmployeeSalary(employeeSalary);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _employeeSalaryLocalService.getBasePersistence();
	}

	@Override
	public EmployeeSalaryLocalService getWrappedService() {
		return _employeeSalaryLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeSalaryLocalService employeeSalaryLocalService) {

		_employeeSalaryLocalService = employeeSalaryLocalService;
	}

	private EmployeeSalaryLocalService _employeeSalaryLocalService;

}