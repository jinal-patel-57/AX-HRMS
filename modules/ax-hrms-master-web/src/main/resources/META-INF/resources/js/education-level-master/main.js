(function ($, AxEducationLevelMasterWebPortlet) {

    let namespace;



    $.validator.addMethod("validEducationLevelName", function (value, element) {
        value = value.trim();

        // Starts with letter
        // Allows letters, spaces, dot and hyphen
        return this.optional(element) ||
            /^[A-Za-z]+([A-Za-z\s.-]*[A-Za-z])?$/.test(value);

    }, "Enter a valid Education Level name");



    function setConfigsForValidation(config) {
        namespace = config.namespace;

        const form = $("#addEditEducationLevelMaster");

        // Prevent duplicate initialization
        if (!form.length || form.data("validator")) {
            return;
        }

        form.validate({
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

            errorPlacement: function (error, element) {
                error.addClass("text-danger");
                error.insertAfter(element);
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

})($, (window.AxEducationLevelMasterWebPortlet =
    window.AxEducationLevelMasterWebPortlet || {}));
