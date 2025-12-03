/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AppraisalMeetingInviteesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalMeetingInviteesLocalService
 * @generated
 */
public class AppraisalMeetingInviteesLocalServiceWrapper
	implements AppraisalMeetingInviteesLocalService,
			   ServiceWrapper<AppraisalMeetingInviteesLocalService> {

	public AppraisalMeetingInviteesLocalServiceWrapper() {
		this(null);
	}

	public AppraisalMeetingInviteesLocalServiceWrapper(
		AppraisalMeetingInviteesLocalService
			appraisalMeetingInviteesLocalService) {

		_appraisalMeetingInviteesLocalService =
			appraisalMeetingInviteesLocalService;
	}

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
	@Override
	public com.ax.hrms.model.AppraisalMeetingInvitees
		addAppraisalMeetingInvitees(
			com.ax.hrms.model.AppraisalMeetingInvitees
				appraisalMeetingInvitees) {

		return _appraisalMeetingInviteesLocalService.
			addAppraisalMeetingInvitees(appraisalMeetingInvitees);
	}

	/**
	 * Creates a new appraisal meeting invitees with the primary key. Does not add the appraisal meeting invitees to the database.
	 *
	 * @param appraisalMeetingInviteeId the primary key for the new appraisal meeting invitees
	 * @return the new appraisal meeting invitees
	 */
	@Override
	public com.ax.hrms.model.AppraisalMeetingInvitees
		createAppraisalMeetingInvitees(long appraisalMeetingInviteeId) {

		return _appraisalMeetingInviteesLocalService.
			createAppraisalMeetingInvitees(appraisalMeetingInviteeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalMeetingInviteesLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.ax.hrms.model.AppraisalMeetingInvitees
		deleteAppraisalMeetingInvitees(
			com.ax.hrms.model.AppraisalMeetingInvitees
				appraisalMeetingInvitees) {

		return _appraisalMeetingInviteesLocalService.
			deleteAppraisalMeetingInvitees(appraisalMeetingInvitees);
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
	@Override
	public com.ax.hrms.model.AppraisalMeetingInvitees
			deleteAppraisalMeetingInvitees(long appraisalMeetingInviteeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalMeetingInviteesLocalService.
			deleteAppraisalMeetingInvitees(appraisalMeetingInviteeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalMeetingInviteesLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _appraisalMeetingInviteesLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _appraisalMeetingInviteesLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appraisalMeetingInviteesLocalService.dynamicQuery();
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

		return _appraisalMeetingInviteesLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _appraisalMeetingInviteesLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _appraisalMeetingInviteesLocalService.dynamicQuery(
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

		return _appraisalMeetingInviteesLocalService.dynamicQueryCount(
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

		return _appraisalMeetingInviteesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.AppraisalMeetingInvitees
		fetchAppraisalMeetingInvitees(long appraisalMeetingInviteeId) {

		return _appraisalMeetingInviteesLocalService.
			fetchAppraisalMeetingInvitees(appraisalMeetingInviteeId);
	}

	/**
	 * Returns the appraisal meeting invitees matching the UUID and group.
	 *
	 * @param uuid the appraisal meeting invitees's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalMeetingInvitees
		fetchAppraisalMeetingInviteesByUuidAndGroupId(
			String uuid, long groupId) {

		return _appraisalMeetingInviteesLocalService.
			fetchAppraisalMeetingInviteesByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.AppraisalMeetingInvitees>
		findByAppraisalMeetingId(long appraisalMeetingId) {

		return _appraisalMeetingInviteesLocalService.findByAppraisalMeetingId(
			appraisalMeetingId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _appraisalMeetingInviteesLocalService.
			getActionableDynamicQuery();
	}

	/**
	 * Returns the appraisal meeting invitees with the primary key.
	 *
	 * @param appraisalMeetingInviteeId the primary key of the appraisal meeting invitees
	 * @return the appraisal meeting invitees
	 * @throws PortalException if a appraisal meeting invitees with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalMeetingInvitees
			getAppraisalMeetingInvitees(long appraisalMeetingInviteeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalMeetingInviteesLocalService.
			getAppraisalMeetingInvitees(appraisalMeetingInviteeId);
	}

	/**
	 * Returns the appraisal meeting invitees matching the UUID and group.
	 *
	 * @param uuid the appraisal meeting invitees's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal meeting invitees
	 * @throws PortalException if a matching appraisal meeting invitees could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalMeetingInvitees
			getAppraisalMeetingInviteesByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalMeetingInviteesLocalService.
			getAppraisalMeetingInviteesByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.ax.hrms.model.AppraisalMeetingInvitees>
		getAppraisalMeetingInviteeses(int start, int end) {

		return _appraisalMeetingInviteesLocalService.
			getAppraisalMeetingInviteeses(start, end);
	}

	/**
	 * Returns all the appraisal meeting inviteeses matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal meeting inviteeses
	 * @param companyId the primary key of the company
	 * @return the matching appraisal meeting inviteeses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.AppraisalMeetingInvitees>
		getAppraisalMeetingInviteesesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _appraisalMeetingInviteesLocalService.
			getAppraisalMeetingInviteesesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.ax.hrms.model.AppraisalMeetingInvitees>
		getAppraisalMeetingInviteesesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.AppraisalMeetingInvitees>
					orderByComparator) {

		return _appraisalMeetingInviteesLocalService.
			getAppraisalMeetingInviteesesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of appraisal meeting inviteeses.
	 *
	 * @return the number of appraisal meeting inviteeses
	 */
	@Override
	public int getAppraisalMeetingInviteesesCount() {
		return _appraisalMeetingInviteesLocalService.
			getAppraisalMeetingInviteesesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _appraisalMeetingInviteesLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _appraisalMeetingInviteesLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appraisalMeetingInviteesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalMeetingInviteesLocalService.getPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.ax.hrms.model.AppraisalMeetingInvitees
		updateAppraisalMeetingInvitees(
			com.ax.hrms.model.AppraisalMeetingInvitees
				appraisalMeetingInvitees) {

		return _appraisalMeetingInviteesLocalService.
			updateAppraisalMeetingInvitees(appraisalMeetingInvitees);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _appraisalMeetingInviteesLocalService.getBasePersistence();
	}

	@Override
	public AppraisalMeetingInviteesLocalService getWrappedService() {
		return _appraisalMeetingInviteesLocalService;
	}

	@Override
	public void setWrappedService(
		AppraisalMeetingInviteesLocalService
			appraisalMeetingInviteesLocalService) {

		_appraisalMeetingInviteesLocalService =
			appraisalMeetingInviteesLocalService;
	}

	private AppraisalMeetingInviteesLocalService
		_appraisalMeetingInviteesLocalService;

}