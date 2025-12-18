/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchWorkFromHomeRequestException;
import com.ax.hrms.model.WorkFromHomeRequest;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the work from home request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkFromHomeRequestUtil
 * @generated
 */
@ProviderType
public interface WorkFromHomeRequestPersistence
	extends BasePersistence<WorkFromHomeRequest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkFromHomeRequestUtil} to access the work from home request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the work from home requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByUuid(String uuid);

	/**
	 * Returns a range of all the work from home requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @return the range of matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the work from home requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work from home requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work from home request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException;

	/**
	 * Returns the first work from home request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator);

	/**
	 * Returns the last work from home request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException;

	/**
	 * Returns the last work from home request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator);

	/**
	 * Returns the work from home requests before and after the current work from home request in the ordered set where uuid = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	public WorkFromHomeRequest[] findByUuid_PrevAndNext(
			long workFromHomeRequestId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException;

	/**
	 * Removes all the work from home requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of work from home requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching work from home requests
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the work from home request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchWorkFromHomeRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchWorkFromHomeRequestException;

	/**
	 * Returns the work from home request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the work from home request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the work from home request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the work from home request that was removed
	 */
	public WorkFromHomeRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchWorkFromHomeRequestException;

	/**
	 * Returns the number of work from home requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching work from home requests
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the work from home requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the work from home requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @return the range of matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the work from home requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work from home requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work from home request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException;

	/**
	 * Returns the first work from home request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator);

	/**
	 * Returns the last work from home request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException;

	/**
	 * Returns the last work from home request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator);

	/**
	 * Returns the work from home requests before and after the current work from home request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	public WorkFromHomeRequest[] findByUuid_C_PrevAndNext(
			long workFromHomeRequestId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException;

	/**
	 * Removes all the work from home requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of work from home requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching work from home requests
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the work from home requests where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByEmployeeId(
		long employeeId);

	/**
	 * Returns a range of all the work from home requests where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @return the range of matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the work from home requests where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work from home requests where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work from home request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException;

	/**
	 * Returns the first work from home request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator);

	/**
	 * Returns the last work from home request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException;

	/**
	 * Returns the last work from home request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator);

	/**
	 * Returns the work from home requests before and after the current work from home request in the ordered set where employeeId = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home request
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	public WorkFromHomeRequest[] findByEmployeeId_PrevAndNext(
			long workFromHomeRequestId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException;

	/**
	 * Removes all the work from home requests where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of work from home requests where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching work from home requests
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the work from home requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByStatus(long status);

	/**
	 * Returns a range of all the work from home requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @return the range of matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByStatus(
		long status, int start, int end);

	/**
	 * Returns an ordered range of all the work from home requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByStatus(
		long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work from home requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByStatus(
		long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work from home request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest findByStatus_First(
			long status,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException;

	/**
	 * Returns the first work from home request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest fetchByStatus_First(
		long status,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator);

	/**
	 * Returns the last work from home request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest findByStatus_Last(
			long status,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException;

	/**
	 * Returns the last work from home request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest fetchByStatus_Last(
		long status,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator);

	/**
	 * Returns the work from home requests before and after the current work from home request in the ordered set where status = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home request
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	public WorkFromHomeRequest[] findByStatus_PrevAndNext(
			long workFromHomeRequestId, long status,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException;

	/**
	 * Removes all the work from home requests where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(long status);

	/**
	 * Returns the number of work from home requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching work from home requests
	 */
	public int countByStatus(long status);

	/**
	 * Returns all the work from home requests where employeeId = &#63; and status = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @return the matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByEmployeeIdAndStatus(
		long employeeId, long status);

	/**
	 * Returns a range of all the work from home requests where employeeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @return the range of matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByEmployeeIdAndStatus(
		long employeeId, long status, int start, int end);

	/**
	 * Returns an ordered range of all the work from home requests where employeeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByEmployeeIdAndStatus(
		long employeeId, long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work from home requests where employeeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByEmployeeIdAndStatus(
		long employeeId, long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work from home request in the ordered set where employeeId = &#63; and status = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest findByEmployeeIdAndStatus_First(
			long employeeId, long status,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException;

	/**
	 * Returns the first work from home request in the ordered set where employeeId = &#63; and status = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest fetchByEmployeeIdAndStatus_First(
		long employeeId, long status,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator);

	/**
	 * Returns the last work from home request in the ordered set where employeeId = &#63; and status = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest findByEmployeeIdAndStatus_Last(
			long employeeId, long status,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException;

	/**
	 * Returns the last work from home request in the ordered set where employeeId = &#63; and status = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest fetchByEmployeeIdAndStatus_Last(
		long employeeId, long status,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator);

	/**
	 * Returns the work from home requests before and after the current work from home request in the ordered set where employeeId = &#63; and status = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home request
	 * @param employeeId the employee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	public WorkFromHomeRequest[] findByEmployeeIdAndStatus_PrevAndNext(
			long workFromHomeRequestId, long employeeId, long status,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException;

	/**
	 * Removes all the work from home requests where employeeId = &#63; and status = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 */
	public void removeByEmployeeIdAndStatus(long employeeId, long status);

	/**
	 * Returns the number of work from home requests where employeeId = &#63; and status = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param status the status
	 * @return the number of matching work from home requests
	 */
	public int countByEmployeeIdAndStatus(long employeeId, long status);

	/**
	 * Returns all the work from home requests where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByDateRange(
		Date startDate, Date endDate);

	/**
	 * Returns a range of all the work from home requests where startDate = &#63; and endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @return the range of matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByDateRange(
		Date startDate, Date endDate, int start, int end);

	/**
	 * Returns an ordered range of all the work from home requests where startDate = &#63; and endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByDateRange(
		Date startDate, Date endDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work from home requests where startDate = &#63; and endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findByDateRange(
		Date startDate, Date endDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work from home request in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest findByDateRange_First(
			Date startDate, Date endDate,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException;

	/**
	 * Returns the first work from home request in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest fetchByDateRange_First(
		Date startDate, Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator);

	/**
	 * Returns the last work from home request in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest findByDateRange_Last(
			Date startDate, Date endDate,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException;

	/**
	 * Returns the last work from home request in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work from home request, or <code>null</code> if a matching work from home request could not be found
	 */
	public WorkFromHomeRequest fetchByDateRange_Last(
		Date startDate, Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator);

	/**
	 * Returns the work from home requests before and after the current work from home request in the ordered set where startDate = &#63; and endDate = &#63;.
	 *
	 * @param workFromHomeRequestId the primary key of the current work from home request
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	public WorkFromHomeRequest[] findByDateRange_PrevAndNext(
			long workFromHomeRequestId, Date startDate, Date endDate,
			com.liferay.portal.kernel.util.OrderByComparator
				<WorkFromHomeRequest> orderByComparator)
		throws NoSuchWorkFromHomeRequestException;

	/**
	 * Removes all the work from home requests where startDate = &#63; and endDate = &#63; from the database.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 */
	public void removeByDateRange(Date startDate, Date endDate);

	/**
	 * Returns the number of work from home requests where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the number of matching work from home requests
	 */
	public int countByDateRange(Date startDate, Date endDate);

	/**
	 * Caches the work from home request in the entity cache if it is enabled.
	 *
	 * @param workFromHomeRequest the work from home request
	 */
	public void cacheResult(WorkFromHomeRequest workFromHomeRequest);

	/**
	 * Caches the work from home requests in the entity cache if it is enabled.
	 *
	 * @param workFromHomeRequests the work from home requests
	 */
	public void cacheResult(
		java.util.List<WorkFromHomeRequest> workFromHomeRequests);

	/**
	 * Creates a new work from home request with the primary key. Does not add the work from home request to the database.
	 *
	 * @param workFromHomeRequestId the primary key for the new work from home request
	 * @return the new work from home request
	 */
	public WorkFromHomeRequest create(long workFromHomeRequestId);

	/**
	 * Removes the work from home request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workFromHomeRequestId the primary key of the work from home request
	 * @return the work from home request that was removed
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	public WorkFromHomeRequest remove(long workFromHomeRequestId)
		throws NoSuchWorkFromHomeRequestException;

	public WorkFromHomeRequest updateImpl(
		WorkFromHomeRequest workFromHomeRequest);

	/**
	 * Returns the work from home request with the primary key or throws a <code>NoSuchWorkFromHomeRequestException</code> if it could not be found.
	 *
	 * @param workFromHomeRequestId the primary key of the work from home request
	 * @return the work from home request
	 * @throws NoSuchWorkFromHomeRequestException if a work from home request with the primary key could not be found
	 */
	public WorkFromHomeRequest findByPrimaryKey(long workFromHomeRequestId)
		throws NoSuchWorkFromHomeRequestException;

	/**
	 * Returns the work from home request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workFromHomeRequestId the primary key of the work from home request
	 * @return the work from home request, or <code>null</code> if a work from home request with the primary key could not be found
	 */
	public WorkFromHomeRequest fetchByPrimaryKey(long workFromHomeRequestId);

	/**
	 * Returns all the work from home requests.
	 *
	 * @return the work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findAll();

	/**
	 * Returns a range of all the work from home requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @return the range of work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the work from home requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work from home requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkFromHomeRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from home requests
	 * @param end the upper bound of the range of work from home requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work from home requests
	 */
	public java.util.List<WorkFromHomeRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkFromHomeRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the work from home requests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of work from home requests.
	 *
	 * @return the number of work from home requests
	 */
	public int countAll();

}