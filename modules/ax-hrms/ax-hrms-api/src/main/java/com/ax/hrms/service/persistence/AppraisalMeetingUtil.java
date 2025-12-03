/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.AppraisalMeeting;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the appraisal meeting service. This utility wraps <code>com.ax.hrms.service.persistence.impl.AppraisalMeetingPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalMeetingPersistence
 * @generated
 */
public class AppraisalMeetingUtil {

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
	public static void clearCache(AppraisalMeeting appraisalMeeting) {
		getPersistence().clearCache(appraisalMeeting);
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
	public static Map<Serializable, AppraisalMeeting> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AppraisalMeeting> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AppraisalMeeting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AppraisalMeeting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AppraisalMeeting> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AppraisalMeeting update(AppraisalMeeting appraisalMeeting) {
		return getPersistence().update(appraisalMeeting);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AppraisalMeeting update(
		AppraisalMeeting appraisalMeeting, ServiceContext serviceContext) {

		return getPersistence().update(appraisalMeeting, serviceContext);
	}

	/**
	 * Returns all the appraisal meetings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching appraisal meetings
	 */
	public static List<AppraisalMeeting> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the appraisal meetings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal meetings
	 * @param end the upper bound of the range of appraisal meetings (not inclusive)
	 * @return the range of matching appraisal meetings
	 */
	public static List<AppraisalMeeting> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the appraisal meetings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal meetings
	 * @param end the upper bound of the range of appraisal meetings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal meetings
	 */
	public static List<AppraisalMeeting> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppraisalMeeting> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the appraisal meetings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal meetings
	 * @param end the upper bound of the range of appraisal meetings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal meetings
	 */
	public static List<AppraisalMeeting> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppraisalMeeting> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first appraisal meeting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a matching appraisal meeting could not be found
	 */
	public static AppraisalMeeting findByUuid_First(
			String uuid, OrderByComparator<AppraisalMeeting> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first appraisal meeting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	public static AppraisalMeeting fetchByUuid_First(
		String uuid, OrderByComparator<AppraisalMeeting> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last appraisal meeting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a matching appraisal meeting could not be found
	 */
	public static AppraisalMeeting findByUuid_Last(
			String uuid, OrderByComparator<AppraisalMeeting> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last appraisal meeting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	public static AppraisalMeeting fetchByUuid_Last(
		String uuid, OrderByComparator<AppraisalMeeting> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the appraisal meetings before and after the current appraisal meeting in the ordered set where uuid = &#63;.
	 *
	 * @param appraisalMeetingId the primary key of the current appraisal meeting
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a appraisal meeting with the primary key could not be found
	 */
	public static AppraisalMeeting[] findByUuid_PrevAndNext(
			long appraisalMeetingId, String uuid,
			OrderByComparator<AppraisalMeeting> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingException {

		return getPersistence().findByUuid_PrevAndNext(
			appraisalMeetingId, uuid, orderByComparator);
	}

	/**
	 * Removes all the appraisal meetings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of appraisal meetings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching appraisal meetings
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the appraisal meeting where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAppraisalMeetingException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a matching appraisal meeting could not be found
	 */
	public static AppraisalMeeting findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the appraisal meeting where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	public static AppraisalMeeting fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the appraisal meeting where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	public static AppraisalMeeting fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the appraisal meeting where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the appraisal meeting that was removed
	 */
	public static AppraisalMeeting removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of appraisal meetings where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching appraisal meetings
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the appraisal meetings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching appraisal meetings
	 */
	public static List<AppraisalMeeting> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the appraisal meetings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal meetings
	 * @param end the upper bound of the range of appraisal meetings (not inclusive)
	 * @return the range of matching appraisal meetings
	 */
	public static List<AppraisalMeeting> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the appraisal meetings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal meetings
	 * @param end the upper bound of the range of appraisal meetings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal meetings
	 */
	public static List<AppraisalMeeting> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalMeeting> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the appraisal meetings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal meetings
	 * @param end the upper bound of the range of appraisal meetings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal meetings
	 */
	public static List<AppraisalMeeting> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalMeeting> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first appraisal meeting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a matching appraisal meeting could not be found
	 */
	public static AppraisalMeeting findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AppraisalMeeting> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first appraisal meeting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	public static AppraisalMeeting fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AppraisalMeeting> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last appraisal meeting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a matching appraisal meeting could not be found
	 */
	public static AppraisalMeeting findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AppraisalMeeting> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last appraisal meeting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	public static AppraisalMeeting fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AppraisalMeeting> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the appraisal meetings before and after the current appraisal meeting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param appraisalMeetingId the primary key of the current appraisal meeting
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a appraisal meeting with the primary key could not be found
	 */
	public static AppraisalMeeting[] findByUuid_C_PrevAndNext(
			long appraisalMeetingId, String uuid, long companyId,
			OrderByComparator<AppraisalMeeting> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingException {

		return getPersistence().findByUuid_C_PrevAndNext(
			appraisalMeetingId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the appraisal meetings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of appraisal meetings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching appraisal meetings
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the appraisal meeting where appraisalProcessId = &#63; or throws a <code>NoSuchAppraisalMeetingException</code> if it could not be found.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the matching appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a matching appraisal meeting could not be found
	 */
	public static AppraisalMeeting findByAppraisalProcessId(
			long appraisalProcessId)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingException {

		return getPersistence().findByAppraisalProcessId(appraisalProcessId);
	}

	/**
	 * Returns the appraisal meeting where appraisalProcessId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	public static AppraisalMeeting fetchByAppraisalProcessId(
		long appraisalProcessId) {

		return getPersistence().fetchByAppraisalProcessId(appraisalProcessId);
	}

	/**
	 * Returns the appraisal meeting where appraisalProcessId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	public static AppraisalMeeting fetchByAppraisalProcessId(
		long appraisalProcessId, boolean useFinderCache) {

		return getPersistence().fetchByAppraisalProcessId(
			appraisalProcessId, useFinderCache);
	}

	/**
	 * Removes the appraisal meeting where appraisalProcessId = &#63; from the database.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the appraisal meeting that was removed
	 */
	public static AppraisalMeeting removeByAppraisalProcessId(
			long appraisalProcessId)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingException {

		return getPersistence().removeByAppraisalProcessId(appraisalProcessId);
	}

	/**
	 * Returns the number of appraisal meetings where appraisalProcessId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the number of matching appraisal meetings
	 */
	public static int countByAppraisalProcessId(long appraisalProcessId) {
		return getPersistence().countByAppraisalProcessId(appraisalProcessId);
	}

	/**
	 * Caches the appraisal meeting in the entity cache if it is enabled.
	 *
	 * @param appraisalMeeting the appraisal meeting
	 */
	public static void cacheResult(AppraisalMeeting appraisalMeeting) {
		getPersistence().cacheResult(appraisalMeeting);
	}

	/**
	 * Caches the appraisal meetings in the entity cache if it is enabled.
	 *
	 * @param appraisalMeetings the appraisal meetings
	 */
	public static void cacheResult(List<AppraisalMeeting> appraisalMeetings) {
		getPersistence().cacheResult(appraisalMeetings);
	}

	/**
	 * Creates a new appraisal meeting with the primary key. Does not add the appraisal meeting to the database.
	 *
	 * @param appraisalMeetingId the primary key for the new appraisal meeting
	 * @return the new appraisal meeting
	 */
	public static AppraisalMeeting create(long appraisalMeetingId) {
		return getPersistence().create(appraisalMeetingId);
	}

	/**
	 * Removes the appraisal meeting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalMeetingId the primary key of the appraisal meeting
	 * @return the appraisal meeting that was removed
	 * @throws NoSuchAppraisalMeetingException if a appraisal meeting with the primary key could not be found
	 */
	public static AppraisalMeeting remove(long appraisalMeetingId)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingException {

		return getPersistence().remove(appraisalMeetingId);
	}

	public static AppraisalMeeting updateImpl(
		AppraisalMeeting appraisalMeeting) {

		return getPersistence().updateImpl(appraisalMeeting);
	}

	/**
	 * Returns the appraisal meeting with the primary key or throws a <code>NoSuchAppraisalMeetingException</code> if it could not be found.
	 *
	 * @param appraisalMeetingId the primary key of the appraisal meeting
	 * @return the appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a appraisal meeting with the primary key could not be found
	 */
	public static AppraisalMeeting findByPrimaryKey(long appraisalMeetingId)
		throws com.ax.hrms.exception.NoSuchAppraisalMeetingException {

		return getPersistence().findByPrimaryKey(appraisalMeetingId);
	}

	/**
	 * Returns the appraisal meeting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalMeetingId the primary key of the appraisal meeting
	 * @return the appraisal meeting, or <code>null</code> if a appraisal meeting with the primary key could not be found
	 */
	public static AppraisalMeeting fetchByPrimaryKey(long appraisalMeetingId) {
		return getPersistence().fetchByPrimaryKey(appraisalMeetingId);
	}

	/**
	 * Returns all the appraisal meetings.
	 *
	 * @return the appraisal meetings
	 */
	public static List<AppraisalMeeting> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the appraisal meetings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal meetings
	 * @param end the upper bound of the range of appraisal meetings (not inclusive)
	 * @return the range of appraisal meetings
	 */
	public static List<AppraisalMeeting> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the appraisal meetings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal meetings
	 * @param end the upper bound of the range of appraisal meetings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appraisal meetings
	 */
	public static List<AppraisalMeeting> findAll(
		int start, int end,
		OrderByComparator<AppraisalMeeting> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the appraisal meetings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal meetings
	 * @param end the upper bound of the range of appraisal meetings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of appraisal meetings
	 */
	public static List<AppraisalMeeting> findAll(
		int start, int end,
		OrderByComparator<AppraisalMeeting> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the appraisal meetings from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of appraisal meetings.
	 *
	 * @return the number of appraisal meetings
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AppraisalMeetingPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(AppraisalMeetingPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile AppraisalMeetingPersistence _persistence;

}