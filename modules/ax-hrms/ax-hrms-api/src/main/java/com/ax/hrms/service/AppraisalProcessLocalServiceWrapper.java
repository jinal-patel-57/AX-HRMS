/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AppraisalProcessLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalProcessLocalService
 * @generated
 */
public class AppraisalProcessLocalServiceWrapper
	implements AppraisalProcessLocalService,
			   ServiceWrapper<AppraisalProcessLocalService> {

	public AppraisalProcessLocalServiceWrapper() {
		this(null);
	}

	public AppraisalProcessLocalServiceWrapper(
		AppraisalProcessLocalService appraisalProcessLocalService) {

		_appraisalProcessLocalService = appraisalProcessLocalService;
	}

	/**
	 * Adds the appraisal process to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalProcessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalProcess the appraisal process
	 * @return the appraisal process that was added
	 */
	@Override
	public com.ax.hrms.model.AppraisalProcess addAppraisalProcess(
		com.ax.hrms.model.AppraisalProcess appraisalProcess) {

		return _appraisalProcessLocalService.addAppraisalProcess(
			appraisalProcess);
	}

	/**
	 * Creates a new appraisal process with the primary key. Does not add the appraisal process to the database.
	 *
	 * @param appraisalProcessId the primary key for the new appraisal process
	 * @return the new appraisal process
	 */
	@Override
	public com.ax.hrms.model.AppraisalProcess createAppraisalProcess(
		long appraisalProcessId) {

		return _appraisalProcessLocalService.createAppraisalProcess(
			appraisalProcessId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalProcessLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the appraisal process from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalProcessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalProcess the appraisal process
	 * @return the appraisal process that was removed
	 */
	@Override
	public com.ax.hrms.model.AppraisalProcess deleteAppraisalProcess(
		com.ax.hrms.model.AppraisalProcess appraisalProcess) {

		return _appraisalProcessLocalService.deleteAppraisalProcess(
			appraisalProcess);
	}

	/**
	 * Deletes the appraisal process with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalProcessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalProcessId the primary key of the appraisal process
	 * @return the appraisal process that was removed
	 * @throws PortalException if a appraisal process with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalProcess deleteAppraisalProcess(
			long appraisalProcessId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalProcessLocalService.deleteAppraisalProcess(
			appraisalProcessId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalProcessLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _appraisalProcessLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _appraisalProcessLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appraisalProcessLocalService.dynamicQuery();
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

		return _appraisalProcessLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalProcessModelImpl</code>.
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

		return _appraisalProcessLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalProcessModelImpl</code>.
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

		return _appraisalProcessLocalService.dynamicQuery(
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

		return _appraisalProcessLocalService.dynamicQueryCount(dynamicQuery);
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

		return _appraisalProcessLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.AppraisalProcess fetchAppraisalProcess(
		long appraisalProcessId) {

		return _appraisalProcessLocalService.fetchAppraisalProcess(
			appraisalProcessId);
	}

	/**
	 * Returns the appraisal process matching the UUID and group.
	 *
	 * @param uuid the appraisal process's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal process, or <code>null</code> if a matching appraisal process could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalProcess
		fetchAppraisalProcessByUuidAndGroupId(String uuid, long groupId) {

		return _appraisalProcessLocalService.
			fetchAppraisalProcessByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _appraisalProcessLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the appraisal process with the primary key.
	 *
	 * @param appraisalProcessId the primary key of the appraisal process
	 * @return the appraisal process
	 * @throws PortalException if a appraisal process with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalProcess getAppraisalProcess(
			long appraisalProcessId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalProcessLocalService.getAppraisalProcess(
			appraisalProcessId);
	}

	/**
	 * Returns the appraisal process matching the UUID and group.
	 *
	 * @param uuid the appraisal process's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal process
	 * @throws PortalException if a matching appraisal process could not be found
	 */
	@Override
	public com.ax.hrms.model.AppraisalProcess
			getAppraisalProcessByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalProcessLocalService.
			getAppraisalProcessByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the appraisal processes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalProcessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal processes
	 * @param end the upper bound of the range of appraisal processes (not inclusive)
	 * @return the range of appraisal processes
	 */
	@Override
	public java.util.List<com.ax.hrms.model.AppraisalProcess>
		getAppraisalProcesses(int start, int end) {

		return _appraisalProcessLocalService.getAppraisalProcesses(start, end);
	}

	/**
	 * Returns all the appraisal processes matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal processes
	 * @param companyId the primary key of the company
	 * @return the matching appraisal processes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.AppraisalProcess>
		getAppraisalProcessesByUuidAndCompanyId(String uuid, long companyId) {

		return _appraisalProcessLocalService.
			getAppraisalProcessesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of appraisal processes matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal processes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of appraisal processes
	 * @param end the upper bound of the range of appraisal processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching appraisal processes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.AppraisalProcess>
		getAppraisalProcessesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.AppraisalProcess> orderByComparator) {

		return _appraisalProcessLocalService.
			getAppraisalProcessesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of appraisal processes.
	 *
	 * @return the number of appraisal processes
	 */
	@Override
	public int getAppraisalProcessesCount() {
		return _appraisalProcessLocalService.getAppraisalProcessesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _appraisalProcessLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _appraisalProcessLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appraisalProcessLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appraisalProcessLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the appraisal process in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalProcessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalProcess the appraisal process
	 * @return the appraisal process that was updated
	 */
	@Override
	public com.ax.hrms.model.AppraisalProcess updateAppraisalProcess(
		com.ax.hrms.model.AppraisalProcess appraisalProcess) {

		return _appraisalProcessLocalService.updateAppraisalProcess(
			appraisalProcess);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _appraisalProcessLocalService.getBasePersistence();
	}

	@Override
	public AppraisalProcessLocalService getWrappedService() {
		return _appraisalProcessLocalService;
	}

	@Override
	public void setWrappedService(
		AppraisalProcessLocalService appraisalProcessLocalService) {

		_appraisalProcessLocalService = appraisalProcessLocalService;
	}

	private AppraisalProcessLocalService _appraisalProcessLocalService;

}