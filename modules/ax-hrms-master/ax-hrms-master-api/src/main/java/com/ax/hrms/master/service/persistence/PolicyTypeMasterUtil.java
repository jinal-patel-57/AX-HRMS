/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.model.PolicyTypeMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the policy type master service. This utility wraps <code>com.ax.hrms.master.service.persistence.impl.PolicyTypeMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyTypeMasterPersistence
 * @generated
 */
public class PolicyTypeMasterUtil {

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
	public static void clearCache(PolicyTypeMaster policyTypeMaster) {
		getPersistence().clearCache(policyTypeMaster);
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
	public static Map<Serializable, PolicyTypeMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PolicyTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PolicyTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PolicyTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PolicyTypeMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PolicyTypeMaster update(PolicyTypeMaster policyTypeMaster) {
		return getPersistence().update(policyTypeMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PolicyTypeMaster update(
		PolicyTypeMaster policyTypeMaster, ServiceContext serviceContext) {

		return getPersistence().update(policyTypeMaster, serviceContext);
	}

	/**
	 * Returns the policy type master where policyType = &#63; or throws a <code>NoSuchPolicyTypeMasterException</code> if it could not be found.
	 *
	 * @param policyType the policy type
	 * @return the matching policy type master
	 * @throws NoSuchPolicyTypeMasterException if a matching policy type master could not be found
	 */
	public static PolicyTypeMaster findByPolicyType(String policyType)
		throws com.ax.hrms.master.exception.NoSuchPolicyTypeMasterException {

		return getPersistence().findByPolicyType(policyType);
	}

	/**
	 * Returns the policy type master where policyType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyType the policy type
	 * @return the matching policy type master, or <code>null</code> if a matching policy type master could not be found
	 */
	public static PolicyTypeMaster fetchByPolicyType(String policyType) {
		return getPersistence().fetchByPolicyType(policyType);
	}

	/**
	 * Returns the policy type master where policyType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyType the policy type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy type master, or <code>null</code> if a matching policy type master could not be found
	 */
	public static PolicyTypeMaster fetchByPolicyType(
		String policyType, boolean useFinderCache) {

		return getPersistence().fetchByPolicyType(policyType, useFinderCache);
	}

	/**
	 * Removes the policy type master where policyType = &#63; from the database.
	 *
	 * @param policyType the policy type
	 * @return the policy type master that was removed
	 */
	public static PolicyTypeMaster removeByPolicyType(String policyType)
		throws com.ax.hrms.master.exception.NoSuchPolicyTypeMasterException {

		return getPersistence().removeByPolicyType(policyType);
	}

	/**
	 * Returns the number of policy type masters where policyType = &#63;.
	 *
	 * @param policyType the policy type
	 * @return the number of matching policy type masters
	 */
	public static int countByPolicyType(String policyType) {
		return getPersistence().countByPolicyType(policyType);
	}

	/**
	 * Caches the policy type master in the entity cache if it is enabled.
	 *
	 * @param policyTypeMaster the policy type master
	 */
	public static void cacheResult(PolicyTypeMaster policyTypeMaster) {
		getPersistence().cacheResult(policyTypeMaster);
	}

	/**
	 * Caches the policy type masters in the entity cache if it is enabled.
	 *
	 * @param policyTypeMasters the policy type masters
	 */
	public static void cacheResult(List<PolicyTypeMaster> policyTypeMasters) {
		getPersistence().cacheResult(policyTypeMasters);
	}

	/**
	 * Creates a new policy type master with the primary key. Does not add the policy type master to the database.
	 *
	 * @param policyTypeMasterID the primary key for the new policy type master
	 * @return the new policy type master
	 */
	public static PolicyTypeMaster create(long policyTypeMasterID) {
		return getPersistence().create(policyTypeMasterID);
	}

	/**
	 * Removes the policy type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyTypeMasterID the primary key of the policy type master
	 * @return the policy type master that was removed
	 * @throws NoSuchPolicyTypeMasterException if a policy type master with the primary key could not be found
	 */
	public static PolicyTypeMaster remove(long policyTypeMasterID)
		throws com.ax.hrms.master.exception.NoSuchPolicyTypeMasterException {

		return getPersistence().remove(policyTypeMasterID);
	}

	public static PolicyTypeMaster updateImpl(
		PolicyTypeMaster policyTypeMaster) {

		return getPersistence().updateImpl(policyTypeMaster);
	}

	/**
	 * Returns the policy type master with the primary key or throws a <code>NoSuchPolicyTypeMasterException</code> if it could not be found.
	 *
	 * @param policyTypeMasterID the primary key of the policy type master
	 * @return the policy type master
	 * @throws NoSuchPolicyTypeMasterException if a policy type master with the primary key could not be found
	 */
	public static PolicyTypeMaster findByPrimaryKey(long policyTypeMasterID)
		throws com.ax.hrms.master.exception.NoSuchPolicyTypeMasterException {

		return getPersistence().findByPrimaryKey(policyTypeMasterID);
	}

	/**
	 * Returns the policy type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyTypeMasterID the primary key of the policy type master
	 * @return the policy type master, or <code>null</code> if a policy type master with the primary key could not be found
	 */
	public static PolicyTypeMaster fetchByPrimaryKey(long policyTypeMasterID) {
		return getPersistence().fetchByPrimaryKey(policyTypeMasterID);
	}

	/**
	 * Returns all the policy type masters.
	 *
	 * @return the policy type masters
	 */
	public static List<PolicyTypeMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the policy type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy type masters
	 * @param end the upper bound of the range of policy type masters (not inclusive)
	 * @return the range of policy type masters
	 */
	public static List<PolicyTypeMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the policy type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy type masters
	 * @param end the upper bound of the range of policy type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of policy type masters
	 */
	public static List<PolicyTypeMaster> findAll(
		int start, int end,
		OrderByComparator<PolicyTypeMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policy type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy type masters
	 * @param end the upper bound of the range of policy type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of policy type masters
	 */
	public static List<PolicyTypeMaster> findAll(
		int start, int end,
		OrderByComparator<PolicyTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the policy type masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of policy type masters.
	 *
	 * @return the number of policy type masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PolicyTypeMasterPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(PolicyTypeMasterPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile PolicyTypeMasterPersistence _persistence;

}