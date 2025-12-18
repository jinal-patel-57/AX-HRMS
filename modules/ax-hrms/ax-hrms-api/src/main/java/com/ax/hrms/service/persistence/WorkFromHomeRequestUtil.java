/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.WorkFromHomeRequest;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the work from home request service. This utility wraps <code>com.ax.hrms.service.persistence.impl.WorkFromHomeRequestPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHomeRequestPersistence
 * @generated
 */
public class WorkFromHomeRequestUtil {

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
	public static void clearCache(WorkFromHomeRequest workFromHomeRequest) {
		getPersistence().clearCache(workFromHomeRequest);
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
	public static Map<Serializable, WorkFromHomeRequest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WorkFromHomeRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkFromHomeRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkFromHomeRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WorkFromHomeRequest update(
		WorkFromHomeRequest workFromHomeRequest) {

		return getPersistence().update(workFromHomeRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WorkFromHomeRequest update(
		WorkFromHomeRequest workFromHomeRequest,
		ServiceContext serviceContext) {

		return getPersistence().update(workFromHomeRequest, serviceContext);
	}

	/**
	 * Returns all the work from home requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the work from home requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @return the range of matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the work from home requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work from home requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work from home request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest findByUuid_First(
			String uuid,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeRequestException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first work from home request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest fetchByUuid_First(
		String uuid, OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last work from home request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest findByUuid_Last(
			String uuid,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeRequestException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last work from home request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest fetchByUuid_Last(
		String uuid, OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the work from home requests before and after the current work from home request in the ordered set where uuid = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	public static WorkFromHomeRequest[] findByUuid_PrevAndNext(
			long workFromHomeRequestId, String uuid,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeRequestException {

		return getPersistence().findByUuid_PrevAndNext(
			workFromHomeRequestId, uuid, orderByComparator);
	}

	/**
	 * Removes all the work from home requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of work from home requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching work from home requests
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the work from home request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchWorkFromHomeRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeRequestException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the work from home request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the work from home request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the work from home request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the work from home request that was removed
	 */
	public static WorkFromHomeRequest removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeRequestException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of work from home requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching work from home requests
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the work from home requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the work from home requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @return the range of matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the work from home requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work from home requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work from home request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeRequestException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first work from home request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last work from home request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeRequestException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last work from home request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the work from home requests before and after the current work from home request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	public static WorkFromHomeRequest[] findByUuid_C_PrevAndNext(
			long workFromHomeRequestId, String uuid, long companyId,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeRequestException {

		return getPersistence().findByUuid_C_PrevAndNext(
			workFromHomeRequestId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the work from home requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of work from home requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching work from home requests
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the work from home requests where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the work from home requests where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @return the range of matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the work from home requests where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work from home requests where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work from home request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest findByEmployeeId_First(
			long employeeId,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeRequestException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first work from home request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last work from home request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeRequestException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last work from home request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the work from home requests before and after the current work from home request in the ordered set where employeeId = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home request
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	public static WorkFromHomeRequest[] findByEmployeeId_PrevAndNext(
			long workFromHomeRequestId, long employeeId,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeRequestException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			workFromHomeRequestId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the work from home requests where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of work from home requests where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching work from home requests
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the work from home requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByStatus(long status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the work from home requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @return the range of matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByStatus(
		long status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the work from home requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByStatus(
		long status, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work from home requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByStatus(
		long status, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work from home request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest findByStatus_First(
			long status,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeRequestException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first work from home request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest fetchByStatus_First(
		long status, OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last work from home request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest findByStatus_Last(
			long status,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeRequestException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last work from home request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest fetchByStatus_Last(
		long status, OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the work from home requests before and after the current work from home request in the ordered set where status = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home request
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	public static WorkFromHomeRequest[] findByStatus_PrevAndNext(
			long workFromHomeRequestId, long status,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeRequestException {

		return getPersistence().findByStatus_PrevAndNext(
			workFromHomeRequestId, status, orderByComparator);
	}

	/**
	 * Removes all the work from home requests where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(long status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of work from home requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching work from home requests
	 */
	public static int countByStatus(long status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the work from home requests where employeeId = &#63; and status = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @return the matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByEmployeeIdAndStatus(
		long employeeId, long status) {

		return getPersistence().findByEmployeeIdAndStatus(employeeId, status);
	}

	/**
	 * Returns a range of all the work from home requests where employeeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @return the range of matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByEmployeeIdAndStatus(
		long employeeId, long status, int start, int end) {

		return getPersistence().findByEmployeeIdAndStatus(
			employeeId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the work from home requests where employeeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByEmployeeIdAndStatus(
		long employeeId, long status, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return getPersistence().findByEmployeeIdAndStatus(
			employeeId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work from home requests where employeeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByEmployeeIdAndStatus(
		long employeeId, long status, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeIdAndStatus(
			employeeId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work from home request in the ordered set where employeeId = &#63; and status = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest findByEmployeeIdAndStatus_First(
			long employeeId, long status,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeRequestException {

		return getPersistence().findByEmployeeIdAndStatus_First(
			employeeId, status, orderByComparator);
	}

	/**
	 * Returns the first work from home request in the ordered set where employeeId = &#63; and status = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest fetchByEmployeeIdAndStatus_First(
		long employeeId, long status,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return getPersistence().fetchByEmployeeIdAndStatus_First(
			employeeId, status, orderByComparator);
	}

	/**
	 * Returns the last work from home request in the ordered set where employeeId = &#63; and status = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest findByEmployeeIdAndStatus_Last(
			long employeeId, long status,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeRequestException {

		return getPersistence().findByEmployeeIdAndStatus_Last(
			employeeId, status, orderByComparator);
	}

	/**
	 * Returns the last work from home request in the ordered set where employeeId = &#63; and status = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest fetchByEmployeeIdAndStatus_Last(
		long employeeId, long status,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return getPersistence().fetchByEmployeeIdAndStatus_Last(
			employeeId, status, orderByComparator);
	}

	/**
	 * Returns the work from home requests before and after the current work from home request in the ordered set where employeeId = &#63; and status = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home request
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	public static WorkFromHomeRequest[] findByEmployeeIdAndStatus_PrevAndNext(
			long workFromHomeRequestId, long employeeId, long status,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeRequestException {

		return getPersistence().findByEmployeeIdAndStatus_PrevAndNext(
			workFromHomeRequestId, employeeId, status, orderByComparator);
	}

	/**
	 * Removes all the work from home requests where employeeId = &#63; and status = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 */
	public static void removeByEmployeeIdAndStatus(
		long employeeId, long status) {

		getPersistence().removeByEmployeeIdAndStatus(employeeId, status);
	}

	/**
	 * Returns the number of work from home requests where employeeId = &#63; and status = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @return the number of matching work from home requests
	 */
	public static int countByEmployeeIdAndStatus(long employeeId, long status) {
		return getPersistence().countByEmployeeIdAndStatus(employeeId, status);
	}

	/**
	 * Returns all the work from home requests where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByDateRange(
		Date startDate, Date endDate) {

		return getPersistence().findByDateRange(startDate, endDate);
	}

	/**
	 * Returns a range of all the work from home requests where startDate = &#63; and endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @return the range of matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByDateRange(
		Date startDate, Date endDate, int start, int end) {

		return getPersistence().findByDateRange(startDate, endDate, start, end);
	}

	/**
	 * Returns an ordered range of all the work from home requests where startDate = &#63; and endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByDateRange(
		Date startDate, Date endDate, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return getPersistence().findByDateRange(
			startDate, endDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work from home requests where startDate = &#63; and endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home requests
	 */
	public static List<WorkFromHomeRequest> findByDateRange(
		Date startDate, Date endDate, int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDateRange(
			startDate, endDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work from home request in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest findByDateRange_First(
			Date startDate, Date endDate,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeRequestException {

		return getPersistence().findByDateRange_First(
			startDate, endDate, orderByComparator);
	}

	/**
	 * Returns the first work from home request in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest fetchByDateRange_First(
		Date startDate, Date endDate,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return getPersistence().fetchByDateRange_First(
			startDate, endDate, orderByComparator);
	}

	/**
	 * Returns the last work from home request in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest findByDateRange_Last(
			Date startDate, Date endDate,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeRequestException {

		return getPersistence().findByDateRange_Last(
			startDate, endDate, orderByComparator);
	}

	/**
	 * Returns the last work from home request in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public static WorkFromHomeRequest fetchByDateRange_Last(
		Date startDate, Date endDate,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return getPersistence().fetchByDateRange_Last(
			startDate, endDate, orderByComparator);
	}

	/**
	 * Returns the work from home requests before and after the current work from home request in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home request
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	public static WorkFromHomeRequest[] findByDateRange_PrevAndNext(
			long workFromHomeRequestId, Date startDate, Date endDate,
			OrderByComparator<WorkFromHomeRequest> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeRequestException {

		return getPersistence().findByDateRange_PrevAndNext(
			workFromHomeRequestId, startDate, endDate, orderByComparator);
	}

	/**
	 * Removes all the work from home requests where startDate = &#63; and endDate = &#63; from the database.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 */
	public static void removeByDateRange(Date startDate, Date endDate) {
		getPersistence().removeByDateRange(startDate, endDate);
	}

	/**
	 * Returns the number of work from home requests where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the number of matching work from home requests
	 */
	public static int countByDateRange(Date startDate, Date endDate) {
		return getPersistence().countByDateRange(startDate, endDate);
	}

	/**
	 * Caches the work from home request in the entity cache if it is enabled.
	 *
	 * @param workFromHomeRequest the work from home request
	 */
	public static void cacheResult(WorkFromHomeRequest workFromHomeRequest) {
		getPersistence().cacheResult(workFromHomeRequest);
	}

	/**
	 * Caches the work from home requests in the entity cache if it is enabled.
	 *
	 * @param workFromHomeRequests the work from home requests
	 */
	public static void cacheResult(
		List<WorkFromHomeRequest> workFromHomeRequests) {

		getPersistence().cacheResult(workFromHomeRequests);
	}

	/**
	 * Creates a new work from home request with the primary key. Does not add the work from home request to the database.
	 *
	 * @param workFromHomeRequestId the primary key for the new work from home request
	 * @return the new work from home request
	 */
	public static WorkFromHomeRequest create(long workFromHomeRequestId) {
		return getPersistence().create(workFromHomeRequestId);
	}

	/**
	 * Removes the work from home request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workFromHomeRequestId the primary key of the work from home request
	 * @return the work from home request that was removed
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	public static WorkFromHomeRequest remove(long workFromHomeRequestId)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeRequestException {

		return getPersistence().remove(workFromHomeRequestId);
	}

	public static WorkFromHomeRequest updateImpl(
		WorkFromHomeRequest workFromHomeRequest) {

		return getPersistence().updateImpl(workFromHomeRequest);
	}

	/**
	 * Returns the work from home request with the primary key or throws a <code>NoSuchWorkFromHomeRequestException</code> if it could not be found.
	 *
	 * @param workFromHomeRequestId the primary key of the work from home request
	 * @return the work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	public static WorkFromHomeRequest findByPrimaryKey(
			long workFromHomeRequestId)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeRequestException {

		return getPersistence().findByPrimaryKey(workFromHomeRequestId);
	}

	/**
	 * Returns the work from home request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workFromHomeRequestId the primary key of the work from home request
	 * @return the work from home request, or <code>null</code> if a work from home request with the primary key could not be found
	 */
	public static WorkFromHomeRequest fetchByPrimaryKey(
		long workFromHomeRequestId) {

		return getPersistence().fetchByPrimaryKey(workFromHomeRequestId);
	}

	/**
	 * Returns all the work from home requests.
	 *
	 * @return the work from home requests
	 */
	public static List<WorkFromHomeRequest> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the work from home requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @return the range of work from home requests
	 */
	public static List<WorkFromHomeRequest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the work from home requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work from home requests
	 */
	public static List<WorkFromHomeRequest> findAll(
		int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work from home requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work from home requests
	 */
	public static List<WorkFromHomeRequest> findAll(
		int start, int end,
		OrderByComparator<WorkFromHomeRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the work from home requests from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of work from home requests.
	 *
	 * @return the number of work from home requests
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WorkFromHomeRequestPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		WorkFromHomeRequestPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile WorkFromHomeRequestPersistence _persistence;

}