/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.Policy;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the policy service. This utility wraps <code>com.ax.hrms.service.persistence.impl.PolicyPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyPersistence
 * @generated
 */
public class PolicyUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Policy policy) {
		getPersistence().clearCache(policy);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Policy> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Policy> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Policy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Policy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Policy> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Policy update(Policy policy) {
		return getPersistence().update(policy);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Policy update(Policy policy, ServiceContext serviceContext) {
		return getPersistence().update(policy, serviceContext);
	}

	/**
	 * Returns all the policies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching policies
	 */
	public static List<Policy> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Policy> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Policy> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Policy> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Policy> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Policy> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first policy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public static Policy findByUuid_First(
			String uuid, OrderByComparator<Policy> orderByComparator)
		throws com.ax.hrms.exception.NoSuchPolicyException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first policy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public static Policy fetchByUuid_First(
		String uuid, OrderByComparator<Policy> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last policy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public static Policy findByUuid_Last(
			String uuid, OrderByComparator<Policy> orderByComparator)
		throws com.ax.hrms.exception.NoSuchPolicyException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last policy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public static Policy fetchByUuid_Last(
		String uuid, OrderByComparator<Policy> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the policies before and after the current policy in the ordered set where uuid = &#63;.
	 *
	 * @param policyId the primary key of the current policy
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy
	 * @throws NoSuchPolicyException if a policy with the primary key could not be found
	 */
	public static Policy[] findByUuid_PrevAndNext(
			long policyId, String uuid,
			OrderByComparator<Policy> orderByComparator)
		throws com.ax.hrms.exception.NoSuchPolicyException {

		return getPersistence().findByUuid_PrevAndNext(
			policyId, uuid, orderByComparator);
	}

	/**
	 * Removes all the policies where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of policies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching policies
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the policy where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPolicyException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public static Policy findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchPolicyException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the policy where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public static Policy fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the policy where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public static Policy fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the policy where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the policy that was removed
	 */
	public static Policy removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchPolicyException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of policies where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching policies
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the policies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching policies
	 */
	public static List<Policy> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<Policy> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<Policy> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Policy> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<Policy> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Policy> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first policy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public static Policy findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Policy> orderByComparator)
		throws com.ax.hrms.exception.NoSuchPolicyException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first policy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public static Policy fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Policy> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last policy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public static Policy findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Policy> orderByComparator)
		throws com.ax.hrms.exception.NoSuchPolicyException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last policy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public static Policy fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Policy> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static Policy[] findByUuid_C_PrevAndNext(
			long policyId, String uuid, long companyId,
			OrderByComparator<Policy> orderByComparator)
		throws com.ax.hrms.exception.NoSuchPolicyException {

		return getPersistence().findByUuid_C_PrevAndNext(
			policyId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the policies where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of policies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching policies
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the policies where year = &#63;.
	 *
	 * @param year the year
	 * @return the matching policies
	 */
	public static List<Policy> findByYear(int year) {
		return getPersistence().findByYear(year);
	}

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
	public static List<Policy> findByYear(int year, int start, int end) {
		return getPersistence().findByYear(year, start, end);
	}

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
	public static List<Policy> findByYear(
		int year, int start, int end,
		OrderByComparator<Policy> orderByComparator) {

		return getPersistence().findByYear(year, start, end, orderByComparator);
	}

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
	public static List<Policy> findByYear(
		int year, int start, int end,
		OrderByComparator<Policy> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByYear(
			year, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first policy in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public static Policy findByYear_First(
			int year, OrderByComparator<Policy> orderByComparator)
		throws com.ax.hrms.exception.NoSuchPolicyException {

		return getPersistence().findByYear_First(year, orderByComparator);
	}

	/**
	 * Returns the first policy in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public static Policy fetchByYear_First(
		int year, OrderByComparator<Policy> orderByComparator) {

		return getPersistence().fetchByYear_First(year, orderByComparator);
	}

	/**
	 * Returns the last policy in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public static Policy findByYear_Last(
			int year, OrderByComparator<Policy> orderByComparator)
		throws com.ax.hrms.exception.NoSuchPolicyException {

		return getPersistence().findByYear_Last(year, orderByComparator);
	}

	/**
	 * Returns the last policy in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public static Policy fetchByYear_Last(
		int year, OrderByComparator<Policy> orderByComparator) {

		return getPersistence().fetchByYear_Last(year, orderByComparator);
	}

	/**
	 * Returns the policies before and after the current policy in the ordered set where year = &#63;.
	 *
	 * @param policyId the primary key of the current policy
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy
	 * @throws NoSuchPolicyException if a policy with the primary key could not be found
	 */
	public static Policy[] findByYear_PrevAndNext(
			long policyId, int year,
			OrderByComparator<Policy> orderByComparator)
		throws com.ax.hrms.exception.NoSuchPolicyException {

		return getPersistence().findByYear_PrevAndNext(
			policyId, year, orderByComparator);
	}

	/**
	 * Removes all the policies where year = &#63; from the database.
	 *
	 * @param year the year
	 */
	public static void removeByYear(int year) {
		getPersistence().removeByYear(year);
	}

	/**
	 * Returns the number of policies where year = &#63;.
	 *
	 * @param year the year
	 * @return the number of matching policies
	 */
	public static int countByYear(int year) {
		return getPersistence().countByYear(year);
	}

	/**
	 * Returns the policy where policyTypeId = &#63; and year = &#63; or throws a <code>NoSuchPolicyException</code> if it could not be found.
	 *
	 * @param policyTypeId the policy type ID
	 * @param year the year
	 * @return the matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public static Policy findByPolicyTypeIdAndPolicyYear(
			long policyTypeId, int year)
		throws com.ax.hrms.exception.NoSuchPolicyException {

		return getPersistence().findByPolicyTypeIdAndPolicyYear(
			policyTypeId, year);
	}

	/**
	 * Returns the policy where policyTypeId = &#63; and year = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyTypeId the policy type ID
	 * @param year the year
	 * @return the matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public static Policy fetchByPolicyTypeIdAndPolicyYear(
		long policyTypeId, int year) {

		return getPersistence().fetchByPolicyTypeIdAndPolicyYear(
			policyTypeId, year);
	}

	/**
	 * Returns the policy where policyTypeId = &#63; and year = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyTypeId the policy type ID
	 * @param year the year
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public static Policy fetchByPolicyTypeIdAndPolicyYear(
		long policyTypeId, int year, boolean useFinderCache) {

		return getPersistence().fetchByPolicyTypeIdAndPolicyYear(
			policyTypeId, year, useFinderCache);
	}

	/**
	 * Removes the policy where policyTypeId = &#63; and year = &#63; from the database.
	 *
	 * @param policyTypeId the policy type ID
	 * @param year the year
	 * @return the policy that was removed
	 */
	public static Policy removeByPolicyTypeIdAndPolicyYear(
			long policyTypeId, int year)
		throws com.ax.hrms.exception.NoSuchPolicyException {

		return getPersistence().removeByPolicyTypeIdAndPolicyYear(
			policyTypeId, year);
	}

	/**
	 * Returns the number of policies where policyTypeId = &#63; and year = &#63;.
	 *
	 * @param policyTypeId the policy type ID
	 * @param year the year
	 * @return the number of matching policies
	 */
	public static int countByPolicyTypeIdAndPolicyYear(
		long policyTypeId, int year) {

		return getPersistence().countByPolicyTypeIdAndPolicyYear(
			policyTypeId, year);
	}

	/**
	 * Caches the policy in the entity cache if it is enabled.
	 *
	 * @param policy the policy
	 */
	public static void cacheResult(Policy policy) {
		getPersistence().cacheResult(policy);
	}

	/**
	 * Caches the policies in the entity cache if it is enabled.
	 *
	 * @param policies the policies
	 */
	public static void cacheResult(List<Policy> policies) {
		getPersistence().cacheResult(policies);
	}

	/**
	 * Creates a new policy with the primary key. Does not add the policy to the database.
	 *
	 * @param policyId the primary key for the new policy
	 * @return the new policy
	 */
	public static Policy create(long policyId) {
		return getPersistence().create(policyId);
	}

	/**
	 * Removes the policy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyId the primary key of the policy
	 * @return the policy that was removed
	 * @throws NoSuchPolicyException if a policy with the primary key could not be found
	 */
	public static Policy remove(long policyId)
		throws com.ax.hrms.exception.NoSuchPolicyException {

		return getPersistence().remove(policyId);
	}

	public static Policy updateImpl(Policy policy) {
		return getPersistence().updateImpl(policy);
	}

	/**
	 * Returns the policy with the primary key or throws a <code>NoSuchPolicyException</code> if it could not be found.
	 *
	 * @param policyId the primary key of the policy
	 * @return the policy
	 * @throws NoSuchPolicyException if a policy with the primary key could not be found
	 */
	public static Policy findByPrimaryKey(long policyId)
		throws com.ax.hrms.exception.NoSuchPolicyException {

		return getPersistence().findByPrimaryKey(policyId);
	}

	/**
	 * Returns the policy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyId the primary key of the policy
	 * @return the policy, or <code>null</code> if a policy with the primary key could not be found
	 */
	public static Policy fetchByPrimaryKey(long policyId) {
		return getPersistence().fetchByPrimaryKey(policyId);
	}

	/**
	 * Returns all the policies.
	 *
	 * @return the policies
	 */
	public static List<Policy> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Policy> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Policy> findAll(
		int start, int end, OrderByComparator<Policy> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Policy> findAll(
		int start, int end, OrderByComparator<Policy> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the policies from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of policies.
	 *
	 * @return the number of policies
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PolicyPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(PolicyPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile PolicyPersistence _persistence;

}