(function ($, AxHrmsEmployeeOnboardingEmployeeWebPortlet) {
    let namespace;


function attachFormValidationTriggers(formSelector) {
         $.validator.setDefaults({

                    highlight: function () {
                    },

                    unhighlight: function () {
                    }
                });

    const $form = $(formSelector);

    if (!$form.length) return;



    // Focusout + change → field-level validation
    $form.on(
        "focusout change",
        "input, select, textarea",
        function () {
            if (!$form.data("validator")) {
                return;
            }
            $form.validate().element(this);
        }
    );

    // Input → only for DATE fields
    $form.on(
        "input",
        "input[type='date']",
        function () {
            if (!$form.data("validator")) {
                return;
            }
            $form.validate().element(this);
        }
    );
}

function applyGenericDateRestriction(element) {
    if (!element) return;
    
    const today = new Date().toISOString().split('T')[0];
    element.setAttribute('min', '1900-01-01');
    element.setAttribute('max', today);

    element.addEventListener('input', function () {
        const val = this.value; // Expected format: yyyy-mm-dd
        if (val) {
            const parts = val.split('-');
            if (parts[0] && parts[0].length > 4) {
                parts[0] = parts[0].substring(0, 4);
                this.value = parts.join('-');
            }
        }
    });
}




    function setConfigsForRejectUrl(config) {
        namespace = config.namespace;
        let rejectUrl = employeeRejectUrl;
        let textValue = $('#' + namespace + 'review').val();
        rejectUrl = rejectUrl.replace('REVIEW', textValue);
        window.location.href = rejectUrl;
    }

     function setConfigsForAddressProofToggle(config) {
            namespace = config.namespace;

            let checkbox = $('#' + namespace + 'sameAsPermanent');
            let addressProofSection = $('#addressProofSection');
            let addressProofInput = $('#' + namespace + 'addressProofFile');
            let form = $("#addressStepperForm");



            function toggleAddressProof() {
                if (checkbox.is(':checked')) {
                    addressProofSection.hide();


//                    addressProofInput.val("");

                    addressProofInput.removeClass("is-invalid is-valid");

                    addressProofInput.next(".invalid-feedback").remove();

//                    if (form.data("validator")) {
//                        form.validate().resetElements(addressProofInput);
//                    }


                } else {
                    addressProofSection.show();
                }
            }

            // Initial state
            toggleAddressProof();

            // Toggle on change
            checkbox.on('change', function () {
                toggleAddressProof();
            });
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
        console.log("input :: ",input)
         if (input.id) {
                        input.id = input.id.replace(/[0-9]+$/, '') + index;
         }

         console.log("input after id :: ",input)
        if (input.type === "file") {
            const fresh = document.createElement("input");
            fresh.type = "file";
            fresh.className = input.className;
            fresh.id = input.id;
            fresh.name = input.name;
            fresh.multiple=true;
            fresh.accept = input.accept;
            input.parentNode.replaceChild(fresh, input);
        } else {
            input.value = "";
        }
    });


// THis code is for the removing the validation error while add the new experience.
clone.querySelectorAll(".invalid-feedback").forEach(el => el.remove());
clone.querySelectorAll(".is-invalid").forEach(el => el.classList.remove("is-invalid"));
clone.querySelectorAll("[aria-describedby]").forEach(el => {
    el.removeAttribute("aria-describedby");
});
    $(clone).find("input, select, textarea").each(function () {
        $(this).removeData("previousValue");
        $(this).removeData("rules");
        $(this).off(".validate");
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

//        initializeValidation();

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

            const form = $("#addressStepperForm");

            if (this.checked) {

                copyPermanentToPresent(permanentFields, presentFields);
                togglePresentFields(presentFields, true);

                Object.values(presentFields).forEach(field => {

                    $(field).removeClass("is-invalid is-valid");

                    $(field).next(".invalid-feedback").remove();

                    if (form.data("validator")) {
                        form.validate().resetElements($(field));
                    }
                });

            } else {

                togglePresentFields(presentFields, false);
                clearPresentFields(presentFields);

            }
        });



        function clearPresentFields(presentFields) {
            Object.values(presentFields).forEach(field => {
                field.value = "";
            });
        }

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
        let storedExperienceYears = null;
/* ================= HR COMMON LOGIC ================= */




        // ===== Validators reused from HR =====
        if (!$.validator.methods.decimalExperience) {
            $.validator.addMethod(
                "decimalExperience",
                function (value, element) {
                    return this.optional(element) || /^(?:\d+|\d+\.\d{1,2})$/.test(value);
                },
                "Please enter a valid experience (e.g. 2, 2.5, 10.75)."
            );
        }



        if (!$.validator.methods.lettersAndNumbersOnly) {
            $.validator.addMethod("lettersAndNumbersOnly", function (value) {
                return /^[a-zA-Z0-9]+$/.test(value);
            });
        }

        if (!$.validator.methods.numericality) {
            $.validator.addMethod("numericality", function (value) {
                return /^\d*\.?\d+$/.test(value);
            });
        }

        if (!$.validator.methods.linkUrlValidation) {
            $.validator.addMethod("linkUrlValidation", function (value) {
                return value === "" ||
                    /^(https?:\/\/)([a-zA-Z0-9-]+\.)+[a-zA-Z]{2,}(\/.*)?$/.test(value);
            });
        }





        function allowOnlySixDigitPincode(input) {
		
		    // Format pre-filled value (update case)
		    input.value = input.value.replace(/\D/g, "").substring(0, 6);
		
		    input.addEventListener("input", function () {
		        this.value = this.value.replace(/\D/g, "").substring(0, 6);
		    });
		}
		const presentpinCodeInput = document.getElementById(namespace + "presentpinCode");
		const permanentPincodeInput = document.getElementById(namespace + "permanentPincode");
		if(presentpinCodeInput){
			allowOnlySixDigitPincode(presentpinCodeInput);
		}
		if(permanentPincodeInput){
			allowOnlySixDigitPincode(permanentPincodeInput);
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

         // Generic date range validation (1900 to today)
        $.validator.addMethod("pastDate1900", function (value, element) {
            if (this.optional(element)) return true;
            const date = new Date(value);
            const minDate = new Date("1900-01-01");
            const today = new Date();
            today.setHours(23, 59, 59, 999); 
            return date >= minDate && date <= today;
        }, "Please enter a date between 01-01-1900 and today.");

        /* ================= Aadhaar & PAN FILE VALIDATION ================= */

//      $.validator.addMethod(
//          "documentRequired",
//          function (value, element, existingFileId) {
//
////                  const $el = $(element);
////
////                  if (!$el.data("validatedOnce")) {
////                      $el.data("validatedOnce", true);
////                      return true;
////                  }
//
//            const $el = $(element);
//
//            if (!element.files || element.files.length === 0) {
//
//                // If user has NOT tried to submit yet → skip error
//                if (!$el.closest("form").data("submitted")) {
//                    return true;
//                }
//            }
//
//              // UPDATE case → already uploaded
//              if (existingFileId && existingFileId > 0) {
//                  return true;
//              }
//              // ADD case → must upload
//              return element.files && element.files.length > 0;
//          }
//      );

$.validator.addMethod(
    "documentRequired",
    function (value, element, existingFileId) {

        const form = element.form;

        // UPDATE case → file already exists in DB
        if (existingFileId && existingFileId > 0) {
            return true;
        }

        // Before clicking Next → skip validation
        if (!form._submitAttempted) {
            return true;
        }

        // After clicking Next → file is mandatory
        return element.files && element.files.length > 0;
    },
    "Please upload the required document."
);


        $.validator.addMethod(
            "validExtension",
            function (value, element) {
                if (!value) return true; // handled by required

                return /\.(pdf|jpg|jpeg|png)$/i.test(value);
            },
            "Only PDF, JPG, JPEG, or PNG files are allowed."
        );

        $.validator.addMethod(
            "validExtensionForProfileImage",
            function (value, element) {
                if (!value) return true; // handled by required

                return /\.(jpg|jpeg|png)$/i.test(value);
            },
            "Only JPG, JPEG, or PNG files are allowed."
        );

      $.validator.addMethod(
          "fileRequiredIfNoExisting",
          function (value, element) {
              const form = element.form;
              const existingFileId = $(element).data("existing-file-id");

              // UPDATE case → file already exists
              if (existingFileId && existingFileId !== "0" && existingFileId !== 0) {
                  return true;
              }
              if (!form._submitAttempted) {
                return true;
              }

              // ADD case → file must be selected
              return element.files && element.files.length > 0;
          },
          "Please upload the certificate."
      );



        
        $(document).ready(function () {

        function formatAadhaar(value) {
            if (!value) return "";

            value = value.replace(/\D/g, "");

            if (value.length > 12) {
                value = value.substring(0, 12);
            }

            return value.replace(/(\d{4})(\d{0,4})(\d{0,4})/, function (_, a, b, c) {
                return [a, b, c].filter(Boolean).join("-");
            });
        }


        var aadhaarField = $("#" + namespace + "aadharNumber");

        if (aadhaarField.val()) {
            aadhaarField.val(formatAadhaar(aadhaarField.val()));
        }

            var $form1 = $("#stepperForm");
            $form1.validate({
                onchange: function (element) {
                    if (element.type === "file" && !element.files.length) {
                        return;
                    }
                    this.element(element);
                },
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
                        ageRange: true,
                        notFutureDate: true,
                        pastDate1900: true
                    },
                    [namespace + "mobileNo"]: {
                        required: true,
                        digits: true,
                        minlength: 10,
                        maxlength: 15,
                        validMobile10: true
                    },

                    [namespace + "fatherName"]: {
                        required: true,

                    },
                    [namespace + "nameAsPerAadhaarCard"]: {
                        required: true,
                        lettersOnly: true
                    },
                    [namespace + "marriageDate"]: {
                        required: function () {
                            return $("#" + namespace + "maritalStatus").is(":checked");
                        },
                        date: true,
                        notFutureDate: true,
                        pastDate1900: true
                    },
                    [namespace + "employeeProfilePicture"]: {
                        profilePicRequired: true,
//                        required: function () {
//                            return !profilePicName || profilePicName.trim() === "";
//                        },
                        validExtensionForProfileImage:true,
                            maxFileSize: 10

                    },

                    [namespace + "spouseName"]: {
                        required: function () {
                            return $("#" + namespace + "maritalStatus").is(":checked");
                        },
                        lettersOnly: true

                    },
                    [namespace + "aadhaarCard"]: {
                           documentRequired: aadhaarCardId,
                           validExtension: true,
                           maxFileSize: 10
                       },

                       [namespace + "panCard"]: {
                           documentRequired: panCardId,
                           validExtension: true,
                           maxFileSize: 10
                       },
                        [namespace + "aadharNumber"]: {
                            required: true,
                            validAadhaar: true
                        },

                        [namespace + "panNumber"]: {
                            required: true,
                            minlength: 10,
                            maxlength: 10,
                            validPAN: true
                        },
                        [namespace + "kycDocumentType"]: {
                           required: function () {
                               // Required only if no document already uploaded
                               return !isKycDocumentAlreadyUploaded;
                           }
                        },
                       [namespace + "kycDocumentFile"]: {
                           required: function (element) {
                               var kycTypeSelected =
                                   $("#" + namespace + "kycDocumentType").val();
                               const form = element.form;
                        // UPDATE case → already uploaded
                        if (isKycDocumentAlreadyUploaded) {
                            return false;
                        }

                        // Do not validate before clicking Next
                        if (!form._submitAttempted) {
                            return false;
                        }
                               // Required only if:
                               // 1. KYC type selected
                               // 2. No document already uploaded
                               return kycTypeSelected && !isKycDocumentAlreadyUploaded;
                           },
                           validExtension: true,
                           maxFileSize: 10
                       },
                       [namespace + "stipendAmount"]: {
                            required: true,
                            number: true,
                            ctcLimitByEmployeeType: true
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
                        notFutureDate: "Future dates are not allowed.",
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
                        profilePicRequired: "Please select a profile picture",
                           validExtensionForProfileImage:"Only JPG, JPEG, or PNG files are allowed.",
                           maxFileSize: "File size must not exceed 10 MB."
                    },

                    [namespace + "fatherName"]: {
                        required: "Please enter Father/Husband Name."
                    },
                    [namespace + "nameAsPerAadhaarCard"]: {
                        required: "Please Enter Name as per Aadhar Card.",
                        lettersOnly: "Only letters are allowed for Name."

                    },
                    [namespace + "marriageDate"]: {
                        required: "Please enter your marriage date.",
                        notFutureDate: "Future dates are not allowed.",
                        date: "Please enter a valid date."
                    },
//                    [namespace + "employeeProfilePicture"]: {
//                        required: "Please select a profile picture.",
//                        validExtensionForProfileImage:"Only JPG, JPEG, or PNG files are allowed.",
//                        maxFileSize: "File size must not exceed 10 MB."
//                    },

                    [namespace + "spouseName"]: {
                        required: "Please enter your spouse's name.",
                        lettersOnly: "Only letters are allowed for Name."
                    },
                      [namespace + "aadhaarCard"]: {
                           documentRequired: "Please upload Aadhar card.",
                           validExtension: "Only PDF, JPG, JPEG, or PNG files are allowed.",
                           maxFileSize: "File size must not exceed 10 MB.",

                       },

                       [namespace + "panCard"]: {
                           documentRequired: "Please upload PAN card.",
                               validExtension: "Only PDF, JPG, JPEG, or PNG files are allowed.",
                               maxFileSize: "File size must not exceed 10 MB."
                       },

                        [namespace + "aadharNumber"]: {
                            required: "Please enter Aadhar number.",
                              validAadhaar: "Aadhar must be in format 1234-1234-1234."

                        },
                        [namespace + "panNumber"]: {
                            required: "Please enter PAN number.",
                            minlength: "PAN number must be exactly 10 characters.",
                            maxlength: "PAN number must be exactly 10 characters.",
                            validPAN: "Please enter a valid PAN number (e.g., ABCDE1234F)."
                        },
                        [namespace + "kycDocumentFile"]: {
                            required: "Please upload KYC document.",
                            validExtension: "Only PDF, JPG, JPEG, or PNG files are allowed.",
                            maxFileSize: "File size must not exceed 10 MB."
                        },
                        [namespace + "kycDocumentType"]: {
                            required: "Please select KYC document type."
                        },
                        [namespace + "stipendAmount"]: {
                            required: "Please enter stipend.",
                            number: "Please enter a valid amount.",
                        }
                }
            });
            /* ===== HR ONLY FIELD RULES + MESSAGES ===== */

            // Integrate generic date restriction for DOB and Joining Date
            const dobInput = document.getElementById(namespace + "dateOfBirth");
            if (dobInput) {
                applyGenericDateRestriction(dobInput);
            }
            const joiningDateInput = document.getElementById(namespace + "joiningDate");
            if (joiningDateInput) {
                applyGenericDateRestriction(joiningDateInput);
            }

            const marriageDateInput = document.getElementById(namespace + "marriageDate");
            if (marriageDateInput) {
                applyGenericDateRestriction(marriageDateInput);
            }

          if (typeof isHrStatus !== "undefined" && isHrStatus === true) {



              $('[name="' + namespace + 'firstName"]').rules("add", {
                  required: true,
                  lettersOnly: true,
                  maxlength: 50,
                  messages: {
                      required: "Please enter first name.",
                      lettersOnly: "First name should contain only alphabets.",
                      maxlength: "First name cannot exceed 50 characters."
                  }
              });

              $('[name="' + namespace + 'middleName"]').rules("add", {
                  lettersOnly: true,
                  maxlength: 50,
                  messages: {
                      
                  }
              });

              $('[name="' + namespace + 'lastName"]').rules("add", {
                  required: true,
                  lettersOnly: true,
                  maxlength: 50,
                  messages: {
                      required: "Please enter last name."
                  }
              });
              $('[name="' + namespace + 'department"]').rules("add", {
                  required: true,

                  messages: {
                      required: "Please select department."
                  }
              });
              $('[name="' + namespace + 'designation"]').rules("add", {
                  required: true,

                  messages: {
                      required: "Please select designation."
                  }
              });

              $('[name="' + namespace + 'joiningDate"]').rules("add", {
                  required: true,
                  date: true,
                  pastDate1900: true,
                  messages: {
                      required: "Please select joining date."
                  }
              });

              $('[name="' + namespace + 'grossSalaryCTCPM"]').rules("add", {
                  required: true,
                  ctcLimitByEmployeeType: true,
                  messages: {
                      required: "Please enter gross salary per month.",

                  }
              });
              $('[name="' + namespace + 'branch"]').rules("add", {
                  required: true,
                  messages: {
                      required: "Please select Branch.",
                  }
              });


                $(document).ready(function () {

                   $("#grossSalaryCTCPM").on("input", function () {
                       const pm = parseFloat(this.value);
                       const $pa = $("#grossSalaryCTCPA");

                       if (!isNaN(pm) && pm > 0) {
                           $pa.val((pm * 12).toFixed(2)).valid();
                       } else {
                           $pa.val("").valid();
                       }


                   });

                    function bindDecimalInput(selector) {
                               $(document).on("input", selector, function () {
                                   let v = this.value;

                                   // allow only digits and dot
                                   v = v.replace(/[^0-9.]/g, "");

                                   // allow only one dot
                                   const dotIndex = v.indexOf(".");
                                   if (dotIndex !== -1) {
                                       v = v.substring(0, dotIndex + 1) +
                                           v.substring(dotIndex + 1).replace(/\./g, "");
                                   }

                                   this.value = v;
                               });
                           }

                           bindDecimalInput("#grossSalaryCTCPM, #grossSalaryCTCPA");


                    });






          }
             /* ================= EXPERIENCE TOGGLE ================= */

         $('input[name="' + namespace + 'isExperienced"]').on('change', function () {

             const isExperiencedYes = this.value === 'Yes';
             const $experienceField = $('[name="' + namespace + 'experienceYear"]');

             if (isExperiencedYes) {

                 // ENABLE field
                 $experienceField.prop('disabled', false);

                 // RESTORE value if exists
                 if (storedExperienceYears !== null) {
                     $experienceField.val(storedExperienceYears);
                 }

                 // ADD validation
                 $experienceField.rules("add", {
                     required: true,
                    decimalExperience: true,
                     min: 0,
                     max: 50,
                      messages: {
                             required: "Please enter experience.",
                             decimalExperience: "Enter a valid experience (e.g. 2, 2.5, 10.75).",
                             min: "Experience must be at least 0.",
                             max: "Experience cannot exceed 50 years."
                         }
                 });

             } else {

                 // STORE value before clearing
                 storedExperienceYears = $experienceField.val();

                 // DISABLE + CLEAR
                 $experienceField
                     .prop('disabled', true)
                     .val('');

                 // REMOVE validation
                 $experienceField.rules("remove");
                 $experienceField.removeClass("is-invalid is-valid");
                 $experienceField.next(".invalid-feedback").remove();
             }
         });


             // handle update case (page load)
            $('input[name="' + namespace + 'isExperienced"]:checked').trigger('change');



           // validation trigger
            attachFormValidationTriggers("#stepperForm");






$.validator.addMethod("ctcLimitByEmployeeType", function (value, element) {
    if (!value) return true; // handled by required rule

//    var employeeType = $('input[name="<portlet:namespace />employeeType"]').val();
// var employeeType = $("#employeeType").val();
    var employeeType = $('input[name="' + namespace + 'employeeType"]').val();

 console.log("employeeType :: ",employeeType)
    var amount = parseFloat(value);

    if (isNaN(amount)) return false;

    if (employeeType && employeeType.toLowerCase() === 'intern') {
        return amount <= 100000; // 1,00,000
    } else {
        return amount <= 1000000; // 10,00,000
    }
}, function () {
    var employeeType = $('input[name="' + namespace + 'employeeType"]').val();
    return employeeType && employeeType.toLowerCase() === 'intern'
        ? "Stipend per month cannot exceed ₹1,00,000."
        : "CTC per month cannot exceed ₹10,00,000.";
});




$.validator.addMethod(
    "maxFileSize",
    function (value, element, maxSizeMB) {
        if (!element.files || element.files.length === 0) {
            return true;
        }

        const file = element.files[0];

                const allowedExtensions = /\.(pdf|jpg|jpeg|png)$/i;

                if (!allowedExtensions.test(file.name)) {
                    return true;
                }
        const maxSizeBytes = maxSizeMB * 1024 * 1024;
        console.log("maxSizeBytes in the hr",maxSizeBytes)
        return file.size <= maxSizeBytes;
    },
    "File size must not exceed 10 MB."
);







            $.validator.addMethod("validMobile10", function (value) {
				return /^(?!0{10})\d{10}$/.test(value);
			}, "Enter a valid 10-digit mobile number");

            /* ================= Aadhaar Validation ================= */
            $.validator.addMethod("validAadhaar", function (value, element) {
                if (this.optional(element)) {
                    return true;
                }
                return /^\d{4}-\d{4}-\d{4}$/.test(value);
            }, "Please enter Aadhaar in format 1234-1234-1234");
            /* ================= PAN Validation ================= */
            $.validator.addMethod("validPAN", function (value, element) {
                if (this.optional(element)) {
                    return true;
                }
                return /^[A-Z]{5}[0-9]{4}[A-Z]{1}$/.test(value.toUpperCase());
            }, "Please enter a valid PAN number (e.g., ABCDE1234F).");


            $.validator.addMethod("lettersOnly", function (value, element) {
                return this.optional(element) || /^(?=.*[A-Za-z])[A-Za-z\s]+$/.test(value);
            }, "Only letters are allowed.");

            $("#" + namespace + "fatherName").rules("add", {
                lettersOnly: true
            });
//            $.validator.addMethod("profilePicRequired", function (value, element) {
//                        const form = element.form;
//
//                        // Do NOT validate until submit is attempted
//                        if (!form._submitAttempted) {
//                            return true;
//                        }
//
//
//		    	        if (element.files && element.files.length > 0) {
//                            return true;
//                        }
//
//                        // If file already exists in DB → valid
//                        if (typeof profilePicName !== "undefined" &&
//                            profilePicName !== null &&
//                            profilePicName.trim() !== "") {
//                            return true;
//                        }
//
//
//		    	if (profilePicName) {
//		        	return true; // already uploaded earlier
//		    	}
//		    	return element.files && element.files.length > 0; },
//		    "Please select a profile picture");


$.validator.addMethod(
    "profilePicRequired",
    function (value, element) {
        const form = element.form;

        // Do not validate until Next/Submit is clicked
        if (!form._submitAttempted) {
            return true;
        }

        // New file selected
        if (element.files && element.files.length > 0) {
            return true;
        }

        // Existing file already saved in DB
        if (profilePicName && profilePicName.trim() !== "") {
            return true;
        }

        return false;
    },
    "Please select a profile picture"
);




            $("#" + namespace + "panNumber").on("keyup", function () {
                this.value = this.value.toUpperCase();
            });

const aadhaarSelector = "#" + namespace + "aadharNumber";

$(document).on("input", aadhaarSelector, function () {
    this.value = formatAadhaar(this.value);
});


$('a[data-bs-toggle="tab"]').on('shown.bs.tab', function () {

    const $aadhaar = $("#" + namespace + "aadharNumber");

    if ($aadhaar.length && $aadhaar.val()) {
        $aadhaar.val(formatAadhaar($aadhaar.val()));
    }
});


            $('.next-button-basic-details').on('click', function (event) {
                event.preventDefault();
                console.log("Inside the js of the employee onboarding!!!!!!")


                var form1 = $('#stepperForm');

                    form1[0]._submitAttempted = true;
                form1.find('input[type="file"]').each(function () {
                    $(this).valid();
                });
                    if (!form1.valid()) {
                        return;
                    }

                var aadhaarField = $("#" + namespace + "aadharNumber");
                if (aadhaarField.length) {
                    aadhaarField.val(aadhaarField.val().replace(/-/g, ""));
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
		        const eduForm = document.getElementById("educationStepperForm");
                if (eduForm) {
                    eduForm._submitAttempted = false;
                }
		        if (previousTabButton.length > 0) {
		            previousTabButton.tab('show');
		            const previousTabContentId = previousTabButton.attr('data-bs-target');
		            $(previousTabContentId).addClass('show active');
		            $(currentTab.attr('data-bs-target')).removeClass('show active');
		                    setTimeout(function () {
                                const $aadhaar = $("#" + namespace + "aadharNumber");
                                if ($aadhaar.length && $aadhaar.val()) {
                                    $aadhaar.val(formatAadhaar($aadhaar.val()));
                                }
                            }, 0);

		       //     $(previousTabContentId).find('input').first().focus();
		        }
		    });

            function toggleMaritalStatusFields() {
                var maritalStatusCheckbox = $("#" + namespace + "maritalStatus");
                var marriageDateField = $("#" + namespace + "marriageDate");
                var spouseNameField = $("#" + namespace + "spouseName");
                if (maritalStatusCheckbox.is(":checked")) {
		            const today = new Date().toISOString().split("T")[0];
					//marriageDateField.attr("max", today);
					marriageDateField.removeAttr("max");
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
                    },
                    [namespace + "addressProofFile"]: {

                        validExtension: true,
                        maxFileSize: 10
                    },
                },

                messages: {

                    /* ================= PERMANENT ADDRESS ================= */

                    [namespace + "permanentAddressLine1"]: {
                        required: "Please enter permanent address line 1.",
                        maxlength: "Address line 1 cannot exceed 250 characters.",
                        validAddress: "Invalid address. Only letters, numbers, and special characters ( # , . - / ' & ) are allowed."
                    },
                    [namespace + "permanentAddressLine2"]: {
                        maxlength: "Address line 2 cannot exceed 250 characters.",
                        validAddress: "Invalid address. Only letters, numbers, and special characters ( # , . - / ' & ) are allowed."
                    },
                    [namespace + "permanentAddressLine3"]: {
                        maxlength: "Address line 3 cannot exceed 250 characters.",
                        validAddress: "Invalid address. Only letters, numbers, and special characters ( # , . - / ' & ) are allowed."
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
                        validAddress: "Invalid address. Only letters, numbers, and special characters ( # , . - / ' & ) are allowed."
                    },
                    [namespace + "presentaddressLine2"]: {
                        maxlength: "Address line 2 cannot exceed 250 characters.",
                       validAddress: "Invalid address. Only letters, numbers, and special characters ( # , . - / ' & ) are allowed."
                    },
                    [namespace + "presentaddressLine3"]: {
                        maxlength: "Address line 3 cannot exceed 250 characters.",
                        validAddress: "Invalid address. Only letters, numbers, and special characters ( # , . - / ' & ) are allowed."
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
                    },
                    [namespace + "addressProofFile"]: {

                         validExtension: "Only PDF, JPG, JPEG, or PNG files are allowed.",
                         maxFileSize: "File size must not exceed 10 MB."
                    },
                }

            });
            
			$.validator.addMethod("validAddress", function (value) {
                return (value == '') || /^[A-Za-z0-9\s,.\-#/()'&]+$/.test(value.trim());
            }, "Invalid address. Only letters, numbers, and special characters ( # , . - / ' & ) are allowed.");

            $.validator.addMethod("validCity", function (value) {
                return /^[A-Za-z ]+$/.test(value.trim());
            });

            $.validator.addMethod("validState", function (value) {
                return /^[A-Za-z ]+$/.test(value.trim());
            });

            $.validator.addMethod("validPincode", function (value) {
                return /^(?!0{6})\d{6}$/.test(value);
            });

            // validation trigger
            attachFormValidationTriggers("#addressStepperForm");



            $('.next-button-adress-details').on('click', function (event) {
                event.preventDefault();
                const form2 = $('#addressStepperForm');
                var formData = new FormData(form2[0]);
                form2[0]._submitAttempted = true;
                form2.find('input[type="file"]').each(function () {
                    $(this).valid();
                });
                if (!form2.valid()) {
                    return;
                }
                $("#overlay").fadeIn(300);
                $.ajax({
                    url: form2.attr('action'),
                    method: 'POST',
                    data: formData,
                    contentType: false,
                    processData: false,
                    success: function (response) {
                        const currentTab = $('.nav-link.active');
                        document.getElementById("updateFlagAddress").value = "true";
                        const nextTabButton = currentTab.parent().next().find('.nav-link');
                        if (nextTabButton.length > 0) {
                            nextTabButton.tab('show');
                            const nextTabContentId = nextTabButton.attr('data-bs-target');
                            $(nextTabContentId).addClass('show active');
                            $(currentTab.attr('data-bs-target')).removeClass('show active');
                          //  $(nextTabContentId).find('input').first().focus();
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
                    rules[institutionKey] = {required: true, maxlength: 250, lettersOnly: true};
                    rules[degreeKey] = {required: true,minlength: 2, maxlength: 75, validDegree: true};
                   rules[startDateKey] = {
                         required: true,
                         date: true,
                         pastDate1900: true
                     };

                 const startSelector = `[name="${startDateKey}"]`;

                 rules[endDateKey] = {
                     required: true,
                     date: true,
                     pastDate1900: true,
                     endAfterStart: startSelector
                 };

                    rules[passingYearKey] = {
                        required: true,
                        digits: true,
                        minlength: 4,
                        maxlength: 4
                    };

                    rules[eduCertKey] = {
                        fileRequiredIfNoExisting: true,
                        validExtension: true,
                        maxFileSize:10
                    };

                    messages[levelNameKey] = {
                        required: "Please select an education level name."
                    };
                    messages[institutionKey] = {
                        required: "Please enter institution name.",
                        maxlength: "Institution name must not exceed 250 characters.",
                        lettersOnly: "Only letters and spaces are allowed."
                    };
                        messages[degreeKey] = {
                            required: "Please enter degree.",
                                minlength: "Degree must be at least 2 characters.",
                            maxlength: "Degree must not exceed 75 characters.",
                            validDegree: "Only letters, spaces, dot (.), hyphen (-), and parentheses are allowed."
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
                         fileRequiredIfNoExisting: "Please upload education certificate.",
                         validExtension: "Only PDF, JPG, JPEG, or PNG files are allowed.",
                         maxFileSize: "File size must not exceed 10 MB."
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

                const form = document.getElementById("educationStepperForm");
                form._submitAttempted = false;
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
			    
			    if (!confirm('Are you sure you want to delete this education record?')) {
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
                    form3[0]._submitAttempted = true;

                    if (!form3.valid()) {
                        return false;
                    }

                    form3[0]._submitAttempted = false;
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
                            // Reset submit attempt when tab loads
                            const eduForm = document.getElementById("educationStepperForm");
                            if (eduForm) {
                                eduForm._submitAttempted = false;
                            }

                                const nextId = nextTabButton.attr("data-bs-target");

                                $(nextId).addClass('show active');
                                $(currentTab.attr('data-bs-target')).removeClass('show active');

                            //    $(nextId).find("input").first().focus();
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

             //   $(nextContentId).find('input,select').first().focus();
            });

            initializeValidation();
            bindPassingYearAutoFill();

            // validation trigger
            attachFormValidationTriggers("#educationStepperForm");

            document.querySelectorAll('#educationStepperForm input[type="date"]').forEach(input => {
                applyGenericDateRestriction(input);
            });

//            $(document).on('change', 'input[type="date"]', function () {
//                $(this).valid();
//            });
//           $(document).on(
//               "focusout change ",
//               "#educationStepperForm input, #educationStepperForm select,#educationStepperForm textarea",
//
//               function () {
//
//                   const form = $("#educationStepperForm");
//
//                   // ensure validator exists
//                   if (!form.data("validator")) {
//                       initializeValidation(); //
//                   }
//
//                   // validate only current field
//                   form.validate().element(this);
//               }
//           );




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

           $.validator.addMethod(
               "validDegree",
               function (value, element) {
                   if (this.optional(element)) return true;

                   value = value.trim();

                   return /^[A-Za-z]+(?:\.[A-Za-z]+)*(?:[ -][A-Za-z]+(?:\.[A-Za-z]+)*)*(?: ?\([A-Za-z]+(?:\.[A-Za-z]+)*\))?$/.test(value);
               },
               "Please enter a valid degree name."
           );



            /* ---- Prevent typing more than valid date length ---- */
            $(document).on("input", "input[type='date']", function () {
                if (this.value.length > 10) {
                    this.value = this.value.substring(0, 10);
                }
            });

            $(document).on("change", 'input[type="file"]', function () {
                initializeValidation()
                const form = $(this.form);

                console.log("Inside the OK....",form)
                console.log("form.data(validator) :: ",form.data("validator"))
                if (form.data("validator")) {
                    form.validate().element(this);
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
                        pastDate1900: true
                    };

                    rules[relieving] = {
                        required: true,
                        date: true,
                        afterJoiningDate: joining,
                        pastDate1900: true
                    };
                    rules[expCertKey] = {
                        fileRequiredIfNoExisting: true,
                        validExtension: true,
                        maxFileSize:10
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
                      fileRequiredIfNoExisting: "Please upload experience certificate.",
                      validExtension: "Only PDF, JPG, JPEG, or PNG files are allowed.",
                      maxFileSize: "File size must not exceed 10 MB."
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

//        $(document).on(
//            "focusout change",
//            "#experienceStepperForm input, #experienceStepperForm select",
//            function () {
//
//                const form = $("#experienceStepperForm");
//
//                // ensure validator exists
//                if (!form.data("validator")) {
//                    initializeValidation();
//                }
//
//                // validate only current field (same as education)
//                form.validate().element(this);
//            }
//        );

            // validation trigger
            attachFormValidationTriggers("#experienceStepperForm");

             document.querySelectorAll('#experienceStepperForm input[type="date"]').forEach(input => {
                            applyGenericDateRestriction(input);
                        });


        
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
                form[0]._submitAttempted = true;

            if (!form.valid()) return;
            form._submitAttempted = false;
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
                    minlength:10,
                    accountNumberValidation: true
                },

               [namespace + "beneficiaryName"]: {
                   maxlength: 75,
                   onlyLettersAndSpaces: true
               },
               [namespace + "nameAsPerPanCard"]: {
                   required: true,
                   maxlength: 75,
                   onlyLettersAndSpaces: true
               },

               [namespace + "bankName"]: {
                   maxlength: 75,
                   onlyLettersAndSpaces: true
               },

               [namespace + "bankBranch"]: {
                   maxlength: 75,
                   onlyLettersAndSpacesAndNumber: true
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
                [namespace + "nameAsPerPanCard"]: {
                    required: "Please enter the Name.",
                    maxlength: "Name should not exceed 75 characters.",
                    onlyLettersAndSpaces: "Name should contain only alphabets and spaces."
                },

                [namespace + "bankName"]: {
                    maxlength: "Bank name should not exceed 75 characters.",
                    onlyLettersAndSpaces: "Bank name should contain only alphabets and spaces."
                },

                [namespace + "bankBranch"]: {
                    maxlength: "Bank branch should not exceed 75 characters.",
                    onlyLettersAndSpacesAndNumber: "Bank branch should contain only letters, numbers, and spaces."
                },

                [namespace + "ifscCode"]: {
                    maxlength: "IFSC code should not exceed 75 characters.",
                    ifscCodeValidation: "Please enter a valid IFSC code (Format: AAAA0123456)"
                }
            }
        });

        $.validator.addMethod("accountNumberValidation", function (value, element) {
            return /^[0-9]*$/.test(value);
        }, "Account number should not contain alphabet characters, underscores, special characters, or whitespaces.");

        $.validator.addMethod("onlyLettersAndSpacesAndNumber", function(value, element) {
            return this.optional(element) || /^[A-Za-z0-9\s]+$/.test(value);
        }, "Please enter only letters, numbers, and spaces.");


		$.validator.addMethod("ifscCodeValidation", function (value, element) {
//      		return (value == '') || /^[A-Z]{4}0[A-Z0-9]{6}$/.test(value);
    return (value == '') || /^[A-Z]{4}0[A-Z0-9]{6}$/.test(value.toUpperCase());
    	}, "Please enter a valid IFSC code (Format: AAAA0123456)");
    	 if (!$.validator.methods.onlyLettersAndSpaces) {
             $.validator.addMethod(
                 "onlyLettersAndSpaces",
                 function (value, element) {
                     value = value.trim().replace(/\s+/g, " ");
                     return this.optional(element) || /^(?=.*[A-Za-z])[A-Za-z ]+$/.test(value);
                 },
                 "Only alphabets and spaces are allowed"
             );
         }
         // validation trigger
        attachFormValidationTriggers("#bankAccountStepperForm");


        $('.next-button-bank-account-details').on('click', function (event) {
            event.preventDefault();
            let url = new URL(window.location.href);
            const paramName = "_com_ax_hrms_employee_onboarding_web_AxHrmsEmployeeOnboardingHrWebPortlet_ExperienceCurIndex";
			if (url.searchParams.has(paramName)) {
			    url.searchParams.delete(paramName);

			    window.history.replaceState({}, document.title, url.toString());
			}
            const form5 = $('#bankAccountStepperForm');
            if (!form5.valid()) {
                return;
            }
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

		$(document).ready(function () {

            const uanInput = $('#' + namespace + 'uan');
            const esicInput = $('#' + namespace + 'esicNo');

            // Format UAN if value exists (update case)
            if (uanInput.val()) {
                uanInput.val(formatUan(uanInput.val()));
            }

            // Format ESIC if value exists (update case)
            if (esicInput.val()) {
                esicInput.val(formatEsicNo(esicInput.val()));
            }
        });

		
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
                    maxlength: 14,
                    uanValidation: true
                },

                [namespace + "esicNo"]: {
                    maxlength: 21,
                    esicValidation: true
                }
            },
            messages: {
                [namespace + "uan"]: {
                    maxlength: "UAN should not exceed 12 numbers.",
                    uanValidation: "UAN number must be exactly 12 digits (format XXXX-XXXX-XXXX)"
                },
                [namespace + "esicNo"]: {
                    maxlength: "ESIC No. should not exceed 17 numbers.",
                    esicValidation: "ESIC number must be exactly 17 digits (format XX-XX-XXXXXX-XXX-XXXX)"
                }
            }
        });

       $.validator.addMethod("uanValidation", function (value, element) {
           return this.optional(element) || /^\d{4}-\d{4}-\d{4}$/.test(value);
       }, "UAN number must be exactly 12 digits (format XXXX-XXXX-XXXX)"
       );

		$.validator.addMethod("esicValidation", function (value, element) {
        	return this.optional(element) || /^(\d{2}-\d{2}-\d{6}-\d{3}-\d{4})$/.test(value);
    	}, "ESIC number must be exactly 17 digits (format XX-XX-XXXXXX-XXX-XXXX)");

    	$(document).on('input', '#' + namespace + 'uan', function () {
            this.value = formatUan(this.value);
        });

        // validation trigger
        attachFormValidationTriggers("#uanEsicStepperForm");

		
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
    function formatUan(value) {
        // Remove non-digits
        const digits = value.replace(/\D/g, "").substring(0, 12);

        let formatted = "";

        if (digits.length > 0) formatted += digits.substring(0, 4);
        if (digits.length >= 5) formatted += "-" + digits.substring(4, 8);
        if (digits.length >= 9) formatted += "-" + digits.substring(8, 12);

        return formatted;
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
     const namespace = config.namespace;
        let getEmployeeUrl = config.getEmployeeUrl;
        var $form7 = $("#nomineeStepperForm");
         function allowOnlySixDigitPincode(input) {

        		    // Format pre-filled value (update case)
        		    input.value = input.value.replace(/\D/g, "").substring(0, 6);

        		    input.addEventListener("input", function () {
        		        this.value = this.value.replace(/\D/g, "").substring(0, 6);
        		    });
        		}
         const nomineePincodeInput =
                document.querySelector(
                    '#nomineeStepperForm input[name="' + namespace + 'presentpinCode"]'
                );

            allowOnlySixDigitPincode(nomineePincodeInput);


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
                  pastDate1900: true
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
                    required: "Please enter the address line 1.",
                    maxlength: "Address line 1 cannot exceed 250 characters.",
                    validAddress: "Invalid address. Only letters, numbers, and special characters ( # , . - / ' & ) are allowed."
                },
                [namespace + "nomineeCity"]: {
                    required: "Please enter the city.",
                    maxlength: "City name cannot exceed 75 characters.",
                    validNameOnly: "City name should contain only alphabets and space."

                },
                [namespace + "presentaddressLine2"]: {
                    maxlength: "Address line 2 cannot exceed 250 characters.",
                    validAddress: "Invalid address. Only letters, numbers, and special characters ( # , . - / ' & ) are allowed."
                },
                [namespace + "presentaddressLine3"]: {
                    maxlength: "Address line 3 cannot exceed 250 characters.",
                    validAddress: "Invalid address. Only letters, numbers, and special characters ( # , . - / ' & ) are allowed."
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

        // validation trigger
        attachFormValidationTriggers("#nomineeStepperForm");


//        $(document).on(
//            "focusout change",
//            "#nomineeStepperForm input, #nomineeStepperForm select",
//            function () {
//                $form7.validate().element(this);
//            }
//        );
        $(document).on(
            "input",
            "#nomineeStepperForm input[type='date']",
            function () {
                if (this.value.length > 10) {
                    this.value = this.value.substring(0, 10);
                }
            }
        );

        function showMessage(newMessage) {
        console.log("showwing the message ok ne")
            Liferay.Util.openToast({
                title: 'Info',
                message: newMessage,
                type: 'info',
                autoClose: 10000
            });
        }

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
//                success: function (response) {
//                    form7.hide();
////                    window.location.href = getEmployeeUrl;
//                    const questionMarkIndex = window.location.href.indexOf('?');
//					if (questionMarkIndex !== -1) {
//					    const cleanURL = window.location.href.substring(0, questionMarkIndex);
//					    window.location.href = cleanURL;
//					}
//					showMessage("Done")
//                    document.getElementById("employeeOnBorading").style.display = "none";
//                },
            success: function () {
                Liferay.Util.openToast({
                    title: 'Success',
                    message: 'Employee Updated Successfully',
                    type: 'success',
                    autoClose: 3000
                });

                setTimeout(function () {
                    const questionMarkIndex = window.location.href.indexOf('?');
                    if (questionMarkIndex !== -1) {
                        window.location.href = window.location.href.substring(0, questionMarkIndex);
                    }
                }, 1500);
            },
                error: function () {
                    console.log('There was an error saving the data. Please try again.');
                },
                complete: function () {
                    $("#overlay").fadeOut(300);
                }
            });
        });
        const nomineeDobInput = document.getElementById(namespace + "nomineeDob");
        if (nomineeDobInput) {
            applyGenericDateRestriction(nomineeDobInput);
        }

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
    AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForAddressProofToggle = setConfigsForAddressProofToggle;

})($, window.AxHrmsEmployeeOnboardingEmployeeWebPortlet || (window.AxHrmsEmployeeOnboardingEmployeeWebPortlet = {}));