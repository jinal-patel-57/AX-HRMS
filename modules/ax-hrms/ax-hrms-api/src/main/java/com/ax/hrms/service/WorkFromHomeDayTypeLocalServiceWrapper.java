/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link WorkFromHomeDayTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHomeDayTypeLocalService
 * @generated
 */
public class WorkFromHomeDayTypeLocalServiceWrapper
	implements ServiceWrapper<WorkFromHomeDayTypeLocalService>,
			   WorkFromHomeDayTypeLocalService {

	public WorkFromHomeDayTypeLocalServiceWrapper() {
		this(null);
	}

	public WorkFromHomeDayTypeLocalServiceWrapper(
		WorkFromHomeDayTypeLocalService workFromHomeDayTypeLocalService) {

		_workFromHomeDayTypeLocalService = workFromHomeDayTypeLocalService;
	}

	/**
	 * Adds the work from home day type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkFromHomeDayTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workFromHomeDayType the work from home day type
	 * @return the work from home day type that was added
	 */
	@Override
	public com.ax.hrms.model.WorkFromHomeDayType addWorkFromHomeDayType(
		com.ax.hrms.model.WorkFromHomeDayType workFromHomeDayType) {

		return _workFromHomeDayTypeLocalService.addWorkFromHomeDayType(
			workFromHomeDayType);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workFromHomeDayTypeLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new work from home day type with the primary key. Does not add the work from home day type to the database.
	 *
	 * @param workFromHomeDayTypeId the primary key for the new work from home day type
	 * @return the new work from home day type
	 */
	@Override
	public com.ax.hrms.model.WorkFromHomeDayType createWorkFromHomeDayType(
		long workFromHomeDayTypeId) {

		return _workFromHomeDayTypeLocalService.createWorkFromHomeDayType(
			workFromHomeDayTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workFromHomeDayTypeLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the work from home day type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkFromHomeDayTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workFromHomeDayTypeId the primary key of the work from home day type
	 * @return the work from home day type that was removed
	 * @throws PortalException if a work from home day type with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.WorkFromHomeDayType deleteWorkFromHomeDayType(
			long workFromHomeDayTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workFromHomeDayTypeLocalService.deleteWorkFromHomeDayType(
			workFromHomeDayTypeId);
	}

	/**
	 * Deletes the work from home day type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkFromHomeDayTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workFromHomeDayType the work from home day type
	 * @return the work from home day type that was removed
	 */
	@Override
	public com.ax.hrms.model.WorkFromHomeDayType deleteWorkFromHomeDayType(
		com.ax.hrms.model.WorkFromHomeDayType workFromHomeDayType) {

		return _workFromHomeDayTypeLocalService.deleteWorkFromHomeDayType(
			workFromHomeDayType);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _workFromHomeDayTypeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _workFromHomeDayTypeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workFromHomeDayTypeLocalService.dynamicQuery();
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

		return _workFromHomeDayTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.WorkFromHomeDayTypeModelImpl</code>.
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

		return _workFromHomeDayTypeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.WorkFromHomeDayTypeModelImpl</code>.
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

		return _workFromHomeDayTypeLocalService.dynamicQuery(
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

		return _workFromHomeDayTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _workFromHomeDayTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.WorkFromHomeDayType fetchWorkFromHomeDayType(
		long workFromHomeDayTypeId) {

		return _workFromHomeDayTypeLocalService.fetchWorkFromHomeDayType(
			workFromHomeDayTypeId);
	}

	/**
	 * Returns the work from home day type matching the UUID and group.
	 *
	 * @param uuid the work from home day type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	@Override
	public com.ax.hrms.model.WorkFromHomeDayType
		fetchWorkFromHomeDayTypeByUuidAndGroupId(String uuid, long groupId) {

		return _workFromHomeDayTypeLocalService.
			fetchWorkFromHomeDayTypeByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.WorkFromHomeDayType>
		findByWorkFromHomeDate(java.util.Date workFromHomeDate) {

		return _workFromHomeDayTypeLocalService.findByWorkFromHomeDate(
			workFromHomeDate);
	}

	@Override
	public java.util.List<com.ax.hrms.model.WorkFromHomeDayType>
		findByWorkFromHomeRequestId(long workFromHomeRequestId) {

		return _workFromHomeDayTypeLocalService.findByWorkFromHomeRequestId(
			workFromHomeRequestId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _workFromHomeDayTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _workFromHomeDayTypeLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _workFromHomeDayTypeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _workFromHomeDayTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workFromHomeDayTypeLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the work from home day type with the primary key.
	 *
	 * @param workFromHomeDayTypeId the primary key of the work from home day type
	 * @return the work from home day type
	 * @throws PortalException if a work from home day type with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.WorkFromHomeDayType getWorkFromHomeDayType(
			long workFromHomeDayTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workFromHomeDayTypeLocalService.getWorkFromHomeDayType(
			workFromHomeDayTypeId);
	}

	/**
	 * Returns the work from home day type matching the UUID and group.
	 *
	 * @param uuid the work from home day type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching work from home day type
	 * @throws PortalException if a matching work from home day type could not be found
	 */
	@Override
	public com.ax.hrms.model.WorkFromHomeDayType
			getWorkFromHomeDayTypeByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workFromHomeDayTypeLocalService.
			getWorkFromHomeDayTypeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the work from home day types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @return the range of work from home day types
	 */
	@Override
	public java.util.List<com.ax.hrms.model.WorkFromHomeDayType>
		getWorkFromHomeDayTypes(int start, int end) {

		return _workFromHomeDayTypeLocalService.getWorkFromHomeDayTypes(
			start, end);
	}

	/**
	 * Returns all the work from home day types matching the UUID and company.
	 *
	 * @param uuid the UUID of the work from home day types
	 * @param companyId the primary key of the company
	 * @return the matching work from home day types, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.WorkFromHomeDayType>
		getWorkFromHomeDayTypesByUuidAndCompanyId(String uuid, long companyId) {

		return _workFromHomeDayTypeLocalService.
			getWorkFromHomeDayTypesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of work from home day types matching the UUID and company.
	 *
	 * @param uuid the UUID of the work from home day types
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching work from home day types, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.WorkFromHomeDayType>
		getWorkFromHomeDayTypesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.WorkFromHomeDayType> orderByComparator) {

		return _workFromHomeDayTypeLocalService.
			getWorkFromHomeDayTypesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of work from home day types.
	 *
	 * @return the number of work from home day types
	 */
	@Override
	public int getWorkFromHomeDayTypesCount() {
		return _workFromHomeDayTypeLocalService.getWorkFromHomeDayTypesCount();
	}

	/**
	 * Updates the work from home day type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkFromHomeDayTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workFromHomeDayType the work from home day type
	 * @return the work from home day type that was updated
	 */
	@Override
	public com.ax.hrms.model.WorkFromHomeDayType updateWorkFromHomeDayType(
		com.ax.hrms.model.WorkFromHomeDayType workFromHomeDayType) {

		return _workFromHomeDayTypeLocalService.updateWorkFromHomeDayType(
			workFromHomeDayType);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _workFromHomeDayTypeLocalService.getBasePersistence();
	}

	@Override
	public WorkFromHomeDayTypeLocalService getWrappedService() {
		return _workFromHomeDayTypeLocalService;
	}

	@Override
	public void setWrappedService(
		WorkFromHomeDayTypeLocalService workFromHomeDayTypeLocalService) {

		_workFromHomeDayTypeLocalService = workFromHomeDayTypeLocalService;
	}

	private WorkFromHomeDayTypeLocalService _workFromHomeDayTypeLocalService;

}