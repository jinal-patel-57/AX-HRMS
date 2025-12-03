/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link CompensatoryDataLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CompensatoryDataLocalService
 * @generated
 */
public class CompensatoryDataLocalServiceWrapper
	implements CompensatoryDataLocalService,
			   ServiceWrapper<CompensatoryDataLocalService> {

	public CompensatoryDataLocalServiceWrapper() {
		this(null);
	}

	public CompensatoryDataLocalServiceWrapper(
		CompensatoryDataLocalService compensatoryDataLocalService) {

		_compensatoryDataLocalService = compensatoryDataLocalService;
	}

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
	@Override
	public com.ax.hrms.model.CompensatoryData addCompensatoryData(
		com.ax.hrms.model.CompensatoryData compensatoryData) {

		return _compensatoryDataLocalService.addCompensatoryData(
			compensatoryData);
	}

	/**
	 * Creates a new compensatory data with the primary key. Does not add the compensatory data to the database.
	 *
	 * @param compensatoryDataId the primary key for the new compensatory data
	 * @return the new compensatory data
	 */
	@Override
	public com.ax.hrms.model.CompensatoryData createCompensatoryData(
		long compensatoryDataId) {

		return _compensatoryDataLocalService.createCompensatoryData(
			compensatoryDataId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _compensatoryDataLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.ax.hrms.model.CompensatoryData deleteCompensatoryData(
		com.ax.hrms.model.CompensatoryData compensatoryData) {

		return _compensatoryDataLocalService.deleteCompensatoryData(
			compensatoryData);
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
	@Override
	public com.ax.hrms.model.CompensatoryData deleteCompensatoryData(
			long compensatoryDataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _compensatoryDataLocalService.deleteCompensatoryData(
			compensatoryDataId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _compensatoryDataLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _compensatoryDataLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _compensatoryDataLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _compensatoryDataLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _compensatoryDataLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _compensatoryDataLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _compensatoryDataLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _compensatoryDataLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _compensatoryDataLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.CompensatoryData fetchCompensatoryData(
		long compensatoryDataId) {

		return _compensatoryDataLocalService.fetchCompensatoryData(
			compensatoryDataId);
	}

	/**
	 * Returns the compensatory data matching the UUID and group.
	 *
	 * @param uuid the compensatory data's UUID
	 * @param groupId the primary key of the group
	 * @return the matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	@Override
	public com.ax.hrms.model.CompensatoryData
		fetchCompensatoryDataByUuidAndGroupId(String uuid, long groupId) {

		return _compensatoryDataLocalService.
			fetchCompensatoryDataByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.CompensatoryData> findByEmployeeId(
		long employeeId) {

		return _compensatoryDataLocalService.findByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.ax.hrms.model.CompensatoryData> findByManagerId(
		long managerId) {

		return _compensatoryDataLocalService.findByManagerId(managerId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _compensatoryDataLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the compensatory data with the primary key.
	 *
	 * @param compensatoryDataId the primary key of the compensatory data
	 * @return the compensatory data
	 * @throws PortalException if a compensatory data with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.CompensatoryData getCompensatoryData(
			long compensatoryDataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _compensatoryDataLocalService.getCompensatoryData(
			compensatoryDataId);
	}

	/**
	 * Returns the compensatory data matching the UUID and group.
	 *
	 * @param uuid the compensatory data's UUID
	 * @param groupId the primary key of the group
	 * @return the matching compensatory data
	 * @throws PortalException if a matching compensatory data could not be found
	 */
	@Override
	public com.ax.hrms.model.CompensatoryData
			getCompensatoryDataByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _compensatoryDataLocalService.
			getCompensatoryDataByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.ax.hrms.model.CompensatoryData>
		getCompensatoryDatas(int start, int end) {

		return _compensatoryDataLocalService.getCompensatoryDatas(start, end);
	}

	/**
	 * Returns all the compensatory datas matching the UUID and company.
	 *
	 * @param uuid the UUID of the compensatory datas
	 * @param companyId the primary key of the company
	 * @return the matching compensatory datas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.CompensatoryData>
		getCompensatoryDatasByUuidAndCompanyId(String uuid, long companyId) {

		return _compensatoryDataLocalService.
			getCompensatoryDatasByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.ax.hrms.model.CompensatoryData>
		getCompensatoryDatasByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.CompensatoryData> orderByComparator) {

		return _compensatoryDataLocalService.
			getCompensatoryDatasByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of compensatory datas.
	 *
	 * @return the number of compensatory datas
	 */
	@Override
	public int getCompensatoryDatasCount() {
		return _compensatoryDataLocalService.getCompensatoryDatasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _compensatoryDataLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _compensatoryDataLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _compensatoryDataLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _compensatoryDataLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.ax.hrms.model.CompensatoryData updateCompensatoryData(
		com.ax.hrms.model.CompensatoryData compensatoryData) {

		return _compensatoryDataLocalService.updateCompensatoryData(
			compensatoryData);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _compensatoryDataLocalService.getBasePersistence();
	}

	@Override
	public CompensatoryDataLocalService getWrappedService() {
		return _compensatoryDataLocalService;
	}

	@Override
	public void setWrappedService(
		CompensatoryDataLocalService compensatoryDataLocalService) {

		_compensatoryDataLocalService = compensatoryDataLocalService;
	}

	private CompensatoryDataLocalService _compensatoryDataLocalService;

}