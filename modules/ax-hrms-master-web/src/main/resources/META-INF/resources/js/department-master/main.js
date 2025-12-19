(function ($, AxDepartmentMasterWebPortlet) {

    let namespace;

    function setConfigsForValidation(config) {
        namespace = config.namespace;

        $(document).ready(function () {

            // Custom validation for Department Name
            $.validator.addMethod("validDepartmentName", function (value, element) {

                // Trim spaces
                value = value.trim();

                // Regex:
                // Starts with letter
                // Allows letters, spaces, hyphen, ampersand
                // No multiple spaces
                return this.optional(element) ||
                    /^[A-Za-z]+([A-Za-z\s&-]*[A-Za-z])?$/.test(value);

            }, "Enter a valid Department Name");

            $("#departmentForm").validate({
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
                errorPlacement: function (error, element) {
                    error.addClass("text-danger");
                    error.insertAfter(element);
                }
            });
        });
    }

    function setConfigsForDeleteDepartment(config) {
        namespace = config.namespace;

        let url = config.deleteDepartmentURL.replace(
            'DEPARTMENT_MASTER_ID',
            config.departmentMasterId
        );

        if (confirm('Are you sure you want to delete this Department?')) {
            window.location.href = url;
        }
    }

    AxDepartmentMasterWebPortlet.setConfigsForValidation = setConfigsForValidation;
    AxDepartmentMasterWebPortlet.setConfigsForDeleteDepartment =
        setConfigsForDeleteDepartment;

})($, (window.AxDepartmentMasterWebPortlet =
    window.AxDepartmentMasterWebPortlet || {}));
