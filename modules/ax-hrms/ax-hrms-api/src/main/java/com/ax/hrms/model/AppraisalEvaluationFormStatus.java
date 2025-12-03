/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ax.hrms.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the AppraisalEvaluationFormStatus service. Represents a row in the &quot;ax_AppraisalEvaluationFormStatus&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AppraisalEvaluationFormStatusModel
 * @generated
 */
@ImplementationClassName(
	"com.ax.hrms.model.impl.AppraisalEvaluationFormStatusImpl"
)
@ProviderType
public interface AppraisalEvaluationFormStatus
	extends AppraisalEvaluationFormStatusModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ax.hrms.model.impl.AppraisalEvaluationFormStatusImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AppraisalEvaluationFormStatus, Long>
		APPRAISAL_EVALUATION_FORM_STATUS_ID_ACCESSOR =
			new Accessor<AppraisalEvaluationFormStatus, Long>() {

				@Override
				public Long get(
					AppraisalEvaluationFormStatus
						appraisalEvaluationFormStatus) {

					return appraisalEvaluationFormStatus.
						getAppraisalEvaluationFormStatusId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<AppraisalEvaluationFormStatus> getTypeClass() {
					return AppraisalEvaluationFormStatus.class;
				}

			};

}