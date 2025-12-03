var open_compensatory_form_modal;
var submit_compensatory_form;
(function ($, axHrmsCompensatoryDataWebPortlet) {

    let namespace;

    function setConfigs(config) {
        namespace = config.namespace;

        $(document).ready(function () {

            $.validator.addMethod("notAfterToday", function(value, element) {
                var today = new Date();
                today.setHours(0,0,0,0); // Set to midnight for comparison
                var inputDate = new Date(value);
                inputDate.setHours(0,0,0,0); // Ensure inputDate is also set to midnight
                return this.optional(element) || inputDate <= today;
            }, "Please enter a date that is not after today.");
        
            $.validator.addMethod("positiveInteger", function (value, element) {
                return this.optional(element) || /^[1-9]\d*$/.test(value);
            }, "Please enter a valid value for Hours.");

            $.validator.addMethod("maxCharThousand", function (value, element) {
                return this.optional(element) || value.length <= 1000;
            }, "Please enter no more than 1000 characters.");

            $("#approveCompensationForm").validate({
                rules: {
                   [namespace + "approvedHours"]: {
                        required: true,
                        positiveInteger: true
                    },
                },
                messages: {
                  
                },
                errorPlacement: function (error, element) {
                    error.insertAfter(element);
                },
            });
      
            open_compensatory_form_modal = function (compId,reqHrs) {
                $('#hiddenCompensatoryDataId').val(compId);
                $('#requestedHours').val(reqHrs);
                $('#approveCompensationModal').modal('show');
            }
    
            submit_compensatory_form = function () {
                if ($('#approveCompensationForm').valid()) {
                    $('#approveCompensationModal').modal('hide');
                    console.log("VALID FORM");
                    $('#approveCompensationForm').submit();
                }
                else {
                    return false;
                }
            }
    
      
        });
    }

    axHrmsCompensatoryDataWebPortlet.setConfigs = setConfigs;
})(jQuery, (window.axHrmsCompensatoryDataWebPortlet = window.axHrmsCompensatoryDataWebPortlet || {}));
