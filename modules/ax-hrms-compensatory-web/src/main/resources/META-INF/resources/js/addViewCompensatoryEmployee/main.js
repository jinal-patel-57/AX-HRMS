var open_compensatory_form_modal;
var submit_compensatory_form;

(function ($, axHrmsCompensatoryDataWebPortlet) {

    let namespace;

    function setConfigs(config) {
        namespace = config.namespace;

        $(document).ready(function () {

        function applyGenericDateRestriction(element) {
            if (!element) return;

            const today = new Date().toISOString().split('T')[0];
            element.setAttribute('min', '1900-01-01');
            element.setAttribute('max', today);

            element.addEventListener('input', function () {
                const val = this.value; // Expected format: yyyy-mm-dd
                if (val) {
                    const parts = val.split('-');
                    if (parts[0] && parts[0].length > 4) {
                        parts[0] = parts[0].substring(0, 4);
                        this.value = parts.join('-');
                    }
                }
            });
        }
            const compensationDate = document.getElementById("compensationDate");
                            if (compensationDate) {
                                applyGenericDateRestriction(compensationDate);
                            }
            $.validator.addMethod("notAfterToday", function (value) {
                if (!value) return true;

                var today = new Date();
                today.setHours(0, 0, 0, 0);

                var inputDate = new Date(value);
                inputDate.setHours(0, 0, 0, 0);

                return inputDate <= today;
            });

            $.validator.addMethod("positiveInteger", function (value) {
                return /^[1-9]\d*$/.test(value);
            });

            $.validator.addMethod("maxCharThousand", function (value) {
                return value.length <= 70;
            });

            $.validator.addMethod("notSameEmployeeAndManager", function (value) {
                var employeeId = $('#' + namespace + 'employeeNames').val();
                if (!employeeId || !value) return true;
                return employeeId !== value;
            }, "Employee and Manager cannot be the same.");

            $("#addCompensatoryDataForm").validate({

                rules: {
                    [namespace + "employeeNames"]: { required: true },
                    [namespace + "compensationDate"]: {
                        required: true,
                        notAfterToday: true
                    },
//                    [namespace + "compensationHours"]: {
//                        required: true,
//                        positiveInteger: true
//                    },
                    [namespace + "compensationType"]: {
                        required: true
                    },
                    [namespace + "projectManager"]: {
                        required: true,
                        notSameEmployeeAndManager: true
                    },
                    [namespace + "description"]: {
                        required: true,
                        maxCharThousand: true
                    }
                },

                messages: {
                    [namespace + "employeeNames"]: {
                        required: "Please select an employee."
                    },
                    [namespace + "compensationDate"]: {
                        required: "Please enter compensation date.",
                        notAfterToday: "Compensation date cannot be in the future."
                    },
//                    [namespace + "compensationHours"]: {
//                        required: "Please enter hours.",
//                        positiveInteger: "Hours must be a positive number."
//                    },
                    [namespace + "compensationType"]: {
                        required: "Please select half day or full day."
                    },
                    [namespace + "projectManager"]: {
                        required: "Please select manager.",
                        notSameEmployeeAndManager: "Employee and Manager cannot be the same."
                    },
                    [namespace + "description"]: {
                        required: "Please enter description.",
                        maxCharThousand: "Description cannot exceed 70 characters."
                    }
                },

                errorPlacement: function (error, element) {
//                    error.addClass("text-danger");
//                    error.insertAfter(element);

//                  if (element.attr("name") === namespace + "compensationType") {
//                        error.appendTo("#compensationType-error");   // ✅ place inside custom label
//                    } else {
//                        error.insertAfter(element);
//                    }
   if (element.attr("name") === namespace + "compensationType") {
        $("#compensationTypeError").html(error);
    } else {
        error.insertAfter(element);
    }

                },

                highlight: function (element) {
//                    $(element).addClass("is-invalid");

    if ($(element).attr("name") === namespace + "compensationType") {
        $("#compensationTypeGroup").addClass("is-invalid-group");
    } else {
        $(element).addClass("is-invalid");
    }
                },

                unhighlight: function (element) {
//                    $(element).removeClass("is-invalid");
    if ($(element).attr("name") === namespace + "compensationType") {
        $("#compensationTypeGroup").removeClass("is-invalid-group");
    } else {
        $(element).removeClass("is-invalid");
    }

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
        });



        open_compensatory_form_modal = function () {
            $('#addCompensatoryDataModal').modal('show');
        };

        submit_compensatory_form = function () {
            if ($('#addCompensatoryDataForm').valid()) {
                $('#addCompensatoryDataForm').submit();
            }
        };

        $('#addCompensatoryDataModal').on('hidden.bs.modal', function () {
            var form = $('#addCompensatoryDataForm');
            form[0].reset();
            form.validate().resetForm();
            form.find('.is-invalid').removeClass('is-invalid');
        });
    }

    axHrmsCompensatoryDataWebPortlet.setConfigs = setConfigs;

})(jQuery, window.axHrmsCompensatoryDataWebPortlet = window.axHrmsCompensatoryDataWebPortlet || {});
