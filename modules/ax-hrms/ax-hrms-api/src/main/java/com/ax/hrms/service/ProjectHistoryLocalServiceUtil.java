/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.ProjectHistory;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProjectHistory. This utility wraps
 * <code>com.ax.hrms.service.impl.ProjectHistoryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectHistoryLocalService
 * @generated
 */
public class ProjectHistoryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.ProjectHistoryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static ProjectHistory addProjectHistory(
		ProjectHistory projectHistory) {

		return getService().addProjectHistory(projectHistory);
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
	 * Creates a new project history with the primary key. Does not add the project history to the database.
	 *
	 * @param projectHistoryId the primary key for the new project history
	 * @return the new project history
	 */
	public static ProjectHistory createProjectHistory(long projectHistoryId) {
		return getService().createProjectHistory(projectHistoryId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static ProjectHistory deleteProjectHistory(long projectHistoryId)
		throws PortalException {

		return getService().deleteProjectHistory(projectHistoryId);
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
	public static ProjectHistory deleteProjectHistory(
		ProjectHistory projectHistory) {

		return getService().deleteProjectHistory(projectHistory);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.ProjectHistoryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.ProjectHistoryModelImpl</code>.
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

	public static ProjectHistory fetchProjectHistory(long projectHistoryId) {
		return getService().fetchProjectHistory(projectHistoryId);
	}

	/**
	 * Returns the project history matching the UUID and group.
	 *
	 * @param uuid the project history's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project history, or <code>null</code> if a matching project history could not be found
	 */
	public static ProjectHistory fetchProjectHistoryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchProjectHistoryByUuidAndGroupId(uuid, groupId);
	}

	public static List<ProjectHistory> findByManagerId(long managerId) {
		return getService().findByManagerId(managerId);
	}

	public static ProjectHistory findByProjectId(long projectId)
		throws com.ax.hrms.exception.NoSuchProjectHistoryException {

		return getService().findByProjectId(projectId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	public static List<ProjectHistory> getProjectHistories(int start, int end) {
		return getService().getProjectHistories(start, end);
	}

	/**
	 * Returns all the project histories matching the UUID and company.
	 *
	 * @param uuid the UUID of the project histories
	 * @param companyId the primary key of the company
	 * @return the matching project histories, or an empty list if no matches were found
	 */
	public static List<ProjectHistory> getProjectHistoriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getProjectHistoriesByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<ProjectHistory> getProjectHistoriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProjectHistory> orderByComparator) {

		return getService().getProjectHistoriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of project histories.
	 *
	 * @return the number of project histories
	 */
	public static int getProjectHistoriesCount() {
		return getService().getProjectHistoriesCount();
	}

	/**
	 * Returns the project history with the primary key.
	 *
	 * @param projectHistoryId the primary key of the project history
	 * @return the project history
	 * @throws PortalException if a project history with the primary key could not be found
	 */
	public static ProjectHistory getProjectHistory(long projectHistoryId)
		throws PortalException {

		return getService().getProjectHistory(projectHistoryId);
	}

	/**
	 * Returns the project history matching the UUID and group.
	 *
	 * @param uuid the project history's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project history
	 * @throws PortalException if a matching project history could not be found
	 */
	public static ProjectHistory getProjectHistoryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getProjectHistoryByUuidAndGroupId(uuid, groupId);
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
	public static ProjectHistory updateProjectHistory(
		ProjectHistory projectHistory) {

		return getService().updateProjectHistory(projectHistory);
	}

	public static ProjectHistoryLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<ProjectHistoryLocalService> _serviceSnapshot =
		new Snapshot<>(
			ProjectHistoryLocalServiceUtil.class,
			ProjectHistoryLocalService.class);

}