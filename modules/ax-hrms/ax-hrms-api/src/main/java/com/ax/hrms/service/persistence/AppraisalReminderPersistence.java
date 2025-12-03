/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchAppraisalReminderException;
import com.ax.hrms.model.AppraisalReminder;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the appraisal reminder service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalReminderUtil
 * @generated
 */
@ProviderType
public interface AppraisalReminderPersistence
	extends BasePersistence<AppraisalReminder> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppraisalReminderUtil} to access the appraisal reminder persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the appraisal reminders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching appraisal reminders
	 */
	public java.util.List<AppraisalReminder> findByUuid(String uuid);

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
	public java.util.List<AppraisalReminder> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<AppraisalReminder> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalReminder>
			orderByComparator);

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
	public java.util.List<AppraisalReminder> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalReminder>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first appraisal reminder in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a matching appraisal reminder could not be found
	 */
	public AppraisalReminder findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalReminder>
				orderByComparator)
		throws NoSuchAppraisalReminderException;

	/**
	 * Returns the first appraisal reminder in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	public AppraisalReminder fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalReminder>
			orderByComparator);

	/**
	 * Returns the last appraisal reminder in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a matching appraisal reminder could not be found
	 */
	public AppraisalReminder findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalReminder>
				orderByComparator)
		throws NoSuchAppraisalReminderException;

	/**
	 * Returns the last appraisal reminder in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	public AppraisalReminder fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalReminder>
			orderByComparator);

	/**
	 * Returns the appraisal reminders before and after the current appraisal reminder in the ordered set where uuid = &#63;.
	 *
	 * @param appraisalRemainderId the primary key of the current appraisal reminder
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a appraisal reminder with the primary key could not be found
	 */
	public AppraisalReminder[] findByUuid_PrevAndNext(
			long appraisalRemainderId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalReminder>
				orderByComparator)
		throws NoSuchAppraisalReminderException;

	/**
	 * Removes all the appraisal reminders where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of appraisal reminders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching appraisal reminders
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the appraisal reminder where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAppraisalReminderException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a matching appraisal reminder could not be found
	 */
	public AppraisalReminder findByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalReminderException;

	/**
	 * Returns the appraisal reminder where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	public AppraisalReminder fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the appraisal reminder where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	public AppraisalReminder fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the appraisal reminder where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the appraisal reminder that was removed
	 */
	public AppraisalReminder removeByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalReminderException;

	/**
	 * Returns the number of appraisal reminders where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching appraisal reminders
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the appraisal reminders where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching appraisal reminders
	 */
	public java.util.List<AppraisalReminder> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<AppraisalReminder> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<AppraisalReminder> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalReminder>
			orderByComparator);

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
	public java.util.List<AppraisalReminder> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalReminder>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first appraisal reminder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a matching appraisal reminder could not be found
	 */
	public AppraisalReminder findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalReminder>
				orderByComparator)
		throws NoSuchAppraisalReminderException;

	/**
	 * Returns the first appraisal reminder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	public AppraisalReminder fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalReminder>
			orderByComparator);

	/**
	 * Returns the last appraisal reminder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a matching appraisal reminder could not be found
	 */
	public AppraisalReminder findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalReminder>
				orderByComparator)
		throws NoSuchAppraisalReminderException;

	/**
	 * Returns the last appraisal reminder in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	public AppraisalReminder fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalReminder>
			orderByComparator);

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
	public AppraisalReminder[] findByUuid_C_PrevAndNext(
			long appraisalRemainderId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalReminder>
				orderByComparator)
		throws NoSuchAppraisalReminderException;

	/**
	 * Removes all the appraisal reminders where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of appraisal reminders where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching appraisal reminders
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the appraisal reminder where appraisalProcessId = &#63; or throws a <code>NoSuchAppraisalReminderException</code> if it could not be found.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the matching appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a matching appraisal reminder could not be found
	 */
	public AppraisalReminder findByAppraisalProcessId(long appraisalProcessId)
		throws NoSuchAppraisalReminderException;

	/**
	 * Returns the appraisal reminder where appraisalProcessId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	public AppraisalReminder fetchByAppraisalProcessId(long appraisalProcessId);

	/**
	 * Returns the appraisal reminder where appraisalProcessId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	public AppraisalReminder fetchByAppraisalProcessId(
		long appraisalProcessId, boolean useFinderCache);

	/**
	 * Removes the appraisal reminder where appraisalProcessId = &#63; from the database.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the appraisal reminder that was removed
	 */
	public AppraisalReminder removeByAppraisalProcessId(long appraisalProcessId)
		throws NoSuchAppraisalReminderException;

	/**
	 * Returns the number of appraisal reminders where appraisalProcessId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the number of matching appraisal reminders
	 */
	public int countByAppraisalProcessId(long appraisalProcessId);

	/**
	 * Caches the appraisal reminder in the entity cache if it is enabled.
	 *
	 * @param appraisalReminder the appraisal reminder
	 */
	public void cacheResult(AppraisalReminder appraisalReminder);

	/**
	 * Caches the appraisal reminders in the entity cache if it is enabled.
	 *
	 * @param appraisalReminders the appraisal reminders
	 */
	public void cacheResult(
		java.util.List<AppraisalReminder> appraisalReminders);

	/**
	 * Creates a new appraisal reminder with the primary key. Does not add the appraisal reminder to the database.
	 *
	 * @param appraisalRemainderId the primary key for the new appraisal reminder
	 * @return the new appraisal reminder
	 */
	public AppraisalReminder create(long appraisalRemainderId);

	/**
	 * Removes the appraisal reminder with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalRemainderId the primary key of the appraisal reminder
	 * @return the appraisal reminder that was removed
	 * @throws NoSuchAppraisalReminderException if a appraisal reminder with the primary key could not be found
	 */
	public AppraisalReminder remove(long appraisalRemainderId)
		throws NoSuchAppraisalReminderException;

	public AppraisalReminder updateImpl(AppraisalReminder appraisalReminder);

	/**
	 * Returns the appraisal reminder with the primary key or throws a <code>NoSuchAppraisalReminderException</code> if it could not be found.
	 *
	 * @param appraisalRemainderId the primary key of the appraisal reminder
	 * @return the appraisal reminder
	 * @throws NoSuchAppraisalReminderException if a appraisal reminder with the primary key could not be found
	 */
	public AppraisalReminder findByPrimaryKey(long appraisalRemainderId)
		throws NoSuchAppraisalReminderException;

	/**
	 * Returns the appraisal reminder with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalRemainderId the primary key of the appraisal reminder
	 * @return the appraisal reminder, or <code>null</code> if a appraisal reminder with the primary key could not be found
	 */
	public AppraisalReminder fetchByPrimaryKey(long appraisalRemainderId);

	/**
	 * Returns all the appraisal reminders.
	 *
	 * @return the appraisal reminders
	 */
	public java.util.List<AppraisalReminder> findAll();

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
	public java.util.List<AppraisalReminder> findAll(int start, int end);

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
	public java.util.List<AppraisalReminder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalReminder>
			orderByComparator);

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
	public java.util.List<AppraisalReminder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalReminder>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the appraisal reminders from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of appraisal reminders.
	 *
	 * @return the number of appraisal reminders
	 */
	public int countAll();

}