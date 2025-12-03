/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ProbationStatusMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProbationStatusMasterLocalService
 * @generated
 */
public class ProbationStatusMasterLocalServiceWrapper
	implements ProbationStatusMasterLocalService,
			   ServiceWrapper<ProbationStatusMasterLocalService> {

	public ProbationStatusMasterLocalServiceWrapper() {
		this(null);
	}

	public ProbationStatusMasterLocalServiceWrapper(
		ProbationStatusMasterLocalService probationStatusMasterLocalService) {

		_probationStatusMasterLocalService = probationStatusMasterLocalService;
	}

	/**
	 * Adds the probation status master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProbationStatusMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param probationStatusMaster the probation status master
	 * @return the probation status master that was added
	 */
	@Override
	public com.ax.hrms.master.model.ProbationStatusMaster
		addProbationStatusMaster(
			com.ax.hrms.master.model.ProbationStatusMaster
				probationStatusMaster) {

		return _probationStatusMasterLocalService.addProbationStatusMaster(
			probationStatusMaster);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _probationStatusMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new probation status master with the primary key. Does not add the probation status master to the database.
	 *
	 * @param probationStatusMasterId the primary key for the new probation status master
	 * @return the new probation status master
	 */
	@Override
	public com.ax.hrms.master.model.ProbationStatusMaster
		createProbationStatusMaster(long probationStatusMasterId) {

		return _probationStatusMasterLocalService.createProbationStatusMaster(
			probationStatusMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _probationStatusMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the probation status master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProbationStatusMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param probationStatusMasterId the primary key of the probation status master
	 * @return the probation status master that was removed
	 * @throws PortalException if a probation status master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.ProbationStatusMaster
			deleteProbationStatusMaster(long probationStatusMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _probationStatusMasterLocalService.deleteProbationStatusMaster(
			probationStatusMasterId);
	}

	/**
	 * Deletes the probation status master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProbationStatusMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param probationStatusMaster the probation status master
	 * @return the probation status master that was removed
	 */
	@Override
	public com.ax.hrms.master.model.ProbationStatusMaster
		deleteProbationStatusMaster(
			com.ax.hrms.master.model.ProbationStatusMaster
				probationStatusMaster) {

		return _probationStatusMasterLocalService.deleteProbationStatusMaster(
			probationStatusMaster);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _probationStatusMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _probationStatusMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _probationStatusMasterLocalService.dynamicQuery();
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

		return _probationStatusMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.ProbationStatusMasterModelImpl</code>.
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

		return _probationStatusMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.ProbationStatusMasterModelImpl</code>.
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

		return _probationStatusMasterLocalService.dynamicQuery(
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

		return _probationStatusMasterLocalService.dynamicQueryCount(
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

		return _probationStatusMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.master.model.ProbationStatusMaster
		fetchProbationStatusMaster(long probationStatusMasterId) {

		return _probationStatusMasterLocalService.fetchProbationStatusMaster(
			probationStatusMasterId);
	}

	@Override
	public com.ax.hrms.master.model.ProbationStatusMaster
			findByProbationStatusName(String probationStatus)
		throws com.ax.hrms.master.exception.
			NoSuchProbationStatusMasterException {

		return _probationStatusMasterLocalService.findByProbationStatusName(
			probationStatus);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _probationStatusMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _probationStatusMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _probationStatusMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _probationStatusMasterLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the probation status master with the primary key.
	 *
	 * @param probationStatusMasterId the primary key of the probation status master
	 * @return the probation status master
	 * @throws PortalException if a probation status master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.ProbationStatusMaster
			getProbationStatusMaster(long probationStatusMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _probationStatusMasterLocalService.getProbationStatusMaster(
			probationStatusMasterId);
	}

	/**
	 * Returns a range of all the probation status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.ProbationStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of probation status masters
	 * @param end the upper bound of the range of probation status masters (not inclusive)
	 * @return the range of probation status masters
	 */
	@Override
	public java.util.List<com.ax.hrms.master.model.ProbationStatusMaster>
		getProbationStatusMasters(int start, int end) {

		return _probationStatusMasterLocalService.getProbationStatusMasters(
			start, end);
	}

	/**
	 * Returns the number of probation status masters.
	 *
	 * @return the number of probation status masters
	 */
	@Override
	public int getProbationStatusMastersCount() {
		return _probationStatusMasterLocalService.
			getProbationStatusMastersCount();
	}

	/**
	 * Updates the probation status master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProbationStatusMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param probationStatusMaster the probation status master
	 * @return the probation status master that was updated
	 */
	@Override
	public com.ax.hrms.master.model.ProbationStatusMaster
		updateProbationStatusMaster(
			com.ax.hrms.master.model.ProbationStatusMaster
				probationStatusMaster) {

		return _probationStatusMasterLocalService.updateProbationStatusMaster(
			probationStatusMaster);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _probationStatusMasterLocalService.getBasePersistence();
	}

	@Override
	public ProbationStatusMasterLocalService getWrappedService() {
		return _probationStatusMasterLocalService;
	}

	@Override
	public void setWrappedService(
		ProbationStatusMasterLocalService probationStatusMasterLocalService) {

		_probationStatusMasterLocalService = probationStatusMasterLocalService;
	}

	private ProbationStatusMasterLocalService
		_probationStatusMasterLocalService;

}