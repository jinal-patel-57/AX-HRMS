/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.RolePolicies;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the role policies service. This utility wraps <code>com.ax.hrms.service.persistence.impl.RolePoliciesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RolePoliciesPersistence
 * @generated
 */
public class RolePoliciesUtil {

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
	public static void clearCache(RolePolicies rolePolicies) {
		getPersistence().clearCache(rolePolicies);
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
	public static Map<Serializable, RolePolicies> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RolePolicies> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RolePolicies> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RolePolicies> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RolePolicies> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RolePolicies update(RolePolicies rolePolicies) {
		return getPersistence().update(rolePolicies);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RolePolicies update(
		RolePolicies rolePolicies, ServiceContext serviceContext) {

		return getPersistence().update(rolePolicies, serviceContext);
	}

	/**
	 * Returns all the role policieses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching role policieses
	 */
	public static List<RolePolicies> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<RolePolicies> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<RolePolicies> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RolePolicies> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<RolePolicies> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RolePolicies> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first role policies in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	public static RolePolicies findByUuid_First(
			String uuid, OrderByComparator<RolePolicies> orderByComparator)
		throws com.ax.hrms.exception.NoSuchRolePoliciesException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first role policies in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	public static RolePolicies fetchByUuid_First(
		String uuid, OrderByComparator<RolePolicies> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last role policies in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	public static RolePolicies findByUuid_Last(
			String uuid, OrderByComparator<RolePolicies> orderByComparator)
		throws com.ax.hrms.exception.NoSuchRolePoliciesException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last role policies in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	public static RolePolicies fetchByUuid_Last(
		String uuid, OrderByComparator<RolePolicies> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the role policieses before and after the current role policies in the ordered set where uuid = &#63;.
	 *
	 * @param rolePoliciesId the primary key of the current role policies
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role policies
	 * @throws NoSuchRolePoliciesException if a role policies with the primary key could not be found
	 */
	public static RolePolicies[] findByUuid_PrevAndNext(
			long rolePoliciesId, String uuid,
			OrderByComparator<RolePolicies> orderByComparator)
		throws com.ax.hrms.exception.NoSuchRolePoliciesException {

		return getPersistence().findByUuid_PrevAndNext(
			rolePoliciesId, uuid, orderByComparator);
	}

	/**
	 * Removes all the role policieses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of role policieses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching role policieses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the role policies where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRolePoliciesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	public static RolePolicies findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchRolePoliciesException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the role policies where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	public static RolePolicies fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the role policies where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	public static RolePolicies fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the role policies where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the role policies that was removed
	 */
	public static RolePolicies removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchRolePoliciesException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of role policieses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching role policieses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the role policieses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching role policieses
	 */
	public static List<RolePolicies> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<RolePolicies> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<RolePolicies> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RolePolicies> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<RolePolicies> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RolePolicies> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first role policies in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	public static RolePolicies findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<RolePolicies> orderByComparator)
		throws com.ax.hrms.exception.NoSuchRolePoliciesException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first role policies in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	public static RolePolicies fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<RolePolicies> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last role policies in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	public static RolePolicies findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<RolePolicies> orderByComparator)
		throws com.ax.hrms.exception.NoSuchRolePoliciesException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last role policies in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	public static RolePolicies fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<RolePolicies> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static RolePolicies[] findByUuid_C_PrevAndNext(
			long rolePoliciesId, String uuid, long companyId,
			OrderByComparator<RolePolicies> orderByComparator)
		throws com.ax.hrms.exception.NoSuchRolePoliciesException {

		return getPersistence().findByUuid_C_PrevAndNext(
			rolePoliciesId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the role policieses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of role policieses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching role policieses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the role policieses where policyId = &#63;.
	 *
	 * @param policyId the policy ID
	 * @return the matching role policieses
	 */
	public static List<RolePolicies> findByPolicyId(long policyId) {
		return getPersistence().findByPolicyId(policyId);
	}

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
	public static List<RolePolicies> findByPolicyId(
		long policyId, int start, int end) {

		return getPersistence().findByPolicyId(policyId, start, end);
	}

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
	public static List<RolePolicies> findByPolicyId(
		long policyId, int start, int end,
		OrderByComparator<RolePolicies> orderByComparator) {

		return getPersistence().findByPolicyId(
			policyId, start, end, orderByComparator);
	}

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
	public static List<RolePolicies> findByPolicyId(
		long policyId, int start, int end,
		OrderByComparator<RolePolicies> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPolicyId(
			policyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first role policies in the ordered set where policyId = &#63;.
	 *
	 * @param policyId the policy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	public static RolePolicies findByPolicyId_First(
			long policyId, OrderByComparator<RolePolicies> orderByComparator)
		throws com.ax.hrms.exception.NoSuchRolePoliciesException {

		return getPersistence().findByPolicyId_First(
			policyId, orderByComparator);
	}

	/**
	 * Returns the first role policies in the ordered set where policyId = &#63;.
	 *
	 * @param policyId the policy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	public static RolePolicies fetchByPolicyId_First(
		long policyId, OrderByComparator<RolePolicies> orderByComparator) {

		return getPersistence().fetchByPolicyId_First(
			policyId, orderByComparator);
	}

	/**
	 * Returns the last role policies in the ordered set where policyId = &#63;.
	 *
	 * @param policyId the policy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	public static RolePolicies findByPolicyId_Last(
			long policyId, OrderByComparator<RolePolicies> orderByComparator)
		throws com.ax.hrms.exception.NoSuchRolePoliciesException {

		return getPersistence().findByPolicyId_Last(
			policyId, orderByComparator);
	}

	/**
	 * Returns the last role policies in the ordered set where policyId = &#63;.
	 *
	 * @param policyId the policy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	public static RolePolicies fetchByPolicyId_Last(
		long policyId, OrderByComparator<RolePolicies> orderByComparator) {

		return getPersistence().fetchByPolicyId_Last(
			policyId, orderByComparator);
	}

	/**
	 * Returns the role policieses before and after the current role policies in the ordered set where policyId = &#63;.
	 *
	 * @param rolePoliciesId the primary key of the current role policies
	 * @param policyId the policy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role policies
	 * @throws NoSuchRolePoliciesException if a role policies with the primary key could not be found
	 */
	public static RolePolicies[] findByPolicyId_PrevAndNext(
			long rolePoliciesId, long policyId,
			OrderByComparator<RolePolicies> orderByComparator)
		throws com.ax.hrms.exception.NoSuchRolePoliciesException {

		return getPersistence().findByPolicyId_PrevAndNext(
			rolePoliciesId, policyId, orderByComparator);
	}

	/**
	 * Removes all the role policieses where policyId = &#63; from the database.
	 *
	 * @param policyId the policy ID
	 */
	public static void removeByPolicyId(long policyId) {
		getPersistence().removeByPolicyId(policyId);
	}

	/**
	 * Returns the number of role policieses where policyId = &#63;.
	 *
	 * @param policyId the policy ID
	 * @return the number of matching role policieses
	 */
	public static int countByPolicyId(long policyId) {
		return getPersistence().countByPolicyId(policyId);
	}

	/**
	 * Returns the role policies where policyId = &#63; and roleId = &#63; or throws a <code>NoSuchRolePoliciesException</code> if it could not be found.
	 *
	 * @param policyId the policy ID
	 * @param roleId the role ID
	 * @return the matching role policies
	 * @throws NoSuchRolePoliciesException if a matching role policies could not be found
	 */
	public static RolePolicies findByPolicyIdAndRoleId(
			long policyId, long roleId)
		throws com.ax.hrms.exception.NoSuchRolePoliciesException {

		return getPersistence().findByPolicyIdAndRoleId(policyId, roleId);
	}

	/**
	 * Returns the role policies where policyId = &#63; and roleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyId the policy ID
	 * @param roleId the role ID
	 * @return the matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	public static RolePolicies fetchByPolicyIdAndRoleId(
		long policyId, long roleId) {

		return getPersistence().fetchByPolicyIdAndRoleId(policyId, roleId);
	}

	/**
	 * Returns the role policies where policyId = &#63; and roleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyId the policy ID
	 * @param roleId the role ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	public static RolePolicies fetchByPolicyIdAndRoleId(
		long policyId, long roleId, boolean useFinderCache) {

		return getPersistence().fetchByPolicyIdAndRoleId(
			policyId, roleId, useFinderCache);
	}

	/**
	 * Removes the role policies where policyId = &#63; and roleId = &#63; from the database.
	 *
	 * @param policyId the policy ID
	 * @param roleId the role ID
	 * @return the role policies that was removed
	 */
	public static RolePolicies removeByPolicyIdAndRoleId(
			long policyId, long roleId)
		throws com.ax.hrms.exception.NoSuchRolePoliciesException {

		return getPersistence().removeByPolicyIdAndRoleId(policyId, roleId);
	}

	/**
	 * Returns the number of role policieses where policyId = &#63; and roleId = &#63;.
	 *
	 * @param policyId the policy ID
	 * @param roleId the role ID
	 * @return the number of matching role policieses
	 */
	public static int countByPolicyIdAndRoleId(long policyId, long roleId) {
		return getPersistence().countByPolicyIdAndRoleId(policyId, roleId);
	}

	/**
	 * Caches the role policies in the entity cache if it is enabled.
	 *
	 * @param rolePolicies the role policies
	 */
	public static void cacheResult(RolePolicies rolePolicies) {
		getPersistence().cacheResult(rolePolicies);
	}

	/**
	 * Caches the role policieses in the entity cache if it is enabled.
	 *
	 * @param rolePolicieses the role policieses
	 */
	public static void cacheResult(List<RolePolicies> rolePolicieses) {
		getPersistence().cacheResult(rolePolicieses);
	}

	/**
	 * Creates a new role policies with the primary key. Does not add the role policies to the database.
	 *
	 * @param rolePoliciesId the primary key for the new role policies
	 * @return the new role policies
	 */
	public static RolePolicies create(long rolePoliciesId) {
		return getPersistence().create(rolePoliciesId);
	}

	/**
	 * Removes the role policies with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rolePoliciesId the primary key of the role policies
	 * @return the role policies that was removed
	 * @throws NoSuchRolePoliciesException if a role policies with the primary key could not be found
	 */
	public static RolePolicies remove(long rolePoliciesId)
		throws com.ax.hrms.exception.NoSuchRolePoliciesException {

		return getPersistence().remove(rolePoliciesId);
	}

	public static RolePolicies updateImpl(RolePolicies rolePolicies) {
		return getPersistence().updateImpl(rolePolicies);
	}

	/**
	 * Returns the role policies with the primary key or throws a <code>NoSuchRolePoliciesException</code> if it could not be found.
	 *
	 * @param rolePoliciesId the primary key of the role policies
	 * @return the role policies
	 * @throws NoSuchRolePoliciesException if a role policies with the primary key could not be found
	 */
	public static RolePolicies findByPrimaryKey(long rolePoliciesId)
		throws com.ax.hrms.exception.NoSuchRolePoliciesException {

		return getPersistence().findByPrimaryKey(rolePoliciesId);
	}

	/**
	 * Returns the role policies with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rolePoliciesId the primary key of the role policies
	 * @return the role policies, or <code>null</code> if a role policies with the primary key could not be found
	 */
	public static RolePolicies fetchByPrimaryKey(long rolePoliciesId) {
		return getPersistence().fetchByPrimaryKey(rolePoliciesId);
	}

	/**
	 * Returns all the role policieses.
	 *
	 * @return the role policieses
	 */
	public static List<RolePolicies> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<RolePolicies> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<RolePolicies> findAll(
		int start, int end, OrderByComparator<RolePolicies> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<RolePolicies> findAll(
		int start, int end, OrderByComparator<RolePolicies> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the role policieses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of role policieses.
	 *
	 * @return the number of role policieses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RolePoliciesPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(RolePoliciesPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile RolePoliciesPersistence _persistence;

}