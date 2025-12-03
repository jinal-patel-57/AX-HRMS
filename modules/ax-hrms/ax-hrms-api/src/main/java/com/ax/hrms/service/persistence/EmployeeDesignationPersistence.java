/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchEmployeeDesignationException;
import com.ax.hrms.model.EmployeeDesignation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee designation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDesignationUtil
 * @generated
 */
@ProviderType
public interface EmployeeDesignationPersistence
	extends BasePersistence<EmployeeDesignation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeDesignationUtil} to access the employee designation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee designations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee designations
	 */
	public java.util.List<EmployeeDesignation> findByUuid(String uuid);

	/**
	 * Returns a range of all the employee designations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @return the range of matching employee designations
	 */
	public java.util.List<EmployeeDesignation> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the employee designations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee designations
	 */
	public java.util.List<EmployeeDesignation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDesignation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee designations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee designations
	 */
	public java.util.List<EmployeeDesignation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDesignation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee designation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee designation
	 * @throws NoSuchEmployeeDesignationException if a matching employee designation could not be found
	 */
	public EmployeeDesignation findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeDesignation> orderByComparator)
		throws NoSuchEmployeeDesignationException;

	/**
	 * Returns the first employee designation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee designation, or <code>null</code> if a matching employee designation could not be found
	 */
	public EmployeeDesignation fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDesignation>
			orderByComparator);

	/**
	 * Returns the last employee designation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee designation
	 * @throws NoSuchEmployeeDesignationException if a matching employee designation could not be found
	 */
	public EmployeeDesignation findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeDesignation> orderByComparator)
		throws NoSuchEmployeeDesignationException;

	/**
	 * Returns the last employee designation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee designation, or <code>null</code> if a matching employee designation could not be found
	 */
	public EmployeeDesignation fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDesignation>
			orderByComparator);

	/**
	 * Returns the employee designations before and after the current employee designation in the ordered set where uuid = &#63;.
	 *
	 * @param employeeDesignationId the primary key of the current employee designation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee designation
	 * @throws NoSuchEmployeeDesignationException if a employee designation with the primary key could not be found
	 */
	public EmployeeDesignation[] findByUuid_PrevAndNext(
			long employeeDesignationId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeDesignation> orderByComparator)
		throws NoSuchEmployeeDesignationException;

	/**
	 * Removes all the employee designations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of employee designations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee designations
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the employee designation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeDesignationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee designation
	 * @throws NoSuchEmployeeDesignationException if a matching employee designation could not be found
	 */
	public EmployeeDesignation findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDesignationException;

	/**
	 * Returns the employee designation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee designation, or <code>null</code> if a matching employee designation could not be found
	 */
	public EmployeeDesignation fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the employee designation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee designation, or <code>null</code> if a matching employee designation could not be found
	 */
	public EmployeeDesignation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the employee designation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee designation that was removed
	 */
	public EmployeeDesignation removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDesignationException;

	/**
	 * Returns the number of employee designations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee designations
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the employee designations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee designations
	 */
	public java.util.List<EmployeeDesignation> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the employee designations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @return the range of matching employee designations
	 */
	public java.util.List<EmployeeDesignation> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the employee designations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee designations
	 */
	public java.util.List<EmployeeDesignation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDesignation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee designations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee designations
	 */
	public java.util.List<EmployeeDesignation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDesignation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee designation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee designation
	 * @throws NoSuchEmployeeDesignationException if a matching employee designation could not be found
	 */
	public EmployeeDesignation findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeDesignation> orderByComparator)
		throws NoSuchEmployeeDesignationException;

	/**
	 * Returns the first employee designation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee designation, or <code>null</code> if a matching employee designation could not be found
	 */
	public EmployeeDesignation fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDesignation>
			orderByComparator);

	/**
	 * Returns the last employee designation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee designation
	 * @throws NoSuchEmployeeDesignationException if a matching employee designation could not be found
	 */
	public EmployeeDesignation findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeDesignation> orderByComparator)
		throws NoSuchEmployeeDesignationException;

	/**
	 * Returns the last employee designation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee designation, or <code>null</code> if a matching employee designation could not be found
	 */
	public EmployeeDesignation fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDesignation>
			orderByComparator);

	/**
	 * Returns the employee designations before and after the current employee designation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeeDesignationId the primary key of the current employee designation
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee designation
	 * @throws NoSuchEmployeeDesignationException if a employee designation with the primary key could not be found
	 */
	public EmployeeDesignation[] findByUuid_C_PrevAndNext(
			long employeeDesignationId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeDesignation> orderByComparator)
		throws NoSuchEmployeeDesignationException;

	/**
	 * Removes all the employee designations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of employee designations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee designations
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the employee designation where employeeId = &#63; or throws a <code>NoSuchEmployeeDesignationException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee designation
	 * @throws NoSuchEmployeeDesignationException if a matching employee designation could not be found
	 */
	public EmployeeDesignation findByEmployeeId(long employeeId)
		throws NoSuchEmployeeDesignationException;

	/**
	 * Returns the employee designation where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee designation, or <code>null</code> if a matching employee designation could not be found
	 */
	public EmployeeDesignation fetchByEmployeeId(long employeeId);

	/**
	 * Returns the employee designation where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee designation, or <code>null</code> if a matching employee designation could not be found
	 */
	public EmployeeDesignation fetchByEmployeeId(
		long employeeId, boolean useFinderCache);

	/**
	 * Removes the employee designation where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the employee designation that was removed
	 */
	public EmployeeDesignation removeByEmployeeId(long employeeId)
		throws NoSuchEmployeeDesignationException;

	/**
	 * Returns the number of employee designations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee designations
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee designation in the entity cache if it is enabled.
	 *
	 * @param employeeDesignation the employee designation
	 */
	public void cacheResult(EmployeeDesignation employeeDesignation);

	/**
	 * Caches the employee designations in the entity cache if it is enabled.
	 *
	 * @param employeeDesignations the employee designations
	 */
	public void cacheResult(
		java.util.List<EmployeeDesignation> employeeDesignations);

	/**
	 * Creates a new employee designation with the primary key. Does not add the employee designation to the database.
	 *
	 * @param employeeDesignationId the primary key for the new employee designation
	 * @return the new employee designation
	 */
	public EmployeeDesignation create(long employeeDesignationId);

	/**
	 * Removes the employee designation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDesignationId the primary key of the employee designation
	 * @return the employee designation that was removed
	 * @throws NoSuchEmployeeDesignationException if a employee designation with the primary key could not be found
	 */
	public EmployeeDesignation remove(long employeeDesignationId)
		throws NoSuchEmployeeDesignationException;

	public EmployeeDesignation updateImpl(
		EmployeeDesignation employeeDesignation);

	/**
	 * Returns the employee designation with the primary key or throws a <code>NoSuchEmployeeDesignationException</code> if it could not be found.
	 *
	 * @param employeeDesignationId the primary key of the employee designation
	 * @return the employee designation
	 * @throws NoSuchEmployeeDesignationException if a employee designation with the primary key could not be found
	 */
	public EmployeeDesignation findByPrimaryKey(long employeeDesignationId)
		throws NoSuchEmployeeDesignationException;

	/**
	 * Returns the employee designation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDesignationId the primary key of the employee designation
	 * @return the employee designation, or <code>null</code> if a employee designation with the primary key could not be found
	 */
	public EmployeeDesignation fetchByPrimaryKey(long employeeDesignationId);

	/**
	 * Returns all the employee designations.
	 *
	 * @return the employee designations
	 */
	public java.util.List<EmployeeDesignation> findAll();

	/**
	 * Returns a range of all the employee designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @return the range of employee designations
	 */
	public java.util.List<EmployeeDesignation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee designations
	 */
	public java.util.List<EmployeeDesignation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDesignation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee designations
	 */
	public java.util.List<EmployeeDesignation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDesignation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee designations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee designations.
	 *
	 * @return the number of employee designations
	 */
	public int countAll();

}