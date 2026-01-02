(function ($, AxProbationStatusMasterWebPortlet) {

    let namespace;

    function setConfigsForValidation(config) {
        namespace = config.namespace;

        if (!$.validator || !$("#addEditProbationStatusMaster").length) {
            return;
        }

       $.validator.addMethod("startsWithLetter", function (value, element) {
           return this.optional(element) || /^[A-Za-z]/.test(value);
       });

       $.validator.addMethod("validCharacters", function (value, element) {
           return this.optional(element) || /^[A-Za-z\s-]+$/.test(value);
       });


        $("#" + namespace + "probationStatus").attr({
            minlength: 2,
            maxlength: 70
        });

        $("#addEditProbationStatusMaster").validate({
            rules: {
               [namespace + "probationStatus"]: {
                       required: true,
                       minlength: 2,
                       maxlength: 70,
                       startsWithLetter: true,
                       validCharacters: true
                   }
            },
            messages: {
                 [namespace + "probationStatus"]: {
                        required: "Enter Probation Status name",
                        minlength: "Probation Status must be at least 2 characters",
                        maxlength: "Probation Status cannot exceed 70 characters",
                        startsWithLetter: "Probation Status must start with a letter",
                        validCharacters: "Only letters, spaces, and hyphens (-) are allowed"
                    }
            },
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

            onfocusout: function (element) {
                $(element).valid();
            },
            onkeyup: function (element) {
                $(element).valid();
            },
            submitHandler: function (form) {
                form.submit();
            }
        });
    }

    function setConfigsForDeleteProbationStatusMaster(config) {
        namespace = config.namespace;

        let url = config.deleteUrl.replace(
            'PROBATIONSTATUS_MASTER_ID',
            config.probationStatusMasterId
        );

        if (confirm("Are you sure you want to delete this Probation Status?")) {
            window.location.href = url;
        }
    }

    AxProbationStatusMasterWebPortlet.setConfigsForValidation = setConfigsForValidation;
    AxProbationStatusMasterWebPortlet.setConfigsForDeleteProbationStatusMaster =
        setConfigsForDeleteProbationStatusMaster;

})($, (window.AxProbationStatusMasterWebPortlet =
    window.AxProbationStatusMasterWebPortlet || {}));
