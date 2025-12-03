/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.exception.NoSuchTemplateLevelMasterException;
import com.ax.hrms.master.model.TemplateLevelMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the template level master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TemplateLevelMasterUtil
 * @generated
 */
@ProviderType
public interface TemplateLevelMasterPersistence
	extends BasePersistence<TemplateLevelMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TemplateLevelMasterUtil} to access the template level master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the template level master where levelName = &#63; or throws a <code>NoSuchTemplateLevelMasterException</code> if it could not be found.
	 *
	 * @param levelName the level name
	 * @return the matching template level master
	 * @throws NoSuchTemplateLevelMasterException if a matching template level master could not be found
	 */
	public TemplateLevelMaster findBylevelName(String levelName)
		throws NoSuchTemplateLevelMasterException;

	/**
	 * Returns the template level master where levelName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param levelName the level name
	 * @return the matching template level master, or <code>null</code> if a matching template level master could not be found
	 */
	public TemplateLevelMaster fetchBylevelName(String levelName);

	/**
	 * Returns the template level master where levelName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param levelName the level name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching template level master, or <code>null</code> if a matching template level master could not be found
	 */
	public TemplateLevelMaster fetchBylevelName(
		String levelName, boolean useFinderCache);

	/**
	 * Removes the template level master where levelName = &#63; from the database.
	 *
	 * @param levelName the level name
	 * @return the template level master that was removed
	 */
	public TemplateLevelMaster removeBylevelName(String levelName)
		throws NoSuchTemplateLevelMasterException;

	/**
	 * Returns the number of template level masters where levelName = &#63;.
	 *
	 * @param levelName the level name
	 * @return the number of matching template level masters
	 */
	public int countBylevelName(String levelName);

	/**
	 * Caches the template level master in the entity cache if it is enabled.
	 *
	 * @param templateLevelMaster the template level master
	 */
	public void cacheResult(TemplateLevelMaster templateLevelMaster);

	/**
	 * Caches the template level masters in the entity cache if it is enabled.
	 *
	 * @param templateLevelMasters the template level masters
	 */
	public void cacheResult(
		java.util.List<TemplateLevelMaster> templateLevelMasters);

	/**
	 * Creates a new template level master with the primary key. Does not add the template level master to the database.
	 *
	 * @param templateLevelMasterId the primary key for the new template level master
	 * @return the new template level master
	 */
	public TemplateLevelMaster create(long templateLevelMasterId);

	/**
	 * Removes the template level master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param templateLevelMasterId the primary key of the template level master
	 * @return the template level master that was removed
	 * @throws NoSuchTemplateLevelMasterException if a template level master with the primary key could not be found
	 */
	public TemplateLevelMaster remove(long templateLevelMasterId)
		throws NoSuchTemplateLevelMasterException;

	public TemplateLevelMaster updateImpl(
		TemplateLevelMaster templateLevelMaster);

	/**
	 * Returns the template level master with the primary key or throws a <code>NoSuchTemplateLevelMasterException</code> if it could not be found.
	 *
	 * @param templateLevelMasterId the primary key of the template level master
	 * @return the template level master
	 * @throws NoSuchTemplateLevelMasterException if a template level master with the primary key could not be found
	 */
	public TemplateLevelMaster findByPrimaryKey(long templateLevelMasterId)
		throws NoSuchTemplateLevelMasterException;

	/**
	 * Returns the template level master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param templateLevelMasterId the primary key of the template level master
	 * @return the template level master, or <code>null</code> if a template level master with the primary key could not be found
	 */
	public TemplateLevelMaster fetchByPrimaryKey(long templateLevelMasterId);

	/**
	 * Returns all the template level masters.
	 *
	 * @return the template level masters
	 */
	public java.util.List<TemplateLevelMaster> findAll();

	/**
	 * Returns a range of all the template level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplateLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of template level masters
	 * @param end the upper bound of the range of template level masters (not inclusive)
	 * @return the range of template level masters
	 */
	public java.util.List<TemplateLevelMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the template level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplateLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of template level masters
	 * @param end the upper bound of the range of template level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of template level masters
	 */
	public java.util.List<TemplateLevelMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TemplateLevelMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the template level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TemplateLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of template level masters
	 * @param end the upper bound of the range of template level masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of template level masters
	 */
	public java.util.List<TemplateLevelMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TemplateLevelMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the template level masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of template level masters.
	 *
	 * @return the number of template level masters
	 */
	public int countAll();

}