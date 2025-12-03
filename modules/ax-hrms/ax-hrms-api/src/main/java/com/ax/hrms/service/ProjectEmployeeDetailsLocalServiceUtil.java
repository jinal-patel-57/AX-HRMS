/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.ProjectEmployeeDetails;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProjectEmployeeDetails. This utility wraps
 * <code>com.ax.hrms.service.impl.ProjectEmployeeDetailsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectEmployeeDetailsLocalService
 * @generated
 */
public class ProjectEmployeeDetailsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.ProjectEmployeeDetailsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static ProjectEmployeeDetails addProjectEmployeeDetails(
		ProjectEmployeeDetails projectEmployeeDetails) {

		return getService().addProjectEmployeeDetails(projectEmployeeDetails);
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
	 * Creates a new project employee details with the primary key. Does not add the project employee details to the database.
	 *
	 * @param projectEmployeeDetailsId the primary key for the new project employee details
	 * @return the new project employee details
	 */
	public static ProjectEmployeeDetails createProjectEmployeeDetails(
		long projectEmployeeDetailsId) {

		return getService().createProjectEmployeeDetails(
			projectEmployeeDetailsId);
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
	public static ProjectEmployeeDetails deleteProjectEmployeeDetails(
			long projectEmployeeDetailsId)
		throws PortalException {

		return getService().deleteProjectEmployeeDetails(
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
	public static ProjectEmployeeDetails deleteProjectEmployeeDetails(
		ProjectEmployeeDetails projectEmployeeDetails) {

		return getService().deleteProjectEmployeeDetails(
			projectEmployeeDetails);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.ProjectEmployeeDetailsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.ProjectEmployeeDetailsModelImpl</code>.
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

	public static ProjectEmployeeDetails fetchProjectEmployeeDetails(
		long projectEmployeeDetailsId) {

		return getService().fetchProjectEmployeeDetails(
			projectEmployeeDetailsId);
	}

	/**
	 * Returns the project employee details matching the UUID and group.
	 *
	 * @param uuid the project employee details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails
		fetchProjectEmployeeDetailsByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchProjectEmployeeDetailsByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<ProjectEmployeeDetails> findByEmployeeId(
		long employeeId) {

		return getService().findByEmployeeId(employeeId);
	}

	public static List<ProjectEmployeeDetails> findByEmployeeId(
		long employeeId, int start, int end) {

		return getService().findByEmployeeId(employeeId, start, end);
	}

	public static List<ProjectEmployeeDetails> findByProjectId(long projectId) {
		return getService().findByProjectId(projectId);
	}

	public static ProjectEmployeeDetails findByProjectIdAndEmployeeId(
			long projectId, long employeeId)
		throws com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException {

		return getService().findByProjectIdAndEmployeeId(projectId, employeeId);
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
	 * Returns the project employee details with the primary key.
	 *
	 * @param projectEmployeeDetailsId the primary key of the project employee details
	 * @return the project employee details
	 * @throws PortalException if a project employee details with the primary key could not be found
	 */
	public static ProjectEmployeeDetails getProjectEmployeeDetails(
			long projectEmployeeDetailsId)
		throws PortalException {

		return getService().getProjectEmployeeDetails(projectEmployeeDetailsId);
	}

	/**
	 * Returns the project employee details matching the UUID and group.
	 *
	 * @param uuid the project employee details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project employee details
	 * @throws PortalException if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails
			getProjectEmployeeDetailsByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getProjectEmployeeDetailsByUuidAndGroupId(
			uuid, groupId);
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
	public static List<ProjectEmployeeDetails> getProjectEmployeeDetailses(
		int start, int end) {

		return getService().getProjectEmployeeDetailses(start, end);
	}

	/**
	 * Returns all the project employee detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the project employee detailses
	 * @param companyId the primary key of the company
	 * @return the matching project employee detailses, or an empty list if no matches were found
	 */
	public static List<ProjectEmployeeDetails>
		getProjectEmployeeDetailsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getProjectEmployeeDetailsesByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<ProjectEmployeeDetails>
		getProjectEmployeeDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		return getService().getProjectEmployeeDetailsesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of project employee detailses.
	 *
	 * @return the number of project employee detailses
	 */
	public static int getProjectEmployeeDetailsesCount() {
		return getService().getProjectEmployeeDetailsesCount();
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
	public static ProjectEmployeeDetails updateProjectEmployeeDetails(
		ProjectEmployeeDetails projectEmployeeDetails) {

		return getService().updateProjectEmployeeDetails(
			projectEmployeeDetails);
	}

	public static ProjectEmployeeDetailsLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<ProjectEmployeeDetailsLocalService>
		_serviceSnapshot = new Snapshot<>(
			ProjectEmployeeDetailsLocalServiceUtil.class,
			ProjectEmployeeDetailsLocalService.class);

}