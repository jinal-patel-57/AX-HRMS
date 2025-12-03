/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link HolidayLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see HolidayLocalService
 * @generated
 */
public class HolidayLocalServiceWrapper
	implements HolidayLocalService, ServiceWrapper<HolidayLocalService> {

	public HolidayLocalServiceWrapper() {
		this(null);
	}

	public HolidayLocalServiceWrapper(HolidayLocalService holidayLocalService) {
		_holidayLocalService = holidayLocalService;
	}

	/**
	 * Adds the holiday to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HolidayLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param holiday the holiday
	 * @return the holiday that was added
	 */
	@Override
	public com.ax.hrms.model.Holiday addHoliday(
		com.ax.hrms.model.Holiday holiday) {

		return _holidayLocalService.addHoliday(holiday);
	}

	/**
	 * Creates a new holiday with the primary key. Does not add the holiday to the database.
	 *
	 * @param holidayId the primary key for the new holiday
	 * @return the new holiday
	 */
	@Override
	public com.ax.hrms.model.Holiday createHoliday(long holidayId) {
		return _holidayLocalService.createHoliday(holidayId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _holidayLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the holiday from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HolidayLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param holiday the holiday
	 * @return the holiday that was removed
	 */
	@Override
	public com.ax.hrms.model.Holiday deleteHoliday(
		com.ax.hrms.model.Holiday holiday) {

		return _holidayLocalService.deleteHoliday(holiday);
	}

	/**
	 * Deletes the holiday with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HolidayLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param holidayId the primary key of the holiday
	 * @return the holiday that was removed
	 * @throws PortalException if a holiday with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.Holiday deleteHoliday(long holidayId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _holidayLocalService.deleteHoliday(holidayId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _holidayLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _holidayLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _holidayLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _holidayLocalService.dynamicQuery();
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

		return _holidayLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.HolidayModelImpl</code>.
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

		return _holidayLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.HolidayModelImpl</code>.
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

		return _holidayLocalService.dynamicQuery(
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

		return _holidayLocalService.dynamicQueryCount(dynamicQuery);
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

		return _holidayLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ax.hrms.model.Holiday fetchHoliday(long holidayId) {
		return _holidayLocalService.fetchHoliday(holidayId);
	}

	/**
	 * Returns the holiday matching the UUID and group.
	 *
	 * @param uuid the holiday's UUID
	 * @param groupId the primary key of the group
	 * @return the matching holiday, or <code>null</code> if a matching holiday could not be found
	 */
	@Override
	public com.ax.hrms.model.Holiday fetchHolidayByUuidAndGroupId(
		String uuid, long groupId) {

		return _holidayLocalService.fetchHolidayByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.ax.hrms.model.Holiday findByDate(java.util.Date date)
		throws com.ax.hrms.exception.NoSuchHolidayException {

		return _holidayLocalService.findByDate(date);
	}

	@Override
	public java.util.List<com.ax.hrms.model.Holiday>
		findByIsFloaterAndCurrentYear(Boolean isFloater, int year) {

		return _holidayLocalService.findByIsFloaterAndCurrentYear(
			isFloater, year);
	}

	@Override
	public java.util.List<com.ax.hrms.model.Holiday> findByYear(int year) {
		return _holidayLocalService.findByYear(year);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _holidayLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _holidayLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns the holiday with the primary key.
	 *
	 * @param holidayId the primary key of the holiday
	 * @return the holiday
	 * @throws PortalException if a holiday with the primary key could not be found
	 */
	@Override
	public com.ax.hrms.model.Holiday getHoliday(long holidayId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _holidayLocalService.getHoliday(holidayId);
	}

	/**
	 * Returns the holiday matching the UUID and group.
	 *
	 * @param uuid the holiday's UUID
	 * @param groupId the primary key of the group
	 * @return the matching holiday
	 * @throws PortalException if a matching holiday could not be found
	 */
	@Override
	public com.ax.hrms.model.Holiday getHolidayByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _holidayLocalService.getHolidayByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the holidays.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.HolidayModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @return the range of holidays
	 */
	@Override
	public java.util.List<com.ax.hrms.model.Holiday> getHolidays(
		int start, int end) {

		return _holidayLocalService.getHolidays(start, end);
	}

	/**
	 * Returns all the holidays matching the UUID and company.
	 *
	 * @param uuid the UUID of the holidays
	 * @param companyId the primary key of the company
	 * @return the matching holidays, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.Holiday>
		getHolidaysByUuidAndCompanyId(String uuid, long companyId) {

		return _holidayLocalService.getHolidaysByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of holidays matching the UUID and company.
	 *
	 * @param uuid the UUID of the holidays
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of holidays
	 * @param end the upper bound of the range of holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching holidays, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ax.hrms.model.Holiday>
		getHolidaysByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ax.hrms.model.Holiday> orderByComparator) {

		return _holidayLocalService.getHolidaysByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of holidays.
	 *
	 * @return the number of holidays
	 */
	@Override
	public int getHolidaysCount() {
		return _holidayLocalService.getHolidaysCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _holidayLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _holidayLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _holidayLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<Integer> getYear() {
		return _holidayLocalService.getYear();
	}

	/**
	 * Updates the holiday in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HolidayLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param holiday the holiday
	 * @return the holiday that was updated
	 */
	@Override
	public com.ax.hrms.model.Holiday updateHoliday(
		com.ax.hrms.model.Holiday holiday) {

		return _holidayLocalService.updateHoliday(holiday);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _holidayLocalService.getBasePersistence();
	}

	@Override
	public HolidayLocalService getWrappedService() {
		return _holidayLocalService;
	}

	@Override
	public void setWrappedService(HolidayLocalService holidayLocalService) {
		_holidayLocalService = holidayLocalService;
	}

	private HolidayLocalService _holidayLocalService;

}