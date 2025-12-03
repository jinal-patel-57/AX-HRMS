/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.master.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the AppraisalStatusMaster service. Represents a row in the &quot;ax_master_AppraisalStatusMaster&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalStatusMasterModel
 * @generated
 */
@ImplementationClassName(
	"com.ax.hrms.master.model.impl.AppraisalStatusMasterImpl"
)
@ProviderType
public interface AppraisalStatusMaster
	extends AppraisalStatusMasterModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ax.hrms.master.model.impl.AppraisalStatusMasterImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AppraisalStatusMaster, Long>
		APPRAISAL_STATUS_MASTER_ID_ACCESSOR =
			new Accessor<AppraisalStatusMaster, Long>() {

				@Override
				public Long get(AppraisalStatusMaster appraisalStatusMaster) {
					return appraisalStatusMaster.getAppraisalStatusMasterId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<AppraisalStatusMaster> getTypeClass() {
					return AppraisalStatusMaster.class;
				}

			};

}