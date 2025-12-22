(function ($, AxEducationLevelMasterWebPortlet) {

    'use strict';

    let namespace;


    $(document).ready(function () {

        if (!$.validator || !$.validator.addMethod) {
            console.error("jQuery Validation plugin not loaded");
            return;
        }

        if (!$.validator.methods.validEducationLevelName) {
            $.validator.addMethod(
                "validEducationLevelName",
                function (value, element) {
                    value = value.trim();

                    return this.optional(element) ||
                        /^[A-Za-z]+([A-Za-z\s.-]*[A-Za-z])?$/.test(value);
                },
                "Only letters, spaces, '.' and '-' are allowed"
            );
        }
    });


    function setConfigsForValidation(config) {

        namespace = config.namespace;

        const $form = $("#addEditEducationLevelMaster");

        if (!$form.length) {
            return;
        }


        if ($form.data("validator")) {
            $form.validate().destroy();
        }

        $form.validate({

            ignore: [],

            rules: {
                [namespace + "levelName"]: {
                    required: true,
                    minlength: 2,
                    maxlength: 70,
                    validEducationLevelName: true
                }
            },

            messages: {
                [namespace + "levelName"]: {
                    required: "Enter Education Level name",
                    minlength: "Education Level must be at least 2 characters",
                    maxlength: "Education Level cannot exceed 70 characters",
                    validEducationLevelName:
                        "Only letters, spaces, '.' and '-' are allowed"
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
                form.submit(); // submit ONLY when valid
            }
        });
    }


    function setConfigsForDeleteEducationLevelMaster(config) {

        let url = config.deleteUrl.replace(
            'EDUCATIONLEVEL_MASTER_ID',
            config.educationLevelMasterId
        );

        if (confirm("Are you sure you want to delete this Education Level?")) {
            window.location.href = url;
        }
    }


    AxEducationLevelMasterWebPortlet.setConfigsForValidation =
        setConfigsForValidation;

    AxEducationLevelMasterWebPortlet.setConfigsForDeleteEducationLevelMaster =
        setConfigsForDeleteEducationLevelMaster;

})(
    jQuery,
    window.AxEducationLevelMasterWebPortlet =
        window.AxEducationLevelMasterWebPortlet || {}
);
