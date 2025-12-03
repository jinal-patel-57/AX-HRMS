/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service.persistence;

import com.ax.hrms.model.PipProgram;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the pip program service. This utility wraps <code>com.ax.hrms.service.persistence.impl.PipProgramPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PipProgramPersistence
 * @generated
 */
public class PipProgramUtil {

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
	public static void clearCache(PipProgram pipProgram) {
		getPersistence().clearCache(pipProgram);
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
	public static Map<Serializable, PipProgram> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PipProgram> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PipProgram> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PipProgram> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PipProgram> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PipProgram update(PipProgram pipProgram) {
		return getPersistence().update(pipProgram);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PipProgram update(
		PipProgram pipProgram, ServiceContext serviceContext) {

		return getPersistence().update(pipProgram, serviceContext);
	}

	/**
	 * Returns all the pip programs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching pip programs
	 */
	public static List<PipProgram> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the pip programs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @return the range of matching pip programs
	 */
	public static List<PipProgram> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the pip programs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pip programs
	 */
	public static List<PipProgram> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PipProgram> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pip programs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pip programs
	 */
	public static List<PipProgram> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PipProgram> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pip program in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pip program
	 * @throws NoSuchPipProgramException if a matching pip program could not be found
	 */
	public static PipProgram findByUuid_First(
			String uuid, OrderByComparator<PipProgram> orderByComparator)
		throws com.ax.hrms.exception.NoSuchPipProgramException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first pip program in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pip program, or <code>null</code> if a matching pip program could not be found
	 */
	public static PipProgram fetchByUuid_First(
		String uuid, OrderByComparator<PipProgram> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last pip program in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pip program
	 * @throws NoSuchPipProgramException if a matching pip program could not be found
	 */
	public static PipProgram findByUuid_Last(
			String uuid, OrderByComparator<PipProgram> orderByComparator)
		throws com.ax.hrms.exception.NoSuchPipProgramException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last pip program in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pip program, or <code>null</code> if a matching pip program could not be found
	 */
	public static PipProgram fetchByUuid_Last(
		String uuid, OrderByComparator<PipProgram> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the pip programs before and after the current pip program in the ordered set where uuid = &#63;.
	 *
	 * @param pipProgramId the primary key of the current pip program
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pip program
	 * @throws NoSuchPipProgramException if a pip program with the primary key could not be found
	 */
	public static PipProgram[] findByUuid_PrevAndNext(
			long pipProgramId, String uuid,
			OrderByComparator<PipProgram> orderByComparator)
		throws com.ax.hrms.exception.NoSuchPipProgramException {

		return getPersistence().findByUuid_PrevAndNext(
			pipProgramId, uuid, orderByComparator);
	}

	/**
	 * Removes all the pip programs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of pip programs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching pip programs
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the pip program where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPipProgramException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pip program
	 * @throws NoSuchPipProgramException if a matching pip program could not be found
	 */
	public static PipProgram findByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchPipProgramException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the pip program where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pip program, or <code>null</code> if a matching pip program could not be found
	 */
	public static PipProgram fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the pip program where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pip program, or <code>null</code> if a matching pip program could not be found
	 */
	public static PipProgram fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the pip program where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the pip program that was removed
	 */
	public static PipProgram removeByUUID_G(String uuid, long groupId)
		throws com.ax.hrms.exception.NoSuchPipProgramException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of pip programs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching pip programs
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the pip programs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching pip programs
	 */
	public static List<PipProgram> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the pip programs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @return the range of matching pip programs
	 */
	public static List<PipProgram> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the pip programs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pip programs
	 */
	public static List<PipProgram> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PipProgram> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pip programs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pip programs
	 */
	public static List<PipProgram> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PipProgram> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pip program in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pip program
	 * @throws NoSuchPipProgramException if a matching pip program could not be found
	 */
	public static PipProgram findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PipProgram> orderByComparator)
		throws com.ax.hrms.exception.NoSuchPipProgramException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first pip program in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pip program, or <code>null</code> if a matching pip program could not be found
	 */
	public static PipProgram fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PipProgram> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last pip program in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pip program
	 * @throws NoSuchPipProgramException if a matching pip program could not be found
	 */
	public static PipProgram findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PipProgram> orderByComparator)
		throws com.ax.hrms.exception.NoSuchPipProgramException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last pip program in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pip program, or <code>null</code> if a matching pip program could not be found
	 */
	public static PipProgram fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PipProgram> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the pip programs before and after the current pip program in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param pipProgramId the primary key of the current pip program
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pip program
	 * @throws NoSuchPipProgramException if a pip program with the primary key could not be found
	 */
	public static PipProgram[] findByUuid_C_PrevAndNext(
			long pipProgramId, String uuid, long companyId,
			OrderByComparator<PipProgram> orderByComparator)
		throws com.ax.hrms.exception.NoSuchPipProgramException {

		return getPersistence().findByUuid_C_PrevAndNext(
			pipProgramId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the pip programs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of pip programs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching pip programs
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the pip program in the entity cache if it is enabled.
	 *
	 * @param pipProgram the pip program
	 */
	public static void cacheResult(PipProgram pipProgram) {
		getPersistence().cacheResult(pipProgram);
	}

	/**
	 * Caches the pip programs in the entity cache if it is enabled.
	 *
	 * @param pipPrograms the pip programs
	 */
	public static void cacheResult(List<PipProgram> pipPrograms) {
		getPersistence().cacheResult(pipPrograms);
	}

	/**
	 * Creates a new pip program with the primary key. Does not add the pip program to the database.
	 *
	 * @param pipProgramId the primary key for the new pip program
	 * @return the new pip program
	 */
	public static PipProgram create(long pipProgramId) {
		return getPersistence().create(pipProgramId);
	}

	/**
	 * Removes the pip program with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pipProgramId the primary key of the pip program
	 * @return the pip program that was removed
	 * @throws NoSuchPipProgramException if a pip program with the primary key could not be found
	 */
	public static PipProgram remove(long pipProgramId)
		throws com.ax.hrms.exception.NoSuchPipProgramException {

		return getPersistence().remove(pipProgramId);
	}

	public static PipProgram updateImpl(PipProgram pipProgram) {
		return getPersistence().updateImpl(pipProgram);
	}

	/**
	 * Returns the pip program with the primary key or throws a <code>NoSuchPipProgramException</code> if it could not be found.
	 *
	 * @param pipProgramId the primary key of the pip program
	 * @return the pip program
	 * @throws NoSuchPipProgramException if a pip program with the primary key could not be found
	 */
	public static PipProgram findByPrimaryKey(long pipProgramId)
		throws com.ax.hrms.exception.NoSuchPipProgramException {

		return getPersistence().findByPrimaryKey(pipProgramId);
	}

	/**
	 * Returns the pip program with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pipProgramId the primary key of the pip program
	 * @return the pip program, or <code>null</code> if a pip program with the primary key could not be found
	 */
	public static PipProgram fetchByPrimaryKey(long pipProgramId) {
		return getPersistence().fetchByPrimaryKey(pipProgramId);
	}

	/**
	 * Returns all the pip programs.
	 *
	 * @return the pip programs
	 */
	public static List<PipProgram> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the pip programs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @return the range of pip programs
	 */
	public static List<PipProgram> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the pip programs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pip programs
	 */
	public static List<PipProgram> findAll(
		int start, int end, OrderByComparator<PipProgram> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pip programs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pip programs
	 */
	public static List<PipProgram> findAll(
		int start, int end, OrderByComparator<PipProgram> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the pip programs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of pip programs.
	 *
	 * @return the number of pip programs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PipProgramPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(PipProgramPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile PipProgramPersistence _persistence;

}