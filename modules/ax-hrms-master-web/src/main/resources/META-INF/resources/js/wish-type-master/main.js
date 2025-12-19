(function ($, AxWishTypeMasterWebPortlet) {

    let namespace;

    function setConfigsForValidation(config) {
        namespace = config.namespace;

        $(document).ready(function () {

            // Custom validator for Wish Type Name
            $.validator.addMethod("validWishTypeName", function (value, element) {

                value = value.trim();

                // Starts with letter
                // Allows letters, spaces, hyphen, ampersand
                return this.optional(element) ||
                    /^[A-Za-z]+([A-Za-z\s&-]*[A-Za-z])?$/.test(value);

            }, "Enter a valid Wish Type name");

            $("#addEditWishTypeMaster").validate({
                rules: {
                    [namespace + "wishType"]: {
                        required: true,
                        minlength: 2,
                        maxlength: 50,
                        validWishTypeName: true
                    }
                },
                messages: {
                    [namespace + "wishType"]: {
                        required: "Enter Wish Type name",
                        minlength: "Wish Type must be at least 2 characters",
                        maxlength: "Wish Type cannot exceed 50 characters",
                        validWishTypeName:
                            "Only letters, spaces, '&' and '-' are allowed"
                    }
                },
                errorPlacement: function (error, element) {
                    error.addClass("text-danger");
                    error.insertAfter(element);
                }
            });
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
