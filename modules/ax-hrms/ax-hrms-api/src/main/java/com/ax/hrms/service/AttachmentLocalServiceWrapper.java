/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AttachmentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentLocalService
 * @generated
 */
public class AttachmentLocalServiceWrapper
	implements AttachmentLocalService, ServiceWrapper<AttachmentLocalService> {

	public AttachmentLocalServiceWrapper() {
		this(null);
	}

	public AttachmentLocalServiceWrapper(
		AttachmentLocalService attachmentLocalService) {

		_attachmentLocalService = attachmentLocalService;
	}

	/**
	 * Adds the attachment to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AttachmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param attachment the attachment
	 * @return the attachment that was added
	 */
	@Override
	public com.ax.hrms.model.Attachment addAttachment(
		com.ax.hrms.model.Attachment attachment) {

		return _attachmentLocalService.addAttachment(attachment);
	}

	/**
	 * Creates a new attachment with the primary key. Does not add the attachment to the database.
	 *
	 * @param attachmentId the primary key for the new attachment
	 * @return the new attachment
	 */
	@Override
	public com.ax.hrms.model.Attachment createAttachment(long attachmentId) {
		return _attachmentLocalService.createAttachment(attachmentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attachmentLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the attachment from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AttachmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param attachment the attachment
	 * @return the attachment that was removed
	 */
	@Override
	public com.ax.hrms.model.Attachment deleteAttachment(
		com.ax.hrms.model.Attachment attachment) {

		return _attachmentLocalService.deleteAttachment(attachment);
	}

	/**
	 * Deletes the attachment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AttachmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param attachmentId the primary key of the attachment
	 * @return the attachment that was removed
	 * @throws PortalException if a attachment with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.Attachment deleteAttachment(long attachmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attachmentLocalService.deleteAttachment(attachmentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attachmentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _attachmentLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _attachmentLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _attachmentLocalService.dynamicQuery();
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

		return _attachmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AttachmentModelImpl</code>.
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

		return _attachmentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AttachmentModelImpl</code>.
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

		return _attachmentLocalService.dynamicQuery(
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

		return _attachmentLocalService.dynamicQueryCount(dynamicQuery);
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

		return _attachmentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.Attachment fetchAttachment(long attachmentId) {
		return _attachmentLocalService.fetchAttachment(attachmentId);
	}

	/**
	 * Returns the attachment matching the UUID and group.
	 *
	 * @param uuid the attachment's UUID
	 * @param groupId the primary key of the group
	 * @return the matching attachment, or <code>null</code> if a matching attachment could not be found
	 */
	@Override
	public com.ax.hrms.model.Attachment fetchAttachmentByUuidAndGroupId(
		String uuid, long groupId) {

		return _attachmentLocalService.fetchAttachmentByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.Attachment> findByTimeTrackerId(
		long timeTrackerId) {

		return _attachmentLocalService.findByTimeTrackerId(timeTrackerId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _attachmentLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the attachment with the primary key.
	 *
	 * @param attachmentId the primary key of the attachment
	 * @return the attachment
	 * @throws PortalException if a attachment with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.Attachment getAttachment(long attachmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attachmentLocalService.getAttachment(attachmentId);
	}

	/**
	 * Returns the attachment matching the UUID and group.
	 *
	 * @param uuid the attachment's UUID
	 * @param groupId the primary key of the group
	 * @return the matching attachment
	 * @throws PortalException if a matching attachment could not be found
	 */
	@Override
	public com.ax.hrms.model.Attachment getAttachmentByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attachmentLocalService.getAttachmentByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @return the range of attachments
	 */
	@Override
	public java.util.List<com.ax.hrms.model.Attachment> getAttachments(
		int start, int end) {

		return _attachmentLocalService.getAttachments(start, end);
	}

	/**
	 * Returns all the attachments matching the UUID and company.
	 *
	 * @param uuid the UUID of the attachments
	 * @param companyId the primary key of the company
	 * @return the matching attachments, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.Attachment>
		getAttachmentsByUuidAndCompanyId(String uuid, long companyId) {

		return _attachmentLocalService.getAttachmentsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of attachments matching the UUID and company.
	 *
	 * @param uuid the UUID of the attachments
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching attachments, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.Attachment>
		getAttachmentsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.Attachment> orderByComparator) {

		return _attachmentLocalService.getAttachmentsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of attachments.
	 *
	 * @return the number of attachments
	 */
	@Override
	public int getAttachmentsCount() {
		return _attachmentLocalService.getAttachmentsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _attachmentLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _attachmentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _attachmentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attachmentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the attachment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AttachmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param attachment the attachment
	 * @return the attachment that was updated
	 */
	@Override
	public com.ax.hrms.model.Attachment updateAttachment(
		com.ax.hrms.model.Attachment attachment) {

		return _attachmentLocalService.updateAttachment(attachment);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _attachmentLocalService.getBasePersistence();
	}

	@Override
	public AttachmentLocalService getWrappedService() {
		return _attachmentLocalService;
	}

	@Override
	public void setWrappedService(
		AttachmentLocalService attachmentLocalService) {

		_attachmentLocalService = attachmentLocalService;
	}

	private AttachmentLocalService _attachmentLocalService;

}