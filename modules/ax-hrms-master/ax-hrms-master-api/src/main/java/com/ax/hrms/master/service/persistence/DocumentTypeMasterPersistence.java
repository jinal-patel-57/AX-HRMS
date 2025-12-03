/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.exception.NoSuchDocumentTypeMasterException;
import com.ax.hrms.master.model.DocumentTypeMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the document type master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentTypeMasterUtil
 * @generated
 */
@ProviderType
public interface DocumentTypeMasterPersistence
	extends BasePersistence<DocumentTypeMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DocumentTypeMasterUtil} to access the document type master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the document type master where documentTypeName = &#63; or throws a <code>NoSuchDocumentTypeMasterException</code> if it could not be found.
	 *
	 * @param documentTypeName the document type name
	 * @return the matching document type master
	 * @throws NoSuchDocumentTypeMasterException if a matching document type master could not be found
	 */
	public DocumentTypeMaster findByDocumentTypeName(String documentTypeName)
		throws NoSuchDocumentTypeMasterException;

	/**
	 * Returns the document type master where documentTypeName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param documentTypeName the document type name
	 * @return the matching document type master, or <code>null</code> if a matching document type master could not be found
	 */
	public DocumentTypeMaster fetchByDocumentTypeName(String documentTypeName);

	/**
	 * Returns the document type master where documentTypeName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param documentTypeName the document type name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document type master, or <code>null</code> if a matching document type master could not be found
	 */
	public DocumentTypeMaster fetchByDocumentTypeName(
		String documentTypeName, boolean useFinderCache);

	/**
	 * Removes the document type master where documentTypeName = &#63; from the database.
	 *
	 * @param documentTypeName the document type name
	 * @return the document type master that was removed
	 */
	public DocumentTypeMaster removeByDocumentTypeName(String documentTypeName)
		throws NoSuchDocumentTypeMasterException;

	/**
	 * Returns the number of document type masters where documentTypeName = &#63;.
	 *
	 * @param documentTypeName the document type name
	 * @return the number of matching document type masters
	 */
	public int countByDocumentTypeName(String documentTypeName);

	/**
	 * Caches the document type master in the entity cache if it is enabled.
	 *
	 * @param documentTypeMaster the document type master
	 */
	public void cacheResult(DocumentTypeMaster documentTypeMaster);

	/**
	 * Caches the document type masters in the entity cache if it is enabled.
	 *
	 * @param documentTypeMasters the document type masters
	 */
	public void cacheResult(
		java.util.List<DocumentTypeMaster> documentTypeMasters);

	/**
	 * Creates a new document type master with the primary key. Does not add the document type master to the database.
	 *
	 * @param documentTypeMasterId the primary key for the new document type master
	 * @return the new document type master
	 */
	public DocumentTypeMaster create(long documentTypeMasterId);

	/**
	 * Removes the document type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentTypeMasterId the primary key of the document type master
	 * @return the document type master that was removed
	 * @throws NoSuchDocumentTypeMasterException if a document type master with the primary key could not be found
	 */
	public DocumentTypeMaster remove(long documentTypeMasterId)
		throws NoSuchDocumentTypeMasterException;

	public DocumentTypeMaster updateImpl(DocumentTypeMaster documentTypeMaster);

	/**
	 * Returns the document type master with the primary key or throws a <code>NoSuchDocumentTypeMasterException</code> if it could not be found.
	 *
	 * @param documentTypeMasterId the primary key of the document type master
	 * @return the document type master
	 * @throws NoSuchDocumentTypeMasterException if a document type master with the primary key could not be found
	 */
	public DocumentTypeMaster findByPrimaryKey(long documentTypeMasterId)
		throws NoSuchDocumentTypeMasterException;

	/**
	 * Returns the document type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentTypeMasterId the primary key of the document type master
	 * @return the document type master, or <code>null</code> if a document type master with the primary key could not be found
	 */
	public DocumentTypeMaster fetchByPrimaryKey(long documentTypeMasterId);

	/**
	 * Returns all the document type masters.
	 *
	 * @return the document type masters
	 */
	public java.util.List<DocumentTypeMaster> findAll();

	/**
	 * Returns a range of all the document type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document type masters
	 * @param end the upper bound of the range of document type masters (not inclusive)
	 * @return the range of document type masters
	 */
	public java.util.List<DocumentTypeMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the document type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document type masters
	 * @param end the upper bound of the range of document type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of document type masters
	 */
	public java.util.List<DocumentTypeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentTypeMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the document type masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentTypeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document type masters
	 * @param end the upper bound of the range of document type masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of document type masters
	 */
	public java.util.List<DocumentTypeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentTypeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the document type masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of document type masters.
	 *
	 * @return the number of document type masters
	 */
	public int countAll();

}