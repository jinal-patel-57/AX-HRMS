/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.PipProgram;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PipProgram. This utility wraps
 * <code>com.ax.hrms.service.impl.PipProgramLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PipProgramLocalService
 * @generated
 */
public class PipProgramLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.PipProgramLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the pip program to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PipProgramLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pipProgram the pip program
	 * @return the pip program that was added
	 */
	public static PipProgram addPipProgram(PipProgram pipProgram) {
		return getService().addPipProgram(pipProgram);
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
	 * Creates a new pip program with the primary key. Does not add the pip program to the database.
	 *
	 * @param pipProgramId the primary key for the new pip program
	 * @return the new pip program
	 */
	public static PipProgram createPipProgram(long pipProgramId) {
		return getService().createPipProgram(pipProgramId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the pip program with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PipProgramLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pipProgramId the primary key of the pip program
	 * @return the pip program that was removed
	 * @throws PortalException if a pip program with the primary key could not be found
	 */
	public static PipProgram deletePipProgram(long pipProgramId)
		throws PortalException {

		return getService().deletePipProgram(pipProgramId);
	}

	/**
	 * Deletes the pip program from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PipProgramLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pipProgram the pip program
	 * @return the pip program that was removed
	 */
	public static PipProgram deletePipProgram(PipProgram pipProgram) {
		return getService().deletePipProgram(pipProgram);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.PipProgramModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.PipProgramModelImpl</code>.
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

	public static PipProgram fetchPipProgram(long pipProgramId) {
		return getService().fetchPipProgram(pipProgramId);
	}

	/**
	 * Returns the pip program matching the UUID and group.
	 *
	 * @param uuid the pip program's UUID
	 * @param groupId the primary key of the group
	 * @return the matching pip program, or <code>null</code> if a matching pip program could not be found
	 */
	public static PipProgram fetchPipProgramByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchPipProgramByUuidAndGroupId(uuid, groupId);
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
	 * Returns the pip program with the primary key.
	 *
	 * @param pipProgramId the primary key of the pip program
	 * @return the pip program
	 * @throws PortalException if a pip program with the primary key could not be found
	 */
	public static PipProgram getPipProgram(long pipProgramId)
		throws PortalException {

		return getService().getPipProgram(pipProgramId);
	}

	/**
	 * Returns the pip program matching the UUID and group.
	 *
	 * @param uuid the pip program's UUID
	 * @param groupId the primary key of the group
	 * @return the matching pip program
	 * @throws PortalException if a matching pip program could not be found
	 */
	public static PipProgram getPipProgramByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getPipProgramByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the pip programs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.PipProgramModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @return the range of pip programs
	 */
	public static List<PipProgram> getPipPrograms(int start, int end) {
		return getService().getPipPrograms(start, end);
	}

	/**
	 * Returns all the pip programs matching the UUID and company.
	 *
	 * @param uuid the UUID of the pip programs
	 * @param companyId the primary key of the company
	 * @return the matching pip programs, or an empty list if no matches were found
	 */
	public static List<PipProgram> getPipProgramsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getPipProgramsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of pip programs matching the UUID and company.
	 *
	 * @param uuid the UUID of the pip programs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of pip programs
	 * @param end the upper bound of the range of pip programs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching pip programs, or an empty list if no matches were found
	 */
	public static List<PipProgram> getPipProgramsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PipProgram> orderByComparator) {

		return getService().getPipProgramsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of pip programs.
	 *
	 * @return the number of pip programs
	 */
	public static int getPipProgramsCount() {
		return getService().getPipProgramsCount();
	}

	/**
	 * Updates the pip program in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PipProgramLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pipProgram the pip program
	 * @return the pip program that was updated
	 */
	public static PipProgram updatePipProgram(PipProgram pipProgram) {
		return getService().updatePipProgram(pipProgram);
	}

	public static PipProgramLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<PipProgramLocalService> _serviceSnapshot =
		new Snapshot<>(
			PipProgramLocalServiceUtil.class, PipProgramLocalService.class);

}