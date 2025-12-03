/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.CompensatoryData;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the compensatory data service. This utility wraps <code>com.ax.hrms.service.persistence.impl.CompensatoryDataPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CompensatoryDataPersistence
 * @generated
 */
public class CompensatoryDataUtil {

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
	public static void clearCache(CompensatoryData compensatoryData) {
		getPersistence().clearCache(compensatoryData);
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
	public static Map<Serializable, CompensatoryData> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CompensatoryData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CompensatoryData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CompensatoryData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CompensatoryData> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CompensatoryData update(CompensatoryData compensatoryData) {
		return getPersistence().update(compensatoryData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CompensatoryData update(
		CompensatoryData compensatoryData, ServiceContext serviceContext) {

		return getPersistence().update(compensatoryData, serviceContext);
	}

	/**
	 * Returns all the compensatory datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching compensatory datas
	 */
	public static List<CompensatoryData> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the compensatory datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @return the range of matching compensatory datas
	 */
	public static List<CompensatoryData> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the compensatory datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching compensatory datas
	 */
	public static List<CompensatoryData> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CompensatoryData> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the compensatory datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching compensatory datas
	 */
	public static List<CompensatoryData> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CompensatoryData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first compensatory data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching compensatory data
	 * @throws NoSuchCompensatoryDataException if a matching compensatory data could not be found
	 */
	public static CompensatoryData findByUuid_First(
			String uuid, OrderByComparator<CompensatoryData> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCompensatoryDataException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first compensatory data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	public static CompensatoryData fetchByUuid_First(
		String uuid, OrderByComparator<CompensatoryData> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last compensatory data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching compensatory data
	 * @throws NoSuchCompensatoryDataException if a matching compensatory data could not be found
	 */
	public static CompensatoryData findByUuid_Last(
			String uuid, OrderByComparator<CompensatoryData> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCompensatoryDataException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last compensatory data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	public static CompensatoryData fetchByUuid_Last(
		String uuid, OrderByComparator<CompensatoryData> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the compensatory datas before and after the current compensatory data in the ordered set where uuid = &#63;.
	 *
	 * @param compensatoryDataId the primary key of the current compensatory data
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next compensatory data
	 * @throws NoSuchCompensatoryDataException if a compensatory data with the primary key could not be found
	 */
	public static CompensatoryData[] findByUuid_PrevAndNext(
			long compensatoryDataId, String uuid,
			OrderByComparator<CompensatoryData> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCompensatoryDataException {

		return getPersistence().findByUuid_PrevAndNext(
			compensatoryDataId, uuid, orderByComparator);
	}

	/**
	 * Removes all the compensatory datas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of compensatory datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching compensatory datas
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the compensatory data where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCompensatoryDataException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching compensatory data
	 * @throws NoSuchCompensatoryDataException if a matching compensatory data could not be found
	 */
	public static CompensatoryData findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchCompensatoryDataException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the compensatory data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	public static CompensatoryData fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the compensatory data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	public static CompensatoryData fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the compensatory data where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the compensatory data that was removed
	 */
	public static CompensatoryData removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchCompensatoryDataException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of compensatory datas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching compensatory datas
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the compensatory datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching compensatory datas
	 */
	public static List<CompensatoryData> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the compensatory datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @return the range of matching compensatory datas
	 */
	public static List<CompensatoryData> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the compensatory datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching compensatory datas
	 */
	public static List<CompensatoryData> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CompensatoryData> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the compensatory datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching compensatory datas
	 */
	public static List<CompensatoryData> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CompensatoryData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first compensatory data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching compensatory data
	 * @throws NoSuchCompensatoryDataException if a matching compensatory data could not be found
	 */
	public static CompensatoryData findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CompensatoryData> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCompensatoryDataException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first compensatory data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	public static CompensatoryData fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CompensatoryData> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last compensatory data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching compensatory data
	 * @throws NoSuchCompensatoryDataException if a matching compensatory data could not be found
	 */
	public static CompensatoryData findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CompensatoryData> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCompensatoryDataException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last compensatory data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	public static CompensatoryData fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CompensatoryData> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the compensatory datas before and after the current compensatory data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param compensatoryDataId the primary key of the current compensatory data
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next compensatory data
	 * @throws NoSuchCompensatoryDataException if a compensatory data with the primary key could not be found
	 */
	public static CompensatoryData[] findByUuid_C_PrevAndNext(
			long compensatoryDataId, String uuid, long companyId,
			OrderByComparator<CompensatoryData> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCompensatoryDataException {

		return getPersistence().findByUuid_C_PrevAndNext(
			compensatoryDataId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the compensatory datas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of compensatory datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching compensatory datas
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the compensatory datas where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching compensatory datas
	 */
	public static List<CompensatoryData> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the compensatory datas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @return the range of matching compensatory datas
	 */
	public static List<CompensatoryData> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the compensatory datas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching compensatory datas
	 */
	public static List<CompensatoryData> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<CompensatoryData> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the compensatory datas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching compensatory datas
	 */
	public static List<CompensatoryData> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<CompensatoryData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first compensatory data in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching compensatory data
	 * @throws NoSuchCompensatoryDataException if a matching compensatory data could not be found
	 */
	public static CompensatoryData findByEmployeeId_First(
			long employeeId,
			OrderByComparator<CompensatoryData> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCompensatoryDataException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first compensatory data in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	public static CompensatoryData fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<CompensatoryData> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last compensatory data in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching compensatory data
	 * @throws NoSuchCompensatoryDataException if a matching compensatory data could not be found
	 */
	public static CompensatoryData findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<CompensatoryData> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCompensatoryDataException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last compensatory data in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	public static CompensatoryData fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<CompensatoryData> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the compensatory datas before and after the current compensatory data in the ordered set where employeeId = &#63;.
	 *
	 * @param compensatoryDataId the primary key of the current compensatory data
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next compensatory data
	 * @throws NoSuchCompensatoryDataException if a compensatory data with the primary key could not be found
	 */
	public static CompensatoryData[] findByEmployeeId_PrevAndNext(
			long compensatoryDataId, long employeeId,
			OrderByComparator<CompensatoryData> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCompensatoryDataException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			compensatoryDataId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the compensatory datas where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of compensatory datas where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching compensatory datas
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the compensatory datas where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @return the matching compensatory datas
	 */
	public static List<CompensatoryData> findByManagerId(long managerId) {
		return getPersistence().findByManagerId(managerId);
	}

	/**
	 * Returns a range of all the compensatory datas where managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @return the range of matching compensatory datas
	 */
	public static List<CompensatoryData> findByManagerId(
		long managerId, int start, int end) {

		return getPersistence().findByManagerId(managerId, start, end);
	}

	/**
	 * Returns an ordered range of all the compensatory datas where managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching compensatory datas
	 */
	public static List<CompensatoryData> findByManagerId(
		long managerId, int start, int end,
		OrderByComparator<CompensatoryData> orderByComparator) {

		return getPersistence().findByManagerId(
			managerId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the compensatory datas where managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching compensatory datas
	 */
	public static List<CompensatoryData> findByManagerId(
		long managerId, int start, int end,
		OrderByComparator<CompensatoryData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByManagerId(
			managerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first compensatory data in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching compensatory data
	 * @throws NoSuchCompensatoryDataException if a matching compensatory data could not be found
	 */
	public static CompensatoryData findByManagerId_First(
			long managerId,
			OrderByComparator<CompensatoryData> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCompensatoryDataException {

		return getPersistence().findByManagerId_First(
			managerId, orderByComparator);
	}

	/**
	 * Returns the first compensatory data in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	public static CompensatoryData fetchByManagerId_First(
		long managerId, OrderByComparator<CompensatoryData> orderByComparator) {

		return getPersistence().fetchByManagerId_First(
			managerId, orderByComparator);
	}

	/**
	 * Returns the last compensatory data in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching compensatory data
	 * @throws NoSuchCompensatoryDataException if a matching compensatory data could not be found
	 */
	public static CompensatoryData findByManagerId_Last(
			long managerId,
			OrderByComparator<CompensatoryData> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCompensatoryDataException {

		return getPersistence().findByManagerId_Last(
			managerId, orderByComparator);
	}

	/**
	 * Returns the last compensatory data in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	public static CompensatoryData fetchByManagerId_Last(
		long managerId, OrderByComparator<CompensatoryData> orderByComparator) {

		return getPersistence().fetchByManagerId_Last(
			managerId, orderByComparator);
	}

	/**
	 * Returns the compensatory datas before and after the current compensatory data in the ordered set where managerId = &#63;.
	 *
	 * @param compensatoryDataId the primary key of the current compensatory data
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next compensatory data
	 * @throws NoSuchCompensatoryDataException if a compensatory data with the primary key could not be found
	 */
	public static CompensatoryData[] findByManagerId_PrevAndNext(
			long compensatoryDataId, long managerId,
			OrderByComparator<CompensatoryData> orderByComparator)
		throws com.ax.hrms.exception.NoSuchCompensatoryDataException {

		return getPersistence().findByManagerId_PrevAndNext(
			compensatoryDataId, managerId, orderByComparator);
	}

	/**
	 * Removes all the compensatory datas where managerId = &#63; from the database.
	 *
	 * @param managerId the manager ID
	 */
	public static void removeByManagerId(long managerId) {
		getPersistence().removeByManagerId(managerId);
	}

	/**
	 * Returns the number of compensatory datas where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @return the number of matching compensatory datas
	 */
	public static int countByManagerId(long managerId) {
		return getPersistence().countByManagerId(managerId);
	}

	/**
	 * Caches the compensatory data in the entity cache if it is enabled.
	 *
	 * @param compensatoryData the compensatory data
	 */
	public static void cacheResult(CompensatoryData compensatoryData) {
		getPersistence().cacheResult(compensatoryData);
	}

	/**
	 * Caches the compensatory datas in the entity cache if it is enabled.
	 *
	 * @param compensatoryDatas the compensatory datas
	 */
	public static void cacheResult(List<CompensatoryData> compensatoryDatas) {
		getPersistence().cacheResult(compensatoryDatas);
	}

	/**
	 * Creates a new compensatory data with the primary key. Does not add the compensatory data to the database.
	 *
	 * @param compensatoryDataId the primary key for the new compensatory data
	 * @return the new compensatory data
	 */
	public static CompensatoryData create(long compensatoryDataId) {
		return getPersistence().create(compensatoryDataId);
	}

	/**
	 * Removes the compensatory data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param compensatoryDataId the primary key of the compensatory data
	 * @return the compensatory data that was removed
	 * @throws NoSuchCompensatoryDataException if a compensatory data with the primary key could not be found
	 */
	public static CompensatoryData remove(long compensatoryDataId)
		throws com.ax.hrms.exception.NoSuchCompensatoryDataException {

		return getPersistence().remove(compensatoryDataId);
	}

	public static CompensatoryData updateImpl(
		CompensatoryData compensatoryData) {

		return getPersistence().updateImpl(compensatoryData);
	}

	/**
	 * Returns the compensatory data with the primary key or throws a <code>NoSuchCompensatoryDataException</code> if it could not be found.
	 *
	 * @param compensatoryDataId the primary key of the compensatory data
	 * @return the compensatory data
	 * @throws NoSuchCompensatoryDataException if a compensatory data with the primary key could not be found
	 */
	public static CompensatoryData findByPrimaryKey(long compensatoryDataId)
		throws com.ax.hrms.exception.NoSuchCompensatoryDataException {

		return getPersistence().findByPrimaryKey(compensatoryDataId);
	}

	/**
	 * Returns the compensatory data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param compensatoryDataId the primary key of the compensatory data
	 * @return the compensatory data, or <code>null</code> if a compensatory data with the primary key could not be found
	 */
	public static CompensatoryData fetchByPrimaryKey(long compensatoryDataId) {
		return getPersistence().fetchByPrimaryKey(compensatoryDataId);
	}

	/**
	 * Returns all the compensatory datas.
	 *
	 * @return the compensatory datas
	 */
	public static List<CompensatoryData> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the compensatory datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @return the range of compensatory datas
	 */
	public static List<CompensatoryData> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the compensatory datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of compensatory datas
	 */
	public static List<CompensatoryData> findAll(
		int start, int end,
		OrderByComparator<CompensatoryData> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the compensatory datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of compensatory datas
	 */
	public static List<CompensatoryData> findAll(
		int start, int end,
		OrderByComparator<CompensatoryData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the compensatory datas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of compensatory datas.
	 *
	 * @return the number of compensatory datas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CompensatoryDataPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(CompensatoryDataPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile CompensatoryDataPersistence _persistence;

}