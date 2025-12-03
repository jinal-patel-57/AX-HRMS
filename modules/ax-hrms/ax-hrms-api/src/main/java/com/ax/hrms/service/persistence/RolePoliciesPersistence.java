/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchRolePoliciesException;
import com.ax.hrms.model.RolePolicies;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the role policies service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RolePoliciesUtil
 * @generated
 */
@ProviderType
public interface RolePoliciesPersistence extends BasePersistence<RolePolicies> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RolePoliciesUtil} to access the role policies persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the role policieses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching role policieses
	 */
	public java.util.List<RolePolicies> findByUuid(String uuid);

	/**
	 * Returns a range of all the role policieses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @return the range of matching role policieses
	 */
	public java.util.List<RolePolicies> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the role policieses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role policieses
	 */
	public java.util.List<RolePolicies> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
			orderByComparator);

	/**
	 * Returns an ordered range of all the role policieses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role policieses
	 */
	public java.util.List<RolePolicies> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first role policies in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	public RolePolicies findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
				orderByComparator)
		throws NoSuchRolePoliciesException;

	/**
	 * Returns the first role policies in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	public RolePolicies fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
			orderByComparator);

	/**
	 * Returns the last role policies in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	public RolePolicies findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
				orderByComparator)
		throws NoSuchRolePoliciesException;

	/**
	 * Returns the last role policies in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	public RolePolicies fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
			orderByComparator);

	/**
	 * Returns the role policieses before and after the current role policies in the ordered set where uuid = &#63;.
	 *
	 * @param rolePoliciesId the primary key of the current role policies
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role policies
	 * @throws NoSuchRolePoliciesException if a role policies with the primary key could not be found
	 */
	public RolePolicies[] findByUuid_PrevAndNext(
			long rolePoliciesId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
				orderByComparator)
		throws NoSuchRolePoliciesException;

	/**
	 * Removes all the role policieses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of role policieses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching role policieses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the role policies where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRolePoliciesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	public RolePolicies findByUUID_G(String uuid, long groupId)
		throws NoSuchRolePoliciesException;

	/**
	 * Returns the role policies where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	public RolePolicies fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the role policies where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	public RolePolicies fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the role policies where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the role policies that was removed
	 */
	public RolePolicies removeByUUID_G(String uuid, long groupId)
		throws NoSuchRolePoliciesException;

	/**
	 * Returns the number of role policieses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching role policieses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the role policieses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching role policieses
	 */
	public java.util.List<RolePolicies> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the role policieses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @return the range of matching role policieses
	 */
	public java.util.List<RolePolicies> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the role policieses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role policieses
	 */
	public java.util.List<RolePolicies> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
			orderByComparator);

	/**
	 * Returns an ordered range of all the role policieses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role policieses
	 */
	public java.util.List<RolePolicies> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first role policies in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	public RolePolicies findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
				orderByComparator)
		throws NoSuchRolePoliciesException;

	/**
	 * Returns the first role policies in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	public RolePolicies fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
			orderByComparator);

	/**
	 * Returns the last role policies in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	public RolePolicies findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
				orderByComparator)
		throws NoSuchRolePoliciesException;

	/**
	 * Returns the last role policies in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	public RolePolicies fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
			orderByComparator);

	/**
	 * Returns the role policieses before and after the current role policies in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rolePoliciesId the primary key of the current role policies
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role policies
	 * @throws NoSuchRolePoliciesException if a role policies with the primary key could not be found
	 */
	public RolePolicies[] findByUuid_C_PrevAndNext(
			long rolePoliciesId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
				orderByComparator)
		throws NoSuchRolePoliciesException;

	/**
	 * Removes all the role policieses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of role policieses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching role policieses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the role policieses where policyId = &#63;.
	 *
	 * @param policyId the policy ID
	 * @return the matching role policieses
	 */
	public java.util.List<RolePolicies> findByPolicyId(long policyId);

	/**
	 * Returns a range of all the role policieses where policyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param policyId the policy ID
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @return the range of matching role policieses
	 */
	public java.util.List<RolePolicies> findByPolicyId(
		long policyId, int start, int end);

	/**
	 * Returns an ordered range of all the role policieses where policyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param policyId the policy ID
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role policieses
	 */
	public java.util.List<RolePolicies> findByPolicyId(
		long policyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
			orderByComparator);

	/**
	 * Returns an ordered range of all the role policieses where policyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param policyId the policy ID
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role policieses
	 */
	public java.util.List<RolePolicies> findByPolicyId(
		long policyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first role policies in the ordered set where policyId = &#63;.
	 *
	 * @param policyId the policy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	public RolePolicies findByPolicyId_First(
			long policyId,
			com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
				orderByComparator)
		throws NoSuchRolePoliciesException;

	/**
	 * Returns the first role policies in the ordered set where policyId = &#63;.
	 *
	 * @param policyId the policy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	public RolePolicies fetchByPolicyId_First(
		long policyId,
		com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
			orderByComparator);

	/**
	 * Returns the last role policies in the ordered set where policyId = &#63;.
	 *
	 * @param policyId the policy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	public RolePolicies findByPolicyId_Last(
			long policyId,
			com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
				orderByComparator)
		throws NoSuchRolePoliciesException;

	/**
	 * Returns the last role policies in the ordered set where policyId = &#63;.
	 *
	 * @param policyId the policy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	public RolePolicies fetchByPolicyId_Last(
		long policyId,
		com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
			orderByComparator);

	/**
	 * Returns the role policieses before and after the current role policies in the ordered set where policyId = &#63;.
	 *
	 * @param rolePoliciesId the primary key of the current role policies
	 * @param policyId the policy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role policies
	 * @throws NoSuchRolePoliciesException if a role policies with the primary key could not be found
	 */
	public RolePolicies[] findByPolicyId_PrevAndNext(
			long rolePoliciesId, long policyId,
			com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
				orderByComparator)
		throws NoSuchRolePoliciesException;

	/**
	 * Removes all the role policieses where policyId = &#63; from the database.
	 *
	 * @param policyId the policy ID
	 */
	public void removeByPolicyId(long policyId);

	/**
	 * Returns the number of role policieses where policyId = &#63;.
	 *
	 * @param policyId the policy ID
	 * @return the number of matching role policieses
	 */
	public int countByPolicyId(long policyId);

	/**
	 * Returns the role policies where policyId = &#63; and roleId = &#63; or throws a <code>NoSuchRolePoliciesException</code> if it could not be found.
	 *
	 * @param policyId the policy ID
	 * @param roleId the role ID
	 * @return the matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	public RolePolicies findByPolicyIdAndRoleId(long policyId, long roleId)
		throws NoSuchRolePoliciesException;

	/**
	 * Returns the role policies where policyId = &#63; and roleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyId the policy ID
	 * @param roleId the role ID
	 * @return the matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	public RolePolicies fetchByPolicyIdAndRoleId(long policyId, long roleId);

	/**
	 * Returns the role policies where policyId = &#63; and roleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyId the policy ID
	 * @param roleId the role ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	public RolePolicies fetchByPolicyIdAndRoleId(
		long policyId, long roleId, boolean useFinderCache);

	/**
	 * Removes the role policies where policyId = &#63; and roleId = &#63; from the database.
	 *
	 * @param policyId the policy ID
	 * @param roleId the role ID
	 * @return the role policies that was removed
	 */
	public RolePolicies removeByPolicyIdAndRoleId(long policyId, long roleId)
		throws NoSuchRolePoliciesException;

	/**
	 * Returns the number of role policieses where policyId = &#63; and roleId = &#63;.
	 *
	 * @param policyId the policy ID
	 * @param roleId the role ID
	 * @return the number of matching role policieses
	 */
	public int countByPolicyIdAndRoleId(long policyId, long roleId);

	/**
	 * Caches the role policies in the entity cache if it is enabled.
	 *
	 * @param rolePolicies the role policies
	 */
	public void cacheResult(RolePolicies rolePolicies);

	/**
	 * Caches the role policieses in the entity cache if it is enabled.
	 *
	 * @param rolePolicieses the role policieses
	 */
	public void cacheResult(java.util.List<RolePolicies> rolePolicieses);

	/**
	 * Creates a new role policies with the primary key. Does not add the role policies to the database.
	 *
	 * @param rolePoliciesId the primary key for the new role policies
	 * @return the new role policies
	 */
	public RolePolicies create(long rolePoliciesId);

	/**
	 * Removes the role policies with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rolePoliciesId the primary key of the role policies
	 * @return the role policies that was removed
	 * @throws NoSuchRolePoliciesException if a role policies with the primary key could not be found
	 */
	public RolePolicies remove(long rolePoliciesId)
		throws NoSuchRolePoliciesException;

	public RolePolicies updateImpl(RolePolicies rolePolicies);

	/**
	 * Returns the role policies with the primary key or throws a <code>NoSuchRolePoliciesException</code> if it could not be found.
	 *
	 * @param rolePoliciesId the primary key of the role policies
	 * @return the role policies
	 * @throws NoSuchRolePoliciesException if a role policies with the primary key could not be found
	 */
	public RolePolicies findByPrimaryKey(long rolePoliciesId)
		throws NoSuchRolePoliciesException;

	/**
	 * Returns the role policies with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rolePoliciesId the primary key of the role policies
	 * @return the role policies, or <code>null</code> if a role policies with the primary key could not be found
	 */
	public RolePolicies fetchByPrimaryKey(long rolePoliciesId);

	/**
	 * Returns all the role policieses.
	 *
	 * @return the role policieses
	 */
	public java.util.List<RolePolicies> findAll();

	/**
	 * Returns a range of all the role policieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @return the range of role policieses
	 */
	public java.util.List<RolePolicies> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the role policieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of role policieses
	 */
	public java.util.List<RolePolicies> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
			orderByComparator);

	/**
	 * Returns an ordered range of all the role policieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of role policieses
	 */
	public java.util.List<RolePolicies> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RolePolicies>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the role policieses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of role policieses.
	 *
	 * @return the number of role policieses
	 */
	public int countAll();

}