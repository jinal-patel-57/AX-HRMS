/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link LeavePolicyMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeavePolicyMasterLocalService
 * @generated
 */
public class LeavePolicyMasterLocalServiceWrapper
	implements LeavePolicyMasterLocalService,
			   ServiceWrapper<LeavePolicyMasterLocalService> {

	public LeavePolicyMasterLocalServiceWrapper() {
		this(null);
	}

	public LeavePolicyMasterLocalServiceWrapper(
		LeavePolicyMasterLocalService leavePolicyMasterLocalService) {

		_leavePolicyMasterLocalService = leavePolicyMasterLocalService;
	}

	/**
	 * Adds the leave policy master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeavePolicyMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leavePolicyMaster the leave policy master
	 * @return the leave policy master that was added
	 */
	@Override
	public com.ax.hrms.master.model.LeavePolicyMaster addLeavePolicyMaster(
		com.ax.hrms.master.model.LeavePolicyMaster leavePolicyMaster) {

		return _leavePolicyMasterLocalService.addLeavePolicyMaster(
			leavePolicyMaster);
	}

	/**
	 * Creates a new leave policy master with the primary key. Does not add the leave policy master to the database.
	 *
	 * @param leavePolicyMasterId the primary key for the new leave policy master
	 * @return the new leave policy master
	 */
	@Override
	public com.ax.hrms.master.model.LeavePolicyMaster createLeavePolicyMaster(
		long leavePolicyMasterId) {

		return _leavePolicyMasterLocalService.createLeavePolicyMaster(
			leavePolicyMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leavePolicyMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the leave policy master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeavePolicyMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leavePolicyMaster the leave policy master
	 * @return the leave policy master that was removed
	 */
	@Override
	public com.ax.hrms.master.model.LeavePolicyMaster deleteLeavePolicyMaster(
		com.ax.hrms.master.model.LeavePolicyMaster leavePolicyMaster) {

		return _leavePolicyMasterLocalService.deleteLeavePolicyMaster(
			leavePolicyMaster);
	}

	/**
	 * Deletes the leave policy master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeavePolicyMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leavePolicyMasterId the primary key of the leave policy master
	 * @return the leave policy master that was removed
	 * @throws PortalException if a leave policy master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.LeavePolicyMaster deleteLeavePolicyMaster(
			long leavePolicyMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leavePolicyMasterLocalService.deleteLeavePolicyMaster(
			leavePolicyMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leavePolicyMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _leavePolicyMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _leavePolicyMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leavePolicyMasterLocalService.dynamicQuery();
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

		return _leavePolicyMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.LeavePolicyMasterModelImpl</code>.
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

		return _leavePolicyMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.LeavePolicyMasterModelImpl</code>.
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

		return _leavePolicyMasterLocalService.dynamicQuery(
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

		return _leavePolicyMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _leavePolicyMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.master.model.LeavePolicyMaster fetchLeavePolicyMaster(
		long leavePolicyMasterId) {

		return _leavePolicyMasterLocalService.fetchLeavePolicyMaster(
			leavePolicyMasterId);
	}

	@Override
	public com.ax.hrms.master.model.LeavePolicyMaster findByLeaveTypeMasterId(
			long leaveTypeMasterId)
		throws com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException {

		return _leavePolicyMasterLocalService.findByLeaveTypeMasterId(
			leaveTypeMasterId);
	}

	@Override
	public com.ax.hrms.master.model.LeavePolicyMaster
			findByLeaveTypeMasterIdAndYear(
				long leaveTypeMasterId, int yearOfPolicy)
		throws com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException {

		return _leavePolicyMasterLocalService.findByLeaveTypeMasterIdAndYear(
			leaveTypeMasterId, yearOfPolicy);
	}

	@Override
	public com.ax.hrms.master.model.LeavePolicyMaster
			findByLeaveTypeMasterIdAndYearOfPolicy(
				long leaveTypeMasterId, int yearOfPolicy)
		throws com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException {

		return _leavePolicyMasterLocalService.
			findByLeaveTypeMasterIdAndYearOfPolicy(
				leaveTypeMasterId, yearOfPolicy);
	}

	@Override
	public com.ax.hrms.master.model.LeavePolicyMaster
			findByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
				long leaveTypeMasterId, int yearOfPolicy,
				int eligibleAfterMonths)
		throws com.ax.hrms.master.exception.NoSuchLeavePolicyMasterException {

		return _leavePolicyMasterLocalService.
			findByLeaveTypeMasterIdAndYearOfPolicyAndEligibleAfterMonths(
				leaveTypeMasterId, yearOfPolicy, eligibleAfterMonths);
	}

	@Override
	public java.util.List<com.ax.hrms.master.model.LeavePolicyMaster>
		findByYear(int yearOfPolicy) {

		return _leavePolicyMasterLocalService.findByYear(yearOfPolicy);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _leavePolicyMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _leavePolicyMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the leave policy master with the primary key.
	 *
	 * @param leavePolicyMasterId the primary key of the leave policy master
	 * @return the leave policy master
	 * @throws PortalException if a leave policy master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.LeavePolicyMaster getLeavePolicyMaster(
			long leavePolicyMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leavePolicyMasterLocalService.getLeavePolicyMaster(
			leavePolicyMasterId);
	}

	/**
	 * Returns a range of all the leave policy masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.LeavePolicyMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave policy masters
	 * @param end the upper bound of the range of leave policy masters (not inclusive)
	 * @return the range of leave policy masters
	 */
	@Override
	public java.util.List<com.ax.hrms.master.model.LeavePolicyMaster>
		getLeavePolicyMasters(int start, int end) {

		return _leavePolicyMasterLocalService.getLeavePolicyMasters(start, end);
	}

	/**
	 * Returns the number of leave policy masters.
	 *
	 * @return the number of leave policy masters
	 */
	@Override
	public int getLeavePolicyMastersCount() {
		return _leavePolicyMasterLocalService.getLeavePolicyMastersCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leavePolicyMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leavePolicyMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the leave policy master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeavePolicyMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leavePolicyMaster the leave policy master
	 * @return the leave policy master that was updated
	 */
	@Override
	public com.ax.hrms.master.model.LeavePolicyMaster updateLeavePolicyMaster(
		com.ax.hrms.master.model.LeavePolicyMaster leavePolicyMaster) {

		return _leavePolicyMasterLocalService.updateLeavePolicyMaster(
			leavePolicyMaster);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _leavePolicyMasterLocalService.getBasePersistence();
	}

	@Override
	public LeavePolicyMasterLocalService getWrappedService() {
		return _leavePolicyMasterLocalService;
	}

	@Override
	public void setWrappedService(
		LeavePolicyMasterLocalService leavePolicyMasterLocalService) {

		_leavePolicyMasterLocalService = leavePolicyMasterLocalService;
	}

	private LeavePolicyMasterLocalService _leavePolicyMasterLocalService;

}