/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.LeaveBalance;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for LeaveBalance. This utility wraps
 * <code>com.ax.hrms.service.impl.LeaveBalanceLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveBalanceLocalService
 * @generated
 */
public class LeaveBalanceLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.LeaveBalanceLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static LeaveBalance addLeaveBalance(LeaveBalance leaveBalance) {
		return getService().addLeaveBalance(leaveBalance);
	}

	/**
	 * Creates a new leave balance with the primary key. Does not add the leave balance to the database.
	 *
	 * @param leaveBalanceId the primary key for the new leave balance
	 * @return the new leave balance
	 */
	public static LeaveBalance createLeaveBalance(long leaveBalanceId) {
		return getService().createLeaveBalance(leaveBalanceId);
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
	 * Deletes the leave balance from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveBalanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveBalance the leave balance
	 * @return the leave balance that was removed
	 */
	public static LeaveBalance deleteLeaveBalance(LeaveBalance leaveBalance) {
		return getService().deleteLeaveBalance(leaveBalance);
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
	public static LeaveBalance deleteLeaveBalance(long leaveBalanceId)
		throws PortalException {

		return getService().deleteLeaveBalance(leaveBalanceId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveBalanceModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveBalanceModelImpl</code>.
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

	public static LeaveBalance fetchLeaveBalance(long leaveBalanceId) {
		return getService().fetchLeaveBalance(leaveBalanceId);
	}

	/**
	 * Returns the leave balance matching the UUID and group.
	 *
	 * @param uuid the leave balance's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave balance, or <code>null</code> if a matching leave balance could not be found
	 */
	public static LeaveBalance fetchLeaveBalanceByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchLeaveBalanceByUuidAndGroupId(uuid, groupId);
	}

	public static List<LeaveBalance> findByEmployeeId(long employeeId) {
		return getService().findByEmployeeId(employeeId);
	}

	public static LeaveBalance findByEmployeeIdAndLeaveTypeMasterId(
			long employeeId, long leaveTypeMasterId)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getService().findByEmployeeIdAndLeaveTypeMasterId(
			employeeId, leaveTypeMasterId);
	}

	public static List<LeaveBalance> findByEmployeeIdAndYear(
		long employeeId, int year) {

		return getService().findByEmployeeIdAndYear(employeeId, year);
	}

	public static LeaveBalance findByEmployeeIdLeaveTypeMasterIdAndYear(
			long employeeId, long leaveTypeMasterId, int year)
		throws com.ax.hrms.exception.NoSuchLeaveBalanceException {

		return getService().findByEmployeeIdLeaveTypeMasterIdAndYear(
			employeeId, leaveTypeMasterId, year);
	}

	public static List<LeaveBalance> findByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int year) {

		return getService().findByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, year);
	}

	public static List<LeaveBalance> findByYear(int year) {
		return getService().findByYear(year);
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
	 * Returns the leave balance with the primary key.
	 *
	 * @param leaveBalanceId the primary key of the leave balance
	 * @return the leave balance
	 * @throws PortalException if a leave balance with the primary key could not be found
	 */
	public static LeaveBalance getLeaveBalance(long leaveBalanceId)
		throws PortalException {

		return getService().getLeaveBalance(leaveBalanceId);
	}

	/**
	 * Returns the leave balance matching the UUID and group.
	 *
	 * @param uuid the leave balance's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave balance
	 * @throws PortalException if a matching leave balance could not be found
	 */
	public static LeaveBalance getLeaveBalanceByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getLeaveBalanceByUuidAndGroupId(uuid, groupId);
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
	public static List<LeaveBalance> getLeaveBalances(int start, int end) {
		return getService().getLeaveBalances(start, end);
	}

	/**
	 * Returns all the leave balances matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave balances
	 * @param companyId the primary key of the company
	 * @return the matching leave balances, or an empty list if no matches were found
	 */
	public static List<LeaveBalance> getLeaveBalancesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getLeaveBalancesByUuidAndCompanyId(uuid, companyId);
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
	public static List<LeaveBalance> getLeaveBalancesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveBalance> orderByComparator) {

		return getService().getLeaveBalancesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of leave balances.
	 *
	 * @return the number of leave balances
	 */
	public static int getLeaveBalancesCount() {
		return getService().getLeaveBalancesCount();
	}

	public static List<Object[]> getLeaveReportByEmployeeId(long empId) {
		return getService().getLeaveReportByEmployeeId(empId);
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
	 * Updates the leave balance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveBalanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveBalance the leave balance
	 * @return the leave balance that was updated
	 */
	public static LeaveBalance updateLeaveBalance(LeaveBalance leaveBalance) {
		return getService().updateLeaveBalance(leaveBalance);
	}

	public static LeaveBalanceLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<LeaveBalanceLocalService> _serviceSnapshot =
		new Snapshot<>(
			LeaveBalanceLocalServiceUtil.class, LeaveBalanceLocalService.class);

}