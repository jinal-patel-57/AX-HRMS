/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.exception.NoSuchWishTypeMasterException;
import com.ax.hrms.master.model.WishTypeMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the wish type master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WishTypeMasterUtil
 * @generated
 */
@ProviderType
public interface WishTypeMasterPersistence
	extends BasePersistence<WishTypeMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WishTypeMasterUtil} to access the wish type master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the wish type master where wishType = &#63; or throws a <code>NoSuchWishTypeMasterException</code> if it could not be found.
	 *
	 * @param wishType the wish type
	 * @return the matching wish type master
	 * @throws NoSuchWishTypeMasterException if a matching wish type master could not be found
	 */
	public WishTypeMaster findByWishType(String wishType)
		throws NoSuchWishTypeMasterException;

	/**
	 * Returns the wish type master where wishType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param wishType the wish type
	 * @return the matching wish type master, or <code>null</code> if a matching wish type master could not be found
	 */
	public WishTypeMaster fetchByWishType(String wishType);

	/**
	 * Returns the wish type master where wishType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param wishType the wish type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching wish type master, or <code>null</code> if a matching wish type master could not be found
	 */
	public WishTypeMaster fetchByWishType(
		String wishType, boolean useFinderCache);

	/**
	 * Removes the wish type master where wishType = &#63; from the database.
	 *
	 * @param wishType the wish type
	 * @return the wish type master that was removed
	 */
	public WishTypeMaster removeByWishType(String wishType)
		throws NoSuchWishTypeMasterException;

	/**
	 * Returns the number of wish type masters where wishType = &#63;.
	 *
	 * @param wishType the wish type
	 * @return the number of matching wish type masters
	 */
	public int countByWishType(String wishType);

	/**
	 * Caches the wish type master in the entity cache if it is enabled.
	 *
	 * @param wishTypeMaster the wish type master
	 */
	public void cacheResult(WishTypeMaster wishTypeMaster);

	/**
	 * Caches the wish type masters in the entity cache if it is enabled.
	 *
	 * @param wishTypeMasters the wish type masters
	 */
	public void cacheResult(java.util.List<WishTypeMaster> wishTypeMasters);

	/**
	 * Creates a new wish type master with the primary key. Does not add the wish type master to the database.
	 *
	 * @param wishTypeMasterId the primary key for the new wish type master
	 * @return the new wish type master
	 */
	public WishTypeMaster create(long wishTypeMasterId);

	/**
	 * Removes the wish type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wishTypeMasterId the primary key of the wish type master
	 * @return the wish type master that was removed
	 * @throws NoSuchWishTypeMasterException if a wish type master with the primary key could not be found
	 */
	public WishTypeMaster remove(long wishTypeMasterId)
		throws NoSuchWishTypeMasterException;

	public WishTypeMaster updateImpl(WishTypeMaster wishTypeMaster);

	/**
	 * Returns the wish type master with the primary key or throws a <code>NoSuchWishTypeMasterException</code> if it could not be found.
	 *
	 * @param wishTypeMasterId the primary key of the wish type master
	 * @return the wish type master
	 * @throws NoSuchWishTypeMasterException if a wish type master with the primary key could not be found
	 */
	public WishTypeMaster findByPrimaryKey(long wishTypeMasterId)
		throws NoSuchWishTypeMasterException;

	/**
	 * Returns the wish type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param wishTypeMasterId the primary key of the wish type master
	 * @return the wish type master, or <code>null</code> if a wish type master with the primary key could not be found
	 */
	public WishTypeMaster fetchByPrimaryKey(long wishTypeMasterId);

	/**
	 * Returns all the wish type masters.
	 *
	 * @return the wish type masters
	 */
	public java.util.List<WishTypeMaster> findAll();

	/**
	 * Returns a range of all the wish type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WishTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of wish type masters
	 * @param end the upper bound of the range of wish type masters (not inclusive)
	 * @return the range of wish type masters
	 */
	public java.util.List<WishTypeMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the wish type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WishTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of wish type masters
	 * @param end the upper bound of the range of wish type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of wish type masters
	 */
	public java.util.List<WishTypeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WishTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the wish type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WishTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of wish type masters
	 * @param end the upper bound of the range of wish type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of wish type masters
	 */
	public java.util.List<WishTypeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WishTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the wish type masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of wish type masters.
	 *
	 * @return the number of wish type masters
	 */
	public int countAll();

}