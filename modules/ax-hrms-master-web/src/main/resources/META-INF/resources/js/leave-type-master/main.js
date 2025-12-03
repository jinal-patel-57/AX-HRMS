$(document).ready(function(){
	$("table").addClass("table table-bordered")
});

(function($, AxLeaveTypeMasterWebPortlet) {
    let namespace;
    
    function setConfigsForValidation(config){
        namespace = config.namespace;
        $(document).ready(function(){
        	
        	$("#leaveTypeMasterForm").validate({
        		rules:{
        			[namespace+"leaveTypeName"]:{
        				required:true,
        				validLetters:true,
						maxlength: 75
        			},
					[namespace+"description"]:{
						maxlength: 250
					}
        		},
        		messages:{
        			[namespace+"leaveTypeName"]:{
        				required:"Enter leave type",
        				validLetters:"Enter letters only",
						maxlength: "Enter maximum 75 characters"
        			},
					[namespace+"description"]:{
						validLetters:"Enter letters only",
						maxlength: "Enter maximum 250 characters"
					}
        		},
        		errorPlacement:function(error,element){
        			error.insertAfter(element);
        		}
        	});
        	$.validator.addMethod("validLetters", function(value, element) {
                return this.optional(element) || /^[a-zA-Z\s]+$/.test(value);
            }, "Please enter letters only");
        });
        
    }
    function setConfigsForDeleteLeaveType(config){
        namespace = config.namespace;
        console.log(config);
			let url = config.deleteUrl;
			url = url.replace('LEAVE_TYPE_MASTER_ID', config.leaveTypeMasterId);
			if(confirm('Are you sure you want to delete ?')) 
				window.location.href = url;
    }

	AxLeaveTypeMasterWebPortlet.setConfigsForValidation = setConfigsForValidation;
	AxLeaveTypeMasterWebPortlet.setConfigsForDeleteLeaveType = setConfigsForDeleteLeaveType;
})($, (window.AxLeaveTypeMasterWebPortlet = window.AxLeaveTypeMasterWebPortlet || {}));
