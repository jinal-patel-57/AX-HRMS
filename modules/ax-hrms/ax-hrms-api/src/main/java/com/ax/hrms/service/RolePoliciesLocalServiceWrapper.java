/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link RolePoliciesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RolePoliciesLocalService
 * @generated
 */
public class RolePoliciesLocalServiceWrapper
	implements RolePoliciesLocalService,
			   ServiceWrapper<RolePoliciesLocalService> {

	public RolePoliciesLocalServiceWrapper() {
		this(null);
	}

	public RolePoliciesLocalServiceWrapper(
		RolePoliciesLocalService rolePoliciesLocalService) {

		_rolePoliciesLocalService = rolePoliciesLocalService;
	}

	/**
	 * Adds the role policies to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RolePoliciesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rolePolicies the role policies
	 * @return the role policies that was added
	 */
	@Override
	public com.ax.hrms.model.RolePolicies addRolePolicies(
		com.ax.hrms.model.RolePolicies rolePolicies) {

		return _rolePoliciesLocalService.addRolePolicies(rolePolicies);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rolePoliciesLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new role policies with the primary key. Does not add the role policies to the database.
	 *
	 * @param rolePoliciesId the primary key for the new role policies
	 * @return the new role policies
	 */
	@Override
	public com.ax.hrms.model.RolePolicies createRolePolicies(
		long rolePoliciesId) {

		return _rolePoliciesLocalService.createRolePolicies(rolePoliciesId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rolePoliciesLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the role policies with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RolePoliciesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rolePoliciesId the primary key of the role policies
	 * @return the role policies that was removed
	 * @throws PortalException if a role policies with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.RolePolicies deleteRolePolicies(
			long rolePoliciesId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rolePoliciesLocalService.deleteRolePolicies(rolePoliciesId);
	}

	/**
	 * Deletes the role policies from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RolePoliciesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rolePolicies the role policies
	 * @return the role policies that was removed
	 */
	@Override
	public com.ax.hrms.model.RolePolicies deleteRolePolicies(
		com.ax.hrms.model.RolePolicies rolePolicies) {

		return _rolePoliciesLocalService.deleteRolePolicies(rolePolicies);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _rolePoliciesLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _rolePoliciesLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rolePoliciesLocalService.dynamicQuery();
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

		return _rolePoliciesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.RolePoliciesModelImpl</code>.
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

		return _rolePoliciesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.RolePoliciesModelImpl</code>.
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

		return _rolePoliciesLocalService.dynamicQuery(
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

		return _rolePoliciesLocalService.dynamicQueryCount(dynamicQuery);
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

		return _rolePoliciesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.RolePolicies fetchRolePolicies(
		long rolePoliciesId) {

		return _rolePoliciesLocalService.fetchRolePolicies(rolePoliciesId);
	}

	/**
	 * Returns the role policies matching the UUID and group.
	 *
	 * @param uuid the role policies's UUID
	 * @param groupId the primary key of the group
	 * @return the matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	@Override
	public com.ax.hrms.model.RolePolicies fetchRolePoliciesByUuidAndGroupId(
		String uuid, long groupId) {

		return _rolePoliciesLocalService.fetchRolePoliciesByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.RolePolicies> findByPolicyId(
		long policyId) {

		return _rolePoliciesLocalService.findByPolicyId(policyId);
	}

	@Override
	public com.ax.hrms.model.RolePolicies findByPolicyIdAndRoleId(
			long policyId, long roleId)
		throws com.ax.hrms.exception.NoSuchRolePoliciesException {

		return _rolePoliciesLocalService.findByPolicyIdAndRoleId(
			policyId, roleId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _rolePoliciesLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _rolePoliciesLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _rolePoliciesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rolePoliciesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rolePoliciesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the role policies with the primary key.
	 *
	 * @param rolePoliciesId the primary key of the role policies
	 * @return the role policies
	 * @throws PortalException if a role policies with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.RolePolicies getRolePolicies(long rolePoliciesId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rolePoliciesLocalService.getRolePolicies(rolePoliciesId);
	}

	/**
	 * Returns the role policies matching the UUID and group.
	 *
	 * @param uuid the role policies's UUID
	 * @param groupId the primary key of the group
	 * @return the matching role policies
	 * @throws PortalException if a matching role policies could not be found
	 */
	@Override
	public com.ax.hrms.model.RolePolicies getRolePoliciesByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rolePoliciesLocalService.getRolePoliciesByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the role policieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.RolePoliciesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @return the range of role policieses
	 */
	@Override
	public java.util.List<com.ax.hrms.model.RolePolicies> getRolePolicieses(
		int start, int end) {

		return _rolePoliciesLocalService.getRolePolicieses(start, end);
	}

	/**
	 * Returns all the role policieses matching the UUID and company.
	 *
	 * @param uuid the UUID of the role policieses
	 * @param companyId the primary key of the company
	 * @return the matching role policieses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.RolePolicies>
		getRolePoliciesesByUuidAndCompanyId(String uuid, long companyId) {

		return _rolePoliciesLocalService.getRolePoliciesesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of role policieses matching the UUID and company.
	 *
	 * @param uuid the UUID of the role policieses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of role policieses
	 * @param end the upper bound of the range of role policieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching role policieses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.RolePolicies>
		getRolePoliciesesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.RolePolicies> orderByComparator) {

		return _rolePoliciesLocalService.getRolePoliciesesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of role policieses.
	 *
	 * @return the number of role policieses
	 */
	@Override
	public int getRolePoliciesesCount() {
		return _rolePoliciesLocalService.getRolePoliciesesCount();
	}

	/**
	 * Updates the role policies in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RolePoliciesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rolePolicies the role policies
	 * @return the role policies that was updated
	 */
	@Override
	public com.ax.hrms.model.RolePolicies updateRolePolicies(
		com.ax.hrms.model.RolePolicies rolePolicies) {

		return _rolePoliciesLocalService.updateRolePolicies(rolePolicies);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _rolePoliciesLocalService.getBasePersistence();
	}

	@Override
	public RolePoliciesLocalService getWrappedService() {
		return _rolePoliciesLocalService;
	}

	@Override
	public void setWrappedService(
		RolePoliciesLocalService rolePoliciesLocalService) {

		_rolePoliciesLocalService = rolePoliciesLocalService;
	}

	private RolePoliciesLocalService _rolePoliciesLocalService;

}