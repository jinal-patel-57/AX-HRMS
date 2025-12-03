/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.ProjectEmployeeDetails;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the project employee details service. This utility wraps <code>com.ax.hrms.service.persistence.impl.ProjectEmployeeDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectEmployeeDetailsPersistence
 * @generated
 */
public class ProjectEmployeeDetailsUtil {

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
		ProjectEmployeeDetails projectEmployeeDetails) {

		getPersistence().clearCache(projectEmployeeDetails);
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
	public static Map<Serializable, ProjectEmployeeDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProjectEmployeeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectEmployeeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectEmployeeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjectEmployeeDetails update(
		ProjectEmployeeDetails projectEmployeeDetails) {

		return getPersistence().update(projectEmployeeDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjectEmployeeDetails update(
		ProjectEmployeeDetails projectEmployeeDetails,
		ServiceContext serviceContext) {

		return getPersistence().update(projectEmployeeDetails, serviceContext);
	}

	/**
	 * Returns all the project employee detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project employee detailses
	 */
	public static List<ProjectEmployeeDetails> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the project employee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @return the range of matching project employee detailses
	 */
	public static List<ProjectEmployeeDetails> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the project employee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project employee detailses
	 */
	public static List<ProjectEmployeeDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the project employee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project employee detailses
	 */
	public static List<ProjectEmployeeDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first project employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails findByUuid_First(
			String uuid,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first project employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails fetchByUuid_First(
		String uuid,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last project employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails findByUuid_Last(
			String uuid,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last project employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the project employee detailses before and after the current project employee details in the ordered set where uuid = &#63;.
	 *
	 * @param projectEmployeeDetailsId the primary key of the current project employee details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a project employee details with the primary key could not be found
	 */
	public static ProjectEmployeeDetails[] findByUuid_PrevAndNext(
			long projectEmployeeDetailsId, String uuid,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException {

		return getPersistence().findByUuid_PrevAndNext(
			projectEmployeeDetailsId, uuid, orderByComparator);
	}

	/**
	 * Removes all the project employee detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of project employee detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project employee detailses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the project employee details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProjectEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the project employee details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the project employee details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the project employee details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the project employee details that was removed
	 */
	public static ProjectEmployeeDetails removeByUUID_G(
			String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of project employee detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching project employee detailses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the project employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching project employee detailses
	 */
	public static List<ProjectEmployeeDetails> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the project employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @return the range of matching project employee detailses
	 */
	public static List<ProjectEmployeeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the project employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project employee detailses
	 */
	public static List<ProjectEmployeeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the project employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project employee detailses
	 */
	public static List<ProjectEmployeeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first project employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first project employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last project employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last project employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the project employee detailses before and after the current project employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param projectEmployeeDetailsId the primary key of the current project employee details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a project employee details with the primary key could not be found
	 */
	public static ProjectEmployeeDetails[] findByUuid_C_PrevAndNext(
			long projectEmployeeDetailsId, String uuid, long companyId,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException {

		return getPersistence().findByUuid_C_PrevAndNext(
			projectEmployeeDetailsId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the project employee detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of project employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching project employee detailses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the project employee detailses where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching project employee detailses
	 */
	public static List<ProjectEmployeeDetails> findByProjectId(long projectId) {
		return getPersistence().findByProjectId(projectId);
	}

	/**
	 * Returns a range of all the project employee detailses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @return the range of matching project employee detailses
	 */
	public static List<ProjectEmployeeDetails> findByProjectId(
		long projectId, int start, int end) {

		return getPersistence().findByProjectId(projectId, start, end);
	}

	/**
	 * Returns an ordered range of all the project employee detailses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project employee detailses
	 */
	public static List<ProjectEmployeeDetails> findByProjectId(
		long projectId, int start, int end,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		return getPersistence().findByProjectId(
			projectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the project employee detailses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project employee detailses
	 */
	public static List<ProjectEmployeeDetails> findByProjectId(
		long projectId, int start, int end,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProjectId(
			projectId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first project employee details in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails findByProjectId_First(
			long projectId,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException {

		return getPersistence().findByProjectId_First(
			projectId, orderByComparator);
	}

	/**
	 * Returns the first project employee details in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails fetchByProjectId_First(
		long projectId,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		return getPersistence().fetchByProjectId_First(
			projectId, orderByComparator);
	}

	/**
	 * Returns the last project employee details in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails findByProjectId_Last(
			long projectId,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException {

		return getPersistence().findByProjectId_Last(
			projectId, orderByComparator);
	}

	/**
	 * Returns the last project employee details in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails fetchByProjectId_Last(
		long projectId,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		return getPersistence().fetchByProjectId_Last(
			projectId, orderByComparator);
	}

	/**
	 * Returns the project employee detailses before and after the current project employee details in the ordered set where projectId = &#63;.
	 *
	 * @param projectEmployeeDetailsId the primary key of the current project employee details
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a project employee details with the primary key could not be found
	 */
	public static ProjectEmployeeDetails[] findByProjectId_PrevAndNext(
			long projectEmployeeDetailsId, long projectId,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException {

		return getPersistence().findByProjectId_PrevAndNext(
			projectEmployeeDetailsId, projectId, orderByComparator);
	}

	/**
	 * Removes all the project employee detailses where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	public static void removeByProjectId(long projectId) {
		getPersistence().removeByProjectId(projectId);
	}

	/**
	 * Returns the number of project employee detailses where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching project employee detailses
	 */
	public static int countByProjectId(long projectId) {
		return getPersistence().countByProjectId(projectId);
	}

	/**
	 * Returns all the project employee detailses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching project employee detailses
	 */
	public static List<ProjectEmployeeDetails> findByEmployeeId(
		long employeeId) {

		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the project employee detailses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @return the range of matching project employee detailses
	 */
	public static List<ProjectEmployeeDetails> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the project employee detailses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project employee detailses
	 */
	public static List<ProjectEmployeeDetails> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the project employee detailses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project employee detailses
	 */
	public static List<ProjectEmployeeDetails> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first project employee details in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails findByEmployeeId_First(
			long employeeId,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first project employee details in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last project employee details in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last project employee details in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the project employee detailses before and after the current project employee details in the ordered set where employeeId = &#63;.
	 *
	 * @param projectEmployeeDetailsId the primary key of the current project employee details
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a project employee details with the primary key could not be found
	 */
	public static ProjectEmployeeDetails[] findByEmployeeId_PrevAndNext(
			long projectEmployeeDetailsId, long employeeId,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator)
		throws com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			projectEmployeeDetailsId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the project employee detailses where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of project employee detailses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching project employee detailses
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns the project employee details where projectId = &#63; and employeeId = &#63; or throws a <code>NoSuchProjectEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @return the matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails findByProjectIdAndEmployeeId(
			long projectId, long employeeId)
		throws com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException {

		return getPersistence().findByProjectIdAndEmployeeId(
			projectId, employeeId);
	}

	/**
	 * Returns the project employee details where projectId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @return the matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails fetchByProjectIdAndEmployeeId(
		long projectId, long employeeId) {

		return getPersistence().fetchByProjectIdAndEmployeeId(
			projectId, employeeId);
	}

	/**
	 * Returns the project employee details where projectId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public static ProjectEmployeeDetails fetchByProjectIdAndEmployeeId(
		long projectId, long employeeId, boolean useFinderCache) {

		return getPersistence().fetchByProjectIdAndEmployeeId(
			projectId, employeeId, useFinderCache);
	}

	/**
	 * Removes the project employee details where projectId = &#63; and employeeId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @return the project employee details that was removed
	 */
	public static ProjectEmployeeDetails removeByProjectIdAndEmployeeId(
			long projectId, long employeeId)
		throws com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException {

		return getPersistence().removeByProjectIdAndEmployeeId(
			projectId, employeeId);
	}

	/**
	 * Returns the number of project employee detailses where projectId = &#63; and employeeId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @return the number of matching project employee detailses
	 */
	public static int countByProjectIdAndEmployeeId(
		long projectId, long employeeId) {

		return getPersistence().countByProjectIdAndEmployeeId(
			projectId, employeeId);
	}

	/**
	 * Caches the project employee details in the entity cache if it is enabled.
	 *
	 * @param projectEmployeeDetails the project employee details
	 */
	public static void cacheResult(
		ProjectEmployeeDetails projectEmployeeDetails) {

		getPersistence().cacheResult(projectEmployeeDetails);
	}

	/**
	 * Caches the project employee detailses in the entity cache if it is enabled.
	 *
	 * @param projectEmployeeDetailses the project employee detailses
	 */
	public static void cacheResult(
		List<ProjectEmployeeDetails> projectEmployeeDetailses) {

		getPersistence().cacheResult(projectEmployeeDetailses);
	}

	/**
	 * Creates a new project employee details with the primary key. Does not add the project employee details to the database.
	 *
	 * @param projectEmployeeDetailsId the primary key for the new project employee details
	 * @return the new project employee details
	 */
	public static ProjectEmployeeDetails create(long projectEmployeeDetailsId) {
		return getPersistence().create(projectEmployeeDetailsId);
	}

	/**
	 * Removes the project employee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectEmployeeDetailsId the primary key of the project employee details
	 * @return the project employee details that was removed
	 * @throws NoSuchProjectEmployeeDetailsException if a project employee details with the primary key could not be found
	 */
	public static ProjectEmployeeDetails remove(long projectEmployeeDetailsId)
		throws com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException {

		return getPersistence().remove(projectEmployeeDetailsId);
	}

	public static ProjectEmployeeDetails updateImpl(
		ProjectEmployeeDetails projectEmployeeDetails) {

		return getPersistence().updateImpl(projectEmployeeDetails);
	}

	/**
	 * Returns the project employee details with the primary key or throws a <code>NoSuchProjectEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param projectEmployeeDetailsId the primary key of the project employee details
	 * @return the project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a project employee details with the primary key could not be found
	 */
	public static ProjectEmployeeDetails findByPrimaryKey(
			long projectEmployeeDetailsId)
		throws com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException {

		return getPersistence().findByPrimaryKey(projectEmployeeDetailsId);
	}

	/**
	 * Returns the project employee details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectEmployeeDetailsId the primary key of the project employee details
	 * @return the project employee details, or <code>null</code> if a project employee details with the primary key could not be found
	 */
	public static ProjectEmployeeDetails fetchByPrimaryKey(
		long projectEmployeeDetailsId) {

		return getPersistence().fetchByPrimaryKey(projectEmployeeDetailsId);
	}

	/**
	 * Returns all the project employee detailses.
	 *
	 * @return the project employee detailses
	 */
	public static List<ProjectEmployeeDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the project employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @return the range of project employee detailses
	 */
	public static List<ProjectEmployeeDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the project employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project employee detailses
	 */
	public static List<ProjectEmployeeDetails> findAll(
		int start, int end,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the project employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of project employee detailses
	 */
	public static List<ProjectEmployeeDetails> findAll(
		int start, int end,
		OrderByComparator<ProjectEmployeeDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the project employee detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of project employee detailses.
	 *
	 * @return the number of project employee detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProjectEmployeeDetailsPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		ProjectEmployeeDetailsPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile ProjectEmployeeDetailsPersistence _persistence;

}