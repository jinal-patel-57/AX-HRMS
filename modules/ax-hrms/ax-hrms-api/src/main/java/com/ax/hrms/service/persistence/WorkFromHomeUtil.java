/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.WorkFromHome;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the work from home service. This utility wraps <code>com.ax.hrms.service.persistence.impl.WorkFromHomePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHomePersistence
 * @generated
 */
public class WorkFromHomeUtil {

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
	public static void clearCache(WorkFromHome workFromHome) {
		getPersistence().clearCache(workFromHome);
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
	public static Map<Serializable, WorkFromHome> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WorkFromHome> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkFromHome> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkFromHome> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WorkFromHome update(WorkFromHome workFromHome) {
		return getPersistence().update(workFromHome);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WorkFromHome update(
		WorkFromHome workFromHome, ServiceContext serviceContext) {

		return getPersistence().update(workFromHome, serviceContext);
	}

	/**
	 * Returns all the work from homes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching work from homes
	 */
	public static List<WorkFromHome> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the work from homes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of matching work from homes
	 */
	public static List<WorkFromHome> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the work from homes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from homes
	 */
	public static List<WorkFromHome> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work from homes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from homes
	 */
	public static List<WorkFromHome> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work from home in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public static WorkFromHome findByUuid_First(
			String uuid, OrderByComparator<WorkFromHome> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first work from home in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public static WorkFromHome fetchByUuid_First(
		String uuid, OrderByComparator<WorkFromHome> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last work from home in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public static WorkFromHome findByUuid_Last(
			String uuid, OrderByComparator<WorkFromHome> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last work from home in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public static WorkFromHome fetchByUuid_Last(
		String uuid, OrderByComparator<WorkFromHome> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the work from homes before and after the current work from home in the ordered set where uuid = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	public static WorkFromHome[] findByUuid_PrevAndNext(
			long workFromHomeRequestId, String uuid,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeException {

		return getPersistence().findByUuid_PrevAndNext(
			workFromHomeRequestId, uuid, orderByComparator);
	}

	/**
	 * Removes all the work from homes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of work from homes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching work from homes
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the work from home where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchWorkFromHomeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public static WorkFromHome findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the work from home where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public static WorkFromHome fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the work from home where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public static WorkFromHome fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the work from home where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the work from home that was removed
	 */
	public static WorkFromHome removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of work from homes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching work from homes
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the work from homes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching work from homes
	 */
	public static List<WorkFromHome> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the work from homes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of matching work from homes
	 */
	public static List<WorkFromHome> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the work from homes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from homes
	 */
	public static List<WorkFromHome> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work from homes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from homes
	 */
	public static List<WorkFromHome> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work from home in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public static WorkFromHome findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first work from home in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public static WorkFromHome fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<WorkFromHome> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last work from home in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public static WorkFromHome findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last work from home in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public static WorkFromHome fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<WorkFromHome> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the work from homes before and after the current work from home in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	public static WorkFromHome[] findByUuid_C_PrevAndNext(
			long workFromHomeRequestId, String uuid, long companyId,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeException {

		return getPersistence().findByUuid_C_PrevAndNext(
			workFromHomeRequestId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the work from homes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of work from homes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching work from homes
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the work from homes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching work from homes
	 */
	public static List<WorkFromHome> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the work from homes where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of matching work from homes
	 */
	public static List<WorkFromHome> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the work from homes where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from homes
	 */
	public static List<WorkFromHome> findByUserId(
		long userId, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work from homes where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from homes
	 */
	public static List<WorkFromHome> findByUserId(
		long userId, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work from home in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public static WorkFromHome findByUserId_First(
			long userId, OrderByComparator<WorkFromHome> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first work from home in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public static WorkFromHome fetchByUserId_First(
		long userId, OrderByComparator<WorkFromHome> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last work from home in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public static WorkFromHome findByUserId_Last(
			long userId, OrderByComparator<WorkFromHome> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last work from home in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public static WorkFromHome fetchByUserId_Last(
		long userId, OrderByComparator<WorkFromHome> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the work from homes before and after the current work from home in the ordered set where userId = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	public static WorkFromHome[] findByUserId_PrevAndNext(
			long workFromHomeRequestId, long userId,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeException {

		return getPersistence().findByUserId_PrevAndNext(
			workFromHomeRequestId, userId, orderByComparator);
	}

	/**
	 * Removes all the work from homes where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of work from homes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching work from homes
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the work from homes where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching work from homes
	 */
	public static List<WorkFromHome> findByStatus(long status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the work from homes where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of matching work from homes
	 */
	public static List<WorkFromHome> findByStatus(
		long status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the work from homes where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from homes
	 */
	public static List<WorkFromHome> findByStatus(
		long status, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work from homes where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from homes
	 */
	public static List<WorkFromHome> findByStatus(
		long status, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work from home in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public static WorkFromHome findByStatus_First(
			long status, OrderByComparator<WorkFromHome> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first work from home in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public static WorkFromHome fetchByStatus_First(
		long status, OrderByComparator<WorkFromHome> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last work from home in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public static WorkFromHome findByStatus_Last(
			long status, OrderByComparator<WorkFromHome> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last work from home in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public static WorkFromHome fetchByStatus_Last(
		long status, OrderByComparator<WorkFromHome> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the work from homes before and after the current work from home in the ordered set where status = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	public static WorkFromHome[] findByStatus_PrevAndNext(
			long workFromHomeRequestId, long status,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeException {

		return getPersistence().findByStatus_PrevAndNext(
			workFromHomeRequestId, status, orderByComparator);
	}

	/**
	 * Removes all the work from homes where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(long status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of work from homes where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching work from homes
	 */
	public static int countByStatus(long status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the work from homes where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching work from homes
	 */
	public static List<WorkFromHome> findByUserIdAndStatus(
		long userId, long status) {

		return getPersistence().findByUserIdAndStatus(userId, status);
	}

	/**
	 * Returns a range of all the work from homes where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of matching work from homes
	 */
	public static List<WorkFromHome> findByUserIdAndStatus(
		long userId, long status, int start, int end) {

		return getPersistence().findByUserIdAndStatus(
			userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the work from homes where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from homes
	 */
	public static List<WorkFromHome> findByUserIdAndStatus(
		long userId, long status, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator) {

		return getPersistence().findByUserIdAndStatus(
			userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work from homes where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from homes
	 */
	public static List<WorkFromHome> findByUserIdAndStatus(
		long userId, long status, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserIdAndStatus(
			userId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work from home in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public static WorkFromHome findByUserIdAndStatus_First(
			long userId, long status,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeException {

		return getPersistence().findByUserIdAndStatus_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the first work from home in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public static WorkFromHome fetchByUserIdAndStatus_First(
		long userId, long status,
		OrderByComparator<WorkFromHome> orderByComparator) {

		return getPersistence().fetchByUserIdAndStatus_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last work from home in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public static WorkFromHome findByUserIdAndStatus_Last(
			long userId, long status,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeException {

		return getPersistence().findByUserIdAndStatus_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last work from home in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public static WorkFromHome fetchByUserIdAndStatus_Last(
		long userId, long status,
		OrderByComparator<WorkFromHome> orderByComparator) {

		return getPersistence().fetchByUserIdAndStatus_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the work from homes before and after the current work from home in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	public static WorkFromHome[] findByUserIdAndStatus_PrevAndNext(
			long workFromHomeRequestId, long userId, long status,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeException {

		return getPersistence().findByUserIdAndStatus_PrevAndNext(
			workFromHomeRequestId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the work from homes where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByUserIdAndStatus(long userId, long status) {
		getPersistence().removeByUserIdAndStatus(userId, status);
	}

	/**
	 * Returns the number of work from homes where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching work from homes
	 */
	public static int countByUserIdAndStatus(long userId, long status) {
		return getPersistence().countByUserIdAndStatus(userId, status);
	}

	/**
	 * Returns all the work from homes where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the matching work from homes
	 */
	public static List<WorkFromHome> findByDateRange(
		Date startDate, Date endDate) {

		return getPersistence().findByDateRange(startDate, endDate);
	}

	/**
	 * Returns a range of all the work from homes where startDate = &#63; and endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of matching work from homes
	 */
	public static List<WorkFromHome> findByDateRange(
		Date startDate, Date endDate, int start, int end) {

		return getPersistence().findByDateRange(startDate, endDate, start, end);
	}

	/**
	 * Returns an ordered range of all the work from homes where startDate = &#63; and endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from homes
	 */
	public static List<WorkFromHome> findByDateRange(
		Date startDate, Date endDate, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator) {

		return getPersistence().findByDateRange(
			startDate, endDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work from homes where startDate = &#63; and endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from homes
	 */
	public static List<WorkFromHome> findByDateRange(
		Date startDate, Date endDate, int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDateRange(
			startDate, endDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work from home in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public static WorkFromHome findByDateRange_First(
			Date startDate, Date endDate,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeException {

		return getPersistence().findByDateRange_First(
			startDate, endDate, orderByComparator);
	}

	/**
	 * Returns the first work from home in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public static WorkFromHome fetchByDateRange_First(
		Date startDate, Date endDate,
		OrderByComparator<WorkFromHome> orderByComparator) {

		return getPersistence().fetchByDateRange_First(
			startDate, endDate, orderByComparator);
	}

	/**
	 * Returns the last work from home in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public static WorkFromHome findByDateRange_Last(
			Date startDate, Date endDate,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeException {

		return getPersistence().findByDateRange_Last(
			startDate, endDate, orderByComparator);
	}

	/**
	 * Returns the last work from home in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public static WorkFromHome fetchByDateRange_Last(
		Date startDate, Date endDate,
		OrderByComparator<WorkFromHome> orderByComparator) {

		return getPersistence().fetchByDateRange_Last(
			startDate, endDate, orderByComparator);
	}

	/**
	 * Returns the work from homes before and after the current work from home in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	public static WorkFromHome[] findByDateRange_PrevAndNext(
			long workFromHomeRequestId, Date startDate, Date endDate,
			OrderByComparator<WorkFromHome> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeException {

		return getPersistence().findByDateRange_PrevAndNext(
			workFromHomeRequestId, startDate, endDate, orderByComparator);
	}

	/**
	 * Removes all the work from homes where startDate = &#63; and endDate = &#63; from the database.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 */
	public static void removeByDateRange(Date startDate, Date endDate) {
		getPersistence().removeByDateRange(startDate, endDate);
	}

	/**
	 * Returns the number of work from homes where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the number of matching work from homes
	 */
	public static int countByDateRange(Date startDate, Date endDate) {
		return getPersistence().countByDateRange(startDate, endDate);
	}

	/**
	 * Caches the work from home in the entity cache if it is enabled.
	 *
	 * @param workFromHome the work from home
	 */
	public static void cacheResult(WorkFromHome workFromHome) {
		getPersistence().cacheResult(workFromHome);
	}

	/**
	 * Caches the work from homes in the entity cache if it is enabled.
	 *
	 * @param workFromHomes the work from homes
	 */
	public static void cacheResult(List<WorkFromHome> workFromHomes) {
		getPersistence().cacheResult(workFromHomes);
	}

	/**
	 * Creates a new work from home with the primary key. Does not add the work from home to the database.
	 *
	 * @param workFromHomeRequestId the primary key for the new work from home
	 * @return the new work from home
	 */
	public static WorkFromHome create(long workFromHomeRequestId) {
		return getPersistence().create(workFromHomeRequestId);
	}

	/**
	 * Removes the work from home with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workFromHomeRequestId the primary key of the work from home
	 * @return the work from home that was removed
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	public static WorkFromHome remove(long workFromHomeRequestId)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeException {

		return getPersistence().remove(workFromHomeRequestId);
	}

	public static WorkFromHome updateImpl(WorkFromHome workFromHome) {
		return getPersistence().updateImpl(workFromHome);
	}

	/**
	 * Returns the work from home with the primary key or throws a <code>NoSuchWorkFromHomeException</code> if it could not be found.
	 *
	 * @param workFromHomeRequestId the primary key of the work from home
	 * @return the work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	public static WorkFromHome findByPrimaryKey(long workFromHomeRequestId)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeException {

		return getPersistence().findByPrimaryKey(workFromHomeRequestId);
	}

	/**
	 * Returns the work from home with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workFromHomeRequestId the primary key of the work from home
	 * @return the work from home, or <code>null</code> if a work from home with the primary key could not be found
	 */
	public static WorkFromHome fetchByPrimaryKey(long workFromHomeRequestId) {
		return getPersistence().fetchByPrimaryKey(workFromHomeRequestId);
	}

	/**
	 * Returns all the work from homes.
	 *
	 * @return the work from homes
	 */
	public static List<WorkFromHome> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the work from homes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of work from homes
	 */
	public static List<WorkFromHome> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the work from homes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work from homes
	 */
	public static List<WorkFromHome> findAll(
		int start, int end, OrderByComparator<WorkFromHome> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work from homes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work from homes
	 */
	public static List<WorkFromHome> findAll(
		int start, int end, OrderByComparator<WorkFromHome> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the work from homes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of work from homes.
	 *
	 * @return the number of work from homes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WorkFromHomePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(WorkFromHomePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile WorkFromHomePersistence _persistence;

}