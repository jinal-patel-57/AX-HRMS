/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.exception.NoSuchAppraisalReminderException;
import com.ax.hrms.model.AppraisalReminder;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for AppraisalReminder. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalReminderLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AppraisalReminderLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ax.hrms.service.impl.AppraisalReminderLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the appraisal reminder local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link AppraisalReminderLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the appraisal reminder to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalReminderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalReminder the appraisal reminder
	 * @return the appraisal reminder that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AppraisalReminder addAppraisalReminder(
		AppraisalReminder appraisalReminder);

	/**
	 * Creates a new appraisal reminder with the primary key. Does not add the appraisal reminder to the database.
	 *
	 * @param appraisalRemainderId the primary key for the new appraisal reminder
	 * @return the new appraisal reminder
	 */
	@Transactional(enabled = false)
	public AppraisalReminder createAppraisalReminder(long appraisalRemainderId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the appraisal reminder from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalReminderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalReminder the appraisal reminder
	 * @return the appraisal reminder that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public AppraisalReminder deleteAppraisalReminder(
		AppraisalReminder appraisalReminder);

	/**
	 * Deletes the appraisal reminder with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalReminderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalRemainderId the primary key of the appraisal reminder
	 * @return the appraisal reminder that was removed
	 * @throws PortalException if a appraisal reminder with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public AppraisalReminder deleteAppraisalReminder(long appraisalRemainderId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalReminderModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalReminderModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AppraisalReminder fetchAppraisalReminder(long appraisalRemainderId);

	/**
	 * Returns the appraisal reminder matching the UUID and group.
	 *
	 * @param uuid the appraisal reminder's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal reminder, or <code>null</code> if a matching appraisal reminder could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AppraisalReminder fetchAppraisalReminderByUuidAndGroupId(
		String uuid, long groupId);

	public AppraisalReminder findByAppraisalProcessId(long appraisalProcessId)
		throws NoSuchAppraisalReminderException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the appraisal reminder with the primary key.
	 *
	 * @param appraisalRemainderId the primary key of the appraisal reminder
	 * @return the appraisal reminder
	 * @throws PortalException if a appraisal reminder with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AppraisalReminder getAppraisalReminder(long appraisalRemainderId)
		throws PortalException;

	/**
	 * Returns the appraisal reminder matching the UUID and group.
	 *
	 * @param uuid the appraisal reminder's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal reminder
	 * @throws PortalException if a matching appraisal reminder could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AppraisalReminder getAppraisalReminderByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the appraisal reminders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalReminderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal reminders
	 * @param end the upper bound of the range of appraisal reminders (not inclusive)
	 * @return the range of appraisal reminders
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AppraisalReminder> getAppraisalReminders(int start, int end);

	/**
	 * Returns all the appraisal reminders matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal reminders
	 * @param companyId the primary key of the company
	 * @return the matching appraisal reminders, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AppraisalReminder> getAppraisalRemindersByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of appraisal reminders matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal reminders
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of appraisal reminders
	 * @param end the upper bound of the range of appraisal reminders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching appraisal reminders, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AppraisalReminder> getAppraisalRemindersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalReminder> orderByComparator);

	/**
	 * Returns the number of appraisal reminders.
	 *
	 * @return the number of appraisal reminders
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAppraisalRemindersCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Updates the appraisal reminder in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalReminderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalReminder the appraisal reminder
	 * @return the appraisal reminder that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AppraisalReminder updateAppraisalReminder(
		AppraisalReminder appraisalReminder);

}