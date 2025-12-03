/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.EmployeeSalary;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for EmployeeSalary. This utility wraps
 * <code>com.ax.hrms.service.impl.EmployeeSalaryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeSalaryLocalService
 * @generated
 */
public class EmployeeSalaryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.EmployeeSalaryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the employee salary to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeSalaryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeSalary the employee salary
	 * @return the employee salary that was added
	 */
	public static EmployeeSalary addEmployeeSalary(
		EmployeeSalary employeeSalary) {

		return getService().addEmployeeSalary(employeeSalary);
	}

	/**
	 * Creates a new employee salary with the primary key. Does not add the employee salary to the database.
	 *
	 * @param salaryId the primary key for the new employee salary
	 * @return the new employee salary
	 */
	public static EmployeeSalary createEmployeeSalary(long salaryId) {
		return getService().createEmployeeSalary(salaryId);
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
	 * Deletes the employee salary from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeSalaryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeSalary the employee salary
	 * @return the employee salary that was removed
	 */
	public static EmployeeSalary deleteEmployeeSalary(
		EmployeeSalary employeeSalary) {

		return getService().deleteEmployeeSalary(employeeSalary);
	}

	/**
	 * Deletes the employee salary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeSalaryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salaryId the primary key of the employee salary
	 * @return the employee salary that was removed
	 * @throws PortalException if a employee salary with the primary key could not be found
	 */
	public static EmployeeSalary deleteEmployeeSalary(long salaryId)
		throws PortalException {

		return getService().deleteEmployeeSalary(salaryId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeSalaryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeSalaryModelImpl</code>.
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

	public static EmployeeSalary fetchEmployeeSalary(long salaryId) {
		return getService().fetchEmployeeSalary(salaryId);
	}

	/**
	 * Returns the employee salary matching the UUID and group.
	 *
	 * @param uuid the employee salary's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	public static EmployeeSalary fetchEmployeeSalaryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchEmployeeSalaryByUuidAndGroupId(uuid, groupId);
	}

	public static EmployeeSalary findByEmployeeIdAndStatus(
			long employeeId, boolean status)
		throws com.ax.hrms.exception.NoSuchEmployeeSalaryException {

		return getService().findByEmployeeIdAndStatus(employeeId, status);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the employee salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @return the range of employee salaries
	 */
	public static List<EmployeeSalary> getEmployeeSalaries(int start, int end) {
		return getService().getEmployeeSalaries(start, end);
	}

	/**
	 * Returns all the employee salaries matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee salaries
	 * @param companyId the primary key of the company
	 * @return the matching employee salaries, or an empty list if no matches were found
	 */
	public static List<EmployeeSalary> getEmployeeSalariesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getEmployeeSalariesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of employee salaries matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee salaries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee salaries, or an empty list if no matches were found
	 */
	public static List<EmployeeSalary> getEmployeeSalariesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeSalary> orderByComparator) {

		return getService().getEmployeeSalariesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee salaries.
	 *
	 * @return the number of employee salaries
	 */
	public static int getEmployeeSalariesCount() {
		return getService().getEmployeeSalariesCount();
	}

	/**
	 * Returns the employee salary with the primary key.
	 *
	 * @param salaryId the primary key of the employee salary
	 * @return the employee salary
	 * @throws PortalException if a employee salary with the primary key could not be found
	 */
	public static EmployeeSalary getEmployeeSalary(long salaryId)
		throws PortalException {

		return getService().getEmployeeSalary(salaryId);
	}

	/**
	 * Returns the employee salary matching the UUID and group.
	 *
	 * @param uuid the employee salary's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee salary
	 * @throws PortalException if a matching employee salary could not be found
	 */
	public static EmployeeSalary getEmployeeSalaryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getEmployeeSalaryByUuidAndGroupId(uuid, groupId);
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
	 * Updates the employee salary in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeSalaryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeSalary the employee salary
	 * @return the employee salary that was updated
	 */
	public static EmployeeSalary updateEmployeeSalary(
		EmployeeSalary employeeSalary) {

		return getService().updateEmployeeSalary(employeeSalary);
	}

	public static EmployeeSalaryLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<EmployeeSalaryLocalService> _serviceSnapshot =
		new Snapshot<>(
			EmployeeSalaryLocalServiceUtil.class,
			EmployeeSalaryLocalService.class);

}