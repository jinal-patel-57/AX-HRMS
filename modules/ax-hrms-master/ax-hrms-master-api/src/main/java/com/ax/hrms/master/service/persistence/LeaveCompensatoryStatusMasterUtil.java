/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the leave compensatory status master service. This utility wraps <code>com.ax.hrms.master.service.persistence.impl.LeaveCompensatoryStatusMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveCompensatoryStatusMasterPersistence
 * @generated
 */
public class LeaveCompensatoryStatusMasterUtil {

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
		LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster) {

		getPersistence().clearCache(leaveCompensatoryStatusMaster);
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
	public static Map<Serializable, LeaveCompensatoryStatusMaster>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LeaveCompensatoryStatusMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LeaveCompensatoryStatusMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LeaveCompensatoryStatusMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LeaveCompensatoryStatusMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LeaveCompensatoryStatusMaster update(
		LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster) {

		return getPersistence().update(leaveCompensatoryStatusMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LeaveCompensatoryStatusMaster update(
		LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster,
		ServiceContext serviceContext) {

		return getPersistence().update(
			leaveCompensatoryStatusMaster, serviceContext);
	}

	/**
	 * Returns the leave compensatory status master where leaveCompensatoryStatus = &#63; or throws a <code>NoSuchLeaveCompensatoryStatusMasterException</code> if it could not be found.
	 *
	 * @param leaveCompensatoryStatus the leave compensatory status
	 * @return the matching leave compensatory status master
	 * @throws NoSuchLeaveCompensatoryStatusMasterException if a matching leave compensatory status master could not be found
	 */
	public static LeaveCompensatoryStatusMaster findByLeaveCompensatoryStatus(
			String leaveCompensatoryStatus)
		throws com.ax.hrms.master.exception.
			NoSuchLeaveCompensatoryStatusMasterException {

		return getPersistence().findByLeaveCompensatoryStatus(
			leaveCompensatoryStatus);
	}

	/**
	 * Returns the leave compensatory status master where leaveCompensatoryStatus = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveCompensatoryStatus the leave compensatory status
	 * @return the matching leave compensatory status master, or <code>null</code> if a matching leave compensatory status master could not be found
	 */
	public static LeaveCompensatoryStatusMaster fetchByLeaveCompensatoryStatus(
		String leaveCompensatoryStatus) {

		return getPersistence().fetchByLeaveCompensatoryStatus(
			leaveCompensatoryStatus);
	}

	/**
	 * Returns the leave compensatory status master where leaveCompensatoryStatus = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveCompensatoryStatus the leave compensatory status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave compensatory status master, or <code>null</code> if a matching leave compensatory status master could not be found
	 */
	public static LeaveCompensatoryStatusMaster fetchByLeaveCompensatoryStatus(
		String leaveCompensatoryStatus, boolean useFinderCache) {

		return getPersistence().fetchByLeaveCompensatoryStatus(
			leaveCompensatoryStatus, useFinderCache);
	}

	/**
	 * Removes the leave compensatory status master where leaveCompensatoryStatus = &#63; from the database.
	 *
	 * @param leaveCompensatoryStatus the leave compensatory status
	 * @return the leave compensatory status master that was removed
	 */
	public static LeaveCompensatoryStatusMaster removeByLeaveCompensatoryStatus(
			String leaveCompensatoryStatus)
		throws com.ax.hrms.master.exception.
			NoSuchLeaveCompensatoryStatusMasterException {

		return getPersistence().removeByLeaveCompensatoryStatus(
			leaveCompensatoryStatus);
	}

	/**
	 * Returns the number of leave compensatory status masters where leaveCompensatoryStatus = &#63;.
	 *
	 * @param leaveCompensatoryStatus the leave compensatory status
	 * @return the number of matching leave compensatory status masters
	 */
	public static int countByLeaveCompensatoryStatus(
		String leaveCompensatoryStatus) {

		return getPersistence().countByLeaveCompensatoryStatus(
			leaveCompensatoryStatus);
	}

	/**
	 * Returns the leave compensatory status master where leaveCompensatoryStatusMasterId = &#63; or throws a <code>NoSuchLeaveCompensatoryStatusMasterException</code> if it could not be found.
	 *
	 * @param leaveCompensatoryStatusMasterId the leave compensatory status master ID
	 * @return the matching leave compensatory status master
	 * @throws NoSuchLeaveCompensatoryStatusMasterException if a matching leave compensatory status master could not be found
	 */
	public static LeaveCompensatoryStatusMaster
			findByLeaveCompensatoryStatusById(
				long leaveCompensatoryStatusMasterId)
		throws com.ax.hrms.master.exception.
			NoSuchLeaveCompensatoryStatusMasterException {

		return getPersistence().findByLeaveCompensatoryStatusById(
			leaveCompensatoryStatusMasterId);
	}

	/**
	 * Returns the leave compensatory status master where leaveCompensatoryStatusMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveCompensatoryStatusMasterId the leave compensatory status master ID
	 * @return the matching leave compensatory status master, or <code>null</code> if a matching leave compensatory status master could not be found
	 */
	public static LeaveCompensatoryStatusMaster
		fetchByLeaveCompensatoryStatusById(
			long leaveCompensatoryStatusMasterId) {

		return getPersistence().fetchByLeaveCompensatoryStatusById(
			leaveCompensatoryStatusMasterId);
	}

	/**
	 * Returns the leave compensatory status master where leaveCompensatoryStatusMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveCompensatoryStatusMasterId the leave compensatory status master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave compensatory status master, or <code>null</code> if a matching leave compensatory status master could not be found
	 */
	public static LeaveCompensatoryStatusMaster
		fetchByLeaveCompensatoryStatusById(
			long leaveCompensatoryStatusMasterId, boolean useFinderCache) {

		return getPersistence().fetchByLeaveCompensatoryStatusById(
			leaveCompensatoryStatusMasterId, useFinderCache);
	}

	/**
	 * Removes the leave compensatory status master where leaveCompensatoryStatusMasterId = &#63; from the database.
	 *
	 * @param leaveCompensatoryStatusMasterId the leave compensatory status master ID
	 * @return the leave compensatory status master that was removed
	 */
	public static LeaveCompensatoryStatusMaster
			removeByLeaveCompensatoryStatusById(
				long leaveCompensatoryStatusMasterId)
		throws com.ax.hrms.master.exception.
			NoSuchLeaveCompensatoryStatusMasterException {

		return getPersistence().removeByLeaveCompensatoryStatusById(
			leaveCompensatoryStatusMasterId);
	}

	/**
	 * Returns the number of leave compensatory status masters where leaveCompensatoryStatusMasterId = &#63;.
	 *
	 * @param leaveCompensatoryStatusMasterId the leave compensatory status master ID
	 * @return the number of matching leave compensatory status masters
	 */
	public static int countByLeaveCompensatoryStatusById(
		long leaveCompensatoryStatusMasterId) {

		return getPersistence().countByLeaveCompensatoryStatusById(
			leaveCompensatoryStatusMasterId);
	}

	/**
	 * Caches the leave compensatory status master in the entity cache if it is enabled.
	 *
	 * @param leaveCompensatoryStatusMaster the leave compensatory status master
	 */
	public static void cacheResult(
		LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster) {

		getPersistence().cacheResult(leaveCompensatoryStatusMaster);
	}

	/**
	 * Caches the leave compensatory status masters in the entity cache if it is enabled.
	 *
	 * @param leaveCompensatoryStatusMasters the leave compensatory status masters
	 */
	public static void cacheResult(
		List<LeaveCompensatoryStatusMaster> leaveCompensatoryStatusMasters) {

		getPersistence().cacheResult(leaveCompensatoryStatusMasters);
	}

	/**
	 * Creates a new leave compensatory status master with the primary key. Does not add the leave compensatory status master to the database.
	 *
	 * @param leaveCompensatoryStatusMasterId the primary key for the new leave compensatory status master
	 * @return the new leave compensatory status master
	 */
	public static LeaveCompensatoryStatusMaster create(
		long leaveCompensatoryStatusMasterId) {

		return getPersistence().create(leaveCompensatoryStatusMasterId);
	}

	/**
	 * Removes the leave compensatory status master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveCompensatoryStatusMasterId the primary key of the leave compensatory status master
	 * @return the leave compensatory status master that was removed
	 * @throws NoSuchLeaveCompensatoryStatusMasterException if a leave compensatory status master with the primary key could not be found
	 */
	public static LeaveCompensatoryStatusMaster remove(
			long leaveCompensatoryStatusMasterId)
		throws com.ax.hrms.master.exception.
			NoSuchLeaveCompensatoryStatusMasterException {

		return getPersistence().remove(leaveCompensatoryStatusMasterId);
	}

	public static LeaveCompensatoryStatusMaster updateImpl(
		LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster) {

		return getPersistence().updateImpl(leaveCompensatoryStatusMaster);
	}

	/**
	 * Returns the leave compensatory status master with the primary key or throws a <code>NoSuchLeaveCompensatoryStatusMasterException</code> if it could not be found.
	 *
	 * @param leaveCompensatoryStatusMasterId the primary key of the leave compensatory status master
	 * @return the leave compensatory status master
	 * @throws NoSuchLeaveCompensatoryStatusMasterException if a leave compensatory status master with the primary key could not be found
	 */
	public static LeaveCompensatoryStatusMaster findByPrimaryKey(
			long leaveCompensatoryStatusMasterId)
		throws com.ax.hrms.master.exception.
			NoSuchLeaveCompensatoryStatusMasterException {

		return getPersistence().findByPrimaryKey(
			leaveCompensatoryStatusMasterId);
	}

	/**
	 * Returns the leave compensatory status master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveCompensatoryStatusMasterId the primary key of the leave compensatory status master
	 * @return the leave compensatory status master, or <code>null</code> if a leave compensatory status master with the primary key could not be found
	 */
	public static LeaveCompensatoryStatusMaster fetchByPrimaryKey(
		long leaveCompensatoryStatusMasterId) {

		return getPersistence().fetchByPrimaryKey(
			leaveCompensatoryStatusMasterId);
	}

	/**
	 * Returns all the leave compensatory status masters.
	 *
	 * @return the leave compensatory status masters
	 */
	public static List<LeaveCompensatoryStatusMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the leave compensatory status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveCompensatoryStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave compensatory status masters
	 * @param end the upper bound of the range of leave compensatory status masters (not inclusive)
	 * @return the range of leave compensatory status masters
	 */
	public static List<LeaveCompensatoryStatusMaster> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the leave compensatory status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveCompensatoryStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave compensatory status masters
	 * @param end the upper bound of the range of leave compensatory status masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave compensatory status masters
	 */
	public static List<LeaveCompensatoryStatusMaster> findAll(
		int start, int end,
		OrderByComparator<LeaveCompensatoryStatusMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave compensatory status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveCompensatoryStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave compensatory status masters
	 * @param end the upper bound of the range of leave compensatory status masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave compensatory status masters
	 */
	public static List<LeaveCompensatoryStatusMaster> findAll(
		int start, int end,
		OrderByComparator<LeaveCompensatoryStatusMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the leave compensatory status masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of leave compensatory status masters.
	 *
	 * @return the number of leave compensatory status masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LeaveCompensatoryStatusMasterPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		LeaveCompensatoryStatusMasterPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile LeaveCompensatoryStatusMasterPersistence
		_persistence;

}