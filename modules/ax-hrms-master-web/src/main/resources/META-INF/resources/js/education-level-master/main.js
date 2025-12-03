(function($, AxEducationLevelMasterWebPortlet) {
    let namespace;
    
    function setConfigsForValidation(config){
        namespace = config.namespace;
        $(document).ready(function(){
        	$("#addEditEducationLevelMaster").validate({
        		rules:{
        			[namespace+"levelName"]:{
        				required:true,
        				validLetters:true
        			}
        		},
        		messages:{
        			[namespace+"levelName"]:{
        				required:"Enter Education Level name",
        				validLetters:"Enter letters only"
        			}
        		},
        		errorPlacement:function(error,element){
        			error.insertAfter(element);
        		}
        	});
        	$.validator.addMethod("validLetters", function(value, element) {
                var firstCharValid = /^[a-zA-Z\s]/.test(value.charAt(0));

                var restValid = /^[a-zA-Z0-9\s\W]+$/.test(value.substring(1));

                return this.optional(element) || (firstCharValid && restValid);
                
            }, "Please enter letters only");
        });
        
    }
    function setConfigsForDeleteEducationLevelMaster(config){
        namespace = config.namespace;
        console.log(config);
			let url = config.deleteUrl;
			url = url.replace('EDUCATIONLEVEL_MASTER_ID', config.educationLevelMasterId);
            let text = "Are you sure you want to delete this education level?";
            if (confirm(text) == true) {
                window.location.href = url;
            } else {
                text = "You canceled!";
            }
    }
    
    AxEducationLevelMasterWebPortlet.setConfigsForValidation = setConfigsForValidation;
    AxEducationLevelMasterWebPortlet.setConfigsForDeleteEducationLevelMaster = setConfigsForDeleteEducationLevelMaster;
})($, (window.AxEducationLevelMasterWebPortlet = window.AxEducationLevelMasterWebPortlet || {}));
