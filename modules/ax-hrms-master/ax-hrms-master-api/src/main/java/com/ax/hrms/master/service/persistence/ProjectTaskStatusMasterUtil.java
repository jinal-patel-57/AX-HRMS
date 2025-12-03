/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.model.ProjectTaskStatusMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the project task status master service. This utility wraps <code>com.ax.hrms.master.service.persistence.impl.ProjectTaskStatusMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectTaskStatusMasterPersistence
 * @generated
 */
public class ProjectTaskStatusMasterUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		ProjectTaskStatusMaster projectTaskStatusMaster) {

		getPersistence().clearCache(projectTaskStatusMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ProjectTaskStatusMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProjectTaskStatusMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectTaskStatusMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectTaskStatusMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjectTaskStatusMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjectTaskStatusMaster update(
		ProjectTaskStatusMaster projectTaskStatusMaster) {

		return getPersistence().update(projectTaskStatusMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjectTaskStatusMaster update(
		ProjectTaskStatusMaster projectTaskStatusMaster,
		ServiceContext serviceContext) {

		return getPersistence().update(projectTaskStatusMaster, serviceContext);
	}

	/**
	 * Returns the project task status master where projectTaskStatusName = &#63; and isApplicableForProject = &#63; and isApplicableForTask = &#63; or throws a <code>NoSuchProjectTaskStatusMasterException</code> if it could not be found.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @param isApplicableForProject the is applicable for project
	 * @param isApplicableForTask the is applicable for task
	 * @return the matching project task status master
	 * @throws NoSuchProjectTaskStatusMasterException if a matching project task status master could not be found
	 */
	public static ProjectTaskStatusMaster
			findByStatusNameAndApplicableForProjectAndTask(
				String projectTaskStatusName, boolean isApplicableForProject,
				boolean isApplicableForTask)
		throws com.ax.hrms.master.exception.
			NoSuchProjectTaskStatusMasterException {

		return getPersistence().findByStatusNameAndApplicableForProjectAndTask(
			projectTaskStatusName, isApplicableForProject, isApplicableForTask);
	}

	/**
	 * Returns the project task status master where projectTaskStatusName = &#63; and isApplicableForProject = &#63; and isApplicableForTask = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @param isApplicableForProject the is applicable for project
	 * @param isApplicableForTask the is applicable for task
	 * @return the matching project task status master, or <code>null</code> if a matching project task status master could not be found
	 */
	public static ProjectTaskStatusMaster
		fetchByStatusNameAndApplicableForProjectAndTask(
			String projectTaskStatusName, boolean isApplicableForProject,
			boolean isApplicableForTask) {

		return getPersistence().fetchByStatusNameAndApplicableForProjectAndTask(
			projectTaskStatusName, isApplicableForProject, isApplicableForTask);
	}

	/**
	 * Returns the project task status master where projectTaskStatusName = &#63; and isApplicableForProject = &#63; and isApplicableForTask = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @param isApplicableForProject the is applicable for project
	 * @param isApplicableForTask the is applicable for task
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project task status master, or <code>null</code> if a matching project task status master could not be found
	 */
	public static ProjectTaskStatusMaster
		fetchByStatusNameAndApplicableForProjectAndTask(
			String projectTaskStatusName, boolean isApplicableForProject,
			boolean isApplicableForTask, boolean useFinderCache) {

		return getPersistence().fetchByStatusNameAndApplicableForProjectAndTask(
			projectTaskStatusName, isApplicableForProject, isApplicableForTask,
			useFinderCache);
	}

	/**
	 * Removes the project task status master where projectTaskStatusName = &#63; and isApplicableForProject = &#63; and isApplicableForTask = &#63; from the database.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @param isApplicableForProject the is applicable for project
	 * @param isApplicableForTask the is applicable for task
	 * @return the project task status master that was removed
	 */
	public static ProjectTaskStatusMaster
			removeByStatusNameAndApplicableForProjectAndTask(
				String projectTaskStatusName, boolean isApplicableForProject,
				boolean isApplicableForTask)
		throws com.ax.hrms.master.exception.
			NoSuchProjectTaskStatusMasterException {

		return getPersistence().
			removeByStatusNameAndApplicableForProjectAndTask(
				projectTaskStatusName, isApplicableForProject,
				isApplicableForTask);
	}

	/**
	 * Returns the number of project task status masters where projectTaskStatusName = &#63; and isApplicableForProject = &#63; and isApplicableForTask = &#63;.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @param isApplicableForProject the is applicable for project
	 * @param isApplicableForTask the is applicable for task
	 * @return the number of matching project task status masters
	 */
	public static int countByStatusNameAndApplicableForProjectAndTask(
		String projectTaskStatusName, boolean isApplicableForProject,
		boolean isApplicableForTask) {

		return getPersistence().countByStatusNameAndApplicableForProjectAndTask(
			projectTaskStatusName, isApplicableForProject, isApplicableForTask);
	}

	/**
	 * Returns the project task status master where projectTaskStatusName = &#63; or throws a <code>NoSuchProjectTaskStatusMasterException</code> if it could not be found.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @return the matching project task status master
	 * @throws NoSuchProjectTaskStatusMasterException if a matching project task status master could not be found
	 */
	public static ProjectTaskStatusMaster findByProjectTaskStatusName(
			String projectTaskStatusName)
		throws com.ax.hrms.master.exception.
			NoSuchProjectTaskStatusMasterException {

		return getPersistence().findByProjectTaskStatusName(
			projectTaskStatusName);
	}

	/**
	 * Returns the project task status master where projectTaskStatusName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @return the matching project task status master, or <code>null</code> if a matching project task status master could not be found
	 */
	public static ProjectTaskStatusMaster fetchByProjectTaskStatusName(
		String projectTaskStatusName) {

		return getPersistence().fetchByProjectTaskStatusName(
			projectTaskStatusName);
	}

	/**
	 * Returns the project task status master where projectTaskStatusName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project task status master, or <code>null</code> if a matching project task status master could not be found
	 */
	public static ProjectTaskStatusMaster fetchByProjectTaskStatusName(
		String projectTaskStatusName, boolean useFinderCache) {

		return getPersistence().fetchByProjectTaskStatusName(
			projectTaskStatusName, useFinderCache);
	}

	/**
	 * Removes the project task status master where projectTaskStatusName = &#63; from the database.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @return the project task status master that was removed
	 */
	public static ProjectTaskStatusMaster removeByProjectTaskStatusName(
			String projectTaskStatusName)
		throws com.ax.hrms.master.exception.
			NoSuchProjectTaskStatusMasterException {

		return getPersistence().removeByProjectTaskStatusName(
			projectTaskStatusName);
	}

	/**
	 * Returns the number of project task status masters where projectTaskStatusName = &#63;.
	 *
	 * @param projectTaskStatusName the project task status name
	 * @return the number of matching project task status masters
	 */
	public static int countByProjectTaskStatusName(
		String projectTaskStatusName) {

		return getPersistence().countByProjectTaskStatusName(
			projectTaskStatusName);
	}

	/**
	 * Caches the project task status master in the entity cache if it is enabled.
	 *
	 * @param projectTaskStatusMaster the project task status master
	 */
	public static void cacheResult(
		ProjectTaskStatusMaster projectTaskStatusMaster) {

		getPersistence().cacheResult(projectTaskStatusMaster);
	}

	/**
	 * Caches the project task status masters in the entity cache if it is enabled.
	 *
	 * @param projectTaskStatusMasters the project task status masters
	 */
	public static void cacheResult(
		List<ProjectTaskStatusMaster> projectTaskStatusMasters) {

		getPersistence().cacheResult(projectTaskStatusMasters);
	}

	/**
	 * Creates a new project task status master with the primary key. Does not add the project task status master to the database.
	 *
	 * @param projectTaskStatusMasterId the primary key for the new project task status master
	 * @return the new project task status master
	 */
	public static ProjectTaskStatusMaster create(
		long projectTaskStatusMasterId) {

		return getPersistence().create(projectTaskStatusMasterId);
	}

	/**
	 * Removes the project task status master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectTaskStatusMasterId the primary key of the project task status master
	 * @return the project task status master that was removed
	 * @throws NoSuchProjectTaskStatusMasterException if a project task status master with the primary key could not be found
	 */
	public static ProjectTaskStatusMaster remove(long projectTaskStatusMasterId)
		throws com.ax.hrms.master.exception.
			NoSuchProjectTaskStatusMasterException {

		return getPersistence().remove(projectTaskStatusMasterId);
	}

	public static ProjectTaskStatusMaster updateImpl(
		ProjectTaskStatusMaster projectTaskStatusMaster) {

		return getPersistence().updateImpl(projectTaskStatusMaster);
	}

	/**
	 * Returns the project task status master with the primary key or throws a <code>NoSuchProjectTaskStatusMasterException</code> if it could not be found.
	 *
	 * @param projectTaskStatusMasterId the primary key of the project task status master
	 * @return the project task status master
	 * @throws NoSuchProjectTaskStatusMasterException if a project task status master with the primary key could not be found
	 */
	public static ProjectTaskStatusMaster findByPrimaryKey(
			long projectTaskStatusMasterId)
		throws com.ax.hrms.master.exception.
			NoSuchProjectTaskStatusMasterException {

		return getPersistence().findByPrimaryKey(projectTaskStatusMasterId);
	}

	/**
	 * Returns the project task status master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectTaskStatusMasterId the primary key of the project task status master
	 * @return the project task status master, or <code>null</code> if a project task status master with the primary key could not be found
	 */
	public static ProjectTaskStatusMaster fetchByPrimaryKey(
		long projectTaskStatusMasterId) {

		return getPersistence().fetchByPrimaryKey(projectTaskStatusMasterId);
	}

	/**
	 * Returns all the project task status masters.
	 *
	 * @return the project task status masters
	 */
	public static List<ProjectTaskStatusMaster> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ProjectTaskStatusMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ProjectTaskStatusMaster> findAll(
		int start, int end,
		OrderByComparator<ProjectTaskStatusMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ProjectTaskStatusMaster> findAll(
		int start, int end,
		OrderByComparator<ProjectTaskStatusMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the project task status masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of project task status masters.
	 *
	 * @return the number of project task status masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProjectTaskStatusMasterPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		ProjectTaskStatusMasterPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile ProjectTaskStatusMasterPersistence _persistence;

}