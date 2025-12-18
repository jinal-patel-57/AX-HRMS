/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link WorkFromHomeRequestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHomeRequestLocalService
 * @generated
 */
public class WorkFromHomeRequestLocalServiceWrapper
	implements ServiceWrapper<WorkFromHomeRequestLocalService>,
			   WorkFromHomeRequestLocalService {

	public WorkFromHomeRequestLocalServiceWrapper() {
		this(null);
	}

	public WorkFromHomeRequestLocalServiceWrapper(
		WorkFromHomeRequestLocalService workFromHomeRequestLocalService) {

		_workFromHomeRequestLocalService = workFromHomeRequestLocalService;
	}

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
	@Override
	public com.ax.hrms.model.WorkFromHomeRequest addWorkFromHomeRequest(
		com.ax.hrms.model.WorkFromHomeRequest workFromHomeRequest) {

		return _workFromHomeRequestLocalService.addWorkFromHomeRequest(
			workFromHomeRequest);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workFromHomeRequestLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new work from home request with the primary key. Does not add the work from home request to the database.
	 *
	 * @param workFromHomeRequestId the primary key for the new work from home request
	 * @return the new work from home request
	 */
	@Override
	public com.ax.hrms.model.WorkFromHomeRequest createWorkFromHomeRequest(
		long workFromHomeRequestId) {

		return _workFromHomeRequestLocalService.createWorkFromHomeRequest(
			workFromHomeRequestId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workFromHomeRequestLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public com.ax.hrms.model.WorkFromHomeRequest deleteWorkFromHomeRequest(
			long workFromHomeRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workFromHomeRequestLocalService.deleteWorkFromHomeRequest(
			workFromHomeRequestId);
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
	@Override
	public com.ax.hrms.model.WorkFromHomeRequest deleteWorkFromHomeRequest(
		com.ax.hrms.model.WorkFromHomeRequest workFromHomeRequest) {

		return _workFromHomeRequestLocalService.deleteWorkFromHomeRequest(
			workFromHomeRequest);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _workFromHomeRequestLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _workFromHomeRequestLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workFromHomeRequestLocalService.dynamicQuery();
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

		return _workFromHomeRequestLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _workFromHomeRequestLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _workFromHomeRequestLocalService.dynamicQuery(
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

		return _workFromHomeRequestLocalService.dynamicQueryCount(dynamicQuery);
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

		return _workFromHomeRequestLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.WorkFromHomeRequest fetchWorkFromHomeRequest(
		long workFromHomeRequestId) {

		return _workFromHomeRequestLocalService.fetchWorkFromHomeRequest(
			workFromHomeRequestId);
	}

	/**
	 * Returns the work from home request matching the UUID and group.
	 *
	 * @param uuid the work from home request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	@Override
	public com.ax.hrms.model.WorkFromHomeRequest
		fetchWorkFromHomeRequestByUuidAndGroupId(String uuid, long groupId) {

		return _workFromHomeRequestLocalService.
			fetchWorkFromHomeRequestByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.WorkFromHomeRequest>
		findByEmployeeId(long employeeId, int start, int end) {

		return _workFromHomeRequestLocalService.findByEmployeeId(
			employeeId, start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _workFromHomeRequestLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _workFromHomeRequestLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _workFromHomeRequestLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _workFromHomeRequestLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workFromHomeRequestLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the work from home request with the primary key.
	 *
	 * @param workFromHomeRequestId the primary key of the work from home request
	 * @return the work from home request
	 * @throws PortalException if a work from home request with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.WorkFromHomeRequest getWorkFromHomeRequest(
			long workFromHomeRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workFromHomeRequestLocalService.getWorkFromHomeRequest(
			workFromHomeRequestId);
	}

	/**
	 * Returns the work from home request matching the UUID and group.
	 *
	 * @param uuid the work from home request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching work from home request
	 * @throws PortalException if a matching work from home request could not be found
	 */
	@Override
	public com.ax.hrms.model.WorkFromHomeRequest
			getWorkFromHomeRequestByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workFromHomeRequestLocalService.
			getWorkFromHomeRequestByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.ax.hrms.model.WorkFromHomeRequest>
		getWorkFromHomeRequests(int start, int end) {

		return _workFromHomeRequestLocalService.getWorkFromHomeRequests(
			start, end);
	}

	/**
	 * Returns all the work from home requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the work from home requests
	 * @param companyId the primary key of the company
	 * @return the matching work from home requests, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.WorkFromHomeRequest>
		getWorkFromHomeRequestsByUuidAndCompanyId(String uuid, long companyId) {

		return _workFromHomeRequestLocalService.
			getWorkFromHomeRequestsByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.ax.hrms.model.WorkFromHomeRequest>
		getWorkFromHomeRequestsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.WorkFromHomeRequest> orderByComparator) {

		return _workFromHomeRequestLocalService.
			getWorkFromHomeRequestsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of work from home requests.
	 *
	 * @return the number of work from home requests
	 */
	@Override
	public int getWorkFromHomeRequestsCount() {
		return _workFromHomeRequestLocalService.getWorkFromHomeRequestsCount();
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
	@Override
	public com.ax.hrms.model.WorkFromHomeRequest updateWorkFromHomeRequest(
		com.ax.hrms.model.WorkFromHomeRequest workFromHomeRequest) {

		return _workFromHomeRequestLocalService.updateWorkFromHomeRequest(
			workFromHomeRequest);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _workFromHomeRequestLocalService.getBasePersistence();
	}

	@Override
	public WorkFromHomeRequestLocalService getWrappedService() {
		return _workFromHomeRequestLocalService;
	}

	@Override
	public void setWrappedService(
		WorkFromHomeRequestLocalService workFromHomeRequestLocalService) {

		_workFromHomeRequestLocalService = workFromHomeRequestLocalService;
	}

	private WorkFromHomeRequestLocalService _workFromHomeRequestLocalService;

}