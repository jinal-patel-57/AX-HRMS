/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.TimeTracker;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for TimeTracker. This utility wraps
 * <code>com.ax.hrms.service.impl.TimeTrackerLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TimeTrackerLocalService
 * @generated
 */
public class TimeTrackerLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.TimeTrackerLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the time tracker to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TimeTrackerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param timeTracker the time tracker
	 * @return the time tracker that was added
	 */
	public static TimeTracker addTimeTracker(TimeTracker timeTracker) {
		return getService().addTimeTracker(timeTracker);
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
	 * Creates a new time tracker with the primary key. Does not add the time tracker to the database.
	 *
	 * @param timeTrackerId the primary key for the new time tracker
	 * @return the new time tracker
	 */
	public static TimeTracker createTimeTracker(long timeTrackerId) {
		return getService().createTimeTracker(timeTrackerId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the time tracker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TimeTrackerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param timeTrackerId the primary key of the time tracker
	 * @return the time tracker that was removed
	 * @throws PortalException if a time tracker with the primary key could not be found
	 */
	public static TimeTracker deleteTimeTracker(long timeTrackerId)
		throws PortalException {

		return getService().deleteTimeTracker(timeTrackerId);
	}

	/**
	 * Deletes the time tracker from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TimeTrackerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param timeTracker the time tracker
	 * @return the time tracker that was removed
	 */
	public static TimeTracker deleteTimeTracker(TimeTracker timeTracker) {
		return getService().deleteTimeTracker(timeTracker);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.TimeTrackerModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.TimeTrackerModelImpl</code>.
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

	public static TimeTracker fetchTimeTracker(long timeTrackerId) {
		return getService().fetchTimeTracker(timeTrackerId);
	}

	/**
	 * Returns the time tracker matching the UUID and group.
	 *
	 * @param uuid the time tracker's UUID
	 * @param groupId the primary key of the group
	 * @return the matching time tracker, or <code>null</code> if a matching time tracker could not be found
	 */
	public static TimeTracker fetchTimeTrackerByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchTimeTrackerByUuidAndGroupId(uuid, groupId);
	}

	public static List<TimeTracker> findByTaskId(long taskId) {
		return getService().findByTaskId(taskId);
	}

	public static List<TimeTracker> findByTaskIdAndEmployeeId(
		long taskId, long employeeId) {

		return getService().findByTaskIdAndEmployeeId(taskId, employeeId);
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
	 * Returns the time tracker with the primary key.
	 *
	 * @param timeTrackerId the primary key of the time tracker
	 * @return the time tracker
	 * @throws PortalException if a time tracker with the primary key could not be found
	 */
	public static TimeTracker getTimeTracker(long timeTrackerId)
		throws PortalException {

		return getService().getTimeTracker(timeTrackerId);
	}

	/**
	 * Returns the time tracker matching the UUID and group.
	 *
	 * @param uuid the time tracker's UUID
	 * @param groupId the primary key of the group
	 * @return the matching time tracker
	 * @throws PortalException if a matching time tracker could not be found
	 */
	public static TimeTracker getTimeTrackerByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getTimeTrackerByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the time trackers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.TimeTrackerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @return the range of time trackers
	 */
	public static List<TimeTracker> getTimeTrackers(int start, int end) {
		return getService().getTimeTrackers(start, end);
	}

	/**
	 * Returns all the time trackers matching the UUID and company.
	 *
	 * @param uuid the UUID of the time trackers
	 * @param companyId the primary key of the company
	 * @return the matching time trackers, or an empty list if no matches were found
	 */
	public static List<TimeTracker> getTimeTrackersByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getTimeTrackersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of time trackers matching the UUID and company.
	 *
	 * @param uuid the UUID of the time trackers
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of time trackers
	 * @param end the upper bound of the range of time trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching time trackers, or an empty list if no matches were found
	 */
	public static List<TimeTracker> getTimeTrackersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TimeTracker> orderByComparator) {

		return getService().getTimeTrackersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of time trackers.
	 *
	 * @return the number of time trackers
	 */
	public static int getTimeTrackersCount() {
		return getService().getTimeTrackersCount();
	}

	/**
	 * Updates the time tracker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TimeTrackerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param timeTracker the time tracker
	 * @return the time tracker that was updated
	 */
	public static TimeTracker updateTimeTracker(TimeTracker timeTracker) {
		return getService().updateTimeTracker(timeTracker);
	}

	public static TimeTrackerLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<TimeTrackerLocalService> _serviceSnapshot =
		new Snapshot<>(
			TimeTrackerLocalServiceUtil.class, TimeTrackerLocalService.class);

}