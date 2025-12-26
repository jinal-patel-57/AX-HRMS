(function ($, AxHrmsEmployeeOnboardingEmployeeWebPortlet) {
    let namespace;

    function setConfigsForRejectUrl(config) {
        namespace = config.namespace;
        let rejectUrl = employeeRejectUrl;
        let textValue = $('#' + namespace + 'review').val();
        rejectUrl = rejectUrl.replace('REVIEW', textValue);
        window.location.href = rejectUrl;
    }

//    function setConfigsForAddExperienceSection(config) {
//        namespace = config.namespace;
//
//        var originalSection = document.querySelector('.experience-section');
//        var newSection = originalSection.cloneNode(true);
//
//        var anchors = newSection.getElementsByTagName('a');
//        while (anchors.length > 0) {
//            var parent = anchors[0].parentNode;
//            while (anchors[0].firstChild) {
//                parent.insertBefore(anchors[0].firstChild, anchors[0]);
//            }
//            parent.removeChild(anchors[0]);
//        }
//
//        var inputs = newSection.querySelectorAll('input,select');
//        var index = document.querySelectorAll('.experience-section').length + 1;
//
//        var previous = document.getElementById("currentIndex").value
//        document.getElementById("currentIndex").value = 1 + parseInt(previous);
//
//        inputs.forEach(function (input) {
//
//            input.id = input.id.replace(/[0-9]+$/, '') + index;
//            input.name = input.name.replace(/\d+$/, '') + index;
//
//            input.value = '';
//        });
//
//        document.getElementById('experience-section-container').appendChild(newSection);
//        const redundantFooter = newSection.getElementsByClassName("card-footer");
//        if(redundantFooter.length >0){
//            redundantFooter[0].remove();
//        }
//
//        var deleteButton = document.createElement('button');
//        deleteButton.className = 'btn btn-outline-danger delete-section';
//        // deleteButton.textContent = 'Delete';
//        deleteButton.type = 'button';
//        const icon = document.createElement("i");
//        icon.className= "icon-trash";
//        deleteButton.appendChild(icon);
//
//        const footerExpDel = document.createElement("div");
//        footerExpDel.className="card-footer text-right";
//        footerExpDel.appendChild(deleteButton);
//        const card = newSection.getElementsByClassName("card")[0];
//        card.appendChild(footerExpDel);
//
//
//        deleteButton.addEventListener('click', function () {
//            newSection.remove();
//        });
//    }
function setConfigsForAddExperienceSection(config) {

    const namespace = config.namespace;

    const original = document.querySelector(".experience-section");
    const clone = original.cloneNode(true);

    clone.removeAttribute("data-experience-id");
    clone.querySelectorAll("a").forEach(a => a.remove());

    const index =
        document.querySelectorAll(".experience-section").length + 1;

    clone.querySelectorAll("input").forEach(input => {

        input.name = input.name.replace(/\d+$/, "") + index;

        if (input.type === "file") {
            const fresh = document.createElement("input");
            fresh.type = "file";
            fresh.className = input.className;
            fresh.name = input.name;
            fresh.accept = input.accept;
            input.parentNode.replaceChild(fresh, input);
        } else {
            input.value = "";
        }
    });

    const oldFooter = clone.querySelector(".card-footer");
    if (oldFooter) oldFooter.remove();

    const footer = document.createElement("div");
    footer.className = "card-footer text-right";

    const deleteBtn = document.createElement("button");
    deleteBtn.type = "button";
    deleteBtn.className = "btn btn-outline-danger delete-section";

    deleteBtn.innerHTML = '<i class="icon-trash"></i>';

    deleteBtn.addEventListener("click", function () {
        clone.remove();
    });

    footer.appendChild(deleteBtn);
    clone.querySelector(".card").appendChild(footer);

    document
        .getElementById("experience-section-container")
        .appendChild(clone);

    document.getElementById("currentIndex").value = index;
}


    function setConfigsForToggleAddress(config) {
        namespace = config.namespace;
        var sameAsPermanentCheckbox = document.getElementById(namespace + "sameAsPermanent");

        var permanentFields = {
            line1: document.getElementById(namespace + "permanentAddressLine1"),
            line2: document.getElementById(namespace + "permanentAddressLine2"),
            line3: document.getElementById(namespace + "permanentAddressLine3"),
            state: document.getElementById(namespace + "permanentState"),
            country: document.getElementById(namespace + "permanentCountry"),
            pincode: document.getElementById(namespace + "permanentPincode")
        };

        var presentFields = {
            line1: document.getElementById(namespace + "presentaddressLine1"),
            line2: document.getElementById(namespace + "presentaddressLine2"),
            line3: document.getElementById(namespace + "presentaddressLine3"),
            state: document.getElementById(namespace + "presentstate"),
            country: document.getElementById(namespace + "presentCountry"),
            pincode: document.getElementById(namespace + "presentpinCode")
        };

        if (sameAsPermanentCheckbox.checked) {
            presentFields.line1.value = permanentFields.line1.value;
            presentFields.line2.value = permanentFields.line2.value;
            presentFields.line3.value = permanentFields.line3.value;
            presentFields.state.value = permanentFields.state.value;
            presentFields.country.value = permanentFields.country.value;

            presentFields.pincode.value = permanentFields.pincode.value;

            Object.values(presentFields).forEach(function (field) {
                field.disabled = true;
            });
        } else {
            Object.values(presentFields).forEach(function (field) {
                field.disabled = false;
            });

            presentFields.line1.value = "";
            presentFields.line2.value = "";
            presentFields.line3.value = "";
            presentFields.state.value = "";
            presentFields.country.value = "";
            presentFields.pincode.value = "";
        }
    }

    function setConfigsForValidation(config) {
        namespace = config.namespace;
        config.profilePicName = profilePicName;
        $(document).ready(function () {

        // Custom age validation
        $.validator.addMethod("ageRange", function (value, element) {
            if (!value) return false;

            let dob = new Date(value);
            let today = new Date();

            let age = today.getFullYear() - dob.getFullYear();
            let monthDiff = today.getMonth() - dob.getMonth();

            if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < dob.getDate())) {
                age--;
            }

            return age >= 18 && age <= 60;
        }, "Age must be between 18 and 60 years.");

            var $form1 = $("#stepperForm");
            $form1.validate({
                errorClass: 'is-invalid',
                validClass: 'is-valid',
                errorElement: 'div',
                errorPlacement: function (error, element) {
                    error.addClass('invalid-feedback');
                    element.after(error);
                },
                rules: {
                    [namespace + "personalEmail"]: {
                        required: true,
                        email: true
                    },
                    [namespace + "dateOfBirth"]: {
                        required: true,
                        date: true,
                        ageRange: true
                    },
                    [namespace + "mobileNo"]: {
                        required: true,
                        digits: true,
                        minlength: 10,
                        maxlength: 15
                    },

                    [namespace + "fatherName"]: {
                        required: true
                    },
                    [namespace + "marriageDate"]: {
                        required: function () {
                            return $("#" + namespace + "maritalStatus").is(":checked");
                        },
                        date: true
                    },
                    [namespace + "employeeProfilePicture"]: {
                        profilePicRequired: true,
                        required: function () {
                            return !profilePicName || profilePicName.trim() === "";
                        }
                    },



                    [namespace + "spouseName"]: {
                        required: function () {
                            return $("#" + namespace + "maritalStatus").is(":checked");
                        }
                    }
                },
                messages: {
                    [namespace + "personalEmail"]: {
                        required: "Please enter your personal email.",
                        email: "Please enter a valid email address."
                    },
                    [namespace + "dateOfBirth"]: {
                        required: "Please enter your date of birth.",
                        date: "Please enter a valid date.",
                        ageRange: "Age must be between 18 and 60 years."
                    },
                    [namespace + "mobileNo"]: {
                        required: "Please enter your mobile number.",
                        digits: "Mobile number should contain only digits.",
                        minlength: "Mobile number must be at least 10 digits long.",
                        maxlength: "Mobile number must not exceed 15 digits."
                    },
                    [namespace + "employeeProfilePicture"]: {
                        profilePicRequired: "Please select a profile picture jinal"
                    },

                    [namespace + "fatherName"]: {
                        required: "Please Enter FatherName."
                    },
                    [namespace + "marriageDate"]: {
                        required: "Please enter your marriage date.",
                        date: "Please enter a valid date."
                    },
                    [namespace + "employeeProfilePicture"]: {
                        required: "Please select a profile picture."
                    },

                    [namespace + "spouseName"]: {
                        required: "Please enter your spouse's name."
                    }
                }
            });

            $.validator.addMethod("lettersOnly", function (value, element) {
                return this.optional(element) || /^[A-Za-z\s]+$/i.test(value);
            }, "Only letters are allowed for Father's Name.");

            $("#" + namespace + "fatherName").rules("add", {
                lettersOnly: true
            });
            $.validator.addMethod("profilePicRequired", function (value, element) {
		    	if (profilePicName) {
		        	return true; // already uploaded earlier
		    	}
		    	return element.files && element.files.length > 0; }, 
		    "Please select a profile picture jinal");

//            var fileInput = document.getElementById(namespace + 'employeeProfilePicture');
//
//            const myFile = new File([''], profilePicName, {
//                type: 'text/plain',
//                lastModified: new Date(),
//            });
//            const dataTransfer = new DataTransfer();
//            dataTransfer.items.add(myFile);
//            fileInput.files = dataTransfer.files;


            $('.next-button-basic-details').on('click', function (event) {
                event.preventDefault();
                var form1 = $('#stepperForm');
                if (!form1.valid()) {
                    return;
                }

                var formData = new FormData(form1[0]);

                $.ajax({
                    url: form1.attr('action'),
                    method: 'POST',
                    data: formData,
                    contentType: false,
                    processData: false,
                    success: function (response) {
                        debugger;
                        let currentTab = $('.nav-link.active');
                        let nextTabButton = currentTab.parent().next().find('.nav-link');
                        if (nextTabButton.length > 0) {
                            nextTabButton.tab('show');
                            var nextTabContentId = nextTabButton.attr('data-bs-target');
                            $(nextTabContentId).addClass('show active');
                            $(currentTab.attr('data-bs-target')).removeClass('show active');
                            $(nextTabContentId).find('input').first().focus();
                        }
                    },
                    error: function () {
                        console.log('There was an error saving the data. Please try again.');
                    }
                });
            });
            
            $('.previous-button').on('click', function (event) {
		        debugger;
		        event.preventDefault();
		        const currentTab = $('.nav-link.active');
		        const previousTabButton = currentTab.parent().prev().find('.nav-link');
		        if (previousTabButton.length > 0) {
		            previousTabButton.tab('show');
		            const previousTabContentId = previousTabButton.attr('data-bs-target');
		            $(previousTabContentId).addClass('show active');
		            $(currentTab.attr('data-bs-target')).removeClass('show active');
		            $(previousTabContentId).find('input').first().focus();
		        }
		    });

            function toggleMaritalStatusFields() {
                var maritalStatusCheckbox = $("#" + namespace + "maritalStatus");
                var marriageDateField = $("#" + namespace + "marriageDate");
                var spouseNameField = $("#" + namespace + "spouseName");
                if (maritalStatusCheckbox.is(":checked")) {
                    spouseNameField.prop("disabled", false);
                    marriageDateField.prop("disabled", false);
                    marriageDateField.rules("add", {required: true, date: true});
                    spouseNameField.rules("add", {required: true});
                } else {
                    marriageDateField.prop("disabled", true);
                    spouseNameField.prop("disabled", true);
                    marriageDateField.val("");
                    spouseNameField.val("");
                    marriageDateField.rules("remove", "required date");
                    spouseNameField.rules("remove", "required");
                    marriageDateField.removeClass("is-invalid");
                    spouseNameField.removeClass("is-invalid");
                    marriageDateField.siblings(".invalid-feedback").remove();
                    spouseNameField.siblings(".invalid-feedback").remove();
                }
            }

            toggleMaritalStatusFields();
            $("#" + namespace + "maritalStatus").on("change", toggleMaritalStatusFields);
            AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForValidation = setConfigsForValidation;
        });
    }


    

    function setConfigsForAddressValidation(config) {
        const namespace = config.namespace;
        $(document).ready(function () {
            const $form2 = $("#addressStepperForm");
            $form2.validate({
                errorClass: 'is-invalid',
                validClass: 'is-valid',
                errorElement: 'div',
                errorPlacement: function (error, element) {
                    error.addClass('invalid-feedback');
                    element.after(error);
                },
                rules: {
                    [namespace + "permanentAddressLine1"]: {
                        required: true,
                        maxlength: 250
                    },
                    [namespace + "permanentAddressLine2"]: {
                        maxlength: 250
                    },
                    [namespace + "permanentAddressLine3"]: {
                        maxlength: 250
                    },
                    [namespace + "permanentState"]: {
                        required: true,
                        maxlength: 100
                    },
                    [namespace + "permanentCountry"]: {
                        required: true
                    },
                    [namespace + "permanentPincode"]: {
                        required: true,
                        digits: true,
                        minlength: 5,
                        maxlength: 10
                    },
                    [namespace + "presentaddressLine1"]: {
                        required: true,
                        maxlength: 250
                    },
                    [namespace + "presentaddressLine2"]: {
                        maxlength: 250
                    },
                    [namespace + "presentaddressLine3"]: {
                        maxlength: 250
                    },
                    [namespace + "presentstate"]: {
                        required: true,
                        maxlength: 100
                    },
                    [namespace + "presentCountry"]: {
                        required: true
                    },
                    [namespace + "presentpinCode"]: {
                        required: true,
                        digits: true,
                        minlength: 5,
                        maxlength: 10
                    }
                },
                messages: {
                    [namespace + "permanentAddressLine1"]: {
                        required: "Please enter the permanent address line 1.",
                        maxlength: "Address line 1 cannot exceed 250 characters."
                    },
                    [namespace + "permanentAddressLine2"]: {
                        maxlength: "Address line 2 cannot exceed 250 characters."
                    },
                    [namespace + "permanentAddressLine3"]: {
                        maxlength: "Address line 3 cannot exceed 250 characters."
                    },
                    [namespace + "permanentState"]: {
                        required: "Please enter the state for the permanent address.",
                        maxlength: "State name cannot exceed 100 characters."
                    },
                    [namespace + "permanentCountry"]: {
                        required: "Please select a country for the permanent address."
                    },
                    [namespace + "permanentPincode"]: {
                        required: "Please enter the pincode for the permanent address.",
                        digits: "Pincode should contain only digits.",
                        minlength: "Pincode must be at least 5 digits long.",
                        maxlength: "Pincode cannot exceed 10 digits."
                    },
                    [namespace + "presentaddressLine1"]: {
                        required: "Please enter the present address line 1.",
                        maxlength: "Address line 1 cannot exceed 250 characters."
                    },
                    [namespace + "presentaddressLine2"]: {
                        maxlength: "Address line 2 cannot exceed 250 characters."
                    },
                    [namespace + "presentaddressLine3"]: {
                        maxlength: "Address line 3 cannot exceed 250 characters."
                    },
                    [namespace + "presentstate"]: {
                        required: "Please enter the state for the present address.",
                        maxlength: "State name cannot exceed 100 characters."
                    },
                    [namespace + "presentCountry"]: {
                        required: "Please select a country for the present address."
                    },
                    [namespace + "presentpinCode"]: {
                        required: "Please enter the pincode for the present address.",
                        digits: "Pincode should contain only digits.",
                        minlength: "Pincode must be at least 5 digits long.",
                        maxlength: "Pincode cannot exceed 10 digits."
                    }
                }
            });

            $('.next-button-adress-details').on('click', function (event) {
                event.preventDefault();
                const form2 = $('#addressStepperForm');
                if (!form2.valid()) {
                    return;
                }
                $.ajax({
                    url: form2.attr('action'),
                    method: 'POST',
                    data: form2.serialize(),
                    success: function (response) {
                        const currentTab = $('.nav-link.active');
                        document.getElementById("updateFlagAddress").value = "true";
                        const nextTabButton = currentTab.parent().next().find('.nav-link');
                        if (nextTabButton.length > 0) {
                            nextTabButton.tab('show');
                            const nextTabContentId = nextTabButton.attr('data-bs-target');
                            $(nextTabContentId).addClass('show active');
                            $(currentTab.attr('data-bs-target')).removeClass('show active');
                            $(nextTabContentId).find('input').first().focus();
                        }
                    },
                    error: function () {
                        console.log('There was an error saving the data. Please try again.');
                    }
                });
            });
            AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForAddressValidation = setConfigsForAddressValidation;
        });
    }


    function setConfigsForEducationValidation(config) {

        var namespace = config.namespace;
        var educationIndex = config.educationIndex;

        $(document).ready(function () {

            let rules = {};
            let messages = {};

            // ======================================================
            // VALIDATION INITIALIZER
            // ======================================================
            function initializeValidation() {

                const form3 = $("#educationStepperForm");
                rules = {};
                messages = {};

                document.querySelectorAll('.education-section').forEach((section, index) => {

                    const idx = index + 1;

                    const levelNameKey = `${namespace}levelName${idx}`;
                    const institutionKey = `${namespace}institution${idx}`;
                    const degreeKey = `${namespace}degree${idx}`;
                    const startDateKey = `${namespace}startDate${idx}`;
                    const endDateKey = `${namespace}endDate${idx}`;
                    const passingYearKey = `${namespace}passingYear${idx}`;

                    rules[levelNameKey] = {required: true};
                    rules[institutionKey] = {required: true, maxlength: 250};
                    rules[degreeKey] = {required: true, maxlength: 75};
                    rules[startDateKey] = {required: true, date: true};
                    rules[endDateKey] = {required: true, date: true};
                    rules[passingYearKey] = {
                        required: true,
                        digits: true,
                        minlength: 4,
                        maxlength: 4
                    };

                    messages[levelNameKey] = {
                        required: "Please select an education level name."
                    };
                    messages[institutionKey] = {
                        required: "Please enter institution name.",
                        maxlength: "Institution name must not exceed 250 characters."
                    };
                    messages[degreeKey] = {
                        required: "Please enter degree.",
                        maxlength: "Degree must not exceed 75 characters."
                    };
                    messages[startDateKey] = {
                        required: "Please enter start date.",
                        date: "Enter a valid date."
                    };
                    messages[endDateKey] = {
                        required: "Please enter end date.",
                        date: "Enter a valid date."
                    };
                    messages[passingYearKey] = {
                        required: "Please enter passing year.",
                        digits: "Only digits allowed.",
                        minlength: "Year must be 4 digits.",
                        maxlength: "Year must be 4 digits."
                    };
                });

                form3.validate({
                    errorClass: 'is-invalid',
                    validClass: 'is-valid',
                    errorElement: 'div',
                    errorPlacement: function (error, element) {
                        error.addClass('invalid-feedback');
                        element.after(error);
                    },
                    rules: rules,
                    messages: messages
                });
            }

            // ======================================================
            // RESTORE TAB POSITION IF NEEDED
            // ======================================================
            try {
                const index_edu = parseInt(educationIndex);
                for (let i = 1; i < index_edu; i++) {
                    $('.nav-link.active').parent().next().find('.nav-link').click();
                }
            } catch (err) {
                console.log("error", err);
            }


            // ======================================================
            // ADD EDUCATION SECTION (CLONING)
            // ======================================================
            function addEducationSection() {

                const originalSection = document.getElementById('initial-education-section');
                const newSection = originalSection.cloneNode(true);

                // Remove anchor tags (existing previews)
                newSection.querySelectorAll("a").forEach(a => a.remove());

                const index = document.querySelectorAll('.education-section').length + 1;

                newSection.querySelectorAll("input, select").forEach(input => {

                    // Set new ID & name
                    if (input.id) {
                        input.id = input.id.replace(/[0-9]+$/, '') + index;
                    }
                    if (input.name) {
                        input.name = input.name.replace(/[0-9]+$/, '') + index;
                    }

                    // Handle file input safely
                    if (input.type === "file") {
                        const freshFile = document.createElement("input");
                        freshFile.type = "file";
                        freshFile.className = input.className;
                        freshFile.id = input.id;
                        freshFile.name = input.name;
                        input.parentNode.replaceChild(freshFile, input);
                    }
                    // Reset select
                    else if (input.tagName.toLowerCase() === "select") {
                        input.selectedIndex = 0;
                    }
                    // Reset text/date
                    else {
                        input.value = "";
                    }
                });

                // Remove older footer if present
                const oldFooter = newSection.querySelector(".card-footer");
                if (oldFooter) oldFooter.remove();

                // Add delete button for new section
                const footer = document.createElement("div");
                footer.className = "card-footer text-right";

                const deleteBtn = document.createElement("button");
                deleteBtn.type = "button";
                deleteBtn.className = "btn btn-outline-danger delete-section";

                const icon = document.createElement("i");
                icon.className = "icon-trash";

                deleteBtn.appendChild(icon);
                footer.appendChild(deleteBtn);

                deleteBtn.onclick = function () {
                    newSection.remove();
                    initializeValidation();
                };

                newSection.querySelector(".card").appendChild(footer);

                document.getElementById("education-section-container").appendChild(newSection);

                // Update index
                document.getElementById("educationCurrentIndex").value = index;

                initializeValidation();
            }


            // Add section button
            document.getElementById("add-education-section")
                .addEventListener("click", addEducationSection);


            // ======================================================
            // SUBMIT BUTTON (AJAX WITH FILE SUPPORT)
            // ======================================================
            $('.next-button-education-details').on('click', function (event) {

                initializeValidation();
                const form3 = $('#educationStepperForm');

                if (!form3.valid()) {
                    return false;
                }

                // Use FormData to support file upload
                const formData = new FormData(form3[0]);

                $.ajax({
                    url: form3.attr("action"),
                    method: "POST",
                    data: formData,
                    contentType: false,
                    processData: false,
                    success: function () {

                        const currentTab = $('.nav-link.active');
                        document.getElementById("firstVisitEducation").value = "false";

                        const nextTabButton = currentTab.parent().next().find('.nav-link');

                        if (nextTabButton.length > 0) {
                            nextTabButton.tab("show");

                            const nextId = nextTabButton.attr("data-bs-target");
                            
                            $(nextId).addClass('show active');
                            $(currentTab.attr('data-bs-target')).removeClass('show active');
                            
                            $(nextId).find("input").first().focus();
                        }
                    },
                    error: function () {
                        console.log("Error saving data. Please try again.");
                    }
                });
            });

        });
    }



//    function setConfigsForExperienceValidation(config) {
//        config.experienceIndex = experienceIndex;
//
//        $(document).ready(function () {
//            let rules = {};
//            let messages = {};
//
//            // Relieving date must be after joining date (section-wise)
//            $.validator.addMethod("afterJoiningDate", function (value, element, params) {
//
//                if (!value) return true;
//
//                const relievingDate = new Date(value);
//                const joiningInput = document.getElementById(params);
//
//                if (!joiningInput || !joiningInput.value) return true;
//
//                const joiningDate = new Date(joiningInput.value);
//
//                return relievingDate > joiningDate;
//
//            }, "Relieving date must be after joining date.");
//
//
//            function initializeValidationForExperience() {
//                const form4 = $("#experienceStepperForm");
//
//                document.querySelectorAll('.experience-section').forEach((section, index) => {
//                    const idx = index + 1;
//                    const companyNameKey = `${namespace}companyName${idx}`;
//                    const joiningDateKey = `${namespace}joiningDate${idx}`;
//                    const relievingDateKey = `${namespace}relievingDate${idx}`;
//                    rules[companyNameKey] = {required: true};
//                    rules[joiningDateKey] = {required: true, date: true};
//                    rules[relievingDateKey] = {
//                        required: true,
//                        date: true,
//                        afterJoiningDate: `${namespace}joiningDate${idx}`
//                    };
//
//
//                    messages[companyNameKey] = {
//                        required: "Please select Company Name."
//                    };
//
//                    messages[joiningDateKey] = {
//                        required: "Please enter the start date.",
//                        date: "Please enter a valid date."
//                    };
//                   messages[relievingDateKey] = {
//                       required: "Please enter the end date.",
//                       date: "Please enter a valid date.",
//                       afterJoiningDate: "Relieving date must be after joining date."
//                   };
//
//                });
//
//
//                form4.validate({
//                    errorClass: 'is-invalid',
//                    validClass: 'is-valid',
//                    errorElement: 'div',
//                    errorPlacement: function (error, element) {
//                        error.addClass('invalid-feedback');
//                        element.after(error);
//                    },
//                    rules: rules,
//                    messages: messages
//                });
//
//            }
//
//            try {
//                var index_experience = parseInt(experienceIndex);
//                for (var i = 1; i < index_experience; i++) {
//                    $('.nav-link.active').parent().next().find('.nav-link').click();
//                }
//            } catch (err) {
//                console.log(err);
//            }
//
//            $('.next-button-experience-details').on('click', function (event) {
//                initializeValidationForExperience();
//                event.preventDefault();
//                const form4 = $('#experienceStepperForm');
//                if (!form4.valid()) {
//                    return false;
//                }
//
//                var formData = new FormData(form4[0]);
//
//                $.ajax({
//                    url: form4.attr('action'),
//                    data: formData,
//                    method: 'POST',
//                    contentType: false,
//                    processData: false,
//                    success: function (response) {
//                        const currentTab = $('.nav-link.active');
//                        document.getElementById("firstVisit").value = "false";
//                        const nextTabButton = currentTab.parent().next().find('.nav-link');
//                        if (nextTabButton.length > 0) {
//                            nextTabButton.tab('show');
//                            const nextTabContentId = nextTabButton.attr('data-bs-target');
//                            $(nextTabContentId).addClass('show active');
//                            $(currentTab.attr('data-bs-target')).removeClass('show active');
//                            $(nextTabContentId).find('input').first().focus();
//                        }
//                    },
//                    error: function () {
//                        console.log('There was an error saving the data. Please try again.');
//                    }
//                });
//            });
//        });
//        AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForExperienceValidation = setConfigsForExperienceValidation;
//    }

function setConfigsForExperienceValidation(config) {

    const namespace = config.namespace;

    $(document).ready(function () {

        /* ================= VALIDATION ================= */

        $.validator.addMethod(
            "afterJoiningDate",
            function (value, element, joiningInputName) {

                if (!value) return true;

                const joiningInput =
                    document.getElementsByName(joiningInputName)[0];

                if (!joiningInput || !joiningInput.value) return true;

                return new Date(value) > new Date(joiningInput.value);
            },
            "Relieving date must be after joining date."
        );

        function initializeValidation() {

            const form = $("#experienceStepperForm");
            form.removeData("validator");

            let rules = {};
            let messages = {};

            document
                .querySelectorAll(".experience-section")
                .forEach((section, index) => {

                    const idx = index + 1;

                    const company = `${namespace}companyName${idx}`;
                    const joining = `${namespace}joiningDate${idx}`;
                    const relieving = `${namespace}relievingDate${idx}`;

                    rules[company] = { required: true };
                    rules[joining] = { required: true, date: true };
                    rules[relieving] = {
                        required: true,
                        date: true,
                        afterJoiningDate: joining
                    };

                    messages[company] = {
                        required: "Please enter company name."
                    };
                    messages[joining] = {
                        required: "Please enter joining date."
                    };
                    messages[relieving] = {
                        required: "Please enter relieving date.",
                        afterJoiningDate:
                            "Relieving date must be after joining date."
                    };
                });

            form.validate({
                errorClass: "is-invalid",
                validClass: "is-valid",
                errorElement: "div",
                errorPlacement: function (error, element) {
                    error.addClass("invalid-feedback");
                    element.after(error);
                },
                rules: rules,
                messages: messages
            });
        }

        /* ================= ADD EXPERIENCE SECTION ================= */

//        $("#add-experience-section").on("click", function () {
//
//            const original =
//                document.getElementById("initial-experience-section");
//
//            const clone = original.cloneNode(true);
//
//            clone.querySelectorAll("a").forEach(a => a.remove());
//
//            const index =
//                document.querySelectorAll(".experience-section").length + 1;
//
//            clone.querySelectorAll("input").forEach(input => {
//
//                input.name =
//                    input.name.replace(/\d+$/, "") + index;
//
//                if (input.type === "file") {
//                    const fresh = document.createElement("input");
//                    fresh.type = "file";
//                    fresh.className = input.className;
//                    fresh.name = input.name;
//                    fresh.accept = input.accept;
//                    input.parentNode.replaceChild(fresh, input);
//                } else {
//                    input.value = "";
//                }
//            });
//
//            document
//                .getElementById("experience-section-container")
//                .appendChild(clone);
//
//            document.getElementById("currentIndex").value = index;
//
//            initializeValidation();
//        });

        /* ================= SUBMIT ================= */

        $(".next-button-experience-details").on("click", function () {

            initializeValidation();

            const form = $("#experienceStepperForm");
            if (!form.valid()) return;

            const formData = new FormData(form[0]);

            $.ajax({
                url: form.attr("action"),
                type: "POST",
                data: formData,
                processData: false,
                contentType: false,
                success: function () {

                    const currentTab = $('.nav-link.active');
                    const nextTabButton = currentTab.parent().next().find('.nav-link');

                    if (nextTabButton.length > 0) {

                        nextTabButton.tab('show');

                        const nextTabContentId = nextTabButton.attr('data-bs-target');

                        $(nextTabContentId).addClass('show active');
                        $(currentTab.attr('data-bs-target')).removeClass('show active');

                        $(nextTabContentId).find('input,select').first().focus();
                    }
                },
                error: function () {
                    console.error("Error saving experience (HR)");
                }
            });
        });

    });
}


    // bank account details
    function setConfigsForBankAccountValidation(config) {
        var $form5 = $("#bankAccountStepperForm");
        $form5.validate({
            errorClass: 'is-invalid',
            validClass: 'is-valid',
            errorElement: 'div',
            errorPlacement: function (error, element) {
                error.addClass('invalid-feedback');
                element.after(error);
            },
            rules: {
                [namespace + "accountNumber"]: {
                    required: true,
                    maxlength: 75,
                    accountNumberValidation: true
                },

                [namespace + "beneficiaryName"]: {
                    required: true,
                    maxlength: 75
                },
                [namespace + "bankName"]: {
                    required: true,
                    maxlength: 75
                },
                [namespace + "ifscCode"]: {
                    required: true,
                    maxlength: 75,
                    ifscCodeValidation: true
                },
                [namespace + "bankBranch"]: {
                    required: true,
                    maxlength: 75
                }
            },
            messages: {
                [namespace + "accountNumber"]: {
                    required: "Please enter the account number.",
                    maxlength: "Account number should not exceed 75 characters.",
                    accountNumberValidation: "Account number should not contain alphabet characters, underscores, special characters, or whitespaces."
                },

                [namespace + "beneficiaryName"]: {
                    required: "Please enter the beneficiary name.",
                    maxlength: "Beneficiary name should not exceed 75 characters."
                },
                [namespace + "bankName"]: {
                    required: "Please enter the bank name.",
                    maxlength: "Bank name should not exceed 75 characters."
                },
                [namespace + "ifscCode"]: {
                    required: "Please enter the IFSC code.",
                    maxlength: "IFSC code should not exceed 75 characters.",
                    ifscCodeValidation: "Please enter a valid IFSC code (Format: AAAA0BBBBBB)"
                },
                [namespace + "bankBranch"]: {
                    required: "Please enter the bank branch.",
                    maxlength: "Bank branch should not exceed 75 characters."
                }
            }
        });

        $.validator.addMethod("accountNumberValidation", function (value, element) {
            return /^[0-9]*$/.test(value);
        }, "Account number should not contain alphabet characters, underscores, special characters, or whitespaces.");

		$.validator.addMethod("ifscCodeValidation", function (value, element) {
      		return (value == '') || /^[A-Z]{4}0[A-Z0-9]{6}$/.test(value);
    	}, "Please enter a valid IFSC code (Format: AAAA0BBBBBB)");

        $('.next-button-bank-account-details').on('click', function (event) {
            event.preventDefault();
            const form5 = $('#bankAccountStepperForm');
//            if (!form5.valid()) {
//                return;
//            }
            $.ajax({
                url: form5.attr('action'),
                method: 'POST',
                data: form5.serialize(),
                success: function (response) {
                    const currentTab = $('.nav-link.active');
                    document.getElementById("updateFlagBank").value = "true";
                    const nextTabButton = currentTab.parent().next().find('.nav-link');
                    if (nextTabButton.length > 0) {
                        nextTabButton.tab('show');
                        const nextTabContentId = nextTabButton.attr('data-bs-target');
                        $(nextTabContentId).addClass('show active');
                        $(currentTab.attr('data-bs-target')).removeClass('show active');
                        $(nextTabContentId).find('input').first().focus();
                    }
                },
                error: function () {
                    console.log('There was an error saving the data. Please try again.');
                }
            });
        });
        AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForBankAccountValidation = setConfigsForBankAccountValidation;
    }

    // uanEsic Details
    function setConfigsForUanEsicValidation() {
		var form6 = $('#uanEsicStepperForm');
		
		form6.validate({
            errorClass: 'is-invalid',
            validClass: 'is-valid',
            errorElement: 'div',
            errorPlacement: function (error, element) {
                error.addClass('invalid-feedback');
                element.after(error);
            },
            rules: {
                [namespace + "uan"]: {
                    maxlength: 75,
                    uanValidation: true
                },

                [namespace + "esicNo"]: {
                    maxlength: 75,
                    esicValidation: true
                }
            },
            messages: {
                [namespace + "uan"]: {
                    maxlength: "UAN should not exceed 75 characters.",
                    uanValidation: "UAN must be exactly 12 digits (numbers only, no spaces or special characters)"
                },
                [namespace + "esicNo"]: {
                    maxlength: "ESIC No. should not exceed 75 characters.",
                    esicValidation: "ESIC number must be exactly 17 digits (numbers only, no spaces or special characters)"
                }
            }
        });

        $.validator.addMethod("uanValidation", function (value, element) {
        	return this.optional(element) || /^[0-9]{12}$/.test(value); 
        }, "UAN must be exactly 12 digits (numbers only, no spaces or special characters)");

		$.validator.addMethod("esicValidation", function (value, element) {
	        return this.optional(element) || /^[0-9]{17}$/.test(value); 
	    }, "ESIC number must be exactly 17 digits (numbers only, no spaces or special characters)");
    	
		
        $('.next-button-uan-esic-details').on('click', function (event) {
            event.preventDefault();
            if (!form6.valid()) {
                return;
            }
            $.ajax({
                url: form6.attr('action'),
                method: 'POST',
                data: form6.serialize(),
                success: function (response) {
                    const currentTab = $('.nav-link.active');
                    document.getElementById("updateFlagUanEsic").value = "true";
                    const nextTabButton = currentTab.parent().next().find('.nav-link');
                    if (nextTabButton.length > 0) {
                        nextTabButton.tab('show');
                        const nextTabContentId = nextTabButton.attr('data-bs-target');
                        $(nextTabContentId).addClass('show active');
                        $(currentTab.attr('data-bs-target')).removeClass('show active');
                        $(nextTabContentId).find('input').first().focus();
                    }
                },
                error: function () {
                    console.log('There was an error saving the data. Please try again.');
                }
            });
        });

        AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForUanEsicValidation = setConfigsForUanEsicValidation;
    }

    // Nominee Details
    function setConfigsForNomineeValidation(config) {
        let getEmployeeUrl = config.getEmployeeUrl;
        var $form7 = $("#nomineeStepperForm");
        $form7.validate({
            errorClass: 'is-invalid',
            validClass: 'is-valid',
            errorElement: 'div',
            errorPlacement: function (error, element) {
                error.addClass('invalid-feedback');
                element.after(error);
            },
            rules: {
                [namespace + "nomineeFirstName"]: {
                    required: true,
                    maxlength: 75
                },
                [namespace + "nomineeLastName"]: {
                    required: true,
                    maxlength: 75
                },
                [namespace + "nomineeContact"]: {
                    required: true,
                    maxlength: 30,
                    digits: true // If the contact number should contain only digits
                },
                [namespace + "presentaddressLine1"]: {
                    required: true,
                    maxlength: 250
                },
                [namespace + "presentaddressLine2"]: {
                    required: true,
                    maxlength: 250
                },
                [namespace + "presentaddressLine3"]: {
                    required: true,
                    maxlength: 250
                },
                [namespace + "presentstate"]: {
                    required: true,
                    maxlength: 100
                },
                [namespace + "presentCountry"]: {
                    required: true
                },
                [namespace + "presentpinCode"]: {
                    required: true,
                    digits: true,
                    minlength: 5,
                    maxlength: 10
                },
                [namespace + "relationshipWithNominee"]: {
                    required: true,
                    maxlength: 75
                },
                [namespace + "nomineeDob"]: {
                    required: true,
                    date: true
                }
            },
            messages: {
                [namespace + "nomineeFirstName"]: {
                    required: "Please enter the nominee's first name.",
                    maxlength: "First name should not exceed 75 characters."
                },
                [namespace + "nomineeLastName"]: {
                    required: "Please enter the nominee's last name.",
                    maxlength: "Last name should not exceed 75 characters."
                },
                [namespace + "nomineeContact"]: {
                    required: "Please enter the nominee's contact number.",
                    maxlength: "Contact number should not exceed 30 characters.",
                    digits: "Contact number should contain only digits."
                },
                [namespace + "nomineeAddress"]: {
                    required: "Please enter the nominee's address ID.",
                    digits: "Address ID should contain only digits."
                },
                [namespace + "presentaddressLine1"]: {
                    required: "Please enter the present address line 1.",
                    maxlength: "Address line 1 cannot exceed 250 characters."
                },
                [namespace + "presentaddressLine2"]: {
                    required: "Please enter the present address line 2.",
                    maxlength: "Address line 2 cannot exceed 250 characters."
                },
                [namespace + "presentaddressLine3"]: {
                    required: "Please enter the present address line 3.",
                    maxlength: "Address line 3 cannot exceed 250 characters."
                },
                [namespace + "presentstate"]: {
                    required: "Please enter the state for the present address.",
                    maxlength: "State name cannot exceed 100 characters."
                },
                [namespace + "presentCountry"]: {
                    required: "Please select a country for the present address."
                },
                [namespace + "presentpinCode"]: {
                    required: "Please enter the pincode for the present address.",
                    digits: "Pincode should contain only digits.",
                    minlength: "Pincode must be at least 5 digits long.",
                    maxlength: "Pincode cannot exceed 10 digits."
                },
                [namespace + "relationshipWithNominee"]: {
                    required: "Please enter the relationship with the nominee.",
                    maxlength: "Relationship should not exceed 75 characters."
                },
                [namespace + "nomineeDob"]: {
                    required: "Please enter the nominee's date of birth.",
                    date: "Please enter a valid date."
                }
            }
        });

        $('.next-button-nominee-details').on('click', function (event) {
            event.preventDefault();
            const form7 = $('#nomineeStepperForm');
            if (!form7.valid()) {
                return;
            }
            $.ajax({
                url: form7.attr('action'),
                method: 'POST',
                data: form7.serialize(),
                success: function (response) {
                    form7.hide();
//                    window.location.href = getEmployeeUrl;
                    const questionMarkIndex = window.location.href.indexOf('?');
					if (questionMarkIndex !== -1) {
					    const cleanURL = window.location.href.substring(0, questionMarkIndex);
					    window.location.href = cleanURL;
					}
                    document.getElementById("employeeOnBorading").style.display = "none";
                },
                error: function () {
                    console.log('There was an error saving the data. Please try again.');
                }
            });
        });
        AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForNomineeValidation = setConfigsForNomineeValidation;
    }

    AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForRejectUrl = setConfigsForRejectUrl;
    AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForAddExperienceSection = setConfigsForAddExperienceSection;
    AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForToggleAddress = setConfigsForToggleAddress;
    AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForValidation = setConfigsForValidation;
    AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForAddressValidation = setConfigsForAddressValidation;
    AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForEducationValidation = setConfigsForEducationValidation;
    AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForExperienceValidation = setConfigsForExperienceValidation;
    AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForBankAccountValidation = setConfigsForBankAccountValidation;
    AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForUanEsicValidation = setConfigsForUanEsicValidation;
    AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForNomineeValidation = setConfigsForNomineeValidation;

})($, window.AxHrmsEmployeeOnboardingEmployeeWebPortlet || (window.AxHrmsEmployeeOnboardingEmployeeWebPortlet = {}));