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
 * The extended model interface for the TemplateLevelMaster service. Represents a row in the &quot;ax_master_TemplateLevelMaster&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TemplateLevelMasterModel
 * @generated
 */
@ImplementationClassName(
	"com.ax.hrms.master.model.impl.TemplateLevelMasterImpl"
)
@ProviderType
public interface TemplateLevelMaster
	extends PersistedModel, TemplateLevelMasterModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ax.hrms.master.model.impl.TemplateLevelMasterImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TemplateLevelMaster, Long>
		TEMPLATE_LEVEL_MASTER_ID_ACCESSOR =
			new Accessor<TemplateLevelMaster, Long>() {

				@Override
				public Long get(TemplateLevelMaster templateLevelMaster) {
					return templateLevelMaster.getTemplateLevelMasterId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<TemplateLevelMaster> getTypeClass() {
					return TemplateLevelMaster.class;
				}

			};

}