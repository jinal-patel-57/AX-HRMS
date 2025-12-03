/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.exception.NoSuchDepartmentMasterException;
import com.ax.hrms.master.model.DepartmentMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the department master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentMasterUtil
 * @generated
 */
@ProviderType
public interface DepartmentMasterPersistence
	extends BasePersistence<DepartmentMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DepartmentMasterUtil} to access the department master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the department master where departmentName = &#63; or throws a <code>NoSuchDepartmentMasterException</code> if it could not be found.
	 *
	 * @param departmentName the department name
	 * @return the matching department master
	 * @throws NoSuchDepartmentMasterException if a matching department master could not be found
	 */
	public DepartmentMaster findByDepartmentName(String departmentName)
		throws NoSuchDepartmentMasterException;

	/**
	 * Returns the department master where departmentName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param departmentName the department name
	 * @return the matching department master, or <code>null</code> if a matching department master could not be found
	 */
	public DepartmentMaster fetchByDepartmentName(String departmentName);

	/**
	 * Returns the department master where departmentName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param departmentName the department name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department master, or <code>null</code> if a matching department master could not be found
	 */
	public DepartmentMaster fetchByDepartmentName(
		String departmentName, boolean useFinderCache);

	/**
	 * Removes the department master where departmentName = &#63; from the database.
	 *
	 * @param departmentName the department name
	 * @return the department master that was removed
	 */
	public DepartmentMaster removeByDepartmentName(String departmentName)
		throws NoSuchDepartmentMasterException;

	/**
	 * Returns the number of department masters where departmentName = &#63;.
	 *
	 * @param departmentName the department name
	 * @return the number of matching department masters
	 */
	public int countByDepartmentName(String departmentName);

	/**
	 * Returns the department master where departmentMasterId = &#63; or throws a <code>NoSuchDepartmentMasterException</code> if it could not be found.
	 *
	 * @param departmentMasterId the department master ID
	 * @return the matching department master
	 * @throws NoSuchDepartmentMasterException if a matching department master could not be found
	 */
	public DepartmentMaster findByDepartmentNameById(long departmentMasterId)
		throws NoSuchDepartmentMasterException;

	/**
	 * Returns the department master where departmentMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param departmentMasterId the department master ID
	 * @return the matching department master, or <code>null</code> if a matching department master could not be found
	 */
	public DepartmentMaster fetchByDepartmentNameById(long departmentMasterId);

	/**
	 * Returns the department master where departmentMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param departmentMasterId the department master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching department master, or <code>null</code> if a matching department master could not be found
	 */
	public DepartmentMaster fetchByDepartmentNameById(
		long departmentMasterId, boolean useFinderCache);

	/**
	 * Removes the department master where departmentMasterId = &#63; from the database.
	 *
	 * @param departmentMasterId the department master ID
	 * @return the department master that was removed
	 */
	public DepartmentMaster removeByDepartmentNameById(long departmentMasterId)
		throws NoSuchDepartmentMasterException;

	/**
	 * Returns the number of department masters where departmentMasterId = &#63;.
	 *
	 * @param departmentMasterId the department master ID
	 * @return the number of matching department masters
	 */
	public int countByDepartmentNameById(long departmentMasterId);

	/**
	 * Caches the department master in the entity cache if it is enabled.
	 *
	 * @param departmentMaster the department master
	 */
	public void cacheResult(DepartmentMaster departmentMaster);

	/**
	 * Caches the department masters in the entity cache if it is enabled.
	 *
	 * @param departmentMasters the department masters
	 */
	public void cacheResult(java.util.List<DepartmentMaster> departmentMasters);

	/**
	 * Creates a new department master with the primary key. Does not add the department master to the database.
	 *
	 * @param departmentMasterId the primary key for the new department master
	 * @return the new department master
	 */
	public DepartmentMaster create(long departmentMasterId);

	/**
	 * Removes the department master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param departmentMasterId the primary key of the department master
	 * @return the department master that was removed
	 * @throws NoSuchDepartmentMasterException if a department master with the primary key could not be found
	 */
	public DepartmentMaster remove(long departmentMasterId)
		throws NoSuchDepartmentMasterException;

	public DepartmentMaster updateImpl(DepartmentMaster departmentMaster);

	/**
	 * Returns the department master with the primary key or throws a <code>NoSuchDepartmentMasterException</code> if it could not be found.
	 *
	 * @param departmentMasterId the primary key of the department master
	 * @return the department master
	 * @throws NoSuchDepartmentMasterException if a department master with the primary key could not be found
	 */
	public DepartmentMaster findByPrimaryKey(long departmentMasterId)
		throws NoSuchDepartmentMasterException;

	/**
	 * Returns the department master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param departmentMasterId the primary key of the department master
	 * @return the department master, or <code>null</code> if a department master with the primary key could not be found
	 */
	public DepartmentMaster fetchByPrimaryKey(long departmentMasterId);

	/**
	 * Returns all the department masters.
	 *
	 * @return the department masters
	 */
	public java.util.List<DepartmentMaster> findAll();

	/**
	 * Returns a range of all the department masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department masters
	 * @param end the upper bound of the range of department masters (not inclusive)
	 * @return the range of department masters
	 */
	public java.util.List<DepartmentMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the department masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department masters
	 * @param end the upper bound of the range of department masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of department masters
	 */
	public java.util.List<DepartmentMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the department masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DepartmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department masters
	 * @param end the upper bound of the range of department masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of department masters
	 */
	public java.util.List<DepartmentMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DepartmentMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the department masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of department masters.
	 *
	 * @return the number of department masters
	 */
	public int countAll();

}