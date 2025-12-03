(function($, AxHrmsProjectTaskStatusMasterWebPortlet) {
let namespace;

function setConfigsForValidation(config){
    namespace = config.namespace;

$(document).ready(function () {
    $("#projectTaskStatusForm").validate({
        rules: {
            [namespace+"projectTaskStatusName"]: {
                required: true,
                maxlength: 50,
                lettersAndSpacesOnly: true
            }
        },
        messages: {
            [namespace+"projectTaskStatusName"]: {
                required: "Please enter Status Name",
                maxlength: "Status exceeding maximum lenght!",
                lettersAndSpacesOnly: "Use only letters ans spaces for status names!"
            }
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





AxHrmsProjectTaskStatusMasterWebPortlet.setConfigsForValidation = setConfigsForValidation;

})($, (window.AxHrmsProjectTaskStatusMasterWebPortlet = window.AxHrmsProjectTaskStatusMasterWebPortlet || {}));
