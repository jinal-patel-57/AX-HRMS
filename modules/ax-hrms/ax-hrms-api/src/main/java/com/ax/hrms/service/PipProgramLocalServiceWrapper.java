/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link PipProgramLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PipProgramLocalService
 * @generated
 */
public class PipProgramLocalServiceWrapper
	implements PipProgramLocalService, ServiceWrapper<PipProgramLocalService> {

	public PipProgramLocalServiceWrapper() {
		this(null);
	}

	public PipProgramLocalServiceWrapper(
		PipProgramLocalService pipProgramLocalService) {

		_pipProgramLocalService = pipProgramLocalService;
	}

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
	@Override
	public com.ax.hrms.model.PipProgram addPipProgram(
		com.ax.hrms.model.PipProgram pipProgram) {

		return _pipProgramLocalService.addPipProgram(pipProgram);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pipProgramLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new pip program with the primary key. Does not add the pip program to the database.
	 *
	 * @param pipProgramId the primary key for the new pip program
	 * @return the new pip program
	 */
	@Override
	public com.ax.hrms.model.PipProgram createPipProgram(long pipProgramId) {
		return _pipProgramLocalService.createPipProgram(pipProgramId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pipProgramLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.ax.hrms.model.PipProgram deletePipProgram(long pipProgramId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pipProgramLocalService.deletePipProgram(pipProgramId);
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
	@Override
	public com.ax.hrms.model.PipProgram deletePipProgram(
		com.ax.hrms.model.PipProgram pipProgram) {

		return _pipProgramLocalService.deletePipProgram(pipProgram);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _pipProgramLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _pipProgramLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _pipProgramLocalService.dynamicQuery();
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

		return _pipProgramLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _pipProgramLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _pipProgramLocalService.dynamicQuery(
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

		return _pipProgramLocalService.dynamicQueryCount(dynamicQuery);
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

		return _pipProgramLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.PipProgram fetchPipProgram(long pipProgramId) {
		return _pipProgramLocalService.fetchPipProgram(pipProgramId);
	}

	/**
	 * Returns the pip program matching the UUID and group.
	 *
	 * @param uuid the pip program's UUID
	 * @param groupId the primary key of the group
	 * @return the matching pip program, or <code>null</code> if a matching pip program could not be found
	 */
	@Override
	public com.ax.hrms.model.PipProgram fetchPipProgramByUuidAndGroupId(
		String uuid, long groupId) {

		return _pipProgramLocalService.fetchPipProgramByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _pipProgramLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _pipProgramLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _pipProgramLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _pipProgramLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pipProgramLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the pip program with the primary key.
	 *
	 * @param pipProgramId the primary key of the pip program
	 * @return the pip program
	 * @throws PortalException if a pip program with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.PipProgram getPipProgram(long pipProgramId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pipProgramLocalService.getPipProgram(pipProgramId);
	}

	/**
	 * Returns the pip program matching the UUID and group.
	 *
	 * @param uuid the pip program's UUID
	 * @param groupId the primary key of the group
	 * @return the matching pip program
	 * @throws PortalException if a matching pip program could not be found
	 */
	@Override
	public com.ax.hrms.model.PipProgram getPipProgramByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pipProgramLocalService.getPipProgramByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<com.ax.hrms.model.PipProgram> getPipPrograms(
		int start, int end) {

		return _pipProgramLocalService.getPipPrograms(start, end);
	}

	/**
	 * Returns all the pip programs matching the UUID and company.
	 *
	 * @param uuid the UUID of the pip programs
	 * @param companyId the primary key of the company
	 * @return the matching pip programs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.PipProgram>
		getPipProgramsByUuidAndCompanyId(String uuid, long companyId) {

		return _pipProgramLocalService.getPipProgramsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.ax.hrms.model.PipProgram>
		getPipProgramsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.PipProgram> orderByComparator) {

		return _pipProgramLocalService.getPipProgramsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of pip programs.
	 *
	 * @return the number of pip programs
	 */
	@Override
	public int getPipProgramsCount() {
		return _pipProgramLocalService.getPipProgramsCount();
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
	@Override
	public com.ax.hrms.model.PipProgram updatePipProgram(
		com.ax.hrms.model.PipProgram pipProgram) {

		return _pipProgramLocalService.updatePipProgram(pipProgram);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _pipProgramLocalService.getBasePersistence();
	}

	@Override
	public PipProgramLocalService getWrappedService() {
		return _pipProgramLocalService;
	}

	@Override
	public void setWrappedService(
		PipProgramLocalService pipProgramLocalService) {

		_pipProgramLocalService = pipProgramLocalService;
	}

	private PipProgramLocalService _pipProgramLocalService;

}