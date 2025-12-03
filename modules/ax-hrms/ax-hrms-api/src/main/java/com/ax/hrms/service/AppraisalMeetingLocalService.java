/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.exception.NoSuchAppraisalMeetingException;
import com.ax.hrms.model.AppraisalMeeting;

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
 * Provides the local service interface for AppraisalMeeting. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalMeetingLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AppraisalMeetingLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ax.hrms.service.impl.AppraisalMeetingLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the appraisal meeting local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link AppraisalMeetingLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the appraisal meeting to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalMeetingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalMeeting the appraisal meeting
	 * @return the appraisal meeting that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AppraisalMeeting addAppraisalMeeting(
		AppraisalMeeting appraisalMeeting);

	/**
	 * Creates a new appraisal meeting with the primary key. Does not add the appraisal meeting to the database.
	 *
	 * @param appraisalMeetingId the primary key for the new appraisal meeting
	 * @return the new appraisal meeting
	 */
	@Transactional(enabled = false)
	public AppraisalMeeting createAppraisalMeeting(long appraisalMeetingId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the appraisal meeting from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalMeetingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalMeeting the appraisal meeting
	 * @return the appraisal meeting that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public AppraisalMeeting deleteAppraisalMeeting(
		AppraisalMeeting appraisalMeeting);

	/**
	 * Deletes the appraisal meeting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalMeetingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalMeetingId the primary key of the appraisal meeting
	 * @return the appraisal meeting that was removed
	 * @throws PortalException if a appraisal meeting with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public AppraisalMeeting deleteAppraisalMeeting(long appraisalMeetingId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalMeetingModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalMeetingModelImpl</code>.
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
	public AppraisalMeeting fetchAppraisalMeeting(long appraisalMeetingId);

	/**
	 * Returns the appraisal meeting matching the UUID and group.
	 *
	 * @param uuid the appraisal meeting's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal meeting, or <code>null</code> if a matching appraisal meeting could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AppraisalMeeting fetchAppraisalMeetingByUuidAndGroupId(
		String uuid, long groupId);

	public AppraisalMeeting findByAppraisalProcessId(long appraisalProcessId)
		throws NoSuchAppraisalMeetingException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the appraisal meeting with the primary key.
	 *
	 * @param appraisalMeetingId the primary key of the appraisal meeting
	 * @return the appraisal meeting
	 * @throws PortalException if a appraisal meeting with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AppraisalMeeting getAppraisalMeeting(long appraisalMeetingId)
		throws PortalException;

	/**
	 * Returns the appraisal meeting matching the UUID and group.
	 *
	 * @param uuid the appraisal meeting's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal meeting
	 * @throws PortalException if a matching appraisal meeting could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AppraisalMeeting getAppraisalMeetingByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the appraisal meetings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalMeetingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal meetings
	 * @param end the upper bound of the range of appraisal meetings (not inclusive)
	 * @return the range of appraisal meetings
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AppraisalMeeting> getAppraisalMeetings(int start, int end);

	/**
	 * Returns all the appraisal meetings matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal meetings
	 * @param companyId the primary key of the company
	 * @return the matching appraisal meetings, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AppraisalMeeting> getAppraisalMeetingsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of appraisal meetings matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal meetings
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of appraisal meetings
	 * @param end the upper bound of the range of appraisal meetings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching appraisal meetings, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AppraisalMeeting> getAppraisalMeetingsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalMeeting> orderByComparator);

	/**
	 * Returns the number of appraisal meetings.
	 *
	 * @return the number of appraisal meetings
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAppraisalMeetingsCount();

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
	 * Updates the appraisal meeting in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalMeetingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalMeeting the appraisal meeting
	 * @return the appraisal meeting that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AppraisalMeeting updateAppraisalMeeting(
		AppraisalMeeting appraisalMeeting);

}