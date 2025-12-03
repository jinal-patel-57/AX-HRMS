/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.base;

import com.ax.hrms.model.ProjectEmployeeDetails;
import com.ax.hrms.service.ProjectEmployeeDetailsLocalService;
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
 * Provides the base implementation for the project employee details local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.ax.hrms.service.impl.ProjectEmployeeDetailsLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ax.hrms.service.impl.ProjectEmployeeDetailsLocalServiceImpl
 * @generated
 */
public abstract class ProjectEmployeeDetailsLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   ProjectEmployeeDetailsLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ProjectEmployeeDetailsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ax.hrms.service.ProjectEmployeeDetailsLocalServiceUtil</code>.
	 */

	/**
	 * Adds the project employee details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectEmployeeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectEmployeeDetails the project employee details
	 * @return the project employee details that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ProjectEmployeeDetails addProjectEmployeeDetails(
		ProjectEmployeeDetails projectEmployeeDetails) {

		projectEmployeeDetails.setNew(true);

		return projectEmployeeDetailsPersistence.update(projectEmployeeDetails);
	}

	/**
	 * Creates a new project employee details with the primary key. Does not add the project employee details to the database.
	 *
	 * @param projectEmployeeDetailsId the primary key for the new project employee details
	 * @return the new project employee details
	 */
	@Override
	@Transactional(enabled = false)
	public ProjectEmployeeDetails createProjectEmployeeDetails(
		long projectEmployeeDetailsId) {

		return projectEmployeeDetailsPersistence.create(
			projectEmployeeDetailsId);
	}

	/**
	 * Deletes the project employee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectEmployeeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectEmployeeDetailsId the primary key of the project employee details
	 * @return the project employee details that was removed
	 * @throws PortalException if a project employee details with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ProjectEmployeeDetails deleteProjectEmployeeDetails(
			long projectEmployeeDetailsId)
		throws PortalException {

		return projectEmployeeDetailsPersistence.remove(
			projectEmployeeDetailsId);
	}

	/**
	 * Deletes the project employee details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectEmployeeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectEmployeeDetails the project employee details
	 * @return the project employee details that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ProjectEmployeeDetails deleteProjectEmployeeDetails(
		ProjectEmployeeDetails projectEmployeeDetails) {

		return projectEmployeeDetailsPersistence.remove(projectEmployeeDetails);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return projectEmployeeDetailsPersistence.dslQuery(dslQuery);
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
			ProjectEmployeeDetails.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return projectEmployeeDetailsPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.ProjectEmployeeDetailsModelImpl</code>.
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

		return projectEmployeeDetailsPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.ProjectEmployeeDetailsModelImpl</code>.
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

		return projectEmployeeDetailsPersistence.findWithDynamicQuery(
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
		return projectEmployeeDetailsPersistence.countWithDynamicQuery(
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
		DynamicQuery dynamicQuery, Projection projection) {

		return projectEmployeeDetailsPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public ProjectEmployeeDetails fetchProjectEmployeeDetails(
		long projectEmployeeDetailsId) {

		return projectEmployeeDetailsPersistence.fetchByPrimaryKey(
			projectEmployeeDetailsId);
	}

	/**
	 * Returns the project employee details matching the UUID and group.
	 *
	 * @param uuid the project employee details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project employee details, or <code>null</code> if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails fetchProjectEmployeeDetailsByUuidAndGroupId(
		String uuid, long groupId) {

		return projectEmployeeDetailsPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the project employee details with the primary key.
	 *
	 * @param projectEmployeeDetailsId the primary key of the project employee details
	 * @return the project employee details
	 * @throws PortalException if a project employee details with the primary key could not be found
	 */
	@Override
	public ProjectEmployeeDetails getProjectEmployeeDetails(
			long projectEmployeeDetailsId)
		throws PortalException {

		return projectEmployeeDetailsPersistence.findByPrimaryKey(
			projectEmployeeDetailsId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			projectEmployeeDetailsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ProjectEmployeeDetails.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"projectEmployeeDetailsId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			projectEmployeeDetailsLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			ProjectEmployeeDetails.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"projectEmployeeDetailsId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			projectEmployeeDetailsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ProjectEmployeeDetails.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"projectEmployeeDetailsId");
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
			new ActionableDynamicQuery.PerformActionMethod
				<ProjectEmployeeDetails>() {

				@Override
				public void performAction(
						ProjectEmployeeDetails projectEmployeeDetails)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, projectEmployeeDetails);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(
					ProjectEmployeeDetails.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return projectEmployeeDetailsPersistence.create(
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
				"Implement ProjectEmployeeDetailsLocalServiceImpl#deleteProjectEmployeeDetails(ProjectEmployeeDetails) to avoid orphaned data");
		}

		return projectEmployeeDetailsLocalService.deleteProjectEmployeeDetails(
			(ProjectEmployeeDetails)persistedModel);
	}

	@Override
	public BasePersistence<ProjectEmployeeDetails> getBasePersistence() {
		return projectEmployeeDetailsPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return projectEmployeeDetailsPersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns all the project employee detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the project employee detailses
	 * @param companyId the primary key of the company
	 * @return the matching project employee detailses, or an empty list if no matches were found
	 */
	@Override
	public List<ProjectEmployeeDetails>
		getProjectEmployeeDetailsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return projectEmployeeDetailsPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of project employee detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the project employee detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching project employee detailses, or an empty list if no matches were found
	 */
	@Override
	public List<ProjectEmployeeDetails>
		getProjectEmployeeDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ProjectEmployeeDetails> orderByComparator) {

		return projectEmployeeDetailsPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the project employee details matching the UUID and group.
	 *
	 * @param uuid the project employee details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project employee details
	 * @throws PortalException if a matching project employee details could not be found
	 */
	@Override
	public ProjectEmployeeDetails getProjectEmployeeDetailsByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return projectEmployeeDetailsPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the project employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.ProjectEmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project employee detailses
	 * @param end the upper bound of the range of project employee detailses (not inclusive)
	 * @return the range of project employee detailses
	 */
	@Override
	public List<ProjectEmployeeDetails> getProjectEmployeeDetailses(
		int start, int end) {

		return projectEmployeeDetailsPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of project employee detailses.
	 *
	 * @return the number of project employee detailses
	 */
	@Override
	public int getProjectEmployeeDetailsesCount() {
		return projectEmployeeDetailsPersistence.countAll();
	}

	/**
	 * Updates the project employee details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectEmployeeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectEmployeeDetails the project employee details
	 * @return the project employee details that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ProjectEmployeeDetails updateProjectEmployeeDetails(
		ProjectEmployeeDetails projectEmployeeDetails) {

		return projectEmployeeDetailsPersistence.update(projectEmployeeDetails);
	}

	@Deactivate
	protected void deactivate() {
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ProjectEmployeeDetailsLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		projectEmployeeDetailsLocalService =
			(ProjectEmployeeDetailsLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ProjectEmployeeDetailsLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ProjectEmployeeDetails.class;
	}

	protected String getModelClassName() {
		return ProjectEmployeeDetails.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				projectEmployeeDetailsPersistence.getDataSource();

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

	protected ProjectEmployeeDetailsLocalService
		projectEmployeeDetailsLocalService;

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
		ProjectEmployeeDetailsLocalServiceBaseImpl.class);

}