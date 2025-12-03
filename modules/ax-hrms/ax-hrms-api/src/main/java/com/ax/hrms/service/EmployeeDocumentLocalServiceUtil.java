/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.EmployeeDocument;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for EmployeeDocument. This utility wraps
 * <code>com.ax.hrms.service.impl.EmployeeDocumentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDocumentLocalService
 * @generated
 */
public class EmployeeDocumentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.EmployeeDocumentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the employee document to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDocumentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDocument the employee document
	 * @return the employee document that was added
	 */
	public static EmployeeDocument addEmployeeDocument(
		EmployeeDocument employeeDocument) {

		return getService().addEmployeeDocument(employeeDocument);
	}

	/**
	 * Creates a new employee document with the primary key. Does not add the employee document to the database.
	 *
	 * @param documentId the primary key for the new employee document
	 * @return the new employee document
	 */
	public static EmployeeDocument createEmployeeDocument(long documentId) {
		return getService().createEmployeeDocument(documentId);
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
	 * Deletes the employee document from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDocumentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDocument the employee document
	 * @return the employee document that was removed
	 */
	public static EmployeeDocument deleteEmployeeDocument(
		EmployeeDocument employeeDocument) {

		return getService().deleteEmployeeDocument(employeeDocument);
	}

	/**
	 * Deletes the employee document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDocumentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentId the primary key of the employee document
	 * @return the employee document that was removed
	 * @throws PortalException if a employee document with the primary key could not be found
	 */
	public static EmployeeDocument deleteEmployeeDocument(long documentId)
		throws PortalException {

		return getService().deleteEmployeeDocument(documentId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeDocumentModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeDocumentModelImpl</code>.
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

	public static EmployeeDocument fetchEmployeeDocument(long documentId) {
		return getService().fetchEmployeeDocument(documentId);
	}

	/**
	 * Returns the employee document matching the UUID and group.
	 *
	 * @param uuid the employee document's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	public static EmployeeDocument fetchEmployeeDocumentByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchEmployeeDocumentByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the employee document with the primary key.
	 *
	 * @param documentId the primary key of the employee document
	 * @return the employee document
	 * @throws PortalException if a employee document with the primary key could not be found
	 */
	public static EmployeeDocument getEmployeeDocument(long documentId)
		throws PortalException {

		return getService().getEmployeeDocument(documentId);
	}

	/**
	 * Returns the employee document matching the UUID and group.
	 *
	 * @param uuid the employee document's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee document
	 * @throws PortalException if a matching employee document could not be found
	 */
	public static EmployeeDocument getEmployeeDocumentByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getEmployeeDocumentByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the employee documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @return the range of employee documents
	 */
	public static List<EmployeeDocument> getEmployeeDocuments(
		int start, int end) {

		return getService().getEmployeeDocuments(start, end);
	}

	/**
	 * Returns all the employee documents matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee documents
	 * @param companyId the primary key of the company
	 * @return the matching employee documents, or an empty list if no matches were found
	 */
	public static List<EmployeeDocument> getEmployeeDocumentsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getEmployeeDocumentsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of employee documents matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee documents
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee documents, or an empty list if no matches were found
	 */
	public static List<EmployeeDocument> getEmployeeDocumentsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeDocument> orderByComparator) {

		return getService().getEmployeeDocumentsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee documents.
	 *
	 * @return the number of employee documents
	 */
	public static int getEmployeeDocumentsCount() {
		return getService().getEmployeeDocumentsCount();
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
	 * Updates the employee document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDocumentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDocument the employee document
	 * @return the employee document that was updated
	 */
	public static EmployeeDocument updateEmployeeDocument(
		EmployeeDocument employeeDocument) {

		return getService().updateEmployeeDocument(employeeDocument);
	}

	public static EmployeeDocumentLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<EmployeeDocumentLocalService>
		_serviceSnapshot = new Snapshot<>(
			EmployeeDocumentLocalServiceUtil.class,
			EmployeeDocumentLocalService.class);

}