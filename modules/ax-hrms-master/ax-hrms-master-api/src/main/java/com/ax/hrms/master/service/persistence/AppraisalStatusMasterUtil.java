/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.model.AppraisalStatusMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the appraisal status master service. This utility wraps <code>com.ax.hrms.master.service.persistence.impl.AppraisalStatusMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalStatusMasterPersistence
 * @generated
 */
public class AppraisalStatusMasterUtil {

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
	public static void clearCache(AppraisalStatusMaster appraisalStatusMaster) {
		getPersistence().clearCache(appraisalStatusMaster);
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
	public static Map<Serializable, AppraisalStatusMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AppraisalStatusMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AppraisalStatusMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AppraisalStatusMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AppraisalStatusMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AppraisalStatusMaster update(
		AppraisalStatusMaster appraisalStatusMaster) {

		return getPersistence().update(appraisalStatusMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AppraisalStatusMaster update(
		AppraisalStatusMaster appraisalStatusMaster,
		ServiceContext serviceContext) {

		return getPersistence().update(appraisalStatusMaster, serviceContext);
	}

	/**
	 * Returns the appraisal status master where status = &#63; or throws a <code>NoSuchAppraisalStatusMasterException</code> if it could not be found.
	 *
	 * @param status the status
	 * @return the matching appraisal status master
	 * @throws NoSuchAppraisalStatusMasterException if a matching appraisal status master could not be found
	 */
	public static AppraisalStatusMaster findBystatus(String status)
		throws com.ax.hrms.master.exception.
			NoSuchAppraisalStatusMasterException {

		return getPersistence().findBystatus(status);
	}

	/**
	 * Returns the appraisal status master where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param status the status
	 * @return the matching appraisal status master, or <code>null</code> if a matching appraisal status master could not be found
	 */
	public static AppraisalStatusMaster fetchBystatus(String status) {
		return getPersistence().fetchBystatus(status);
	}

	/**
	 * Returns the appraisal status master where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal status master, or <code>null</code> if a matching appraisal status master could not be found
	 */
	public static AppraisalStatusMaster fetchBystatus(
		String status, boolean useFinderCache) {

		return getPersistence().fetchBystatus(status, useFinderCache);
	}

	/**
	 * Removes the appraisal status master where status = &#63; from the database.
	 *
	 * @param status the status
	 * @return the appraisal status master that was removed
	 */
	public static AppraisalStatusMaster removeBystatus(String status)
		throws com.ax.hrms.master.exception.
			NoSuchAppraisalStatusMasterException {

		return getPersistence().removeBystatus(status);
	}

	/**
	 * Returns the number of appraisal status masters where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching appraisal status masters
	 */
	public static int countBystatus(String status) {
		return getPersistence().countBystatus(status);
	}

	/**
	 * Caches the appraisal status master in the entity cache if it is enabled.
	 *
	 * @param appraisalStatusMaster the appraisal status master
	 */
	public static void cacheResult(
		AppraisalStatusMaster appraisalStatusMaster) {

		getPersistence().cacheResult(appraisalStatusMaster);
	}

	/**
	 * Caches the appraisal status masters in the entity cache if it is enabled.
	 *
	 * @param appraisalStatusMasters the appraisal status masters
	 */
	public static void cacheResult(
		List<AppraisalStatusMaster> appraisalStatusMasters) {

		getPersistence().cacheResult(appraisalStatusMasters);
	}

	/**
	 * Creates a new appraisal status master with the primary key. Does not add the appraisal status master to the database.
	 *
	 * @param appraisalStatusMasterId the primary key for the new appraisal status master
	 * @return the new appraisal status master
	 */
	public static AppraisalStatusMaster create(long appraisalStatusMasterId) {
		return getPersistence().create(appraisalStatusMasterId);
	}

	/**
	 * Removes the appraisal status master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalStatusMasterId the primary key of the appraisal status master
	 * @return the appraisal status master that was removed
	 * @throws NoSuchAppraisalStatusMasterException if a appraisal status master with the primary key could not be found
	 */
	public static AppraisalStatusMaster remove(long appraisalStatusMasterId)
		throws com.ax.hrms.master.exception.
			NoSuchAppraisalStatusMasterException {

		return getPersistence().remove(appraisalStatusMasterId);
	}

	public static AppraisalStatusMaster updateImpl(
		AppraisalStatusMaster appraisalStatusMaster) {

		return getPersistence().updateImpl(appraisalStatusMaster);
	}

	/**
	 * Returns the appraisal status master with the primary key or throws a <code>NoSuchAppraisalStatusMasterException</code> if it could not be found.
	 *
	 * @param appraisalStatusMasterId the primary key of the appraisal status master
	 * @return the appraisal status master
	 * @throws NoSuchAppraisalStatusMasterException if a appraisal status master with the primary key could not be found
	 */
	public static AppraisalStatusMaster findByPrimaryKey(
			long appraisalStatusMasterId)
		throws com.ax.hrms.master.exception.
			NoSuchAppraisalStatusMasterException {

		return getPersistence().findByPrimaryKey(appraisalStatusMasterId);
	}

	/**
	 * Returns the appraisal status master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalStatusMasterId the primary key of the appraisal status master
	 * @return the appraisal status master, or <code>null</code> if a appraisal status master with the primary key could not be found
	 */
	public static AppraisalStatusMaster fetchByPrimaryKey(
		long appraisalStatusMasterId) {

		return getPersistence().fetchByPrimaryKey(appraisalStatusMasterId);
	}

	/**
	 * Returns all the appraisal status masters.
	 *
	 * @return the appraisal status masters
	 */
	public static List<AppraisalStatusMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the appraisal status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal status masters
	 * @param end the upper bound of the range of appraisal status masters (not inclusive)
	 * @return the range of appraisal status masters
	 */
	public static List<AppraisalStatusMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the appraisal status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal status masters
	 * @param end the upper bound of the range of appraisal status masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appraisal status masters
	 */
	public static List<AppraisalStatusMaster> findAll(
		int start, int end,
		OrderByComparator<AppraisalStatusMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the appraisal status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal status masters
	 * @param end the upper bound of the range of appraisal status masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of appraisal status masters
	 */
	public static List<AppraisalStatusMaster> findAll(
		int start, int end,
		OrderByComparator<AppraisalStatusMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the appraisal status masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of appraisal status masters.
	 *
	 * @return the number of appraisal status masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AppraisalStatusMasterPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		AppraisalStatusMasterPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile AppraisalStatusMasterPersistence _persistence;

}