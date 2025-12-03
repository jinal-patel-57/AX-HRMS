/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.exception.NoSuchProjectTaskStatusMasterException;
import com.ax.hrms.master.model.ProjectTaskStatusMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the project task status master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectTaskStatusMasterUtil
 * @generated
 */
@ProviderType
public interface ProjectTaskStatusMasterPersistence
	extends BasePersistence<ProjectTaskStatusMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectTaskStatusMasterUtil} to access the project task status master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the project task status master where projectTaskStatusName = &#63; and isApplicableForProject = &#63; and isApplicableForTask = &#63; or throws a <code>NoSuchProjectTaskStatusMasterException</code> if it could not be found.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @param isApplicableForProject the is applicable for project
	 * @param isApplicableForTask the is applicable for task
	 * @return the matching project task status master
	 * @throws NoSuchProjectTaskStatusMasterException if a matching project task status master could not be found
	 */
	public ProjectTaskStatusMaster
			findByStatusNameAndApplicableForProjectAndTask(
				String projectTaskStatusName, boolean isApplicableForProject,
				boolean isApplicableForTask)
		throws NoSuchProjectTaskStatusMasterException;

	/**
	 * Returns the project task status master where projectTaskStatusName = &#63; and isApplicableForProject = &#63; and isApplicableForTask = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @param isApplicableForProject the is applicable for project
	 * @param isApplicableForTask the is applicable for task
	 * @return the matching project task status master, or <code>null</code> if a matching project task status master could not be found
	 */
	public ProjectTaskStatusMaster
		fetchByStatusNameAndApplicableForProjectAndTask(
			String projectTaskStatusName, boolean isApplicableForProject,
			boolean isApplicableForTask);

	/**
	 * Returns the project task status master where projectTaskStatusName = &#63; and isApplicableForProject = &#63; and isApplicableForTask = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @param isApplicableForProject the is applicable for project
	 * @param isApplicableForTask the is applicable for task
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project task status master, or <code>null</code> if a matching project task status master could not be found
	 */
	public ProjectTaskStatusMaster
		fetchByStatusNameAndApplicableForProjectAndTask(
			String projectTaskStatusName, boolean isApplicableForProject,
			boolean isApplicableForTask, boolean useFinderCache);

	/**
	 * Removes the project task status master where projectTaskStatusName = &#63; and isApplicableForProject = &#63; and isApplicableForTask = &#63; from the database.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @param isApplicableForProject the is applicable for project
	 * @param isApplicableForTask the is applicable for task
	 * @return the project task status master that was removed
	 */
	public ProjectTaskStatusMaster
			removeByStatusNameAndApplicableForProjectAndTask(
				String projectTaskStatusName, boolean isApplicableForProject,
				boolean isApplicableForTask)
		throws NoSuchProjectTaskStatusMasterException;

	/**
	 * Returns the number of project task status masters where projectTaskStatusName = &#63; and isApplicableForProject = &#63; and isApplicableForTask = &#63;.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @param isApplicableForProject the is applicable for project
	 * @param isApplicableForTask the is applicable for task
	 * @return the number of matching project task status masters
	 */
	public int countByStatusNameAndApplicableForProjectAndTask(
		String projectTaskStatusName, boolean isApplicableForProject,
		boolean isApplicableForTask);

	/**
	 * Returns the project task status master where projectTaskStatusName = &#63; or throws a <code>NoSuchProjectTaskStatusMasterException</code> if it could not be found.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @return the matching project task status master
	 * @throws NoSuchProjectTaskStatusMasterException if a matching project task status master could not be found
	 */
	public ProjectTaskStatusMaster findByProjectTaskStatusName(
			String projectTaskStatusName)
		throws NoSuchProjectTaskStatusMasterException;

	/**
	 * Returns the project task status master where projectTaskStatusName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @return the matching project task status master, or <code>null</code> if a matching project task status master could not be found
	 */
	public ProjectTaskStatusMaster fetchByProjectTaskStatusName(
		String projectTaskStatusName);

	/**
	 * Returns the project task status master where projectTaskStatusName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project task status master, or <code>null</code> if a matching project task status master could not be found
	 */
	public ProjectTaskStatusMaster fetchByProjectTaskStatusName(
		String projectTaskStatusName, boolean useFinderCache);

	/**
	 * Removes the project task status master where projectTaskStatusName = &#63; from the database.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @return the project task status master that was removed
	 */
	public ProjectTaskStatusMaster removeByProjectTaskStatusName(
			String projectTaskStatusName)
		throws NoSuchProjectTaskStatusMasterException;

	/**
	 * Returns the number of project task status masters where projectTaskStatusName = &#63;.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @return the number of matching project task status masters
	 */
	public int countByProjectTaskStatusName(String projectTaskStatusName);

	/**
	 * Caches the project task status master in the entity cache if it is enabled.
	 *
	 * @param projectTaskStatusMaster the project task status master
	 */
	public void cacheResult(ProjectTaskStatusMaster projectTaskStatusMaster);

	/**
	 * Caches the project task status masters in the entity cache if it is enabled.
	 *
	 * @param projectTaskStatusMasters the project task status masters
	 */
	public void cacheResult(
		java.util.List<ProjectTaskStatusMaster> projectTaskStatusMasters);

	/**
	 * Creates a new project task status master with the primary key. Does not add the project task status master to the database.
	 *
	 * @param projectTaskStatusMasterId the primary key for the new project task status master
	 * @return the new project task status master
	 */
	public ProjectTaskStatusMaster create(long projectTaskStatusMasterId);

	/**
	 * Removes the project task status master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectTaskStatusMasterId the primary key of the project task status master
	 * @return the project task status master that was removed
	 * @throws NoSuchProjectTaskStatusMasterException if a project task status master with the primary key could not be found
	 */
	public ProjectTaskStatusMaster remove(long projectTaskStatusMasterId)
		throws NoSuchProjectTaskStatusMasterException;

	public ProjectTaskStatusMaster updateImpl(
		ProjectTaskStatusMaster projectTaskStatusMaster);

	/**
	 * Returns the project task status master with the primary key or throws a <code>NoSuchProjectTaskStatusMasterException</code> if it could not be found.
	 *
	 * @param projectTaskStatusMasterId the primary key of the project task status master
	 * @return the project task status master
	 * @throws NoSuchProjectTaskStatusMasterException if a project task status master with the primary key could not be found
	 */
	public ProjectTaskStatusMaster findByPrimaryKey(
			long projectTaskStatusMasterId)
		throws NoSuchProjectTaskStatusMasterException;

	/**
	 * Returns the project task status master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectTaskStatusMasterId the primary key of the project task status master
	 * @return the project task status master, or <code>null</code> if a project task status master with the primary key could not be found
	 */
	public ProjectTaskStatusMaster fetchByPrimaryKey(
		long projectTaskStatusMasterId);

	/**
	 * Returns all the project task status masters.
	 *
	 * @return the project task status masters
	 */
	public java.util.List<ProjectTaskStatusMaster> findAll();

	/**
	 * Returns a range of all the project task status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectTaskStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project task status masters
	 * @param end the upper bound of the range of project task status masters (not inclusive)
	 * @return the range of project task status masters
	 */
	public java.util.List<ProjectTaskStatusMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the project task status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectTaskStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project task status masters
	 * @param end the upper bound of the range of project task status masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project task status masters
	 */
	public java.util.List<ProjectTaskStatusMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProjectTaskStatusMaster> orderByComparator);

	/**
	 * Returns an ordered range of all the project task status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectTaskStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project task status masters
	 * @param end the upper bound of the range of project task status masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of project task status masters
	 */
	public java.util.List<ProjectTaskStatusMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ProjectTaskStatusMaster> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the project task status masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of project task status masters.
	 *
	 * @return the number of project task status masters
	 */
	public int countAll();

}