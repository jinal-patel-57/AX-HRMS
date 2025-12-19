(function ($, window) {

    window.AxHrmsHolidayHrAdminWebPortlet =
        window.AxHrmsHolidayHrAdminWebPortlet || {};

    // ================= PREVENT DUPLICATE REGISTRATION =================
    if (!$.validator || $.validator.methods.validHolidayName) {
        return;
    }

    /* ================= Custom Validators ================= */

    $.validator.addMethod("validHolidayName", function (value, element) {
        value = value.trim();
        return this.optional(element) ||
            /^[A-Za-z]+([A-Za-z\s&-]*[A-Za-z])?$/.test(value);
    }, "Invalid holiday name");

    $.validator.addMethod("validHolidayDesc", function (value, element) {
        value = value.trim();
        return this.optional(element) ||
            /^[A-Za-z0-9\s.,()-]+$/.test(value);
    }, "Invalid description");

    $.validator.addMethod("validHolidayDate", function (value, element) {
        if (!value) return true;
        let year = new Date(value).getFullYear();
        let current = new Date().getFullYear();
        return year >= current - 2 && year <= current + 1;
    }, "Invalid holiday date");

    /* ================= Validation Init ================= */

    window.AxHrmsHolidayHrAdminWebPortlet.setConfigsForValidation = function (config) {

        const namespace = config.namespace;
        const form = $("#addEditHolidayHrAdmin");

        if (!form.length || form.data("validator")) {
            return;
        }

        form.validate({
            ignore: [],

            rules: {
                [namespace + "holidayName"]: {
                    required: true,
                    minlength: 2,
                    maxlength: 70,
                    validHolidayName: true
                },
                [namespace + "holidayDesc"]: {
                    required: true,
                    minlength: 5,
                    maxlength: 250,
                    validHolidayDesc: true
                },
                [namespace + "holidayDate"]: {
                    required: true,
                    validHolidayDate: true
                },
                [namespace + "isFloater"]: {
                    required: true
                }
            },

            errorPlacement: function (error, element) {
                error.addClass("text-danger");
                if (element.attr("type") === "radio") {
                    error.insertAfter(element.closest(".form-group"));
                } else {
                    error.insertAfter(element);
                }
            },

            submitHandler: function (form) {
                form.submit();
            }
        });
    };

})(jQuery, window);
