/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EmployeeUanEsicLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeUanEsicLocalService
 * @generated
 */
public class EmployeeUanEsicLocalServiceWrapper
	implements EmployeeUanEsicLocalService,
			   ServiceWrapper<EmployeeUanEsicLocalService> {

	public EmployeeUanEsicLocalServiceWrapper() {
		this(null);
	}

	public EmployeeUanEsicLocalServiceWrapper(
		EmployeeUanEsicLocalService employeeUanEsicLocalService) {

		_employeeUanEsicLocalService = employeeUanEsicLocalService;
	}

	/**
	 * Adds the employee uan esic to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeUanEsicLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeUanEsic the employee uan esic
	 * @return the employee uan esic that was added
	 */
	@Override
	public com.ax.hrms.model.EmployeeUanEsic addEmployeeUanEsic(
		com.ax.hrms.model.EmployeeUanEsic employeeUanEsic) {

		return _employeeUanEsicLocalService.addEmployeeUanEsic(employeeUanEsic);
	}

	/**
	 * Creates a new employee uan esic with the primary key. Does not add the employee uan esic to the database.
	 *
	 * @param uanEsicId the primary key for the new employee uan esic
	 * @return the new employee uan esic
	 */
	@Override
	public com.ax.hrms.model.EmployeeUanEsic createEmployeeUanEsic(
		long uanEsicId) {

		return _employeeUanEsicLocalService.createEmployeeUanEsic(uanEsicId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeUanEsicLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the employee uan esic from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeUanEsicLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeUanEsic the employee uan esic
	 * @return the employee uan esic that was removed
	 */
	@Override
	public com.ax.hrms.model.EmployeeUanEsic deleteEmployeeUanEsic(
		com.ax.hrms.model.EmployeeUanEsic employeeUanEsic) {

		return _employeeUanEsicLocalService.deleteEmployeeUanEsic(
			employeeUanEsic);
	}

	/**
	 * Deletes the employee uan esic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeUanEsicLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param uanEsicId the primary key of the employee uan esic
	 * @return the employee uan esic that was removed
	 * @throws PortalException if a employee uan esic with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeUanEsic deleteEmployeeUanEsic(
			long uanEsicId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeUanEsicLocalService.deleteEmployeeUanEsic(uanEsicId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeUanEsicLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _employeeUanEsicLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _employeeUanEsicLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeUanEsicLocalService.dynamicQuery();
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

		return _employeeUanEsicLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeUanEsicModelImpl</code>.
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

		return _employeeUanEsicLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeUanEsicModelImpl</code>.
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

		return _employeeUanEsicLocalService.dynamicQuery(
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

		return _employeeUanEsicLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeUanEsicLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.EmployeeUanEsic fetchEmployeeUanEsic(
		long uanEsicId) {

		return _employeeUanEsicLocalService.fetchEmployeeUanEsic(uanEsicId);
	}

	/**
	 * Returns the employee uan esic matching the UUID and group.
	 *
	 * @param uuid the employee uan esic's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee uan esic, or <code>null</code> if a matching employee uan esic could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeUanEsic
		fetchEmployeeUanEsicByUuidAndGroupId(String uuid, long groupId) {

		return _employeeUanEsicLocalService.
			fetchEmployeeUanEsicByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeUanEsicLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the employee uan esic with the primary key.
	 *
	 * @param uanEsicId the primary key of the employee uan esic
	 * @return the employee uan esic
	 * @throws PortalException if a employee uan esic with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeUanEsic getEmployeeUanEsic(long uanEsicId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeUanEsicLocalService.getEmployeeUanEsic(uanEsicId);
	}

	/**
	 * Returns the employee uan esic matching the UUID and group.
	 *
	 * @param uuid the employee uan esic's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee uan esic
	 * @throws PortalException if a matching employee uan esic could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeUanEsic getEmployeeUanEsicByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeUanEsicLocalService.getEmployeeUanEsicByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the employee uan esics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeUanEsicModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @return the range of employee uan esics
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeUanEsic>
		getEmployeeUanEsics(int start, int end) {

		return _employeeUanEsicLocalService.getEmployeeUanEsics(start, end);
	}

	/**
	 * Returns all the employee uan esics matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee uan esics
	 * @param companyId the primary key of the company
	 * @return the matching employee uan esics, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeUanEsic>
		getEmployeeUanEsicsByUuidAndCompanyId(String uuid, long companyId) {

		return _employeeUanEsicLocalService.
			getEmployeeUanEsicsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of employee uan esics matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee uan esics
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee uan esics
	 * @param end the upper bound of the range of employee uan esics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee uan esics, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeUanEsic>
		getEmployeeUanEsicsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.EmployeeUanEsic> orderByComparator) {

		return _employeeUanEsicLocalService.
			getEmployeeUanEsicsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee uan esics.
	 *
	 * @return the number of employee uan esics
	 */
	@Override
	public int getEmployeeUanEsicsCount() {
		return _employeeUanEsicLocalService.getEmployeeUanEsicsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _employeeUanEsicLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeUanEsicLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeUanEsicLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeUanEsicLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee uan esic in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeUanEsicLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeUanEsic the employee uan esic
	 * @return the employee uan esic that was updated
	 */
	@Override
	public com.ax.hrms.model.EmployeeUanEsic updateEmployeeUanEsic(
		com.ax.hrms.model.EmployeeUanEsic employeeUanEsic) {

		return _employeeUanEsicLocalService.updateEmployeeUanEsic(
			employeeUanEsic);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _employeeUanEsicLocalService.getBasePersistence();
	}

	@Override
	public EmployeeUanEsicLocalService getWrappedService() {
		return _employeeUanEsicLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeUanEsicLocalService employeeUanEsicLocalService) {

		_employeeUanEsicLocalService = employeeUanEsicLocalService;
	}

	private EmployeeUanEsicLocalService _employeeUanEsicLocalService;

}