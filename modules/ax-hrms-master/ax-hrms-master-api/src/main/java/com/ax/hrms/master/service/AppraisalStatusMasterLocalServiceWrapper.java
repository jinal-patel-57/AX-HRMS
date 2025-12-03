/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AppraisalStatusMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalStatusMasterLocalService
 * @generated
 */
public class AppraisalStatusMasterLocalServiceWrapper
	implements AppraisalStatusMasterLocalService,
			   ServiceWrapper<AppraisalStatusMasterLocalService> {

	public AppraisalStatusMasterLocalServiceWrapper() {
		this(null);
	}

	public AppraisalStatusMasterLocalServiceWrapper(
		AppraisalStatusMasterLocalService appraisalStatusMasterLocalService) {

		_appraisalStatusMasterLocalService = appraisalStatusMasterLocalService;
	}

	/**
	 * Adds the appraisal status master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalStatusMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalStatusMaster the appraisal status master
	 * @return the appraisal status master that was added
	 */
	@Override
	public com.ax.hrms.master.model.AppraisalStatusMaster
		addAppraisalStatusMaster(
			com.ax.hrms.master.model.AppraisalStatusMaster
				appraisalStatusMaster) {

		return _appraisalStatusMasterLocalService.addAppraisalStatusMaster(
			appraisalStatusMaster);
	}

	/**
	 * Creates a new appraisal status master with the primary key. Does not add the appraisal status master to the database.
	 *
	 * @param appraisalStatusMasterId the primary key for the new appraisal status master
	 * @return the new appraisal status master
	 */
	@Override
	public com.ax.hrms.master.model.AppraisalStatusMaster
		createAppraisalStatusMaster(long appraisalStatusMasterId) {

		return _appraisalStatusMasterLocalService.createAppraisalStatusMaster(
			appraisalStatusMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalStatusMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the appraisal status master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalStatusMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalStatusMaster the appraisal status master
	 * @return the appraisal status master that was removed
	 */
	@Override
	public com.ax.hrms.master.model.AppraisalStatusMaster
		deleteAppraisalStatusMaster(
			com.ax.hrms.master.model.AppraisalStatusMaster
				appraisalStatusMaster) {

		return _appraisalStatusMasterLocalService.deleteAppraisalStatusMaster(
			appraisalStatusMaster);
	}

	/**
	 * Deletes the appraisal status master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalStatusMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalStatusMasterId the primary key of the appraisal status master
	 * @return the appraisal status master that was removed
	 * @throws PortalException if a appraisal status master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.AppraisalStatusMaster
			deleteAppraisalStatusMaster(long appraisalStatusMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalStatusMasterLocalService.deleteAppraisalStatusMaster(
			appraisalStatusMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalStatusMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _appraisalStatusMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _appraisalStatusMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appraisalStatusMasterLocalService.dynamicQuery();
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

		return _appraisalStatusMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.AppraisalStatusMasterModelImpl</code>.
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

		return _appraisalStatusMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.AppraisalStatusMasterModelImpl</code>.
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

		return _appraisalStatusMasterLocalService.dynamicQuery(
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

		return _appraisalStatusMasterLocalService.dynamicQueryCount(
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

		return _appraisalStatusMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.master.model.AppraisalStatusMaster
		fetchAppraisalStatusMaster(long appraisalStatusMasterId) {

		return _appraisalStatusMasterLocalService.fetchAppraisalStatusMaster(
			appraisalStatusMasterId);
	}

	@Override
	public com.ax.hrms.master.model.AppraisalStatusMaster findBystatus(
			String status)
		throws com.ax.hrms.master.exception.
			NoSuchAppraisalStatusMasterException {

		return _appraisalStatusMasterLocalService.findBystatus(status);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _appraisalStatusMasterLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the appraisal status master with the primary key.
	 *
	 * @param appraisalStatusMasterId the primary key of the appraisal status master
	 * @return the appraisal status master
	 * @throws PortalException if a appraisal status master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.AppraisalStatusMaster
			getAppraisalStatusMaster(long appraisalStatusMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalStatusMasterLocalService.getAppraisalStatusMaster(
			appraisalStatusMasterId);
	}

	/**
	 * Returns a range of all the appraisal status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.AppraisalStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal status masters
	 * @param end the upper bound of the range of appraisal status masters (not inclusive)
	 * @return the range of appraisal status masters
	 */
	@Override
	public java.util.List<com.ax.hrms.master.model.AppraisalStatusMaster>
		getAppraisalStatusMasters(int start, int end) {

		return _appraisalStatusMasterLocalService.getAppraisalStatusMasters(
			start, end);
	}

	/**
	 * Returns the number of appraisal status masters.
	 *
	 * @return the number of appraisal status masters
	 */
	@Override
	public int getAppraisalStatusMastersCount() {
		return _appraisalStatusMasterLocalService.
			getAppraisalStatusMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _appraisalStatusMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appraisalStatusMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalStatusMasterLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the appraisal status master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalStatusMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalStatusMaster the appraisal status master
	 * @return the appraisal status master that was updated
	 */
	@Override
	public com.ax.hrms.master.model.AppraisalStatusMaster
		updateAppraisalStatusMaster(
			com.ax.hrms.master.model.AppraisalStatusMaster
				appraisalStatusMaster) {

		return _appraisalStatusMasterLocalService.updateAppraisalStatusMaster(
			appraisalStatusMaster);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _appraisalStatusMasterLocalService.getBasePersistence();
	}

	@Override
	public AppraisalStatusMasterLocalService getWrappedService() {
		return _appraisalStatusMasterLocalService;
	}

	@Override
	public void setWrappedService(
		AppraisalStatusMasterLocalService appraisalStatusMasterLocalService) {

		_appraisalStatusMasterLocalService = appraisalStatusMasterLocalService;
	}

	private AppraisalStatusMasterLocalService
		_appraisalStatusMasterLocalService;

}