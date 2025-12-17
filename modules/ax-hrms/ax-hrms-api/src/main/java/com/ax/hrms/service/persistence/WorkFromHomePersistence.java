/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchWorkFromHomeException;
import com.ax.hrms.model.WorkFromHome;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the work from home service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHomeUtil
 * @generated
 */
@ProviderType
public interface WorkFromHomePersistence extends BasePersistence<WorkFromHome> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkFromHomeUtil} to access the work from home persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the work from homes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching work from homes
	 */
	public java.util.List<WorkFromHome> findByUuid(String uuid);

	/**
	 * Returns a range of all the work from homes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of matching work from homes
	 */
	public java.util.List<WorkFromHome> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the work from homes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from homes
	 */
	public java.util.List<WorkFromHome> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work from homes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from homes
	 */
	public java.util.List<WorkFromHome> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work from home in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public WorkFromHome findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
				orderByComparator)
		throws NoSuchWorkFromHomeException;

	/**
	 * Returns the first work from home in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public WorkFromHome fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator);

	/**
	 * Returns the last work from home in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public WorkFromHome findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
				orderByComparator)
		throws NoSuchWorkFromHomeException;

	/**
	 * Returns the last work from home in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public WorkFromHome fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator);

	/**
	 * Returns the work from homes before and after the current work from home in the ordered set where uuid = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	public WorkFromHome[] findByUuid_PrevAndNext(
			long workFromHomeRequestId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
				orderByComparator)
		throws NoSuchWorkFromHomeException;

	/**
	 * Removes all the work from homes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of work from homes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching work from homes
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the work from home where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchWorkFromHomeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public WorkFromHome findByUUID_G(String uuid, long groupId)
		throws NoSuchWorkFromHomeException;

	/**
	 * Returns the work from home where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public WorkFromHome fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the work from home where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public WorkFromHome fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the work from home where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the work from home that was removed
	 */
	public WorkFromHome removeByUUID_G(String uuid, long groupId)
		throws NoSuchWorkFromHomeException;

	/**
	 * Returns the number of work from homes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching work from homes
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the work from homes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching work from homes
	 */
	public java.util.List<WorkFromHome> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the work from homes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of matching work from homes
	 */
	public java.util.List<WorkFromHome> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the work from homes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from homes
	 */
	public java.util.List<WorkFromHome> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work from homes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from homes
	 */
	public java.util.List<WorkFromHome> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work from home in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public WorkFromHome findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
				orderByComparator)
		throws NoSuchWorkFromHomeException;

	/**
	 * Returns the first work from home in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public WorkFromHome fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator);

	/**
	 * Returns the last work from home in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public WorkFromHome findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
				orderByComparator)
		throws NoSuchWorkFromHomeException;

	/**
	 * Returns the last work from home in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public WorkFromHome fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator);

	/**
	 * Returns the work from homes before and after the current work from home in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	public WorkFromHome[] findByUuid_C_PrevAndNext(
			long workFromHomeRequestId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
				orderByComparator)
		throws NoSuchWorkFromHomeException;

	/**
	 * Removes all the work from homes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of work from homes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching work from homes
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the work from homes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching work from homes
	 */
	public java.util.List<WorkFromHome> findByUserId(long userId);

	/**
	 * Returns a range of all the work from homes where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of matching work from homes
	 */
	public java.util.List<WorkFromHome> findByUserId(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the work from homes where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from homes
	 */
	public java.util.List<WorkFromHome> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work from homes where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from homes
	 */
	public java.util.List<WorkFromHome> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work from home in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public WorkFromHome findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
				orderByComparator)
		throws NoSuchWorkFromHomeException;

	/**
	 * Returns the first work from home in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public WorkFromHome fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator);

	/**
	 * Returns the last work from home in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public WorkFromHome findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
				orderByComparator)
		throws NoSuchWorkFromHomeException;

	/**
	 * Returns the last work from home in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public WorkFromHome fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator);

	/**
	 * Returns the work from homes before and after the current work from home in the ordered set where userId = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	public WorkFromHome[] findByUserId_PrevAndNext(
			long workFromHomeRequestId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
				orderByComparator)
		throws NoSuchWorkFromHomeException;

	/**
	 * Removes all the work from homes where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of work from homes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching work from homes
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the work from homes where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching work from homes
	 */
	public java.util.List<WorkFromHome> findByStatus(long status);

	/**
	 * Returns a range of all the work from homes where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of matching work from homes
	 */
	public java.util.List<WorkFromHome> findByStatus(
		long status, int start, int end);

	/**
	 * Returns an ordered range of all the work from homes where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from homes
	 */
	public java.util.List<WorkFromHome> findByStatus(
		long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work from homes where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from homes
	 */
	public java.util.List<WorkFromHome> findByStatus(
		long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work from home in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public WorkFromHome findByStatus_First(
			long status,
			com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
				orderByComparator)
		throws NoSuchWorkFromHomeException;

	/**
	 * Returns the first work from home in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public WorkFromHome fetchByStatus_First(
		long status,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator);

	/**
	 * Returns the last work from home in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public WorkFromHome findByStatus_Last(
			long status,
			com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
				orderByComparator)
		throws NoSuchWorkFromHomeException;

	/**
	 * Returns the last work from home in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public WorkFromHome fetchByStatus_Last(
		long status,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator);

	/**
	 * Returns the work from homes before and after the current work from home in the ordered set where status = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	public WorkFromHome[] findByStatus_PrevAndNext(
			long workFromHomeRequestId, long status,
			com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
				orderByComparator)
		throws NoSuchWorkFromHomeException;

	/**
	 * Removes all the work from homes where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(long status);

	/**
	 * Returns the number of work from homes where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching work from homes
	 */
	public int countByStatus(long status);

	/**
	 * Returns all the work from homes where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching work from homes
	 */
	public java.util.List<WorkFromHome> findByUserIdAndStatus(
		long userId, long status);

	/**
	 * Returns a range of all the work from homes where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of matching work from homes
	 */
	public java.util.List<WorkFromHome> findByUserIdAndStatus(
		long userId, long status, int start, int end);

	/**
	 * Returns an ordered range of all the work from homes where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from homes
	 */
	public java.util.List<WorkFromHome> findByUserIdAndStatus(
		long userId, long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work from homes where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from homes
	 */
	public java.util.List<WorkFromHome> findByUserIdAndStatus(
		long userId, long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work from home in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public WorkFromHome findByUserIdAndStatus_First(
			long userId, long status,
			com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
				orderByComparator)
		throws NoSuchWorkFromHomeException;

	/**
	 * Returns the first work from home in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public WorkFromHome fetchByUserIdAndStatus_First(
		long userId, long status,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator);

	/**
	 * Returns the last work from home in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public WorkFromHome findByUserIdAndStatus_Last(
			long userId, long status,
			com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
				orderByComparator)
		throws NoSuchWorkFromHomeException;

	/**
	 * Returns the last work from home in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public WorkFromHome fetchByUserIdAndStatus_Last(
		long userId, long status,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator);

	/**
	 * Returns the work from homes before and after the current work from home in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	public WorkFromHome[] findByUserIdAndStatus_PrevAndNext(
			long workFromHomeRequestId, long userId, long status,
			com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
				orderByComparator)
		throws NoSuchWorkFromHomeException;

	/**
	 * Removes all the work from homes where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByUserIdAndStatus(long userId, long status);

	/**
	 * Returns the number of work from homes where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching work from homes
	 */
	public int countByUserIdAndStatus(long userId, long status);

	/**
	 * Returns all the work from homes where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the matching work from homes
	 */
	public java.util.List<WorkFromHome> findByDateRange(
		Date startDate, Date endDate);

	/**
	 * Returns a range of all the work from homes where startDate = &#63; and endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of matching work from homes
	 */
	public java.util.List<WorkFromHome> findByDateRange(
		Date startDate, Date endDate, int start, int end);

	/**
	 * Returns an ordered range of all the work from homes where startDate = &#63; and endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from homes
	 */
	public java.util.List<WorkFromHome> findByDateRange(
		Date startDate, Date endDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work from homes where startDate = &#63; and endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from homes
	 */
	public java.util.List<WorkFromHome> findByDateRange(
		Date startDate, Date endDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work from home in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public WorkFromHome findByDateRange_First(
			Date startDate, Date endDate,
			com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
				orderByComparator)
		throws NoSuchWorkFromHomeException;

	/**
	 * Returns the first work from home in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public WorkFromHome fetchByDateRange_First(
		Date startDate, Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator);

	/**
	 * Returns the last work from home in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home
	 * @throws NoSuchWorkFromHomeException if a matching work from home could not be found
	 */
	public WorkFromHome findByDateRange_Last(
			Date startDate, Date endDate,
			com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
				orderByComparator)
		throws NoSuchWorkFromHomeException;

	/**
	 * Returns the last work from home in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home, or <code>null</code> if a matching work from home could not be found
	 */
	public WorkFromHome fetchByDateRange_Last(
		Date startDate, Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator);

	/**
	 * Returns the work from homes before and after the current work from home in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	public WorkFromHome[] findByDateRange_PrevAndNext(
			long workFromHomeRequestId, Date startDate, Date endDate,
			com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
				orderByComparator)
		throws NoSuchWorkFromHomeException;

	/**
	 * Removes all the work from homes where startDate = &#63; and endDate = &#63; from the database.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 */
	public void removeByDateRange(Date startDate, Date endDate);

	/**
	 * Returns the number of work from homes where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the number of matching work from homes
	 */
	public int countByDateRange(Date startDate, Date endDate);

	/**
	 * Caches the work from home in the entity cache if it is enabled.
	 *
	 * @param workFromHome the work from home
	 */
	public void cacheResult(WorkFromHome workFromHome);

	/**
	 * Caches the work from homes in the entity cache if it is enabled.
	 *
	 * @param workFromHomes the work from homes
	 */
	public void cacheResult(java.util.List<WorkFromHome> workFromHomes);

	/**
	 * Creates a new work from home with the primary key. Does not add the work from home to the database.
	 *
	 * @param workFromHomeRequestId the primary key for the new work from home
	 * @return the new work from home
	 */
	public WorkFromHome create(long workFromHomeRequestId);

	/**
	 * Removes the work from home with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workFromHomeRequestId the primary key of the work from home
	 * @return the work from home that was removed
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	public WorkFromHome remove(long workFromHomeRequestId)
		throws NoSuchWorkFromHomeException;

	public WorkFromHome updateImpl(WorkFromHome workFromHome);

	/**
	 * Returns the work from home with the primary key or throws a <code>NoSuchWorkFromHomeException</code> if it could not be found.
	 *
	 * @param workFromHomeRequestId the primary key of the work from home
	 * @return the work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	public WorkFromHome findByPrimaryKey(long workFromHomeRequestId)
		throws NoSuchWorkFromHomeException;

	/**
	 * Returns the work from home with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workFromHomeRequestId the primary key of the work from home
	 * @return the work from home, or <code>null</code> if a work from home with the primary key could not be found
	 */
	public WorkFromHome fetchByPrimaryKey(long workFromHomeRequestId);

	/**
	 * Returns all the work from homes.
	 *
	 * @return the work from homes
	 */
	public java.util.List<WorkFromHome> findAll();

	/**
	 * Returns a range of all the work from homes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of work from homes
	 */
	public java.util.List<WorkFromHome> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the work from homes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work from homes
	 */
	public java.util.List<WorkFromHome> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work from homes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work from homes
	 */
	public java.util.List<WorkFromHome> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHome>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the work from homes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of work from homes.
	 *
	 * @return the number of work from homes
	 */
	public int countAll();

}