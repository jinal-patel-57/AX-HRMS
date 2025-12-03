/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EducationLevelMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EducationLevelMasterLocalService
 * @generated
 */
public class EducationLevelMasterLocalServiceWrapper
	implements EducationLevelMasterLocalService,
			   ServiceWrapper<EducationLevelMasterLocalService> {

	public EducationLevelMasterLocalServiceWrapper() {
		this(null);
	}

	public EducationLevelMasterLocalServiceWrapper(
		EducationLevelMasterLocalService educationLevelMasterLocalService) {

		_educationLevelMasterLocalService = educationLevelMasterLocalService;
	}

	/**
	 * Adds the education level master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EducationLevelMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param educationLevelMaster the education level master
	 * @return the education level master that was added
	 */
	@Override
	public com.ax.hrms.master.model.EducationLevelMaster
		addEducationLevelMaster(
			com.ax.hrms.master.model.EducationLevelMaster
				educationLevelMaster) {

		return _educationLevelMasterLocalService.addEducationLevelMaster(
			educationLevelMaster);
	}

	/**
	 * Creates a new education level master with the primary key. Does not add the education level master to the database.
	 *
	 * @param educationLevelMasterId the primary key for the new education level master
	 * @return the new education level master
	 */
	@Override
	public com.ax.hrms.master.model.EducationLevelMaster
		createEducationLevelMaster(long educationLevelMasterId) {

		return _educationLevelMasterLocalService.createEducationLevelMaster(
			educationLevelMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _educationLevelMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the education level master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EducationLevelMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param educationLevelMaster the education level master
	 * @return the education level master that was removed
	 */
	@Override
	public com.ax.hrms.master.model.EducationLevelMaster
		deleteEducationLevelMaster(
			com.ax.hrms.master.model.EducationLevelMaster
				educationLevelMaster) {

		return _educationLevelMasterLocalService.deleteEducationLevelMaster(
			educationLevelMaster);
	}

	/**
	 * Deletes the education level master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EducationLevelMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param educationLevelMasterId the primary key of the education level master
	 * @return the education level master that was removed
	 * @throws PortalException if a education level master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.EducationLevelMaster
			deleteEducationLevelMaster(long educationLevelMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _educationLevelMasterLocalService.deleteEducationLevelMaster(
			educationLevelMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _educationLevelMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _educationLevelMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _educationLevelMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _educationLevelMasterLocalService.dynamicQuery();
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

		return _educationLevelMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.EducationLevelMasterModelImpl</code>.
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

		return _educationLevelMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.EducationLevelMasterModelImpl</code>.
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

		return _educationLevelMasterLocalService.dynamicQuery(
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

		return _educationLevelMasterLocalService.dynamicQueryCount(
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

		return _educationLevelMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.master.model.EducationLevelMaster
		fetchEducationLevelMaster(long educationLevelMasterId) {

		return _educationLevelMasterLocalService.fetchEducationLevelMaster(
			educationLevelMasterId);
	}

	@Override
	public com.ax.hrms.master.model.EducationLevelMaster findByLevelName(
			String levelName)
		throws com.ax.hrms.master.exception.
			NoSuchEducationLevelMasterException {

		return _educationLevelMasterLocalService.findByLevelName(levelName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _educationLevelMasterLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the education level master with the primary key.
	 *
	 * @param educationLevelMasterId the primary key of the education level master
	 * @return the education level master
	 * @throws PortalException if a education level master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.EducationLevelMaster
			getEducationLevelMaster(long educationLevelMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _educationLevelMasterLocalService.getEducationLevelMaster(
			educationLevelMasterId);
	}

	/**
	 * Returns a range of all the education level masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.EducationLevelMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of education level masters
	 * @param end the upper bound of the range of education level masters (not inclusive)
	 * @return the range of education level masters
	 */
	@Override
	public java.util.List<com.ax.hrms.master.model.EducationLevelMaster>
		getEducationLevelMasters(int start, int end) {

		return _educationLevelMasterLocalService.getEducationLevelMasters(
			start, end);
	}

	/**
	 * Returns the number of education level masters.
	 *
	 * @return the number of education level masters
	 */
	@Override
	public int getEducationLevelMastersCount() {
		return _educationLevelMasterLocalService.
			getEducationLevelMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _educationLevelMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _educationLevelMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _educationLevelMasterLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the education level master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EducationLevelMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param educationLevelMaster the education level master
	 * @return the education level master that was updated
	 */
	@Override
	public com.ax.hrms.master.model.EducationLevelMaster
		updateEducationLevelMaster(
			com.ax.hrms.master.model.EducationLevelMaster
				educationLevelMaster) {

		return _educationLevelMasterLocalService.updateEducationLevelMaster(
			educationLevelMaster);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _educationLevelMasterLocalService.getBasePersistence();
	}

	@Override
	public EducationLevelMasterLocalService getWrappedService() {
		return _educationLevelMasterLocalService;
	}

	@Override
	public void setWrappedService(
		EducationLevelMasterLocalService educationLevelMasterLocalService) {

		_educationLevelMasterLocalService = educationLevelMasterLocalService;
	}

	private EducationLevelMasterLocalService _educationLevelMasterLocalService;

}