/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.model.BranchMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the branch master service. This utility wraps <code>com.ax.hrms.master.service.persistence.impl.BranchMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BranchMasterPersistence
 * @generated
 */
public class BranchMasterUtil {

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
	public static void clearCache(BranchMaster branchMaster) {
		getPersistence().clearCache(branchMaster);
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
	public static Map<Serializable, BranchMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BranchMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BranchMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BranchMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BranchMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BranchMaster update(BranchMaster branchMaster) {
		return getPersistence().update(branchMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BranchMaster update(
		BranchMaster branchMaster, ServiceContext serviceContext) {

		return getPersistence().update(branchMaster, serviceContext);
	}

	/**
	 * Caches the branch master in the entity cache if it is enabled.
	 *
	 * @param branchMaster the branch master
	 */
	public static void cacheResult(BranchMaster branchMaster) {
		getPersistence().cacheResult(branchMaster);
	}

	/**
	 * Caches the branch masters in the entity cache if it is enabled.
	 *
	 * @param branchMasters the branch masters
	 */
	public static void cacheResult(List<BranchMaster> branchMasters) {
		getPersistence().cacheResult(branchMasters);
	}

	/**
	 * Creates a new branch master with the primary key. Does not add the branch master to the database.
	 *
	 * @param branchMasterId the primary key for the new branch master
	 * @return the new branch master
	 */
	public static BranchMaster create(long branchMasterId) {
		return getPersistence().create(branchMasterId);
	}

	/**
	 * Removes the branch master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param branchMasterId the primary key of the branch master
	 * @return the branch master that was removed
	 * @throws NoSuchBranchMasterException if a branch master with the primary key could not be found
	 */
	public static BranchMaster remove(long branchMasterId)
		throws com.ax.hrms.master.exception.NoSuchBranchMasterException {

		return getPersistence().remove(branchMasterId);
	}

	public static BranchMaster updateImpl(BranchMaster branchMaster) {
		return getPersistence().updateImpl(branchMaster);
	}

	/**
	 * Returns the branch master with the primary key or throws a <code>NoSuchBranchMasterException</code> if it could not be found.
	 *
	 * @param branchMasterId the primary key of the branch master
	 * @return the branch master
	 * @throws NoSuchBranchMasterException if a branch master with the primary key could not be found
	 */
	public static BranchMaster findByPrimaryKey(long branchMasterId)
		throws com.ax.hrms.master.exception.NoSuchBranchMasterException {

		return getPersistence().findByPrimaryKey(branchMasterId);
	}

	/**
	 * Returns the branch master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param branchMasterId the primary key of the branch master
	 * @return the branch master, or <code>null</code> if a branch master with the primary key could not be found
	 */
	public static BranchMaster fetchByPrimaryKey(long branchMasterId) {
		return getPersistence().fetchByPrimaryKey(branchMasterId);
	}

	/**
	 * Returns all the branch masters.
	 *
	 * @return the branch masters
	 */
	public static List<BranchMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the branch masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of branch masters
	 * @param end the upper bound of the range of branch masters (not inclusive)
	 * @return the range of branch masters
	 */
	public static List<BranchMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the branch masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of branch masters
	 * @param end the upper bound of the range of branch masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of branch masters
	 */
	public static List<BranchMaster> findAll(
		int start, int end, OrderByComparator<BranchMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the branch masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of branch masters
	 * @param end the upper bound of the range of branch masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of branch masters
	 */
	public static List<BranchMaster> findAll(
		int start, int end, OrderByComparator<BranchMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the branch masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of branch masters.
	 *
	 * @return the number of branch masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BranchMasterPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(BranchMasterPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile BranchMasterPersistence _persistence;

}