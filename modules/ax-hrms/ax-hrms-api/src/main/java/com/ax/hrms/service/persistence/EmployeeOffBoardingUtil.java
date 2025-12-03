/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.EmployeeOffBoarding;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the employee off boarding service. This utility wraps <code>com.ax.hrms.service.persistence.impl.EmployeeOffBoardingPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeOffBoardingPersistence
 * @generated
 */
public class EmployeeOffBoardingUtil {

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
	public static void clearCache(EmployeeOffBoarding employeeOffBoarding) {
		getPersistence().clearCache(employeeOffBoarding);
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
	public static Map<Serializable, EmployeeOffBoarding> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeOffBoarding> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeOffBoarding> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeOffBoarding> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeOffBoarding> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeOffBoarding update(
		EmployeeOffBoarding employeeOffBoarding) {

		return getPersistence().update(employeeOffBoarding);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeOffBoarding update(
		EmployeeOffBoarding employeeOffBoarding,
		ServiceContext serviceContext) {

		return getPersistence().update(employeeOffBoarding, serviceContext);
	}

	/**
	 * Returns all the employee off boardings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee off boardings
	 */
	public static List<EmployeeOffBoarding> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the employee off boardings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @return the range of matching employee off boardings
	 */
	public static List<EmployeeOffBoarding> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the employee off boardings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee off boardings
	 */
	public static List<EmployeeOffBoarding> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeOffBoarding> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee off boardings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee off boardings
	 */
	public static List<EmployeeOffBoarding> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeOffBoarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee off boarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a matching employee off boarding could not be found
	 */
	public static EmployeeOffBoarding findByUuid_First(
			String uuid,
			OrderByComparator<EmployeeOffBoarding> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeOffBoardingException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first employee off boarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	public static EmployeeOffBoarding fetchByUuid_First(
		String uuid, OrderByComparator<EmployeeOffBoarding> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee off boarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a matching employee off boarding could not be found
	 */
	public static EmployeeOffBoarding findByUuid_Last(
			String uuid,
			OrderByComparator<EmployeeOffBoarding> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeOffBoardingException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee off boarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	public static EmployeeOffBoarding fetchByUuid_Last(
		String uuid, OrderByComparator<EmployeeOffBoarding> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the employee off boardings before and after the current employee off boarding in the ordered set where uuid = &#63;.
	 *
	 * @param employeeOffBoardingId the primary key of the current employee off boarding
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a employee off boarding with the primary key could not be found
	 */
	public static EmployeeOffBoarding[] findByUuid_PrevAndNext(
			long employeeOffBoardingId, String uuid,
			OrderByComparator<EmployeeOffBoarding> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeOffBoardingException {

		return getPersistence().findByUuid_PrevAndNext(
			employeeOffBoardingId, uuid, orderByComparator);
	}

	/**
	 * Removes all the employee off boardings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of employee off boardings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee off boardings
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the employee off boarding where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeOffBoardingException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a matching employee off boarding could not be found
	 */
	public static EmployeeOffBoarding findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeOffBoardingException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee off boarding where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	public static EmployeeOffBoarding fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee off boarding where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	public static EmployeeOffBoarding fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the employee off boarding where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee off boarding that was removed
	 */
	public static EmployeeOffBoarding removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeOffBoardingException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of employee off boardings where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee off boardings
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the employee off boardings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee off boardings
	 */
	public static List<EmployeeOffBoarding> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the employee off boardings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @return the range of matching employee off boardings
	 */
	public static List<EmployeeOffBoarding> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee off boardings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee off boardings
	 */
	public static List<EmployeeOffBoarding> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeOffBoarding> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee off boardings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee off boardings
	 */
	public static List<EmployeeOffBoarding> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeOffBoarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee off boarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a matching employee off boarding could not be found
	 */
	public static EmployeeOffBoarding findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeOffBoarding> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeOffBoardingException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first employee off boarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	public static EmployeeOffBoarding fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeOffBoarding> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee off boarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a matching employee off boarding could not be found
	 */
	public static EmployeeOffBoarding findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeOffBoarding> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeOffBoardingException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee off boarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	public static EmployeeOffBoarding fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeOffBoarding> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the employee off boardings before and after the current employee off boarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeeOffBoardingId the primary key of the current employee off boarding
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a employee off boarding with the primary key could not be found
	 */
	public static EmployeeOffBoarding[] findByUuid_C_PrevAndNext(
			long employeeOffBoardingId, String uuid, long companyId,
			OrderByComparator<EmployeeOffBoarding> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeOffBoardingException {

		return getPersistence().findByUuid_C_PrevAndNext(
			employeeOffBoardingId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the employee off boardings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of employee off boardings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee off boardings
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the employee off boarding where employeeId = &#63; or throws a <code>NoSuchEmployeeOffBoardingException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a matching employee off boarding could not be found
	 */
	public static EmployeeOffBoarding findByEmployeeId(long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeOffBoardingException {

		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns the employee off boarding where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	public static EmployeeOffBoarding fetchByEmployeeId(long employeeId) {
		return getPersistence().fetchByEmployeeId(employeeId);
	}

	/**
	 * Returns the employee off boarding where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	public static EmployeeOffBoarding fetchByEmployeeId(
		long employeeId, boolean useFinderCache) {

		return getPersistence().fetchByEmployeeId(employeeId, useFinderCache);
	}

	/**
	 * Removes the employee off boarding where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the employee off boarding that was removed
	 */
	public static EmployeeOffBoarding removeByEmployeeId(long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeOffBoardingException {

		return getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee off boardings where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee off boardings
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Caches the employee off boarding in the entity cache if it is enabled.
	 *
	 * @param employeeOffBoarding the employee off boarding
	 */
	public static void cacheResult(EmployeeOffBoarding employeeOffBoarding) {
		getPersistence().cacheResult(employeeOffBoarding);
	}

	/**
	 * Caches the employee off boardings in the entity cache if it is enabled.
	 *
	 * @param employeeOffBoardings the employee off boardings
	 */
	public static void cacheResult(
		List<EmployeeOffBoarding> employeeOffBoardings) {

		getPersistence().cacheResult(employeeOffBoardings);
	}

	/**
	 * Creates a new employee off boarding with the primary key. Does not add the employee off boarding to the database.
	 *
	 * @param employeeOffBoardingId the primary key for the new employee off boarding
	 * @return the new employee off boarding
	 */
	public static EmployeeOffBoarding create(long employeeOffBoardingId) {
		return getPersistence().create(employeeOffBoardingId);
	}

	/**
	 * Removes the employee off boarding with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeOffBoardingId the primary key of the employee off boarding
	 * @return the employee off boarding that was removed
	 * @throws NoSuchEmployeeOffBoardingException if a employee off boarding with the primary key could not be found
	 */
	public static EmployeeOffBoarding remove(long employeeOffBoardingId)
		throws com.ax.hrms.exception.NoSuchEmployeeOffBoardingException {

		return getPersistence().remove(employeeOffBoardingId);
	}

	public static EmployeeOffBoarding updateImpl(
		EmployeeOffBoarding employeeOffBoarding) {

		return getPersistence().updateImpl(employeeOffBoarding);
	}

	/**
	 * Returns the employee off boarding with the primary key or throws a <code>NoSuchEmployeeOffBoardingException</code> if it could not be found.
	 *
	 * @param employeeOffBoardingId the primary key of the employee off boarding
	 * @return the employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a employee off boarding with the primary key could not be found
	 */
	public static EmployeeOffBoarding findByPrimaryKey(
			long employeeOffBoardingId)
		throws com.ax.hrms.exception.NoSuchEmployeeOffBoardingException {

		return getPersistence().findByPrimaryKey(employeeOffBoardingId);
	}

	/**
	 * Returns the employee off boarding with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeOffBoardingId the primary key of the employee off boarding
	 * @return the employee off boarding, or <code>null</code> if a employee off boarding with the primary key could not be found
	 */
	public static EmployeeOffBoarding fetchByPrimaryKey(
		long employeeOffBoardingId) {

		return getPersistence().fetchByPrimaryKey(employeeOffBoardingId);
	}

	/**
	 * Returns all the employee off boardings.
	 *
	 * @return the employee off boardings
	 */
	public static List<EmployeeOffBoarding> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee off boardings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @return the range of employee off boardings
	 */
	public static List<EmployeeOffBoarding> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee off boardings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee off boardings
	 */
	public static List<EmployeeOffBoarding> findAll(
		int start, int end,
		OrderByComparator<EmployeeOffBoarding> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee off boardings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee off boardings
	 */
	public static List<EmployeeOffBoarding> findAll(
		int start, int end,
		OrderByComparator<EmployeeOffBoarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee off boardings from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee off boardings.
	 *
	 * @return the number of employee off boardings
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeOffBoardingPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		EmployeeOffBoardingPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile EmployeeOffBoardingPersistence _persistence;

}