/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.service.persistence;

import com.ax.hrms.master.model.DocumentTypeMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the document type master service. This utility wraps <code>com.ax.hrms.master.service.persistence.impl.DocumentTypeMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentTypeMasterPersistence
 * @generated
 */
public class DocumentTypeMasterUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(DocumentTypeMaster documentTypeMaster) {
		getPersistence().clearCache(documentTypeMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, DocumentTypeMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DocumentTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DocumentTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DocumentTypeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DocumentTypeMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DocumentTypeMaster update(
		DocumentTypeMaster documentTypeMaster) {

		return getPersistence().update(documentTypeMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DocumentTypeMaster update(
		DocumentTypeMaster documentTypeMaster, ServiceContext serviceContext) {

		return getPersistence().update(documentTypeMaster, serviceContext);
	}

	/**
	 * Returns the document type master where documentTypeName = &#63; or throws a <code>NoSuchDocumentTypeMasterException</code> if it could not be found.
	 *
	 * @param documentTypeName the document type name
	 * @return the matching document type master
	 * @throws NoSuchDocumentTypeMasterException if a matching document type master could not be found
	 */
	public static DocumentTypeMaster findByDocumentTypeName(
			String documentTypeName)
		throws com.ax.hrms.master.exception.NoSuchDocumentTypeMasterException {

		return getPersistence().findByDocumentTypeName(documentTypeName);
	}

	/**
	 * Returns the document type master where documentTypeName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param documentTypeName the document type name
	 * @return the matching document type master, or <code>null</code> if a matching document type master could not be found
	 */
	public static DocumentTypeMaster fetchByDocumentTypeName(
		String documentTypeName) {

		return getPersistence().fetchByDocumentTypeName(documentTypeName);
	}

	/**
	 * Returns the document type master where documentTypeName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param documentTypeName the document type name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document type master, or <code>null</code> if a matching document type master could not be found
	 */
	public static DocumentTypeMaster fetchByDocumentTypeName(
		String documentTypeName, boolean useFinderCache) {

		return getPersistence().fetchByDocumentTypeName(
			documentTypeName, useFinderCache);
	}

	/**
	 * Removes the document type master where documentTypeName = &#63; from the database.
	 *
	 * @param documentTypeName the document type name
	 * @return the document type master that was removed
	 */
	public static DocumentTypeMaster removeByDocumentTypeName(
			String documentTypeName)
		throws com.ax.hrms.master.exception.NoSuchDocumentTypeMasterException {

		return getPersistence().removeByDocumentTypeName(documentTypeName);
	}

	/**
	 * Returns the number of document type masters where documentTypeName = &#63;.
	 *
	 * @param documentTypeName the document type name
	 * @return the number of matching document type masters
	 */
	public static int countByDocumentTypeName(String documentTypeName) {
		return getPersistence().countByDocumentTypeName(documentTypeName);
	}

	/**
	 * Caches the document type master in the entity cache if it is enabled.
	 *
	 * @param documentTypeMaster the document type master
	 */
	public static void cacheResult(DocumentTypeMaster documentTypeMaster) {
		getPersistence().cacheResult(documentTypeMaster);
	}

	/**
	 * Caches the document type masters in the entity cache if it is enabled.
	 *
	 * @param documentTypeMasters the document type masters
	 */
	public static void cacheResult(
		List<DocumentTypeMaster> documentTypeMasters) {

		getPersistence().cacheResult(documentTypeMasters);
	}

	/**
	 * Creates a new document type master with the primary key. Does not add the document type master to the database.
	 *
	 * @param documentTypeMasterId the primary key for the new document type master
	 * @return the new document type master
	 */
	public static DocumentTypeMaster create(long documentTypeMasterId) {
		return getPersistence().create(documentTypeMasterId);
	}

	/**
	 * Removes the document type master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentTypeMasterId the primary key of the document type master
	 * @return the document type master that was removed
	 * @throws NoSuchDocumentTypeMasterException if a document type master with the primary key could not be found
	 */
	public static DocumentTypeMaster remove(long documentTypeMasterId)
		throws com.ax.hrms.master.exception.NoSuchDocumentTypeMasterException {

		return getPersistence().remove(documentTypeMasterId);
	}

	public static DocumentTypeMaster updateImpl(
		DocumentTypeMaster documentTypeMaster) {

		return getPersistence().updateImpl(documentTypeMaster);
	}

	/**
	 * Returns the document type master with the primary key or throws a <code>NoSuchDocumentTypeMasterException</code> if it could not be found.
	 *
	 * @param documentTypeMasterId the primary key of the document type master
	 * @return the document type master
	 * @throws NoSuchDocumentTypeMasterException if a document type master with the primary key could not be found
	 */
	public static DocumentTypeMaster findByPrimaryKey(long documentTypeMasterId)
		throws com.ax.hrms.master.exception.NoSuchDocumentTypeMasterException {

		return getPersistence().findByPrimaryKey(documentTypeMasterId);
	}

	/**
	 * Returns the document type master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentTypeMasterId the primary key of the document type master
	 * @return the document type master, or <code>null</code> if a document type master with the primary key could not be found
	 */
	public static DocumentTypeMaster fetchByPrimaryKey(
		long documentTypeMasterId) {

		return getPersistence().fetchByPrimaryKey(documentTypeMasterId);
	}

	/**
	 * Returns all the document type masters.
	 *
	 * @return the document type masters
	 */
	public static List<DocumentTypeMaster> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<DocumentTypeMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<DocumentTypeMaster> findAll(
		int start, int end,
		OrderByComparator<DocumentTypeMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<DocumentTypeMaster> findAll(
		int start, int end,
		OrderByComparator<DocumentTypeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the document type masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of document type masters.
	 *
	 * @return the number of document type masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DocumentTypeMasterPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		DocumentTypeMasterPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile DocumentTypeMasterPersistence _persistence;

}