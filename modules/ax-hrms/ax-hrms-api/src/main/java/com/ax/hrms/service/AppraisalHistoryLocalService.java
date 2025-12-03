/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.AppraisalHistory;

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
 * Provides the local service interface for AppraisalHistory. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalHistoryLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AppraisalHistoryLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ax.hrms.service.impl.AppraisalHistoryLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the appraisal history local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link AppraisalHistoryLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the appraisal history to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalHistory the appraisal history
	 * @return the appraisal history that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AppraisalHistory addAppraisalHistory(
		AppraisalHistory appraisalHistory);

	/**
	 * Creates a new appraisal history with the primary key. Does not add the appraisal history to the database.
	 *
	 * @param appraisalId the primary key for the new appraisal history
	 * @return the new appraisal history
	 */
	@Transactional(enabled = false)
	public AppraisalHistory createAppraisalHistory(long appraisalId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the appraisal history from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalHistory the appraisal history
	 * @return the appraisal history that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public AppraisalHistory deleteAppraisalHistory(
		AppraisalHistory appraisalHistory);

	/**
	 * Deletes the appraisal history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalId the primary key of the appraisal history
	 * @return the appraisal history that was removed
	 * @throws PortalException if a appraisal history with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public AppraisalHistory deleteAppraisalHistory(long appraisalId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalHistoryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalHistoryModelImpl</code>.
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
	public AppraisalHistory fetchAppraisalHistory(long appraisalId);

	/**
	 * Returns the appraisal history matching the UUID and group.
	 *
	 * @param uuid the appraisal history's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal history, or <code>null</code> if a matching appraisal history could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AppraisalHistory fetchAppraisalHistoryByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns a range of all the appraisal histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.AppraisalHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal histories
	 * @param end the upper bound of the range of appraisal histories (not inclusive)
	 * @return the range of appraisal histories
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AppraisalHistory> getAppraisalHistories(int start, int end);

	/**
	 * Returns all the appraisal histories matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal histories
	 * @param companyId the primary key of the company
	 * @return the matching appraisal histories, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AppraisalHistory> getAppraisalHistoriesByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of appraisal histories matching the UUID and company.
	 *
	 * @param uuid the UUID of the appraisal histories
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of appraisal histories
	 * @param end the upper bound of the range of appraisal histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching appraisal histories, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AppraisalHistory> getAppraisalHistoriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AppraisalHistory> orderByComparator);

	/**
	 * Returns the number of appraisal histories.
	 *
	 * @return the number of appraisal histories
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAppraisalHistoriesCount();

	/**
	 * Returns the appraisal history with the primary key.
	 *
	 * @param appraisalId the primary key of the appraisal history
	 * @return the appraisal history
	 * @throws PortalException if a appraisal history with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AppraisalHistory getAppraisalHistory(long appraisalId)
		throws PortalException;

	/**
	 * Returns the appraisal history matching the UUID and group.
	 *
	 * @param uuid the appraisal history's UUID
	 * @param groupId the primary key of the group
	 * @return the matching appraisal history
	 * @throws PortalException if a matching appraisal history could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AppraisalHistory getAppraisalHistoryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

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
	 * Updates the appraisal history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppraisalHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appraisalHistory the appraisal history
	 * @return the appraisal history that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AppraisalHistory updateAppraisalHistory(
		AppraisalHistory appraisalHistory);

}