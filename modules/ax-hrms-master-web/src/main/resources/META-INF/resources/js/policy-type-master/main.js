(function ($, AxPolicyTypeMasterWebPortlet) {

    let namespace;

    function setConfigsForValidation(config) {
        namespace = config.namespace;

        $(document).ready(function () {

            const fieldName = namespace + "policyType";

            /* Custom validator */
            $.validator.addMethod("validPolicyType", function (value, element) {

                value = value.trim();


                const regex = /^[A-Za-z][A-Za-z0-9&]*(?:\s[A-Za-z0-9&]+)*$/;

                return this.optional(element) || regex.test(value);

            }, "Invalid Policy Type Name");

            const form = $("#addEditPolicyTypeMaster");

            form.validate({
                ignore: [],
                onkeyup: function (element) {
                    $(element).valid();   // REAL-TIME typing validation
                },
                onfocusout: function (element) {
                    $(element).valid();   // blur validation
                },
                rules: {
                    [fieldName]: {
                        required: true,
                        validPolicyType: true,
                        minlength: 2,
                        maxlength: 70
                    }
                },
                messages: {
                    [fieldName]: {
                        required: "Policy Type Name is required",
                        minlength: "Minimum 2 characters required",
                        maxlength: "Maximum 70 characters allowed",
                        validPolicyType:
                            "Only letters, numbers, spaces and '&' are allowed. Must start with a letter."
                    }
                },
                errorElement: "div",
                errorClass: "text-danger",
                highlight: function (element) {
                    $(element).addClass("is-invalid");
                },
                unhighlight: function (element) {
                    $(element).removeClass("is-invalid");
                },
                errorPlacement: function (error, element) {
                    error.insertAfter(element);
                },
                submitHandler: function (form) {
                    form.submit();
                }
            });

            /* 🔹 Paste + input handling (REAL-TIME cleanup) */
            $("#" + fieldName.replace(namespace, "")).on("input paste", function () {
                $(this).valid();
            });

            /* 🔹 Trim spaces automatically */
            $("#" + fieldName.replace(namespace, "")).on("blur", function () {
                $(this).val($(this).val().trim());
            });

        });
    }

    AxPolicyTypeMasterWebPortlet.setConfigsForValidation = setConfigsForValidation;

})($, (window.AxPolicyTypeMasterWebPortlet = window.AxPolicyTypeMasterWebPortlet || {}));
