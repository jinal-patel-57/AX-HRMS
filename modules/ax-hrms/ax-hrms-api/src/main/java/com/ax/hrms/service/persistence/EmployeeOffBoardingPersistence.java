/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchEmployeeOffBoardingException;
import com.ax.hrms.model.EmployeeOffBoarding;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee off boarding service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeOffBoardingUtil
 * @generated
 */
@ProviderType
public interface EmployeeOffBoardingPersistence
	extends BasePersistence<EmployeeOffBoarding> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeOffBoardingUtil} to access the employee off boarding persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee off boardings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee off boardings
	 */
	public java.util.List<EmployeeOffBoarding> findByUuid(String uuid);

	/**
	 * Returns a range of all the employee off boardings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @return the range of matching employee off boardings
	 */
	public java.util.List<EmployeeOffBoarding> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the employee off boardings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee off boardings
	 */
	public java.util.List<EmployeeOffBoarding> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOffBoarding>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee off boardings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee off boardings
	 */
	public java.util.List<EmployeeOffBoarding> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOffBoarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee off boarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a matching employee off boarding could not be found
	 */
	public EmployeeOffBoarding findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOffBoarding> orderByComparator)
		throws NoSuchEmployeeOffBoardingException;

	/**
	 * Returns the first employee off boarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	public EmployeeOffBoarding fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOffBoarding>
			orderByComparator);

	/**
	 * Returns the last employee off boarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a matching employee off boarding could not be found
	 */
	public EmployeeOffBoarding findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOffBoarding> orderByComparator)
		throws NoSuchEmployeeOffBoardingException;

	/**
	 * Returns the last employee off boarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	public EmployeeOffBoarding fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOffBoarding>
			orderByComparator);

	/**
	 * Returns the employee off boardings before and after the current employee off boarding in the ordered set where uuid = &#63;.
	 *
	 * @param employeeOffBoardingId the primary key of the current employee off boarding
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a employee off boarding with the primary key could not be found
	 */
	public EmployeeOffBoarding[] findByUuid_PrevAndNext(
			long employeeOffBoardingId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOffBoarding> orderByComparator)
		throws NoSuchEmployeeOffBoardingException;

	/**
	 * Removes all the employee off boardings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of employee off boardings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee off boardings
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the employee off boarding where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeOffBoardingException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a matching employee off boarding could not be found
	 */
	public EmployeeOffBoarding findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeOffBoardingException;

	/**
	 * Returns the employee off boarding where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	public EmployeeOffBoarding fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the employee off boarding where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	public EmployeeOffBoarding fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the employee off boarding where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee off boarding that was removed
	 */
	public EmployeeOffBoarding removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeOffBoardingException;

	/**
	 * Returns the number of employee off boardings where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee off boardings
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the employee off boardings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee off boardings
	 */
	public java.util.List<EmployeeOffBoarding> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the employee off boardings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @return the range of matching employee off boardings
	 */
	public java.util.List<EmployeeOffBoarding> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the employee off boardings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee off boardings
	 */
	public java.util.List<EmployeeOffBoarding> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOffBoarding>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee off boardings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee off boardings
	 */
	public java.util.List<EmployeeOffBoarding> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOffBoarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee off boarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a matching employee off boarding could not be found
	 */
	public EmployeeOffBoarding findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOffBoarding> orderByComparator)
		throws NoSuchEmployeeOffBoardingException;

	/**
	 * Returns the first employee off boarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	public EmployeeOffBoarding fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOffBoarding>
			orderByComparator);

	/**
	 * Returns the last employee off boarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a matching employee off boarding could not be found
	 */
	public EmployeeOffBoarding findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOffBoarding> orderByComparator)
		throws NoSuchEmployeeOffBoardingException;

	/**
	 * Returns the last employee off boarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	public EmployeeOffBoarding fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOffBoarding>
			orderByComparator);

	/**
	 * Returns the employee off boardings before and after the current employee off boarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeeOffBoardingId the primary key of the current employee off boarding
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a employee off boarding with the primary key could not be found
	 */
	public EmployeeOffBoarding[] findByUuid_C_PrevAndNext(
			long employeeOffBoardingId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOffBoarding> orderByComparator)
		throws NoSuchEmployeeOffBoardingException;

	/**
	 * Removes all the employee off boardings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of employee off boardings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee off boardings
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the employee off boarding where employeeId = &#63; or throws a <code>NoSuchEmployeeOffBoardingException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a matching employee off boarding could not be found
	 */
	public EmployeeOffBoarding findByEmployeeId(long employeeId)
		throws NoSuchEmployeeOffBoardingException;

	/**
	 * Returns the employee off boarding where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	public EmployeeOffBoarding fetchByEmployeeId(long employeeId);

	/**
	 * Returns the employee off boarding where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	public EmployeeOffBoarding fetchByEmployeeId(
		long employeeId, boolean useFinderCache);

	/**
	 * Removes the employee off boarding where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the employee off boarding that was removed
	 */
	public EmployeeOffBoarding removeByEmployeeId(long employeeId)
		throws NoSuchEmployeeOffBoardingException;

	/**
	 * Returns the number of employee off boardings where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee off boardings
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee off boarding in the entity cache if it is enabled.
	 *
	 * @param employeeOffBoarding the employee off boarding
	 */
	public void cacheResult(EmployeeOffBoarding employeeOffBoarding);

	/**
	 * Caches the employee off boardings in the entity cache if it is enabled.
	 *
	 * @param employeeOffBoardings the employee off boardings
	 */
	public void cacheResult(
		java.util.List<EmployeeOffBoarding> employeeOffBoardings);

	/**
	 * Creates a new employee off boarding with the primary key. Does not add the employee off boarding to the database.
	 *
	 * @param employeeOffBoardingId the primary key for the new employee off boarding
	 * @return the new employee off boarding
	 */
	public EmployeeOffBoarding create(long employeeOffBoardingId);

	/**
	 * Removes the employee off boarding with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeOffBoardingId the primary key of the employee off boarding
	 * @return the employee off boarding that was removed
	 * @throws NoSuchEmployeeOffBoardingException if a employee off boarding with the primary key could not be found
	 */
	public EmployeeOffBoarding remove(long employeeOffBoardingId)
		throws NoSuchEmployeeOffBoardingException;

	public EmployeeOffBoarding updateImpl(
		EmployeeOffBoarding employeeOffBoarding);

	/**
	 * Returns the employee off boarding with the primary key or throws a <code>NoSuchEmployeeOffBoardingException</code> if it could not be found.
	 *
	 * @param employeeOffBoardingId the primary key of the employee off boarding
	 * @return the employee off boarding
	 * @throws NoSuchEmployeeOffBoardingException if a employee off boarding with the primary key could not be found
	 */
	public EmployeeOffBoarding findByPrimaryKey(long employeeOffBoardingId)
		throws NoSuchEmployeeOffBoardingException;

	/**
	 * Returns the employee off boarding with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeOffBoardingId the primary key of the employee off boarding
	 * @return the employee off boarding, or <code>null</code> if a employee off boarding with the primary key could not be found
	 */
	public EmployeeOffBoarding fetchByPrimaryKey(long employeeOffBoardingId);

	/**
	 * Returns all the employee off boardings.
	 *
	 * @return the employee off boardings
	 */
	public java.util.List<EmployeeOffBoarding> findAll();

	/**
	 * Returns a range of all the employee off boardings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @return the range of employee off boardings
	 */
	public java.util.List<EmployeeOffBoarding> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee off boardings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee off boardings
	 */
	public java.util.List<EmployeeOffBoarding> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOffBoarding>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee off boardings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee off boardings
	 */
	public java.util.List<EmployeeOffBoarding> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOffBoarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee off boardings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee off boardings.
	 *
	 * @return the number of employee off boardings
	 */
	public int countAll();

}