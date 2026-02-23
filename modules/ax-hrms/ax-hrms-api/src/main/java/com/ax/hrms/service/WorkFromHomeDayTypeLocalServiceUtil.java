/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.WorkFromHomeDayType;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for WorkFromHomeDayType. This utility wraps
 * <code>com.ax.hrms.service.impl.WorkFromHomeDayTypeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHomeDayTypeLocalService
 * @generated
 */
public class WorkFromHomeDayTypeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.WorkFromHomeDayTypeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the work from home day type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkFromHomeDayTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workFromHomeDayType the work from home day type
	 * @return the work from home day type that was added
	 */
	public static WorkFromHomeDayType addWorkFromHomeDayType(
		WorkFromHomeDayType workFromHomeDayType) {

		return getService().addWorkFromHomeDayType(workFromHomeDayType);
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
	 * Creates a new work from home day type with the primary key. Does not add the work from home day type to the database.
	 *
	 * @param workFromHomeDayTypeId the primary key for the new work from home day type
	 * @return the new work from home day type
	 */
	public static WorkFromHomeDayType createWorkFromHomeDayType(
		long workFromHomeDayTypeId) {

		return getService().createWorkFromHomeDayType(workFromHomeDayTypeId);
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
	 * Deletes the work from home day type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkFromHomeDayTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workFromHomeDayTypeId the primary key of the work from home day type
	 * @return the work from home day type that was removed
	 * @throws PortalException if a work from home day type with the primary key could not be found
	 */
	public static WorkFromHomeDayType deleteWorkFromHomeDayType(
			long workFromHomeDayTypeId)
		throws PortalException {

		return getService().deleteWorkFromHomeDayType(workFromHomeDayTypeId);
	}

	/**
	 * Deletes the work from home day type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkFromHomeDayTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workFromHomeDayType the work from home day type
	 * @return the work from home day type that was removed
	 */
	public static WorkFromHomeDayType deleteWorkFromHomeDayType(
		WorkFromHomeDayType workFromHomeDayType) {

		return getService().deleteWorkFromHomeDayType(workFromHomeDayType);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.WorkFromHomeDayTypeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.WorkFromHomeDayTypeModelImpl</code>.
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

	public static WorkFromHomeDayType fetchWorkFromHomeDayType(
		long workFromHomeDayTypeId) {

		return getService().fetchWorkFromHomeDayType(workFromHomeDayTypeId);
	}

	/**
	 * Returns the work from home day type matching the UUID and group.
	 *
	 * @param uuid the work from home day type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	public static WorkFromHomeDayType fetchWorkFromHomeDayTypeByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchWorkFromHomeDayTypeByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<WorkFromHomeDayType> findByWorkFromHomeDate(
		java.util.Date workFromHomeDate) {

		return getService().findByWorkFromHomeDate(workFromHomeDate);
	}

	public static List<WorkFromHomeDayType> findByWorkFromHomeRequestId(
		long workFromHomeRequestId) {

		return getService().findByWorkFromHomeRequestId(workFromHomeRequestId);
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
	 * Returns the work from home day type with the primary key.
	 *
	 * @param workFromHomeDayTypeId the primary key of the work from home day type
	 * @return the work from home day type
	 * @throws PortalException if a work from home day type with the primary key could not be found
	 */
	public static WorkFromHomeDayType getWorkFromHomeDayType(
			long workFromHomeDayTypeId)
		throws PortalException {

		return getService().getWorkFromHomeDayType(workFromHomeDayTypeId);
	}

	/**
	 * Returns the work from home day type matching the UUID and group.
	 *
	 * @param uuid the work from home day type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching work from home day type
	 * @throws PortalException if a matching work from home day type could not be found
	 */
	public static WorkFromHomeDayType getWorkFromHomeDayTypeByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getWorkFromHomeDayTypeByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the work from home day types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @return the range of work from home day types
	 */
	public static List<WorkFromHomeDayType> getWorkFromHomeDayTypes(
		int start, int end) {

		return getService().getWorkFromHomeDayTypes(start, end);
	}

	/**
	 * Returns all the work from home day types matching the UUID and company.
	 *
	 * @param uuid the UUID of the work from home day types
	 * @param companyId the primary key of the company
	 * @return the matching work from home day types, or an empty list if no matches were found
	 */
	public static List<WorkFromHomeDayType>
		getWorkFromHomeDayTypesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getWorkFromHomeDayTypesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of work from home day types matching the UUID and company.
	 *
	 * @param uuid the UUID of the work from home day types
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching work from home day types, or an empty list if no matches were found
	 */
	public static List<WorkFromHomeDayType>
		getWorkFromHomeDayTypesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		return getService().getWorkFromHomeDayTypesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of work from home day types.
	 *
	 * @return the number of work from home day types
	 */
	public static int getWorkFromHomeDayTypesCount() {
		return getService().getWorkFromHomeDayTypesCount();
	}

	/**
	 * Updates the work from home day type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkFromHomeDayTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workFromHomeDayType the work from home day type
	 * @return the work from home day type that was updated
	 */
	public static WorkFromHomeDayType updateWorkFromHomeDayType(
		WorkFromHomeDayType workFromHomeDayType) {

		return getService().updateWorkFromHomeDayType(workFromHomeDayType);
	}

	public static WorkFromHomeDayTypeLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<WorkFromHomeDayTypeLocalService>
		_serviceSnapshot = new Snapshot<>(
			WorkFromHomeDayTypeLocalServiceUtil.class,
			WorkFromHomeDayTypeLocalService.class);

}