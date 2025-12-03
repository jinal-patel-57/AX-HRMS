/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AppraisalMeetingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalMeetingLocalService
 * @generated
 */
public class AppraisalMeetingLocalServiceWrapper
	implements AppraisalMeetingLocalService,
			   ServiceWrapper<AppraisalMeetingLocalService> {

	public AppraisalMeetingLocalServiceWrapper() {
		this(null);
	}

	public AppraisalMeetingLocalServiceWrapper(
		AppraisalMeetingLocalService appraisalMeetingLocalService) {

		_appraisalMeetingLocalService = appraisalMeetingLocalService;
	}

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
	@Override
	public com.ax.hrms.model.AppraisalMeeting addAppraisalMeeting(
		com.ax.hrms.model.AppraisalMeeting appraisalMeeting) {

		return _appraisalMeetingLocalService.addAppraisalMeeting(
			appraisalMeeting);
	}

	/**
	 * Creates a new appraisal meeting with the primary key. Does not add the appraisal meeting to the database.
	 *
	 * @param appraisalMeetingId the primary key for the new appraisal meeting
	 * @return the new appraisal meeting
	 */
	@Override
	public com.ax.hrms.model.AppraisalMeeting createAppraisalMeeting(
		long appraisalMeetingId) {

		return _appraisalMeetingLocalService.createAppraisalMeeting(
			appraisalMeetingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalMeetingLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.ax.hrms.model.AppraisalMeeting deleteAppraisalMeeting(
		com.ax.hrms.model.AppraisalMeeting appraisalMeeting) {

		return _appraisalMeetingLocalService.deleteAppraisalMeeting(
			appraisalMeeting);
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
	@Override
	public com.ax.hrms.model.AppraisalMeeting deleteAppraisalMeeting(
			long appraisalMeetingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalMeetingLocalService.deleteAppraisalMeeting(
			appraisalMeetingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalMeetingLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _appraisalMeetingLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _appraisalMeetingLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appraisalMeetingLocalService.dynamicQuery();
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

		return _appraisalMeetingLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _appraisalMeetingLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _appraisalMeetingLocalService.dynamicQuery(
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

		return _appraisalMeetingLocalService.dynamicQueryCount(dynamicQuery);
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

		return _appraisalMeetingLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.AppraisalMeeting fetchAppraisalMeeting(
		long appraisalMeetingId) {

		return _appraisalMeetingLocalService.fetchAppraisalMeeting(
			appraisalMeetingId);
	}

	/**
	 * Returns the appraisal meeting matching the UUID and group.
	 *
	 * @param uuid the appraisal meeting's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalMeeting
		fetchAppraisalMeetingByUuidAndGroupId(String uuid, long groupId) {

		return _appraisalMeetingLocalService.
			fetchAppraisalMeetingByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.ax.hrms.model.AppraisalMeeting findByAppraisalProcessId(
			long appraisalProcessId)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingException {

		return _appraisalMeetingLocalService.findByAppraisalProcessId(
			appraisalProcessId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _appraisalMeetingLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the appraisal meeting with the primary key.
	 *
	 * @param appraisalMeetingId the primary key of the appraisal meeting
	 * @return the appraisal meeting
	 * @throws PortalException if a appraisal meeting with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalMeeting getAppraisalMeeting(
			long appraisalMeetingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalMeetingLocalService.getAppraisalMeeting(
			appraisalMeetingId);
	}

	/**
	 * Returns the appraisal meeting matching the UUID and group.
	 *
	 * @param uuid the appraisal meeting's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal meeting
	 * @throws PortalException if a matching appraisal meeting could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalMeeting
			getAppraisalMeetingByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalMeetingLocalService.
			getAppraisalMeetingByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.ax.hrms.model.AppraisalMeeting>
		getAppraisalMeetings(int start, int end) {

		return _appraisalMeetingLocalService.getAppraisalMeetings(start, end);
	}

	/**
	 * Returns all the appraisal meetings matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal meetings
	 * @param companyId the primary key of the company
	 * @return the matching appraisal meetings, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.AppraisalMeeting>
		getAppraisalMeetingsByUuidAndCompanyId(String uuid, long companyId) {

		return _appraisalMeetingLocalService.
			getAppraisalMeetingsByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.ax.hrms.model.AppraisalMeeting>
		getAppraisalMeetingsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.AppraisalMeeting> orderByComparator) {

		return _appraisalMeetingLocalService.
			getAppraisalMeetingsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of appraisal meetings.
	 *
	 * @return the number of appraisal meetings
	 */
	@Override
	public int getAppraisalMeetingsCount() {
		return _appraisalMeetingLocalService.getAppraisalMeetingsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _appraisalMeetingLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _appraisalMeetingLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appraisalMeetingLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalMeetingLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.ax.hrms.model.AppraisalMeeting updateAppraisalMeeting(
		com.ax.hrms.model.AppraisalMeeting appraisalMeeting) {

		return _appraisalMeetingLocalService.updateAppraisalMeeting(
			appraisalMeeting);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _appraisalMeetingLocalService.getBasePersistence();
	}

	@Override
	public AppraisalMeetingLocalService getWrappedService() {
		return _appraisalMeetingLocalService;
	}

	@Override
	public void setWrappedService(
		AppraisalMeetingLocalService appraisalMeetingLocalService) {

		_appraisalMeetingLocalService = appraisalMeetingLocalService;
	}

	private AppraisalMeetingLocalService _appraisalMeetingLocalService;

}