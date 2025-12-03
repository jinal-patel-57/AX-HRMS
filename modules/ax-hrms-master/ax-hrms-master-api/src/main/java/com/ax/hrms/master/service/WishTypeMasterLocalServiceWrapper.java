/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link WishTypeMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WishTypeMasterLocalService
 * @generated
 */
public class WishTypeMasterLocalServiceWrapper
	implements ServiceWrapper<WishTypeMasterLocalService>,
			   WishTypeMasterLocalService {

	public WishTypeMasterLocalServiceWrapper() {
		this(null);
	}

	public WishTypeMasterLocalServiceWrapper(
		WishTypeMasterLocalService wishTypeMasterLocalService) {

		_wishTypeMasterLocalService = wishTypeMasterLocalService;
	}

	/**
	 * Adds the wish type master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WishTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param wishTypeMaster the wish type master
	 * @return the wish type master that was added
	 */
	@Override
	public com.ax.hrms.master.model.WishTypeMaster addWishTypeMaster(
		com.ax.hrms.master.model.WishTypeMaster wishTypeMaster) {

		return _wishTypeMasterLocalService.addWishTypeMaster(wishTypeMaster);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _wishTypeMasterLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new wish type master with the primary key. Does not add the wish type master to the database.
	 *
	 * @param wishTypeMasterId the primary key for the new wish type master
	 * @return the new wish type master
	 */
	@Override
	public com.ax.hrms.master.model.WishTypeMaster createWishTypeMaster(
		long wishTypeMasterId) {

		return _wishTypeMasterLocalService.createWishTypeMaster(
			wishTypeMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _wishTypeMasterLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the wish type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WishTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param wishTypeMasterId the primary key of the wish type master
	 * @return the wish type master that was removed
	 * @throws PortalException if a wish type master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.WishTypeMaster deleteWishTypeMaster(
			long wishTypeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _wishTypeMasterLocalService.deleteWishTypeMaster(
			wishTypeMasterId);
	}

	/**
	 * Deletes the wish type master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WishTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param wishTypeMaster the wish type master
	 * @return the wish type master that was removed
	 */
	@Override
	public com.ax.hrms.master.model.WishTypeMaster deleteWishTypeMaster(
		com.ax.hrms.master.model.WishTypeMaster wishTypeMaster) {

		return _wishTypeMasterLocalService.deleteWishTypeMaster(wishTypeMaster);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _wishTypeMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _wishTypeMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _wishTypeMasterLocalService.dynamicQuery();
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

		return _wishTypeMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.WishTypeMasterModelImpl</code>.
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

		return _wishTypeMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.WishTypeMasterModelImpl</code>.
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

		return _wishTypeMasterLocalService.dynamicQuery(
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

		return _wishTypeMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _wishTypeMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.master.model.WishTypeMaster fetchWishTypeMaster(
		long wishTypeMasterId) {

		return _wishTypeMasterLocalService.fetchWishTypeMaster(
			wishTypeMasterId);
	}

	@Override
	public com.ax.hrms.master.model.WishTypeMaster findByWishType(
			String wishType)
		throws com.ax.hrms.master.exception.NoSuchWishTypeMasterException {

		return _wishTypeMasterLocalService.findByWishType(wishType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _wishTypeMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _wishTypeMasterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _wishTypeMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _wishTypeMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the wish type master with the primary key.
	 *
	 * @param wishTypeMasterId the primary key of the wish type master
	 * @return the wish type master
	 * @throws PortalException if a wish type master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.WishTypeMaster getWishTypeMaster(
			long wishTypeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _wishTypeMasterLocalService.getWishTypeMaster(wishTypeMasterId);
	}

	/**
	 * Returns a range of all the wish type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.WishTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of wish type masters
	 * @param end the upper bound of the range of wish type masters (not inclusive)
	 * @return the range of wish type masters
	 */
	@Override
	public java.util.List<com.ax.hrms.master.model.WishTypeMaster>
		getWishTypeMasters(int start, int end) {

		return _wishTypeMasterLocalService.getWishTypeMasters(start, end);
	}

	/**
	 * Returns the number of wish type masters.
	 *
	 * @return the number of wish type masters
	 */
	@Override
	public int getWishTypeMastersCount() {
		return _wishTypeMasterLocalService.getWishTypeMastersCount();
	}

	/**
	 * Updates the wish type master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WishTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param wishTypeMaster the wish type master
	 * @return the wish type master that was updated
	 */
	@Override
	public com.ax.hrms.master.model.WishTypeMaster updateWishTypeMaster(
		com.ax.hrms.master.model.WishTypeMaster wishTypeMaster) {

		return _wishTypeMasterLocalService.updateWishTypeMaster(wishTypeMaster);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _wishTypeMasterLocalService.getBasePersistence();
	}

	@Override
	public WishTypeMasterLocalService getWrappedService() {
		return _wishTypeMasterLocalService;
	}

	@Override
	public void setWrappedService(
		WishTypeMasterLocalService wishTypeMasterLocalService) {

		_wishTypeMasterLocalService = wishTypeMasterLocalService;
	}

	private WishTypeMasterLocalService _wishTypeMasterLocalService;

}