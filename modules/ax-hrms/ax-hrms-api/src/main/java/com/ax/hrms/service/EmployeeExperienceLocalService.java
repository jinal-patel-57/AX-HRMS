/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.EmployeeExperience;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for EmployeeExperience. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeExperienceLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface EmployeeExperienceLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ax.hrms.service.impl.EmployeeExperienceLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the employee experience local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link EmployeeExperienceLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public EmployeeExperience addEmployeeExperience(
		EmployeeExperience employeeExperience);

	/**
	 * Creates a new employee experience with the primary key. Does not add the employee experience to the database.
	 *
	 * @param experienceId the primary key for the new employee experience
	 * @return the new employee experience
	 */
	@Transactional(enabled = false)
	public EmployeeExperience createEmployeeExperience(long experienceId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public EmployeeExperience deleteEmployeeExperience(
		EmployeeExperience employeeExperience);

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
	@Indexable(type = IndexableType.DELETE)
	public EmployeeExperience deleteEmployeeExperience(long experienceId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EmployeeExperience fetchEmployeeExperience(long experienceId);

	/**
	 * Returns the employee experience matching the UUID and group.
	 *
	 * @param uuid the employee experience's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EmployeeExperience fetchEmployeeExperienceByUuidAndGroupId(
		String uuid, long groupId);

	public List<EmployeeExperience> findByEmployeeId(long employeeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the employee experience with the primary key.
	 *
	 * @param experienceId the primary key of the employee experience
	 * @return the employee experience
	 * @throws PortalException if a employee experience with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EmployeeExperience getEmployeeExperience(long experienceId)
		throws PortalException;

	/**
	 * Returns the employee experience matching the UUID and group.
	 *
	 * @param uuid the employee experience's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee experience
	 * @throws PortalException if a matching employee experience could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EmployeeExperience getEmployeeExperienceByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EmployeeExperience> getEmployeeExperiences(int start, int end);

	/**
	 * Returns all the employee experiences matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee experiences
	 * @param companyId the primary key of the company
	 * @return the matching employee experiences, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EmployeeExperience> getEmployeeExperiencesByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EmployeeExperience> getEmployeeExperiencesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator);

	/**
	 * Returns the number of employee experiences.
	 *
	 * @return the number of employee experiences
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEmployeeExperiencesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public EmployeeExperience updateEmployeeExperience(
		EmployeeExperience employeeExperience);

}