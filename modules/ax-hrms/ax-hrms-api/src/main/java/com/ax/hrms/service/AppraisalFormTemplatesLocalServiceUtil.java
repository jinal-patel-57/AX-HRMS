/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.AppraisalFormTemplates;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AppraisalFormTemplates. This utility wraps
 * <code>com.ax.hrms.service.impl.AppraisalFormTemplatesLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalFormTemplatesLocalService
 * @generated
 */
public class AppraisalFormTemplatesLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.AppraisalFormTemplatesLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the appraisal form templates to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalFormTemplatesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalFormTemplates the appraisal form templates
	 * @return the appraisal form templates that was added
	 */
	public static AppraisalFormTemplates addAppraisalFormTemplates(
		AppraisalFormTemplates appraisalFormTemplates) {

		return getService().addAppraisalFormTemplates(appraisalFormTemplates);
	}

	/**
	 * Creates a new appraisal form templates with the primary key. Does not add the appraisal form templates to the database.
	 *
	 * @param appraisalFormTemplateId the primary key for the new appraisal form templates
	 * @return the new appraisal form templates
	 */
	public static AppraisalFormTemplates createAppraisalFormTemplates(
		long appraisalFormTemplateId) {

		return getService().createAppraisalFormTemplates(
			appraisalFormTemplateId);
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
	 * Deletes the appraisal form templates from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalFormTemplatesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalFormTemplates the appraisal form templates
	 * @return the appraisal form templates that was removed
	 */
	public static AppraisalFormTemplates deleteAppraisalFormTemplates(
		AppraisalFormTemplates appraisalFormTemplates) {

		return getService().deleteAppraisalFormTemplates(
			appraisalFormTemplates);
	}

	/**
	 * Deletes the appraisal form templates with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalFormTemplatesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalFormTemplateId the primary key of the appraisal form templates
	 * @return the appraisal form templates that was removed
	 * @throws PortalException if a appraisal form templates with the primary key could not be found
	 */
	public static AppraisalFormTemplates deleteAppraisalFormTemplates(
			long appraisalFormTemplateId)
		throws PortalException {

		return getService().deleteAppraisalFormTemplates(
			appraisalFormTemplateId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalFormTemplatesModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalFormTemplatesModelImpl</code>.
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

	public static AppraisalFormTemplates fetchAppraisalFormTemplates(
		long appraisalFormTemplateId) {

		return getService().fetchAppraisalFormTemplates(
			appraisalFormTemplateId);
	}

	/**
	 * Returns the appraisal form templates matching the UUID and group.
	 *
	 * @param uuid the appraisal form templates's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	public static AppraisalFormTemplates
		fetchAppraisalFormTemplatesByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchAppraisalFormTemplatesByUuidAndGroupId(
			uuid, groupId);
	}

	public static AppraisalFormTemplates findByTemplateLevelIdAndTemplateYear(
			long templateLevelId, String templateYear)
		throws com.ax.hrms.exception.NoSuchAppraisalFormTemplatesException {

		return getService().findByTemplateLevelIdAndTemplateYear(
			templateLevelId, templateYear);
	}

	public static AppraisalFormTemplates findByTemplateYearAndTemplateLevelId(
			String templateYear, long templateLevelId)
		throws com.ax.hrms.exception.NoSuchAppraisalFormTemplatesException {

		return getService().findByTemplateYearAndTemplateLevelId(
			templateYear, templateLevelId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the appraisal form templates with the primary key.
	 *
	 * @param appraisalFormTemplateId the primary key of the appraisal form templates
	 * @return the appraisal form templates
	 * @throws PortalException if a appraisal form templates with the primary key could not be found
	 */
	public static AppraisalFormTemplates getAppraisalFormTemplates(
			long appraisalFormTemplateId)
		throws PortalException {

		return getService().getAppraisalFormTemplates(appraisalFormTemplateId);
	}

	/**
	 * Returns the appraisal form templates matching the UUID and group.
	 *
	 * @param uuid the appraisal form templates's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal form templates
	 * @throws PortalException if a matching appraisal form templates could not be found
	 */
	public static AppraisalFormTemplates
			getAppraisalFormTemplatesByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getAppraisalFormTemplatesByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the appraisal form templateses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalFormTemplatesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal form templateses
	 * @param end the upper bound of the range of appraisal form templateses (not inclusive)
	 * @return the range of appraisal form templateses
	 */
	public static List<AppraisalFormTemplates> getAppraisalFormTemplateses(
		int start, int end) {

		return getService().getAppraisalFormTemplateses(start, end);
	}

	/**
	 * Returns all the appraisal form templateses matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal form templateses
	 * @param companyId the primary key of the company
	 * @return the matching appraisal form templateses, or an empty list if no matches were found
	 */
	public static List<AppraisalFormTemplates>
		getAppraisalFormTemplatesesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getAppraisalFormTemplatesesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of appraisal form templateses matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal form templateses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of appraisal form templateses
	 * @param end the upper bound of the range of appraisal form templateses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching appraisal form templateses, or an empty list if no matches were found
	 */
	public static List<AppraisalFormTemplates>
		getAppraisalFormTemplatesesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<AppraisalFormTemplates> orderByComparator) {

		return getService().getAppraisalFormTemplatesesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of appraisal form templateses.
	 *
	 * @return the number of appraisal form templateses
	 */
	public static int getAppraisalFormTemplatesesCount() {
		return getService().getAppraisalFormTemplatesesCount();
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
	 * Updates the appraisal form templates in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalFormTemplatesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalFormTemplates the appraisal form templates
	 * @return the appraisal form templates that was updated
	 */
	public static AppraisalFormTemplates updateAppraisalFormTemplates(
		AppraisalFormTemplates appraisalFormTemplates) {

		return getService().updateAppraisalFormTemplates(
			appraisalFormTemplates);
	}

	public static AppraisalFormTemplatesLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<AppraisalFormTemplatesLocalService>
		_serviceSnapshot = new Snapshot<>(
			AppraisalFormTemplatesLocalServiceUtil.class,
			AppraisalFormTemplatesLocalService.class);

}