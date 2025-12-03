/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.RolePolicies;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for RolePolicies. This utility wraps
 * <code>com.ax.hrms.service.impl.RolePoliciesLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RolePoliciesLocalService
 * @generated
 */
public class RolePoliciesLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.RolePoliciesLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static RolePolicies addRolePolicies(RolePolicies rolePolicies) {
		return getService().addRolePolicies(rolePolicies);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new role policies with the primary key. Does not add the role policies to the database.
	 *
	 * @param rolePoliciesId the primary key for the new role policies
	 * @return the new role policies
	 */
	public static RolePolicies createRolePolicies(long rolePoliciesId) {
		return getService().createRolePolicies(rolePoliciesId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static RolePolicies deleteRolePolicies(long rolePoliciesId)
		throws PortalException {

		return getService().deleteRolePolicies(rolePoliciesId);
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
	public static RolePolicies deleteRolePolicies(RolePolicies rolePolicies) {
		return getService().deleteRolePolicies(rolePolicies);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static RolePolicies fetchRolePolicies(long rolePoliciesId) {
		return getService().fetchRolePolicies(rolePoliciesId);
	}

	/**
	 * Returns the role policies matching the UUID and group.
	 *
	 * @param uuid the role policies's UUID
	 * @param groupId the primary key of the group
	 * @return the matching role policies, or <code>null</code> if a matching role policies could not be found
	 */
	public static RolePolicies fetchRolePoliciesByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchRolePoliciesByUuidAndGroupId(uuid, groupId);
	}

	public static List<RolePolicies> findByPolicyId(long policyId) {
		return getService().findByPolicyId(policyId);
	}

	public static RolePolicies findByPolicyIdAndRoleId(
			long policyId, long roleId)
		throws com.ax.hrms.exception.NoSuchRolePoliciesException {

		return getService().findByPolicyIdAndRoleId(policyId, roleId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the role policies with the primary key.
	 *
	 * @param rolePoliciesId the primary key of the role policies
	 * @return the role policies
	 * @throws PortalException if a role policies with the primary key could not be found
	 */
	public static RolePolicies getRolePolicies(long rolePoliciesId)
		throws PortalException {

		return getService().getRolePolicies(rolePoliciesId);
	}

	/**
	 * Returns the role policies matching the UUID and group.
	 *
	 * @param uuid the role policies's UUID
	 * @param groupId the primary key of the group
	 * @return the matching role policies
	 * @throws PortalException if a matching role policies could not be found
	 */
	public static RolePolicies getRolePoliciesByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getRolePoliciesByUuidAndGroupId(uuid, groupId);
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
	public static List<RolePolicies> getRolePolicieses(int start, int end) {
		return getService().getRolePolicieses(start, end);
	}

	/**
	 * Returns all the role policieses matching the UUID and company.
	 *
	 * @param uuid the UUID of the role policieses
	 * @param companyId the primary key of the company
	 * @return the matching role policieses, or an empty list if no matches were found
	 */
	public static List<RolePolicies> getRolePoliciesesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getRolePoliciesesByUuidAndCompanyId(
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
	public static List<RolePolicies> getRolePoliciesesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RolePolicies> orderByComparator) {

		return getService().getRolePoliciesesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of role policieses.
	 *
	 * @return the number of role policieses
	 */
	public static int getRolePoliciesesCount() {
		return getService().getRolePoliciesesCount();
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
	public static RolePolicies updateRolePolicies(RolePolicies rolePolicies) {
		return getService().updateRolePolicies(rolePolicies);
	}

	public static RolePoliciesLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<RolePoliciesLocalService> _serviceSnapshot =
		new Snapshot<>(
			RolePoliciesLocalServiceUtil.class, RolePoliciesLocalService.class);

}