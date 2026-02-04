<%@ include file="/init.jsp"%>

<portlet:renderURL var="listEmployeeOnBoardingHr">
	<portlet:param name="mvcCommand" value="/" />
</portlet:renderURL>


<portlet:resourceURL id="/checkEmailExists" var="checkEmailExistsURL"/>
<portlet:actionURL name="/addEmployeeOnboardingHr"
	var="addEmployeeOnboardingHr" />


<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>

<div class="card">
	<div class="card-header">
		<strong>Employee Onboarding HR</strong>
	</div>
	<form action="${addEmployeeOnboardingHr}" method="post"
		id="EmployeeOnBoardingHrForm">
		<div class="card-body">
			<div class="row">
				<div class="col-md-4 col-sm-12">
					<div class="form-group">
						<label class="" for="typeOfEmployee"><liferay-ui:message
								key="typeOfEmployee" /><span class="text-danger">*</span></label> <select
							class="form-control" id="typeOfEmployee"
							name="<portlet:namespace/>typeOfEmployee">

							<option value="permanent">
								<liferay-ui:message key="permanent-employee" />
							</option>
							<option value="temporary">
								<liferay-ui:message key="temporary-employee" />
							</option>
							<option value="intern">
								<liferay-ui:message key="intern" />
							</option>
							<option value="contractor">
								<liferay-ui:message key="contractor" />
							</option>

						</select> <label id="typeOfEmployee-error" class="error text-danger"
							for="typeOfEmployee"></label>
					</div>
				</div>
				<div class="col-md-4 col-sm-12">
					<div class="form-group">
						<label class="" for="employeeCode"><liferay-ui:message
								key="employee-code" /><span class="text-danger">*</span></label> <input
							id="employeeCode"
							placeholder="<liferay-ui:message key='employee-code'/>"
							class="form-control" type="text"
							name="<portlet:namespace/>employeeCode"
							value="${employeCodePattern}" readOnly /> <label
							id="employeeCode-error" class="error text-danger"
							for="employeeCode"></label>
					</div>
				</div>
				<div class="col-md-4 col-sm-12">
					<div class="form-group">
						<label class="" for="firstName"><liferay-ui:message
								key="first-name" /><span class="text-danger">*</span></label> <input
							id="firstName"
							placeholder="<liferay-ui:message key='first-name'/>"
							class="form-control" type="text"
							name="<portlet:namespace/>firstName" /> <label
							id="firstName-error" class="error text-danger" for="firstName"></label>
					</div>
				</div>

				<div class="col-md-4 col-sm-12">
                    <div class="form-group">
                        <label class="" for="middleName"><liferay-ui:message
                                key="middle-name" /></label> <input
                            id="middleName"
                            placeholder="<liferay-ui:message key='middle-name'/>"
                            class="form-control" type="text"
                            name="<portlet:namespace/>middleName" /> <label
                            id="middleName-error" class="error text-danger" for="middleName"></label>
                    </div>
                </div>
				<div class="col-md-4 col-sm-12">
					<div class="form-group">
						<label class="" for="lastName"><liferay-ui:message
								key="last-name" /><span class="text-danger">*</span></label> <input
							id="lastName" placeholder="<liferay-ui:message key='last-name'/>"
							class="form-control" type="text"
							name="<portlet:namespace/>lastName" /> <label id="lastName-error"
							class="error text-danger" for="lastName"></label>
					</div>
				</div>



				<div class="col-md-4 col-sm-12">
					<div class="form-group">
						<label for="officialEmailId"> <liferay-ui:message
								key="official-email-id" /> <span class="text-danger">*</span>
						</label> <input id="officialEmailId" class="form-control" type="text"
							name="<portlet:namespace/>officialEmailId" autocomplete="off"
							value="" data-domain="${domain}" /> <label
							id="officialEmailId-error" class="error text-danger"
							for="officialEmailId"></label>
							<small id="email-exists-msg" class="text-danger d-none">
                                Email already exists.
                            </small>

					</div>

				</div>


				<div class="col-md-4 col-sm-12">
					<div class="form-group">
						<label class="" for="insuranceLink"><liferay-ui:message
								key="insurance-link" /></label> <input id="insuranceLink"
							placeholder="<liferay-ui:message key='insurance-link'/>"
							class="form-control" type="text"
							name="<portlet:namespace/>insuranceLink" /> <label
							id="insuranceLink-error" class="error text-danger"
							for="insuranceLink"></label>
					</div>
				</div>

				<div class="col-md-4 col-sm-12">
					<div class="form-group">
						<label class="" for="joiningDate"><liferay-ui:message
								key="joining-date" /><span class="text-danger">*</span></label> <input
							id="joiningDate"
							placeholder="<liferay-ui:message key='joining-date'/>"
							class="form-control" type="date"
							name="<portlet:namespace/>joiningDate" /> <label
							id="joiningDate-error" class="error text-danger"
							for="joiningDate"></label>
					</div>
				</div>

				<div class="col-md-4 col-sm-12">

					<div class="form-group">
						<label class="" for="grossSalaryCTCPM"><liferay-ui:message
								key="gross-salary-ctc-pm" /> </label> <input id="grossSalaryCTCPM"
							placeholder="<liferay-ui:message key='gross-salary-ctc-pm'/>"
							class="form-control" type="text"
							name="<portlet:namespace/>grossSalaryCTCPM" /> <label
							id="grossSalaryCTCPM-error" class="error text-danger"
							for="grossSalaryCTCPM"></label>
					</div>

				</div>
				<div class="col-md-4 col-sm-12">
					<div class="form-group">
						<label class="" for="grossSalaryCTCPA"><liferay-ui:message
								key="gross-salary-ctc-pa" /> </label> <input id="grossSalaryCTCPA"
							placeholder="<liferay-ui:message key='gross-salary-ctc-pa'/>"
							class="form-control" type="text"
							name="<portlet:namespace/>grossSalaryCTCPA"  readonly /> <label
							id="grossSalaryCTCPA-error" class="error text-danger"
							for="grossSalaryCTCPA"></label>
					</div>
				</div>
				<div class="col-md-4 col-sm-12">
					<div class="form-group">
						<label class="" for="stipend"><liferay-ui:message
								key="stipend" /></label> <input id="stipend"
							placeholder="<liferay-ui:message key='stipend'/>"
							class="form-control" type="text"
							name="<portlet:namespace/>stipend" disabled /> <label
							id="stipend-error" class="error text-danger" for="stipend"></label>
					</div>
				</div>
				<div class="col-md-4 col-sm-12">
					<div class="form-group">
						<label class="" for="isProbationEnabled"><liferay-ui:message
								key="probation-status" /></label>
						<div class="d-flex c-gap-3 align-items-center">
							<div class="form-check d-flex align-items-center c-gap-1">
								<input class="form-check-input" type="radio"
									name="<portlet:namespace />isProbationEnabled" id="enabled"
									value="Enabled" checked> <label
									class="form-check-label" for="enabled"><liferay-ui:message
										key="enabled" /><span class="text-danger">*</span></label>
							</div>
							<div class="form-check d-flex align-items-center c-gap-1">
								<input class="form-check-input" type="radio"
									name="<portlet:namespace />isProbationEnabled" id="disabled"
									value="Disabled"> <label class="form-check-label"
									for="disabled"><liferay-ui:message key="disabled" /></label>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-12">
					<div class="form-group">
						<label class="" for="isExperienced"><liferay-ui:message
								key="is-experienced" /><span class="text-danger">*</span></label>
						<div class="d-flex c-gap-3 align-items-center">
							<div class="form-check d-flex align-items-center c-gap-1">
								<input class="form-check-input" type="radio"
									name="<portlet:namespace />isExperienced" id="yes" value="Yes">
								<label class="form-check-label" for="yes"><liferay-ui:message
										key="yes" /></label>
							</div>
							<div class="form-check d-flex align-items-center c-gap-1">
								<input class="form-check-input" type="radio"
									name="<portlet:namespace />isExperienced" id="no" value="No"
									checked> <label class="form-check-label" for="no"><liferay-ui:message
										key="no" /></label>
							</div>
						</div>
						<label id="isExperienced-error" class="error text-danger"
							for="isExperienced"></label>
					</div>
				</div>
				<div class="col-md-4 col-sm-12">
                    <div class="form-group">
                        <label class="" for="experienceYear">
                            <liferay-ui:message key="experience-year" />
                            <span class="text-danger">*</span>
                        </label>
                        <input
                            id="experienceYear"
                            placeholder="Years in Experience"
                            class="form-control"
                            type="text"
                            name="<portlet:namespace/>experienceYear"

                             />
                        <label id="experienceYear-error"
                               class="error text-danger"
                               for="experienceYear"></label>
                    </div>
                </div>


				<div class="col-md-4 col-sm-12">
					<div class="form-group">
						<label class="" for="gender"><liferay-ui:message
								key="gender" /><span class="text-danger">*</span></label>
						<div class="d-flex c-gap-3 align-items-center">
							<div class="form-check d-flex align-items-center c-gap-1">
								<input class="form-check-input" type="radio"
									name="<portlet:namespace />gender" id="male" value="Male">
								<label class="form-check-label" for="male"><liferay-ui:message
										key="male" /></label>
							</div>
							<div class="form-check d-flex align-items-center c-gap-1">
								<input class="form-check-input" type="radio"
									name="<portlet:namespace />gender" id="female" value="Female"
									checked> <label class="form-check-label" for="female"><liferay-ui:message
										key="female" /></label>
							</div>
						</div>
						<label id="gender-error" class="error text-danger" for="gender"></label>
					</div>
				</div>

                <div class="col-sm-12 col-md-4 col-lg-4">
                    <div class="form-group">
                        <label for="branchSelectBox">
                            <liferay-ui:message key="branch" />
                            <span class="text-danger">*</span>
                        </label>

                        <select id="branchSelectBox"
                            name="<portlet:namespace/>branch"
                            class="form-control custom-select mr-sm-2">

                            <option value="">
                                <liferay-ui:message key="Select Branch" />
                            </option>

                            <c:forEach var="branch" items="${branchMasterList}">
                                <option value="${branch.branchMasterId}">
                                    ${branch.branchName}
                                </option>
                            </c:forEach>

                        </select>
                    </div>
                </div>

				<div class="col-sm-12 col-md-4 col-lg-4">
					<div class="form-group">
                        <label for="managerSelectBox"> 
							<liferay-ui:message key="manager" />

						</label>
						<select id="managerSelectBox"
							name="<portlet:namespace/>manager" class="form-control custom-select mr-sm-2">

							<option value="">
								<liferay-ui:message key="select-manager" />
							</option>

							<c:forEach var="employee" items="${employeeDetailsList}">
								<option value="${employee.getEmployeeId()}">
									${employee.firstName} ${employee.lastName}
									(${employee.employeeCode})</option>
							</c:forEach>

						</select>

					</div>
				</div>

				<div class="col-md-4 col-sm-12">
					<div class="form-group">
						<label class="" for="department"><liferay-ui:message
								key="department" /><span class="text-danger">*</span></label> <select
							class="form-control" id="department"
							name="<portlet:namespace/>department">
							<option value="" disabled selected>
								<liferay-ui:message key="select-department" />
							</option>
							<c:forEach items="${departmentMasterList}" var="department">
								<option value="${department.departmentName}">
									${department.departmentName}</option>
							</c:forEach>
						</select> <label id="department-error" class="error text-danger"
							for="department"></label>
					</div>
				</div>
				<div class="col-md-4 col-sm-12">
					<div class="form-group">
						<label class="" for="designation"><liferay-ui:message
								key="designation" /><span class="text-danger">*</span></label> <select
							class="form-control" id="designation"
							name="<portlet:namespace/>designation" >
							<option value="" disabled selected>
								<liferay-ui:message key="select-designation" />
							</option>
							<c:forEach items="${designationMasterList}" var="designation">
								<option value="${designation.designationName}">
									${designation.designationName}</option>
							</c:forEach>
						</select> <label id="designation-error" class="error text-danger"
							for="designation"></label>
					</div>
				</div>



			</div>
		</div>
		<div class="card-footer text-right align-items-center">
			<a href="${listEmployeeOnBoardingHr}"
				class="btn btn-outline-danger mr-1  "><i
				class="fa-solid fa-angle-left"></i> <liferay-ui:message key="back" /></a>
			<button class="btn btn-outline-success" type="submit">
				<liferay-ui:message key="submit" />
			</button>
		</div>
	</form>

</div>

<script>








    $(document).ready(function () {
        var config = new Object({}),
            namespace = '<portlet:namespace />';

        config.namespace = namespace;

        AxHrmsEmployeeOnboardingHrWebPortlet.setConfigsForValidation(config);
    });



   $(document).ready(function () {
    var checkEmailExistsURL = '${checkEmailExistsURL}';
    console.log("chackEmailURL",checkEmailExistsURL);
  window.isOfficialEmailExists = false;


       const emailInput = $("#officialEmailId");
       const domain = emailInput.data("domain");
       var namespace = '<portlet:namespace />';

       let isDeleting = false;

       emailInput.on("keydown", function (e) {
           if (e.key === "Backspace" || e.key === "Delete") {
               isDeleting = true;
           }
       });
       emailInput.on("keydown", function () {
           window.isOfficialEmailExists = false;
          $("#officialEmailId-error").text("").hide();
       });



    emailInput.on("input", function () {
        let value = emailInput.val() || "";

        // If empty, do nothing
        if (!value) return;

        if (isDeleting) {
            isDeleting = false;
            return;
        }

        // ===== Safe rebuild logic =====

        let username = value;

        // Remove full domain if present
        if (value.includes(domain)) {
            username = value.replace(domain, "");
        }
        // Handle partially deleted domain
        else if (value.includes("@")) {
            username = value.split("@")[0];
        }

        // Clean username
        username = username.replace(/@/g, "").replace(/\s+/g, "");

        // Re-attach domain ONCE
        emailInput.val(username + domain);
    });



       // Prevent cursor entering domain
       emailInput.on("click keyup", function () {
           const value = emailInput.val();
           const domainIndex = value.indexOf(domain);

           if (domainIndex !== -1 && this.selectionStart > domainIndex) {
               this.setSelectionRange(domainIndex, domainIndex);
           }
       });


         $("#grossSalaryCTCPM").on("input keyup", function () {
               let ctcPm = parseFloat($(this).val());

               if (!isNaN(ctcPm)) {
                   $("#grossSalaryCTCPA").val(ctcPm * 12);
               } else {
                   $("#grossSalaryCTCPA").val("");
               }
           });


           function checkEmailExists(email) {

             const emailInput = $("#officialEmailId");

                 if (!email || email.indexOf("@") === -1) return;

                 if (!emailInput.valid()) {
                     return;
                 }

               $.ajax({
                   url: checkEmailExistsURL,
                   type: "GET",
                   data: {
                       [namespace + 'email']: email
                   },
                  success: function (response) {
                      window.isOfficialEmailExists = response.exists;

                      if (!response.exists) {
                          // REMOVE error if email is now valid
                         $("#officialEmailId-error").text("").hide();
                      }

                      // Force revalidation
                      $("#officialEmailId").valid();
                  },
                   error: function () {
                       console.error("Email validation failed");
                   }
               });
           }

            const firstNameInput = $("#firstName");
                const lastNameInput = $("#lastName");

                if (!emailInput.val()) {
                    emailInput.val(domain);
                }

                function generateEmail() {
                    const firstName = firstNameInput.val().trim().toLowerCase();
                    const lastName = lastNameInput.val().trim().toLowerCase();

                    if (firstName && lastName) {

                        window.isOfficialEmailExists = false;
                        $("#officialEmailId-error").text("").hide();

                        emailInput.val(firstName + "." + lastName + domain);

                        checkEmailExists(emailInput.val());
                    }
                }


                firstNameInput.on("blur", generateEmail);
                lastNameInput.on("blur", generateEmail);

                emailInput.on("blur", function () {
                    checkEmailExists($(this).val());
                });





   });






</script>