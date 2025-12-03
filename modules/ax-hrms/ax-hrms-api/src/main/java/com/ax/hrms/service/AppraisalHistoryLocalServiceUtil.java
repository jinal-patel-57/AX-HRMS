/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.AppraisalHistory;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AppraisalHistory. This utility wraps
 * <code>com.ax.hrms.service.impl.AppraisalHistoryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalHistoryLocalService
 * @generated
 */
public class AppraisalHistoryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.AppraisalHistoryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static AppraisalHistory addAppraisalHistory(
		AppraisalHistory appraisalHistory) {

		return getService().addAppraisalHistory(appraisalHistory);
	}

	/**
	 * Creates a new appraisal history with the primary key. Does not add the appraisal history to the database.
	 *
	 * @param appraisalId the primary key for the new appraisal history
	 * @return the new appraisal history
	 */
	public static AppraisalHistory createAppraisalHistory(long appraisalId) {
		return getService().createAppraisalHistory(appraisalId);
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
	 * Deletes the appraisal history from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalHistory the appraisal history
	 * @return the appraisal history that was removed
	 */
	public static AppraisalHistory deleteAppraisalHistory(
		AppraisalHistory appraisalHistory) {

		return getService().deleteAppraisalHistory(appraisalHistory);
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
	public static AppraisalHistory deleteAppraisalHistory(long appraisalId)
		throws PortalException {

		return getService().deleteAppraisalHistory(appraisalId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalHistoryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalHistoryModelImpl</code>.
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

	public static AppraisalHistory fetchAppraisalHistory(long appraisalId) {
		return getService().fetchAppraisalHistory(appraisalId);
	}

	/**
	 * Returns the appraisal history matching the UUID and group.
	 *
	 * @param uuid the appraisal history's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal history, or <code>null</code> if a matching appraisal history could not be found
	 */
	public static AppraisalHistory fetchAppraisalHistoryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchAppraisalHistoryByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	public static List<AppraisalHistory> getAppraisalHistories(
		int start, int end) {

		return getService().getAppraisalHistories(start, end);
	}

	/**
	 * Returns all the appraisal histories matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal histories
	 * @param companyId the primary key of the company
	 * @return the matching appraisal histories, or an empty list if no matches were found
	 */
	public static List<AppraisalHistory>
		getAppraisalHistoriesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getAppraisalHistoriesByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<AppraisalHistory>
		getAppraisalHistoriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<AppraisalHistory> orderByComparator) {

		return getService().getAppraisalHistoriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of appraisal histories.
	 *
	 * @return the number of appraisal histories
	 */
	public static int getAppraisalHistoriesCount() {
		return getService().getAppraisalHistoriesCount();
	}

	/**
	 * Returns the appraisal history with the primary key.
	 *
	 * @param appraisalId the primary key of the appraisal history
	 * @return the appraisal history
	 * @throws PortalException if a appraisal history with the primary key could not be found
	 */
	public static AppraisalHistory getAppraisalHistory(long appraisalId)
		throws PortalException {

		return getService().getAppraisalHistory(appraisalId);
	}

	/**
	 * Returns the appraisal history matching the UUID and group.
	 *
	 * @param uuid the appraisal history's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal history
	 * @throws PortalException if a matching appraisal history could not be found
	 */
	public static AppraisalHistory getAppraisalHistoryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getAppraisalHistoryByUuidAndGroupId(uuid, groupId);
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
	 * Updates the appraisal history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalHistory the appraisal history
	 * @return the appraisal history that was updated
	 */
	public static AppraisalHistory updateAppraisalHistory(
		AppraisalHistory appraisalHistory) {

		return getService().updateAppraisalHistory(appraisalHistory);
	}

	public static AppraisalHistoryLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<AppraisalHistoryLocalService>
		_serviceSnapshot = new Snapshot<>(
			AppraisalHistoryLocalServiceUtil.class,
			AppraisalHistoryLocalService.class);

}