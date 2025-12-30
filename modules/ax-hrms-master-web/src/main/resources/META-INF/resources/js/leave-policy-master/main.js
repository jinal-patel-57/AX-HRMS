(function ($, AxLeavePolicyMasterWebPortlet) {

    let namespace;

    function setConfigsForValidation(config) {

        namespace = config.namespace;

        $(document).ready(function () {

            const form = $("#" + namespace + "leavePolicyForm");
            if (!form.length) {
                return;
            }

            // Custom validators – SAME place & pattern as working reference
            $.validator.addMethod(
                "validateAccrualRate",
                function (value, element) {
                    return this.optional(element) || /^\d{1,3}$/.test(value);
                },
                "Total Leave of the Year should contain up to 3 digits."
            );

            $.validator.addMethod(
                "validateYearOfPolicy",
                function (value, element) {
                    return this.optional(element) || /^\d{4}$/.test(value);
                },
                "Please Enter A valid Year"
            );

            $.validator.addMethod(
                "validLeavePolicyDescription",
                function (value, element) {
                    value = value.trim();
                    return this.optional(element) ||
                        /^[A-Za-z0-9\s.,&()-]+$/.test(value);
                },
                "Only letters, numbers, spaces and . , & ( ) - are allowed"
            );

            // Destroy old validator if exists
            if (form.data("validator")) {
                form.validate().destroy();
            }

            form.validate({

                rules: {
                    [namespace + "leavetypemasterid"]: {
                        required: true
                    },

                    [namespace + "accrualrate"]: {
                        required: true,
                        digits: true,
                        maxlength: 3
                    },

                    [namespace + "eligibleaftermonths"]: {
                        required: true,
                        digits: true,
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
                        maxlength: "Please enter up to three digits"
                    },

                    [namespace + "eligibleaftermonths"]: {
                        required: "Please enter eligible after months",
                        digits: "Please enter only digits",
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

                errorPlacement: function (error, element) {
                    error.insertAfter(element);
                },

                highlight: function (element) {
                    $(element).addClass("is-invalid");
                },

                unhighlight: function (element) {
                    $(element).removeClass("is-invalid");
                }
            });
        });
    }

    function setConfigsForDeleteLeavePolicyMaster(config) {
        let url = config.deleteLeavePolicyMasterURL;
        url = url.replace("LEAVE_POLICY_MASTER_ID", config.leavePolicyMasterid);
        if (confirm("Are you sure you want to delete?")) {
            window.location.href = url;
        }
    }

    AxLeavePolicyMasterWebPortlet.setConfigsForValidation =
        setConfigsForValidation;

    AxLeavePolicyMasterWebPortlet.setConfigsForDeleteLeavePolicyMaster =
        setConfigsForDeleteLeavePolicyMaster;

})(jQuery,
   (window.AxLeavePolicyMasterWebPortlet =
       window.AxLeavePolicyMasterWebPortlet || {}));
