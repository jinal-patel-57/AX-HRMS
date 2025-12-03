/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.EmployeeOffBoarding;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for EmployeeOffBoarding. This utility wraps
 * <code>com.ax.hrms.service.impl.EmployeeOffBoardingLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeOffBoardingLocalService
 * @generated
 */
public class EmployeeOffBoardingLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.EmployeeOffBoardingLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the employee off boarding to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeOffBoardingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeOffBoarding the employee off boarding
	 * @return the employee off boarding that was added
	 */
	public static EmployeeOffBoarding addEmployeeOffBoarding(
		EmployeeOffBoarding employeeOffBoarding) {

		return getService().addEmployeeOffBoarding(employeeOffBoarding);
	}

	/**
	 * Creates a new employee off boarding with the primary key. Does not add the employee off boarding to the database.
	 *
	 * @param employeeOffBoardingId the primary key for the new employee off boarding
	 * @return the new employee off boarding
	 */
	public static EmployeeOffBoarding createEmployeeOffBoarding(
		long employeeOffBoardingId) {

		return getService().createEmployeeOffBoarding(employeeOffBoardingId);
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
	 * Deletes the employee off boarding from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeOffBoardingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeOffBoarding the employee off boarding
	 * @return the employee off boarding that was removed
	 */
	public static EmployeeOffBoarding deleteEmployeeOffBoarding(
		EmployeeOffBoarding employeeOffBoarding) {

		return getService().deleteEmployeeOffBoarding(employeeOffBoarding);
	}

	/**
	 * Deletes the employee off boarding with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeOffBoardingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeOffBoardingId the primary key of the employee off boarding
	 * @return the employee off boarding that was removed
	 * @throws PortalException if a employee off boarding with the primary key could not be found
	 */
	public static EmployeeOffBoarding deleteEmployeeOffBoarding(
			long employeeOffBoardingId)
		throws PortalException {

		return getService().deleteEmployeeOffBoarding(employeeOffBoardingId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeOffBoardingModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeOffBoardingModelImpl</code>.
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

	public static EmployeeOffBoarding fetchEmployeeOffBoarding(
		long employeeOffBoardingId) {

		return getService().fetchEmployeeOffBoarding(employeeOffBoardingId);
	}

	/**
	 * Returns the employee off boarding matching the UUID and group.
	 *
	 * @param uuid the employee off boarding's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	public static EmployeeOffBoarding fetchEmployeeOffBoardingByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchEmployeeOffBoardingByUuidAndGroupId(
			uuid, groupId);
	}

	public static EmployeeOffBoarding findByEmployeeId(long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeOffBoardingException {

		return getService().findByEmployeeId(employeeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the employee off boarding with the primary key.
	 *
	 * @param employeeOffBoardingId the primary key of the employee off boarding
	 * @return the employee off boarding
	 * @throws PortalException if a employee off boarding with the primary key could not be found
	 */
	public static EmployeeOffBoarding getEmployeeOffBoarding(
			long employeeOffBoardingId)
		throws PortalException {

		return getService().getEmployeeOffBoarding(employeeOffBoardingId);
	}

	/**
	 * Returns the employee off boarding matching the UUID and group.
	 *
	 * @param uuid the employee off boarding's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee off boarding
	 * @throws PortalException if a matching employee off boarding could not be found
	 */
	public static EmployeeOffBoarding getEmployeeOffBoardingByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getEmployeeOffBoardingByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the employee off boardings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @return the range of employee off boardings
	 */
	public static List<EmployeeOffBoarding> getEmployeeOffBoardings(
		int start, int end) {

		return getService().getEmployeeOffBoardings(start, end);
	}

	/**
	 * Returns all the employee off boardings matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee off boardings
	 * @param companyId the primary key of the company
	 * @return the matching employee off boardings, or an empty list if no matches were found
	 */
	public static List<EmployeeOffBoarding>
		getEmployeeOffBoardingsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getEmployeeOffBoardingsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of employee off boardings matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee off boardings
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee off boardings, or an empty list if no matches were found
	 */
	public static List<EmployeeOffBoarding>
		getEmployeeOffBoardingsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<EmployeeOffBoarding> orderByComparator) {

		return getService().getEmployeeOffBoardingsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee off boardings.
	 *
	 * @return the number of employee off boardings
	 */
	public static int getEmployeeOffBoardingsCount() {
		return getService().getEmployeeOffBoardingsCount();
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
	 * Updates the employee off boarding in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeOffBoardingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeOffBoarding the employee off boarding
	 * @return the employee off boarding that was updated
	 */
	public static EmployeeOffBoarding updateEmployeeOffBoarding(
		EmployeeOffBoarding employeeOffBoarding) {

		return getService().updateEmployeeOffBoarding(employeeOffBoarding);
	}

	public static EmployeeOffBoardingLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<EmployeeOffBoardingLocalService>
		_serviceSnapshot = new Snapshot<>(
			EmployeeOffBoardingLocalServiceUtil.class,
			EmployeeOffBoardingLocalService.class);

}