/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.EmployeeExperience;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the employee experience service. This utility wraps <code>com.ax.hrms.service.persistence.impl.EmployeeExperiencePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeExperiencePersistence
 * @generated
 */
public class EmployeeExperienceUtil {

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
	public static void clearCache(EmployeeExperience employeeExperience) {
		getPersistence().clearCache(employeeExperience);
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
	public static Map<Serializable, EmployeeExperience> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeExperience> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeExperience> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeExperience> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeExperience update(
		EmployeeExperience employeeExperience) {

		return getPersistence().update(employeeExperience);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeExperience update(
		EmployeeExperience employeeExperience, ServiceContext serviceContext) {

		return getPersistence().update(employeeExperience, serviceContext);
	}

	/**
	 * Returns all the employee experiences where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee experiences
	 */
	public static List<EmployeeExperience> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the employee experiences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @return the range of matching employee experiences
	 */
	public static List<EmployeeExperience> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the employee experiences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee experiences
	 */
	public static List<EmployeeExperience> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee experiences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee experiences
	 */
	public static List<EmployeeExperience> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public static EmployeeExperience findByUuid_First(
			String uuid,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeExperienceException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first employee experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public static EmployeeExperience fetchByUuid_First(
		String uuid, OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public static EmployeeExperience findByUuid_Last(
			String uuid,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeExperienceException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public static EmployeeExperience fetchByUuid_Last(
		String uuid, OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the employee experiences before and after the current employee experience in the ordered set where uuid = &#63;.
	 *
	 * @param experienceId the primary key of the current employee experience
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	public static EmployeeExperience[] findByUuid_PrevAndNext(
			long experienceId, String uuid,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeExperienceException {

		return getPersistence().findByUuid_PrevAndNext(
			experienceId, uuid, orderByComparator);
	}

	/**
	 * Removes all the employee experiences where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of employee experiences where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee experiences
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the employee experience where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeExperienceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public static EmployeeExperience findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeExperienceException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee experience where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public static EmployeeExperience fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee experience where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public static EmployeeExperience fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the employee experience where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee experience that was removed
	 */
	public static EmployeeExperience removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeExperienceException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of employee experiences where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee experiences
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the employee experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee experiences
	 */
	public static List<EmployeeExperience> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the employee experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @return the range of matching employee experiences
	 */
	public static List<EmployeeExperience> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee experiences
	 */
	public static List<EmployeeExperience> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee experiences
	 */
	public static List<EmployeeExperience> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public static EmployeeExperience findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeExperienceException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first employee experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public static EmployeeExperience fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public static EmployeeExperience findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeExperienceException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public static EmployeeExperience fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the employee experiences before and after the current employee experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param experienceId the primary key of the current employee experience
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	public static EmployeeExperience[] findByUuid_C_PrevAndNext(
			long experienceId, String uuid, long companyId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeExperienceException {

		return getPersistence().findByUuid_C_PrevAndNext(
			experienceId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the employee experiences where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of employee experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee experiences
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the employee experiences where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee experiences
	 */
	public static List<EmployeeExperience> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee experiences where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @return the range of matching employee experiences
	 */
	public static List<EmployeeExperience> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee experiences where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee experiences
	 */
	public static List<EmployeeExperience> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee experiences where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee experiences
	 */
	public static List<EmployeeExperience> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public static EmployeeExperience findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeExperienceException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public static EmployeeExperience fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public static EmployeeExperience findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeExperienceException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public static EmployeeExperience fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee experiences before and after the current employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param experienceId the primary key of the current employee experience
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	public static EmployeeExperience[] findByEmployeeId_PrevAndNext(
			long experienceId, long employeeId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeExperienceException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			experienceId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee experiences where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee experiences where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee experiences
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Caches the employee experience in the entity cache if it is enabled.
	 *
	 * @param employeeExperience the employee experience
	 */
	public static void cacheResult(EmployeeExperience employeeExperience) {
		getPersistence().cacheResult(employeeExperience);
	}

	/**
	 * Caches the employee experiences in the entity cache if it is enabled.
	 *
	 * @param employeeExperiences the employee experiences
	 */
	public static void cacheResult(
		List<EmployeeExperience> employeeExperiences) {

		getPersistence().cacheResult(employeeExperiences);
	}

	/**
	 * Creates a new employee experience with the primary key. Does not add the employee experience to the database.
	 *
	 * @param experienceId the primary key for the new employee experience
	 * @return the new employee experience
	 */
	public static EmployeeExperience create(long experienceId) {
		return getPersistence().create(experienceId);
	}

	/**
	 * Removes the employee experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param experienceId the primary key of the employee experience
	 * @return the employee experience that was removed
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	public static EmployeeExperience remove(long experienceId)
		throws com.ax.hrms.exception.NoSuchEmployeeExperienceException {

		return getPersistence().remove(experienceId);
	}

	public static EmployeeExperience updateImpl(
		EmployeeExperience employeeExperience) {

		return getPersistence().updateImpl(employeeExperience);
	}

	/**
	 * Returns the employee experience with the primary key or throws a <code>NoSuchEmployeeExperienceException</code> if it could not be found.
	 *
	 * @param experienceId the primary key of the employee experience
	 * @return the employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	public static EmployeeExperience findByPrimaryKey(long experienceId)
		throws com.ax.hrms.exception.NoSuchEmployeeExperienceException {

		return getPersistence().findByPrimaryKey(experienceId);
	}

	/**
	 * Returns the employee experience with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param experienceId the primary key of the employee experience
	 * @return the employee experience, or <code>null</code> if a employee experience with the primary key could not be found
	 */
	public static EmployeeExperience fetchByPrimaryKey(long experienceId) {
		return getPersistence().fetchByPrimaryKey(experienceId);
	}

	/**
	 * Returns all the employee experiences.
	 *
	 * @return the employee experiences
	 */
	public static List<EmployeeExperience> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @return the range of employee experiences
	 */
	public static List<EmployeeExperience> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee experiences
	 */
	public static List<EmployeeExperience> findAll(
		int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee experiences
	 */
	public static List<EmployeeExperience> findAll(
		int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee experiences from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee experiences.
	 *
	 * @return the number of employee experiences
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeExperiencePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		EmployeeExperiencePersistence persistence) {

		_persistence = persistence;
	}

	private static volatile EmployeeExperiencePersistence _persistence;

}