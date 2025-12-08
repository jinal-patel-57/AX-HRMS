/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.WorkFromHome;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for WorkFromHome. This utility wraps
 * <code>com.ax.hrms.service.impl.WorkFromHomeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHomeLocalService
 * @generated
 */
public class WorkFromHomeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.WorkFromHomeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the work from home to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkFromHomeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workFromHome the work from home
	 * @return the work from home that was added
	 */
	public static WorkFromHome addWorkFromHome(WorkFromHome workFromHome) {
		return getService().addWorkFromHome(workFromHome);
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
	 * Creates a new work from home with the primary key. Does not add the work from home to the database.
	 *
	 * @param workFromHomeRequestId the primary key for the new work from home
	 * @return the new work from home
	 */
	public static WorkFromHome createWorkFromHome(long workFromHomeRequestId) {
		return getService().createWorkFromHome(workFromHomeRequestId);
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
	 * Deletes the work from home with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkFromHomeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workFromHomeRequestId the primary key of the work from home
	 * @return the work from home that was removed
	 * @throws PortalException if a work from home with the primary key could not be found
	 */
	public static WorkFromHome deleteWorkFromHome(long workFromHomeRequestId)
		throws PortalException {

		return getService().deleteWorkFromHome(workFromHomeRequestId);
	}

	/**
	 * Deletes the work from home from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkFromHomeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workFromHome the work from home
	 * @return the work from home that was removed
	 */
	public static WorkFromHome deleteWorkFromHome(WorkFromHome workFromHome) {
		return getService().deleteWorkFromHome(workFromHome);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.WorkFromHomeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.WorkFromHomeModelImpl</code>.
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

	public static WorkFromHome fetchWorkFromHome(long workFromHomeRequestId) {
		return getService().fetchWorkFromHome(workFromHomeRequestId);
	}

	/**
	 * Returns the work from home matching the UUID and group.
	 *
	 * @param uuid the work from home's UUID
	 * @param groupId the primary key of the group
	 * @return the matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public static WorkFromHome fetchWorkFromHomeByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchWorkFromHomeByUuidAndGroupId(uuid, groupId);
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
	 * Returns the work from home with the primary key.
	 *
	 * @param workFromHomeRequestId the primary key of the work from home
	 * @return the work from home
	 * @throws PortalException if a work from home with the primary key could not be found
	 */
	public static WorkFromHome getWorkFromHome(long workFromHomeRequestId)
		throws PortalException {

		return getService().getWorkFromHome(workFromHomeRequestId);
	}

	/**
	 * Returns the work from home matching the UUID and group.
	 *
	 * @param uuid the work from home's UUID
	 * @param groupId the primary key of the group
	 * @return the matching work from home
	 * @throws PortalException if a matching work from home could not be found
	 */
	public static WorkFromHome getWorkFromHomeByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getWorkFromHomeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the work from homes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of work from homes
	 */
	public static List<WorkFromHome> getWorkFromHomes(int start, int end) {
		return getService().getWorkFromHomes(start, end);
	}

	/**
	 * Returns all the work from homes matching the UUID and company.
	 *
	 * @param uuid the UUID of the work from homes
	 * @param companyId the primary key of the company
	 * @return the matching work from homes, or an empty list if no matches were found
	 */
	public static List<WorkFromHome> getWorkFromHomesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getWorkFromHomesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of work from homes matching the UUID and company.
	 *
	 * @param uuid the UUID of the work from homes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching work from homes, or an empty list if no matches were found
	 */
	public static List<WorkFromHome> getWorkFromHomesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator) {

		return getService().getWorkFromHomesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of work from homes.
	 *
	 * @return the number of work from homes
	 */
	public static int getWorkFromHomesCount() {
		return getService().getWorkFromHomesCount();
	}

	/**
	 * Updates the work from home in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkFromHomeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workFromHome the work from home
	 * @return the work from home that was updated
	 */
	public static WorkFromHome updateWorkFromHome(WorkFromHome workFromHome) {
		return getService().updateWorkFromHome(workFromHome);
	}

	public static WorkFromHomeLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<WorkFromHomeLocalService> _serviceSnapshot =
		new Snapshot<>(
			WorkFromHomeLocalServiceUtil.class, WorkFromHomeLocalService.class);

}