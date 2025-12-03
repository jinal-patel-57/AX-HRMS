/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.AppraisalReminder;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AppraisalReminder. This utility wraps
 * <code>com.ax.hrms.service.impl.AppraisalReminderLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalReminderLocalService
 * @generated
 */
public class AppraisalReminderLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.AppraisalReminderLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static AppraisalReminder addAppraisalReminder(
		AppraisalReminder appraisalReminder) {

		return getService().addAppraisalReminder(appraisalReminder);
	}

	/**
	 * Creates a new appraisal reminder with the primary key. Does not add the appraisal reminder to the database.
	 *
	 * @param appraisalRemainderId the primary key for the new appraisal reminder
	 * @return the new appraisal reminder
	 */
	public static AppraisalReminder createAppraisalReminder(
		long appraisalRemainderId) {

		return getService().createAppraisalReminder(appraisalRemainderId);
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
	 * Deletes the appraisal reminder from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalReminderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalReminder the appraisal reminder
	 * @return the appraisal reminder that was removed
	 */
	public static AppraisalReminder deleteAppraisalReminder(
		AppraisalReminder appraisalReminder) {

		return getService().deleteAppraisalReminder(appraisalReminder);
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
	public static AppraisalReminder deleteAppraisalReminder(
			long appraisalRemainderId)
		throws PortalException {

		return getService().deleteAppraisalReminder(appraisalRemainderId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalReminderModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalReminderModelImpl</code>.
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

	public static AppraisalReminder fetchAppraisalReminder(
		long appraisalRemainderId) {

		return getService().fetchAppraisalReminder(appraisalRemainderId);
	}

	/**
	 * Returns the appraisal reminder matching the UUID and group.
	 *
	 * @param uuid the appraisal reminder's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	public static AppraisalReminder fetchAppraisalReminderByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchAppraisalReminderByUuidAndGroupId(
			uuid, groupId);
	}

	public static AppraisalReminder findByAppraisalProcessId(
			long appraisalProcessId)
		throws com.ax.hrms.exception.NoSuchAppraisalReminderException {

		return getService().findByAppraisalProcessId(appraisalProcessId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the appraisal reminder with the primary key.
	 *
	 * @param appraisalRemainderId the primary key of the appraisal reminder
	 * @return the appraisal reminder
	 * @throws PortalException if a appraisal reminder with the primary key could not be found
	 */
	public static AppraisalReminder getAppraisalReminder(
			long appraisalRemainderId)
		throws PortalException {

		return getService().getAppraisalReminder(appraisalRemainderId);
	}

	/**
	 * Returns the appraisal reminder matching the UUID and group.
	 *
	 * @param uuid the appraisal reminder's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal reminder
	 * @throws PortalException if a matching appraisal reminder could not be found
	 */
	public static AppraisalReminder getAppraisalReminderByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getAppraisalReminderByUuidAndGroupId(uuid, groupId);
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
	public static List<AppraisalReminder> getAppraisalReminders(
		int start, int end) {

		return getService().getAppraisalReminders(start, end);
	}

	/**
	 * Returns all the appraisal reminders matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal reminders
	 * @param companyId the primary key of the company
	 * @return the matching appraisal reminders, or an empty list if no matches were found
	 */
	public static List<AppraisalReminder>
		getAppraisalRemindersByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getAppraisalRemindersByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<AppraisalReminder>
		getAppraisalRemindersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<AppraisalReminder> orderByComparator) {

		return getService().getAppraisalRemindersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of appraisal reminders.
	 *
	 * @return the number of appraisal reminders
	 */
	public static int getAppraisalRemindersCount() {
		return getService().getAppraisalRemindersCount();
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
	 * Updates the appraisal reminder in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalReminderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalReminder the appraisal reminder
	 * @return the appraisal reminder that was updated
	 */
	public static AppraisalReminder updateAppraisalReminder(
		AppraisalReminder appraisalReminder) {

		return getService().updateAppraisalReminder(appraisalReminder);
	}

	public static AppraisalReminderLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<AppraisalReminderLocalService>
		_serviceSnapshot = new Snapshot<>(
			AppraisalReminderLocalServiceUtil.class,
			AppraisalReminderLocalService.class);

}