/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.UpcomingProbationEmployee;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the upcoming probation employee service. This utility wraps <code>com.ax.hrms.service.persistence.impl.UpcomingProbationEmployeePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UpcomingProbationEmployeePersistence
 * @generated
 */
public class UpcomingProbationEmployeeUtil {

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
		UpcomingProbationEmployee upcomingProbationEmployee) {

		getPersistence().clearCache(upcomingProbationEmployee);
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
	public static Map<Serializable, UpcomingProbationEmployee>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UpcomingProbationEmployee> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UpcomingProbationEmployee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UpcomingProbationEmployee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UpcomingProbationEmployee update(
		UpcomingProbationEmployee upcomingProbationEmployee) {

		return getPersistence().update(upcomingProbationEmployee);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UpcomingProbationEmployee update(
		UpcomingProbationEmployee upcomingProbationEmployee,
		ServiceContext serviceContext) {

		return getPersistence().update(
			upcomingProbationEmployee, serviceContext);
	}

	/**
	 * Returns all the upcoming probation employees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching upcoming probation employees
	 */
	public static List<UpcomingProbationEmployee> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the upcoming probation employees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @return the range of matching upcoming probation employees
	 */
	public static List<UpcomingProbationEmployee> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the upcoming probation employees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching upcoming probation employees
	 */
	public static List<UpcomingProbationEmployee> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the upcoming probation employees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching upcoming probation employees
	 */
	public static List<UpcomingProbationEmployee> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first upcoming probation employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a matching upcoming probation employee could not be found
	 */
	public static UpcomingProbationEmployee findByUuid_First(
			String uuid,
			OrderByComparator<UpcomingProbationEmployee> orderByComparator)
		throws com.ax.hrms.exception.NoSuchUpcomingProbationEmployeeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first upcoming probation employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	public static UpcomingProbationEmployee fetchByUuid_First(
		String uuid,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last upcoming probation employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a matching upcoming probation employee could not be found
	 */
	public static UpcomingProbationEmployee findByUuid_Last(
			String uuid,
			OrderByComparator<UpcomingProbationEmployee> orderByComparator)
		throws com.ax.hrms.exception.NoSuchUpcomingProbationEmployeeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last upcoming probation employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	public static UpcomingProbationEmployee fetchByUuid_Last(
		String uuid,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the upcoming probation employees before and after the current upcoming probation employee in the ordered set where uuid = &#63;.
	 *
	 * @param upcomingProbationEmployeeId the primary key of the current upcoming probation employee
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a upcoming probation employee with the primary key could not be found
	 */
	public static UpcomingProbationEmployee[] findByUuid_PrevAndNext(
			long upcomingProbationEmployeeId, String uuid,
			OrderByComparator<UpcomingProbationEmployee> orderByComparator)
		throws com.ax.hrms.exception.NoSuchUpcomingProbationEmployeeException {

		return getPersistence().findByUuid_PrevAndNext(
			upcomingProbationEmployeeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the upcoming probation employees where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of upcoming probation employees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching upcoming probation employees
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the upcoming probation employee where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUpcomingProbationEmployeeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a matching upcoming probation employee could not be found
	 */
	public static UpcomingProbationEmployee findByUUID_G(
			String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchUpcomingProbationEmployeeException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the upcoming probation employee where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	public static UpcomingProbationEmployee fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the upcoming probation employee where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	public static UpcomingProbationEmployee fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the upcoming probation employee where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the upcoming probation employee that was removed
	 */
	public static UpcomingProbationEmployee removeByUUID_G(
			String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchUpcomingProbationEmployeeException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of upcoming probation employees where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching upcoming probation employees
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the upcoming probation employees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching upcoming probation employees
	 */
	public static List<UpcomingProbationEmployee> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the upcoming probation employees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @return the range of matching upcoming probation employees
	 */
	public static List<UpcomingProbationEmployee> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the upcoming probation employees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching upcoming probation employees
	 */
	public static List<UpcomingProbationEmployee> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the upcoming probation employees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching upcoming probation employees
	 */
	public static List<UpcomingProbationEmployee> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first upcoming probation employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a matching upcoming probation employee could not be found
	 */
	public static UpcomingProbationEmployee findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<UpcomingProbationEmployee> orderByComparator)
		throws com.ax.hrms.exception.NoSuchUpcomingProbationEmployeeException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first upcoming probation employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	public static UpcomingProbationEmployee fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last upcoming probation employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a matching upcoming probation employee could not be found
	 */
	public static UpcomingProbationEmployee findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<UpcomingProbationEmployee> orderByComparator)
		throws com.ax.hrms.exception.NoSuchUpcomingProbationEmployeeException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last upcoming probation employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	public static UpcomingProbationEmployee fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the upcoming probation employees before and after the current upcoming probation employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param upcomingProbationEmployeeId the primary key of the current upcoming probation employee
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a upcoming probation employee with the primary key could not be found
	 */
	public static UpcomingProbationEmployee[] findByUuid_C_PrevAndNext(
			long upcomingProbationEmployeeId, String uuid, long companyId,
			OrderByComparator<UpcomingProbationEmployee> orderByComparator)
		throws com.ax.hrms.exception.NoSuchUpcomingProbationEmployeeException {

		return getPersistence().findByUuid_C_PrevAndNext(
			upcomingProbationEmployeeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the upcoming probation employees where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of upcoming probation employees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching upcoming probation employees
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the upcoming probation employees where month = &#63; and year = &#63;.
	 *
	 * @param month the month
	 * @param year the year
	 * @return the matching upcoming probation employees
	 */
	public static List<UpcomingProbationEmployee> findByMonthAndYear(
		int month, int year) {

		return getPersistence().findByMonthAndYear(month, year);
	}

	/**
	 * Returns a range of all the upcoming probation employees where month = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param month the month
	 * @param year the year
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @return the range of matching upcoming probation employees
	 */
	public static List<UpcomingProbationEmployee> findByMonthAndYear(
		int month, int year, int start, int end) {

		return getPersistence().findByMonthAndYear(month, year, start, end);
	}

	/**
	 * Returns an ordered range of all the upcoming probation employees where month = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param month the month
	 * @param year the year
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching upcoming probation employees
	 */
	public static List<UpcomingProbationEmployee> findByMonthAndYear(
		int month, int year, int start, int end,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		return getPersistence().findByMonthAndYear(
			month, year, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the upcoming probation employees where month = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param month the month
	 * @param year the year
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching upcoming probation employees
	 */
	public static List<UpcomingProbationEmployee> findByMonthAndYear(
		int month, int year, int start, int end,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByMonthAndYear(
			month, year, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first upcoming probation employee in the ordered set where month = &#63; and year = &#63;.
	 *
	 * @param month the month
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a matching upcoming probation employee could not be found
	 */
	public static UpcomingProbationEmployee findByMonthAndYear_First(
			int month, int year,
			OrderByComparator<UpcomingProbationEmployee> orderByComparator)
		throws com.ax.hrms.exception.NoSuchUpcomingProbationEmployeeException {

		return getPersistence().findByMonthAndYear_First(
			month, year, orderByComparator);
	}

	/**
	 * Returns the first upcoming probation employee in the ordered set where month = &#63; and year = &#63;.
	 *
	 * @param month the month
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	public static UpcomingProbationEmployee fetchByMonthAndYear_First(
		int month, int year,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		return getPersistence().fetchByMonthAndYear_First(
			month, year, orderByComparator);
	}

	/**
	 * Returns the last upcoming probation employee in the ordered set where month = &#63; and year = &#63;.
	 *
	 * @param month the month
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a matching upcoming probation employee could not be found
	 */
	public static UpcomingProbationEmployee findByMonthAndYear_Last(
			int month, int year,
			OrderByComparator<UpcomingProbationEmployee> orderByComparator)
		throws com.ax.hrms.exception.NoSuchUpcomingProbationEmployeeException {

		return getPersistence().findByMonthAndYear_Last(
			month, year, orderByComparator);
	}

	/**
	 * Returns the last upcoming probation employee in the ordered set where month = &#63; and year = &#63;.
	 *
	 * @param month the month
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	public static UpcomingProbationEmployee fetchByMonthAndYear_Last(
		int month, int year,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		return getPersistence().fetchByMonthAndYear_Last(
			month, year, orderByComparator);
	}

	/**
	 * Returns the upcoming probation employees before and after the current upcoming probation employee in the ordered set where month = &#63; and year = &#63;.
	 *
	 * @param upcomingProbationEmployeeId the primary key of the current upcoming probation employee
	 * @param month the month
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a upcoming probation employee with the primary key could not be found
	 */
	public static UpcomingProbationEmployee[] findByMonthAndYear_PrevAndNext(
			long upcomingProbationEmployeeId, int month, int year,
			OrderByComparator<UpcomingProbationEmployee> orderByComparator)
		throws com.ax.hrms.exception.NoSuchUpcomingProbationEmployeeException {

		return getPersistence().findByMonthAndYear_PrevAndNext(
			upcomingProbationEmployeeId, month, year, orderByComparator);
	}

	/**
	 * Removes all the upcoming probation employees where month = &#63; and year = &#63; from the database.
	 *
	 * @param month the month
	 * @param year the year
	 */
	public static void removeByMonthAndYear(int month, int year) {
		getPersistence().removeByMonthAndYear(month, year);
	}

	/**
	 * Returns the number of upcoming probation employees where month = &#63; and year = &#63;.
	 *
	 * @param month the month
	 * @param year the year
	 * @return the number of matching upcoming probation employees
	 */
	public static int countByMonthAndYear(int month, int year) {
		return getPersistence().countByMonthAndYear(month, year);
	}

	/**
	 * Caches the upcoming probation employee in the entity cache if it is enabled.
	 *
	 * @param upcomingProbationEmployee the upcoming probation employee
	 */
	public static void cacheResult(
		UpcomingProbationEmployee upcomingProbationEmployee) {

		getPersistence().cacheResult(upcomingProbationEmployee);
	}

	/**
	 * Caches the upcoming probation employees in the entity cache if it is enabled.
	 *
	 * @param upcomingProbationEmployees the upcoming probation employees
	 */
	public static void cacheResult(
		List<UpcomingProbationEmployee> upcomingProbationEmployees) {

		getPersistence().cacheResult(upcomingProbationEmployees);
	}

	/**
	 * Creates a new upcoming probation employee with the primary key. Does not add the upcoming probation employee to the database.
	 *
	 * @param upcomingProbationEmployeeId the primary key for the new upcoming probation employee
	 * @return the new upcoming probation employee
	 */
	public static UpcomingProbationEmployee create(
		long upcomingProbationEmployeeId) {

		return getPersistence().create(upcomingProbationEmployeeId);
	}

	/**
	 * Removes the upcoming probation employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param upcomingProbationEmployeeId the primary key of the upcoming probation employee
	 * @return the upcoming probation employee that was removed
	 * @throws NoSuchUpcomingProbationEmployeeException if a upcoming probation employee with the primary key could not be found
	 */
	public static UpcomingProbationEmployee remove(
			long upcomingProbationEmployeeId)
		throws com.ax.hrms.exception.NoSuchUpcomingProbationEmployeeException {

		return getPersistence().remove(upcomingProbationEmployeeId);
	}

	public static UpcomingProbationEmployee updateImpl(
		UpcomingProbationEmployee upcomingProbationEmployee) {

		return getPersistence().updateImpl(upcomingProbationEmployee);
	}

	/**
	 * Returns the upcoming probation employee with the primary key or throws a <code>NoSuchUpcomingProbationEmployeeException</code> if it could not be found.
	 *
	 * @param upcomingProbationEmployeeId the primary key of the upcoming probation employee
	 * @return the upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a upcoming probation employee with the primary key could not be found
	 */
	public static UpcomingProbationEmployee findByPrimaryKey(
			long upcomingProbationEmployeeId)
		throws com.ax.hrms.exception.NoSuchUpcomingProbationEmployeeException {

		return getPersistence().findByPrimaryKey(upcomingProbationEmployeeId);
	}

	/**
	 * Returns the upcoming probation employee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param upcomingProbationEmployeeId the primary key of the upcoming probation employee
	 * @return the upcoming probation employee, or <code>null</code> if a upcoming probation employee with the primary key could not be found
	 */
	public static UpcomingProbationEmployee fetchByPrimaryKey(
		long upcomingProbationEmployeeId) {

		return getPersistence().fetchByPrimaryKey(upcomingProbationEmployeeId);
	}

	/**
	 * Returns all the upcoming probation employees.
	 *
	 * @return the upcoming probation employees
	 */
	public static List<UpcomingProbationEmployee> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the upcoming probation employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @return the range of upcoming probation employees
	 */
	public static List<UpcomingProbationEmployee> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the upcoming probation employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of upcoming probation employees
	 */
	public static List<UpcomingProbationEmployee> findAll(
		int start, int end,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the upcoming probation employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of upcoming probation employees
	 */
	public static List<UpcomingProbationEmployee> findAll(
		int start, int end,
		OrderByComparator<UpcomingProbationEmployee> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the upcoming probation employees from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of upcoming probation employees.
	 *
	 * @return the number of upcoming probation employees
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UpcomingProbationEmployeePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		UpcomingProbationEmployeePersistence persistence) {

		_persistence = persistence;
	}

	private static volatile UpcomingProbationEmployeePersistence _persistence;

}