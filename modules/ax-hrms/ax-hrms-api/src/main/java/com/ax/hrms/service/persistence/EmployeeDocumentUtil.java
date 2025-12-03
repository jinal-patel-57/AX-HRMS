/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.EmployeeDocument;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the employee document service. This utility wraps <code>com.ax.hrms.service.persistence.impl.EmployeeDocumentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDocumentPersistence
 * @generated
 */
public class EmployeeDocumentUtil {

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
	public static void clearCache(EmployeeDocument employeeDocument) {
		getPersistence().clearCache(employeeDocument);
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
	public static Map<Serializable, EmployeeDocument> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeDocument> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeDocument update(EmployeeDocument employeeDocument) {
		return getPersistence().update(employeeDocument);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeDocument update(
		EmployeeDocument employeeDocument, ServiceContext serviceContext) {

		return getPersistence().update(employeeDocument, serviceContext);
	}

	/**
	 * Returns all the employee documents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee documents
	 */
	public static List<EmployeeDocument> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<EmployeeDocument> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<EmployeeDocument> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeDocument> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<EmployeeDocument> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee document
	 * @throws NoSuchEmployeeDocumentException if a matching employee document could not be found
	 */
	public static EmployeeDocument findByUuid_First(
			String uuid, OrderByComparator<EmployeeDocument> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDocumentException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first employee document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	public static EmployeeDocument fetchByUuid_First(
		String uuid, OrderByComparator<EmployeeDocument> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee document
	 * @throws NoSuchEmployeeDocumentException if a matching employee document could not be found
	 */
	public static EmployeeDocument findByUuid_Last(
			String uuid, OrderByComparator<EmployeeDocument> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDocumentException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	public static EmployeeDocument fetchByUuid_Last(
		String uuid, OrderByComparator<EmployeeDocument> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the employee documents before and after the current employee document in the ordered set where uuid = &#63;.
	 *
	 * @param documentId the primary key of the current employee document
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee document
	 * @throws NoSuchEmployeeDocumentException if a employee document with the primary key could not be found
	 */
	public static EmployeeDocument[] findByUuid_PrevAndNext(
			long documentId, String uuid,
			OrderByComparator<EmployeeDocument> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDocumentException {

		return getPersistence().findByUuid_PrevAndNext(
			documentId, uuid, orderByComparator);
	}

	/**
	 * Removes all the employee documents where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of employee documents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee documents
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the employee document where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeDocumentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee document
	 * @throws NoSuchEmployeeDocumentException if a matching employee document could not be found
	 */
	public static EmployeeDocument findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeDocumentException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee document where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	public static EmployeeDocument fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee document where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	public static EmployeeDocument fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the employee document where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee document that was removed
	 */
	public static EmployeeDocument removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchEmployeeDocumentException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of employee documents where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee documents
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the employee documents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee documents
	 */
	public static List<EmployeeDocument> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<EmployeeDocument> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<EmployeeDocument> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeDocument> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<EmployeeDocument> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee document
	 * @throws NoSuchEmployeeDocumentException if a matching employee document could not be found
	 */
	public static EmployeeDocument findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeDocument> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDocumentException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first employee document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	public static EmployeeDocument fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeDocument> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee document
	 * @throws NoSuchEmployeeDocumentException if a matching employee document could not be found
	 */
	public static EmployeeDocument findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeDocument> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDocumentException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee document, or <code>null</code> if a matching employee document could not be found
	 */
	public static EmployeeDocument fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeDocument> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static EmployeeDocument[] findByUuid_C_PrevAndNext(
			long documentId, String uuid, long companyId,
			OrderByComparator<EmployeeDocument> orderByComparator)
		throws com.ax.hrms.exception.NoSuchEmployeeDocumentException {

		return getPersistence().findByUuid_C_PrevAndNext(
			documentId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the employee documents where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of employee documents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee documents
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the employee document in the entity cache if it is enabled.
	 *
	 * @param employeeDocument the employee document
	 */
	public static void cacheResult(EmployeeDocument employeeDocument) {
		getPersistence().cacheResult(employeeDocument);
	}

	/**
	 * Caches the employee documents in the entity cache if it is enabled.
	 *
	 * @param employeeDocuments the employee documents
	 */
	public static void cacheResult(List<EmployeeDocument> employeeDocuments) {
		getPersistence().cacheResult(employeeDocuments);
	}

	/**
	 * Creates a new employee document with the primary key. Does not add the employee document to the database.
	 *
	 * @param documentId the primary key for the new employee document
	 * @return the new employee document
	 */
	public static EmployeeDocument create(long documentId) {
		return getPersistence().create(documentId);
	}

	/**
	 * Removes the employee document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentId the primary key of the employee document
	 * @return the employee document that was removed
	 * @throws NoSuchEmployeeDocumentException if a employee document with the primary key could not be found
	 */
	public static EmployeeDocument remove(long documentId)
		throws com.ax.hrms.exception.NoSuchEmployeeDocumentException {

		return getPersistence().remove(documentId);
	}

	public static EmployeeDocument updateImpl(
		EmployeeDocument employeeDocument) {

		return getPersistence().updateImpl(employeeDocument);
	}

	/**
	 * Returns the employee document with the primary key or throws a <code>NoSuchEmployeeDocumentException</code> if it could not be found.
	 *
	 * @param documentId the primary key of the employee document
	 * @return the employee document
	 * @throws NoSuchEmployeeDocumentException if a employee document with the primary key could not be found
	 */
	public static EmployeeDocument findByPrimaryKey(long documentId)
		throws com.ax.hrms.exception.NoSuchEmployeeDocumentException {

		return getPersistence().findByPrimaryKey(documentId);
	}

	/**
	 * Returns the employee document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentId the primary key of the employee document
	 * @return the employee document, or <code>null</code> if a employee document with the primary key could not be found
	 */
	public static EmployeeDocument fetchByPrimaryKey(long documentId) {
		return getPersistence().fetchByPrimaryKey(documentId);
	}

	/**
	 * Returns all the employee documents.
	 *
	 * @return the employee documents
	 */
	public static List<EmployeeDocument> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<EmployeeDocument> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<EmployeeDocument> findAll(
		int start, int end,
		OrderByComparator<EmployeeDocument> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<EmployeeDocument> findAll(
		int start, int end,
		OrderByComparator<EmployeeDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee documents from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee documents.
	 *
	 * @return the number of employee documents
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeDocumentPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(EmployeeDocumentPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile EmployeeDocumentPersistence _persistence;

}