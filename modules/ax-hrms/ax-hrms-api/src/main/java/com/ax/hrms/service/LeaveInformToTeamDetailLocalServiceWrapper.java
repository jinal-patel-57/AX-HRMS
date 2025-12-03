/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link LeaveInformToTeamDetailLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveInformToTeamDetailLocalService
 * @generated
 */
public class LeaveInformToTeamDetailLocalServiceWrapper
	implements LeaveInformToTeamDetailLocalService,
			   ServiceWrapper<LeaveInformToTeamDetailLocalService> {

	public LeaveInformToTeamDetailLocalServiceWrapper() {
		this(null);
	}

	public LeaveInformToTeamDetailLocalServiceWrapper(
		LeaveInformToTeamDetailLocalService
			leaveInformToTeamDetailLocalService) {

		_leaveInformToTeamDetailLocalService =
			leaveInformToTeamDetailLocalService;
	}

	/**
	 * Adds the leave inform to team detail to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveInformToTeamDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveInformToTeamDetail the leave inform to team detail
	 * @return the leave inform to team detail that was added
	 */
	@Override
	public com.ax.hrms.model.LeaveInformToTeamDetail addLeaveInformToTeamDetail(
		com.ax.hrms.model.LeaveInformToTeamDetail leaveInformToTeamDetail) {

		return _leaveInformToTeamDetailLocalService.addLeaveInformToTeamDetail(
			leaveInformToTeamDetail);
	}

	/**
	 * Creates a new leave inform to team detail with the primary key. Does not add the leave inform to team detail to the database.
	 *
	 * @param leaveInformId the primary key for the new leave inform to team detail
	 * @return the new leave inform to team detail
	 */
	@Override
	public com.ax.hrms.model.LeaveInformToTeamDetail
		createLeaveInformToTeamDetail(long leaveInformId) {

		return _leaveInformToTeamDetailLocalService.
			createLeaveInformToTeamDetail(leaveInformId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveInformToTeamDetailLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the leave inform to team detail from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveInformToTeamDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveInformToTeamDetail the leave inform to team detail
	 * @return the leave inform to team detail that was removed
	 */
	@Override
	public com.ax.hrms.model.LeaveInformToTeamDetail
		deleteLeaveInformToTeamDetail(
			com.ax.hrms.model.LeaveInformToTeamDetail leaveInformToTeamDetail) {

		return _leaveInformToTeamDetailLocalService.
			deleteLeaveInformToTeamDetail(leaveInformToTeamDetail);
	}

	/**
	 * Deletes the leave inform to team detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveInformToTeamDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveInformId the primary key of the leave inform to team detail
	 * @return the leave inform to team detail that was removed
	 * @throws PortalException if a leave inform to team detail with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.LeaveInformToTeamDetail
			deleteLeaveInformToTeamDetail(long leaveInformId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveInformToTeamDetailLocalService.
			deleteLeaveInformToTeamDetail(leaveInformId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveInformToTeamDetailLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _leaveInformToTeamDetailLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _leaveInformToTeamDetailLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveInformToTeamDetailLocalService.dynamicQuery();
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

		return _leaveInformToTeamDetailLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveInformToTeamDetailModelImpl</code>.
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

		return _leaveInformToTeamDetailLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveInformToTeamDetailModelImpl</code>.
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

		return _leaveInformToTeamDetailLocalService.dynamicQuery(
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

		return _leaveInformToTeamDetailLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _leaveInformToTeamDetailLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.LeaveInformToTeamDetail
		fetchLeaveInformToTeamDetail(long leaveInformId) {

		return _leaveInformToTeamDetailLocalService.
			fetchLeaveInformToTeamDetail(leaveInformId);
	}

	/**
	 * Returns the leave inform to team detail matching the UUID and group.
	 *
	 * @param uuid the leave inform to team detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	@Override
	public com.ax.hrms.model.LeaveInformToTeamDetail
		fetchLeaveInformToTeamDetailByUuidAndGroupId(
			String uuid, long groupId) {

		return _leaveInformToTeamDetailLocalService.
			fetchLeaveInformToTeamDetailByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.LeaveInformToTeamDetail>
			findByLeaveRequestId(long leaveRequestId)
		throws com.ax.hrms.exception.NoSuchLeaveInformToTeamDetailException {

		return _leaveInformToTeamDetailLocalService.findByLeaveRequestId(
			leaveRequestId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _leaveInformToTeamDetailLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _leaveInformToTeamDetailLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _leaveInformToTeamDetailLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the leave inform to team detail with the primary key.
	 *
	 * @param leaveInformId the primary key of the leave inform to team detail
	 * @return the leave inform to team detail
	 * @throws PortalException if a leave inform to team detail with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.LeaveInformToTeamDetail getLeaveInformToTeamDetail(
			long leaveInformId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveInformToTeamDetailLocalService.getLeaveInformToTeamDetail(
			leaveInformId);
	}

	/**
	 * Returns the leave inform to team detail matching the UUID and group.
	 *
	 * @param uuid the leave inform to team detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave inform to team detail
	 * @throws PortalException if a matching leave inform to team detail could not be found
	 */
	@Override
	public com.ax.hrms.model.LeaveInformToTeamDetail
			getLeaveInformToTeamDetailByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveInformToTeamDetailLocalService.
			getLeaveInformToTeamDetailByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the leave inform to team details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @return the range of leave inform to team details
	 */
	@Override
	public java.util.List<com.ax.hrms.model.LeaveInformToTeamDetail>
		getLeaveInformToTeamDetails(int start, int end) {

		return _leaveInformToTeamDetailLocalService.getLeaveInformToTeamDetails(
			start, end);
	}

	/**
	 * Returns all the leave inform to team details matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave inform to team details
	 * @param companyId the primary key of the company
	 * @return the matching leave inform to team details, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.LeaveInformToTeamDetail>
		getLeaveInformToTeamDetailsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _leaveInformToTeamDetailLocalService.
			getLeaveInformToTeamDetailsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of leave inform to team details matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave inform to team details
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching leave inform to team details, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.LeaveInformToTeamDetail>
		getLeaveInformToTeamDetailsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.LeaveInformToTeamDetail> orderByComparator) {

		return _leaveInformToTeamDetailLocalService.
			getLeaveInformToTeamDetailsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of leave inform to team details.
	 *
	 * @return the number of leave inform to team details
	 */
	@Override
	public int getLeaveInformToTeamDetailsCount() {
		return _leaveInformToTeamDetailLocalService.
			getLeaveInformToTeamDetailsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveInformToTeamDetailLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveInformToTeamDetailLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the leave inform to team detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveInformToTeamDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveInformToTeamDetail the leave inform to team detail
	 * @return the leave inform to team detail that was updated
	 */
	@Override
	public com.ax.hrms.model.LeaveInformToTeamDetail
		updateLeaveInformToTeamDetail(
			com.ax.hrms.model.LeaveInformToTeamDetail leaveInformToTeamDetail) {

		return _leaveInformToTeamDetailLocalService.
			updateLeaveInformToTeamDetail(leaveInformToTeamDetail);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _leaveInformToTeamDetailLocalService.getBasePersistence();
	}

	@Override
	public LeaveInformToTeamDetailLocalService getWrappedService() {
		return _leaveInformToTeamDetailLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveInformToTeamDetailLocalService
			leaveInformToTeamDetailLocalService) {

		_leaveInformToTeamDetailLocalService =
			leaveInformToTeamDetailLocalService;
	}

	private LeaveInformToTeamDetailLocalService
		_leaveInformToTeamDetailLocalService;

}