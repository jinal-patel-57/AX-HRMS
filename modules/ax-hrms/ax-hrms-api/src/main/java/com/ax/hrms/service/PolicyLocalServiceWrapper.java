/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link PolicyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyLocalService
 * @generated
 */
public class PolicyLocalServiceWrapper
	implements PolicyLocalService, ServiceWrapper<PolicyLocalService> {

	public PolicyLocalServiceWrapper() {
		this(null);
	}

	public PolicyLocalServiceWrapper(PolicyLocalService policyLocalService) {
		_policyLocalService = policyLocalService;
	}

	/**
	 * Adds the policy to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policy the policy
	 * @return the policy that was added
	 */
	@Override
	public com.ax.hrms.model.Policy addPolicy(com.ax.hrms.model.Policy policy) {
		return _policyLocalService.addPolicy(policy);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new policy with the primary key. Does not add the policy to the database.
	 *
	 * @param policyId the primary key for the new policy
	 * @return the new policy
	 */
	@Override
	public com.ax.hrms.model.Policy createPolicy(long policyId) {
		return _policyLocalService.createPolicy(policyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the policy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyId the primary key of the policy
	 * @return the policy that was removed
	 * @throws PortalException if a policy with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.Policy deletePolicy(long policyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyLocalService.deletePolicy(policyId);
	}

	/**
	 * Deletes the policy from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policy the policy
	 * @return the policy that was removed
	 */
	@Override
	public com.ax.hrms.model.Policy deletePolicy(
		com.ax.hrms.model.Policy policy) {

		return _policyLocalService.deletePolicy(policy);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _policyLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _policyLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _policyLocalService.dynamicQuery();
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

		return _policyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.PolicyModelImpl</code>.
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

		return _policyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.PolicyModelImpl</code>.
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

		return _policyLocalService.dynamicQuery(
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

		return _policyLocalService.dynamicQueryCount(dynamicQuery);
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

		return _policyLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.Policy fetchPolicy(long policyId) {
		return _policyLocalService.fetchPolicy(policyId);
	}

	/**
	 * Returns the policy matching the UUID and group.
	 *
	 * @param uuid the policy's UUID
	 * @param groupId the primary key of the group
	 * @return the matching policy, or <code>null</code> if a matching policy could not be found
	 */
	@Override
	public com.ax.hrms.model.Policy fetchPolicyByUuidAndGroupId(
		String uuid, long groupId) {

		return _policyLocalService.fetchPolicyByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.ax.hrms.model.Policy findByPolicyTypeIdAndPolicyYear(
			long policyTypeId, int year)
		throws com.ax.hrms.exception.NoSuchPolicyException {

		return _policyLocalService.findByPolicyTypeIdAndPolicyYear(
			policyTypeId, year);
	}

	@Override
	public java.util.List<com.ax.hrms.model.Policy> findByYear(int year) {
		return _policyLocalService.findByYear(year);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _policyLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<Integer> getAllYear() {
		return _policyLocalService.getAllYear();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _policyLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _policyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _policyLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the policies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @return the range of policies
	 */
	@Override
	public java.util.List<com.ax.hrms.model.Policy> getPolicies(
		int start, int end) {

		return _policyLocalService.getPolicies(start, end);
	}

	/**
	 * Returns all the policies matching the UUID and company.
	 *
	 * @param uuid the UUID of the policies
	 * @param companyId the primary key of the company
	 * @return the matching policies, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.Policy>
		getPoliciesByUuidAndCompanyId(String uuid, long companyId) {

		return _policyLocalService.getPoliciesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of policies matching the UUID and company.
	 *
	 * @param uuid the UUID of the policies
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching policies, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.Policy>
		getPoliciesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.Policy> orderByComparator) {

		return _policyLocalService.getPoliciesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of policies.
	 *
	 * @return the number of policies
	 */
	@Override
	public int getPoliciesCount() {
		return _policyLocalService.getPoliciesCount();
	}

	/**
	 * Returns the policy with the primary key.
	 *
	 * @param policyId the primary key of the policy
	 * @return the policy
	 * @throws PortalException if a policy with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.Policy getPolicy(long policyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyLocalService.getPolicy(policyId);
	}

	/**
	 * Returns the policy matching the UUID and group.
	 *
	 * @param uuid the policy's UUID
	 * @param groupId the primary key of the group
	 * @return the matching policy
	 * @throws PortalException if a matching policy could not be found
	 */
	@Override
	public com.ax.hrms.model.Policy getPolicyByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyLocalService.getPolicyByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Updates the policy in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policy the policy
	 * @return the policy that was updated
	 */
	@Override
	public com.ax.hrms.model.Policy updatePolicy(
		com.ax.hrms.model.Policy policy) {

		return _policyLocalService.updatePolicy(policy);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _policyLocalService.getBasePersistence();
	}

	@Override
	public PolicyLocalService getWrappedService() {
		return _policyLocalService;
	}

	@Override
	public void setWrappedService(PolicyLocalService policyLocalService) {
		_policyLocalService = policyLocalService;
	}

	private PolicyLocalService _policyLocalService;

}