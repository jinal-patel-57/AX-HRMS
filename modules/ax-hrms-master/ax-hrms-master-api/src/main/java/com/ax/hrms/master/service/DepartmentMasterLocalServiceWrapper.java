/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link DepartmentMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentMasterLocalService
 * @generated
 */
public class DepartmentMasterLocalServiceWrapper
	implements DepartmentMasterLocalService,
			   ServiceWrapper<DepartmentMasterLocalService> {

	public DepartmentMasterLocalServiceWrapper() {
		this(null);
	}

	public DepartmentMasterLocalServiceWrapper(
		DepartmentMasterLocalService departmentMasterLocalService) {

		_departmentMasterLocalService = departmentMasterLocalService;
	}

	/**
	 * Adds the department master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DepartmentMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param departmentMaster the department master
	 * @return the department master that was added
	 */
	@Override
	public com.ax.hrms.master.model.DepartmentMaster addDepartmentMaster(
		com.ax.hrms.master.model.DepartmentMaster departmentMaster) {

		return _departmentMasterLocalService.addDepartmentMaster(
			departmentMaster);
	}

	/**
	 * Creates a new department master with the primary key. Does not add the department master to the database.
	 *
	 * @param departmentMasterId the primary key for the new department master
	 * @return the new department master
	 */
	@Override
	public com.ax.hrms.master.model.DepartmentMaster createDepartmentMaster(
		long departmentMasterId) {

		return _departmentMasterLocalService.createDepartmentMaster(
			departmentMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the department master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DepartmentMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param departmentMaster the department master
	 * @return the department master that was removed
	 */
	@Override
	public com.ax.hrms.master.model.DepartmentMaster deleteDepartmentMaster(
		com.ax.hrms.master.model.DepartmentMaster departmentMaster) {

		return _departmentMasterLocalService.deleteDepartmentMaster(
			departmentMaster);
	}

	/**
	 * Deletes the department master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DepartmentMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param departmentMasterId the primary key of the department master
	 * @return the department master that was removed
	 * @throws PortalException if a department master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.DepartmentMaster deleteDepartmentMaster(
			long departmentMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentMasterLocalService.deleteDepartmentMaster(
			departmentMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _departmentMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _departmentMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _departmentMasterLocalService.dynamicQuery();
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

		return _departmentMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.DepartmentMasterModelImpl</code>.
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

		return _departmentMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.DepartmentMasterModelImpl</code>.
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

		return _departmentMasterLocalService.dynamicQuery(
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

		return _departmentMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _departmentMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.master.model.DepartmentMaster fetchDepartmentMaster(
		long departmentMasterId) {

		return _departmentMasterLocalService.fetchDepartmentMaster(
			departmentMasterId);
	}

	@Override
	public com.ax.hrms.master.model.DepartmentMaster findByDepartmentName(
			String departmentName)
		throws com.ax.hrms.master.exception.NoSuchDepartmentMasterException {

		return _departmentMasterLocalService.findByDepartmentName(
			departmentName);
	}

	@Override
	public com.ax.hrms.master.model.DepartmentMaster findByDepartmentNameById(
			long departmentMasterId)
		throws com.ax.hrms.master.exception.NoSuchDepartmentMasterException {

		return _departmentMasterLocalService.findByDepartmentNameById(
			departmentMasterId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _departmentMasterLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the department master with the primary key.
	 *
	 * @param departmentMasterId the primary key of the department master
	 * @return the department master
	 * @throws PortalException if a department master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.DepartmentMaster getDepartmentMaster(
			long departmentMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentMasterLocalService.getDepartmentMaster(
			departmentMasterId);
	}

	/**
	 * Returns a range of all the department masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.DepartmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of department masters
	 * @param end the upper bound of the range of department masters (not inclusive)
	 * @return the range of department masters
	 */
	@Override
	public java.util.List<com.ax.hrms.master.model.DepartmentMaster>
		getDepartmentMasters(int start, int end) {

		return _departmentMasterLocalService.getDepartmentMasters(start, end);
	}

	/**
	 * Returns the number of department masters.
	 *
	 * @return the number of department masters
	 */
	@Override
	public int getDepartmentMastersCount() {
		return _departmentMasterLocalService.getDepartmentMastersCount();
	}

	@Override
	public java.util.List<String> getDepartNameList() {
		return _departmentMasterLocalService.getDepartNameList();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _departmentMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _departmentMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _departmentMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean isNameExist(String departmentName) {
		return _departmentMasterLocalService.isNameExist(departmentName);
	}

	/**
	 * Updates the department master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DepartmentMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param departmentMaster the department master
	 * @return the department master that was updated
	 */
	@Override
	public com.ax.hrms.master.model.DepartmentMaster updateDepartmentMaster(
		com.ax.hrms.master.model.DepartmentMaster departmentMaster) {

		return _departmentMasterLocalService.updateDepartmentMaster(
			departmentMaster);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _departmentMasterLocalService.getBasePersistence();
	}

	@Override
	public DepartmentMasterLocalService getWrappedService() {
		return _departmentMasterLocalService;
	}

	@Override
	public void setWrappedService(
		DepartmentMasterLocalService departmentMasterLocalService) {

		_departmentMasterLocalService = departmentMasterLocalService;
	}

	private DepartmentMasterLocalService _departmentMasterLocalService;

}