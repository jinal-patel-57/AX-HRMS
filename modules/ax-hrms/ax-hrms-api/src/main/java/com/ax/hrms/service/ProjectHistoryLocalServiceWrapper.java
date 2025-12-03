/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ProjectHistoryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectHistoryLocalService
 * @generated
 */
public class ProjectHistoryLocalServiceWrapper
	implements ProjectHistoryLocalService,
			   ServiceWrapper<ProjectHistoryLocalService> {

	public ProjectHistoryLocalServiceWrapper() {
		this(null);
	}

	public ProjectHistoryLocalServiceWrapper(
		ProjectHistoryLocalService projectHistoryLocalService) {

		_projectHistoryLocalService = projectHistoryLocalService;
	}

	/**
	 * Adds the project history to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectHistory the project history
	 * @return the project history that was added
	 */
	@Override
	public com.ax.hrms.model.ProjectHistory addProjectHistory(
		com.ax.hrms.model.ProjectHistory projectHistory) {

		return _projectHistoryLocalService.addProjectHistory(projectHistory);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectHistoryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new project history with the primary key. Does not add the project history to the database.
	 *
	 * @param projectHistoryId the primary key for the new project history
	 * @return the new project history
	 */
	@Override
	public com.ax.hrms.model.ProjectHistory createProjectHistory(
		long projectHistoryId) {

		return _projectHistoryLocalService.createProjectHistory(
			projectHistoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectHistoryLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the project history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectHistoryId the primary key of the project history
	 * @return the project history that was removed
	 * @throws PortalException if a project history with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.ProjectHistory deleteProjectHistory(
			long projectHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectHistoryLocalService.deleteProjectHistory(
			projectHistoryId);
	}

	/**
	 * Deletes the project history from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectHistory the project history
	 * @return the project history that was removed
	 */
	@Override
	public com.ax.hrms.model.ProjectHistory deleteProjectHistory(
		com.ax.hrms.model.ProjectHistory projectHistory) {

		return _projectHistoryLocalService.deleteProjectHistory(projectHistory);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _projectHistoryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _projectHistoryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectHistoryLocalService.dynamicQuery();
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

		return _projectHistoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.ProjectHistoryModelImpl</code>.
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

		return _projectHistoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.ProjectHistoryModelImpl</code>.
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

		return _projectHistoryLocalService.dynamicQuery(
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

		return _projectHistoryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _projectHistoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.ProjectHistory fetchProjectHistory(
		long projectHistoryId) {

		return _projectHistoryLocalService.fetchProjectHistory(
			projectHistoryId);
	}

	/**
	 * Returns the project history matching the UUID and group.
	 *
	 * @param uuid the project history's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project history, or <code>null</code> if a matching project history could not be found
	 */
	@Override
	public com.ax.hrms.model.ProjectHistory fetchProjectHistoryByUuidAndGroupId(
		String uuid, long groupId) {

		return _projectHistoryLocalService.fetchProjectHistoryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.ProjectHistory> findByManagerId(
		long managerId) {

		return _projectHistoryLocalService.findByManagerId(managerId);
	}

	@Override
	public com.ax.hrms.model.ProjectHistory findByProjectId(long projectId)
		throws com.ax.hrms.exception.NoSuchProjectHistoryException {

		return _projectHistoryLocalService.findByProjectId(projectId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _projectHistoryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _projectHistoryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _projectHistoryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectHistoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectHistoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the project histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @return the range of project histories
	 */
	@Override
	public java.util.List<com.ax.hrms.model.ProjectHistory> getProjectHistories(
		int start, int end) {

		return _projectHistoryLocalService.getProjectHistories(start, end);
	}

	/**
	 * Returns all the project histories matching the UUID and company.
	 *
	 * @param uuid the UUID of the project histories
	 * @param companyId the primary key of the company
	 * @return the matching project histories, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.ProjectHistory>
		getProjectHistoriesByUuidAndCompanyId(String uuid, long companyId) {

		return _projectHistoryLocalService.
			getProjectHistoriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of project histories matching the UUID and company.
	 *
	 * @param uuid the UUID of the project histories
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching project histories, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.ProjectHistory>
		getProjectHistoriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.ProjectHistory> orderByComparator) {

		return _projectHistoryLocalService.
			getProjectHistoriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of project histories.
	 *
	 * @return the number of project histories
	 */
	@Override
	public int getProjectHistoriesCount() {
		return _projectHistoryLocalService.getProjectHistoriesCount();
	}

	/**
	 * Returns the project history with the primary key.
	 *
	 * @param projectHistoryId the primary key of the project history
	 * @return the project history
	 * @throws PortalException if a project history with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.ProjectHistory getProjectHistory(
			long projectHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectHistoryLocalService.getProjectHistory(projectHistoryId);
	}

	/**
	 * Returns the project history matching the UUID and group.
	 *
	 * @param uuid the project history's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project history
	 * @throws PortalException if a matching project history could not be found
	 */
	@Override
	public com.ax.hrms.model.ProjectHistory getProjectHistoryByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectHistoryLocalService.getProjectHistoryByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Updates the project history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectHistory the project history
	 * @return the project history that was updated
	 */
	@Override
	public com.ax.hrms.model.ProjectHistory updateProjectHistory(
		com.ax.hrms.model.ProjectHistory projectHistory) {

		return _projectHistoryLocalService.updateProjectHistory(projectHistory);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _projectHistoryLocalService.getBasePersistence();
	}

	@Override
	public ProjectHistoryLocalService getWrappedService() {
		return _projectHistoryLocalService;
	}

	@Override
	public void setWrappedService(
		ProjectHistoryLocalService projectHistoryLocalService) {

		_projectHistoryLocalService = projectHistoryLocalService;
	}

	private ProjectHistoryLocalService _projectHistoryLocalService;

}