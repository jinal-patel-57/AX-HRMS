/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AppraisalFormTemplatesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalFormTemplatesLocalService
 * @generated
 */
public class AppraisalFormTemplatesLocalServiceWrapper
	implements AppraisalFormTemplatesLocalService,
			   ServiceWrapper<AppraisalFormTemplatesLocalService> {

	public AppraisalFormTemplatesLocalServiceWrapper() {
		this(null);
	}

	public AppraisalFormTemplatesLocalServiceWrapper(
		AppraisalFormTemplatesLocalService appraisalFormTemplatesLocalService) {

		_appraisalFormTemplatesLocalService =
			appraisalFormTemplatesLocalService;
	}

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
	@Override
	public com.ax.hrms.model.AppraisalFormTemplates addAppraisalFormTemplates(
		com.ax.hrms.model.AppraisalFormTemplates appraisalFormTemplates) {

		return _appraisalFormTemplatesLocalService.addAppraisalFormTemplates(
			appraisalFormTemplates);
	}

	/**
	 * Creates a new appraisal form templates with the primary key. Does not add the appraisal form templates to the database.
	 *
	 * @param appraisalFormTemplateId the primary key for the new appraisal form templates
	 * @return the new appraisal form templates
	 */
	@Override
	public com.ax.hrms.model.AppraisalFormTemplates
		createAppraisalFormTemplates(long appraisalFormTemplateId) {

		return _appraisalFormTemplatesLocalService.createAppraisalFormTemplates(
			appraisalFormTemplateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalFormTemplatesLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.ax.hrms.model.AppraisalFormTemplates
		deleteAppraisalFormTemplates(
			com.ax.hrms.model.AppraisalFormTemplates appraisalFormTemplates) {

		return _appraisalFormTemplatesLocalService.deleteAppraisalFormTemplates(
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
	@Override
	public com.ax.hrms.model.AppraisalFormTemplates
			deleteAppraisalFormTemplates(long appraisalFormTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalFormTemplatesLocalService.deleteAppraisalFormTemplates(
			appraisalFormTemplateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalFormTemplatesLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _appraisalFormTemplatesLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _appraisalFormTemplatesLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appraisalFormTemplatesLocalService.dynamicQuery();
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

		return _appraisalFormTemplatesLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _appraisalFormTemplatesLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _appraisalFormTemplatesLocalService.dynamicQuery(
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

		return _appraisalFormTemplatesLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _appraisalFormTemplatesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.AppraisalFormTemplates fetchAppraisalFormTemplates(
		long appraisalFormTemplateId) {

		return _appraisalFormTemplatesLocalService.fetchAppraisalFormTemplates(
			appraisalFormTemplateId);
	}

	/**
	 * Returns the appraisal form templates matching the UUID and group.
	 *
	 * @param uuid the appraisal form templates's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal form templates, or <code>null</code> if a matching appraisal form templates could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalFormTemplates
		fetchAppraisalFormTemplatesByUuidAndGroupId(String uuid, long groupId) {

		return _appraisalFormTemplatesLocalService.
			fetchAppraisalFormTemplatesByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.ax.hrms.model.AppraisalFormTemplates
			findByTemplateLevelIdAndTemplateYear(
				long templateLevelId, String templateYear)
		throws com.ax.hrms.exception.NoSuchAppraisalFormTemplatesException {

		return _appraisalFormTemplatesLocalService.
			findByTemplateLevelIdAndTemplateYear(templateLevelId, templateYear);
	}

	@Override
	public com.ax.hrms.model.AppraisalFormTemplates
			findByTemplateYearAndTemplateLevelId(
				String templateYear, long templateLevelId)
		throws com.ax.hrms.exception.NoSuchAppraisalFormTemplatesException {

		return _appraisalFormTemplatesLocalService.
			findByTemplateYearAndTemplateLevelId(templateYear, templateLevelId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _appraisalFormTemplatesLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the appraisal form templates with the primary key.
	 *
	 * @param appraisalFormTemplateId the primary key of the appraisal form templates
	 * @return the appraisal form templates
	 * @throws PortalException if a appraisal form templates with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalFormTemplates getAppraisalFormTemplates(
			long appraisalFormTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalFormTemplatesLocalService.getAppraisalFormTemplates(
			appraisalFormTemplateId);
	}

	/**
	 * Returns the appraisal form templates matching the UUID and group.
	 *
	 * @param uuid the appraisal form templates's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal form templates
	 * @throws PortalException if a matching appraisal form templates could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalFormTemplates
			getAppraisalFormTemplatesByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalFormTemplatesLocalService.
			getAppraisalFormTemplatesByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.ax.hrms.model.AppraisalFormTemplates>
		getAppraisalFormTemplateses(int start, int end) {

		return _appraisalFormTemplatesLocalService.getAppraisalFormTemplateses(
			start, end);
	}

	/**
	 * Returns all the appraisal form templateses matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal form templateses
	 * @param companyId the primary key of the company
	 * @return the matching appraisal form templateses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.AppraisalFormTemplates>
		getAppraisalFormTemplatesesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _appraisalFormTemplatesLocalService.
			getAppraisalFormTemplatesesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.ax.hrms.model.AppraisalFormTemplates>
		getAppraisalFormTemplatesesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.AppraisalFormTemplates> orderByComparator) {

		return _appraisalFormTemplatesLocalService.
			getAppraisalFormTemplatesesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of appraisal form templateses.
	 *
	 * @return the number of appraisal form templateses
	 */
	@Override
	public int getAppraisalFormTemplatesesCount() {
		return _appraisalFormTemplatesLocalService.
			getAppraisalFormTemplatesesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _appraisalFormTemplatesLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _appraisalFormTemplatesLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appraisalFormTemplatesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalFormTemplatesLocalService.getPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.ax.hrms.model.AppraisalFormTemplates
		updateAppraisalFormTemplates(
			com.ax.hrms.model.AppraisalFormTemplates appraisalFormTemplates) {

		return _appraisalFormTemplatesLocalService.updateAppraisalFormTemplates(
			appraisalFormTemplates);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _appraisalFormTemplatesLocalService.getBasePersistence();
	}

	@Override
	public AppraisalFormTemplatesLocalService getWrappedService() {
		return _appraisalFormTemplatesLocalService;
	}

	@Override
	public void setWrappedService(
		AppraisalFormTemplatesLocalService appraisalFormTemplatesLocalService) {

		_appraisalFormTemplatesLocalService =
			appraisalFormTemplatesLocalService;
	}

	private AppraisalFormTemplatesLocalService
		_appraisalFormTemplatesLocalService;

}