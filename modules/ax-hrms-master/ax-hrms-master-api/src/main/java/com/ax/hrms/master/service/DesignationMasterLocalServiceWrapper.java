/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link DesignationMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DesignationMasterLocalService
 * @generated
 */
public class DesignationMasterLocalServiceWrapper
	implements DesignationMasterLocalService,
			   ServiceWrapper<DesignationMasterLocalService> {

	public DesignationMasterLocalServiceWrapper() {
		this(null);
	}

	public DesignationMasterLocalServiceWrapper(
		DesignationMasterLocalService designationMasterLocalService) {

		_designationMasterLocalService = designationMasterLocalService;
	}

	/**
	 * Adds the designation master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationMaster the designation master
	 * @return the designation master that was added
	 */
	@Override
	public com.ax.hrms.master.model.DesignationMaster addDesignationMaster(
		com.ax.hrms.master.model.DesignationMaster designationMaster) {

		return _designationMasterLocalService.addDesignationMaster(
			designationMaster);
	}

	/**
	 * Creates a new designation master with the primary key. Does not add the designation master to the database.
	 *
	 * @param designationMasterId the primary key for the new designation master
	 * @return the new designation master
	 */
	@Override
	public com.ax.hrms.master.model.DesignationMaster createDesignationMaster(
		long designationMasterId) {

		return _designationMasterLocalService.createDesignationMaster(
			designationMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the designation master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationMaster the designation master
	 * @return the designation master that was removed
	 */
	@Override
	public com.ax.hrms.master.model.DesignationMaster deleteDesignationMaster(
		com.ax.hrms.master.model.DesignationMaster designationMaster) {

		return _designationMasterLocalService.deleteDesignationMaster(
			designationMaster);
	}

	/**
	 * Deletes the designation master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationMasterId the primary key of the designation master
	 * @return the designation master that was removed
	 * @throws PortalException if a designation master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.DesignationMaster deleteDesignationMaster(
			long designationMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationMasterLocalService.deleteDesignationMaster(
			designationMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _designationMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _designationMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _designationMasterLocalService.dynamicQuery();
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

		return _designationMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.DesignationMasterModelImpl</code>.
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

		return _designationMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.DesignationMasterModelImpl</code>.
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

		return _designationMasterLocalService.dynamicQuery(
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

		return _designationMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _designationMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.master.model.DesignationMaster fetchDesignationMaster(
		long designationMasterId) {

		return _designationMasterLocalService.fetchDesignationMaster(
			designationMasterId);
	}

	@Override
	public com.ax.hrms.master.model.DesignationMaster findByDesignationName(
			String designationName)
		throws com.ax.hrms.master.exception.NoSuchDesignationMasterException {

		return _designationMasterLocalService.findByDesignationName(
			designationName);
	}

	@Override
	public com.ax.hrms.master.model.DesignationMaster findByDesignationNameById(
			long designationMasterId)
		throws com.ax.hrms.master.exception.NoSuchDesignationMasterException {

		return _designationMasterLocalService.findByDesignationNameById(
			designationMasterId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _designationMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<String> getDesigNameList() {
		return _designationMasterLocalService.getDesigNameList();
	}

	@Override
	public long getDesignationIdByName(String designationName) {
		return _designationMasterLocalService.getDesignationIdByName(
			designationName);
	}

	/**
	 * Returns the designation master with the primary key.
	 *
	 * @param designationMasterId the primary key of the designation master
	 * @return the designation master
	 * @throws PortalException if a designation master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.DesignationMaster getDesignationMaster(
			long designationMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationMasterLocalService.getDesignationMaster(
			designationMasterId);
	}

	/**
	 * Returns a range of all the designation masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.DesignationMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation masters
	 * @param end the upper bound of the range of designation masters (not inclusive)
	 * @return the range of designation masters
	 */
	@Override
	public java.util.List<com.ax.hrms.master.model.DesignationMaster>
		getDesignationMasters(int start, int end) {

		return _designationMasterLocalService.getDesignationMasters(start, end);
	}

	/**
	 * Returns the number of designation masters.
	 *
	 * @return the number of designation masters
	 */
	@Override
	public int getDesignationMastersCount() {
		return _designationMasterLocalService.getDesignationMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _designationMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _designationMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean isNameExist(String designationName) {
		return _designationMasterLocalService.isNameExist(designationName);
	}

	/**
	 * Updates the designation master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationMaster the designation master
	 * @return the designation master that was updated
	 */
	@Override
	public com.ax.hrms.master.model.DesignationMaster updateDesignationMaster(
		com.ax.hrms.master.model.DesignationMaster designationMaster) {

		return _designationMasterLocalService.updateDesignationMaster(
			designationMaster);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _designationMasterLocalService.getBasePersistence();
	}

	@Override
	public DesignationMasterLocalService getWrappedService() {
		return _designationMasterLocalService;
	}

	@Override
	public void setWrappedService(
		DesignationMasterLocalService designationMasterLocalService) {

		_designationMasterLocalService = designationMasterLocalService;
	}

	private DesignationMasterLocalService _designationMasterLocalService;

}