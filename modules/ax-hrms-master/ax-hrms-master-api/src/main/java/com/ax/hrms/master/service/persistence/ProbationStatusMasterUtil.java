/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.model.ProbationStatusMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the probation status master service. This utility wraps <code>com.ax.hrms.master.service.persistence.impl.ProbationStatusMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProbationStatusMasterPersistence
 * @generated
 */
public class ProbationStatusMasterUtil {

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
	public static void clearCache(ProbationStatusMaster probationStatusMaster) {
		getPersistence().clearCache(probationStatusMaster);
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
	public static Map<Serializable, ProbationStatusMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProbationStatusMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProbationStatusMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProbationStatusMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProbationStatusMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProbationStatusMaster update(
		ProbationStatusMaster probationStatusMaster) {

		return getPersistence().update(probationStatusMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProbationStatusMaster update(
		ProbationStatusMaster probationStatusMaster,
		ServiceContext serviceContext) {

		return getPersistence().update(probationStatusMaster, serviceContext);
	}

	/**
	 * Returns the probation status master where statusType = &#63; or throws a <code>NoSuchProbationStatusMasterException</code> if it could not be found.
	 *
	 * @param statusType the status type
	 * @return the matching probation status master
	 * @throws NoSuchProbationStatusMasterException if a matching probation status master could not be found
	 */
	public static ProbationStatusMaster findByStatusType(String statusType)
		throws com.ax.hrms.master.exception.
			NoSuchProbationStatusMasterException {

		return getPersistence().findByStatusType(statusType);
	}

	/**
	 * Returns the probation status master where statusType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param statusType the status type
	 * @return the matching probation status master, or <code>null</code> if a matching probation status master could not be found
	 */
	public static ProbationStatusMaster fetchByStatusType(String statusType) {
		return getPersistence().fetchByStatusType(statusType);
	}

	/**
	 * Returns the probation status master where statusType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param statusType the status type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching probation status master, or <code>null</code> if a matching probation status master could not be found
	 */
	public static ProbationStatusMaster fetchByStatusType(
		String statusType, boolean useFinderCache) {

		return getPersistence().fetchByStatusType(statusType, useFinderCache);
	}

	/**
	 * Removes the probation status master where statusType = &#63; from the database.
	 *
	 * @param statusType the status type
	 * @return the probation status master that was removed
	 */
	public static ProbationStatusMaster removeByStatusType(String statusType)
		throws com.ax.hrms.master.exception.
			NoSuchProbationStatusMasterException {

		return getPersistence().removeByStatusType(statusType);
	}

	/**
	 * Returns the number of probation status masters where statusType = &#63;.
	 *
	 * @param statusType the status type
	 * @return the number of matching probation status masters
	 */
	public static int countByStatusType(String statusType) {
		return getPersistence().countByStatusType(statusType);
	}

	/**
	 * Caches the probation status master in the entity cache if it is enabled.
	 *
	 * @param probationStatusMaster the probation status master
	 */
	public static void cacheResult(
		ProbationStatusMaster probationStatusMaster) {

		getPersistence().cacheResult(probationStatusMaster);
	}

	/**
	 * Caches the probation status masters in the entity cache if it is enabled.
	 *
	 * @param probationStatusMasters the probation status masters
	 */
	public static void cacheResult(
		List<ProbationStatusMaster> probationStatusMasters) {

		getPersistence().cacheResult(probationStatusMasters);
	}

	/**
	 * Creates a new probation status master with the primary key. Does not add the probation status master to the database.
	 *
	 * @param probationStatusMasterId the primary key for the new probation status master
	 * @return the new probation status master
	 */
	public static ProbationStatusMaster create(long probationStatusMasterId) {
		return getPersistence().create(probationStatusMasterId);
	}

	/**
	 * Removes the probation status master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param probationStatusMasterId the primary key of the probation status master
	 * @return the probation status master that was removed
	 * @throws NoSuchProbationStatusMasterException if a probation status master with the primary key could not be found
	 */
	public static ProbationStatusMaster remove(long probationStatusMasterId)
		throws com.ax.hrms.master.exception.
			NoSuchProbationStatusMasterException {

		return getPersistence().remove(probationStatusMasterId);
	}

	public static ProbationStatusMaster updateImpl(
		ProbationStatusMaster probationStatusMaster) {

		return getPersistence().updateImpl(probationStatusMaster);
	}

	/**
	 * Returns the probation status master with the primary key or throws a <code>NoSuchProbationStatusMasterException</code> if it could not be found.
	 *
	 * @param probationStatusMasterId the primary key of the probation status master
	 * @return the probation status master
	 * @throws NoSuchProbationStatusMasterException if a probation status master with the primary key could not be found
	 */
	public static ProbationStatusMaster findByPrimaryKey(
			long probationStatusMasterId)
		throws com.ax.hrms.master.exception.
			NoSuchProbationStatusMasterException {

		return getPersistence().findByPrimaryKey(probationStatusMasterId);
	}

	/**
	 * Returns the probation status master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param probationStatusMasterId the primary key of the probation status master
	 * @return the probation status master, or <code>null</code> if a probation status master with the primary key could not be found
	 */
	public static ProbationStatusMaster fetchByPrimaryKey(
		long probationStatusMasterId) {

		return getPersistence().fetchByPrimaryKey(probationStatusMasterId);
	}

	/**
	 * Returns all the probation status masters.
	 *
	 * @return the probation status masters
	 */
	public static List<ProbationStatusMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the probation status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProbationStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of probation status masters
	 * @param end the upper bound of the range of probation status masters (not inclusive)
	 * @return the range of probation status masters
	 */
	public static List<ProbationStatusMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the probation status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProbationStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of probation status masters
	 * @param end the upper bound of the range of probation status masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of probation status masters
	 */
	public static List<ProbationStatusMaster> findAll(
		int start, int end,
		OrderByComparator<ProbationStatusMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the probation status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProbationStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of probation status masters
	 * @param end the upper bound of the range of probation status masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of probation status masters
	 */
	public static List<ProbationStatusMaster> findAll(
		int start, int end,
		OrderByComparator<ProbationStatusMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the probation status masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of probation status masters.
	 *
	 * @return the number of probation status masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProbationStatusMasterPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		ProbationStatusMasterPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile ProbationStatusMasterPersistence _persistence;

}