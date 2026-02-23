/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.WorkFromHomeDayType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the work from home day type service. This utility wraps <code>com.ax.hrms.service.persistence.impl.WorkFromHomeDayTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHomeDayTypePersistence
 * @generated
 */
public class WorkFromHomeDayTypeUtil {

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
	public static void clearCache(WorkFromHomeDayType workFromHomeDayType) {
		getPersistence().clearCache(workFromHomeDayType);
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
	public static Map<Serializable, WorkFromHomeDayType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WorkFromHomeDayType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkFromHomeDayType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkFromHomeDayType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WorkFromHomeDayType update(
		WorkFromHomeDayType workFromHomeDayType) {

		return getPersistence().update(workFromHomeDayType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WorkFromHomeDayType update(
		WorkFromHomeDayType workFromHomeDayType,
		ServiceContext serviceContext) {

		return getPersistence().update(workFromHomeDayType, serviceContext);
	}

	/**
	 * Returns all the work from home day types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching work from home day types
	 */
	public static List<WorkFromHomeDayType> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the work from home day types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @return the range of matching work from home day types
	 */
	public static List<WorkFromHomeDayType> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the work from home day types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home day types
	 */
	public static List<WorkFromHomeDayType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work from home day types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home day types
	 */
	public static List<WorkFromHomeDayType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<WorkFromHomeDayType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work from home day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	public static WorkFromHomeDayType findByUuid_First(
			String uuid,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeDayTypeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first work from home day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	public static WorkFromHomeDayType fetchByUuid_First(
		String uuid, OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last work from home day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	public static WorkFromHomeDayType findByUuid_Last(
			String uuid,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeDayTypeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last work from home day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	public static WorkFromHomeDayType fetchByUuid_Last(
		String uuid, OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the work from home day types before and after the current work from home day type in the ordered set where uuid = &#63;.
	 *
	 * @param workFromHomeDayTypeId the primary key of the current work from home day type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a work from home day type with the primary key could not be found
	 */
	public static WorkFromHomeDayType[] findByUuid_PrevAndNext(
			long workFromHomeDayTypeId, String uuid,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeDayTypeException {

		return getPersistence().findByUuid_PrevAndNext(
			workFromHomeDayTypeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the work from home day types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of work from home day types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching work from home day types
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the work from home day type where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchWorkFromHomeDayTypeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	public static WorkFromHomeDayType findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeDayTypeException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the work from home day type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	public static WorkFromHomeDayType fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the work from home day type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	public static WorkFromHomeDayType fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the work from home day type where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the work from home day type that was removed
	 */
	public static WorkFromHomeDayType removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeDayTypeException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of work from home day types where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching work from home day types
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the work from home day types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching work from home day types
	 */
	public static List<WorkFromHomeDayType> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the work from home day types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @return the range of matching work from home day types
	 */
	public static List<WorkFromHomeDayType> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the work from home day types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home day types
	 */
	public static List<WorkFromHomeDayType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work from home day types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home day types
	 */
	public static List<WorkFromHomeDayType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<WorkFromHomeDayType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work from home day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	public static WorkFromHomeDayType findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeDayTypeException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first work from home day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	public static WorkFromHomeDayType fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last work from home day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	public static WorkFromHomeDayType findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeDayTypeException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last work from home day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	public static WorkFromHomeDayType fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the work from home day types before and after the current work from home day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param workFromHomeDayTypeId the primary key of the current work from home day type
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a work from home day type with the primary key could not be found
	 */
	public static WorkFromHomeDayType[] findByUuid_C_PrevAndNext(
			long workFromHomeDayTypeId, String uuid, long companyId,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeDayTypeException {

		return getPersistence().findByUuid_C_PrevAndNext(
			workFromHomeDayTypeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the work from home day types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of work from home day types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching work from home day types
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the work from home day types where workFromHomeRequestId = &#63;.
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @return the matching work from home day types
	 */
	public static List<WorkFromHomeDayType> findByWorkFromHomeRequestId(
		long workFromHomeRequestId) {

		return getPersistence().findByWorkFromHomeRequestId(
			workFromHomeRequestId);
	}

	/**
	 * Returns a range of all the work from home day types where workFromHomeRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @return the range of matching work from home day types
	 */
	public static List<WorkFromHomeDayType> findByWorkFromHomeRequestId(
		long workFromHomeRequestId, int start, int end) {

		return getPersistence().findByWorkFromHomeRequestId(
			workFromHomeRequestId, start, end);
	}

	/**
	 * Returns an ordered range of all the work from home day types where workFromHomeRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home day types
	 */
	public static List<WorkFromHomeDayType> findByWorkFromHomeRequestId(
		long workFromHomeRequestId, int start, int end,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		return getPersistence().findByWorkFromHomeRequestId(
			workFromHomeRequestId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work from home day types where workFromHomeRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home day types
	 */
	public static List<WorkFromHomeDayType> findByWorkFromHomeRequestId(
		long workFromHomeRequestId, int start, int end,
		OrderByComparator<WorkFromHomeDayType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByWorkFromHomeRequestId(
			workFromHomeRequestId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first work from home day type in the ordered set where workFromHomeRequestId = &#63;.
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	public static WorkFromHomeDayType findByWorkFromHomeRequestId_First(
			long workFromHomeRequestId,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeDayTypeException {

		return getPersistence().findByWorkFromHomeRequestId_First(
			workFromHomeRequestId, orderByComparator);
	}

	/**
	 * Returns the first work from home day type in the ordered set where workFromHomeRequestId = &#63;.
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	public static WorkFromHomeDayType fetchByWorkFromHomeRequestId_First(
		long workFromHomeRequestId,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		return getPersistence().fetchByWorkFromHomeRequestId_First(
			workFromHomeRequestId, orderByComparator);
	}

	/**
	 * Returns the last work from home day type in the ordered set where workFromHomeRequestId = &#63;.
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	public static WorkFromHomeDayType findByWorkFromHomeRequestId_Last(
			long workFromHomeRequestId,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeDayTypeException {

		return getPersistence().findByWorkFromHomeRequestId_Last(
			workFromHomeRequestId, orderByComparator);
	}

	/**
	 * Returns the last work from home day type in the ordered set where workFromHomeRequestId = &#63;.
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	public static WorkFromHomeDayType fetchByWorkFromHomeRequestId_Last(
		long workFromHomeRequestId,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		return getPersistence().fetchByWorkFromHomeRequestId_Last(
			workFromHomeRequestId, orderByComparator);
	}

	/**
	 * Returns the work from home day types before and after the current work from home day type in the ordered set where workFromHomeRequestId = &#63;.
	 *
	 * @param workFromHomeDayTypeId the primary key of the current work from home day type
	 * @param workFromHomeRequestId the work from home request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a work from home day type with the primary key could not be found
	 */
	public static WorkFromHomeDayType[] findByWorkFromHomeRequestId_PrevAndNext(
			long workFromHomeDayTypeId, long workFromHomeRequestId,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeDayTypeException {

		return getPersistence().findByWorkFromHomeRequestId_PrevAndNext(
			workFromHomeDayTypeId, workFromHomeRequestId, orderByComparator);
	}

	/**
	 * Removes all the work from home day types where workFromHomeRequestId = &#63; from the database.
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 */
	public static void removeByWorkFromHomeRequestId(
		long workFromHomeRequestId) {

		getPersistence().removeByWorkFromHomeRequestId(workFromHomeRequestId);
	}

	/**
	 * Returns the number of work from home day types where workFromHomeRequestId = &#63;.
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @return the number of matching work from home day types
	 */
	public static int countByWorkFromHomeRequestId(long workFromHomeRequestId) {
		return getPersistence().countByWorkFromHomeRequestId(
			workFromHomeRequestId);
	}

	/**
	 * Returns all the work from home day types where workFromHomeDate = &#63;.
	 *
	 * @param workFromHomeDate the work from home date
	 * @return the matching work from home day types
	 */
	public static List<WorkFromHomeDayType> findByWorkFromHomeDate(
		Date workFromHomeDate) {

		return getPersistence().findByWorkFromHomeDate(workFromHomeDate);
	}

	/**
	 * Returns a range of all the work from home day types where workFromHomeDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param workFromHomeDate the work from home date
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @return the range of matching work from home day types
	 */
	public static List<WorkFromHomeDayType> findByWorkFromHomeDate(
		Date workFromHomeDate, int start, int end) {

		return getPersistence().findByWorkFromHomeDate(
			workFromHomeDate, start, end);
	}

	/**
	 * Returns an ordered range of all the work from home day types where workFromHomeDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param workFromHomeDate the work from home date
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home day types
	 */
	public static List<WorkFromHomeDayType> findByWorkFromHomeDate(
		Date workFromHomeDate, int start, int end,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		return getPersistence().findByWorkFromHomeDate(
			workFromHomeDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work from home day types where workFromHomeDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param workFromHomeDate the work from home date
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home day types
	 */
	public static List<WorkFromHomeDayType> findByWorkFromHomeDate(
		Date workFromHomeDate, int start, int end,
		OrderByComparator<WorkFromHomeDayType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByWorkFromHomeDate(
			workFromHomeDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work from home day type in the ordered set where workFromHomeDate = &#63;.
	 *
	 * @param workFromHomeDate the work from home date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	public static WorkFromHomeDayType findByWorkFromHomeDate_First(
			Date workFromHomeDate,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeDayTypeException {

		return getPersistence().findByWorkFromHomeDate_First(
			workFromHomeDate, orderByComparator);
	}

	/**
	 * Returns the first work from home day type in the ordered set where workFromHomeDate = &#63;.
	 *
	 * @param workFromHomeDate the work from home date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	public static WorkFromHomeDayType fetchByWorkFromHomeDate_First(
		Date workFromHomeDate,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		return getPersistence().fetchByWorkFromHomeDate_First(
			workFromHomeDate, orderByComparator);
	}

	/**
	 * Returns the last work from home day type in the ordered set where workFromHomeDate = &#63;.
	 *
	 * @param workFromHomeDate the work from home date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	public static WorkFromHomeDayType findByWorkFromHomeDate_Last(
			Date workFromHomeDate,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeDayTypeException {

		return getPersistence().findByWorkFromHomeDate_Last(
			workFromHomeDate, orderByComparator);
	}

	/**
	 * Returns the last work from home day type in the ordered set where workFromHomeDate = &#63;.
	 *
	 * @param workFromHomeDate the work from home date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	public static WorkFromHomeDayType fetchByWorkFromHomeDate_Last(
		Date workFromHomeDate,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		return getPersistence().fetchByWorkFromHomeDate_Last(
			workFromHomeDate, orderByComparator);
	}

	/**
	 * Returns the work from home day types before and after the current work from home day type in the ordered set where workFromHomeDate = &#63;.
	 *
	 * @param workFromHomeDayTypeId the primary key of the current work from home day type
	 * @param workFromHomeDate the work from home date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a work from home day type with the primary key could not be found
	 */
	public static WorkFromHomeDayType[] findByWorkFromHomeDate_PrevAndNext(
			long workFromHomeDayTypeId, Date workFromHomeDate,
			OrderByComparator<WorkFromHomeDayType> orderByComparator)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeDayTypeException {

		return getPersistence().findByWorkFromHomeDate_PrevAndNext(
			workFromHomeDayTypeId, workFromHomeDate, orderByComparator);
	}

	/**
	 * Removes all the work from home day types where workFromHomeDate = &#63; from the database.
	 *
	 * @param workFromHomeDate the work from home date
	 */
	public static void removeByWorkFromHomeDate(Date workFromHomeDate) {
		getPersistence().removeByWorkFromHomeDate(workFromHomeDate);
	}

	/**
	 * Returns the number of work from home day types where workFromHomeDate = &#63;.
	 *
	 * @param workFromHomeDate the work from home date
	 * @return the number of matching work from home day types
	 */
	public static int countByWorkFromHomeDate(Date workFromHomeDate) {
		return getPersistence().countByWorkFromHomeDate(workFromHomeDate);
	}

	/**
	 * Caches the work from home day type in the entity cache if it is enabled.
	 *
	 * @param workFromHomeDayType the work from home day type
	 */
	public static void cacheResult(WorkFromHomeDayType workFromHomeDayType) {
		getPersistence().cacheResult(workFromHomeDayType);
	}

	/**
	 * Caches the work from home day types in the entity cache if it is enabled.
	 *
	 * @param workFromHomeDayTypes the work from home day types
	 */
	public static void cacheResult(
		List<WorkFromHomeDayType> workFromHomeDayTypes) {

		getPersistence().cacheResult(workFromHomeDayTypes);
	}

	/**
	 * Creates a new work from home day type with the primary key. Does not add the work from home day type to the database.
	 *
	 * @param workFromHomeDayTypeId the primary key for the new work from home day type
	 * @return the new work from home day type
	 */
	public static WorkFromHomeDayType create(long workFromHomeDayTypeId) {
		return getPersistence().create(workFromHomeDayTypeId);
	}

	/**
	 * Removes the work from home day type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workFromHomeDayTypeId the primary key of the work from home day type
	 * @return the work from home day type that was removed
	 * @throws NoSuchWorkFromHomeDayTypeException if a work from home day type with the primary key could not be found
	 */
	public static WorkFromHomeDayType remove(long workFromHomeDayTypeId)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeDayTypeException {

		return getPersistence().remove(workFromHomeDayTypeId);
	}

	public static WorkFromHomeDayType updateImpl(
		WorkFromHomeDayType workFromHomeDayType) {

		return getPersistence().updateImpl(workFromHomeDayType);
	}

	/**
	 * Returns the work from home day type with the primary key or throws a <code>NoSuchWorkFromHomeDayTypeException</code> if it could not be found.
	 *
	 * @param workFromHomeDayTypeId the primary key of the work from home day type
	 * @return the work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a work from home day type with the primary key could not be found
	 */
	public static WorkFromHomeDayType findByPrimaryKey(
			long workFromHomeDayTypeId)
		throws com.ax.hrms.exception.NoSuchWorkFromHomeDayTypeException {

		return getPersistence().findByPrimaryKey(workFromHomeDayTypeId);
	}

	/**
	 * Returns the work from home day type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workFromHomeDayTypeId the primary key of the work from home day type
	 * @return the work from home day type, or <code>null</code> if a work from home day type with the primary key could not be found
	 */
	public static WorkFromHomeDayType fetchByPrimaryKey(
		long workFromHomeDayTypeId) {

		return getPersistence().fetchByPrimaryKey(workFromHomeDayTypeId);
	}

	/**
	 * Returns all the work from home day types.
	 *
	 * @return the work from home day types
	 */
	public static List<WorkFromHomeDayType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the work from home day types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @return the range of work from home day types
	 */
	public static List<WorkFromHomeDayType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the work from home day types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work from home day types
	 */
	public static List<WorkFromHomeDayType> findAll(
		int start, int end,
		OrderByComparator<WorkFromHomeDayType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work from home day types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work from home day types
	 */
	public static List<WorkFromHomeDayType> findAll(
		int start, int end,
		OrderByComparator<WorkFromHomeDayType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the work from home day types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of work from home day types.
	 *
	 * @return the number of work from home day types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WorkFromHomeDayTypePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		WorkFromHomeDayTypePersistence persistence) {

		_persistence = persistence;
	}

	private static volatile WorkFromHomeDayTypePersistence _persistence;

}