(function($, AxHrmsTemplateLevelMasterWebPortlet) {
let namespace;

function setConfigsForValidation(config){
    namespace = config.namespace;

$(document).ready(function () {
    $("#templateLevelMasterForm").validate({
        rules: {
            [namespace+"levelName"]: {
                required: true,
                maxlength: 50,
                lettersAndSpacesOnly: true
            }
        },
        messages: {
            [namespace+"levelName"]: {
                required: "Please enter Status Name",
                maxlength: "Status exceeding maximum lenght!",
                lettersAndSpacesOnly: "Use only letters and spaces for template level names!"
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





AxHrmsTemplateLevelMasterWebPortlet.setConfigsForValidation = setConfigsForValidation;

})($, (window.AxHrmsTemplateLevelMasterWebPortlet = window.AxHrmsTemplateLevelMasterWebPortlet || {}));
