/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link TaskReviewLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TaskReviewLocalService
 * @generated
 */
public class TaskReviewLocalServiceWrapper
	implements ServiceWrapper<TaskReviewLocalService>, TaskReviewLocalService {

	public TaskReviewLocalServiceWrapper() {
		this(null);
	}

	public TaskReviewLocalServiceWrapper(
		TaskReviewLocalService taskReviewLocalService) {

		_taskReviewLocalService = taskReviewLocalService;
	}

	/**
	 * Adds the task review to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TaskReviewLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param taskReview the task review
	 * @return the task review that was added
	 */
	@Override
	public com.ax.hrms.model.TaskReview addTaskReview(
		com.ax.hrms.model.TaskReview taskReview) {

		return _taskReviewLocalService.addTaskReview(taskReview);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskReviewLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new task review with the primary key. Does not add the task review to the database.
	 *
	 * @param taskReviewId the primary key for the new task review
	 * @return the new task review
	 */
	@Override
	public com.ax.hrms.model.TaskReview createTaskReview(long taskReviewId) {
		return _taskReviewLocalService.createTaskReview(taskReviewId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskReviewLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the task review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TaskReviewLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param taskReviewId the primary key of the task review
	 * @return the task review that was removed
	 * @throws PortalException if a task review with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.TaskReview deleteTaskReview(long taskReviewId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskReviewLocalService.deleteTaskReview(taskReviewId);
	}

	/**
	 * Deletes the task review from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TaskReviewLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param taskReview the task review
	 * @return the task review that was removed
	 */
	@Override
	public com.ax.hrms.model.TaskReview deleteTaskReview(
		com.ax.hrms.model.TaskReview taskReview) {

		return _taskReviewLocalService.deleteTaskReview(taskReview);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _taskReviewLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _taskReviewLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _taskReviewLocalService.dynamicQuery();
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

		return _taskReviewLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.TaskReviewModelImpl</code>.
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

		return _taskReviewLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.TaskReviewModelImpl</code>.
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

		return _taskReviewLocalService.dynamicQuery(
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

		return _taskReviewLocalService.dynamicQueryCount(dynamicQuery);
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

		return _taskReviewLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.TaskReview fetchTaskReview(long taskReviewId) {
		return _taskReviewLocalService.fetchTaskReview(taskReviewId);
	}

	/**
	 * Returns the task review matching the UUID and group.
	 *
	 * @param uuid the task review's UUID
	 * @param groupId the primary key of the group
	 * @return the matching task review, or <code>null</code> if a matching task review could not be found
	 */
	@Override
	public com.ax.hrms.model.TaskReview fetchTaskReviewByUuidAndGroupId(
		String uuid, long groupId) {

		return _taskReviewLocalService.fetchTaskReviewByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.TaskReview> findByTaskId(
		long taskId) {

		return _taskReviewLocalService.findByTaskId(taskId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _taskReviewLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _taskReviewLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _taskReviewLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _taskReviewLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskReviewLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the task review with the primary key.
	 *
	 * @param taskReviewId the primary key of the task review
	 * @return the task review
	 * @throws PortalException if a task review with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.TaskReview getTaskReview(long taskReviewId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskReviewLocalService.getTaskReview(taskReviewId);
	}

	/**
	 * Returns the task review matching the UUID and group.
	 *
	 * @param uuid the task review's UUID
	 * @param groupId the primary key of the group
	 * @return the matching task review
	 * @throws PortalException if a matching task review could not be found
	 */
	@Override
	public com.ax.hrms.model.TaskReview getTaskReviewByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskReviewLocalService.getTaskReviewByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the task reviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.TaskReviewModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of task reviews
	 * @param end the upper bound of the range of task reviews (not inclusive)
	 * @return the range of task reviews
	 */
	@Override
	public java.util.List<com.ax.hrms.model.TaskReview> getTaskReviews(
		int start, int end) {

		return _taskReviewLocalService.getTaskReviews(start, end);
	}

	/**
	 * Returns all the task reviews matching the UUID and company.
	 *
	 * @param uuid the UUID of the task reviews
	 * @param companyId the primary key of the company
	 * @return the matching task reviews, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.TaskReview>
		getTaskReviewsByUuidAndCompanyId(String uuid, long companyId) {

		return _taskReviewLocalService.getTaskReviewsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of task reviews matching the UUID and company.
	 *
	 * @param uuid the UUID of the task reviews
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of task reviews
	 * @param end the upper bound of the range of task reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching task reviews, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.TaskReview>
		getTaskReviewsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.TaskReview> orderByComparator) {

		return _taskReviewLocalService.getTaskReviewsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of task reviews.
	 *
	 * @return the number of task reviews
	 */
	@Override
	public int getTaskReviewsCount() {
		return _taskReviewLocalService.getTaskReviewsCount();
	}

	/**
	 * Updates the task review in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TaskReviewLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param taskReview the task review
	 * @return the task review that was updated
	 */
	@Override
	public com.ax.hrms.model.TaskReview updateTaskReview(
		com.ax.hrms.model.TaskReview taskReview) {

		return _taskReviewLocalService.updateTaskReview(taskReview);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _taskReviewLocalService.getBasePersistence();
	}

	@Override
	public TaskReviewLocalService getWrappedService() {
		return _taskReviewLocalService;
	}

	@Override
	public void setWrappedService(
		TaskReviewLocalService taskReviewLocalService) {

		_taskReviewLocalService = taskReviewLocalService;
	}

	private TaskReviewLocalService _taskReviewLocalService;

}