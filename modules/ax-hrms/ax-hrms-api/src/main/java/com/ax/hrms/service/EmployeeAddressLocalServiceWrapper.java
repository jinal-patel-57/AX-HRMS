/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EmployeeAddressLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeAddressLocalService
 * @generated
 */
public class EmployeeAddressLocalServiceWrapper
	implements EmployeeAddressLocalService,
			   ServiceWrapper<EmployeeAddressLocalService> {

	public EmployeeAddressLocalServiceWrapper() {
		this(null);
	}

	public EmployeeAddressLocalServiceWrapper(
		EmployeeAddressLocalService employeeAddressLocalService) {

		_employeeAddressLocalService = employeeAddressLocalService;
	}

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
	@Override
	public com.ax.hrms.model.EmployeeAddress addEmployeeAddress(
		com.ax.hrms.model.EmployeeAddress employeeAddress) {

		return _employeeAddressLocalService.addEmployeeAddress(employeeAddress);
	}

	/**
	 * Creates a new employee address with the primary key. Does not add the employee address to the database.
	 *
	 * @param employeeAddressId the primary key for the new employee address
	 * @return the new employee address
	 */
	@Override
	public com.ax.hrms.model.EmployeeAddress createEmployeeAddress(
		long employeeAddressId) {

		return _employeeAddressLocalService.createEmployeeAddress(
			employeeAddressId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeAddressLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.ax.hrms.model.EmployeeAddress deleteEmployeeAddress(
		com.ax.hrms.model.EmployeeAddress employeeAddress) {

		return _employeeAddressLocalService.deleteEmployeeAddress(
			employeeAddress);
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
	@Override
	public com.ax.hrms.model.EmployeeAddress deleteEmployeeAddress(
			long employeeAddressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeAddressLocalService.deleteEmployeeAddress(
			employeeAddressId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeAddressLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _employeeAddressLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _employeeAddressLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeAddressLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _employeeAddressLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _employeeAddressLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _employeeAddressLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _employeeAddressLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _employeeAddressLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.EmployeeAddress fetchEmployeeAddress(
		long employeeAddressId) {

		return _employeeAddressLocalService.fetchEmployeeAddress(
			employeeAddressId);
	}

	/**
	 * Returns the employee address matching the UUID and group.
	 *
	 * @param uuid the employee address's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeAddress
		fetchEmployeeAddressByUuidAndGroupId(String uuid, long groupId) {

		return _employeeAddressLocalService.
			fetchEmployeeAddressByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.ax.hrms.model.EmployeeAddress findByEmployeeId(long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeAddressException {

		return _employeeAddressLocalService.findByEmployeeId(employeeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeAddressLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the employee address with the primary key.
	 *
	 * @param employeeAddressId the primary key of the employee address
	 * @return the employee address
	 * @throws PortalException if a employee address with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeAddress getEmployeeAddress(
			long employeeAddressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeAddressLocalService.getEmployeeAddress(
			employeeAddressId);
	}

	/**
	 * Returns the employee address matching the UUID and group.
	 *
	 * @param uuid the employee address's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee address
	 * @throws PortalException if a matching employee address could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeAddress getEmployeeAddressByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeAddressLocalService.getEmployeeAddressByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeAddress>
		getEmployeeAddresses(int start, int end) {

		return _employeeAddressLocalService.getEmployeeAddresses(start, end);
	}

	/**
	 * Returns all the employee addresses matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee addresses
	 * @param companyId the primary key of the company
	 * @return the matching employee addresses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeAddress>
		getEmployeeAddressesByUuidAndCompanyId(String uuid, long companyId) {

		return _employeeAddressLocalService.
			getEmployeeAddressesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeAddress>
		getEmployeeAddressesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.EmployeeAddress> orderByComparator) {

		return _employeeAddressLocalService.
			getEmployeeAddressesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee addresses.
	 *
	 * @return the number of employee addresses
	 */
	@Override
	public int getEmployeeAddressesCount() {
		return _employeeAddressLocalService.getEmployeeAddressesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _employeeAddressLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeAddressLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeAddressLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeAddressLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.ax.hrms.model.EmployeeAddress updateEmployeeAddress(
		com.ax.hrms.model.EmployeeAddress employeeAddress) {

		return _employeeAddressLocalService.updateEmployeeAddress(
			employeeAddress);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _employeeAddressLocalService.getBasePersistence();
	}

	@Override
	public EmployeeAddressLocalService getWrappedService() {
		return _employeeAddressLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeAddressLocalService employeeAddressLocalService) {

		_employeeAddressLocalService = employeeAddressLocalService;
	}

	private EmployeeAddressLocalService _employeeAddressLocalService;

}