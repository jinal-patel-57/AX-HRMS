$(document).ready(function () {
    $("table").addClass("table table-bordered");
});

(function ($, AxLeaveTypeMasterWebPortlet) {
    let namespace;

    function setConfigsForValidation(config) {
        namespace = config.namespace;

        if (!$.validator || !$("#leaveTypeMasterForm").length) {
            return;
        }

        $.validator.addMethod("validLeaveType", function (value, element) {
            return this.optional(element) || /^[a-zA-Z][a-zA-Z\s]*$/.test(value);
        });

        $.validator.addMethod("validDescription", function (value, element) {
            return this.optional(element) || /^[a-zA-Z0-9\s.,()-]*$/.test(value);
        });

        const leaveTypeField = $("#" + namespace + "leaveTypeName");
        const descriptionField = $("#" + namespace + "description");

        leaveTypeField.attr("maxlength", 75);
        leaveTypeField.attr("minlength", 2);
        descriptionField.attr("maxlength", 250);
        descriptionField.attr("minlength", 5);

        $("#leaveTypeMasterForm").validate({
            ignore: [],
            rules: {
                [namespace + "leaveTypeName"]: {
                    required: true,
                    validLeaveType: true,
                    maxlength: 70,
                    minlength:2
                },
                [namespace + "description"]: {
                    validDescription: true,
                    maxlength: 70,
                    minlength:2
                }
            },
            messages: {
                [namespace + "leaveTypeName"]: {
                    required: "Enter leave type",
                    validLeaveType: "Enter a valid leave type",
                    minlength: "Enter at least 2 characters",
                    maxlength: "Enter maximum 75 characters"
                },
                [namespace + "description"]: {
                    validDescription: "Enter a valid description",
                    minlength: "Enter at least 2 characters",
                    maxlength: "Enter maximum 250 characters"
                }
            },
            errorPlacement: function (error, element) {
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

    function setConfigsForDeleteLeaveType(config) {
        namespace = config.namespace;
        let url = config.deleteUrl;
        url = url.replace('LEAVE_TYPE_MASTER_ID', config.leaveTypeMasterId);
        if (confirm('Are you sure you want to delete ?'))
            window.location.href = url;
    }

    AxLeaveTypeMasterWebPortlet.setConfigsForValidation = setConfigsForValidation;
    AxLeaveTypeMasterWebPortlet.setConfigsForDeleteLeaveType = setConfigsForDeleteLeaveType;

})($, (window.AxLeaveTypeMasterWebPortlet = window.AxLeaveTypeMasterWebPortlet || {}));
