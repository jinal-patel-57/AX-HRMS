/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchAppraisalProcessException;
import com.ax.hrms.model.AppraisalProcess;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the appraisal process service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalProcessUtil
 * @generated
 */
@ProviderType
public interface AppraisalProcessPersistence
	extends BasePersistence<AppraisalProcess> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppraisalProcessUtil} to access the appraisal process persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the appraisal processes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching appraisal processes
	 */
	public java.util.List<AppraisalProcess> findByUuid(String uuid);

	/**
	 * Returns a range of all the appraisal processes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal processes
	 * @param end the upper bound of the range of appraisal processes (not inclusive)
	 * @return the range of matching appraisal processes
	 */
	public java.util.List<AppraisalProcess> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the appraisal processes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal processes
	 * @param end the upper bound of the range of appraisal processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal processes
	 */
	public java.util.List<AppraisalProcess> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProcess>
			orderByComparator);

	/**
	 * Returns an ordered range of all the appraisal processes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of appraisal processes
	 * @param end the upper bound of the range of appraisal processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal processes
	 */
	public java.util.List<AppraisalProcess> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProcess>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first appraisal process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal process
	 * @throws NoSuchAppraisalProcessException if a matching appraisal process could not be found
	 */
	public AppraisalProcess findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalProcess>
				orderByComparator)
		throws NoSuchAppraisalProcessException;

	/**
	 * Returns the first appraisal process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal process, or <code>null</code> if a matching appraisal process could not be found
	 */
	public AppraisalProcess fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProcess>
			orderByComparator);

	/**
	 * Returns the last appraisal process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal process
	 * @throws NoSuchAppraisalProcessException if a matching appraisal process could not be found
	 */
	public AppraisalProcess findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalProcess>
				orderByComparator)
		throws NoSuchAppraisalProcessException;

	/**
	 * Returns the last appraisal process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal process, or <code>null</code> if a matching appraisal process could not be found
	 */
	public AppraisalProcess fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProcess>
			orderByComparator);

	/**
	 * Returns the appraisal processes before and after the current appraisal process in the ordered set where uuid = &#63;.
	 *
	 * @param appraisalProcessId the primary key of the current appraisal process
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal process
	 * @throws NoSuchAppraisalProcessException if a appraisal process with the primary key could not be found
	 */
	public AppraisalProcess[] findByUuid_PrevAndNext(
			long appraisalProcessId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalProcess>
				orderByComparator)
		throws NoSuchAppraisalProcessException;

	/**
	 * Removes all the appraisal processes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of appraisal processes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching appraisal processes
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the appraisal process where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAppraisalProcessException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal process
	 * @throws NoSuchAppraisalProcessException if a matching appraisal process could not be found
	 */
	public AppraisalProcess findByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalProcessException;

	/**
	 * Returns the appraisal process where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching appraisal process, or <code>null</code> if a matching appraisal process could not be found
	 */
	public AppraisalProcess fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the appraisal process where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching appraisal process, or <code>null</code> if a matching appraisal process could not be found
	 */
	public AppraisalProcess fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the appraisal process where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the appraisal process that was removed
	 */
	public AppraisalProcess removeByUUID_G(String uuid, long groupId)
		throws NoSuchAppraisalProcessException;

	/**
	 * Returns the number of appraisal processes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching appraisal processes
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the appraisal processes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching appraisal processes
	 */
	public java.util.List<AppraisalProcess> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the appraisal processes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal processes
	 * @param end the upper bound of the range of appraisal processes (not inclusive)
	 * @return the range of matching appraisal processes
	 */
	public java.util.List<AppraisalProcess> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the appraisal processes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal processes
	 * @param end the upper bound of the range of appraisal processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal processes
	 */
	public java.util.List<AppraisalProcess> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProcess>
			orderByComparator);

	/**
	 * Returns an ordered range of all the appraisal processes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of appraisal processes
	 * @param end the upper bound of the range of appraisal processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching appraisal processes
	 */
	public java.util.List<AppraisalProcess> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProcess>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first appraisal process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal process
	 * @throws NoSuchAppraisalProcessException if a matching appraisal process could not be found
	 */
	public AppraisalProcess findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalProcess>
				orderByComparator)
		throws NoSuchAppraisalProcessException;

	/**
	 * Returns the first appraisal process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal process, or <code>null</code> if a matching appraisal process could not be found
	 */
	public AppraisalProcess fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProcess>
			orderByComparator);

	/**
	 * Returns the last appraisal process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal process
	 * @throws NoSuchAppraisalProcessException if a matching appraisal process could not be found
	 */
	public AppraisalProcess findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalProcess>
				orderByComparator)
		throws NoSuchAppraisalProcessException;

	/**
	 * Returns the last appraisal process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal process, or <code>null</code> if a matching appraisal process could not be found
	 */
	public AppraisalProcess fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProcess>
			orderByComparator);

	/**
	 * Returns the appraisal processes before and after the current appraisal process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param appraisalProcessId the primary key of the current appraisal process
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal process
	 * @throws NoSuchAppraisalProcessException if a appraisal process with the primary key could not be found
	 */
	public AppraisalProcess[] findByUuid_C_PrevAndNext(
			long appraisalProcessId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AppraisalProcess>
				orderByComparator)
		throws NoSuchAppraisalProcessException;

	/**
	 * Removes all the appraisal processes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of appraisal processes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching appraisal processes
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the appraisal process in the entity cache if it is enabled.
	 *
	 * @param appraisalProcess the appraisal process
	 */
	public void cacheResult(AppraisalProcess appraisalProcess);

	/**
	 * Caches the appraisal processes in the entity cache if it is enabled.
	 *
	 * @param appraisalProcesses the appraisal processes
	 */
	public void cacheResult(
		java.util.List<AppraisalProcess> appraisalProcesses);

	/**
	 * Creates a new appraisal process with the primary key. Does not add the appraisal process to the database.
	 *
	 * @param appraisalProcessId the primary key for the new appraisal process
	 * @return the new appraisal process
	 */
	public AppraisalProcess create(long appraisalProcessId);

	/**
	 * Removes the appraisal process with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalProcessId the primary key of the appraisal process
	 * @return the appraisal process that was removed
	 * @throws NoSuchAppraisalProcessException if a appraisal process with the primary key could not be found
	 */
	public AppraisalProcess remove(long appraisalProcessId)
		throws NoSuchAppraisalProcessException;

	public AppraisalProcess updateImpl(AppraisalProcess appraisalProcess);

	/**
	 * Returns the appraisal process with the primary key or throws a <code>NoSuchAppraisalProcessException</code> if it could not be found.
	 *
	 * @param appraisalProcessId the primary key of the appraisal process
	 * @return the appraisal process
	 * @throws NoSuchAppraisalProcessException if a appraisal process with the primary key could not be found
	 */
	public AppraisalProcess findByPrimaryKey(long appraisalProcessId)
		throws NoSuchAppraisalProcessException;

	/**
	 * Returns the appraisal process with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalProcessId the primary key of the appraisal process
	 * @return the appraisal process, or <code>null</code> if a appraisal process with the primary key could not be found
	 */
	public AppraisalProcess fetchByPrimaryKey(long appraisalProcessId);

	/**
	 * Returns all the appraisal processes.
	 *
	 * @return the appraisal processes
	 */
	public java.util.List<AppraisalProcess> findAll();

	/**
	 * Returns a range of all the appraisal processes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalProcessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal processes
	 * @param end the upper bound of the range of appraisal processes (not inclusive)
	 * @return the range of appraisal processes
	 */
	public java.util.List<AppraisalProcess> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the appraisal processes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalProcessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal processes
	 * @param end the upper bound of the range of appraisal processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appraisal processes
	 */
	public java.util.List<AppraisalProcess> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProcess>
			orderByComparator);

	/**
	 * Returns an ordered range of all the appraisal processes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppraisalProcessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal processes
	 * @param end the upper bound of the range of appraisal processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of appraisal processes
	 */
	public java.util.List<AppraisalProcess> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AppraisalProcess>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the appraisal processes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of appraisal processes.
	 *
	 * @return the number of appraisal processes
	 */
	public int countAll();

}