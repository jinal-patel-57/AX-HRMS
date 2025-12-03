<%--
  Created by IntelliJ IDEA.
  User: krish.moradiya
  Date: 06-06-2024
  Time: 02:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/init.jsp"%>


<portlet:actionURL name="editEmployeeProfile"
				   var="editEmployeeProfileUrl" />


<div class="card">
	<div class="card-header">
			<form action="${editEmployeeProfileUrl}" method="POST" id="profileForm">
		<div class="card">
			<div class="card-header">
				<strong> <liferay-ui:message key="Profile Detail"></liferay-ui:message>
				</strong>
			</div>

				<div class="card-body mb-0">
					<div class="row ">

						<div class="col-md-4 col-sm-12 ">
							<div class="form-group">
								<label><liferay-ui:message key="first-name" /><span class="text-danger">*</span></label> <input
									type="text" class="form-control"
									id="<portlet:namespace/>firstName"
									name="<portlet:namespace/>firstName"
									value="${employeeProfileDetail.firstName}" />

							</div>
						</div>

						<div class="col-md-4 col-sm-12 ">
							<div class="form-group">
								<label><liferay-ui:message key="middle-name" /><span class="text-danger">*</span></label> <input
									type="text" class="form-control"
									id="<portlet:namespace/>middleName"
									name="<portlet:namespace/>middleName"
									value="${employeeProfileDetail.middleName}" />

							</div>
						</div>
						<div class="col-md-4 col-sm-12 ">
							<div class="form-group">
								<label><liferay-ui:message key="last-name" /><span class="text-danger">*</span></label> <input
									type="text" class="form-control"
									id="<portlet:namespace/>lastName"
									name="<portlet:namespace/>lastName"
									value="${employeeProfileDetail.lastName}" />

							</div>
						</div>


						<div class="col-md-4 col-sm-12 ">
							<div class="form-group">
								<label><liferay-ui:message key="personal-email" /><span class="text-danger">*</span></label> <input
									type="email" class="form-control"
									id="<portlet:namespace/>personalEmail"
									name="<portlet:namespace/>personalEmail"
									value="${employeeProfileDetail.personalEmailId}" />

							</div>
						</div>


						<div class="col-md-4 col-sm-12 ">
							<div class="form-group">
								<label><liferay-ui:message key="phone-number" /><span class="text-danger">*</span></label> <input
									type="text" class="form-control"
									id="<portlet:namespace/>mobileNumber"
									name="<portlet:namespace/>mobileNumber"
									value="${employeeProfileDetail.mobileNumber}" />


							</div>
						</div>
					</div>
				</div>

		</div>
		<c:choose>
			<c:when test="${not empty employeeProfileDetail.addressList}">
				<c:set var="permanantAddress"
					   value="${employeeProfileDetail.addressList.get(0)}"></c:set>

				<div class="card">
					<div class="card-header">
						<strong> <liferay-ui:message
								key="permanant-address-detail"></liferay-ui:message>
						</strong>
					</div>
					<div class="card-body mb-0">
						<div class="row ">

							<div class="col-md-4 col-sm-12 ">
								<div class="form-group">
									<label><liferay-ui:message key="line-1" /><span class="text-danger">*</span></label> <input
										type="text" class="form-control"
										id="<portlet:namespace/>permanantLine1"
										name="<portlet:namespace/>permanantLine1"
										value="${permanantAddress.line1}" />

								</div>
							</div>

							<div class="col-md-4 col-sm-12 ">
								<div class="form-group">
									<label><liferay-ui:message key="line-2" /> <input
											type="text" class="form-control"
											id="<portlet:namespace/>permanantLine2"
											name="<portlet:namespace/>permanantLine2"
											value="${permanantAddress.line2}" />
								</div>
							</div>

							<div class="col-md-4 col-sm-12 ">
								<div class="form-group">
									<label><liferay-ui:message key="line-3" /></label> <input
										type="text" class="form-control"
										id="<portlet:namespace/>permanantLine3"
										name="<portlet:namespace/>permanantLine3"
										value="${permanantAddress.line3}" />

								</div>
							</div>

							<div class="col-md-4 col-sm-12 ">
								<div class="form-group">
									<label><liferay-ui:message key="state" /><span class="text-danger">*</span></label> <input
										type="text" class="form-control"
										id="<portlet:namespace/>permanantState"
										name="<portlet:namespace/>permanantState"
										value="${permanantAddress.state}" />

								</div>
							</div>

							<div class="col-md-4 col-sm-12 ">
								<div class="form-group">
									<input type="checkbox" class=""
										   id="<portlet:namespace/>isSamePresentAddress"
										   name="<portlet:namespace/>isSamePresentAddress"
										${isSamePresentAddress == true ?'checked':''}> <label><liferay-ui:message
										key="same-as-permanant-address" /></label>
								</div>
							</div>

							<div class="col-md-4 col-sm-12 ">
								<div class="form-group">
									<label><liferay-ui:message key="pincode" /><span class="text-danger">*</span></label> <input
										type="number" class="form-control"
										id="<portlet:namespace/>permanantPincode"
										name="<portlet:namespace/>permanantPincode"
										value="${permanantAddress.pincode}" />

								</div>
							</div>

							<div class="col-md-4 col-sm-12 ">
								<div class="form-group">
									<label><liferay-ui:message key="country" /><span class="text-danger">*</span></label> <select
										class="form-control"
										id="<portlet:namespace/>permanantCountry"
										name="<portlet:namespace/>permanantCountry">
									<option value=""><liferay-ui:message
											key="select-country" /></option>
									<c:forEach items="${countryList}" var="country">
										<option value="${country.getCountryId()}"
											${employeeProfileDetail.permanantCountryId == country.getCountryId() ? 'selected':''}>${country.name}</option>
									</c:forEach>
								</select>
								</div>
							</div>


						</div>
					</div>
				</div>

				<div class="card">
					<div class="card-header">
						<strong> <liferay-ui:message
								key="present-address-detail"></liferay-ui:message>
						</strong>
					</div>

					<c:catch var="exception">
						<c:set var="presentAddress"
							   value="${employeeProfileDetail.addressList.get(1)}"></c:set>
					</c:catch>
					<c:if test="${exception != null}">
						<c:set var="presentAddress"
							   value="${employeeProfileDetail.addressList.get(0)}"></c:set>
					</c:if>


					<div class="card-body mb-0">
						<div class="row ">

							<div class="col-md-4 col-sm-12 ">
								<div class="form-group">
									<label><liferay-ui:message key="line-1" /><span class="text-danger">*</span></label> <input
										type="text" class="form-control"
										id="<portlet:namespace/>presentLine1"
										name="<portlet:namespace/>presentLine1"
										value="${presentAddress.line1}" />

								</div>
							</div>

							<div class="col-md-4 col-sm-12 ">
								<div class="form-group">
									<label><liferay-ui:message key="line-2" /> <input
											type="text" class="form-control"
											id="<portlet:namespace/>presentLine2"
											name="<portlet:namespace/>presentLine2"
											value="${presentAddress.line2}" />
								</div>
							</div>

							<div class="col-md-4 col-sm-12 ">
								<div class="form-group">
									<label><liferay-ui:message key="line-3" /></label> <input
										type="text" class="form-control"
										id="<portlet:namespace/>presentLine3"
										name="<portlet:namespace/>presentLine3"
										value="${presentAddress.line3}" />

								</div>
							</div>

							<div class="col-md-4 col-sm-12 ">
								<div class="form-group">
									<label><liferay-ui:message key="state" /><span class="text-danger">*</span></label> <input
										type="text" class="form-control"
										id="<portlet:namespace/>presentState"
										name="<portlet:namespace/>presentState"
										value="${presentAddress.state}" />

								</div>
							</div>


							<div class="col-md-4 col-sm-12 ">
								<div class="form-group">
									<label><liferay-ui:message key="pincode" /><span class="text-danger">*</span></label> <input
										type="number" class="form-control"
										id="<portlet:namespace />presentPincode"
										name="<portlet:namespace/>presentPincode"
										value="${presentAddress.pincode}" />

								</div>
							</div>

							<div class="col-md-4 col-sm-12 ">
								<div class="form-group">
									<label><liferay-ui:message key="country" /><span class="text-danger">*</span></label> <select
										class="form-control" id="<portlet:namespace/>presentCountry"
										name="<portlet:namespace/>presentCountry">
									<option value=""><liferay-ui:message
											key="select-country" /></option>
									<c:forEach items="${countryList}" var="country">
										<option value="${country.getCountryId()}"
											${employeeProfileDetail.presentCountryId == country.getCountryId() ? 'selected':''}>${country.name}</option>
									</c:forEach>
								</select>
								</div>
							</div>


						</div>
					</div>



				</div>

			</c:when>
			<c:otherwise>
				<div class="alert alert-info" role="alert">
					<liferay-ui:message key="info-message" />
				</div>
			</c:otherwise>

		</c:choose>



		<div class="card-footer text-right mb-0">
			<button type="submit" class="btn btn-outline-success">
				<liferay-ui:message key="submit" />
			</button>

		</div>
				</form>
		
	</div>
</div>





<script type="application/javascript">

	$(document).ready(function(){
		var config = new Object({}),
				namespace = '<portlet:namespace />';

		config.namespace = namespace;

		AxProfileManagementWeb.setConfigs(config);
	});

</script>