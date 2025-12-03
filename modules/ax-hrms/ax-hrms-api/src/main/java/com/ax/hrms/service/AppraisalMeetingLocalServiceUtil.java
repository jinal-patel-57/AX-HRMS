/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.AppraisalMeeting;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AppraisalMeeting. This utility wraps
 * <code>com.ax.hrms.service.impl.AppraisalMeetingLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalMeetingLocalService
 * @generated
 */
public class AppraisalMeetingLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.AppraisalMeetingLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the appraisal meeting to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalMeetingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalMeeting the appraisal meeting
	 * @return the appraisal meeting that was added
	 */
	public static AppraisalMeeting addAppraisalMeeting(
		AppraisalMeeting appraisalMeeting) {

		return getService().addAppraisalMeeting(appraisalMeeting);
	}

	/**
	 * Creates a new appraisal meeting with the primary key. Does not add the appraisal meeting to the database.
	 *
	 * @param appraisalMeetingId the primary key for the new appraisal meeting
	 * @return the new appraisal meeting
	 */
	public static AppraisalMeeting createAppraisalMeeting(
		long appraisalMeetingId) {

		return getService().createAppraisalMeeting(appraisalMeetingId);
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
	 * Deletes the appraisal meeting from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalMeetingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalMeeting the appraisal meeting
	 * @return the appraisal meeting that was removed
	 */
	public static AppraisalMeeting deleteAppraisalMeeting(
		AppraisalMeeting appraisalMeeting) {

		return getService().deleteAppraisalMeeting(appraisalMeeting);
	}

	/**
	 * Deletes the appraisal meeting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalMeetingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalMeetingId the primary key of the appraisal meeting
	 * @return the appraisal meeting that was removed
	 * @throws PortalException if a appraisal meeting with the primary key could not be found
	 */
	public static AppraisalMeeting deleteAppraisalMeeting(
			long appraisalMeetingId)
		throws PortalException {

		return getService().deleteAppraisalMeeting(appraisalMeetingId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalMeetingModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalMeetingModelImpl</code>.
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

	public static AppraisalMeeting fetchAppraisalMeeting(
		long appraisalMeetingId) {

		return getService().fetchAppraisalMeeting(appraisalMeetingId);
	}

	/**
	 * Returns the appraisal meeting matching the UUID and group.
	 *
	 * @param uuid the appraisal meeting's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	public static AppraisalMeeting fetchAppraisalMeetingByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchAppraisalMeetingByUuidAndGroupId(
			uuid, groupId);
	}

	public static AppraisalMeeting findByAppraisalProcessId(
			long appraisalProcessId)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingException {

		return getService().findByAppraisalProcessId(appraisalProcessId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the appraisal meeting with the primary key.
	 *
	 * @param appraisalMeetingId the primary key of the appraisal meeting
	 * @return the appraisal meeting
	 * @throws PortalException if a appraisal meeting with the primary key could not be found
	 */
	public static AppraisalMeeting getAppraisalMeeting(long appraisalMeetingId)
		throws PortalException {

		return getService().getAppraisalMeeting(appraisalMeetingId);
	}

	/**
	 * Returns the appraisal meeting matching the UUID and group.
	 *
	 * @param uuid the appraisal meeting's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal meeting
	 * @throws PortalException if a matching appraisal meeting could not be found
	 */
	public static AppraisalMeeting getAppraisalMeetingByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getAppraisalMeetingByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the appraisal meetings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal meetings
	 * @param end the upper bound of the range of appraisal meetings (not inclusive)
	 * @return the range of appraisal meetings
	 */
	public static List<AppraisalMeeting> getAppraisalMeetings(
		int start, int end) {

		return getService().getAppraisalMeetings(start, end);
	}

	/**
	 * Returns all the appraisal meetings matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal meetings
	 * @param companyId the primary key of the company
	 * @return the matching appraisal meetings, or an empty list if no matches were found
	 */
	public static List<AppraisalMeeting> getAppraisalMeetingsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getAppraisalMeetingsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of appraisal meetings matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal meetings
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of appraisal meetings
	 * @param end the upper bound of the range of appraisal meetings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching appraisal meetings, or an empty list if no matches were found
	 */
	public static List<AppraisalMeeting> getAppraisalMeetingsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalMeeting> orderByComparator) {

		return getService().getAppraisalMeetingsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of appraisal meetings.
	 *
	 * @return the number of appraisal meetings
	 */
	public static int getAppraisalMeetingsCount() {
		return getService().getAppraisalMeetingsCount();
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
	 * Updates the appraisal meeting in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalMeetingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalMeeting the appraisal meeting
	 * @return the appraisal meeting that was updated
	 */
	public static AppraisalMeeting updateAppraisalMeeting(
		AppraisalMeeting appraisalMeeting) {

		return getService().updateAppraisalMeeting(appraisalMeeting);
	}

	public static AppraisalMeetingLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<AppraisalMeetingLocalService>
		_serviceSnapshot = new Snapshot<>(
			AppraisalMeetingLocalServiceUtil.class,
			AppraisalMeetingLocalService.class);

}