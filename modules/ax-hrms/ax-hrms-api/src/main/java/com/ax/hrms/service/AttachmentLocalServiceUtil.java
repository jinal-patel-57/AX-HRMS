/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.Attachment;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Attachment. This utility wraps
 * <code>com.ax.hrms.service.impl.AttachmentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentLocalService
 * @generated
 */
public class AttachmentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.AttachmentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Attachment addAttachment(Attachment attachment) {
		return getService().addAttachment(attachment);
	}

	/**
	 * Creates a new attachment with the primary key. Does not add the attachment to the database.
	 *
	 * @param attachmentId the primary key for the new attachment
	 * @return the new attachment
	 */
	public static Attachment createAttachment(long attachmentId) {
		return getService().createAttachment(attachmentId);
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
	 * Deletes the attachment from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AttachmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param attachment the attachment
	 * @return the attachment that was removed
	 */
	public static Attachment deleteAttachment(Attachment attachment) {
		return getService().deleteAttachment(attachment);
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
	public static Attachment deleteAttachment(long attachmentId)
		throws PortalException {

		return getService().deleteAttachment(attachmentId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AttachmentModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AttachmentModelImpl</code>.
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

	public static Attachment fetchAttachment(long attachmentId) {
		return getService().fetchAttachment(attachmentId);
	}

	/**
	 * Returns the attachment matching the UUID and group.
	 *
	 * @param uuid the attachment's UUID
	 * @param groupId the primary key of the group
	 * @return the matching attachment, or <code>null</code> if a matching attachment could not be found
	 */
	public static Attachment fetchAttachmentByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchAttachmentByUuidAndGroupId(uuid, groupId);
	}

	public static List<Attachment> findByTimeTrackerId(long timeTrackerId) {
		return getService().findByTimeTrackerId(timeTrackerId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the attachment with the primary key.
	 *
	 * @param attachmentId the primary key of the attachment
	 * @return the attachment
	 * @throws PortalException if a attachment with the primary key could not be found
	 */
	public static Attachment getAttachment(long attachmentId)
		throws PortalException {

		return getService().getAttachment(attachmentId);
	}

	/**
	 * Returns the attachment matching the UUID and group.
	 *
	 * @param uuid the attachment's UUID
	 * @param groupId the primary key of the group
	 * @return the matching attachment
	 * @throws PortalException if a matching attachment could not be found
	 */
	public static Attachment getAttachmentByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getAttachmentByUuidAndGroupId(uuid, groupId);
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
	public static List<Attachment> getAttachments(int start, int end) {
		return getService().getAttachments(start, end);
	}

	/**
	 * Returns all the attachments matching the UUID and company.
	 *
	 * @param uuid the UUID of the attachments
	 * @param companyId the primary key of the company
	 * @return the matching attachments, or an empty list if no matches were found
	 */
	public static List<Attachment> getAttachmentsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getAttachmentsByUuidAndCompanyId(uuid, companyId);
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
	public static List<Attachment> getAttachmentsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Attachment> orderByComparator) {

		return getService().getAttachmentsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of attachments.
	 *
	 * @return the number of attachments
	 */
	public static int getAttachmentsCount() {
		return getService().getAttachmentsCount();
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
	 * Updates the attachment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AttachmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param attachment the attachment
	 * @return the attachment that was updated
	 */
	public static Attachment updateAttachment(Attachment attachment) {
		return getService().updateAttachment(attachment);
	}

	public static AttachmentLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<AttachmentLocalService> _serviceSnapshot =
		new Snapshot<>(
			AttachmentLocalServiceUtil.class, AttachmentLocalService.class);

}