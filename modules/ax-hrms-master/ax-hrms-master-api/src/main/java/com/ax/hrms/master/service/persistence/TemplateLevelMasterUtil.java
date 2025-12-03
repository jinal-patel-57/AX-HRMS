/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.model.TemplateLevelMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the template level master service. This utility wraps <code>com.ax.hrms.master.service.persistence.impl.TemplateLevelMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TemplateLevelMasterPersistence
 * @generated
 */
public class TemplateLevelMasterUtil {

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
	public static void clearCache(TemplateLevelMaster templateLevelMaster) {
		getPersistence().clearCache(templateLevelMaster);
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
	public static Map<Serializable, TemplateLevelMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TemplateLevelMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TemplateLevelMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TemplateLevelMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TemplateLevelMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TemplateLevelMaster update(
		TemplateLevelMaster templateLevelMaster) {

		return getPersistence().update(templateLevelMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TemplateLevelMaster update(
		TemplateLevelMaster templateLevelMaster,
		ServiceContext serviceContext) {

		return getPersistence().update(templateLevelMaster, serviceContext);
	}

	/**
	 * Returns the template level master where levelName = &#63; or throws a <code>NoSuchTemplateLevelMasterException</code> if it could not be found.
	 *
	 * @param levelName the level name
	 * @return the matching template level master
	 * @throws NoSuchTemplateLevelMasterException if a matching template level master could not be found
	 */
	public static TemplateLevelMaster findBylevelName(String levelName)
		throws com.ax.hrms.master.exception.NoSuchTemplateLevelMasterException {

		return getPersistence().findBylevelName(levelName);
	}

	/**
	 * Returns the template level master where levelName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param levelName the level name
	 * @return the matching template level master, or <code>null</code> if a matching template level master could not be found
	 */
	public static TemplateLevelMaster fetchBylevelName(String levelName) {
		return getPersistence().fetchBylevelName(levelName);
	}

	/**
	 * Returns the template level master where levelName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param levelName the level name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching template level master, or <code>null</code> if a matching template level master could not be found
	 */
	public static TemplateLevelMaster fetchBylevelName(
		String levelName, boolean useFinderCache) {

		return getPersistence().fetchBylevelName(levelName, useFinderCache);
	}

	/**
	 * Removes the template level master where levelName = &#63; from the database.
	 *
	 * @param levelName the level name
	 * @return the template level master that was removed
	 */
	public static TemplateLevelMaster removeBylevelName(String levelName)
		throws com.ax.hrms.master.exception.NoSuchTemplateLevelMasterException {

		return getPersistence().removeBylevelName(levelName);
	}

	/**
	 * Returns the number of template level masters where levelName = &#63;.
	 *
	 * @param levelName the level name
	 * @return the number of matching template level masters
	 */
	public static int countBylevelName(String levelName) {
		return getPersistence().countBylevelName(levelName);
	}

	/**
	 * Caches the template level master in the entity cache if it is enabled.
	 *
	 * @param templateLevelMaster the template level master
	 */
	public static void cacheResult(TemplateLevelMaster templateLevelMaster) {
		getPersistence().cacheResult(templateLevelMaster);
	}

	/**
	 * Caches the template level masters in the entity cache if it is enabled.
	 *
	 * @param templateLevelMasters the template level masters
	 */
	public static void cacheResult(
		List<TemplateLevelMaster> templateLevelMasters) {

		getPersistence().cacheResult(templateLevelMasters);
	}

	/**
	 * Creates a new template level master with the primary key. Does not add the template level master to the database.
	 *
	 * @param templateLevelMasterId the primary key for the new template level master
	 * @return the new template level master
	 */
	public static TemplateLevelMaster create(long templateLevelMasterId) {
		return getPersistence().create(templateLevelMasterId);
	}

	/**
	 * Removes the template level master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param templateLevelMasterId the primary key of the template level master
	 * @return the template level master that was removed
	 * @throws NoSuchTemplateLevelMasterException if a template level master with the primary key could not be found
	 */
	public static TemplateLevelMaster remove(long templateLevelMasterId)
		throws com.ax.hrms.master.exception.NoSuchTemplateLevelMasterException {

		return getPersistence().remove(templateLevelMasterId);
	}

	public static TemplateLevelMaster updateImpl(
		TemplateLevelMaster templateLevelMaster) {

		return getPersistence().updateImpl(templateLevelMaster);
	}

	/**
	 * Returns the template level master with the primary key or throws a <code>NoSuchTemplateLevelMasterException</code> if it could not be found.
	 *
	 * @param templateLevelMasterId the primary key of the template level master
	 * @return the template level master
	 * @throws NoSuchTemplateLevelMasterException if a template level master with the primary key could not be found
	 */
	public static TemplateLevelMaster findByPrimaryKey(
			long templateLevelMasterId)
		throws com.ax.hrms.master.exception.NoSuchTemplateLevelMasterException {

		return getPersistence().findByPrimaryKey(templateLevelMasterId);
	}

	/**
	 * Returns the template level master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param templateLevelMasterId the primary key of the template level master
	 * @return the template level master, or <code>null</code> if a template level master with the primary key could not be found
	 */
	public static TemplateLevelMaster fetchByPrimaryKey(
		long templateLevelMasterId) {

		return getPersistence().fetchByPrimaryKey(templateLevelMasterId);
	}

	/**
	 * Returns all the template level masters.
	 *
	 * @return the template level masters
	 */
	public static List<TemplateLevelMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the template level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplateLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of template level masters
	 * @param end the upper bound of the range of template level masters (not inclusive)
	 * @return the range of template level masters
	 */
	public static List<TemplateLevelMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the template level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplateLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of template level masters
	 * @param end the upper bound of the range of template level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of template level masters
	 */
	public static List<TemplateLevelMaster> findAll(
		int start, int end,
		OrderByComparator<TemplateLevelMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the template level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplateLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of template level masters
	 * @param end the upper bound of the range of template level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of template level masters
	 */
	public static List<TemplateLevelMaster> findAll(
		int start, int end,
		OrderByComparator<TemplateLevelMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the template level masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of template level masters.
	 *
	 * @return the number of template level masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TemplateLevelMasterPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		TemplateLevelMasterPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile TemplateLevelMasterPersistence _persistence;

}