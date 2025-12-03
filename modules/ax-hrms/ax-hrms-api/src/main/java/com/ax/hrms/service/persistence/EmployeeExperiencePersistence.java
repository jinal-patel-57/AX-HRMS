/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchEmployeeExperienceException;
import com.ax.hrms.model.EmployeeExperience;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee experience service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeExperienceUtil
 * @generated
 */
@ProviderType
public interface EmployeeExperiencePersistence
	extends BasePersistence<EmployeeExperience> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeExperienceUtil} to access the employee experience persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee experiences where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByUuid(String uuid);

	/**
	 * Returns a range of all the employee experiences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @return the range of matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the employee experiences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee experiences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public EmployeeExperience findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
				orderByComparator)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Returns the first employee experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public EmployeeExperience fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns the last employee experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public EmployeeExperience findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
				orderByComparator)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Returns the last employee experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public EmployeeExperience fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns the employee experiences before and after the current employee experience in the ordered set where uuid = &#63;.
	 *
	 * @param experienceId the primary key of the current employee experience
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	public EmployeeExperience[] findByUuid_PrevAndNext(
			long experienceId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
				orderByComparator)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Removes all the employee experiences where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of employee experiences where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee experiences
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the employee experience where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeExperienceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public EmployeeExperience findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Returns the employee experience where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public EmployeeExperience fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the employee experience where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public EmployeeExperience fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the employee experience where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee experience that was removed
	 */
	public EmployeeExperience removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Returns the number of employee experiences where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee experiences
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the employee experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the employee experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @return the range of matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the employee experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public EmployeeExperience findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
				orderByComparator)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Returns the first employee experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public EmployeeExperience fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns the last employee experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public EmployeeExperience findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
				orderByComparator)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Returns the last employee experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public EmployeeExperience fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns the employee experiences before and after the current employee experience in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param experienceId the primary key of the current employee experience
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	public EmployeeExperience[] findByUuid_C_PrevAndNext(
			long experienceId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
				orderByComparator)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Removes all the employee experiences where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of employee experiences where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee experiences
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the employee experiences where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByEmployeeId(long employeeId);

	/**
	 * Returns a range of all the employee experiences where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @return the range of matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee experiences where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee experiences where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public EmployeeExperience findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
				orderByComparator)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Returns the first employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public EmployeeExperience fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns the last employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public EmployeeExperience findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
				orderByComparator)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Returns the last employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public EmployeeExperience fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns the employee experiences before and after the current employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param experienceId the primary key of the current employee experience
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	public EmployeeExperience[] findByEmployeeId_PrevAndNext(
			long experienceId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
				orderByComparator)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Removes all the employee experiences where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee experiences where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee experiences
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee experience in the entity cache if it is enabled.
	 *
	 * @param employeeExperience the employee experience
	 */
	public void cacheResult(EmployeeExperience employeeExperience);

	/**
	 * Caches the employee experiences in the entity cache if it is enabled.
	 *
	 * @param employeeExperiences the employee experiences
	 */
	public void cacheResult(
		java.util.List<EmployeeExperience> employeeExperiences);

	/**
	 * Creates a new employee experience with the primary key. Does not add the employee experience to the database.
	 *
	 * @param experienceId the primary key for the new employee experience
	 * @return the new employee experience
	 */
	public EmployeeExperience create(long experienceId);

	/**
	 * Removes the employee experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param experienceId the primary key of the employee experience
	 * @return the employee experience that was removed
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	public EmployeeExperience remove(long experienceId)
		throws NoSuchEmployeeExperienceException;

	public EmployeeExperience updateImpl(EmployeeExperience employeeExperience);

	/**
	 * Returns the employee experience with the primary key or throws a <code>NoSuchEmployeeExperienceException</code> if it could not be found.
	 *
	 * @param experienceId the primary key of the employee experience
	 * @return the employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	public EmployeeExperience findByPrimaryKey(long experienceId)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Returns the employee experience with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param experienceId the primary key of the employee experience
	 * @return the employee experience, or <code>null</code> if a employee experience with the primary key could not be found
	 */
	public EmployeeExperience fetchByPrimaryKey(long experienceId);

	/**
	 * Returns all the employee experiences.
	 *
	 * @return the employee experiences
	 */
	public java.util.List<EmployeeExperience> findAll();

	/**
	 * Returns a range of all the employee experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @return the range of employee experiences
	 */
	public java.util.List<EmployeeExperience> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee experiences
	 */
	public java.util.List<EmployeeExperience> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee experiences
	 */
	public java.util.List<EmployeeExperience> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee experiences from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee experiences.
	 *
	 * @return the number of employee experiences
	 */
	public int countAll();

}