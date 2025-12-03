/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EmployeeDocumentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDocumentLocalService
 * @generated
 */
public class EmployeeDocumentLocalServiceWrapper
	implements EmployeeDocumentLocalService,
			   ServiceWrapper<EmployeeDocumentLocalService> {

	public EmployeeDocumentLocalServiceWrapper() {
		this(null);
	}

	public EmployeeDocumentLocalServiceWrapper(
		EmployeeDocumentLocalService employeeDocumentLocalService) {

		_employeeDocumentLocalService = employeeDocumentLocalService;
	}

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
	@Override
	public com.ax.hrms.model.EmployeeDocument addEmployeeDocument(
		com.ax.hrms.model.EmployeeDocument employeeDocument) {

		return _employeeDocumentLocalService.addEmployeeDocument(
			employeeDocument);
	}

	/**
	 * Creates a new employee document with the primary key. Does not add the employee document to the database.
	 *
	 * @param documentId the primary key for the new employee document
	 * @return the new employee document
	 */
	@Override
	public com.ax.hrms.model.EmployeeDocument createEmployeeDocument(
		long documentId) {

		return _employeeDocumentLocalService.createEmployeeDocument(documentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDocumentLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.ax.hrms.model.EmployeeDocument deleteEmployeeDocument(
		com.ax.hrms.model.EmployeeDocument employeeDocument) {

		return _employeeDocumentLocalService.deleteEmployeeDocument(
			employeeDocument);
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
	@Override
	public com.ax.hrms.model.EmployeeDocument deleteEmployeeDocument(
			long documentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDocumentLocalService.deleteEmployeeDocument(documentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDocumentLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _employeeDocumentLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _employeeDocumentLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeDocumentLocalService.dynamicQuery();
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

		return _employeeDocumentLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _employeeDocumentLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _employeeDocumentLocalService.dynamicQuery(
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

		return _employeeDocumentLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeDocumentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.EmployeeDocument fetchEmployeeDocument(
		long documentId) {

		return _employeeDocumentLocalService.fetchEmployeeDocument(documentId);
	}

	/**
	 * Returns the employee document matching the UUID and group.
	 *
	 * @param uuid the employee document's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeDocument
		fetchEmployeeDocumentByUuidAndGroupId(String uuid, long groupId) {

		return _employeeDocumentLocalService.
			fetchEmployeeDocumentByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeDocumentLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the employee document with the primary key.
	 *
	 * @param documentId the primary key of the employee document
	 * @return the employee document
	 * @throws PortalException if a employee document with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeDocument getEmployeeDocument(
			long documentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDocumentLocalService.getEmployeeDocument(documentId);
	}

	/**
	 * Returns the employee document matching the UUID and group.
	 *
	 * @param uuid the employee document's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee document
	 * @throws PortalException if a matching employee document could not be found
	 */
	@Override
	public com.ax.hrms.model.EmployeeDocument
			getEmployeeDocumentByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDocumentLocalService.
			getEmployeeDocumentByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeDocument>
		getEmployeeDocuments(int start, int end) {

		return _employeeDocumentLocalService.getEmployeeDocuments(start, end);
	}

	/**
	 * Returns all the employee documents matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee documents
	 * @param companyId the primary key of the company
	 * @return the matching employee documents, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeDocument>
		getEmployeeDocumentsByUuidAndCompanyId(String uuid, long companyId) {

		return _employeeDocumentLocalService.
			getEmployeeDocumentsByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.ax.hrms.model.EmployeeDocument>
		getEmployeeDocumentsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.EmployeeDocument> orderByComparator) {

		return _employeeDocumentLocalService.
			getEmployeeDocumentsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee documents.
	 *
	 * @return the number of employee documents
	 */
	@Override
	public int getEmployeeDocumentsCount() {
		return _employeeDocumentLocalService.getEmployeeDocumentsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _employeeDocumentLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeDocumentLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDocumentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDocumentLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.ax.hrms.model.EmployeeDocument updateEmployeeDocument(
		com.ax.hrms.model.EmployeeDocument employeeDocument) {

		return _employeeDocumentLocalService.updateEmployeeDocument(
			employeeDocument);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _employeeDocumentLocalService.getBasePersistence();
	}

	@Override
	public EmployeeDocumentLocalService getWrappedService() {
		return _employeeDocumentLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeDocumentLocalService employeeDocumentLocalService) {

		_employeeDocumentLocalService = employeeDocumentLocalService;
	}

	private EmployeeDocumentLocalService _employeeDocumentLocalService;

}