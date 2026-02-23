/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchWorkFromHomeDayTypeException;
import com.ax.hrms.model.WorkFromHomeDayType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the work from home day type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHomeDayTypeUtil
 * @generated
 */
@ProviderType
public interface WorkFromHomeDayTypePersistence
	extends BasePersistence<WorkFromHomeDayType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkFromHomeDayTypeUtil} to access the work from home day type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the work from home day types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching work from home day types
	 */
	public java.util.List<WorkFromHomeDayType> findByUuid(String uuid);

	/**
	 * Returns a range of all the work from home day types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @return the range of matching work from home day types
	 */
	public java.util.List<WorkFromHomeDayType> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the work from home day types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home day types
	 */
	public java.util.List<WorkFromHomeDayType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeDayType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work from home day types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home day types
	 */
	public java.util.List<WorkFromHomeDayType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeDayType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work from home day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	public WorkFromHomeDayType findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException;

	/**
	 * Returns the first work from home day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	public WorkFromHomeDayType fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeDayType>
			orderByComparator);

	/**
	 * Returns the last work from home day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	public WorkFromHomeDayType findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException;

	/**
	 * Returns the last work from home day type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	public WorkFromHomeDayType fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeDayType>
			orderByComparator);

	/**
	 * Returns the work from home day types before and after the current work from home day type in the ordered set where uuid = &#63;.
	 *
	 * @param workFromHomeDayTypeId the primary key of the current work from home day type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a work from home day type with the primary key could not be found
	 */
	public WorkFromHomeDayType[] findByUuid_PrevAndNext(
			long workFromHomeDayTypeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException;

	/**
	 * Removes all the work from home day types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of work from home day types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching work from home day types
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the work from home day type where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchWorkFromHomeDayTypeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	public WorkFromHomeDayType findByUUID_G(String uuid, long groupId)
		throws NoSuchWorkFromHomeDayTypeException;

	/**
	 * Returns the work from home day type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	public WorkFromHomeDayType fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the work from home day type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	public WorkFromHomeDayType fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the work from home day type where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the work from home day type that was removed
	 */
	public WorkFromHomeDayType removeByUUID_G(String uuid, long groupId)
		throws NoSuchWorkFromHomeDayTypeException;

	/**
	 * Returns the number of work from home day types where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching work from home day types
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the work from home day types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching work from home day types
	 */
	public java.util.List<WorkFromHomeDayType> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the work from home day types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @return the range of matching work from home day types
	 */
	public java.util.List<WorkFromHomeDayType> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the work from home day types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home day types
	 */
	public java.util.List<WorkFromHomeDayType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeDayType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work from home day types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home day types
	 */
	public java.util.List<WorkFromHomeDayType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeDayType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work from home day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	public WorkFromHomeDayType findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException;

	/**
	 * Returns the first work from home day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	public WorkFromHomeDayType fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeDayType>
			orderByComparator);

	/**
	 * Returns the last work from home day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	public WorkFromHomeDayType findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException;

	/**
	 * Returns the last work from home day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	public WorkFromHomeDayType fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeDayType>
			orderByComparator);

	/**
	 * Returns the work from home day types before and after the current work from home day type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param workFromHomeDayTypeId the primary key of the current work from home day type
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a work from home day type with the primary key could not be found
	 */
	public WorkFromHomeDayType[] findByUuid_C_PrevAndNext(
			long workFromHomeDayTypeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException;

	/**
	 * Removes all the work from home day types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of work from home day types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching work from home day types
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the work from home day types where workFromHomeRequestId = &#63;.
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @return the matching work from home day types
	 */
	public java.util.List<WorkFromHomeDayType> findByWorkFromHomeRequestId(
		long workFromHomeRequestId);

	/**
	 * Returns a range of all the work from home day types where workFromHomeRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @return the range of matching work from home day types
	 */
	public java.util.List<WorkFromHomeDayType> findByWorkFromHomeRequestId(
		long workFromHomeRequestId, int start, int end);

	/**
	 * Returns an ordered range of all the work from home day types where workFromHomeRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home day types
	 */
	public java.util.List<WorkFromHomeDayType> findByWorkFromHomeRequestId(
		long workFromHomeRequestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeDayType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work from home day types where workFromHomeRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home day types
	 */
	public java.util.List<WorkFromHomeDayType> findByWorkFromHomeRequestId(
		long workFromHomeRequestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeDayType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work from home day type in the ordered set where workFromHomeRequestId = &#63;.
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	public WorkFromHomeDayType findByWorkFromHomeRequestId_First(
			long workFromHomeRequestId,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException;

	/**
	 * Returns the first work from home day type in the ordered set where workFromHomeRequestId = &#63;.
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	public WorkFromHomeDayType fetchByWorkFromHomeRequestId_First(
		long workFromHomeRequestId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeDayType>
			orderByComparator);

	/**
	 * Returns the last work from home day type in the ordered set where workFromHomeRequestId = &#63;.
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	public WorkFromHomeDayType findByWorkFromHomeRequestId_Last(
			long workFromHomeRequestId,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException;

	/**
	 * Returns the last work from home day type in the ordered set where workFromHomeRequestId = &#63;.
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	public WorkFromHomeDayType fetchByWorkFromHomeRequestId_Last(
		long workFromHomeRequestId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeDayType>
			orderByComparator);

	/**
	 * Returns the work from home day types before and after the current work from home day type in the ordered set where workFromHomeRequestId = &#63;.
	 *
	 * @param workFromHomeDayTypeId the primary key of the current work from home day type
	 * @param workFromHomeRequestId the work from home request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a work from home day type with the primary key could not be found
	 */
	public WorkFromHomeDayType[] findByWorkFromHomeRequestId_PrevAndNext(
			long workFromHomeDayTypeId, long workFromHomeRequestId,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException;

	/**
	 * Removes all the work from home day types where workFromHomeRequestId = &#63; from the database.
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 */
	public void removeByWorkFromHomeRequestId(long workFromHomeRequestId);

	/**
	 * Returns the number of work from home day types where workFromHomeRequestId = &#63;.
	 *
	 * @param workFromHomeRequestId the work from home request ID
	 * @return the number of matching work from home day types
	 */
	public int countByWorkFromHomeRequestId(long workFromHomeRequestId);

	/**
	 * Returns all the work from home day types where workFromHomeDate = &#63;.
	 *
	 * @param workFromHomeDate the work from home date
	 * @return the matching work from home day types
	 */
	public java.util.List<WorkFromHomeDayType> findByWorkFromHomeDate(
		Date workFromHomeDate);

	/**
	 * Returns a range of all the work from home day types where workFromHomeDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param workFromHomeDate the work from home date
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @return the range of matching work from home day types
	 */
	public java.util.List<WorkFromHomeDayType> findByWorkFromHomeDate(
		Date workFromHomeDate, int start, int end);

	/**
	 * Returns an ordered range of all the work from home day types where workFromHomeDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param workFromHomeDate the work from home date
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home day types
	 */
	public java.util.List<WorkFromHomeDayType> findByWorkFromHomeDate(
		Date workFromHomeDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeDayType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work from home day types where workFromHomeDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param workFromHomeDate the work from home date
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home day types
	 */
	public java.util.List<WorkFromHomeDayType> findByWorkFromHomeDate(
		Date workFromHomeDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeDayType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work from home day type in the ordered set where workFromHomeDate = &#63;.
	 *
	 * @param workFromHomeDate the work from home date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	public WorkFromHomeDayType findByWorkFromHomeDate_First(
			Date workFromHomeDate,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException;

	/**
	 * Returns the first work from home day type in the ordered set where workFromHomeDate = &#63;.
	 *
	 * @param workFromHomeDate the work from home date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	public WorkFromHomeDayType fetchByWorkFromHomeDate_First(
		Date workFromHomeDate,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeDayType>
			orderByComparator);

	/**
	 * Returns the last work from home day type in the ordered set where workFromHomeDate = &#63;.
	 *
	 * @param workFromHomeDate the work from home date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a matching work from home day type could not be found
	 */
	public WorkFromHomeDayType findByWorkFromHomeDate_Last(
			Date workFromHomeDate,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException;

	/**
	 * Returns the last work from home day type in the ordered set where workFromHomeDate = &#63;.
	 *
	 * @param workFromHomeDate the work from home date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home day type, or <code>null</code> if a matching work from home day type could not be found
	 */
	public WorkFromHomeDayType fetchByWorkFromHomeDate_Last(
		Date workFromHomeDate,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeDayType>
			orderByComparator);

	/**
	 * Returns the work from home day types before and after the current work from home day type in the ordered set where workFromHomeDate = &#63;.
	 *
	 * @param workFromHomeDayTypeId the primary key of the current work from home day type
	 * @param workFromHomeDate the work from home date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a work from home day type with the primary key could not be found
	 */
	public WorkFromHomeDayType[] findByWorkFromHomeDate_PrevAndNext(
			long workFromHomeDayTypeId, Date workFromHomeDate,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeDayType> orderByComparator)
		throws NoSuchWorkFromHomeDayTypeException;

	/**
	 * Removes all the work from home day types where workFromHomeDate = &#63; from the database.
	 *
	 * @param workFromHomeDate the work from home date
	 */
	public void removeByWorkFromHomeDate(Date workFromHomeDate);

	/**
	 * Returns the number of work from home day types where workFromHomeDate = &#63;.
	 *
	 * @param workFromHomeDate the work from home date
	 * @return the number of matching work from home day types
	 */
	public int countByWorkFromHomeDate(Date workFromHomeDate);

	/**
	 * Caches the work from home day type in the entity cache if it is enabled.
	 *
	 * @param workFromHomeDayType the work from home day type
	 */
	public void cacheResult(WorkFromHomeDayType workFromHomeDayType);

	/**
	 * Caches the work from home day types in the entity cache if it is enabled.
	 *
	 * @param workFromHomeDayTypes the work from home day types
	 */
	public void cacheResult(
		java.util.List<WorkFromHomeDayType> workFromHomeDayTypes);

	/**
	 * Creates a new work from home day type with the primary key. Does not add the work from home day type to the database.
	 *
	 * @param workFromHomeDayTypeId the primary key for the new work from home day type
	 * @return the new work from home day type
	 */
	public WorkFromHomeDayType create(long workFromHomeDayTypeId);

	/**
	 * Removes the work from home day type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workFromHomeDayTypeId the primary key of the work from home day type
	 * @return the work from home day type that was removed
	 * @throws NoSuchWorkFromHomeDayTypeException if a work from home day type with the primary key could not be found
	 */
	public WorkFromHomeDayType remove(long workFromHomeDayTypeId)
		throws NoSuchWorkFromHomeDayTypeException;

	public WorkFromHomeDayType updateImpl(
		WorkFromHomeDayType workFromHomeDayType);

	/**
	 * Returns the work from home day type with the primary key or throws a <code>NoSuchWorkFromHomeDayTypeException</code> if it could not be found.
	 *
	 * @param workFromHomeDayTypeId the primary key of the work from home day type
	 * @return the work from home day type
	 * @throws NoSuchWorkFromHomeDayTypeException if a work from home day type with the primary key could not be found
	 */
	public WorkFromHomeDayType findByPrimaryKey(long workFromHomeDayTypeId)
		throws NoSuchWorkFromHomeDayTypeException;

	/**
	 * Returns the work from home day type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workFromHomeDayTypeId the primary key of the work from home day type
	 * @return the work from home day type, or <code>null</code> if a work from home day type with the primary key could not be found
	 */
	public WorkFromHomeDayType fetchByPrimaryKey(long workFromHomeDayTypeId);

	/**
	 * Returns all the work from home day types.
	 *
	 * @return the work from home day types
	 */
	public java.util.List<WorkFromHomeDayType> findAll();

	/**
	 * Returns a range of all the work from home day types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @return the range of work from home day types
	 */
	public java.util.List<WorkFromHomeDayType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the work from home day types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work from home day types
	 */
	public java.util.List<WorkFromHomeDayType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeDayType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work from home day types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeDayTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from home day types
	 * @param end the upper bound of the range of work from home day types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work from home day types
	 */
	public java.util.List<WorkFromHomeDayType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeDayType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the work from home day types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of work from home day types.
	 *
	 * @return the number of work from home day types
	 */
	public int countAll();

}