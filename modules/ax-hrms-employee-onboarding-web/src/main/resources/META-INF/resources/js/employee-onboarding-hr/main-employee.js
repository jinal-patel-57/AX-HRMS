(function ($, AxHrmsEmployeeOnboardingEmployeeWebPortlet) {
    let namespace;

    function setConfigsForRejectUrl(config) {
        namespace = config.namespace;
        let rejectUrl = employeeRejectUrl;
        let textValue = $('#' + namespace + 'review').val();
        rejectUrl = rejectUrl.replace('REVIEW', textValue);
        window.location.href = rejectUrl;
    }


function setConfigsForAddExperienceSection(config) {

    const namespace = config.namespace;

    const original = document.querySelector(".experience-section");
    console.log("original :: ",original)
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
            fresh.multiple=true;
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
	    const namespace = config.namespace;
	
	    const sameAsPermanentCheckbox =
	        document.getElementById(namespace + "sameAsPermanent");
	
	    const permanentFields = {
	        line1: document.getElementById(namespace + "permanentAddressLine1"),
	        line2: document.getElementById(namespace + "permanentAddressLine2"),
	        line3: document.getElementById(namespace + "permanentAddressLine3"),
	        city: document.getElementById(namespace + "permanentCity"),
	        state: document.getElementById(namespace + "permanentState"),
	        country: document.getElementById(namespace + "permanentCountry"),
	        pincode: document.getElementById(namespace + "permanentPincode")
	    };
	
	    const presentFields = {
	        line1: document.getElementById(namespace + "presentaddressLine1"),
	        line2: document.getElementById(namespace + "presentaddressLine2"),
	        line3: document.getElementById(namespace + "presentaddressLine3"),
	        city: document.getElementById(namespace + "presentCity"),
	        state: document.getElementById(namespace + "presentstate"),
	        country: document.getElementById(namespace + "presentCountry"),
	        pincode: document.getElementById(namespace + "presentpinCode")
	    };
	
	    // -------------------------
	    // Sync handler
	    // -------------------------
	    function syncIfChecked() {
	        if (sameAsPermanentCheckbox.checked) {
	            copyPermanentToPresent(permanentFields, presentFields);
	        }
	    }
	
	    // -------------------------
	    // Checkbox toggle
	    // -------------------------
	    sameAsPermanentCheckbox.addEventListener("change", function () {
	        if (this.checked) {
	            copyPermanentToPresent(permanentFields, presentFields);
	            togglePresentFields(presentFields, true);
	        } else {
	            togglePresentFields(presentFields, false);
	        }
	    });
	
	    // -------------------------
	    // Listen to permanent field changes
	    // -------------------------
	    Object.values(permanentFields).forEach(field => {
	        field.addEventListener("input", syncIfChecked);
	        field.addEventListener("change", syncIfChecked);
	    });
	
	    // -------------------------
	    // UPDATE CASE (page load)
	    // -------------------------
	    if (sameAsPermanentCheckbox.checked) {
	        copyPermanentToPresent(permanentFields, presentFields);
	        togglePresentFields(presentFields, true);
	    }
	}

    
    function copyPermanentToPresent(permanentFields, presentFields) {
	    presentFields.line1.value = permanentFields.line1.value;
	    presentFields.line2.value = permanentFields.line2.value;
	    presentFields.line3.value = permanentFields.line3.value;
	    presentFields.city.value = permanentFields.city.value;
	    presentFields.state.value = permanentFields.state.value;
	    presentFields.country.value = permanentFields.country.value;
	    presentFields.pincode.value = permanentFields.pincode.value;
	}
	
	function togglePresentFields(presentFields, disabled) {
	    Object.values(presentFields).forEach(field => {
	        field.disabled = disabled;
	    });
	}


    function setConfigsForValidation(config) {
        namespace = config.namespace;
        function allowOnlySixDigitMobile(input) {
		
		    // Format pre-filled value (update case)
		    input.value = input.value.replace(/\D/g, "").substring(0, 6);
		
		    input.addEventListener("input", function () {
		        this.value = this.value.replace(/\D/g, "").substring(0, 6);
		    });
		}
		const presentpinCodeInput = document.getElementById(namespace + "presentpinCode");
		const permanentPincodeInput = document.getElementById(namespace + "permanentPincode");
		if(presentpinCodeInput){
			allowOnlySixDigitMobile(presentpinCodeInput);
		}
		if(permanentPincodeInput){
			allowOnlySixDigitMobile(permanentPincodeInput);
		}
        function allowOnlyTenDigitMobile(input) {
		
		    // Format pre-filled value (update case)
		    input.value = input.value.replace(/\D/g, "").substring(0, 10);
		
		    input.addEventListener("input", function () {
		        this.value = this.value.replace(/\D/g, "").substring(0, 10);
		    });
		}
		const mobileInput = document.getElementById(namespace + "mobileNo");
		if (mobileInput) {
		    allowOnlyTenDigitMobile(mobileInput);
		}
		const nomineeContactInput = document.getElementById(namespace + "nomineeContact");
		
		if (nomineeContactInput) {
		    allowOnlyTenDigitMobile(nomineeContactInput);
		}
        const esicInput = document.getElementById(namespace + "esicNo");
		if (esicInput) {
		    if (esicInput.value) {
		        esicInput.value = formatEsicNo(esicInput.value);
		    }
		
		    esicInput.addEventListener("input", function () {
		
		        const cursorPos = this.selectionStart;
		        const oldValueLength = this.value.length;
		
		        this.value = formatEsicNo(this.value);
		
		        const newValueLength = this.value.length;
		        const diff = newValueLength - oldValueLength;
		
		        // Maintain cursor position
		        this.setSelectionRange(cursorPos + diff, cursorPos + diff);
		    });
		}
        config.profilePicName = profilePicName;
      config.aadhaarCardId = aadhaarCardId;
      config.panCardId = panCardId;



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

        /* ================= Aadhaar & PAN FILE VALIDATION ================= */

      $.validator.addMethod(
          "documentRequired",
          function (value, element, existingFileId) {
              // UPDATE case → already uploaded
              if (existingFileId && existingFileId > 0) {
                  return true;
              }
              // ADD case → must upload
              return element.files && element.files.length > 0;
          }
      );

      $.validator.addMethod(
          "fileRequiredIfNoExisting",
          function (value, element) {

              const existingFileId = $(element).data("existing-file-id");

              // UPDATE case → file already exists
              if (existingFileId && existingFileId !== "0" && existingFileId !== 0) {
                  return true;
              }

              // ADD case → file must be selected
              return element.files && element.files.length > 0;
          },
          "Please upload the certificate."
      );



        
        $(document).ready(function () {

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
                        maxlength: 15,
                        validMobile10: true
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
                    },
                    [namespace + "aadhaarCard"]: {
                           documentRequired: aadhaarCardId
                       },

                       [namespace + "panCard"]: {
                           documentRequired: panCardId
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
                        maxlength: "Mobile number must not exceed 15 digits.",
                        validMobile10: "Enter a valid 10-digit mobile number"
                    },
                    [namespace + "employeeProfilePicture"]: {
                        profilePicRequired: "Please select a profile picture"
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
                    },
                      [namespace + "aadhaarCard"]: {
                           documentRequired: "Please upload Aadhaar card."
                       },

                       [namespace + "panCard"]: {
                           documentRequired: "Please upload PAN card."
                       }

                }
            });
            $.validator.addMethod("validMobile10", function (value) {
				return /^\d{10}$/.test(value);
			}, "Enter a valid 10-digit mobile number");

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
		    "Please select a profile picture");




            $('.next-button-basic-details').on('click', function (event) {
                event.preventDefault();
                var form1 = $('#stepperForm');
                if (!form1.valid()) {
                    return;
                }

                var formData = new FormData(form1[0]);

                $("#overlay").fadeIn(300);

                $.ajax({
                    url: form1.attr('action'),
                    method: 'POST',
                    data: formData,
                    contentType: false,
                    processData: false,
                    success: function (response) {
                        var currentTab = $('.nav-link.active');
                        var nextTabButton = currentTab.parent().next().find('.nav-link');
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
                    },
                    complete: function () {
                        $("#overlay").fadeOut(300);
                    }
                });
            });
            
            $('.previous-button').on('click', function (event) {
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

                    /* ================= PERMANENT ADDRESS ================= */

                    [namespace + "permanentAddressLine1"]: {
                        required: true,
                        maxlength: 250,
                        validAddress: true
                    },
                    [namespace + "permanentAddressLine2"]: {
                        maxlength: 250,
                        validAddress: true
                    },
                    [namespace + "permanentAddressLine3"]: {
                        maxlength: 250,
                        validAddress: true
                    },
                    [namespace + "permanentCity"]: {
                        required: true,
                        maxlength: 75,
                        validCity: true
                    },
                    [namespace + "permanentState"]: {
                        required: true,
                        maxlength: 100,
                        validState: true
                    },
                    [namespace + "permanentCountry"]: {
                        required: true
                    },
                    [namespace + "permanentPincode"]: {
                        required: true,
                        digits: true,
                        validPincode: true
                    },

                    /* ================= PRESENT ADDRESS ================= */

                    [namespace + "presentaddressLine1"]: {
                        required: true,
                        maxlength: 250,
                        validAddress: true
                    },
                    [namespace + "presentaddressLine2"]: {
                        maxlength: 250,
                        validAddress: true
                    },
                    [namespace + "presentaddressLine3"]: {
                        maxlength: 250,
                        validAddress: true
                    },
                    [namespace + "presentCity"]: {
                        required: true,
                        maxlength: 75,
                        validCity: true
                    },
                    [namespace + "presentstate"]: {
                        required: true,
                        maxlength: 100,
                        validState: true
                    },
                    [namespace + "presentCountry"]: {
                        required: true
                    },
                    [namespace + "presentpinCode"]: {
                        required: true,
                        digits: true,
                        validPincode: true
                    }
                },

                messages: {

                    /* ================= PERMANENT ADDRESS ================= */

                    [namespace + "permanentAddressLine1"]: {
                        required: "Please enter permanent address line 1.",
                        maxlength: "Address line 1 cannot exceed 250 characters.",
                        validAddress: "Address can contain letters, numbers, spaces, comma (,), dot (.) and hyphen (-)."
                    },
                    [namespace + "permanentAddressLine2"]: {
                        maxlength: "Address line 2 cannot exceed 250 characters.",
                        validAddress: "Address can contain letters, numbers, spaces, comma (,), dot (.) and hyphen (-)."
                    },
                    [namespace + "permanentAddressLine3"]: {
                        maxlength: "Address line 3 cannot exceed 250 characters.",
                        validAddress: "Address can contain letters, numbers, spaces, comma (,), dot (.) and hyphen (-)."
                    },

                    [namespace + "permanentCity"]: {
                        required: "Please enter the permanent city.",
                        maxlength: "City name cannot exceed 75 characters.",
                        validCity: "City should contain only letters and spaces."
                    },
                    [namespace + "permanentState"]: {
                        required: "Please enter the permanent state.",
                        maxlength: "State name cannot exceed 100 characters.",
                        validState: "State should contain only letters and spaces."
                    },
                    [namespace + "permanentCountry"]: {
                        required: "Please select the permanent country."
                    },
                    [namespace + "permanentPincode"]: {
                        required: "Please enter the permanent pincode.",
                        digits: "Pincode should contain only digits.",
                        validPincode: "Pincode must be exactly 6 digits."
                    },

                    /* ================= PRESENT ADDRESS ================= */

                    [namespace + "presentaddressLine1"]: {
                        required: "Please enter present address line 1.",
                        maxlength: "Address line 1 cannot exceed 250 characters.",
                        validAddress: "Address can contain letters, numbers, spaces, comma (,), dot (.) and hyphen (-)."
                    },
                    [namespace + "presentaddressLine2"]: {
                        maxlength: "Address line 2 cannot exceed 250 characters.",
                       validAddress: "Address can contain letters, numbers, spaces, comma (,), dot (.) and hyphen (-)."
                    },
                    [namespace + "presentaddressLine3"]: {
                        maxlength: "Address line 3 cannot exceed 250 characters.",
                        validAddress: "Address can contain letters, numbers, spaces, comma (,), dot (.) and hyphen (-)."
                    },
                    [namespace + "presentCity"]: {
                        required: "Please enter the present city.",
                        maxlength: "City name cannot exceed 75 characters.",
                        validCity: "City should contain only letters and spaces."
                    },
                    [namespace + "presentstate"]: {
                        required: "Please enter the present state.",
                        maxlength: "State name cannot exceed 100 characters.",
                        validState: "State should contain only letters and spaces."
                    },
                    [namespace + "presentCountry"]: {
                        required: "Please select the present country."
                    },
                    [namespace + "presentpinCode"]: {
                        required: "Please enter the present pincode.",
                        digits: "Pincode should contain only digits.",
                        validPincode: "Pincode must be exactly 6 digits."
                    }
                }

            });
            
			$.validator.addMethod("validAddress", function (value) {
                return /^[A-Za-z0-9\s,.-]+$/.test(value.trim());
            });

            $.validator.addMethod("validCity", function (value) {
                return /^[A-Za-z ]+$/.test(value.trim());
            });

            $.validator.addMethod("validState", function (value) {
                return /^[A-Za-z ]+$/.test(value.trim());
            });

            $.validator.addMethod("validPincode", function (value) {
                return /^\d{6}$/.test(value);
            });




            $('.next-button-adress-details').on('click', function (event) {
                event.preventDefault();
                const form2 = $('#addressStepperForm');
                if (!form2.valid()) {
                    return;
                }
                $("#overlay").fadeIn(300);
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
                    },
                    complete: function () {
                        $("#overlay").fadeOut(300);
                    }
                });
            });
            AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForAddressValidation = setConfigsForAddressValidation;
        });
    }
    
    function deleteEmployeeEducation(){
    	console.log('function called employee');
    	AxHrmsEmployeeOnboardingEmployeeWebPortlet.deleteEmployeeEducation = deleteEmployeeEducation;
    }


    function setConfigsForEducationValidation(config) {

        var namespace = config.namespace;
        var educationIndex = config.educationIndex;
        console.log('educationIndex -- ', educationIndex);

        $(document).ready(function () {

            let rules = {};
            let messages = {};

            // ======================
                  // VALIDATORS
                  // ======================

             $.validator.addMethod(
                 "endAfterStart",
                 function (value, element, startSelector) {

                     const startVal = $(startSelector).val();

                     if (!startVal || !value) {
                         return true;
                     }

                     return new Date(value) >= new Date(startVal);
                 },
                 "End date must be after or equal to start date."
             );


                  $.validator.addMethod("notFutureDate", function (value) {
                      if (!value) return true;

                      const today = new Date();
                      today.setHours(0, 0, 0, 0);

                      const selected = new Date(value);
                      selected.setHours(0, 0, 0, 0);

                      return selected <= today;
                  }, "Future dates are not allowed.");

                  $.validator.addMethod("validFourDigitYear", function (value) {
                      if (!value) return true;
                      const year = value.split("-")[0];
                      return /^\d{4}$/.test(year);
                  }, "Year must be exactly 4 digits.");

            // based on end date auto populate passing year
          function bindPassingYearAutoFill() {

              $(document).on('change', 'input[type="date"][name*="endDate"]', function () {

                  const endDateVal = $(this).val();
                  if (!endDateVal) return;

                  const year = new Date(endDateVal).getFullYear();

                  // Find index from name: endDate1, endDate2, ...
                  const name = $(this).attr('name');
                  const indexMatch = name.match(/endDate(\d+)$/);

                  if (!indexMatch) return;

                  const idx = indexMatch[1];

                  const passingYearField = $(
                      'input[name="' + name.replace('endDate' + idx, 'passingYear' + idx) + '"]'
                  );

                  if (passingYearField.length) {
                      passingYearField.val(year);
                  }
              });
          }
            // ======================================================
            // VALIDATION INITIALIZER
            // ======================================================
            function initializeValidation() {

                const form3 = $("#educationStepperForm");

                    form3.removeData("validator");
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
                    const eduCertKey = `${namespace}educationCertificateAttachment${idx}`;

                    rules[levelNameKey] = {required: true};
                    rules[institutionKey] = {required: true, maxlength: 250};
                    rules[degreeKey] = {required: true, maxlength: 75};
                   rules[startDateKey] = {
                         required: true,
                         date: true,
                         notFutureDate: true,
                         validFourDigitYear: true
                     };

                 const startSelector = `[name="${startDateKey}"]`;

                 rules[endDateKey] = {
                     required: true,
                     date: true,
                     notFutureDate: true,
                     validFourDigitYear: true,
                     endAfterStart: startSelector
                 };

                    rules[passingYearKey] = {
                        required: true,
                        digits: true,
                        minlength: 4,
                        maxlength: 4
                    };

                    rules[eduCertKey] = {
                        fileRequiredIfNoExisting: true
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
                         required: "Please enter the start date.",
                         date: "Please enter a valid date.",
                         notFutureDate: "Start date cannot be a future date.",
                         validFourDigitYear: "Start date year must be 4 digits."
                     };

                     messages[endDateKey] = {
                         required: "Please enter the end date.",
                         date: "Please enter a valid date.",
                         notFutureDate: "End date cannot be a future date.",
                         endAfterStart: "End date must be after or equal to start date.",
                         validFourDigitYear: "End date year must be 4 digits."
                     };
                   messages[passingYearKey] = {
                         required: "Please enter the passing year.",
                         digits: "Passing year should contain only digits.",
                         minlength: "Passing year should be 4 digits long.",
                         maxlength: "Passing year should be 4 digits long."
                     };
                     messages[eduCertKey] = {
                         fileRequiredIfNoExisting: "Please upload education certificate."
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
                         // required for validation
                        freshFile.setAttribute("data-existing-file-id", "0");
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

                deleteBtn.onclick = function (event) {
                    event.preventDefault();
                    console.log('main-employee clicked');
                    newSection.remove();
                    initializeValidation();
                };

                newSection.querySelector(".card").appendChild(footer);

                document.getElementById("education-section-container").appendChild(newSection);

                // Update index
                document.getElementById("educationCurrentIndex").value = index;

                initializeValidation();
                bindPassingYearAutoFill();
            }


			$(document).on('click', '.delete-education-btn', function () {
			    console.log('click called');
			    const educationId = $(this).data('education-id');
			    const deleteUrl = $(this).data('url');
				console.log('deleteUrl -- ', deleteUrl);
			    const $btn = $(this);
			    const actionUrl = $btn.data("url");
			    const $section = $btn.closest(".education-section");
			    if (!educationId) {
			       // newly added (not saved yet)
			       $section.remove();
			       return;
			    }
			    
			    if (!confirm('Are you sure you want to delete this education record? ' + educationId)) {
			        return;
			    }
			    
			    let currentUrl = window.location.href;
			    console.log(currentUrl);
			    
			    $.ajax({
					url: deleteUrl,
					type: 'POST',
					data: {
			            educationId: educationId
			        },
					contentType: false,
					processData: false,
					success: function (response) {
						console.log('response -- ',response);
			            $section.remove();
			            let url = new URL(window.location.href);

						const paramName = "_com_ax_hrms_employee_onboarding_web_AxHrmsEmployeeOnboardingHrWebPortlet_EdCurIndex";
						if (!url.searchParams.has(paramName)) {
				            window.location.href = currentUrl + '&_com_ax_hrms_employee_onboarding_web_AxHrmsEmployeeOnboardingHrWebPortlet_EdCurIndex=3';
						}
			        },
			        error: function () {
			            alert("Failed to delete education record.");
			        }
				});
			
			    //window.location.href = deleteUrl + '&educationId=' + educationId;
			});
			
            // Add section button

            const addEduBtn = document.getElementById('add-education-section');
            if (addEduBtn) {
                addEduBtn.addEventListener('click', addEducationSection);
            }


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

                $("#overlay").fadeIn(300);
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
                            let url = new URL(window.location.href);

							const paramName = "_com_ax_hrms_employee_onboarding_web_AxHrmsEmployeeOnboardingHrWebPortlet_EdCurIndex";
							if (url.searchParams.has(paramName)) {
							    url.searchParams.delete(paramName);
							
							    window.history.replaceState({}, document.title, url.toString());
							}
                            
                        }
                    },
                    error: function () {
                        console.log("Error saving data. Please try again.");
                    },
                    complete: function () {
                        $("#overlay").fadeOut(300);
                    }
                });
            });
            $('#noactionbtnEducation').on('click', function (e) {
                e.preventDefault();

                const currentTab = $('.nav-link.active');
                const nextTabButton = currentTab.parent().next().find('.nav-link');

                if (nextTabButton.length === 0) return;

                const currentContentId = currentTab.attr('data-bs-target');
                const nextContentId = nextTabButton.attr('data-bs-target');

                // Activate tab header
                nextTabButton.tab('show');

                $(currentContentId).removeClass('show active');
                $(nextContentId).addClass('show active');

                $(nextContentId).find('input,select').first().focus();
            });

            initializeValidation();
            bindPassingYearAutoFill();
            $(document).on('change', 'input[type="date"]', function () {
                $(this).valid();
            });
           $(document).on(
               "keyup change input",
               "#educationStepperForm input, #educationStepperForm select",
               function () {

                   const form = $("#educationStepperForm");

                   // ensure validator exists
                   if (!form.data("validator")) {
                       initializeValidation(); //
                   }

                   // validate only current field
                   form.validate().element(this);
               }
           );


        });
    }





function setConfigsForExperienceValidation(config) {
	var experienceIndex = config.experienceIndex;
    console.log('experienceIndex -- ', experienceIndex);
	
    const namespace = config.namespace;

    $(document).ready(function () {
            /* =====================================================
               DATE VALIDATIONS (COMMON)
               ===================================================== */

            /* ---- No Future Date ---- */
            $.validator.addMethod(
                "notFutureDate",
                function (value) {
                    if (!value) return true;

                    const today = new Date();
                    today.setHours(0, 0, 0, 0);

                    const inputDate = new Date(value);
                    inputDate.setHours(0, 0, 0, 0);

                    return inputDate <= today;
                },
                "Future date is not allowed."
            );

            /* ---- Year must be exactly 4 digits ---- */
            $.validator.addMethod(
                "validYearLength",
                function (value) {
                    if (!value) return true;

                    // Expected format: yyyy-mm-dd
                    const parts = value.split("-");
                    if (parts.length !== 3) return false;

                    return parts[0].length === 4;
                },
                "Year must contain exactly 4 digits."
            );

            /* ---- Prevent typing more than valid date length ---- */
            $(document).on("input", "input[type='date']", function () {
                if (this.value.length > 10) {
                    this.value = this.value.substring(0, 10);
                }
            });

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
        
        try {
                const index_exp = parseInt(experienceIndex);
                for (let i = 1; i < index_exp; i++) {
                    $('.nav-link.active').parent().next().find('.nav-link').click();
                }
            } catch (err) {
                console.log("error", err);
            }

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
                    const expCertKey = `${namespace}experienceCertificateAttachment${idx}`;

                    rules[company] = { required: true };
                    rules[joining] = {
                        required: true,
                        date: true,
                        notFutureDate: true,
                        validYearLength: true
                    };

                    rules[relieving] = {
                        required: true,
                        date: true,
                        afterJoiningDate: joining,
                        notFutureDate: true,
                        validYearLength: true
                    };
                    rules[expCertKey] = {
                        fileRequiredIfNoExisting: true
                    };

                    messages[company] = {
                        required: "Please enter company name."
                    };
                  messages[joining] = {
                      required: "Please enter joining date.",
                      notFutureDate: "Joining date cannot be in the future.",
                      validYearLength: "Year must be exactly 4 digits."
                  };

                  messages[relieving] = {
                      required: "Please enter relieving date.",
                      afterJoiningDate: "Relieving date must be after joining date.",
                      notFutureDate: "Relieving date cannot be in the future.",
                      validYearLength: "Year must be exactly 4 digits."
                  };
                  messages[expCertKey] = {
                      fileRequiredIfNoExisting: "Please upload experience certificate."
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
        /* =====================================================
           REAL-TIME VALIDATION (EXPERIENCE – SAME AS EDUCATION)
           ===================================================== */

        $(document).on(
            "keyup change input",
            "#experienceStepperForm input, #experienceStepperForm select",
            function () {

                const form = $("#experienceStepperForm");

                // ensure validator exists
                if (!form.data("validator")) {
                    initializeValidation();
                }

                // validate only current field (same as education)
                form.validate().element(this);
            }
        );

        
        $(document).on('click', '.delete-experience-btn', function () {
			    console.log('click called');
			    const experienceId = $(this).data('experience-id');
			    const deleteUrl = $(this).data('url');
				console.log('deleteUrl -- ', deleteUrl);
			    const $btn = $(this);
			    const actionUrl = $btn.data("url");
			    const $section = $btn.closest(".experience-section");
			    if (!experienceId) {
			       // newly added (not saved yet)
			       $section.remove();
			       return;
			    }
			    
			    if (!confirm('Are you sure you want to delete this experience record? ' + experienceId)) {
			        return;
			    }
			    
			    let url = new URL(window.location.href);

				const paramName = "_com_ax_hrms_employee_onboarding_web_AxHrmsEmployeeOnboardingHrWebPortlet_EdCurIndex";
				if (url.searchParams.has(paramName)) {
				    url.searchParams.delete(paramName);
				
				    window.history.replaceState({}, document.title, url.toString());
				}
			    let currentUrl = window.location.href;
			    			    
			    $.ajax({
					url: deleteUrl,
					type: 'POST',
					data: {
			            experienceId: experienceId
			        },
					contentType: false,
					processData: false,
					success: function (response) {
						console.log('response -- ',response);
			            $section.remove();
			            
			            const paramName = "_com_ax_hrms_employee_onboarding_web_AxHrmsEmployeeOnboardingHrWebPortlet_ExperienceCurIndex";
						if (!url.searchParams.has(paramName)) {
				            window.location.href = currentUrl + '&_com_ax_hrms_employee_onboarding_web_AxHrmsEmployeeOnboardingHrWebPortlet_ExperienceCurIndex=4';
						}
			        },
			        error: function () {
			            alert("Failed to delete education record.");
			        }
				});
			
			    //window.location.href = deleteUrl + '&educationId=' + educationId;
			});
			



        /* ================= SUBMIT ================= */

        $(".next-button-experience-details").on("click", function () {

            initializeValidation();

            const form = $("#experienceStepperForm");
            if (!form.valid()) return;

            const formData = new FormData(form[0]);

            $("#overlay").fadeIn(300);
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
                        
                        let url = new URL(window.location.href);

						const paramName = "_com_ax_hrms_employee_onboarding_web_AxHrmsEmployeeOnboardingHrWebPortlet_ExperienceCurIndex";
						if (url.searchParams.has(paramName)) {
						    url.searchParams.delete(paramName);
						
						    window.history.replaceState({}, document.title, url.toString());
						}
                        
                    }
                },
                error: function () {
                    console.error("Error saving experience (HR)");
                },
                complete: function () {
                    $("#overlay").fadeOut(300);
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
                    maxlength: 20,
                    accountNumberValidation: true
                },

               [namespace + "beneficiaryName"]: {
                   maxlength: 75,
                   onlyLettersAndSpaces: true
               },

               [namespace + "bankName"]: {
                   maxlength: 75,
                   onlyLettersAndSpaces: true
               },

               [namespace + "bankBranch"]: {
                   maxlength: 75,
                   onlyLettersAndSpaces: true
               },
                [namespace + "ifscCode"]: {
                    maxlength: 75,
                    ifscCodeValidation: true
                }
            },
            messages: {
                [namespace + "accountNumber"]: {
                    maxlength: "Account number should not exceed 20 characters.",
                    accountNumberValidation: "Account number should not contain alphabet characters, underscores, special characters, or whitespaces."
                },

                [namespace + "beneficiaryName"]: {
                    maxlength: "Beneficiary name should not exceed 75 characters.",
                    onlyLettersAndSpaces: "Beneficiary name should contain only alphabets and spaces."
                },

                [namespace + "bankName"]: {
                    maxlength: "Bank name should not exceed 75 characters.",
                    onlyLettersAndSpaces: "Bank name should contain only alphabets and spaces."
                },

                [namespace + "bankBranch"]: {
                    maxlength: "Bank branch should not exceed 75 characters.",
                    onlyLettersAndSpaces: "Bank branch should contain only alphabets and spaces."
                },

                [namespace + "ifscCode"]: {
                    maxlength: "IFSC code should not exceed 75 characters.",
                    ifscCodeValidation: "Please enter a valid IFSC code."
                }
            }
        });

        $.validator.addMethod("accountNumberValidation", function (value, element) {
            return /^[0-9]*$/.test(value);
        }, "Account number should not contain alphabet characters, underscores, special characters, or whitespaces.");

		$.validator.addMethod("ifscCodeValidation", function (value, element) {
      		return (value == '') || /^[A-Z]{4}0[A-Z0-9]{6}$/.test(value);
    	}, "Please enter a valid IFSC code (Format: AAAA0BBBBBB)");
    	 if (!$.validator.methods.onlyLettersAndSpaces) {
             $.validator.addMethod(
                 "onlyLettersAndSpaces",
                 function (value, element) {
                     value = value.trim().replace(/\s+/g, " ");
                     return this.optional(element) || /^[A-Za-z ]+$/.test(value);
                 },
                 "Only alphabets and spaces are allowed"
             );
         }


        $('.next-button-bank-account-details').on('click', function (event) {
            event.preventDefault();
            let url = new URL(window.location.href);
            const paramName = "_com_ax_hrms_employee_onboarding_web_AxHrmsEmployeeOnboardingHrWebPortlet_ExperienceCurIndex";
			if (url.searchParams.has(paramName)) {
			    url.searchParams.delete(paramName);
			
			    window.history.replaceState({}, document.title, url.toString());
			}
            const form5 = $('#bankAccountStepperForm');
//            if (!form5.valid()) {
//                return;
//            }
            $("#overlay").fadeIn(300);
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
                },
                complete: function () {
                    $("#overlay").fadeOut(300);
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
                    esicValidation: "ESIC number must be in format XX-XX-XXXXXX-XXX-XXXX"
                }
            }
        });

        $.validator.addMethod("uanValidation", function (value, element) {
        	return this.optional(element) || /^[0-9]{12}$/.test(value); 
        }, "UAN must be exactly 12 digits (numbers only, no spaces or special characters)");

		$.validator.addMethod("esicValidation", function (value, element) {
        	return this.optional(element) || /^(\d{2}-\d{2}-\d{6}-\d{3}-\d{4})$/.test(value);
    	}, "ESIC number must be in format XX-XX-XXXXXX-XXX-XXXX");
    	
		
        $('.next-button-uan-esic-details').on('click', function (event) {
            event.preventDefault();
            if (!form6.valid()) {
                return;
            }
            $("#overlay").fadeIn(300);
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
                },
                complete: function () {
                    $("#overlay").fadeOut(300);
                }
            });
        });

        AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForUanEsicValidation = setConfigsForUanEsicValidation;
    }
    
    function formatEsicNo(value) {
	    // Remove non-digits
	    const digits = value.replace(/\D/g, "").substring(0, 17);
	
	    let formatted = "";
	
	    if (digits.length > 0) formatted += digits.substring(0, 2);
	    if (digits.length >= 3) formatted += "-" + digits.substring(2, 4);
	    if (digits.length >= 5) formatted += "-" + digits.substring(4, 10);
	    if (digits.length >= 11) formatted += "-" + digits.substring(10, 13);
	    if (digits.length >= 14) formatted += "-" + digits.substring(13, 17);
	
	    return formatted;
	}

    // Nominee Details
    function setConfigsForNomineeValidation(config) {
        let getEmployeeUrl = config.getEmployeeUrl;
        var $form7 = $("#nomineeStepperForm");




        $.validator.addMethod(
            "notFutureDate",
            function (value) {
                if (!value) return true;

                const today = new Date();
                today.setHours(0, 0, 0, 0);

                const inputDate = new Date(value);
                inputDate.setHours(0, 0, 0, 0);

                return inputDate <= today;
            },
            "Future date is not allowed."
        );

        $.validator.addMethod(
            "validYearLength",
            function (value) {
                if (!value) return true;

                // Expected format: yyyy-mm-dd
                const parts = value.split("-");
                if (parts.length !== 3) return false;

                return parts[0].length === 4;
            },
            "Year must be exactly 4 digits."
        );

        if (!$.validator.methods.validPersonName) {
            $.validator.addMethod(
                "validPersonName",
                function (value, element) {
                    value = value.trim().replace(/\s+/g, " "); // normalize spaces
                    return this.optional(element) || /^[A-Za-z]+( [A-Za-z]+)*$/.test(value);
                },
                "Only alphabets are allowed. No numbers or special characters."
            );
        }



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
                    maxlength: 75,
                    validPersonName: true
                },
                [namespace + "nomineeLastName"]: {
                    required: true,
                    maxlength: 75,
                    validPersonName: true
                },
                [namespace + "nomineeContact"]: {
                    required: true,
                    maxlength: 30,
                    digits: true,
                    validMobile10: true
                },
                [namespace + "presentaddressLine1"]: {
                    required: true,
                    maxlength: 250,
                    validAddress: true
                },
                [namespace + "nomineeCity"]: {
                    required: true,
                    maxlength: 75,
                    validPersonName:true
                },
                [namespace + "presentaddressLine2"]: {
                    maxlength: 250,
                    validAddress: true
                },
                [namespace + "presentaddressLine3"]: {
                    maxlength: 250,
                    validAddress: true
                },
                [namespace + "presentstate"]: {
                    required: true,
                    maxlength: 100,
                    validPersonName: true
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
                    maxlength: 75,
                    validPersonName: true
                },
              [namespace + "nomineeDob"]: {
                  required: {
                      depends: function () {
                          return this.value === "";
                      }
                  },
                  date: true,
                  notFutureDate: true,
                  validYearLength: true
              }


            },
            messages: {
                [namespace + "nomineeFirstName"]: {
                    required: "Please enter the nominee's first name.",
                    maxlength: "First name should not exceed 75 characters.",
                    validPersonName: "First name can contain only alphabets and space."
                },
                [namespace + "nomineeLastName"]: {
                    required: "Please enter the nominee's last name.",
                    maxlength: "Last name should not exceed 75 characters.",
                    validPersonName: "Last name can contain only alphabets and space."
                },
                [namespace + "nomineeContact"]: {
                    required: "Please enter the nominee's contact number.",
                    maxlength: "Contact number should not exceed 30 characters.",
                    digits: "Contact number should contain only digits.",
                    validMobile10: "Enter a valid 10-digit mobile number."
                },
                [namespace + "nomineeAddress"]: {
                    required: "Please enter the nominee's address ID.",
                    digits: "Address ID should contain only digits."
                },
                [namespace + "presentaddressLine1"]: {
                    required: "Please enter the present address line 1.",
                    maxlength: "Address line 1 cannot exceed 250 characters.",
                    validAddress: "Address can contain letters, numbers, spaces, comma (,), dot (.) and hyphen (-)."
                },
                [namespace + "nomineeCity"]: {
                    required: "Please enter the city.",
                    maxlength: "City name cannot exceed 75 characters.",
                    validNameOnly: "City name should contain only alphabets and space."

                },
                [namespace + "presentaddressLine2"]: {
                    maxlength: "Address line 2 cannot exceed 250 characters.",
                    validAddress: "Address can contain letters, numbers, spaces, comma (,), dot (.) and hyphen (-)."
                },
                [namespace + "presentaddressLine3"]: {
                    maxlength: "Address line 3 cannot exceed 250 characters.",
                    validAddress: "Address can contain letters, numbers, spaces, comma (,), dot (.) and hyphen (-)."
                },
                
                [namespace + "presentstate"]: {
                    required: "Please enter the state for the present address.",
                    maxlength: "State name cannot exceed 100 characters.",
                    validNameOnly: "State name should contain only alphabets and space."
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
                    maxlength: "Relationship should not exceed 75 characters.",
                    validPersonName: "Relationship must contain only alphabets."
                },
                [namespace + "nomineeDob"]: {
                  required: "Please enter the nominee's date of birth.",
                  date: "Please enter a valid date.",
                  notFutureDate: "Date of birth cannot be in the future.",
                  validYearLength: "Year must be exactly 4 digits."
              }


            }
        });


        $(document).on(
            "keyup change input",
            "#nomineeStepperForm input, #nomineeStepperForm select",
            function () {
                $form7.validate().element(this);
            }
        );
        $(document).on(
            "input",
            "#nomineeStepperForm input[type='date']",
            function () {
                if (this.value.length > 10) {
                    this.value = this.value.substring(0, 10);
                }
            }
        );



        $('.next-button-nominee-details').on('click', function (event) {
            event.preventDefault();
            const form7 = $('#nomineeStepperForm');
            if (!form7.valid()) {
                return;
            }
            $("#overlay").fadeIn(300);
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
                },
                complete: function () {
                    $("#overlay").fadeOut(300);
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
    AxHrmsEmployeeOnboardingEmployeeWebPortlet.deleteEmployeeEducation = deleteEmployeeEducation;
    AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForEducationValidation = setConfigsForEducationValidation;
    AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForExperienceValidation = setConfigsForExperienceValidation;
    AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForBankAccountValidation = setConfigsForBankAccountValidation;
    AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForUanEsicValidation = setConfigsForUanEsicValidation;
    AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForNomineeValidation = setConfigsForNomineeValidation;

})($, window.AxHrmsEmployeeOnboardingEmployeeWebPortlet || (window.AxHrmsEmployeeOnboardingEmployeeWebPortlet = {}));