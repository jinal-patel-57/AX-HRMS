/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchEmployeeUanEsicException;
import com.ax.hrms.model.EmployeeUanEsic;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee uan esic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeUanEsicUtil
 * @generated
 */
@ProviderType
public interface EmployeeUanEsicPersistence
	extends BasePersistence<EmployeeUanEsic> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeUanEsicUtil} to access the employee uan esic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee uan esics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee uan esics
	 */
	public java.util.List<EmployeeUanEsic> findByUuid(String uuid);

	/**
	 * Returns a range of all the employee uan esics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @return the range of matching employee uan esics
	 */
	public java.util.List<EmployeeUanEsic> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the employee uan esics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee uan esics
	 */
	public java.util.List<EmployeeUanEsic> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeUanEsic>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee uan esics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee uan esics
	 */
	public java.util.List<EmployeeUanEsic> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeUanEsic>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee uan esic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a matching employee uan esic could not be found
	 */
	public EmployeeUanEsic findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeUanEsic>
				orderByComparator)
		throws NoSuchEmployeeUanEsicException;

	/**
	 * Returns the first employee uan esic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee uan esic, or <code>null</code> if a matching employee uan esic could not be found
	 */
	public EmployeeUanEsic fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeUanEsic>
			orderByComparator);

	/**
	 * Returns the last employee uan esic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a matching employee uan esic could not be found
	 */
	public EmployeeUanEsic findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeUanEsic>
				orderByComparator)
		throws NoSuchEmployeeUanEsicException;

	/**
	 * Returns the last employee uan esic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee uan esic, or <code>null</code> if a matching employee uan esic could not be found
	 */
	public EmployeeUanEsic fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeUanEsic>
			orderByComparator);

	/**
	 * Returns the employee uan esics before and after the current employee uan esic in the ordered set where uuid = &#63;.
	 *
	 * @param uanEsicId the primary key of the current employee uan esic
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a employee uan esic with the primary key could not be found
	 */
	public EmployeeUanEsic[] findByUuid_PrevAndNext(
			long uanEsicId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeUanEsic>
				orderByComparator)
		throws NoSuchEmployeeUanEsicException;

	/**
	 * Removes all the employee uan esics where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of employee uan esics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee uan esics
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the employee uan esic where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeUanEsicException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a matching employee uan esic could not be found
	 */
	public EmployeeUanEsic findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeUanEsicException;

	/**
	 * Returns the employee uan esic where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee uan esic, or <code>null</code> if a matching employee uan esic could not be found
	 */
	public EmployeeUanEsic fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the employee uan esic where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee uan esic, or <code>null</code> if a matching employee uan esic could not be found
	 */
	public EmployeeUanEsic fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the employee uan esic where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee uan esic that was removed
	 */
	public EmployeeUanEsic removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeUanEsicException;

	/**
	 * Returns the number of employee uan esics where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee uan esics
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the employee uan esics where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee uan esics
	 */
	public java.util.List<EmployeeUanEsic> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the employee uan esics where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @return the range of matching employee uan esics
	 */
	public java.util.List<EmployeeUanEsic> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the employee uan esics where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee uan esics
	 */
	public java.util.List<EmployeeUanEsic> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeUanEsic>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee uan esics where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee uan esics
	 */
	public java.util.List<EmployeeUanEsic> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeUanEsic>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee uan esic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a matching employee uan esic could not be found
	 */
	public EmployeeUanEsic findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeUanEsic>
				orderByComparator)
		throws NoSuchEmployeeUanEsicException;

	/**
	 * Returns the first employee uan esic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee uan esic, or <code>null</code> if a matching employee uan esic could not be found
	 */
	public EmployeeUanEsic fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeUanEsic>
			orderByComparator);

	/**
	 * Returns the last employee uan esic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a matching employee uan esic could not be found
	 */
	public EmployeeUanEsic findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeUanEsic>
				orderByComparator)
		throws NoSuchEmployeeUanEsicException;

	/**
	 * Returns the last employee uan esic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee uan esic, or <code>null</code> if a matching employee uan esic could not be found
	 */
	public EmployeeUanEsic fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeUanEsic>
			orderByComparator);

	/**
	 * Returns the employee uan esics before and after the current employee uan esic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uanEsicId the primary key of the current employee uan esic
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a employee uan esic with the primary key could not be found
	 */
	public EmployeeUanEsic[] findByUuid_C_PrevAndNext(
			long uanEsicId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeUanEsic>
				orderByComparator)
		throws NoSuchEmployeeUanEsicException;

	/**
	 * Removes all the employee uan esics where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of employee uan esics where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee uan esics
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the employee uan esic in the entity cache if it is enabled.
	 *
	 * @param employeeUanEsic the employee uan esic
	 */
	public void cacheResult(EmployeeUanEsic employeeUanEsic);

	/**
	 * Caches the employee uan esics in the entity cache if it is enabled.
	 *
	 * @param employeeUanEsics the employee uan esics
	 */
	public void cacheResult(java.util.List<EmployeeUanEsic> employeeUanEsics);

	/**
	 * Creates a new employee uan esic with the primary key. Does not add the employee uan esic to the database.
	 *
	 * @param uanEsicId the primary key for the new employee uan esic
	 * @return the new employee uan esic
	 */
	public EmployeeUanEsic create(long uanEsicId);

	/**
	 * Removes the employee uan esic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param uanEsicId the primary key of the employee uan esic
	 * @return the employee uan esic that was removed
	 * @throws NoSuchEmployeeUanEsicException if a employee uan esic with the primary key could not be found
	 */
	public EmployeeUanEsic remove(long uanEsicId)
		throws NoSuchEmployeeUanEsicException;

	public EmployeeUanEsic updateImpl(EmployeeUanEsic employeeUanEsic);

	/**
	 * Returns the employee uan esic with the primary key or throws a <code>NoSuchEmployeeUanEsicException</code> if it could not be found.
	 *
	 * @param uanEsicId the primary key of the employee uan esic
	 * @return the employee uan esic
	 * @throws NoSuchEmployeeUanEsicException if a employee uan esic with the primary key could not be found
	 */
	public EmployeeUanEsic findByPrimaryKey(long uanEsicId)
		throws NoSuchEmployeeUanEsicException;

	/**
	 * Returns the employee uan esic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param uanEsicId the primary key of the employee uan esic
	 * @return the employee uan esic, or <code>null</code> if a employee uan esic with the primary key could not be found
	 */
	public EmployeeUanEsic fetchByPrimaryKey(long uanEsicId);

	/**
	 * Returns all the employee uan esics.
	 *
	 * @return the employee uan esics
	 */
	public java.util.List<EmployeeUanEsic> findAll();

	/**
	 * Returns a range of all the employee uan esics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @return the range of employee uan esics
	 */
	public java.util.List<EmployeeUanEsic> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee uan esics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee uan esics
	 */
	public java.util.List<EmployeeUanEsic> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeUanEsic>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee uan esics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee uan esics
	 */
	public java.util.List<EmployeeUanEsic> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeUanEsic>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee uan esics from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee uan esics.
	 *
	 * @return the number of employee uan esics
	 */
	public int countAll();

}