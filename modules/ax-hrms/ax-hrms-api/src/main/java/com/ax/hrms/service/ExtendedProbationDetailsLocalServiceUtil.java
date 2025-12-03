/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.ExtendedProbationDetails;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ExtendedProbationDetails. This utility wraps
 * <code>com.ax.hrms.service.impl.ExtendedProbationDetailsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ExtendedProbationDetailsLocalService
 * @generated
 */
public class ExtendedProbationDetailsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.ExtendedProbationDetailsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the extended probation details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExtendedProbationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param extendedProbationDetails the extended probation details
	 * @return the extended probation details that was added
	 */
	public static ExtendedProbationDetails addExtendedProbationDetails(
		ExtendedProbationDetails extendedProbationDetails) {

		return getService().addExtendedProbationDetails(
			extendedProbationDetails);
	}

	/**
	 * Creates a new extended probation details with the primary key. Does not add the extended probation details to the database.
	 *
	 * @param extendedProbationDetailsId the primary key for the new extended probation details
	 * @return the new extended probation details
	 */
	public static ExtendedProbationDetails createExtendedProbationDetails(
		long extendedProbationDetailsId) {

		return getService().createExtendedProbationDetails(
			extendedProbationDetailsId);
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
	 * Deletes the extended probation details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExtendedProbationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param extendedProbationDetails the extended probation details
	 * @return the extended probation details that was removed
	 */
	public static ExtendedProbationDetails deleteExtendedProbationDetails(
		ExtendedProbationDetails extendedProbationDetails) {

		return getService().deleteExtendedProbationDetails(
			extendedProbationDetails);
	}

	/**
	 * Deletes the extended probation details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExtendedProbationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param extendedProbationDetailsId the primary key of the extended probation details
	 * @return the extended probation details that was removed
	 * @throws PortalException if a extended probation details with the primary key could not be found
	 */
	public static ExtendedProbationDetails deleteExtendedProbationDetails(
			long extendedProbationDetailsId)
		throws PortalException {

		return getService().deleteExtendedProbationDetails(
			extendedProbationDetailsId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.ExtendedProbationDetailsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.ExtendedProbationDetailsModelImpl</code>.
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

	public static ExtendedProbationDetails fetchExtendedProbationDetails(
		long extendedProbationDetailsId) {

		return getService().fetchExtendedProbationDetails(
			extendedProbationDetailsId);
	}

	/**
	 * Returns the extended probation details matching the UUID and group.
	 *
	 * @param uuid the extended probation details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching extended probation details, or <code>null</code> if a matching extended probation details could not be found
	 */
	public static ExtendedProbationDetails
		fetchExtendedProbationDetailsByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchExtendedProbationDetailsByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns the extended probation details with the primary key.
	 *
	 * @param extendedProbationDetailsId the primary key of the extended probation details
	 * @return the extended probation details
	 * @throws PortalException if a extended probation details with the primary key could not be found
	 */
	public static ExtendedProbationDetails getExtendedProbationDetails(
			long extendedProbationDetailsId)
		throws PortalException {

		return getService().getExtendedProbationDetails(
			extendedProbationDetailsId);
	}

	/**
	 * Returns the extended probation details matching the UUID and group.
	 *
	 * @param uuid the extended probation details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching extended probation details
	 * @throws PortalException if a matching extended probation details could not be found
	 */
	public static ExtendedProbationDetails
			getExtendedProbationDetailsByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().getExtendedProbationDetailsByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the extended probation detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.ExtendedProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of extended probation detailses
	 * @param end the upper bound of the range of extended probation detailses (not inclusive)
	 * @return the range of extended probation detailses
	 */
	public static List<ExtendedProbationDetails> getExtendedProbationDetailses(
		int start, int end) {

		return getService().getExtendedProbationDetailses(start, end);
	}

	/**
	 * Returns all the extended probation detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the extended probation detailses
	 * @param companyId the primary key of the company
	 * @return the matching extended probation detailses, or an empty list if no matches were found
	 */
	public static List<ExtendedProbationDetails>
		getExtendedProbationDetailsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getExtendedProbationDetailsesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of extended probation detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the extended probation detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of extended probation detailses
	 * @param end the upper bound of the range of extended probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching extended probation detailses, or an empty list if no matches were found
	 */
	public static List<ExtendedProbationDetails>
		getExtendedProbationDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ExtendedProbationDetails> orderByComparator) {

		return getService().getExtendedProbationDetailsesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of extended probation detailses.
	 *
	 * @return the number of extended probation detailses
	 */
	public static int getExtendedProbationDetailsesCount() {
		return getService().getExtendedProbationDetailsesCount();
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
	 * Updates the extended probation details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExtendedProbationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param extendedProbationDetails the extended probation details
	 * @return the extended probation details that was updated
	 */
	public static ExtendedProbationDetails updateExtendedProbationDetails(
		ExtendedProbationDetails extendedProbationDetails) {

		return getService().updateExtendedProbationDetails(
			extendedProbationDetails);
	}

	public static ExtendedProbationDetailsLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<ExtendedProbationDetailsLocalService>
		_serviceSnapshot = new Snapshot<>(
			ExtendedProbationDetailsLocalServiceUtil.class,
			ExtendedProbationDetailsLocalService.class);

}