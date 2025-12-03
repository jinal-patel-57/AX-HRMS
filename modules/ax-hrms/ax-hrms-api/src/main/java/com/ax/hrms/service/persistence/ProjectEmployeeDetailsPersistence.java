/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchProjectEmployeeDetailsException;
import com.ax.hrms.model.ProjectEmployeeDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the project employee details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectEmployeeDetailsUtil
 * @generated
 */
@ProviderType
public interface ProjectEmployeeDetailsPersistence
	extends BasePersistence<ProjectEmployeeDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectEmployeeDetailsUtil} to access the project employee details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the project employee detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project employee detailses
	 */
	public java.util.List<ProjectEmployeeDetails> findByUuid(String uuid);

	/**
	 * Returns a range of all the project employee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @return the range of matching project employee detailses
	 */
	public java.util.List<ProjectEmployeeDetails> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the project employee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project employee detailses
	 */
	public java.util.List<ProjectEmployeeDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEmployeeDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project employee detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project employee detailses
	 */
	public java.util.List<ProjectEmployeeDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEmployeeDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	public ProjectEmployeeDetails findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException;

	/**
	 * Returns the first project employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public ProjectEmployeeDetails fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEmployeeDetails>
			orderByComparator);

	/**
	 * Returns the last project employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	public ProjectEmployeeDetails findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException;

	/**
	 * Returns the last project employee details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public ProjectEmployeeDetails fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEmployeeDetails>
			orderByComparator);

	/**
	 * Returns the project employee detailses before and after the current project employee details in the ordered set where uuid = &#63;.
	 *
	 * @param projectEmployeeDetailsId the primary key of the current project employee details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a project employee details with the primary key could not be found
	 */
	public ProjectEmployeeDetails[] findByUuid_PrevAndNext(
			long projectEmployeeDetailsId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException;

	/**
	 * Removes all the project employee detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of project employee detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project employee detailses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the project employee details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProjectEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	public ProjectEmployeeDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchProjectEmployeeDetailsException;

	/**
	 * Returns the project employee details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public ProjectEmployeeDetails fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the project employee details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public ProjectEmployeeDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the project employee details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the project employee details that was removed
	 */
	public ProjectEmployeeDetails removeByUUID_G(String uuid, long groupId)
		throws NoSuchProjectEmployeeDetailsException;

	/**
	 * Returns the number of project employee detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching project employee detailses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the project employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching project employee detailses
	 */
	public java.util.List<ProjectEmployeeDetails> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the project employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @return the range of matching project employee detailses
	 */
	public java.util.List<ProjectEmployeeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the project employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project employee detailses
	 */
	public java.util.List<ProjectEmployeeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEmployeeDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project employee detailses
	 */
	public java.util.List<ProjectEmployeeDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEmployeeDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	public ProjectEmployeeDetails findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException;

	/**
	 * Returns the first project employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public ProjectEmployeeDetails fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEmployeeDetails>
			orderByComparator);

	/**
	 * Returns the last project employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	public ProjectEmployeeDetails findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException;

	/**
	 * Returns the last project employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public ProjectEmployeeDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEmployeeDetails>
			orderByComparator);

	/**
	 * Returns the project employee detailses before and after the current project employee details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param projectEmployeeDetailsId the primary key of the current project employee details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a project employee details with the primary key could not be found
	 */
	public ProjectEmployeeDetails[] findByUuid_C_PrevAndNext(
			long projectEmployeeDetailsId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException;

	/**
	 * Removes all the project employee detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of project employee detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching project employee detailses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the project employee detailses where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching project employee detailses
	 */
	public java.util.List<ProjectEmployeeDetails> findByProjectId(
		long projectId);

	/**
	 * Returns a range of all the project employee detailses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @return the range of matching project employee detailses
	 */
	public java.util.List<ProjectEmployeeDetails> findByProjectId(
		long projectId, int start, int end);

	/**
	 * Returns an ordered range of all the project employee detailses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project employee detailses
	 */
	public java.util.List<ProjectEmployeeDetails> findByProjectId(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEmployeeDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project employee detailses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project employee detailses
	 */
	public java.util.List<ProjectEmployeeDetails> findByProjectId(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEmployeeDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project employee details in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	public ProjectEmployeeDetails findByProjectId_First(
			long projectId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException;

	/**
	 * Returns the first project employee details in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public ProjectEmployeeDetails fetchByProjectId_First(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEmployeeDetails>
			orderByComparator);

	/**
	 * Returns the last project employee details in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	public ProjectEmployeeDetails findByProjectId_Last(
			long projectId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException;

	/**
	 * Returns the last project employee details in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public ProjectEmployeeDetails fetchByProjectId_Last(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEmployeeDetails>
			orderByComparator);

	/**
	 * Returns the project employee detailses before and after the current project employee details in the ordered set where projectId = &#63;.
	 *
	 * @param projectEmployeeDetailsId the primary key of the current project employee details
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a project employee details with the primary key could not be found
	 */
	public ProjectEmployeeDetails[] findByProjectId_PrevAndNext(
			long projectEmployeeDetailsId, long projectId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException;

	/**
	 * Removes all the project employee detailses where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	public void removeByProjectId(long projectId);

	/**
	 * Returns the number of project employee detailses where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching project employee detailses
	 */
	public int countByProjectId(long projectId);

	/**
	 * Returns all the project employee detailses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching project employee detailses
	 */
	public java.util.List<ProjectEmployeeDetails> findByEmployeeId(
		long employeeId);

	/**
	 * Returns a range of all the project employee detailses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @return the range of matching project employee detailses
	 */
	public java.util.List<ProjectEmployeeDetails> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the project employee detailses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project employee detailses
	 */
	public java.util.List<ProjectEmployeeDetails> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEmployeeDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project employee detailses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project employee detailses
	 */
	public java.util.List<ProjectEmployeeDetails> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEmployeeDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project employee details in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	public ProjectEmployeeDetails findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException;

	/**
	 * Returns the first project employee details in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public ProjectEmployeeDetails fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEmployeeDetails>
			orderByComparator);

	/**
	 * Returns the last project employee details in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	public ProjectEmployeeDetails findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException;

	/**
	 * Returns the last project employee details in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public ProjectEmployeeDetails fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEmployeeDetails>
			orderByComparator);

	/**
	 * Returns the project employee detailses before and after the current project employee details in the ordered set where employeeId = &#63;.
	 *
	 * @param projectEmployeeDetailsId the primary key of the current project employee details
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a project employee details with the primary key could not be found
	 */
	public ProjectEmployeeDetails[] findByEmployeeId_PrevAndNext(
			long projectEmployeeDetailsId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProjectEmployeeDetails> orderByComparator)
		throws NoSuchProjectEmployeeDetailsException;

	/**
	 * Removes all the project employee detailses where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of project employee detailses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching project employee detailses
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns the project employee details where projectId = &#63; and employeeId = &#63; or throws a <code>NoSuchProjectEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @return the matching project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a matching project employee details could not be found
	 */
	public ProjectEmployeeDetails findByProjectIdAndEmployeeId(
			long projectId, long employeeId)
		throws NoSuchProjectEmployeeDetailsException;

	/**
	 * Returns the project employee details where projectId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @return the matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public ProjectEmployeeDetails fetchByProjectIdAndEmployeeId(
		long projectId, long employeeId);

	/**
	 * Returns the project employee details where projectId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	public ProjectEmployeeDetails fetchByProjectIdAndEmployeeId(
		long projectId, long employeeId, boolean useFinderCache);

	/**
	 * Removes the project employee details where projectId = &#63; and employeeId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @return the project employee details that was removed
	 */
	public ProjectEmployeeDetails removeByProjectIdAndEmployeeId(
			long projectId, long employeeId)
		throws NoSuchProjectEmployeeDetailsException;

	/**
	 * Returns the number of project employee detailses where projectId = &#63; and employeeId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @return the number of matching project employee detailses
	 */
	public int countByProjectIdAndEmployeeId(long projectId, long employeeId);

	/**
	 * Caches the project employee details in the entity cache if it is enabled.
	 *
	 * @param projectEmployeeDetails the project employee details
	 */
	public void cacheResult(ProjectEmployeeDetails projectEmployeeDetails);

	/**
	 * Caches the project employee detailses in the entity cache if it is enabled.
	 *
	 * @param projectEmployeeDetailses the project employee detailses
	 */
	public void cacheResult(
		java.util.List<ProjectEmployeeDetails> projectEmployeeDetailses);

	/**
	 * Creates a new project employee details with the primary key. Does not add the project employee details to the database.
	 *
	 * @param projectEmployeeDetailsId the primary key for the new project employee details
	 * @return the new project employee details
	 */
	public ProjectEmployeeDetails create(long projectEmployeeDetailsId);

	/**
	 * Removes the project employee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectEmployeeDetailsId the primary key of the project employee details
	 * @return the project employee details that was removed
	 * @throws NoSuchProjectEmployeeDetailsException if a project employee details with the primary key could not be found
	 */
	public ProjectEmployeeDetails remove(long projectEmployeeDetailsId)
		throws NoSuchProjectEmployeeDetailsException;

	public ProjectEmployeeDetails updateImpl(
		ProjectEmployeeDetails projectEmployeeDetails);

	/**
	 * Returns the project employee details with the primary key or throws a <code>NoSuchProjectEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param projectEmployeeDetailsId the primary key of the project employee details
	 * @return the project employee details
	 * @throws NoSuchProjectEmployeeDetailsException if a project employee details with the primary key could not be found
	 */
	public ProjectEmployeeDetails findByPrimaryKey(
			long projectEmployeeDetailsId)
		throws NoSuchProjectEmployeeDetailsException;

	/**
	 * Returns the project employee details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectEmployeeDetailsId the primary key of the project employee details
	 * @return the project employee details, or <code>null</code> if a project employee details with the primary key could not be found
	 */
	public ProjectEmployeeDetails fetchByPrimaryKey(
		long projectEmployeeDetailsId);

	/**
	 * Returns all the project employee detailses.
	 *
	 * @return the project employee detailses
	 */
	public java.util.List<ProjectEmployeeDetails> findAll();

	/**
	 * Returns a range of all the project employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @return the range of project employee detailses
	 */
	public java.util.List<ProjectEmployeeDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the project employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project employee detailses
	 */
	public java.util.List<ProjectEmployeeDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEmployeeDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of project employee detailses
	 */
	public java.util.List<ProjectEmployeeDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectEmployeeDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the project employee detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of project employee detailses.
	 *
	 * @return the number of project employee detailses
	 */
	public int countAll();

}