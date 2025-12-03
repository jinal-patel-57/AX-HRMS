/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.model.WishTypeMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the wish type master service. This utility wraps <code>com.ax.hrms.master.service.persistence.impl.WishTypeMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WishTypeMasterPersistence
 * @generated
 */
public class WishTypeMasterUtil {

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
	public static void clearCache(WishTypeMaster wishTypeMaster) {
		getPersistence().clearCache(wishTypeMaster);
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
	public static Map<Serializable, WishTypeMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WishTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WishTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WishTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WishTypeMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WishTypeMaster update(WishTypeMaster wishTypeMaster) {
		return getPersistence().update(wishTypeMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WishTypeMaster update(
		WishTypeMaster wishTypeMaster, ServiceContext serviceContext) {

		return getPersistence().update(wishTypeMaster, serviceContext);
	}

	/**
	 * Returns the wish type master where wishType = &#63; or throws a <code>NoSuchWishTypeMasterException</code> if it could not be found.
	 *
	 * @param wishType the wish type
	 * @return the matching wish type master
	 * @throws NoSuchWishTypeMasterException if a matching wish type master could not be found
	 */
	public static WishTypeMaster findByWishType(String wishType)
		throws com.ax.hrms.master.exception.NoSuchWishTypeMasterException {

		return getPersistence().findByWishType(wishType);
	}

	/**
	 * Returns the wish type master where wishType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param wishType the wish type
	 * @return the matching wish type master, or <code>null</code> if a matching wish type master could not be found
	 */
	public static WishTypeMaster fetchByWishType(String wishType) {
		return getPersistence().fetchByWishType(wishType);
	}

	/**
	 * Returns the wish type master where wishType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param wishType the wish type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching wish type master, or <code>null</code> if a matching wish type master could not be found
	 */
	public static WishTypeMaster fetchByWishType(
		String wishType, boolean useFinderCache) {

		return getPersistence().fetchByWishType(wishType, useFinderCache);
	}

	/**
	 * Removes the wish type master where wishType = &#63; from the database.
	 *
	 * @param wishType the wish type
	 * @return the wish type master that was removed
	 */
	public static WishTypeMaster removeByWishType(String wishType)
		throws com.ax.hrms.master.exception.NoSuchWishTypeMasterException {

		return getPersistence().removeByWishType(wishType);
	}

	/**
	 * Returns the number of wish type masters where wishType = &#63;.
	 *
	 * @param wishType the wish type
	 * @return the number of matching wish type masters
	 */
	public static int countByWishType(String wishType) {
		return getPersistence().countByWishType(wishType);
	}

	/**
	 * Caches the wish type master in the entity cache if it is enabled.
	 *
	 * @param wishTypeMaster the wish type master
	 */
	public static void cacheResult(WishTypeMaster wishTypeMaster) {
		getPersistence().cacheResult(wishTypeMaster);
	}

	/**
	 * Caches the wish type masters in the entity cache if it is enabled.
	 *
	 * @param wishTypeMasters the wish type masters
	 */
	public static void cacheResult(List<WishTypeMaster> wishTypeMasters) {
		getPersistence().cacheResult(wishTypeMasters);
	}

	/**
	 * Creates a new wish type master with the primary key. Does not add the wish type master to the database.
	 *
	 * @param wishTypeMasterId the primary key for the new wish type master
	 * @return the new wish type master
	 */
	public static WishTypeMaster create(long wishTypeMasterId) {
		return getPersistence().create(wishTypeMasterId);
	}

	/**
	 * Removes the wish type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wishTypeMasterId the primary key of the wish type master
	 * @return the wish type master that was removed
	 * @throws NoSuchWishTypeMasterException if a wish type master with the primary key could not be found
	 */
	public static WishTypeMaster remove(long wishTypeMasterId)
		throws com.ax.hrms.master.exception.NoSuchWishTypeMasterException {

		return getPersistence().remove(wishTypeMasterId);
	}

	public static WishTypeMaster updateImpl(WishTypeMaster wishTypeMaster) {
		return getPersistence().updateImpl(wishTypeMaster);
	}

	/**
	 * Returns the wish type master with the primary key or throws a <code>NoSuchWishTypeMasterException</code> if it could not be found.
	 *
	 * @param wishTypeMasterId the primary key of the wish type master
	 * @return the wish type master
	 * @throws NoSuchWishTypeMasterException if a wish type master with the primary key could not be found
	 */
	public static WishTypeMaster findByPrimaryKey(long wishTypeMasterId)
		throws com.ax.hrms.master.exception.NoSuchWishTypeMasterException {

		return getPersistence().findByPrimaryKey(wishTypeMasterId);
	}

	/**
	 * Returns the wish type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param wishTypeMasterId the primary key of the wish type master
	 * @return the wish type master, or <code>null</code> if a wish type master with the primary key could not be found
	 */
	public static WishTypeMaster fetchByPrimaryKey(long wishTypeMasterId) {
		return getPersistence().fetchByPrimaryKey(wishTypeMasterId);
	}

	/**
	 * Returns all the wish type masters.
	 *
	 * @return the wish type masters
	 */
	public static List<WishTypeMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the wish type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WishTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of wish type masters
	 * @param end the upper bound of the range of wish type masters (not inclusive)
	 * @return the range of wish type masters
	 */
	public static List<WishTypeMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the wish type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WishTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of wish type masters
	 * @param end the upper bound of the range of wish type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of wish type masters
	 */
	public static List<WishTypeMaster> findAll(
		int start, int end,
		OrderByComparator<WishTypeMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the wish type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WishTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of wish type masters
	 * @param end the upper bound of the range of wish type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of wish type masters
	 */
	public static List<WishTypeMaster> findAll(
		int start, int end, OrderByComparator<WishTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the wish type masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of wish type masters.
	 *
	 * @return the number of wish type masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WishTypeMasterPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(WishTypeMasterPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile WishTypeMasterPersistence _persistence;

}