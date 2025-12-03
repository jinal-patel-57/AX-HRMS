/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EmployeeProbationDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeProbationDetailsLocalService
 * @generated
 */
public class EmployeeProbationDetailsLocalServiceWrapper
	implements EmployeeProbationDetailsLocalService,
			   ServiceWrapper<EmployeeProbationDetailsLocalService> {

	public EmployeeProbationDetailsLocalServiceWrapper() {
		this(null);
	}

	public EmployeeProbationDetailsLocalServiceWrapper(
		EmployeeProbationDetailsLocalService
			employeeProbationDetailsLocalService) {

		_employeeProbationDetailsLocalService =
			employeeProbationDetailsLocalService;
	}

	/**
	 * Adds the employee probation details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeProbationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeProbationDetails the employee probation details
	 * @return the employee probation details that was added
	 */
	@Override
	public com.ax.hrms.model.EmployeeProbationDetails
		addEmployeeProbationDetails(
			com.ax.hrms.model.EmployeeProbationDetails
				employeeProbationDetails) {

		return _employeeProbationDetailsLocalService.
			addEmployeeProbationDetails(employeeProbationDetails);
	}

	/**
	 * Creates a new employee probation details with the primary key. Does not add the employee probation details to the database.
	 *
	 * @param probationDetailId the primary key for the new employee probation details
	 * @return the new employee probation details
	 */
	@Override
	public com.ax.hrms.model.EmployeeProbationDetails
		createEmployeeProbationDetails(long probationDetailId) {

		return _employeeProbationDetailsLocalService.
			createEmployeeProbationDetails(probationDetailId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeProbationDetailsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee probation details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeProbationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeProbationDetails the employee probation details
	 * @return the employee probation details that was removed
	 */
	@Override
	public com.ax.hrms.model.EmployeeProbationDetails
		deleteEmployeeProbationDetails(
			com.ax.hrms.model.EmployeeProbationDetails
				employeeProbationDetails) {

		return _employeeProbationDetailsLocalService.
			deleteEmployeeProbationDetails(employeeProbationDetails);
	}

	/**
	 * Deletes the employee probation details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeProbationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param probationDetailId the primary key of the employee probation details
	 * @return the employee probation details that was removed
	 * @throws PortalException if a employee probation details with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeProbationDetails
			deleteEmployeeProbationDetails(long probationDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeProbationDetailsLocalService.
			deleteEmployeeProbationDetails(probationDetailId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeProbationDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _employeeProbationDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _employeeProbationDetailsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeProbationDetailsLocalService.dynamicQuery();
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

		return _employeeProbationDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeProbationDetailsModelImpl</code>.
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

		return _employeeProbationDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeProbationDetailsModelImpl</code>.
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

		return _employeeProbationDetailsLocalService.dynamicQuery(
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

		return _employeeProbationDetailsLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _employeeProbationDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.EmployeeProbationDetails
		fetchEmployeeProbationDetails(long probationDetailId) {

		return _employeeProbationDetailsLocalService.
			fetchEmployeeProbationDetails(probationDetailId);
	}

	/**
	 * Returns the employee probation details matching the UUID and group.
	 *
	 * @param uuid the employee probation details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee probation details, or <code>null</code> if a matching employee probation details could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeProbationDetails
		fetchEmployeeProbationDetailsByUuidAndGroupId(
			String uuid, long groupId) {

		return _employeeProbationDetailsLocalService.
			fetchEmployeeProbationDetailsByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.ax.hrms.model.EmployeeProbationDetails findByEmployeeId(
			long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeProbationDetailsException {

		return _employeeProbationDetailsLocalService.findByEmployeeId(
			employeeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeProbationDetailsLocalService.
			getActionableDynamicQuery();
	}

	/**
	 * Returns the employee probation details with the primary key.
	 *
	 * @param probationDetailId the primary key of the employee probation details
	 * @return the employee probation details
	 * @throws PortalException if a employee probation details with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeProbationDetails
			getEmployeeProbationDetails(long probationDetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeProbationDetailsLocalService.
			getEmployeeProbationDetails(probationDetailId);
	}

	/**
	 * Returns the employee probation details matching the UUID and group.
	 *
	 * @param uuid the employee probation details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee probation details
	 * @throws PortalException if a matching employee probation details could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeProbationDetails
			getEmployeeProbationDetailsByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeProbationDetailsLocalService.
			getEmployeeProbationDetailsByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the employee probation detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee probation detailses
	 * @param end the upper bound of the range of employee probation detailses (not inclusive)
	 * @return the range of employee probation detailses
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeProbationDetails>
		getEmployeeProbationDetailses(int start, int end) {

		return _employeeProbationDetailsLocalService.
			getEmployeeProbationDetailses(start, end);
	}

	/**
	 * Returns all the employee probation detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee probation detailses
	 * @param companyId the primary key of the company
	 * @return the matching employee probation detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeProbationDetails>
		getEmployeeProbationDetailsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _employeeProbationDetailsLocalService.
			getEmployeeProbationDetailsesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of employee probation detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee probation detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee probation detailses
	 * @param end the upper bound of the range of employee probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee probation detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeProbationDetails>
		getEmployeeProbationDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.EmployeeProbationDetails>
					orderByComparator) {

		return _employeeProbationDetailsLocalService.
			getEmployeeProbationDetailsesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee probation detailses.
	 *
	 * @return the number of employee probation detailses
	 */
	@Override
	public int getEmployeeProbationDetailsesCount() {
		return _employeeProbationDetailsLocalService.
			getEmployeeProbationDetailsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _employeeProbationDetailsLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeProbationDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeProbationDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeProbationDetailsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the employee probation details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeProbationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeProbationDetails the employee probation details
	 * @return the employee probation details that was updated
	 */
	@Override
	public com.ax.hrms.model.EmployeeProbationDetails
		updateEmployeeProbationDetails(
			com.ax.hrms.model.EmployeeProbationDetails
				employeeProbationDetails) {

		return _employeeProbationDetailsLocalService.
			updateEmployeeProbationDetails(employeeProbationDetails);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _employeeProbationDetailsLocalService.getBasePersistence();
	}

	@Override
	public EmployeeProbationDetailsLocalService getWrappedService() {
		return _employeeProbationDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeProbationDetailsLocalService
			employeeProbationDetailsLocalService) {

		_employeeProbationDetailsLocalService =
			employeeProbationDetailsLocalService;
	}

	private EmployeeProbationDetailsLocalService
		_employeeProbationDetailsLocalService;

}