/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link BranchMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BranchMasterLocalService
 * @generated
 */
public class BranchMasterLocalServiceWrapper
	implements BranchMasterLocalService,
			   ServiceWrapper<BranchMasterLocalService> {

	public BranchMasterLocalServiceWrapper() {
		this(null);
	}

	public BranchMasterLocalServiceWrapper(
		BranchMasterLocalService branchMasterLocalService) {

		_branchMasterLocalService = branchMasterLocalService;
	}

	/**
	 * Adds the branch master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BranchMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param branchMaster the branch master
	 * @return the branch master that was added
	 */
	@Override
	public com.ax.hrms.master.model.BranchMaster addBranchMaster(
		com.ax.hrms.master.model.BranchMaster branchMaster) {

		return _branchMasterLocalService.addBranchMaster(branchMaster);
	}

	/**
	 * Creates a new branch master with the primary key. Does not add the branch master to the database.
	 *
	 * @param branchMasterId the primary key for the new branch master
	 * @return the new branch master
	 */
	@Override
	public com.ax.hrms.master.model.BranchMaster createBranchMaster(
		long branchMasterId) {

		return _branchMasterLocalService.createBranchMaster(branchMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _branchMasterLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the branch master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BranchMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param branchMaster the branch master
	 * @return the branch master that was removed
	 */
	@Override
	public com.ax.hrms.master.model.BranchMaster deleteBranchMaster(
		com.ax.hrms.master.model.BranchMaster branchMaster) {

		return _branchMasterLocalService.deleteBranchMaster(branchMaster);
	}

	/**
	 * Deletes the branch master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BranchMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param branchMasterId the primary key of the branch master
	 * @return the branch master that was removed
	 * @throws PortalException if a branch master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.BranchMaster deleteBranchMaster(
			long branchMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _branchMasterLocalService.deleteBranchMaster(branchMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _branchMasterLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _branchMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _branchMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _branchMasterLocalService.dynamicQuery();
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

		return _branchMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.BranchMasterModelImpl</code>.
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

		return _branchMasterLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.BranchMasterModelImpl</code>.
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

		return _branchMasterLocalService.dynamicQuery(
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

		return _branchMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _branchMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.master.model.BranchMaster fetchBranchMaster(
		long branchMasterId) {

		return _branchMasterLocalService.fetchBranchMaster(branchMasterId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _branchMasterLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the branch master with the primary key.
	 *
	 * @param branchMasterId the primary key of the branch master
	 * @return the branch master
	 * @throws PortalException if a branch master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.BranchMaster getBranchMaster(
			long branchMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _branchMasterLocalService.getBranchMaster(branchMasterId);
	}

	/**
	 * Returns a range of all the branch masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.BranchMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of branch masters
	 * @param end the upper bound of the range of branch masters (not inclusive)
	 * @return the range of branch masters
	 */
	@Override
	public java.util.List<com.ax.hrms.master.model.BranchMaster>
		getBranchMasters(int start, int end) {

		return _branchMasterLocalService.getBranchMasters(start, end);
	}

	/**
	 * Returns the number of branch masters.
	 *
	 * @return the number of branch masters
	 */
	@Override
	public int getBranchMastersCount() {
		return _branchMasterLocalService.getBranchMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _branchMasterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _branchMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _branchMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the branch master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BranchMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param branchMaster the branch master
	 * @return the branch master that was updated
	 */
	@Override
	public com.ax.hrms.master.model.BranchMaster updateBranchMaster(
		com.ax.hrms.master.model.BranchMaster branchMaster) {

		return _branchMasterLocalService.updateBranchMaster(branchMaster);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _branchMasterLocalService.getBasePersistence();
	}

	@Override
	public BranchMasterLocalService getWrappedService() {
		return _branchMasterLocalService;
	}

	@Override
	public void setWrappedService(
		BranchMasterLocalService branchMasterLocalService) {

		_branchMasterLocalService = branchMasterLocalService;
	}

	private BranchMasterLocalService _branchMasterLocalService;

}