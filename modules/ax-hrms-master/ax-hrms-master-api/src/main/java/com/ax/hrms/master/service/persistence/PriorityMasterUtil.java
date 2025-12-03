/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.model.PriorityMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the priority master service. This utility wraps <code>com.ax.hrms.master.service.persistence.impl.PriorityMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PriorityMasterPersistence
 * @generated
 */
public class PriorityMasterUtil {

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
	public static void clearCache(PriorityMaster priorityMaster) {
		getPersistence().clearCache(priorityMaster);
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
	public static Map<Serializable, PriorityMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PriorityMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PriorityMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PriorityMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PriorityMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PriorityMaster update(PriorityMaster priorityMaster) {
		return getPersistence().update(priorityMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PriorityMaster update(
		PriorityMaster priorityMaster, ServiceContext serviceContext) {

		return getPersistence().update(priorityMaster, serviceContext);
	}

	/**
	 * Returns the priority master where priorityName = &#63; or throws a <code>NoSuchPriorityMasterException</code> if it could not be found.
	 *
	 * @param priorityName the priority name
	 * @return the matching priority master
	 * @throws NoSuchPriorityMasterException if a matching priority master could not be found
	 */
	public static PriorityMaster findByPriorityName(String priorityName)
		throws com.ax.hrms.master.exception.NoSuchPriorityMasterException {

		return getPersistence().findByPriorityName(priorityName);
	}

	/**
	 * Returns the priority master where priorityName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param priorityName the priority name
	 * @return the matching priority master, or <code>null</code> if a matching priority master could not be found
	 */
	public static PriorityMaster fetchByPriorityName(String priorityName) {
		return getPersistence().fetchByPriorityName(priorityName);
	}

	/**
	 * Returns the priority master where priorityName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param priorityName the priority name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching priority master, or <code>null</code> if a matching priority master could not be found
	 */
	public static PriorityMaster fetchByPriorityName(
		String priorityName, boolean useFinderCache) {

		return getPersistence().fetchByPriorityName(
			priorityName, useFinderCache);
	}

	/**
	 * Removes the priority master where priorityName = &#63; from the database.
	 *
	 * @param priorityName the priority name
	 * @return the priority master that was removed
	 */
	public static PriorityMaster removeByPriorityName(String priorityName)
		throws com.ax.hrms.master.exception.NoSuchPriorityMasterException {

		return getPersistence().removeByPriorityName(priorityName);
	}

	/**
	 * Returns the number of priority masters where priorityName = &#63;.
	 *
	 * @param priorityName the priority name
	 * @return the number of matching priority masters
	 */
	public static int countByPriorityName(String priorityName) {
		return getPersistence().countByPriorityName(priorityName);
	}

	/**
	 * Caches the priority master in the entity cache if it is enabled.
	 *
	 * @param priorityMaster the priority master
	 */
	public static void cacheResult(PriorityMaster priorityMaster) {
		getPersistence().cacheResult(priorityMaster);
	}

	/**
	 * Caches the priority masters in the entity cache if it is enabled.
	 *
	 * @param priorityMasters the priority masters
	 */
	public static void cacheResult(List<PriorityMaster> priorityMasters) {
		getPersistence().cacheResult(priorityMasters);
	}

	/**
	 * Creates a new priority master with the primary key. Does not add the priority master to the database.
	 *
	 * @param priorityMasterId the primary key for the new priority master
	 * @return the new priority master
	 */
	public static PriorityMaster create(long priorityMasterId) {
		return getPersistence().create(priorityMasterId);
	}

	/**
	 * Removes the priority master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param priorityMasterId the primary key of the priority master
	 * @return the priority master that was removed
	 * @throws NoSuchPriorityMasterException if a priority master with the primary key could not be found
	 */
	public static PriorityMaster remove(long priorityMasterId)
		throws com.ax.hrms.master.exception.NoSuchPriorityMasterException {

		return getPersistence().remove(priorityMasterId);
	}

	public static PriorityMaster updateImpl(PriorityMaster priorityMaster) {
		return getPersistence().updateImpl(priorityMaster);
	}

	/**
	 * Returns the priority master with the primary key or throws a <code>NoSuchPriorityMasterException</code> if it could not be found.
	 *
	 * @param priorityMasterId the primary key of the priority master
	 * @return the priority master
	 * @throws NoSuchPriorityMasterException if a priority master with the primary key could not be found
	 */
	public static PriorityMaster findByPrimaryKey(long priorityMasterId)
		throws com.ax.hrms.master.exception.NoSuchPriorityMasterException {

		return getPersistence().findByPrimaryKey(priorityMasterId);
	}

	/**
	 * Returns the priority master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param priorityMasterId the primary key of the priority master
	 * @return the priority master, or <code>null</code> if a priority master with the primary key could not be found
	 */
	public static PriorityMaster fetchByPrimaryKey(long priorityMasterId) {
		return getPersistence().fetchByPrimaryKey(priorityMasterId);
	}

	/**
	 * Returns all the priority masters.
	 *
	 * @return the priority masters
	 */
	public static List<PriorityMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the priority masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of priority masters
	 * @param end the upper bound of the range of priority masters (not inclusive)
	 * @return the range of priority masters
	 */
	public static List<PriorityMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the priority masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of priority masters
	 * @param end the upper bound of the range of priority masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of priority masters
	 */
	public static List<PriorityMaster> findAll(
		int start, int end,
		OrderByComparator<PriorityMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the priority masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of priority masters
	 * @param end the upper bound of the range of priority masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of priority masters
	 */
	public static List<PriorityMaster> findAll(
		int start, int end, OrderByComparator<PriorityMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the priority masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of priority masters.
	 *
	 * @return the number of priority masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PriorityMasterPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(PriorityMasterPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile PriorityMasterPersistence _persistence;

}