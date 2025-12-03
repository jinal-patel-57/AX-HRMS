/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.UpcomingProbationEmployee;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for UpcomingProbationEmployee. This utility wraps
 * <code>com.ax.hrms.service.impl.UpcomingProbationEmployeeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UpcomingProbationEmployeeLocalService
 * @generated
 */
public class UpcomingProbationEmployeeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.UpcomingProbationEmployeeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the upcoming probation employee to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UpcomingProbationEmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param upcomingProbationEmployee the upcoming probation employee
	 * @return the upcoming probation employee that was added
	 */
	public static UpcomingProbationEmployee addUpcomingProbationEmployee(
		UpcomingProbationEmployee upcomingProbationEmployee) {

		return getService().addUpcomingProbationEmployee(
			upcomingProbationEmployee);
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
	 * Creates a new upcoming probation employee with the primary key. Does not add the upcoming probation employee to the database.
	 *
	 * @param upcomingProbationEmployeeId the primary key for the new upcoming probation employee
	 * @return the new upcoming probation employee
	 */
	public static UpcomingProbationEmployee createUpcomingProbationEmployee(
		long upcomingProbationEmployeeId) {

		return getService().createUpcomingProbationEmployee(
			upcomingProbationEmployeeId);
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
	 * Deletes the upcoming probation employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UpcomingProbationEmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param upcomingProbationEmployeeId the primary key of the upcoming probation employee
	 * @return the upcoming probation employee that was removed
	 * @throws PortalException if a upcoming probation employee with the primary key could not be found
	 */
	public static UpcomingProbationEmployee deleteUpcomingProbationEmployee(
			long upcomingProbationEmployeeId)
		throws PortalException {

		return getService().deleteUpcomingProbationEmployee(
			upcomingProbationEmployeeId);
	}

	/**
	 * Deletes the upcoming probation employee from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UpcomingProbationEmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param upcomingProbationEmployee the upcoming probation employee
	 * @return the upcoming probation employee that was removed
	 */
	public static UpcomingProbationEmployee deleteUpcomingProbationEmployee(
		UpcomingProbationEmployee upcomingProbationEmployee) {

		return getService().deleteUpcomingProbationEmployee(
			upcomingProbationEmployee);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.UpcomingProbationEmployeeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.UpcomingProbationEmployeeModelImpl</code>.
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

	public static UpcomingProbationEmployee fetchUpcomingProbationEmployee(
		long upcomingProbationEmployeeId) {

		return getService().fetchUpcomingProbationEmployee(
			upcomingProbationEmployeeId);
	}

	/**
	 * Returns the upcoming probation employee matching the UUID and group.
	 *
	 * @param uuid the upcoming probation employee's UUID
	 * @param groupId the primary key of the group
	 * @return the matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	public static UpcomingProbationEmployee
		fetchUpcomingProbationEmployeeByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchUpcomingProbationEmployeeByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<UpcomingProbationEmployee> findByMonthAndYear(
		int month, int year) {

		return getService().findByMonthAndYear(month, year);
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
	 * Returns the upcoming probation employee with the primary key.
	 *
	 * @param upcomingProbationEmployeeId the primary key of the upcoming probation employee
	 * @return the upcoming probation employee
	 * @throws PortalException if a upcoming probation employee with the primary key could not be found
	 */
	public static UpcomingProbationEmployee getUpcomingProbationEmployee(
			long upcomingProbationEmployeeId)
		throws PortalException {

		return getService().getUpcomingProbationEmployee(
			upcomingProbationEmployeeId);
	}

	/**
	 * Returns the upcoming probation employee matching the UUID and group.
	 *
	 * @param uuid the upcoming probation employee's UUID
	 * @param groupId the primary key of the group
	 * @return the matching upcoming probation employee
	 * @throws PortalException if a matching upcoming probation employee could not be found
	 */
	public static UpcomingProbationEmployee
			getUpcomingProbationEmployeeByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return getService().getUpcomingProbationEmployeeByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the upcoming probation employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @return the range of upcoming probation employees
	 */
	public static List<UpcomingProbationEmployee> getUpcomingProbationEmployees(
		int start, int end) {

		return getService().getUpcomingProbationEmployees(start, end);
	}

	/**
	 * Returns all the upcoming probation employees matching the UUID and company.
	 *
	 * @param uuid the UUID of the upcoming probation employees
	 * @param companyId the primary key of the company
	 * @return the matching upcoming probation employees, or an empty list if no matches were found
	 */
	public static List<UpcomingProbationEmployee>
		getUpcomingProbationEmployeesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getUpcomingProbationEmployeesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of upcoming probation employees matching the UUID and company.
	 *
	 * @param uuid the UUID of the upcoming probation employees
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching upcoming probation employees, or an empty list if no matches were found
	 */
	public static List<UpcomingProbationEmployee>
		getUpcomingProbationEmployeesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		return getService().getUpcomingProbationEmployeesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of upcoming probation employees.
	 *
	 * @return the number of upcoming probation employees
	 */
	public static int getUpcomingProbationEmployeesCount() {
		return getService().getUpcomingProbationEmployeesCount();
	}

	/**
	 * Updates the upcoming probation employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UpcomingProbationEmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param upcomingProbationEmployee the upcoming probation employee
	 * @return the upcoming probation employee that was updated
	 */
	public static UpcomingProbationEmployee updateUpcomingProbationEmployee(
		UpcomingProbationEmployee upcomingProbationEmployee) {

		return getService().updateUpcomingProbationEmployee(
			upcomingProbationEmployee);
	}

	public static UpcomingProbationEmployeeLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<UpcomingProbationEmployeeLocalService>
		_serviceSnapshot = new Snapshot<>(
			UpcomingProbationEmployeeLocalServiceUtil.class,
			UpcomingProbationEmployeeLocalService.class);

}