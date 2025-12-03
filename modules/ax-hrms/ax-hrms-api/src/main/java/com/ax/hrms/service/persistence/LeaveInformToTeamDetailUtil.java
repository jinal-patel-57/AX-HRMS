/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.LeaveInformToTeamDetail;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the leave inform to team detail service. This utility wraps <code>com.ax.hrms.service.persistence.impl.LeaveInformToTeamDetailPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveInformToTeamDetailPersistence
 * @generated
 */
public class LeaveInformToTeamDetailUtil {

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
		LeaveInformToTeamDetail leaveInformToTeamDetail) {

		getPersistence().clearCache(leaveInformToTeamDetail);
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
	public static Map<Serializable, LeaveInformToTeamDetail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LeaveInformToTeamDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LeaveInformToTeamDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LeaveInformToTeamDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LeaveInformToTeamDetail update(
		LeaveInformToTeamDetail leaveInformToTeamDetail) {

		return getPersistence().update(leaveInformToTeamDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LeaveInformToTeamDetail update(
		LeaveInformToTeamDetail leaveInformToTeamDetail,
		ServiceContext serviceContext) {

		return getPersistence().update(leaveInformToTeamDetail, serviceContext);
	}

	/**
	 * Returns all the leave inform to team details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave inform to team details
	 */
	public static List<LeaveInformToTeamDetail> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the leave inform to team details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @return the range of matching leave inform to team details
	 */
	public static List<LeaveInformToTeamDetail> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the leave inform to team details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave inform to team details
	 */
	public static List<LeaveInformToTeamDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave inform to team details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave inform to team details
	 */
	public static List<LeaveInformToTeamDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave inform to team detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a matching leave inform to team detail could not be found
	 */
	public static LeaveInformToTeamDetail findByUuid_First(
			String uuid,
			OrderByComparator<LeaveInformToTeamDetail> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveInformToTeamDetailException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first leave inform to team detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	public static LeaveInformToTeamDetail fetchByUuid_First(
		String uuid,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last leave inform to team detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a matching leave inform to team detail could not be found
	 */
	public static LeaveInformToTeamDetail findByUuid_Last(
			String uuid,
			OrderByComparator<LeaveInformToTeamDetail> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveInformToTeamDetailException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last leave inform to team detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	public static LeaveInformToTeamDetail fetchByUuid_Last(
		String uuid,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the leave inform to team details before and after the current leave inform to team detail in the ordered set where uuid = &#63;.
	 *
	 * @param leaveInformId the primary key of the current leave inform to team detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a leave inform to team detail with the primary key could not be found
	 */
	public static LeaveInformToTeamDetail[] findByUuid_PrevAndNext(
			long leaveInformId, String uuid,
			OrderByComparator<LeaveInformToTeamDetail> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveInformToTeamDetailException {

		return getPersistence().findByUuid_PrevAndNext(
			leaveInformId, uuid, orderByComparator);
	}

	/**
	 * Removes all the leave inform to team details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of leave inform to team details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave inform to team details
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the leave inform to team detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveInformToTeamDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a matching leave inform to team detail could not be found
	 */
	public static LeaveInformToTeamDetail findByUUID_G(
			String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchLeaveInformToTeamDetailException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the leave inform to team detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	public static LeaveInformToTeamDetail fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the leave inform to team detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	public static LeaveInformToTeamDetail fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the leave inform to team detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave inform to team detail that was removed
	 */
	public static LeaveInformToTeamDetail removeByUUID_G(
			String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchLeaveInformToTeamDetailException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of leave inform to team details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave inform to team details
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the leave inform to team details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave inform to team details
	 */
	public static List<LeaveInformToTeamDetail> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the leave inform to team details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @return the range of matching leave inform to team details
	 */
	public static List<LeaveInformToTeamDetail> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the leave inform to team details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave inform to team details
	 */
	public static List<LeaveInformToTeamDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave inform to team details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave inform to team details
	 */
	public static List<LeaveInformToTeamDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave inform to team detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a matching leave inform to team detail could not be found
	 */
	public static LeaveInformToTeamDetail findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LeaveInformToTeamDetail> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveInformToTeamDetailException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first leave inform to team detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	public static LeaveInformToTeamDetail fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last leave inform to team detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a matching leave inform to team detail could not be found
	 */
	public static LeaveInformToTeamDetail findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LeaveInformToTeamDetail> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveInformToTeamDetailException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last leave inform to team detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	public static LeaveInformToTeamDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the leave inform to team details before and after the current leave inform to team detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveInformId the primary key of the current leave inform to team detail
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a leave inform to team detail with the primary key could not be found
	 */
	public static LeaveInformToTeamDetail[] findByUuid_C_PrevAndNext(
			long leaveInformId, String uuid, long companyId,
			OrderByComparator<LeaveInformToTeamDetail> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveInformToTeamDetailException {

		return getPersistence().findByUuid_C_PrevAndNext(
			leaveInformId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the leave inform to team details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of leave inform to team details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave inform to team details
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the leave inform to team details where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @return the matching leave inform to team details
	 */
	public static List<LeaveInformToTeamDetail> findByLeaveRequestId(
		long leaveRequestId) {

		return getPersistence().findByLeaveRequestId(leaveRequestId);
	}

	/**
	 * Returns a range of all the leave inform to team details where leaveRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param leaveRequestId the leave request ID
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @return the range of matching leave inform to team details
	 */
	public static List<LeaveInformToTeamDetail> findByLeaveRequestId(
		long leaveRequestId, int start, int end) {

		return getPersistence().findByLeaveRequestId(
			leaveRequestId, start, end);
	}

	/**
	 * Returns an ordered range of all the leave inform to team details where leaveRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param leaveRequestId the leave request ID
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave inform to team details
	 */
	public static List<LeaveInformToTeamDetail> findByLeaveRequestId(
		long leaveRequestId, int start, int end,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator) {

		return getPersistence().findByLeaveRequestId(
			leaveRequestId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave inform to team details where leaveRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param leaveRequestId the leave request ID
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave inform to team details
	 */
	public static List<LeaveInformToTeamDetail> findByLeaveRequestId(
		long leaveRequestId, int start, int end,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLeaveRequestId(
			leaveRequestId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave inform to team detail in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a matching leave inform to team detail could not be found
	 */
	public static LeaveInformToTeamDetail findByLeaveRequestId_First(
			long leaveRequestId,
			OrderByComparator<LeaveInformToTeamDetail> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveInformToTeamDetailException {

		return getPersistence().findByLeaveRequestId_First(
			leaveRequestId, orderByComparator);
	}

	/**
	 * Returns the first leave inform to team detail in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	public static LeaveInformToTeamDetail fetchByLeaveRequestId_First(
		long leaveRequestId,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator) {

		return getPersistence().fetchByLeaveRequestId_First(
			leaveRequestId, orderByComparator);
	}

	/**
	 * Returns the last leave inform to team detail in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a matching leave inform to team detail could not be found
	 */
	public static LeaveInformToTeamDetail findByLeaveRequestId_Last(
			long leaveRequestId,
			OrderByComparator<LeaveInformToTeamDetail> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveInformToTeamDetailException {

		return getPersistence().findByLeaveRequestId_Last(
			leaveRequestId, orderByComparator);
	}

	/**
	 * Returns the last leave inform to team detail in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	public static LeaveInformToTeamDetail fetchByLeaveRequestId_Last(
		long leaveRequestId,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator) {

		return getPersistence().fetchByLeaveRequestId_Last(
			leaveRequestId, orderByComparator);
	}

	/**
	 * Returns the leave inform to team details before and after the current leave inform to team detail in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveInformId the primary key of the current leave inform to team detail
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a leave inform to team detail with the primary key could not be found
	 */
	public static LeaveInformToTeamDetail[] findByLeaveRequestId_PrevAndNext(
			long leaveInformId, long leaveRequestId,
			OrderByComparator<LeaveInformToTeamDetail> orderByComparator)
		throws com.ax.hrms.exception.NoSuchLeaveInformToTeamDetailException {

		return getPersistence().findByLeaveRequestId_PrevAndNext(
			leaveInformId, leaveRequestId, orderByComparator);
	}

	/**
	 * Removes all the leave inform to team details where leaveRequestId = &#63; from the database.
	 *
	 * @param leaveRequestId the leave request ID
	 */
	public static void removeByLeaveRequestId(long leaveRequestId) {
		getPersistence().removeByLeaveRequestId(leaveRequestId);
	}

	/**
	 * Returns the number of leave inform to team details where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @return the number of matching leave inform to team details
	 */
	public static int countByLeaveRequestId(long leaveRequestId) {
		return getPersistence().countByLeaveRequestId(leaveRequestId);
	}

	/**
	 * Caches the leave inform to team detail in the entity cache if it is enabled.
	 *
	 * @param leaveInformToTeamDetail the leave inform to team detail
	 */
	public static void cacheResult(
		LeaveInformToTeamDetail leaveInformToTeamDetail) {

		getPersistence().cacheResult(leaveInformToTeamDetail);
	}

	/**
	 * Caches the leave inform to team details in the entity cache if it is enabled.
	 *
	 * @param leaveInformToTeamDetails the leave inform to team details
	 */
	public static void cacheResult(
		List<LeaveInformToTeamDetail> leaveInformToTeamDetails) {

		getPersistence().cacheResult(leaveInformToTeamDetails);
	}

	/**
	 * Creates a new leave inform to team detail with the primary key. Does not add the leave inform to team detail to the database.
	 *
	 * @param leaveInformId the primary key for the new leave inform to team detail
	 * @return the new leave inform to team detail
	 */
	public static LeaveInformToTeamDetail create(long leaveInformId) {
		return getPersistence().create(leaveInformId);
	}

	/**
	 * Removes the leave inform to team detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveInformId the primary key of the leave inform to team detail
	 * @return the leave inform to team detail that was removed
	 * @throws NoSuchLeaveInformToTeamDetailException if a leave inform to team detail with the primary key could not be found
	 */
	public static LeaveInformToTeamDetail remove(long leaveInformId)
		throws com.ax.hrms.exception.NoSuchLeaveInformToTeamDetailException {

		return getPersistence().remove(leaveInformId);
	}

	public static LeaveInformToTeamDetail updateImpl(
		LeaveInformToTeamDetail leaveInformToTeamDetail) {

		return getPersistence().updateImpl(leaveInformToTeamDetail);
	}

	/**
	 * Returns the leave inform to team detail with the primary key or throws a <code>NoSuchLeaveInformToTeamDetailException</code> if it could not be found.
	 *
	 * @param leaveInformId the primary key of the leave inform to team detail
	 * @return the leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a leave inform to team detail with the primary key could not be found
	 */
	public static LeaveInformToTeamDetail findByPrimaryKey(long leaveInformId)
		throws com.ax.hrms.exception.NoSuchLeaveInformToTeamDetailException {

		return getPersistence().findByPrimaryKey(leaveInformId);
	}

	/**
	 * Returns the leave inform to team detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveInformId the primary key of the leave inform to team detail
	 * @return the leave inform to team detail, or <code>null</code> if a leave inform to team detail with the primary key could not be found
	 */
	public static LeaveInformToTeamDetail fetchByPrimaryKey(
		long leaveInformId) {

		return getPersistence().fetchByPrimaryKey(leaveInformId);
	}

	/**
	 * Returns all the leave inform to team details.
	 *
	 * @return the leave inform to team details
	 */
	public static List<LeaveInformToTeamDetail> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the leave inform to team details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @return the range of leave inform to team details
	 */
	public static List<LeaveInformToTeamDetail> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the leave inform to team details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave inform to team details
	 */
	public static List<LeaveInformToTeamDetail> findAll(
		int start, int end,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave inform to team details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveInformToTeamDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave inform to team details
	 * @param end the upper bound of the range of leave inform to team details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave inform to team details
	 */
	public static List<LeaveInformToTeamDetail> findAll(
		int start, int end,
		OrderByComparator<LeaveInformToTeamDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the leave inform to team details from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of leave inform to team details.
	 *
	 * @return the number of leave inform to team details
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LeaveInformToTeamDetailPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		LeaveInformToTeamDetailPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile LeaveInformToTeamDetailPersistence _persistence;

}