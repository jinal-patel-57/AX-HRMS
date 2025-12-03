/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.AppraisalEvaluationFormStatus;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AppraisalEvaluationFormStatus. This utility wraps
 * <code>com.ax.hrms.service.impl.AppraisalEvaluationFormStatusLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalEvaluationFormStatusLocalService
 * @generated
 */
public class AppraisalEvaluationFormStatusLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.AppraisalEvaluationFormStatusLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the appraisal evaluation form status to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalEvaluationFormStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalEvaluationFormStatus the appraisal evaluation form status
	 * @return the appraisal evaluation form status that was added
	 */
	public static AppraisalEvaluationFormStatus
		addAppraisalEvaluationFormStatus(
			AppraisalEvaluationFormStatus appraisalEvaluationFormStatus) {

		return getService().addAppraisalEvaluationFormStatus(
			appraisalEvaluationFormStatus);
	}

	/**
	 * Creates a new appraisal evaluation form status with the primary key. Does not add the appraisal evaluation form status to the database.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key for the new appraisal evaluation form status
	 * @return the new appraisal evaluation form status
	 */
	public static AppraisalEvaluationFormStatus
		createAppraisalEvaluationFormStatus(
			long appraisalEvaluationFormStatusId) {

		return getService().createAppraisalEvaluationFormStatus(
			appraisalEvaluationFormStatusId);
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
	 * Deletes the appraisal evaluation form status from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalEvaluationFormStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalEvaluationFormStatus the appraisal evaluation form status
	 * @return the appraisal evaluation form status that was removed
	 */
	public static AppraisalEvaluationFormStatus
		deleteAppraisalEvaluationFormStatus(
			AppraisalEvaluationFormStatus appraisalEvaluationFormStatus) {

		return getService().deleteAppraisalEvaluationFormStatus(
			appraisalEvaluationFormStatus);
	}

	/**
	 * Deletes the appraisal evaluation form status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalEvaluationFormStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalEvaluationFormStatusId the primary key of the appraisal evaluation form status
	 * @return the appraisal evaluation form status that was removed
	 * @throws PortalException if a appraisal evaluation form status with the primary key could not be found
	 */
	public static AppraisalEvaluationFormStatus
			deleteAppraisalEvaluationFormStatus(
				long appraisalEvaluationFormStatusId)
		throws PortalException {

		return getService().deleteAppraisalEvaluationFormStatus(
			appraisalEvaluationFormStatusId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalEvaluationFormStatusModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalEvaluationFormStatusModelImpl</code>.
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

	public static AppraisalEvaluationFormStatus
		fetchAppraisalEvaluationFormStatus(
			long appraisalEvaluationFormStatusId) {

		return getService().fetchAppraisalEvaluationFormStatus(
			appraisalEvaluationFormStatusId);
	}

	/**
	 * Returns the appraisal evaluation form status matching the UUID and group.
	 *
	 * @param uuid the appraisal evaluation form status's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	public static AppraisalEvaluationFormStatus
		fetchAppraisalEvaluationFormStatusByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchAppraisalEvaluationFormStatusByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<AppraisalEvaluationFormStatus>
		findByAppraisalProcessIdAndAppraisalFormTemplateId(
			long appraisalProcessId, long appraisalFormTemplateId) {

		return getService().findByAppraisalProcessIdAndAppraisalFormTemplateId(
			appraisalProcessId, appraisalFormTemplateId);
	}

	public static List<AppraisalEvaluationFormStatus>
		findByStatusAndSubmissionDate(
			java.util.Date submissionDate, boolean status) {

		return getService().findByStatusAndSubmissionDate(
			submissionDate, status);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the appraisal evaluation form status with the primary key.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key of the appraisal evaluation form status
	 * @return the appraisal evaluation form status
	 * @throws PortalException if a appraisal evaluation form status with the primary key could not be found
	 */
	public static AppraisalEvaluationFormStatus
			getAppraisalEvaluationFormStatus(
				long appraisalEvaluationFormStatusId)
		throws PortalException {

		return getService().getAppraisalEvaluationFormStatus(
			appraisalEvaluationFormStatusId);
	}

	/**
	 * Returns the appraisal evaluation form status matching the UUID and group.
	 *
	 * @param uuid the appraisal evaluation form status's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal evaluation form status
	 * @throws PortalException if a matching appraisal evaluation form status could not be found
	 */
	public static AppraisalEvaluationFormStatus
			getAppraisalEvaluationFormStatusByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().getAppraisalEvaluationFormStatusByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the appraisal evaluation form statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalEvaluationFormStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @return the range of appraisal evaluation form statuses
	 */
	public static List<AppraisalEvaluationFormStatus>
		getAppraisalEvaluationFormStatuses(int start, int end) {

		return getService().getAppraisalEvaluationFormStatuses(start, end);
	}

	/**
	 * Returns all the appraisal evaluation form statuses matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal evaluation form statuses
	 * @param companyId the primary key of the company
	 * @return the matching appraisal evaluation form statuses, or an empty list if no matches were found
	 */
	public static List<AppraisalEvaluationFormStatus>
		getAppraisalEvaluationFormStatusesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().
			getAppraisalEvaluationFormStatusesByUuidAndCompanyId(
				uuid, companyId);
	}

	/**
	 * Returns a range of appraisal evaluation form statuses matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal evaluation form statuses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of appraisal evaluation form statuses
	 * @param end the upper bound of the range of appraisal evaluation form statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching appraisal evaluation form statuses, or an empty list if no matches were found
	 */
	public static List<AppraisalEvaluationFormStatus>
		getAppraisalEvaluationFormStatusesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<AppraisalEvaluationFormStatus>
				orderByComparator) {

		return getService().
			getAppraisalEvaluationFormStatusesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of appraisal evaluation form statuses.
	 *
	 * @return the number of appraisal evaluation form statuses
	 */
	public static int getAppraisalEvaluationFormStatusesCount() {
		return getService().getAppraisalEvaluationFormStatusesCount();
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
	 * Updates the appraisal evaluation form status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalEvaluationFormStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalEvaluationFormStatus the appraisal evaluation form status
	 * @return the appraisal evaluation form status that was updated
	 */
	public static AppraisalEvaluationFormStatus
		updateAppraisalEvaluationFormStatus(
			AppraisalEvaluationFormStatus appraisalEvaluationFormStatus) {

		return getService().updateAppraisalEvaluationFormStatus(
			appraisalEvaluationFormStatus);
	}

	public static AppraisalEvaluationFormStatusLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<AppraisalEvaluationFormStatusLocalService>
		_serviceSnapshot = new Snapshot<>(
			AppraisalEvaluationFormStatusLocalServiceUtil.class,
			AppraisalEvaluationFormStatusLocalService.class);

}