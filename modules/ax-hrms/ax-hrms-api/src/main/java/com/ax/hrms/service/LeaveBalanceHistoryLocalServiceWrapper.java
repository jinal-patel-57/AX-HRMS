/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link LeaveBalanceHistoryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveBalanceHistoryLocalService
 * @generated
 */
public class LeaveBalanceHistoryLocalServiceWrapper
	implements LeaveBalanceHistoryLocalService,
			   ServiceWrapper<LeaveBalanceHistoryLocalService> {

	public LeaveBalanceHistoryLocalServiceWrapper() {
		this(null);
	}

	public LeaveBalanceHistoryLocalServiceWrapper(
		LeaveBalanceHistoryLocalService leaveBalanceHistoryLocalService) {

		_leaveBalanceHistoryLocalService = leaveBalanceHistoryLocalService;
	}

	/**
	 * Adds the leave balance history to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveBalanceHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveBalanceHistory the leave balance history
	 * @return the leave balance history that was added
	 */
	@Override
	public com.ax.hrms.model.LeaveBalanceHistory addLeaveBalanceHistory(
		com.ax.hrms.model.LeaveBalanceHistory leaveBalanceHistory) {

		return _leaveBalanceHistoryLocalService.addLeaveBalanceHistory(
			leaveBalanceHistory);
	}

	/**
	 * Creates a new leave balance history with the primary key. Does not add the leave balance history to the database.
	 *
	 * @param leaveBalanceHistoryId the primary key for the new leave balance history
	 * @return the new leave balance history
	 */
	@Override
	public com.ax.hrms.model.LeaveBalanceHistory createLeaveBalanceHistory(
		long leaveBalanceHistoryId) {

		return _leaveBalanceHistoryLocalService.createLeaveBalanceHistory(
			leaveBalanceHistoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveBalanceHistoryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the leave balance history from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveBalanceHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveBalanceHistory the leave balance history
	 * @return the leave balance history that was removed
	 */
	@Override
	public com.ax.hrms.model.LeaveBalanceHistory deleteLeaveBalanceHistory(
		com.ax.hrms.model.LeaveBalanceHistory leaveBalanceHistory) {

		return _leaveBalanceHistoryLocalService.deleteLeaveBalanceHistory(
			leaveBalanceHistory);
	}

	/**
	 * Deletes the leave balance history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveBalanceHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveBalanceHistoryId the primary key of the leave balance history
	 * @return the leave balance history that was removed
	 * @throws PortalException if a leave balance history with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.LeaveBalanceHistory deleteLeaveBalanceHistory(
			long leaveBalanceHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveBalanceHistoryLocalService.deleteLeaveBalanceHistory(
			leaveBalanceHistoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveBalanceHistoryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _leaveBalanceHistoryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _leaveBalanceHistoryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveBalanceHistoryLocalService.dynamicQuery();
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

		return _leaveBalanceHistoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveBalanceHistoryModelImpl</code>.
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

		return _leaveBalanceHistoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveBalanceHistoryModelImpl</code>.
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

		return _leaveBalanceHistoryLocalService.dynamicQuery(
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

		return _leaveBalanceHistoryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _leaveBalanceHistoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.LeaveBalanceHistory fetchLeaveBalanceHistory(
		long leaveBalanceHistoryId) {

		return _leaveBalanceHistoryLocalService.fetchLeaveBalanceHistory(
			leaveBalanceHistoryId);
	}

	/**
	 * Returns the leave balance history matching the UUID and group.
	 *
	 * @param uuid the leave balance history's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	@Override
	public com.ax.hrms.model.LeaveBalanceHistory
		fetchLeaveBalanceHistoryByUuidAndGroupId(String uuid, long groupId) {

		return _leaveBalanceHistoryLocalService.
			fetchLeaveBalanceHistoryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.LeaveBalanceHistory>
		findByEmployeeId(long employeeId) {

		return _leaveBalanceHistoryLocalService.findByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.LeaveBalanceHistory>
		findByEmployeeIdAndYear(long employeeId, int year) {

		return _leaveBalanceHistoryLocalService.findByEmployeeIdAndYear(
			employeeId, year);
	}

	@Override
	public java.util.List<com.ax.hrms.model.LeaveBalanceHistory> findByYear(
		int year) {

		return _leaveBalanceHistoryLocalService.findByYear(year);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _leaveBalanceHistoryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<Integer> getAllYear() {
		return _leaveBalanceHistoryLocalService.getAllYear();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _leaveBalanceHistoryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _leaveBalanceHistoryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the leave balance histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @return the range of leave balance histories
	 */
	@Override
	public java.util.List<com.ax.hrms.model.LeaveBalanceHistory>
		getLeaveBalanceHistories(int start, int end) {

		return _leaveBalanceHistoryLocalService.getLeaveBalanceHistories(
			start, end);
	}

	/**
	 * Returns all the leave balance histories matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave balance histories
	 * @param companyId the primary key of the company
	 * @return the matching leave balance histories, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.LeaveBalanceHistory>
		getLeaveBalanceHistoriesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _leaveBalanceHistoryLocalService.
			getLeaveBalanceHistoriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of leave balance histories matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave balance histories
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching leave balance histories, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.LeaveBalanceHistory>
		getLeaveBalanceHistoriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.LeaveBalanceHistory> orderByComparator) {

		return _leaveBalanceHistoryLocalService.
			getLeaveBalanceHistoriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of leave balance histories.
	 *
	 * @return the number of leave balance histories
	 */
	@Override
	public int getLeaveBalanceHistoriesCount() {
		return _leaveBalanceHistoryLocalService.getLeaveBalanceHistoriesCount();
	}

	/**
	 * Returns the leave balance history with the primary key.
	 *
	 * @param leaveBalanceHistoryId the primary key of the leave balance history
	 * @return the leave balance history
	 * @throws PortalException if a leave balance history with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.LeaveBalanceHistory getLeaveBalanceHistory(
			long leaveBalanceHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveBalanceHistoryLocalService.getLeaveBalanceHistory(
			leaveBalanceHistoryId);
	}

	/**
	 * Returns the leave balance history matching the UUID and group.
	 *
	 * @param uuid the leave balance history's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave balance history
	 * @throws PortalException if a matching leave balance history could not be found
	 */
	@Override
	public com.ax.hrms.model.LeaveBalanceHistory
			getLeaveBalanceHistoryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveBalanceHistoryLocalService.
			getLeaveBalanceHistoryByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveBalanceHistoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveBalanceHistoryLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the leave balance history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveBalanceHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveBalanceHistory the leave balance history
	 * @return the leave balance history that was updated
	 */
	@Override
	public com.ax.hrms.model.LeaveBalanceHistory updateLeaveBalanceHistory(
		com.ax.hrms.model.LeaveBalanceHistory leaveBalanceHistory) {

		return _leaveBalanceHistoryLocalService.updateLeaveBalanceHistory(
			leaveBalanceHistory);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _leaveBalanceHistoryLocalService.getBasePersistence();
	}

	@Override
	public LeaveBalanceHistoryLocalService getWrappedService() {
		return _leaveBalanceHistoryLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveBalanceHistoryLocalService leaveBalanceHistoryLocalService) {

		_leaveBalanceHistoryLocalService = leaveBalanceHistoryLocalService;
	}

	private LeaveBalanceHistoryLocalService _leaveBalanceHistoryLocalService;

}