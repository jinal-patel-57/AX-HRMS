/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link LeaveTypeMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTypeMasterLocalService
 * @generated
 */
public class LeaveTypeMasterLocalServiceWrapper
	implements LeaveTypeMasterLocalService,
			   ServiceWrapper<LeaveTypeMasterLocalService> {

	public LeaveTypeMasterLocalServiceWrapper() {
		this(null);
	}

	public LeaveTypeMasterLocalServiceWrapper(
		LeaveTypeMasterLocalService leaveTypeMasterLocalService) {

		_leaveTypeMasterLocalService = leaveTypeMasterLocalService;
	}

	/**
	 * Adds the leave type master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTypeMaster the leave type master
	 * @return the leave type master that was added
	 */
	@Override
	public com.ax.hrms.master.model.LeaveTypeMaster addLeaveTypeMaster(
		com.ax.hrms.master.model.LeaveTypeMaster leaveTypeMaster) {

		return _leaveTypeMasterLocalService.addLeaveTypeMaster(leaveTypeMaster);
	}

	/**
	 * Creates a new leave type master with the primary key. Does not add the leave type master to the database.
	 *
	 * @param leaveTypeMasterId the primary key for the new leave type master
	 * @return the new leave type master
	 */
	@Override
	public com.ax.hrms.master.model.LeaveTypeMaster createLeaveTypeMaster(
		long leaveTypeMasterId) {

		return _leaveTypeMasterLocalService.createLeaveTypeMaster(
			leaveTypeMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTypeMasterLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the leave type master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTypeMaster the leave type master
	 * @return the leave type master that was removed
	 */
	@Override
	public com.ax.hrms.master.model.LeaveTypeMaster deleteLeaveTypeMaster(
		com.ax.hrms.master.model.LeaveTypeMaster leaveTypeMaster) {

		return _leaveTypeMasterLocalService.deleteLeaveTypeMaster(
			leaveTypeMaster);
	}

	/**
	 * Deletes the leave type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTypeMasterId the primary key of the leave type master
	 * @return the leave type master that was removed
	 * @throws PortalException if a leave type master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.LeaveTypeMaster deleteLeaveTypeMaster(
			long leaveTypeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTypeMasterLocalService.deleteLeaveTypeMaster(
			leaveTypeMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTypeMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _leaveTypeMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _leaveTypeMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaveTypeMasterLocalService.dynamicQuery();
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

		return _leaveTypeMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.LeaveTypeMasterModelImpl</code>.
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

		return _leaveTypeMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.LeaveTypeMasterModelImpl</code>.
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

		return _leaveTypeMasterLocalService.dynamicQuery(
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

		return _leaveTypeMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _leaveTypeMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.master.model.LeaveTypeMaster fetchLeaveTypeMaster(
		long leaveTypeMasterId) {

		return _leaveTypeMasterLocalService.fetchLeaveTypeMaster(
			leaveTypeMasterId);
	}

	@Override
	public java.util.List<com.ax.hrms.master.model.LeaveTypeMaster>
		findByActiveAndAppearForAll(boolean isActive, boolean isAppearForAll) {

		return _leaveTypeMasterLocalService.findByActiveAndAppearForAll(
			isActive, isAppearForAll);
	}

	@Override
	public com.ax.hrms.master.model.LeaveTypeMaster findByLeaveTypeMasterId(
			long leaveTypeMasterId)
		throws com.ax.hrms.master.exception.NoSuchLeaveTypeMasterException {

		return _leaveTypeMasterLocalService.findByLeaveTypeMasterId(
			leaveTypeMasterId);
	}

	@Override
	public com.ax.hrms.master.model.LeaveTypeMaster findByLeaveTypeName(
			String leaveTypeName)
		throws com.ax.hrms.master.exception.NoSuchLeaveTypeMasterException {

		return _leaveTypeMasterLocalService.findByLeaveTypeName(leaveTypeName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _leaveTypeMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _leaveTypeMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the leave type master with the primary key.
	 *
	 * @param leaveTypeMasterId the primary key of the leave type master
	 * @return the leave type master
	 * @throws PortalException if a leave type master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.LeaveTypeMaster getLeaveTypeMaster(
			long leaveTypeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTypeMasterLocalService.getLeaveTypeMaster(
			leaveTypeMasterId);
	}

	@Override
	public long getLeaveTypeMasterIdByName(String leaveTypeName) {
		return _leaveTypeMasterLocalService.getLeaveTypeMasterIdByName(
			leaveTypeName);
	}

	/**
	 * Returns a range of all the leave type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.LeaveTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave type masters
	 * @param end the upper bound of the range of leave type masters (not inclusive)
	 * @return the range of leave type masters
	 */
	@Override
	public java.util.List<com.ax.hrms.master.model.LeaveTypeMaster>
		getLeaveTypeMasters(int start, int end) {

		return _leaveTypeMasterLocalService.getLeaveTypeMasters(start, end);
	}

	/**
	 * Returns the number of leave type masters.
	 *
	 * @return the number of leave type masters
	 */
	@Override
	public int getLeaveTypeMastersCount() {
		return _leaveTypeMasterLocalService.getLeaveTypeMastersCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveTypeMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leaveTypeMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean isLeaveTypeNameExists(String leaveTypeName) {
		return _leaveTypeMasterLocalService.isLeaveTypeNameExists(
			leaveTypeName);
	}

	/**
	 * Updates the leave type master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveTypeMaster the leave type master
	 * @return the leave type master that was updated
	 */
	@Override
	public com.ax.hrms.master.model.LeaveTypeMaster updateLeaveTypeMaster(
		com.ax.hrms.master.model.LeaveTypeMaster leaveTypeMaster) {

		return _leaveTypeMasterLocalService.updateLeaveTypeMaster(
			leaveTypeMaster);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _leaveTypeMasterLocalService.getBasePersistence();
	}

	@Override
	public LeaveTypeMasterLocalService getWrappedService() {
		return _leaveTypeMasterLocalService;
	}

	@Override
	public void setWrappedService(
		LeaveTypeMasterLocalService leaveTypeMasterLocalService) {

		_leaveTypeMasterLocalService = leaveTypeMasterLocalService;
	}

	private LeaveTypeMasterLocalService _leaveTypeMasterLocalService;

}