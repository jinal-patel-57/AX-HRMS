/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.Nominee;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Nominee. This utility wraps
 * <code>com.ax.hrms.service.impl.NomineeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see NomineeLocalService
 * @generated
 */
public class NomineeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.NomineeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the nominee to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NomineeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param nominee the nominee
	 * @return the nominee that was added
	 */
	public static Nominee addNominee(Nominee nominee) {
		return getService().addNominee(nominee);
	}

	/**
	 * Creates a new nominee with the primary key. Does not add the nominee to the database.
	 *
	 * @param nomineeId the primary key for the new nominee
	 * @return the new nominee
	 */
	public static Nominee createNominee(long nomineeId) {
		return getService().createNominee(nomineeId);
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
	 * Deletes the nominee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NomineeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param nomineeId the primary key of the nominee
	 * @return the nominee that was removed
	 * @throws PortalException if a nominee with the primary key could not be found
	 */
	public static Nominee deleteNominee(long nomineeId) throws PortalException {
		return getService().deleteNominee(nomineeId);
	}

	/**
	 * Deletes the nominee from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NomineeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param nominee the nominee
	 * @return the nominee that was removed
	 */
	public static Nominee deleteNominee(Nominee nominee) {
		return getService().deleteNominee(nominee);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.NomineeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.NomineeModelImpl</code>.
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

	public static Nominee fetchNominee(long nomineeId) {
		return getService().fetchNominee(nomineeId);
	}

	/**
	 * Returns the nominee matching the UUID and group.
	 *
	 * @param uuid the nominee's UUID
	 * @param groupId the primary key of the group
	 * @return the matching nominee, or <code>null</code> if a matching nominee could not be found
	 */
	public static Nominee fetchNomineeByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchNomineeByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the nominee with the primary key.
	 *
	 * @param nomineeId the primary key of the nominee
	 * @return the nominee
	 * @throws PortalException if a nominee with the primary key could not be found
	 */
	public static Nominee getNominee(long nomineeId) throws PortalException {
		return getService().getNominee(nomineeId);
	}

	/**
	 * Returns the nominee matching the UUID and group.
	 *
	 * @param uuid the nominee's UUID
	 * @param groupId the primary key of the group
	 * @return the matching nominee
	 * @throws PortalException if a matching nominee could not be found
	 */
	public static Nominee getNomineeByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getNomineeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the nominees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.NomineeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nominees
	 * @param end the upper bound of the range of nominees (not inclusive)
	 * @return the range of nominees
	 */
	public static List<Nominee> getNominees(int start, int end) {
		return getService().getNominees(start, end);
	}

	/**
	 * Returns all the nominees matching the UUID and company.
	 *
	 * @param uuid the UUID of the nominees
	 * @param companyId the primary key of the company
	 * @return the matching nominees, or an empty list if no matches were found
	 */
	public static List<Nominee> getNomineesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getNomineesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of nominees matching the UUID and company.
	 *
	 * @param uuid the UUID of the nominees
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of nominees
	 * @param end the upper bound of the range of nominees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching nominees, or an empty list if no matches were found
	 */
	public static List<Nominee> getNomineesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Nominee> orderByComparator) {

		return getService().getNomineesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of nominees.
	 *
	 * @return the number of nominees
	 */
	public static int getNomineesCount() {
		return getService().getNomineesCount();
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
	 * Updates the nominee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NomineeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param nominee the nominee
	 * @return the nominee that was updated
	 */
	public static Nominee updateNominee(Nominee nominee) {
		return getService().updateNominee(nominee);
	}

	public static NomineeLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<NomineeLocalService> _serviceSnapshot =
		new Snapshot<>(
			NomineeLocalServiceUtil.class, NomineeLocalService.class);

}