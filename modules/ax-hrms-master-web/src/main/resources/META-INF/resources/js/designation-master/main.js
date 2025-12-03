(function($, AxDesignationMasterWebPortlet) {
    let namespace;
    
    function setConfigsForValidation(config){
        namespace = config.namespace;
        $(document).ready(function(){
        	
        	$("#designationMasterForm").validate({
        		rules:{
        			[namespace+"designationName"]:{
        				required:true,
        				validLetters:true
        			}
        		},
        		messages:{
        			[namespace+"designationName"]:{
        				required:"Enter designation name",
        				validLetters:"Enter letters only"
        			}
        		},
        		errorPlacement:function(error,element){
        			error.insertAfter(element);
        		}
        	});
        	$.validator.addMethod("validLetters", function(value, element) {
                return this.optional(element) || /^[a-zA-Z0-9.\s]+$/.test(value);
            }, "Please enter letters only");
        });
        
    }
    function setConfigsForDeleteDesignation(config){
        namespace = config.namespace;
        console.log(config);
			let url = config.deleteUrl;
			url = url.replace('DESIGNATION_MASTER_ID', config.designationMasterId);
			if(confirm('Are you sure you want to delete ?')) 
				window.location.href = url;
    }
    
    AxDesignationMasterWebPortlet.setConfigsForValidation = setConfigsForValidation;
    AxDesignationMasterWebPortlet.setConfigsForDeleteDesignation = setConfigsForDeleteDesignation;
})($, (window.AxDesignationMasterWebPortlet = window.AxDesignationMasterWebPortlet || {}));
