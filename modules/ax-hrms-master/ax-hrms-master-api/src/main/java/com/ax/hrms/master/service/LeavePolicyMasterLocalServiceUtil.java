/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.ax.hrms.master.model.LeavePolicyMaster;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for LeavePolicyMaster. This utility wraps
 * <code>com.ax.hrms.master.service.impl.LeavePolicyMasterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LeavePolicyMasterLocalService
 * @generated
 */
public class LeavePolicyMasterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.master.service.impl.LeavePolicyMasterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the leave policy master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeavePolicyMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leavePolicyMaster the leave policy master
	 * @return the leave policy master that was added
	 */
	public static LeavePolicyMaster addLeavePolicyMaster(
		LeavePolicyMaster leavePolicyMaster) {

		return getService().addLeavePolicyMaster(leavePolicyMaster);
	}

	/**
	 * Creates a new leave policy master with the primary key. Does not add the leave policy master to the database.
	 *
	 * @param leavePolicyMasterId the primary key for the new leave policy master
	 * @return the new leave policy master
	 */
	public static LeavePolicyMaster createLeavePolicyMaster(
		long leavePolicyMasterId) {

		return getService().createLeavePolicyMaster(leavePolicyMasterId);
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
	 * Deletes the leave policy master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeavePolicyMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leavePolicyMaster the leave policy master
	 * @return the leave policy master that was removed
	 */
	public static LeavePolicyMaster deleteLeavePolicyMaster(
		LeavePolicyMaster leavePolicyMaster) {

		return getService().deleteLeavePolicyMaster(leavePolicyMaster);
	}

	/**
	 * Deletes the leave policy master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeavePolicyMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leavePolicyMasterId the primary key of the leave policy master
	 * @return the leave policy master that was removed
	 * @throws PortalException if a leave policy master with the primary key could not be found
	 */
	public static LeavePolicyMaster deleteLeavePolicyMaster(
			long leavePolicyMasterId)
		throws PortalException {

		return getService().deleteLeavePolicyMaster(leavePolicyMasterId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.LeavePolicyMasterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.LeavePolicyMasterModelImpl</code>.
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

	public static LeavePolicyMaster fetchLeavePolicyMaster(
		long leavePolicyMasterId) {

		return getService().fetchLeavePolicyMaster(leavePolicyMasterId);
	}

	public static LeavePolicyMaster findByLeaveTypeMasterId(
			long leaveTypeMasterId)
		throws com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException {

		return getService().findByLeaveTypeMasterId(leaveTypeMasterId);
	}

	public static LeavePolicyMaster findByLeaveTypeMasterIdAndYear(
			long leaveTypeMasterId, int yearOfPolicy)
		throws com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException {

		return getService().findByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, yearOfPolicy);
	}

	public static LeavePolicyMaster findByLeaveTypeMasterIdAndYearOfPolicy(
			long leaveTypeMasterId, int yearOfPolicy)
		throws com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException {

		return getService().findByLeaveTypeMasterIdAndYearOfPolicy(
			leaveTypeMasterId, yearOfPolicy);
	}

	public static LeavePolicyMaster
			findByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
				long leaveTypeMasterId, int yearOfPolicy,
				int eligibleAfterMonths)
		throws com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException {

		return getService().
			findByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
				leaveTypeMasterId, yearOfPolicy, eligibleAfterMonths);
	}

	public static List<LeavePolicyMaster> findByYear(int yearOfPolicy) {
		return getService().findByYear(yearOfPolicy);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the leave policy master with the primary key.
	 *
	 * @param leavePolicyMasterId the primary key of the leave policy master
	 * @return the leave policy master
	 * @throws PortalException if a leave policy master with the primary key could not be found
	 */
	public static LeavePolicyMaster getLeavePolicyMaster(
			long leavePolicyMasterId)
		throws PortalException {

		return getService().getLeavePolicyMaster(leavePolicyMasterId);
	}

	/**
	 * Returns a range of all the leave policy masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.LeavePolicyMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave policy masters
	 * @param end the upper bound of the range of leave policy masters (not inclusive)
	 * @return the range of leave policy masters
	 */
	public static List<LeavePolicyMaster> getLeavePolicyMasters(
		int start, int end) {

		return getService().getLeavePolicyMasters(start, end);
	}

	/**
	 * Returns the number of leave policy masters.
	 *
	 * @return the number of leave policy masters
	 */
	public static int getLeavePolicyMastersCount() {
		return getService().getLeavePolicyMastersCount();
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
	 * Updates the leave policy master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeavePolicyMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leavePolicyMaster the leave policy master
	 * @return the leave policy master that was updated
	 */
	public static LeavePolicyMaster updateLeavePolicyMaster(
		LeavePolicyMaster leavePolicyMaster) {

		return getService().updateLeavePolicyMaster(leavePolicyMaster);
	}

	public static LeavePolicyMasterLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<LeavePolicyMasterLocalService>
		_serviceSnapshot = new Snapshot<>(
			LeavePolicyMasterLocalServiceUtil.class,
			LeavePolicyMasterLocalService.class);

}