/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link LeaveDayTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveDayTypeLocalService
 * @generated
 */
public class LeaveDayTypeLocalServiceWrapper
	implements LeaveDayTypeLocalService,
			   ServiceWrapper<LeaveDayTypeLocalService> {

	public LeaveDayTypeLocalServiceWrapper() {
		this(null);
	}

	public LeaveDayTypeLocalServiceWrapper(
		LeaveDayTypeLocalService leaveDayTypeLocalService) {

		_leaveDayTypeLocalService = leaveDayTypeLocalService;
	}

	/**
	 * Adds the leave day type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveDayTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveDayType the leave day type
	 * @return the leave day type that was added
	 */
	@Override
	public com.ax.hrms.model.LeaveDayType addLeaveDayType(
		com.ax.hrms.model.LeaveDayType leaveDayType) {

		return _leaveDayTypeLocalService.addLeaveDayType(leaveDayType);
	}

	/**
	 * Creates a new leave day type with the primary key. Does not add the leave day type to the database.
	 *
	 * @param leaveDayTypeId the primary key for the new leave day type
	 * @return the new leave day type
	 */
	@Override
	public com.ax.hrms.model.LeaveDayType createLeaveDayType(
		long leaveDayTypeId) {

		return _leaveDayTypeLocalService.createLeaveDayType(leaveDayTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveDayTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the leave day type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveDayTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveDayType the leave day type
	 * @return the leave day type that was removed
	 */
	@Override
	public com.ax.hrms.model.LeaveDayType deleteLeaveDayType(
		com.ax.hrms.model.LeaveDayType leaveDayType) {

		return _leaveDayTypeLocalService.deleteLeaveDayType(leaveDayType);
	}

	/**
	 * Deletes the leave day type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveDayTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveDayTypeId the primary key of the leave day type
	 * @return the leave day type that was removed
	 * @throws PortalException if a leave day type with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.LeaveDayType deleteLeaveDayType(
			long leaveDayTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveDayTypeLocalService.deleteLeaveDayType(leaveDayTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveDayTypeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _leaveDayTypeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _leaveDayTypeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveDayTypeLocalService.dynamicQuery();
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

		return _leaveDayTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveDayTypeModelImpl</code>.
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

		return _leaveDayTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveDayTypeModelImpl</code>.
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

		return _leaveDayTypeLocalService.dynamicQuery(
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

		return _leaveDayTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _leaveDayTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.LeaveDayType fetchLeaveDayType(
		long leaveDayTypeId) {

		return _leaveDayTypeLocalService.fetchLeaveDayType(leaveDayTypeId);
	}

	/**
	 * Returns the leave day type matching the UUID and group.
	 *
	 * @param uuid the leave day type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	@Override
	public com.ax.hrms.model.LeaveDayType fetchLeaveDayTypeByUuidAndGroupId(
		String uuid, long groupId) {

		return _leaveDayTypeLocalService.fetchLeaveDayTypeByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.LeaveDayType> findByLeaveRequestId(
		long leaveRequestId) {

		return _leaveDayTypeLocalService.findByLeaveRequestId(leaveRequestId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _leaveDayTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _leaveDayTypeLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _leaveDayTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the leave day type with the primary key.
	 *
	 * @param leaveDayTypeId the primary key of the leave day type
	 * @return the leave day type
	 * @throws PortalException if a leave day type with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.LeaveDayType getLeaveDayType(long leaveDayTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveDayTypeLocalService.getLeaveDayType(leaveDayTypeId);
	}

	/**
	 * Returns the leave day type matching the UUID and group.
	 *
	 * @param uuid the leave day type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave day type
	 * @throws PortalException if a matching leave day type could not be found
	 */
	@Override
	public com.ax.hrms.model.LeaveDayType getLeaveDayTypeByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveDayTypeLocalService.getLeaveDayTypeByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the leave day types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @return the range of leave day types
	 */
	@Override
	public java.util.List<com.ax.hrms.model.LeaveDayType> getLeaveDayTypes(
		int start, int end) {

		return _leaveDayTypeLocalService.getLeaveDayTypes(start, end);
	}

	/**
	 * Returns all the leave day types matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave day types
	 * @param companyId the primary key of the company
	 * @return the matching leave day types, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.LeaveDayType>
		getLeaveDayTypesByUuidAndCompanyId(String uuid, long companyId) {

		return _leaveDayTypeLocalService.getLeaveDayTypesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of leave day types matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave day types
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching leave day types, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.LeaveDayType>
		getLeaveDayTypesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.LeaveDayType> orderByComparator) {

		return _leaveDayTypeLocalService.getLeaveDayTypesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of leave day types.
	 *
	 * @return the number of leave day types
	 */
	@Override
	public int getLeaveDayTypesCount() {
		return _leaveDayTypeLocalService.getLeaveDayTypesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveDayTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveDayTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the leave day type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveDayTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveDayType the leave day type
	 * @return the leave day type that was updated
	 */
	@Override
	public com.ax.hrms.model.LeaveDayType updateLeaveDayType(
		com.ax.hrms.model.LeaveDayType leaveDayType) {

		return _leaveDayTypeLocalService.updateLeaveDayType(leaveDayType);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _leaveDayTypeLocalService.getBasePersistence();
	}

	@Override
	public LeaveDayTypeLocalService getWrappedService() {
		return _leaveDayTypeLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveDayTypeLocalService leaveDayTypeLocalService) {

		_leaveDayTypeLocalService = leaveDayTypeLocalService;
	}

	private LeaveDayTypeLocalService _leaveDayTypeLocalService;

}