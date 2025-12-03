/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EmployeeWishLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeWishLocalService
 * @generated
 */
public class EmployeeWishLocalServiceWrapper
	implements EmployeeWishLocalService,
			   ServiceWrapper<EmployeeWishLocalService> {

	public EmployeeWishLocalServiceWrapper() {
		this(null);
	}

	public EmployeeWishLocalServiceWrapper(
		EmployeeWishLocalService employeeWishLocalService) {

		_employeeWishLocalService = employeeWishLocalService;
	}

	/**
	 * Adds the employee wish to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeWishLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeWish the employee wish
	 * @return the employee wish that was added
	 */
	@Override
	public com.ax.hrms.model.EmployeeWish addEmployeeWish(
		com.ax.hrms.model.EmployeeWish employeeWish) {

		return _employeeWishLocalService.addEmployeeWish(employeeWish);
	}

	/**
	 * Creates a new employee wish with the primary key. Does not add the employee wish to the database.
	 *
	 * @param wishId the primary key for the new employee wish
	 * @return the new employee wish
	 */
	@Override
	public com.ax.hrms.model.EmployeeWish createEmployeeWish(long wishId) {
		return _employeeWishLocalService.createEmployeeWish(wishId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeWishLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the employee wish from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeWishLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeWish the employee wish
	 * @return the employee wish that was removed
	 */
	@Override
	public com.ax.hrms.model.EmployeeWish deleteEmployeeWish(
		com.ax.hrms.model.EmployeeWish employeeWish) {

		return _employeeWishLocalService.deleteEmployeeWish(employeeWish);
	}

	/**
	 * Deletes the employee wish with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeWishLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param wishId the primary key of the employee wish
	 * @return the employee wish that was removed
	 * @throws PortalException if a employee wish with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeWish deleteEmployeeWish(long wishId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeWishLocalService.deleteEmployeeWish(wishId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeWishLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _employeeWishLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _employeeWishLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeWishLocalService.dynamicQuery();
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

		return _employeeWishLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeWishModelImpl</code>.
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

		return _employeeWishLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeWishModelImpl</code>.
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

		return _employeeWishLocalService.dynamicQuery(
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

		return _employeeWishLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeWishLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.EmployeeWish fetchEmployeeWish(long wishId) {
		return _employeeWishLocalService.fetchEmployeeWish(wishId);
	}

	/**
	 * Returns the employee wish matching the UUID and group.
	 *
	 * @param uuid the employee wish's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee wish, or <code>null</code> if a matching employee wish could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeWish fetchEmployeeWishByUuidAndGroupId(
		String uuid, long groupId) {

		return _employeeWishLocalService.fetchEmployeeWishByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeWishLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the employee wish with the primary key.
	 *
	 * @param wishId the primary key of the employee wish
	 * @return the employee wish
	 * @throws PortalException if a employee wish with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeWish getEmployeeWish(long wishId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeWishLocalService.getEmployeeWish(wishId);
	}

	/**
	 * Returns the employee wish matching the UUID and group.
	 *
	 * @param uuid the employee wish's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee wish
	 * @throws PortalException if a matching employee wish could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeWish getEmployeeWishByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeWishLocalService.getEmployeeWishByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the employee wishes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeWishModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee wishes
	 * @param end the upper bound of the range of employee wishes (not inclusive)
	 * @return the range of employee wishes
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeWish> getEmployeeWishes(
		int start, int end) {

		return _employeeWishLocalService.getEmployeeWishes(start, end);
	}

	/**
	 * Returns all the employee wishes matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee wishes
	 * @param companyId the primary key of the company
	 * @return the matching employee wishes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeWish>
		getEmployeeWishesByUuidAndCompanyId(String uuid, long companyId) {

		return _employeeWishLocalService.getEmployeeWishesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of employee wishes matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee wishes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee wishes
	 * @param end the upper bound of the range of employee wishes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee wishes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeWish>
		getEmployeeWishesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.EmployeeWish> orderByComparator) {

		return _employeeWishLocalService.getEmployeeWishesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee wishes.
	 *
	 * @return the number of employee wishes
	 */
	@Override
	public int getEmployeeWishesCount() {
		return _employeeWishLocalService.getEmployeeWishesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _employeeWishLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeWishLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeWishLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeWishLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee wish in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeWishLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeWish the employee wish
	 * @return the employee wish that was updated
	 */
	@Override
	public com.ax.hrms.model.EmployeeWish updateEmployeeWish(
		com.ax.hrms.model.EmployeeWish employeeWish) {

		return _employeeWishLocalService.updateEmployeeWish(employeeWish);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _employeeWishLocalService.getBasePersistence();
	}

	@Override
	public EmployeeWishLocalService getWrappedService() {
		return _employeeWishLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeWishLocalService employeeWishLocalService) {

		_employeeWishLocalService = employeeWishLocalService;
	}

	private EmployeeWishLocalService _employeeWishLocalService;

}