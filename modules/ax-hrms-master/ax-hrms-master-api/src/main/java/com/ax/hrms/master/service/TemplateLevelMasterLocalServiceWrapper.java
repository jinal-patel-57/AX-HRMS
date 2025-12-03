/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link TemplateLevelMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TemplateLevelMasterLocalService
 * @generated
 */
public class TemplateLevelMasterLocalServiceWrapper
	implements ServiceWrapper<TemplateLevelMasterLocalService>,
			   TemplateLevelMasterLocalService {

	public TemplateLevelMasterLocalServiceWrapper() {
		this(null);
	}

	public TemplateLevelMasterLocalServiceWrapper(
		TemplateLevelMasterLocalService templateLevelMasterLocalService) {

		_templateLevelMasterLocalService = templateLevelMasterLocalService;
	}

	/**
	 * Adds the template level master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TemplateLevelMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param templateLevelMaster the template level master
	 * @return the template level master that was added
	 */
	@Override
	public com.ax.hrms.master.model.TemplateLevelMaster addTemplateLevelMaster(
		com.ax.hrms.master.model.TemplateLevelMaster templateLevelMaster) {

		return _templateLevelMasterLocalService.addTemplateLevelMaster(
			templateLevelMaster);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _templateLevelMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new template level master with the primary key. Does not add the template level master to the database.
	 *
	 * @param templateLevelMasterId the primary key for the new template level master
	 * @return the new template level master
	 */
	@Override
	public com.ax.hrms.master.model.TemplateLevelMaster
		createTemplateLevelMaster(long templateLevelMasterId) {

		return _templateLevelMasterLocalService.createTemplateLevelMaster(
			templateLevelMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _templateLevelMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the template level master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TemplateLevelMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param templateLevelMasterId the primary key of the template level master
	 * @return the template level master that was removed
	 * @throws PortalException if a template level master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.TemplateLevelMaster
			deleteTemplateLevelMaster(long templateLevelMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _templateLevelMasterLocalService.deleteTemplateLevelMaster(
			templateLevelMasterId);
	}

	/**
	 * Deletes the template level master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TemplateLevelMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param templateLevelMaster the template level master
	 * @return the template level master that was removed
	 */
	@Override
	public com.ax.hrms.master.model.TemplateLevelMaster
		deleteTemplateLevelMaster(
			com.ax.hrms.master.model.TemplateLevelMaster templateLevelMaster) {

		return _templateLevelMasterLocalService.deleteTemplateLevelMaster(
			templateLevelMaster);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _templateLevelMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _templateLevelMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _templateLevelMasterLocalService.dynamicQuery();
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

		return _templateLevelMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.TemplateLevelMasterModelImpl</code>.
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

		return _templateLevelMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.TemplateLevelMasterModelImpl</code>.
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

		return _templateLevelMasterLocalService.dynamicQuery(
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

		return _templateLevelMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _templateLevelMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.master.model.TemplateLevelMaster
		fetchTemplateLevelMaster(long templateLevelMasterId) {

		return _templateLevelMasterLocalService.fetchTemplateLevelMaster(
			templateLevelMasterId);
	}

	@Override
	public com.ax.hrms.master.model.TemplateLevelMaster findBylevelName(
			String levelName)
		throws com.ax.hrms.master.exception.NoSuchTemplateLevelMasterException {

		return _templateLevelMasterLocalService.findBylevelName(levelName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _templateLevelMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _templateLevelMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _templateLevelMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _templateLevelMasterLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the template level master with the primary key.
	 *
	 * @param templateLevelMasterId the primary key of the template level master
	 * @return the template level master
	 * @throws PortalException if a template level master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.TemplateLevelMaster getTemplateLevelMaster(
			long templateLevelMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _templateLevelMasterLocalService.getTemplateLevelMaster(
			templateLevelMasterId);
	}

	/**
	 * Returns a range of all the template level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.TemplateLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of template level masters
	 * @param end the upper bound of the range of template level masters (not inclusive)
	 * @return the range of template level masters
	 */
	@Override
	public java.util.List<com.ax.hrms.master.model.TemplateLevelMaster>
		getTemplateLevelMasters(int start, int end) {

		return _templateLevelMasterLocalService.getTemplateLevelMasters(
			start, end);
	}

	/**
	 * Returns the number of template level masters.
	 *
	 * @return the number of template level masters
	 */
	@Override
	public int getTemplateLevelMastersCount() {
		return _templateLevelMasterLocalService.getTemplateLevelMastersCount();
	}

	/**
	 * Updates the template level master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TemplateLevelMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param templateLevelMaster the template level master
	 * @return the template level master that was updated
	 */
	@Override
	public com.ax.hrms.master.model.TemplateLevelMaster
		updateTemplateLevelMaster(
			com.ax.hrms.master.model.TemplateLevelMaster templateLevelMaster) {

		return _templateLevelMasterLocalService.updateTemplateLevelMaster(
			templateLevelMaster);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _templateLevelMasterLocalService.getBasePersistence();
	}

	@Override
	public TemplateLevelMasterLocalService getWrappedService() {
		return _templateLevelMasterLocalService;
	}

	@Override
	public void setWrappedService(
		TemplateLevelMasterLocalService templateLevelMasterLocalService) {

		_templateLevelMasterLocalService = templateLevelMasterLocalService;
	}

	private TemplateLevelMasterLocalService _templateLevelMasterLocalService;

}