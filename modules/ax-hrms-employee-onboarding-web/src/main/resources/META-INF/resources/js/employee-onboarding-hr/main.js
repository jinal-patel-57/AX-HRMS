var setFileInputValues;
(function ($, AxHrmsEmployeeOnboardingHrWebPortlet) {
    let namespace;
    window.isOfficialEmailExists = window.isOfficialEmailExists || false;


    function setConfigsForValidation(config) {
        namespace = config.namespace;

        $.validator.addMethod("validUsernameEmail", function (value, element) {
            const domain = $(element).data("domain");  // dynamic domain from JSP

            // Remove domain part
            let username = value.replace(domain, "");

            // Must not be empty
            if (username.trim() === "") return false;

            // Username allowed characters: letters, digits, dot, underscore, hyphen
            const regex = /^[a-zA-Z0-9._-]+$/;
            return regex.test(username);
        }, "Please enter a valid email.");

       $.validator.addMethod(
           "emailNotExists",
           function () {
               return !window.isOfficialEmailExists;
           },
           "Email already exists."
       );



        $(document).ready(function () {

            $("#EmployeeOnBoardingHrForm").validate({
                rules: {
                    [namespace + "employeeCode"]: {
                        required: true,
                        maxlength: 50,
                        lettersAndNumbersOnly: true,
                    },
                    [namespace + "typeOfEmployee"]: {
                        required: true,
                    },
                    [namespace + "firstName"]: {
                        required: true,
                        maxlength: 50,
                        lettersOnly: true,
                    },
                    [namespace + "lastName"]: {
                        required: true,
                        maxlength: 50,
                        lettersOnly: true,
                    },
                    [namespace + "middleName"]: {
                        maxlength: 50,
                        lettersOnly: true,
                    },
                    [namespace + "branch"]: {
                        required: true,
                    },
                    [namespace + "designation"]: {
                        required: true,
                    },
                    [namespace + "department"]: {
                        required: true,
                    },
                 [namespace + "officialEmailId"]: {
                     required: true,
                     validUsernameEmail: true,
                     emailNotExists: true
                 },

                    [namespace + "joiningDate"]: {
                        required: true,
                        date: true
                    },
                    [namespace + "grossSalaryCTCPM"]: {
                            ctcLimitByEmployeeType:true
                    },

                    [namespace + "grossSalaryCTCPA"]: {

                    },
                    [namespace + "insuranceLink"]: {
                        linkUrlValidation: true
                    },
                    [namespace + "stipend"]: {
                        ctcLimitByEmployeeType:true
                    },
                },
                messages: {
                    [namespace + "employeeCode"]: {
                        required: "Please enter Employee Code",
                        maxlength: "Employee Code exceeding maximum length!",
                        lettersAndNumbersOnly:
                            "Use only letters and numbers for Employee Code!",
                    },
                    [namespace + "firstName"]: {
                        required: "Please enter First Name",
                        maxlength: "First Name exceeding maximum length!",
                        lettersOnly:
                            "Use only letters for First Name!",
                    },
                    [namespace + "lastName"]: {
                        required: "Please enter Last Name",
                        maxlength: "Last Name exceeding maximum length!",
                        lettersOnly:
                            "Use only letters for Last Name!",
                    },
                    [namespace + "middleName"]: {
                        maxlength: "Middle Name exceeding maximum length!",
                        lettersOnly:
                            "Use only letters for Middle Name!",
                    },
                    [namespace + "branch"]: {
                        required: "Please select a Branch!"

                    },
                    [namespace + "designation"]: {
                        required: "Please select a Designation!"

                    },
                    [namespace + "department"]: {
                        required: "Please select a Department!"

                    },
                   [namespace + "officialEmailId"]: {
                       required: "Please enter email username.",
                       validUsernameEmail: "Only letters, numbers, dot, hyphen and underscore allowed."
                   },

                    [namespace + "joiningDate"]: {
                        required: "Please Enter a valid Joining date",
                        date: "Enter a proper Date Only"
                    },
                    [namespace + "grossSalaryCTCPM"]: {
//                        required: "Please Enter a valid Salary",
//                        numericality: "Plese Enter a Valid Salary"
                    },
                    [namespace + "stipend"]: {
                        required: "Please enter stipend",

                    },
                    [namespace + "grossSalaryCTCPA"]: {
//                        required: "Please Enter a valid Salary",
//                        numericality: "Plese Enter a Valid Salary"
                    },
                    [namespace + "insuranceLink"]: {
                        linkUrlValidation: "Please enter a valid URL"
                    }
                },
                errorPlacement: function (error, element) {
                    error.insertAfter(element);
                },
            });





            $.validator.addMethod("ctcLimitByEmployeeType", function (value, element) {
                if (!value) return true; // handled by required rule

//                var employeeType = $('input[name="<portlet:namespace />employeeType"]').val();
                var employeeType = $("#typeOfEmployee").val();
                var amount = parseFloat(value);
                console.log("employeeTpye ::  ",employeeType)
                if (isNaN(amount)) return false;

                if (employeeType && employeeType.toLowerCase() === 'intern') {
                    return amount <= 100000; // 1,00,000
                } else {
                    return amount <= 1000000; // 10,00,000
                }
            }, function () {
//                var employeeType = $('input[name="<portlet:namespace />employeeType"]').val();
                var employeeType = $("#typeOfEmployee").val();

                return employeeType && employeeType.toLowerCase() === 'intern'
                    ? "Stipend per month cannot exceed ₹1,00,000."
                    : "CTC per month cannot exceed ₹10,00,000.";
            });







            $.validator.addMethod(
                "lettersAndSpacesOnly",
                function (value, element) {
                    return this.optional(element) || /^[a-zA-Z\s]+$/.test(value);
                },
                "Please enter only alphabetical characters and spaces"
            );
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

					const today = new Date().toISOString().split("T")[0];
					$("#joiningDate").attr("max", today);

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
                                         required: "Please enter experience in years.",
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

                              // Revalidate to sync form state
                                 $experienceField.valid();
                         }
                     });


                         // handle update case (page load)
                        $('input[name="' + namespace + 'isExperienced"]:checked').trigger('change');


            
            $.validator.addMethod(
			    "linkUrlValidation",
			    function (value, element) {
			        return this.optional(element) || /^(https?:\/\/)?((localhost|(\d{1,3}\.){3}\d{1,3})|((www\.)?[a-zA-Z0-9-]+\.[a-zA-Z]{2,}))(:\d+)?(\/.*)?$/.test(value);
			    },
			    "Please enter a valid URL"
			);

            $.validator.addMethod(
                "lettersOnly",
                function (value, element) {
                    return this.optional(element) || /^[A-Za-z]+$/.test(value);
                },
                "Please enter only alphabetical characters."
            );

          $.validator.addMethod(
              "numericality",
              function (value, element) {
                  return this.optional(element) || /^\d+(\.\d+)?$/.test(value);
              },
              "Please enter a valid number"
          );


            $.validator.addMethod("lettersAndNumbersOnly", function (value, element) {
                return this.optional(element) || /^[a-zA-Z0-9]+$/.test(value);
            }, "Please enter only letters and numbers.");
        });


        // config.namespace = namespace;
        // config.experienceLetterFileName = '${experienceLetterFileName}';
        // config.relievingLetterFileName = '${relievingLetterFileName}';
        // config.fullAndFinalLetterFileName= '${fullAndFinalLetterFileName}';


        $(document).ready(function () {
            toggleFileUploads();





            let allCheckedOnReady = $('.checkbox').length === $('.checkbox:checked').length;
            if (allCheckedOnReady) {
                $('.checkbox').attr("disabled", true);
            }

            $('.checkbox').on('change', function () {
                toggleFileUploads();
                checkFormCompleteness();
            });

            $('.file-upload').on('change', function () {
                checkFormCompleteness();
            });

            function toggleFileUploads() {
                let allChecked = $('.checkbox').length === $('.checkbox:checked').length;
                if (!allChecked) {
                    // Clear the file inputs if they get disabled
                    $('.file-upload').val('');

                }
                $('.file-upload').prop('disabled', !allChecked);
            }

            setFileInputValues = function (filename, fileInputId) {
                var fileName = filename;
                if (fileName != '' && fileName != 'undefined' && fileName != undefined) {
                    const myFile = new File([''], fileName, {
                        type: 'text/plain',
                        lastModified: new Date(),
                    });
                    var fileInput = document.getElementById(fileInputId);
                    myFile.name = fileName;
                    const dataTransfer = new DataTransfer();
                    dataTransfer.items.add(myFile);
                    fileInput.files = dataTransfer.files;
                }
            }

            setFileInputValues(config.experienceLetterFileName, 'fileUpload1');
            setFileInputValues(config.relievingLetterFileName, 'fileUpload2');

            function checkFormCompleteness() {
                let allChecked = $('.checkbox').length === $('.checkbox:checked').length;
                let allFilesUploaded = $('.file-upload').filter(function () {
                    return $(this).val() === "";
                }).length === 0;

                if (allChecked && allFilesUploaded) {
                    $('#offBoardBtn').prop('disabled', false);
                } else {
                    $('#offBoardBtn').prop('disabled', true);
                }
            }

            checkFormCompleteness();
        });

        $(document).ready(function () {

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


         function toggleCTCValidation() {
                        const employeeType = $("#typeOfEmployee").val();

                        const $ctcPM = $('[name="' + namespace + 'grossSalaryCTCPM"]');
                        const $ctcPA = $('[name="' + namespace + 'grossSalaryCTCPA"]');

                        const $asterisks = $("#grossSalaryCTCPM, #grossSalaryCTCPA")
                            .closest(".form-group")
                            .find(".required-asterisk");

                        if (employeeType === "intern") {
                            $ctcPM.rules("remove", "required");
                            $ctcPA.rules("remove", "required");

                            $asterisks.addClass("d-none");

                            // Clear validation state
                            $ctcPM.removeClass("is-invalid is-valid").valid();
                            $ctcPA.removeClass("is-invalid is-valid").valid();
                        } else {
                            $ctcPM.rules("add", {
                                required: true,
                                messages: {
                                    required: "Please enter Gross Salary (CTC PM)"
                                }
                            });



                            $asterisks.removeClass("d-none");
                        }
                    }


            // Function to check the selected type of employee
            function checkEmployeeType() {
                var selectedType = $('#typeOfEmployee').val();
                const $stipendAsterisk = $(".required-asterisk-stipend");
                const $stipend = $('#stipend');
                var $grossFields = $('#grossSalaryCTCPA, #grossSalaryCTCPM');
                    var $form = $("#stepperForm");

    var validator = $form.data("validator");

                if (selectedType === 'intern') {
//                    $('#designation').val('Intern');

    const $designation = $('#designation');

    if ($designation.find('option[value="Intern"]').length) {
        $designation.val('Intern');
    }

//    $designation.prop('disabled', true);

//        $grossFields.each(function () {
//            $(this)
//                .val('')
//                .prop('disabled', true)
//                .removeClass("is-invalid is-valid error");
//
//            $(this).next("label.error").remove();
//        });

        $grossFields.each(function () {

            // Clear value
            $(this).val('');

            // If validator exists → reset this field properly
            if (validator) {
                validator.resetElements($(this));
            }

            // Disable after reset
            $(this).prop('disabled', true);

        });

                if (validator) {
                    validator.resetForm();
                }

                    $('#stipend').prop('disabled', false);




                        $(this).val(''); // remove value

//                        $(this).removeClass("is-invalid error"); // remove error class
//
//                        $(this).next("label.error").remove(); // remove error message label

                        if ($("#stepperForm").data("validator")) {
                            $("#stepperForm").data("validator").resetForm();
                        }




                    $('#stipend').attr('placeholder', 'Stipend');
                    $('#grossSalaryCTCPA, #grossSalaryCTCPM').prop('disabled', true); // Disable CTC fields

                     $stipend.prop('disabled', false);
                           $stipend.attr('placeholder', 'Stipend');
                     $stipend.removeClass("is-invalid is-valid");
                           $stipend.rules("remove");

                           $stipend.rules("add", {
                               required: true,
                               numericality: true,
                               ctcLimitByEmployeeType:true,
                               messages: {
                                   required: "Please enter Stipend",
                                   numericality: "Please enter valid number"
                               }
                           });

                           $stipendAsterisk.removeClass("d-none");



                } else {
        $grossFields.each(function () {
            $(this)
                .prop('disabled', false)
                .removeClass("is-invalid is-valid");
        });
                                $('#grossSalaryCTCPA, #grossSalaryCTCPM').prop('disabled', false);

                                 $stipend.rules("remove");

                                       $stipend.prop('disabled', true);
                                       $stipend.attr('placeholder', 'NA');
                                       $stipend.val('');

//                                       $stipend.removeClass("is-invalid is-valid error");
//                                       $stipend.next("label.error").remove();

                                       $stipend.valid();
                                      if (validator) {
                                            validator.resetForm();
                                      }

                                       $stipendAsterisk.addClass("d-none");

                }
                if (selectedType === 'intern' || selectedType === 'contractor') {
                    $('#enabled, #disabled').prop('disabled', true); // Disable probation radio buttons
                    $('#yes, #no').prop('disabled', true); // Disable experienced radio buttons
                    $('#insuranceLink').prop('disabled', true); // Disable insurance link input
                    $('#disabled').prop('checked', true); // Select the 'Disabled' radio button for probation status
                    $('#no').prop('checked', true); // Select the 'No' radio button for experienced
                } else {
                    $('#enabled, #disabled').prop('disabled', false); // Enable probation radio buttons
                    $('#yes, #no').prop('disabled', false); // Enable experienced radio buttons
                    $('#insuranceLink').prop('disabled', false); // Enable insurance link input
                }
            }
            $('#offBoardBtn').on('click', function (event) {
	            $('#offBoardBtn').prop('disabled', true);
	            $('#action').val('offBoard');
	            //window.location.href = $('#offBoardFm').attr('action');
	            $('#offBoardFm').submit();
            });

            // Initial check on page load
            checkEmployeeType();





            // Check when the type of employee changes
            $('#typeOfEmployee').on('change', function () {
                checkEmployeeType();
            });

            // On page load
            toggleCTCValidation();

            // On employee type change
            $("#typeOfEmployee").on("change", function () {
                toggleCTCValidation();
            });

        });


    }

    AxHrmsEmployeeOnboardingHrWebPortlet.setConfigsForValidation =
        setConfigsForValidation;
})(
    jQuery,
    (window.AxHrmsEmployeeOnboardingHrWebPortlet =
        window.AxHrmsEmployeeOnboardingHrWebPortlet || {})
);
