(function($, AxLeaveCompensatoryStatusMasterWebPortlet) {
    let namespace;
    
    function setConfigsForValidation(config){
        namespace = config.namespace;
        $(document).ready(function(){
        	$("#addEditLeaveCompensatoryStatusMaster").validate({
        		rules:{
        			[namespace+"leaveCompensatoryStatus"]:{
        				required:true,
        				validLetters:true
        			}
        		},
        		messages:{
        			[namespace+"leaveCompensatoryStatus"]:{
        				required:"Enter Leave Compensatory Status name",
        				validLetters:"Enter letters only"
        			}
        		},
        		errorPlacement:function(error,element){
        			error.insertAfter(element);
        		}
        	});
        	$.validator.addMethod("validLetters", function(value, element) {
                var firstCharValid = /^[a-zA-Z\s]/.test(value.charAt(0));
                
                return this.optional(element) || (firstCharValid);
                
            }, "Please enter letters only");
        });
        
    }
    function setConfigsForDeleteLeaveCompensatoryStatusMaster(config){
        namespace = config.namespace;
        console.log(config);
			let url = config.deleteUrl;
			url = url.replace('LEAVECOMPENSATORYSTATUS_MASTER_ID', config.leaveCompensatoryStatusMasterId);
            let text = "Are you sure you want to delete this LEAVE COMPENSATORY STATUS?";
            if (confirm(text) == true) {
                window.location.href = url;
            } else {
                text = "You canceled!";
            }
    }
    
    AxLeaveCompensatoryStatusMasterWebPortlet.setConfigsForValidation = setConfigsForValidation;
    AxLeaveCompensatoryStatusMasterWebPortlet.setConfigsForDeleteLeaveCompensatoryStatusMaster = setConfigsForDeleteLeaveCompensatoryStatusMaster;
})($, (window.AxLeaveCompensatoryStatusMasterWebPortlet = window.AxLeaveCompensatoryStatusMasterWebPortlet || {}));
