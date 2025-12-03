/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.service;

import com.ax.hrms.model.CompensatoryData;

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
 * Provides the local service interface for CompensatoryData. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see CompensatoryDataLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CompensatoryDataLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ax.hrms.service.impl.CompensatoryDataLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the compensatory data local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link CompensatoryDataLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public CompensatoryData addCompensatoryData(
		CompensatoryData compensatoryData);

	/**
	 * Creates a new compensatory data with the primary key. Does not add the compensatory data to the database.
	 *
	 * @param compensatoryDataId the primary key for the new compensatory data
	 * @return the new compensatory data
	 */
	@Transactional(enabled = false)
	public CompensatoryData createCompensatoryData(long compensatoryDataId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public CompensatoryData deleteCompensatoryData(
		CompensatoryData compensatoryData);

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
	@Indexable(type = IndexableType.DELETE)
	public CompensatoryData deleteCompensatoryData(long compensatoryDataId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.CompensatoryDataModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ax.hrms.model.impl.CompensatoryDataModelImpl</code>.
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
	public CompensatoryData fetchCompensatoryData(long compensatoryDataId);

	/**
	 * Returns the compensatory data matching the UUID and group.
	 *
	 * @param uuid the compensatory data's UUID
	 * @param groupId the primary key of the group
	 * @return the matching compensatory data, or <code>null</code> if a matching compensatory data could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CompensatoryData fetchCompensatoryDataByUuidAndGroupId(
		String uuid, long groupId);

	public List<CompensatoryData> findByEmployeeId(long employeeId);

	public List<CompensatoryData> findByManagerId(long managerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the compensatory data with the primary key.
	 *
	 * @param compensatoryDataId the primary key of the compensatory data
	 * @return the compensatory data
	 * @throws PortalException if a compensatory data with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CompensatoryData getCompensatoryData(long compensatoryDataId)
		throws PortalException;

	/**
	 * Returns the compensatory data matching the UUID and group.
	 *
	 * @param uuid the compensatory data's UUID
	 * @param groupId the primary key of the group
	 * @return the matching compensatory data
	 * @throws PortalException if a matching compensatory data could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CompensatoryData getCompensatoryDataByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CompensatoryData> getCompensatoryDatas(int start, int end);

	/**
	 * Returns all the compensatory datas matching the UUID and company.
	 *
	 * @param uuid the UUID of the compensatory datas
	 * @param companyId the primary key of the company
	 * @return the matching compensatory datas, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CompensatoryData> getCompensatoryDatasByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CompensatoryData> getCompensatoryDatasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CompensatoryData> orderByComparator);

	/**
	 * Returns the number of compensatory datas.
	 *
	 * @return the number of compensatory datas
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCompensatoryDatasCount();

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
	 * Updates the compensatory data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CompensatoryDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param compensatoryData the compensatory data
	 * @return the compensatory data that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CompensatoryData updateCompensatoryData(
		CompensatoryData compensatoryData);

}