(function ($, AxBranchMasterWebPortlet) {

    'use strict';

    /* ===================== CUSTOM VALIDATORS ===================== */


    /* ===================== FORM VALIDATION ===================== */

    function setConfigsForValidation(config) {

        const namespace = config.namespace;
        const $form = $("#branchForm");
 $.validator.addMethod("validBranchName", function (value, element) {
        return this.optional(element) ||
            /^[A-Za-z]+([A-Za-z\s&\/-]*[A-Za-z])?$/.test(value.trim());
    });

    $.validator.addMethod("validAddress", function (value, element) {
        return this.optional(element) ||
            /^[A-Za-z0-9\s,.\-\/]+$/.test(value.trim());
    });

    $.validator.addMethod("validCity", function (value, element) {
        return this.optional(element) ||
            /^[A-Za-z\s]+$/.test(value.trim());
    });

    $.validator.addMethod("validState", function (value, element) {
        return this.optional(element) ||
            /^[A-Za-z\s]+$/.test(value.trim());
    });

    $.validator.addMethod("validPincode", function (value, element) {
        return this.optional(element) ||
            /^\d{6}$/.test(value);
    });

        if (!$form.length) {
            return;
        }

        if ($form.data("validator")) {
            $form.validate().destroy();
        }

        $form.validate({

            ignore: [],



            rules: {

                [namespace + "branchName"]: {
                    required: true,
                    minlength: 2,
                    maxlength: 70,
                    validBranchName: true
                },

                [namespace + "address"]: {
                    required: true,
                    maxlength: 250,
                    validAddress: true
                },

                [namespace + "city"]: {
                    required: true,
                    maxlength: 75,
                    validCity: true
                },

                [namespace + "state"]: {
                    required: true,
                    maxlength: 100,
                    validState: true
                },

                [namespace + "country"]: {
                    required: true
                },

                [namespace + "pincode"]: {
                    required: true,
                    digits: true,
                    validPincode: true
                }
            },

            messages: {

                [namespace + "branchName"]: {
                    required: "Please enter branch name",
                    minlength: "Branch name must be at least 2 characters",
                    maxlength: "Branch name cannot exceed 70 characters",
                    validBranchName:
                        "Only letters, spaces, &, / and - are allowed"
                },

                [namespace + "address"]: {
                    required: "Please enter address",
                    maxlength: "Address cannot exceed 250 characters",
                    validAddress:
                        "Address can contain letters, numbers, spaces, comma (,), dot (.), slash (/) and hyphen (-)"
                },

                [namespace + "city"]: {
                    required: "Please enter city",
                    maxlength: "City name cannot exceed 75 characters",
                    validCity: "City should contain only letters and spaces"
                },

                [namespace + "state"]: {
                    required: "Please enter state",
                    maxlength: "State name cannot exceed 100 characters",
                    validState: "State should contain only letters and spaces"
                },

                [namespace + "country"]: {
                    required: "Please select country"
                },

                [namespace + "pincode"]: {
                    required: "Please enter pincode",
                    digits: "Pincode should contain only digits",
                    validPincode: "Pincode must be exactly 6 digits"
                }
            },

            /* ===================== REAL-TIME VALIDATION ===================== */

           errorElement: "small",

              errorPlacement: function (error, element) {
                  error.addClass("text-danger");
                  error.insertAfter(element);
              },

              highlight: function (element) {
                  $(element).addClass("is-invalid");
              },

              unhighlight: function (element) {
                  $(element).removeClass("is-invalid");
              },

              onkeyup: function (element) {
                  $(element).valid();
              },

              onfocusout: function (element) {
                  $(element).valid();
              },

            /* ===================== SUBMIT CONTROL ===================== */

            submitHandler: function (form) {
                form.submit();
            }
        });
    }

    /* ===================== DELETE ===================== */

    function setConfigsForDelete(config) {

        const url = config.deleteURL.replace(
            'BRANCH_ID',
            config.branchId
        );

        if (confirm("Are you sure you want to delete this branch?")) {
            window.location.href = url;
        }
    }

    AxBranchMasterWebPortlet.setConfigsForValidation =
        setConfigsForValidation;

    AxBranchMasterWebPortlet.setConfigsForDelete =
        setConfigsForDelete;

})(jQuery, window.AxBranchMasterWebPortlet =
    window.AxBranchMasterWebPortlet || {});
