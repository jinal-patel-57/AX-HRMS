var open_compensatory_form_modal;
var submit_compensatory_form;

(function ($, axHrmsCompensatoryDataWebPortlet) {

    let namespace;

    function setConfigs(config) {
        namespace = config.namespace;

        $(document).ready(function () {

            $.validator.addMethod("notAfterToday", function (value) {
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
                return value.length <= 1000;
            });

            $("#addCompensatoryDataForm").validate({
                rules: {
                    [namespace + "employeeNames"]: { required: true },
                    [namespace + "compensationDate"]: { required: true, notAfterToday: true },
                    [namespace + "compensationHours"]: { required: true, positiveInteger: true },
                    [namespace + "projectManager"]: { required: true },
                    [namespace + "description"]: { required: true, maxCharThousand: true }
                },
                messages: {
                    [namespace + "employeeNames"]: { required: "Please select an employee." },
                    [namespace + "compensationDate"]: { required: "Please enter date." },
                    [namespace + "compensationHours"]: { required: "Please enter hours." },
                    [namespace + "projectManager"]: { required: "Please select manager." }
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
            form.find('.error').removeClass('error');
        });
    }

    axHrmsCompensatoryDataWebPortlet.setConfigs = setConfigs;

})(jQuery, window.axHrmsCompensatoryDataWebPortlet = window.axHrmsCompensatoryDataWebPortlet || {});
