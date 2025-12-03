/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.LeaveTypeViewPermit;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for LeaveTypeViewPermit. This utility wraps
 * <code>com.ax.hrms.service.impl.LeaveTypeViewPermitLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTypeViewPermitLocalService
 * @generated
 */
public class LeaveTypeViewPermitLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.LeaveTypeViewPermitLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static LeaveTypeViewPermit addLeaveTypeViewPermit(
		LeaveTypeViewPermit leaveTypeViewPermit) {

		return getService().addLeaveTypeViewPermit(leaveTypeViewPermit);
	}

	/**
	 * Creates a new leave type view permit with the primary key. Does not add the leave type view permit to the database.
	 *
	 * @param leaveTypeViewPermitId the primary key for the new leave type view permit
	 * @return the new leave type view permit
	 */
	public static LeaveTypeViewPermit createLeaveTypeViewPermit(
		long leaveTypeViewPermitId) {

		return getService().createLeaveTypeViewPermit(leaveTypeViewPermitId);
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
	 * Deletes the leave type view permit from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTypeViewPermitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTypeViewPermit the leave type view permit
	 * @return the leave type view permit that was removed
	 */
	public static LeaveTypeViewPermit deleteLeaveTypeViewPermit(
		LeaveTypeViewPermit leaveTypeViewPermit) {

		return getService().deleteLeaveTypeViewPermit(leaveTypeViewPermit);
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
	public static LeaveTypeViewPermit deleteLeaveTypeViewPermit(
			long leaveTypeViewPermitId)
		throws PortalException {

		return getService().deleteLeaveTypeViewPermit(leaveTypeViewPermitId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveTypeViewPermitModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveTypeViewPermitModelImpl</code>.
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

	public static LeaveTypeViewPermit fetchLeaveTypeViewPermit(
		long leaveTypeViewPermitId) {

		return getService().fetchLeaveTypeViewPermit(leaveTypeViewPermitId);
	}

	/**
	 * Returns the leave type view permit matching the UUID and group.
	 *
	 * @param uuid the leave type view permit's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave type view permit, or <code>null</code> if a matching leave type view permit could not be found
	 */
	public static LeaveTypeViewPermit fetchLeaveTypeViewPermitByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchLeaveTypeViewPermitByUuidAndGroupId(
			uuid, groupId);
	}

	public static LeaveTypeViewPermit findByEmployeeIdAndLeaveTypeMasterId(
			long employeeId, long leaveTypeMasterId)
		throws com.ax.hrms.exception.NoSuchLeaveTypeViewPermitException {

		return getService().findByEmployeeIdAndLeaveTypeMasterId(
			employeeId, leaveTypeMasterId);
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
	 * Returns the leave type view permit with the primary key.
	 *
	 * @param leaveTypeViewPermitId the primary key of the leave type view permit
	 * @return the leave type view permit
	 * @throws PortalException if a leave type view permit with the primary key could not be found
	 */
	public static LeaveTypeViewPermit getLeaveTypeViewPermit(
			long leaveTypeViewPermitId)
		throws PortalException {

		return getService().getLeaveTypeViewPermit(leaveTypeViewPermitId);
	}

	/**
	 * Returns the leave type view permit matching the UUID and group.
	 *
	 * @param uuid the leave type view permit's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave type view permit
	 * @throws PortalException if a matching leave type view permit could not be found
	 */
	public static LeaveTypeViewPermit getLeaveTypeViewPermitByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getLeaveTypeViewPermitByUuidAndGroupId(
			uuid, groupId);
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
	public static List<LeaveTypeViewPermit> getLeaveTypeViewPermits(
		int start, int end) {

		return getService().getLeaveTypeViewPermits(start, end);
	}

	/**
	 * Returns all the leave type view permits matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave type view permits
	 * @param companyId the primary key of the company
	 * @return the matching leave type view permits, or an empty list if no matches were found
	 */
	public static List<LeaveTypeViewPermit>
		getLeaveTypeViewPermitsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getLeaveTypeViewPermitsByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<LeaveTypeViewPermit>
		getLeaveTypeViewPermitsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<LeaveTypeViewPermit> orderByComparator) {

		return getService().getLeaveTypeViewPermitsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of leave type view permits.
	 *
	 * @return the number of leave type view permits
	 */
	public static int getLeaveTypeViewPermitsCount() {
		return getService().getLeaveTypeViewPermitsCount();
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
	 * Updates the leave type view permit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTypeViewPermitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTypeViewPermit the leave type view permit
	 * @return the leave type view permit that was updated
	 */
	public static LeaveTypeViewPermit updateLeaveTypeViewPermit(
		LeaveTypeViewPermit leaveTypeViewPermit) {

		return getService().updateLeaveTypeViewPermit(leaveTypeViewPermit);
	}

	public static LeaveTypeViewPermitLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<LeaveTypeViewPermitLocalService>
		_serviceSnapshot = new Snapshot<>(
			LeaveTypeViewPermitLocalServiceUtil.class,
			LeaveTypeViewPermitLocalService.class);

}