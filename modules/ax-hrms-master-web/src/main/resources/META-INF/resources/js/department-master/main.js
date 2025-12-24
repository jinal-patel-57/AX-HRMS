(function ($, AxDepartmentMasterWebPortlet) {

    'use strict';

    let namespace;


    $(document).ready(function () {

        if (!$.validator || !$.validator.addMethod) {
            console.error("jQuery Validation plugin not loaded");
            return;
        }

        if (!$.validator.methods.validDepartmentName) {
            $.validator.addMethod(
                "validDepartmentName",
                function (value, element) {
                    value = value.trim();
                    return this.optional(element) ||
                        /^[A-Za-z]+([A-Za-z\s&-]*[A-Za-z])?$/.test(value);
                },
                "Please enter valid Department Name"
            );
        }
    });


    function setConfigsForValidation(config) {

        namespace = config.namespace;

        const $form = $("#departmentForm");

        if (!$form.length) {
            return;
        }


        if ($form.data("validator")) {
            $form.validate().destroy();
        }

        $form.validate({

            ignore: [],

            rules: {
                [namespace + "departmentName"]: {
                    required: true,
                    minlength: 2,
                    maxlength: 70,
                    validDepartmentName: true
                }
            },

            messages: {
                [namespace + "departmentName"]: {
                    required: "Please enter Department Name",
                    minlength: "Department Name must be at least 2 characters",
                    maxlength: "Department Name cannot exceed 70 characters",
                    validDepartmentName:
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


    function setConfigsForDeleteDepartment(config) {

        let url = config.deleteDepartmentURL.replace(
            'DEPARTMENT_MASTER_ID',
            config.departmentMasterId
        );

        if (confirm('Are you sure you want to delete this Department?')) {
            window.location.href = url;
        }
    }


    AxDepartmentMasterWebPortlet.setConfigsForValidation =
        setConfigsForValidation;

    AxDepartmentMasterWebPortlet.setConfigsForDeleteDepartment =
        setConfigsForDeleteDepartment;

})(
    jQuery,
    window.AxDepartmentMasterWebPortlet =
        window.AxDepartmentMasterWebPortlet || {}
);
