/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchAppraisalHistoryException;
import com.ax.hrms.model.AppraisalHistory;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the appraisal history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalHistoryUtil
 * @generated
 */
@ProviderType
public interface AppraisalHistoryPersistence
	extends BasePersistence<AppraisalHistory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppraisalHistoryUtil} to access the appraisal history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the appraisal histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching appraisal histories
	 */
	public java.util.List<AppraisalHistory> findByUuid(String uuid);

	/**
	 * Returns a range of all the appraisal histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal histories
	 * @param end the upper bound of the range of appraisal histories (not inclusive)
	 * @return the range of matching appraisal histories
	 */
	public java.util.List<AppraisalHistory> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the appraisal histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal histories
	 * @param end the upper bound of the range of appraisal histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal histories
	 */
	public java.util.List<AppraisalHistory> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the appraisal histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal histories
	 * @param end the upper bound of the range of appraisal histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal histories
	 */
	public java.util.List<AppraisalHistory> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first appraisal history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal history
	 * @throws NoSuchAppraisalHistoryException if a matching appraisal history could not be found
	 */
	public AppraisalHistory findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalHistory>
				orderByComparator)
		throws NoSuchAppraisalHistoryException;

	/**
	 * Returns the first appraisal history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal history, or <code>null</code> if a matching appraisal history could not be found
	 */
	public AppraisalHistory fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalHistory>
			orderByComparator);

	/**
	 * Returns the last appraisal history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal history
	 * @throws NoSuchAppraisalHistoryException if a matching appraisal history could not be found
	 */
	public AppraisalHistory findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalHistory>
				orderByComparator)
		throws NoSuchAppraisalHistoryException;

	/**
	 * Returns the last appraisal history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal history, or <code>null</code> if a matching appraisal history could not be found
	 */
	public AppraisalHistory fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalHistory>
			orderByComparator);

	/**
	 * Returns the appraisal histories before and after the current appraisal history in the ordered set where uuid = &#63;.
	 *
	 * @param appraisalId the primary key of the current appraisal history
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal history
	 * @throws NoSuchAppraisalHistoryException if a appraisal history with the primary key could not be found
	 */
	public AppraisalHistory[] findByUuid_PrevAndNext(
			long appraisalId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalHistory>
				orderByComparator)
		throws NoSuchAppraisalHistoryException;

	/**
	 * Removes all the appraisal histories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of appraisal histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching appraisal histories
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the appraisal history where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAppraisalHistoryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal history
	 * @throws NoSuchAppraisalHistoryException if a matching appraisal history could not be found
	 */
	public AppraisalHistory findByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalHistoryException;

	/**
	 * Returns the appraisal history where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal history, or <code>null</code> if a matching appraisal history could not be found
	 */
	public AppraisalHistory fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the appraisal history where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal history, or <code>null</code> if a matching appraisal history could not be found
	 */
	public AppraisalHistory fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the appraisal history where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the appraisal history that was removed
	 */
	public AppraisalHistory removeByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalHistoryException;

	/**
	 * Returns the number of appraisal histories where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching appraisal histories
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the appraisal histories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching appraisal histories
	 */
	public java.util.List<AppraisalHistory> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the appraisal histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal histories
	 * @param end the upper bound of the range of appraisal histories (not inclusive)
	 * @return the range of matching appraisal histories
	 */
	public java.util.List<AppraisalHistory> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the appraisal histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal histories
	 * @param end the upper bound of the range of appraisal histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal histories
	 */
	public java.util.List<AppraisalHistory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the appraisal histories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal histories
	 * @param end the upper bound of the range of appraisal histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal histories
	 */
	public java.util.List<AppraisalHistory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first appraisal history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal history
	 * @throws NoSuchAppraisalHistoryException if a matching appraisal history could not be found
	 */
	public AppraisalHistory findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalHistory>
				orderByComparator)
		throws NoSuchAppraisalHistoryException;

	/**
	 * Returns the first appraisal history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal history, or <code>null</code> if a matching appraisal history could not be found
	 */
	public AppraisalHistory fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalHistory>
			orderByComparator);

	/**
	 * Returns the last appraisal history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal history
	 * @throws NoSuchAppraisalHistoryException if a matching appraisal history could not be found
	 */
	public AppraisalHistory findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalHistory>
				orderByComparator)
		throws NoSuchAppraisalHistoryException;

	/**
	 * Returns the last appraisal history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal history, or <code>null</code> if a matching appraisal history could not be found
	 */
	public AppraisalHistory fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalHistory>
			orderByComparator);

	/**
	 * Returns the appraisal histories before and after the current appraisal history in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param appraisalId the primary key of the current appraisal history
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal history
	 * @throws NoSuchAppraisalHistoryException if a appraisal history with the primary key could not be found
	 */
	public AppraisalHistory[] findByUuid_C_PrevAndNext(
			long appraisalId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalHistory>
				orderByComparator)
		throws NoSuchAppraisalHistoryException;

	/**
	 * Removes all the appraisal histories where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of appraisal histories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching appraisal histories
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the appraisal history in the entity cache if it is enabled.
	 *
	 * @param appraisalHistory the appraisal history
	 */
	public void cacheResult(AppraisalHistory appraisalHistory);

	/**
	 * Caches the appraisal histories in the entity cache if it is enabled.
	 *
	 * @param appraisalHistories the appraisal histories
	 */
	public void cacheResult(
		java.util.List<AppraisalHistory> appraisalHistories);

	/**
	 * Creates a new appraisal history with the primary key. Does not add the appraisal history to the database.
	 *
	 * @param appraisalId the primary key for the new appraisal history
	 * @return the new appraisal history
	 */
	public AppraisalHistory create(long appraisalId);

	/**
	 * Removes the appraisal history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalId the primary key of the appraisal history
	 * @return the appraisal history that was removed
	 * @throws NoSuchAppraisalHistoryException if a appraisal history with the primary key could not be found
	 */
	public AppraisalHistory remove(long appraisalId)
		throws NoSuchAppraisalHistoryException;

	public AppraisalHistory updateImpl(AppraisalHistory appraisalHistory);

	/**
	 * Returns the appraisal history with the primary key or throws a <code>NoSuchAppraisalHistoryException</code> if it could not be found.
	 *
	 * @param appraisalId the primary key of the appraisal history
	 * @return the appraisal history
	 * @throws NoSuchAppraisalHistoryException if a appraisal history with the primary key could not be found
	 */
	public AppraisalHistory findByPrimaryKey(long appraisalId)
		throws NoSuchAppraisalHistoryException;

	/**
	 * Returns the appraisal history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalId the primary key of the appraisal history
	 * @return the appraisal history, or <code>null</code> if a appraisal history with the primary key could not be found
	 */
	public AppraisalHistory fetchByPrimaryKey(long appraisalId);

	/**
	 * Returns all the appraisal histories.
	 *
	 * @return the appraisal histories
	 */
	public java.util.List<AppraisalHistory> findAll();

	/**
	 * Returns a range of all the appraisal histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal histories
	 * @param end the upper bound of the range of appraisal histories (not inclusive)
	 * @return the range of appraisal histories
	 */
	public java.util.List<AppraisalHistory> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the appraisal histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal histories
	 * @param end the upper bound of the range of appraisal histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appraisal histories
	 */
	public java.util.List<AppraisalHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the appraisal histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal histories
	 * @param end the upper bound of the range of appraisal histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of appraisal histories
	 */
	public java.util.List<AppraisalHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the appraisal histories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of appraisal histories.
	 *
	 * @return the number of appraisal histories
	 */
	public int countAll();

}