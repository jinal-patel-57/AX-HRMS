/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.EmployeeExperience;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for EmployeeExperience. This utility wraps
 * <code>com.ax.hrms.service.impl.EmployeeExperienceLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeExperienceLocalService
 * @generated
 */
public class EmployeeExperienceLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.EmployeeExperienceLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static EmployeeExperience addEmployeeExperience(
		EmployeeExperience employeeExperience) {

		return getService().addEmployeeExperience(employeeExperience);
	}

	/**
	 * Creates a new employee experience with the primary key. Does not add the employee experience to the database.
	 *
	 * @param experienceId the primary key for the new employee experience
	 * @return the new employee experience
	 */
	public static EmployeeExperience createEmployeeExperience(
		long experienceId) {

		return getService().createEmployeeExperience(experienceId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static EmployeeExperience deleteEmployeeExperience(
		EmployeeExperience employeeExperience) {

		return getService().deleteEmployeeExperience(employeeExperience);
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
	public static EmployeeExperience deleteEmployeeExperience(long experienceId)
		throws PortalException {

		return getService().deleteEmployeeExperience(experienceId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static EmployeeExperience fetchEmployeeExperience(
		long experienceId) {

		return getService().fetchEmployeeExperience(experienceId);
	}

	/**
	 * Returns the employee experience matching the UUID and group.
	 *
	 * @param uuid the employee experience's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public static EmployeeExperience fetchEmployeeExperienceByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchEmployeeExperienceByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<EmployeeExperience> findByEmployeeId(long employeeId) {
		return getService().findByEmployeeId(employeeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the employee experience with the primary key.
	 *
	 * @param experienceId the primary key of the employee experience
	 * @return the employee experience
	 * @throws PortalException if a employee experience with the primary key could not be found
	 */
	public static EmployeeExperience getEmployeeExperience(long experienceId)
		throws PortalException {

		return getService().getEmployeeExperience(experienceId);
	}

	/**
	 * Returns the employee experience matching the UUID and group.
	 *
	 * @param uuid the employee experience's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee experience
	 * @throws PortalException if a matching employee experience could not be found
	 */
	public static EmployeeExperience getEmployeeExperienceByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getEmployeeExperienceByUuidAndGroupId(
			uuid, groupId);
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
	public static List<EmployeeExperience> getEmployeeExperiences(
		int start, int end) {

		return getService().getEmployeeExperiences(start, end);
	}

	/**
	 * Returns all the employee experiences matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee experiences
	 * @param companyId the primary key of the company
	 * @return the matching employee experiences, or an empty list if no matches were found
	 */
	public static List<EmployeeExperience>
		getEmployeeExperiencesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getEmployeeExperiencesByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<EmployeeExperience>
		getEmployeeExperiencesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<EmployeeExperience> orderByComparator) {

		return getService().getEmployeeExperiencesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee experiences.
	 *
	 * @return the number of employee experiences
	 */
	public static int getEmployeeExperiencesCount() {
		return getService().getEmployeeExperiencesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static EmployeeExperience updateEmployeeExperience(
		EmployeeExperience employeeExperience) {

		return getService().updateEmployeeExperience(employeeExperience);
	}

	public static EmployeeExperienceLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<EmployeeExperienceLocalService>
		_serviceSnapshot = new Snapshot<>(
			EmployeeExperienceLocalServiceUtil.class,
			EmployeeExperienceLocalService.class);

}