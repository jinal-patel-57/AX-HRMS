/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link DocumentTypeMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentTypeMasterLocalService
 * @generated
 */
public class DocumentTypeMasterLocalServiceWrapper
	implements DocumentTypeMasterLocalService,
			   ServiceWrapper<DocumentTypeMasterLocalService> {

	public DocumentTypeMasterLocalServiceWrapper() {
		this(null);
	}

	public DocumentTypeMasterLocalServiceWrapper(
		DocumentTypeMasterLocalService documentTypeMasterLocalService) {

		_documentTypeMasterLocalService = documentTypeMasterLocalService;
	}

	/**
	 * Adds the document type master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentTypeMaster the document type master
	 * @return the document type master that was added
	 */
	@Override
	public com.ax.hrms.master.model.DocumentTypeMaster addDocumentTypeMaster(
		com.ax.hrms.master.model.DocumentTypeMaster documentTypeMaster) {

		return _documentTypeMasterLocalService.addDocumentTypeMaster(
			documentTypeMaster);
	}

	/**
	 * Creates a new document type master with the primary key. Does not add the document type master to the database.
	 *
	 * @param documentTypeMasterId the primary key for the new document type master
	 * @return the new document type master
	 */
	@Override
	public com.ax.hrms.master.model.DocumentTypeMaster createDocumentTypeMaster(
		long documentTypeMasterId) {

		return _documentTypeMasterLocalService.createDocumentTypeMaster(
			documentTypeMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentTypeMasterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the document type master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentTypeMaster the document type master
	 * @return the document type master that was removed
	 */
	@Override
	public com.ax.hrms.master.model.DocumentTypeMaster deleteDocumentTypeMaster(
		com.ax.hrms.master.model.DocumentTypeMaster documentTypeMaster) {

		return _documentTypeMasterLocalService.deleteDocumentTypeMaster(
			documentTypeMaster);
	}

	/**
	 * Deletes the document type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentTypeMasterId the primary key of the document type master
	 * @return the document type master that was removed
	 * @throws PortalException if a document type master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.DocumentTypeMaster deleteDocumentTypeMaster(
			long documentTypeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentTypeMasterLocalService.deleteDocumentTypeMaster(
			documentTypeMasterId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentTypeMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _documentTypeMasterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _documentTypeMasterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _documentTypeMasterLocalService.dynamicQuery();
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

		return _documentTypeMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.DocumentTypeMasterModelImpl</code>.
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

		return _documentTypeMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.DocumentTypeMasterModelImpl</code>.
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

		return _documentTypeMasterLocalService.dynamicQuery(
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

		return _documentTypeMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _documentTypeMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.master.model.DocumentTypeMaster fetchDocumentTypeMaster(
		long documentTypeMasterId) {

		return _documentTypeMasterLocalService.fetchDocumentTypeMaster(
			documentTypeMasterId);
	}

	@Override
	public com.ax.hrms.master.model.DocumentTypeMaster findByDocumentTypeName(
			String documentTypeName)
		throws com.ax.hrms.master.exception.NoSuchDocumentTypeMasterException {

		return _documentTypeMasterLocalService.findByDocumentTypeName(
			documentTypeName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _documentTypeMasterLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the document type master with the primary key.
	 *
	 * @param documentTypeMasterId the primary key of the document type master
	 * @return the document type master
	 * @throws PortalException if a document type master with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.master.model.DocumentTypeMaster getDocumentTypeMaster(
			long documentTypeMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentTypeMasterLocalService.getDocumentTypeMaster(
			documentTypeMasterId);
	}

	@Override
	public long getDocumentTypeMasterIdByName(String documentTypeName) {
		return _documentTypeMasterLocalService.getDocumentTypeMasterIdByName(
			documentTypeName);
	}

	/**
	 * Returns a range of all the document type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.master.model.impl.DocumentTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document type masters
	 * @param end the upper bound of the range of document type masters (not inclusive)
	 * @return the range of document type masters
	 */
	@Override
	public java.util.List<com.ax.hrms.master.model.DocumentTypeMaster>
		getDocumentTypeMasters(int start, int end) {

		return _documentTypeMasterLocalService.getDocumentTypeMasters(
			start, end);
	}

	/**
	 * Returns the number of document type masters.
	 *
	 * @return the number of document type masters
	 */
	@Override
	public int getDocumentTypeMastersCount() {
		return _documentTypeMasterLocalService.getDocumentTypeMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _documentTypeMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _documentTypeMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentTypeMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean isDocumentTypeNameExists(String documentTypeName) {
		return _documentTypeMasterLocalService.isDocumentTypeNameExists(
			documentTypeName);
	}

	/**
	 * Updates the document type master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentTypeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentTypeMaster the document type master
	 * @return the document type master that was updated
	 */
	@Override
	public com.ax.hrms.master.model.DocumentTypeMaster updateDocumentTypeMaster(
		com.ax.hrms.master.model.DocumentTypeMaster documentTypeMaster) {

		return _documentTypeMasterLocalService.updateDocumentTypeMaster(
			documentTypeMaster);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _documentTypeMasterLocalService.getBasePersistence();
	}

	@Override
	public DocumentTypeMasterLocalService getWrappedService() {
		return _documentTypeMasterLocalService;
	}

	@Override
	public void setWrappedService(
		DocumentTypeMasterLocalService documentTypeMasterLocalService) {

		_documentTypeMasterLocalService = documentTypeMasterLocalService;
	}

	private DocumentTypeMasterLocalService _documentTypeMasterLocalService;

}