/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.base;

import com.ax.hrms.model.EmployeeSalary;
import com.ax.hrms.service.EmployeeSalaryLocalService;
import com.ax.hrms.service.persistence.AddressPersistence;
import com.ax.hrms.service.persistence.AppraisalEvaluationFormStatusPersistence;
import com.ax.hrms.service.persistence.AppraisalFormTemplatesPersistence;
import com.ax.hrms.service.persistence.AppraisalHistoryPersistence;
import com.ax.hrms.service.persistence.AppraisalMeetingInviteesPersistence;
import com.ax.hrms.service.persistence.AppraisalMeetingPersistence;
import com.ax.hrms.service.persistence.AppraisalProcessPersistence;
import com.ax.hrms.service.persistence.AppraisalReminderPersistence;
import com.ax.hrms.service.persistence.AttachmentPersistence;
import com.ax.hrms.service.persistence.CompensatoryDataPersistence;
import com.ax.hrms.service.persistence.EmployeeAddressPersistence;
import com.ax.hrms.service.persistence.EmployeeBankAccountPersistence;
import com.ax.hrms.service.persistence.EmployeeDepartmentPersistence;
import com.ax.hrms.service.persistence.EmployeeDesignationPersistence;
import com.ax.hrms.service.persistence.EmployeeDetailsFinder;
import com.ax.hrms.service.persistence.EmployeeDetailsPersistence;
import com.ax.hrms.service.persistence.EmployeeDocumentPersistence;
import com.ax.hrms.service.persistence.EmployeeEducationPersistence;
import com.ax.hrms.service.persistence.EmployeeExperiencePersistence;
import com.ax.hrms.service.persistence.EmployeeOffBoardingPersistence;
import com.ax.hrms.service.persistence.EmployeeProbationDetailsPersistence;
import com.ax.hrms.service.persistence.EmployeeSalaryPersistence;
import com.ax.hrms.service.persistence.EmployeeUanEsicPersistence;
import com.ax.hrms.service.persistence.EmployeeWishPersistence;
import com.ax.hrms.service.persistence.ExtendedProbationDetailsPersistence;
import com.ax.hrms.service.persistence.HolidayPersistence;
import com.ax.hrms.service.persistence.LeaveBalanceHistoryPersistence;
import com.ax.hrms.service.persistence.LeaveBalancePersistence;
import com.ax.hrms.service.persistence.LeaveDayTypePersistence;
import com.ax.hrms.service.persistence.LeaveInformToTeamDetailPersistence;
import com.ax.hrms.service.persistence.LeaveRequestPersistence;
import com.ax.hrms.service.persistence.LeaveTypeViewPermitPersistence;
import com.ax.hrms.service.persistence.NomineePersistence;
import com.ax.hrms.service.persistence.PipProgramPersistence;
import com.ax.hrms.service.persistence.PolicyPersistence;
import com.ax.hrms.service.persistence.ProjectEmployeeDetailsPersistence;
import com.ax.hrms.service.persistence.ProjectHistoryPersistence;
import com.ax.hrms.service.persistence.ProjectPersistence;
import com.ax.hrms.service.persistence.RolePoliciesPersistence;
import com.ax.hrms.service.persistence.TaskPersistence;
import com.ax.hrms.service.persistence.TaskReviewPersistence;
import com.ax.hrms.service.persistence.TimeTrackerPersistence;
import com.ax.hrms.service.persistence.UpcomingProbationEmployeePersistence;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the employee salary local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.ax.hrms.service.impl.EmployeeSalaryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ax.hrms.service.impl.EmployeeSalaryLocalServiceImpl
 * @generated
 */
public abstract class EmployeeSalaryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, EmployeeSalaryLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>EmployeeSalaryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ax.hrms.service.EmployeeSalaryLocalServiceUtil</code>.
	 */

	/**
	 * Adds the employee salary to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeSalaryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeSalary the employee salary
	 * @return the employee salary that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EmployeeSalary addEmployeeSalary(EmployeeSalary employeeSalary) {
		employeeSalary.setNew(true);

		return employeeSalaryPersistence.update(employeeSalary);
	}

	/**
	 * Creates a new employee salary with the primary key. Does not add the employee salary to the database.
	 *
	 * @param salaryId the primary key for the new employee salary
	 * @return the new employee salary
	 */
	@Override
	@Transactional(enabled = false)
	public EmployeeSalary createEmployeeSalary(long salaryId) {
		return employeeSalaryPersistence.create(salaryId);
	}

	/**
	 * Deletes the employee salary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeSalaryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salaryId the primary key of the employee salary
	 * @return the employee salary that was removed
	 * @throws PortalException if a employee salary with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EmployeeSalary deleteEmployeeSalary(long salaryId)
		throws PortalException {

		return employeeSalaryPersistence.remove(salaryId);
	}

	/**
	 * Deletes the employee salary from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeSalaryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeSalary the employee salary
	 * @return the employee salary that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EmployeeSalary deleteEmployeeSalary(EmployeeSalary employeeSalary) {
		return employeeSalaryPersistence.remove(employeeSalary);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return employeeSalaryPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			EmployeeSalary.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return employeeSalaryPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return employeeSalaryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return employeeSalaryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return employeeSalaryPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return employeeSalaryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public EmployeeSalary fetchEmployeeSalary(long salaryId) {
		return employeeSalaryPersistence.fetchByPrimaryKey(salaryId);
	}

	/**
	 * Returns the employee salary matching the UUID and group.
	 *
	 * @param uuid the employee salary's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee salary, or <code>null</code> if a matching employee salary could not be found
	 */
	@Override
	public EmployeeSalary fetchEmployeeSalaryByUuidAndGroupId(
		String uuid, long groupId) {

		return employeeSalaryPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee salary with the primary key.
	 *
	 * @param salaryId the primary key of the employee salary
	 * @return the employee salary
	 * @throws PortalException if a employee salary with the primary key could not be found
	 */
	@Override
	public EmployeeSalary getEmployeeSalary(long salaryId)
		throws PortalException {

		return employeeSalaryPersistence.findByPrimaryKey(salaryId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(employeeSalaryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(EmployeeSalary.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("salaryId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			employeeSalaryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(EmployeeSalary.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("salaryId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(employeeSalaryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(EmployeeSalary.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("salaryId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<EmployeeSalary>() {

				@Override
				public void performAction(EmployeeSalary employeeSalary)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, employeeSalary);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(EmployeeSalary.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return employeeSalaryPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement EmployeeSalaryLocalServiceImpl#deleteEmployeeSalary(EmployeeSalary) to avoid orphaned data");
		}

		return employeeSalaryLocalService.deleteEmployeeSalary(
			(EmployeeSalary)persistedModel);
	}

	@Override
	public BasePersistence<EmployeeSalary> getBasePersistence() {
		return employeeSalaryPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return employeeSalaryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the employee salaries matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee salaries
	 * @param companyId the primary key of the company
	 * @return the matching employee salaries, or an empty list if no matches were found
	 */
	@Override
	public List<EmployeeSalary> getEmployeeSalariesByUuidAndCompanyId(
		String uuid, long companyId) {

		return employeeSalaryPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of employee salaries matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee salaries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee salaries, or an empty list if no matches were found
	 */
	@Override
	public List<EmployeeSalary> getEmployeeSalariesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeSalary> orderByComparator) {

		return employeeSalaryPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the employee salary matching the UUID and group.
	 *
	 * @param uuid the employee salary's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee salary
	 * @throws PortalException if a matching employee salary could not be found
	 */
	@Override
	public EmployeeSalary getEmployeeSalaryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return employeeSalaryPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the employee salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeSalaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee salaries
	 * @param end the upper bound of the range of employee salaries (not inclusive)
	 * @return the range of employee salaries
	 */
	@Override
	public List<EmployeeSalary> getEmployeeSalaries(int start, int end) {
		return employeeSalaryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of employee salaries.
	 *
	 * @return the number of employee salaries
	 */
	@Override
	public int getEmployeeSalariesCount() {
		return employeeSalaryPersistence.countAll();
	}

	/**
	 * Updates the employee salary in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeSalaryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeSalary the employee salary
	 * @return the employee salary that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EmployeeSalary updateEmployeeSalary(EmployeeSalary employeeSalary) {
		return employeeSalaryPersistence.update(employeeSalary);
	}

	@Deactivate
	protected void deactivate() {
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			EmployeeSalaryLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		employeeSalaryLocalService = (EmployeeSalaryLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return EmployeeSalaryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return EmployeeSalary.class;
	}

	protected String getModelClassName() {
		return EmployeeSalary.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = employeeSalaryPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Reference
	protected AddressPersistence addressPersistence;

	@Reference
	protected AppraisalEvaluationFormStatusPersistence
		appraisalEvaluationFormStatusPersistence;

	@Reference
	protected AppraisalFormTemplatesPersistence
		appraisalFormTemplatesPersistence;

	@Reference
	protected AppraisalHistoryPersistence appraisalHistoryPersistence;

	@Reference
	protected AppraisalMeetingPersistence appraisalMeetingPersistence;

	@Reference
	protected AppraisalMeetingInviteesPersistence
		appraisalMeetingInviteesPersistence;

	@Reference
	protected AppraisalProcessPersistence appraisalProcessPersistence;

	@Reference
	protected AppraisalReminderPersistence appraisalReminderPersistence;

	@Reference
	protected AttachmentPersistence attachmentPersistence;

	@Reference
	protected CompensatoryDataPersistence compensatoryDataPersistence;

	@Reference
	protected EmployeeAddressPersistence employeeAddressPersistence;

	@Reference
	protected EmployeeBankAccountPersistence employeeBankAccountPersistence;

	@Reference
	protected EmployeeDepartmentPersistence employeeDepartmentPersistence;

	@Reference
	protected EmployeeDesignationPersistence employeeDesignationPersistence;

	@Reference
	protected EmployeeDetailsPersistence employeeDetailsPersistence;

	@Reference
	protected EmployeeDetailsFinder employeeDetailsFinder;

	@Reference
	protected EmployeeDocumentPersistence employeeDocumentPersistence;

	@Reference
	protected EmployeeEducationPersistence employeeEducationPersistence;

	@Reference
	protected EmployeeExperiencePersistence employeeExperiencePersistence;

	@Reference
	protected EmployeeOffBoardingPersistence employeeOffBoardingPersistence;

	@Reference
	protected EmployeeProbationDetailsPersistence
		employeeProbationDetailsPersistence;

	protected EmployeeSalaryLocalService employeeSalaryLocalService;

	@Reference
	protected EmployeeSalaryPersistence employeeSalaryPersistence;

	@Reference
	protected EmployeeUanEsicPersistence employeeUanEsicPersistence;

	@Reference
	protected EmployeeWishPersistence employeeWishPersistence;

	@Reference
	protected ExtendedProbationDetailsPersistence
		extendedProbationDetailsPersistence;

	@Reference
	protected HolidayPersistence holidayPersistence;

	@Reference
	protected LeaveBalancePersistence leaveBalancePersistence;

	@Reference
	protected LeaveBalanceHistoryPersistence leaveBalanceHistoryPersistence;

	@Reference
	protected LeaveDayTypePersistence leaveDayTypePersistence;

	@Reference
	protected LeaveInformToTeamDetailPersistence
		leaveInformToTeamDetailPersistence;

	@Reference
	protected LeaveRequestPersistence leaveRequestPersistence;

	@Reference
	protected LeaveTypeViewPermitPersistence leaveTypeViewPermitPersistence;

	@Reference
	protected NomineePersistence nomineePersistence;

	@Reference
	protected PipProgramPersistence pipProgramPersistence;

	@Reference
	protected PolicyPersistence policyPersistence;

	@Reference
	protected ProjectPersistence projectPersistence;

	@Reference
	protected ProjectEmployeeDetailsPersistence
		projectEmployeeDetailsPersistence;

	@Reference
	protected ProjectHistoryPersistence projectHistoryPersistence;

	@Reference
	protected RolePoliciesPersistence rolePoliciesPersistence;

	@Reference
	protected TaskPersistence taskPersistence;

	@Reference
	protected TaskReviewPersistence taskReviewPersistence;

	@Reference
	protected TimeTrackerPersistence timeTrackerPersistence;

	@Reference
	protected UpcomingProbationEmployeePersistence
		upcomingProbationEmployeePersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeSalaryLocalServiceBaseImpl.class);

}