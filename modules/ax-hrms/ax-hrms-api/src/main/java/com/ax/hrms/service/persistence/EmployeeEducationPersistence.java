/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchEmployeeEducationException;
import com.ax.hrms.model.EmployeeEducation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee education service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeEducationUtil
 * @generated
 */
@ProviderType
public interface EmployeeEducationPersistence
	extends BasePersistence<EmployeeEducation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeEducationUtil} to access the employee education persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee educations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee educations
	 */
	public java.util.List<EmployeeEducation> findByUuid(String uuid);

	/**
	 * Returns a range of all the employee educations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @return the range of matching employee educations
	 */
	public java.util.List<EmployeeEducation> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the employee educations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee educations
	 */
	public java.util.List<EmployeeEducation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee educations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee educations
	 */
	public java.util.List<EmployeeEducation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee education in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee education
	 * @throws NoSuchEmployeeEducationException if a matching employee education could not be found
	 */
	public EmployeeEducation findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
				orderByComparator)
		throws NoSuchEmployeeEducationException;

	/**
	 * Returns the first employee education in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee education, or <code>null</code> if a matching employee education could not be found
	 */
	public EmployeeEducation fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
			orderByComparator);

	/**
	 * Returns the last employee education in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee education
	 * @throws NoSuchEmployeeEducationException if a matching employee education could not be found
	 */
	public EmployeeEducation findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
				orderByComparator)
		throws NoSuchEmployeeEducationException;

	/**
	 * Returns the last employee education in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee education, or <code>null</code> if a matching employee education could not be found
	 */
	public EmployeeEducation fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
			orderByComparator);

	/**
	 * Returns the employee educations before and after the current employee education in the ordered set where uuid = &#63;.
	 *
	 * @param educationId the primary key of the current employee education
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee education
	 * @throws NoSuchEmployeeEducationException if a employee education with the primary key could not be found
	 */
	public EmployeeEducation[] findByUuid_PrevAndNext(
			long educationId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
				orderByComparator)
		throws NoSuchEmployeeEducationException;

	/**
	 * Removes all the employee educations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of employee educations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee educations
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the employee education where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeEducationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee education
	 * @throws NoSuchEmployeeEducationException if a matching employee education could not be found
	 */
	public EmployeeEducation findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeEducationException;

	/**
	 * Returns the employee education where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee education, or <code>null</code> if a matching employee education could not be found
	 */
	public EmployeeEducation fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the employee education where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee education, or <code>null</code> if a matching employee education could not be found
	 */
	public EmployeeEducation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the employee education where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee education that was removed
	 */
	public EmployeeEducation removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeEducationException;

	/**
	 * Returns the number of employee educations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee educations
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the employee educations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee educations
	 */
	public java.util.List<EmployeeEducation> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the employee educations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @return the range of matching employee educations
	 */
	public java.util.List<EmployeeEducation> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the employee educations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee educations
	 */
	public java.util.List<EmployeeEducation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee educations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee educations
	 */
	public java.util.List<EmployeeEducation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee education in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee education
	 * @throws NoSuchEmployeeEducationException if a matching employee education could not be found
	 */
	public EmployeeEducation findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
				orderByComparator)
		throws NoSuchEmployeeEducationException;

	/**
	 * Returns the first employee education in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee education, or <code>null</code> if a matching employee education could not be found
	 */
	public EmployeeEducation fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
			orderByComparator);

	/**
	 * Returns the last employee education in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee education
	 * @throws NoSuchEmployeeEducationException if a matching employee education could not be found
	 */
	public EmployeeEducation findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
				orderByComparator)
		throws NoSuchEmployeeEducationException;

	/**
	 * Returns the last employee education in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee education, or <code>null</code> if a matching employee education could not be found
	 */
	public EmployeeEducation fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
			orderByComparator);

	/**
	 * Returns the employee educations before and after the current employee education in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param educationId the primary key of the current employee education
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee education
	 * @throws NoSuchEmployeeEducationException if a employee education with the primary key could not be found
	 */
	public EmployeeEducation[] findByUuid_C_PrevAndNext(
			long educationId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
				orderByComparator)
		throws NoSuchEmployeeEducationException;

	/**
	 * Removes all the employee educations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of employee educations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee educations
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the employee educations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee educations
	 */
	public java.util.List<EmployeeEducation> findByEmployeeId(long employeeId);

	/**
	 * Returns a range of all the employee educations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @return the range of matching employee educations
	 */
	public java.util.List<EmployeeEducation> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee educations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee educations
	 */
	public java.util.List<EmployeeEducation> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee educations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee educations
	 */
	public java.util.List<EmployeeEducation> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee education in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee education
	 * @throws NoSuchEmployeeEducationException if a matching employee education could not be found
	 */
	public EmployeeEducation findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
				orderByComparator)
		throws NoSuchEmployeeEducationException;

	/**
	 * Returns the first employee education in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee education, or <code>null</code> if a matching employee education could not be found
	 */
	public EmployeeEducation fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
			orderByComparator);

	/**
	 * Returns the last employee education in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee education
	 * @throws NoSuchEmployeeEducationException if a matching employee education could not be found
	 */
	public EmployeeEducation findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
				orderByComparator)
		throws NoSuchEmployeeEducationException;

	/**
	 * Returns the last employee education in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee education, or <code>null</code> if a matching employee education could not be found
	 */
	public EmployeeEducation fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
			orderByComparator);

	/**
	 * Returns the employee educations before and after the current employee education in the ordered set where employeeId = &#63;.
	 *
	 * @param educationId the primary key of the current employee education
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee education
	 * @throws NoSuchEmployeeEducationException if a employee education with the primary key could not be found
	 */
	public EmployeeEducation[] findByEmployeeId_PrevAndNext(
			long educationId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
				orderByComparator)
		throws NoSuchEmployeeEducationException;

	/**
	 * Removes all the employee educations where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee educations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee educations
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee education in the entity cache if it is enabled.
	 *
	 * @param employeeEducation the employee education
	 */
	public void cacheResult(EmployeeEducation employeeEducation);

	/**
	 * Caches the employee educations in the entity cache if it is enabled.
	 *
	 * @param employeeEducations the employee educations
	 */
	public void cacheResult(
		java.util.List<EmployeeEducation> employeeEducations);

	/**
	 * Creates a new employee education with the primary key. Does not add the employee education to the database.
	 *
	 * @param educationId the primary key for the new employee education
	 * @return the new employee education
	 */
	public EmployeeEducation create(long educationId);

	/**
	 * Removes the employee education with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param educationId the primary key of the employee education
	 * @return the employee education that was removed
	 * @throws NoSuchEmployeeEducationException if a employee education with the primary key could not be found
	 */
	public EmployeeEducation remove(long educationId)
		throws NoSuchEmployeeEducationException;

	public EmployeeEducation updateImpl(EmployeeEducation employeeEducation);

	/**
	 * Returns the employee education with the primary key or throws a <code>NoSuchEmployeeEducationException</code> if it could not be found.
	 *
	 * @param educationId the primary key of the employee education
	 * @return the employee education
	 * @throws NoSuchEmployeeEducationException if a employee education with the primary key could not be found
	 */
	public EmployeeEducation findByPrimaryKey(long educationId)
		throws NoSuchEmployeeEducationException;

	/**
	 * Returns the employee education with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param educationId the primary key of the employee education
	 * @return the employee education, or <code>null</code> if a employee education with the primary key could not be found
	 */
	public EmployeeEducation fetchByPrimaryKey(long educationId);

	/**
	 * Returns all the employee educations.
	 *
	 * @return the employee educations
	 */
	public java.util.List<EmployeeEducation> findAll();

	/**
	 * Returns a range of all the employee educations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @return the range of employee educations
	 */
	public java.util.List<EmployeeEducation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee educations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee educations
	 */
	public java.util.List<EmployeeEducation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee educations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEducationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee educations
	 * @param end the upper bound of the range of employee educations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee educations
	 */
	public java.util.List<EmployeeEducation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeEducation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee educations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee educations.
	 *
	 * @return the number of employee educations
	 */
	public int countAll();

}