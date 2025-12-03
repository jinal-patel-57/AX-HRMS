/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.AppraisalMeetingInvitees;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the appraisal meeting invitees service. This utility wraps <code>com.ax.hrms.service.persistence.impl.AppraisalMeetingInviteesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalMeetingInviteesPersistence
 * @generated
 */
public class AppraisalMeetingInviteesUtil {

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
		AppraisalMeetingInvitees appraisalMeetingInvitees) {

		getPersistence().clearCache(appraisalMeetingInvitees);
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
	public static Map<Serializable, AppraisalMeetingInvitees>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AppraisalMeetingInvitees> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AppraisalMeetingInvitees> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AppraisalMeetingInvitees> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AppraisalMeetingInvitees update(
		AppraisalMeetingInvitees appraisalMeetingInvitees) {

		return getPersistence().update(appraisalMeetingInvitees);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AppraisalMeetingInvitees update(
		AppraisalMeetingInvitees appraisalMeetingInvitees,
		ServiceContext serviceContext) {

		return getPersistence().update(
			appraisalMeetingInvitees, serviceContext);
	}

	/**
	 * Returns all the appraisal meeting inviteeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching appraisal meeting inviteeses
	 */
	public static List<AppraisalMeetingInvitees> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the appraisal meeting inviteeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @return the range of matching appraisal meeting inviteeses
	 */
	public static List<AppraisalMeetingInvitees> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the appraisal meeting inviteeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal meeting inviteeses
	 */
	public static List<AppraisalMeetingInvitees> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the appraisal meeting inviteeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal meeting inviteeses
	 */
	public static List<AppraisalMeetingInvitees> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first appraisal meeting invitees in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a matching appraisal meeting invitees could not be found
	 */
	public static AppraisalMeetingInvitees findByUuid_First(
			String uuid,
			OrderByComparator<AppraisalMeetingInvitees> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingInviteesException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first appraisal meeting invitees in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	public static AppraisalMeetingInvitees fetchByUuid_First(
		String uuid,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last appraisal meeting invitees in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a matching appraisal meeting invitees could not be found
	 */
	public static AppraisalMeetingInvitees findByUuid_Last(
			String uuid,
			OrderByComparator<AppraisalMeetingInvitees> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingInviteesException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last appraisal meeting invitees in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	public static AppraisalMeetingInvitees fetchByUuid_Last(
		String uuid,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the appraisal meeting inviteeses before and after the current appraisal meeting invitees in the ordered set where uuid = &#63;.
	 *
	 * @param appraisalMeetingInviteeId the primary key of the current appraisal meeting invitees
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a appraisal meeting invitees with the primary key could not be found
	 */
	public static AppraisalMeetingInvitees[] findByUuid_PrevAndNext(
			long appraisalMeetingInviteeId, String uuid,
			OrderByComparator<AppraisalMeetingInvitees> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingInviteesException {

		return getPersistence().findByUuid_PrevAndNext(
			appraisalMeetingInviteeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the appraisal meeting inviteeses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of appraisal meeting inviteeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching appraisal meeting inviteeses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the appraisal meeting invitees where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAppraisalMeetingInviteesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a matching appraisal meeting invitees could not be found
	 */
	public static AppraisalMeetingInvitees findByUUID_G(
			String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingInviteesException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the appraisal meeting invitees where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	public static AppraisalMeetingInvitees fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the appraisal meeting invitees where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	public static AppraisalMeetingInvitees fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the appraisal meeting invitees where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the appraisal meeting invitees that was removed
	 */
	public static AppraisalMeetingInvitees removeByUUID_G(
			String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingInviteesException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of appraisal meeting inviteeses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching appraisal meeting inviteeses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the appraisal meeting inviteeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching appraisal meeting inviteeses
	 */
	public static List<AppraisalMeetingInvitees> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the appraisal meeting inviteeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @return the range of matching appraisal meeting inviteeses
	 */
	public static List<AppraisalMeetingInvitees> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the appraisal meeting inviteeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal meeting inviteeses
	 */
	public static List<AppraisalMeetingInvitees> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the appraisal meeting inviteeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal meeting inviteeses
	 */
	public static List<AppraisalMeetingInvitees> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first appraisal meeting invitees in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a matching appraisal meeting invitees could not be found
	 */
	public static AppraisalMeetingInvitees findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AppraisalMeetingInvitees> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingInviteesException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first appraisal meeting invitees in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	public static AppraisalMeetingInvitees fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last appraisal meeting invitees in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a matching appraisal meeting invitees could not be found
	 */
	public static AppraisalMeetingInvitees findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AppraisalMeetingInvitees> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingInviteesException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last appraisal meeting invitees in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	public static AppraisalMeetingInvitees fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the appraisal meeting inviteeses before and after the current appraisal meeting invitees in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param appraisalMeetingInviteeId the primary key of the current appraisal meeting invitees
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a appraisal meeting invitees with the primary key could not be found
	 */
	public static AppraisalMeetingInvitees[] findByUuid_C_PrevAndNext(
			long appraisalMeetingInviteeId, String uuid, long companyId,
			OrderByComparator<AppraisalMeetingInvitees> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingInviteesException {

		return getPersistence().findByUuid_C_PrevAndNext(
			appraisalMeetingInviteeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the appraisal meeting inviteeses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of appraisal meeting inviteeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching appraisal meeting inviteeses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the appraisal meeting inviteeses where appraisalMeetingId = &#63;.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @return the matching appraisal meeting inviteeses
	 */
	public static List<AppraisalMeetingInvitees> findByAppraisalMeetingId(
		long appraisalMeetingId) {

		return getPersistence().findByAppraisalMeetingId(appraisalMeetingId);
	}

	/**
	 * Returns a range of all the appraisal meeting inviteeses where appraisalMeetingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @return the range of matching appraisal meeting inviteeses
	 */
	public static List<AppraisalMeetingInvitees> findByAppraisalMeetingId(
		long appraisalMeetingId, int start, int end) {

		return getPersistence().findByAppraisalMeetingId(
			appraisalMeetingId, start, end);
	}

	/**
	 * Returns an ordered range of all the appraisal meeting inviteeses where appraisalMeetingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal meeting inviteeses
	 */
	public static List<AppraisalMeetingInvitees> findByAppraisalMeetingId(
		long appraisalMeetingId, int start, int end,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator) {

		return getPersistence().findByAppraisalMeetingId(
			appraisalMeetingId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the appraisal meeting inviteeses where appraisalMeetingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal meeting inviteeses
	 */
	public static List<AppraisalMeetingInvitees> findByAppraisalMeetingId(
		long appraisalMeetingId, int start, int end,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAppraisalMeetingId(
			appraisalMeetingId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first appraisal meeting invitees in the ordered set where appraisalMeetingId = &#63;.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a matching appraisal meeting invitees could not be found
	 */
	public static AppraisalMeetingInvitees findByAppraisalMeetingId_First(
			long appraisalMeetingId,
			OrderByComparator<AppraisalMeetingInvitees> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingInviteesException {

		return getPersistence().findByAppraisalMeetingId_First(
			appraisalMeetingId, orderByComparator);
	}

	/**
	 * Returns the first appraisal meeting invitees in the ordered set where appraisalMeetingId = &#63;.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	public static AppraisalMeetingInvitees fetchByAppraisalMeetingId_First(
		long appraisalMeetingId,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator) {

		return getPersistence().fetchByAppraisalMeetingId_First(
			appraisalMeetingId, orderByComparator);
	}

	/**
	 * Returns the last appraisal meeting invitees in the ordered set where appraisalMeetingId = &#63;.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a matching appraisal meeting invitees could not be found
	 */
	public static AppraisalMeetingInvitees findByAppraisalMeetingId_Last(
			long appraisalMeetingId,
			OrderByComparator<AppraisalMeetingInvitees> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingInviteesException {

		return getPersistence().findByAppraisalMeetingId_Last(
			appraisalMeetingId, orderByComparator);
	}

	/**
	 * Returns the last appraisal meeting invitees in the ordered set where appraisalMeetingId = &#63;.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	public static AppraisalMeetingInvitees fetchByAppraisalMeetingId_Last(
		long appraisalMeetingId,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator) {

		return getPersistence().fetchByAppraisalMeetingId_Last(
			appraisalMeetingId, orderByComparator);
	}

	/**
	 * Returns the appraisal meeting inviteeses before and after the current appraisal meeting invitees in the ordered set where appraisalMeetingId = &#63;.
	 *
	 * @param appraisalMeetingInviteeId the primary key of the current appraisal meeting invitees
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a appraisal meeting invitees with the primary key could not be found
	 */
	public static AppraisalMeetingInvitees[]
			findByAppraisalMeetingId_PrevAndNext(
				long appraisalMeetingInviteeId, long appraisalMeetingId,
				OrderByComparator<AppraisalMeetingInvitees> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingInviteesException {

		return getPersistence().findByAppraisalMeetingId_PrevAndNext(
			appraisalMeetingInviteeId, appraisalMeetingId, orderByComparator);
	}

	/**
	 * Removes all the appraisal meeting inviteeses where appraisalMeetingId = &#63; from the database.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 */
	public static void removeByAppraisalMeetingId(long appraisalMeetingId) {
		getPersistence().removeByAppraisalMeetingId(appraisalMeetingId);
	}

	/**
	 * Returns the number of appraisal meeting inviteeses where appraisalMeetingId = &#63;.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @return the number of matching appraisal meeting inviteeses
	 */
	public static int countByAppraisalMeetingId(long appraisalMeetingId) {
		return getPersistence().countByAppraisalMeetingId(appraisalMeetingId);
	}

	/**
	 * Caches the appraisal meeting invitees in the entity cache if it is enabled.
	 *
	 * @param appraisalMeetingInvitees the appraisal meeting invitees
	 */
	public static void cacheResult(
		AppraisalMeetingInvitees appraisalMeetingInvitees) {

		getPersistence().cacheResult(appraisalMeetingInvitees);
	}

	/**
	 * Caches the appraisal meeting inviteeses in the entity cache if it is enabled.
	 *
	 * @param appraisalMeetingInviteeses the appraisal meeting inviteeses
	 */
	public static void cacheResult(
		List<AppraisalMeetingInvitees> appraisalMeetingInviteeses) {

		getPersistence().cacheResult(appraisalMeetingInviteeses);
	}

	/**
	 * Creates a new appraisal meeting invitees with the primary key. Does not add the appraisal meeting invitees to the database.
	 *
	 * @param appraisalMeetingInviteeId the primary key for the new appraisal meeting invitees
	 * @return the new appraisal meeting invitees
	 */
	public static AppraisalMeetingInvitees create(
		long appraisalMeetingInviteeId) {

		return getPersistence().create(appraisalMeetingInviteeId);
	}

	/**
	 * Removes the appraisal meeting invitees with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalMeetingInviteeId the primary key of the appraisal meeting invitees
	 * @return the appraisal meeting invitees that was removed
	 * @throws NoSuchAppraisalMeetingInviteesException if a appraisal meeting invitees with the primary key could not be found
	 */
	public static AppraisalMeetingInvitees remove(
			long appraisalMeetingInviteeId)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingInviteesException {

		return getPersistence().remove(appraisalMeetingInviteeId);
	}

	public static AppraisalMeetingInvitees updateImpl(
		AppraisalMeetingInvitees appraisalMeetingInvitees) {

		return getPersistence().updateImpl(appraisalMeetingInvitees);
	}

	/**
	 * Returns the appraisal meeting invitees with the primary key or throws a <code>NoSuchAppraisalMeetingInviteesException</code> if it could not be found.
	 *
	 * @param appraisalMeetingInviteeId the primary key of the appraisal meeting invitees
	 * @return the appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a appraisal meeting invitees with the primary key could not be found
	 */
	public static AppraisalMeetingInvitees findByPrimaryKey(
			long appraisalMeetingInviteeId)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingInviteesException {

		return getPersistence().findByPrimaryKey(appraisalMeetingInviteeId);
	}

	/**
	 * Returns the appraisal meeting invitees with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalMeetingInviteeId the primary key of the appraisal meeting invitees
	 * @return the appraisal meeting invitees, or <code>null</code> if a appraisal meeting invitees with the primary key could not be found
	 */
	public static AppraisalMeetingInvitees fetchByPrimaryKey(
		long appraisalMeetingInviteeId) {

		return getPersistence().fetchByPrimaryKey(appraisalMeetingInviteeId);
	}

	/**
	 * Returns all the appraisal meeting inviteeses.
	 *
	 * @return the appraisal meeting inviteeses
	 */
	public static List<AppraisalMeetingInvitees> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the appraisal meeting inviteeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @return the range of appraisal meeting inviteeses
	 */
	public static List<AppraisalMeetingInvitees> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the appraisal meeting inviteeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appraisal meeting inviteeses
	 */
	public static List<AppraisalMeetingInvitees> findAll(
		int start, int end,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the appraisal meeting inviteeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of appraisal meeting inviteeses
	 */
	public static List<AppraisalMeetingInvitees> findAll(
		int start, int end,
		OrderByComparator<AppraisalMeetingInvitees> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the appraisal meeting inviteeses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of appraisal meeting inviteeses.
	 *
	 * @return the number of appraisal meeting inviteeses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AppraisalMeetingInviteesPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		AppraisalMeetingInviteesPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile AppraisalMeetingInviteesPersistence _persistence;

}