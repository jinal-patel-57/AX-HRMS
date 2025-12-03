(function($, AxHrmsAppraisalStatusMaster) {
let namespace;

function setConfigsForValidation(config){
    namespace = config.namespace;
//  [namespace+"projectTaskStatusName"]
$(document).ready(function () {
     $("#appraisalStatusForm").validate({
           rules: {
              [namespace+"status"]: {
                   required: true,
                   maxlength: 50,
                   lettersAndSpacesOnly: true
               },
           },
           messages: {
               [namespace+"status"]: {
                   required: "Please enter Status Name",
                   maxlength: "Status exceeding maximum length!",
                   lettersAndSpacesOnly: "Use only letters and spaces for appraisal status names!"
               },
           },
           errorPlacement: function (error, element) {
               error.insertAfter(element);
           }
       });


       $.validator.addMethod("lettersAndSpacesOnly", function (value, element) {
           return this.optional(element) || /^[a-zA-Z\s]+$/.test(value);
       }, "Please enter only alphabetical characters and spaces");
});
    
}





AxHrmsAppraisalStatusMaster.setConfigsForValidation = setConfigsForValidation;

})($, (window.AxHrmsAppraisalStatusMaster = window.AxHrmsAppraisalStatusMaster || {}));
