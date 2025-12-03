/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link UpcomingProbationEmployeeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UpcomingProbationEmployeeLocalService
 * @generated
 */
public class UpcomingProbationEmployeeLocalServiceWrapper
	implements ServiceWrapper<UpcomingProbationEmployeeLocalService>,
			   UpcomingProbationEmployeeLocalService {

	public UpcomingProbationEmployeeLocalServiceWrapper() {
		this(null);
	}

	public UpcomingProbationEmployeeLocalServiceWrapper(
		UpcomingProbationEmployeeLocalService
			upcomingProbationEmployeeLocalService) {

		_upcomingProbationEmployeeLocalService =
			upcomingProbationEmployeeLocalService;
	}

	/**
	 * Adds the upcoming probation employee to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UpcomingProbationEmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param upcomingProbationEmployee the upcoming probation employee
	 * @return the upcoming probation employee that was added
	 */
	@Override
	public com.ax.hrms.model.UpcomingProbationEmployee
		addUpcomingProbationEmployee(
			com.ax.hrms.model.UpcomingProbationEmployee
				upcomingProbationEmployee) {

		return _upcomingProbationEmployeeLocalService.
			addUpcomingProbationEmployee(upcomingProbationEmployee);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _upcomingProbationEmployeeLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new upcoming probation employee with the primary key. Does not add the upcoming probation employee to the database.
	 *
	 * @param upcomingProbationEmployeeId the primary key for the new upcoming probation employee
	 * @return the new upcoming probation employee
	 */
	@Override
	public com.ax.hrms.model.UpcomingProbationEmployee
		createUpcomingProbationEmployee(long upcomingProbationEmployeeId) {

		return _upcomingProbationEmployeeLocalService.
			createUpcomingProbationEmployee(upcomingProbationEmployeeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _upcomingProbationEmployeeLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the upcoming probation employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UpcomingProbationEmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param upcomingProbationEmployeeId the primary key of the upcoming probation employee
	 * @return the upcoming probation employee that was removed
	 * @throws PortalException if a upcoming probation employee with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.UpcomingProbationEmployee
			deleteUpcomingProbationEmployee(long upcomingProbationEmployeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _upcomingProbationEmployeeLocalService.
			deleteUpcomingProbationEmployee(upcomingProbationEmployeeId);
	}

	/**
	 * Deletes the upcoming probation employee from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UpcomingProbationEmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param upcomingProbationEmployee the upcoming probation employee
	 * @return the upcoming probation employee that was removed
	 */
	@Override
	public com.ax.hrms.model.UpcomingProbationEmployee
		deleteUpcomingProbationEmployee(
			com.ax.hrms.model.UpcomingProbationEmployee
				upcomingProbationEmployee) {

		return _upcomingProbationEmployeeLocalService.
			deleteUpcomingProbationEmployee(upcomingProbationEmployee);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _upcomingProbationEmployeeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _upcomingProbationEmployeeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _upcomingProbationEmployeeLocalService.dynamicQuery();
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

		return _upcomingProbationEmployeeLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.UpcomingProbationEmployeeModelImpl</code>.
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

		return _upcomingProbationEmployeeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.UpcomingProbationEmployeeModelImpl</code>.
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

		return _upcomingProbationEmployeeLocalService.dynamicQuery(
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

		return _upcomingProbationEmployeeLocalService.dynamicQueryCount(
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

		return _upcomingProbationEmployeeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.UpcomingProbationEmployee
		fetchUpcomingProbationEmployee(long upcomingProbationEmployeeId) {

		return _upcomingProbationEmployeeLocalService.
			fetchUpcomingProbationEmployee(upcomingProbationEmployeeId);
	}

	/**
	 * Returns the upcoming probation employee matching the UUID and group.
	 *
	 * @param uuid the upcoming probation employee's UUID
	 * @param groupId the primary key of the group
	 * @return the matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	@Override
	public com.ax.hrms.model.UpcomingProbationEmployee
		fetchUpcomingProbationEmployeeByUuidAndGroupId(
			String uuid, long groupId) {

		return _upcomingProbationEmployeeLocalService.
			fetchUpcomingProbationEmployeeByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.UpcomingProbationEmployee>
		findByMonthAndYear(int month, int year) {

		return _upcomingProbationEmployeeLocalService.findByMonthAndYear(
			month, year);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _upcomingProbationEmployeeLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _upcomingProbationEmployeeLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _upcomingProbationEmployeeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _upcomingProbationEmployeeLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _upcomingProbationEmployeeLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the upcoming probation employee with the primary key.
	 *
	 * @param upcomingProbationEmployeeId the primary key of the upcoming probation employee
	 * @return the upcoming probation employee
	 * @throws PortalException if a upcoming probation employee with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.UpcomingProbationEmployee
			getUpcomingProbationEmployee(long upcomingProbationEmployeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _upcomingProbationEmployeeLocalService.
			getUpcomingProbationEmployee(upcomingProbationEmployeeId);
	}

	/**
	 * Returns the upcoming probation employee matching the UUID and group.
	 *
	 * @param uuid the upcoming probation employee's UUID
	 * @param groupId the primary key of the group
	 * @return the matching upcoming probation employee
	 * @throws PortalException if a matching upcoming probation employee could not be found
	 */
	@Override
	public com.ax.hrms.model.UpcomingProbationEmployee
			getUpcomingProbationEmployeeByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _upcomingProbationEmployeeLocalService.
			getUpcomingProbationEmployeeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the upcoming probation employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.UpcomingProbationEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @return the range of upcoming probation employees
	 */
	@Override
	public java.util.List<com.ax.hrms.model.UpcomingProbationEmployee>
		getUpcomingProbationEmployees(int start, int end) {

		return _upcomingProbationEmployeeLocalService.
			getUpcomingProbationEmployees(start, end);
	}

	/**
	 * Returns all the upcoming probation employees matching the UUID and company.
	 *
	 * @param uuid the UUID of the upcoming probation employees
	 * @param companyId the primary key of the company
	 * @return the matching upcoming probation employees, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.UpcomingProbationEmployee>
		getUpcomingProbationEmployeesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _upcomingProbationEmployeeLocalService.
			getUpcomingProbationEmployeesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of upcoming probation employees matching the UUID and company.
	 *
	 * @param uuid the UUID of the upcoming probation employees
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of upcoming probation employees
	 * @param end the upper bound of the range of upcoming probation employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching upcoming probation employees, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.UpcomingProbationEmployee>
		getUpcomingProbationEmployeesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.UpcomingProbationEmployee>
					orderByComparator) {

		return _upcomingProbationEmployeeLocalService.
			getUpcomingProbationEmployeesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of upcoming probation employees.
	 *
	 * @return the number of upcoming probation employees
	 */
	@Override
	public int getUpcomingProbationEmployeesCount() {
		return _upcomingProbationEmployeeLocalService.
			getUpcomingProbationEmployeesCount();
	}

	/**
	 * Updates the upcoming probation employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UpcomingProbationEmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param upcomingProbationEmployee the upcoming probation employee
	 * @return the upcoming probation employee that was updated
	 */
	@Override
	public com.ax.hrms.model.UpcomingProbationEmployee
		updateUpcomingProbationEmployee(
			com.ax.hrms.model.UpcomingProbationEmployee
				upcomingProbationEmployee) {

		return _upcomingProbationEmployeeLocalService.
			updateUpcomingProbationEmployee(upcomingProbationEmployee);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _upcomingProbationEmployeeLocalService.getBasePersistence();
	}

	@Override
	public UpcomingProbationEmployeeLocalService getWrappedService() {
		return _upcomingProbationEmployeeLocalService;
	}

	@Override
	public void setWrappedService(
		UpcomingProbationEmployeeLocalService
			upcomingProbationEmployeeLocalService) {

		_upcomingProbationEmployeeLocalService =
			upcomingProbationEmployeeLocalService;
	}

	private UpcomingProbationEmployeeLocalService
		_upcomingProbationEmployeeLocalService;

}