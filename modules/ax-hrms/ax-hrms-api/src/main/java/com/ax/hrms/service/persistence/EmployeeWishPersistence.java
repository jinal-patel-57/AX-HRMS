/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchEmployeeWishException;
import com.ax.hrms.model.EmployeeWish;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee wish service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeWishUtil
 * @generated
 */
@ProviderType
public interface EmployeeWishPersistence extends BasePersistence<EmployeeWish> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeWishUtil} to access the employee wish persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee wishes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee wishes
	 */
	public java.util.List<EmployeeWish> findByUuid(String uuid);

	/**
	 * Returns a range of all the employee wishes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWishModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee wishes
	 * @param end the upper bound of the range of employee wishes (not inclusive)
	 * @return the range of matching employee wishes
	 */
	public java.util.List<EmployeeWish> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the employee wishes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWishModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee wishes
	 * @param end the upper bound of the range of employee wishes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee wishes
	 */
	public java.util.List<EmployeeWish> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWish>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee wishes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWishModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee wishes
	 * @param end the upper bound of the range of employee wishes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee wishes
	 */
	public java.util.List<EmployeeWish> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWish>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee wish in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee wish
	 * @throws NoSuchEmployeeWishException if a matching employee wish could not be found
	 */
	public EmployeeWish findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeWish>
				orderByComparator)
		throws NoSuchEmployeeWishException;

	/**
	 * Returns the first employee wish in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee wish, or <code>null</code> if a matching employee wish could not be found
	 */
	public EmployeeWish fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWish>
			orderByComparator);

	/**
	 * Returns the last employee wish in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee wish
	 * @throws NoSuchEmployeeWishException if a matching employee wish could not be found
	 */
	public EmployeeWish findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeWish>
				orderByComparator)
		throws NoSuchEmployeeWishException;

	/**
	 * Returns the last employee wish in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee wish, or <code>null</code> if a matching employee wish could not be found
	 */
	public EmployeeWish fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWish>
			orderByComparator);

	/**
	 * Returns the employee wishes before and after the current employee wish in the ordered set where uuid = &#63;.
	 *
	 * @param wishId the primary key of the current employee wish
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee wish
	 * @throws NoSuchEmployeeWishException if a employee wish with the primary key could not be found
	 */
	public EmployeeWish[] findByUuid_PrevAndNext(
			long wishId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeWish>
				orderByComparator)
		throws NoSuchEmployeeWishException;

	/**
	 * Removes all the employee wishes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of employee wishes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee wishes
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the employee wish where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeWishException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee wish
	 * @throws NoSuchEmployeeWishException if a matching employee wish could not be found
	 */
	public EmployeeWish findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeWishException;

	/**
	 * Returns the employee wish where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee wish, or <code>null</code> if a matching employee wish could not be found
	 */
	public EmployeeWish fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the employee wish where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee wish, or <code>null</code> if a matching employee wish could not be found
	 */
	public EmployeeWish fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the employee wish where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee wish that was removed
	 */
	public EmployeeWish removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeWishException;

	/**
	 * Returns the number of employee wishes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee wishes
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the employee wishes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee wishes
	 */
	public java.util.List<EmployeeWish> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the employee wishes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWishModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee wishes
	 * @param end the upper bound of the range of employee wishes (not inclusive)
	 * @return the range of matching employee wishes
	 */
	public java.util.List<EmployeeWish> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the employee wishes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWishModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee wishes
	 * @param end the upper bound of the range of employee wishes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee wishes
	 */
	public java.util.List<EmployeeWish> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWish>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee wishes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWishModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee wishes
	 * @param end the upper bound of the range of employee wishes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee wishes
	 */
	public java.util.List<EmployeeWish> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWish>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee wish in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee wish
	 * @throws NoSuchEmployeeWishException if a matching employee wish could not be found
	 */
	public EmployeeWish findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeWish>
				orderByComparator)
		throws NoSuchEmployeeWishException;

	/**
	 * Returns the first employee wish in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee wish, or <code>null</code> if a matching employee wish could not be found
	 */
	public EmployeeWish fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWish>
			orderByComparator);

	/**
	 * Returns the last employee wish in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee wish
	 * @throws NoSuchEmployeeWishException if a matching employee wish could not be found
	 */
	public EmployeeWish findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeWish>
				orderByComparator)
		throws NoSuchEmployeeWishException;

	/**
	 * Returns the last employee wish in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee wish, or <code>null</code> if a matching employee wish could not be found
	 */
	public EmployeeWish fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWish>
			orderByComparator);

	/**
	 * Returns the employee wishes before and after the current employee wish in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param wishId the primary key of the current employee wish
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee wish
	 * @throws NoSuchEmployeeWishException if a employee wish with the primary key could not be found
	 */
	public EmployeeWish[] findByUuid_C_PrevAndNext(
			long wishId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeWish>
				orderByComparator)
		throws NoSuchEmployeeWishException;

	/**
	 * Removes all the employee wishes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of employee wishes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee wishes
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the employee wish in the entity cache if it is enabled.
	 *
	 * @param employeeWish the employee wish
	 */
	public void cacheResult(EmployeeWish employeeWish);

	/**
	 * Caches the employee wishes in the entity cache if it is enabled.
	 *
	 * @param employeeWishes the employee wishes
	 */
	public void cacheResult(java.util.List<EmployeeWish> employeeWishes);

	/**
	 * Creates a new employee wish with the primary key. Does not add the employee wish to the database.
	 *
	 * @param wishId the primary key for the new employee wish
	 * @return the new employee wish
	 */
	public EmployeeWish create(long wishId);

	/**
	 * Removes the employee wish with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wishId the primary key of the employee wish
	 * @return the employee wish that was removed
	 * @throws NoSuchEmployeeWishException if a employee wish with the primary key could not be found
	 */
	public EmployeeWish remove(long wishId) throws NoSuchEmployeeWishException;

	public EmployeeWish updateImpl(EmployeeWish employeeWish);

	/**
	 * Returns the employee wish with the primary key or throws a <code>NoSuchEmployeeWishException</code> if it could not be found.
	 *
	 * @param wishId the primary key of the employee wish
	 * @return the employee wish
	 * @throws NoSuchEmployeeWishException if a employee wish with the primary key could not be found
	 */
	public EmployeeWish findByPrimaryKey(long wishId)
		throws NoSuchEmployeeWishException;

	/**
	 * Returns the employee wish with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param wishId the primary key of the employee wish
	 * @return the employee wish, or <code>null</code> if a employee wish with the primary key could not be found
	 */
	public EmployeeWish fetchByPrimaryKey(long wishId);

	/**
	 * Returns all the employee wishes.
	 *
	 * @return the employee wishes
	 */
	public java.util.List<EmployeeWish> findAll();

	/**
	 * Returns a range of all the employee wishes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWishModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee wishes
	 * @param end the upper bound of the range of employee wishes (not inclusive)
	 * @return the range of employee wishes
	 */
	public java.util.List<EmployeeWish> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee wishes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWishModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee wishes
	 * @param end the upper bound of the range of employee wishes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee wishes
	 */
	public java.util.List<EmployeeWish> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWish>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee wishes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWishModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee wishes
	 * @param end the upper bound of the range of employee wishes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee wishes
	 */
	public java.util.List<EmployeeWish> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWish>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee wishes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee wishes.
	 *
	 * @return the number of employee wishes
	 */
	public int countAll();

}