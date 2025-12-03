/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AppraisalHistoryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalHistoryLocalService
 * @generated
 */
public class AppraisalHistoryLocalServiceWrapper
	implements AppraisalHistoryLocalService,
			   ServiceWrapper<AppraisalHistoryLocalService> {

	public AppraisalHistoryLocalServiceWrapper() {
		this(null);
	}

	public AppraisalHistoryLocalServiceWrapper(
		AppraisalHistoryLocalService appraisalHistoryLocalService) {

		_appraisalHistoryLocalService = appraisalHistoryLocalService;
	}

	/**
	 * Adds the appraisal history to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalHistory the appraisal history
	 * @return the appraisal history that was added
	 */
	@Override
	public com.ax.hrms.model.AppraisalHistory addAppraisalHistory(
		com.ax.hrms.model.AppraisalHistory appraisalHistory) {

		return _appraisalHistoryLocalService.addAppraisalHistory(
			appraisalHistory);
	}

	/**
	 * Creates a new appraisal history with the primary key. Does not add the appraisal history to the database.
	 *
	 * @param appraisalId the primary key for the new appraisal history
	 * @return the new appraisal history
	 */
	@Override
	public com.ax.hrms.model.AppraisalHistory createAppraisalHistory(
		long appraisalId) {

		return _appraisalHistoryLocalService.createAppraisalHistory(
			appraisalId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalHistoryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the appraisal history from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalHistory the appraisal history
	 * @return the appraisal history that was removed
	 */
	@Override
	public com.ax.hrms.model.AppraisalHistory deleteAppraisalHistory(
		com.ax.hrms.model.AppraisalHistory appraisalHistory) {

		return _appraisalHistoryLocalService.deleteAppraisalHistory(
			appraisalHistory);
	}

	/**
	 * Deletes the appraisal history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalId the primary key of the appraisal history
	 * @return the appraisal history that was removed
	 * @throws PortalException if a appraisal history with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalHistory deleteAppraisalHistory(
			long appraisalId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalHistoryLocalService.deleteAppraisalHistory(
			appraisalId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalHistoryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _appraisalHistoryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _appraisalHistoryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appraisalHistoryLocalService.dynamicQuery();
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

		return _appraisalHistoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalHistoryModelImpl</code>.
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

		return _appraisalHistoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalHistoryModelImpl</code>.
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

		return _appraisalHistoryLocalService.dynamicQuery(
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

		return _appraisalHistoryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _appraisalHistoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.AppraisalHistory fetchAppraisalHistory(
		long appraisalId) {

		return _appraisalHistoryLocalService.fetchAppraisalHistory(appraisalId);
	}

	/**
	 * Returns the appraisal history matching the UUID and group.
	 *
	 * @param uuid the appraisal history's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal history, or <code>null</code> if a matching appraisal history could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalHistory
		fetchAppraisalHistoryByUuidAndGroupId(String uuid, long groupId) {

		return _appraisalHistoryLocalService.
			fetchAppraisalHistoryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _appraisalHistoryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the appraisal histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal histories
	 * @param end the upper bound of the range of appraisal histories (not inclusive)
	 * @return the range of appraisal histories
	 */
	@Override
	public java.util.List<com.ax.hrms.model.AppraisalHistory>
		getAppraisalHistories(int start, int end) {

		return _appraisalHistoryLocalService.getAppraisalHistories(start, end);
	}

	/**
	 * Returns all the appraisal histories matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal histories
	 * @param companyId the primary key of the company
	 * @return the matching appraisal histories, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.AppraisalHistory>
		getAppraisalHistoriesByUuidAndCompanyId(String uuid, long companyId) {

		return _appraisalHistoryLocalService.
			getAppraisalHistoriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of appraisal histories matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal histories
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of appraisal histories
	 * @param end the upper bound of the range of appraisal histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching appraisal histories, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.AppraisalHistory>
		getAppraisalHistoriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.AppraisalHistory> orderByComparator) {

		return _appraisalHistoryLocalService.
			getAppraisalHistoriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of appraisal histories.
	 *
	 * @return the number of appraisal histories
	 */
	@Override
	public int getAppraisalHistoriesCount() {
		return _appraisalHistoryLocalService.getAppraisalHistoriesCount();
	}

	/**
	 * Returns the appraisal history with the primary key.
	 *
	 * @param appraisalId the primary key of the appraisal history
	 * @return the appraisal history
	 * @throws PortalException if a appraisal history with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalHistory getAppraisalHistory(
			long appraisalId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalHistoryLocalService.getAppraisalHistory(appraisalId);
	}

	/**
	 * Returns the appraisal history matching the UUID and group.
	 *
	 * @param uuid the appraisal history's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal history
	 * @throws PortalException if a matching appraisal history could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalHistory
			getAppraisalHistoryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalHistoryLocalService.
			getAppraisalHistoryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _appraisalHistoryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _appraisalHistoryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appraisalHistoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalHistoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the appraisal history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalHistory the appraisal history
	 * @return the appraisal history that was updated
	 */
	@Override
	public com.ax.hrms.model.AppraisalHistory updateAppraisalHistory(
		com.ax.hrms.model.AppraisalHistory appraisalHistory) {

		return _appraisalHistoryLocalService.updateAppraisalHistory(
			appraisalHistory);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _appraisalHistoryLocalService.getBasePersistence();
	}

	@Override
	public AppraisalHistoryLocalService getWrappedService() {
		return _appraisalHistoryLocalService;
	}

	@Override
	public void setWrappedService(
		AppraisalHistoryLocalService appraisalHistoryLocalService) {

		_appraisalHistoryLocalService = appraisalHistoryLocalService;
	}

	private AppraisalHistoryLocalService _appraisalHistoryLocalService;

}