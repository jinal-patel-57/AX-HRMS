(function ($, AxWishTypeMasterWebPortlet) {

    let namespace;

    function setConfigsForValidation(config) {
        namespace = config.namespace;

        if (!$.validator || !$("#addEditWishTypeMaster").length) {
            return;
        }

        $.validator.addMethod("validWishTypeName", function (value, element) {
            value = value.trim();
            return this.optional(element) ||
                /^[A-Za-z]+([A-Za-z\s&-]*[A-Za-z])?$/.test(value);
        });

        $("#" + namespace + "wishType").attr({
            minlength: 2,
            maxlength: 70
        });

        $("#addEditWishTypeMaster").validate({
            rules: {
                [namespace + "wishType"]: {
                    required: true,
                    minlength: 2,
                    maxlength: 70,
                    validWishTypeName: true
                }
            },
            messages: {
                [namespace + "wishType"]: {
                    required: "Enter Wish Type name",
                    minlength: "Wish Type must be at least 2 characters",
                    maxlength: "Wish Type cannot exceed 70 characters",
                    validWishTypeName:
                        "Only letters, spaces, '&' and '-' are allowed"
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

    function setConfigsForDeleteWishTypeMaster(config) {
        namespace = config.namespace;

        let url = config.deleteUrl.replace(
            'WISHTYPE_MASTER_ID',
            config.wishTypeMasterId
        );

        if (confirm("Are you sure you want to delete this Wish Type?")) {
            window.location.href = url;
        }
    }

    AxWishTypeMasterWebPortlet.setConfigsForValidation = setConfigsForValidation;
    AxWishTypeMasterWebPortlet.setConfigsForDeleteWishTypeMaster =
        setConfigsForDeleteWishTypeMaster;

})($, (window.AxWishTypeMasterWebPortlet =
    window.AxWishTypeMasterWebPortlet || {}));
