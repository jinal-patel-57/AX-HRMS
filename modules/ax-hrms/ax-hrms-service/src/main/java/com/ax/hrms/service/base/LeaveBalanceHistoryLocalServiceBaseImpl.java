/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.base;

import com.ax.hrms.model.LeaveBalanceHistory;
import com.ax.hrms.service.LeaveBalanceHistoryLocalService;
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
 * Provides the base implementation for the leave balance history local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.ax.hrms.service.impl.LeaveBalanceHistoryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ax.hrms.service.impl.LeaveBalanceHistoryLocalServiceImpl
 * @generated
 */
public abstract class LeaveBalanceHistoryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   LeaveBalanceHistoryLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>LeaveBalanceHistoryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ax.hrms.service.LeaveBalanceHistoryLocalServiceUtil</code>.
	 */

	/**
	 * Adds the leave balance history to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveBalanceHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveBalanceHistory the leave balance history
	 * @return the leave balance history that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public LeaveBalanceHistory addLeaveBalanceHistory(
		LeaveBalanceHistory leaveBalanceHistory) {

		leaveBalanceHistory.setNew(true);

		return leaveBalanceHistoryPersistence.update(leaveBalanceHistory);
	}

	/**
	 * Creates a new leave balance history with the primary key. Does not add the leave balance history to the database.
	 *
	 * @param leaveBalanceHistoryId the primary key for the new leave balance history
	 * @return the new leave balance history
	 */
	@Override
	@Transactional(enabled = false)
	public LeaveBalanceHistory createLeaveBalanceHistory(
		long leaveBalanceHistoryId) {

		return leaveBalanceHistoryPersistence.create(leaveBalanceHistoryId);
	}

	/**
	 * Deletes the leave balance history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveBalanceHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveBalanceHistoryId the primary key of the leave balance history
	 * @return the leave balance history that was removed
	 * @throws PortalException if a leave balance history with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public LeaveBalanceHistory deleteLeaveBalanceHistory(
			long leaveBalanceHistoryId)
		throws PortalException {

		return leaveBalanceHistoryPersistence.remove(leaveBalanceHistoryId);
	}

	/**
	 * Deletes the leave balance history from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveBalanceHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveBalanceHistory the leave balance history
	 * @return the leave balance history that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public LeaveBalanceHistory deleteLeaveBalanceHistory(
		LeaveBalanceHistory leaveBalanceHistory) {

		return leaveBalanceHistoryPersistence.remove(leaveBalanceHistory);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return leaveBalanceHistoryPersistence.dslQuery(dslQuery);
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
			LeaveBalanceHistory.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return leaveBalanceHistoryPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveBalanceHistoryModelImpl</code>.
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

		return leaveBalanceHistoryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveBalanceHistoryModelImpl</code>.
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

		return leaveBalanceHistoryPersistence.findWithDynamicQuery(
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
		return leaveBalanceHistoryPersistence.countWithDynamicQuery(
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

		return leaveBalanceHistoryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public LeaveBalanceHistory fetchLeaveBalanceHistory(
		long leaveBalanceHistoryId) {

		return leaveBalanceHistoryPersistence.fetchByPrimaryKey(
			leaveBalanceHistoryId);
	}

	/**
	 * Returns the leave balance history matching the UUID and group.
	 *
	 * @param uuid the leave balance history's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave balance history, or <code>null</code> if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory fetchLeaveBalanceHistoryByUuidAndGroupId(
		String uuid, long groupId) {

		return leaveBalanceHistoryPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the leave balance history with the primary key.
	 *
	 * @param leaveBalanceHistoryId the primary key of the leave balance history
	 * @return the leave balance history
	 * @throws PortalException if a leave balance history with the primary key could not be found
	 */
	@Override
	public LeaveBalanceHistory getLeaveBalanceHistory(
			long leaveBalanceHistoryId)
		throws PortalException {

		return leaveBalanceHistoryPersistence.findByPrimaryKey(
			leaveBalanceHistoryId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			leaveBalanceHistoryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(LeaveBalanceHistory.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"leaveBalanceHistoryId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			leaveBalanceHistoryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			LeaveBalanceHistory.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"leaveBalanceHistoryId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			leaveBalanceHistoryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(LeaveBalanceHistory.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"leaveBalanceHistoryId");
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
				<LeaveBalanceHistory>() {

				@Override
				public void performAction(
						LeaveBalanceHistory leaveBalanceHistory)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, leaveBalanceHistory);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(
					LeaveBalanceHistory.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return leaveBalanceHistoryPersistence.create(
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
				"Implement LeaveBalanceHistoryLocalServiceImpl#deleteLeaveBalanceHistory(LeaveBalanceHistory) to avoid orphaned data");
		}

		return leaveBalanceHistoryLocalService.deleteLeaveBalanceHistory(
			(LeaveBalanceHistory)persistedModel);
	}

	@Override
	public BasePersistence<LeaveBalanceHistory> getBasePersistence() {
		return leaveBalanceHistoryPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return leaveBalanceHistoryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the leave balance histories matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave balance histories
	 * @param companyId the primary key of the company
	 * @return the matching leave balance histories, or an empty list if no matches were found
	 */
	@Override
	public List<LeaveBalanceHistory> getLeaveBalanceHistoriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return leaveBalanceHistoryPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of leave balance histories matching the UUID and company.
	 *
	 * @param uuid the UUID of the leave balance histories
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching leave balance histories, or an empty list if no matches were found
	 */
	@Override
	public List<LeaveBalanceHistory> getLeaveBalanceHistoriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LeaveBalanceHistory> orderByComparator) {

		return leaveBalanceHistoryPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the leave balance history matching the UUID and group.
	 *
	 * @param uuid the leave balance history's UUID
	 * @param groupId the primary key of the group
	 * @return the matching leave balance history
	 * @throws PortalException if a matching leave balance history could not be found
	 */
	@Override
	public LeaveBalanceHistory getLeaveBalanceHistoryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return leaveBalanceHistoryPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the leave balance histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.LeaveBalanceHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave balance histories
	 * @param end the upper bound of the range of leave balance histories (not inclusive)
	 * @return the range of leave balance histories
	 */
	@Override
	public List<LeaveBalanceHistory> getLeaveBalanceHistories(
		int start, int end) {

		return leaveBalanceHistoryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of leave balance histories.
	 *
	 * @return the number of leave balance histories
	 */
	@Override
	public int getLeaveBalanceHistoriesCount() {
		return leaveBalanceHistoryPersistence.countAll();
	}

	/**
	 * Updates the leave balance history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeaveBalanceHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leaveBalanceHistory the leave balance history
	 * @return the leave balance history that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public LeaveBalanceHistory updateLeaveBalanceHistory(
		LeaveBalanceHistory leaveBalanceHistory) {

		return leaveBalanceHistoryPersistence.update(leaveBalanceHistory);
	}

	@Deactivate
	protected void deactivate() {
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			LeaveBalanceHistoryLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		leaveBalanceHistoryLocalService =
			(LeaveBalanceHistoryLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return LeaveBalanceHistoryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return LeaveBalanceHistory.class;
	}

	protected String getModelClassName() {
		return LeaveBalanceHistory.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				leaveBalanceHistoryPersistence.getDataSource();

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

	protected LeaveBalanceHistoryLocalService leaveBalanceHistoryLocalService;

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
		LeaveBalanceHistoryLocalServiceBaseImpl.class);

}