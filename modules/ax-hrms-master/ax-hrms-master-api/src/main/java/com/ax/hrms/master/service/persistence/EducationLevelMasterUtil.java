/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.model.EducationLevelMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the education level master service. This utility wraps <code>com.ax.hrms.master.service.persistence.impl.EducationLevelMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EducationLevelMasterPersistence
 * @generated
 */
public class EducationLevelMasterUtil {

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
	public static void clearCache(EducationLevelMaster educationLevelMaster) {
		getPersistence().clearCache(educationLevelMaster);
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
	public static Map<Serializable, EducationLevelMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EducationLevelMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EducationLevelMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EducationLevelMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EducationLevelMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EducationLevelMaster update(
		EducationLevelMaster educationLevelMaster) {

		return getPersistence().update(educationLevelMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EducationLevelMaster update(
		EducationLevelMaster educationLevelMaster,
		ServiceContext serviceContext) {

		return getPersistence().update(educationLevelMaster, serviceContext);
	}

	/**
	 * Returns the education level master where levelName = &#63; or throws a <code>NoSuchEducationLevelMasterException</code> if it could not be found.
	 *
	 * @param levelName the level name
	 * @return the matching education level master
	 * @throws NoSuchEducationLevelMasterException if a matching education level master could not be found
	 */
	public static EducationLevelMaster findByLevelName(String levelName)
		throws com.ax.hrms.master.exception.
			NoSuchEducationLevelMasterException {

		return getPersistence().findByLevelName(levelName);
	}

	/**
	 * Returns the education level master where levelName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param levelName the level name
	 * @return the matching education level master, or <code>null</code> if a matching education level master could not be found
	 */
	public static EducationLevelMaster fetchByLevelName(String levelName) {
		return getPersistence().fetchByLevelName(levelName);
	}

	/**
	 * Returns the education level master where levelName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param levelName the level name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching education level master, or <code>null</code> if a matching education level master could not be found
	 */
	public static EducationLevelMaster fetchByLevelName(
		String levelName, boolean useFinderCache) {

		return getPersistence().fetchByLevelName(levelName, useFinderCache);
	}

	/**
	 * Removes the education level master where levelName = &#63; from the database.
	 *
	 * @param levelName the level name
	 * @return the education level master that was removed
	 */
	public static EducationLevelMaster removeByLevelName(String levelName)
		throws com.ax.hrms.master.exception.
			NoSuchEducationLevelMasterException {

		return getPersistence().removeByLevelName(levelName);
	}

	/**
	 * Returns the number of education level masters where levelName = &#63;.
	 *
	 * @param levelName the level name
	 * @return the number of matching education level masters
	 */
	public static int countByLevelName(String levelName) {
		return getPersistence().countByLevelName(levelName);
	}

	/**
	 * Caches the education level master in the entity cache if it is enabled.
	 *
	 * @param educationLevelMaster the education level master
	 */
	public static void cacheResult(EducationLevelMaster educationLevelMaster) {
		getPersistence().cacheResult(educationLevelMaster);
	}

	/**
	 * Caches the education level masters in the entity cache if it is enabled.
	 *
	 * @param educationLevelMasters the education level masters
	 */
	public static void cacheResult(
		List<EducationLevelMaster> educationLevelMasters) {

		getPersistence().cacheResult(educationLevelMasters);
	}

	/**
	 * Creates a new education level master with the primary key. Does not add the education level master to the database.
	 *
	 * @param educationLevelMasterId the primary key for the new education level master
	 * @return the new education level master
	 */
	public static EducationLevelMaster create(long educationLevelMasterId) {
		return getPersistence().create(educationLevelMasterId);
	}

	/**
	 * Removes the education level master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param educationLevelMasterId the primary key of the education level master
	 * @return the education level master that was removed
	 * @throws NoSuchEducationLevelMasterException if a education level master with the primary key could not be found
	 */
	public static EducationLevelMaster remove(long educationLevelMasterId)
		throws com.ax.hrms.master.exception.
			NoSuchEducationLevelMasterException {

		return getPersistence().remove(educationLevelMasterId);
	}

	public static EducationLevelMaster updateImpl(
		EducationLevelMaster educationLevelMaster) {

		return getPersistence().updateImpl(educationLevelMaster);
	}

	/**
	 * Returns the education level master with the primary key or throws a <code>NoSuchEducationLevelMasterException</code> if it could not be found.
	 *
	 * @param educationLevelMasterId the primary key of the education level master
	 * @return the education level master
	 * @throws NoSuchEducationLevelMasterException if a education level master with the primary key could not be found
	 */
	public static EducationLevelMaster findByPrimaryKey(
			long educationLevelMasterId)
		throws com.ax.hrms.master.exception.
			NoSuchEducationLevelMasterException {

		return getPersistence().findByPrimaryKey(educationLevelMasterId);
	}

	/**
	 * Returns the education level master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param educationLevelMasterId the primary key of the education level master
	 * @return the education level master, or <code>null</code> if a education level master with the primary key could not be found
	 */
	public static EducationLevelMaster fetchByPrimaryKey(
		long educationLevelMasterId) {

		return getPersistence().fetchByPrimaryKey(educationLevelMasterId);
	}

	/**
	 * Returns all the education level masters.
	 *
	 * @return the education level masters
	 */
	public static List<EducationLevelMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the education level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EducationLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of education level masters
	 * @param end the upper bound of the range of education level masters (not inclusive)
	 * @return the range of education level masters
	 */
	public static List<EducationLevelMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the education level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EducationLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of education level masters
	 * @param end the upper bound of the range of education level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of education level masters
	 */
	public static List<EducationLevelMaster> findAll(
		int start, int end,
		OrderByComparator<EducationLevelMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the education level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EducationLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of education level masters
	 * @param end the upper bound of the range of education level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of education level masters
	 */
	public static List<EducationLevelMaster> findAll(
		int start, int end,
		OrderByComparator<EducationLevelMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the education level masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of education level masters.
	 *
	 * @return the number of education level masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EducationLevelMasterPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		EducationLevelMasterPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile EducationLevelMasterPersistence _persistence;

}