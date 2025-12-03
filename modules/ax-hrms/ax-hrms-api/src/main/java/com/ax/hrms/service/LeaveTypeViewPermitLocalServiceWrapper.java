/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link LeaveTypeViewPermitLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTypeViewPermitLocalService
 * @generated
 */
public class LeaveTypeViewPermitLocalServiceWrapper
	implements LeaveTypeViewPermitLocalService,
			   ServiceWrapper<LeaveTypeViewPermitLocalService> {

	public LeaveTypeViewPermitLocalServiceWrapper() {
		this(null);
	}

	public LeaveTypeViewPermitLocalServiceWrapper(
		LeaveTypeViewPermitLocalService leaveTypeViewPermitLocalService) {

		_leaveTypeViewPermitLocalService = leaveTypeViewPermitLocalService;
	}

	/**
	 * Adds the leave type view permit to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTypeViewPermitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTypeViewPermit the leave type view permit
	 * @return the leave type view permit that was added
	 */
	@Override
	public com.ax.hrms.model.LeaveTypeViewPermit addLeaveTypeViewPermit(
		com.ax.hrms.model.LeaveTypeViewPermit leaveTypeViewPermit) {

		return _leaveTypeViewPermitLocalService.addLeaveTypeViewPermit(
			leaveTypeViewPermit);
	}

	/**
	 * Creates a new leave type view permit with the primary key. Does not add the leave type view permit to the database.
	 *
	 * @param leaveTypeViewPermitId the primary key for the new leave type view permit
	 * @return the new leave type view permit
	 */
	@Override
	public com.ax.hrms.model.LeaveTypeViewPermit createLeaveTypeViewPermit(
		long leaveTypeViewPermitId) {

		return _leaveTypeViewPermitLocalService.createLeaveTypeViewPermit(
			leaveTypeViewPermitId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTypeViewPermitLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the leave type view permit from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTypeViewPermitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTypeViewPermit the leave type view permit
	 * @return the leave type view permit that was removed
	 */
	@Override
	public com.ax.hrms.model.LeaveTypeViewPermit deleteLeaveTypeViewPermit(
		com.ax.hrms.model.LeaveTypeViewPermit leaveTypeViewPermit) {

		return _leaveTypeViewPermitLocalService.deleteLeaveTypeViewPermit(
			leaveTypeViewPermit);
	}

	/**
	 * Deletes the leave type view permit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTypeViewPermitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTypeViewPermitId the primary key of the leave type view permit
	 * @return the leave type view permit that was removed
	 * @throws PortalException if a leave type view permit with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.LeaveTypeViewPermit deleteLeaveTypeViewPermit(
			long leaveTypeViewPermitId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTypeViewPermitLocalService.deleteLeaveTypeViewPermit(
			leaveTypeViewPermitId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTypeViewPermitLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _leaveTypeViewPermitLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _leaveTypeViewPermitLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveTypeViewPermitLocalService.dynamicQuery();
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

		return _leaveTypeViewPermitLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveTypeViewPermitModelImpl</code>.
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

		return _leaveTypeViewPermitLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveTypeViewPermitModelImpl</code>.
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

		return _leaveTypeViewPermitLocalService.dynamicQuery(
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

		return _leaveTypeViewPermitLocalService.dynamicQueryCount(dynamicQuery);
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

		return _leaveTypeViewPermitLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.LeaveTypeViewPermit fetchLeaveTypeViewPermit(
		long leaveTypeViewPermitId) {

		return _leaveTypeViewPermitLocalService.fetchLeaveTypeViewPermit(
			leaveTypeViewPermitId);
	}

	/**
	 * Returns the leave type view permit matching the UUID and group.
	 *
	 * @param uuid the leave type view permit's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave type view permit, or <code>null</code> if a matching leave type view permit could not be found
	 */
	@Override
	public com.ax.hrms.model.LeaveTypeViewPermit
		fetchLeaveTypeViewPermitByUuidAndGroupId(String uuid, long groupId) {

		return _leaveTypeViewPermitLocalService.
			fetchLeaveTypeViewPermitByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.ax.hrms.model.LeaveTypeViewPermit
			findByEmployeeIdAndLeaveTypeMasterId(
				long employeeId, long leaveTypeMasterId)
		throws com.ax.hrms.exception.NoSuchLeaveTypeViewPermitException {

		return _leaveTypeViewPermitLocalService.
			findByEmployeeIdAndLeaveTypeMasterId(employeeId, leaveTypeMasterId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _leaveTypeViewPermitLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _leaveTypeViewPermitLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _leaveTypeViewPermitLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the leave type view permit with the primary key.
	 *
	 * @param leaveTypeViewPermitId the primary key of the leave type view permit
	 * @return the leave type view permit
	 * @throws PortalException if a leave type view permit with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.LeaveTypeViewPermit getLeaveTypeViewPermit(
			long leaveTypeViewPermitId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTypeViewPermitLocalService.getLeaveTypeViewPermit(
			leaveTypeViewPermitId);
	}

	/**
	 * Returns the leave type view permit matching the UUID and group.
	 *
	 * @param uuid the leave type view permit's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave type view permit
	 * @throws PortalException if a matching leave type view permit could not be found
	 */
	@Override
	public com.ax.hrms.model.LeaveTypeViewPermit
			getLeaveTypeViewPermitByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTypeViewPermitLocalService.
			getLeaveTypeViewPermitByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the leave type view permits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveTypeViewPermitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave type view permits
	 * @param end the upper bound of the range of leave type view permits (not inclusive)
	 * @return the range of leave type view permits
	 */
	@Override
	public java.util.List<com.ax.hrms.model.LeaveTypeViewPermit>
		getLeaveTypeViewPermits(int start, int end) {

		return _leaveTypeViewPermitLocalService.getLeaveTypeViewPermits(
			start, end);
	}

	/**
	 * Returns all the leave type view permits matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave type view permits
	 * @param companyId the primary key of the company
	 * @return the matching leave type view permits, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.LeaveTypeViewPermit>
		getLeaveTypeViewPermitsByUuidAndCompanyId(String uuid, long companyId) {

		return _leaveTypeViewPermitLocalService.
			getLeaveTypeViewPermitsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of leave type view permits matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave type view permits
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of leave type view permits
	 * @param end the upper bound of the range of leave type view permits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching leave type view permits, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.LeaveTypeViewPermit>
		getLeaveTypeViewPermitsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.LeaveTypeViewPermit> orderByComparator) {

		return _leaveTypeViewPermitLocalService.
			getLeaveTypeViewPermitsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of leave type view permits.
	 *
	 * @return the number of leave type view permits
	 */
	@Override
	public int getLeaveTypeViewPermitsCount() {
		return _leaveTypeViewPermitLocalService.getLeaveTypeViewPermitsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveTypeViewPermitLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTypeViewPermitLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the leave type view permit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTypeViewPermitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTypeViewPermit the leave type view permit
	 * @return the leave type view permit that was updated
	 */
	@Override
	public com.ax.hrms.model.LeaveTypeViewPermit updateLeaveTypeViewPermit(
		com.ax.hrms.model.LeaveTypeViewPermit leaveTypeViewPermit) {

		return _leaveTypeViewPermitLocalService.updateLeaveTypeViewPermit(
			leaveTypeViewPermit);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _leaveTypeViewPermitLocalService.getBasePersistence();
	}

	@Override
	public LeaveTypeViewPermitLocalService getWrappedService() {
		return _leaveTypeViewPermitLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveTypeViewPermitLocalService leaveTypeViewPermitLocalService) {

		_leaveTypeViewPermitLocalService = leaveTypeViewPermitLocalService;
	}

	private LeaveTypeViewPermitLocalService _leaveTypeViewPermitLocalService;

}