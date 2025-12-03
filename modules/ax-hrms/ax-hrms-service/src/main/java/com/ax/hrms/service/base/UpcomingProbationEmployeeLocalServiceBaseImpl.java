/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.base;

import com.ax.hrms.model.UpcomingProbationEmployee;
import com.ax.hrms.service.UpcomingProbationEmployeeLocalService;
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
 * Provides the base implementation for the upcoming probation employee local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.ax.hrms.service.impl.UpcomingProbationEmployeeLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ax.hrms.service.impl.UpcomingProbationEmployeeLocalServiceImpl
 * @generated
 */
public abstract class UpcomingProbationEmployeeLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   UpcomingProbationEmployeeLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>UpcomingProbationEmployeeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ax.hrms.service.UpcomingProbationEmployeeLocalServiceUtil</code>.
	 */

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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public UpcomingProbationEmployee addUpcomingProbationEmployee(
		UpcomingProbationEmployee upcomingProbationEmployee) {

		upcomingProbationEmployee.setNew(true);

		return upcomingProbationEmployeePersistence.update(
			upcomingProbationEmployee);
	}

	/**
	 * Creates a new upcoming probation employee with the primary key. Does not add the upcoming probation employee to the database.
	 *
	 * @param upcomingProbationEmployeeId the primary key for the new upcoming probation employee
	 * @return the new upcoming probation employee
	 */
	@Override
	@Transactional(enabled = false)
	public UpcomingProbationEmployee createUpcomingProbationEmployee(
		long upcomingProbationEmployeeId) {

		return upcomingProbationEmployeePersistence.create(
			upcomingProbationEmployeeId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public UpcomingProbationEmployee deleteUpcomingProbationEmployee(
			long upcomingProbationEmployeeId)
		throws PortalException {

		return upcomingProbationEmployeePersistence.remove(
			upcomingProbationEmployeeId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public UpcomingProbationEmployee deleteUpcomingProbationEmployee(
		UpcomingProbationEmployee upcomingProbationEmployee) {

		return upcomingProbationEmployeePersistence.remove(
			upcomingProbationEmployee);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return upcomingProbationEmployeePersistence.dslQuery(dslQuery);
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
			UpcomingProbationEmployee.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return upcomingProbationEmployeePersistence.findWithDynamicQuery(
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return upcomingProbationEmployeePersistence.findWithDynamicQuery(
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return upcomingProbationEmployeePersistence.findWithDynamicQuery(
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
		return upcomingProbationEmployeePersistence.countWithDynamicQuery(
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

		return upcomingProbationEmployeePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public UpcomingProbationEmployee fetchUpcomingProbationEmployee(
		long upcomingProbationEmployeeId) {

		return upcomingProbationEmployeePersistence.fetchByPrimaryKey(
			upcomingProbationEmployeeId);
	}

	/**
	 * Returns the upcoming probation employee matching the UUID and group.
	 *
	 * @param uuid the upcoming probation employee's UUID
	 * @param groupId the primary key of the group
	 * @return the matching upcoming probation employee, or <code>null</code> if a matching upcoming probation employee could not be found
	 */
	@Override
	public UpcomingProbationEmployee
		fetchUpcomingProbationEmployeeByUuidAndGroupId(
			String uuid, long groupId) {

		return upcomingProbationEmployeePersistence.fetchByUUID_G(
			uuid, groupId);
	}

	/**
	 * Returns the upcoming probation employee with the primary key.
	 *
	 * @param upcomingProbationEmployeeId the primary key of the upcoming probation employee
	 * @return the upcoming probation employee
	 * @throws PortalException if a upcoming probation employee with the primary key could not be found
	 */
	@Override
	public UpcomingProbationEmployee getUpcomingProbationEmployee(
			long upcomingProbationEmployeeId)
		throws PortalException {

		return upcomingProbationEmployeePersistence.findByPrimaryKey(
			upcomingProbationEmployeeId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			upcomingProbationEmployeeLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(UpcomingProbationEmployee.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"upcomingProbationEmployeeId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			upcomingProbationEmployeeLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			UpcomingProbationEmployee.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"upcomingProbationEmployeeId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			upcomingProbationEmployeeLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(UpcomingProbationEmployee.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"upcomingProbationEmployeeId");
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
				<UpcomingProbationEmployee>() {

				@Override
				public void performAction(
						UpcomingProbationEmployee upcomingProbationEmployee)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, upcomingProbationEmployee);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(
					UpcomingProbationEmployee.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return upcomingProbationEmployeePersistence.create(
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
				"Implement UpcomingProbationEmployeeLocalServiceImpl#deleteUpcomingProbationEmployee(UpcomingProbationEmployee) to avoid orphaned data");
		}

		return upcomingProbationEmployeeLocalService.
			deleteUpcomingProbationEmployee(
				(UpcomingProbationEmployee)persistedModel);
	}

	@Override
	public BasePersistence<UpcomingProbationEmployee> getBasePersistence() {
		return upcomingProbationEmployeePersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return upcomingProbationEmployeePersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns all the upcoming probation employees matching the UUID and company.
	 *
	 * @param uuid the UUID of the upcoming probation employees
	 * @param companyId the primary key of the company
	 * @return the matching upcoming probation employees, or an empty list if no matches were found
	 */
	@Override
	public List<UpcomingProbationEmployee>
		getUpcomingProbationEmployeesByUuidAndCompanyId(
			String uuid, long companyId) {

		return upcomingProbationEmployeePersistence.findByUuid_C(
			uuid, companyId);
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
	public List<UpcomingProbationEmployee>
		getUpcomingProbationEmployeesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<UpcomingProbationEmployee> orderByComparator) {

		return upcomingProbationEmployeePersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public UpcomingProbationEmployee
			getUpcomingProbationEmployeeByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return upcomingProbationEmployeePersistence.findByUUID_G(uuid, groupId);
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
	public List<UpcomingProbationEmployee> getUpcomingProbationEmployees(
		int start, int end) {

		return upcomingProbationEmployeePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of upcoming probation employees.
	 *
	 * @return the number of upcoming probation employees
	 */
	@Override
	public int getUpcomingProbationEmployeesCount() {
		return upcomingProbationEmployeePersistence.countAll();
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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public UpcomingProbationEmployee updateUpcomingProbationEmployee(
		UpcomingProbationEmployee upcomingProbationEmployee) {

		return upcomingProbationEmployeePersistence.update(
			upcomingProbationEmployee);
	}

	@Deactivate
	protected void deactivate() {
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			UpcomingProbationEmployeeLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		upcomingProbationEmployeeLocalService =
			(UpcomingProbationEmployeeLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return UpcomingProbationEmployeeLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return UpcomingProbationEmployee.class;
	}

	protected String getModelClassName() {
		return UpcomingProbationEmployee.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				upcomingProbationEmployeePersistence.getDataSource();

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

	protected UpcomingProbationEmployeeLocalService
		upcomingProbationEmployeeLocalService;

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
		UpcomingProbationEmployeeLocalServiceBaseImpl.class);

}