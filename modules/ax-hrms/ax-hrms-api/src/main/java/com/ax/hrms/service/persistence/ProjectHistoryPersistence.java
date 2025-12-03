/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchProjectHistoryException;
import com.ax.hrms.model.ProjectHistory;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the project history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectHistoryUtil
 * @generated
 */
@ProviderType
public interface ProjectHistoryPersistence
	extends BasePersistence<ProjectHistory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectHistoryUtil} to access the project history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the project histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project histories
	 */
	public java.util.List<ProjectHistory> findByUuid(String uuid);

	/**
	 * Returns a range of all the project histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @return the range of matching project histories
	 */
	public java.util.List<ProjectHistory> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the project histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project histories
	 */
	public java.util.List<ProjectHistory> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project histories
	 */
	public java.util.List<ProjectHistory> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project history
	 * @throws NoSuchProjectHistoryException if a matching project history could not be found
	 */
	public ProjectHistory findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
				orderByComparator)
		throws NoSuchProjectHistoryException;

	/**
	 * Returns the first project history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project history, or <code>null</code> if a matching project history could not be found
	 */
	public ProjectHistory fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
			orderByComparator);

	/**
	 * Returns the last project history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project history
	 * @throws NoSuchProjectHistoryException if a matching project history could not be found
	 */
	public ProjectHistory findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
				orderByComparator)
		throws NoSuchProjectHistoryException;

	/**
	 * Returns the last project history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project history, or <code>null</code> if a matching project history could not be found
	 */
	public ProjectHistory fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
			orderByComparator);

	/**
	 * Returns the project histories before and after the current project history in the ordered set where uuid = &#63;.
	 *
	 * @param projectHistoryId the primary key of the current project history
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project history
	 * @throws NoSuchProjectHistoryException if a project history with the primary key could not be found
	 */
	public ProjectHistory[] findByUuid_PrevAndNext(
			long projectHistoryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
				orderByComparator)
		throws NoSuchProjectHistoryException;

	/**
	 * Removes all the project histories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of project histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project histories
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the project history where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProjectHistoryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project history
	 * @throws NoSuchProjectHistoryException if a matching project history could not be found
	 */
	public ProjectHistory findByUUID_G(String uuid, long groupId)
		throws NoSuchProjectHistoryException;

	/**
	 * Returns the project history where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project history, or <code>null</code> if a matching project history could not be found
	 */
	public ProjectHistory fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the project history where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project history, or <code>null</code> if a matching project history could not be found
	 */
	public ProjectHistory fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the project history where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the project history that was removed
	 */
	public ProjectHistory removeByUUID_G(String uuid, long groupId)
		throws NoSuchProjectHistoryException;

	/**
	 * Returns the number of project histories where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching project histories
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the project histories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching project histories
	 */
	public java.util.List<ProjectHistory> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the project histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @return the range of matching project histories
	 */
	public java.util.List<ProjectHistory> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the project histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project histories
	 */
	public java.util.List<ProjectHistory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project histories
	 */
	public java.util.List<ProjectHistory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project history
	 * @throws NoSuchProjectHistoryException if a matching project history could not be found
	 */
	public ProjectHistory findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
				orderByComparator)
		throws NoSuchProjectHistoryException;

	/**
	 * Returns the first project history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project history, or <code>null</code> if a matching project history could not be found
	 */
	public ProjectHistory fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
			orderByComparator);

	/**
	 * Returns the last project history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project history
	 * @throws NoSuchProjectHistoryException if a matching project history could not be found
	 */
	public ProjectHistory findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
				orderByComparator)
		throws NoSuchProjectHistoryException;

	/**
	 * Returns the last project history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project history, or <code>null</code> if a matching project history could not be found
	 */
	public ProjectHistory fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
			orderByComparator);

	/**
	 * Returns the project histories before and after the current project history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param projectHistoryId the primary key of the current project history
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project history
	 * @throws NoSuchProjectHistoryException if a project history with the primary key could not be found
	 */
	public ProjectHistory[] findByUuid_C_PrevAndNext(
			long projectHistoryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
				orderByComparator)
		throws NoSuchProjectHistoryException;

	/**
	 * Removes all the project histories where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of project histories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching project histories
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the project histories where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @return the matching project histories
	 */
	public java.util.List<ProjectHistory> findByManagerId(long managerId);

	/**
	 * Returns a range of all the project histories where managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @return the range of matching project histories
	 */
	public java.util.List<ProjectHistory> findByManagerId(
		long managerId, int start, int end);

	/**
	 * Returns an ordered range of all the project histories where managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project histories
	 */
	public java.util.List<ProjectHistory> findByManagerId(
		long managerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project histories where managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project histories
	 */
	public java.util.List<ProjectHistory> findByManagerId(
		long managerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project history in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project history
	 * @throws NoSuchProjectHistoryException if a matching project history could not be found
	 */
	public ProjectHistory findByManagerId_First(
			long managerId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
				orderByComparator)
		throws NoSuchProjectHistoryException;

	/**
	 * Returns the first project history in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project history, or <code>null</code> if a matching project history could not be found
	 */
	public ProjectHistory fetchByManagerId_First(
		long managerId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
			orderByComparator);

	/**
	 * Returns the last project history in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project history
	 * @throws NoSuchProjectHistoryException if a matching project history could not be found
	 */
	public ProjectHistory findByManagerId_Last(
			long managerId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
				orderByComparator)
		throws NoSuchProjectHistoryException;

	/**
	 * Returns the last project history in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project history, or <code>null</code> if a matching project history could not be found
	 */
	public ProjectHistory fetchByManagerId_Last(
		long managerId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
			orderByComparator);

	/**
	 * Returns the project histories before and after the current project history in the ordered set where managerId = &#63;.
	 *
	 * @param projectHistoryId the primary key of the current project history
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project history
	 * @throws NoSuchProjectHistoryException if a project history with the primary key could not be found
	 */
	public ProjectHistory[] findByManagerId_PrevAndNext(
			long projectHistoryId, long managerId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
				orderByComparator)
		throws NoSuchProjectHistoryException;

	/**
	 * Removes all the project histories where managerId = &#63; from the database.
	 *
	 * @param managerId the manager ID
	 */
	public void removeByManagerId(long managerId);

	/**
	 * Returns the number of project histories where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @return the number of matching project histories
	 */
	public int countByManagerId(long managerId);

	/**
	 * Returns the project history where projectId = &#63; or throws a <code>NoSuchProjectHistoryException</code> if it could not be found.
	 *
	 * @param projectId the project ID
	 * @return the matching project history
	 * @throws NoSuchProjectHistoryException if a matching project history could not be found
	 */
	public ProjectHistory findByProjectId(long projectId)
		throws NoSuchProjectHistoryException;

	/**
	 * Returns the project history where projectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param projectId the project ID
	 * @return the matching project history, or <code>null</code> if a matching project history could not be found
	 */
	public ProjectHistory fetchByProjectId(long projectId);

	/**
	 * Returns the project history where projectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param projectId the project ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project history, or <code>null</code> if a matching project history could not be found
	 */
	public ProjectHistory fetchByProjectId(
		long projectId, boolean useFinderCache);

	/**
	 * Removes the project history where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @return the project history that was removed
	 */
	public ProjectHistory removeByProjectId(long projectId)
		throws NoSuchProjectHistoryException;

	/**
	 * Returns the number of project histories where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching project histories
	 */
	public int countByProjectId(long projectId);

	/**
	 * Caches the project history in the entity cache if it is enabled.
	 *
	 * @param projectHistory the project history
	 */
	public void cacheResult(ProjectHistory projectHistory);

	/**
	 * Caches the project histories in the entity cache if it is enabled.
	 *
	 * @param projectHistories the project histories
	 */
	public void cacheResult(java.util.List<ProjectHistory> projectHistories);

	/**
	 * Creates a new project history with the primary key. Does not add the project history to the database.
	 *
	 * @param projectHistoryId the primary key for the new project history
	 * @return the new project history
	 */
	public ProjectHistory create(long projectHistoryId);

	/**
	 * Removes the project history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectHistoryId the primary key of the project history
	 * @return the project history that was removed
	 * @throws NoSuchProjectHistoryException if a project history with the primary key could not be found
	 */
	public ProjectHistory remove(long projectHistoryId)
		throws NoSuchProjectHistoryException;

	public ProjectHistory updateImpl(ProjectHistory projectHistory);

	/**
	 * Returns the project history with the primary key or throws a <code>NoSuchProjectHistoryException</code> if it could not be found.
	 *
	 * @param projectHistoryId the primary key of the project history
	 * @return the project history
	 * @throws NoSuchProjectHistoryException if a project history with the primary key could not be found
	 */
	public ProjectHistory findByPrimaryKey(long projectHistoryId)
		throws NoSuchProjectHistoryException;

	/**
	 * Returns the project history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectHistoryId the primary key of the project history
	 * @return the project history, or <code>null</code> if a project history with the primary key could not be found
	 */
	public ProjectHistory fetchByPrimaryKey(long projectHistoryId);

	/**
	 * Returns all the project histories.
	 *
	 * @return the project histories
	 */
	public java.util.List<ProjectHistory> findAll();

	/**
	 * Returns a range of all the project histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @return the range of project histories
	 */
	public java.util.List<ProjectHistory> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the project histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project histories
	 */
	public java.util.List<ProjectHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project histories
	 * @param end the upper bound of the range of project histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of project histories
	 */
	public java.util.List<ProjectHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the project histories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of project histories.
	 *
	 * @return the number of project histories
	 */
	public int countAll();

}