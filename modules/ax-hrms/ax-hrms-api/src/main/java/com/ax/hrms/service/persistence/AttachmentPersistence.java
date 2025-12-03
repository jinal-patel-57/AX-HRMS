/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchAttachmentException;
import com.ax.hrms.model.Attachment;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the attachment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentUtil
 * @generated
 */
@ProviderType
public interface AttachmentPersistence extends BasePersistence<Attachment> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AttachmentUtil} to access the attachment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the attachments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching attachments
	 */
	public java.util.List<Attachment> findByUuid(String uuid);

	/**
	 * Returns a range of all the attachments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @return the range of matching attachments
	 */
	public java.util.List<Attachment> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the attachments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attachments
	 */
	public java.util.List<Attachment> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Attachment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the attachments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching attachments
	 */
	public java.util.List<Attachment> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Attachment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first attachment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment
	 * @throws NoSuchAttachmentException if a matching attachment could not be found
	 */
	public Attachment findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Attachment>
				orderByComparator)
		throws NoSuchAttachmentException;

	/**
	 * Returns the first attachment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment, or <code>null</code> if a matching attachment could not be found
	 */
	public Attachment fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Attachment>
			orderByComparator);

	/**
	 * Returns the last attachment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment
	 * @throws NoSuchAttachmentException if a matching attachment could not be found
	 */
	public Attachment findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Attachment>
				orderByComparator)
		throws NoSuchAttachmentException;

	/**
	 * Returns the last attachment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment, or <code>null</code> if a matching attachment could not be found
	 */
	public Attachment fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Attachment>
			orderByComparator);

	/**
	 * Returns the attachments before and after the current attachment in the ordered set where uuid = &#63;.
	 *
	 * @param attachmentId the primary key of the current attachment
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachment
	 * @throws NoSuchAttachmentException if a attachment with the primary key could not be found
	 */
	public Attachment[] findByUuid_PrevAndNext(
			long attachmentId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Attachment>
				orderByComparator)
		throws NoSuchAttachmentException;

	/**
	 * Removes all the attachments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of attachments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching attachments
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the attachment where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAttachmentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching attachment
	 * @throws NoSuchAttachmentException if a matching attachment could not be found
	 */
	public Attachment findByUUID_G(String uuid, long groupId)
		throws NoSuchAttachmentException;

	/**
	 * Returns the attachment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching attachment, or <code>null</code> if a matching attachment could not be found
	 */
	public Attachment fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the attachment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching attachment, or <code>null</code> if a matching attachment could not be found
	 */
	public Attachment fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the attachment where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the attachment that was removed
	 */
	public Attachment removeByUUID_G(String uuid, long groupId)
		throws NoSuchAttachmentException;

	/**
	 * Returns the number of attachments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching attachments
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the attachments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching attachments
	 */
	public java.util.List<Attachment> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the attachments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @return the range of matching attachments
	 */
	public java.util.List<Attachment> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the attachments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attachments
	 */
	public java.util.List<Attachment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Attachment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the attachments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching attachments
	 */
	public java.util.List<Attachment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Attachment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first attachment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment
	 * @throws NoSuchAttachmentException if a matching attachment could not be found
	 */
	public Attachment findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Attachment>
				orderByComparator)
		throws NoSuchAttachmentException;

	/**
	 * Returns the first attachment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment, or <code>null</code> if a matching attachment could not be found
	 */
	public Attachment fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Attachment>
			orderByComparator);

	/**
	 * Returns the last attachment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment
	 * @throws NoSuchAttachmentException if a matching attachment could not be found
	 */
	public Attachment findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Attachment>
				orderByComparator)
		throws NoSuchAttachmentException;

	/**
	 * Returns the last attachment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment, or <code>null</code> if a matching attachment could not be found
	 */
	public Attachment fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Attachment>
			orderByComparator);

	/**
	 * Returns the attachments before and after the current attachment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param attachmentId the primary key of the current attachment
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachment
	 * @throws NoSuchAttachmentException if a attachment with the primary key could not be found
	 */
	public Attachment[] findByUuid_C_PrevAndNext(
			long attachmentId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Attachment>
				orderByComparator)
		throws NoSuchAttachmentException;

	/**
	 * Removes all the attachments where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of attachments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching attachments
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the attachments where timeTrackerId = &#63;.
	 *
	 * @param timeTrackerId the time tracker ID
	 * @return the matching attachments
	 */
	public java.util.List<Attachment> findByTimeTrackerId(long timeTrackerId);

	/**
	 * Returns a range of all the attachments where timeTrackerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param timeTrackerId the time tracker ID
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @return the range of matching attachments
	 */
	public java.util.List<Attachment> findByTimeTrackerId(
		long timeTrackerId, int start, int end);

	/**
	 * Returns an ordered range of all the attachments where timeTrackerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param timeTrackerId the time tracker ID
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attachments
	 */
	public java.util.List<Attachment> findByTimeTrackerId(
		long timeTrackerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Attachment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the attachments where timeTrackerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param timeTrackerId the time tracker ID
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching attachments
	 */
	public java.util.List<Attachment> findByTimeTrackerId(
		long timeTrackerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Attachment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first attachment in the ordered set where timeTrackerId = &#63;.
	 *
	 * @param timeTrackerId the time tracker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment
	 * @throws NoSuchAttachmentException if a matching attachment could not be found
	 */
	public Attachment findByTimeTrackerId_First(
			long timeTrackerId,
			com.liferay.portal.kernel.util.OrderByComparator<Attachment>
				orderByComparator)
		throws NoSuchAttachmentException;

	/**
	 * Returns the first attachment in the ordered set where timeTrackerId = &#63;.
	 *
	 * @param timeTrackerId the time tracker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attachment, or <code>null</code> if a matching attachment could not be found
	 */
	public Attachment fetchByTimeTrackerId_First(
		long timeTrackerId,
		com.liferay.portal.kernel.util.OrderByComparator<Attachment>
			orderByComparator);

	/**
	 * Returns the last attachment in the ordered set where timeTrackerId = &#63;.
	 *
	 * @param timeTrackerId the time tracker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment
	 * @throws NoSuchAttachmentException if a matching attachment could not be found
	 */
	public Attachment findByTimeTrackerId_Last(
			long timeTrackerId,
			com.liferay.portal.kernel.util.OrderByComparator<Attachment>
				orderByComparator)
		throws NoSuchAttachmentException;

	/**
	 * Returns the last attachment in the ordered set where timeTrackerId = &#63;.
	 *
	 * @param timeTrackerId the time tracker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attachment, or <code>null</code> if a matching attachment could not be found
	 */
	public Attachment fetchByTimeTrackerId_Last(
		long timeTrackerId,
		com.liferay.portal.kernel.util.OrderByComparator<Attachment>
			orderByComparator);

	/**
	 * Returns the attachments before and after the current attachment in the ordered set where timeTrackerId = &#63;.
	 *
	 * @param attachmentId the primary key of the current attachment
	 * @param timeTrackerId the time tracker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attachment
	 * @throws NoSuchAttachmentException if a attachment with the primary key could not be found
	 */
	public Attachment[] findByTimeTrackerId_PrevAndNext(
			long attachmentId, long timeTrackerId,
			com.liferay.portal.kernel.util.OrderByComparator<Attachment>
				orderByComparator)
		throws NoSuchAttachmentException;

	/**
	 * Removes all the attachments where timeTrackerId = &#63; from the database.
	 *
	 * @param timeTrackerId the time tracker ID
	 */
	public void removeByTimeTrackerId(long timeTrackerId);

	/**
	 * Returns the number of attachments where timeTrackerId = &#63;.
	 *
	 * @param timeTrackerId the time tracker ID
	 * @return the number of matching attachments
	 */
	public int countByTimeTrackerId(long timeTrackerId);

	/**
	 * Caches the attachment in the entity cache if it is enabled.
	 *
	 * @param attachment the attachment
	 */
	public void cacheResult(Attachment attachment);

	/**
	 * Caches the attachments in the entity cache if it is enabled.
	 *
	 * @param attachments the attachments
	 */
	public void cacheResult(java.util.List<Attachment> attachments);

	/**
	 * Creates a new attachment with the primary key. Does not add the attachment to the database.
	 *
	 * @param attachmentId the primary key for the new attachment
	 * @return the new attachment
	 */
	public Attachment create(long attachmentId);

	/**
	 * Removes the attachment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentId the primary key of the attachment
	 * @return the attachment that was removed
	 * @throws NoSuchAttachmentException if a attachment with the primary key could not be found
	 */
	public Attachment remove(long attachmentId)
		throws NoSuchAttachmentException;

	public Attachment updateImpl(Attachment attachment);

	/**
	 * Returns the attachment with the primary key or throws a <code>NoSuchAttachmentException</code> if it could not be found.
	 *
	 * @param attachmentId the primary key of the attachment
	 * @return the attachment
	 * @throws NoSuchAttachmentException if a attachment with the primary key could not be found
	 */
	public Attachment findByPrimaryKey(long attachmentId)
		throws NoSuchAttachmentException;

	/**
	 * Returns the attachment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attachmentId the primary key of the attachment
	 * @return the attachment, or <code>null</code> if a attachment with the primary key could not be found
	 */
	public Attachment fetchByPrimaryKey(long attachmentId);

	/**
	 * Returns all the attachments.
	 *
	 * @return the attachments
	 */
	public java.util.List<Attachment> findAll();

	/**
	 * Returns a range of all the attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @return the range of attachments
	 */
	public java.util.List<Attachment> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of attachments
	 */
	public java.util.List<Attachment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Attachment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachments
	 * @param end the upper bound of the range of attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of attachments
	 */
	public java.util.List<Attachment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Attachment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the attachments from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of attachments.
	 *
	 * @return the number of attachments
	 */
	public int countAll();

}