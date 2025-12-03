/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.EmployeeProbationDetails;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the employee probation details service. This utility wraps <code>com.ax.hrms.service.persistence.impl.EmployeeProbationDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeProbationDetailsPersistence
 * @generated
 */
public class EmployeeProbationDetailsUtil {

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
	public static void clearCache(
		EmployeeProbationDetails employeeProbationDetails) {

		getPersistence().clearCache(employeeProbationDetails);
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
	public static Map<Serializable, EmployeeProbationDetails>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeProbationDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeProbationDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeProbationDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeProbationDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeProbationDetails update(
		EmployeeProbationDetails employeeProbationDetails) {

		return getPersistence().update(employeeProbationDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeProbationDetails update(
		EmployeeProbationDetails employeeProbationDetails,
		ServiceContext serviceContext) {

		return getPersistence().update(
			employeeProbationDetails, serviceContext);
	}

	/**
	 * Returns all the employee probation detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee probation detailses
	 */
	public static List<EmployeeProbationDetails> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the employee probation detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee probation detailses
	 * @param end the upper bound of the range of employee probation detailses (not inclusive)
	 * @return the range of matching employee probation detailses
	 */
	public static List<EmployeeProbationDetails> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the employee probation detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee probation detailses
	 * @param end the upper bound of the range of employee probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee probation detailses
	 */
	public static List<EmployeeProbationDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeProbationDetails> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee probation detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee probation detailses
	 * @param end the upper bound of the range of employee probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee probation detailses
	 */
	public static List<EmployeeProbationDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeProbationDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee probation details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee probation details
	 * @throws NoSuchEmployeeProbationDetailsException if a matching employee probation details could not be found
	 */
	public static EmployeeProbationDetails findByUuid_First(
			String uuid,
			OrderByComparator<EmployeeProbationDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeProbationDetailsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first employee probation details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee probation details, or <code>null</code> if a matching employee probation details could not be found
	 */
	public static EmployeeProbationDetails fetchByUuid_First(
		String uuid,
		OrderByComparator<EmployeeProbationDetails> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee probation details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee probation details
	 * @throws NoSuchEmployeeProbationDetailsException if a matching employee probation details could not be found
	 */
	public static EmployeeProbationDetails findByUuid_Last(
			String uuid,
			OrderByComparator<EmployeeProbationDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeProbationDetailsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee probation details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee probation details, or <code>null</code> if a matching employee probation details could not be found
	 */
	public static EmployeeProbationDetails fetchByUuid_Last(
		String uuid,
		OrderByComparator<EmployeeProbationDetails> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the employee probation detailses before and after the current employee probation details in the ordered set where uuid = &#63;.
	 *
	 * @param probationDetailId the primary key of the current employee probation details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee probation details
	 * @throws NoSuchEmployeeProbationDetailsException if a employee probation details with the primary key could not be found
	 */
	public static EmployeeProbationDetails[] findByUuid_PrevAndNext(
			long probationDetailId, String uuid,
			OrderByComparator<EmployeeProbationDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeProbationDetailsException {

		return getPersistence().findByUuid_PrevAndNext(
			probationDetailId, uuid, orderByComparator);
	}

	/**
	 * Removes all the employee probation detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of employee probation detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee probation detailses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the employee probation details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeProbationDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee probation details
	 * @throws NoSuchEmployeeProbationDetailsException if a matching employee probation details could not be found
	 */
	public static EmployeeProbationDetails findByUUID_G(
			String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeProbationDetailsException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee probation details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee probation details, or <code>null</code> if a matching employee probation details could not be found
	 */
	public static EmployeeProbationDetails fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee probation details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee probation details, or <code>null</code> if a matching employee probation details could not be found
	 */
	public static EmployeeProbationDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the employee probation details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee probation details that was removed
	 */
	public static EmployeeProbationDetails removeByUUID_G(
			String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeProbationDetailsException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of employee probation detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee probation detailses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the employee probation detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee probation detailses
	 */
	public static List<EmployeeProbationDetails> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the employee probation detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee probation detailses
	 * @param end the upper bound of the range of employee probation detailses (not inclusive)
	 * @return the range of matching employee probation detailses
	 */
	public static List<EmployeeProbationDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee probation detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee probation detailses
	 * @param end the upper bound of the range of employee probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee probation detailses
	 */
	public static List<EmployeeProbationDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeProbationDetails> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee probation detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee probation detailses
	 * @param end the upper bound of the range of employee probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee probation detailses
	 */
	public static List<EmployeeProbationDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeProbationDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee probation details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee probation details
	 * @throws NoSuchEmployeeProbationDetailsException if a matching employee probation details could not be found
	 */
	public static EmployeeProbationDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeProbationDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeProbationDetailsException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first employee probation details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee probation details, or <code>null</code> if a matching employee probation details could not be found
	 */
	public static EmployeeProbationDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeProbationDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee probation details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee probation details
	 * @throws NoSuchEmployeeProbationDetailsException if a matching employee probation details could not be found
	 */
	public static EmployeeProbationDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeProbationDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeProbationDetailsException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee probation details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee probation details, or <code>null</code> if a matching employee probation details could not be found
	 */
	public static EmployeeProbationDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeProbationDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the employee probation detailses before and after the current employee probation details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param probationDetailId the primary key of the current employee probation details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee probation details
	 * @throws NoSuchEmployeeProbationDetailsException if a employee probation details with the primary key could not be found
	 */
	public static EmployeeProbationDetails[] findByUuid_C_PrevAndNext(
			long probationDetailId, String uuid, long companyId,
			OrderByComparator<EmployeeProbationDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeProbationDetailsException {

		return getPersistence().findByUuid_C_PrevAndNext(
			probationDetailId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the employee probation detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of employee probation detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee probation detailses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the employee probation details where employeeId = &#63; or throws a <code>NoSuchEmployeeProbationDetailsException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee probation details
	 * @throws NoSuchEmployeeProbationDetailsException if a matching employee probation details could not be found
	 */
	public static EmployeeProbationDetails findByEmployeeId(long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeProbationDetailsException {

		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns the employee probation details where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee probation details, or <code>null</code> if a matching employee probation details could not be found
	 */
	public static EmployeeProbationDetails fetchByEmployeeId(long employeeId) {
		return getPersistence().fetchByEmployeeId(employeeId);
	}

	/**
	 * Returns the employee probation details where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee probation details, or <code>null</code> if a matching employee probation details could not be found
	 */
	public static EmployeeProbationDetails fetchByEmployeeId(
		long employeeId, boolean useFinderCache) {

		return getPersistence().fetchByEmployeeId(employeeId, useFinderCache);
	}

	/**
	 * Removes the employee probation details where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the employee probation details that was removed
	 */
	public static EmployeeProbationDetails removeByEmployeeId(long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeProbationDetailsException {

		return getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee probation detailses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee probation detailses
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Caches the employee probation details in the entity cache if it is enabled.
	 *
	 * @param employeeProbationDetails the employee probation details
	 */
	public static void cacheResult(
		EmployeeProbationDetails employeeProbationDetails) {

		getPersistence().cacheResult(employeeProbationDetails);
	}

	/**
	 * Caches the employee probation detailses in the entity cache if it is enabled.
	 *
	 * @param employeeProbationDetailses the employee probation detailses
	 */
	public static void cacheResult(
		List<EmployeeProbationDetails> employeeProbationDetailses) {

		getPersistence().cacheResult(employeeProbationDetailses);
	}

	/**
	 * Creates a new employee probation details with the primary key. Does not add the employee probation details to the database.
	 *
	 * @param probationDetailId the primary key for the new employee probation details
	 * @return the new employee probation details
	 */
	public static EmployeeProbationDetails create(long probationDetailId) {
		return getPersistence().create(probationDetailId);
	}

	/**
	 * Removes the employee probation details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param probationDetailId the primary key of the employee probation details
	 * @return the employee probation details that was removed
	 * @throws NoSuchEmployeeProbationDetailsException if a employee probation details with the primary key could not be found
	 */
	public static EmployeeProbationDetails remove(long probationDetailId)
		throws com.ax.hrms.exception.NoSuchEmployeeProbationDetailsException {

		return getPersistence().remove(probationDetailId);
	}

	public static EmployeeProbationDetails updateImpl(
		EmployeeProbationDetails employeeProbationDetails) {

		return getPersistence().updateImpl(employeeProbationDetails);
	}

	/**
	 * Returns the employee probation details with the primary key or throws a <code>NoSuchEmployeeProbationDetailsException</code> if it could not be found.
	 *
	 * @param probationDetailId the primary key of the employee probation details
	 * @return the employee probation details
	 * @throws NoSuchEmployeeProbationDetailsException if a employee probation details with the primary key could not be found
	 */
	public static EmployeeProbationDetails findByPrimaryKey(
			long probationDetailId)
		throws com.ax.hrms.exception.NoSuchEmployeeProbationDetailsException {

		return getPersistence().findByPrimaryKey(probationDetailId);
	}

	/**
	 * Returns the employee probation details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param probationDetailId the primary key of the employee probation details
	 * @return the employee probation details, or <code>null</code> if a employee probation details with the primary key could not be found
	 */
	public static EmployeeProbationDetails fetchByPrimaryKey(
		long probationDetailId) {

		return getPersistence().fetchByPrimaryKey(probationDetailId);
	}

	/**
	 * Returns all the employee probation detailses.
	 *
	 * @return the employee probation detailses
	 */
	public static List<EmployeeProbationDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee probation detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee probation detailses
	 * @param end the upper bound of the range of employee probation detailses (not inclusive)
	 * @return the range of employee probation detailses
	 */
	public static List<EmployeeProbationDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee probation detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee probation detailses
	 * @param end the upper bound of the range of employee probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee probation detailses
	 */
	public static List<EmployeeProbationDetails> findAll(
		int start, int end,
		OrderByComparator<EmployeeProbationDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee probation detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee probation detailses
	 * @param end the upper bound of the range of employee probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee probation detailses
	 */
	public static List<EmployeeProbationDetails> findAll(
		int start, int end,
		OrderByComparator<EmployeeProbationDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee probation detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee probation detailses.
	 *
	 * @return the number of employee probation detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeProbationDetailsPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		EmployeeProbationDetailsPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile EmployeeProbationDetailsPersistence _persistence;

}