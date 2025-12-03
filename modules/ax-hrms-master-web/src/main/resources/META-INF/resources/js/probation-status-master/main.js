(function($, AxProbationStatusMasterWebPortlet) {
    let namespace;
    
    function setConfigsForValidation(config){
        namespace = config.namespace;
        $(document).ready(function(){
        	$("#addEditProbationStatusMaster").validate({
        		rules:{
        			[namespace+"probationStatus"]:{
        				required:true,
        				validLetters:true
        			}
        		},
        		messages:{
        			[namespace+"probationStatus"]:{
        				required:"Enter Probation Status name",
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
    function setConfigsForDeleteProbationStatusMaster(config){
        namespace = config.namespace;
        console.log(config);
			let url = config.deleteUrl;
			url = url.replace('PROBATIONSTATUS_MASTER_ID', config.probationStatusMasterId);
            let text = "Are you sure you want to delete this PROBATION STATUS?";
            if (confirm(text) == true) {
                window.location.href = url;
            } else {
                text = "You canceled!";
            }
    }
    
    AxProbationStatusMasterWebPortlet.setConfigsForValidation = setConfigsForValidation;
    AxProbationStatusMasterWebPortlet.setConfigsForDeleteProbationStatusMaster = setConfigsForDeleteProbationStatusMaster;
})($, (window.AxProbationStatusMasterWebPortlet = window.AxProbationStatusMasterWebPortlet || {}));
