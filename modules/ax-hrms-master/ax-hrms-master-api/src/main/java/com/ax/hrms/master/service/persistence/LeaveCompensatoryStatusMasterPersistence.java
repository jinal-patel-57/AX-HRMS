/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.exception.NoSuchLeaveCompensatoryStatusMasterException;
import com.ax.hrms.master.model.LeaveCompensatoryStatusMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the leave compensatory status master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveCompensatoryStatusMasterUtil
 * @generated
 */
@ProviderType
public interface LeaveCompensatoryStatusMasterPersistence
	extends BasePersistence<LeaveCompensatoryStatusMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveCompensatoryStatusMasterUtil} to access the leave compensatory status master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the leave compensatory status master where leaveCompensatoryStatus = &#63; or throws a <code>NoSuchLeaveCompensatoryStatusMasterException</code> if it could not be found.
	 *
	 * @param leaveCompensatoryStatus the leave compensatory status
	 * @return the matching leave compensatory status master
	 * @throws NoSuchLeaveCompensatoryStatusMasterException if a matching leave compensatory status master could not be found
	 */
	public LeaveCompensatoryStatusMaster findByLeaveCompensatoryStatus(
			String leaveCompensatoryStatus)
		throws NoSuchLeaveCompensatoryStatusMasterException;

	/**
	 * Returns the leave compensatory status master where leaveCompensatoryStatus = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveCompensatoryStatus the leave compensatory status
	 * @return the matching leave compensatory status master, or <code>null</code> if a matching leave compensatory status master could not be found
	 */
	public LeaveCompensatoryStatusMaster fetchByLeaveCompensatoryStatus(
		String leaveCompensatoryStatus);

	/**
	 * Returns the leave compensatory status master where leaveCompensatoryStatus = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveCompensatoryStatus the leave compensatory status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave compensatory status master, or <code>null</code> if a matching leave compensatory status master could not be found
	 */
	public LeaveCompensatoryStatusMaster fetchByLeaveCompensatoryStatus(
		String leaveCompensatoryStatus, boolean useFinderCache);

	/**
	 * Removes the leave compensatory status master where leaveCompensatoryStatus = &#63; from the database.
	 *
	 * @param leaveCompensatoryStatus the leave compensatory status
	 * @return the leave compensatory status master that was removed
	 */
	public LeaveCompensatoryStatusMaster removeByLeaveCompensatoryStatus(
			String leaveCompensatoryStatus)
		throws NoSuchLeaveCompensatoryStatusMasterException;

	/**
	 * Returns the number of leave compensatory status masters where leaveCompensatoryStatus = &#63;.
	 *
	 * @param leaveCompensatoryStatus the leave compensatory status
	 * @return the number of matching leave compensatory status masters
	 */
	public int countByLeaveCompensatoryStatus(String leaveCompensatoryStatus);

	/**
	 * Returns the leave compensatory status master where leaveCompensatoryStatusMasterId = &#63; or throws a <code>NoSuchLeaveCompensatoryStatusMasterException</code> if it could not be found.
	 *
	 * @param leaveCompensatoryStatusMasterId the leave compensatory status master ID
	 * @return the matching leave compensatory status master
	 * @throws NoSuchLeaveCompensatoryStatusMasterException if a matching leave compensatory status master could not be found
	 */
	public LeaveCompensatoryStatusMaster findByLeaveCompensatoryStatusById(
			long leaveCompensatoryStatusMasterId)
		throws NoSuchLeaveCompensatoryStatusMasterException;

	/**
	 * Returns the leave compensatory status master where leaveCompensatoryStatusMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveCompensatoryStatusMasterId the leave compensatory status master ID
	 * @return the matching leave compensatory status master, or <code>null</code> if a matching leave compensatory status master could not be found
	 */
	public LeaveCompensatoryStatusMaster fetchByLeaveCompensatoryStatusById(
		long leaveCompensatoryStatusMasterId);

	/**
	 * Returns the leave compensatory status master where leaveCompensatoryStatusMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveCompensatoryStatusMasterId the leave compensatory status master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leave compensatory status master, or <code>null</code> if a matching leave compensatory status master could not be found
	 */
	public LeaveCompensatoryStatusMaster fetchByLeaveCompensatoryStatusById(
		long leaveCompensatoryStatusMasterId, boolean useFinderCache);

	/**
	 * Removes the leave compensatory status master where leaveCompensatoryStatusMasterId = &#63; from the database.
	 *
	 * @param leaveCompensatoryStatusMasterId the leave compensatory status master ID
	 * @return the leave compensatory status master that was removed
	 */
	public LeaveCompensatoryStatusMaster removeByLeaveCompensatoryStatusById(
			long leaveCompensatoryStatusMasterId)
		throws NoSuchLeaveCompensatoryStatusMasterException;

	/**
	 * Returns the number of leave compensatory status masters where leaveCompensatoryStatusMasterId = &#63;.
	 *
	 * @param leaveCompensatoryStatusMasterId the leave compensatory status master ID
	 * @return the number of matching leave compensatory status masters
	 */
	public int countByLeaveCompensatoryStatusById(
		long leaveCompensatoryStatusMasterId);

	/**
	 * Caches the leave compensatory status master in the entity cache if it is enabled.
	 *
	 * @param leaveCompensatoryStatusMaster the leave compensatory status master
	 */
	public void cacheResult(
		LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster);

	/**
	 * Caches the leave compensatory status masters in the entity cache if it is enabled.
	 *
	 * @param leaveCompensatoryStatusMasters the leave compensatory status masters
	 */
	public void cacheResult(
		java.util.List<LeaveCompensatoryStatusMaster>
			leaveCompensatoryStatusMasters);

	/**
	 * Creates a new leave compensatory status master with the primary key. Does not add the leave compensatory status master to the database.
	 *
	 * @param leaveCompensatoryStatusMasterId the primary key for the new leave compensatory status master
	 * @return the new leave compensatory status master
	 */
	public LeaveCompensatoryStatusMaster create(
		long leaveCompensatoryStatusMasterId);

	/**
	 * Removes the leave compensatory status master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveCompensatoryStatusMasterId the primary key of the leave compensatory status master
	 * @return the leave compensatory status master that was removed
	 * @throws NoSuchLeaveCompensatoryStatusMasterException if a leave compensatory status master with the primary key could not be found
	 */
	public LeaveCompensatoryStatusMaster remove(
			long leaveCompensatoryStatusMasterId)
		throws NoSuchLeaveCompensatoryStatusMasterException;

	public LeaveCompensatoryStatusMaster updateImpl(
		LeaveCompensatoryStatusMaster leaveCompensatoryStatusMaster);

	/**
	 * Returns the leave compensatory status master with the primary key or throws a <code>NoSuchLeaveCompensatoryStatusMasterException</code> if it could not be found.
	 *
	 * @param leaveCompensatoryStatusMasterId the primary key of the leave compensatory status master
	 * @return the leave compensatory status master
	 * @throws NoSuchLeaveCompensatoryStatusMasterException if a leave compensatory status master with the primary key could not be found
	 */
	public LeaveCompensatoryStatusMaster findByPrimaryKey(
			long leaveCompensatoryStatusMasterId)
		throws NoSuchLeaveCompensatoryStatusMasterException;

	/**
	 * Returns the leave compensatory status master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveCompensatoryStatusMasterId the primary key of the leave compensatory status master
	 * @return the leave compensatory status master, or <code>null</code> if a leave compensatory status master with the primary key could not be found
	 */
	public LeaveCompensatoryStatusMaster fetchByPrimaryKey(
		long leaveCompensatoryStatusMasterId);

	/**
	 * Returns all the leave compensatory status masters.
	 *
	 * @return the leave compensatory status masters
	 */
	public java.util.List<LeaveCompensatoryStatusMaster> findAll();

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
	public java.util.List<LeaveCompensatoryStatusMaster> findAll(
		int start, int end);

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
	public java.util.List<LeaveCompensatoryStatusMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<LeaveCompensatoryStatusMaster> orderByComparator);

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
	public java.util.List<LeaveCompensatoryStatusMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<LeaveCompensatoryStatusMaster> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the leave compensatory status masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of leave compensatory status masters.
	 *
	 * @return the number of leave compensatory status masters
	 */
	public int countAll();

}