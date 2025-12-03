/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.Holiday;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the holiday service. This utility wraps <code>com.ax.hrms.service.persistence.impl.HolidayPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HolidayPersistence
 * @generated
 */
public class HolidayUtil {

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
	public static void clearCache(Holiday holiday) {
		getPersistence().clearCache(holiday);
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
	public static Map<Serializable, Holiday> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Holiday> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Holiday> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Holiday> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Holiday> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Holiday update(Holiday holiday) {
		return getPersistence().update(holiday);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Holiday update(
		Holiday holiday, ServiceContext serviceContext) {

		return getPersistence().update(holiday, serviceContext);
	}

	/**
	 * Returns all the holidays where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching holidays
	 */
	public static List<Holiday> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the holidays where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @return the range of matching holidays
	 */
	public static List<Holiday> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the holidays where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching holidays
	 */
	public static List<Holiday> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Holiday> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the holidays where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching holidays
	 */
	public static List<Holiday> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Holiday> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first holiday in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching holiday
	 * @throws NoSuchHolidayException if a matching holiday could not be found
	 */
	public static Holiday findByUuid_First(
			String uuid, OrderByComparator<Holiday> orderByComparator)
		throws com.ax.hrms.exception.NoSuchHolidayException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first holiday in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public static Holiday fetchByUuid_First(
		String uuid, OrderByComparator<Holiday> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last holiday in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching holiday
	 * @throws NoSuchHolidayException if a matching holiday could not be found
	 */
	public static Holiday findByUuid_Last(
			String uuid, OrderByComparator<Holiday> orderByComparator)
		throws com.ax.hrms.exception.NoSuchHolidayException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last holiday in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public static Holiday fetchByUuid_Last(
		String uuid, OrderByComparator<Holiday> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the holidays before and after the current holiday in the ordered set where uuid = &#63;.
	 *
	 * @param holidayId the primary key of the current holiday
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next holiday
	 * @throws NoSuchHolidayException if a holiday with the primary key could not be found
	 */
	public static Holiday[] findByUuid_PrevAndNext(
			long holidayId, String uuid,
			OrderByComparator<Holiday> orderByComparator)
		throws com.ax.hrms.exception.NoSuchHolidayException {

		return getPersistence().findByUuid_PrevAndNext(
			holidayId, uuid, orderByComparator);
	}

	/**
	 * Removes all the holidays where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of holidays where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching holidays
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the holiday where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchHolidayException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching holiday
	 * @throws NoSuchHolidayException if a matching holiday could not be found
	 */
	public static Holiday findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchHolidayException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the holiday where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public static Holiday fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the holiday where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public static Holiday fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the holiday where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the holiday that was removed
	 */
	public static Holiday removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchHolidayException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of holidays where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching holidays
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the holidays where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching holidays
	 */
	public static List<Holiday> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the holidays where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @return the range of matching holidays
	 */
	public static List<Holiday> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the holidays where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching holidays
	 */
	public static List<Holiday> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Holiday> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the holidays where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching holidays
	 */
	public static List<Holiday> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Holiday> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first holiday in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching holiday
	 * @throws NoSuchHolidayException if a matching holiday could not be found
	 */
	public static Holiday findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Holiday> orderByComparator)
		throws com.ax.hrms.exception.NoSuchHolidayException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first holiday in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public static Holiday fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Holiday> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last holiday in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching holiday
	 * @throws NoSuchHolidayException if a matching holiday could not be found
	 */
	public static Holiday findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Holiday> orderByComparator)
		throws com.ax.hrms.exception.NoSuchHolidayException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last holiday in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public static Holiday fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Holiday> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the holidays before and after the current holiday in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param holidayId the primary key of the current holiday
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next holiday
	 * @throws NoSuchHolidayException if a holiday with the primary key could not be found
	 */
	public static Holiday[] findByUuid_C_PrevAndNext(
			long holidayId, String uuid, long companyId,
			OrderByComparator<Holiday> orderByComparator)
		throws com.ax.hrms.exception.NoSuchHolidayException {

		return getPersistence().findByUuid_C_PrevAndNext(
			holidayId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the holidays where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of holidays where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching holidays
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the holidays where year = &#63;.
	 *
	 * @param year the year
	 * @return the matching holidays
	 */
	public static List<Holiday> findByYear(int year) {
		return getPersistence().findByYear(year);
	}

	/**
	 * Returns a range of all the holidays where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @return the range of matching holidays
	 */
	public static List<Holiday> findByYear(int year, int start, int end) {
		return getPersistence().findByYear(year, start, end);
	}

	/**
	 * Returns an ordered range of all the holidays where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching holidays
	 */
	public static List<Holiday> findByYear(
		int year, int start, int end,
		OrderByComparator<Holiday> orderByComparator) {

		return getPersistence().findByYear(year, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the holidays where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching holidays
	 */
	public static List<Holiday> findByYear(
		int year, int start, int end,
		OrderByComparator<Holiday> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByYear(
			year, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first holiday in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching holiday
	 * @throws NoSuchHolidayException if a matching holiday could not be found
	 */
	public static Holiday findByYear_First(
			int year, OrderByComparator<Holiday> orderByComparator)
		throws com.ax.hrms.exception.NoSuchHolidayException {

		return getPersistence().findByYear_First(year, orderByComparator);
	}

	/**
	 * Returns the first holiday in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public static Holiday fetchByYear_First(
		int year, OrderByComparator<Holiday> orderByComparator) {

		return getPersistence().fetchByYear_First(year, orderByComparator);
	}

	/**
	 * Returns the last holiday in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching holiday
	 * @throws NoSuchHolidayException if a matching holiday could not be found
	 */
	public static Holiday findByYear_Last(
			int year, OrderByComparator<Holiday> orderByComparator)
		throws com.ax.hrms.exception.NoSuchHolidayException {

		return getPersistence().findByYear_Last(year, orderByComparator);
	}

	/**
	 * Returns the last holiday in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public static Holiday fetchByYear_Last(
		int year, OrderByComparator<Holiday> orderByComparator) {

		return getPersistence().fetchByYear_Last(year, orderByComparator);
	}

	/**
	 * Returns the holidays before and after the current holiday in the ordered set where year = &#63;.
	 *
	 * @param holidayId the primary key of the current holiday
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next holiday
	 * @throws NoSuchHolidayException if a holiday with the primary key could not be found
	 */
	public static Holiday[] findByYear_PrevAndNext(
			long holidayId, int year,
			OrderByComparator<Holiday> orderByComparator)
		throws com.ax.hrms.exception.NoSuchHolidayException {

		return getPersistence().findByYear_PrevAndNext(
			holidayId, year, orderByComparator);
	}

	/**
	 * Removes all the holidays where year = &#63; from the database.
	 *
	 * @param year the year
	 */
	public static void removeByYear(int year) {
		getPersistence().removeByYear(year);
	}

	/**
	 * Returns the number of holidays where year = &#63;.
	 *
	 * @param year the year
	 * @return the number of matching holidays
	 */
	public static int countByYear(int year) {
		return getPersistence().countByYear(year);
	}

	/**
	 * Returns all the holidays where isFloater = &#63; and year = &#63;.
	 *
	 * @param isFloater the is floater
	 * @param year the year
	 * @return the matching holidays
	 */
	public static List<Holiday> findByIsFloaterAndCurrentYear(
		Boolean isFloater, int year) {

		return getPersistence().findByIsFloaterAndCurrentYear(isFloater, year);
	}

	/**
	 * Returns a range of all the holidays where isFloater = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param isFloater the is floater
	 * @param year the year
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @return the range of matching holidays
	 */
	public static List<Holiday> findByIsFloaterAndCurrentYear(
		Boolean isFloater, int year, int start, int end) {

		return getPersistence().findByIsFloaterAndCurrentYear(
			isFloater, year, start, end);
	}

	/**
	 * Returns an ordered range of all the holidays where isFloater = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param isFloater the is floater
	 * @param year the year
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching holidays
	 */
	public static List<Holiday> findByIsFloaterAndCurrentYear(
		Boolean isFloater, int year, int start, int end,
		OrderByComparator<Holiday> orderByComparator) {

		return getPersistence().findByIsFloaterAndCurrentYear(
			isFloater, year, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the holidays where isFloater = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param isFloater the is floater
	 * @param year the year
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching holidays
	 */
	public static List<Holiday> findByIsFloaterAndCurrentYear(
		Boolean isFloater, int year, int start, int end,
		OrderByComparator<Holiday> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByIsFloaterAndCurrentYear(
			isFloater, year, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first holiday in the ordered set where isFloater = &#63; and year = &#63;.
	 *
	 * @param isFloater the is floater
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching holiday
	 * @throws NoSuchHolidayException if a matching holiday could not be found
	 */
	public static Holiday findByIsFloaterAndCurrentYear_First(
			Boolean isFloater, int year,
			OrderByComparator<Holiday> orderByComparator)
		throws com.ax.hrms.exception.NoSuchHolidayException {

		return getPersistence().findByIsFloaterAndCurrentYear_First(
			isFloater, year, orderByComparator);
	}

	/**
	 * Returns the first holiday in the ordered set where isFloater = &#63; and year = &#63;.
	 *
	 * @param isFloater the is floater
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public static Holiday fetchByIsFloaterAndCurrentYear_First(
		Boolean isFloater, int year,
		OrderByComparator<Holiday> orderByComparator) {

		return getPersistence().fetchByIsFloaterAndCurrentYear_First(
			isFloater, year, orderByComparator);
	}

	/**
	 * Returns the last holiday in the ordered set where isFloater = &#63; and year = &#63;.
	 *
	 * @param isFloater the is floater
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching holiday
	 * @throws NoSuchHolidayException if a matching holiday could not be found
	 */
	public static Holiday findByIsFloaterAndCurrentYear_Last(
			Boolean isFloater, int year,
			OrderByComparator<Holiday> orderByComparator)
		throws com.ax.hrms.exception.NoSuchHolidayException {

		return getPersistence().findByIsFloaterAndCurrentYear_Last(
			isFloater, year, orderByComparator);
	}

	/**
	 * Returns the last holiday in the ordered set where isFloater = &#63; and year = &#63;.
	 *
	 * @param isFloater the is floater
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public static Holiday fetchByIsFloaterAndCurrentYear_Last(
		Boolean isFloater, int year,
		OrderByComparator<Holiday> orderByComparator) {

		return getPersistence().fetchByIsFloaterAndCurrentYear_Last(
			isFloater, year, orderByComparator);
	}

	/**
	 * Returns the holidays before and after the current holiday in the ordered set where isFloater = &#63; and year = &#63;.
	 *
	 * @param holidayId the primary key of the current holiday
	 * @param isFloater the is floater
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next holiday
	 * @throws NoSuchHolidayException if a holiday with the primary key could not be found
	 */
	public static Holiday[] findByIsFloaterAndCurrentYear_PrevAndNext(
			long holidayId, Boolean isFloater, int year,
			OrderByComparator<Holiday> orderByComparator)
		throws com.ax.hrms.exception.NoSuchHolidayException {

		return getPersistence().findByIsFloaterAndCurrentYear_PrevAndNext(
			holidayId, isFloater, year, orderByComparator);
	}

	/**
	 * Removes all the holidays where isFloater = &#63; and year = &#63; from the database.
	 *
	 * @param isFloater the is floater
	 * @param year the year
	 */
	public static void removeByIsFloaterAndCurrentYear(
		Boolean isFloater, int year) {

		getPersistence().removeByIsFloaterAndCurrentYear(isFloater, year);
	}

	/**
	 * Returns the number of holidays where isFloater = &#63; and year = &#63;.
	 *
	 * @param isFloater the is floater
	 * @param year the year
	 * @return the number of matching holidays
	 */
	public static int countByIsFloaterAndCurrentYear(
		Boolean isFloater, int year) {

		return getPersistence().countByIsFloaterAndCurrentYear(isFloater, year);
	}

	/**
	 * Returns the holiday where date = &#63; or throws a <code>NoSuchHolidayException</code> if it could not be found.
	 *
	 * @param date the date
	 * @return the matching holiday
	 * @throws NoSuchHolidayException if a matching holiday could not be found
	 */
	public static Holiday findByDate(Date date)
		throws com.ax.hrms.exception.NoSuchHolidayException {

		return getPersistence().findByDate(date);
	}

	/**
	 * Returns the holiday where date = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param date the date
	 * @return the matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public static Holiday fetchByDate(Date date) {
		return getPersistence().fetchByDate(date);
	}

	/**
	 * Returns the holiday where date = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param date the date
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public static Holiday fetchByDate(Date date, boolean useFinderCache) {
		return getPersistence().fetchByDate(date, useFinderCache);
	}

	/**
	 * Removes the holiday where date = &#63; from the database.
	 *
	 * @param date the date
	 * @return the holiday that was removed
	 */
	public static Holiday removeByDate(Date date)
		throws com.ax.hrms.exception.NoSuchHolidayException {

		return getPersistence().removeByDate(date);
	}

	/**
	 * Returns the number of holidays where date = &#63;.
	 *
	 * @param date the date
	 * @return the number of matching holidays
	 */
	public static int countByDate(Date date) {
		return getPersistence().countByDate(date);
	}

	/**
	 * Caches the holiday in the entity cache if it is enabled.
	 *
	 * @param holiday the holiday
	 */
	public static void cacheResult(Holiday holiday) {
		getPersistence().cacheResult(holiday);
	}

	/**
	 * Caches the holidays in the entity cache if it is enabled.
	 *
	 * @param holidays the holidays
	 */
	public static void cacheResult(List<Holiday> holidays) {
		getPersistence().cacheResult(holidays);
	}

	/**
	 * Creates a new holiday with the primary key. Does not add the holiday to the database.
	 *
	 * @param holidayId the primary key for the new holiday
	 * @return the new holiday
	 */
	public static Holiday create(long holidayId) {
		return getPersistence().create(holidayId);
	}

	/**
	 * Removes the holiday with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param holidayId the primary key of the holiday
	 * @return the holiday that was removed
	 * @throws NoSuchHolidayException if a holiday with the primary key could not be found
	 */
	public static Holiday remove(long holidayId)
		throws com.ax.hrms.exception.NoSuchHolidayException {

		return getPersistence().remove(holidayId);
	}

	public static Holiday updateImpl(Holiday holiday) {
		return getPersistence().updateImpl(holiday);
	}

	/**
	 * Returns the holiday with the primary key or throws a <code>NoSuchHolidayException</code> if it could not be found.
	 *
	 * @param holidayId the primary key of the holiday
	 * @return the holiday
	 * @throws NoSuchHolidayException if a holiday with the primary key could not be found
	 */
	public static Holiday findByPrimaryKey(long holidayId)
		throws com.ax.hrms.exception.NoSuchHolidayException {

		return getPersistence().findByPrimaryKey(holidayId);
	}

	/**
	 * Returns the holiday with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param holidayId the primary key of the holiday
	 * @return the holiday, or <code>null</code> if a holiday with the primary key could not be found
	 */
	public static Holiday fetchByPrimaryKey(long holidayId) {
		return getPersistence().fetchByPrimaryKey(holidayId);
	}

	/**
	 * Returns all the holidays.
	 *
	 * @return the holidays
	 */
	public static List<Holiday> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the holidays.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @return the range of holidays
	 */
	public static List<Holiday> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the holidays.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of holidays
	 */
	public static List<Holiday> findAll(
		int start, int end, OrderByComparator<Holiday> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the holidays.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of holidays
	 */
	public static List<Holiday> findAll(
		int start, int end, OrderByComparator<Holiday> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the holidays from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of holidays.
	 *
	 * @return the number of holidays
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static HolidayPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(HolidayPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile HolidayPersistence _persistence;

}