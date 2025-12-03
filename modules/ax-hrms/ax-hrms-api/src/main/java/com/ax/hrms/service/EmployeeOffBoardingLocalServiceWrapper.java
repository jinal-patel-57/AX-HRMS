/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EmployeeOffBoardingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeOffBoardingLocalService
 * @generated
 */
public class EmployeeOffBoardingLocalServiceWrapper
	implements EmployeeOffBoardingLocalService,
			   ServiceWrapper<EmployeeOffBoardingLocalService> {

	public EmployeeOffBoardingLocalServiceWrapper() {
		this(null);
	}

	public EmployeeOffBoardingLocalServiceWrapper(
		EmployeeOffBoardingLocalService employeeOffBoardingLocalService) {

		_employeeOffBoardingLocalService = employeeOffBoardingLocalService;
	}

	/**
	 * Adds the employee off boarding to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeOffBoardingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeOffBoarding the employee off boarding
	 * @return the employee off boarding that was added
	 */
	@Override
	public com.ax.hrms.model.EmployeeOffBoarding addEmployeeOffBoarding(
		com.ax.hrms.model.EmployeeOffBoarding employeeOffBoarding) {

		return _employeeOffBoardingLocalService.addEmployeeOffBoarding(
			employeeOffBoarding);
	}

	/**
	 * Creates a new employee off boarding with the primary key. Does not add the employee off boarding to the database.
	 *
	 * @param employeeOffBoardingId the primary key for the new employee off boarding
	 * @return the new employee off boarding
	 */
	@Override
	public com.ax.hrms.model.EmployeeOffBoarding createEmployeeOffBoarding(
		long employeeOffBoardingId) {

		return _employeeOffBoardingLocalService.createEmployeeOffBoarding(
			employeeOffBoardingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeOffBoardingLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee off boarding from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeOffBoardingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeOffBoarding the employee off boarding
	 * @return the employee off boarding that was removed
	 */
	@Override
	public com.ax.hrms.model.EmployeeOffBoarding deleteEmployeeOffBoarding(
		com.ax.hrms.model.EmployeeOffBoarding employeeOffBoarding) {

		return _employeeOffBoardingLocalService.deleteEmployeeOffBoarding(
			employeeOffBoarding);
	}

	/**
	 * Deletes the employee off boarding with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeOffBoardingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeOffBoardingId the primary key of the employee off boarding
	 * @return the employee off boarding that was removed
	 * @throws PortalException if a employee off boarding with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeOffBoarding deleteEmployeeOffBoarding(
			long employeeOffBoardingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeOffBoardingLocalService.deleteEmployeeOffBoarding(
			employeeOffBoardingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeOffBoardingLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _employeeOffBoardingLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _employeeOffBoardingLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeOffBoardingLocalService.dynamicQuery();
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

		return _employeeOffBoardingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeOffBoardingModelImpl</code>.
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

		return _employeeOffBoardingLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeOffBoardingModelImpl</code>.
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

		return _employeeOffBoardingLocalService.dynamicQuery(
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

		return _employeeOffBoardingLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeOffBoardingLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.EmployeeOffBoarding fetchEmployeeOffBoarding(
		long employeeOffBoardingId) {

		return _employeeOffBoardingLocalService.fetchEmployeeOffBoarding(
			employeeOffBoardingId);
	}

	/**
	 * Returns the employee off boarding matching the UUID and group.
	 *
	 * @param uuid the employee off boarding's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee off boarding, or <code>null</code> if a matching employee off boarding could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeOffBoarding
		fetchEmployeeOffBoardingByUuidAndGroupId(String uuid, long groupId) {

		return _employeeOffBoardingLocalService.
			fetchEmployeeOffBoardingByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.ax.hrms.model.EmployeeOffBoarding findByEmployeeId(
			long employeeId)
		throws com.ax.hrms.exception.NoSuchEmployeeOffBoardingException {

		return _employeeOffBoardingLocalService.findByEmployeeId(employeeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeOffBoardingLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the employee off boarding with the primary key.
	 *
	 * @param employeeOffBoardingId the primary key of the employee off boarding
	 * @return the employee off boarding
	 * @throws PortalException if a employee off boarding with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeOffBoarding getEmployeeOffBoarding(
			long employeeOffBoardingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeOffBoardingLocalService.getEmployeeOffBoarding(
			employeeOffBoardingId);
	}

	/**
	 * Returns the employee off boarding matching the UUID and group.
	 *
	 * @param uuid the employee off boarding's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee off boarding
	 * @throws PortalException if a matching employee off boarding could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeOffBoarding
			getEmployeeOffBoardingByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeOffBoardingLocalService.
			getEmployeeOffBoardingByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the employee off boardings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeOffBoardingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @return the range of employee off boardings
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeOffBoarding>
		getEmployeeOffBoardings(int start, int end) {

		return _employeeOffBoardingLocalService.getEmployeeOffBoardings(
			start, end);
	}

	/**
	 * Returns all the employee off boardings matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee off boardings
	 * @param companyId the primary key of the company
	 * @return the matching employee off boardings, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeOffBoarding>
		getEmployeeOffBoardingsByUuidAndCompanyId(String uuid, long companyId) {

		return _employeeOffBoardingLocalService.
			getEmployeeOffBoardingsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of employee off boardings matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee off boardings
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee off boardings
	 * @param end the upper bound of the range of employee off boardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee off boardings, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeOffBoarding>
		getEmployeeOffBoardingsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.EmployeeOffBoarding> orderByComparator) {

		return _employeeOffBoardingLocalService.
			getEmployeeOffBoardingsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee off boardings.
	 *
	 * @return the number of employee off boardings
	 */
	@Override
	public int getEmployeeOffBoardingsCount() {
		return _employeeOffBoardingLocalService.getEmployeeOffBoardingsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _employeeOffBoardingLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeOffBoardingLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeOffBoardingLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeOffBoardingLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the employee off boarding in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeOffBoardingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeOffBoarding the employee off boarding
	 * @return the employee off boarding that was updated
	 */
	@Override
	public com.ax.hrms.model.EmployeeOffBoarding updateEmployeeOffBoarding(
		com.ax.hrms.model.EmployeeOffBoarding employeeOffBoarding) {

		return _employeeOffBoardingLocalService.updateEmployeeOffBoarding(
			employeeOffBoarding);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _employeeOffBoardingLocalService.getBasePersistence();
	}

	@Override
	public EmployeeOffBoardingLocalService getWrappedService() {
		return _employeeOffBoardingLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeOffBoardingLocalService employeeOffBoardingLocalService) {

		_employeeOffBoardingLocalService = employeeOffBoardingLocalService;
	}

	private EmployeeOffBoardingLocalService _employeeOffBoardingLocalService;

}