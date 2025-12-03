/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.AppraisalMeetingInvitees;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AppraisalMeetingInvitees. This utility wraps
 * <code>com.ax.hrms.service.impl.AppraisalMeetingInviteesLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalMeetingInviteesLocalService
 * @generated
 */
public class AppraisalMeetingInviteesLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.AppraisalMeetingInviteesLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the appraisal meeting invitees to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalMeetingInviteesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalMeetingInvitees the appraisal meeting invitees
	 * @return the appraisal meeting invitees that was added
	 */
	public static AppraisalMeetingInvitees addAppraisalMeetingInvitees(
		AppraisalMeetingInvitees appraisalMeetingInvitees) {

		return getService().addAppraisalMeetingInvitees(
			appraisalMeetingInvitees);
	}

	/**
	 * Creates a new appraisal meeting invitees with the primary key. Does not add the appraisal meeting invitees to the database.
	 *
	 * @param appraisalMeetingInviteeId the primary key for the new appraisal meeting invitees
	 * @return the new appraisal meeting invitees
	 */
	public static AppraisalMeetingInvitees createAppraisalMeetingInvitees(
		long appraisalMeetingInviteeId) {

		return getService().createAppraisalMeetingInvitees(
			appraisalMeetingInviteeId);
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
	 * Deletes the appraisal meeting invitees from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalMeetingInviteesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalMeetingInvitees the appraisal meeting invitees
	 * @return the appraisal meeting invitees that was removed
	 */
	public static AppraisalMeetingInvitees deleteAppraisalMeetingInvitees(
		AppraisalMeetingInvitees appraisalMeetingInvitees) {

		return getService().deleteAppraisalMeetingInvitees(
			appraisalMeetingInvitees);
	}

	/**
	 * Deletes the appraisal meeting invitees with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalMeetingInviteesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalMeetingInviteeId the primary key of the appraisal meeting invitees
	 * @return the appraisal meeting invitees that was removed
	 * @throws PortalException if a appraisal meeting invitees with the primary key could not be found
	 */
	public static AppraisalMeetingInvitees deleteAppraisalMeetingInvitees(
			long appraisalMeetingInviteeId)
		throws PortalException {

		return getService().deleteAppraisalMeetingInvitees(
			appraisalMeetingInviteeId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalMeetingInviteesModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalMeetingInviteesModelImpl</code>.
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

	public static AppraisalMeetingInvitees fetchAppraisalMeetingInvitees(
		long appraisalMeetingInviteeId) {

		return getService().fetchAppraisalMeetingInvitees(
			appraisalMeetingInviteeId);
	}

	/**
	 * Returns the appraisal meeting invitees matching the UUID and group.
	 *
	 * @param uuid the appraisal meeting invitees's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	public static AppraisalMeetingInvitees
		fetchAppraisalMeetingInviteesByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchAppraisalMeetingInviteesByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<AppraisalMeetingInvitees> findByAppraisalMeetingId(
		long appraisalMeetingId) {

		return getService().findByAppraisalMeetingId(appraisalMeetingId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the appraisal meeting invitees with the primary key.
	 *
	 * @param appraisalMeetingInviteeId the primary key of the appraisal meeting invitees
	 * @return the appraisal meeting invitees
	 * @throws PortalException if a appraisal meeting invitees with the primary key could not be found
	 */
	public static AppraisalMeetingInvitees getAppraisalMeetingInvitees(
			long appraisalMeetingInviteeId)
		throws PortalException {

		return getService().getAppraisalMeetingInvitees(
			appraisalMeetingInviteeId);
	}

	/**
	 * Returns the appraisal meeting invitees matching the UUID and group.
	 *
	 * @param uuid the appraisal meeting invitees's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal meeting invitees
	 * @throws PortalException if a matching appraisal meeting invitees could not be found
	 */
	public static AppraisalMeetingInvitees
			getAppraisalMeetingInviteesByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().getAppraisalMeetingInviteesByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the appraisal meeting inviteeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @return the range of appraisal meeting inviteeses
	 */
	public static List<AppraisalMeetingInvitees> getAppraisalMeetingInviteeses(
		int start, int end) {

		return getService().getAppraisalMeetingInviteeses(start, end);
	}

	/**
	 * Returns all the appraisal meeting inviteeses matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal meeting inviteeses
	 * @param companyId the primary key of the company
	 * @return the matching appraisal meeting inviteeses, or an empty list if no matches were found
	 */
	public static List<AppraisalMeetingInvitees>
		getAppraisalMeetingInviteesesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getAppraisalMeetingInviteesesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of appraisal meeting inviteeses matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal meeting inviteeses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching appraisal meeting inviteeses, or an empty list if no matches were found
	 */
	public static List<AppraisalMeetingInvitees>
		getAppraisalMeetingInviteesesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<AppraisalMeetingInvitees> orderByComparator) {

		return getService().getAppraisalMeetingInviteesesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of appraisal meeting inviteeses.
	 *
	 * @return the number of appraisal meeting inviteeses
	 */
	public static int getAppraisalMeetingInviteesesCount() {
		return getService().getAppraisalMeetingInviteesesCount();
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
	 * Updates the appraisal meeting invitees in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalMeetingInviteesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalMeetingInvitees the appraisal meeting invitees
	 * @return the appraisal meeting invitees that was updated
	 */
	public static AppraisalMeetingInvitees updateAppraisalMeetingInvitees(
		AppraisalMeetingInvitees appraisalMeetingInvitees) {

		return getService().updateAppraisalMeetingInvitees(
			appraisalMeetingInvitees);
	}

	public static AppraisalMeetingInviteesLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<AppraisalMeetingInviteesLocalService>
		_serviceSnapshot = new Snapshot<>(
			AppraisalMeetingInviteesLocalServiceUtil.class,
			AppraisalMeetingInviteesLocalService.class);

}