/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.ax.hrms.master.model.AppraisalStatusMaster;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AppraisalStatusMaster. This utility wraps
 * <code>com.ax.hrms.master.service.impl.AppraisalStatusMasterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalStatusMasterLocalService
 * @generated
 */
public class AppraisalStatusMasterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.master.service.impl.AppraisalStatusMasterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the appraisal status master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalStatusMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalStatusMaster the appraisal status master
	 * @return the appraisal status master that was added
	 */
	public static AppraisalStatusMaster addAppraisalStatusMaster(
		AppraisalStatusMaster appraisalStatusMaster) {

		return getService().addAppraisalStatusMaster(appraisalStatusMaster);
	}

	/**
	 * Creates a new appraisal status master with the primary key. Does not add the appraisal status master to the database.
	 *
	 * @param appraisalStatusMasterId the primary key for the new appraisal status master
	 * @return the new appraisal status master
	 */
	public static AppraisalStatusMaster createAppraisalStatusMaster(
		long appraisalStatusMasterId) {

		return getService().createAppraisalStatusMaster(
			appraisalStatusMasterId);
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
	 * Deletes the appraisal status master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalStatusMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalStatusMaster the appraisal status master
	 * @return the appraisal status master that was removed
	 */
	public static AppraisalStatusMaster deleteAppraisalStatusMaster(
		AppraisalStatusMaster appraisalStatusMaster) {

		return getService().deleteAppraisalStatusMaster(appraisalStatusMaster);
	}

	/**
	 * Deletes the appraisal status master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalStatusMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalStatusMasterId the primary key of the appraisal status master
	 * @return the appraisal status master that was removed
	 * @throws PortalException if a appraisal status master with the primary key could not be found
	 */
	public static AppraisalStatusMaster deleteAppraisalStatusMaster(
			long appraisalStatusMasterId)
		throws PortalException {

		return getService().deleteAppraisalStatusMaster(
			appraisalStatusMasterId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.AppraisalStatusMasterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.AppraisalStatusMasterModelImpl</code>.
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

	public static AppraisalStatusMaster fetchAppraisalStatusMaster(
		long appraisalStatusMasterId) {

		return getService().fetchAppraisalStatusMaster(appraisalStatusMasterId);
	}

	public static AppraisalStatusMaster findBystatus(String status)
		throws com.ax.hrms.master.exception.
			NoSuchAppraisalStatusMasterException {

		return getService().findBystatus(status);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the appraisal status master with the primary key.
	 *
	 * @param appraisalStatusMasterId the primary key of the appraisal status master
	 * @return the appraisal status master
	 * @throws PortalException if a appraisal status master with the primary key could not be found
	 */
	public static AppraisalStatusMaster getAppraisalStatusMaster(
			long appraisalStatusMasterId)
		throws PortalException {

		return getService().getAppraisalStatusMaster(appraisalStatusMasterId);
	}

	/**
	 * Returns a range of all the appraisal status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.AppraisalStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal status masters
	 * @param end the upper bound of the range of appraisal status masters (not inclusive)
	 * @return the range of appraisal status masters
	 */
	public static List<AppraisalStatusMaster> getAppraisalStatusMasters(
		int start, int end) {

		return getService().getAppraisalStatusMasters(start, end);
	}

	/**
	 * Returns the number of appraisal status masters.
	 *
	 * @return the number of appraisal status masters
	 */
	public static int getAppraisalStatusMastersCount() {
		return getService().getAppraisalStatusMastersCount();
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
	 * Updates the appraisal status master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalStatusMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalStatusMaster the appraisal status master
	 * @return the appraisal status master that was updated
	 */
	public static AppraisalStatusMaster updateAppraisalStatusMaster(
		AppraisalStatusMaster appraisalStatusMaster) {

		return getService().updateAppraisalStatusMaster(appraisalStatusMaster);
	}

	public static AppraisalStatusMasterLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<AppraisalStatusMasterLocalService>
		_serviceSnapshot = new Snapshot<>(
			AppraisalStatusMasterLocalServiceUtil.class,
			AppraisalStatusMasterLocalService.class);

}