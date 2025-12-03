/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchLeaveDayTypeException;
import com.ax.hrms.model.LeaveDayType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the leave day type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveDayTypeUtil
 * @generated
 */
@ProviderType
public interface LeaveDayTypePersistence extends BasePersistence<LeaveDayType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveDayTypeUtil} to access the leave day type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the leave day types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching leave day types
	 */
	public java.util.List<LeaveDayType> findByUuid(String uuid);

	/**
	 * Returns a range of all the leave day types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @return the range of matching leave day types
	 */
	public java.util.List<LeaveDayType> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the leave day types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave day types
	 */
	public java.util.List<LeaveDayType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave day types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave day types
	 */
	public java.util.List<LeaveDayType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave day type
	 * @throws NoSuchLeaveDayTypeException if a matching leave day type could not be found
	 */
	public LeaveDayType findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
				orderByComparator)
		throws NoSuchLeaveDayTypeException;

	/**
	 * Returns the first leave day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	public LeaveDayType fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
			orderByComparator);

	/**
	 * Returns the last leave day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave day type
	 * @throws NoSuchLeaveDayTypeException if a matching leave day type could not be found
	 */
	public LeaveDayType findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
				orderByComparator)
		throws NoSuchLeaveDayTypeException;

	/**
	 * Returns the last leave day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	public LeaveDayType fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
			orderByComparator);

	/**
	 * Returns the leave day types before and after the current leave day type in the ordered set where uuid = &#63;.
	 *
	 * @param leaveDayTypeId the primary key of the current leave day type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave day type
	 * @throws NoSuchLeaveDayTypeException if a leave day type with the primary key could not be found
	 */
	public LeaveDayType[] findByUuid_PrevAndNext(
			long leaveDayTypeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
				orderByComparator)
		throws NoSuchLeaveDayTypeException;

	/**
	 * Removes all the leave day types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of leave day types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching leave day types
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the leave day type where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLeaveDayTypeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave day type
	 * @throws NoSuchLeaveDayTypeException if a matching leave day type could not be found
	 */
	public LeaveDayType findByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveDayTypeException;

	/**
	 * Returns the leave day type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	public LeaveDayType fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the leave day type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	public LeaveDayType fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the leave day type where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the leave day type that was removed
	 */
	public LeaveDayType removeByUUID_G(String uuid, long groupId)
		throws NoSuchLeaveDayTypeException;

	/**
	 * Returns the number of leave day types where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching leave day types
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the leave day types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching leave day types
	 */
	public java.util.List<LeaveDayType> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the leave day types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @return the range of matching leave day types
	 */
	public java.util.List<LeaveDayType> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the leave day types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave day types
	 */
	public java.util.List<LeaveDayType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave day types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave day types
	 */
	public java.util.List<LeaveDayType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave day type
	 * @throws NoSuchLeaveDayTypeException if a matching leave day type could not be found
	 */
	public LeaveDayType findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
				orderByComparator)
		throws NoSuchLeaveDayTypeException;

	/**
	 * Returns the first leave day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	public LeaveDayType fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
			orderByComparator);

	/**
	 * Returns the last leave day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave day type
	 * @throws NoSuchLeaveDayTypeException if a matching leave day type could not be found
	 */
	public LeaveDayType findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
				orderByComparator)
		throws NoSuchLeaveDayTypeException;

	/**
	 * Returns the last leave day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	public LeaveDayType fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
			orderByComparator);

	/**
	 * Returns the leave day types before and after the current leave day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param leaveDayTypeId the primary key of the current leave day type
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave day type
	 * @throws NoSuchLeaveDayTypeException if a leave day type with the primary key could not be found
	 */
	public LeaveDayType[] findByUuid_C_PrevAndNext(
			long leaveDayTypeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
				orderByComparator)
		throws NoSuchLeaveDayTypeException;

	/**
	 * Removes all the leave day types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of leave day types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching leave day types
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the leave day types where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @return the matching leave day types
	 */
	public java.util.List<LeaveDayType> findByLeaveRequestId(
		long leaveRequestId);

	/**
	 * Returns a range of all the leave day types where leaveRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param leaveRequestId the leave request ID
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @return the range of matching leave day types
	 */
	public java.util.List<LeaveDayType> findByLeaveRequestId(
		long leaveRequestId, int start, int end);

	/**
	 * Returns an ordered range of all the leave day types where leaveRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param leaveRequestId the leave request ID
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave day types
	 */
	public java.util.List<LeaveDayType> findByLeaveRequestId(
		long leaveRequestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave day types where leaveRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param leaveRequestId the leave request ID
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave day types
	 */
	public java.util.List<LeaveDayType> findByLeaveRequestId(
		long leaveRequestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave day type in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave day type
	 * @throws NoSuchLeaveDayTypeException if a matching leave day type could not be found
	 */
	public LeaveDayType findByLeaveRequestId_First(
			long leaveRequestId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
				orderByComparator)
		throws NoSuchLeaveDayTypeException;

	/**
	 * Returns the first leave day type in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	public LeaveDayType fetchByLeaveRequestId_First(
		long leaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
			orderByComparator);

	/**
	 * Returns the last leave day type in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave day type
	 * @throws NoSuchLeaveDayTypeException if a matching leave day type could not be found
	 */
	public LeaveDayType findByLeaveRequestId_Last(
			long leaveRequestId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
				orderByComparator)
		throws NoSuchLeaveDayTypeException;

	/**
	 * Returns the last leave day type in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave day type, or <code>null</code> if a matching leave day type could not be found
	 */
	public LeaveDayType fetchByLeaveRequestId_Last(
		long leaveRequestId,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
			orderByComparator);

	/**
	 * Returns the leave day types before and after the current leave day type in the ordered set where leaveRequestId = &#63;.
	 *
	 * @param leaveDayTypeId the primary key of the current leave day type
	 * @param leaveRequestId the leave request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave day type
	 * @throws NoSuchLeaveDayTypeException if a leave day type with the primary key could not be found
	 */
	public LeaveDayType[] findByLeaveRequestId_PrevAndNext(
			long leaveDayTypeId, long leaveRequestId,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
				orderByComparator)
		throws NoSuchLeaveDayTypeException;

	/**
	 * Removes all the leave day types where leaveRequestId = &#63; from the database.
	 *
	 * @param leaveRequestId the leave request ID
	 */
	public void removeByLeaveRequestId(long leaveRequestId);

	/**
	 * Returns the number of leave day types where leaveRequestId = &#63;.
	 *
	 * @param leaveRequestId the leave request ID
	 * @return the number of matching leave day types
	 */
	public int countByLeaveRequestId(long leaveRequestId);

	/**
	 * Caches the leave day type in the entity cache if it is enabled.
	 *
	 * @param leaveDayType the leave day type
	 */
	public void cacheResult(LeaveDayType leaveDayType);

	/**
	 * Caches the leave day types in the entity cache if it is enabled.
	 *
	 * @param leaveDayTypes the leave day types
	 */
	public void cacheResult(java.util.List<LeaveDayType> leaveDayTypes);

	/**
	 * Creates a new leave day type with the primary key. Does not add the leave day type to the database.
	 *
	 * @param leaveDayTypeId the primary key for the new leave day type
	 * @return the new leave day type
	 */
	public LeaveDayType create(long leaveDayTypeId);

	/**
	 * Removes the leave day type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveDayTypeId the primary key of the leave day type
	 * @return the leave day type that was removed
	 * @throws NoSuchLeaveDayTypeException if a leave day type with the primary key could not be found
	 */
	public LeaveDayType remove(long leaveDayTypeId)
		throws NoSuchLeaveDayTypeException;

	public LeaveDayType updateImpl(LeaveDayType leaveDayType);

	/**
	 * Returns the leave day type with the primary key or throws a <code>NoSuchLeaveDayTypeException</code> if it could not be found.
	 *
	 * @param leaveDayTypeId the primary key of the leave day type
	 * @return the leave day type
	 * @throws NoSuchLeaveDayTypeException if a leave day type with the primary key could not be found
	 */
	public LeaveDayType findByPrimaryKey(long leaveDayTypeId)
		throws NoSuchLeaveDayTypeException;

	/**
	 * Returns the leave day type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveDayTypeId the primary key of the leave day type
	 * @return the leave day type, or <code>null</code> if a leave day type with the primary key could not be found
	 */
	public LeaveDayType fetchByPrimaryKey(long leaveDayTypeId);

	/**
	 * Returns all the leave day types.
	 *
	 * @return the leave day types
	 */
	public java.util.List<LeaveDayType> findAll();

	/**
	 * Returns a range of all the leave day types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @return the range of leave day types
	 */
	public java.util.List<LeaveDayType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the leave day types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave day types
	 */
	public java.util.List<LeaveDayType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave day types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave day types
	 * @param end the upper bound of the range of leave day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave day types
	 */
	public java.util.List<LeaveDayType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveDayType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the leave day types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of leave day types.
	 *
	 * @return the number of leave day types
	 */
	public int countAll();

}