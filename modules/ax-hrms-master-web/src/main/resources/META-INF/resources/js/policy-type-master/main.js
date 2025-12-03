(function($, AxPolicyTypeMasterWebPortlet) {
    let namespace;
    
    function setConfigsForValidation(config){
        namespace = config.namespace;
        $(document).ready(function(){
        	
        	$("#addEditPolicyTypeMaster").validate({
        		rules:{

        			[namespace+"policyType"]:{

        				required:true,
        				validLetters:true
        			}
        		},
        		messages:{

        			[namespace+"policyType"]:{

        				required:"Enter policy Type name",
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
    function setConfigsForDeletePolicyTypeMaster(config){
        namespace = config.namespace;
        console.log(config);
            let url = config.deleteUrl;
            url = url.replace('POLICYTYPE_MASTER_ID', config.policyTypeMasterId);
            let text = "Are you sure you want to delete this policy type?";
            if (confirm(text) == true) {
                window.location.href = url;
            } else {
                text = "You canceled!";
            }
    }
    
    AxPolicyTypeMasterWebPortlet.setConfigsForValidation = setConfigsForValidation;
    AxPolicyTypeMasterWebPortlet.setConfigsForDeletePolicyTypeMaster = setConfigsForDeletePolicyTypeMaster;
})($, (window.AxPolicyTypeMasterWebPortlet = window.AxPolicyTypeMasterWebPortlet || {}));
