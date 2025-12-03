<%@ include file="/init.jsp"%>


<liferay-portlet:renderURL var="backURL" />

<liferay-ui:success key="detail-update-success-message"
	message="Profile detail updated..."></liferay-ui:success>



<div class="card">
<div class="card-body pb-0">
	<div class="card">
		<div class="card-header">
			<strong> <liferay-ui:message key="employee-profile"></liferay-ui:message>
			</strong>
		</div>
		<div class="card-body">


			<div class="row">


				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
					<div class="form-group-view">
						<div class="profilePic">
							<img src="${employeeProfileDetail.previewUrl}" class="cover">
						</div>
						<div class="col-6 align-center">
							<div class="row">
								<h3>${employeeProfileDetail.getFullName()}</h3>
							</div>
							<div class="row">
								<p>${employeeProfileDetail.officialEmailId}</p>
							</div>
						</div>
					</div>

				</div>

				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
					<div class="form-group-view">
						<div class="label-name">
							<liferay-ui:message key="first-name" />
						</div>
						<div class="label-content">${employeeProfileDetail.firstName}</div>
					</div>

				</div>

				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
					<div class="form-group-view">
						<div class="label-name">
							<liferay-ui:message key="middle-name" />
						</div>
						<div class="label-content">${employeeProfileDetail.middleName}</div>
					</div>

				</div>

				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
					<div class="form-group-view">
						<div class="label-name">
							<liferay-ui:message key="last-name" />
						</div>
						<div class="label-content">${employeeProfileDetail.lastName}</div>
					</div>

				</div>

				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
					<div class="form-group-view">
						<div class="label-name">
							<liferay-ui:message key="gender" />
						</div>
						<div class="label-content">${employeeProfileDetail.gender}</div>
					</div>

				</div>

				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
					<div class="form-group-view">
						<div class="label-name">
							<liferay-ui:message key="phone-number" />
						</div>
						<div class="label-content">${employeeProfileDetail.mobileNumber}</div>
					</div>

				</div>

				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
					<div class="form-group-view">
						<div class="label-name">
							<liferay-ui:message key="personal-email" />
						</div>
						<div class="label-content">${employeeProfileDetail.personalEmailId}</div>
					</div>

				</div>

				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
					<div class="form-group-view">
						<div class="label-name">
							<liferay-ui:message key="official-email-id" />
						</div>
						<div class="label-content">${employeeProfileDetail.officialEmailId}</div>
					</div>

				</div>

				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
					<div class="form-group-view">
						<div class="label-name">
							<liferay-ui:message key="joining-date" />
						</div>
						<div class="label-content">${employeeProfileDetail.joiningDate}</div>
					</div>

				</div>

				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
					<div class="form-group-view">
						<div class="label-name">
							<liferay-ui:message key="designation" />
						</div>
						<div class="label-content">${employeeProfileDetail.designationName}</div>
					</div>

				</div>

				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
					<div class="form-group-view">
						<div class="label-name">
							<liferay-ui:message key="department" />
						</div>
						<c:forEach var="departmentName"
							items="${employeeProfileDetail.departmentNames}">
							<div class="label-content">${departmentName}</div>
						</c:forEach>


					</div>

				</div>


			</div>
		</div>
	</div>


	<c:if test="${not empty employeeProfileDetail.addressList}">
		<div class="card mb-0">

			<div class="card-header">
				<strong> <liferay-ui:message key="address"></liferay-ui:message>
				</strong>
			</div>

			<div class="card-body">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
						<div class="form-group-view">
							<h4>
								<liferay-ui:message key="permanant-address-detail" />
							</h4>
						</div>

					</div>

						<c:set var="permanantAddress"
							value="${employeeProfileDetail.addressList.get(0)}"></c:set>

						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
							<div class="form-group-view">
								<div class="label-name">
									<liferay-ui:message key="line-1" />
								</div>
								<div class="label-content">${permanantAddress.line1}</div>
							</div>

						</div>

						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
							<div class="form-group-view">
								<div class="label-name">
									<liferay-ui:message key="line-2" />
								</div>
								<div class="label-content">${permanantAddress.line2}</div>
							</div>

						</div>

						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
							<div class="form-group-view">
								<div class="label-name">
									<liferay-ui:message key="line-3" />
								</div>
								<div class="label-content">${permanantAddress.line3}</div>
							</div>

						</div>

						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
							<div class="form-group-view">
								<div class="label-name">
									<liferay-ui:message key="state" />
								</div>
								<div class="label-content">${permanantAddress.state}</div>
							</div>

						</div>

						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
							<div class="form-group-view">
								<div class="label-name">
									<liferay-ui:message key="pincode" />
								</div>
								<div class="label-content">${permanantAddress.pincode}</div>
							</div>

						</div>

						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
							<div class="form-group-view">
								<div class="label-name">
									<liferay-ui:message key="country" />
								</div>
								<div class="label-content">${employeeProfileDetail.permanantCountry}</div>
							</div>

						</div>

				</div>
				


				<c:if test="${not employeeProfileDetail.isSamePresentAddress()}">
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
							<div class="form-group-view">
								<h4>
									<liferay-ui:message key="present-address-detail" />
								</h4>
							</div>

						</div>

						<c:catch var="exception">
							<c:set var="permanantAddress"
								value="${employeeProfileDetail.addressList.get(1)}"></c:set>

							<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="line-1" />
									</div>
									<div class="label-content">${permanantAddress.line1}</div>
								</div>

							</div>

							<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="line-2" />
									</div>
									<div class="label-content">${permanantAddress.line2}</div>
								</div>

							</div>

							<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="line-3" />
									</div>
									<div class="label-content">${permanantAddress.line3}</div>
								</div>

							</div>

							<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="state" />
									</div>
									<div class="label-content">${permanantAddress.state}</div>
								</div>

							</div>

							<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="pincode" />
									</div>
									<div class="label-content">${permanantAddress.pincode}</div>
								</div>

							</div>

							<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
								<div class="form-group-view">
									<div class="label-name">
										<liferay-ui:message key="country" />
									</div>
									<div class="label-content">${employeeProfileDetail.presentCountry}</div>
								</div>

							</div>


						</c:catch>
					</div>
				</c:if>
			</div>
		</div>
	</c:if>
</div>
	<div class="card-footer text-right mb-0">
		<a href="${backURL}" class="btn  btn-outline-danger"> <liferay-ui:message
				key="back" />
		</a>
	</div>
</div>



