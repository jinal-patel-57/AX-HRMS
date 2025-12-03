/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.model.DepartmentMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the department master service. This utility wraps <code>com.ax.hrms.master.service.persistence.impl.DepartmentMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentMasterPersistence
 * @generated
 */
public class DepartmentMasterUtil {

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
	public static void clearCache(DepartmentMaster departmentMaster) {
		getPersistence().clearCache(departmentMaster);
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
	public static Map<Serializable, DepartmentMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DepartmentMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DepartmentMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DepartmentMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DepartmentMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DepartmentMaster update(DepartmentMaster departmentMaster) {
		return getPersistence().update(departmentMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DepartmentMaster update(
		DepartmentMaster departmentMaster, ServiceContext serviceContext) {

		return getPersistence().update(departmentMaster, serviceContext);
	}

	/**
	 * Returns the department master where departmentName = &#63; or throws a <code>NoSuchDepartmentMasterException</code> if it could not be found.
	 *
	 * @param departmentName the department name
	 * @return the matching department master
	 * @throws NoSuchDepartmentMasterException if a matching department master could not be found
	 */
	public static DepartmentMaster findByDepartmentName(String departmentName)
		throws com.ax.hrms.master.exception.NoSuchDepartmentMasterException {

		return getPersistence().findByDepartmentName(departmentName);
	}

	/**
	 * Returns the department master where departmentName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param departmentName the department name
	 * @return the matching department master, or <code>null</code> if a matching department master could not be found
	 */
	public static DepartmentMaster fetchByDepartmentName(
		String departmentName) {

		return getPersistence().fetchByDepartmentName(departmentName);
	}

	/**
	 * Returns the department master where departmentName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param departmentName the department name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department master, or <code>null</code> if a matching department master could not be found
	 */
	public static DepartmentMaster fetchByDepartmentName(
		String departmentName, boolean useFinderCache) {

		return getPersistence().fetchByDepartmentName(
			departmentName, useFinderCache);
	}

	/**
	 * Removes the department master where departmentName = &#63; from the database.
	 *
	 * @param departmentName the department name
	 * @return the department master that was removed
	 */
	public static DepartmentMaster removeByDepartmentName(String departmentName)
		throws com.ax.hrms.master.exception.NoSuchDepartmentMasterException {

		return getPersistence().removeByDepartmentName(departmentName);
	}

	/**
	 * Returns the number of department masters where departmentName = &#63;.
	 *
	 * @param departmentName the department name
	 * @return the number of matching department masters
	 */
	public static int countByDepartmentName(String departmentName) {
		return getPersistence().countByDepartmentName(departmentName);
	}

	/**
	 * Returns the department master where departmentMasterId = &#63; or throws a <code>NoSuchDepartmentMasterException</code> if it could not be found.
	 *
	 * @param departmentMasterId the department master ID
	 * @return the matching department master
	 * @throws NoSuchDepartmentMasterException if a matching department master could not be found
	 */
	public static DepartmentMaster findByDepartmentNameById(
			long departmentMasterId)
		throws com.ax.hrms.master.exception.NoSuchDepartmentMasterException {

		return getPersistence().findByDepartmentNameById(departmentMasterId);
	}

	/**
	 * Returns the department master where departmentMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param departmentMasterId the department master ID
	 * @return the matching department master, or <code>null</code> if a matching department master could not be found
	 */
	public static DepartmentMaster fetchByDepartmentNameById(
		long departmentMasterId) {

		return getPersistence().fetchByDepartmentNameById(departmentMasterId);
	}

	/**
	 * Returns the department master where departmentMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param departmentMasterId the department master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department master, or <code>null</code> if a matching department master could not be found
	 */
	public static DepartmentMaster fetchByDepartmentNameById(
		long departmentMasterId, boolean useFinderCache) {

		return getPersistence().fetchByDepartmentNameById(
			departmentMasterId, useFinderCache);
	}

	/**
	 * Removes the department master where departmentMasterId = &#63; from the database.
	 *
	 * @param departmentMasterId the department master ID
	 * @return the department master that was removed
	 */
	public static DepartmentMaster removeByDepartmentNameById(
			long departmentMasterId)
		throws com.ax.hrms.master.exception.NoSuchDepartmentMasterException {

		return getPersistence().removeByDepartmentNameById(departmentMasterId);
	}

	/**
	 * Returns the number of department masters where departmentMasterId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @return the number of matching department masters
	 */
	public static int countByDepartmentNameById(long departmentMasterId) {
		return getPersistence().countByDepartmentNameById(departmentMasterId);
	}

	/**
	 * Caches the department master in the entity cache if it is enabled.
	 *
	 * @param departmentMaster the department master
	 */
	public static void cacheResult(DepartmentMaster departmentMaster) {
		getPersistence().cacheResult(departmentMaster);
	}

	/**
	 * Caches the department masters in the entity cache if it is enabled.
	 *
	 * @param departmentMasters the department masters
	 */
	public static void cacheResult(List<DepartmentMaster> departmentMasters) {
		getPersistence().cacheResult(departmentMasters);
	}

	/**
	 * Creates a new department master with the primary key. Does not add the department master to the database.
	 *
	 * @param departmentMasterId the primary key for the new department master
	 * @return the new department master
	 */
	public static DepartmentMaster create(long departmentMasterId) {
		return getPersistence().create(departmentMasterId);
	}

	/**
	 * Removes the department master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param departmentMasterId the primary key of the department master
	 * @return the department master that was removed
	 * @throws NoSuchDepartmentMasterException if a department master with the primary key could not be found
	 */
	public static DepartmentMaster remove(long departmentMasterId)
		throws com.ax.hrms.master.exception.NoSuchDepartmentMasterException {

		return getPersistence().remove(departmentMasterId);
	}

	public static DepartmentMaster updateImpl(
		DepartmentMaster departmentMaster) {

		return getPersistence().updateImpl(departmentMaster);
	}

	/**
	 * Returns the department master with the primary key or throws a <code>NoSuchDepartmentMasterException</code> if it could not be found.
	 *
	 * @param departmentMasterId the primary key of the department master
	 * @return the department master
	 * @throws NoSuchDepartmentMasterException if a department master with the primary key could not be found
	 */
	public static DepartmentMaster findByPrimaryKey(long departmentMasterId)
		throws com.ax.hrms.master.exception.NoSuchDepartmentMasterException {

		return getPersistence().findByPrimaryKey(departmentMasterId);
	}

	/**
	 * Returns the department master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param departmentMasterId the primary key of the department master
	 * @return the department master, or <code>null</code> if a department master with the primary key could not be found
	 */
	public static DepartmentMaster fetchByPrimaryKey(long departmentMasterId) {
		return getPersistence().fetchByPrimaryKey(departmentMasterId);
	}

	/**
	 * Returns all the department masters.
	 *
	 * @return the department masters
	 */
	public static List<DepartmentMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the department masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department masters
	 * @param end the upper bound of the range of department masters (not inclusive)
	 * @return the range of department masters
	 */
	public static List<DepartmentMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the department masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department masters
	 * @param end the upper bound of the range of department masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of department masters
	 */
	public static List<DepartmentMaster> findAll(
		int start, int end,
		OrderByComparator<DepartmentMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the department masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department masters
	 * @param end the upper bound of the range of department masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of department masters
	 */
	public static List<DepartmentMaster> findAll(
		int start, int end,
		OrderByComparator<DepartmentMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the department masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of department masters.
	 *
	 * @return the number of department masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DepartmentMasterPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(DepartmentMasterPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile DepartmentMasterPersistence _persistence;

}