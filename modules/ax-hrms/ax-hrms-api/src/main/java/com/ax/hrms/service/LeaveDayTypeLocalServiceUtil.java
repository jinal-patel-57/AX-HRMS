/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.LeaveDayType;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for LeaveDayType. This utility wraps
 * <code>com.ax.hrms.service.impl.LeaveDayTypeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveDayTypeLocalService
 * @generated
 */
public class LeaveDayTypeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.LeaveDayTypeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the leave day type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveDayTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveDayType the leave day type
	 * @return the leave day type that was added
	 */
	public static LeaveDayType addLeaveDayType(LeaveDayType leaveDayType) {
		return getService().addLeaveDayType(leaveDayType);
	}

	/**
	 * Creates a new leave day type with the primary key. Does not add the leave day type to the database.
	 *
	 * @param leaveDayTypeId the primary key for the new leave day type
	 * @return the new leave day type
	 */
	public static LeaveDayType createLeaveDayType(long leaveDayTypeId) {
		return getService().createLeaveDayType(leaveDayTypeId);
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
	 * Deletes the leave day type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveDayTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveDayType the leave day type
	 * @return the leave day type that was removed
	 */
	public static LeaveDayType deleteLeaveDayType(LeaveDayType leaveDayType) {
		return getService().deleteLeaveDayType(leaveDayType);
	}

	/**
	 * Deletes the leave day type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveDayTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveDayTypeId the primary key of the leave day type
	 * @return the leave day type that was removed
	 * @throws PortalException if a leave day type with the primary key could not be found
	 */
	public static LeaveDayType deleteLeaveDayType(long leaveDayTypeId)
		throws PortalException {

		return getService().deleteLeaveDayType(leaveDayTypeId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveDayTypeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveDayTypeModelImpl</code>.
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

	public static LeaveDayType fetchLeaveDayType(long leaveDayTypeId) {
		return getService().fetchLeaveDayType(leaveDayTypeId);
	}

	/**
	 * Returns the leave day type matching the UUID and group.
	 *
	 * @param uuid the leave day type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	public static LeaveDayType fetchLeaveDayTypeByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchLeaveDayTypeByUuidAndGroupId(uuid, groupId);
	}

	public static List<LeaveDayType> findByLeaveRequestId(long leaveRequestId) {
		return getService().findByLeaveRequestId(leaveRequestId);
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

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the leave day type with the primary key.
	 *
	 * @param leaveDayTypeId the primary key of the leave day type
	 * @return the leave day type
	 * @throws PortalException if a leave day type with the primary key could not be found
	 */
	public static LeaveDayType getLeaveDayType(long leaveDayTypeId)
		throws PortalException {

		return getService().getLeaveDayType(leaveDayTypeId);
	}

	/**
	 * Returns the leave day type matching the UUID and group.
	 *
	 * @param uuid the leave day type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave day type
	 * @throws PortalException if a matching leave day type could not be found
	 */
	public static LeaveDayType getLeaveDayTypeByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getLeaveDayTypeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the leave day types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @return the range of leave day types
	 */
	public static List<LeaveDayType> getLeaveDayTypes(int start, int end) {
		return getService().getLeaveDayTypes(start, end);
	}

	/**
	 * Returns all the leave day types matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave day types
	 * @param companyId the primary key of the company
	 * @return the matching leave day types, or an empty list if no matches were found
	 */
	public static List<LeaveDayType> getLeaveDayTypesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getLeaveDayTypesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of leave day types matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave day types
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching leave day types, or an empty list if no matches were found
	 */
	public static List<LeaveDayType> getLeaveDayTypesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveDayType> orderByComparator) {

		return getService().getLeaveDayTypesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of leave day types.
	 *
	 * @return the number of leave day types
	 */
	public static int getLeaveDayTypesCount() {
		return getService().getLeaveDayTypesCount();
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
	 * Updates the leave day type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveDayTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveDayType the leave day type
	 * @return the leave day type that was updated
	 */
	public static LeaveDayType updateLeaveDayType(LeaveDayType leaveDayType) {
		return getService().updateLeaveDayType(leaveDayType);
	}

	public static LeaveDayTypeLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<LeaveDayTypeLocalService> _serviceSnapshot =
		new Snapshot<>(
			LeaveDayTypeLocalServiceUtil.class, LeaveDayTypeLocalService.class);

}