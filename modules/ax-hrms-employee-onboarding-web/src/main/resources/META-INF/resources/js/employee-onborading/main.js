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
        namespace = config.namespace;

        var originalSection = document.querySelector('.experience-section');
        var newSection = originalSection.cloneNode(true);

        var anchors = newSection.getElementsByTagName('a');
        while (anchors.length > 0) {
            var parent = anchors[0].parentNode;
            while (anchors[0].firstChild) {
                parent.insertBefore(anchors[0].firstChild, anchors[0]);
            }
            parent.removeChild(anchors[0]);
        }

        var inputs = newSection.querySelectorAll('input,select');
        var index = document.querySelectorAll('.experience-section').length + 1;

        var previous = document.getElementById("currentIndex").value
        document.getElementById("currentIndex").value = 1 + parseInt(previous);

        inputs.forEach(function (input) {

            input.id = input.id.replace(/[0-9]+$/, '') + index;
            input.name = input.name.replace(/\d+$/, '') + index;

            input.value = '';
        });

        document.getElementById('experience-section-container').appendChild(newSection);
        const redundantFooter = newSection.getElementsByClassName("card-footer");
        if(redundantFooter.length >0){
            redundantFooter[0].remove();
        }

        var deleteButton = document.createElement('button');
        deleteButton.className = 'btn btn-outline-danger delete-section';
        // deleteButton.textContent = 'Delete';
        deleteButton.type = 'button';
        const icon = document.createElement("i");
        icon.className= "icon-trash";
        deleteButton.appendChild(icon);

        const footerExpDel = document.createElement("div");
        footerExpDel.className="card-footer text-right";
        footerExpDel.appendChild(deleteButton);
        const card = newSection.getElementsByClassName("card")[0];
        card.appendChild(footerExpDel);


        deleteButton.addEventListener('click', function () {
            newSection.remove();
        });
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
                        date: true
                    },
                    [namespace + "mobileNo"]: {
                        required: true,
                        digits: true,
                        minlength: 10,
                        maxlength: 15
                    },
                    [namespace + "skypeId"]: {
                        required: true
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
                        date: "Please enter a valid date."
                    },
                    [namespace + "mobileNo"]: {
                        required: "Please enter your mobile number.",
                        digits: "Mobile number should contain only digits.",
                        minlength: "Mobile number must be at least 10 digits long.",
                        maxlength: "Mobile number must not exceed 15 digits."
                    },
                    [namespace + "skypeId"]: {
                        required: "Please Enter skypeId."
                    },
                    [namespace + "fatherName"]: {
                        required: "Please Enter FatherName."
                    },
                    [namespace + "marriageDate"]: {
                        required: "Please enter your marriage date.",
                        date: "Please enter a valid date."
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

            var fileInput = document.getElementById(namespace + 'employeeProfilePicture');

            const myFile = new File([''], profilePicName, {
                type: 'text/plain',
                lastModified: new Date(),
            });
            const dataTransfer = new DataTransfer();
            dataTransfer.items.add(myFile);
            fileInput.files = dataTransfer.files;


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
                        var currentTab = $('.nav-link.active');
                        var nextTabButton = currentTab.parent().next().find('.nav-link');
                        if (nextTabButton.length > 0) {
                            nextTabButton.tab('show');
                            var nextTabContentId = nextTabButton.attr('data-bs-target');
                            $(nextTabContentId).find('input').first().focus();
                        }
                    },
                    error: function () {
                        console.log('There was an error saving the data. Please try again.');
                    }
                });
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


    $('.previous-button').on('click', function (event) {
        event.preventDefault();
        const currentTab = $('.nav-link.active');
        const previousTabButton = currentTab.parent().prev().find('.nav-link');
        if (previousTabButton.length > 0) {
            previousTabButton.tab('show');
            const previousTabContentId = previousTabButton.attr('data-bs-target');
            $(previousTabContentId).find('input').first().focus();
        }
    });

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

      jQuery.validator.addMethod("endAfterStart", function (value, element, paramSelector) {
          var startVal = $(paramSelector).val();
          if (!startVal || !value) {
              return true;
          }
        
          try {
              return new Date(value) >= new Date(startVal);
          } catch (e) {
              return false;
          }
      }, "End date must be after start date.");

      config.educationIndex = educationIndex;

      $(document).ready(function () {

          function teardownValidator(form) {

              form.find('.is-invalid, .is-valid').removeClass('is-invalid is-valid');
              form.find('div.invalid-feedback').remove();
              form.removeData('validator');
              form.removeData('unobtrusiveValidation');
          }

          function initializeValidation() {
              const form3 = $("#educationStepperForm");

              teardownValidator(form3);

              const rules = {};
              const messages = {};

              document.querySelectorAll('.education-section').forEach((section, index) => {
                  const idx = index + 1;


                  const levelNameName = `${namespace}levelName${idx}`;
                  const institutionName = `${namespace}institution${idx}`;
                  const degreeName = `${namespace}degree${idx}`;
                  const startDateName = `${namespace}startDate${idx}`;
                  const endDateName = `${namespace}endDate${idx}`;
                  const passingYearName = `${namespace}passingYear${idx}`;


                  const startSelector = `[name="${startDateName}"]`;

                  rules[levelNameName] = { required: true };
                  rules[institutionName] = { required: true, maxlength: 250 };
                  rules[degreeName] = { required: true, maxlength: 75 };
                  rules[startDateName] = { required: true, date: true };

                  rules[endDateName] = {
                      required: true,
                      date: true,
                      endAfterStart: startSelector
                  };

                  rules[passingYearName] = { required: true, digits: true, minlength: 4, maxlength: 4 };

                  messages[levelNameName] = { required: "Please select an education level name." };
                  messages[institutionName] = {
                      required: "Please enter the institution name.",
                      maxlength: "Institution name should not exceed 250 characters."
                  };
                  messages[degreeName] = {
                      required: "Please enter the degree obtained.",
                      maxlength: "Degree should not exceed 75 characters."
                  };
                  messages[startDateName] = {
                      required: "Please enter the start date.",
                      date: "Please enter a valid date."
                  };
                  messages[endDateName] = {
                      required: "Please enter the end date.",
                      date: "Please enter a valid date.",
                      endAfterStart: "End date must be after start date."
                  };
                  messages[passingYearName] = {
                      required: "Please enter the passing year.",
                      digits: "Passing year should contain only digits.",
                      minlength: "Passing year should be 4 digits long.",
                      maxlength: "Passing year should be 4 digits long."
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
                  messages: messages,
              });
          }

          try {
              var index_edu = parseInt(educationIndex);
              for (var i = 1; i < index_edu; i++) {
                  $('.nav-link.active').parent().next().find('.nav-link').click();
              }
          } catch (err) {
              console.log("error" + err);
          }

          function addEducationSection() {
              const originalSection = document.getElementById('initial-education-section');
              const newSection = originalSection.cloneNode(true);

              var anchors = newSection.getElementsByTagName('a');
              while (anchors.length > 0) {
                  var parent = anchors[0].parentNode;
                  while (anchors[0].firstChild) {
                      parent.insertBefore(anchors[0].firstChild, anchors[0]);
                  }
                  parent.removeChild(anchors[0]);
              }

              const index = document.querySelectorAll('.education-section').length + 1;

              newSection.querySelectorAll('input, select').forEach(input => {
                  input.id = input.id.replace(/[0-9]+$/, '') + index;
                  input.name = input.name.replace(/[0-9]+$/, '') + index;
                  input.value = '';
              });

              const deleteButton = document.createElement('button');
              deleteButton.className = 'btn btn-outline-danger delete-section';
              deleteButton.type = 'button';
              deleteButton.onclick = function () {
                  newSection.remove();
                  initializeValidation();
              };

              const redundantFooter = newSection.getElementsByClassName("card-footer");
              if (redundantFooter.length > 0) {
                  redundantFooter[0].remove();
              }

              const footerElementNew = document.createElement("div");
              footerElementNew.className = "card-footer text-right";

              const icon = document.createElement("i");
              icon.className = "icon-trash";
              deleteButton.appendChild(icon);
              footerElementNew.appendChild(deleteButton);

              const placement = newSection.getElementsByClassName("card");
              placement[0].appendChild(footerElementNew);

              document.getElementById('education-section-container').appendChild(newSection);

              document.getElementById("educationCurrentIndex").value = index;

              initializeValidation();
          }

          $('#add-education-section').on('click', addEducationSection);

          $('.next-button-education-details').on('click', function (event) {
              initializeValidation();

              const form3 = $('#educationStepperForm');

              if (!form3.valid()) {
                  event.preventDefault();
                  return false;
              }

              $.ajax({
                  url: form3.attr('action'),
                  method: 'POST',
                  data: form3.serialize(),
                  success: function (response) {
                      const currentTab = $('.nav-link.active');
                      document.getElementById("firstVisitEducation").value = "false";
                      const nextTabButton = currentTab.parent().next().find('.nav-link');
                      if (nextTabButton.length > 0) {
                          nextTabButton.tab('show');
                          const nextTabContentId = nextTabButton.attr('data-bs-target');
                          $(nextTabContentId).find('input').first().focus();
                      }
                  },
                  error: function () {
                      console.log('There was an error saving the data. Please try again.');
                  }
              });
          });

          $('#noactionbtnEducation').on('click', function () {
              const currentTab = $('.nav-link.active');
              const nextTabButton = currentTab.parent().next().find('.nav-link');
              if (nextTabButton.length > 0) {
                  nextTabButton.tab('show');
                  const nextTabContentId = nextTabButton.attr('data-bs-target');
                  $(nextTabContentId).find('input').first().focus();
              }
          });

          initializeValidation();
      });
  }



    function setConfigsForExperienceValidation(config) {
        config.experienceIndex = experienceIndex;

        $(document).ready(function () {
            let rules = {};
            let messages = {};

            function initializeValidationForExperience() {
                const form4 = $("#experienceStepperForm");

                document.querySelectorAll('.experience-section').forEach((section, index) => {
                    const idx = index + 1;
                    const companyNameKey = `${namespace}companyName${idx}`;
                    const joiningDateKey = `${namespace}joiningDate${idx}`;
                    const relievingDateKey = `${namespace}relievingDate${idx}`;
                    rules[companyNameKey] = {required: true};
                    rules[joiningDateKey] = {required: true, date: true};
                    rules[relievingDateKey] = {required: true, date: true};

                    messages[companyNameKey] = {
                        required: "Please select Company Name."
                    };

                    messages[joiningDateKey] = {
                        required: "Please enter the start date.",
                        date: "Please enter a valid date."
                    };
                    messages[relievingDateKey] = {
                        required: "Please enter the end date.",
                        date: "Please enter a valid date."
                    };
                });


                form4.validate({
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

            try {
                var index_experience = parseInt(experienceIndex);
                for (var i = 1; i < index_experience; i++) {
                    $('.nav-link.active').parent().next().find('.nav-link').click();
                }
            } catch (err) {
                console.log(err);
            }

            $('.next-button-experience-details').on('click', function (event) {
                initializeValidationForExperience();
                event.preventDefault();
                const form4 = $('#experienceStepperForm');
                if (!form4.valid()) {
                    return false;
                }

                var formData = new FormData(form4[0]);

                $.ajax({
                    url: form4.attr('action'),
                    data: formData,
                    method: 'POST',
                    contentType: false,
                    processData: false,
                    success: function (response) {
                        const currentTab = $('.nav-link.active');
                        document.getElementById("firstVisit").value = "false";
                        const nextTabButton = currentTab.parent().next().find('.nav-link');
                        if (nextTabButton.length > 0) {
                            nextTabButton.tab('show');
                            const nextTabContentId = nextTabButton.attr('data-bs-target');
                            $(nextTabContentId).find('input').first().focus();
                        }
                    },
                    error: function () {
                        console.log('There was an error saving the data. Please try again.');
                    }
                });
            });


            $('#noactionbtnExperience').on('click', function (event) {
                const currentTab = $('.nav-link.active');
                const nextTabButton = currentTab.parent().next().find('.nav-link');
                if (nextTabButton.length > 0) {
                    nextTabButton.tab('show');
                    const nextTabContentId = nextTabButton.attr('data-bs-target');
                    $(nextTabContentId).find('input').first().focus();
                }
            });

        });
        AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForExperienceValidation = setConfigsForExperienceValidation;
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
                [namespace + "accountType"]: {
                    required: true
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
                    maxlength: 75
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
                [namespace + "accountType"]: {
                    required: "Please select an account type."
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
                    maxlength: "IFSC code should not exceed 75 characters."
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

        $('.next-button-uan-esic-details').on('click', function (event) {
            const form6 = $('#uanEsicStepperForm');
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
                    window.location.href = getEmployeeUrl;
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