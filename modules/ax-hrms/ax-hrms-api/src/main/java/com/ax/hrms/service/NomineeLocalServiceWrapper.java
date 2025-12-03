/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link NomineeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see NomineeLocalService
 * @generated
 */
public class NomineeLocalServiceWrapper
	implements NomineeLocalService, ServiceWrapper<NomineeLocalService> {

	public NomineeLocalServiceWrapper() {
		this(null);
	}

	public NomineeLocalServiceWrapper(NomineeLocalService nomineeLocalService) {
		_nomineeLocalService = nomineeLocalService;
	}

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
	@Override
	public com.ax.hrms.model.Nominee addNominee(
		com.ax.hrms.model.Nominee nominee) {

		return _nomineeLocalService.addNominee(nominee);
	}

	/**
	 * Creates a new nominee with the primary key. Does not add the nominee to the database.
	 *
	 * @param nomineeId the primary key for the new nominee
	 * @return the new nominee
	 */
	@Override
	public com.ax.hrms.model.Nominee createNominee(long nomineeId) {
		return _nomineeLocalService.createNominee(nomineeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _nomineeLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.ax.hrms.model.Nominee deleteNominee(long nomineeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _nomineeLocalService.deleteNominee(nomineeId);
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
	@Override
	public com.ax.hrms.model.Nominee deleteNominee(
		com.ax.hrms.model.Nominee nominee) {

		return _nomineeLocalService.deleteNominee(nominee);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _nomineeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _nomineeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _nomineeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _nomineeLocalService.dynamicQuery();
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

		return _nomineeLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _nomineeLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _nomineeLocalService.dynamicQuery(
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

		return _nomineeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _nomineeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.Nominee fetchNominee(long nomineeId) {
		return _nomineeLocalService.fetchNominee(nomineeId);
	}

	/**
	 * Returns the nominee matching the UUID and group.
	 *
	 * @param uuid the nominee's UUID
	 * @param groupId the primary key of the group
	 * @return the matching nominee, or <code>null</code> if a matching nominee could not be found
	 */
	@Override
	public com.ax.hrms.model.Nominee fetchNomineeByUuidAndGroupId(
		String uuid, long groupId) {

		return _nomineeLocalService.fetchNomineeByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _nomineeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _nomineeLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _nomineeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the nominee with the primary key.
	 *
	 * @param nomineeId the primary key of the nominee
	 * @return the nominee
	 * @throws PortalException if a nominee with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.Nominee getNominee(long nomineeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _nomineeLocalService.getNominee(nomineeId);
	}

	/**
	 * Returns the nominee matching the UUID and group.
	 *
	 * @param uuid the nominee's UUID
	 * @param groupId the primary key of the group
	 * @return the matching nominee
	 * @throws PortalException if a matching nominee could not be found
	 */
	@Override
	public com.ax.hrms.model.Nominee getNomineeByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _nomineeLocalService.getNomineeByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.ax.hrms.model.Nominee> getNominees(
		int start, int end) {

		return _nomineeLocalService.getNominees(start, end);
	}

	/**
	 * Returns all the nominees matching the UUID and company.
	 *
	 * @param uuid the UUID of the nominees
	 * @param companyId the primary key of the company
	 * @return the matching nominees, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.Nominee>
		getNomineesByUuidAndCompanyId(String uuid, long companyId) {

		return _nomineeLocalService.getNomineesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.ax.hrms.model.Nominee>
		getNomineesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.Nominee> orderByComparator) {

		return _nomineeLocalService.getNomineesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of nominees.
	 *
	 * @return the number of nominees
	 */
	@Override
	public int getNomineesCount() {
		return _nomineeLocalService.getNomineesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _nomineeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _nomineeLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.ax.hrms.model.Nominee updateNominee(
		com.ax.hrms.model.Nominee nominee) {

		return _nomineeLocalService.updateNominee(nominee);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _nomineeLocalService.getBasePersistence();
	}

	@Override
	public NomineeLocalService getWrappedService() {
		return _nomineeLocalService;
	}

	@Override
	public void setWrappedService(NomineeLocalService nomineeLocalService) {
		_nomineeLocalService = nomineeLocalService;
	}

	private NomineeLocalService _nomineeLocalService;

}