/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.model.LeavePolicyMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the leave policy master service. This utility wraps <code>com.ax.hrms.master.service.persistence.impl.LeavePolicyMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeavePolicyMasterPersistence
 * @generated
 */
public class LeavePolicyMasterUtil {

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
	public static void clearCache(LeavePolicyMaster leavePolicyMaster) {
		getPersistence().clearCache(leavePolicyMaster);
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
	public static Map<Serializable, LeavePolicyMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LeavePolicyMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LeavePolicyMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LeavePolicyMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LeavePolicyMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LeavePolicyMaster update(
		LeavePolicyMaster leavePolicyMaster) {

		return getPersistence().update(leavePolicyMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LeavePolicyMaster update(
		LeavePolicyMaster leavePolicyMaster, ServiceContext serviceContext) {

		return getPersistence().update(leavePolicyMaster, serviceContext);
	}

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; or throws a <code>NoSuchLeavePolicyMasterException</code> if it could not be found.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the matching leave policy master
	 * @throws NoSuchLeavePolicyMasterException if a matching leave policy master could not be found
	 */
	public static LeavePolicyMaster findByLeaveTypeMasterId(
			long leaveTypeMasterId)
		throws com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException {

		return getPersistence().findByLeaveTypeMasterId(leaveTypeMasterId);
	}

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	public static LeavePolicyMaster fetchByLeaveTypeMasterId(
		long leaveTypeMasterId) {

		return getPersistence().fetchByLeaveTypeMasterId(leaveTypeMasterId);
	}

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	public static LeavePolicyMaster fetchByLeaveTypeMasterId(
		long leaveTypeMasterId, boolean useFinderCache) {

		return getPersistence().fetchByLeaveTypeMasterId(
			leaveTypeMasterId, useFinderCache);
	}

	/**
	 * Removes the leave policy master where leaveTypeMasterId = &#63; from the database.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the leave policy master that was removed
	 */
	public static LeavePolicyMaster removeByLeaveTypeMasterId(
			long leaveTypeMasterId)
		throws com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException {

		return getPersistence().removeByLeaveTypeMasterId(leaveTypeMasterId);
	}

	/**
	 * Returns the number of leave policy masters where leaveTypeMasterId = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the number of matching leave policy masters
	 */
	public static int countByLeaveTypeMasterId(long leaveTypeMasterId) {
		return getPersistence().countByLeaveTypeMasterId(leaveTypeMasterId);
	}

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; or throws a <code>NoSuchLeavePolicyMasterException</code> if it could not be found.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @return the matching leave policy master
	 * @throws NoSuchLeavePolicyMasterException if a matching leave policy master could not be found
	 */
	public static LeavePolicyMaster findByLeaveTypeMasterIdAndYear(
			long leaveTypeMasterId, int yearOfPolicy)
		throws com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException {

		return getPersistence().findByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, yearOfPolicy);
	}

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @return the matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	public static LeavePolicyMaster fetchByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int yearOfPolicy) {

		return getPersistence().fetchByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, yearOfPolicy);
	}

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	public static LeavePolicyMaster fetchByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int yearOfPolicy, boolean useFinderCache) {

		return getPersistence().fetchByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, yearOfPolicy, useFinderCache);
	}

	/**
	 * Removes the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; from the database.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @return the leave policy master that was removed
	 */
	public static LeavePolicyMaster removeByLeaveTypeMasterIdAndYear(
			long leaveTypeMasterId, int yearOfPolicy)
		throws com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException {

		return getPersistence().removeByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, yearOfPolicy);
	}

	/**
	 * Returns the number of leave policy masters where leaveTypeMasterId = &#63; and yearOfPolicy = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @return the number of matching leave policy masters
	 */
	public static int countByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int yearOfPolicy) {

		return getPersistence().countByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, yearOfPolicy);
	}

	/**
	 * Returns all the leave policy masters where yearOfPolicy = &#63;.
	 *
	 * @param yearOfPolicy the year of policy
	 * @return the matching leave policy masters
	 */
	public static List<LeavePolicyMaster> findByYear(int yearOfPolicy) {
		return getPersistence().findByYear(yearOfPolicy);
	}

	/**
	 * Returns a range of all the leave policy masters where yearOfPolicy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeavePolicyMasterModelImpl</code>.
	 * </p>
	 *
	 * @param yearOfPolicy the year of policy
	 * @param start the lower bound of the range of leave policy masters
	 * @param end the upper bound of the range of leave policy masters (not inclusive)
	 * @return the range of matching leave policy masters
	 */
	public static List<LeavePolicyMaster> findByYear(
		int yearOfPolicy, int start, int end) {

		return getPersistence().findByYear(yearOfPolicy, start, end);
	}

	/**
	 * Returns an ordered range of all the leave policy masters where yearOfPolicy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeavePolicyMasterModelImpl</code>.
	 * </p>
	 *
	 * @param yearOfPolicy the year of policy
	 * @param start the lower bound of the range of leave policy masters
	 * @param end the upper bound of the range of leave policy masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave policy masters
	 */
	public static List<LeavePolicyMaster> findByYear(
		int yearOfPolicy, int start, int end,
		OrderByComparator<LeavePolicyMaster> orderByComparator) {

		return getPersistence().findByYear(
			yearOfPolicy, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave policy masters where yearOfPolicy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeavePolicyMasterModelImpl</code>.
	 * </p>
	 *
	 * @param yearOfPolicy the year of policy
	 * @param start the lower bound of the range of leave policy masters
	 * @param end the upper bound of the range of leave policy masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave policy masters
	 */
	public static List<LeavePolicyMaster> findByYear(
		int yearOfPolicy, int start, int end,
		OrderByComparator<LeavePolicyMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByYear(
			yearOfPolicy, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first leave policy master in the ordered set where yearOfPolicy = &#63;.
	 *
	 * @param yearOfPolicy the year of policy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave policy master
	 * @throws NoSuchLeavePolicyMasterException if a matching leave policy master could not be found
	 */
	public static LeavePolicyMaster findByYear_First(
			int yearOfPolicy,
			OrderByComparator<LeavePolicyMaster> orderByComparator)
		throws com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException {

		return getPersistence().findByYear_First(
			yearOfPolicy, orderByComparator);
	}

	/**
	 * Returns the first leave policy master in the ordered set where yearOfPolicy = &#63;.
	 *
	 * @param yearOfPolicy the year of policy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	public static LeavePolicyMaster fetchByYear_First(
		int yearOfPolicy,
		OrderByComparator<LeavePolicyMaster> orderByComparator) {

		return getPersistence().fetchByYear_First(
			yearOfPolicy, orderByComparator);
	}

	/**
	 * Returns the last leave policy master in the ordered set where yearOfPolicy = &#63;.
	 *
	 * @param yearOfPolicy the year of policy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave policy master
	 * @throws NoSuchLeavePolicyMasterException if a matching leave policy master could not be found
	 */
	public static LeavePolicyMaster findByYear_Last(
			int yearOfPolicy,
			OrderByComparator<LeavePolicyMaster> orderByComparator)
		throws com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException {

		return getPersistence().findByYear_Last(
			yearOfPolicy, orderByComparator);
	}

	/**
	 * Returns the last leave policy master in the ordered set where yearOfPolicy = &#63;.
	 *
	 * @param yearOfPolicy the year of policy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	public static LeavePolicyMaster fetchByYear_Last(
		int yearOfPolicy,
		OrderByComparator<LeavePolicyMaster> orderByComparator) {

		return getPersistence().fetchByYear_Last(
			yearOfPolicy, orderByComparator);
	}

	/**
	 * Returns the leave policy masters before and after the current leave policy master in the ordered set where yearOfPolicy = &#63;.
	 *
	 * @param leavePolicyMasterId the primary key of the current leave policy master
	 * @param yearOfPolicy the year of policy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave policy master
	 * @throws NoSuchLeavePolicyMasterException if a leave policy master with the primary key could not be found
	 */
	public static LeavePolicyMaster[] findByYear_PrevAndNext(
			long leavePolicyMasterId, int yearOfPolicy,
			OrderByComparator<LeavePolicyMaster> orderByComparator)
		throws com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException {

		return getPersistence().findByYear_PrevAndNext(
			leavePolicyMasterId, yearOfPolicy, orderByComparator);
	}

	/**
	 * Removes all the leave policy masters where yearOfPolicy = &#63; from the database.
	 *
	 * @param yearOfPolicy the year of policy
	 */
	public static void removeByYear(int yearOfPolicy) {
		getPersistence().removeByYear(yearOfPolicy);
	}

	/**
	 * Returns the number of leave policy masters where yearOfPolicy = &#63;.
	 *
	 * @param yearOfPolicy the year of policy
	 * @return the number of matching leave policy masters
	 */
	public static int countByYear(int yearOfPolicy) {
		return getPersistence().countByYear(yearOfPolicy);
	}

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; and eligibleAfterMonths = &#63; or throws a <code>NoSuchLeavePolicyMasterException</code> if it could not be found.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @param eligibleAfterMonths the eligible after months
	 * @return the matching leave policy master
	 * @throws NoSuchLeavePolicyMasterException if a matching leave policy master could not be found
	 */
	public static LeavePolicyMaster
			findByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
				long leaveTypeMasterId, int yearOfPolicy,
				int eligibleAfterMonths)
		throws com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException {

		return getPersistence().
			findByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
				leaveTypeMasterId, yearOfPolicy, eligibleAfterMonths);
	}

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; and eligibleAfterMonths = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @param eligibleAfterMonths the eligible after months
	 * @return the matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	public static LeavePolicyMaster
		fetchByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
			long leaveTypeMasterId, int yearOfPolicy, int eligibleAfterMonths) {

		return getPersistence().
			fetchByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
				leaveTypeMasterId, yearOfPolicy, eligibleAfterMonths);
	}

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; and eligibleAfterMonths = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @param eligibleAfterMonths the eligible after months
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	public static LeavePolicyMaster
		fetchByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
			long leaveTypeMasterId, int yearOfPolicy, int eligibleAfterMonths,
			boolean useFinderCache) {

		return getPersistence().
			fetchByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
				leaveTypeMasterId, yearOfPolicy, eligibleAfterMonths,
				useFinderCache);
	}

	/**
	 * Removes the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; and eligibleAfterMonths = &#63; from the database.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @param eligibleAfterMonths the eligible after months
	 * @return the leave policy master that was removed
	 */
	public static LeavePolicyMaster
			removeByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
				long leaveTypeMasterId, int yearOfPolicy,
				int eligibleAfterMonths)
		throws com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException {

		return getPersistence().
			removeByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
				leaveTypeMasterId, yearOfPolicy, eligibleAfterMonths);
	}

	/**
	 * Returns the number of leave policy masters where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; and eligibleAfterMonths = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @param eligibleAfterMonths the eligible after months
	 * @return the number of matching leave policy masters
	 */
	public static int
		countByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
			long leaveTypeMasterId, int yearOfPolicy, int eligibleAfterMonths) {

		return getPersistence().
			countByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
				leaveTypeMasterId, yearOfPolicy, eligibleAfterMonths);
	}

	/**
	 * Caches the leave policy master in the entity cache if it is enabled.
	 *
	 * @param leavePolicyMaster the leave policy master
	 */
	public static void cacheResult(LeavePolicyMaster leavePolicyMaster) {
		getPersistence().cacheResult(leavePolicyMaster);
	}

	/**
	 * Caches the leave policy masters in the entity cache if it is enabled.
	 *
	 * @param leavePolicyMasters the leave policy masters
	 */
	public static void cacheResult(List<LeavePolicyMaster> leavePolicyMasters) {
		getPersistence().cacheResult(leavePolicyMasters);
	}

	/**
	 * Creates a new leave policy master with the primary key. Does not add the leave policy master to the database.
	 *
	 * @param leavePolicyMasterId the primary key for the new leave policy master
	 * @return the new leave policy master
	 */
	public static LeavePolicyMaster create(long leavePolicyMasterId) {
		return getPersistence().create(leavePolicyMasterId);
	}

	/**
	 * Removes the leave policy master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leavePolicyMasterId the primary key of the leave policy master
	 * @return the leave policy master that was removed
	 * @throws NoSuchLeavePolicyMasterException if a leave policy master with the primary key could not be found
	 */
	public static LeavePolicyMaster remove(long leavePolicyMasterId)
		throws com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException {

		return getPersistence().remove(leavePolicyMasterId);
	}

	public static LeavePolicyMaster updateImpl(
		LeavePolicyMaster leavePolicyMaster) {

		return getPersistence().updateImpl(leavePolicyMaster);
	}

	/**
	 * Returns the leave policy master with the primary key or throws a <code>NoSuchLeavePolicyMasterException</code> if it could not be found.
	 *
	 * @param leavePolicyMasterId the primary key of the leave policy master
	 * @return the leave policy master
	 * @throws NoSuchLeavePolicyMasterException if a leave policy master with the primary key could not be found
	 */
	public static LeavePolicyMaster findByPrimaryKey(long leavePolicyMasterId)
		throws com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException {

		return getPersistence().findByPrimaryKey(leavePolicyMasterId);
	}

	/**
	 * Returns the leave policy master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leavePolicyMasterId the primary key of the leave policy master
	 * @return the leave policy master, or <code>null</code> if a leave policy master with the primary key could not be found
	 */
	public static LeavePolicyMaster fetchByPrimaryKey(
		long leavePolicyMasterId) {

		return getPersistence().fetchByPrimaryKey(leavePolicyMasterId);
	}

	/**
	 * Returns all the leave policy masters.
	 *
	 * @return the leave policy masters
	 */
	public static List<LeavePolicyMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the leave policy masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeavePolicyMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave policy masters
	 * @param end the upper bound of the range of leave policy masters (not inclusive)
	 * @return the range of leave policy masters
	 */
	public static List<LeavePolicyMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the leave policy masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeavePolicyMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave policy masters
	 * @param end the upper bound of the range of leave policy masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave policy masters
	 */
	public static List<LeavePolicyMaster> findAll(
		int start, int end,
		OrderByComparator<LeavePolicyMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the leave policy masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeavePolicyMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave policy masters
	 * @param end the upper bound of the range of leave policy masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave policy masters
	 */
	public static List<LeavePolicyMaster> findAll(
		int start, int end,
		OrderByComparator<LeavePolicyMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the leave policy masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of leave policy masters.
	 *
	 * @return the number of leave policy masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LeavePolicyMasterPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		LeavePolicyMasterPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile LeavePolicyMasterPersistence _persistence;

}