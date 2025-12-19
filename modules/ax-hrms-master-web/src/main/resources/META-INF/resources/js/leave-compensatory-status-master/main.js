(function ($, AxLeaveCompensatoryStatusMasterWebPortlet) {

    let namespace;

    function setConfigsForValidation(config) {
        namespace = config.namespace;

        $(document).ready(function () {

            // Custom validator for Leave Compensatory Status Name
            $.validator.addMethod("validLeaveCompStatusName", function (value, element) {

                value = value.trim();

                // Starts with letter
                // Allows letters, spaces and hyphen
                return this.optional(element) ||
                    /^[A-Za-z]+([A-Za-z\s-]*[A-Za-z])?$/.test(value);

            }, "Enter a valid Leave Compensatory Status name");

            $("#addEditLeaveCompensatoryStatusMaster").validate({
                rules: {
                    [namespace + "leaveCompensatoryStatus"]: {
                        required: true,
                        minlength: 2,
                        maxlength: 50,
                        validLeaveCompStatusName: true
                    }
                },
                messages: {
                    [namespace + "leaveCompensatoryStatus"]: {
                        required: "Enter Leave Compensatory Status name",
                        minlength: "Must be at least 2 characters",
                        maxlength: "Cannot exceed 50 characters",
                        validLeaveCompStatusName:
                            "Only letters, spaces and '-' are allowed"
                    }
                },
                errorPlacement: function (error, element) {
                    error.addClass("text-danger");
                    error.insertAfter(element);
                }
            });
        });
    }

    function setConfigsForDeleteLeaveCompensatoryStatusMaster(config) {
        namespace = config.namespace;

        let url = config.deleteUrl.replace(
            'LEAVECOMPENSATORYSTATUS_MASTER_ID',
            config.leaveCompensatoryStatusMasterId
        );

        if (confirm(
            "Are you sure you want to delete this Leave Compensatory Status?"
        )) {
            window.location.href = url;
        }
    }

    AxLeaveCompensatoryStatusMasterWebPortlet.setConfigsForValidation =
        setConfigsForValidation;
    AxLeaveCompensatoryStatusMasterWebPortlet
        .setConfigsForDeleteLeaveCompensatoryStatusMaster =
        setConfigsForDeleteLeaveCompensatoryStatusMaster;

})($, (window.AxLeaveCompensatoryStatusMasterWebPortlet =
    window.AxLeaveCompensatoryStatusMasterWebPortlet || {}));
