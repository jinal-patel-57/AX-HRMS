/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.EmployeeDesignation;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for EmployeeDesignation. This utility wraps
 * <code>com.ax.hrms.service.impl.EmployeeDesignationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDesignationLocalService
 * @generated
 */
public class EmployeeDesignationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.EmployeeDesignationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the employee designation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDesignation the employee designation
	 * @return the employee designation that was added
	 */
	public static EmployeeDesignation addEmployeeDesignation(
		EmployeeDesignation employeeDesignation) {

		return getService().addEmployeeDesignation(employeeDesignation);
	}

	/**
	 * Creates a new employee designation with the primary key. Does not add the employee designation to the database.
	 *
	 * @param employeeDesignationId the primary key for the new employee designation
	 * @return the new employee designation
	 */
	public static EmployeeDesignation createEmployeeDesignation(
		long employeeDesignationId) {

		return getService().createEmployeeDesignation(employeeDesignationId);
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
	 * Deletes the employee designation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDesignation the employee designation
	 * @return the employee designation that was removed
	 */
	public static EmployeeDesignation deleteEmployeeDesignation(
		EmployeeDesignation employeeDesignation) {

		return getService().deleteEmployeeDesignation(employeeDesignation);
	}

	/**
	 * Deletes the employee designation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDesignationId the primary key of the employee designation
	 * @return the employee designation that was removed
	 * @throws PortalException if a employee designation with the primary key could not be found
	 */
	public static EmployeeDesignation deleteEmployeeDesignation(
			long employeeDesignationId)
		throws PortalException {

		return getService().deleteEmployeeDesignation(employeeDesignationId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeDesignationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeDesignationModelImpl</code>.
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

	public static EmployeeDesignation fetchEmployeeDesignation(
		long employeeDesignationId) {

		return getService().fetchEmployeeDesignation(employeeDesignationId);
	}

	/**
	 * Returns the employee designation matching the UUID and group.
	 *
	 * @param uuid the employee designation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee designation, or <code>null</code> if a matching employee designation could not be found
	 */
	public static EmployeeDesignation fetchEmployeeDesignationByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchEmployeeDesignationByUuidAndGroupId(
			uuid, groupId);
	}

	public static EmployeeDesignation findByEmployeeId(long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeDesignationException {

		return getService().findByEmployeeId(employeeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static long getDesignationIdByEmployeeId(long employeeId) {
		return getService().getDesignationIdByEmployeeId(employeeId);
	}

	/**
	 * Returns the employee designation with the primary key.
	 *
	 * @param employeeDesignationId the primary key of the employee designation
	 * @return the employee designation
	 * @throws PortalException if a employee designation with the primary key could not be found
	 */
	public static EmployeeDesignation getEmployeeDesignation(
			long employeeDesignationId)
		throws PortalException {

		return getService().getEmployeeDesignation(employeeDesignationId);
	}

	/**
	 * Returns the employee designation matching the UUID and group.
	 *
	 * @param uuid the employee designation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee designation
	 * @throws PortalException if a matching employee designation could not be found
	 */
	public static EmployeeDesignation getEmployeeDesignationByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getEmployeeDesignationByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the employee designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @return the range of employee designations
	 */
	public static List<EmployeeDesignation> getEmployeeDesignations(
		int start, int end) {

		return getService().getEmployeeDesignations(start, end);
	}

	/**
	 * Returns all the employee designations matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee designations
	 * @param companyId the primary key of the company
	 * @return the matching employee designations, or an empty list if no matches were found
	 */
	public static List<EmployeeDesignation>
		getEmployeeDesignationsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getEmployeeDesignationsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of employee designations matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee designations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee designations, or an empty list if no matches were found
	 */
	public static List<EmployeeDesignation>
		getEmployeeDesignationsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<EmployeeDesignation> orderByComparator) {

		return getService().getEmployeeDesignationsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee designations.
	 *
	 * @return the number of employee designations
	 */
	public static int getEmployeeDesignationsCount() {
		return getService().getEmployeeDesignationsCount();
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
	 * Updates the employee designation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDesignation the employee designation
	 * @return the employee designation that was updated
	 */
	public static EmployeeDesignation updateEmployeeDesignation(
		EmployeeDesignation employeeDesignation) {

		return getService().updateEmployeeDesignation(employeeDesignation);
	}

	public static EmployeeDesignationLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<EmployeeDesignationLocalService>
		_serviceSnapshot = new Snapshot<>(
			EmployeeDesignationLocalServiceUtil.class,
			EmployeeDesignationLocalService.class);

}