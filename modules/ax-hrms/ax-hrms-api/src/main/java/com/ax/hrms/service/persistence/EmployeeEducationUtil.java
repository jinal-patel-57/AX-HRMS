/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.EmployeeEducation;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the employee education service. This utility wraps <code>com.ax.hrms.service.persistence.impl.EmployeeEducationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeEducationPersistence
 * @generated
 */
public class EmployeeEducationUtil {

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
	public static void clearCache(EmployeeEducation employeeEducation) {
		getPersistence().clearCache(employeeEducation);
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
	public static Map<Serializable, EmployeeEducation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeEducation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeEducation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeEducation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeEducation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeEducation update(
		EmployeeEducation employeeEducation) {

		return getPersistence().update(employeeEducation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeEducation update(
		EmployeeEducation employeeEducation, ServiceContext serviceContext) {

		return getPersistence().update(employeeEducation, serviceContext);
	}

	/**
	 * Returns all the employee educations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee educations
	 */
	public static List<EmployeeEducation> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the employee educations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @return the range of matching employee educations
	 */
	public static List<EmployeeEducation> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the employee educations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee educations
	 */
	public static List<EmployeeEducation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeEducation> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee educations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee educations
	 */
	public static List<EmployeeEducation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeEducation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee education in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee education
	 * @throws NoSuchEmployeeEducationException if a matching employee education could not be found
	 */
	public static EmployeeEducation findByUuid_First(
			String uuid, OrderByComparator<EmployeeEducation> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeEducationException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first employee education in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee education, or <code>null</code> if a matching employee education could not be found
	 */
	public static EmployeeEducation fetchByUuid_First(
		String uuid, OrderByComparator<EmployeeEducation> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee education in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee education
	 * @throws NoSuchEmployeeEducationException if a matching employee education could not be found
	 */
	public static EmployeeEducation findByUuid_Last(
			String uuid, OrderByComparator<EmployeeEducation> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeEducationException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee education in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee education, or <code>null</code> if a matching employee education could not be found
	 */
	public static EmployeeEducation fetchByUuid_Last(
		String uuid, OrderByComparator<EmployeeEducation> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the employee educations before and after the current employee education in the ordered set where uuid = &#63;.
	 *
	 * @param educationId the primary key of the current employee education
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee education
	 * @throws NoSuchEmployeeEducationException if a employee education with the primary key could not be found
	 */
	public static EmployeeEducation[] findByUuid_PrevAndNext(
			long educationId, String uuid,
			OrderByComparator<EmployeeEducation> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeEducationException {

		return getPersistence().findByUuid_PrevAndNext(
			educationId, uuid, orderByComparator);
	}

	/**
	 * Removes all the employee educations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of employee educations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee educations
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the employee education where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeEducationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee education
	 * @throws NoSuchEmployeeEducationException if a matching employee education could not be found
	 */
	public static EmployeeEducation findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeEducationException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee education where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee education, or <code>null</code> if a matching employee education could not be found
	 */
	public static EmployeeEducation fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee education where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee education, or <code>null</code> if a matching employee education could not be found
	 */
	public static EmployeeEducation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the employee education where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee education that was removed
	 */
	public static EmployeeEducation removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeEducationException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of employee educations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee educations
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the employee educations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee educations
	 */
	public static List<EmployeeEducation> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the employee educations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @return the range of matching employee educations
	 */
	public static List<EmployeeEducation> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee educations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee educations
	 */
	public static List<EmployeeEducation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeEducation> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee educations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee educations
	 */
	public static List<EmployeeEducation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeEducation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee education in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee education
	 * @throws NoSuchEmployeeEducationException if a matching employee education could not be found
	 */
	public static EmployeeEducation findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeEducation> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeEducationException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first employee education in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee education, or <code>null</code> if a matching employee education could not be found
	 */
	public static EmployeeEducation fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeEducation> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee education in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee education
	 * @throws NoSuchEmployeeEducationException if a matching employee education could not be found
	 */
	public static EmployeeEducation findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeEducation> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeEducationException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee education in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee education, or <code>null</code> if a matching employee education could not be found
	 */
	public static EmployeeEducation fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeEducation> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the employee educations before and after the current employee education in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param educationId the primary key of the current employee education
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee education
	 * @throws NoSuchEmployeeEducationException if a employee education with the primary key could not be found
	 */
	public static EmployeeEducation[] findByUuid_C_PrevAndNext(
			long educationId, String uuid, long companyId,
			OrderByComparator<EmployeeEducation> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeEducationException {

		return getPersistence().findByUuid_C_PrevAndNext(
			educationId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the employee educations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of employee educations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee educations
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the employee educations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee educations
	 */
	public static List<EmployeeEducation> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee educations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @return the range of matching employee educations
	 */
	public static List<EmployeeEducation> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee educations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee educations
	 */
	public static List<EmployeeEducation> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeEducation> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee educations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee educations
	 */
	public static List<EmployeeEducation> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeEducation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee education in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee education
	 * @throws NoSuchEmployeeEducationException if a matching employee education could not be found
	 */
	public static EmployeeEducation findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeEducation> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeEducationException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee education in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee education, or <code>null</code> if a matching employee education could not be found
	 */
	public static EmployeeEducation fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeEducation> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee education in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee education
	 * @throws NoSuchEmployeeEducationException if a matching employee education could not be found
	 */
	public static EmployeeEducation findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeEducation> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeEducationException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee education in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee education, or <code>null</code> if a matching employee education could not be found
	 */
	public static EmployeeEducation fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeEducation> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee educations before and after the current employee education in the ordered set where employeeId = &#63;.
	 *
	 * @param educationId the primary key of the current employee education
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee education
	 * @throws NoSuchEmployeeEducationException if a employee education with the primary key could not be found
	 */
	public static EmployeeEducation[] findByEmployeeId_PrevAndNext(
			long educationId, long employeeId,
			OrderByComparator<EmployeeEducation> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeEducationException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			educationId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee educations where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee educations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee educations
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Caches the employee education in the entity cache if it is enabled.
	 *
	 * @param employeeEducation the employee education
	 */
	public static void cacheResult(EmployeeEducation employeeEducation) {
		getPersistence().cacheResult(employeeEducation);
	}

	/**
	 * Caches the employee educations in the entity cache if it is enabled.
	 *
	 * @param employeeEducations the employee educations
	 */
	public static void cacheResult(List<EmployeeEducation> employeeEducations) {
		getPersistence().cacheResult(employeeEducations);
	}

	/**
	 * Creates a new employee education with the primary key. Does not add the employee education to the database.
	 *
	 * @param educationId the primary key for the new employee education
	 * @return the new employee education
	 */
	public static EmployeeEducation create(long educationId) {
		return getPersistence().create(educationId);
	}

	/**
	 * Removes the employee education with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param educationId the primary key of the employee education
	 * @return the employee education that was removed
	 * @throws NoSuchEmployeeEducationException if a employee education with the primary key could not be found
	 */
	public static EmployeeEducation remove(long educationId)
		throws com.ax.hrms.exception.NoSuchEmployeeEducationException {

		return getPersistence().remove(educationId);
	}

	public static EmployeeEducation updateImpl(
		EmployeeEducation employeeEducation) {

		return getPersistence().updateImpl(employeeEducation);
	}

	/**
	 * Returns the employee education with the primary key or throws a <code>NoSuchEmployeeEducationException</code> if it could not be found.
	 *
	 * @param educationId the primary key of the employee education
	 * @return the employee education
	 * @throws NoSuchEmployeeEducationException if a employee education with the primary key could not be found
	 */
	public static EmployeeEducation findByPrimaryKey(long educationId)
		throws com.ax.hrms.exception.NoSuchEmployeeEducationException {

		return getPersistence().findByPrimaryKey(educationId);
	}

	/**
	 * Returns the employee education with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param educationId the primary key of the employee education
	 * @return the employee education, or <code>null</code> if a employee education with the primary key could not be found
	 */
	public static EmployeeEducation fetchByPrimaryKey(long educationId) {
		return getPersistence().fetchByPrimaryKey(educationId);
	}

	/**
	 * Returns all the employee educations.
	 *
	 * @return the employee educations
	 */
	public static List<EmployeeEducation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee educations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @return the range of employee educations
	 */
	public static List<EmployeeEducation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee educations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee educations
	 */
	public static List<EmployeeEducation> findAll(
		int start, int end,
		OrderByComparator<EmployeeEducation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee educations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee educations
	 */
	public static List<EmployeeEducation> findAll(
		int start, int end,
		OrderByComparator<EmployeeEducation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee educations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee educations.
	 *
	 * @return the number of employee educations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeEducationPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		EmployeeEducationPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile EmployeeEducationPersistence _persistence;

}