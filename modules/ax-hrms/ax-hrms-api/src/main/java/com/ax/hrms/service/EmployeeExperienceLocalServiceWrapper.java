/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EmployeeExperienceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeExperienceLocalService
 * @generated
 */
public class EmployeeExperienceLocalServiceWrapper
	implements EmployeeExperienceLocalService,
			   ServiceWrapper<EmployeeExperienceLocalService> {

	public EmployeeExperienceLocalServiceWrapper() {
		this(null);
	}

	public EmployeeExperienceLocalServiceWrapper(
		EmployeeExperienceLocalService employeeExperienceLocalService) {

		_employeeExperienceLocalService = employeeExperienceLocalService;
	}

	/**
	 * Adds the employee experience to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeExperienceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeExperience the employee experience
	 * @return the employee experience that was added
	 */
	@Override
	public com.ax.hrms.model.EmployeeExperience addEmployeeExperience(
		com.ax.hrms.model.EmployeeExperience employeeExperience) {

		return _employeeExperienceLocalService.addEmployeeExperience(
			employeeExperience);
	}

	/**
	 * Creates a new employee experience with the primary key. Does not add the employee experience to the database.
	 *
	 * @param experienceId the primary key for the new employee experience
	 * @return the new employee experience
	 */
	@Override
	public com.ax.hrms.model.EmployeeExperience createEmployeeExperience(
		long experienceId) {

		return _employeeExperienceLocalService.createEmployeeExperience(
			experienceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeExperienceLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee experience from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeExperienceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeExperience the employee experience
	 * @return the employee experience that was removed
	 */
	@Override
	public com.ax.hrms.model.EmployeeExperience deleteEmployeeExperience(
		com.ax.hrms.model.EmployeeExperience employeeExperience) {

		return _employeeExperienceLocalService.deleteEmployeeExperience(
			employeeExperience);
	}

	/**
	 * Deletes the employee experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeExperienceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param experienceId the primary key of the employee experience
	 * @return the employee experience that was removed
	 * @throws PortalException if a employee experience with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeExperience deleteEmployeeExperience(
			long experienceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeExperienceLocalService.deleteEmployeeExperience(
			experienceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeExperienceLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _employeeExperienceLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _employeeExperienceLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeExperienceLocalService.dynamicQuery();
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

		return _employeeExperienceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeExperienceModelImpl</code>.
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

		return _employeeExperienceLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeExperienceModelImpl</code>.
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

		return _employeeExperienceLocalService.dynamicQuery(
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

		return _employeeExperienceLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeExperienceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.EmployeeExperience fetchEmployeeExperience(
		long experienceId) {

		return _employeeExperienceLocalService.fetchEmployeeExperience(
			experienceId);
	}

	/**
	 * Returns the employee experience matching the UUID and group.
	 *
	 * @param uuid the employee experience's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeExperience
		fetchEmployeeExperienceByUuidAndGroupId(String uuid, long groupId) {

		return _employeeExperienceLocalService.
			fetchEmployeeExperienceByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.EmployeeExperience>
		findByEmployeeId(long employeeId) {

		return _employeeExperienceLocalService.findByEmployeeId(employeeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeExperienceLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the employee experience with the primary key.
	 *
	 * @param experienceId the primary key of the employee experience
	 * @return the employee experience
	 * @throws PortalException if a employee experience with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeExperience getEmployeeExperience(
			long experienceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeExperienceLocalService.getEmployeeExperience(
			experienceId);
	}

	/**
	 * Returns the employee experience matching the UUID and group.
	 *
	 * @param uuid the employee experience's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee experience
	 * @throws PortalException if a matching employee experience could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeExperience
			getEmployeeExperienceByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeExperienceLocalService.
			getEmployeeExperienceByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the employee experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @return the range of employee experiences
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeExperience>
		getEmployeeExperiences(int start, int end) {

		return _employeeExperienceLocalService.getEmployeeExperiences(
			start, end);
	}

	/**
	 * Returns all the employee experiences matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee experiences
	 * @param companyId the primary key of the company
	 * @return the matching employee experiences, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeExperience>
		getEmployeeExperiencesByUuidAndCompanyId(String uuid, long companyId) {

		return _employeeExperienceLocalService.
			getEmployeeExperiencesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of employee experiences matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee experiences
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee experiences, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeExperience>
		getEmployeeExperiencesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.EmployeeExperience> orderByComparator) {

		return _employeeExperienceLocalService.
			getEmployeeExperiencesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee experiences.
	 *
	 * @return the number of employee experiences
	 */
	@Override
	public int getEmployeeExperiencesCount() {
		return _employeeExperienceLocalService.getEmployeeExperiencesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _employeeExperienceLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeExperienceLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeExperienceLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeExperienceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee experience in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeExperienceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeExperience the employee experience
	 * @return the employee experience that was updated
	 */
	@Override
	public com.ax.hrms.model.EmployeeExperience updateEmployeeExperience(
		com.ax.hrms.model.EmployeeExperience employeeExperience) {

		return _employeeExperienceLocalService.updateEmployeeExperience(
			employeeExperience);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _employeeExperienceLocalService.getBasePersistence();
	}

	@Override
	public EmployeeExperienceLocalService getWrappedService() {
		return _employeeExperienceLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeExperienceLocalService employeeExperienceLocalService) {

		_employeeExperienceLocalService = employeeExperienceLocalService;
	}

	private EmployeeExperienceLocalService _employeeExperienceLocalService;

}