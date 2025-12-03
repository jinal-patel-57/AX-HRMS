/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.exception.NoSuchPolicyTypeMasterException;
import com.ax.hrms.master.model.PolicyTypeMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the policy type master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyTypeMasterUtil
 * @generated
 */
@ProviderType
public interface PolicyTypeMasterPersistence
	extends BasePersistence<PolicyTypeMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PolicyTypeMasterUtil} to access the policy type master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the policy type master where policyType = &#63; or throws a <code>NoSuchPolicyTypeMasterException</code> if it could not be found.
	 *
	 * @param policyType the policy type
	 * @return the matching policy type master
	 * @throws NoSuchPolicyTypeMasterException if a matching policy type master could not be found
	 */
	public PolicyTypeMaster findByPolicyType(String policyType)
		throws NoSuchPolicyTypeMasterException;

	/**
	 * Returns the policy type master where policyType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param policyType the policy type
	 * @return the matching policy type master, or <code>null</code> if a matching policy type master could not be found
	 */
	public PolicyTypeMaster fetchByPolicyType(String policyType);

	/**
	 * Returns the policy type master where policyType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param policyType the policy type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy type master, or <code>null</code> if a matching policy type master could not be found
	 */
	public PolicyTypeMaster fetchByPolicyType(
		String policyType, boolean useFinderCache);

	/**
	 * Removes the policy type master where policyType = &#63; from the database.
	 *
	 * @param policyType the policy type
	 * @return the policy type master that was removed
	 */
	public PolicyTypeMaster removeByPolicyType(String policyType)
		throws NoSuchPolicyTypeMasterException;

	/**
	 * Returns the number of policy type masters where policyType = &#63;.
	 *
	 * @param policyType the policy type
	 * @return the number of matching policy type masters
	 */
	public int countByPolicyType(String policyType);

	/**
	 * Caches the policy type master in the entity cache if it is enabled.
	 *
	 * @param policyTypeMaster the policy type master
	 */
	public void cacheResult(PolicyTypeMaster policyTypeMaster);

	/**
	 * Caches the policy type masters in the entity cache if it is enabled.
	 *
	 * @param policyTypeMasters the policy type masters
	 */
	public void cacheResult(java.util.List<PolicyTypeMaster> policyTypeMasters);

	/**
	 * Creates a new policy type master with the primary key. Does not add the policy type master to the database.
	 *
	 * @param policyTypeMasterID the primary key for the new policy type master
	 * @return the new policy type master
	 */
	public PolicyTypeMaster create(long policyTypeMasterID);

	/**
	 * Removes the policy type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyTypeMasterID the primary key of the policy type master
	 * @return the policy type master that was removed
	 * @throws NoSuchPolicyTypeMasterException if a policy type master with the primary key could not be found
	 */
	public PolicyTypeMaster remove(long policyTypeMasterID)
		throws NoSuchPolicyTypeMasterException;

	public PolicyTypeMaster updateImpl(PolicyTypeMaster policyTypeMaster);

	/**
	 * Returns the policy type master with the primary key or throws a <code>NoSuchPolicyTypeMasterException</code> if it could not be found.
	 *
	 * @param policyTypeMasterID the primary key of the policy type master
	 * @return the policy type master
	 * @throws NoSuchPolicyTypeMasterException if a policy type master with the primary key could not be found
	 */
	public PolicyTypeMaster findByPrimaryKey(long policyTypeMasterID)
		throws NoSuchPolicyTypeMasterException;

	/**
	 * Returns the policy type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyTypeMasterID the primary key of the policy type master
	 * @return the policy type master, or <code>null</code> if a policy type master with the primary key could not be found
	 */
	public PolicyTypeMaster fetchByPrimaryKey(long policyTypeMasterID);

	/**
	 * Returns all the policy type masters.
	 *
	 * @return the policy type masters
	 */
	public java.util.List<PolicyTypeMaster> findAll();

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
	public java.util.List<PolicyTypeMaster> findAll(int start, int end);

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
	public java.util.List<PolicyTypeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyTypeMaster>
			orderByComparator);

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
	public java.util.List<PolicyTypeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PolicyTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the policy type masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of policy type masters.
	 *
	 * @return the number of policy type masters
	 */
	public int countAll();

}