/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchPolicyException;
import com.ax.hrms.model.Policy;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the policy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyUtil
 * @generated
 */
@ProviderType
public interface PolicyPersistence extends BasePersistence<Policy> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PolicyUtil} to access the policy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the policies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching policies
	 */
	public java.util.List<Policy> findByUuid(String uuid);

	/**
	 * Returns a range of all the policies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @return the range of matching policies
	 */
	public java.util.List<Policy> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the policies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policies
	 */
	public java.util.List<Policy> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator);

	/**
	 * Returns an ordered range of all the policies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policies
	 */
	public java.util.List<Policy> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first policy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public Policy findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Policy>
				orderByComparator)
		throws NoSuchPolicyException;

	/**
	 * Returns the first policy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public Policy fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator);

	/**
	 * Returns the last policy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public Policy findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Policy>
				orderByComparator)
		throws NoSuchPolicyException;

	/**
	 * Returns the last policy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public Policy fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator);

	/**
	 * Returns the policies before and after the current policy in the ordered set where uuid = &#63;.
	 *
	 * @param policyId the primary key of the current policy
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy
	 * @throws NoSuchPolicyException if a policy with the primary key could not be found
	 */
	public Policy[] findByUuid_PrevAndNext(
			long policyId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Policy>
				orderByComparator)
		throws NoSuchPolicyException;

	/**
	 * Removes all the policies where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of policies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching policies
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the policy where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPolicyException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public Policy findByUUID_G(String uuid, long groupId)
		throws NoSuchPolicyException;

	/**
	 * Returns the policy where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public Policy fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the policy where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public Policy fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the policy where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the policy that was removed
	 */
	public Policy removeByUUID_G(String uuid, long groupId)
		throws NoSuchPolicyException;

	/**
	 * Returns the number of policies where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching policies
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the policies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching policies
	 */
	public java.util.List<Policy> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the policies where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @return the range of matching policies
	 */
	public java.util.List<Policy> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the policies where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policies
	 */
	public java.util.List<Policy> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator);

	/**
	 * Returns an ordered range of all the policies where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policies
	 */
	public java.util.List<Policy> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first policy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public Policy findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Policy>
				orderByComparator)
		throws NoSuchPolicyException;

	/**
	 * Returns the first policy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public Policy fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator);

	/**
	 * Returns the last policy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public Policy findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Policy>
				orderByComparator)
		throws NoSuchPolicyException;

	/**
	 * Returns the last policy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public Policy fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator);

	/**
	 * Returns the policies before and after the current policy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param policyId the primary key of the current policy
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy
	 * @throws NoSuchPolicyException if a policy with the primary key could not be found
	 */
	public Policy[] findByUuid_C_PrevAndNext(
			long policyId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Policy>
				orderByComparator)
		throws NoSuchPolicyException;

	/**
	 * Removes all the policies where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of policies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching policies
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the policies where year = &#63;.
	 *
	 * @param year the year
	 * @return the matching policies
	 */
	public java.util.List<Policy> findByYear(int year);

	/**
	 * Returns a range of all the policies where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @return the range of matching policies
	 */
	public java.util.List<Policy> findByYear(int year, int start, int end);

	/**
	 * Returns an ordered range of all the policies where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policies
	 */
	public java.util.List<Policy> findByYear(
		int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator);

	/**
	 * Returns an ordered range of all the policies where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policies
	 */
	public java.util.List<Policy> findByYear(
		int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first policy in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public Policy findByYear_First(
			int year,
			com.liferay.portal.kernel.util.OrderByComparator<Policy>
				orderByComparator)
		throws NoSuchPolicyException;

	/**
	 * Returns the first policy in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public Policy fetchByYear_First(
		int year,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator);

	/**
	 * Returns the last policy in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public Policy findByYear_Last(
			int year,
			com.liferay.portal.kernel.util.OrderByComparator<Policy>
				orderByComparator)
		throws NoSuchPolicyException;

	/**
	 * Returns the last policy in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public Policy fetchByYear_Last(
		int year,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator);

	/**
	 * Returns the policies before and after the current policy in the ordered set where year = &#63;.
	 *
	 * @param policyId the primary key of the current policy
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy
	 * @throws NoSuchPolicyException if a policy with the primary key could not be found
	 */
	public Policy[] findByYear_PrevAndNext(
			long policyId, int year,
			com.liferay.portal.kernel.util.OrderByComparator<Policy>
				orderByComparator)
		throws NoSuchPolicyException;

	/**
	 * Removes all the policies where year = &#63; from the database.
	 *
	 * @param year the year
	 */
	public void removeByYear(int year);

	/**
	 * Returns the number of policies where year = &#63;.
	 *
	 * @param year the year
	 * @return the number of matching policies
	 */
	public int countByYear(int year);

	/**
	 * Returns the policy where policyTypeId = &#63; and year = &#63; or throws a <code>NoSuchPolicyException</code> if it could not be found.
	 *
	 * @param policyTypeId the policy type ID
	 * @param year the year
	 * @return the matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public Policy findByPolicyTypeIdAndPolicyYear(long policyTypeId, int year)
		throws NoSuchPolicyException;

	/**
	 * Returns the policy where policyTypeId = &#63; and year = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyTypeId the policy type ID
	 * @param year the year
	 * @return the matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public Policy fetchByPolicyTypeIdAndPolicyYear(long policyTypeId, int year);

	/**
	 * Returns the policy where policyTypeId = &#63; and year = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyTypeId the policy type ID
	 * @param year the year
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public Policy fetchByPolicyTypeIdAndPolicyYear(
		long policyTypeId, int year, boolean useFinderCache);

	/**
	 * Removes the policy where policyTypeId = &#63; and year = &#63; from the database.
	 *
	 * @param policyTypeId the policy type ID
	 * @param year the year
	 * @return the policy that was removed
	 */
	public Policy removeByPolicyTypeIdAndPolicyYear(long policyTypeId, int year)
		throws NoSuchPolicyException;

	/**
	 * Returns the number of policies where policyTypeId = &#63; and year = &#63;.
	 *
	 * @param policyTypeId the policy type ID
	 * @param year the year
	 * @return the number of matching policies
	 */
	public int countByPolicyTypeIdAndPolicyYear(long policyTypeId, int year);

	/**
	 * Caches the policy in the entity cache if it is enabled.
	 *
	 * @param policy the policy
	 */
	public void cacheResult(Policy policy);

	/**
	 * Caches the policies in the entity cache if it is enabled.
	 *
	 * @param policies the policies
	 */
	public void cacheResult(java.util.List<Policy> policies);

	/**
	 * Creates a new policy with the primary key. Does not add the policy to the database.
	 *
	 * @param policyId the primary key for the new policy
	 * @return the new policy
	 */
	public Policy create(long policyId);

	/**
	 * Removes the policy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyId the primary key of the policy
	 * @return the policy that was removed
	 * @throws NoSuchPolicyException if a policy with the primary key could not be found
	 */
	public Policy remove(long policyId) throws NoSuchPolicyException;

	public Policy updateImpl(Policy policy);

	/**
	 * Returns the policy with the primary key or throws a <code>NoSuchPolicyException</code> if it could not be found.
	 *
	 * @param policyId the primary key of the policy
	 * @return the policy
	 * @throws NoSuchPolicyException if a policy with the primary key could not be found
	 */
	public Policy findByPrimaryKey(long policyId) throws NoSuchPolicyException;

	/**
	 * Returns the policy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyId the primary key of the policy
	 * @return the policy, or <code>null</code> if a policy with the primary key could not be found
	 */
	public Policy fetchByPrimaryKey(long policyId);

	/**
	 * Returns all the policies.
	 *
	 * @return the policies
	 */
	public java.util.List<Policy> findAll();

	/**
	 * Returns a range of all the policies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @return the range of policies
	 */
	public java.util.List<Policy> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the policies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of policies
	 */
	public java.util.List<Policy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator);

	/**
	 * Returns an ordered range of all the policies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of policies
	 */
	public java.util.List<Policy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the policies from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of policies.
	 *
	 * @return the number of policies
	 */
	public int countAll();

}