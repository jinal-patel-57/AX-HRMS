/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException;
import com.ax.hrms.master.model.LeavePolicyMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the leave policy master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeavePolicyMasterUtil
 * @generated
 */
@ProviderType
public interface LeavePolicyMasterPersistence
	extends BasePersistence<LeavePolicyMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeavePolicyMasterUtil} to access the leave policy master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; or throws a <code>NoSuchLeavePolicyMasterException</code> if it could not be found.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the matching leave policy master
	 * @throws NoSuchLeavePolicyMasterException if a matching leave policy master could not be found
	 */
	public LeavePolicyMaster findByLeaveTypeMasterId(long leaveTypeMasterId)
		throws NoSuchLeavePolicyMasterException;

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	public LeavePolicyMaster fetchByLeaveTypeMasterId(long leaveTypeMasterId);

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	public LeavePolicyMaster fetchByLeaveTypeMasterId(
		long leaveTypeMasterId, boolean useFinderCache);

	/**
	 * Removes the leave policy master where leaveTypeMasterId = &#63; from the database.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the leave policy master that was removed
	 */
	public LeavePolicyMaster removeByLeaveTypeMasterId(long leaveTypeMasterId)
		throws NoSuchLeavePolicyMasterException;

	/**
	 * Returns the number of leave policy masters where leaveTypeMasterId = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the number of matching leave policy masters
	 */
	public int countByLeaveTypeMasterId(long leaveTypeMasterId);

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; or throws a <code>NoSuchLeavePolicyMasterException</code> if it could not be found.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @return the matching leave policy master
	 * @throws NoSuchLeavePolicyMasterException if a matching leave policy master could not be found
	 */
	public LeavePolicyMaster findByLeaveTypeMasterIdAndYear(
			long leaveTypeMasterId, int yearOfPolicy)
		throws NoSuchLeavePolicyMasterException;

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @return the matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	public LeavePolicyMaster fetchByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int yearOfPolicy);

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	public LeavePolicyMaster fetchByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int yearOfPolicy, boolean useFinderCache);

	/**
	 * Removes the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; from the database.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @return the leave policy master that was removed
	 */
	public LeavePolicyMaster removeByLeaveTypeMasterIdAndYear(
			long leaveTypeMasterId, int yearOfPolicy)
		throws NoSuchLeavePolicyMasterException;

	/**
	 * Returns the number of leave policy masters where leaveTypeMasterId = &#63; and yearOfPolicy = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @return the number of matching leave policy masters
	 */
	public int countByLeaveTypeMasterIdAndYear(
		long leaveTypeMasterId, int yearOfPolicy);

	/**
	 * Returns all the leave policy masters where yearOfPolicy = &#63;.
	 *
	 * @param yearOfPolicy the year of policy
	 * @return the matching leave policy masters
	 */
	public java.util.List<LeavePolicyMaster> findByYear(int yearOfPolicy);

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
	public java.util.List<LeavePolicyMaster> findByYear(
		int yearOfPolicy, int start, int end);

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
	public java.util.List<LeavePolicyMaster> findByYear(
		int yearOfPolicy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeavePolicyMaster>
			orderByComparator);

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
	public java.util.List<LeavePolicyMaster> findByYear(
		int yearOfPolicy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeavePolicyMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave policy master in the ordered set where yearOfPolicy = &#63;.
	 *
	 * @param yearOfPolicy the year of policy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave policy master
	 * @throws NoSuchLeavePolicyMasterException if a matching leave policy master could not be found
	 */
	public LeavePolicyMaster findByYear_First(
			int yearOfPolicy,
			com.liferay.portal.kernel.util.OrderByComparator<LeavePolicyMaster>
				orderByComparator)
		throws NoSuchLeavePolicyMasterException;

	/**
	 * Returns the first leave policy master in the ordered set where yearOfPolicy = &#63;.
	 *
	 * @param yearOfPolicy the year of policy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	public LeavePolicyMaster fetchByYear_First(
		int yearOfPolicy,
		com.liferay.portal.kernel.util.OrderByComparator<LeavePolicyMaster>
			orderByComparator);

	/**
	 * Returns the last leave policy master in the ordered set where yearOfPolicy = &#63;.
	 *
	 * @param yearOfPolicy the year of policy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave policy master
	 * @throws NoSuchLeavePolicyMasterException if a matching leave policy master could not be found
	 */
	public LeavePolicyMaster findByYear_Last(
			int yearOfPolicy,
			com.liferay.portal.kernel.util.OrderByComparator<LeavePolicyMaster>
				orderByComparator)
		throws NoSuchLeavePolicyMasterException;

	/**
	 * Returns the last leave policy master in the ordered set where yearOfPolicy = &#63;.
	 *
	 * @param yearOfPolicy the year of policy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	public LeavePolicyMaster fetchByYear_Last(
		int yearOfPolicy,
		com.liferay.portal.kernel.util.OrderByComparator<LeavePolicyMaster>
			orderByComparator);

	/**
	 * Returns the leave policy masters before and after the current leave policy master in the ordered set where yearOfPolicy = &#63;.
	 *
	 * @param leavePolicyMasterId the primary key of the current leave policy master
	 * @param yearOfPolicy the year of policy
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave policy master
	 * @throws NoSuchLeavePolicyMasterException if a leave policy master with the primary key could not be found
	 */
	public LeavePolicyMaster[] findByYear_PrevAndNext(
			long leavePolicyMasterId, int yearOfPolicy,
			com.liferay.portal.kernel.util.OrderByComparator<LeavePolicyMaster>
				orderByComparator)
		throws NoSuchLeavePolicyMasterException;

	/**
	 * Removes all the leave policy masters where yearOfPolicy = &#63; from the database.
	 *
	 * @param yearOfPolicy the year of policy
	 */
	public void removeByYear(int yearOfPolicy);

	/**
	 * Returns the number of leave policy masters where yearOfPolicy = &#63;.
	 *
	 * @param yearOfPolicy the year of policy
	 * @return the number of matching leave policy masters
	 */
	public int countByYear(int yearOfPolicy);

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; and eligibleAfterMonths = &#63; or throws a <code>NoSuchLeavePolicyMasterException</code> if it could not be found.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @param eligibleAfterMonths the eligible after months
	 * @return the matching leave policy master
	 * @throws NoSuchLeavePolicyMasterException if a matching leave policy master could not be found
	 */
	public LeavePolicyMaster
			findByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
				long leaveTypeMasterId, int yearOfPolicy,
				int eligibleAfterMonths)
		throws NoSuchLeavePolicyMasterException;

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; and eligibleAfterMonths = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @param eligibleAfterMonths the eligible after months
	 * @return the matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	public LeavePolicyMaster
		fetchByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
			long leaveTypeMasterId, int yearOfPolicy, int eligibleAfterMonths);

	/**
	 * Returns the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; and eligibleAfterMonths = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @param eligibleAfterMonths the eligible after months
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave policy master, or <code>null</code> if a matching leave policy master could not be found
	 */
	public LeavePolicyMaster
		fetchByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
			long leaveTypeMasterId, int yearOfPolicy, int eligibleAfterMonths,
			boolean useFinderCache);

	/**
	 * Removes the leave policy master where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; and eligibleAfterMonths = &#63; from the database.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @param eligibleAfterMonths the eligible after months
	 * @return the leave policy master that was removed
	 */
	public LeavePolicyMaster
			removeByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
				long leaveTypeMasterId, int yearOfPolicy,
				int eligibleAfterMonths)
		throws NoSuchLeavePolicyMasterException;

	/**
	 * Returns the number of leave policy masters where leaveTypeMasterId = &#63; and yearOfPolicy = &#63; and eligibleAfterMonths = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param yearOfPolicy the year of policy
	 * @param eligibleAfterMonths the eligible after months
	 * @return the number of matching leave policy masters
	 */
	public int countByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
		long leaveTypeMasterId, int yearOfPolicy, int eligibleAfterMonths);

	/**
	 * Caches the leave policy master in the entity cache if it is enabled.
	 *
	 * @param leavePolicyMaster the leave policy master
	 */
	public void cacheResult(LeavePolicyMaster leavePolicyMaster);

	/**
	 * Caches the leave policy masters in the entity cache if it is enabled.
	 *
	 * @param leavePolicyMasters the leave policy masters
	 */
	public void cacheResult(
		java.util.List<LeavePolicyMaster> leavePolicyMasters);

	/**
	 * Creates a new leave policy master with the primary key. Does not add the leave policy master to the database.
	 *
	 * @param leavePolicyMasterId the primary key for the new leave policy master
	 * @return the new leave policy master
	 */
	public LeavePolicyMaster create(long leavePolicyMasterId);

	/**
	 * Removes the leave policy master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leavePolicyMasterId the primary key of the leave policy master
	 * @return the leave policy master that was removed
	 * @throws NoSuchLeavePolicyMasterException if a leave policy master with the primary key could not be found
	 */
	public LeavePolicyMaster remove(long leavePolicyMasterId)
		throws NoSuchLeavePolicyMasterException;

	public LeavePolicyMaster updateImpl(LeavePolicyMaster leavePolicyMaster);

	/**
	 * Returns the leave policy master with the primary key or throws a <code>NoSuchLeavePolicyMasterException</code> if it could not be found.
	 *
	 * @param leavePolicyMasterId the primary key of the leave policy master
	 * @return the leave policy master
	 * @throws NoSuchLeavePolicyMasterException if a leave policy master with the primary key could not be found
	 */
	public LeavePolicyMaster findByPrimaryKey(long leavePolicyMasterId)
		throws NoSuchLeavePolicyMasterException;

	/**
	 * Returns the leave policy master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leavePolicyMasterId the primary key of the leave policy master
	 * @return the leave policy master, or <code>null</code> if a leave policy master with the primary key could not be found
	 */
	public LeavePolicyMaster fetchByPrimaryKey(long leavePolicyMasterId);

	/**
	 * Returns all the leave policy masters.
	 *
	 * @return the leave policy masters
	 */
	public java.util.List<LeavePolicyMaster> findAll();

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
	public java.util.List<LeavePolicyMaster> findAll(int start, int end);

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
	public java.util.List<LeavePolicyMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeavePolicyMaster>
			orderByComparator);

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
	public java.util.List<LeavePolicyMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeavePolicyMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the leave policy masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of leave policy masters.
	 *
	 * @return the number of leave policy masters
	 */
	public int countAll();

}