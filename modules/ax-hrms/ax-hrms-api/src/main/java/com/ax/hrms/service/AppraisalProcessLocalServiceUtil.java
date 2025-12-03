/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.AppraisalProcess;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AppraisalProcess. This utility wraps
 * <code>com.ax.hrms.service.impl.AppraisalProcessLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalProcessLocalService
 * @generated
 */
public class AppraisalProcessLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.AppraisalProcessLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static AppraisalProcess addAppraisalProcess(
		AppraisalProcess appraisalProcess) {

		return getService().addAppraisalProcess(appraisalProcess);
	}

	/**
	 * Creates a new appraisal process with the primary key. Does not add the appraisal process to the database.
	 *
	 * @param appraisalProcessId the primary key for the new appraisal process
	 * @return the new appraisal process
	 */
	public static AppraisalProcess createAppraisalProcess(
		long appraisalProcessId) {

		return getService().createAppraisalProcess(appraisalProcessId);
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
	 * Deletes the appraisal process from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalProcessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalProcess the appraisal process
	 * @return the appraisal process that was removed
	 */
	public static AppraisalProcess deleteAppraisalProcess(
		AppraisalProcess appraisalProcess) {

		return getService().deleteAppraisalProcess(appraisalProcess);
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
	public static AppraisalProcess deleteAppraisalProcess(
			long appraisalProcessId)
		throws PortalException {

		return getService().deleteAppraisalProcess(appraisalProcessId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalProcessModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalProcessModelImpl</code>.
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

	public static AppraisalProcess fetchAppraisalProcess(
		long appraisalProcessId) {

		return getService().fetchAppraisalProcess(appraisalProcessId);
	}

	/**
	 * Returns the appraisal process matching the UUID and group.
	 *
	 * @param uuid the appraisal process's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal process, or <code>null</code> if a matching appraisal process could not be found
	 */
	public static AppraisalProcess fetchAppraisalProcessByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchAppraisalProcessByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the appraisal process with the primary key.
	 *
	 * @param appraisalProcessId the primary key of the appraisal process
	 * @return the appraisal process
	 * @throws PortalException if a appraisal process with the primary key could not be found
	 */
	public static AppraisalProcess getAppraisalProcess(long appraisalProcessId)
		throws PortalException {

		return getService().getAppraisalProcess(appraisalProcessId);
	}

	/**
	 * Returns the appraisal process matching the UUID and group.
	 *
	 * @param uuid the appraisal process's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal process
	 * @throws PortalException if a matching appraisal process could not be found
	 */
	public static AppraisalProcess getAppraisalProcessByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getAppraisalProcessByUuidAndGroupId(uuid, groupId);
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
	public static List<AppraisalProcess> getAppraisalProcesses(
		int start, int end) {

		return getService().getAppraisalProcesses(start, end);
	}

	/**
	 * Returns all the appraisal processes matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal processes
	 * @param companyId the primary key of the company
	 * @return the matching appraisal processes, or an empty list if no matches were found
	 */
	public static List<AppraisalProcess>
		getAppraisalProcessesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getAppraisalProcessesByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<AppraisalProcess>
		getAppraisalProcessesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<AppraisalProcess> orderByComparator) {

		return getService().getAppraisalProcessesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of appraisal processes.
	 *
	 * @return the number of appraisal processes
	 */
	public static int getAppraisalProcessesCount() {
		return getService().getAppraisalProcessesCount();
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
	 * Updates the appraisal process in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalProcessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalProcess the appraisal process
	 * @return the appraisal process that was updated
	 */
	public static AppraisalProcess updateAppraisalProcess(
		AppraisalProcess appraisalProcess) {

		return getService().updateAppraisalProcess(appraisalProcess);
	}

	public static AppraisalProcessLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<AppraisalProcessLocalService>
		_serviceSnapshot = new Snapshot<>(
			AppraisalProcessLocalServiceUtil.class,
			AppraisalProcessLocalService.class);

}