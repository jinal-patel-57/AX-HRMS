/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EmployeeBankAccountLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeBankAccountLocalService
 * @generated
 */
public class EmployeeBankAccountLocalServiceWrapper
	implements EmployeeBankAccountLocalService,
			   ServiceWrapper<EmployeeBankAccountLocalService> {

	public EmployeeBankAccountLocalServiceWrapper() {
		this(null);
	}

	public EmployeeBankAccountLocalServiceWrapper(
		EmployeeBankAccountLocalService employeeBankAccountLocalService) {

		_employeeBankAccountLocalService = employeeBankAccountLocalService;
	}

	/**
	 * Adds the employee bank account to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeBankAccountLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeBankAccount the employee bank account
	 * @return the employee bank account that was added
	 */
	@Override
	public com.ax.hrms.model.EmployeeBankAccount addEmployeeBankAccount(
		com.ax.hrms.model.EmployeeBankAccount employeeBankAccount) {

		return _employeeBankAccountLocalService.addEmployeeBankAccount(
			employeeBankAccount);
	}

	/**
	 * Creates a new employee bank account with the primary key. Does not add the employee bank account to the database.
	 *
	 * @param bankAccountId the primary key for the new employee bank account
	 * @return the new employee bank account
	 */
	@Override
	public com.ax.hrms.model.EmployeeBankAccount createEmployeeBankAccount(
		long bankAccountId) {

		return _employeeBankAccountLocalService.createEmployeeBankAccount(
			bankAccountId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeBankAccountLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee bank account from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeBankAccountLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeBankAccount the employee bank account
	 * @return the employee bank account that was removed
	 */
	@Override
	public com.ax.hrms.model.EmployeeBankAccount deleteEmployeeBankAccount(
		com.ax.hrms.model.EmployeeBankAccount employeeBankAccount) {

		return _employeeBankAccountLocalService.deleteEmployeeBankAccount(
			employeeBankAccount);
	}

	/**
	 * Deletes the employee bank account with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeBankAccountLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bankAccountId the primary key of the employee bank account
	 * @return the employee bank account that was removed
	 * @throws PortalException if a employee bank account with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeBankAccount deleteEmployeeBankAccount(
			long bankAccountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeBankAccountLocalService.deleteEmployeeBankAccount(
			bankAccountId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeBankAccountLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _employeeBankAccountLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _employeeBankAccountLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeBankAccountLocalService.dynamicQuery();
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

		return _employeeBankAccountLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeBankAccountModelImpl</code>.
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

		return _employeeBankAccountLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeBankAccountModelImpl</code>.
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

		return _employeeBankAccountLocalService.dynamicQuery(
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

		return _employeeBankAccountLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeBankAccountLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.EmployeeBankAccount fetchEmployeeBankAccount(
		long bankAccountId) {

		return _employeeBankAccountLocalService.fetchEmployeeBankAccount(
			bankAccountId);
	}

	/**
	 * Returns the employee bank account matching the UUID and group.
	 *
	 * @param uuid the employee bank account's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee bank account, or <code>null</code> if a matching employee bank account could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeBankAccount
		fetchEmployeeBankAccountByUuidAndGroupId(String uuid, long groupId) {

		return _employeeBankAccountLocalService.
			fetchEmployeeBankAccountByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeBankAccountLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the employee bank account with the primary key.
	 *
	 * @param bankAccountId the primary key of the employee bank account
	 * @return the employee bank account
	 * @throws PortalException if a employee bank account with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeBankAccount getEmployeeBankAccount(
			long bankAccountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeBankAccountLocalService.getEmployeeBankAccount(
			bankAccountId);
	}

	/**
	 * Returns the employee bank account matching the UUID and group.
	 *
	 * @param uuid the employee bank account's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee bank account
	 * @throws PortalException if a matching employee bank account could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeBankAccount
			getEmployeeBankAccountByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeBankAccountLocalService.
			getEmployeeBankAccountByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the employee bank accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @return the range of employee bank accounts
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeBankAccount>
		getEmployeeBankAccounts(int start, int end) {

		return _employeeBankAccountLocalService.getEmployeeBankAccounts(
			start, end);
	}

	/**
	 * Returns all the employee bank accounts matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee bank accounts
	 * @param companyId the primary key of the company
	 * @return the matching employee bank accounts, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeBankAccount>
		getEmployeeBankAccountsByUuidAndCompanyId(String uuid, long companyId) {

		return _employeeBankAccountLocalService.
			getEmployeeBankAccountsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of employee bank accounts matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee bank accounts
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee bank accounts, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeBankAccount>
		getEmployeeBankAccountsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.EmployeeBankAccount> orderByComparator) {

		return _employeeBankAccountLocalService.
			getEmployeeBankAccountsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee bank accounts.
	 *
	 * @return the number of employee bank accounts
	 */
	@Override
	public int getEmployeeBankAccountsCount() {
		return _employeeBankAccountLocalService.getEmployeeBankAccountsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _employeeBankAccountLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeBankAccountLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeBankAccountLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeBankAccountLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the employee bank account in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeBankAccountLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeBankAccount the employee bank account
	 * @return the employee bank account that was updated
	 */
	@Override
	public com.ax.hrms.model.EmployeeBankAccount updateEmployeeBankAccount(
		com.ax.hrms.model.EmployeeBankAccount employeeBankAccount) {

		return _employeeBankAccountLocalService.updateEmployeeBankAccount(
			employeeBankAccount);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _employeeBankAccountLocalService.getBasePersistence();
	}

	@Override
	public EmployeeBankAccountLocalService getWrappedService() {
		return _employeeBankAccountLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeBankAccountLocalService employeeBankAccountLocalService) {

		_employeeBankAccountLocalService = employeeBankAccountLocalService;
	}

	private EmployeeBankAccountLocalService _employeeBankAccountLocalService;

}