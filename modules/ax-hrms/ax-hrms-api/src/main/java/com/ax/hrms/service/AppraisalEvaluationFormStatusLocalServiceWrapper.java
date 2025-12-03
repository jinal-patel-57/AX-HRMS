/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AppraisalEvaluationFormStatusLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalEvaluationFormStatusLocalService
 * @generated
 */
public class AppraisalEvaluationFormStatusLocalServiceWrapper
	implements AppraisalEvaluationFormStatusLocalService,
			   ServiceWrapper<AppraisalEvaluationFormStatusLocalService> {

	public AppraisalEvaluationFormStatusLocalServiceWrapper() {
		this(null);
	}

	public AppraisalEvaluationFormStatusLocalServiceWrapper(
		AppraisalEvaluationFormStatusLocalService
			appraisalEvaluationFormStatusLocalService) {

		_appraisalEvaluationFormStatusLocalService =
			appraisalEvaluationFormStatusLocalService;
	}

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
	@Override
	public com.ax.hrms.model.AppraisalEvaluationFormStatus
		addAppraisalEvaluationFormStatus(
			com.ax.hrms.model.AppraisalEvaluationFormStatus
				appraisalEvaluationFormStatus) {

		return _appraisalEvaluationFormStatusLocalService.
			addAppraisalEvaluationFormStatus(appraisalEvaluationFormStatus);
	}

	/**
	 * Creates a new appraisal evaluation form status with the primary key. Does not add the appraisal evaluation form status to the database.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key for the new appraisal evaluation form status
	 * @return the new appraisal evaluation form status
	 */
	@Override
	public com.ax.hrms.model.AppraisalEvaluationFormStatus
		createAppraisalEvaluationFormStatus(
			long appraisalEvaluationFormStatusId) {

		return _appraisalEvaluationFormStatusLocalService.
			createAppraisalEvaluationFormStatus(
				appraisalEvaluationFormStatusId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalEvaluationFormStatusLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.ax.hrms.model.AppraisalEvaluationFormStatus
		deleteAppraisalEvaluationFormStatus(
			com.ax.hrms.model.AppraisalEvaluationFormStatus
				appraisalEvaluationFormStatus) {

		return _appraisalEvaluationFormStatusLocalService.
			deleteAppraisalEvaluationFormStatus(appraisalEvaluationFormStatus);
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
	@Override
	public com.ax.hrms.model.AppraisalEvaluationFormStatus
			deleteAppraisalEvaluationFormStatus(
				long appraisalEvaluationFormStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalEvaluationFormStatusLocalService.
			deleteAppraisalEvaluationFormStatus(
				appraisalEvaluationFormStatusId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalEvaluationFormStatusLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _appraisalEvaluationFormStatusLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _appraisalEvaluationFormStatusLocalService.dslQueryCount(
			dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appraisalEvaluationFormStatusLocalService.dynamicQuery();
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

		return _appraisalEvaluationFormStatusLocalService.dynamicQuery(
			dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _appraisalEvaluationFormStatusLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _appraisalEvaluationFormStatusLocalService.dynamicQuery(
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

		return _appraisalEvaluationFormStatusLocalService.dynamicQueryCount(
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

		return _appraisalEvaluationFormStatusLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.AppraisalEvaluationFormStatus
		fetchAppraisalEvaluationFormStatus(
			long appraisalEvaluationFormStatusId) {

		return _appraisalEvaluationFormStatusLocalService.
			fetchAppraisalEvaluationFormStatus(appraisalEvaluationFormStatusId);
	}

	/**
	 * Returns the appraisal evaluation form status matching the UUID and group.
	 *
	 * @param uuid the appraisal evaluation form status's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal evaluation form status, or <code>null</code> if a matching appraisal evaluation form status could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalEvaluationFormStatus
		fetchAppraisalEvaluationFormStatusByUuidAndGroupId(
			String uuid, long groupId) {

		return _appraisalEvaluationFormStatusLocalService.
			fetchAppraisalEvaluationFormStatusByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.AppraisalEvaluationFormStatus>
		findByAppraisalProcessIdAndAppraisalFormTemplateId(
			long appraisalProcessId, long appraisalFormTemplateId) {

		return _appraisalEvaluationFormStatusLocalService.
			findByAppraisalProcessIdAndAppraisalFormTemplateId(
				appraisalProcessId, appraisalFormTemplateId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.AppraisalEvaluationFormStatus>
		findByStatusAndSubmissionDate(
			java.util.Date submissionDate, boolean status) {

		return _appraisalEvaluationFormStatusLocalService.
			findByStatusAndSubmissionDate(submissionDate, status);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _appraisalEvaluationFormStatusLocalService.
			getActionableDynamicQuery();
	}

	/**
	 * Returns the appraisal evaluation form status with the primary key.
	 *
	 * @param appraisalEvaluationFormStatusId the primary key of the appraisal evaluation form status
	 * @return the appraisal evaluation form status
	 * @throws PortalException if a appraisal evaluation form status with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalEvaluationFormStatus
			getAppraisalEvaluationFormStatus(
				long appraisalEvaluationFormStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalEvaluationFormStatusLocalService.
			getAppraisalEvaluationFormStatus(appraisalEvaluationFormStatusId);
	}

	/**
	 * Returns the appraisal evaluation form status matching the UUID and group.
	 *
	 * @param uuid the appraisal evaluation form status's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal evaluation form status
	 * @throws PortalException if a matching appraisal evaluation form status could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalEvaluationFormStatus
			getAppraisalEvaluationFormStatusByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalEvaluationFormStatusLocalService.
			getAppraisalEvaluationFormStatusByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.ax.hrms.model.AppraisalEvaluationFormStatus>
		getAppraisalEvaluationFormStatuses(int start, int end) {

		return _appraisalEvaluationFormStatusLocalService.
			getAppraisalEvaluationFormStatuses(start, end);
	}

	/**
	 * Returns all the appraisal evaluation form statuses matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal evaluation form statuses
	 * @param companyId the primary key of the company
	 * @return the matching appraisal evaluation form statuses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.AppraisalEvaluationFormStatus>
		getAppraisalEvaluationFormStatusesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _appraisalEvaluationFormStatusLocalService.
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
	@Override
	public java.util.List<com.ax.hrms.model.AppraisalEvaluationFormStatus>
		getAppraisalEvaluationFormStatusesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.AppraisalEvaluationFormStatus>
					orderByComparator) {

		return _appraisalEvaluationFormStatusLocalService.
			getAppraisalEvaluationFormStatusesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of appraisal evaluation form statuses.
	 *
	 * @return the number of appraisal evaluation form statuses
	 */
	@Override
	public int getAppraisalEvaluationFormStatusesCount() {
		return _appraisalEvaluationFormStatusLocalService.
			getAppraisalEvaluationFormStatusesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _appraisalEvaluationFormStatusLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _appraisalEvaluationFormStatusLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appraisalEvaluationFormStatusLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalEvaluationFormStatusLocalService.getPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.ax.hrms.model.AppraisalEvaluationFormStatus
		updateAppraisalEvaluationFormStatus(
			com.ax.hrms.model.AppraisalEvaluationFormStatus
				appraisalEvaluationFormStatus) {

		return _appraisalEvaluationFormStatusLocalService.
			updateAppraisalEvaluationFormStatus(appraisalEvaluationFormStatus);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _appraisalEvaluationFormStatusLocalService.getBasePersistence();
	}

	@Override
	public AppraisalEvaluationFormStatusLocalService getWrappedService() {
		return _appraisalEvaluationFormStatusLocalService;
	}

	@Override
	public void setWrappedService(
		AppraisalEvaluationFormStatusLocalService
			appraisalEvaluationFormStatusLocalService) {

		_appraisalEvaluationFormStatusLocalService =
			appraisalEvaluationFormStatusLocalService;
	}

	private AppraisalEvaluationFormStatusLocalService
		_appraisalEvaluationFormStatusLocalService;

}