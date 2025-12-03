/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchAppraisalMeetingInviteesException;
import com.ax.hrms.model.AppraisalMeetingInvitees;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the appraisal meeting invitees service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalMeetingInviteesUtil
 * @generated
 */
@ProviderType
public interface AppraisalMeetingInviteesPersistence
	extends BasePersistence<AppraisalMeetingInvitees> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppraisalMeetingInviteesUtil} to access the appraisal meeting invitees persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the appraisal meeting inviteeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching appraisal meeting inviteeses
	 */
	public java.util.List<AppraisalMeetingInvitees> findByUuid(String uuid);

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
	public java.util.List<AppraisalMeetingInvitees> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<AppraisalMeetingInvitees> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalMeetingInvitees> orderByComparator);

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
	public java.util.List<AppraisalMeetingInvitees> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalMeetingInvitees> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first appraisal meeting invitees in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a matching appraisal meeting invitees could not be found
	 */
	public AppraisalMeetingInvitees findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalMeetingInvitees> orderByComparator)
		throws NoSuchAppraisalMeetingInviteesException;

	/**
	 * Returns the first appraisal meeting invitees in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	public AppraisalMeetingInvitees fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalMeetingInvitees> orderByComparator);

	/**
	 * Returns the last appraisal meeting invitees in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a matching appraisal meeting invitees could not be found
	 */
	public AppraisalMeetingInvitees findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalMeetingInvitees> orderByComparator)
		throws NoSuchAppraisalMeetingInviteesException;

	/**
	 * Returns the last appraisal meeting invitees in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	public AppraisalMeetingInvitees fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalMeetingInvitees> orderByComparator);

	/**
	 * Returns the appraisal meeting inviteeses before and after the current appraisal meeting invitees in the ordered set where uuid = &#63;.
	 *
	 * @param appraisalMeetingInviteeId the primary key of the current appraisal meeting invitees
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a appraisal meeting invitees with the primary key could not be found
	 */
	public AppraisalMeetingInvitees[] findByUuid_PrevAndNext(
			long appraisalMeetingInviteeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalMeetingInvitees> orderByComparator)
		throws NoSuchAppraisalMeetingInviteesException;

	/**
	 * Removes all the appraisal meeting inviteeses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of appraisal meeting inviteeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching appraisal meeting inviteeses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the appraisal meeting invitees where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAppraisalMeetingInviteesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a matching appraisal meeting invitees could not be found
	 */
	public AppraisalMeetingInvitees findByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalMeetingInviteesException;

	/**
	 * Returns the appraisal meeting invitees where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	public AppraisalMeetingInvitees fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the appraisal meeting invitees where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	public AppraisalMeetingInvitees fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the appraisal meeting invitees where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the appraisal meeting invitees that was removed
	 */
	public AppraisalMeetingInvitees removeByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalMeetingInviteesException;

	/**
	 * Returns the number of appraisal meeting inviteeses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching appraisal meeting inviteeses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the appraisal meeting inviteeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching appraisal meeting inviteeses
	 */
	public java.util.List<AppraisalMeetingInvitees> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<AppraisalMeetingInvitees> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<AppraisalMeetingInvitees> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalMeetingInvitees> orderByComparator);

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
	public java.util.List<AppraisalMeetingInvitees> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalMeetingInvitees> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first appraisal meeting invitees in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a matching appraisal meeting invitees could not be found
	 */
	public AppraisalMeetingInvitees findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalMeetingInvitees> orderByComparator)
		throws NoSuchAppraisalMeetingInviteesException;

	/**
	 * Returns the first appraisal meeting invitees in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	public AppraisalMeetingInvitees fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalMeetingInvitees> orderByComparator);

	/**
	 * Returns the last appraisal meeting invitees in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a matching appraisal meeting invitees could not be found
	 */
	public AppraisalMeetingInvitees findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalMeetingInvitees> orderByComparator)
		throws NoSuchAppraisalMeetingInviteesException;

	/**
	 * Returns the last appraisal meeting invitees in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	public AppraisalMeetingInvitees fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalMeetingInvitees> orderByComparator);

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
	public AppraisalMeetingInvitees[] findByUuid_C_PrevAndNext(
			long appraisalMeetingInviteeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalMeetingInvitees> orderByComparator)
		throws NoSuchAppraisalMeetingInviteesException;

	/**
	 * Removes all the appraisal meeting inviteeses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of appraisal meeting inviteeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching appraisal meeting inviteeses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the appraisal meeting inviteeses where appraisalMeetingId = &#63;.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @return the matching appraisal meeting inviteeses
	 */
	public java.util.List<AppraisalMeetingInvitees> findByAppraisalMeetingId(
		long appraisalMeetingId);

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
	public java.util.List<AppraisalMeetingInvitees> findByAppraisalMeetingId(
		long appraisalMeetingId, int start, int end);

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
	public java.util.List<AppraisalMeetingInvitees> findByAppraisalMeetingId(
		long appraisalMeetingId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalMeetingInvitees> orderByComparator);

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
	public java.util.List<AppraisalMeetingInvitees> findByAppraisalMeetingId(
		long appraisalMeetingId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalMeetingInvitees> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first appraisal meeting invitees in the ordered set where appraisalMeetingId = &#63;.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a matching appraisal meeting invitees could not be found
	 */
	public AppraisalMeetingInvitees findByAppraisalMeetingId_First(
			long appraisalMeetingId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalMeetingInvitees> orderByComparator)
		throws NoSuchAppraisalMeetingInviteesException;

	/**
	 * Returns the first appraisal meeting invitees in the ordered set where appraisalMeetingId = &#63;.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	public AppraisalMeetingInvitees fetchByAppraisalMeetingId_First(
		long appraisalMeetingId,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalMeetingInvitees> orderByComparator);

	/**
	 * Returns the last appraisal meeting invitees in the ordered set where appraisalMeetingId = &#63;.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a matching appraisal meeting invitees could not be found
	 */
	public AppraisalMeetingInvitees findByAppraisalMeetingId_Last(
			long appraisalMeetingId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalMeetingInvitees> orderByComparator)
		throws NoSuchAppraisalMeetingInviteesException;

	/**
	 * Returns the last appraisal meeting invitees in the ordered set where appraisalMeetingId = &#63;.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	public AppraisalMeetingInvitees fetchByAppraisalMeetingId_Last(
		long appraisalMeetingId,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalMeetingInvitees> orderByComparator);

	/**
	 * Returns the appraisal meeting inviteeses before and after the current appraisal meeting invitees in the ordered set where appraisalMeetingId = &#63;.
	 *
	 * @param appraisalMeetingInviteeId the primary key of the current appraisal meeting invitees
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a appraisal meeting invitees with the primary key could not be found
	 */
	public AppraisalMeetingInvitees[] findByAppraisalMeetingId_PrevAndNext(
			long appraisalMeetingInviteeId, long appraisalMeetingId,
			com.liferay.portal.kernel.util.OrderByComparator
				<AppraisalMeetingInvitees> orderByComparator)
		throws NoSuchAppraisalMeetingInviteesException;

	/**
	 * Removes all the appraisal meeting inviteeses where appraisalMeetingId = &#63; from the database.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 */
	public void removeByAppraisalMeetingId(long appraisalMeetingId);

	/**
	 * Returns the number of appraisal meeting inviteeses where appraisalMeetingId = &#63;.
	 *
	 * @param appraisalMeetingId the appraisal meeting ID
	 * @return the number of matching appraisal meeting inviteeses
	 */
	public int countByAppraisalMeetingId(long appraisalMeetingId);

	/**
	 * Caches the appraisal meeting invitees in the entity cache if it is enabled.
	 *
	 * @param appraisalMeetingInvitees the appraisal meeting invitees
	 */
	public void cacheResult(AppraisalMeetingInvitees appraisalMeetingInvitees);

	/**
	 * Caches the appraisal meeting inviteeses in the entity cache if it is enabled.
	 *
	 * @param appraisalMeetingInviteeses the appraisal meeting inviteeses
	 */
	public void cacheResult(
		java.util.List<AppraisalMeetingInvitees> appraisalMeetingInviteeses);

	/**
	 * Creates a new appraisal meeting invitees with the primary key. Does not add the appraisal meeting invitees to the database.
	 *
	 * @param appraisalMeetingInviteeId the primary key for the new appraisal meeting invitees
	 * @return the new appraisal meeting invitees
	 */
	public AppraisalMeetingInvitees create(long appraisalMeetingInviteeId);

	/**
	 * Removes the appraisal meeting invitees with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalMeetingInviteeId the primary key of the appraisal meeting invitees
	 * @return the appraisal meeting invitees that was removed
	 * @throws NoSuchAppraisalMeetingInviteesException if a appraisal meeting invitees with the primary key could not be found
	 */
	public AppraisalMeetingInvitees remove(long appraisalMeetingInviteeId)
		throws NoSuchAppraisalMeetingInviteesException;

	public AppraisalMeetingInvitees updateImpl(
		AppraisalMeetingInvitees appraisalMeetingInvitees);

	/**
	 * Returns the appraisal meeting invitees with the primary key or throws a <code>NoSuchAppraisalMeetingInviteesException</code> if it could not be found.
	 *
	 * @param appraisalMeetingInviteeId the primary key of the appraisal meeting invitees
	 * @return the appraisal meeting invitees
	 * @throws NoSuchAppraisalMeetingInviteesException if a appraisal meeting invitees with the primary key could not be found
	 */
	public AppraisalMeetingInvitees findByPrimaryKey(
			long appraisalMeetingInviteeId)
		throws NoSuchAppraisalMeetingInviteesException;

	/**
	 * Returns the appraisal meeting invitees with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalMeetingInviteeId the primary key of the appraisal meeting invitees
	 * @return the appraisal meeting invitees, or <code>null</code> if a appraisal meeting invitees with the primary key could not be found
	 */
	public AppraisalMeetingInvitees fetchByPrimaryKey(
		long appraisalMeetingInviteeId);

	/**
	 * Returns all the appraisal meeting inviteeses.
	 *
	 * @return the appraisal meeting inviteeses
	 */
	public java.util.List<AppraisalMeetingInvitees> findAll();

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
	public java.util.List<AppraisalMeetingInvitees> findAll(int start, int end);

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
	public java.util.List<AppraisalMeetingInvitees> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalMeetingInvitees> orderByComparator);

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
	public java.util.List<AppraisalMeetingInvitees> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<AppraisalMeetingInvitees> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the appraisal meeting inviteeses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of appraisal meeting inviteeses.
	 *
	 * @return the number of appraisal meeting inviteeses
	 */
	public int countAll();

}