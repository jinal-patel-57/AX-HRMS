/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.base;

import com.ax.hrms.model.EmployeeWish;
import com.ax.hrms.service.EmployeeWishLocalService;
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
 * Provides the base implementation for the employee wish local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.ax.hrms.service.impl.EmployeeWishLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ax.hrms.service.impl.EmployeeWishLocalServiceImpl
 * @generated
 */
public abstract class EmployeeWishLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, EmployeeWishLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>EmployeeWishLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ax.hrms.service.EmployeeWishLocalServiceUtil</code>.
	 */

	/**
	 * Adds the employee wish to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeWishLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeWish the employee wish
	 * @return the employee wish that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EmployeeWish addEmployeeWish(EmployeeWish employeeWish) {
		employeeWish.setNew(true);

		return employeeWishPersistence.update(employeeWish);
	}

	/**
	 * Creates a new employee wish with the primary key. Does not add the employee wish to the database.
	 *
	 * @param wishId the primary key for the new employee wish
	 * @return the new employee wish
	 */
	@Override
	@Transactional(enabled = false)
	public EmployeeWish createEmployeeWish(long wishId) {
		return employeeWishPersistence.create(wishId);
	}

	/**
	 * Deletes the employee wish with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeWishLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param wishId the primary key of the employee wish
	 * @return the employee wish that was removed
	 * @throws PortalException if a employee wish with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EmployeeWish deleteEmployeeWish(long wishId) throws PortalException {
		return employeeWishPersistence.remove(wishId);
	}

	/**
	 * Deletes the employee wish from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeWishLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeWish the employee wish
	 * @return the employee wish that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EmployeeWish deleteEmployeeWish(EmployeeWish employeeWish) {
		return employeeWishPersistence.remove(employeeWish);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return employeeWishPersistence.dslQuery(dslQuery);
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
			EmployeeWish.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return employeeWishPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeWishModelImpl</code>.
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

		return employeeWishPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeWishModelImpl</code>.
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

		return employeeWishPersistence.findWithDynamicQuery(
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
		return employeeWishPersistence.countWithDynamicQuery(dynamicQuery);
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

		return employeeWishPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public EmployeeWish fetchEmployeeWish(long wishId) {
		return employeeWishPersistence.fetchByPrimaryKey(wishId);
	}

	/**
	 * Returns the employee wish matching the UUID and group.
	 *
	 * @param uuid the employee wish's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee wish, or <code>null</code> if a matching employee wish could not be found
	 */
	@Override
	public EmployeeWish fetchEmployeeWishByUuidAndGroupId(
		String uuid, long groupId) {

		return employeeWishPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee wish with the primary key.
	 *
	 * @param wishId the primary key of the employee wish
	 * @return the employee wish
	 * @throws PortalException if a employee wish with the primary key could not be found
	 */
	@Override
	public EmployeeWish getEmployeeWish(long wishId) throws PortalException {
		return employeeWishPersistence.findByPrimaryKey(wishId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(employeeWishLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(EmployeeWish.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("wishId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			employeeWishLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(EmployeeWish.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("wishId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(employeeWishLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(EmployeeWish.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("wishId");
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
			new ActionableDynamicQuery.PerformActionMethod<EmployeeWish>() {

				@Override
				public void performAction(EmployeeWish employeeWish)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, employeeWish);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(EmployeeWish.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return employeeWishPersistence.create(
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
				"Implement EmployeeWishLocalServiceImpl#deleteEmployeeWish(EmployeeWish) to avoid orphaned data");
		}

		return employeeWishLocalService.deleteEmployeeWish(
			(EmployeeWish)persistedModel);
	}

	@Override
	public BasePersistence<EmployeeWish> getBasePersistence() {
		return employeeWishPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return employeeWishPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the employee wishes matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee wishes
	 * @param companyId the primary key of the company
	 * @return the matching employee wishes, or an empty list if no matches were found
	 */
	@Override
	public List<EmployeeWish> getEmployeeWishesByUuidAndCompanyId(
		String uuid, long companyId) {

		return employeeWishPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of employee wishes matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee wishes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee wishes
	 * @param end the upper bound of the range of employee wishes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee wishes, or an empty list if no matches were found
	 */
	@Override
	public List<EmployeeWish> getEmployeeWishesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeWish> orderByComparator) {

		return employeeWishPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the employee wish matching the UUID and group.
	 *
	 * @param uuid the employee wish's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee wish
	 * @throws PortalException if a matching employee wish could not be found
	 */
	@Override
	public EmployeeWish getEmployeeWishByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return employeeWishPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the employee wishes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeWishModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee wishes
	 * @param end the upper bound of the range of employee wishes (not inclusive)
	 * @return the range of employee wishes
	 */
	@Override
	public List<EmployeeWish> getEmployeeWishes(int start, int end) {
		return employeeWishPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of employee wishes.
	 *
	 * @return the number of employee wishes
	 */
	@Override
	public int getEmployeeWishesCount() {
		return employeeWishPersistence.countAll();
	}

	/**
	 * Updates the employee wish in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeWishLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeWish the employee wish
	 * @return the employee wish that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EmployeeWish updateEmployeeWish(EmployeeWish employeeWish) {
		return employeeWishPersistence.update(employeeWish);
	}

	@Deactivate
	protected void deactivate() {
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			EmployeeWishLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		employeeWishLocalService = (EmployeeWishLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return EmployeeWishLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return EmployeeWish.class;
	}

	protected String getModelClassName() {
		return EmployeeWish.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = employeeWishPersistence.getDataSource();

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

	protected EmployeeWishLocalService employeeWishLocalService;

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
		EmployeeWishLocalServiceBaseImpl.class);

}