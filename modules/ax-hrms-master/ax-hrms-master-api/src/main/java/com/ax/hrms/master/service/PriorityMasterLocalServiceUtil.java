/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.ax.hrms.master.model.PriorityMaster;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PriorityMaster. This utility wraps
 * <code>com.ax.hrms.master.service.impl.PriorityMasterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PriorityMasterLocalService
 * @generated
 */
public class PriorityMasterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.master.service.impl.PriorityMasterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the priority master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PriorityMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param priorityMaster the priority master
	 * @return the priority master that was added
	 */
	public static PriorityMaster addPriorityMaster(
		PriorityMaster priorityMaster) {

		return getService().addPriorityMaster(priorityMaster);
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
	 * Creates a new priority master with the primary key. Does not add the priority master to the database.
	 *
	 * @param priorityMasterId the primary key for the new priority master
	 * @return the new priority master
	 */
	public static PriorityMaster createPriorityMaster(long priorityMasterId) {
		return getService().createPriorityMaster(priorityMasterId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the priority master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PriorityMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param priorityMasterId the primary key of the priority master
	 * @return the priority master that was removed
	 * @throws PortalException if a priority master with the primary key could not be found
	 */
	public static PriorityMaster deletePriorityMaster(long priorityMasterId)
		throws PortalException {

		return getService().deletePriorityMaster(priorityMasterId);
	}

	/**
	 * Deletes the priority master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PriorityMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param priorityMaster the priority master
	 * @return the priority master that was removed
	 */
	public static PriorityMaster deletePriorityMaster(
		PriorityMaster priorityMaster) {

		return getService().deletePriorityMaster(priorityMaster);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.PriorityMasterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.PriorityMasterModelImpl</code>.
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

	public static PriorityMaster fetchPriorityMaster(long priorityMasterId) {
		return getService().fetchPriorityMaster(priorityMasterId);
	}

	public static PriorityMaster findByPriorityName(String priorityName)
		throws com.ax.hrms.master.exception.NoSuchPriorityMasterException {

		return getService().findByPriorityName(priorityName);
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

	public static long getPriorityIdByPriorityName(String priorityName) {
		return getService().getPriorityIdByPriorityName(priorityName);
	}

	/**
	 * Returns the priority master with the primary key.
	 *
	 * @param priorityMasterId the primary key of the priority master
	 * @return the priority master
	 * @throws PortalException if a priority master with the primary key could not be found
	 */
	public static PriorityMaster getPriorityMaster(long priorityMasterId)
		throws PortalException {

		return getService().getPriorityMaster(priorityMasterId);
	}

	/**
	 * Returns a range of all the priority masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.PriorityMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of priority masters
	 * @param end the upper bound of the range of priority masters (not inclusive)
	 * @return the range of priority masters
	 */
	public static List<PriorityMaster> getPriorityMasters(int start, int end) {
		return getService().getPriorityMasters(start, end);
	}

	/**
	 * Returns the number of priority masters.
	 *
	 * @return the number of priority masters
	 */
	public static int getPriorityMastersCount() {
		return getService().getPriorityMastersCount();
	}

	public static boolean isPriorityNameExist(String priorityName) {
		return getService().isPriorityNameExist(priorityName);
	}

	/**
	 * Updates the priority master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PriorityMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param priorityMaster the priority master
	 * @return the priority master that was updated
	 */
	public static PriorityMaster updatePriorityMaster(
		PriorityMaster priorityMaster) {

		return getService().updatePriorityMaster(priorityMaster);
	}

	public static PriorityMasterLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<PriorityMasterLocalService> _serviceSnapshot =
		new Snapshot<>(
			PriorityMasterLocalServiceUtil.class,
			PriorityMasterLocalService.class);

}