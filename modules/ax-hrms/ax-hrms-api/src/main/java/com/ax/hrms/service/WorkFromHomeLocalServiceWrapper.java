/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link WorkFromHomeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHomeLocalService
 * @generated
 */
public class WorkFromHomeLocalServiceWrapper
	implements ServiceWrapper<WorkFromHomeLocalService>,
			   WorkFromHomeLocalService {

	public WorkFromHomeLocalServiceWrapper() {
		this(null);
	}

	public WorkFromHomeLocalServiceWrapper(
		WorkFromHomeLocalService workFromHomeLocalService) {

		_workFromHomeLocalService = workFromHomeLocalService;
	}

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
	@Override
	public com.ax.hrms.model.WorkFromHome addWorkFromHome(
		com.ax.hrms.model.WorkFromHome workFromHome) {

		return _workFromHomeLocalService.addWorkFromHome(workFromHome);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workFromHomeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new work from home with the primary key. Does not add the work from home to the database.
	 *
	 * @param workFromHomeRequestId the primary key for the new work from home
	 * @return the new work from home
	 */
	@Override
	public com.ax.hrms.model.WorkFromHome createWorkFromHome(
		long workFromHomeRequestId) {

		return _workFromHomeLocalService.createWorkFromHome(
			workFromHomeRequestId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workFromHomeLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.ax.hrms.model.WorkFromHome deleteWorkFromHome(
			long workFromHomeRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workFromHomeLocalService.deleteWorkFromHome(
			workFromHomeRequestId);
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
	@Override
	public com.ax.hrms.model.WorkFromHome deleteWorkFromHome(
		com.ax.hrms.model.WorkFromHome workFromHome) {

		return _workFromHomeLocalService.deleteWorkFromHome(workFromHome);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _workFromHomeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _workFromHomeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workFromHomeLocalService.dynamicQuery();
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

		return _workFromHomeLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _workFromHomeLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _workFromHomeLocalService.dynamicQuery(
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

		return _workFromHomeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _workFromHomeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.WorkFromHome fetchWorkFromHome(
		long workFromHomeRequestId) {

		return _workFromHomeLocalService.fetchWorkFromHome(
			workFromHomeRequestId);
	}

	/**
	 * Returns the work from home matching the UUID and group.
	 *
	 * @param uuid the work from home's UUID
	 * @param groupId the primary key of the group
	 * @return the matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	@Override
	public com.ax.hrms.model.WorkFromHome fetchWorkFromHomeByUuidAndGroupId(
		String uuid, long groupId) {

		return _workFromHomeLocalService.fetchWorkFromHomeByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _workFromHomeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _workFromHomeLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _workFromHomeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _workFromHomeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workFromHomeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the work from home with the primary key.
	 *
	 * @param workFromHomeRequestId the primary key of the work from home
	 * @return the work from home
	 * @throws PortalException if a work from home with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.WorkFromHome getWorkFromHome(
			long workFromHomeRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workFromHomeLocalService.getWorkFromHome(workFromHomeRequestId);
	}

	/**
	 * Returns the work from home matching the UUID and group.
	 *
	 * @param uuid the work from home's UUID
	 * @param groupId the primary key of the group
	 * @return the matching work from home
	 * @throws PortalException if a matching work from home could not be found
	 */
	@Override
	public com.ax.hrms.model.WorkFromHome getWorkFromHomeByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workFromHomeLocalService.getWorkFromHomeByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<com.ax.hrms.model.WorkFromHome> getWorkFromHomes(
		int start, int end) {

		return _workFromHomeLocalService.getWorkFromHomes(start, end);
	}

	/**
	 * Returns all the work from homes matching the UUID and company.
	 *
	 * @param uuid the UUID of the work from homes
	 * @param companyId the primary key of the company
	 * @return the matching work from homes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.WorkFromHome>
		getWorkFromHomesByUuidAndCompanyId(String uuid, long companyId) {

		return _workFromHomeLocalService.getWorkFromHomesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.ax.hrms.model.WorkFromHome>
		getWorkFromHomesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.WorkFromHome> orderByComparator) {

		return _workFromHomeLocalService.getWorkFromHomesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of work from homes.
	 *
	 * @return the number of work from homes
	 */
	@Override
	public int getWorkFromHomesCount() {
		return _workFromHomeLocalService.getWorkFromHomesCount();
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
	@Override
	public com.ax.hrms.model.WorkFromHome updateWorkFromHome(
		com.ax.hrms.model.WorkFromHome workFromHome) {

		return _workFromHomeLocalService.updateWorkFromHome(workFromHome);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _workFromHomeLocalService.getBasePersistence();
	}

	@Override
	public WorkFromHomeLocalService getWrappedService() {
		return _workFromHomeLocalService;
	}

	@Override
	public void setWrappedService(
		WorkFromHomeLocalService workFromHomeLocalService) {

		_workFromHomeLocalService = workFromHomeLocalService;
	}

	private WorkFromHomeLocalService _workFromHomeLocalService;

}