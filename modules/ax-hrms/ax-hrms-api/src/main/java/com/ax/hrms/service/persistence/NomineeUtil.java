/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.Nominee;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the nominee service. This utility wraps <code>com.ax.hrms.service.persistence.impl.NomineePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NomineePersistence
 * @generated
 */
public class NomineeUtil {

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
	public static void clearCache(Nominee nominee) {
		getPersistence().clearCache(nominee);
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
	public static Map<Serializable, Nominee> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Nominee> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Nominee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Nominee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Nominee> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Nominee update(Nominee nominee) {
		return getPersistence().update(nominee);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Nominee update(
		Nominee nominee, ServiceContext serviceContext) {

		return getPersistence().update(nominee, serviceContext);
	}

	/**
	 * Returns all the nominees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching nominees
	 */
	public static List<Nominee> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the nominees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NomineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of nominees
	 * @param end the upper bound of the range of nominees (not inclusive)
	 * @return the range of matching nominees
	 */
	public static List<Nominee> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the nominees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NomineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of nominees
	 * @param end the upper bound of the range of nominees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching nominees
	 */
	public static List<Nominee> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Nominee> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the nominees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NomineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of nominees
	 * @param end the upper bound of the range of nominees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching nominees
	 */
	public static List<Nominee> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Nominee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first nominee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching nominee
	 * @throws NoSuchNomineeException if a matching nominee could not be found
	 */
	public static Nominee findByUuid_First(
			String uuid, OrderByComparator<Nominee> orderByComparator)
		throws com.ax.hrms.exception.NoSuchNomineeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first nominee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching nominee, or <code>null</code> if a matching nominee could not be found
	 */
	public static Nominee fetchByUuid_First(
		String uuid, OrderByComparator<Nominee> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last nominee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching nominee
	 * @throws NoSuchNomineeException if a matching nominee could not be found
	 */
	public static Nominee findByUuid_Last(
			String uuid, OrderByComparator<Nominee> orderByComparator)
		throws com.ax.hrms.exception.NoSuchNomineeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last nominee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching nominee, or <code>null</code> if a matching nominee could not be found
	 */
	public static Nominee fetchByUuid_Last(
		String uuid, OrderByComparator<Nominee> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the nominees before and after the current nominee in the ordered set where uuid = &#63;.
	 *
	 * @param nomineeId the primary key of the current nominee
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next nominee
	 * @throws NoSuchNomineeException if a nominee with the primary key could not be found
	 */
	public static Nominee[] findByUuid_PrevAndNext(
			long nomineeId, String uuid,
			OrderByComparator<Nominee> orderByComparator)
		throws com.ax.hrms.exception.NoSuchNomineeException {

		return getPersistence().findByUuid_PrevAndNext(
			nomineeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the nominees where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of nominees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching nominees
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the nominee where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchNomineeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching nominee
	 * @throws NoSuchNomineeException if a matching nominee could not be found
	 */
	public static Nominee findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchNomineeException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the nominee where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching nominee, or <code>null</code> if a matching nominee could not be found
	 */
	public static Nominee fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the nominee where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching nominee, or <code>null</code> if a matching nominee could not be found
	 */
	public static Nominee fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the nominee where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the nominee that was removed
	 */
	public static Nominee removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchNomineeException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of nominees where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching nominees
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the nominees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching nominees
	 */
	public static List<Nominee> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the nominees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NomineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of nominees
	 * @param end the upper bound of the range of nominees (not inclusive)
	 * @return the range of matching nominees
	 */
	public static List<Nominee> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the nominees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NomineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of nominees
	 * @param end the upper bound of the range of nominees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching nominees
	 */
	public static List<Nominee> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Nominee> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the nominees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NomineeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of nominees
	 * @param end the upper bound of the range of nominees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching nominees
	 */
	public static List<Nominee> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Nominee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first nominee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching nominee
	 * @throws NoSuchNomineeException if a matching nominee could not be found
	 */
	public static Nominee findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Nominee> orderByComparator)
		throws com.ax.hrms.exception.NoSuchNomineeException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first nominee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching nominee, or <code>null</code> if a matching nominee could not be found
	 */
	public static Nominee fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Nominee> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last nominee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching nominee
	 * @throws NoSuchNomineeException if a matching nominee could not be found
	 */
	public static Nominee findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Nominee> orderByComparator)
		throws com.ax.hrms.exception.NoSuchNomineeException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last nominee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching nominee, or <code>null</code> if a matching nominee could not be found
	 */
	public static Nominee fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Nominee> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the nominees before and after the current nominee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param nomineeId the primary key of the current nominee
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next nominee
	 * @throws NoSuchNomineeException if a nominee with the primary key could not be found
	 */
	public static Nominee[] findByUuid_C_PrevAndNext(
			long nomineeId, String uuid, long companyId,
			OrderByComparator<Nominee> orderByComparator)
		throws com.ax.hrms.exception.NoSuchNomineeException {

		return getPersistence().findByUuid_C_PrevAndNext(
			nomineeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the nominees where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of nominees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching nominees
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the nominee in the entity cache if it is enabled.
	 *
	 * @param nominee the nominee
	 */
	public static void cacheResult(Nominee nominee) {
		getPersistence().cacheResult(nominee);
	}

	/**
	 * Caches the nominees in the entity cache if it is enabled.
	 *
	 * @param nominees the nominees
	 */
	public static void cacheResult(List<Nominee> nominees) {
		getPersistence().cacheResult(nominees);
	}

	/**
	 * Creates a new nominee with the primary key. Does not add the nominee to the database.
	 *
	 * @param nomineeId the primary key for the new nominee
	 * @return the new nominee
	 */
	public static Nominee create(long nomineeId) {
		return getPersistence().create(nomineeId);
	}

	/**
	 * Removes the nominee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param nomineeId the primary key of the nominee
	 * @return the nominee that was removed
	 * @throws NoSuchNomineeException if a nominee with the primary key could not be found
	 */
	public static Nominee remove(long nomineeId)
		throws com.ax.hrms.exception.NoSuchNomineeException {

		return getPersistence().remove(nomineeId);
	}

	public static Nominee updateImpl(Nominee nominee) {
		return getPersistence().updateImpl(nominee);
	}

	/**
	 * Returns the nominee with the primary key or throws a <code>NoSuchNomineeException</code> if it could not be found.
	 *
	 * @param nomineeId the primary key of the nominee
	 * @return the nominee
	 * @throws NoSuchNomineeException if a nominee with the primary key could not be found
	 */
	public static Nominee findByPrimaryKey(long nomineeId)
		throws com.ax.hrms.exception.NoSuchNomineeException {

		return getPersistence().findByPrimaryKey(nomineeId);
	}

	/**
	 * Returns the nominee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param nomineeId the primary key of the nominee
	 * @return the nominee, or <code>null</code> if a nominee with the primary key could not be found
	 */
	public static Nominee fetchByPrimaryKey(long nomineeId) {
		return getPersistence().fetchByPrimaryKey(nomineeId);
	}

	/**
	 * Returns all the nominees.
	 *
	 * @return the nominees
	 */
	public static List<Nominee> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the nominees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NomineeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nominees
	 * @param end the upper bound of the range of nominees (not inclusive)
	 * @return the range of nominees
	 */
	public static List<Nominee> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the nominees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NomineeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nominees
	 * @param end the upper bound of the range of nominees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of nominees
	 */
	public static List<Nominee> findAll(
		int start, int end, OrderByComparator<Nominee> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the nominees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NomineeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nominees
	 * @param end the upper bound of the range of nominees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of nominees
	 */
	public static List<Nominee> findAll(
		int start, int end, OrderByComparator<Nominee> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the nominees from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of nominees.
	 *
	 * @return the number of nominees
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static NomineePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(NomineePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile NomineePersistence _persistence;

}