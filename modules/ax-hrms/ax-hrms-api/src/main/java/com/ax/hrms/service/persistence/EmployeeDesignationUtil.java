/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.EmployeeDesignation;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the employee designation service. This utility wraps <code>com.ax.hrms.service.persistence.impl.EmployeeDesignationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDesignationPersistence
 * @generated
 */
public class EmployeeDesignationUtil {

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
	public static void clearCache(EmployeeDesignation employeeDesignation) {
		getPersistence().clearCache(employeeDesignation);
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
	public static Map<Serializable, EmployeeDesignation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeDesignation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeDesignation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeDesignation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeDesignation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeDesignation update(
		EmployeeDesignation employeeDesignation) {

		return getPersistence().update(employeeDesignation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeDesignation update(
		EmployeeDesignation employeeDesignation,
		ServiceContext serviceContext) {

		return getPersistence().update(employeeDesignation, serviceContext);
	}

	/**
	 * Returns all the employee designations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee designations
	 */
	public static List<EmployeeDesignation> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the employee designations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @return the range of matching employee designations
	 */
	public static List<EmployeeDesignation> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the employee designations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee designations
	 */
	public static List<EmployeeDesignation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeDesignation> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee designations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee designations
	 */
	public static List<EmployeeDesignation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeDesignation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee designation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee designation
	 * @throws NoSuchEmployeeDesignationException if a matching employee designation could not be found
	 */
	public static EmployeeDesignation findByUuid_First(
			String uuid,
			OrderByComparator<EmployeeDesignation> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDesignationException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first employee designation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee designation, or <code>null</code> if a matching employee designation could not be found
	 */
	public static EmployeeDesignation fetchByUuid_First(
		String uuid, OrderByComparator<EmployeeDesignation> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee designation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee designation
	 * @throws NoSuchEmployeeDesignationException if a matching employee designation could not be found
	 */
	public static EmployeeDesignation findByUuid_Last(
			String uuid,
			OrderByComparator<EmployeeDesignation> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDesignationException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee designation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee designation, or <code>null</code> if a matching employee designation could not be found
	 */
	public static EmployeeDesignation fetchByUuid_Last(
		String uuid, OrderByComparator<EmployeeDesignation> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the employee designations before and after the current employee designation in the ordered set where uuid = &#63;.
	 *
	 * @param employeeDesignationId the primary key of the current employee designation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee designation
	 * @throws NoSuchEmployeeDesignationException if a employee designation with the primary key could not be found
	 */
	public static EmployeeDesignation[] findByUuid_PrevAndNext(
			long employeeDesignationId, String uuid,
			OrderByComparator<EmployeeDesignation> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDesignationException {

		return getPersistence().findByUuid_PrevAndNext(
			employeeDesignationId, uuid, orderByComparator);
	}

	/**
	 * Removes all the employee designations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of employee designations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee designations
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the employee designation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeDesignationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee designation
	 * @throws NoSuchEmployeeDesignationException if a matching employee designation could not be found
	 */
	public static EmployeeDesignation findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeDesignationException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee designation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee designation, or <code>null</code> if a matching employee designation could not be found
	 */
	public static EmployeeDesignation fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee designation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee designation, or <code>null</code> if a matching employee designation could not be found
	 */
	public static EmployeeDesignation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the employee designation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee designation that was removed
	 */
	public static EmployeeDesignation removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeDesignationException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of employee designations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee designations
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the employee designations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee designations
	 */
	public static List<EmployeeDesignation> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the employee designations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @return the range of matching employee designations
	 */
	public static List<EmployeeDesignation> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee designations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee designations
	 */
	public static List<EmployeeDesignation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeDesignation> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee designations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee designations
	 */
	public static List<EmployeeDesignation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeDesignation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee designation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee designation
	 * @throws NoSuchEmployeeDesignationException if a matching employee designation could not be found
	 */
	public static EmployeeDesignation findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeDesignation> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDesignationException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first employee designation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee designation, or <code>null</code> if a matching employee designation could not be found
	 */
	public static EmployeeDesignation fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeDesignation> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee designation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee designation
	 * @throws NoSuchEmployeeDesignationException if a matching employee designation could not be found
	 */
	public static EmployeeDesignation findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeDesignation> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDesignationException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee designation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee designation, or <code>null</code> if a matching employee designation could not be found
	 */
	public static EmployeeDesignation fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeDesignation> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the employee designations before and after the current employee designation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeeDesignationId the primary key of the current employee designation
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee designation
	 * @throws NoSuchEmployeeDesignationException if a employee designation with the primary key could not be found
	 */
	public static EmployeeDesignation[] findByUuid_C_PrevAndNext(
			long employeeDesignationId, String uuid, long companyId,
			OrderByComparator<EmployeeDesignation> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDesignationException {

		return getPersistence().findByUuid_C_PrevAndNext(
			employeeDesignationId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the employee designations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of employee designations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee designations
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the employee designation where employeeId = &#63; or throws a <code>NoSuchEmployeeDesignationException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee designation
	 * @throws NoSuchEmployeeDesignationException if a matching employee designation could not be found
	 */
	public static EmployeeDesignation findByEmployeeId(long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeDesignationException {

		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns the employee designation where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee designation, or <code>null</code> if a matching employee designation could not be found
	 */
	public static EmployeeDesignation fetchByEmployeeId(long employeeId) {
		return getPersistence().fetchByEmployeeId(employeeId);
	}

	/**
	 * Returns the employee designation where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee designation, or <code>null</code> if a matching employee designation could not be found
	 */
	public static EmployeeDesignation fetchByEmployeeId(
		long employeeId, boolean useFinderCache) {

		return getPersistence().fetchByEmployeeId(employeeId, useFinderCache);
	}

	/**
	 * Removes the employee designation where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the employee designation that was removed
	 */
	public static EmployeeDesignation removeByEmployeeId(long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeDesignationException {

		return getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee designations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee designations
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Caches the employee designation in the entity cache if it is enabled.
	 *
	 * @param employeeDesignation the employee designation
	 */
	public static void cacheResult(EmployeeDesignation employeeDesignation) {
		getPersistence().cacheResult(employeeDesignation);
	}

	/**
	 * Caches the employee designations in the entity cache if it is enabled.
	 *
	 * @param employeeDesignations the employee designations
	 */
	public static void cacheResult(
		List<EmployeeDesignation> employeeDesignations) {

		getPersistence().cacheResult(employeeDesignations);
	}

	/**
	 * Creates a new employee designation with the primary key. Does not add the employee designation to the database.
	 *
	 * @param employeeDesignationId the primary key for the new employee designation
	 * @return the new employee designation
	 */
	public static EmployeeDesignation create(long employeeDesignationId) {
		return getPersistence().create(employeeDesignationId);
	}

	/**
	 * Removes the employee designation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDesignationId the primary key of the employee designation
	 * @return the employee designation that was removed
	 * @throws NoSuchEmployeeDesignationException if a employee designation with the primary key could not be found
	 */
	public static EmployeeDesignation remove(long employeeDesignationId)
		throws com.ax.hrms.exception.NoSuchEmployeeDesignationException {

		return getPersistence().remove(employeeDesignationId);
	}

	public static EmployeeDesignation updateImpl(
		EmployeeDesignation employeeDesignation) {

		return getPersistence().updateImpl(employeeDesignation);
	}

	/**
	 * Returns the employee designation with the primary key or throws a <code>NoSuchEmployeeDesignationException</code> if it could not be found.
	 *
	 * @param employeeDesignationId the primary key of the employee designation
	 * @return the employee designation
	 * @throws NoSuchEmployeeDesignationException if a employee designation with the primary key could not be found
	 */
	public static EmployeeDesignation findByPrimaryKey(
			long employeeDesignationId)
		throws com.ax.hrms.exception.NoSuchEmployeeDesignationException {

		return getPersistence().findByPrimaryKey(employeeDesignationId);
	}

	/**
	 * Returns the employee designation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDesignationId the primary key of the employee designation
	 * @return the employee designation, or <code>null</code> if a employee designation with the primary key could not be found
	 */
	public static EmployeeDesignation fetchByPrimaryKey(
		long employeeDesignationId) {

		return getPersistence().fetchByPrimaryKey(employeeDesignationId);
	}

	/**
	 * Returns all the employee designations.
	 *
	 * @return the employee designations
	 */
	public static List<EmployeeDesignation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @return the range of employee designations
	 */
	public static List<EmployeeDesignation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee designations
	 */
	public static List<EmployeeDesignation> findAll(
		int start, int end,
		OrderByComparator<EmployeeDesignation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee designations
	 */
	public static List<EmployeeDesignation> findAll(
		int start, int end,
		OrderByComparator<EmployeeDesignation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee designations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee designations.
	 *
	 * @return the number of employee designations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeDesignationPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		EmployeeDesignationPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile EmployeeDesignationPersistence _persistence;

}