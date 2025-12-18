/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.WorkFromHomeRequest;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for WorkFromHomeRequest. This utility wraps
 * <code>com.ax.hrms.service.impl.WorkFromHomeRequestLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHomeRequestLocalService
 * @generated
 */
public class WorkFromHomeRequestLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.WorkFromHomeRequestLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the work from home request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkFromHomeRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workFromHomeRequest the work from home request
	 * @return the work from home request that was added
	 */
	public static WorkFromHomeRequest addWorkFromHomeRequest(
		WorkFromHomeRequest workFromHomeRequest) {

		return getService().addWorkFromHomeRequest(workFromHomeRequest);
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
	 * Creates a new work from home request with the primary key. Does not add the work from home request to the database.
	 *
	 * @param workFromHomeRequestId the primary key for the new work from home request
	 * @return the new work from home request
	 */
	public static WorkFromHomeRequest createWorkFromHomeRequest(
		long workFromHomeRequestId) {

		return getService().createWorkFromHomeRequest(workFromHomeRequestId);
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
	 * Deletes the work from home request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkFromHomeRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workFromHomeRequestId the primary key of the work from home request
	 * @return the work from home request that was removed
	 * @throws PortalException if a work from home request with the primary key could not be found
	 */
	public static WorkFromHomeRequest deleteWorkFromHomeRequest(
			long workFromHomeRequestId)
		throws PortalException {

		return getService().deleteWorkFromHomeRequest(workFromHomeRequestId);
	}

	/**
	 * Deletes the work from home request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkFromHomeRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workFromHomeRequest the work from home request
	 * @return the work from home request that was removed
	 */
	public static WorkFromHomeRequest deleteWorkFromHomeRequest(
		WorkFromHomeRequest workFromHomeRequest) {

		return getService().deleteWorkFromHomeRequest(workFromHomeRequest);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.WorkFromHomeRequestModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.WorkFromHomeRequestModelImpl</code>.
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

	public static WorkFromHomeRequest fetchWorkFromHomeRequest(
		long workFromHomeRequestId) {

		return getService().fetchWorkFromHomeRequest(workFromHomeRequestId);
	}

	/**
	 * Returns the work from home request matching the UUID and group.
	 *
	 * @param uuid the work from home request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest fetchWorkFromHomeRequestByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchWorkFromHomeRequestByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<WorkFromHomeRequest> findByEmployeeId(
		long employeeId, int start, int end) {

		return getService().findByEmployeeId(employeeId, start, end);
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
	 * Returns the work from home request with the primary key.
	 *
	 * @param workFromHomeRequestId the primary key of the work from home request
	 * @return the work from home request
	 * @throws PortalException if a work from home request with the primary key could not be found
	 */
	public static WorkFromHomeRequest getWorkFromHomeRequest(
			long workFromHomeRequestId)
		throws PortalException {

		return getService().getWorkFromHomeRequest(workFromHomeRequestId);
	}

	/**
	 * Returns the work from home request matching the UUID and group.
	 *
	 * @param uuid the work from home request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching work from home request
	 * @throws PortalException if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest getWorkFromHomeRequestByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getWorkFromHomeRequestByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the work from home requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @return the range of work from home requests
	 */
	public static List<WorkFromHomeRequest> getWorkFromHomeRequests(
		int start, int end) {

		return getService().getWorkFromHomeRequests(start, end);
	}

	/**
	 * Returns all the work from home requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the work from home requests
	 * @param companyId the primary key of the company
	 * @return the matching work from home requests, or an empty list if no matches were found
	 */
	public static List<WorkFromHomeRequest>
		getWorkFromHomeRequestsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getWorkFromHomeRequestsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of work from home requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the work from home requests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching work from home requests, or an empty list if no matches were found
	 */
	public static List<WorkFromHomeRequest>
		getWorkFromHomeRequestsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return getService().getWorkFromHomeRequestsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of work from home requests.
	 *
	 * @return the number of work from home requests
	 */
	public static int getWorkFromHomeRequestsCount() {
		return getService().getWorkFromHomeRequestsCount();
	}

	/**
	 * Updates the work from home request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkFromHomeRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workFromHomeRequest the work from home request
	 * @return the work from home request that was updated
	 */
	public static WorkFromHomeRequest updateWorkFromHomeRequest(
		WorkFromHomeRequest workFromHomeRequest) {

		return getService().updateWorkFromHomeRequest(workFromHomeRequest);
	}

	public static WorkFromHomeRequestLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<WorkFromHomeRequestLocalService>
		_serviceSnapshot = new Snapshot<>(
			WorkFromHomeRequestLocalServiceUtil.class,
			WorkFromHomeRequestLocalService.class);

}