/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchEmployeeAddressException;
import com.ax.hrms.model.EmployeeAddress;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee address service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeAddressUtil
 * @generated
 */
@ProviderType
public interface EmployeeAddressPersistence
	extends BasePersistence<EmployeeAddress> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeAddressUtil} to access the employee address persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee addresses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee addresses
	 */
	public java.util.List<EmployeeAddress> findByUuid(String uuid);

	/**
	 * Returns a range of all the employee addresses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @return the range of matching employee addresses
	 */
	public java.util.List<EmployeeAddress> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the employee addresses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee addresses
	 */
	public java.util.List<EmployeeAddress> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee addresses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee addresses
	 */
	public java.util.List<EmployeeAddress> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee address in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public EmployeeAddress findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
				orderByComparator)
		throws NoSuchEmployeeAddressException;

	/**
	 * Returns the first employee address in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public EmployeeAddress fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator);

	/**
	 * Returns the last employee address in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public EmployeeAddress findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
				orderByComparator)
		throws NoSuchEmployeeAddressException;

	/**
	 * Returns the last employee address in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public EmployeeAddress fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator);

	/**
	 * Returns the employee addresses before and after the current employee address in the ordered set where uuid = &#63;.
	 *
	 * @param employeeAddressId the primary key of the current employee address
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee address
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	public EmployeeAddress[] findByUuid_PrevAndNext(
			long employeeAddressId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
				orderByComparator)
		throws NoSuchEmployeeAddressException;

	/**
	 * Removes all the employee addresses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of employee addresses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee addresses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the employee address where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeAddressException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public EmployeeAddress findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeAddressException;

	/**
	 * Returns the employee address where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public EmployeeAddress fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the employee address where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public EmployeeAddress fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the employee address where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee address that was removed
	 */
	public EmployeeAddress removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeAddressException;

	/**
	 * Returns the number of employee addresses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee addresses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the employee addresses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee addresses
	 */
	public java.util.List<EmployeeAddress> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the employee addresses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @return the range of matching employee addresses
	 */
	public java.util.List<EmployeeAddress> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the employee addresses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee addresses
	 */
	public java.util.List<EmployeeAddress> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee addresses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee addresses
	 */
	public java.util.List<EmployeeAddress> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee address in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public EmployeeAddress findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
				orderByComparator)
		throws NoSuchEmployeeAddressException;

	/**
	 * Returns the first employee address in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public EmployeeAddress fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator);

	/**
	 * Returns the last employee address in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public EmployeeAddress findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
				orderByComparator)
		throws NoSuchEmployeeAddressException;

	/**
	 * Returns the last employee address in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public EmployeeAddress fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator);

	/**
	 * Returns the employee addresses before and after the current employee address in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeeAddressId the primary key of the current employee address
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee address
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	public EmployeeAddress[] findByUuid_C_PrevAndNext(
			long employeeAddressId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
				orderByComparator)
		throws NoSuchEmployeeAddressException;

	/**
	 * Removes all the employee addresses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of employee addresses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee addresses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the employee address where employeeId = &#63; or throws a <code>NoSuchEmployeeAddressException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public EmployeeAddress findByEmployeeId(long employeeId)
		throws NoSuchEmployeeAddressException;

	/**
	 * Returns the employee address where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public EmployeeAddress fetchByEmployeeId(long employeeId);

	/**
	 * Returns the employee address where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public EmployeeAddress fetchByEmployeeId(
		long employeeId, boolean useFinderCache);

	/**
	 * Removes the employee address where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the employee address that was removed
	 */
	public EmployeeAddress removeByEmployeeId(long employeeId)
		throws NoSuchEmployeeAddressException;

	/**
	 * Returns the number of employee addresses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee addresses
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee address in the entity cache if it is enabled.
	 *
	 * @param employeeAddress the employee address
	 */
	public void cacheResult(EmployeeAddress employeeAddress);

	/**
	 * Caches the employee addresses in the entity cache if it is enabled.
	 *
	 * @param employeeAddresses the employee addresses
	 */
	public void cacheResult(java.util.List<EmployeeAddress> employeeAddresses);

	/**
	 * Creates a new employee address with the primary key. Does not add the employee address to the database.
	 *
	 * @param employeeAddressId the primary key for the new employee address
	 * @return the new employee address
	 */
	public EmployeeAddress create(long employeeAddressId);

	/**
	 * Removes the employee address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeAddressId the primary key of the employee address
	 * @return the employee address that was removed
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	public EmployeeAddress remove(long employeeAddressId)
		throws NoSuchEmployeeAddressException;

	public EmployeeAddress updateImpl(EmployeeAddress employeeAddress);

	/**
	 * Returns the employee address with the primary key or throws a <code>NoSuchEmployeeAddressException</code> if it could not be found.
	 *
	 * @param employeeAddressId the primary key of the employee address
	 * @return the employee address
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	public EmployeeAddress findByPrimaryKey(long employeeAddressId)
		throws NoSuchEmployeeAddressException;

	/**
	 * Returns the employee address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeAddressId the primary key of the employee address
	 * @return the employee address, or <code>null</code> if a employee address with the primary key could not be found
	 */
	public EmployeeAddress fetchByPrimaryKey(long employeeAddressId);

	/**
	 * Returns all the employee addresses.
	 *
	 * @return the employee addresses
	 */
	public java.util.List<EmployeeAddress> findAll();

	/**
	 * Returns a range of all the employee addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @return the range of employee addresses
	 */
	public java.util.List<EmployeeAddress> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee addresses
	 */
	public java.util.List<EmployeeAddress> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee addresses
	 */
	public java.util.List<EmployeeAddress> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee addresses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee addresses.
	 *
	 * @return the number of employee addresses
	 */
	public int countAll();

}