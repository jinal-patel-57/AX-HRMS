/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchHolidayException;
import com.ax.hrms.model.Holiday;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the holiday service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HolidayUtil
 * @generated
 */
@ProviderType
public interface HolidayPersistence extends BasePersistence<Holiday> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HolidayUtil} to access the holiday persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the holidays where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching holidays
	 */
	public java.util.List<Holiday> findByUuid(String uuid);

	/**
	 * Returns a range of all the holidays where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @return the range of matching holidays
	 */
	public java.util.List<Holiday> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the holidays where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching holidays
	 */
	public java.util.List<Holiday> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Holiday>
			orderByComparator);

	/**
	 * Returns an ordered range of all the holidays where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching holidays
	 */
	public java.util.List<Holiday> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Holiday>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first holiday in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching holiday
	 * @throws NoSuchHolidayException if a matching holiday could not be found
	 */
	public Holiday findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Holiday>
				orderByComparator)
		throws NoSuchHolidayException;

	/**
	 * Returns the first holiday in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public Holiday fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Holiday>
			orderByComparator);

	/**
	 * Returns the last holiday in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching holiday
	 * @throws NoSuchHolidayException if a matching holiday could not be found
	 */
	public Holiday findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Holiday>
				orderByComparator)
		throws NoSuchHolidayException;

	/**
	 * Returns the last holiday in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public Holiday fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Holiday>
			orderByComparator);

	/**
	 * Returns the holidays before and after the current holiday in the ordered set where uuid = &#63;.
	 *
	 * @param holidayId the primary key of the current holiday
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next holiday
	 * @throws NoSuchHolidayException if a holiday with the primary key could not be found
	 */
	public Holiday[] findByUuid_PrevAndNext(
			long holidayId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Holiday>
				orderByComparator)
		throws NoSuchHolidayException;

	/**
	 * Removes all the holidays where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of holidays where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching holidays
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the holiday where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchHolidayException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching holiday
	 * @throws NoSuchHolidayException if a matching holiday could not be found
	 */
	public Holiday findByUUID_G(String uuid, long groupId)
		throws NoSuchHolidayException;

	/**
	 * Returns the holiday where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public Holiday fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the holiday where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public Holiday fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the holiday where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the holiday that was removed
	 */
	public Holiday removeByUUID_G(String uuid, long groupId)
		throws NoSuchHolidayException;

	/**
	 * Returns the number of holidays where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching holidays
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the holidays where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching holidays
	 */
	public java.util.List<Holiday> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the holidays where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @return the range of matching holidays
	 */
	public java.util.List<Holiday> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the holidays where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching holidays
	 */
	public java.util.List<Holiday> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Holiday>
			orderByComparator);

	/**
	 * Returns an ordered range of all the holidays where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching holidays
	 */
	public java.util.List<Holiday> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Holiday>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first holiday in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching holiday
	 * @throws NoSuchHolidayException if a matching holiday could not be found
	 */
	public Holiday findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Holiday>
				orderByComparator)
		throws NoSuchHolidayException;

	/**
	 * Returns the first holiday in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public Holiday fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Holiday>
			orderByComparator);

	/**
	 * Returns the last holiday in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching holiday
	 * @throws NoSuchHolidayException if a matching holiday could not be found
	 */
	public Holiday findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Holiday>
				orderByComparator)
		throws NoSuchHolidayException;

	/**
	 * Returns the last holiday in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public Holiday fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Holiday>
			orderByComparator);

	/**
	 * Returns the holidays before and after the current holiday in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param holidayId the primary key of the current holiday
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next holiday
	 * @throws NoSuchHolidayException if a holiday with the primary key could not be found
	 */
	public Holiday[] findByUuid_C_PrevAndNext(
			long holidayId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Holiday>
				orderByComparator)
		throws NoSuchHolidayException;

	/**
	 * Removes all the holidays where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of holidays where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching holidays
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the holidays where year = &#63;.
	 *
	 * @param year the year
	 * @return the matching holidays
	 */
	public java.util.List<Holiday> findByYear(int year);

	/**
	 * Returns a range of all the holidays where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @return the range of matching holidays
	 */
	public java.util.List<Holiday> findByYear(int year, int start, int end);

	/**
	 * Returns an ordered range of all the holidays where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching holidays
	 */
	public java.util.List<Holiday> findByYear(
		int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Holiday>
			orderByComparator);

	/**
	 * Returns an ordered range of all the holidays where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching holidays
	 */
	public java.util.List<Holiday> findByYear(
		int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Holiday>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first holiday in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching holiday
	 * @throws NoSuchHolidayException if a matching holiday could not be found
	 */
	public Holiday findByYear_First(
			int year,
			com.liferay.portal.kernel.util.OrderByComparator<Holiday>
				orderByComparator)
		throws NoSuchHolidayException;

	/**
	 * Returns the first holiday in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public Holiday fetchByYear_First(
		int year,
		com.liferay.portal.kernel.util.OrderByComparator<Holiday>
			orderByComparator);

	/**
	 * Returns the last holiday in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching holiday
	 * @throws NoSuchHolidayException if a matching holiday could not be found
	 */
	public Holiday findByYear_Last(
			int year,
			com.liferay.portal.kernel.util.OrderByComparator<Holiday>
				orderByComparator)
		throws NoSuchHolidayException;

	/**
	 * Returns the last holiday in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public Holiday fetchByYear_Last(
		int year,
		com.liferay.portal.kernel.util.OrderByComparator<Holiday>
			orderByComparator);

	/**
	 * Returns the holidays before and after the current holiday in the ordered set where year = &#63;.
	 *
	 * @param holidayId the primary key of the current holiday
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next holiday
	 * @throws NoSuchHolidayException if a holiday with the primary key could not be found
	 */
	public Holiday[] findByYear_PrevAndNext(
			long holidayId, int year,
			com.liferay.portal.kernel.util.OrderByComparator<Holiday>
				orderByComparator)
		throws NoSuchHolidayException;

	/**
	 * Removes all the holidays where year = &#63; from the database.
	 *
	 * @param year the year
	 */
	public void removeByYear(int year);

	/**
	 * Returns the number of holidays where year = &#63;.
	 *
	 * @param year the year
	 * @return the number of matching holidays
	 */
	public int countByYear(int year);

	/**
	 * Returns all the holidays where isFloater = &#63; and year = &#63;.
	 *
	 * @param isFloater the is floater
	 * @param year the year
	 * @return the matching holidays
	 */
	public java.util.List<Holiday> findByIsFloaterAndCurrentYear(
		Boolean isFloater, int year);

	/**
	 * Returns a range of all the holidays where isFloater = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param isFloater the is floater
	 * @param year the year
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @return the range of matching holidays
	 */
	public java.util.List<Holiday> findByIsFloaterAndCurrentYear(
		Boolean isFloater, int year, int start, int end);

	/**
	 * Returns an ordered range of all the holidays where isFloater = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param isFloater the is floater
	 * @param year the year
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching holidays
	 */
	public java.util.List<Holiday> findByIsFloaterAndCurrentYear(
		Boolean isFloater, int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Holiday>
			orderByComparator);

	/**
	 * Returns an ordered range of all the holidays where isFloater = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param isFloater the is floater
	 * @param year the year
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching holidays
	 */
	public java.util.List<Holiday> findByIsFloaterAndCurrentYear(
		Boolean isFloater, int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Holiday>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first holiday in the ordered set where isFloater = &#63; and year = &#63;.
	 *
	 * @param isFloater the is floater
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching holiday
	 * @throws NoSuchHolidayException if a matching holiday could not be found
	 */
	public Holiday findByIsFloaterAndCurrentYear_First(
			Boolean isFloater, int year,
			com.liferay.portal.kernel.util.OrderByComparator<Holiday>
				orderByComparator)
		throws NoSuchHolidayException;

	/**
	 * Returns the first holiday in the ordered set where isFloater = &#63; and year = &#63;.
	 *
	 * @param isFloater the is floater
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public Holiday fetchByIsFloaterAndCurrentYear_First(
		Boolean isFloater, int year,
		com.liferay.portal.kernel.util.OrderByComparator<Holiday>
			orderByComparator);

	/**
	 * Returns the last holiday in the ordered set where isFloater = &#63; and year = &#63;.
	 *
	 * @param isFloater the is floater
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching holiday
	 * @throws NoSuchHolidayException if a matching holiday could not be found
	 */
	public Holiday findByIsFloaterAndCurrentYear_Last(
			Boolean isFloater, int year,
			com.liferay.portal.kernel.util.OrderByComparator<Holiday>
				orderByComparator)
		throws NoSuchHolidayException;

	/**
	 * Returns the last holiday in the ordered set where isFloater = &#63; and year = &#63;.
	 *
	 * @param isFloater the is floater
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public Holiday fetchByIsFloaterAndCurrentYear_Last(
		Boolean isFloater, int year,
		com.liferay.portal.kernel.util.OrderByComparator<Holiday>
			orderByComparator);

	/**
	 * Returns the holidays before and after the current holiday in the ordered set where isFloater = &#63; and year = &#63;.
	 *
	 * @param holidayId the primary key of the current holiday
	 * @param isFloater the is floater
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next holiday
	 * @throws NoSuchHolidayException if a holiday with the primary key could not be found
	 */
	public Holiday[] findByIsFloaterAndCurrentYear_PrevAndNext(
			long holidayId, Boolean isFloater, int year,
			com.liferay.portal.kernel.util.OrderByComparator<Holiday>
				orderByComparator)
		throws NoSuchHolidayException;

	/**
	 * Removes all the holidays where isFloater = &#63; and year = &#63; from the database.
	 *
	 * @param isFloater the is floater
	 * @param year the year
	 */
	public void removeByIsFloaterAndCurrentYear(Boolean isFloater, int year);

	/**
	 * Returns the number of holidays where isFloater = &#63; and year = &#63;.
	 *
	 * @param isFloater the is floater
	 * @param year the year
	 * @return the number of matching holidays
	 */
	public int countByIsFloaterAndCurrentYear(Boolean isFloater, int year);

	/**
	 * Returns the holiday where date = &#63; or throws a <code>NoSuchHolidayException</code> if it could not be found.
	 *
	 * @param date the date
	 * @return the matching holiday
	 * @throws NoSuchHolidayException if a matching holiday could not be found
	 */
	public Holiday findByDate(Date date) throws NoSuchHolidayException;

	/**
	 * Returns the holiday where date = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param date the date
	 * @return the matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public Holiday fetchByDate(Date date);

	/**
	 * Returns the holiday where date = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param date the date
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	public Holiday fetchByDate(Date date, boolean useFinderCache);

	/**
	 * Removes the holiday where date = &#63; from the database.
	 *
	 * @param date the date
	 * @return the holiday that was removed
	 */
	public Holiday removeByDate(Date date) throws NoSuchHolidayException;

	/**
	 * Returns the number of holidays where date = &#63;.
	 *
	 * @param date the date
	 * @return the number of matching holidays
	 */
	public int countByDate(Date date);

	/**
	 * Caches the holiday in the entity cache if it is enabled.
	 *
	 * @param holiday the holiday
	 */
	public void cacheResult(Holiday holiday);

	/**
	 * Caches the holidays in the entity cache if it is enabled.
	 *
	 * @param holidays the holidays
	 */
	public void cacheResult(java.util.List<Holiday> holidays);

	/**
	 * Creates a new holiday with the primary key. Does not add the holiday to the database.
	 *
	 * @param holidayId the primary key for the new holiday
	 * @return the new holiday
	 */
	public Holiday create(long holidayId);

	/**
	 * Removes the holiday with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param holidayId the primary key of the holiday
	 * @return the holiday that was removed
	 * @throws NoSuchHolidayException if a holiday with the primary key could not be found
	 */
	public Holiday remove(long holidayId) throws NoSuchHolidayException;

	public Holiday updateImpl(Holiday holiday);

	/**
	 * Returns the holiday with the primary key or throws a <code>NoSuchHolidayException</code> if it could not be found.
	 *
	 * @param holidayId the primary key of the holiday
	 * @return the holiday
	 * @throws NoSuchHolidayException if a holiday with the primary key could not be found
	 */
	public Holiday findByPrimaryKey(long holidayId)
		throws NoSuchHolidayException;

	/**
	 * Returns the holiday with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param holidayId the primary key of the holiday
	 * @return the holiday, or <code>null</code> if a holiday with the primary key could not be found
	 */
	public Holiday fetchByPrimaryKey(long holidayId);

	/**
	 * Returns all the holidays.
	 *
	 * @return the holidays
	 */
	public java.util.List<Holiday> findAll();

	/**
	 * Returns a range of all the holidays.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @return the range of holidays
	 */
	public java.util.List<Holiday> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the holidays.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of holidays
	 */
	public java.util.List<Holiday> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Holiday>
			orderByComparator);

	/**
	 * Returns an ordered range of all the holidays.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of holidays
	 */
	public java.util.List<Holiday> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Holiday>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the holidays from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of holidays.
	 *
	 * @return the number of holidays
	 */
	public int countAll();

}