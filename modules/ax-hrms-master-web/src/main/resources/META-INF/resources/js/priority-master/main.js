$(document).ready(function(){
	$("table").addClass("table table-bordered")
});

(function($, AxPriorityMasterWebPortlet) {
    let namespace;
    
    function setConfigsForValidation(config){
        namespace = config.namespace;
        $(document).ready(function(){
        	
        	$("#priorityMasterForm").validate({
        		rules:{
        			[namespace+"priorityName"]:{
        				required:true,
        				validLetters:true,
						maxlength: 75
        			}
        		},
        		messages:{
        			[namespace+"priorityName"]:{
        				required:"Enter priority",
        				validLetters:"Enter letters only",
						maxlength: "Enter maximum 75 characters"
        			}
        		},
        		errorPlacement:function(error,element){
        			error.insertAfter(element);
        		}
        	});
        	$.validator.addMethod("validLetters", function(value, element) {
                return this.optional(element) || /^[a-zA-Z0-9\s]+$/.test(value);
            }, "Please enter letters only");
        });
        
    }
    function setConfigsForDeletePriority(config){
        namespace = config.namespace;
        console.log(config);
			let url = config.deleteUrl;
			url = url.replace('PRIORITY_MASTER_ID', config.priorityMasterId);
			if(confirm('Are you sure you want to delete ?')) 
				window.location.href = url;
    }

	AxPriorityMasterWebPortlet.setConfigsForValidation = setConfigsForValidation;
	AxPriorityMasterWebPortlet.setConfigsForDeletePriority = setConfigsForDeletePriority;
})($, (window.AxPriorityMasterWebPortlet = window.AxPriorityMasterWebPortlet || {}));
