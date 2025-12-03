/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.EmployeeBankAccount;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the employee bank account service. This utility wraps <code>com.ax.hrms.service.persistence.impl.EmployeeBankAccountPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeBankAccountPersistence
 * @generated
 */
public class EmployeeBankAccountUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(EmployeeBankAccount employeeBankAccount) {
		getPersistence().clearCache(employeeBankAccount);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, EmployeeBankAccount> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeBankAccount> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeBankAccount> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeBankAccount> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeBankAccount> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeBankAccount update(
		EmployeeBankAccount employeeBankAccount) {

		return getPersistence().update(employeeBankAccount);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeBankAccount update(
		EmployeeBankAccount employeeBankAccount,
		ServiceContext serviceContext) {

		return getPersistence().update(employeeBankAccount, serviceContext);
	}

	/**
	 * Returns all the employee bank accounts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee bank accounts
	 */
	public static List<EmployeeBankAccount> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the employee bank accounts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @return the range of matching employee bank accounts
	 */
	public static List<EmployeeBankAccount> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the employee bank accounts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee bank accounts
	 */
	public static List<EmployeeBankAccount> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeBankAccount> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee bank accounts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee bank accounts
	 */
	public static List<EmployeeBankAccount> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeBankAccount> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee bank account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a matching employee bank account could not be found
	 */
	public static EmployeeBankAccount findByUuid_First(
			String uuid,
			OrderByComparator<EmployeeBankAccount> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeBankAccountException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first employee bank account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee bank account, or <code>null</code> if a matching employee bank account could not be found
	 */
	public static EmployeeBankAccount fetchByUuid_First(
		String uuid, OrderByComparator<EmployeeBankAccount> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee bank account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a matching employee bank account could not be found
	 */
	public static EmployeeBankAccount findByUuid_Last(
			String uuid,
			OrderByComparator<EmployeeBankAccount> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeBankAccountException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee bank account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee bank account, or <code>null</code> if a matching employee bank account could not be found
	 */
	public static EmployeeBankAccount fetchByUuid_Last(
		String uuid, OrderByComparator<EmployeeBankAccount> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the employee bank accounts before and after the current employee bank account in the ordered set where uuid = &#63;.
	 *
	 * @param bankAccountId the primary key of the current employee bank account
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a employee bank account with the primary key could not be found
	 */
	public static EmployeeBankAccount[] findByUuid_PrevAndNext(
			long bankAccountId, String uuid,
			OrderByComparator<EmployeeBankAccount> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeBankAccountException {

		return getPersistence().findByUuid_PrevAndNext(
			bankAccountId, uuid, orderByComparator);
	}

	/**
	 * Removes all the employee bank accounts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of employee bank accounts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee bank accounts
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the employee bank account where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeBankAccountException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a matching employee bank account could not be found
	 */
	public static EmployeeBankAccount findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeBankAccountException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee bank account where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee bank account, or <code>null</code> if a matching employee bank account could not be found
	 */
	public static EmployeeBankAccount fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee bank account where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee bank account, or <code>null</code> if a matching employee bank account could not be found
	 */
	public static EmployeeBankAccount fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the employee bank account where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee bank account that was removed
	 */
	public static EmployeeBankAccount removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeBankAccountException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of employee bank accounts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee bank accounts
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the employee bank accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee bank accounts
	 */
	public static List<EmployeeBankAccount> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the employee bank accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @return the range of matching employee bank accounts
	 */
	public static List<EmployeeBankAccount> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee bank accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee bank accounts
	 */
	public static List<EmployeeBankAccount> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeBankAccount> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee bank accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee bank accounts
	 */
	public static List<EmployeeBankAccount> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeBankAccount> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee bank account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a matching employee bank account could not be found
	 */
	public static EmployeeBankAccount findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeBankAccount> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeBankAccountException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first employee bank account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee bank account, or <code>null</code> if a matching employee bank account could not be found
	 */
	public static EmployeeBankAccount fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeBankAccount> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee bank account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a matching employee bank account could not be found
	 */
	public static EmployeeBankAccount findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeBankAccount> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeBankAccountException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee bank account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee bank account, or <code>null</code> if a matching employee bank account could not be found
	 */
	public static EmployeeBankAccount fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeBankAccount> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the employee bank accounts before and after the current employee bank account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param bankAccountId the primary key of the current employee bank account
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a employee bank account with the primary key could not be found
	 */
	public static EmployeeBankAccount[] findByUuid_C_PrevAndNext(
			long bankAccountId, String uuid, long companyId,
			OrderByComparator<EmployeeBankAccount> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeBankAccountException {

		return getPersistence().findByUuid_C_PrevAndNext(
			bankAccountId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the employee bank accounts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of employee bank accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee bank accounts
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the employee bank account in the entity cache if it is enabled.
	 *
	 * @param employeeBankAccount the employee bank account
	 */
	public static void cacheResult(EmployeeBankAccount employeeBankAccount) {
		getPersistence().cacheResult(employeeBankAccount);
	}

	/**
	 * Caches the employee bank accounts in the entity cache if it is enabled.
	 *
	 * @param employeeBankAccounts the employee bank accounts
	 */
	public static void cacheResult(
		List<EmployeeBankAccount> employeeBankAccounts) {

		getPersistence().cacheResult(employeeBankAccounts);
	}

	/**
	 * Creates a new employee bank account with the primary key. Does not add the employee bank account to the database.
	 *
	 * @param bankAccountId the primary key for the new employee bank account
	 * @return the new employee bank account
	 */
	public static EmployeeBankAccount create(long bankAccountId) {
		return getPersistence().create(bankAccountId);
	}

	/**
	 * Removes the employee bank account with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bankAccountId the primary key of the employee bank account
	 * @return the employee bank account that was removed
	 * @throws NoSuchEmployeeBankAccountException if a employee bank account with the primary key could not be found
	 */
	public static EmployeeBankAccount remove(long bankAccountId)
		throws com.ax.hrms.exception.NoSuchEmployeeBankAccountException {

		return getPersistence().remove(bankAccountId);
	}

	public static EmployeeBankAccount updateImpl(
		EmployeeBankAccount employeeBankAccount) {

		return getPersistence().updateImpl(employeeBankAccount);
	}

	/**
	 * Returns the employee bank account with the primary key or throws a <code>NoSuchEmployeeBankAccountException</code> if it could not be found.
	 *
	 * @param bankAccountId the primary key of the employee bank account
	 * @return the employee bank account
	 * @throws NoSuchEmployeeBankAccountException if a employee bank account with the primary key could not be found
	 */
	public static EmployeeBankAccount findByPrimaryKey(long bankAccountId)
		throws com.ax.hrms.exception.NoSuchEmployeeBankAccountException {

		return getPersistence().findByPrimaryKey(bankAccountId);
	}

	/**
	 * Returns the employee bank account with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bankAccountId the primary key of the employee bank account
	 * @return the employee bank account, or <code>null</code> if a employee bank account with the primary key could not be found
	 */
	public static EmployeeBankAccount fetchByPrimaryKey(long bankAccountId) {
		return getPersistence().fetchByPrimaryKey(bankAccountId);
	}

	/**
	 * Returns all the employee bank accounts.
	 *
	 * @return the employee bank accounts
	 */
	public static List<EmployeeBankAccount> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee bank accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @return the range of employee bank accounts
	 */
	public static List<EmployeeBankAccount> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee bank accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee bank accounts
	 */
	public static List<EmployeeBankAccount> findAll(
		int start, int end,
		OrderByComparator<EmployeeBankAccount> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee bank accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBankAccountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee bank accounts
	 * @param end the upper bound of the range of employee bank accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee bank accounts
	 */
	public static List<EmployeeBankAccount> findAll(
		int start, int end,
		OrderByComparator<EmployeeBankAccount> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee bank accounts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee bank accounts.
	 *
	 * @return the number of employee bank accounts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeBankAccountPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		EmployeeBankAccountPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile EmployeeBankAccountPersistence _persistence;

}