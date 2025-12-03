/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.ax.hrms.master.model.LeaveTypeMaster;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for LeaveTypeMaster. This utility wraps
 * <code>com.ax.hrms.master.service.impl.LeaveTypeMasterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTypeMasterLocalService
 * @generated
 */
public class LeaveTypeMasterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.master.service.impl.LeaveTypeMasterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the leave type master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTypeMaster the leave type master
	 * @return the leave type master that was added
	 */
	public static LeaveTypeMaster addLeaveTypeMaster(
		LeaveTypeMaster leaveTypeMaster) {

		return getService().addLeaveTypeMaster(leaveTypeMaster);
	}

	/**
	 * Creates a new leave type master with the primary key. Does not add the leave type master to the database.
	 *
	 * @param leaveTypeMasterId the primary key for the new leave type master
	 * @return the new leave type master
	 */
	public static LeaveTypeMaster createLeaveTypeMaster(
		long leaveTypeMasterId) {

		return getService().createLeaveTypeMaster(leaveTypeMasterId);
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
	 * Deletes the leave type master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTypeMaster the leave type master
	 * @return the leave type master that was removed
	 */
	public static LeaveTypeMaster deleteLeaveTypeMaster(
		LeaveTypeMaster leaveTypeMaster) {

		return getService().deleteLeaveTypeMaster(leaveTypeMaster);
	}

	/**
	 * Deletes the leave type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTypeMasterId the primary key of the leave type master
	 * @return the leave type master that was removed
	 * @throws PortalException if a leave type master with the primary key could not be found
	 */
	public static LeaveTypeMaster deleteLeaveTypeMaster(long leaveTypeMasterId)
		throws PortalException {

		return getService().deleteLeaveTypeMaster(leaveTypeMasterId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.LeaveTypeMasterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.LeaveTypeMasterModelImpl</code>.
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

	public static LeaveTypeMaster fetchLeaveTypeMaster(long leaveTypeMasterId) {
		return getService().fetchLeaveTypeMaster(leaveTypeMasterId);
	}

	public static List<LeaveTypeMaster> findByActiveAndAppearForAll(
		boolean isActive, boolean isAppearForAll) {

		return getService().findByActiveAndAppearForAll(
			isActive, isAppearForAll);
	}

	public static LeaveTypeMaster findByLeaveTypeMasterId(
			long leaveTypeMasterId)
		throws com.ax.hrms.master.exception.NoSuchLeaveTypeMasterException {

		return getService().findByLeaveTypeMasterId(leaveTypeMasterId);
	}

	public static LeaveTypeMaster findByLeaveTypeName(String leaveTypeName)
		throws com.ax.hrms.master.exception.NoSuchLeaveTypeMasterException {

		return getService().findByLeaveTypeName(leaveTypeName);
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
	 * Returns the leave type master with the primary key.
	 *
	 * @param leaveTypeMasterId the primary key of the leave type master
	 * @return the leave type master
	 * @throws PortalException if a leave type master with the primary key could not be found
	 */
	public static LeaveTypeMaster getLeaveTypeMaster(long leaveTypeMasterId)
		throws PortalException {

		return getService().getLeaveTypeMaster(leaveTypeMasterId);
	}

	public static long getLeaveTypeMasterIdByName(String leaveTypeName) {
		return getService().getLeaveTypeMasterIdByName(leaveTypeName);
	}

	/**
	 * Returns a range of all the leave type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.LeaveTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave type masters
	 * @param end the upper bound of the range of leave type masters (not inclusive)
	 * @return the range of leave type masters
	 */
	public static List<LeaveTypeMaster> getLeaveTypeMasters(
		int start, int end) {

		return getService().getLeaveTypeMasters(start, end);
	}

	/**
	 * Returns the number of leave type masters.
	 *
	 * @return the number of leave type masters
	 */
	public static int getLeaveTypeMastersCount() {
		return getService().getLeaveTypeMastersCount();
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

	public static boolean isLeaveTypeNameExists(String leaveTypeName) {
		return getService().isLeaveTypeNameExists(leaveTypeName);
	}

	/**
	 * Updates the leave type master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTypeMaster the leave type master
	 * @return the leave type master that was updated
	 */
	public static LeaveTypeMaster updateLeaveTypeMaster(
		LeaveTypeMaster leaveTypeMaster) {

		return getService().updateLeaveTypeMaster(leaveTypeMaster);
	}

	public static LeaveTypeMasterLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<LeaveTypeMasterLocalService>
		_serviceSnapshot = new Snapshot<>(
			LeaveTypeMasterLocalServiceUtil.class,
			LeaveTypeMasterLocalService.class);

}