/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EmployeeEducationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeEducationLocalService
 * @generated
 */
public class EmployeeEducationLocalServiceWrapper
	implements EmployeeEducationLocalService,
			   ServiceWrapper<EmployeeEducationLocalService> {

	public EmployeeEducationLocalServiceWrapper() {
		this(null);
	}

	public EmployeeEducationLocalServiceWrapper(
		EmployeeEducationLocalService employeeEducationLocalService) {

		_employeeEducationLocalService = employeeEducationLocalService;
	}

	/**
	 * Adds the employee education to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeEducationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeEducation the employee education
	 * @return the employee education that was added
	 */
	@Override
	public com.ax.hrms.model.EmployeeEducation addEmployeeEducation(
		com.ax.hrms.model.EmployeeEducation employeeEducation) {

		return _employeeEducationLocalService.addEmployeeEducation(
			employeeEducation);
	}

	/**
	 * Creates a new employee education with the primary key. Does not add the employee education to the database.
	 *
	 * @param educationId the primary key for the new employee education
	 * @return the new employee education
	 */
	@Override
	public com.ax.hrms.model.EmployeeEducation createEmployeeEducation(
		long educationId) {

		return _employeeEducationLocalService.createEmployeeEducation(
			educationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeEducationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee education from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeEducationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeEducation the employee education
	 * @return the employee education that was removed
	 */
	@Override
	public com.ax.hrms.model.EmployeeEducation deleteEmployeeEducation(
		com.ax.hrms.model.EmployeeEducation employeeEducation) {

		return _employeeEducationLocalService.deleteEmployeeEducation(
			employeeEducation);
	}

	/**
	 * Deletes the employee education with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeEducationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param educationId the primary key of the employee education
	 * @return the employee education that was removed
	 * @throws PortalException if a employee education with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeEducation deleteEmployeeEducation(
			long educationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeEducationLocalService.deleteEmployeeEducation(
			educationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeEducationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _employeeEducationLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _employeeEducationLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeEducationLocalService.dynamicQuery();
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

		return _employeeEducationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeEducationModelImpl</code>.
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

		return _employeeEducationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeEducationModelImpl</code>.
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

		return _employeeEducationLocalService.dynamicQuery(
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

		return _employeeEducationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeEducationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.EmployeeEducation fetchEmployeeEducation(
		long educationId) {

		return _employeeEducationLocalService.fetchEmployeeEducation(
			educationId);
	}

	/**
	 * Returns the employee education matching the UUID and group.
	 *
	 * @param uuid the employee education's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee education, or <code>null</code> if a matching employee education could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeEducation
		fetchEmployeeEducationByUuidAndGroupId(String uuid, long groupId) {

		return _employeeEducationLocalService.
			fetchEmployeeEducationByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.EmployeeEducation> findByEmployeeId(
		long employeeId) {

		return _employeeEducationLocalService.findByEmployeeId(employeeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeEducationLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the employee education with the primary key.
	 *
	 * @param educationId the primary key of the employee education
	 * @return the employee education
	 * @throws PortalException if a employee education with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeEducation getEmployeeEducation(
			long educationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeEducationLocalService.getEmployeeEducation(educationId);
	}

	/**
	 * Returns the employee education matching the UUID and group.
	 *
	 * @param uuid the employee education's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee education
	 * @throws PortalException if a matching employee education could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeEducation
			getEmployeeEducationByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeEducationLocalService.
			getEmployeeEducationByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the employee educations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @return the range of employee educations
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeEducation>
		getEmployeeEducations(int start, int end) {

		return _employeeEducationLocalService.getEmployeeEducations(start, end);
	}

	/**
	 * Returns all the employee educations matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee educations
	 * @param companyId the primary key of the company
	 * @return the matching employee educations, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeEducation>
		getEmployeeEducationsByUuidAndCompanyId(String uuid, long companyId) {

		return _employeeEducationLocalService.
			getEmployeeEducationsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of employee educations matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee educations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee educations, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeEducation>
		getEmployeeEducationsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.EmployeeEducation> orderByComparator) {

		return _employeeEducationLocalService.
			getEmployeeEducationsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee educations.
	 *
	 * @return the number of employee educations
	 */
	@Override
	public int getEmployeeEducationsCount() {
		return _employeeEducationLocalService.getEmployeeEducationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _employeeEducationLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeEducationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeEducationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeEducationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee education in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeEducationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeEducation the employee education
	 * @return the employee education that was updated
	 */
	@Override
	public com.ax.hrms.model.EmployeeEducation updateEmployeeEducation(
		com.ax.hrms.model.EmployeeEducation employeeEducation) {

		return _employeeEducationLocalService.updateEmployeeEducation(
			employeeEducation);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _employeeEducationLocalService.getBasePersistence();
	}

	@Override
	public EmployeeEducationLocalService getWrappedService() {
		return _employeeEducationLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeEducationLocalService employeeEducationLocalService) {

		_employeeEducationLocalService = employeeEducationLocalService;
	}

	private EmployeeEducationLocalService _employeeEducationLocalService;

}