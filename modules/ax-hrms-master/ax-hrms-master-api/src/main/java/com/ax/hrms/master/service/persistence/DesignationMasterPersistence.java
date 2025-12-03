/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.exception.NoSuchDesignationMasterException;
import com.ax.hrms.master.model.DesignationMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the designation master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DesignationMasterUtil
 * @generated
 */
@ProviderType
public interface DesignationMasterPersistence
	extends BasePersistence<DesignationMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DesignationMasterUtil} to access the designation master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the designation master where designationName = &#63; or throws a <code>NoSuchDesignationMasterException</code> if it could not be found.
	 *
	 * @param designationName the designation name
	 * @return the matching designation master
	 * @throws NoSuchDesignationMasterException if a matching designation master could not be found
	 */
	public DesignationMaster findByDesignationName(String designationName)
		throws NoSuchDesignationMasterException;

	/**
	 * Returns the designation master where designationName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param designationName the designation name
	 * @return the matching designation master, or <code>null</code> if a matching designation master could not be found
	 */
	public DesignationMaster fetchByDesignationName(String designationName);

	/**
	 * Returns the designation master where designationName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param designationName the designation name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching designation master, or <code>null</code> if a matching designation master could not be found
	 */
	public DesignationMaster fetchByDesignationName(
		String designationName, boolean useFinderCache);

	/**
	 * Removes the designation master where designationName = &#63; from the database.
	 *
	 * @param designationName the designation name
	 * @return the designation master that was removed
	 */
	public DesignationMaster removeByDesignationName(String designationName)
		throws NoSuchDesignationMasterException;

	/**
	 * Returns the number of designation masters where designationName = &#63;.
	 *
	 * @param designationName the designation name
	 * @return the number of matching designation masters
	 */
	public int countByDesignationName(String designationName);

	/**
	 * Returns the designation master where designationMasterId = &#63; or throws a <code>NoSuchDesignationMasterException</code> if it could not be found.
	 *
	 * @param designationMasterId the designation master ID
	 * @return the matching designation master
	 * @throws NoSuchDesignationMasterException if a matching designation master could not be found
	 */
	public DesignationMaster findByDesignationNameById(long designationMasterId)
		throws NoSuchDesignationMasterException;

	/**
	 * Returns the designation master where designationMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param designationMasterId the designation master ID
	 * @return the matching designation master, or <code>null</code> if a matching designation master could not be found
	 */
	public DesignationMaster fetchByDesignationNameById(
		long designationMasterId);

	/**
	 * Returns the designation master where designationMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param designationMasterId the designation master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching designation master, or <code>null</code> if a matching designation master could not be found
	 */
	public DesignationMaster fetchByDesignationNameById(
		long designationMasterId, boolean useFinderCache);

	/**
	 * Removes the designation master where designationMasterId = &#63; from the database.
	 *
	 * @param designationMasterId the designation master ID
	 * @return the designation master that was removed
	 */
	public DesignationMaster removeByDesignationNameById(
			long designationMasterId)
		throws NoSuchDesignationMasterException;

	/**
	 * Returns the number of designation masters where designationMasterId = &#63;.
	 *
	 * @param designationMasterId the designation master ID
	 * @return the number of matching designation masters
	 */
	public int countByDesignationNameById(long designationMasterId);

	/**
	 * Caches the designation master in the entity cache if it is enabled.
	 *
	 * @param designationMaster the designation master
	 */
	public void cacheResult(DesignationMaster designationMaster);

	/**
	 * Caches the designation masters in the entity cache if it is enabled.
	 *
	 * @param designationMasters the designation masters
	 */
	public void cacheResult(
		java.util.List<DesignationMaster> designationMasters);

	/**
	 * Creates a new designation master with the primary key. Does not add the designation master to the database.
	 *
	 * @param designationMasterId the primary key for the new designation master
	 * @return the new designation master
	 */
	public DesignationMaster create(long designationMasterId);

	/**
	 * Removes the designation master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationMasterId the primary key of the designation master
	 * @return the designation master that was removed
	 * @throws NoSuchDesignationMasterException if a designation master with the primary key could not be found
	 */
	public DesignationMaster remove(long designationMasterId)
		throws NoSuchDesignationMasterException;

	public DesignationMaster updateImpl(DesignationMaster designationMaster);

	/**
	 * Returns the designation master with the primary key or throws a <code>NoSuchDesignationMasterException</code> if it could not be found.
	 *
	 * @param designationMasterId the primary key of the designation master
	 * @return the designation master
	 * @throws NoSuchDesignationMasterException if a designation master with the primary key could not be found
	 */
	public DesignationMaster findByPrimaryKey(long designationMasterId)
		throws NoSuchDesignationMasterException;

	/**
	 * Returns the designation master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationMasterId the primary key of the designation master
	 * @return the designation master, or <code>null</code> if a designation master with the primary key could not be found
	 */
	public DesignationMaster fetchByPrimaryKey(long designationMasterId);

	/**
	 * Returns all the designation masters.
	 *
	 * @return the designation masters
	 */
	public java.util.List<DesignationMaster> findAll();

	/**
	 * Returns a range of all the designation masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation masters
	 * @param end the upper bound of the range of designation masters (not inclusive)
	 * @return the range of designation masters
	 */
	public java.util.List<DesignationMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the designation masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation masters
	 * @param end the upper bound of the range of designation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designation masters
	 */
	public java.util.List<DesignationMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the designation masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation masters
	 * @param end the upper bound of the range of designation masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of designation masters
	 */
	public java.util.List<DesignationMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the designation masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of designation masters.
	 *
	 * @return the number of designation masters
	 */
	public int countAll();

}