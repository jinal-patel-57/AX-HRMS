/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchNomineeException;
import com.ax.hrms.model.Nominee;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the nominee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NomineeUtil
 * @generated
 */
@ProviderType
public interface NomineePersistence extends BasePersistence<Nominee> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NomineeUtil} to access the nominee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the nominees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching nominees
	 */
	public java.util.List<Nominee> findByUuid(String uuid);

	/**
	 * Returns a range of all the nominees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NomineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of nominees
	 * @param end the upper bound of the range of nominees (not inclusive)
	 * @return the range of matching nominees
	 */
	public java.util.List<Nominee> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the nominees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NomineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of nominees
	 * @param end the upper bound of the range of nominees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching nominees
	 */
	public java.util.List<Nominee> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Nominee>
			orderByComparator);

	/**
	 * Returns an ordered range of all the nominees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NomineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of nominees
	 * @param end the upper bound of the range of nominees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching nominees
	 */
	public java.util.List<Nominee> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Nominee>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first nominee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching nominee
	 * @throws NoSuchNomineeException if a matching nominee could not be found
	 */
	public Nominee findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Nominee>
				orderByComparator)
		throws NoSuchNomineeException;

	/**
	 * Returns the first nominee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching nominee, or <code>null</code> if a matching nominee could not be found
	 */
	public Nominee fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Nominee>
			orderByComparator);

	/**
	 * Returns the last nominee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching nominee
	 * @throws NoSuchNomineeException if a matching nominee could not be found
	 */
	public Nominee findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Nominee>
				orderByComparator)
		throws NoSuchNomineeException;

	/**
	 * Returns the last nominee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching nominee, or <code>null</code> if a matching nominee could not be found
	 */
	public Nominee fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Nominee>
			orderByComparator);

	/**
	 * Returns the nominees before and after the current nominee in the ordered set where uuid = &#63;.
	 *
	 * @param nomineeId the primary key of the current nominee
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next nominee
	 * @throws NoSuchNomineeException if a nominee with the primary key could not be found
	 */
	public Nominee[] findByUuid_PrevAndNext(
			long nomineeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Nominee>
				orderByComparator)
		throws NoSuchNomineeException;

	/**
	 * Removes all the nominees where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of nominees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching nominees
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the nominee where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchNomineeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching nominee
	 * @throws NoSuchNomineeException if a matching nominee could not be found
	 */
	public Nominee findByUUID_G(String uuid, long groupId)
		throws NoSuchNomineeException;

	/**
	 * Returns the nominee where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching nominee, or <code>null</code> if a matching nominee could not be found
	 */
	public Nominee fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the nominee where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching nominee, or <code>null</code> if a matching nominee could not be found
	 */
	public Nominee fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the nominee where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the nominee that was removed
	 */
	public Nominee removeByUUID_G(String uuid, long groupId)
		throws NoSuchNomineeException;

	/**
	 * Returns the number of nominees where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching nominees
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the nominees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching nominees
	 */
	public java.util.List<Nominee> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the nominees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NomineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of nominees
	 * @param end the upper bound of the range of nominees (not inclusive)
	 * @return the range of matching nominees
	 */
	public java.util.List<Nominee> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the nominees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NomineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of nominees
	 * @param end the upper bound of the range of nominees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching nominees
	 */
	public java.util.List<Nominee> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Nominee>
			orderByComparator);

	/**
	 * Returns an ordered range of all the nominees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NomineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of nominees
	 * @param end the upper bound of the range of nominees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching nominees
	 */
	public java.util.List<Nominee> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Nominee>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first nominee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching nominee
	 * @throws NoSuchNomineeException if a matching nominee could not be found
	 */
	public Nominee findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Nominee>
				orderByComparator)
		throws NoSuchNomineeException;

	/**
	 * Returns the first nominee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching nominee, or <code>null</code> if a matching nominee could not be found
	 */
	public Nominee fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Nominee>
			orderByComparator);

	/**
	 * Returns the last nominee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching nominee
	 * @throws NoSuchNomineeException if a matching nominee could not be found
	 */
	public Nominee findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Nominee>
				orderByComparator)
		throws NoSuchNomineeException;

	/**
	 * Returns the last nominee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching nominee, or <code>null</code> if a matching nominee could not be found
	 */
	public Nominee fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Nominee>
			orderByComparator);

	/**
	 * Returns the nominees before and after the current nominee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param nomineeId the primary key of the current nominee
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next nominee
	 * @throws NoSuchNomineeException if a nominee with the primary key could not be found
	 */
	public Nominee[] findByUuid_C_PrevAndNext(
			long nomineeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Nominee>
				orderByComparator)
		throws NoSuchNomineeException;

	/**
	 * Removes all the nominees where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of nominees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching nominees
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the nominee in the entity cache if it is enabled.
	 *
	 * @param nominee the nominee
	 */
	public void cacheResult(Nominee nominee);

	/**
	 * Caches the nominees in the entity cache if it is enabled.
	 *
	 * @param nominees the nominees
	 */
	public void cacheResult(java.util.List<Nominee> nominees);

	/**
	 * Creates a new nominee with the primary key. Does not add the nominee to the database.
	 *
	 * @param nomineeId the primary key for the new nominee
	 * @return the new nominee
	 */
	public Nominee create(long nomineeId);

	/**
	 * Removes the nominee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param nomineeId the primary key of the nominee
	 * @return the nominee that was removed
	 * @throws NoSuchNomineeException if a nominee with the primary key could not be found
	 */
	public Nominee remove(long nomineeId) throws NoSuchNomineeException;

	public Nominee updateImpl(Nominee nominee);

	/**
	 * Returns the nominee with the primary key or throws a <code>NoSuchNomineeException</code> if it could not be found.
	 *
	 * @param nomineeId the primary key of the nominee
	 * @return the nominee
	 * @throws NoSuchNomineeException if a nominee with the primary key could not be found
	 */
	public Nominee findByPrimaryKey(long nomineeId)
		throws NoSuchNomineeException;

	/**
	 * Returns the nominee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param nomineeId the primary key of the nominee
	 * @return the nominee, or <code>null</code> if a nominee with the primary key could not be found
	 */
	public Nominee fetchByPrimaryKey(long nomineeId);

	/**
	 * Returns all the nominees.
	 *
	 * @return the nominees
	 */
	public java.util.List<Nominee> findAll();

	/**
	 * Returns a range of all the nominees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NomineeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nominees
	 * @param end the upper bound of the range of nominees (not inclusive)
	 * @return the range of nominees
	 */
	public java.util.List<Nominee> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the nominees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NomineeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nominees
	 * @param end the upper bound of the range of nominees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of nominees
	 */
	public java.util.List<Nominee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Nominee>
			orderByComparator);

	/**
	 * Returns an ordered range of all the nominees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NomineeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nominees
	 * @param end the upper bound of the range of nominees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of nominees
	 */
	public java.util.List<Nominee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Nominee>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the nominees from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of nominees.
	 *
	 * @return the number of nominees
	 */
	public int countAll();

}