/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ExtendedProbationDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ExtendedProbationDetailsLocalService
 * @generated
 */
public class ExtendedProbationDetailsLocalServiceWrapper
	implements ExtendedProbationDetailsLocalService,
			   ServiceWrapper<ExtendedProbationDetailsLocalService> {

	public ExtendedProbationDetailsLocalServiceWrapper() {
		this(null);
	}

	public ExtendedProbationDetailsLocalServiceWrapper(
		ExtendedProbationDetailsLocalService
			extendedProbationDetailsLocalService) {

		_extendedProbationDetailsLocalService =
			extendedProbationDetailsLocalService;
	}

	/**
	 * Adds the extended probation details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExtendedProbationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param extendedProbationDetails the extended probation details
	 * @return the extended probation details that was added
	 */
	@Override
	public com.ax.hrms.model.ExtendedProbationDetails
		addExtendedProbationDetails(
			com.ax.hrms.model.ExtendedProbationDetails
				extendedProbationDetails) {

		return _extendedProbationDetailsLocalService.
			addExtendedProbationDetails(extendedProbationDetails);
	}

	/**
	 * Creates a new extended probation details with the primary key. Does not add the extended probation details to the database.
	 *
	 * @param extendedProbationDetailsId the primary key for the new extended probation details
	 * @return the new extended probation details
	 */
	@Override
	public com.ax.hrms.model.ExtendedProbationDetails
		createExtendedProbationDetails(long extendedProbationDetailsId) {

		return _extendedProbationDetailsLocalService.
			createExtendedProbationDetails(extendedProbationDetailsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _extendedProbationDetailsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the extended probation details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExtendedProbationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param extendedProbationDetails the extended probation details
	 * @return the extended probation details that was removed
	 */
	@Override
	public com.ax.hrms.model.ExtendedProbationDetails
		deleteExtendedProbationDetails(
			com.ax.hrms.model.ExtendedProbationDetails
				extendedProbationDetails) {

		return _extendedProbationDetailsLocalService.
			deleteExtendedProbationDetails(extendedProbationDetails);
	}

	/**
	 * Deletes the extended probation details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExtendedProbationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param extendedProbationDetailsId the primary key of the extended probation details
	 * @return the extended probation details that was removed
	 * @throws PortalException if a extended probation details with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.ExtendedProbationDetails
			deleteExtendedProbationDetails(long extendedProbationDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _extendedProbationDetailsLocalService.
			deleteExtendedProbationDetails(extendedProbationDetailsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _extendedProbationDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _extendedProbationDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _extendedProbationDetailsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _extendedProbationDetailsLocalService.dynamicQuery();
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

		return _extendedProbationDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.ExtendedProbationDetailsModelImpl</code>.
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

		return _extendedProbationDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.ExtendedProbationDetailsModelImpl</code>.
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

		return _extendedProbationDetailsLocalService.dynamicQuery(
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

		return _extendedProbationDetailsLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _extendedProbationDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.ExtendedProbationDetails
		fetchExtendedProbationDetails(long extendedProbationDetailsId) {

		return _extendedProbationDetailsLocalService.
			fetchExtendedProbationDetails(extendedProbationDetailsId);
	}

	/**
	 * Returns the extended probation details matching the UUID and group.
	 *
	 * @param uuid the extended probation details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching extended probation details, or <code>null</code> if a matching extended probation details could not be found
	 */
	@Override
	public com.ax.hrms.model.ExtendedProbationDetails
		fetchExtendedProbationDetailsByUuidAndGroupId(
			String uuid, long groupId) {

		return _extendedProbationDetailsLocalService.
			fetchExtendedProbationDetailsByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _extendedProbationDetailsLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _extendedProbationDetailsLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns the extended probation details with the primary key.
	 *
	 * @param extendedProbationDetailsId the primary key of the extended probation details
	 * @return the extended probation details
	 * @throws PortalException if a extended probation details with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.ExtendedProbationDetails
			getExtendedProbationDetails(long extendedProbationDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _extendedProbationDetailsLocalService.
			getExtendedProbationDetails(extendedProbationDetailsId);
	}

	/**
	 * Returns the extended probation details matching the UUID and group.
	 *
	 * @param uuid the extended probation details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching extended probation details
	 * @throws PortalException if a matching extended probation details could not be found
	 */
	@Override
	public com.ax.hrms.model.ExtendedProbationDetails
			getExtendedProbationDetailsByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _extendedProbationDetailsLocalService.
			getExtendedProbationDetailsByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the extended probation detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.ExtendedProbationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of extended probation detailses
	 * @param end the upper bound of the range of extended probation detailses (not inclusive)
	 * @return the range of extended probation detailses
	 */
	@Override
	public java.util.List<com.ax.hrms.model.ExtendedProbationDetails>
		getExtendedProbationDetailses(int start, int end) {

		return _extendedProbationDetailsLocalService.
			getExtendedProbationDetailses(start, end);
	}

	/**
	 * Returns all the extended probation detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the extended probation detailses
	 * @param companyId the primary key of the company
	 * @return the matching extended probation detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.ExtendedProbationDetails>
		getExtendedProbationDetailsesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _extendedProbationDetailsLocalService.
			getExtendedProbationDetailsesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of extended probation detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the extended probation detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of extended probation detailses
	 * @param end the upper bound of the range of extended probation detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching extended probation detailses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.ExtendedProbationDetails>
		getExtendedProbationDetailsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.ExtendedProbationDetails>
					orderByComparator) {

		return _extendedProbationDetailsLocalService.
			getExtendedProbationDetailsesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of extended probation detailses.
	 *
	 * @return the number of extended probation detailses
	 */
	@Override
	public int getExtendedProbationDetailsesCount() {
		return _extendedProbationDetailsLocalService.
			getExtendedProbationDetailsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _extendedProbationDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _extendedProbationDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _extendedProbationDetailsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the extended probation details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExtendedProbationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param extendedProbationDetails the extended probation details
	 * @return the extended probation details that was updated
	 */
	@Override
	public com.ax.hrms.model.ExtendedProbationDetails
		updateExtendedProbationDetails(
			com.ax.hrms.model.ExtendedProbationDetails
				extendedProbationDetails) {

		return _extendedProbationDetailsLocalService.
			updateExtendedProbationDetails(extendedProbationDetails);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _extendedProbationDetailsLocalService.getBasePersistence();
	}

	@Override
	public ExtendedProbationDetailsLocalService getWrappedService() {
		return _extendedProbationDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		ExtendedProbationDetailsLocalService
			extendedProbationDetailsLocalService) {

		_extendedProbationDetailsLocalService =
			extendedProbationDetailsLocalService;
	}

	private ExtendedProbationDetailsLocalService
		_extendedProbationDetailsLocalService;

}