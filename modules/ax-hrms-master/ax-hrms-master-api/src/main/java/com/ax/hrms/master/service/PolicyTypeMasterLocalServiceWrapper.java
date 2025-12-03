/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link PolicyTypeMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyTypeMasterLocalService
 * @generated
 */
public class PolicyTypeMasterLocalServiceWrapper
	implements PolicyTypeMasterLocalService,
			   ServiceWrapper<PolicyTypeMasterLocalService> {

	public PolicyTypeMasterLocalServiceWrapper() {
		this(null);
	}

	public PolicyTypeMasterLocalServiceWrapper(
		PolicyTypeMasterLocalService policyTypeMasterLocalService) {

		_policyTypeMasterLocalService = policyTypeMasterLocalService;
	}

	/**
	 * Adds the policy type master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyTypeMaster the policy type master
	 * @return the policy type master that was added
	 */
	@Override
	public com.ax.hrms.master.model.PolicyTypeMaster addPolicyTypeMaster(
		com.ax.hrms.master.model.PolicyTypeMaster policyTypeMaster) {

		return _policyTypeMasterLocalService.addPolicyTypeMaster(
			policyTypeMaster);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyTypeMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new policy type master with the primary key. Does not add the policy type master to the database.
	 *
	 * @param policyTypeMasterID the primary key for the new policy type master
	 * @return the new policy type master
	 */
	@Override
	public com.ax.hrms.master.model.PolicyTypeMaster createPolicyTypeMaster(
		long policyTypeMasterID) {

		return _policyTypeMasterLocalService.createPolicyTypeMaster(
			policyTypeMasterID);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyTypeMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the policy type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyTypeMasterID the primary key of the policy type master
	 * @return the policy type master that was removed
	 * @throws PortalException if a policy type master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.PolicyTypeMaster deletePolicyTypeMaster(
			long policyTypeMasterID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyTypeMasterLocalService.deletePolicyTypeMaster(
			policyTypeMasterID);
	}

	/**
	 * Deletes the policy type master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyTypeMaster the policy type master
	 * @return the policy type master that was removed
	 */
	@Override
	public com.ax.hrms.master.model.PolicyTypeMaster deletePolicyTypeMaster(
		com.ax.hrms.master.model.PolicyTypeMaster policyTypeMaster) {

		return _policyTypeMasterLocalService.deletePolicyTypeMaster(
			policyTypeMaster);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _policyTypeMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _policyTypeMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _policyTypeMasterLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _policyTypeMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.PolicyTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _policyTypeMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.PolicyTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _policyTypeMasterLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _policyTypeMasterLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _policyTypeMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.master.model.PolicyTypeMaster fetchPolicyTypeMaster(
		long policyTypeMasterID) {

		return _policyTypeMasterLocalService.fetchPolicyTypeMaster(
			policyTypeMasterID);
	}

	@Override
	public com.ax.hrms.master.model.PolicyTypeMaster findByPolicyType(
			String policyType)
		throws com.ax.hrms.master.exception.NoSuchPolicyTypeMasterException {

		return _policyTypeMasterLocalService.findByPolicyType(policyType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _policyTypeMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<String> getAllPolicyType() {
		return _policyTypeMasterLocalService.getAllPolicyType();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _policyTypeMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _policyTypeMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyTypeMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the policy type master with the primary key.
	 *
	 * @param policyTypeMasterID the primary key of the policy type master
	 * @return the policy type master
	 * @throws PortalException if a policy type master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.PolicyTypeMaster getPolicyTypeMaster(
			long policyTypeMasterID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyTypeMasterLocalService.getPolicyTypeMaster(
			policyTypeMasterID);
	}

	/**
	 * Returns a range of all the policy type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.PolicyTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy type masters
	 * @param end the upper bound of the range of policy type masters (not inclusive)
	 * @return the range of policy type masters
	 */
	@Override
	public java.util.List<com.ax.hrms.master.model.PolicyTypeMaster>
		getPolicyTypeMasters(int start, int end) {

		return _policyTypeMasterLocalService.getPolicyTypeMasters(start, end);
	}

	/**
	 * Returns the number of policy type masters.
	 *
	 * @return the number of policy type masters
	 */
	@Override
	public int getPolicyTypeMastersCount() {
		return _policyTypeMasterLocalService.getPolicyTypeMastersCount();
	}

	/**
	 * Updates the policy type master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyTypeMaster the policy type master
	 * @return the policy type master that was updated
	 */
	@Override
	public com.ax.hrms.master.model.PolicyTypeMaster updatePolicyTypeMaster(
		com.ax.hrms.master.model.PolicyTypeMaster policyTypeMaster) {

		return _policyTypeMasterLocalService.updatePolicyTypeMaster(
			policyTypeMaster);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _policyTypeMasterLocalService.getBasePersistence();
	}

	@Override
	public PolicyTypeMasterLocalService getWrappedService() {
		return _policyTypeMasterLocalService;
	}

	@Override
	public void setWrappedService(
		PolicyTypeMasterLocalService policyTypeMasterLocalService) {

		_policyTypeMasterLocalService = policyTypeMasterLocalService;
	}

	private PolicyTypeMasterLocalService _policyTypeMasterLocalService;

}