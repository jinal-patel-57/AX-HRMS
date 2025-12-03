/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EmployeeDesignationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDesignationLocalService
 * @generated
 */
public class EmployeeDesignationLocalServiceWrapper
	implements EmployeeDesignationLocalService,
			   ServiceWrapper<EmployeeDesignationLocalService> {

	public EmployeeDesignationLocalServiceWrapper() {
		this(null);
	}

	public EmployeeDesignationLocalServiceWrapper(
		EmployeeDesignationLocalService employeeDesignationLocalService) {

		_employeeDesignationLocalService = employeeDesignationLocalService;
	}

	/**
	 * Adds the employee designation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDesignation the employee designation
	 * @return the employee designation that was added
	 */
	@Override
	public com.ax.hrms.model.EmployeeDesignation addEmployeeDesignation(
		com.ax.hrms.model.EmployeeDesignation employeeDesignation) {

		return _employeeDesignationLocalService.addEmployeeDesignation(
			employeeDesignation);
	}

	/**
	 * Creates a new employee designation with the primary key. Does not add the employee designation to the database.
	 *
	 * @param employeeDesignationId the primary key for the new employee designation
	 * @return the new employee designation
	 */
	@Override
	public com.ax.hrms.model.EmployeeDesignation createEmployeeDesignation(
		long employeeDesignationId) {

		return _employeeDesignationLocalService.createEmployeeDesignation(
			employeeDesignationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDesignationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee designation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDesignation the employee designation
	 * @return the employee designation that was removed
	 */
	@Override
	public com.ax.hrms.model.EmployeeDesignation deleteEmployeeDesignation(
		com.ax.hrms.model.EmployeeDesignation employeeDesignation) {

		return _employeeDesignationLocalService.deleteEmployeeDesignation(
			employeeDesignation);
	}

	/**
	 * Deletes the employee designation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDesignationId the primary key of the employee designation
	 * @return the employee designation that was removed
	 * @throws PortalException if a employee designation with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeDesignation deleteEmployeeDesignation(
			long employeeDesignationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDesignationLocalService.deleteEmployeeDesignation(
			employeeDesignationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDesignationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _employeeDesignationLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _employeeDesignationLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeDesignationLocalService.dynamicQuery();
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

		return _employeeDesignationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeDesignationModelImpl</code>.
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

		return _employeeDesignationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeDesignationModelImpl</code>.
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

		return _employeeDesignationLocalService.dynamicQuery(
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

		return _employeeDesignationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeDesignationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.EmployeeDesignation fetchEmployeeDesignation(
		long employeeDesignationId) {

		return _employeeDesignationLocalService.fetchEmployeeDesignation(
			employeeDesignationId);
	}

	/**
	 * Returns the employee designation matching the UUID and group.
	 *
	 * @param uuid the employee designation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee designation, or <code>null</code> if a matching employee designation could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeDesignation
		fetchEmployeeDesignationByUuidAndGroupId(String uuid, long groupId) {

		return _employeeDesignationLocalService.
			fetchEmployeeDesignationByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.ax.hrms.model.EmployeeDesignation findByEmployeeId(
			long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeDesignationException {

		return _employeeDesignationLocalService.findByEmployeeId(employeeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeDesignationLocalService.getActionableDynamicQuery();
	}

	@Override
	public long getDesignationIdByEmployeeId(long employeeId) {
		return _employeeDesignationLocalService.getDesignationIdByEmployeeId(
			employeeId);
	}

	/**
	 * Returns the employee designation with the primary key.
	 *
	 * @param employeeDesignationId the primary key of the employee designation
	 * @return the employee designation
	 * @throws PortalException if a employee designation with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeDesignation getEmployeeDesignation(
			long employeeDesignationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDesignationLocalService.getEmployeeDesignation(
			employeeDesignationId);
	}

	/**
	 * Returns the employee designation matching the UUID and group.
	 *
	 * @param uuid the employee designation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee designation
	 * @throws PortalException if a matching employee designation could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeDesignation
			getEmployeeDesignationByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDesignationLocalService.
			getEmployeeDesignationByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the employee designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @return the range of employee designations
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeDesignation>
		getEmployeeDesignations(int start, int end) {

		return _employeeDesignationLocalService.getEmployeeDesignations(
			start, end);
	}

	/**
	 * Returns all the employee designations matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee designations
	 * @param companyId the primary key of the company
	 * @return the matching employee designations, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeDesignation>
		getEmployeeDesignationsByUuidAndCompanyId(String uuid, long companyId) {

		return _employeeDesignationLocalService.
			getEmployeeDesignationsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of employee designations matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee designations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee designations, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeDesignation>
		getEmployeeDesignationsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.EmployeeDesignation> orderByComparator) {

		return _employeeDesignationLocalService.
			getEmployeeDesignationsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee designations.
	 *
	 * @return the number of employee designations
	 */
	@Override
	public int getEmployeeDesignationsCount() {
		return _employeeDesignationLocalService.getEmployeeDesignationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _employeeDesignationLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeDesignationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDesignationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDesignationLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the employee designation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDesignation the employee designation
	 * @return the employee designation that was updated
	 */
	@Override
	public com.ax.hrms.model.EmployeeDesignation updateEmployeeDesignation(
		com.ax.hrms.model.EmployeeDesignation employeeDesignation) {

		return _employeeDesignationLocalService.updateEmployeeDesignation(
			employeeDesignation);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _employeeDesignationLocalService.getBasePersistence();
	}

	@Override
	public EmployeeDesignationLocalService getWrappedService() {
		return _employeeDesignationLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeDesignationLocalService employeeDesignationLocalService) {

		_employeeDesignationLocalService = employeeDesignationLocalService;
	}

	private EmployeeDesignationLocalService _employeeDesignationLocalService;

}