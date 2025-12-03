/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.EmployeeAddress;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for EmployeeAddress. This utility wraps
 * <code>com.ax.hrms.service.impl.EmployeeAddressLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeAddressLocalService
 * @generated
 */
public class EmployeeAddressLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.EmployeeAddressLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the employee address to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeAddressLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeAddress the employee address
	 * @return the employee address that was added
	 */
	public static EmployeeAddress addEmployeeAddress(
		EmployeeAddress employeeAddress) {

		return getService().addEmployeeAddress(employeeAddress);
	}

	/**
	 * Creates a new employee address with the primary key. Does not add the employee address to the database.
	 *
	 * @param employeeAddressId the primary key for the new employee address
	 * @return the new employee address
	 */
	public static EmployeeAddress createEmployeeAddress(
		long employeeAddressId) {

		return getService().createEmployeeAddress(employeeAddressId);
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
	 * Deletes the employee address from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeAddressLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeAddress the employee address
	 * @return the employee address that was removed
	 */
	public static EmployeeAddress deleteEmployeeAddress(
		EmployeeAddress employeeAddress) {

		return getService().deleteEmployeeAddress(employeeAddress);
	}

	/**
	 * Deletes the employee address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeAddressLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeAddressId the primary key of the employee address
	 * @return the employee address that was removed
	 * @throws PortalException if a employee address with the primary key could not be found
	 */
	public static EmployeeAddress deleteEmployeeAddress(long employeeAddressId)
		throws PortalException {

		return getService().deleteEmployeeAddress(employeeAddressId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeAddressModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeAddressModelImpl</code>.
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

	public static EmployeeAddress fetchEmployeeAddress(long employeeAddressId) {
		return getService().fetchEmployeeAddress(employeeAddressId);
	}

	/**
	 * Returns the employee address matching the UUID and group.
	 *
	 * @param uuid the employee address's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public static EmployeeAddress fetchEmployeeAddressByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchEmployeeAddressByUuidAndGroupId(uuid, groupId);
	}

	public static EmployeeAddress findByEmployeeId(long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeAddressException {

		return getService().findByEmployeeId(employeeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the employee address with the primary key.
	 *
	 * @param employeeAddressId the primary key of the employee address
	 * @return the employee address
	 * @throws PortalException if a employee address with the primary key could not be found
	 */
	public static EmployeeAddress getEmployeeAddress(long employeeAddressId)
		throws PortalException {

		return getService().getEmployeeAddress(employeeAddressId);
	}

	/**
	 * Returns the employee address matching the UUID and group.
	 *
	 * @param uuid the employee address's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee address
	 * @throws PortalException if a matching employee address could not be found
	 */
	public static EmployeeAddress getEmployeeAddressByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getEmployeeAddressByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the employee addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @return the range of employee addresses
	 */
	public static List<EmployeeAddress> getEmployeeAddresses(
		int start, int end) {

		return getService().getEmployeeAddresses(start, end);
	}

	/**
	 * Returns all the employee addresses matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee addresses
	 * @param companyId the primary key of the company
	 * @return the matching employee addresses, or an empty list if no matches were found
	 */
	public static List<EmployeeAddress> getEmployeeAddressesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getEmployeeAddressesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of employee addresses matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee addresses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee addresses, or an empty list if no matches were found
	 */
	public static List<EmployeeAddress> getEmployeeAddressesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator) {

		return getService().getEmployeeAddressesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee addresses.
	 *
	 * @return the number of employee addresses
	 */
	public static int getEmployeeAddressesCount() {
		return getService().getEmployeeAddressesCount();
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
	 * Updates the employee address in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeAddressLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeAddress the employee address
	 * @return the employee address that was updated
	 */
	public static EmployeeAddress updateEmployeeAddress(
		EmployeeAddress employeeAddress) {

		return getService().updateEmployeeAddress(employeeAddress);
	}

	public static EmployeeAddressLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<EmployeeAddressLocalService>
		_serviceSnapshot = new Snapshot<>(
			EmployeeAddressLocalServiceUtil.class,
			EmployeeAddressLocalService.class);

}