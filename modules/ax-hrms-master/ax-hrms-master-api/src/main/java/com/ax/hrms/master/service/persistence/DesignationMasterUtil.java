/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.model.DesignationMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the designation master service. This utility wraps <code>com.ax.hrms.master.service.persistence.impl.DesignationMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DesignationMasterPersistence
 * @generated
 */
public class DesignationMasterUtil {

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
	public static void clearCache(DesignationMaster designationMaster) {
		getPersistence().clearCache(designationMaster);
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
	public static Map<Serializable, DesignationMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DesignationMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DesignationMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DesignationMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DesignationMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DesignationMaster update(
		DesignationMaster designationMaster) {

		return getPersistence().update(designationMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DesignationMaster update(
		DesignationMaster designationMaster, ServiceContext serviceContext) {

		return getPersistence().update(designationMaster, serviceContext);
	}

	/**
	 * Returns the designation master where designationName = &#63; or throws a <code>NoSuchDesignationMasterException</code> if it could not be found.
	 *
	 * @param designationName the designation name
	 * @return the matching designation master
	 * @throws NoSuchDesignationMasterException if a matching designation master could not be found
	 */
	public static DesignationMaster findByDesignationName(
			String designationName)
		throws com.ax.hrms.master.exception.NoSuchDesignationMasterException {

		return getPersistence().findByDesignationName(designationName);
	}

	/**
	 * Returns the designation master where designationName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param designationName the designation name
	 * @return the matching designation master, or <code>null</code> if a matching designation master could not be found
	 */
	public static DesignationMaster fetchByDesignationName(
		String designationName) {

		return getPersistence().fetchByDesignationName(designationName);
	}

	/**
	 * Returns the designation master where designationName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param designationName the designation name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching designation master, or <code>null</code> if a matching designation master could not be found
	 */
	public static DesignationMaster fetchByDesignationName(
		String designationName, boolean useFinderCache) {

		return getPersistence().fetchByDesignationName(
			designationName, useFinderCache);
	}

	/**
	 * Removes the designation master where designationName = &#63; from the database.
	 *
	 * @param designationName the designation name
	 * @return the designation master that was removed
	 */
	public static DesignationMaster removeByDesignationName(
			String designationName)
		throws com.ax.hrms.master.exception.NoSuchDesignationMasterException {

		return getPersistence().removeByDesignationName(designationName);
	}

	/**
	 * Returns the number of designation masters where designationName = &#63;.
	 *
	 * @param designationName the designation name
	 * @return the number of matching designation masters
	 */
	public static int countByDesignationName(String designationName) {
		return getPersistence().countByDesignationName(designationName);
	}

	/**
	 * Returns the designation master where designationMasterId = &#63; or throws a <code>NoSuchDesignationMasterException</code> if it could not be found.
	 *
	 * @param designationMasterId the designation master ID
	 * @return the matching designation master
	 * @throws NoSuchDesignationMasterException if a matching designation master could not be found
	 */
	public static DesignationMaster findByDesignationNameById(
			long designationMasterId)
		throws com.ax.hrms.master.exception.NoSuchDesignationMasterException {

		return getPersistence().findByDesignationNameById(designationMasterId);
	}

	/**
	 * Returns the designation master where designationMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param designationMasterId the designation master ID
	 * @return the matching designation master, or <code>null</code> if a matching designation master could not be found
	 */
	public static DesignationMaster fetchByDesignationNameById(
		long designationMasterId) {

		return getPersistence().fetchByDesignationNameById(designationMasterId);
	}

	/**
	 * Returns the designation master where designationMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param designationMasterId the designation master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching designation master, or <code>null</code> if a matching designation master could not be found
	 */
	public static DesignationMaster fetchByDesignationNameById(
		long designationMasterId, boolean useFinderCache) {

		return getPersistence().fetchByDesignationNameById(
			designationMasterId, useFinderCache);
	}

	/**
	 * Removes the designation master where designationMasterId = &#63; from the database.
	 *
	 * @param designationMasterId the designation master ID
	 * @return the designation master that was removed
	 */
	public static DesignationMaster removeByDesignationNameById(
			long designationMasterId)
		throws com.ax.hrms.master.exception.NoSuchDesignationMasterException {

		return getPersistence().removeByDesignationNameById(
			designationMasterId);
	}

	/**
	 * Returns the number of designation masters where designationMasterId = &#63;.
	 *
	 * @param designationMasterId the designation master ID
	 * @return the number of matching designation masters
	 */
	public static int countByDesignationNameById(long designationMasterId) {
		return getPersistence().countByDesignationNameById(designationMasterId);
	}

	/**
	 * Caches the designation master in the entity cache if it is enabled.
	 *
	 * @param designationMaster the designation master
	 */
	public static void cacheResult(DesignationMaster designationMaster) {
		getPersistence().cacheResult(designationMaster);
	}

	/**
	 * Caches the designation masters in the entity cache if it is enabled.
	 *
	 * @param designationMasters the designation masters
	 */
	public static void cacheResult(List<DesignationMaster> designationMasters) {
		getPersistence().cacheResult(designationMasters);
	}

	/**
	 * Creates a new designation master with the primary key. Does not add the designation master to the database.
	 *
	 * @param designationMasterId the primary key for the new designation master
	 * @return the new designation master
	 */
	public static DesignationMaster create(long designationMasterId) {
		return getPersistence().create(designationMasterId);
	}

	/**
	 * Removes the designation master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationMasterId the primary key of the designation master
	 * @return the designation master that was removed
	 * @throws NoSuchDesignationMasterException if a designation master with the primary key could not be found
	 */
	public static DesignationMaster remove(long designationMasterId)
		throws com.ax.hrms.master.exception.NoSuchDesignationMasterException {

		return getPersistence().remove(designationMasterId);
	}

	public static DesignationMaster updateImpl(
		DesignationMaster designationMaster) {

		return getPersistence().updateImpl(designationMaster);
	}

	/**
	 * Returns the designation master with the primary key or throws a <code>NoSuchDesignationMasterException</code> if it could not be found.
	 *
	 * @param designationMasterId the primary key of the designation master
	 * @return the designation master
	 * @throws NoSuchDesignationMasterException if a designation master with the primary key could not be found
	 */
	public static DesignationMaster findByPrimaryKey(long designationMasterId)
		throws com.ax.hrms.master.exception.NoSuchDesignationMasterException {

		return getPersistence().findByPrimaryKey(designationMasterId);
	}

	/**
	 * Returns the designation master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationMasterId the primary key of the designation master
	 * @return the designation master, or <code>null</code> if a designation master with the primary key could not be found
	 */
	public static DesignationMaster fetchByPrimaryKey(
		long designationMasterId) {

		return getPersistence().fetchByPrimaryKey(designationMasterId);
	}

	/**
	 * Returns all the designation masters.
	 *
	 * @return the designation masters
	 */
	public static List<DesignationMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the designation masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation masters
	 * @param end the upper bound of the range of designation masters (not inclusive)
	 * @return the range of designation masters
	 */
	public static List<DesignationMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the designation masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation masters
	 * @param end the upper bound of the range of designation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designation masters
	 */
	public static List<DesignationMaster> findAll(
		int start, int end,
		OrderByComparator<DesignationMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the designation masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation masters
	 * @param end the upper bound of the range of designation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of designation masters
	 */
	public static List<DesignationMaster> findAll(
		int start, int end,
		OrderByComparator<DesignationMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the designation masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of designation masters.
	 *
	 * @return the number of designation masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DesignationMasterPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		DesignationMasterPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile DesignationMasterPersistence _persistence;

}