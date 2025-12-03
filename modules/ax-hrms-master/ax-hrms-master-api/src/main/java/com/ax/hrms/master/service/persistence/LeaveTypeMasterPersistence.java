/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.exception.NoSuchLeaveTypeMasterException;
import com.ax.hrms.master.model.LeaveTypeMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the leave type master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTypeMasterUtil
 * @generated
 */
@ProviderType
public interface LeaveTypeMasterPersistence
	extends BasePersistence<LeaveTypeMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveTypeMasterUtil} to access the leave type master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the leave type master where leaveTypeName = &#63; or throws a <code>NoSuchLeaveTypeMasterException</code> if it could not be found.
	 *
	 * @param leaveTypeName the leave type name
	 * @return the matching leave type master
	 * @throws NoSuchLeaveTypeMasterException if a matching leave type master could not be found
	 */
	public LeaveTypeMaster findByLeaveTypeName(String leaveTypeName)
		throws NoSuchLeaveTypeMasterException;

	/**
	 * Returns the leave type master where leaveTypeName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveTypeName the leave type name
	 * @return the matching leave type master, or <code>null</code> if a matching leave type master could not be found
	 */
	public LeaveTypeMaster fetchByLeaveTypeName(String leaveTypeName);

	/**
	 * Returns the leave type master where leaveTypeName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveTypeName the leave type name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave type master, or <code>null</code> if a matching leave type master could not be found
	 */
	public LeaveTypeMaster fetchByLeaveTypeName(
		String leaveTypeName, boolean useFinderCache);

	/**
	 * Removes the leave type master where leaveTypeName = &#63; from the database.
	 *
	 * @param leaveTypeName the leave type name
	 * @return the leave type master that was removed
	 */
	public LeaveTypeMaster removeByLeaveTypeName(String leaveTypeName)
		throws NoSuchLeaveTypeMasterException;

	/**
	 * Returns the number of leave type masters where leaveTypeName = &#63;.
	 *
	 * @param leaveTypeName the leave type name
	 * @return the number of matching leave type masters
	 */
	public int countByLeaveTypeName(String leaveTypeName);

	/**
	 * Returns the leave type master where leaveTypeMasterId = &#63; or throws a <code>NoSuchLeaveTypeMasterException</code> if it could not be found.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the matching leave type master
	 * @throws NoSuchLeaveTypeMasterException if a matching leave type master could not be found
	 */
	public LeaveTypeMaster findByLeaveTypeMasterId(long leaveTypeMasterId)
		throws NoSuchLeaveTypeMasterException;

	/**
	 * Returns the leave type master where leaveTypeMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the matching leave type master, or <code>null</code> if a matching leave type master could not be found
	 */
	public LeaveTypeMaster fetchByLeaveTypeMasterId(long leaveTypeMasterId);

	/**
	 * Returns the leave type master where leaveTypeMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave type master, or <code>null</code> if a matching leave type master could not be found
	 */
	public LeaveTypeMaster fetchByLeaveTypeMasterId(
		long leaveTypeMasterId, boolean useFinderCache);

	/**
	 * Removes the leave type master where leaveTypeMasterId = &#63; from the database.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the leave type master that was removed
	 */
	public LeaveTypeMaster removeByLeaveTypeMasterId(long leaveTypeMasterId)
		throws NoSuchLeaveTypeMasterException;

	/**
	 * Returns the number of leave type masters where leaveTypeMasterId = &#63;.
	 *
	 * @param leaveTypeMasterId the leave type master ID
	 * @return the number of matching leave type masters
	 */
	public int countByLeaveTypeMasterId(long leaveTypeMasterId);

	/**
	 * Returns all the leave type masters where isActive = &#63; and isAppearForAll = &#63;.
	 *
	 * @param isActive the is active
	 * @param isAppearForAll the is appear for all
	 * @return the matching leave type masters
	 */
	public java.util.List<LeaveTypeMaster> findByActiveAndAppearForAll(
		boolean isActive, boolean isAppearForAll);

	/**
	 * Returns a range of all the leave type masters where isActive = &#63; and isAppearForAll = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param isAppearForAll the is appear for all
	 * @param start the lower bound of the range of leave type masters
	 * @param end the upper bound of the range of leave type masters (not inclusive)
	 * @return the range of matching leave type masters
	 */
	public java.util.List<LeaveTypeMaster> findByActiveAndAppearForAll(
		boolean isActive, boolean isAppearForAll, int start, int end);

	/**
	 * Returns an ordered range of all the leave type masters where isActive = &#63; and isAppearForAll = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param isAppearForAll the is appear for all
	 * @param start the lower bound of the range of leave type masters
	 * @param end the upper bound of the range of leave type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leave type masters
	 */
	public java.util.List<LeaveTypeMaster> findByActiveAndAppearForAll(
		boolean isActive, boolean isAppearForAll, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave type masters where isActive = &#63; and isAppearForAll = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param isAppearForAll the is appear for all
	 * @param start the lower bound of the range of leave type masters
	 * @param end the upper bound of the range of leave type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leave type masters
	 */
	public java.util.List<LeaveTypeMaster> findByActiveAndAppearForAll(
		boolean isActive, boolean isAppearForAll, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first leave type master in the ordered set where isActive = &#63; and isAppearForAll = &#63;.
	 *
	 * @param isActive the is active
	 * @param isAppearForAll the is appear for all
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type master
	 * @throws NoSuchLeaveTypeMasterException if a matching leave type master could not be found
	 */
	public LeaveTypeMaster findByActiveAndAppearForAll_First(
			boolean isActive, boolean isAppearForAll,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveTypeMaster>
				orderByComparator)
		throws NoSuchLeaveTypeMasterException;

	/**
	 * Returns the first leave type master in the ordered set where isActive = &#63; and isAppearForAll = &#63;.
	 *
	 * @param isActive the is active
	 * @param isAppearForAll the is appear for all
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leave type master, or <code>null</code> if a matching leave type master could not be found
	 */
	public LeaveTypeMaster fetchByActiveAndAppearForAll_First(
		boolean isActive, boolean isAppearForAll,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypeMaster>
			orderByComparator);

	/**
	 * Returns the last leave type master in the ordered set where isActive = &#63; and isAppearForAll = &#63;.
	 *
	 * @param isActive the is active
	 * @param isAppearForAll the is appear for all
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type master
	 * @throws NoSuchLeaveTypeMasterException if a matching leave type master could not be found
	 */
	public LeaveTypeMaster findByActiveAndAppearForAll_Last(
			boolean isActive, boolean isAppearForAll,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveTypeMaster>
				orderByComparator)
		throws NoSuchLeaveTypeMasterException;

	/**
	 * Returns the last leave type master in the ordered set where isActive = &#63; and isAppearForAll = &#63;.
	 *
	 * @param isActive the is active
	 * @param isAppearForAll the is appear for all
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leave type master, or <code>null</code> if a matching leave type master could not be found
	 */
	public LeaveTypeMaster fetchByActiveAndAppearForAll_Last(
		boolean isActive, boolean isAppearForAll,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypeMaster>
			orderByComparator);

	/**
	 * Returns the leave type masters before and after the current leave type master in the ordered set where isActive = &#63; and isAppearForAll = &#63;.
	 *
	 * @param leaveTypeMasterId the primary key of the current leave type master
	 * @param isActive the is active
	 * @param isAppearForAll the is appear for all
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leave type master
	 * @throws NoSuchLeaveTypeMasterException if a leave type master with the primary key could not be found
	 */
	public LeaveTypeMaster[] findByActiveAndAppearForAll_PrevAndNext(
			long leaveTypeMasterId, boolean isActive, boolean isAppearForAll,
			com.liferay.portal.kernel.util.OrderByComparator<LeaveTypeMaster>
				orderByComparator)
		throws NoSuchLeaveTypeMasterException;

	/**
	 * Removes all the leave type masters where isActive = &#63; and isAppearForAll = &#63; from the database.
	 *
	 * @param isActive the is active
	 * @param isAppearForAll the is appear for all
	 */
	public void removeByActiveAndAppearForAll(
		boolean isActive, boolean isAppearForAll);

	/**
	 * Returns the number of leave type masters where isActive = &#63; and isAppearForAll = &#63;.
	 *
	 * @param isActive the is active
	 * @param isAppearForAll the is appear for all
	 * @return the number of matching leave type masters
	 */
	public int countByActiveAndAppearForAll(
		boolean isActive, boolean isAppearForAll);

	/**
	 * Caches the leave type master in the entity cache if it is enabled.
	 *
	 * @param leaveTypeMaster the leave type master
	 */
	public void cacheResult(LeaveTypeMaster leaveTypeMaster);

	/**
	 * Caches the leave type masters in the entity cache if it is enabled.
	 *
	 * @param leaveTypeMasters the leave type masters
	 */
	public void cacheResult(java.util.List<LeaveTypeMaster> leaveTypeMasters);

	/**
	 * Creates a new leave type master with the primary key. Does not add the leave type master to the database.
	 *
	 * @param leaveTypeMasterId the primary key for the new leave type master
	 * @return the new leave type master
	 */
	public LeaveTypeMaster create(long leaveTypeMasterId);

	/**
	 * Removes the leave type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveTypeMasterId the primary key of the leave type master
	 * @return the leave type master that was removed
	 * @throws NoSuchLeaveTypeMasterException if a leave type master with the primary key could not be found
	 */
	public LeaveTypeMaster remove(long leaveTypeMasterId)
		throws NoSuchLeaveTypeMasterException;

	public LeaveTypeMaster updateImpl(LeaveTypeMaster leaveTypeMaster);

	/**
	 * Returns the leave type master with the primary key or throws a <code>NoSuchLeaveTypeMasterException</code> if it could not be found.
	 *
	 * @param leaveTypeMasterId the primary key of the leave type master
	 * @return the leave type master
	 * @throws NoSuchLeaveTypeMasterException if a leave type master with the primary key could not be found
	 */
	public LeaveTypeMaster findByPrimaryKey(long leaveTypeMasterId)
		throws NoSuchLeaveTypeMasterException;

	/**
	 * Returns the leave type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveTypeMasterId the primary key of the leave type master
	 * @return the leave type master, or <code>null</code> if a leave type master with the primary key could not be found
	 */
	public LeaveTypeMaster fetchByPrimaryKey(long leaveTypeMasterId);

	/**
	 * Returns all the leave type masters.
	 *
	 * @return the leave type masters
	 */
	public java.util.List<LeaveTypeMaster> findAll();

	/**
	 * Returns a range of all the leave type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave type masters
	 * @param end the upper bound of the range of leave type masters (not inclusive)
	 * @return the range of leave type masters
	 */
	public java.util.List<LeaveTypeMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the leave type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave type masters
	 * @param end the upper bound of the range of leave type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave type masters
	 */
	public java.util.List<LeaveTypeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the leave type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeaveTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave type masters
	 * @param end the upper bound of the range of leave type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leave type masters
	 */
	public java.util.List<LeaveTypeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LeaveTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the leave type masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of leave type masters.
	 *
	 * @return the number of leave type masters
	 */
	public int countAll();

}