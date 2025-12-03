/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.exception.NoSuchEmployeeDocumentException;
import com.ax.hrms.model.EmployeeDocument;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDocumentUtil
 * @generated
 */
@ProviderType
public interface EmployeeDocumentPersistence
	extends BasePersistence<EmployeeDocument> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeDocumentUtil} to access the employee document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee documents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee documents
	 */
	public java.util.List<EmployeeDocument> findByUuid(String uuid);

	/**
	 * Returns a range of all the employee documents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @return the range of matching employee documents
	 */
	public java.util.List<EmployeeDocument> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the employee documents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee documents
	 */
	public java.util.List<EmployeeDocument> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee documents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee documents
	 */
	public java.util.List<EmployeeDocument> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee document
	 * @throws NoSuchEmployeeDocumentException if a matching employee document could not be found
	 */
	public EmployeeDocument findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
				orderByComparator)
		throws NoSuchEmployeeDocumentException;

	/**
	 * Returns the first employee document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	public EmployeeDocument fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
			orderByComparator);

	/**
	 * Returns the last employee document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee document
	 * @throws NoSuchEmployeeDocumentException if a matching employee document could not be found
	 */
	public EmployeeDocument findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
				orderByComparator)
		throws NoSuchEmployeeDocumentException;

	/**
	 * Returns the last employee document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	public EmployeeDocument fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
			orderByComparator);

	/**
	 * Returns the employee documents before and after the current employee document in the ordered set where uuid = &#63;.
	 *
	 * @param documentId the primary key of the current employee document
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee document
	 * @throws NoSuchEmployeeDocumentException if a employee document with the primary key could not be found
	 */
	public EmployeeDocument[] findByUuid_PrevAndNext(
			long documentId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
				orderByComparator)
		throws NoSuchEmployeeDocumentException;

	/**
	 * Removes all the employee documents where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of employee documents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee documents
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the employee document where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeDocumentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee document
	 * @throws NoSuchEmployeeDocumentException if a matching employee document could not be found
	 */
	public EmployeeDocument findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDocumentException;

	/**
	 * Returns the employee document where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	public EmployeeDocument fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the employee document where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	public EmployeeDocument fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the employee document where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee document that was removed
	 */
	public EmployeeDocument removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDocumentException;

	/**
	 * Returns the number of employee documents where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee documents
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the employee documents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee documents
	 */
	public java.util.List<EmployeeDocument> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the employee documents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @return the range of matching employee documents
	 */
	public java.util.List<EmployeeDocument> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the employee documents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee documents
	 */
	public java.util.List<EmployeeDocument> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee documents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee documents
	 */
	public java.util.List<EmployeeDocument> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee document
	 * @throws NoSuchEmployeeDocumentException if a matching employee document could not be found
	 */
	public EmployeeDocument findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
				orderByComparator)
		throws NoSuchEmployeeDocumentException;

	/**
	 * Returns the first employee document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	public EmployeeDocument fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
			orderByComparator);

	/**
	 * Returns the last employee document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee document
	 * @throws NoSuchEmployeeDocumentException if a matching employee document could not be found
	 */
	public EmployeeDocument findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
				orderByComparator)
		throws NoSuchEmployeeDocumentException;

	/**
	 * Returns the last employee document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	public EmployeeDocument fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
			orderByComparator);

	/**
	 * Returns the employee documents before and after the current employee document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param documentId the primary key of the current employee document
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee document
	 * @throws NoSuchEmployeeDocumentException if a employee document with the primary key could not be found
	 */
	public EmployeeDocument[] findByUuid_C_PrevAndNext(
			long documentId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
				orderByComparator)
		throws NoSuchEmployeeDocumentException;

	/**
	 * Removes all the employee documents where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of employee documents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee documents
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the employee document in the entity cache if it is enabled.
	 *
	 * @param employeeDocument the employee document
	 */
	public void cacheResult(EmployeeDocument employeeDocument);

	/**
	 * Caches the employee documents in the entity cache if it is enabled.
	 *
	 * @param employeeDocuments the employee documents
	 */
	public void cacheResult(java.util.List<EmployeeDocument> employeeDocuments);

	/**
	 * Creates a new employee document with the primary key. Does not add the employee document to the database.
	 *
	 * @param documentId the primary key for the new employee document
	 * @return the new employee document
	 */
	public EmployeeDocument create(long documentId);

	/**
	 * Removes the employee document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentId the primary key of the employee document
	 * @return the employee document that was removed
	 * @throws NoSuchEmployeeDocumentException if a employee document with the primary key could not be found
	 */
	public EmployeeDocument remove(long documentId)
		throws NoSuchEmployeeDocumentException;

	public EmployeeDocument updateImpl(EmployeeDocument employeeDocument);

	/**
	 * Returns the employee document with the primary key or throws a <code>NoSuchEmployeeDocumentException</code> if it could not be found.
	 *
	 * @param documentId the primary key of the employee document
	 * @return the employee document
	 * @throws NoSuchEmployeeDocumentException if a employee document with the primary key could not be found
	 */
	public EmployeeDocument findByPrimaryKey(long documentId)
		throws NoSuchEmployeeDocumentException;

	/**
	 * Returns the employee document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentId the primary key of the employee document
	 * @return the employee document, or <code>null</code> if a employee document with the primary key could not be found
	 */
	public EmployeeDocument fetchByPrimaryKey(long documentId);

	/**
	 * Returns all the employee documents.
	 *
	 * @return the employee documents
	 */
	public java.util.List<EmployeeDocument> findAll();

	/**
	 * Returns a range of all the employee documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @return the range of employee documents
	 */
	public java.util.List<EmployeeDocument> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee documents
	 */
	public java.util.List<EmployeeDocument> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee documents
	 * @param end the upper bound of the range of employee documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee documents
	 */
	public java.util.List<EmployeeDocument> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee documents from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee documents.
	 *
	 * @return the number of employee documents
	 */
	public int countAll();

}