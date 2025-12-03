/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ProjectTaskStatusMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectTaskStatusMasterLocalService
 * @generated
 */
public class ProjectTaskStatusMasterLocalServiceWrapper
	implements ProjectTaskStatusMasterLocalService,
			   ServiceWrapper<ProjectTaskStatusMasterLocalService> {

	public ProjectTaskStatusMasterLocalServiceWrapper() {
		this(null);
	}

	public ProjectTaskStatusMasterLocalServiceWrapper(
		ProjectTaskStatusMasterLocalService
			projectTaskStatusMasterLocalService) {

		_projectTaskStatusMasterLocalService =
			projectTaskStatusMasterLocalService;
	}

	/**
	 * Adds the project task status master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectTaskStatusMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectTaskStatusMaster the project task status master
	 * @return the project task status master that was added
	 */
	@Override
	public com.ax.hrms.master.model.ProjectTaskStatusMaster
		addProjectTaskStatusMaster(
			com.ax.hrms.master.model.ProjectTaskStatusMaster
				projectTaskStatusMaster) {

		return _projectTaskStatusMasterLocalService.addProjectTaskStatusMaster(
			projectTaskStatusMaster);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectTaskStatusMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new project task status master with the primary key. Does not add the project task status master to the database.
	 *
	 * @param projectTaskStatusMasterId the primary key for the new project task status master
	 * @return the new project task status master
	 */
	@Override
	public com.ax.hrms.master.model.ProjectTaskStatusMaster
		createProjectTaskStatusMaster(long projectTaskStatusMasterId) {

		return _projectTaskStatusMasterLocalService.
			createProjectTaskStatusMaster(projectTaskStatusMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectTaskStatusMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the project task status master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectTaskStatusMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectTaskStatusMasterId the primary key of the project task status master
	 * @return the project task status master that was removed
	 * @throws PortalException if a project task status master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.ProjectTaskStatusMaster
			deleteProjectTaskStatusMaster(long projectTaskStatusMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectTaskStatusMasterLocalService.
			deleteProjectTaskStatusMaster(projectTaskStatusMasterId);
	}

	/**
	 * Deletes the project task status master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectTaskStatusMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectTaskStatusMaster the project task status master
	 * @return the project task status master that was removed
	 */
	@Override
	public com.ax.hrms.master.model.ProjectTaskStatusMaster
		deleteProjectTaskStatusMaster(
			com.ax.hrms.master.model.ProjectTaskStatusMaster
				projectTaskStatusMaster) {

		return _projectTaskStatusMasterLocalService.
			deleteProjectTaskStatusMaster(projectTaskStatusMaster);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _projectTaskStatusMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _projectTaskStatusMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectTaskStatusMasterLocalService.dynamicQuery();
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

		return _projectTaskStatusMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.ProjectTaskStatusMasterModelImpl</code>.
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

		return _projectTaskStatusMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.ProjectTaskStatusMasterModelImpl</code>.
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

		return _projectTaskStatusMasterLocalService.dynamicQuery(
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

		return _projectTaskStatusMasterLocalService.dynamicQueryCount(
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

		return _projectTaskStatusMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.master.model.ProjectTaskStatusMaster
			fetchBystatusNameAndApplicableFor(
				String projectTaskStatusName, String applicableFor)
		throws com.ax.hrms.master.exception.
			NoSuchProjectTaskStatusMasterException {

		return _projectTaskStatusMasterLocalService.
			fetchBystatusNameAndApplicableFor(
				projectTaskStatusName, applicableFor);
	}

	@Override
	public com.ax.hrms.master.model.ProjectTaskStatusMaster
		fetchProjectTaskStatusMaster(long projectTaskStatusMasterId) {

		return _projectTaskStatusMasterLocalService.
			fetchProjectTaskStatusMaster(projectTaskStatusMasterId);
	}

	@Override
	public com.ax.hrms.master.model.ProjectTaskStatusMaster
			findByProjectTaskStatusName(String projectTaskStatusName)
		throws com.ax.hrms.master.exception.
			NoSuchProjectTaskStatusMasterException {

		return _projectTaskStatusMasterLocalService.findByProjectTaskStatusName(
			projectTaskStatusName);
	}

	@Override
	public com.ax.hrms.master.model.ProjectTaskStatusMaster
			findBystatusNameAndApplicableFor(
				String projectTaskStatusName, String applicableFor)
		throws com.ax.hrms.master.exception.
			NoSuchProjectTaskStatusMasterException {

		return _projectTaskStatusMasterLocalService.
			findBystatusNameAndApplicableFor(
				projectTaskStatusName, applicableFor);
	}

	@Override
	public com.ax.hrms.master.model.ProjectTaskStatusMaster
			findByStatusNameAndApplicableForProjectAndTask(
				String projectTaskStatusName, boolean isApplicableForProject,
				boolean isApplicableForTask)
		throws com.ax.hrms.master.exception.
			NoSuchProjectTaskStatusMasterException {

		return _projectTaskStatusMasterLocalService.
			findByStatusNameAndApplicableForProjectAndTask(
				projectTaskStatusName, isApplicableForProject,
				isApplicableForTask);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _projectTaskStatusMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _projectTaskStatusMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectTaskStatusMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectTaskStatusMasterLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the project task status master with the primary key.
	 *
	 * @param projectTaskStatusMasterId the primary key of the project task status master
	 * @return the project task status master
	 * @throws PortalException if a project task status master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.ProjectTaskStatusMaster
			getProjectTaskStatusMaster(long projectTaskStatusMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectTaskStatusMasterLocalService.getProjectTaskStatusMaster(
			projectTaskStatusMasterId);
	}

	/**
	 * Returns a range of all the project task status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.ProjectTaskStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project task status masters
	 * @param end the upper bound of the range of project task status masters (not inclusive)
	 * @return the range of project task status masters
	 */
	@Override
	public java.util.List<com.ax.hrms.master.model.ProjectTaskStatusMaster>
		getProjectTaskStatusMasters(int start, int end) {

		return _projectTaskStatusMasterLocalService.getProjectTaskStatusMasters(
			start, end);
	}

	/**
	 * Returns the number of project task status masters.
	 *
	 * @return the number of project task status masters
	 */
	@Override
	public int getProjectTaskStatusMastersCount() {
		return _projectTaskStatusMasterLocalService.
			getProjectTaskStatusMastersCount();
	}

	/**
	 * Updates the project task status master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectTaskStatusMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectTaskStatusMaster the project task status master
	 * @return the project task status master that was updated
	 */
	@Override
	public com.ax.hrms.master.model.ProjectTaskStatusMaster
		updateProjectTaskStatusMaster(
			com.ax.hrms.master.model.ProjectTaskStatusMaster
				projectTaskStatusMaster) {

		return _projectTaskStatusMasterLocalService.
			updateProjectTaskStatusMaster(projectTaskStatusMaster);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _projectTaskStatusMasterLocalService.getBasePersistence();
	}

	@Override
	public ProjectTaskStatusMasterLocalService getWrappedService() {
		return _projectTaskStatusMasterLocalService;
	}

	@Override
	public void setWrappedService(
		ProjectTaskStatusMasterLocalService
			projectTaskStatusMasterLocalService) {

		_projectTaskStatusMasterLocalService =
			projectTaskStatusMasterLocalService;
	}

	private ProjectTaskStatusMasterLocalService
		_projectTaskStatusMasterLocalService;

}