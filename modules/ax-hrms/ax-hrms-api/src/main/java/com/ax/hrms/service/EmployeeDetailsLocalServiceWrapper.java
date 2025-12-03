/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EmployeeDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetailsLocalService
 * @generated
 */
public class EmployeeDetailsLocalServiceWrapper
	implements EmployeeDetailsLocalService,
			   ServiceWrapper<EmployeeDetailsLocalService> {

	public EmployeeDetailsLocalServiceWrapper() {
		this(null);
	}

	public EmployeeDetailsLocalServiceWrapper(
		EmployeeDetailsLocalService employeeDetailsLocalService) {

		_employeeDetailsLocalService = employeeDetailsLocalService;
	}

	/**
	 * Adds the employee details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDetails the employee details
	 * @return the employee details that was added
	 */
	@Override
	public com.ax.hrms.model.EmployeeDetails addEmployeeDetails(
		com.ax.hrms.model.EmployeeDetails employeeDetails) {

		return _employeeDetailsLocalService.addEmployeeDetails(employeeDetails);
	}

	/**
	 * Creates a new employee details with the primary key. Does not add the employee details to the database.
	 *
	 * @param employeeId the primary key for the new employee details
	 * @return the new employee details
	 */
	@Override
	public com.ax.hrms.model.EmployeeDetails createEmployeeDetails(
		long employeeId) {

		return _employeeDetailsLocalService.createEmployeeDetails(employeeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDetailsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the employee details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDetails the employee details
	 * @return the employee details that was removed
	 */
	@Override
	public com.ax.hrms.model.EmployeeDetails deleteEmployeeDetails(
		com.ax.hrms.model.EmployeeDetails employeeDetails) {

		return _employeeDetailsLocalService.deleteEmployeeDetails(
			employeeDetails);
	}

	/**
	 * Deletes the employee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeId the primary key of the employee details
	 * @return the employee details that was removed
	 * @throws PortalException if a employee details with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeDetails deleteEmployeeDetails(
			long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDetailsLocalService.deleteEmployeeDetails(employeeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _employeeDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _employeeDetailsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeDetailsLocalService.dynamicQuery();
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

		return _employeeDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeDetailsModelImpl</code>.
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

		return _employeeDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeDetailsModelImpl</code>.
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

		return _employeeDetailsLocalService.dynamicQuery(
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

		return _employeeDetailsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.EmployeeDetails fetchEmployeeDetails(
		long employeeId) {

		return _employeeDetailsLocalService.fetchEmployeeDetails(employeeId);
	}

	/**
	 * Returns the employee details matching the UUID and group.
	 *
	 * @param uuid the employee details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeDetails
		fetchEmployeeDetailsByUuidAndGroupId(String uuid, long groupId) {

		return _employeeDetailsLocalService.
			fetchEmployeeDetailsByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<Object[]> FilterByDepartmentDesignationName(
		String departName, String desgiName) {

		return _employeeDetailsLocalService.FilterByDepartmentDesignationName(
			departName, desgiName);
	}

	@Override
	public com.ax.hrms.model.EmployeeDetails findByEmployeeId(long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return _employeeDetailsLocalService.findByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.EmployeeDetails> findByEmployeeName(
		String firstName, String lastName) {

		return _employeeDetailsLocalService.findByEmployeeName(
			firstName, lastName);
	}

	@Override
	public java.util.List<com.ax.hrms.model.EmployeeDetails> findByIsTerminated(
		boolean isTerminated) {

		return _employeeDetailsLocalService.findByIsTerminated(isTerminated);
	}

	@Override
	public java.util.List<com.ax.hrms.model.EmployeeDetails> findByLeavingDate(
		java.util.Date date) {

		return _employeeDetailsLocalService.findByLeavingDate(date);
	}

	@Override
	public com.ax.hrms.model.EmployeeDetails findByLrUserId(long lrUserId)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return _employeeDetailsLocalService.findByLrUserId(lrUserId);
	}

	@Override
	public java.util.List<Object[]> findEmployeeByName(
		String fName, String lName) {

		return _employeeDetailsLocalService.findEmployeeByName(fName, lName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeDetailsLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<Long> getAllContinuedEmployeeId() {
		return _employeeDetailsLocalService.getAllContinuedEmployeeId();
	}

	@Override
	public java.util.List<Object[]> getAllDesigByEmpId(long empId) {
		return _employeeDetailsLocalService.getAllDesigByEmpId(empId);
	}

	/**
	 * Returns the employee details with the primary key.
	 *
	 * @param employeeId the primary key of the employee details
	 * @return the employee details
	 * @throws PortalException if a employee details with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeDetails getEmployeeDetails(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDetailsLocalService.getEmployeeDetails(employeeId);
	}

	/**
	 * Returns the employee details matching the UUID and group.
	 *
	 * @param uuid the employee details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee details
	 * @throws PortalException if a matching employee details could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeDetails getEmployeeDetailsByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDetailsLocalService.getEmployeeDetailsByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of employee detailses
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeDetails>
		getEmployeeDetailses(int start, int end) {

		return _employeeDetailsLocalService.getEmployeeDetailses(start, end);
	}

	/**
	 * Returns all the employee detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee detailses
	 * @param companyId the primary key of the company
	 * @return the matching employee detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeDetails>
		getEmployeeDetailsesByUuidAndCompanyId(String uuid, long companyId) {

		return _employeeDetailsLocalService.
			getEmployeeDetailsesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of employee detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeDetails>
		getEmployeeDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.EmployeeDetails> orderByComparator) {

		return _employeeDetailsLocalService.
			getEmployeeDetailsesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee detailses.
	 *
	 * @return the number of employee detailses
	 */
	@Override
	public int getEmployeeDetailsesCount() {
		return _employeeDetailsLocalService.getEmployeeDetailsesCount();
	}

	@Override
	public java.util.List<Long> getEmployeeIdByDepartmentId(long departmentId) {
		return _employeeDetailsLocalService.getEmployeeIdByDepartmentId(
			departmentId);
	}

	@Override
	public java.util.List<Long> getEmployeeIdByDesignationId(
		long designationId) {

		return _employeeDetailsLocalService.getEmployeeIdByDesignationId(
			designationId);
	}

	@Override
	public java.util.List<Long> getEmployeeIdByDesignationIdAndDepartmentId(
		long designationId, long departmentId) {

		return _employeeDetailsLocalService.
			getEmployeeIdByDesignationIdAndDepartmentId(
				designationId, departmentId);
	}

	@Override
	public java.util.List<Long> getEmployeeIdByLruserid(long lruserid) {
		return _employeeDetailsLocalService.getEmployeeIdByLruserid(lruserid);
	}

	@Override
	public java.util.List<Long> getEmployeeIdByNameString(String nameStr) {
		return _employeeDetailsLocalService.getEmployeeIdByNameString(nameStr);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _employeeDetailsLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDetails the employee details
	 * @return the employee details that was updated
	 */
	@Override
	public com.ax.hrms.model.EmployeeDetails updateEmployeeDetails(
		com.ax.hrms.model.EmployeeDetails employeeDetails) {

		return _employeeDetailsLocalService.updateEmployeeDetails(
			employeeDetails);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _employeeDetailsLocalService.getBasePersistence();
	}

	@Override
	public EmployeeDetailsLocalService getWrappedService() {
		return _employeeDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeDetailsLocalService employeeDetailsLocalService) {

		_employeeDetailsLocalService = employeeDetailsLocalService;
	}

	private EmployeeDetailsLocalService _employeeDetailsLocalService;

}