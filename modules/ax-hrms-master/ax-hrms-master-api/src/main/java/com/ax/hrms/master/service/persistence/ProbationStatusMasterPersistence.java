/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.exception.NoSuchProbationStatusMasterException;
import com.ax.hrms.master.model.ProbationStatusMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the probation status master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProbationStatusMasterUtil
 * @generated
 */
@ProviderType
public interface ProbationStatusMasterPersistence
	extends BasePersistence<ProbationStatusMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProbationStatusMasterUtil} to access the probation status master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the probation status master where statusType = &#63; or throws a <code>NoSuchProbationStatusMasterException</code> if it could not be found.
	 *
	 * @param statusType the status type
	 * @return the matching probation status master
	 * @throws NoSuchProbationStatusMasterException if a matching probation status master could not be found
	 */
	public ProbationStatusMaster findByStatusType(String statusType)
		throws NoSuchProbationStatusMasterException;

	/**
	 * Returns the probation status master where statusType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param statusType the status type
	 * @return the matching probation status master, or <code>null</code> if a matching probation status master could not be found
	 */
	public ProbationStatusMaster fetchByStatusType(String statusType);

	/**
	 * Returns the probation status master where statusType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param statusType the status type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching probation status master, or <code>null</code> if a matching probation status master could not be found
	 */
	public ProbationStatusMaster fetchByStatusType(
		String statusType, boolean useFinderCache);

	/**
	 * Removes the probation status master where statusType = &#63; from the database.
	 *
	 * @param statusType the status type
	 * @return the probation status master that was removed
	 */
	public ProbationStatusMaster removeByStatusType(String statusType)
		throws NoSuchProbationStatusMasterException;

	/**
	 * Returns the number of probation status masters where statusType = &#63;.
	 *
	 * @param statusType the status type
	 * @return the number of matching probation status masters
	 */
	public int countByStatusType(String statusType);

	/**
	 * Caches the probation status master in the entity cache if it is enabled.
	 *
	 * @param probationStatusMaster the probation status master
	 */
	public void cacheResult(ProbationStatusMaster probationStatusMaster);

	/**
	 * Caches the probation status masters in the entity cache if it is enabled.
	 *
	 * @param probationStatusMasters the probation status masters
	 */
	public void cacheResult(
		java.util.List<ProbationStatusMaster> probationStatusMasters);

	/**
	 * Creates a new probation status master with the primary key. Does not add the probation status master to the database.
	 *
	 * @param probationStatusMasterId the primary key for the new probation status master
	 * @return the new probation status master
	 */
	public ProbationStatusMaster create(long probationStatusMasterId);

	/**
	 * Removes the probation status master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param probationStatusMasterId the primary key of the probation status master
	 * @return the probation status master that was removed
	 * @throws NoSuchProbationStatusMasterException if a probation status master with the primary key could not be found
	 */
	public ProbationStatusMaster remove(long probationStatusMasterId)
		throws NoSuchProbationStatusMasterException;

	public ProbationStatusMaster updateImpl(
		ProbationStatusMaster probationStatusMaster);

	/**
	 * Returns the probation status master with the primary key or throws a <code>NoSuchProbationStatusMasterException</code> if it could not be found.
	 *
	 * @param probationStatusMasterId the primary key of the probation status master
	 * @return the probation status master
	 * @throws NoSuchProbationStatusMasterException if a probation status master with the primary key could not be found
	 */
	public ProbationStatusMaster findByPrimaryKey(long probationStatusMasterId)
		throws NoSuchProbationStatusMasterException;

	/**
	 * Returns the probation status master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param probationStatusMasterId the primary key of the probation status master
	 * @return the probation status master, or <code>null</code> if a probation status master with the primary key could not be found
	 */
	public ProbationStatusMaster fetchByPrimaryKey(
		long probationStatusMasterId);

	/**
	 * Returns all the probation status masters.
	 *
	 * @return the probation status masters
	 */
	public java.util.List<ProbationStatusMaster> findAll();

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
	public java.util.List<ProbationStatusMaster> findAll(int start, int end);

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
	public java.util.List<ProbationStatusMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProbationStatusMaster>
			orderByComparator);

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
	public java.util.List<ProbationStatusMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProbationStatusMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the probation status masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of probation status masters.
	 *
	 * @return the number of probation status masters
	 */
	public int countAll();

}