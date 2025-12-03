<%@ include file="/init.jsp"%>

<liferay-ui:error key="policy-process-management-hr-admin-exists"
	message="policy-process-management-hr-admin-name-is-already-exist" />
<portlet:renderURL var="homeUrl">
	<portlet:param name="selectedYear"
		value="${not empty policy.getYear() ? policy.getYear() : 'SELECTED_YEAR'}" />
</portlet:renderURL>
<portlet:actionURL name="/addEditPolicyProcessManagementHrAdmin"
	var="addEditPolicyProcessManagementHrAdminURL">
	<portlet:param name="backURL" value="${homeUrl}" />
</portlet:actionURL>

<portlet:actionURL name="/fetchPolicyProcessManagementHrAdmin"
	var="fetchPolicyProcessManagementHrAdminURL" />


<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
</head>
<liferay-ui:error key="existed-policy-entry-key"
	message="Existed Policy Type Entry is Found !" />

<body>



	<div class="card">
		<div class="card-header">
			<strong> <liferay-ui:message key="add-policy"></liferay-ui:message>
			</strong>
		</div>
		<form action="${addEditPolicyProcessManagementHrAdminURL}"
			method="Post" enctype="multipart/form-data"
			id="addEditPolicyHrAdminForm">

			<div class="card-body mb-0">
				<div class="row ">

					<div class="col-md-4 col-sm-12 ">
						<div class="form-group">
							<input value="${policy.getPolicyId()}" type="hidden"
								name="<portlet:namespace />policyId">
								 <label class=""
								for="policyName"><liferay-ui:message key="PolicyName" /><span class="text-danger">*</span></label>

							<input value="${policy.getPolicyName()}" id="policyName"
								placeholder="Enter Policy Name" class="form-control" type="text"
								name="<portlet:namespace/>policyName">

						</div>

					</div>

					<div class="col-md-4 col-sm-12 ">
						<div class="form-group">
							<label for="policyDescription"><liferay-ui:message
									key="policyDescription" /><span class="text-danger">*</span></label> <input
								value="${policy.getPolicyDescription()}" id="policyDescription"
								placeholder="Enter Policy Description" class="form-control"
								type="text" name="<portlet:namespace/>policyDescription"
								value="">

						</div>

					</div>

					<div class="col-md-4 col-sm-12 ">
						<div class="form-group">
							<label for="policytypes">Choose Policy Type:<span class="text-danger">*</span></label> <select
								class="btn-secondary" id="selectedType"
								name="<portlet:namespace />selectedPolicyType">
								<option value="" selected disabled><liferay-ui:message
										key="PolicyTypes" /></option>
								<c:forEach items="${policyTypes}" var="policy">
									<c:if test="${policy ne null}">
										<option value="${policy.getPolicyTypeMasterID()}"
											${policy.getPolicyType() eq currentPolicy ? 'selected' : ''}>${policy.getPolicyType()}</option>
									</c:if>
								</c:forEach>
							</select>

						</div>

					</div>

					<div class="col-md-4 col-sm-12 ">
						<div class="form-group">
							
										<label for="uploadDocument"><liferay-ui:message
												key="uploadDocument" /><span class="text-danger">*</span></label> <input type="file"
											id="uploadDocument" value="${URL}" title="${fileName}"
											name="<portlet:namespace/>uploadDocument"
											class="form-control" />


										<c:if test="${not empty fileName}">
											<a href="${URL}" target="_blank"><liferay-ui:message
													key="viewDocument" /></a>
										</c:if>

									
						</div>

					</div>
					<div class="col-md-4 col-sm-12 ">
						<div class="form-group">
							<label for="applicableRoles"><liferay-ui:message key="applicableRoles"/><span class="text-danger">*</span></label>
							<select class="form-control" id="role"  name="<portlet:namespace/>role" >
								<option value=""><liferay-ui:message key="SelectRoles"/></option>
								<c:forEach var="role" items="${roleName}">
									<option value="${role.getRoleId()}">${role.getName()}</option>
								</c:forEach>
							</select>
							<div id="selectedOptionsContainer"></div>
							<input  type="hidden" value="" name="<portlet:namespace/>selectedRoles" id="roleHidden" />

						</div>

					</div>

					<div class="col-md-4 col-sm-12 ">
						<div class="form-group">
							<label for="applicableDate"><liferay-ui:message
									key="applicableDate" /><span class="text-danger">*</span></label> <input
								value="<fmt:formatDate pattern = "yyyy-MM-dd"  value = '${policy.getApplicableDate()}'/>"
								id="applicableDate" placeholder="Enter Policy Applicable Date"
								class="form-control datepicker"
								name="<portlet:namespace/>applicableDate" value="">

						</div>

					</div>

					<div class="col-md-4 col-sm-12 ">
						<div class="form-group">

							<label for="policyYear"><liferay-ui:message
									key="year-text" /><span class="text-danger">*</span></label> <select id="policyYear"
								class="form-control" name="<portlet:namespace/>policyYear">
								<c:choose>
									<c:when test="${policy.getYear() ne null}">
										<option value="${policy.getYear()}"
											${policy.getYear() eq year ? 'selected' : ''}>
											${policy.getYear()}</option>
									</c:when>
									<c:otherwise>
										<option value="" selected>
											<liferay-ui:message key="select-option" />
										</option>
									</c:otherwise>
								</c:choose>

							</select>


						</div>

					</div>

					<div class="col-md-4 col-sm-12 ">
						<div class="form-group">

							<label for="status"><liferay-ui:message
									key="policyStatus" /><span class="text-danger">*</span></label>
							<div>

								<input value="Active" type="radio" class="form-check-input ml-2"
									id="statusActive"
									${policy.getStatus() eq true ? 'checked' : ''}
									name="<portlet:namespace/>status" value="Active"> <label
									class="form-check-label ml-4"
									for="statusActive"><liferay-ui:message key="active" /></label>
							</div>
							<div>
								<input value="InActive" type="radio" class="form-check-input ml-2"
									id="statusInActive"
									${policy.getStatus() eq false ? 'checked' : ''}
									name="<portlet:namespace/>status" value="InActive"> <label
									class="form-check-label ml-4" 
									for="statusInActive"><liferay-ui:message
										key="in-active" /></label>
						</div>
						</div>

					</div>
					


				</div>
			</div>
			<div class="card-footer text-right mb-0">
				<a href="${homeUrl}" class="btn btn-outline-danger mr-1"><liferay-ui:message
						key="back" /></a>
				<button class="btn btn-outline-success" type="submit">
					<liferay-ui:message key="submit" />
				</button>
			</div>
		</form>
	</div>










	<!-- Initialize Datepicker -->
	<script>
		$(document).ready(function() {
			var currentYear = new Date().getFullYear();
			var startDate = new Date(currentYear - 2, 0, 1); // January 1st of previous year
			var endDate = new Date(currentYear + 1, 11, 31); // December 31st of next year

			$('.datepicker').datepicker({
				format : 'yyyy-mm-dd',
				autoclose : true,
				startDate : startDate,
				endDate : endDate
			});

			var fileInput = document.getElementById('uploadDocument');
			var fileName = '${fileName}';

			const myFile = new File([ '' ], fileName, {

				type : 'text/plain',
				lastModified : new Date(),
			});

			myFile.name = fileName;
			const dataTransfer = new DataTransfer();
			dataTransfer.items.add(myFile);
			fileInput.files = dataTransfer.files;
		});

		$(document)
				.ready(
						function() {

							var config = {};
							config.namespace = '<portlet:namespace />';
							config.year = '${not empty existedPolicy ? (existedPolicy.getYear()) : (not empty policy ? policy.getYear() : "")}';
							config.fileName = '${not empty fileName ? fileName : ""}';
							config.filePath = '${not empty URL ? URL : ""}';
							config.policyName = 'policyName';
							config.policyDescription = 'policyDescription';
							config.selectedType = 'selectedType';
							config.applicableDate = 'applicableDate';
							config.uploadDocument = 'uploadDocument';
							config.policyYear = 'policyYear';
							config.role = 'role';

							config.listOfAssignee = '${rolePoliciesId}';

							AxHrmsPolicyProcessManagementHrAdminWebPortlet
									.setConfigs(config);
							AxHrmsPolicyProcessManagementHrAdminWebPortlet
									.setFileData(config);
						});
	</script>

</body>

