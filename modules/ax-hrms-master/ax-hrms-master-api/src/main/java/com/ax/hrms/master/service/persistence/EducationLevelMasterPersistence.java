/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.exception.NoSuchEducationLevelMasterException;
import com.ax.hrms.master.model.EducationLevelMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the education level master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EducationLevelMasterUtil
 * @generated
 */
@ProviderType
public interface EducationLevelMasterPersistence
	extends BasePersistence<EducationLevelMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EducationLevelMasterUtil} to access the education level master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the education level master where levelName = &#63; or throws a <code>NoSuchEducationLevelMasterException</code> if it could not be found.
	 *
	 * @param levelName the level name
	 * @return the matching education level master
	 * @throws NoSuchEducationLevelMasterException if a matching education level master could not be found
	 */
	public EducationLevelMaster findByLevelName(String levelName)
		throws NoSuchEducationLevelMasterException;

	/**
	 * Returns the education level master where levelName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param levelName the level name
	 * @return the matching education level master, or <code>null</code> if a matching education level master could not be found
	 */
	public EducationLevelMaster fetchByLevelName(String levelName);

	/**
	 * Returns the education level master where levelName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param levelName the level name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching education level master, or <code>null</code> if a matching education level master could not be found
	 */
	public EducationLevelMaster fetchByLevelName(
		String levelName, boolean useFinderCache);

	/**
	 * Removes the education level master where levelName = &#63; from the database.
	 *
	 * @param levelName the level name
	 * @return the education level master that was removed
	 */
	public EducationLevelMaster removeByLevelName(String levelName)
		throws NoSuchEducationLevelMasterException;

	/**
	 * Returns the number of education level masters where levelName = &#63;.
	 *
	 * @param levelName the level name
	 * @return the number of matching education level masters
	 */
	public int countByLevelName(String levelName);

	/**
	 * Caches the education level master in the entity cache if it is enabled.
	 *
	 * @param educationLevelMaster the education level master
	 */
	public void cacheResult(EducationLevelMaster educationLevelMaster);

	/**
	 * Caches the education level masters in the entity cache if it is enabled.
	 *
	 * @param educationLevelMasters the education level masters
	 */
	public void cacheResult(
		java.util.List<EducationLevelMaster> educationLevelMasters);

	/**
	 * Creates a new education level master with the primary key. Does not add the education level master to the database.
	 *
	 * @param educationLevelMasterId the primary key for the new education level master
	 * @return the new education level master
	 */
	public EducationLevelMaster create(long educationLevelMasterId);

	/**
	 * Removes the education level master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param educationLevelMasterId the primary key of the education level master
	 * @return the education level master that was removed
	 * @throws NoSuchEducationLevelMasterException if a education level master with the primary key could not be found
	 */
	public EducationLevelMaster remove(long educationLevelMasterId)
		throws NoSuchEducationLevelMasterException;

	public EducationLevelMaster updateImpl(
		EducationLevelMaster educationLevelMaster);

	/**
	 * Returns the education level master with the primary key or throws a <code>NoSuchEducationLevelMasterException</code> if it could not be found.
	 *
	 * @param educationLevelMasterId the primary key of the education level master
	 * @return the education level master
	 * @throws NoSuchEducationLevelMasterException if a education level master with the primary key could not be found
	 */
	public EducationLevelMaster findByPrimaryKey(long educationLevelMasterId)
		throws NoSuchEducationLevelMasterException;

	/**
	 * Returns the education level master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param educationLevelMasterId the primary key of the education level master
	 * @return the education level master, or <code>null</code> if a education level master with the primary key could not be found
	 */
	public EducationLevelMaster fetchByPrimaryKey(long educationLevelMasterId);

	/**
	 * Returns all the education level masters.
	 *
	 * @return the education level masters
	 */
	public java.util.List<EducationLevelMaster> findAll();

	/**
	 * Returns a range of all the education level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EducationLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of education level masters
	 * @param end the upper bound of the range of education level masters (not inclusive)
	 * @return the range of education level masters
	 */
	public java.util.List<EducationLevelMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the education level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EducationLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of education level masters
	 * @param end the upper bound of the range of education level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of education level masters
	 */
	public java.util.List<EducationLevelMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EducationLevelMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the education level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EducationLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of education level masters
	 * @param end the upper bound of the range of education level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of education level masters
	 */
	public java.util.List<EducationLevelMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EducationLevelMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the education level masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of education level masters.
	 *
	 * @return the number of education level masters
	 */
	public int countAll();

}