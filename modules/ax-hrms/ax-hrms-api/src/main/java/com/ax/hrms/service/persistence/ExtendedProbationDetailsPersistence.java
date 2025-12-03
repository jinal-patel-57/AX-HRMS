/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchExtendedProbationDetailsException;
import com.ax.hrms.model.ExtendedProbationDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the extended probation details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExtendedProbationDetailsUtil
 * @generated
 */
@ProviderType
public interface ExtendedProbationDetailsPersistence
	extends BasePersistence<ExtendedProbationDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExtendedProbationDetailsUtil} to access the extended probation details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the extended probation detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching extended probation detailses
	 */
	public java.util.List<ExtendedProbationDetails> findByUuid(String uuid);

	/**
	 * Returns a range of all the extended probation detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExtendedProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of extended probation detailses
	 * @param end the upper bound of the range of extended probation detailses (not inclusive)
	 * @return the range of matching extended probation detailses
	 */
	public java.util.List<ExtendedProbationDetails> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the extended probation detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExtendedProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of extended probation detailses
	 * @param end the upper bound of the range of extended probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching extended probation detailses
	 */
	public java.util.List<ExtendedProbationDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ExtendedProbationDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the extended probation detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExtendedProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of extended probation detailses
	 * @param end the upper bound of the range of extended probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching extended probation detailses
	 */
	public java.util.List<ExtendedProbationDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ExtendedProbationDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first extended probation details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching extended probation details
	 * @throws NoSuchExtendedProbationDetailsException if a matching extended probation details could not be found
	 */
	public ExtendedProbationDetails findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ExtendedProbationDetails> orderByComparator)
		throws NoSuchExtendedProbationDetailsException;

	/**
	 * Returns the first extended probation details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching extended probation details, or <code>null</code> if a matching extended probation details could not be found
	 */
	public ExtendedProbationDetails fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ExtendedProbationDetails> orderByComparator);

	/**
	 * Returns the last extended probation details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching extended probation details
	 * @throws NoSuchExtendedProbationDetailsException if a matching extended probation details could not be found
	 */
	public ExtendedProbationDetails findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ExtendedProbationDetails> orderByComparator)
		throws NoSuchExtendedProbationDetailsException;

	/**
	 * Returns the last extended probation details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching extended probation details, or <code>null</code> if a matching extended probation details could not be found
	 */
	public ExtendedProbationDetails fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<ExtendedProbationDetails> orderByComparator);

	/**
	 * Returns the extended probation detailses before and after the current extended probation details in the ordered set where uuid = &#63;.
	 *
	 * @param extendedProbationDetailsId the primary key of the current extended probation details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next extended probation details
	 * @throws NoSuchExtendedProbationDetailsException if a extended probation details with the primary key could not be found
	 */
	public ExtendedProbationDetails[] findByUuid_PrevAndNext(
			long extendedProbationDetailsId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ExtendedProbationDetails> orderByComparator)
		throws NoSuchExtendedProbationDetailsException;

	/**
	 * Removes all the extended probation detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of extended probation detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching extended probation detailses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the extended probation details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchExtendedProbationDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching extended probation details
	 * @throws NoSuchExtendedProbationDetailsException if a matching extended probation details could not be found
	 */
	public ExtendedProbationDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchExtendedProbationDetailsException;

	/**
	 * Returns the extended probation details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching extended probation details, or <code>null</code> if a matching extended probation details could not be found
	 */
	public ExtendedProbationDetails fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the extended probation details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching extended probation details, or <code>null</code> if a matching extended probation details could not be found
	 */
	public ExtendedProbationDetails fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the extended probation details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the extended probation details that was removed
	 */
	public ExtendedProbationDetails removeByUUID_G(String uuid, long groupId)
		throws NoSuchExtendedProbationDetailsException;

	/**
	 * Returns the number of extended probation detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching extended probation detailses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the extended probation detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching extended probation detailses
	 */
	public java.util.List<ExtendedProbationDetails> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the extended probation detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExtendedProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of extended probation detailses
	 * @param end the upper bound of the range of extended probation detailses (not inclusive)
	 * @return the range of matching extended probation detailses
	 */
	public java.util.List<ExtendedProbationDetails> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the extended probation detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExtendedProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of extended probation detailses
	 * @param end the upper bound of the range of extended probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching extended probation detailses
	 */
	public java.util.List<ExtendedProbationDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ExtendedProbationDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the extended probation detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExtendedProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of extended probation detailses
	 * @param end the upper bound of the range of extended probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching extended probation detailses
	 */
	public java.util.List<ExtendedProbationDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ExtendedProbationDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first extended probation details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching extended probation details
	 * @throws NoSuchExtendedProbationDetailsException if a matching extended probation details could not be found
	 */
	public ExtendedProbationDetails findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ExtendedProbationDetails> orderByComparator)
		throws NoSuchExtendedProbationDetailsException;

	/**
	 * Returns the first extended probation details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching extended probation details, or <code>null</code> if a matching extended probation details could not be found
	 */
	public ExtendedProbationDetails fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ExtendedProbationDetails> orderByComparator);

	/**
	 * Returns the last extended probation details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching extended probation details
	 * @throws NoSuchExtendedProbationDetailsException if a matching extended probation details could not be found
	 */
	public ExtendedProbationDetails findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ExtendedProbationDetails> orderByComparator)
		throws NoSuchExtendedProbationDetailsException;

	/**
	 * Returns the last extended probation details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching extended probation details, or <code>null</code> if a matching extended probation details could not be found
	 */
	public ExtendedProbationDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<ExtendedProbationDetails> orderByComparator);

	/**
	 * Returns the extended probation detailses before and after the current extended probation details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param extendedProbationDetailsId the primary key of the current extended probation details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next extended probation details
	 * @throws NoSuchExtendedProbationDetailsException if a extended probation details with the primary key could not be found
	 */
	public ExtendedProbationDetails[] findByUuid_C_PrevAndNext(
			long extendedProbationDetailsId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ExtendedProbationDetails> orderByComparator)
		throws NoSuchExtendedProbationDetailsException;

	/**
	 * Removes all the extended probation detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of extended probation detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching extended probation detailses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the extended probation details in the entity cache if it is enabled.
	 *
	 * @param extendedProbationDetails the extended probation details
	 */
	public void cacheResult(ExtendedProbationDetails extendedProbationDetails);

	/**
	 * Caches the extended probation detailses in the entity cache if it is enabled.
	 *
	 * @param extendedProbationDetailses the extended probation detailses
	 */
	public void cacheResult(
		java.util.List<ExtendedProbationDetails> extendedProbationDetailses);

	/**
	 * Creates a new extended probation details with the primary key. Does not add the extended probation details to the database.
	 *
	 * @param extendedProbationDetailsId the primary key for the new extended probation details
	 * @return the new extended probation details
	 */
	public ExtendedProbationDetails create(long extendedProbationDetailsId);

	/**
	 * Removes the extended probation details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param extendedProbationDetailsId the primary key of the extended probation details
	 * @return the extended probation details that was removed
	 * @throws NoSuchExtendedProbationDetailsException if a extended probation details with the primary key could not be found
	 */
	public ExtendedProbationDetails remove(long extendedProbationDetailsId)
		throws NoSuchExtendedProbationDetailsException;

	public ExtendedProbationDetails updateImpl(
		ExtendedProbationDetails extendedProbationDetails);

	/**
	 * Returns the extended probation details with the primary key or throws a <code>NoSuchExtendedProbationDetailsException</code> if it could not be found.
	 *
	 * @param extendedProbationDetailsId the primary key of the extended probation details
	 * @return the extended probation details
	 * @throws NoSuchExtendedProbationDetailsException if a extended probation details with the primary key could not be found
	 */
	public ExtendedProbationDetails findByPrimaryKey(
			long extendedProbationDetailsId)
		throws NoSuchExtendedProbationDetailsException;

	/**
	 * Returns the extended probation details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param extendedProbationDetailsId the primary key of the extended probation details
	 * @return the extended probation details, or <code>null</code> if a extended probation details with the primary key could not be found
	 */
	public ExtendedProbationDetails fetchByPrimaryKey(
		long extendedProbationDetailsId);

	/**
	 * Returns all the extended probation detailses.
	 *
	 * @return the extended probation detailses
	 */
	public java.util.List<ExtendedProbationDetails> findAll();

	/**
	 * Returns a range of all the extended probation detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExtendedProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of extended probation detailses
	 * @param end the upper bound of the range of extended probation detailses (not inclusive)
	 * @return the range of extended probation detailses
	 */
	public java.util.List<ExtendedProbationDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the extended probation detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExtendedProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of extended probation detailses
	 * @param end the upper bound of the range of extended probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of extended probation detailses
	 */
	public java.util.List<ExtendedProbationDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ExtendedProbationDetails> orderByComparator);

	/**
	 * Returns an ordered range of all the extended probation detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExtendedProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of extended probation detailses
	 * @param end the upper bound of the range of extended probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of extended probation detailses
	 */
	public java.util.List<ExtendedProbationDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ExtendedProbationDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the extended probation detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of extended probation detailses.
	 *
	 * @return the number of extended probation detailses
	 */
	public int countAll();

}