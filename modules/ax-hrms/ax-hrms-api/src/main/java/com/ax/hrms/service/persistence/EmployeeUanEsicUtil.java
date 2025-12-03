/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.EmployeeUanEsic;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the employee uan esic service. This utility wraps <code>com.ax.hrms.service.persistence.impl.EmployeeUanEsicPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeUanEsicPersistence
 * @generated
 */
public class EmployeeUanEsicUtil {

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
	public static void clearCache(EmployeeUanEsic employeeUanEsic) {
		getPersistence().clearCache(employeeUanEsic);
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
	public static Map<Serializable, EmployeeUanEsic> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeUanEsic> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeUanEsic> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeUanEsic> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeUanEsic> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeUanEsic update(EmployeeUanEsic employeeUanEsic) {
		return getPersistence().update(employeeUanEsic);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeUanEsic update(
		EmployeeUanEsic employeeUanEsic, ServiceContext serviceContext) {

		return getPersistence().update(employeeUanEsic, serviceContext);
	}

	/**
	 * Returns all the employee uan esics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee uan esics
	 */
	public static List<EmployeeUanEsic> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the employee uan esics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @return the range of matching employee uan esics
	 */
	public static List<EmployeeUanEsic> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the employee uan esics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee uan esics
	 */
	public static List<EmployeeUanEsic> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeUanEsic> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee uan esics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee uan esics
	 */
	public static List<EmployeeUanEsic> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeUanEsic> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee uan esic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a matching employee uan esic could not be found
	 */
	public static EmployeeUanEsic findByUuid_First(
			String uuid, OrderByComparator<EmployeeUanEsic> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeUanEsicException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first employee uan esic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee uan esic, or <code>null</code> if a matching employee uan esic could not be found
	 */
	public static EmployeeUanEsic fetchByUuid_First(
		String uuid, OrderByComparator<EmployeeUanEsic> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee uan esic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a matching employee uan esic could not be found
	 */
	public static EmployeeUanEsic findByUuid_Last(
			String uuid, OrderByComparator<EmployeeUanEsic> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeUanEsicException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee uan esic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee uan esic, or <code>null</code> if a matching employee uan esic could not be found
	 */
	public static EmployeeUanEsic fetchByUuid_Last(
		String uuid, OrderByComparator<EmployeeUanEsic> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the employee uan esics before and after the current employee uan esic in the ordered set where uuid = &#63;.
	 *
	 * @param uanEsicId the primary key of the current employee uan esic
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a employee uan esic with the primary key could not be found
	 */
	public static EmployeeUanEsic[] findByUuid_PrevAndNext(
			long uanEsicId, String uuid,
			OrderByComparator<EmployeeUanEsic> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeUanEsicException {

		return getPersistence().findByUuid_PrevAndNext(
			uanEsicId, uuid, orderByComparator);
	}

	/**
	 * Removes all the employee uan esics where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of employee uan esics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee uan esics
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the employee uan esic where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeUanEsicException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a matching employee uan esic could not be found
	 */
	public static EmployeeUanEsic findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeUanEsicException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee uan esic where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee uan esic, or <code>null</code> if a matching employee uan esic could not be found
	 */
	public static EmployeeUanEsic fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee uan esic where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee uan esic, or <code>null</code> if a matching employee uan esic could not be found
	 */
	public static EmployeeUanEsic fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the employee uan esic where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee uan esic that was removed
	 */
	public static EmployeeUanEsic removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeUanEsicException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of employee uan esics where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee uan esics
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the employee uan esics where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee uan esics
	 */
	public static List<EmployeeUanEsic> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the employee uan esics where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @return the range of matching employee uan esics
	 */
	public static List<EmployeeUanEsic> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee uan esics where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee uan esics
	 */
	public static List<EmployeeUanEsic> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeUanEsic> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee uan esics where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee uan esics
	 */
	public static List<EmployeeUanEsic> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeUanEsic> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee uan esic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a matching employee uan esic could not be found
	 */
	public static EmployeeUanEsic findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeUanEsic> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeUanEsicException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first employee uan esic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee uan esic, or <code>null</code> if a matching employee uan esic could not be found
	 */
	public static EmployeeUanEsic fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeUanEsic> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee uan esic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a matching employee uan esic could not be found
	 */
	public static EmployeeUanEsic findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeUanEsic> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeUanEsicException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee uan esic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee uan esic, or <code>null</code> if a matching employee uan esic could not be found
	 */
	public static EmployeeUanEsic fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeUanEsic> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the employee uan esics before and after the current employee uan esic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uanEsicId the primary key of the current employee uan esic
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a employee uan esic with the primary key could not be found
	 */
	public static EmployeeUanEsic[] findByUuid_C_PrevAndNext(
			long uanEsicId, String uuid, long companyId,
			OrderByComparator<EmployeeUanEsic> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeUanEsicException {

		return getPersistence().findByUuid_C_PrevAndNext(
			uanEsicId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the employee uan esics where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of employee uan esics where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee uan esics
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the employee uan esic in the entity cache if it is enabled.
	 *
	 * @param employeeUanEsic the employee uan esic
	 */
	public static void cacheResult(EmployeeUanEsic employeeUanEsic) {
		getPersistence().cacheResult(employeeUanEsic);
	}

	/**
	 * Caches the employee uan esics in the entity cache if it is enabled.
	 *
	 * @param employeeUanEsics the employee uan esics
	 */
	public static void cacheResult(List<EmployeeUanEsic> employeeUanEsics) {
		getPersistence().cacheResult(employeeUanEsics);
	}

	/**
	 * Creates a new employee uan esic with the primary key. Does not add the employee uan esic to the database.
	 *
	 * @param uanEsicId the primary key for the new employee uan esic
	 * @return the new employee uan esic
	 */
	public static EmployeeUanEsic create(long uanEsicId) {
		return getPersistence().create(uanEsicId);
	}

	/**
	 * Removes the employee uan esic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param uanEsicId the primary key of the employee uan esic
	 * @return the employee uan esic that was removed
	 * @throws NoSuchEmployeeUanEsicException if a employee uan esic with the primary key could not be found
	 */
	public static EmployeeUanEsic remove(long uanEsicId)
		throws com.ax.hrms.exception.NoSuchEmployeeUanEsicException {

		return getPersistence().remove(uanEsicId);
	}

	public static EmployeeUanEsic updateImpl(EmployeeUanEsic employeeUanEsic) {
		return getPersistence().updateImpl(employeeUanEsic);
	}

	/**
	 * Returns the employee uan esic with the primary key or throws a <code>NoSuchEmployeeUanEsicException</code> if it could not be found.
	 *
	 * @param uanEsicId the primary key of the employee uan esic
	 * @return the employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a employee uan esic with the primary key could not be found
	 */
	public static EmployeeUanEsic findByPrimaryKey(long uanEsicId)
		throws com.ax.hrms.exception.NoSuchEmployeeUanEsicException {

		return getPersistence().findByPrimaryKey(uanEsicId);
	}

	/**
	 * Returns the employee uan esic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param uanEsicId the primary key of the employee uan esic
	 * @return the employee uan esic, or <code>null</code> if a employee uan esic with the primary key could not be found
	 */
	public static EmployeeUanEsic fetchByPrimaryKey(long uanEsicId) {
		return getPersistence().fetchByPrimaryKey(uanEsicId);
	}

	/**
	 * Returns all the employee uan esics.
	 *
	 * @return the employee uan esics
	 */
	public static List<EmployeeUanEsic> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee uan esics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @return the range of employee uan esics
	 */
	public static List<EmployeeUanEsic> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee uan esics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee uan esics
	 */
	public static List<EmployeeUanEsic> findAll(
		int start, int end,
		OrderByComparator<EmployeeUanEsic> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee uan esics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee uan esics
	 */
	public static List<EmployeeUanEsic> findAll(
		int start, int end,
		OrderByComparator<EmployeeUanEsic> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee uan esics from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee uan esics.
	 *
	 * @return the number of employee uan esics
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeUanEsicPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(EmployeeUanEsicPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile EmployeeUanEsicPersistence _persistence;

}