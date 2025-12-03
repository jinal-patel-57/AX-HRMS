/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.LeaveBalanceHistory;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for LeaveBalanceHistory. This utility wraps
 * <code>com.ax.hrms.service.impl.LeaveBalanceHistoryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveBalanceHistoryLocalService
 * @generated
 */
public class LeaveBalanceHistoryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.LeaveBalanceHistoryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static LeaveBalanceHistory addLeaveBalanceHistory(
		LeaveBalanceHistory leaveBalanceHistory) {

		return getService().addLeaveBalanceHistory(leaveBalanceHistory);
	}

	/**
	 * Creates a new leave balance history with the primary key. Does not add the leave balance history to the database.
	 *
	 * @param leaveBalanceHistoryId the primary key for the new leave balance history
	 * @return the new leave balance history
	 */
	public static LeaveBalanceHistory createLeaveBalanceHistory(
		long leaveBalanceHistoryId) {

		return getService().createLeaveBalanceHistory(leaveBalanceHistoryId);
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
	 * Deletes the leave balance history from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveBalanceHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveBalanceHistory the leave balance history
	 * @return the leave balance history that was removed
	 */
	public static LeaveBalanceHistory deleteLeaveBalanceHistory(
		LeaveBalanceHistory leaveBalanceHistory) {

		return getService().deleteLeaveBalanceHistory(leaveBalanceHistory);
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
	public static LeaveBalanceHistory deleteLeaveBalanceHistory(
			long leaveBalanceHistoryId)
		throws PortalException {

		return getService().deleteLeaveBalanceHistory(leaveBalanceHistoryId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveBalanceHistoryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveBalanceHistoryModelImpl</code>.
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

	public static LeaveBalanceHistory fetchLeaveBalanceHistory(
		long leaveBalanceHistoryId) {

		return getService().fetchLeaveBalanceHistory(leaveBalanceHistoryId);
	}

	/**
	 * Returns the leave balance history matching the UUID and group.
	 *
	 * @param uuid the leave balance history's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory fetchLeaveBalanceHistoryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchLeaveBalanceHistoryByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<LeaveBalanceHistory> findByEmployeeId(long employeeId) {
		return getService().findByEmployeeId(employeeId);
	}

	public static List<LeaveBalanceHistory> findByEmployeeIdAndYear(
		long employeeId, int year) {

		return getService().findByEmployeeIdAndYear(employeeId, year);
	}

	public static List<LeaveBalanceHistory> findByYear(int year) {
		return getService().findByYear(year);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<Integer> getAllYear() {
		return getService().getAllYear();
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
	public static List<LeaveBalanceHistory> getLeaveBalanceHistories(
		int start, int end) {

		return getService().getLeaveBalanceHistories(start, end);
	}

	/**
	 * Returns all the leave balance histories matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave balance histories
	 * @param companyId the primary key of the company
	 * @return the matching leave balance histories, or an empty list if no matches were found
	 */
	public static List<LeaveBalanceHistory>
		getLeaveBalanceHistoriesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getLeaveBalanceHistoriesByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<LeaveBalanceHistory>
		getLeaveBalanceHistoriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return getService().getLeaveBalanceHistoriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of leave balance histories.
	 *
	 * @return the number of leave balance histories
	 */
	public static int getLeaveBalanceHistoriesCount() {
		return getService().getLeaveBalanceHistoriesCount();
	}

	/**
	 * Returns the leave balance history with the primary key.
	 *
	 * @param leaveBalanceHistoryId the primary key of the leave balance history
	 * @return the leave balance history
	 * @throws PortalException if a leave balance history with the primary key could not be found
	 */
	public static LeaveBalanceHistory getLeaveBalanceHistory(
			long leaveBalanceHistoryId)
		throws PortalException {

		return getService().getLeaveBalanceHistory(leaveBalanceHistoryId);
	}

	/**
	 * Returns the leave balance history matching the UUID and group.
	 *
	 * @param uuid the leave balance history's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave balance history
	 * @throws PortalException if a matching leave balance history could not be found
	 */
	public static LeaveBalanceHistory getLeaveBalanceHistoryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getLeaveBalanceHistoryByUuidAndGroupId(
			uuid, groupId);
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
	 * Updates the leave balance history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveBalanceHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveBalanceHistory the leave balance history
	 * @return the leave balance history that was updated
	 */
	public static LeaveBalanceHistory updateLeaveBalanceHistory(
		LeaveBalanceHistory leaveBalanceHistory) {

		return getService().updateLeaveBalanceHistory(leaveBalanceHistory);
	}

	public static LeaveBalanceHistoryLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<LeaveBalanceHistoryLocalService>
		_serviceSnapshot = new Snapshot<>(
			LeaveBalanceHistoryLocalServiceUtil.class,
			LeaveBalanceHistoryLocalService.class);

}