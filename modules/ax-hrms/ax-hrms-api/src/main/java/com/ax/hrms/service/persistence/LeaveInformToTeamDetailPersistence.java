/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchLeaveInformToTeamDetailException;
import com.ax.hrms.model.LeaveInformToTeamDetail;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the leave inform to team detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveInformToTeamDetailUtil
 * @generated
 */
@ProviderType
public interface LeaveInformToTeamDetailPersistence
	extends BasePersistence<LeaveInformToTeamDetail> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveInformToTeamDetailUtil} to access the leave inform to team detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the leave inform to team details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave inform to team details
	 */
	public java.util.List<LeaveInformToTeamDetail> findByUuid(String uuid);

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
	public java.util.List<LeaveInformToTeamDetail> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<LeaveInformToTeamDetail> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<LeaveInformToTeamDetail> orderByComparator);

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
	public java.util.List<LeaveInformToTeamDetail> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<LeaveInformToTeamDetail> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave inform to team detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a matching leave inform to team detail could not be found
	 */
	public LeaveInformToTeamDetail findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveInformToTeamDetail> orderByComparator)
		throws NoSuchLeaveInformToTeamDetailException;

	/**
	 * Returns the first leave inform to team detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	public LeaveInformToTeamDetail fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<LeaveInformToTeamDetail> orderByComparator);

	/**
	 * Returns the last leave inform to team detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a matching leave inform to team detail could not be found
	 */
	public LeaveInformToTeamDetail findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveInformToTeamDetail> orderByComparator)
		throws NoSuchLeaveInformToTeamDetailException;

	/**
	 * Returns the last leave inform to team detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	public LeaveInformToTeamDetail fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<LeaveInformToTeamDetail> orderByComparator);

	/**
	 * Returns the leave inform to team details before and after the current leave inform to team detail in the ordered set where uuid = &#63;.
	 *
	 * @param leaveInformId the primary key of the current leave inform to team detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a leave inform to team detail with the primary key could not be found
	 */
	public LeaveInformToTeamDetail[] findByUuid_PrevAndNext(
			long leaveInformId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveInformToTeamDetail> orderByComparator)
		throws NoSuchLeaveInformToTeamDetailException;

	/**
	 * Removes all the leave inform to team details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of leave inform to team details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave inform to team details
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the leave inform to team detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveInformToTeamDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a matching leave inform to team detail could not be found
	 */
	public LeaveInformToTeamDetail findByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveInformToTeamDetailException;

	/**
	 * Returns the leave inform to team detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	public LeaveInformToTeamDetail fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the leave inform to team detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	public LeaveInformToTeamDetail fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the leave inform to team detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave inform to team detail that was removed
	 */
	public LeaveInformToTeamDetail removeByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveInformToTeamDetailException;

	/**
	 * Returns the number of leave inform to team details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave inform to team details
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the leave inform to team details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave inform to team details
	 */
	public java.util.List<LeaveInformToTeamDetail> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<LeaveInformToTeamDetail> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<LeaveInformToTeamDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<LeaveInformToTeamDetail> orderByComparator);

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
	public java.util.List<LeaveInformToTeamDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<LeaveInformToTeamDetail> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave inform to team detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a matching leave inform to team detail could not be found
	 */
	public LeaveInformToTeamDetail findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveInformToTeamDetail> orderByComparator)
		throws NoSuchLeaveInformToTeamDetailException;

	/**
	 * Returns the first leave inform to team detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	public LeaveInformToTeamDetail fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<LeaveInformToTeamDetail> orderByComparator);

	/**
	 * Returns the last leave inform to team detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a matching leave inform to team detail could not be found
	 */
	public LeaveInformToTeamDetail findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveInformToTeamDetail> orderByComparator)
		throws NoSuchLeaveInformToTeamDetailException;

	/**
	 * Returns the last leave inform to team detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	public LeaveInformToTeamDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<LeaveInformToTeamDetail> orderByComparator);

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
	public LeaveInformToTeamDetail[] findByUuid_C_PrevAndNext(
			long leaveInformId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveInformToTeamDetail> orderByComparator)
		throws NoSuchLeaveInformToTeamDetailException;

	/**
	 * Removes all the leave inform to team details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of leave inform to team details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave inform to team details
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the leave inform to team details where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @return the matching leave inform to team details
	 */
	public java.util.List<LeaveInformToTeamDetail> findByLeaveRequestId(
		long leaveRequestId);

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
	public java.util.List<LeaveInformToTeamDetail> findByLeaveRequestId(
		long leaveRequestId, int start, int end);

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
	public java.util.List<LeaveInformToTeamDetail> findByLeaveRequestId(
		long leaveRequestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<LeaveInformToTeamDetail> orderByComparator);

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
	public java.util.List<LeaveInformToTeamDetail> findByLeaveRequestId(
		long leaveRequestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<LeaveInformToTeamDetail> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave inform to team detail in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a matching leave inform to team detail could not be found
	 */
	public LeaveInformToTeamDetail findByLeaveRequestId_First(
			long leaveRequestId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveInformToTeamDetail> orderByComparator)
		throws NoSuchLeaveInformToTeamDetailException;

	/**
	 * Returns the first leave inform to team detail in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	public LeaveInformToTeamDetail fetchByLeaveRequestId_First(
		long leaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator
			<LeaveInformToTeamDetail> orderByComparator);

	/**
	 * Returns the last leave inform to team detail in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a matching leave inform to team detail could not be found
	 */
	public LeaveInformToTeamDetail findByLeaveRequestId_Last(
			long leaveRequestId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveInformToTeamDetail> orderByComparator)
		throws NoSuchLeaveInformToTeamDetailException;

	/**
	 * Returns the last leave inform to team detail in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave inform to team detail, or <code>null</code> if a matching leave inform to team detail could not be found
	 */
	public LeaveInformToTeamDetail fetchByLeaveRequestId_Last(
		long leaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator
			<LeaveInformToTeamDetail> orderByComparator);

	/**
	 * Returns the leave inform to team details before and after the current leave inform to team detail in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveInformId the primary key of the current leave inform to team detail
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a leave inform to team detail with the primary key could not be found
	 */
	public LeaveInformToTeamDetail[] findByLeaveRequestId_PrevAndNext(
			long leaveInformId, long leaveRequestId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LeaveInformToTeamDetail> orderByComparator)
		throws NoSuchLeaveInformToTeamDetailException;

	/**
	 * Removes all the leave inform to team details where leaveRequestId = &#63; from the database.
	 *
	 * @param leaveRequestId the leave request ID
	 */
	public void removeByLeaveRequestId(long leaveRequestId);

	/**
	 * Returns the number of leave inform to team details where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @return the number of matching leave inform to team details
	 */
	public int countByLeaveRequestId(long leaveRequestId);

	/**
	 * Caches the leave inform to team detail in the entity cache if it is enabled.
	 *
	 * @param leaveInformToTeamDetail the leave inform to team detail
	 */
	public void cacheResult(LeaveInformToTeamDetail leaveInformToTeamDetail);

	/**
	 * Caches the leave inform to team details in the entity cache if it is enabled.
	 *
	 * @param leaveInformToTeamDetails the leave inform to team details
	 */
	public void cacheResult(
		java.util.List<LeaveInformToTeamDetail> leaveInformToTeamDetails);

	/**
	 * Creates a new leave inform to team detail with the primary key. Does not add the leave inform to team detail to the database.
	 *
	 * @param leaveInformId the primary key for the new leave inform to team detail
	 * @return the new leave inform to team detail
	 */
	public LeaveInformToTeamDetail create(long leaveInformId);

	/**
	 * Removes the leave inform to team detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveInformId the primary key of the leave inform to team detail
	 * @return the leave inform to team detail that was removed
	 * @throws NoSuchLeaveInformToTeamDetailException if a leave inform to team detail with the primary key could not be found
	 */
	public LeaveInformToTeamDetail remove(long leaveInformId)
		throws NoSuchLeaveInformToTeamDetailException;

	public LeaveInformToTeamDetail updateImpl(
		LeaveInformToTeamDetail leaveInformToTeamDetail);

	/**
	 * Returns the leave inform to team detail with the primary key or throws a <code>NoSuchLeaveInformToTeamDetailException</code> if it could not be found.
	 *
	 * @param leaveInformId the primary key of the leave inform to team detail
	 * @return the leave inform to team detail
	 * @throws NoSuchLeaveInformToTeamDetailException if a leave inform to team detail with the primary key could not be found
	 */
	public LeaveInformToTeamDetail findByPrimaryKey(long leaveInformId)
		throws NoSuchLeaveInformToTeamDetailException;

	/**
	 * Returns the leave inform to team detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveInformId the primary key of the leave inform to team detail
	 * @return the leave inform to team detail, or <code>null</code> if a leave inform to team detail with the primary key could not be found
	 */
	public LeaveInformToTeamDetail fetchByPrimaryKey(long leaveInformId);

	/**
	 * Returns all the leave inform to team details.
	 *
	 * @return the leave inform to team details
	 */
	public java.util.List<LeaveInformToTeamDetail> findAll();

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
	public java.util.List<LeaveInformToTeamDetail> findAll(int start, int end);

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
	public java.util.List<LeaveInformToTeamDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<LeaveInformToTeamDetail> orderByComparator);

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
	public java.util.List<LeaveInformToTeamDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<LeaveInformToTeamDetail> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the leave inform to team details from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of leave inform to team details.
	 *
	 * @return the number of leave inform to team details
	 */
	public int countAll();

}