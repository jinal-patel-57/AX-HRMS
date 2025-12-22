(function ($, AxLeaveCompensatoryStatusMasterWebPortlet) {

    let namespace;

    $(document).ready(function () {

        if (!$.validator || !$.validator.addMethod) {
            return;
        }

        if (!$.validator.methods.validLeaveCompStatusName) {
            $.validator.addMethod(
                "validLeaveCompStatusName",
                function (value, element) {
                    value = value.trim();
                    return this.optional(element) ||
                        /^[A-Za-z]+([A-Za-z\s&-]*[A-Za-z])?$/.test(value);
                },
                "Only letters, spaces, '&' and '-' are allowed"
            );
        }
    });

    function setConfigsForValidation(config) {

        namespace = config.namespace;

        const $form = $("#addEditLeaveCompensatoryStatusMaster");

        if (!$form.length) {
            return;
        }

        if ($form.data("validator")) {
            $form.validate().destroy();
        }

        $form.validate({

            ignore: [],

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
                        "Only letters, spaces, '&' and '-' are allowed"
                }
            },

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

            submitHandler: function (form) {
                form.submit();
            }
        });
    }

    function setConfigsForDeleteLeaveCompensatoryStatusMaster(config) {

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

})(
    jQuery,
    window.AxLeaveCompensatoryStatusMasterWebPortlet =
        window.AxLeaveCompensatoryStatusMasterWebPortlet || {}
);
