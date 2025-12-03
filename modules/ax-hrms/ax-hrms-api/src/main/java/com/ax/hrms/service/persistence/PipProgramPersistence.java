/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchPipProgramException;
import com.ax.hrms.model.PipProgram;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pip program service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PipProgramUtil
 * @generated
 */
@ProviderType
public interface PipProgramPersistence extends BasePersistence<PipProgram> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PipProgramUtil} to access the pip program persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the pip programs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching pip programs
	 */
	public java.util.List<PipProgram> findByUuid(String uuid);

	/**
	 * Returns a range of all the pip programs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @return the range of matching pip programs
	 */
	public java.util.List<PipProgram> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the pip programs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pip programs
	 */
	public java.util.List<PipProgram> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PipProgram>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pip programs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pip programs
	 */
	public java.util.List<PipProgram> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PipProgram>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pip program in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pip program
	 * @throws NoSuchPipProgramException if a matching pip program could not be found
	 */
	public PipProgram findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PipProgram>
				orderByComparator)
		throws NoSuchPipProgramException;

	/**
	 * Returns the first pip program in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pip program, or <code>null</code> if a matching pip program could not be found
	 */
	public PipProgram fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PipProgram>
			orderByComparator);

	/**
	 * Returns the last pip program in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pip program
	 * @throws NoSuchPipProgramException if a matching pip program could not be found
	 */
	public PipProgram findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PipProgram>
				orderByComparator)
		throws NoSuchPipProgramException;

	/**
	 * Returns the last pip program in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pip program, or <code>null</code> if a matching pip program could not be found
	 */
	public PipProgram fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PipProgram>
			orderByComparator);

	/**
	 * Returns the pip programs before and after the current pip program in the ordered set where uuid = &#63;.
	 *
	 * @param pipProgramId the primary key of the current pip program
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pip program
	 * @throws NoSuchPipProgramException if a pip program with the primary key could not be found
	 */
	public PipProgram[] findByUuid_PrevAndNext(
			long pipProgramId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PipProgram>
				orderByComparator)
		throws NoSuchPipProgramException;

	/**
	 * Removes all the pip programs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of pip programs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching pip programs
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the pip program where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPipProgramException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pip program
	 * @throws NoSuchPipProgramException if a matching pip program could not be found
	 */
	public PipProgram findByUUID_G(String uuid, long groupId)
		throws NoSuchPipProgramException;

	/**
	 * Returns the pip program where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pip program, or <code>null</code> if a matching pip program could not be found
	 */
	public PipProgram fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the pip program where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pip program, or <code>null</code> if a matching pip program could not be found
	 */
	public PipProgram fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the pip program where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the pip program that was removed
	 */
	public PipProgram removeByUUID_G(String uuid, long groupId)
		throws NoSuchPipProgramException;

	/**
	 * Returns the number of pip programs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching pip programs
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the pip programs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching pip programs
	 */
	public java.util.List<PipProgram> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the pip programs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @return the range of matching pip programs
	 */
	public java.util.List<PipProgram> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the pip programs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pip programs
	 */
	public java.util.List<PipProgram> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PipProgram>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pip programs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pip programs
	 */
	public java.util.List<PipProgram> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PipProgram>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pip program in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pip program
	 * @throws NoSuchPipProgramException if a matching pip program could not be found
	 */
	public PipProgram findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PipProgram>
				orderByComparator)
		throws NoSuchPipProgramException;

	/**
	 * Returns the first pip program in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pip program, or <code>null</code> if a matching pip program could not be found
	 */
	public PipProgram fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PipProgram>
			orderByComparator);

	/**
	 * Returns the last pip program in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pip program
	 * @throws NoSuchPipProgramException if a matching pip program could not be found
	 */
	public PipProgram findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PipProgram>
				orderByComparator)
		throws NoSuchPipProgramException;

	/**
	 * Returns the last pip program in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pip program, or <code>null</code> if a matching pip program could not be found
	 */
	public PipProgram fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PipProgram>
			orderByComparator);

	/**
	 * Returns the pip programs before and after the current pip program in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param pipProgramId the primary key of the current pip program
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pip program
	 * @throws NoSuchPipProgramException if a pip program with the primary key could not be found
	 */
	public PipProgram[] findByUuid_C_PrevAndNext(
			long pipProgramId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PipProgram>
				orderByComparator)
		throws NoSuchPipProgramException;

	/**
	 * Removes all the pip programs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of pip programs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching pip programs
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the pip program in the entity cache if it is enabled.
	 *
	 * @param pipProgram the pip program
	 */
	public void cacheResult(PipProgram pipProgram);

	/**
	 * Caches the pip programs in the entity cache if it is enabled.
	 *
	 * @param pipPrograms the pip programs
	 */
	public void cacheResult(java.util.List<PipProgram> pipPrograms);

	/**
	 * Creates a new pip program with the primary key. Does not add the pip program to the database.
	 *
	 * @param pipProgramId the primary key for the new pip program
	 * @return the new pip program
	 */
	public PipProgram create(long pipProgramId);

	/**
	 * Removes the pip program with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pipProgramId the primary key of the pip program
	 * @return the pip program that was removed
	 * @throws NoSuchPipProgramException if a pip program with the primary key could not be found
	 */
	public PipProgram remove(long pipProgramId)
		throws NoSuchPipProgramException;

	public PipProgram updateImpl(PipProgram pipProgram);

	/**
	 * Returns the pip program with the primary key or throws a <code>NoSuchPipProgramException</code> if it could not be found.
	 *
	 * @param pipProgramId the primary key of the pip program
	 * @return the pip program
	 * @throws NoSuchPipProgramException if a pip program with the primary key could not be found
	 */
	public PipProgram findByPrimaryKey(long pipProgramId)
		throws NoSuchPipProgramException;

	/**
	 * Returns the pip program with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pipProgramId the primary key of the pip program
	 * @return the pip program, or <code>null</code> if a pip program with the primary key could not be found
	 */
	public PipProgram fetchByPrimaryKey(long pipProgramId);

	/**
	 * Returns all the pip programs.
	 *
	 * @return the pip programs
	 */
	public java.util.List<PipProgram> findAll();

	/**
	 * Returns a range of all the pip programs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @return the range of pip programs
	 */
	public java.util.List<PipProgram> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the pip programs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pip programs
	 */
	public java.util.List<PipProgram> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PipProgram>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pip programs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pip programs
	 */
	public java.util.List<PipProgram> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PipProgram>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pip programs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pip programs.
	 *
	 * @return the number of pip programs
	 */
	public int countAll();

}