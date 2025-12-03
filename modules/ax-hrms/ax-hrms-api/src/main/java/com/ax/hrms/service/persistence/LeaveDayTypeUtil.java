/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.LeaveDayType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the leave day type service. This utility wraps <code>com.ax.hrms.service.persistence.impl.LeaveDayTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveDayTypePersistence
 * @generated
 */
public class LeaveDayTypeUtil {

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
	public static void clearCache(LeaveDayType leaveDayType) {
		getPersistence().clearCache(leaveDayType);
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
	public static Map<Serializable, LeaveDayType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LeaveDayType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LeaveDayType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LeaveDayType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LeaveDayType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LeaveDayType update(LeaveDayType leaveDayType) {
		return getPersistence().update(leaveDayType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LeaveDayType update(
		LeaveDayType leaveDayType, ServiceContext serviceContext) {

		return getPersistence().update(leaveDayType, serviceContext);
	}

	/**
	 * Returns all the leave day types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave day types
	 */
	public static List<LeaveDayType> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the leave day types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @return the range of matching leave day types
	 */
	public static List<LeaveDayType> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the leave day types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave day types
	 */
	public static List<LeaveDayType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveDayType> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave day types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave day types
	 */
	public static List<LeaveDayType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveDayType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave day type
	 * @throws NoSuchLeaveDayTypeException if a matching leave day type could not be found
	 */
	public static LeaveDayType findByUuid_First(
			String uuid, OrderByComparator<LeaveDayType> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveDayTypeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first leave day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	public static LeaveDayType fetchByUuid_First(
		String uuid, OrderByComparator<LeaveDayType> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last leave day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave day type
	 * @throws NoSuchLeaveDayTypeException if a matching leave day type could not be found
	 */
	public static LeaveDayType findByUuid_Last(
			String uuid, OrderByComparator<LeaveDayType> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveDayTypeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last leave day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	public static LeaveDayType fetchByUuid_Last(
		String uuid, OrderByComparator<LeaveDayType> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the leave day types before and after the current leave day type in the ordered set where uuid = &#63;.
	 *
	 * @param leaveDayTypeId the primary key of the current leave day type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave day type
	 * @throws NoSuchLeaveDayTypeException if a leave day type with the primary key could not be found
	 */
	public static LeaveDayType[] findByUuid_PrevAndNext(
			long leaveDayTypeId, String uuid,
			OrderByComparator<LeaveDayType> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveDayTypeException {

		return getPersistence().findByUuid_PrevAndNext(
			leaveDayTypeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the leave day types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of leave day types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave day types
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the leave day type where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveDayTypeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave day type
	 * @throws NoSuchLeaveDayTypeException if a matching leave day type could not be found
	 */
	public static LeaveDayType findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchLeaveDayTypeException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the leave day type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	public static LeaveDayType fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the leave day type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	public static LeaveDayType fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the leave day type where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave day type that was removed
	 */
	public static LeaveDayType removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchLeaveDayTypeException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of leave day types where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave day types
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the leave day types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave day types
	 */
	public static List<LeaveDayType> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the leave day types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @return the range of matching leave day types
	 */
	public static List<LeaveDayType> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the leave day types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave day types
	 */
	public static List<LeaveDayType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveDayType> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave day types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave day types
	 */
	public static List<LeaveDayType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveDayType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave day type
	 * @throws NoSuchLeaveDayTypeException if a matching leave day type could not be found
	 */
	public static LeaveDayType findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LeaveDayType> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveDayTypeException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first leave day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	public static LeaveDayType fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LeaveDayType> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last leave day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave day type
	 * @throws NoSuchLeaveDayTypeException if a matching leave day type could not be found
	 */
	public static LeaveDayType findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LeaveDayType> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveDayTypeException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last leave day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	public static LeaveDayType fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LeaveDayType> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the leave day types before and after the current leave day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveDayTypeId the primary key of the current leave day type
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave day type
	 * @throws NoSuchLeaveDayTypeException if a leave day type with the primary key could not be found
	 */
	public static LeaveDayType[] findByUuid_C_PrevAndNext(
			long leaveDayTypeId, String uuid, long companyId,
			OrderByComparator<LeaveDayType> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveDayTypeException {

		return getPersistence().findByUuid_C_PrevAndNext(
			leaveDayTypeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the leave day types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of leave day types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave day types
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the leave day types where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @return the matching leave day types
	 */
	public static List<LeaveDayType> findByLeaveRequestId(long leaveRequestId) {
		return getPersistence().findByLeaveRequestId(leaveRequestId);
	}

	/**
	 * Returns a range of all the leave day types where leaveRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param leaveRequestId the leave request ID
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @return the range of matching leave day types
	 */
	public static List<LeaveDayType> findByLeaveRequestId(
		long leaveRequestId, int start, int end) {

		return getPersistence().findByLeaveRequestId(
			leaveRequestId, start, end);
	}

	/**
	 * Returns an ordered range of all the leave day types where leaveRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param leaveRequestId the leave request ID
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave day types
	 */
	public static List<LeaveDayType> findByLeaveRequestId(
		long leaveRequestId, int start, int end,
		OrderByComparator<LeaveDayType> orderByComparator) {

		return getPersistence().findByLeaveRequestId(
			leaveRequestId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave day types where leaveRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param leaveRequestId the leave request ID
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave day types
	 */
	public static List<LeaveDayType> findByLeaveRequestId(
		long leaveRequestId, int start, int end,
		OrderByComparator<LeaveDayType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLeaveRequestId(
			leaveRequestId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave day type in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave day type
	 * @throws NoSuchLeaveDayTypeException if a matching leave day type could not be found
	 */
	public static LeaveDayType findByLeaveRequestId_First(
			long leaveRequestId,
			OrderByComparator<LeaveDayType> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveDayTypeException {

		return getPersistence().findByLeaveRequestId_First(
			leaveRequestId, orderByComparator);
	}

	/**
	 * Returns the first leave day type in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	public static LeaveDayType fetchByLeaveRequestId_First(
		long leaveRequestId,
		OrderByComparator<LeaveDayType> orderByComparator) {

		return getPersistence().fetchByLeaveRequestId_First(
			leaveRequestId, orderByComparator);
	}

	/**
	 * Returns the last leave day type in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave day type
	 * @throws NoSuchLeaveDayTypeException if a matching leave day type could not be found
	 */
	public static LeaveDayType findByLeaveRequestId_Last(
			long leaveRequestId,
			OrderByComparator<LeaveDayType> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveDayTypeException {

		return getPersistence().findByLeaveRequestId_Last(
			leaveRequestId, orderByComparator);
	}

	/**
	 * Returns the last leave day type in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	public static LeaveDayType fetchByLeaveRequestId_Last(
		long leaveRequestId,
		OrderByComparator<LeaveDayType> orderByComparator) {

		return getPersistence().fetchByLeaveRequestId_Last(
			leaveRequestId, orderByComparator);
	}

	/**
	 * Returns the leave day types before and after the current leave day type in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveDayTypeId the primary key of the current leave day type
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave day type
	 * @throws NoSuchLeaveDayTypeException if a leave day type with the primary key could not be found
	 */
	public static LeaveDayType[] findByLeaveRequestId_PrevAndNext(
			long leaveDayTypeId, long leaveRequestId,
			OrderByComparator<LeaveDayType> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveDayTypeException {

		return getPersistence().findByLeaveRequestId_PrevAndNext(
			leaveDayTypeId, leaveRequestId, orderByComparator);
	}

	/**
	 * Removes all the leave day types where leaveRequestId = &#63; from the database.
	 *
	 * @param leaveRequestId the leave request ID
	 */
	public static void removeByLeaveRequestId(long leaveRequestId) {
		getPersistence().removeByLeaveRequestId(leaveRequestId);
	}

	/**
	 * Returns the number of leave day types where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @return the number of matching leave day types
	 */
	public static int countByLeaveRequestId(long leaveRequestId) {
		return getPersistence().countByLeaveRequestId(leaveRequestId);
	}

	/**
	 * Caches the leave day type in the entity cache if it is enabled.
	 *
	 * @param leaveDayType the leave day type
	 */
	public static void cacheResult(LeaveDayType leaveDayType) {
		getPersistence().cacheResult(leaveDayType);
	}

	/**
	 * Caches the leave day types in the entity cache if it is enabled.
	 *
	 * @param leaveDayTypes the leave day types
	 */
	public static void cacheResult(List<LeaveDayType> leaveDayTypes) {
		getPersistence().cacheResult(leaveDayTypes);
	}

	/**
	 * Creates a new leave day type with the primary key. Does not add the leave day type to the database.
	 *
	 * @param leaveDayTypeId the primary key for the new leave day type
	 * @return the new leave day type
	 */
	public static LeaveDayType create(long leaveDayTypeId) {
		return getPersistence().create(leaveDayTypeId);
	}

	/**
	 * Removes the leave day type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveDayTypeId the primary key of the leave day type
	 * @return the leave day type that was removed
	 * @throws NoSuchLeaveDayTypeException if a leave day type with the primary key could not be found
	 */
	public static LeaveDayType remove(long leaveDayTypeId)
		throws com.ax.hrms.exception.NoSuchLeaveDayTypeException {

		return getPersistence().remove(leaveDayTypeId);
	}

	public static LeaveDayType updateImpl(LeaveDayType leaveDayType) {
		return getPersistence().updateImpl(leaveDayType);
	}

	/**
	 * Returns the leave day type with the primary key or throws a <code>NoSuchLeaveDayTypeException</code> if it could not be found.
	 *
	 * @param leaveDayTypeId the primary key of the leave day type
	 * @return the leave day type
	 * @throws NoSuchLeaveDayTypeException if a leave day type with the primary key could not be found
	 */
	public static LeaveDayType findByPrimaryKey(long leaveDayTypeId)
		throws com.ax.hrms.exception.NoSuchLeaveDayTypeException {

		return getPersistence().findByPrimaryKey(leaveDayTypeId);
	}

	/**
	 * Returns the leave day type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveDayTypeId the primary key of the leave day type
	 * @return the leave day type, or <code>null</code> if a leave day type with the primary key could not be found
	 */
	public static LeaveDayType fetchByPrimaryKey(long leaveDayTypeId) {
		return getPersistence().fetchByPrimaryKey(leaveDayTypeId);
	}

	/**
	 * Returns all the leave day types.
	 *
	 * @return the leave day types
	 */
	public static List<LeaveDayType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the leave day types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @return the range of leave day types
	 */
	public static List<LeaveDayType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the leave day types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave day types
	 */
	public static List<LeaveDayType> findAll(
		int start, int end, OrderByComparator<LeaveDayType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave day types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave day types
	 */
	public static List<LeaveDayType> findAll(
		int start, int end, OrderByComparator<LeaveDayType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the leave day types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of leave day types.
	 *
	 * @return the number of leave day types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LeaveDayTypePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(LeaveDayTypePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile LeaveDayTypePersistence _persistence;

}