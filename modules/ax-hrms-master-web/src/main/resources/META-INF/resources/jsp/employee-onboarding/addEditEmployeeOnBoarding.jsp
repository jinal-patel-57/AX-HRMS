<%@ include file="/init.jsp"%>

<!-- Include Bootstrap CSS and JavaScript -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>

<div class="container mt-3">
    <!-- Stepper Form -->
    <form id="stepperForm">
        <!-- Navigation tabs -->
        <ul class="nav nav-tabs" id="stepperNav" role="tablist">
            <li class="nav-item" role="presentation">
                <button class="nav-link active" id="step1-tab" data-bs-toggle="tab" data-bs-target="#step1" type="button" role="tab" aria-controls="step1" aria-selected="true">
                    <liferay-ui:message key="basic-details"/>
                </button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="step2-tab" data-bs-toggle="tab" data-bs-target="#step2" type="button" role="tab" aria-controls="step2" aria-selected="false">
                    <liferay-ui:message key="address-details"/>
                </button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="step3-tab" data-bs-toggle="tab" data-bs-target="#step3" type="button" role="tab" aria-controls="step3" aria-selected="false">
                    <liferay-ui:message key="education-details"/>
                </button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="step4-tab" data-bs-toggle="tab" data-bs-target="#step4" type="button" role="tab" aria-controls="step4" aria-selected="false">
                    <liferay-ui:message key="experience-details"/>
                </button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="step5-tab" data-bs-toggle="tab" data-bs-target="#step5" type="button" role="tab" aria-controls="step5" aria-selected="false">
                    <liferay-ui:message key="bank-accounts-details"/>
                </button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="step6-tab" data-bs-toggle="tab" data-bs-target="#step6" type="button" role="tab" aria-controls="step6" aria-selected="false">
                    <liferay-ui:message key="uan-esic-details"/>
                </button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="step7-tab" data-bs-toggle="tab" data-bs-target="#step7" type="button" role="tab" aria-controls="step7" aria-selected="false">
                    <liferay-ui:message key="nominee-details"/>
                </button>
            </li>
        </ul>

        <!-- Tab content -->
        <div class="tab-content" id="stepperContent">
            <!-- Step 1 -->
            <div class="tab-pane fade show active" id="step1" role="tabpanel" aria-labelledby="step1-tab">
                <div class="mt-3">
                    <h4><liferay-ui:message key="basic-details"/></h4>
                    
                    <!-- First Row: Personal Email, Date of Birth, Mobile No -->
                    <div class="row mb-3">
                        <div class="col-4">
                            <label for="<portlet:namespace />personalEmail" class="form-label">
                                <liferay-ui:message key="personal-email"/>
                            </label>
                            <input type="email" class="form-control" id="<portlet:namespace />personalEmail" name="<portlet:namespace />personalEmail" required />
                        </div>
                        <div class="col-4">
                            <label for="<portlet:namespace />dateOfBirth" class="form-label">
                                <liferay-ui:message key="date-of-birth"/>
                            </label>
                            <input type="date" class="form-control" id="<portlet:namespace />dateOfBirth" name="<portlet:namespace />dateOfBirth" required />
                        </div>
                        <div class="col-4">
                            <label for="<portlet:namespace />mobileNo" class="form-label">
                                <liferay-ui:message key="mobile-no"/>
                            </label>
                            <input type="tel" class="form-control" id="<portlet:namespace />mobileNo" name="<portlet:namespace />mobileNo" required />
                        </div>
                    </div>

                    <!-- Second Row: Skype ID and Father's Name -->
                    <div class="row mb-3">
                        <div class="col-6">
                            <label for="<portlet:namespace />skypeId" class="form-label">
                                <liferay-ui:message key="skype-id"/>
                            </label>
                            <input type="text" class="form-control" id="<portlet:namespace />skypeId" name="<portlet:namespace />skypeId" required />
                        </div>
                        <div class="col-6">
                            <label for="<portlet:namespace />fatherName" class="form-label">
                                <liferay-ui:message key="father-name"/>
                            </label>
                            <input type="text" class="form-control" id="<portlet:namespace />fatherName" name="<portlet:namespace />fatherName" required />
                        </div>
                    </div>

                    <!-- Third Row: Marital Status, Marriage Date, and Spouse Name -->
                    <div class="row mb-3">
                        <div class="col-4">
                            <div class="form-check">
                                <input type="checkbox" class="form-check-input" id="<portlet:namespace />maritalStatus" name="<portlet:namespace />maritalStatus" />
                                <label class="form-check-label" for="<portlet:namespace />maritalStatus">
                                    <liferay-ui:message key="married"/>
                                </label>
                            </div>
                        </div>
                        <div class="col-4">
                            <label for="<portlet:namespace />marriageDate" class="form-label">
                                <liferay-ui:message key="marriage-date"/>
                            </label>
                            <input type="date" class="form-control" id="<portlet:namespace />marriageDate" name="<portlet:namespace />marriageDate" required />
                        </div>
                        <div class="col-4">
                            <label for="<portlet:namespace />spouseName" class="form-label">
                                <liferay-ui:message key="spouse-name"/>
                            </label>
                            <input type="text" class="form-control" id="<portlet:namespace />spouseName" name="<portlet:namespace />spouseName" required />
                        </div>
                    </div>

                    <!-- Next Button -->
                    <button class="btn btn-primary" type="button" onclick="navigateToStep(2)">Next</button>
                </div>
            </div>
			
			<!-- step 2 -->
            <div class="tab-pane fade" id="step2" role="tabpanel" aria-labelledby="step2-tab">
			    <div class="mt-3">
			        <h4><liferay-ui:message key="step2-heading"/></h4>
			
			        <!-- Permanent Address Fields -->
			        <div class="mb-3">
			            <h5><liferay-ui:message key="permanent-address-heading"/></h5>
			
			            <!-- Address Line 1 -->
			            <div class="mb-3">
			                <label for="permanentAddressLine1" class="form-label">
			                    <liferay-ui:message key="permanent-address-line1"/>
			                </label>
			                <input type="text" class="form-control" id="<portlet:namespace />permanentAddressLine1" name="<portlet:namespace />permanentAddressLine1" maxlength="250" />
			            </div>
			
			            <!-- Address Line 2 -->
			            <div class="mb-3">
			                <label for="permanentAddressLine2" class="form-label">
			                    <liferay-ui:message key="permanent-address-line2"/>
			                </label>
			                <input type="text" class="form-control" id="<portlet:namespace />permanentAddressLine2" name="<portlet:namespace />permanentAddressLine2" maxlength="250" />
			            </div>
			
			            <!-- Address Line 3 -->
			            <div class="mb-3">
			                <label for="permanentAddressLine3" class="form-label">
			                    <liferay-ui:message key="permanent-address-line3"/>
			                </label>
			                <input type="text" class="form-control" id="<portlet:namespace />permanentAddressLine3" name="<portlet:namespace />permanentAddressLine3" maxlength="250" />
			            </div>
			
			            <!-- State -->
			            <div class="mb-3">
			                <label for="permanentState" class="form-label">
			                    <liferay-ui:message key="permanent-state"/>
			                </label>
			                <input type="text" class="form-control" id="<portlet:namespace />permanentState" name="<portlet:namespace />permanentState" maxlength="100" />
			            </div>
			
			            <!-- Country -->
			            <div class="mb-3">
			                <label for="permanentCountry" class="form-label">
			                    <liferay-ui:message key="permanent-country"/>
			                </label>
			                <input type="number" class="form-control" id="<portlet:namespace />permanentCountry" name="<portlet:namespace />permanentCountry" />
			            </div>
			
			            <!-- Pincode -->
			            <div class="mb-3">
			                <label for="permanentPincode" class="form-label">
			                    <liferay-ui:message key="permanent-pincode"/>
			                </label>
			                <input type="text" class="form-control" id="<portlet:namespace />permanentPincode" name="<portlet:namespace />permanentPincode" maxlength="10" />
			            </div>
			        </div>
			
			        <!-- Checkbox for Same as Permanent Address -->
			        <div class="mb-3 form-check">
			            <input type="checkbox" class="form-check-input" id="sameAsPermanent" name="sameAsPermanent" onclick="togglePresentAddress()" />
			            <label class="form-check-label" for="sameAsPermanent">
			                <liferay-ui:message key="same-as-permanent-address"/>
			            </label>
			        </div>
			
			        <!-- Present Address Fields -->
			        <div class="mb-3">
			            <h5><liferay-ui:message key="present-address-heading"/></h5>
			
			            <!-- Address Line 1 -->
			            <div class="mb-3">
			                <label for="addressLine1" class="form-label">
			                    <liferay-ui:message key="present-address-line1"/>
			                </label>
			                <input type="text" class="form-control" id="<portlet:namespace />addressLine1" name="<portlet:namespace />addressLine1" maxlength="250" required />
			            </div>
			
			            <!-- Address Line 2 -->
			            <div class="mb-3">
			                <label for="addressLine2" class="form-label">
			                    <liferay-ui:message key="present-address-line2"/>
			                </label>
			                <input type="text" class="form-control" id="<portlet:namespace />addressLine2" name="<portlet:namespace />addressLine2" maxlength="250" />
			            </div>
			
			            <!-- Address Line 3 -->
			            <div class="mb-3">
			                <label for="addressLine3" class="form-label">
			                    <liferay-ui:message key="present-address-line3"/>
			                </label>
			                <input type="text" class="form-control" id="<portlet:namespace />addressLine3" name="<portlet:namespace />addressLine3" maxlength="250" />
			            </div>
			
			            <!-- State -->
			            <div class="mb-3">
			                <label for="state" class="form-label">
			                    <liferay-ui:message key="state"/>
			                </label>
			                <input type="text" class="form-control" id="<portlet:namespace />state" name="<portlet:namespace />state" maxlength="100" required />
			            </div>
			
			            <!-- Country -->
			            <div class="mb-3">
			                <label for="country" class="form-label">
			                    <liferay-ui:message key="country"/>
			                </label>
			                <input type="number" class="form-control" id="<portlet:namespace />country" name="<portlet:namespace />country" required />
			            </div>
			
			            <!-- Pincode -->
			            <div class="mb-3">
			                <label for="pincode" class="form-label">
			                    <liferay-ui:message key="pincode"/>
			                </label>
			                <input type="text" class="form-control" id="<portlet:namespace />pinCode" name="<portlet:namespace />pinCode" maxlength="10" required />
			            </div>
			        </div>
			
			        <!-- Navigation buttons -->
			        <button class="btn btn-primary" type="button" onclick="navigateToStep(1)">
			            <liferay-ui:message key="previous"/>
			        </button>
			        <button class="btn btn-primary" type="button" onclick="navigateToStep(3)">
			            <liferay-ui:message key="next"/>
			        </button>
			    </div>
			</div>
			
			<script>
				function togglePresentAddress() {
				    // Get the same as permanent checkbox
				    var sameAsPermanentCheckbox = document.getElementById("sameAsPermanent");
				    
				    // Get the permanent address fields
				    var permanentFields = {
				        line1: document.getElementById("<portlet:namespace />permanentAddressLine1"),
				        line2: document.getElementById("<portlet:namespace />permanentAddressLine2"),
				        line3: document.getElementById("<portlet:namespace />permanentAddressLine3"),
				        state: document.getElementById("<portlet:namespace />permanentState"),
				        country: document.getElementById("<portlet:namespace />permanentCountry"),
				        pincode: document.getElementById("<portlet:namespace />permanentPincode")
				    };
				    
				    // Get the present address fields
				    var presentFields = {
				        line1: document.getElementById("<portlet:namespace />addressLine1"),
				        line2: document.getElementById("<portlet:namespace />addressLine2"),
				        line3: document.getElementById("<portlet:namespace />addressLine3"),
				        state: document.getElementById("<portlet:namespace />state"),
				        country: document.getElementById("<portlet:namespace />country"),
				        pincode: document.getElementById("<portlet:namespace />pinCode")
				    };
				    
				    // Check if the checkbox is checked
				    if (sameAsPermanentCheckbox.checked) {
				        // Copy values from permanent to present address
				        presentFields.line1.value = permanentFields.line1.value;
				        presentFields.line2.value = permanentFields.line2.value;
				        presentFields.line3.value = permanentFields.line3.value;
				        presentFields.state.value = permanentFields.state.value;
				        presentFields.country.value = permanentFields.country.value;
				        presentFields.pincode.value = permanentFields.pincode.value;
				        
				        // Disable the present address fields
				        Object.values(presentFields).forEach(function(field) {
				            field.disabled = true;
				        });
				    } else {
				        // Enable the present address fields
				        Object.values(presentFields).forEach(function(field) {
				            field.disabled = false;
				        });
				        
				        // Optionally, clear the present address fields when checkbox is unchecked
				        // If you don't want to clear the fields, remove or comment out the following code block
				        presentFields.line1.value = "";
				        presentFields.line2.value = "";
				        presentFields.line3.value = "";
				        presentFields.state.value = "";
				        presentFields.country.value = "";
				        presentFields.pincode.value = "";
				    }
				}
			</script>

            <!-- Step 3 -->
			<div class="tab-pane fade" id="step3" role="tabpanel" aria-labelledby="step3-tab">
			    <div class="mt-3">
			        <h4><liferay-ui:message key="education-details"/></h4>
			
			        <!-- Container for all education sections -->
			        <div id="education-section-container">
			            <!-- Initial education section (no delete button) -->
			            <div class="education-section" id="initial-education-section">
			                <div class="row">
			                    <div class="mb-3 col-md-4">
			                        <label for="levelName1" class="form-label">
			                            <liferay-ui:message key="level-name"/>
			                        </label>
			                        <input type="text" class="form-control" id="levelName1" name="levelName[]" maxlength="250" required />
			                    </div>
			                    <div class="mb-3 col-md-4">
			                        <label for="institution1" class="form-label">
			                            <liferay-ui:message key="institution"/>
			                        </label>
			                        <input type="text" class="form-control" id="institution1" name="institution[]" maxlength="250" required />
			                    </div>
			                    <div class="mb-3 col-md-4">
			                        <label for="degree1" class="form-label">
			                            <liferay-ui:message key="degree"/>
			                        </label>
			                        <input type="text" class="form-control" id="degree1" name="degree[]" maxlength="75" required />
			                    </div>
			                </div>
			                <div class="row">
			                    <div class="mb-3 col-md-4">
			                        <label for="startDate1" class="form-label">
			                            <liferay-ui:message key="start-date"/>
			                        </label>
			                        <input type="date" class="form-control" id="startDate1" name="startDate[]" required />
			                    </div>
			                    <div class="mb-3 col-md-4">
			                        <label for="endDate1" class="form-label">
			                            <liferay-ui:message key="end-date"/>
			                        </label>
			                        <input type="date" class="form-control" id="endDate1" name="endDate[]" required />
			                    </div>
			                    <div class="mb-3 col-md-4">
			                        <label for="passingYear1" class="form-label">
			                            <liferay-ui:message key="passing-year"/>
			                        </label>
			                        <input type="text" class="form-control" id="passingYear1" name="passingYear[]" maxlength="4" required />
			                    </div>
			                </div>
			
			                <!-- Hidden fields -->
			                <input type="hidden" id="employeeId1" name="employeeId[]" value="some_value" />
			                <input type="hidden" id="educationId1" name="educationId[]" value="some_value" />
			            </div>
			        </div>
			
			        <!-- Plus button to add new section -->
			        <button class="btn btn-primary" type="button" id="add-education-section">
			            +
			        </button>
			
			        <!-- Navigation buttons -->
			        <button class="btn btn-primary" type="button" onclick="navigateToStep(2)">Previous</button>
			        <button class="btn btn-primary" type="button" onclick="navigateToStep(4)">Next</button>
			    </div>
			</div>
			
			<script>
			    // Function to add a new education section
			    function addEducationSection() {
			        // Clone the initial education section
			        var originalSection = document.getElementById('initial-education-section');
			        var newSection = originalSection.cloneNode(true);
			
			        // Clear input values and increment IDs and names to avoid conflicts
			        var inputs = newSection.querySelectorAll('input');
			        var index = document.querySelectorAll('.education-section').length + 1;
			        inputs.forEach(function(input) {
			            // Update ID and name attributes
			            input.id = input.id.replace(/[0-9]+$/, '') + index;
			            input.name = input.name.replace(/\d+$/, '') + index;
			
			            // Clear input value
			            input.value = '';
			        });
			
			        // Append the new section to the container
			        document.getElementById('education-section-container').appendChild(newSection);
			
			        // Add a delete button to the new section
			        var deleteButton = document.createElement('button');
			        deleteButton.className = 'btn btn-danger delete-section';
			        deleteButton.textContent = 'Delete';
			        deleteButton.type = 'button';
			
			        // Append the delete button to the new section
			        newSection.appendChild(deleteButton);
			
			        // Add an event listener to the delete button to remove the section when clicked
			        deleteButton.addEventListener('click', function() {
			            newSection.remove();
			        });
			    }
			
			    // Add event listener for the plus button to add new sections
			    document.getElementById('add-education-section').addEventListener('click', addEducationSection);
			</script>

            <!-- Step 4 -->
			<div class="tab-pane fade" id="step4" role="tabpanel" aria-labelledby="step4-tab">
			    <div class="mt-3">
			        <h4><liferay-ui:message key="experience-details"/></h4>
			
			        <!-- Container for all experience sections -->
			        <div id="experience-section-container">
			            <!-- Initial experience section -->
			            <div class="experience-section">
			                <!-- Company Name -->
			                <div class="mb-3">
			                    <label for="companyName1" class="form-label">
			                        <liferay-ui:message key="company-name"/>
			                    </label>
			                    <input type="text" class="form-control" id="companyName1" name="companyName[]" maxlength="75" required />
			                </div>
			
			                <!-- Row with Joining Date and Relieving Date -->
			                <div class="row">
			                    <div class="mb-3 col-md-6">
			                        <label for="joiningDate1" class="form-label">
			                            <liferay-ui:message key="joining-date"/>
			                        </label>
			                        <input type="date" class="form-control" id="joiningDate1" name="joiningDate[]" required />
			                    </div>
			                    <div class="mb-3 col-md-6">
			                        <label for="relievingDate1" class="form-label">
			                            <liferay-ui:message key="relieving-date"/>
			                        </label>
			                        <input type="date" class="form-control" id="relievingDate1" name="relievingDate[]" />
			                    </div>
			                </div>
			
			                <!-- Experience Certificate Attachment -->
			                <div class="mb-3">
			                    <label for="experienceCertificateAttachment1">
			                        <liferay-ui:message key="experience-certificate-attachment"/>
			                    </label>
			                    <input id="experienceCertificateAttachment1" type="file" name="experienceCertificateAttachment[]" class="form-control">
			                </div>
			
			                <!-- Hidden fields -->
			                <input type="hidden" id="employeeId1" name="employeeId[]" value="some_value" />
			                <input type="hidden" id="experienceId1" name="experienceId[]" value="some_value" />
			
			                <!-- Delete Button (Initially Hidden) -->
			                <button class="btn btn-danger delete-section d-none" type="button">
			                    Delete
			                </button>
			            </div>
			        </div>
			
			        <!-- Plus button to add new experience sections -->
			        <button class="btn btn-primary" type="button" id="add-experience-section">
			            +
			        </button>
			
			        <!-- Navigation buttons -->
			        <button class="btn btn-primary" type="button" onclick="navigateToStep(3)">Previous</button>
			        <button class="btn btn-primary" type="button" onclick="navigateToStep(5)">Next</button>
			    </div>
			</div>
			
			<script>
			    function addExperienceSection() {
			        var originalSection = document.querySelector('.experience-section');
			        var newSection = originalSection.cloneNode(true);
			
			        var inputs = newSection.querySelectorAll('input');
			        var index = document.querySelectorAll('.experience-section').length + 1;
			        inputs.forEach(function(input) {
			        	
			            input.id = input.id.replace(/[0-9]+$/, '') + index;
			            input.name = input.name.replace(/\d+$/, '') + index;

			            input.value = '';
			        });
			
			        document.getElementById('experience-section-container').appendChild(newSection);
			        
			        var deleteButton = newSection.querySelector('.delete-section');
			        deleteButton.classList.remove('d-none');
			
			        deleteButton.addEventListener('click', function() {
			            newSection.remove();
			        });
			    }
			
			    document.getElementById('add-experience-section').addEventListener('click', addExperienceSection);
			</script>

            <!-- Step 5 -->
            <div class="tab-pane fade" id="step5" role="tabpanel" aria-labelledby="step5-tab">
                <div class="mt-3">
                    <h4><liferay-ui:message key="bank-accounts-details"/></h4>
                    
                    <!-- Account Number -->
                    <div class="mb-3">
                        <label for="accountNumber" class="form-label">
                            <liferay-ui:message key="account-number"/>
                        </label>
                        <input type="text" class="form-control" id="<portlet:namespace />accountNumber" name="<portlet:namespace />accountNumber" maxlength="75" required />
                    </div>

                    <!-- Account Type -->
                    <div class="mb-3">
                        <label for="accountType" class="form-label">
                            <liferay-ui:message key="account-type"/>
                        </label>
                        <input type="text" class="form-control" id="<portlet:namespace />accountType" name="<portlet:namespace />accountType" maxlength="75" required />
                    </div>

                    <!-- Beneficiary Name -->
                    <div class="mb-3">
                        <label for="beneficiaryName" class="form-label">
                            <liferay-ui:message key="beneficiary-name"/>
                        </label>
                        <input type="text" class="form-control" id="<portlet:namespace />beneficiaryName" name="<portlet:namespace />beneficiaryName" maxlength="75" required />
                    </div>

                    <!-- Bank Name -->
                    <div class="mb-3">
                        <label for="bankName" class="form-label">
                            <liferay-ui:message key="bank-name"/>
                        </label>
                        <input type="text" class="form-control" id="<portlet:namespace />bankName" name="<portlet:namespace />bankName" maxlength="75" required />
                    </div>

                    <!-- Active -->
                    <div class="form-check mb-3">
                        <input type="checkbox" class="form-check-input" id="<portlet:namespace />status" name="<portlet:namespace />status" />
                        <label class="form-check-label" for="status">
                            <liferay-ui:message key="active"/>
                        </label>
                    </div>

                    <!-- IFSC Code -->
                    <div class="mb-3">
                        <label for="ifscCode" class="form-label">
                            <liferay-ui:message key="ifsc-code"/>
                        </label>
                        <input type="text" class="form-control" id="<portlet:namespace />ifscCode" name="<portlet:namespace />ifscCode" maxlength="75" required />
                    </div>

                    <!-- Bank Branch -->
                    <div class="mb-3">
                        <label for="bankBranch" class="form-label">
                            <liferay-ui:message key="bank-branch"/>
                        </label>
                        <input type="text" class="form-control" id="<portlet:namespace />bankBranch" name="<portlet:namespace />bankBranch" maxlength="75" required />
                    </div>

                    <!-- Employee ID (Hidden field) -->
                    <input type="hidden" id="<portlet:namespace />employeeId" name="<portlet:namespace />employeeId" value="some_value" />

                    <!-- Bank Account ID (Hidden field) -->
                    <input type="hidden" id="<portlet:namespace />bankAccountId" name="<portlet:namespace />bankAccountId" value="some_value" />

                    <!-- Navigation buttons -->
                    <button class="btn btn-primary" type="button" onclick="navigateToStep(4)">Previous</button>
                    <button class="btn btn-primary" type="button" onclick="navigateToStep(6)">Next</button>
                </div>
            </div>

            <!-- Steps 6-7 would be updated similarly using the keys from language.properties -->

            <!-- Step 6 -->
            <div class="tab-pane fade" id="step6" role="tabpanel" aria-labelledby="step6-tab">
                <div class="mt-3">
                    <h4><liferay-ui:message key="uan-esic-details"/></h4>
                    
                    <!-- UAN (Universal Account Number) -->
                    <div class="mb-3">
                        <label for="uan" class="form-label">
                            <liferay-ui:message key="uan"/>
                        </label>
                        <input type="text" class="form-control" id="<portlet:namespace />uan" name="<portlet:namespace />uan" maxlength="12" required />
                    </div>

                    <!-- ESIC Number -->
                    <div class="mb-3">
                        <label for="esicNo" class="form-label">
                            <liferay-ui:message key="esic-no"/>
                        </label>
                        <input type="text" class="form-control" id="<portlet:namespace />esicNo" name="<portlet:namespace />esicNo" maxlength="17" required />
                    </div>

                    <!-- UAN ESIC ID (Hidden field) -->
                    <input type="hidden" id="<portlet:namespace />uanEscId" name="<portlet:namespace />uanEscId" value="some_value" />

                    <!-- Navigation buttons -->
                    <button class="btn btn-primary" type="button" onclick="navigateToStep(5)">Previous</button>
                    <button class="btn btn-primary" type="button" onclick="navigateToStep(7)">Next</button>
                </div>
            </div>

            <!-- Step 7 -->
            <div class="tab-pane fade" id="step7" role="tabpanel" aria-labelledby="step7-tab">
                <div class="mt-3">
                    <h4><liferay-ui:message key="nominee-details"/></h4>
                    
                    <!-- Nominee First Name -->
                    <div class="mb-3">
                        <label for="nomineeFirstName" class="form-label">
                            <liferay-ui:message key="nominee-first-name"/>
                        </label>
                        <input type="text" class="form-control" id="<portlet:namespace />nomineeFirstName" name="<portlet:namespace />nomineeFirstName" maxlength="75" required />
                    </div>

                    <!-- Nominee Last Name -->
                    <div class="mb-3">
                        <label for="nomineeLastName" class="form-label">
                            <liferay-ui:message key="nominee-last-name"/>
                        </label>
                        <input type="text" class="form-control" id="<portlet:namespace />nomineeLastName" name="<portlet:namespace />nomineeLastName" maxlength="75" required />
                    </div>

                    <!-- Nominee Contact -->
                    <div class="mb-3">
                        <label for="nomineeContact" class="form-label">
                            <liferay-ui:message key="nominee-contact"/>
                        </label>
                        <input type="text" class="form-control" id="<portlet:namespace />nomineeContact" name="<portlet:namespace />nomineeContact" maxlength="30" required />
                    </div>

                    <!-- Nominee Address (bigint, type: addressId) -->
                    <div class="mb-3">
                        <label for="nomineeAddress" class="form-label">
                            <liferay-ui:message key="nominee-address"/>
                        </label>
                        <input type="number" class="form-control" id="<portlet:namespace />nomineeAddress" name="<portlet:namespace />nomineeAddress" required />
                    </div>

                    <!-- Relationship with Nominee -->
                    <div class="mb-3">
                        <label for="relationshipWithNominee" class="form-label">
                            <liferay-ui:message key="relationship-with-nominee"/>
                        </label>
                        <input type="text" class="form-control" id="<portlet:namespace />relationshipWithNominee" name="<portlet:namespace />relationshipWithNominee" maxlength="75" required />
                    </div>

                    <!-- Nominee Date of Birth -->
                    <div class="mb-3">
                        <label for="nomineeDob" class="form-label">
                            <liferay-ui:message key="nominee-dob"/>
                        </label>
                        <input type="date" class="form-control" id="<portlet:namespace />nomineeDob" name="<portlet:namespace />nomineeDob" required />
                    </div>

                    <!-- Nominee ID (Hidden field) -->
                    <input type="hidden" id="<portlet:namespace />nomineeId" name="<portlet:namespace />nomineeId" value="some_value" />

                    <!-- Navigation buttons -->
                    <button class="btn btn-primary" type="button" onclick="navigateToStep(6)">Previous</button>
                    <button class="btn btn-primary" type="submit">Submit</button>
                </div>
            </div>
        </div>
    </form>
</div>

<script>
    // JavaScript function to navigate between steps
    function navigateToStep(stepNumber) {
        var tabSelector = '#step' + stepNumber + '-tab';
        document.querySelector(tabSelector).click();
    }
   
    document.querySelector('#stepperForm').addEventListener('submit', function(event) {
        event.preventDefault();
        alert('Form submitted successfully!');
    });
</script>

 