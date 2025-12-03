/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.exception.NoSuchPriorityMasterException;
import com.ax.hrms.master.model.PriorityMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the priority master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PriorityMasterUtil
 * @generated
 */
@ProviderType
public interface PriorityMasterPersistence
	extends BasePersistence<PriorityMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PriorityMasterUtil} to access the priority master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the priority master where priorityName = &#63; or throws a <code>NoSuchPriorityMasterException</code> if it could not be found.
	 *
	 * @param priorityName the priority name
	 * @return the matching priority master
	 * @throws NoSuchPriorityMasterException if a matching priority master could not be found
	 */
	public PriorityMaster findByPriorityName(String priorityName)
		throws NoSuchPriorityMasterException;

	/**
	 * Returns the priority master where priorityName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param priorityName the priority name
	 * @return the matching priority master, or <code>null</code> if a matching priority master could not be found
	 */
	public PriorityMaster fetchByPriorityName(String priorityName);

	/**
	 * Returns the priority master where priorityName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param priorityName the priority name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching priority master, or <code>null</code> if a matching priority master could not be found
	 */
	public PriorityMaster fetchByPriorityName(
		String priorityName, boolean useFinderCache);

	/**
	 * Removes the priority master where priorityName = &#63; from the database.
	 *
	 * @param priorityName the priority name
	 * @return the priority master that was removed
	 */
	public PriorityMaster removeByPriorityName(String priorityName)
		throws NoSuchPriorityMasterException;

	/**
	 * Returns the number of priority masters where priorityName = &#63;.
	 *
	 * @param priorityName the priority name
	 * @return the number of matching priority masters
	 */
	public int countByPriorityName(String priorityName);

	/**
	 * Caches the priority master in the entity cache if it is enabled.
	 *
	 * @param priorityMaster the priority master
	 */
	public void cacheResult(PriorityMaster priorityMaster);

	/**
	 * Caches the priority masters in the entity cache if it is enabled.
	 *
	 * @param priorityMasters the priority masters
	 */
	public void cacheResult(java.util.List<PriorityMaster> priorityMasters);

	/**
	 * Creates a new priority master with the primary key. Does not add the priority master to the database.
	 *
	 * @param priorityMasterId the primary key for the new priority master
	 * @return the new priority master
	 */
	public PriorityMaster create(long priorityMasterId);

	/**
	 * Removes the priority master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param priorityMasterId the primary key of the priority master
	 * @return the priority master that was removed
	 * @throws NoSuchPriorityMasterException if a priority master with the primary key could not be found
	 */
	public PriorityMaster remove(long priorityMasterId)
		throws NoSuchPriorityMasterException;

	public PriorityMaster updateImpl(PriorityMaster priorityMaster);

	/**
	 * Returns the priority master with the primary key or throws a <code>NoSuchPriorityMasterException</code> if it could not be found.
	 *
	 * @param priorityMasterId the primary key of the priority master
	 * @return the priority master
	 * @throws NoSuchPriorityMasterException if a priority master with the primary key could not be found
	 */
	public PriorityMaster findByPrimaryKey(long priorityMasterId)
		throws NoSuchPriorityMasterException;

	/**
	 * Returns the priority master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param priorityMasterId the primary key of the priority master
	 * @return the priority master, or <code>null</code> if a priority master with the primary key could not be found
	 */
	public PriorityMaster fetchByPrimaryKey(long priorityMasterId);

	/**
	 * Returns all the priority masters.
	 *
	 * @return the priority masters
	 */
	public java.util.List<PriorityMaster> findAll();

	/**
	 * Returns a range of all the priority masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of priority masters
	 * @param end the upper bound of the range of priority masters (not inclusive)
	 * @return the range of priority masters
	 */
	public java.util.List<PriorityMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the priority masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of priority masters
	 * @param end the upper bound of the range of priority masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of priority masters
	 */
	public java.util.List<PriorityMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PriorityMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the priority masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of priority masters
	 * @param end the upper bound of the range of priority masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of priority masters
	 */
	public java.util.List<PriorityMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PriorityMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the priority masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of priority masters.
	 *
	 * @return the number of priority masters
	 */
	public int countAll();

}