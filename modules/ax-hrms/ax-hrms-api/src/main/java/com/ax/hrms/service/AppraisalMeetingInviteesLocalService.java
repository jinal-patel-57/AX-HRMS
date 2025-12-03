/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.AppraisalMeetingInvitees;

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
 * Provides the local service interface for AppraisalMeetingInvitees. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalMeetingInviteesLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AppraisalMeetingInviteesLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ax.hrms.service.impl.AppraisalMeetingInviteesLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the appraisal meeting invitees local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link AppraisalMeetingInviteesLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the appraisal meeting invitees to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalMeetingInviteesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalMeetingInvitees the appraisal meeting invitees
	 * @return the appraisal meeting invitees that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AppraisalMeetingInvitees addAppraisalMeetingInvitees(
		AppraisalMeetingInvitees appraisalMeetingInvitees);

	/**
	 * Creates a new appraisal meeting invitees with the primary key. Does not add the appraisal meeting invitees to the database.
	 *
	 * @param appraisalMeetingInviteeId the primary key for the new appraisal meeting invitees
	 * @return the new appraisal meeting invitees
	 */
	@Transactional(enabled = false)
	public AppraisalMeetingInvitees createAppraisalMeetingInvitees(
		long appraisalMeetingInviteeId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the appraisal meeting invitees from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalMeetingInviteesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalMeetingInvitees the appraisal meeting invitees
	 * @return the appraisal meeting invitees that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public AppraisalMeetingInvitees deleteAppraisalMeetingInvitees(
		AppraisalMeetingInvitees appraisalMeetingInvitees);

	/**
	 * Deletes the appraisal meeting invitees with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalMeetingInviteesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalMeetingInviteeId the primary key of the appraisal meeting invitees
	 * @return the appraisal meeting invitees that was removed
	 * @throws PortalException if a appraisal meeting invitees with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public AppraisalMeetingInvitees deleteAppraisalMeetingInvitees(
			long appraisalMeetingInviteeId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalMeetingInviteesModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalMeetingInviteesModelImpl</code>.
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
	public AppraisalMeetingInvitees fetchAppraisalMeetingInvitees(
		long appraisalMeetingInviteeId);

	/**
	 * Returns the appraisal meeting invitees matching the UUID and group.
	 *
	 * @param uuid the appraisal meeting invitees's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal meeting invitees, or <code>null</code> if a matching appraisal meeting invitees could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AppraisalMeetingInvitees
		fetchAppraisalMeetingInviteesByUuidAndGroupId(
			String uuid, long groupId);

	public List<AppraisalMeetingInvitees> findByAppraisalMeetingId(
		long appraisalMeetingId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the appraisal meeting invitees with the primary key.
	 *
	 * @param appraisalMeetingInviteeId the primary key of the appraisal meeting invitees
	 * @return the appraisal meeting invitees
	 * @throws PortalException if a appraisal meeting invitees with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AppraisalMeetingInvitees getAppraisalMeetingInvitees(
			long appraisalMeetingInviteeId)
		throws PortalException;

	/**
	 * Returns the appraisal meeting invitees matching the UUID and group.
	 *
	 * @param uuid the appraisal meeting invitees's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal meeting invitees
	 * @throws PortalException if a matching appraisal meeting invitees could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AppraisalMeetingInvitees getAppraisalMeetingInviteesByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the appraisal meeting inviteeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalMeetingInviteesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @return the range of appraisal meeting inviteeses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AppraisalMeetingInvitees> getAppraisalMeetingInviteeses(
		int start, int end);

	/**
	 * Returns all the appraisal meeting inviteeses matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal meeting inviteeses
	 * @param companyId the primary key of the company
	 * @return the matching appraisal meeting inviteeses, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AppraisalMeetingInvitees>
		getAppraisalMeetingInviteesesByUuidAndCompanyId(
			String uuid, long companyId);

	/**
	 * Returns a range of appraisal meeting inviteeses matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal meeting inviteeses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of appraisal meeting inviteeses
	 * @param end the upper bound of the range of appraisal meeting inviteeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching appraisal meeting inviteeses, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AppraisalMeetingInvitees>
		getAppraisalMeetingInviteesesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<AppraisalMeetingInvitees> orderByComparator);

	/**
	 * Returns the number of appraisal meeting inviteeses.
	 *
	 * @return the number of appraisal meeting inviteeses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAppraisalMeetingInviteesesCount();

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
	 * Updates the appraisal meeting invitees in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalMeetingInviteesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalMeetingInvitees the appraisal meeting invitees
	 * @return the appraisal meeting invitees that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AppraisalMeetingInvitees updateAppraisalMeetingInvitees(
		AppraisalMeetingInvitees appraisalMeetingInvitees);

}