/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchAppraisalMeetingException;
import com.ax.hrms.model.AppraisalMeeting;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the appraisal meeting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalMeetingUtil
 * @generated
 */
@ProviderType
public interface AppraisalMeetingPersistence
	extends BasePersistence<AppraisalMeeting> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppraisalMeetingUtil} to access the appraisal meeting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the appraisal meetings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching appraisal meetings
	 */
	public java.util.List<AppraisalMeeting> findByUuid(String uuid);

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
	public java.util.List<AppraisalMeeting> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<AppraisalMeeting> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalMeeting>
			orderByComparator);

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
	public java.util.List<AppraisalMeeting> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalMeeting>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first appraisal meeting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a matching appraisal meeting could not be found
	 */
	public AppraisalMeeting findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalMeeting>
				orderByComparator)
		throws NoSuchAppraisalMeetingException;

	/**
	 * Returns the first appraisal meeting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	public AppraisalMeeting fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalMeeting>
			orderByComparator);

	/**
	 * Returns the last appraisal meeting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a matching appraisal meeting could not be found
	 */
	public AppraisalMeeting findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalMeeting>
				orderByComparator)
		throws NoSuchAppraisalMeetingException;

	/**
	 * Returns the last appraisal meeting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	public AppraisalMeeting fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalMeeting>
			orderByComparator);

	/**
	 * Returns the appraisal meetings before and after the current appraisal meeting in the ordered set where uuid = &#63;.
	 *
	 * @param appraisalMeetingId the primary key of the current appraisal meeting
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a appraisal meeting with the primary key could not be found
	 */
	public AppraisalMeeting[] findByUuid_PrevAndNext(
			long appraisalMeetingId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalMeeting>
				orderByComparator)
		throws NoSuchAppraisalMeetingException;

	/**
	 * Removes all the appraisal meetings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of appraisal meetings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching appraisal meetings
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the appraisal meeting where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAppraisalMeetingException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a matching appraisal meeting could not be found
	 */
	public AppraisalMeeting findByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalMeetingException;

	/**
	 * Returns the appraisal meeting where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	public AppraisalMeeting fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the appraisal meeting where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	public AppraisalMeeting fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the appraisal meeting where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the appraisal meeting that was removed
	 */
	public AppraisalMeeting removeByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalMeetingException;

	/**
	 * Returns the number of appraisal meetings where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching appraisal meetings
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the appraisal meetings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching appraisal meetings
	 */
	public java.util.List<AppraisalMeeting> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<AppraisalMeeting> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<AppraisalMeeting> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalMeeting>
			orderByComparator);

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
	public java.util.List<AppraisalMeeting> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalMeeting>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first appraisal meeting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a matching appraisal meeting could not be found
	 */
	public AppraisalMeeting findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalMeeting>
				orderByComparator)
		throws NoSuchAppraisalMeetingException;

	/**
	 * Returns the first appraisal meeting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	public AppraisalMeeting fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalMeeting>
			orderByComparator);

	/**
	 * Returns the last appraisal meeting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a matching appraisal meeting could not be found
	 */
	public AppraisalMeeting findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalMeeting>
				orderByComparator)
		throws NoSuchAppraisalMeetingException;

	/**
	 * Returns the last appraisal meeting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	public AppraisalMeeting fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalMeeting>
			orderByComparator);

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
	public AppraisalMeeting[] findByUuid_C_PrevAndNext(
			long appraisalMeetingId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalMeeting>
				orderByComparator)
		throws NoSuchAppraisalMeetingException;

	/**
	 * Removes all the appraisal meetings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of appraisal meetings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching appraisal meetings
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the appraisal meeting where appraisalProcessId = &#63; or throws a <code>NoSuchAppraisalMeetingException</code> if it could not be found.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the matching appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a matching appraisal meeting could not be found
	 */
	public AppraisalMeeting findByAppraisalProcessId(long appraisalProcessId)
		throws NoSuchAppraisalMeetingException;

	/**
	 * Returns the appraisal meeting where appraisalProcessId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	public AppraisalMeeting fetchByAppraisalProcessId(long appraisalProcessId);

	/**
	 * Returns the appraisal meeting where appraisalProcessId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	public AppraisalMeeting fetchByAppraisalProcessId(
		long appraisalProcessId, boolean useFinderCache);

	/**
	 * Removes the appraisal meeting where appraisalProcessId = &#63; from the database.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the appraisal meeting that was removed
	 */
	public AppraisalMeeting removeByAppraisalProcessId(long appraisalProcessId)
		throws NoSuchAppraisalMeetingException;

	/**
	 * Returns the number of appraisal meetings where appraisalProcessId = &#63;.
	 *
	 * @param appraisalProcessId the appraisal process ID
	 * @return the number of matching appraisal meetings
	 */
	public int countByAppraisalProcessId(long appraisalProcessId);

	/**
	 * Caches the appraisal meeting in the entity cache if it is enabled.
	 *
	 * @param appraisalMeeting the appraisal meeting
	 */
	public void cacheResult(AppraisalMeeting appraisalMeeting);

	/**
	 * Caches the appraisal meetings in the entity cache if it is enabled.
	 *
	 * @param appraisalMeetings the appraisal meetings
	 */
	public void cacheResult(java.util.List<AppraisalMeeting> appraisalMeetings);

	/**
	 * Creates a new appraisal meeting with the primary key. Does not add the appraisal meeting to the database.
	 *
	 * @param appraisalMeetingId the primary key for the new appraisal meeting
	 * @return the new appraisal meeting
	 */
	public AppraisalMeeting create(long appraisalMeetingId);

	/**
	 * Removes the appraisal meeting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalMeetingId the primary key of the appraisal meeting
	 * @return the appraisal meeting that was removed
	 * @throws NoSuchAppraisalMeetingException if a appraisal meeting with the primary key could not be found
	 */
	public AppraisalMeeting remove(long appraisalMeetingId)
		throws NoSuchAppraisalMeetingException;

	public AppraisalMeeting updateImpl(AppraisalMeeting appraisalMeeting);

	/**
	 * Returns the appraisal meeting with the primary key or throws a <code>NoSuchAppraisalMeetingException</code> if it could not be found.
	 *
	 * @param appraisalMeetingId the primary key of the appraisal meeting
	 * @return the appraisal meeting
	 * @throws NoSuchAppraisalMeetingException if a appraisal meeting with the primary key could not be found
	 */
	public AppraisalMeeting findByPrimaryKey(long appraisalMeetingId)
		throws NoSuchAppraisalMeetingException;

	/**
	 * Returns the appraisal meeting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalMeetingId the primary key of the appraisal meeting
	 * @return the appraisal meeting, or <code>null</code> if a appraisal meeting with the primary key could not be found
	 */
	public AppraisalMeeting fetchByPrimaryKey(long appraisalMeetingId);

	/**
	 * Returns all the appraisal meetings.
	 *
	 * @return the appraisal meetings
	 */
	public java.util.List<AppraisalMeeting> findAll();

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
	public java.util.List<AppraisalMeeting> findAll(int start, int end);

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
	public java.util.List<AppraisalMeeting> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalMeeting>
			orderByComparator);

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
	public java.util.List<AppraisalMeeting> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalMeeting>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the appraisal meetings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of appraisal meetings.
	 *
	 * @return the number of appraisal meetings
	 */
	public int countAll();

}