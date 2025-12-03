/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.CompensatoryData;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CompensatoryData. This utility wraps
 * <code>com.ax.hrms.service.impl.CompensatoryDataLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CompensatoryDataLocalService
 * @generated
 */
public class CompensatoryDataLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ax.hrms.service.impl.CompensatoryDataLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the compensatory data to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CompensatoryDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param compensatoryData the compensatory data
	 * @return the compensatory data that was added
	 */
	public static CompensatoryData addCompensatoryData(
		CompensatoryData compensatoryData) {

		return getService().addCompensatoryData(compensatoryData);
	}

	/**
	 * Creates a new compensatory data with the primary key. Does not add the compensatory data to the database.
	 *
	 * @param compensatoryDataId the primary key for the new compensatory data
	 * @return the new compensatory data
	 */
	public static CompensatoryData createCompensatoryData(
		long compensatoryDataId) {

		return getService().createCompensatoryData(compensatoryDataId);
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
	 * Deletes the compensatory data from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CompensatoryDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param compensatoryData the compensatory data
	 * @return the compensatory data that was removed
	 */
	public static CompensatoryData deleteCompensatoryData(
		CompensatoryData compensatoryData) {

		return getService().deleteCompensatoryData(compensatoryData);
	}

	/**
	 * Deletes the compensatory data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CompensatoryDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param compensatoryDataId the primary key of the compensatory data
	 * @return the compensatory data that was removed
	 * @throws PortalException if a compensatory data with the primary key could not be found
	 */
	public static CompensatoryData deleteCompensatoryData(
			long compensatoryDataId)
		throws PortalException {

		return getService().deleteCompensatoryData(compensatoryDataId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.CompensatoryDataModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.CompensatoryDataModelImpl</code>.
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

	public static CompensatoryData fetchCompensatoryData(
		long compensatoryDataId) {

		return getService().fetchCompensatoryData(compensatoryDataId);
	}

	/**
	 * Returns the compensatory data matching the UUID and group.
	 *
	 * @param uuid the compensatory data's UUID
	 * @param groupId the primary key of the group
	 * @return the matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	public static CompensatoryData fetchCompensatoryDataByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchCompensatoryDataByUuidAndGroupId(
			uuid, groupId);
	}

	public static List<CompensatoryData> findByEmployeeId(long employeeId) {
		return getService().findByEmployeeId(employeeId);
	}

	public static List<CompensatoryData> findByManagerId(long managerId) {
		return getService().findByManagerId(managerId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the compensatory data with the primary key.
	 *
	 * @param compensatoryDataId the primary key of the compensatory data
	 * @return the compensatory data
	 * @throws PortalException if a compensatory data with the primary key could not be found
	 */
	public static CompensatoryData getCompensatoryData(long compensatoryDataId)
		throws PortalException {

		return getService().getCompensatoryData(compensatoryDataId);
	}

	/**
	 * Returns the compensatory data matching the UUID and group.
	 *
	 * @param uuid the compensatory data's UUID
	 * @param groupId the primary key of the group
	 * @return the matching compensatory data
	 * @throws PortalException if a matching compensatory data could not be found
	 */
	public static CompensatoryData getCompensatoryDataByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getCompensatoryDataByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the compensatory datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.CompensatoryDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @return the range of compensatory datas
	 */
	public static List<CompensatoryData> getCompensatoryDatas(
		int start, int end) {

		return getService().getCompensatoryDatas(start, end);
	}

	/**
	 * Returns all the compensatory datas matching the UUID and company.
	 *
	 * @param uuid the UUID of the compensatory datas
	 * @param companyId the primary key of the company
	 * @return the matching compensatory datas, or an empty list if no matches were found
	 */
	public static List<CompensatoryData> getCompensatoryDatasByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getCompensatoryDatasByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of compensatory datas matching the UUID and company.
	 *
	 * @param uuid the UUID of the compensatory datas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of compensatory datas
	 * @param end the upper bound of the range of compensatory datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching compensatory datas, or an empty list if no matches were found
	 */
	public static List<CompensatoryData> getCompensatoryDatasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CompensatoryData> orderByComparator) {

		return getService().getCompensatoryDatasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of compensatory datas.
	 *
	 * @return the number of compensatory datas
	 */
	public static int getCompensatoryDatasCount() {
		return getService().getCompensatoryDatasCount();
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
	 * Updates the compensatory data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CompensatoryDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param compensatoryData the compensatory data
	 * @return the compensatory data that was updated
	 */
	public static CompensatoryData updateCompensatoryData(
		CompensatoryData compensatoryData) {

		return getService().updateCompensatoryData(compensatoryData);
	}

	public static CompensatoryDataLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<CompensatoryDataLocalService>
		_serviceSnapshot = new Snapshot<>(
			CompensatoryDataLocalServiceUtil.class,
			CompensatoryDataLocalService.class);

}