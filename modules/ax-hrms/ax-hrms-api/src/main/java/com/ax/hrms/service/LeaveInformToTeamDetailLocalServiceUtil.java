/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.LeaveInformToTeamDetail;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for LeaveInformToTeamDetail. This utility wraps
 * <code>com.ax.hrms.service.impl.LeaveInformToTeamDetailLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveInformToTeamDetailLocalService
 * @generated
 */
public class LeaveInformToTeamDetailLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.LeaveInformToTeamDetailLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static LeaveInformToTeamDetail addLeaveInformToTeamDetail(
		LeaveInformToTeamDetail leaveInformToTeamDetail) {

		return getService().addLeaveInformToTeamDetail(leaveInformToTeamDetail);
	}

	/**
	 * Creates a new leave inform to team detail with the primary key. Does not add the leave inform to team detail to the database.
	 *
	 * @param leaveInformId the primary key for the new leave inform to team detail
	 * @return the new leave inform to team detail
	 */
	public static LeaveInformToTeamDetail createLeaveInformToTeamDetail(
		long leaveInformId) {

		return getService().createLeaveInformToTeamDetail(leaveInformId);
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
	 * Deletes the leave inform to team detail from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveInformToTeamDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveInformToTeamDetail the leave inform to team detail
	 * @return the leave inform to team detail that was removed
	 */
	public static LeaveInformToTeamDetail deleteLeaveInformToTeamDetail(
		LeaveInformToTeamDetail leaveInformToTeamDetail) {

		return getService().deleteLeaveInformToTeamDetail(
			leaveInformToTeamDetail);
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
	public static LeaveInformToTeamDetail deleteLeaveInformToTeamDetail(
			long leaveInformId)
		throws PortalException {

		return getService().deleteLeaveInformToTeamDetail(leaveInformId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveInformToTeamDetailModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveInformToTeamDetailModelImpl</code>.
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

	public static LeaveInformToTeamDetail fetchLeaveInformToTeamDetail(
		long leaveInformId) {

		return getService().fetchLeaveInformToTeamDetail(leaveInformId);
	}

	/**
	 * Returns the leave inform to team detail matching the UUID and group.
	 *
	 * @param uuid the leave inform to team detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	public static LeaveInformToTeamDetail
		fetchLeaveInformToTeamDetailByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchLeaveInformToTeamDetailByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<LeaveInformToTeamDetail> findByLeaveRequestId(
			long leaveRequestId)
		throws com.ax.hrms.exception.NoSuchLeaveInformToTeamDetailException {

		return getService().findByLeaveRequestId(leaveRequestId);
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
	 * Returns the leave inform to team detail with the primary key.
	 *
	 * @param leaveInformId the primary key of the leave inform to team detail
	 * @return the leave inform to team detail
	 * @throws PortalException if a leave inform to team detail with the primary key could not be found
	 */
	public static LeaveInformToTeamDetail getLeaveInformToTeamDetail(
			long leaveInformId)
		throws PortalException {

		return getService().getLeaveInformToTeamDetail(leaveInformId);
	}

	/**
	 * Returns the leave inform to team detail matching the UUID and group.
	 *
	 * @param uuid the leave inform to team detail's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave inform to team detail
	 * @throws PortalException if a matching leave inform to team detail could not be found
	 */
	public static LeaveInformToTeamDetail
			getLeaveInformToTeamDetailByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().getLeaveInformToTeamDetailByUuidAndGroupId(
			uuid, groupId);
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
	public static List<LeaveInformToTeamDetail> getLeaveInformToTeamDetails(
		int start, int end) {

		return getService().getLeaveInformToTeamDetails(start, end);
	}

	/**
	 * Returns all the leave inform to team details matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave inform to team details
	 * @param companyId the primary key of the company
	 * @return the matching leave inform to team details, or an empty list if no matches were found
	 */
	public static List<LeaveInformToTeamDetail>
		getLeaveInformToTeamDetailsByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getLeaveInformToTeamDetailsByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<LeaveInformToTeamDetail>
		getLeaveInformToTeamDetailsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<LeaveInformToTeamDetail> orderByComparator) {

		return getService().getLeaveInformToTeamDetailsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of leave inform to team details.
	 *
	 * @return the number of leave inform to team details
	 */
	public static int getLeaveInformToTeamDetailsCount() {
		return getService().getLeaveInformToTeamDetailsCount();
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
	 * Updates the leave inform to team detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveInformToTeamDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveInformToTeamDetail the leave inform to team detail
	 * @return the leave inform to team detail that was updated
	 */
	public static LeaveInformToTeamDetail updateLeaveInformToTeamDetail(
		LeaveInformToTeamDetail leaveInformToTeamDetail) {

		return getService().updateLeaveInformToTeamDetail(
			leaveInformToTeamDetail);
	}

	public static LeaveInformToTeamDetailLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<LeaveInformToTeamDetailLocalService>
		_serviceSnapshot = new Snapshot<>(
			LeaveInformToTeamDetailLocalServiceUtil.class,
			LeaveInformToTeamDetailLocalService.class);

}