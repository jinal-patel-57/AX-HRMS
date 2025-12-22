(function ($, AxDesignationMasterWebPortlet) {

    'use strict';

    let namespace;

    $(document).ready(function () {

        if (!$.validator || !$.validator.addMethod) {
            return;
        }

        if (!$.validator.methods.validDesignationName) {
            $.validator.addMethod("validDesignationName", function (value, element) {
                value = value.trim();
                return this.optional(element) ||
                    /^[A-Za-z]+([A-Za-z\s.&-]*[A-Za-z])?$/.test(value);
            }, "Enter a valid Designation Name");

        }
    });

    function setConfigsForValidation(config) {

        namespace = config.namespace;

        const $form = $("#designationMasterForm");

        if (!$form.length) {
            return;
        }

        if ($form.data("validator")) {
            $form.validate().destroy();
        }

        $form.validate({

            ignore: [],

            rules: {
                [namespace + "designationName"]: {
                    required: true,
                    minlength: 2,
                    maxlength: 70,
                    validDesignationName: true
                }
            },

            messages: {
                [namespace + "designationName"]: {
                    required: "Enter Designation Name",
                    minlength: "Designation Name must be at least 2 characters",
                    maxlength: "Designation Name cannot exceed 70 characters",
                    validDesignationName:
                        "Only letters, spaces, &, '.', and '-' are allowed"
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

    function setConfigsForDeleteDesignation(config) {

        let url = config.deleteUrl.replace(
            'DESIGNATION_MASTER_ID',
            config.designationMasterId
        );

        if (confirm('Are you sure you want to delete this Designation?')) {
            window.location.href = url;
        }
    }

    AxDesignationMasterWebPortlet.setConfigsForValidation =
        setConfigsForValidation;

    AxDesignationMasterWebPortlet.setConfigsForDeleteDesignation =
        setConfigsForDeleteDesignation;

})(
    jQuery,
    window.AxDesignationMasterWebPortlet =
        window.AxDesignationMasterWebPortlet || {}
);
