/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.AppraisalReminder;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the appraisal reminder service. This utility wraps <code>com.ax.hrms.service.persistence.impl.AppraisalReminderPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalReminderPersistence
 * @generated
 */
public class AppraisalReminderUtil {

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
	public static void clearCache(AppraisalReminder appraisalReminder) {
		getPersistence().clearCache(appraisalReminder);
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
	public static Map<Serializable, AppraisalReminder> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AppraisalReminder> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AppraisalReminder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AppraisalReminder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AppraisalReminder> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AppraisalReminder update(
		AppraisalReminder appraisalReminder) {

		return getPersistence().update(appraisalReminder);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AppraisalReminder update(
		AppraisalReminder appraisalReminder, ServiceContext serviceContext) {

		return getPersistence().update(appraisalReminder, serviceContext);
	}

	/**
	 * Returns all the appraisal reminders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching appraisal reminders
	 */
	public static List<AppraisalReminder> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the appraisal reminders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalReminderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal reminders
	 * @param end the upper bound of the range of appraisal reminders (not inclusive)
	 * @return the range of matching appraisal reminders
	 */
	public static List<AppraisalReminder> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the appraisal reminders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalReminderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal reminders
	 * @param end the upper bound of the range of appraisal reminders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal reminders
	 */
	public static List<AppraisalReminder> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppraisalReminder> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the appraisal reminders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalReminderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal reminders
	 * @param end the upper bound of the range of appraisal reminders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal reminders
	 */
	public static List<AppraisalReminder> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AppraisalReminder> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first appraisal reminder in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a matching appraisal reminder could not be found
	 */
	public static AppraisalReminder findByUuid_First(
			String uuid, OrderByComparator<AppraisalReminder> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalReminderException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first appraisal reminder in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	public static AppraisalReminder fetchByUuid_First(
		String uuid, OrderByComparator<AppraisalReminder> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last appraisal reminder in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a matching appraisal reminder could not be found
	 */
	public static AppraisalReminder findByUuid_Last(
			String uuid, OrderByComparator<AppraisalReminder> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalReminderException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last appraisal reminder in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	public static AppraisalReminder fetchByUuid_Last(
		String uuid, OrderByComparator<AppraisalReminder> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the appraisal reminders before and after the current appraisal reminder in the ordered set where uuid = &#63;.
	 *
	 * @param appraisalRemainderId the primary key of the current appraisal reminder
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a appraisal reminder with the primary key could not be found
	 */
	public static AppraisalReminder[] findByUuid_PrevAndNext(
			long appraisalRemainderId, String uuid,
			OrderByComparator<AppraisalReminder> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalReminderException {

		return getPersistence().findByUuid_PrevAndNext(
			appraisalRemainderId, uuid, orderByComparator);
	}

	/**
	 * Removes all the appraisal reminders where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of appraisal reminders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching appraisal reminders
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the appraisal reminder where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAppraisalReminderException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a matching appraisal reminder could not be found
	 */
	public static AppraisalReminder findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchAppraisalReminderException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the appraisal reminder where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	public static AppraisalReminder fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the appraisal reminder where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	public static AppraisalReminder fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the appraisal reminder where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the appraisal reminder that was removed
	 */
	public static AppraisalReminder removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchAppraisalReminderException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of appraisal reminders where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching appraisal reminders
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the appraisal reminders where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching appraisal reminders
	 */
	public static List<AppraisalReminder> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the appraisal reminders where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalReminderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal reminders
	 * @param end the upper bound of the range of appraisal reminders (not inclusive)
	 * @return the range of matching appraisal reminders
	 */
	public static List<AppraisalReminder> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the appraisal reminders where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalReminderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal reminders
	 * @param end the upper bound of the range of appraisal reminders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal reminders
	 */
	public static List<AppraisalReminder> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalReminder> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the appraisal reminders where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalReminderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal reminders
	 * @param end the upper bound of the range of appraisal reminders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal reminders
	 */
	public static List<AppraisalReminder> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalReminder> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first appraisal reminder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a matching appraisal reminder could not be found
	 */
	public static AppraisalReminder findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AppraisalReminder> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalReminderException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first appraisal reminder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	public static AppraisalReminder fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AppraisalReminder> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last appraisal reminder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a matching appraisal reminder could not be found
	 */
	public static AppraisalReminder findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AppraisalReminder> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalReminderException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last appraisal reminder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	public static AppraisalReminder fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AppraisalReminder> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the appraisal reminders before and after the current appraisal reminder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param appraisalRemainderId the primary key of the current appraisal reminder
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a appraisal reminder with the primary key could not be found
	 */
	public static AppraisalReminder[] findByUuid_C_PrevAndNext(
			long appraisalRemainderId, String uuid, long companyId,
			OrderByComparator<AppraisalReminder> orderByComparator)
		throws com.ax.hrms.exception.NoSuchAppraisalReminderException {

		return getPersistence().findByUuid_C_PrevAndNext(
			appraisalRemainderId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the appraisal reminders where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of appraisal reminders where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching appraisal reminders
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the appraisal reminder where appraisalProcessId = &#63; or throws a <code>NoSuchAppraisalReminderException</code> if it could not be found.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the matching appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a matching appraisal reminder could not be found
	 */
	public static AppraisalReminder findByAppraisalProcessId(
			long appraisalProcessId)
		throws com.ax.hrms.exception.NoSuchAppraisalReminderException {

		return getPersistence().findByAppraisalProcessId(appraisalProcessId);
	}

	/**
	 * Returns the appraisal reminder where appraisalProcessId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	public static AppraisalReminder fetchByAppraisalProcessId(
		long appraisalProcessId) {

		return getPersistence().fetchByAppraisalProcessId(appraisalProcessId);
	}

	/**
	 * Returns the appraisal reminder where appraisalProcessId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	public static AppraisalReminder fetchByAppraisalProcessId(
		long appraisalProcessId, boolean useFinderCache) {

		return getPersistence().fetchByAppraisalProcessId(
			appraisalProcessId, useFinderCache);
	}

	/**
	 * Removes the appraisal reminder where appraisalProcessId = &#63; from the database.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the appraisal reminder that was removed
	 */
	public static AppraisalReminder removeByAppraisalProcessId(
			long appraisalProcessId)
		throws com.ax.hrms.exception.NoSuchAppraisalReminderException {

		return getPersistence().removeByAppraisalProcessId(appraisalProcessId);
	}

	/**
	 * Returns the number of appraisal reminders where appraisalProcessId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the number of matching appraisal reminders
	 */
	public static int countByAppraisalProcessId(long appraisalProcessId) {
		return getPersistence().countByAppraisalProcessId(appraisalProcessId);
	}

	/**
	 * Caches the appraisal reminder in the entity cache if it is enabled.
	 *
	 * @param appraisalReminder the appraisal reminder
	 */
	public static void cacheResult(AppraisalReminder appraisalReminder) {
		getPersistence().cacheResult(appraisalReminder);
	}

	/**
	 * Caches the appraisal reminders in the entity cache if it is enabled.
	 *
	 * @param appraisalReminders the appraisal reminders
	 */
	public static void cacheResult(List<AppraisalReminder> appraisalReminders) {
		getPersistence().cacheResult(appraisalReminders);
	}

	/**
	 * Creates a new appraisal reminder with the primary key. Does not add the appraisal reminder to the database.
	 *
	 * @param appraisalRemainderId the primary key for the new appraisal reminder
	 * @return the new appraisal reminder
	 */
	public static AppraisalReminder create(long appraisalRemainderId) {
		return getPersistence().create(appraisalRemainderId);
	}

	/**
	 * Removes the appraisal reminder with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalRemainderId the primary key of the appraisal reminder
	 * @return the appraisal reminder that was removed
	 * @throws NoSuchAppraisalReminderException if a appraisal reminder with the primary key could not be found
	 */
	public static AppraisalReminder remove(long appraisalRemainderId)
		throws com.ax.hrms.exception.NoSuchAppraisalReminderException {

		return getPersistence().remove(appraisalRemainderId);
	}

	public static AppraisalReminder updateImpl(
		AppraisalReminder appraisalReminder) {

		return getPersistence().updateImpl(appraisalReminder);
	}

	/**
	 * Returns the appraisal reminder with the primary key or throws a <code>NoSuchAppraisalReminderException</code> if it could not be found.
	 *
	 * @param appraisalRemainderId the primary key of the appraisal reminder
	 * @return the appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a appraisal reminder with the primary key could not be found
	 */
	public static AppraisalReminder findByPrimaryKey(long appraisalRemainderId)
		throws com.ax.hrms.exception.NoSuchAppraisalReminderException {

		return getPersistence().findByPrimaryKey(appraisalRemainderId);
	}

	/**
	 * Returns the appraisal reminder with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalRemainderId the primary key of the appraisal reminder
	 * @return the appraisal reminder, or <code>null</code> if a appraisal reminder with the primary key could not be found
	 */
	public static AppraisalReminder fetchByPrimaryKey(
		long appraisalRemainderId) {

		return getPersistence().fetchByPrimaryKey(appraisalRemainderId);
	}

	/**
	 * Returns all the appraisal reminders.
	 *
	 * @return the appraisal reminders
	 */
	public static List<AppraisalReminder> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the appraisal reminders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalReminderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal reminders
	 * @param end the upper bound of the range of appraisal reminders (not inclusive)
	 * @return the range of appraisal reminders
	 */
	public static List<AppraisalReminder> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the appraisal reminders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalReminderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal reminders
	 * @param end the upper bound of the range of appraisal reminders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appraisal reminders
	 */
	public static List<AppraisalReminder> findAll(
		int start, int end,
		OrderByComparator<AppraisalReminder> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the appraisal reminders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalReminderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal reminders
	 * @param end the upper bound of the range of appraisal reminders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of appraisal reminders
	 */
	public static List<AppraisalReminder> findAll(
		int start, int end,
		OrderByComparator<AppraisalReminder> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the appraisal reminders from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of appraisal reminders.
	 *
	 * @return the number of appraisal reminders
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AppraisalReminderPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		AppraisalReminderPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile AppraisalReminderPersistence _persistence;

}