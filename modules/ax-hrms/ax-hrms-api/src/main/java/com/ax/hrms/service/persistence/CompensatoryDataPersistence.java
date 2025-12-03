/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchCompensatoryDataException;
import com.ax.hrms.model.CompensatoryData;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the compensatory data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CompensatoryDataUtil
 * @generated
 */
@ProviderType
public interface CompensatoryDataPersistence
	extends BasePersistence<CompensatoryData> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CompensatoryDataUtil} to access the compensatory data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the compensatory datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching compensatory datas
	 */
	public java.util.List<CompensatoryData> findByUuid(String uuid);

	/**
	 * Returns a range of all the compensatory datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @return the range of matching compensatory datas
	 */
	public java.util.List<CompensatoryData> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the compensatory datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching compensatory datas
	 */
	public java.util.List<CompensatoryData> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
			orderByComparator);

	/**
	 * Returns an ordered range of all the compensatory datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching compensatory datas
	 */
	public java.util.List<CompensatoryData> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first compensatory data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching compensatory data
	 * @throws NoSuchCompensatoryDataException if a matching compensatory data could not be found
	 */
	public CompensatoryData findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
				orderByComparator)
		throws NoSuchCompensatoryDataException;

	/**
	 * Returns the first compensatory data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	public CompensatoryData fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
			orderByComparator);

	/**
	 * Returns the last compensatory data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching compensatory data
	 * @throws NoSuchCompensatoryDataException if a matching compensatory data could not be found
	 */
	public CompensatoryData findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
				orderByComparator)
		throws NoSuchCompensatoryDataException;

	/**
	 * Returns the last compensatory data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	public CompensatoryData fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
			orderByComparator);

	/**
	 * Returns the compensatory datas before and after the current compensatory data in the ordered set where uuid = &#63;.
	 *
	 * @param compensatoryDataId the primary key of the current compensatory data
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next compensatory data
	 * @throws NoSuchCompensatoryDataException if a compensatory data with the primary key could not be found
	 */
	public CompensatoryData[] findByUuid_PrevAndNext(
			long compensatoryDataId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
				orderByComparator)
		throws NoSuchCompensatoryDataException;

	/**
	 * Removes all the compensatory datas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of compensatory datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching compensatory datas
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the compensatory data where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCompensatoryDataException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching compensatory data
	 * @throws NoSuchCompensatoryDataException if a matching compensatory data could not be found
	 */
	public CompensatoryData findByUUID_G(String uuid, long groupId)
		throws NoSuchCompensatoryDataException;

	/**
	 * Returns the compensatory data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	public CompensatoryData fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the compensatory data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	public CompensatoryData fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the compensatory data where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the compensatory data that was removed
	 */
	public CompensatoryData removeByUUID_G(String uuid, long groupId)
		throws NoSuchCompensatoryDataException;

	/**
	 * Returns the number of compensatory datas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching compensatory datas
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the compensatory datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching compensatory datas
	 */
	public java.util.List<CompensatoryData> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the compensatory datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @return the range of matching compensatory datas
	 */
	public java.util.List<CompensatoryData> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the compensatory datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching compensatory datas
	 */
	public java.util.List<CompensatoryData> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
			orderByComparator);

	/**
	 * Returns an ordered range of all the compensatory datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching compensatory datas
	 */
	public java.util.List<CompensatoryData> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first compensatory data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching compensatory data
	 * @throws NoSuchCompensatoryDataException if a matching compensatory data could not be found
	 */
	public CompensatoryData findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
				orderByComparator)
		throws NoSuchCompensatoryDataException;

	/**
	 * Returns the first compensatory data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	public CompensatoryData fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
			orderByComparator);

	/**
	 * Returns the last compensatory data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching compensatory data
	 * @throws NoSuchCompensatoryDataException if a matching compensatory data could not be found
	 */
	public CompensatoryData findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
				orderByComparator)
		throws NoSuchCompensatoryDataException;

	/**
	 * Returns the last compensatory data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	public CompensatoryData fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
			orderByComparator);

	/**
	 * Returns the compensatory datas before and after the current compensatory data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param compensatoryDataId the primary key of the current compensatory data
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next compensatory data
	 * @throws NoSuchCompensatoryDataException if a compensatory data with the primary key could not be found
	 */
	public CompensatoryData[] findByUuid_C_PrevAndNext(
			long compensatoryDataId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
				orderByComparator)
		throws NoSuchCompensatoryDataException;

	/**
	 * Removes all the compensatory datas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of compensatory datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching compensatory datas
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the compensatory datas where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching compensatory datas
	 */
	public java.util.List<CompensatoryData> findByEmployeeId(long employeeId);

	/**
	 * Returns a range of all the compensatory datas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @return the range of matching compensatory datas
	 */
	public java.util.List<CompensatoryData> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the compensatory datas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching compensatory datas
	 */
	public java.util.List<CompensatoryData> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
			orderByComparator);

	/**
	 * Returns an ordered range of all the compensatory datas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching compensatory datas
	 */
	public java.util.List<CompensatoryData> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first compensatory data in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching compensatory data
	 * @throws NoSuchCompensatoryDataException if a matching compensatory data could not be found
	 */
	public CompensatoryData findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
				orderByComparator)
		throws NoSuchCompensatoryDataException;

	/**
	 * Returns the first compensatory data in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	public CompensatoryData fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
			orderByComparator);

	/**
	 * Returns the last compensatory data in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching compensatory data
	 * @throws NoSuchCompensatoryDataException if a matching compensatory data could not be found
	 */
	public CompensatoryData findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
				orderByComparator)
		throws NoSuchCompensatoryDataException;

	/**
	 * Returns the last compensatory data in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	public CompensatoryData fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
			orderByComparator);

	/**
	 * Returns the compensatory datas before and after the current compensatory data in the ordered set where employeeId = &#63;.
	 *
	 * @param compensatoryDataId the primary key of the current compensatory data
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next compensatory data
	 * @throws NoSuchCompensatoryDataException if a compensatory data with the primary key could not be found
	 */
	public CompensatoryData[] findByEmployeeId_PrevAndNext(
			long compensatoryDataId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
				orderByComparator)
		throws NoSuchCompensatoryDataException;

	/**
	 * Removes all the compensatory datas where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of compensatory datas where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching compensatory datas
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the compensatory datas where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @return the matching compensatory datas
	 */
	public java.util.List<CompensatoryData> findByManagerId(long managerId);

	/**
	 * Returns a range of all the compensatory datas where managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @return the range of matching compensatory datas
	 */
	public java.util.List<CompensatoryData> findByManagerId(
		long managerId, int start, int end);

	/**
	 * Returns an ordered range of all the compensatory datas where managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching compensatory datas
	 */
	public java.util.List<CompensatoryData> findByManagerId(
		long managerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
			orderByComparator);

	/**
	 * Returns an ordered range of all the compensatory datas where managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching compensatory datas
	 */
	public java.util.List<CompensatoryData> findByManagerId(
		long managerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first compensatory data in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching compensatory data
	 * @throws NoSuchCompensatoryDataException if a matching compensatory data could not be found
	 */
	public CompensatoryData findByManagerId_First(
			long managerId,
			com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
				orderByComparator)
		throws NoSuchCompensatoryDataException;

	/**
	 * Returns the first compensatory data in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	public CompensatoryData fetchByManagerId_First(
		long managerId,
		com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
			orderByComparator);

	/**
	 * Returns the last compensatory data in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching compensatory data
	 * @throws NoSuchCompensatoryDataException if a matching compensatory data could not be found
	 */
	public CompensatoryData findByManagerId_Last(
			long managerId,
			com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
				orderByComparator)
		throws NoSuchCompensatoryDataException;

	/**
	 * Returns the last compensatory data in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	public CompensatoryData fetchByManagerId_Last(
		long managerId,
		com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
			orderByComparator);

	/**
	 * Returns the compensatory datas before and after the current compensatory data in the ordered set where managerId = &#63;.
	 *
	 * @param compensatoryDataId the primary key of the current compensatory data
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next compensatory data
	 * @throws NoSuchCompensatoryDataException if a compensatory data with the primary key could not be found
	 */
	public CompensatoryData[] findByManagerId_PrevAndNext(
			long compensatoryDataId, long managerId,
			com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
				orderByComparator)
		throws NoSuchCompensatoryDataException;

	/**
	 * Removes all the compensatory datas where managerId = &#63; from the database.
	 *
	 * @param managerId the manager ID
	 */
	public void removeByManagerId(long managerId);

	/**
	 * Returns the number of compensatory datas where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @return the number of matching compensatory datas
	 */
	public int countByManagerId(long managerId);

	/**
	 * Caches the compensatory data in the entity cache if it is enabled.
	 *
	 * @param compensatoryData the compensatory data
	 */
	public void cacheResult(CompensatoryData compensatoryData);

	/**
	 * Caches the compensatory datas in the entity cache if it is enabled.
	 *
	 * @param compensatoryDatas the compensatory datas
	 */
	public void cacheResult(java.util.List<CompensatoryData> compensatoryDatas);

	/**
	 * Creates a new compensatory data with the primary key. Does not add the compensatory data to the database.
	 *
	 * @param compensatoryDataId the primary key for the new compensatory data
	 * @return the new compensatory data
	 */
	public CompensatoryData create(long compensatoryDataId);

	/**
	 * Removes the compensatory data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param compensatoryDataId the primary key of the compensatory data
	 * @return the compensatory data that was removed
	 * @throws NoSuchCompensatoryDataException if a compensatory data with the primary key could not be found
	 */
	public CompensatoryData remove(long compensatoryDataId)
		throws NoSuchCompensatoryDataException;

	public CompensatoryData updateImpl(CompensatoryData compensatoryData);

	/**
	 * Returns the compensatory data with the primary key or throws a <code>NoSuchCompensatoryDataException</code> if it could not be found.
	 *
	 * @param compensatoryDataId the primary key of the compensatory data
	 * @return the compensatory data
	 * @throws NoSuchCompensatoryDataException if a compensatory data with the primary key could not be found
	 */
	public CompensatoryData findByPrimaryKey(long compensatoryDataId)
		throws NoSuchCompensatoryDataException;

	/**
	 * Returns the compensatory data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param compensatoryDataId the primary key of the compensatory data
	 * @return the compensatory data, or <code>null</code> if a compensatory data with the primary key could not be found
	 */
	public CompensatoryData fetchByPrimaryKey(long compensatoryDataId);

	/**
	 * Returns all the compensatory datas.
	 *
	 * @return the compensatory datas
	 */
	public java.util.List<CompensatoryData> findAll();

	/**
	 * Returns a range of all the compensatory datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @return the range of compensatory datas
	 */
	public java.util.List<CompensatoryData> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the compensatory datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of compensatory datas
	 */
	public java.util.List<CompensatoryData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
			orderByComparator);

	/**
	 * Returns an ordered range of all the compensatory datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of compensatory datas
	 */
	public java.util.List<CompensatoryData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CompensatoryData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the compensatory datas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of compensatory datas.
	 *
	 * @return the number of compensatory datas
	 */
	public int countAll();

}