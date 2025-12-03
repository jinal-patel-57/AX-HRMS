/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.EmployeeDetails;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the employee details service. This utility wraps <code>com.ax.hrms.service.persistence.impl.EmployeeDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetailsPersistence
 * @generated
 */
public class EmployeeDetailsUtil {

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
	public static void clearCache(EmployeeDetails employeeDetails) {
		getPersistence().clearCache(employeeDetails);
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
	public static Map<Serializable, EmployeeDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeDetails update(EmployeeDetails employeeDetails) {
		return getPersistence().update(employeeDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeDetails update(
		EmployeeDetails employeeDetails, ServiceContext serviceContext) {

		return getPersistence().update(employeeDetails, serviceContext);
	}

	/**
	 * Returns all the employee detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee detailses
	 */
	public static List<EmployeeDetails> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the employee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of matching employee detailses
	 */
	public static List<EmployeeDetails> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the employee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee detailses
	 */
	public static List<EmployeeDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee detailses
	 */
	public static List<EmployeeDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public static EmployeeDetails findByUuid_First(
			String uuid, OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public static EmployeeDetails fetchByUuid_First(
		String uuid, OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public static EmployeeDetails findByUuid_Last(
			String uuid, OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public static EmployeeDetails fetchByUuid_Last(
		String uuid, OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the employee detailses before and after the current employee details in the ordered set where uuid = &#63;.
	 *
	 * @param employeeId the primary key of the current employee details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	public static EmployeeDetails[] findByUuid_PrevAndNext(
			long employeeId, String uuid,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByUuid_PrevAndNext(
			employeeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the employee detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of employee detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee detailses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the employee details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public static EmployeeDetails findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public static EmployeeDetails fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public static EmployeeDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the employee details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee details that was removed
	 */
	public static EmployeeDetails removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of employee detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee detailses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee detailses
	 */
	public static List<EmployeeDetails> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of matching employee detailses
	 */
	public static List<EmployeeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee detailses
	 */
	public static List<EmployeeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee detailses
	 */
	public static List<EmployeeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public static EmployeeDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public static EmployeeDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public static EmployeeDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public static EmployeeDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the employee detailses before and after the current employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	public static EmployeeDetails[] findByUuid_C_PrevAndNext(
			long employeeId, String uuid, long companyId,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByUuid_C_PrevAndNext(
			employeeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the employee detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee detailses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the employee details where employeeId = &#63; or throws a <code>NoSuchEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public static EmployeeDetails findByEmployeeId(long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns the employee details where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public static EmployeeDetails fetchByEmployeeId(long employeeId) {
		return getPersistence().fetchByEmployeeId(employeeId);
	}

	/**
	 * Returns the employee details where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public static EmployeeDetails fetchByEmployeeId(
		long employeeId, boolean useFinderCache) {

		return getPersistence().fetchByEmployeeId(employeeId, useFinderCache);
	}

	/**
	 * Removes the employee details where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the employee details that was removed
	 */
	public static EmployeeDetails removeByEmployeeId(long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee detailses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee detailses
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns the employee details where lrUserId = &#63; or throws a <code>NoSuchEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param lrUserId the lr user ID
	 * @return the matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public static EmployeeDetails findByLrUserId(long lrUserId)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByLrUserId(lrUserId);
	}

	/**
	 * Returns the employee details where lrUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param lrUserId the lr user ID
	 * @return the matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public static EmployeeDetails fetchByLrUserId(long lrUserId) {
		return getPersistence().fetchByLrUserId(lrUserId);
	}

	/**
	 * Returns the employee details where lrUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param lrUserId the lr user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public static EmployeeDetails fetchByLrUserId(
		long lrUserId, boolean useFinderCache) {

		return getPersistence().fetchByLrUserId(lrUserId, useFinderCache);
	}

	/**
	 * Removes the employee details where lrUserId = &#63; from the database.
	 *
	 * @param lrUserId the lr user ID
	 * @return the employee details that was removed
	 */
	public static EmployeeDetails removeByLrUserId(long lrUserId)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().removeByLrUserId(lrUserId);
	}

	/**
	 * Returns the number of employee detailses where lrUserId = &#63;.
	 *
	 * @param lrUserId the lr user ID
	 * @return the number of matching employee detailses
	 */
	public static int countByLrUserId(long lrUserId) {
		return getPersistence().countByLrUserId(lrUserId);
	}

	/**
	 * Returns all the employee detailses where leavingDate = &#63;.
	 *
	 * @param leavingDate the leaving date
	 * @return the matching employee detailses
	 */
	public static List<EmployeeDetails> findByLeavingDate(Date leavingDate) {
		return getPersistence().findByLeavingDate(leavingDate);
	}

	/**
	 * Returns a range of all the employee detailses where leavingDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param leavingDate the leaving date
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of matching employee detailses
	 */
	public static List<EmployeeDetails> findByLeavingDate(
		Date leavingDate, int start, int end) {

		return getPersistence().findByLeavingDate(leavingDate, start, end);
	}

	/**
	 * Returns an ordered range of all the employee detailses where leavingDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param leavingDate the leaving date
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee detailses
	 */
	public static List<EmployeeDetails> findByLeavingDate(
		Date leavingDate, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().findByLeavingDate(
			leavingDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee detailses where leavingDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param leavingDate the leaving date
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee detailses
	 */
	public static List<EmployeeDetails> findByLeavingDate(
		Date leavingDate, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLeavingDate(
			leavingDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee details in the ordered set where leavingDate = &#63;.
	 *
	 * @param leavingDate the leaving date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public static EmployeeDetails findByLeavingDate_First(
			Date leavingDate,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByLeavingDate_First(
			leavingDate, orderByComparator);
	}

	/**
	 * Returns the first employee details in the ordered set where leavingDate = &#63;.
	 *
	 * @param leavingDate the leaving date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public static EmployeeDetails fetchByLeavingDate_First(
		Date leavingDate,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().fetchByLeavingDate_First(
			leavingDate, orderByComparator);
	}

	/**
	 * Returns the last employee details in the ordered set where leavingDate = &#63;.
	 *
	 * @param leavingDate the leaving date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public static EmployeeDetails findByLeavingDate_Last(
			Date leavingDate,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByLeavingDate_Last(
			leavingDate, orderByComparator);
	}

	/**
	 * Returns the last employee details in the ordered set where leavingDate = &#63;.
	 *
	 * @param leavingDate the leaving date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public static EmployeeDetails fetchByLeavingDate_Last(
		Date leavingDate,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().fetchByLeavingDate_Last(
			leavingDate, orderByComparator);
	}

	/**
	 * Returns the employee detailses before and after the current employee details in the ordered set where leavingDate = &#63;.
	 *
	 * @param employeeId the primary key of the current employee details
	 * @param leavingDate the leaving date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	public static EmployeeDetails[] findByLeavingDate_PrevAndNext(
			long employeeId, Date leavingDate,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByLeavingDate_PrevAndNext(
			employeeId, leavingDate, orderByComparator);
	}

	/**
	 * Removes all the employee detailses where leavingDate = &#63; from the database.
	 *
	 * @param leavingDate the leaving date
	 */
	public static void removeByLeavingDate(Date leavingDate) {
		getPersistence().removeByLeavingDate(leavingDate);
	}

	/**
	 * Returns the number of employee detailses where leavingDate = &#63;.
	 *
	 * @param leavingDate the leaving date
	 * @return the number of matching employee detailses
	 */
	public static int countByLeavingDate(Date leavingDate) {
		return getPersistence().countByLeavingDate(leavingDate);
	}

	/**
	 * Returns all the employee detailses where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @return the matching employee detailses
	 */
	public static List<EmployeeDetails> findByEmployeeName(
		String firstName, String lastName) {

		return getPersistence().findByEmployeeName(firstName, lastName);
	}

	/**
	 * Returns a range of all the employee detailses where firstName = &#63; and lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of matching employee detailses
	 */
	public static List<EmployeeDetails> findByEmployeeName(
		String firstName, String lastName, int start, int end) {

		return getPersistence().findByEmployeeName(
			firstName, lastName, start, end);
	}

	/**
	 * Returns an ordered range of all the employee detailses where firstName = &#63; and lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee detailses
	 */
	public static List<EmployeeDetails> findByEmployeeName(
		String firstName, String lastName, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().findByEmployeeName(
			firstName, lastName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee detailses where firstName = &#63; and lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee detailses
	 */
	public static List<EmployeeDetails> findByEmployeeName(
		String firstName, String lastName, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeName(
			firstName, lastName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee details in the ordered set where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public static EmployeeDetails findByEmployeeName_First(
			String firstName, String lastName,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByEmployeeName_First(
			firstName, lastName, orderByComparator);
	}

	/**
	 * Returns the first employee details in the ordered set where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public static EmployeeDetails fetchByEmployeeName_First(
		String firstName, String lastName,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().fetchByEmployeeName_First(
			firstName, lastName, orderByComparator);
	}

	/**
	 * Returns the last employee details in the ordered set where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public static EmployeeDetails findByEmployeeName_Last(
			String firstName, String lastName,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByEmployeeName_Last(
			firstName, lastName, orderByComparator);
	}

	/**
	 * Returns the last employee details in the ordered set where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public static EmployeeDetails fetchByEmployeeName_Last(
		String firstName, String lastName,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().fetchByEmployeeName_Last(
			firstName, lastName, orderByComparator);
	}

	/**
	 * Returns the employee detailses before and after the current employee details in the ordered set where firstName = &#63; and lastName = &#63;.
	 *
	 * @param employeeId the primary key of the current employee details
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	public static EmployeeDetails[] findByEmployeeName_PrevAndNext(
			long employeeId, String firstName, String lastName,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByEmployeeName_PrevAndNext(
			employeeId, firstName, lastName, orderByComparator);
	}

	/**
	 * Removes all the employee detailses where firstName = &#63; and lastName = &#63; from the database.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 */
	public static void removeByEmployeeName(String firstName, String lastName) {
		getPersistence().removeByEmployeeName(firstName, lastName);
	}

	/**
	 * Returns the number of employee detailses where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @return the number of matching employee detailses
	 */
	public static int countByEmployeeName(String firstName, String lastName) {
		return getPersistence().countByEmployeeName(firstName, lastName);
	}

	/**
	 * Returns all the employee detailses where isTerminated = &#63;.
	 *
	 * @param isTerminated the is terminated
	 * @return the matching employee detailses
	 */
	public static List<EmployeeDetails> findByIsTerminated(
		boolean isTerminated) {

		return getPersistence().findByIsTerminated(isTerminated);
	}

	/**
	 * Returns a range of all the employee detailses where isTerminated = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param isTerminated the is terminated
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of matching employee detailses
	 */
	public static List<EmployeeDetails> findByIsTerminated(
		boolean isTerminated, int start, int end) {

		return getPersistence().findByIsTerminated(isTerminated, start, end);
	}

	/**
	 * Returns an ordered range of all the employee detailses where isTerminated = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param isTerminated the is terminated
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee detailses
	 */
	public static List<EmployeeDetails> findByIsTerminated(
		boolean isTerminated, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().findByIsTerminated(
			isTerminated, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee detailses where isTerminated = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param isTerminated the is terminated
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee detailses
	 */
	public static List<EmployeeDetails> findByIsTerminated(
		boolean isTerminated, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByIsTerminated(
			isTerminated, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee details in the ordered set where isTerminated = &#63;.
	 *
	 * @param isTerminated the is terminated
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public static EmployeeDetails findByIsTerminated_First(
			boolean isTerminated,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByIsTerminated_First(
			isTerminated, orderByComparator);
	}

	/**
	 * Returns the first employee details in the ordered set where isTerminated = &#63;.
	 *
	 * @param isTerminated the is terminated
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public static EmployeeDetails fetchByIsTerminated_First(
		boolean isTerminated,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().fetchByIsTerminated_First(
			isTerminated, orderByComparator);
	}

	/**
	 * Returns the last employee details in the ordered set where isTerminated = &#63;.
	 *
	 * @param isTerminated the is terminated
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public static EmployeeDetails findByIsTerminated_Last(
			boolean isTerminated,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByIsTerminated_Last(
			isTerminated, orderByComparator);
	}

	/**
	 * Returns the last employee details in the ordered set where isTerminated = &#63;.
	 *
	 * @param isTerminated the is terminated
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public static EmployeeDetails fetchByIsTerminated_Last(
		boolean isTerminated,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().fetchByIsTerminated_Last(
			isTerminated, orderByComparator);
	}

	/**
	 * Returns the employee detailses before and after the current employee details in the ordered set where isTerminated = &#63;.
	 *
	 * @param employeeId the primary key of the current employee details
	 * @param isTerminated the is terminated
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	public static EmployeeDetails[] findByIsTerminated_PrevAndNext(
			long employeeId, boolean isTerminated,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByIsTerminated_PrevAndNext(
			employeeId, isTerminated, orderByComparator);
	}

	/**
	 * Removes all the employee detailses where isTerminated = &#63; from the database.
	 *
	 * @param isTerminated the is terminated
	 */
	public static void removeByIsTerminated(boolean isTerminated) {
		getPersistence().removeByIsTerminated(isTerminated);
	}

	/**
	 * Returns the number of employee detailses where isTerminated = &#63;.
	 *
	 * @param isTerminated the is terminated
	 * @return the number of matching employee detailses
	 */
	public static int countByIsTerminated(boolean isTerminated) {
		return getPersistence().countByIsTerminated(isTerminated);
	}

	/**
	 * Caches the employee details in the entity cache if it is enabled.
	 *
	 * @param employeeDetails the employee details
	 */
	public static void cacheResult(EmployeeDetails employeeDetails) {
		getPersistence().cacheResult(employeeDetails);
	}

	/**
	 * Caches the employee detailses in the entity cache if it is enabled.
	 *
	 * @param employeeDetailses the employee detailses
	 */
	public static void cacheResult(List<EmployeeDetails> employeeDetailses) {
		getPersistence().cacheResult(employeeDetailses);
	}

	/**
	 * Creates a new employee details with the primary key. Does not add the employee details to the database.
	 *
	 * @param employeeId the primary key for the new employee details
	 * @return the new employee details
	 */
	public static EmployeeDetails create(long employeeId) {
		return getPersistence().create(employeeId);
	}

	/**
	 * Removes the employee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeId the primary key of the employee details
	 * @return the employee details that was removed
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	public static EmployeeDetails remove(long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().remove(employeeId);
	}

	public static EmployeeDetails updateImpl(EmployeeDetails employeeDetails) {
		return getPersistence().updateImpl(employeeDetails);
	}

	/**
	 * Returns the employee details with the primary key or throws a <code>NoSuchEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee details
	 * @return the employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	public static EmployeeDetails findByPrimaryKey(long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByPrimaryKey(employeeId);
	}

	/**
	 * Returns the employee details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee details
	 * @return the employee details, or <code>null</code> if a employee details with the primary key could not be found
	 */
	public static EmployeeDetails fetchByPrimaryKey(long employeeId) {
		return getPersistence().fetchByPrimaryKey(employeeId);
	}

	/**
	 * Returns all the employee detailses.
	 *
	 * @return the employee detailses
	 */
	public static List<EmployeeDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of employee detailses
	 */
	public static List<EmployeeDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee detailses
	 */
	public static List<EmployeeDetails> findAll(
		int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee detailses
	 */
	public static List<EmployeeDetails> findAll(
		int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee detailses.
	 *
	 * @return the number of employee detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeDetailsPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(EmployeeDetailsPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile EmployeeDetailsPersistence _persistence;

}