/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link PriorityMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PriorityMasterLocalService
 * @generated
 */
public class PriorityMasterLocalServiceWrapper
	implements PriorityMasterLocalService,
			   ServiceWrapper<PriorityMasterLocalService> {

	public PriorityMasterLocalServiceWrapper() {
		this(null);
	}

	public PriorityMasterLocalServiceWrapper(
		PriorityMasterLocalService priorityMasterLocalService) {

		_priorityMasterLocalService = priorityMasterLocalService;
	}

	/**
	 * Adds the priority master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PriorityMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param priorityMaster the priority master
	 * @return the priority master that was added
	 */
	@Override
	public com.ax.hrms.master.model.PriorityMaster addPriorityMaster(
		com.ax.hrms.master.model.PriorityMaster priorityMaster) {

		return _priorityMasterLocalService.addPriorityMaster(priorityMaster);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _priorityMasterLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new priority master with the primary key. Does not add the priority master to the database.
	 *
	 * @param priorityMasterId the primary key for the new priority master
	 * @return the new priority master
	 */
	@Override
	public com.ax.hrms.master.model.PriorityMaster createPriorityMaster(
		long priorityMasterId) {

		return _priorityMasterLocalService.createPriorityMaster(
			priorityMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _priorityMasterLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the priority master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PriorityMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param priorityMasterId the primary key of the priority master
	 * @return the priority master that was removed
	 * @throws PortalException if a priority master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.PriorityMaster deletePriorityMaster(
			long priorityMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _priorityMasterLocalService.deletePriorityMaster(
			priorityMasterId);
	}

	/**
	 * Deletes the priority master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PriorityMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param priorityMaster the priority master
	 * @return the priority master that was removed
	 */
	@Override
	public com.ax.hrms.master.model.PriorityMaster deletePriorityMaster(
		com.ax.hrms.master.model.PriorityMaster priorityMaster) {

		return _priorityMasterLocalService.deletePriorityMaster(priorityMaster);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _priorityMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _priorityMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _priorityMasterLocalService.dynamicQuery();
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

		return _priorityMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.PriorityMasterModelImpl</code>.
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

		return _priorityMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.PriorityMasterModelImpl</code>.
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

		return _priorityMasterLocalService.dynamicQuery(
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

		return _priorityMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _priorityMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.master.model.PriorityMaster fetchPriorityMaster(
		long priorityMasterId) {

		return _priorityMasterLocalService.fetchPriorityMaster(
			priorityMasterId);
	}

	@Override
	public com.ax.hrms.master.model.PriorityMaster findByPriorityName(
			String priorityName)
		throws com.ax.hrms.master.exception.NoSuchPriorityMasterException {

		return _priorityMasterLocalService.findByPriorityName(priorityName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _priorityMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _priorityMasterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _priorityMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _priorityMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public long getPriorityIdByPriorityName(String priorityName) {
		return _priorityMasterLocalService.getPriorityIdByPriorityName(
			priorityName);
	}

	/**
	 * Returns the priority master with the primary key.
	 *
	 * @param priorityMasterId the primary key of the priority master
	 * @return the priority master
	 * @throws PortalException if a priority master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.PriorityMaster getPriorityMaster(
			long priorityMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _priorityMasterLocalService.getPriorityMaster(priorityMasterId);
	}

	/**
	 * Returns a range of all the priority masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.PriorityMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of priority masters
	 * @param end the upper bound of the range of priority masters (not inclusive)
	 * @return the range of priority masters
	 */
	@Override
	public java.util.List<com.ax.hrms.master.model.PriorityMaster>
		getPriorityMasters(int start, int end) {

		return _priorityMasterLocalService.getPriorityMasters(start, end);
	}

	/**
	 * Returns the number of priority masters.
	 *
	 * @return the number of priority masters
	 */
	@Override
	public int getPriorityMastersCount() {
		return _priorityMasterLocalService.getPriorityMastersCount();
	}

	@Override
	public boolean isPriorityNameExist(String priorityName) {
		return _priorityMasterLocalService.isPriorityNameExist(priorityName);
	}

	/**
	 * Updates the priority master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PriorityMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param priorityMaster the priority master
	 * @return the priority master that was updated
	 */
	@Override
	public com.ax.hrms.master.model.PriorityMaster updatePriorityMaster(
		com.ax.hrms.master.model.PriorityMaster priorityMaster) {

		return _priorityMasterLocalService.updatePriorityMaster(priorityMaster);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _priorityMasterLocalService.getBasePersistence();
	}

	@Override
	public PriorityMasterLocalService getWrappedService() {
		return _priorityMasterLocalService;
	}

	@Override
	public void setWrappedService(
		PriorityMasterLocalService priorityMasterLocalService) {

		_priorityMasterLocalService = priorityMasterLocalService;
	}

	private PriorityMasterLocalService _priorityMasterLocalService;

}