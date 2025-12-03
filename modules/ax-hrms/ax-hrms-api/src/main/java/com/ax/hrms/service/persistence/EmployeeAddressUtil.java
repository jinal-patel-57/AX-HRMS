/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.EmployeeAddress;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the employee address service. This utility wraps <code>com.ax.hrms.service.persistence.impl.EmployeeAddressPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeAddressPersistence
 * @generated
 */
public class EmployeeAddressUtil {

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
	public static void clearCache(EmployeeAddress employeeAddress) {
		getPersistence().clearCache(employeeAddress);
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
	public static Map<Serializable, EmployeeAddress> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeAddress> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeAddress> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeAddress> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeAddress update(EmployeeAddress employeeAddress) {
		return getPersistence().update(employeeAddress);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeAddress update(
		EmployeeAddress employeeAddress, ServiceContext serviceContext) {

		return getPersistence().update(employeeAddress, serviceContext);
	}

	/**
	 * Returns all the employee addresses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee addresses
	 */
	public static List<EmployeeAddress> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the employee addresses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @return the range of matching employee addresses
	 */
	public static List<EmployeeAddress> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the employee addresses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee addresses
	 */
	public static List<EmployeeAddress> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee addresses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee addresses
	 */
	public static List<EmployeeAddress> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee address in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public static EmployeeAddress findByUuid_First(
			String uuid, OrderByComparator<EmployeeAddress> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeAddressException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first employee address in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public static EmployeeAddress fetchByUuid_First(
		String uuid, OrderByComparator<EmployeeAddress> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee address in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public static EmployeeAddress findByUuid_Last(
			String uuid, OrderByComparator<EmployeeAddress> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeAddressException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee address in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public static EmployeeAddress fetchByUuid_Last(
		String uuid, OrderByComparator<EmployeeAddress> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the employee addresses before and after the current employee address in the ordered set where uuid = &#63;.
	 *
	 * @param employeeAddressId the primary key of the current employee address
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee address
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	public static EmployeeAddress[] findByUuid_PrevAndNext(
			long employeeAddressId, String uuid,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeAddressException {

		return getPersistence().findByUuid_PrevAndNext(
			employeeAddressId, uuid, orderByComparator);
	}

	/**
	 * Removes all the employee addresses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of employee addresses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee addresses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the employee address where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeAddressException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public static EmployeeAddress findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeAddressException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee address where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public static EmployeeAddress fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee address where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public static EmployeeAddress fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the employee address where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee address that was removed
	 */
	public static EmployeeAddress removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeAddressException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of employee addresses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee addresses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the employee addresses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee addresses
	 */
	public static List<EmployeeAddress> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the employee addresses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @return the range of matching employee addresses
	 */
	public static List<EmployeeAddress> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee addresses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee addresses
	 */
	public static List<EmployeeAddress> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee addresses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee addresses
	 */
	public static List<EmployeeAddress> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee address in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public static EmployeeAddress findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeAddressException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first employee address in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public static EmployeeAddress fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeAddress> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee address in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public static EmployeeAddress findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeAddressException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee address in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public static EmployeeAddress fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeAddress> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the employee addresses before and after the current employee address in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeeAddressId the primary key of the current employee address
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee address
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	public static EmployeeAddress[] findByUuid_C_PrevAndNext(
			long employeeAddressId, String uuid, long companyId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeAddressException {

		return getPersistence().findByUuid_C_PrevAndNext(
			employeeAddressId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the employee addresses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of employee addresses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee addresses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the employee address where employeeId = &#63; or throws a <code>NoSuchEmployeeAddressException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public static EmployeeAddress findByEmployeeId(long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeAddressException {

		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns the employee address where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public static EmployeeAddress fetchByEmployeeId(long employeeId) {
		return getPersistence().fetchByEmployeeId(employeeId);
	}

	/**
	 * Returns the employee address where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public static EmployeeAddress fetchByEmployeeId(
		long employeeId, boolean useFinderCache) {

		return getPersistence().fetchByEmployeeId(employeeId, useFinderCache);
	}

	/**
	 * Removes the employee address where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the employee address that was removed
	 */
	public static EmployeeAddress removeByEmployeeId(long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeAddressException {

		return getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee addresses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee addresses
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Caches the employee address in the entity cache if it is enabled.
	 *
	 * @param employeeAddress the employee address
	 */
	public static void cacheResult(EmployeeAddress employeeAddress) {
		getPersistence().cacheResult(employeeAddress);
	}

	/**
	 * Caches the employee addresses in the entity cache if it is enabled.
	 *
	 * @param employeeAddresses the employee addresses
	 */
	public static void cacheResult(List<EmployeeAddress> employeeAddresses) {
		getPersistence().cacheResult(employeeAddresses);
	}

	/**
	 * Creates a new employee address with the primary key. Does not add the employee address to the database.
	 *
	 * @param employeeAddressId the primary key for the new employee address
	 * @return the new employee address
	 */
	public static EmployeeAddress create(long employeeAddressId) {
		return getPersistence().create(employeeAddressId);
	}

	/**
	 * Removes the employee address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeAddressId the primary key of the employee address
	 * @return the employee address that was removed
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	public static EmployeeAddress remove(long employeeAddressId)
		throws com.ax.hrms.exception.NoSuchEmployeeAddressException {

		return getPersistence().remove(employeeAddressId);
	}

	public static EmployeeAddress updateImpl(EmployeeAddress employeeAddress) {
		return getPersistence().updateImpl(employeeAddress);
	}

	/**
	 * Returns the employee address with the primary key or throws a <code>NoSuchEmployeeAddressException</code> if it could not be found.
	 *
	 * @param employeeAddressId the primary key of the employee address
	 * @return the employee address
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	public static EmployeeAddress findByPrimaryKey(long employeeAddressId)
		throws com.ax.hrms.exception.NoSuchEmployeeAddressException {

		return getPersistence().findByPrimaryKey(employeeAddressId);
	}

	/**
	 * Returns the employee address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeAddressId the primary key of the employee address
	 * @return the employee address, or <code>null</code> if a employee address with the primary key could not be found
	 */
	public static EmployeeAddress fetchByPrimaryKey(long employeeAddressId) {
		return getPersistence().fetchByPrimaryKey(employeeAddressId);
	}

	/**
	 * Returns all the employee addresses.
	 *
	 * @return the employee addresses
	 */
	public static List<EmployeeAddress> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @return the range of employee addresses
	 */
	public static List<EmployeeAddress> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee addresses
	 */
	public static List<EmployeeAddress> findAll(
		int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee addresses
	 */
	public static List<EmployeeAddress> findAll(
		int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee addresses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee addresses.
	 *
	 * @return the number of employee addresses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeAddressPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(EmployeeAddressPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile EmployeeAddressPersistence _persistence;

}