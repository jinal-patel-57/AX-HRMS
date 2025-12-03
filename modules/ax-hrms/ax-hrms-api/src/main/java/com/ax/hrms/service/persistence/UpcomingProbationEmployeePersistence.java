/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchUpcomingProbationEmployeeException;
import com.ax.hrms.model.UpcomingProbationEmployee;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the upcoming probation employee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UpcomingProbationEmployeeUtil
 * @generated
 */
@ProviderType
public interface UpcomingProbationEmployeePersistence
	extends BasePersistence<UpcomingProbationEmployee> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UpcomingProbationEmployeeUtil} to access the upcoming probation employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the upcoming probation employees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching upcoming probation employees
	 */
	public java.util.List<UpcomingProbationEmployee> findByUuid(String uuid);

	/**
	 * Returns a range of all the upcoming probation employees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @return the range of matching upcoming probation employees
	 */
	public java.util.List<UpcomingProbationEmployee> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the upcoming probation employees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching upcoming probation employees
	 */
	public java.util.List<UpcomingProbationEmployee> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UpcomingProbationEmployee> orderByComparator);

	/**
	 * Returns an ordered range of all the upcoming probation employees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching upcoming probation employees
	 */
	public java.util.List<UpcomingProbationEmployee> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UpcomingProbationEmployee> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first upcoming probation employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a matching upcoming probation employee could not be found
	 */
	public UpcomingProbationEmployee findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<UpcomingProbationEmployee> orderByComparator)
		throws NoSuchUpcomingProbationEmployeeException;

	/**
	 * Returns the first upcoming probation employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	public UpcomingProbationEmployee fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<UpcomingProbationEmployee> orderByComparator);

	/**
	 * Returns the last upcoming probation employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a matching upcoming probation employee could not be found
	 */
	public UpcomingProbationEmployee findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<UpcomingProbationEmployee> orderByComparator)
		throws NoSuchUpcomingProbationEmployeeException;

	/**
	 * Returns the last upcoming probation employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	public UpcomingProbationEmployee fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<UpcomingProbationEmployee> orderByComparator);

	/**
	 * Returns the upcoming probation employees before and after the current upcoming probation employee in the ordered set where uuid = &#63;.
	 *
	 * @param upcomingProbationEmployeeId the primary key of the current upcoming probation employee
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a upcoming probation employee with the primary key could not be found
	 */
	public UpcomingProbationEmployee[] findByUuid_PrevAndNext(
			long upcomingProbationEmployeeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<UpcomingProbationEmployee> orderByComparator)
		throws NoSuchUpcomingProbationEmployeeException;

	/**
	 * Removes all the upcoming probation employees where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of upcoming probation employees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching upcoming probation employees
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the upcoming probation employee where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUpcomingProbationEmployeeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a matching upcoming probation employee could not be found
	 */
	public UpcomingProbationEmployee findByUUID_G(String uuid, long groupId)
		throws NoSuchUpcomingProbationEmployeeException;

	/**
	 * Returns the upcoming probation employee where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	public UpcomingProbationEmployee fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the upcoming probation employee where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	public UpcomingProbationEmployee fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the upcoming probation employee where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the upcoming probation employee that was removed
	 */
	public UpcomingProbationEmployee removeByUUID_G(String uuid, long groupId)
		throws NoSuchUpcomingProbationEmployeeException;

	/**
	 * Returns the number of upcoming probation employees where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching upcoming probation employees
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the upcoming probation employees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching upcoming probation employees
	 */
	public java.util.List<UpcomingProbationEmployee> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the upcoming probation employees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @return the range of matching upcoming probation employees
	 */
	public java.util.List<UpcomingProbationEmployee> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the upcoming probation employees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching upcoming probation employees
	 */
	public java.util.List<UpcomingProbationEmployee> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UpcomingProbationEmployee> orderByComparator);

	/**
	 * Returns an ordered range of all the upcoming probation employees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching upcoming probation employees
	 */
	public java.util.List<UpcomingProbationEmployee> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UpcomingProbationEmployee> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first upcoming probation employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a matching upcoming probation employee could not be found
	 */
	public UpcomingProbationEmployee findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UpcomingProbationEmployee> orderByComparator)
		throws NoSuchUpcomingProbationEmployeeException;

	/**
	 * Returns the first upcoming probation employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	public UpcomingProbationEmployee fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<UpcomingProbationEmployee> orderByComparator);

	/**
	 * Returns the last upcoming probation employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a matching upcoming probation employee could not be found
	 */
	public UpcomingProbationEmployee findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UpcomingProbationEmployee> orderByComparator)
		throws NoSuchUpcomingProbationEmployeeException;

	/**
	 * Returns the last upcoming probation employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	public UpcomingProbationEmployee fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<UpcomingProbationEmployee> orderByComparator);

	/**
	 * Returns the upcoming probation employees before and after the current upcoming probation employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param upcomingProbationEmployeeId the primary key of the current upcoming probation employee
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a upcoming probation employee with the primary key could not be found
	 */
	public UpcomingProbationEmployee[] findByUuid_C_PrevAndNext(
			long upcomingProbationEmployeeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<UpcomingProbationEmployee> orderByComparator)
		throws NoSuchUpcomingProbationEmployeeException;

	/**
	 * Removes all the upcoming probation employees where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of upcoming probation employees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching upcoming probation employees
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the upcoming probation employees where month = &#63; and year = &#63;.
	 *
	 * @param month the month
	 * @param year the year
	 * @return the matching upcoming probation employees
	 */
	public java.util.List<UpcomingProbationEmployee> findByMonthAndYear(
		int month, int year);

	/**
	 * Returns a range of all the upcoming probation employees where month = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param month the month
	 * @param year the year
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @return the range of matching upcoming probation employees
	 */
	public java.util.List<UpcomingProbationEmployee> findByMonthAndYear(
		int month, int year, int start, int end);

	/**
	 * Returns an ordered range of all the upcoming probation employees where month = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param month the month
	 * @param year the year
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching upcoming probation employees
	 */
	public java.util.List<UpcomingProbationEmployee> findByMonthAndYear(
		int month, int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UpcomingProbationEmployee> orderByComparator);

	/**
	 * Returns an ordered range of all the upcoming probation employees where month = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param month the month
	 * @param year the year
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching upcoming probation employees
	 */
	public java.util.List<UpcomingProbationEmployee> findByMonthAndYear(
		int month, int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UpcomingProbationEmployee> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first upcoming probation employee in the ordered set where month = &#63; and year = &#63;.
	 *
	 * @param month the month
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a matching upcoming probation employee could not be found
	 */
	public UpcomingProbationEmployee findByMonthAndYear_First(
			int month, int year,
			com.liferay.portal.kernel.util.OrderByComparator
				<UpcomingProbationEmployee> orderByComparator)
		throws NoSuchUpcomingProbationEmployeeException;

	/**
	 * Returns the first upcoming probation employee in the ordered set where month = &#63; and year = &#63;.
	 *
	 * @param month the month
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	public UpcomingProbationEmployee fetchByMonthAndYear_First(
		int month, int year,
		com.liferay.portal.kernel.util.OrderByComparator
			<UpcomingProbationEmployee> orderByComparator);

	/**
	 * Returns the last upcoming probation employee in the ordered set where month = &#63; and year = &#63;.
	 *
	 * @param month the month
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a matching upcoming probation employee could not be found
	 */
	public UpcomingProbationEmployee findByMonthAndYear_Last(
			int month, int year,
			com.liferay.portal.kernel.util.OrderByComparator
				<UpcomingProbationEmployee> orderByComparator)
		throws NoSuchUpcomingProbationEmployeeException;

	/**
	 * Returns the last upcoming probation employee in the ordered set where month = &#63; and year = &#63;.
	 *
	 * @param month the month
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	public UpcomingProbationEmployee fetchByMonthAndYear_Last(
		int month, int year,
		com.liferay.portal.kernel.util.OrderByComparator
			<UpcomingProbationEmployee> orderByComparator);

	/**
	 * Returns the upcoming probation employees before and after the current upcoming probation employee in the ordered set where month = &#63; and year = &#63;.
	 *
	 * @param upcomingProbationEmployeeId the primary key of the current upcoming probation employee
	 * @param month the month
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a upcoming probation employee with the primary key could not be found
	 */
	public UpcomingProbationEmployee[] findByMonthAndYear_PrevAndNext(
			long upcomingProbationEmployeeId, int month, int year,
			com.liferay.portal.kernel.util.OrderByComparator
				<UpcomingProbationEmployee> orderByComparator)
		throws NoSuchUpcomingProbationEmployeeException;

	/**
	 * Removes all the upcoming probation employees where month = &#63; and year = &#63; from the database.
	 *
	 * @param month the month
	 * @param year the year
	 */
	public void removeByMonthAndYear(int month, int year);

	/**
	 * Returns the number of upcoming probation employees where month = &#63; and year = &#63;.
	 *
	 * @param month the month
	 * @param year the year
	 * @return the number of matching upcoming probation employees
	 */
	public int countByMonthAndYear(int month, int year);

	/**
	 * Caches the upcoming probation employee in the entity cache if it is enabled.
	 *
	 * @param upcomingProbationEmployee the upcoming probation employee
	 */
	public void cacheResult(
		UpcomingProbationEmployee upcomingProbationEmployee);

	/**
	 * Caches the upcoming probation employees in the entity cache if it is enabled.
	 *
	 * @param upcomingProbationEmployees the upcoming probation employees
	 */
	public void cacheResult(
		java.util.List<UpcomingProbationEmployee> upcomingProbationEmployees);

	/**
	 * Creates a new upcoming probation employee with the primary key. Does not add the upcoming probation employee to the database.
	 *
	 * @param upcomingProbationEmployeeId the primary key for the new upcoming probation employee
	 * @return the new upcoming probation employee
	 */
	public UpcomingProbationEmployee create(long upcomingProbationEmployeeId);

	/**
	 * Removes the upcoming probation employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param upcomingProbationEmployeeId the primary key of the upcoming probation employee
	 * @return the upcoming probation employee that was removed
	 * @throws NoSuchUpcomingProbationEmployeeException if a upcoming probation employee with the primary key could not be found
	 */
	public UpcomingProbationEmployee remove(long upcomingProbationEmployeeId)
		throws NoSuchUpcomingProbationEmployeeException;

	public UpcomingProbationEmployee updateImpl(
		UpcomingProbationEmployee upcomingProbationEmployee);

	/**
	 * Returns the upcoming probation employee with the primary key or throws a <code>NoSuchUpcomingProbationEmployeeException</code> if it could not be found.
	 *
	 * @param upcomingProbationEmployeeId the primary key of the upcoming probation employee
	 * @return the upcoming probation employee
	 * @throws NoSuchUpcomingProbationEmployeeException if a upcoming probation employee with the primary key could not be found
	 */
	public UpcomingProbationEmployee findByPrimaryKey(
			long upcomingProbationEmployeeId)
		throws NoSuchUpcomingProbationEmployeeException;

	/**
	 * Returns the upcoming probation employee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param upcomingProbationEmployeeId the primary key of the upcoming probation employee
	 * @return the upcoming probation employee, or <code>null</code> if a upcoming probation employee with the primary key could not be found
	 */
	public UpcomingProbationEmployee fetchByPrimaryKey(
		long upcomingProbationEmployeeId);

	/**
	 * Returns all the upcoming probation employees.
	 *
	 * @return the upcoming probation employees
	 */
	public java.util.List<UpcomingProbationEmployee> findAll();

	/**
	 * Returns a range of all the upcoming probation employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @return the range of upcoming probation employees
	 */
	public java.util.List<UpcomingProbationEmployee> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the upcoming probation employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of upcoming probation employees
	 */
	public java.util.List<UpcomingProbationEmployee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UpcomingProbationEmployee> orderByComparator);

	/**
	 * Returns an ordered range of all the upcoming probation employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of upcoming probation employees
	 */
	public java.util.List<UpcomingProbationEmployee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<UpcomingProbationEmployee> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the upcoming probation employees from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of upcoming probation employees.
	 *
	 * @return the number of upcoming probation employees
	 */
	public int countAll();

}