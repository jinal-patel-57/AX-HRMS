(function ($, AxProbationStatusMasterWebPortlet) {

    let namespace;

    function setConfigsForValidation(config) {
        namespace = config.namespace;

        $(document).ready(function () {

            // Custom validator for Probation Status Name
            $.validator.addMethod("validProbationStatusName", function (value, element) {
                // Starts with letter, allows letters, spaces, hyphen only
                return this.optional(element) ||
                    /^[A-Za-z][A-Za-z\s-]*$/.test(value);
            }, "Enter a valid Probation Status name");

            $("#addEditProbationStatusMaster").validate({
                rules: {
                    [namespace + "probationStatus"]: {
                        required: true,
                        minlength: 2,
                        maxlength: 70,
                        validProbationStatusName: true
                    }
                },
                messages: {
                    [namespace + "probationStatus"]: {
                        required: "Enter Probation Status name",
                        minlength: "Probation Status must be at least 2 characters",
                        maxlength: "Probation Status cannot exceed 70 characters",
                        validProbationStatusName: "Only letters, spaces and hyphen (-) are allowed"
                    }
                },
                errorPlacement: function (error, element) {
                    error.addClass("text-danger");
                    error.insertAfter(element);
                }
            });
        });
    }

    function setConfigsForDeleteProbationStatusMaster(config) {
        namespace = config.namespace;

        let url = config.deleteUrl.replace(
            'PROBATIONSTATUS_MASTER_ID',
            config.probationStatusMasterId
        );

        let text = "Are you sure you want to delete this Probation Status?";
        if (confirm(text)) {
            window.location.href = url;
        }
    }

    AxProbationStatusMasterWebPortlet.setConfigsForValidation = setConfigsForValidation;
    AxProbationStatusMasterWebPortlet.setConfigsForDeleteProbationStatusMaster =
        setConfigsForDeleteProbationStatusMaster;

})($, (window.AxProbationStatusMasterWebPortlet =
    window.AxProbationStatusMasterWebPortlet || {}));
