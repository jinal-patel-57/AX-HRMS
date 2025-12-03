/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.ProjectHistory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the project history service. This utility wraps <code>com.ax.hrms.service.persistence.impl.ProjectHistoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectHistoryPersistence
 * @generated
 */
public class ProjectHistoryUtil {

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
	public static void clearCache(ProjectHistory projectHistory) {
		getPersistence().clearCache(projectHistory);
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
	public static Map<Serializable, ProjectHistory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProjectHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjectHistory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjectHistory update(ProjectHistory projectHistory) {
		return getPersistence().update(projectHistory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjectHistory update(
		ProjectHistory projectHistory, ServiceContext serviceContext) {

		return getPersistence().update(projectHistory, serviceContext);
	}

	/**
	 * Returns all the project histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project histories
	 */
	public static List<ProjectHistory> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the project histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @return the range of matching project histories
	 */
	public static List<ProjectHistory> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the project histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project histories
	 */
	public static List<ProjectHistory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProjectHistory> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the project histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project histories
	 */
	public static List<ProjectHistory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProjectHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first project history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project history
	 * @throws NoSuchProjectHistoryException if a matching project history could not be found
	 */
	public static ProjectHistory findByUuid_First(
			String uuid, OrderByComparator<ProjectHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchProjectHistoryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first project history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project history, or <code>null</code> if a matching project history could not be found
	 */
	public static ProjectHistory fetchByUuid_First(
		String uuid, OrderByComparator<ProjectHistory> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last project history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project history
	 * @throws NoSuchProjectHistoryException if a matching project history could not be found
	 */
	public static ProjectHistory findByUuid_Last(
			String uuid, OrderByComparator<ProjectHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchProjectHistoryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last project history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project history, or <code>null</code> if a matching project history could not be found
	 */
	public static ProjectHistory fetchByUuid_Last(
		String uuid, OrderByComparator<ProjectHistory> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the project histories before and after the current project history in the ordered set where uuid = &#63;.
	 *
	 * @param projectHistoryId the primary key of the current project history
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project history
	 * @throws NoSuchProjectHistoryException if a project history with the primary key could not be found
	 */
	public static ProjectHistory[] findByUuid_PrevAndNext(
			long projectHistoryId, String uuid,
			OrderByComparator<ProjectHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchProjectHistoryException {

		return getPersistence().findByUuid_PrevAndNext(
			projectHistoryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the project histories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of project histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project histories
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the project history where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProjectHistoryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project history
	 * @throws NoSuchProjectHistoryException if a matching project history could not be found
	 */
	public static ProjectHistory findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchProjectHistoryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the project history where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project history, or <code>null</code> if a matching project history could not be found
	 */
	public static ProjectHistory fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the project history where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project history, or <code>null</code> if a matching project history could not be found
	 */
	public static ProjectHistory fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the project history where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the project history that was removed
	 */
	public static ProjectHistory removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchProjectHistoryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of project histories where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching project histories
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the project histories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching project histories
	 */
	public static List<ProjectHistory> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the project histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @return the range of matching project histories
	 */
	public static List<ProjectHistory> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the project histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project histories
	 */
	public static List<ProjectHistory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProjectHistory> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the project histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project histories
	 */
	public static List<ProjectHistory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProjectHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first project history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project history
	 * @throws NoSuchProjectHistoryException if a matching project history could not be found
	 */
	public static ProjectHistory findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProjectHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchProjectHistoryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first project history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project history, or <code>null</code> if a matching project history could not be found
	 */
	public static ProjectHistory fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProjectHistory> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last project history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project history
	 * @throws NoSuchProjectHistoryException if a matching project history could not be found
	 */
	public static ProjectHistory findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProjectHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchProjectHistoryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last project history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project history, or <code>null</code> if a matching project history could not be found
	 */
	public static ProjectHistory fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProjectHistory> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the project histories before and after the current project history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param projectHistoryId the primary key of the current project history
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project history
	 * @throws NoSuchProjectHistoryException if a project history with the primary key could not be found
	 */
	public static ProjectHistory[] findByUuid_C_PrevAndNext(
			long projectHistoryId, String uuid, long companyId,
			OrderByComparator<ProjectHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchProjectHistoryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			projectHistoryId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the project histories where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of project histories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching project histories
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the project histories where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @return the matching project histories
	 */
	public static List<ProjectHistory> findByManagerId(long managerId) {
		return getPersistence().findByManagerId(managerId);
	}

	/**
	 * Returns a range of all the project histories where managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @return the range of matching project histories
	 */
	public static List<ProjectHistory> findByManagerId(
		long managerId, int start, int end) {

		return getPersistence().findByManagerId(managerId, start, end);
	}

	/**
	 * Returns an ordered range of all the project histories where managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project histories
	 */
	public static List<ProjectHistory> findByManagerId(
		long managerId, int start, int end,
		OrderByComparator<ProjectHistory> orderByComparator) {

		return getPersistence().findByManagerId(
			managerId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the project histories where managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project histories
	 */
	public static List<ProjectHistory> findByManagerId(
		long managerId, int start, int end,
		OrderByComparator<ProjectHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByManagerId(
			managerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first project history in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project history
	 * @throws NoSuchProjectHistoryException if a matching project history could not be found
	 */
	public static ProjectHistory findByManagerId_First(
			long managerId, OrderByComparator<ProjectHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchProjectHistoryException {

		return getPersistence().findByManagerId_First(
			managerId, orderByComparator);
	}

	/**
	 * Returns the first project history in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project history, or <code>null</code> if a matching project history could not be found
	 */
	public static ProjectHistory fetchByManagerId_First(
		long managerId, OrderByComparator<ProjectHistory> orderByComparator) {

		return getPersistence().fetchByManagerId_First(
			managerId, orderByComparator);
	}

	/**
	 * Returns the last project history in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project history
	 * @throws NoSuchProjectHistoryException if a matching project history could not be found
	 */
	public static ProjectHistory findByManagerId_Last(
			long managerId, OrderByComparator<ProjectHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchProjectHistoryException {

		return getPersistence().findByManagerId_Last(
			managerId, orderByComparator);
	}

	/**
	 * Returns the last project history in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project history, or <code>null</code> if a matching project history could not be found
	 */
	public static ProjectHistory fetchByManagerId_Last(
		long managerId, OrderByComparator<ProjectHistory> orderByComparator) {

		return getPersistence().fetchByManagerId_Last(
			managerId, orderByComparator);
	}

	/**
	 * Returns the project histories before and after the current project history in the ordered set where managerId = &#63;.
	 *
	 * @param projectHistoryId the primary key of the current project history
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project history
	 * @throws NoSuchProjectHistoryException if a project history with the primary key could not be found
	 */
	public static ProjectHistory[] findByManagerId_PrevAndNext(
			long projectHistoryId, long managerId,
			OrderByComparator<ProjectHistory> orderByComparator)
		throws com.ax.hrms.exception.NoSuchProjectHistoryException {

		return getPersistence().findByManagerId_PrevAndNext(
			projectHistoryId, managerId, orderByComparator);
	}

	/**
	 * Removes all the project histories where managerId = &#63; from the database.
	 *
	 * @param managerId the manager ID
	 */
	public static void removeByManagerId(long managerId) {
		getPersistence().removeByManagerId(managerId);
	}

	/**
	 * Returns the number of project histories where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @return the number of matching project histories
	 */
	public static int countByManagerId(long managerId) {
		return getPersistence().countByManagerId(managerId);
	}

	/**
	 * Returns the project history where projectId = &#63; or throws a <code>NoSuchProjectHistoryException</code> if it could not be found.
	 *
	 * @param projectId the project ID
	 * @return the matching project history
	 * @throws NoSuchProjectHistoryException if a matching project history could not be found
	 */
	public static ProjectHistory findByProjectId(long projectId)
		throws com.ax.hrms.exception.NoSuchProjectHistoryException {

		return getPersistence().findByProjectId(projectId);
	}

	/**
	 * Returns the project history where projectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param projectId the project ID
	 * @return the matching project history, or <code>null</code> if a matching project history could not be found
	 */
	public static ProjectHistory fetchByProjectId(long projectId) {
		return getPersistence().fetchByProjectId(projectId);
	}

	/**
	 * Returns the project history where projectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param projectId the project ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project history, or <code>null</code> if a matching project history could not be found
	 */
	public static ProjectHistory fetchByProjectId(
		long projectId, boolean useFinderCache) {

		return getPersistence().fetchByProjectId(projectId, useFinderCache);
	}

	/**
	 * Removes the project history where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @return the project history that was removed
	 */
	public static ProjectHistory removeByProjectId(long projectId)
		throws com.ax.hrms.exception.NoSuchProjectHistoryException {

		return getPersistence().removeByProjectId(projectId);
	}

	/**
	 * Returns the number of project histories where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching project histories
	 */
	public static int countByProjectId(long projectId) {
		return getPersistence().countByProjectId(projectId);
	}

	/**
	 * Caches the project history in the entity cache if it is enabled.
	 *
	 * @param projectHistory the project history
	 */
	public static void cacheResult(ProjectHistory projectHistory) {
		getPersistence().cacheResult(projectHistory);
	}

	/**
	 * Caches the project histories in the entity cache if it is enabled.
	 *
	 * @param projectHistories the project histories
	 */
	public static void cacheResult(List<ProjectHistory> projectHistories) {
		getPersistence().cacheResult(projectHistories);
	}

	/**
	 * Creates a new project history with the primary key. Does not add the project history to the database.
	 *
	 * @param projectHistoryId the primary key for the new project history
	 * @return the new project history
	 */
	public static ProjectHistory create(long projectHistoryId) {
		return getPersistence().create(projectHistoryId);
	}

	/**
	 * Removes the project history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectHistoryId the primary key of the project history
	 * @return the project history that was removed
	 * @throws NoSuchProjectHistoryException if a project history with the primary key could not be found
	 */
	public static ProjectHistory remove(long projectHistoryId)
		throws com.ax.hrms.exception.NoSuchProjectHistoryException {

		return getPersistence().remove(projectHistoryId);
	}

	public static ProjectHistory updateImpl(ProjectHistory projectHistory) {
		return getPersistence().updateImpl(projectHistory);
	}

	/**
	 * Returns the project history with the primary key or throws a <code>NoSuchProjectHistoryException</code> if it could not be found.
	 *
	 * @param projectHistoryId the primary key of the project history
	 * @return the project history
	 * @throws NoSuchProjectHistoryException if a project history with the primary key could not be found
	 */
	public static ProjectHistory findByPrimaryKey(long projectHistoryId)
		throws com.ax.hrms.exception.NoSuchProjectHistoryException {

		return getPersistence().findByPrimaryKey(projectHistoryId);
	}

	/**
	 * Returns the project history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectHistoryId the primary key of the project history
	 * @return the project history, or <code>null</code> if a project history with the primary key could not be found
	 */
	public static ProjectHistory fetchByPrimaryKey(long projectHistoryId) {
		return getPersistence().fetchByPrimaryKey(projectHistoryId);
	}

	/**
	 * Returns all the project histories.
	 *
	 * @return the project histories
	 */
	public static List<ProjectHistory> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the project histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @return the range of project histories
	 */
	public static List<ProjectHistory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the project histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project histories
	 */
	public static List<ProjectHistory> findAll(
		int start, int end,
		OrderByComparator<ProjectHistory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the project histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of project histories
	 */
	public static List<ProjectHistory> findAll(
		int start, int end, OrderByComparator<ProjectHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the project histories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of project histories.
	 *
	 * @return the number of project histories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProjectHistoryPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ProjectHistoryPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ProjectHistoryPersistence _persistence;

}