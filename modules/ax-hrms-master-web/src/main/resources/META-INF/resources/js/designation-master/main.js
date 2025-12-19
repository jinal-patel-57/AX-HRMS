(function ($, AxDesignationMasterWebPortlet) {

    let namespace;



    $.validator.addMethod("validDesignationName", function (value, element) {
        value = value.trim();

        // Starts with letter
        // Allows letters, spaces, dot and hyphen
        return this.optional(element) ||
            /^[A-Za-z]+([A-Za-z\s.-]*[A-Za-z])?$/.test(value);

    }, "Enter a valid Designation Name");



    function setConfigsForValidation(config) {

        namespace = config.namespace;

        const form = $("#designationMasterForm");

        // Prevent duplicate validation
        if (!form.length || form.data("validator")) {
            return;
        }

        form.validate({
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
                        "Only letters, spaces, '.', and '-' are allowed"
                }
            },

            errorPlacement: function (error, element) {
                error.addClass("text-danger");
                error.insertAfter(element);
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

})($, (window.AxDesignationMasterWebPortlet =
    window.AxDesignationMasterWebPortlet || {}));
