/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AppraisalReminderLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalReminderLocalService
 * @generated
 */
public class AppraisalReminderLocalServiceWrapper
	implements AppraisalReminderLocalService,
			   ServiceWrapper<AppraisalReminderLocalService> {

	public AppraisalReminderLocalServiceWrapper() {
		this(null);
	}

	public AppraisalReminderLocalServiceWrapper(
		AppraisalReminderLocalService appraisalReminderLocalService) {

		_appraisalReminderLocalService = appraisalReminderLocalService;
	}

	/**
	 * Adds the appraisal reminder to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalReminderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalReminder the appraisal reminder
	 * @return the appraisal reminder that was added
	 */
	@Override
	public com.ax.hrms.model.AppraisalReminder addAppraisalReminder(
		com.ax.hrms.model.AppraisalReminder appraisalReminder) {

		return _appraisalReminderLocalService.addAppraisalReminder(
			appraisalReminder);
	}

	/**
	 * Creates a new appraisal reminder with the primary key. Does not add the appraisal reminder to the database.
	 *
	 * @param appraisalRemainderId the primary key for the new appraisal reminder
	 * @return the new appraisal reminder
	 */
	@Override
	public com.ax.hrms.model.AppraisalReminder createAppraisalReminder(
		long appraisalRemainderId) {

		return _appraisalReminderLocalService.createAppraisalReminder(
			appraisalRemainderId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalReminderLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the appraisal reminder from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalReminderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalReminder the appraisal reminder
	 * @return the appraisal reminder that was removed
	 */
	@Override
	public com.ax.hrms.model.AppraisalReminder deleteAppraisalReminder(
		com.ax.hrms.model.AppraisalReminder appraisalReminder) {

		return _appraisalReminderLocalService.deleteAppraisalReminder(
			appraisalReminder);
	}

	/**
	 * Deletes the appraisal reminder with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalReminderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalRemainderId the primary key of the appraisal reminder
	 * @return the appraisal reminder that was removed
	 * @throws PortalException if a appraisal reminder with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalReminder deleteAppraisalReminder(
			long appraisalRemainderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalReminderLocalService.deleteAppraisalReminder(
			appraisalRemainderId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalReminderLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _appraisalReminderLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _appraisalReminderLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appraisalReminderLocalService.dynamicQuery();
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

		return _appraisalReminderLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalReminderModelImpl</code>.
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

		return _appraisalReminderLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalReminderModelImpl</code>.
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

		return _appraisalReminderLocalService.dynamicQuery(
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

		return _appraisalReminderLocalService.dynamicQueryCount(dynamicQuery);
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

		return _appraisalReminderLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.AppraisalReminder fetchAppraisalReminder(
		long appraisalRemainderId) {

		return _appraisalReminderLocalService.fetchAppraisalReminder(
			appraisalRemainderId);
	}

	/**
	 * Returns the appraisal reminder matching the UUID and group.
	 *
	 * @param uuid the appraisal reminder's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalReminder
		fetchAppraisalReminderByUuidAndGroupId(String uuid, long groupId) {

		return _appraisalReminderLocalService.
			fetchAppraisalReminderByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.ax.hrms.model.AppraisalReminder findByAppraisalProcessId(
			long appraisalProcessId)
		throws com.ax.hrms.exception.NoSuchAppraisalReminderException {

		return _appraisalReminderLocalService.findByAppraisalProcessId(
			appraisalProcessId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _appraisalReminderLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the appraisal reminder with the primary key.
	 *
	 * @param appraisalRemainderId the primary key of the appraisal reminder
	 * @return the appraisal reminder
	 * @throws PortalException if a appraisal reminder with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalReminder getAppraisalReminder(
			long appraisalRemainderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalReminderLocalService.getAppraisalReminder(
			appraisalRemainderId);
	}

	/**
	 * Returns the appraisal reminder matching the UUID and group.
	 *
	 * @param uuid the appraisal reminder's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal reminder
	 * @throws PortalException if a matching appraisal reminder could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalReminder
			getAppraisalReminderByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalReminderLocalService.
			getAppraisalReminderByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the appraisal reminders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalReminderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal reminders
	 * @param end the upper bound of the range of appraisal reminders (not inclusive)
	 * @return the range of appraisal reminders
	 */
	@Override
	public java.util.List<com.ax.hrms.model.AppraisalReminder>
		getAppraisalReminders(int start, int end) {

		return _appraisalReminderLocalService.getAppraisalReminders(start, end);
	}

	/**
	 * Returns all the appraisal reminders matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal reminders
	 * @param companyId the primary key of the company
	 * @return the matching appraisal reminders, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.AppraisalReminder>
		getAppraisalRemindersByUuidAndCompanyId(String uuid, long companyId) {

		return _appraisalReminderLocalService.
			getAppraisalRemindersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of appraisal reminders matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal reminders
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of appraisal reminders
	 * @param end the upper bound of the range of appraisal reminders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching appraisal reminders, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.AppraisalReminder>
		getAppraisalRemindersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.AppraisalReminder> orderByComparator) {

		return _appraisalReminderLocalService.
			getAppraisalRemindersByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of appraisal reminders.
	 *
	 * @return the number of appraisal reminders
	 */
	@Override
	public int getAppraisalRemindersCount() {
		return _appraisalReminderLocalService.getAppraisalRemindersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _appraisalReminderLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _appraisalReminderLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appraisalReminderLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalReminderLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the appraisal reminder in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalReminderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalReminder the appraisal reminder
	 * @return the appraisal reminder that was updated
	 */
	@Override
	public com.ax.hrms.model.AppraisalReminder updateAppraisalReminder(
		com.ax.hrms.model.AppraisalReminder appraisalReminder) {

		return _appraisalReminderLocalService.updateAppraisalReminder(
			appraisalReminder);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _appraisalReminderLocalService.getBasePersistence();
	}

	@Override
	public AppraisalReminderLocalService getWrappedService() {
		return _appraisalReminderLocalService;
	}

	@Override
	public void setWrappedService(
		AppraisalReminderLocalService appraisalReminderLocalService) {

		_appraisalReminderLocalService = appraisalReminderLocalService;
	}

	private AppraisalReminderLocalService _appraisalReminderLocalService;

}