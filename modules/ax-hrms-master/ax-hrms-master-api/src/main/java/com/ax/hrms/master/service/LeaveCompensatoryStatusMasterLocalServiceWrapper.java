/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link LeaveCompensatoryStatusMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveCompensatoryStatusMasterLocalService
 * @generated
 */
public class LeaveCompensatoryStatusMasterLocalServiceWrapper
	implements LeaveCompensatoryStatusMasterLocalService,
			   ServiceWrapper<LeaveCompensatoryStatusMasterLocalService> {

	public LeaveCompensatoryStatusMasterLocalServiceWrapper() {
		this(null);
	}

	public LeaveCompensatoryStatusMasterLocalServiceWrapper(
		LeaveCompensatoryStatusMasterLocalService
			leaveCompensatoryStatusMasterLocalService) {

		_leaveCompensatoryStatusMasterLocalService =
			leaveCompensatoryStatusMasterLocalService;
	}

	/**
	 * Adds the leave compensatory status master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveCompensatoryStatusMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveCompensatoryStatusMaster the leave compensatory status master
	 * @return the leave compensatory status master that was added
	 */
	@Override
	public com.ax.hrms.master.model.LeaveCompensatoryStatusMaster
		addLeaveCompensatoryStatusMaster(
			com.ax.hrms.master.model.LeaveCompensatoryStatusMaster
				leaveCompensatoryStatusMaster) {

		return _leaveCompensatoryStatusMasterLocalService.
			addLeaveCompensatoryStatusMaster(leaveCompensatoryStatusMaster);
	}

	/**
	 * Creates a new leave compensatory status master with the primary key. Does not add the leave compensatory status master to the database.
	 *
	 * @param leaveCompensatoryStatusMasterId the primary key for the new leave compensatory status master
	 * @return the new leave compensatory status master
	 */
	@Override
	public com.ax.hrms.master.model.LeaveCompensatoryStatusMaster
		createLeaveCompensatoryStatusMaster(
			long leaveCompensatoryStatusMasterId) {

		return _leaveCompensatoryStatusMasterLocalService.
			createLeaveCompensatoryStatusMaster(
				leaveCompensatoryStatusMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveCompensatoryStatusMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the leave compensatory status master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveCompensatoryStatusMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveCompensatoryStatusMaster the leave compensatory status master
	 * @return the leave compensatory status master that was removed
	 */
	@Override
	public com.ax.hrms.master.model.LeaveCompensatoryStatusMaster
		deleteLeaveCompensatoryStatusMaster(
			com.ax.hrms.master.model.LeaveCompensatoryStatusMaster
				leaveCompensatoryStatusMaster) {

		return _leaveCompensatoryStatusMasterLocalService.
			deleteLeaveCompensatoryStatusMaster(leaveCompensatoryStatusMaster);
	}

	/**
	 * Deletes the leave compensatory status master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveCompensatoryStatusMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveCompensatoryStatusMasterId the primary key of the leave compensatory status master
	 * @return the leave compensatory status master that was removed
	 * @throws PortalException if a leave compensatory status master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.LeaveCompensatoryStatusMaster
			deleteLeaveCompensatoryStatusMaster(
				long leaveCompensatoryStatusMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveCompensatoryStatusMasterLocalService.
			deleteLeaveCompensatoryStatusMaster(
				leaveCompensatoryStatusMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveCompensatoryStatusMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _leaveCompensatoryStatusMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _leaveCompensatoryStatusMasterLocalService.dslQueryCount(
			dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveCompensatoryStatusMasterLocalService.dynamicQuery();
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

		return _leaveCompensatoryStatusMasterLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.LeaveCompensatoryStatusMasterModelImpl</code>.
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

		return _leaveCompensatoryStatusMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.LeaveCompensatoryStatusMasterModelImpl</code>.
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

		return _leaveCompensatoryStatusMasterLocalService.dynamicQuery(
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

		return _leaveCompensatoryStatusMasterLocalService.dynamicQueryCount(
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

		return _leaveCompensatoryStatusMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.master.model.LeaveCompensatoryStatusMaster
		fetchLeaveCompensatoryStatusMaster(
			long leaveCompensatoryStatusMasterId) {

		return _leaveCompensatoryStatusMasterLocalService.
			fetchLeaveCompensatoryStatusMaster(leaveCompensatoryStatusMasterId);
	}

	@Override
	public com.ax.hrms.master.model.LeaveCompensatoryStatusMaster
			findByLeaveCompensatoryStatusById(
				long leaveCompensatoryStatusMasterId)
		throws com.ax.hrms.master.exception.
			NoSuchLeaveCompensatoryStatusMasterException {

		return _leaveCompensatoryStatusMasterLocalService.
			findByLeaveCompensatoryStatusById(leaveCompensatoryStatusMasterId);
	}

	@Override
	public com.ax.hrms.master.model.LeaveCompensatoryStatusMaster
			findByLeaveCompensatoryStatusName(
				String leaveCompensatoryStatusName)
		throws com.ax.hrms.master.exception.
			NoSuchLeaveCompensatoryStatusMasterException {

		return _leaveCompensatoryStatusMasterLocalService.
			findByLeaveCompensatoryStatusName(leaveCompensatoryStatusName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _leaveCompensatoryStatusMasterLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _leaveCompensatoryStatusMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the leave compensatory status master with the primary key.
	 *
	 * @param leaveCompensatoryStatusMasterId the primary key of the leave compensatory status master
	 * @return the leave compensatory status master
	 * @throws PortalException if a leave compensatory status master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.LeaveCompensatoryStatusMaster
			getLeaveCompensatoryStatusMaster(
				long leaveCompensatoryStatusMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveCompensatoryStatusMasterLocalService.
			getLeaveCompensatoryStatusMaster(leaveCompensatoryStatusMasterId);
	}

	/**
	 * Returns a range of all the leave compensatory status masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.LeaveCompensatoryStatusMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave compensatory status masters
	 * @param end the upper bound of the range of leave compensatory status masters (not inclusive)
	 * @return the range of leave compensatory status masters
	 */
	@Override
	public java.util.List
		<com.ax.hrms.master.model.LeaveCompensatoryStatusMaster>
			getLeaveCompensatoryStatusMasters(int start, int end) {

		return _leaveCompensatoryStatusMasterLocalService.
			getLeaveCompensatoryStatusMasters(start, end);
	}

	/**
	 * Returns the number of leave compensatory status masters.
	 *
	 * @return the number of leave compensatory status masters
	 */
	@Override
	public int getLeaveCompensatoryStatusMastersCount() {
		return _leaveCompensatoryStatusMasterLocalService.
			getLeaveCompensatoryStatusMastersCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveCompensatoryStatusMasterLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveCompensatoryStatusMasterLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the leave compensatory status master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveCompensatoryStatusMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveCompensatoryStatusMaster the leave compensatory status master
	 * @return the leave compensatory status master that was updated
	 */
	@Override
	public com.ax.hrms.master.model.LeaveCompensatoryStatusMaster
		updateLeaveCompensatoryStatusMaster(
			com.ax.hrms.master.model.LeaveCompensatoryStatusMaster
				leaveCompensatoryStatusMaster) {

		return _leaveCompensatoryStatusMasterLocalService.
			updateLeaveCompensatoryStatusMaster(leaveCompensatoryStatusMaster);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _leaveCompensatoryStatusMasterLocalService.getBasePersistence();
	}

	@Override
	public LeaveCompensatoryStatusMasterLocalService getWrappedService() {
		return _leaveCompensatoryStatusMasterLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveCompensatoryStatusMasterLocalService
			leaveCompensatoryStatusMasterLocalService) {

		_leaveCompensatoryStatusMasterLocalService =
			leaveCompensatoryStatusMasterLocalService;
	}

	private LeaveCompensatoryStatusMasterLocalService
		_leaveCompensatoryStatusMasterLocalService;

}