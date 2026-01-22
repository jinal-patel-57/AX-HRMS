/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.exception.NoSuchBranchMasterException;
import com.ax.hrms.master.model.BranchMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the branch master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BranchMasterUtil
 * @generated
 */
@ProviderType
public interface BranchMasterPersistence extends BasePersistence<BranchMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BranchMasterUtil} to access the branch master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the branch master in the entity cache if it is enabled.
	 *
	 * @param branchMaster the branch master
	 */
	public void cacheResult(BranchMaster branchMaster);

	/**
	 * Caches the branch masters in the entity cache if it is enabled.
	 *
	 * @param branchMasters the branch masters
	 */
	public void cacheResult(java.util.List<BranchMaster> branchMasters);

	/**
	 * Creates a new branch master with the primary key. Does not add the branch master to the database.
	 *
	 * @param branchMasterId the primary key for the new branch master
	 * @return the new branch master
	 */
	public BranchMaster create(long branchMasterId);

	/**
	 * Removes the branch master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param branchMasterId the primary key of the branch master
	 * @return the branch master that was removed
	 * @throws NoSuchBranchMasterException if a branch master with the primary key could not be found
	 */
	public BranchMaster remove(long branchMasterId)
		throws NoSuchBranchMasterException;

	public BranchMaster updateImpl(BranchMaster branchMaster);

	/**
	 * Returns the branch master with the primary key or throws a <code>NoSuchBranchMasterException</code> if it could not be found.
	 *
	 * @param branchMasterId the primary key of the branch master
	 * @return the branch master
	 * @throws NoSuchBranchMasterException if a branch master with the primary key could not be found
	 */
	public BranchMaster findByPrimaryKey(long branchMasterId)
		throws NoSuchBranchMasterException;

	/**
	 * Returns the branch master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param branchMasterId the primary key of the branch master
	 * @return the branch master, or <code>null</code> if a branch master with the primary key could not be found
	 */
	public BranchMaster fetchByPrimaryKey(long branchMasterId);

	/**
	 * Returns all the branch masters.
	 *
	 * @return the branch masters
	 */
	public java.util.List<BranchMaster> findAll();

	/**
	 * Returns a range of all the branch masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of branch masters
	 * @param end the upper bound of the range of branch masters (not inclusive)
	 * @return the range of branch masters
	 */
	public java.util.List<BranchMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the branch masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of branch masters
	 * @param end the upper bound of the range of branch masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of branch masters
	 */
	public java.util.List<BranchMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BranchMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the branch masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of branch masters
	 * @param end the upper bound of the range of branch masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of branch masters
	 */
	public java.util.List<BranchMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BranchMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the branch masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of branch masters.
	 *
	 * @return the number of branch masters
	 */
	public int countAll();

}