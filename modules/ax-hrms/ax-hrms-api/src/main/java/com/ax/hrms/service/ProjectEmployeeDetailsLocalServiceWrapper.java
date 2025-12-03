/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ProjectEmployeeDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectEmployeeDetailsLocalService
 * @generated
 */
public class ProjectEmployeeDetailsLocalServiceWrapper
	implements ProjectEmployeeDetailsLocalService,
			   ServiceWrapper<ProjectEmployeeDetailsLocalService> {

	public ProjectEmployeeDetailsLocalServiceWrapper() {
		this(null);
	}

	public ProjectEmployeeDetailsLocalServiceWrapper(
		ProjectEmployeeDetailsLocalService projectEmployeeDetailsLocalService) {

		_projectEmployeeDetailsLocalService =
			projectEmployeeDetailsLocalService;
	}

	/**
	 * Adds the project employee details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectEmployeeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectEmployeeDetails the project employee details
	 * @return the project employee details that was added
	 */
	@Override
	public com.ax.hrms.model.ProjectEmployeeDetails addProjectEmployeeDetails(
		com.ax.hrms.model.ProjectEmployeeDetails projectEmployeeDetails) {

		return _projectEmployeeDetailsLocalService.addProjectEmployeeDetails(
			projectEmployeeDetails);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectEmployeeDetailsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new project employee details with the primary key. Does not add the project employee details to the database.
	 *
	 * @param projectEmployeeDetailsId the primary key for the new project employee details
	 * @return the new project employee details
	 */
	@Override
	public com.ax.hrms.model.ProjectEmployeeDetails
		createProjectEmployeeDetails(long projectEmployeeDetailsId) {

		return _projectEmployeeDetailsLocalService.createProjectEmployeeDetails(
			projectEmployeeDetailsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectEmployeeDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the project employee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectEmployeeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectEmployeeDetailsId the primary key of the project employee details
	 * @return the project employee details that was removed
	 * @throws PortalException if a project employee details with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.ProjectEmployeeDetails
			deleteProjectEmployeeDetails(long projectEmployeeDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectEmployeeDetailsLocalService.deleteProjectEmployeeDetails(
			projectEmployeeDetailsId);
	}

	/**
	 * Deletes the project employee details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectEmployeeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectEmployeeDetails the project employee details
	 * @return the project employee details that was removed
	 */
	@Override
	public com.ax.hrms.model.ProjectEmployeeDetails
		deleteProjectEmployeeDetails(
			com.ax.hrms.model.ProjectEmployeeDetails projectEmployeeDetails) {

		return _projectEmployeeDetailsLocalService.deleteProjectEmployeeDetails(
			projectEmployeeDetails);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _projectEmployeeDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _projectEmployeeDetailsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectEmployeeDetailsLocalService.dynamicQuery();
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

		return _projectEmployeeDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.ProjectEmployeeDetailsModelImpl</code>.
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

		return _projectEmployeeDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.ProjectEmployeeDetailsModelImpl</code>.
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

		return _projectEmployeeDetailsLocalService.dynamicQuery(
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

		return _projectEmployeeDetailsLocalService.dynamicQueryCount(
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

		return _projectEmployeeDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.ProjectEmployeeDetails fetchProjectEmployeeDetails(
		long projectEmployeeDetailsId) {

		return _projectEmployeeDetailsLocalService.fetchProjectEmployeeDetails(
			projectEmployeeDetailsId);
	}

	/**
	 * Returns the project employee details matching the UUID and group.
	 *
	 * @param uuid the project employee details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	@Override
	public com.ax.hrms.model.ProjectEmployeeDetails
		fetchProjectEmployeeDetailsByUuidAndGroupId(String uuid, long groupId) {

		return _projectEmployeeDetailsLocalService.
			fetchProjectEmployeeDetailsByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.ProjectEmployeeDetails>
		findByEmployeeId(long employeeId) {

		return _projectEmployeeDetailsLocalService.findByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.ProjectEmployeeDetails>
		findByEmployeeId(long employeeId, int start, int end) {

		return _projectEmployeeDetailsLocalService.findByEmployeeId(
			employeeId, start, end);
	}

	@Override
	public java.util.List<com.ax.hrms.model.ProjectEmployeeDetails>
		findByProjectId(long projectId) {

		return _projectEmployeeDetailsLocalService.findByProjectId(projectId);
	}

	@Override
	public com.ax.hrms.model.ProjectEmployeeDetails
			findByProjectIdAndEmployeeId(long projectId, long employeeId)
		throws com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException {

		return _projectEmployeeDetailsLocalService.findByProjectIdAndEmployeeId(
			projectId, employeeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _projectEmployeeDetailsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _projectEmployeeDetailsLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _projectEmployeeDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectEmployeeDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectEmployeeDetailsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the project employee details with the primary key.
	 *
	 * @param projectEmployeeDetailsId the primary key of the project employee details
	 * @return the project employee details
	 * @throws PortalException if a project employee details with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.ProjectEmployeeDetails getProjectEmployeeDetails(
			long projectEmployeeDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectEmployeeDetailsLocalService.getProjectEmployeeDetails(
			projectEmployeeDetailsId);
	}

	/**
	 * Returns the project employee details matching the UUID and group.
	 *
	 * @param uuid the project employee details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project employee details
	 * @throws PortalException if a matching project employee details could not be found
	 */
	@Override
	public com.ax.hrms.model.ProjectEmployeeDetails
			getProjectEmployeeDetailsByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectEmployeeDetailsLocalService.
			getProjectEmployeeDetailsByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the project employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @return the range of project employee detailses
	 */
	@Override
	public java.util.List<com.ax.hrms.model.ProjectEmployeeDetails>
		getProjectEmployeeDetailses(int start, int end) {

		return _projectEmployeeDetailsLocalService.getProjectEmployeeDetailses(
			start, end);
	}

	/**
	 * Returns all the project employee detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the project employee detailses
	 * @param companyId the primary key of the company
	 * @return the matching project employee detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.ProjectEmployeeDetails>
		getProjectEmployeeDetailsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _projectEmployeeDetailsLocalService.
			getProjectEmployeeDetailsesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of project employee detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the project employee detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching project employee detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.ProjectEmployeeDetails>
		getProjectEmployeeDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.ProjectEmployeeDetails> orderByComparator) {

		return _projectEmployeeDetailsLocalService.
			getProjectEmployeeDetailsesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of project employee detailses.
	 *
	 * @return the number of project employee detailses
	 */
	@Override
	public int getProjectEmployeeDetailsesCount() {
		return _projectEmployeeDetailsLocalService.
			getProjectEmployeeDetailsesCount();
	}

	/**
	 * Updates the project employee details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectEmployeeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectEmployeeDetails the project employee details
	 * @return the project employee details that was updated
	 */
	@Override
	public com.ax.hrms.model.ProjectEmployeeDetails
		updateProjectEmployeeDetails(
			com.ax.hrms.model.ProjectEmployeeDetails projectEmployeeDetails) {

		return _projectEmployeeDetailsLocalService.updateProjectEmployeeDetails(
			projectEmployeeDetails);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _projectEmployeeDetailsLocalService.getBasePersistence();
	}

	@Override
	public ProjectEmployeeDetailsLocalService getWrappedService() {
		return _projectEmployeeDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		ProjectEmployeeDetailsLocalService projectEmployeeDetailsLocalService) {

		_projectEmployeeDetailsLocalService =
			projectEmployeeDetailsLocalService;
	}

	private ProjectEmployeeDetailsLocalService
		_projectEmployeeDetailsLocalService;

}