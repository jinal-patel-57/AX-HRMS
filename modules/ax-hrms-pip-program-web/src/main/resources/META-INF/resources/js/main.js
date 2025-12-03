var check_pip_form;
var check_pip_demotion_form;
(function ($, AxPipProgramWebPortlet) {

    let namespace;
    let code;

    function setConfigs(config) {
        namespace = config.namespace;
        code = config.code;
        check_pip_form = function () {
            if ($('#pipForm').valid()) {
                $("#comments").val($('#sNote').summernote('code'));
                $('#pipForm').submit();
            } else {
                return false;
            }
        }

        check_pip_demotion_form = function () {
            if ($('#demotionForm').valid()) {
                $('#demotionForm').submit();
            }
            else {
                return false;
            }
        }

        $(document).ready(function () {
            // Load Summernote for comments
            $('#sNote').summernote({
                height: 150,
                codemirror: {
                    theme: 'monokai'
                },

            });


            $('#sNote').summernote('code', code);

            $("#demotionForm").validate({
                rules: {
                    [namespace + "designationSelect"]: {
                        required: true
                    },
                },
                messages: {
                    [namespace + "designationSelect"]: {
                        required: "Please select Updated Designation."
                    },
                },
                errorPlacement: function (error, element) {
                    error.insertAfter(element);
                }
            });

            $("#pipForm").validate({
                rules: {
                    [namespace + "employee"]: {
                        required: true
                    },
                    [namespace + "startDate"]: {
                        required: true,
                        date: true,
                    },
                    [namespace + "noOfMonths"]: {
                        required: true,
                    },
                    [namespace + "meetingDate"]: {
                        required: true,
                        date: true
                    }
                },
                messages: {
                    [namespace + "employee"]: {
                        required: "Please select an employee."
                    },
                    [namespace + "startDate"]: {
                        required: "Please enter a start date.",
                        date: "Please enter a valid date.",
                    },
                    [namespace + "noOfMonths"]: {
                        required: "Please select the number of months.",
                    },
                    [namespace + "meetingDate"]: {
                        required: "Please enter a me    eting date.",
                        date: "Please enter a valid date."
                    }
                },
                errorPlacement: function (error, element) {
                    error.insertAfter(element);
                }
            });
        });
    }

    AxPipProgramWebPortlet.setConfigs = setConfigs;
})(jQuery, (window.AxPipProgramWebPortlet = window.AxPipProgramWebPortlet || {}));
