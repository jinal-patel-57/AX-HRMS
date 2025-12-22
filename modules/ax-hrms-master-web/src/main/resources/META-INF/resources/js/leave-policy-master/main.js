(function($, AxLeavePolicyMasterWebPortlet) {

    let namespace;

    if ($.validator && $.validator.addMethod) {

        if (!$.validator.methods.validateAccrualRate) {
            $.validator.addMethod("validateAccrualRate", function(value, element) {
                return this.optional(element) || /^\d{1,3}(\.\d{0,3})?$/.test(value);
            }, "Total Leave of the Year should contain up to 3 digits.");
        }

        if (!$.validator.methods.validateYearOfPolicy) {
            $.validator.addMethod("validateYearOfPolicy", function(value, element) {
                return this.optional(element) || (/^\d{4}$/).test(value);
            }, "Please Enter A valid Year");
        }

        if (!$.validator.methods.validLeavePolicyDescription) {
            $.validator.addMethod("validLeavePolicyDescription", function(value, element) {
                value = value.trim();
                return this.optional(element) ||
                    /^[A-Za-z0-9\s.,&()-]+$/.test(value);
            }, "Only letters, numbers, spaces and . , & ( ) - are allowed");
        }
    }

    function setConfigsForValidation(config) {

        namespace = config.namespace;

        const form = $("#" + namespace + "leavePolicyForm");

        if (!form.length) {
            return;
        }

        if (form.data("validator")) {
            form.validate().destroy();
        }

        form.validate({
            rules: {
                [namespace + "leavetypemasterid"]: { required: true },
                [namespace + "accrualrate"]: {
                    required: true,
                    digits: true,
                    minlength: 1,
                    maxlength: 3
                },
                [namespace + "maximumbalance"]: {
                    required: function() {
                        return $("#" + namespace + "iscarryforward").is(":checked");
                    },
                    min: function() {
                        if ($("#" + namespace + "iscarryforward").is(":checked")) {
                            return 0.01;
                        }
                    }
                },
                [namespace + "eligibleaftermonths"]: {
                    required: true,
                    digits: true,
                    minlength: 1,
                    maxlength: 2
                },
                [namespace + "yearOfPolicy"]: {
                    required: true,
                    validateYearOfPolicy: true
                },
                [namespace + "description"]: {
                    required: true,
                    minlength: 5,
                    maxlength: 255,
                    validLeavePolicyDescription: true
                }
            },
            messages: {
                [namespace + "leavetypemasterid"]: {
                    required: "Please select a leave type"
                },
                [namespace + "accrualrate"]: {
                    required: "Please enter total leave of the year",
                    digits: "Please enter only digits",
                    minlength: "Please enter up to two digits",
                    maxlength: "Please enter up to two digits"
                },
                [namespace + "maximumbalance"]: {
                    required: "Please enter maximum balance",
                    min: "Please enter a value greater than 0 for maximum balance"
                },
                [namespace + "eligibleaftermonths"]: {
                    required: "Please enter eligible after months",
                    digits: "Please enter only digits",
                    minlength: "Please enter up to two digits",
                    maxlength: "Please enter up to two digits"
                },
                [namespace + "description"]: {
                    required: "Please enter description",
                    minlength: "Description must be at least 5 characters",
                    maxlength: "Description cannot exceed 255 characters",
                    validLeavePolicyDescription:
                        "Only letters, numbers, spaces and . , & ( ) - are allowed"
                }
            },
            errorPlacement: function(error, element) {
                error.insertAfter(element);
            },
            highlight: function(element) {
                $(element).addClass("is-invalid");
            },
            unhighlight: function(element) {
                $(element).removeClass("is-invalid");
            },
            onkeyup: function(element) {
                $(element).valid();
            },
            onfocusout: function(element) {
                $(element).valid();
            },
            submitHandler: function(form) {
                form.submit();
            }
        });
        $("#" + namespace + "maximumbalance").prop("disabled", true);
        $("#" + namespace + "ischeckmax").prop("disabled", true);

        if (config.cf) {
            $("#" + namespace + "maximumbalance").prop("disabled", false);
            $("#" + namespace + "ischeckmax").prop("disabled", false);
        }

        $("#" + namespace + "iscarryforward").change(function () {

            var isChecked = $(this).is(":checked");

            $("#" + namespace + "maximumbalance").prop("disabled", !isChecked);
            $("#" + namespace + "ischeckmax").prop("disabled", !isChecked);

            if (!isChecked) {
                $("#" + namespace + "maximumbalance").val("");
                $("#" + namespace + "maximumbalance").removeClass("is-invalid");
                $("#" + namespace + "maximumbalance").next("label.error").remove();
                $("#" + namespace + "ischeckmax").prop("checked", false);
            }
        });

    }

    function setConfigsForDeleteLeavePolicyMaster(config) {
        let url = config.deleteLeavePolicyMasterURL;
        url = url.replace('LEAVE_POLICY_MASTER_ID', config.leavePolicyMasterid);
        if (confirm('Are you sure you want to delete?')) {
            window.location.href = url;
        }
    }

    AxLeavePolicyMasterWebPortlet.setConfigsForValidation =
        setConfigsForValidation;
    AxLeavePolicyMasterWebPortlet.setConfigsForDeleteLeavePolicyMaster =
        setConfigsForDeleteLeavePolicyMaster;

})($, window.AxLeavePolicyMasterWebPortlet =
    window.AxLeavePolicyMasterWebPortlet || {});
