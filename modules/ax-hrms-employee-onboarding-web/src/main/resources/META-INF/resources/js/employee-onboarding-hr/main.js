var setFileInputValues;
(function ($, AxHrmsEmployeeOnboardingHrWebPortlet) {
    let namespace;

    function setConfigsForValidation(config) {
        namespace = config.namespace;

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
                        required: true,
                        maxlength: 50,
                        lettersOnly: true,
                    },
                    [namespace + "designation"]: {
                        required: true,
                    },
                    [namespace + "department"]: {
                        required: true,
                    },
                    [namespace + "officialEmailId"]: {
                        required: true,
                    },
                    [namespace + "joiningDate"]: {
                        required: true,
                        date: true
                    },
                    [namespace + "grossSalaryCTCPM"]: {
                        required: true,
                        numericality: true
                    },
                    [namespace + "stipend"]: {
                        required: true,
                        numericality: true
                    },
                    [namespace + "grossSalaryCTCPA"]: {
                        required: true,
                        numericality: true
                    },
                    [namespace + "insuranceLink"]: {
                        required: true
                    }
                },
                messages: {
                    [namespace + "employeeCode"]: {
                        required: "Please enter Employee Code",
                        maxlength: "Employee Code exceeding maximum lenght!",
                        lettersAndNumbersOnly:
                            "Use only letters and numbers for Employee Code!",
                    },
                    [namespace + "firstName"]: {
                        required: "Please enter First Name",
                        maxlength: "First Name exceeding maximum lenght!",
                        lettersOnly:
                            "Use only letters for First Name!",
                    },
                    [namespace + "lastName"]: {
                        required: "Please enter Last Name",
                        maxlength: "Last Name exceeding maximum lenght!",
                        lettersOnly:
                            "Use only letters for Last Name!",
                    },
                    [namespace + "middleName"]: {
                        required: "Please enter Middle Name",
                        maxlength: "Middle Name exceeding maximum lenght!",
                        lettersOnly:
                            "Use only letters for Middle Name!",
                    },
                    [namespace + "designation"]: {
                        required: "Please select a Designation!"

                    },
                    [namespace + "department"]: {
                        required: "Please select a Department!"

                    },
                    [namespace + "officialEmailId"]: {
                        required: "Please Enter a valid Email ID",
                    },
                    [namespace + "joiningDate"]: {
                        required: "Please Enter a valid Joining date",
                        date: "Enter a proper Date Only"
                    },
                    [namespace + "grossSalaryCTCPM"]: {
                        required: "Please Enter a valid Salary",
                        numericality: "Plese enter a valid Salary"
                    },
                    [namespace + "grossSalaryCTCPA"]: {
                        required: "Please Enter a valid Salary",
                        numericality: "Plese enter a valid Salary"
                    },
                    [namespace + "insuranceLink"]: {
                        required: "Please Enter a valid Insurance Link",
                    }
                },
                errorPlacement: function (error, element) {
                    error.insertAfter(element);
                },
            });

            $.validator.addMethod(
                "lettersAndSpacesOnly",
                function (value, element) {
                    return this.optional(element) || /^[a-zA-Z\s]+$/.test(value);
                },
                "Please enter only alphabetical characters and spaces"
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
                    return this.optional(element) || /^\d*\.?\d+$/.test(value);
                },
                "Please Use Decimals."
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
                if (fileName != '') {
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
            // Function to check the selected type of employee
            function checkEmployeeType() {
                var selectedType = $('#typeOfEmployee').val();
                if (selectedType === 'intern') {
                    $('#designation').val('Intern');
                    $('#stipend').prop('disabled', false);
                    $('#grossSalaryCTCPA, #grossSalaryCTCPM').prop('disabled', true); // Disable CTC fields
                } else {
                    $('#grossSalaryCTCPA, #grossSalaryCTCPM').prop('disabled', false); // Enable CTC fields
                    $('#stipend').prop('disabled', true);
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

            // Initial check on page load
            checkEmployeeType();

            // Check when the type of employee changes
            $('#typeOfEmployee').on('change', function () {
                checkEmployeeType();
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
