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
 * The extended model interface for the PolicyTypeMaster service. Represents a row in the &quot;ax_master_PolicyTypeMaster&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyTypeMasterModel
 * @generated
 */
@ImplementationClassName("com.ax.hrms.master.model.impl.PolicyTypeMasterImpl")
@ProviderType
public interface PolicyTypeMaster
	extends PersistedModel, PolicyTypeMasterModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ax.hrms.master.model.impl.PolicyTypeMasterImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PolicyTypeMaster, Long>
		POLICY_TYPE_MASTER_ID_ACCESSOR =
			new Accessor<PolicyTypeMaster, Long>() {

				@Override
				public Long get(PolicyTypeMaster policyTypeMaster) {
					return policyTypeMaster.getPolicyTypeMasterID();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<PolicyTypeMaster> getTypeClass() {
					return PolicyTypeMaster.class;
				}

			};

}