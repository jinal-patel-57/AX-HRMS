/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.exception.NoSuchEmployeeDetailsException;
import com.ax.hrms.model.EmployeeDetails;

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

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for EmployeeDetails. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetailsLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface EmployeeDetailsLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ax.hrms.service.impl.EmployeeDetailsLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the employee details local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link EmployeeDetailsLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the employee details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDetails the employee details
	 * @return the employee details that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EmployeeDetails addEmployeeDetails(EmployeeDetails employeeDetails);

	/**
	 * Creates a new employee details with the primary key. Does not add the employee details to the database.
	 *
	 * @param employeeId the primary key for the new employee details
	 * @return the new employee details
	 */
	@Transactional(enabled = false)
	public EmployeeDetails createEmployeeDetails(long employeeId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the employee details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDetails the employee details
	 * @return the employee details that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public EmployeeDetails deleteEmployeeDetails(
		EmployeeDetails employeeDetails);

	/**
	 * Deletes the employee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeId the primary key of the employee details
	 * @return the employee details that was removed
	 * @throws PortalException if a employee details with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public EmployeeDetails deleteEmployeeDetails(long employeeId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeDetailsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeDetailsModelImpl</code>.
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
	public EmployeeDetails fetchEmployeeDetails(long employeeId);

	/**
	 * Returns the employee details matching the UUID and group.
	 *
	 * @param uuid the employee details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EmployeeDetails fetchEmployeeDetailsByUuidAndGroupId(
		String uuid, long groupId);

	public List<Object[]> FilterByDepartmentDesignationName(
		String departName, String desgiName);

	public EmployeeDetails findByEmployeeId(long employeeId)
		throws NoSuchEmployeeDetailsException;

	public List<EmployeeDetails> findByEmployeeName(
		String firstName, String lastName);

	public List<EmployeeDetails> findByIsTerminated(boolean isTerminated);

	public List<EmployeeDetails> findByLeavingDate(Date date);

	public EmployeeDetails findByLrUserId(long lrUserId)
		throws NoSuchEmployeeDetailsException;

	public List<Object[]> findEmployeeByName(String fName, String lName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Long> getAllContinuedEmployeeId();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Object[]> getAllDesigByEmpId(long empId);

	/**
	 * Returns the employee details with the primary key.
	 *
	 * @param employeeId the primary key of the employee details
	 * @return the employee details
	 * @throws PortalException if a employee details with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EmployeeDetails getEmployeeDetails(long employeeId)
		throws PortalException;

	/**
	 * Returns the employee details matching the UUID and group.
	 *
	 * @param uuid the employee details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee details
	 * @throws PortalException if a matching employee details could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EmployeeDetails getEmployeeDetailsByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of employee detailses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EmployeeDetails> getEmployeeDetailses(int start, int end);

	/**
	 * Returns all the employee detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee detailses
	 * @param companyId the primary key of the company
	 * @return the matching employee detailses, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EmployeeDetails> getEmployeeDetailsesByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of employee detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee detailses, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EmployeeDetails> getEmployeeDetailsesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator);

	/**
	 * Returns the number of employee detailses.
	 *
	 * @return the number of employee detailses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEmployeeDetailsesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Long> getEmployeeIdByDepartmentId(long departmentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Long> getEmployeeIdByDesignationId(long designationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Long> getEmployeeIdByDesignationIdAndDepartmentId(
		long designationId, long departmentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Long> getEmployeeIdByLruserid(long lruserid);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Long> getEmployeeIdByNameString(String nameStr);

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
	 * Updates the employee details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDetails the employee details
	 * @return the employee details that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EmployeeDetails updateEmployeeDetails(
		EmployeeDetails employeeDetails);

}