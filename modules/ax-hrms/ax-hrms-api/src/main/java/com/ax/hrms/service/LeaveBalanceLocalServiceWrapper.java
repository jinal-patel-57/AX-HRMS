/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link LeaveBalanceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveBalanceLocalService
 * @generated
 */
public class LeaveBalanceLocalServiceWrapper
	implements LeaveBalanceLocalService,
			   ServiceWrapper<LeaveBalanceLocalService> {

	public LeaveBalanceLocalServiceWrapper() {
		this(null);
	}

	public LeaveBalanceLocalServiceWrapper(
		LeaveBalanceLocalService leaveBalanceLocalService) {

		_leaveBalanceLocalService = leaveBalanceLocalService;
	}

	/**
	 * Adds the leave balance to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveBalanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveBalance the leave balance
	 * @return the leave balance that was added
	 */
	@Override
	public com.ax.hrms.model.LeaveBalance addLeaveBalance(
		com.ax.hrms.model.LeaveBalance leaveBalance) {

		return _leaveBalanceLocalService.addLeaveBalance(leaveBalance);
	}

	/**
	 * Creates a new leave balance with the primary key. Does not add the leave balance to the database.
	 *
	 * @param leaveBalanceId the primary key for the new leave balance
	 * @return the new leave balance
	 */
	@Override
	public com.ax.hrms.model.LeaveBalance createLeaveBalance(
		long leaveBalanceId) {

		return _leaveBalanceLocalService.createLeaveBalance(leaveBalanceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveBalanceLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the leave balance from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveBalanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveBalance the leave balance
	 * @return the leave balance that was removed
	 */
	@Override
	public com.ax.hrms.model.LeaveBalance deleteLeaveBalance(
		com.ax.hrms.model.LeaveBalance leaveBalance) {

		return _leaveBalanceLocalService.deleteLeaveBalance(leaveBalance);
	}

	/**
	 * Deletes the leave balance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveBalanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveBalanceId the primary key of the leave balance
	 * @return the leave balance that was removed
	 * @throws PortalException if a leave balance with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.LeaveBalance deleteLeaveBalance(
			long leaveBalanceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveBalanceLocalService.deleteLeaveBalance(leaveBalanceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveBalanceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _leaveBalanceLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _leaveBalanceLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveBalanceLocalService.dynamicQuery();
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

		return _leaveBalanceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveBalanceModelImpl</code>.
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

		return _leaveBalanceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveBalanceModelImpl</code>.
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

		return _leaveBalanceLocalService.dynamicQuery(
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

		return _leaveBalanceLocalService.dynamicQueryCount(dynamicQuery);
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

		return _leaveBalanceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.LeaveBalance fetchLeaveBalance(
		long leaveBalanceId) {

		return _leaveBalanceLocalService.fetchLeaveBalance(leaveBalanceId);
	}

	/**
	 * Returns the leave balance matching the UUID and group.
	 *
	 * @param uuid the leave balance's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	@Override
	public com.ax.hrms.model.LeaveBalance fetchLeaveBalanceByUuidAndGroupId(
		String uuid, long groupId) {

		return _leaveBalanceLocalService.fetchLeaveBalanceByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.LeaveBalance> findByEmployeeId(
		long employeeId) {

		return _leaveBalanceLocalService.findByEmployeeId(employeeId);
	}

	@Override
	public com.ax.hrms.model.LeaveBalance findByEmployeeIdAndLeaveTypeMasterId(
			long employeeId, long leaveTypeMasterId)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return _leaveBalanceLocalService.findByEmployeeIdAndLeaveTypeMasterId(
			employeeId, leaveTypeMasterId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.LeaveBalance>
		findByEmployeeIdAndYear(long employeeId, int year) {

		return _leaveBalanceLocalService.findByEmployeeIdAndYear(
			employeeId, year);
	}

	@Override
	public com.ax.hrms.model.LeaveBalance
			findByEmployeeIdLeaveTypeMasterIdAndYear(
				long employeeId, long leaveTypeMasterId, int year)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return _leaveBalanceLocalService.
			findByEmployeeIdLeaveTypeMasterIdAndYear(
				employeeId, leaveTypeMasterId, year);
	}

	@Override
	public java.util.List<com.ax.hrms.model.LeaveBalance>
		findByLeaveTypeMasterIdAndYear(long leaveTypeMasterId, int year) {

		return _leaveBalanceLocalService.findByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, year);
	}

	@Override
	public java.util.List<com.ax.hrms.model.LeaveBalance> findByYear(int year) {
		return _leaveBalanceLocalService.findByYear(year);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _leaveBalanceLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _leaveBalanceLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _leaveBalanceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the leave balance with the primary key.
	 *
	 * @param leaveBalanceId the primary key of the leave balance
	 * @return the leave balance
	 * @throws PortalException if a leave balance with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.LeaveBalance getLeaveBalance(long leaveBalanceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveBalanceLocalService.getLeaveBalance(leaveBalanceId);
	}

	/**
	 * Returns the leave balance matching the UUID and group.
	 *
	 * @param uuid the leave balance's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave balance
	 * @throws PortalException if a matching leave balance could not be found
	 */
	@Override
	public com.ax.hrms.model.LeaveBalance getLeaveBalanceByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveBalanceLocalService.getLeaveBalanceByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the leave balances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveBalanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @return the range of leave balances
	 */
	@Override
	public java.util.List<com.ax.hrms.model.LeaveBalance> getLeaveBalances(
		int start, int end) {

		return _leaveBalanceLocalService.getLeaveBalances(start, end);
	}

	/**
	 * Returns all the leave balances matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave balances
	 * @param companyId the primary key of the company
	 * @return the matching leave balances, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.LeaveBalance>
		getLeaveBalancesByUuidAndCompanyId(String uuid, long companyId) {

		return _leaveBalanceLocalService.getLeaveBalancesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of leave balances matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave balances
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of leave balances
	 * @param end the upper bound of the range of leave balances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching leave balances, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.LeaveBalance>
		getLeaveBalancesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.LeaveBalance> orderByComparator) {

		return _leaveBalanceLocalService.getLeaveBalancesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of leave balances.
	 *
	 * @return the number of leave balances
	 */
	@Override
	public int getLeaveBalancesCount() {
		return _leaveBalanceLocalService.getLeaveBalancesCount();
	}

	@Override
	public java.util.List<Object[]> getLeaveReportByEmployeeId(long empId) {
		return _leaveBalanceLocalService.getLeaveReportByEmployeeId(empId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveBalanceLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveBalanceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the leave balance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveBalanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveBalance the leave balance
	 * @return the leave balance that was updated
	 */
	@Override
	public com.ax.hrms.model.LeaveBalance updateLeaveBalance(
		com.ax.hrms.model.LeaveBalance leaveBalance) {

		return _leaveBalanceLocalService.updateLeaveBalance(leaveBalance);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _leaveBalanceLocalService.getBasePersistence();
	}

	@Override
	public LeaveBalanceLocalService getWrappedService() {
		return _leaveBalanceLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveBalanceLocalService leaveBalanceLocalService) {

		_leaveBalanceLocalService = leaveBalanceLocalService;
	}

	private LeaveBalanceLocalService _leaveBalanceLocalService;

}