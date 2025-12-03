(function($, AxDepartmentMasterWebPortlet) {
    let namespace;
    
    function setConfigsForValidation(config){
        namespace = config.namespace;
        
        $(document).ready(function(){
            $("#departmentForm").validate({
                rules: {
                    [namespace + "departmentName"]: {
                        required: true,
                        validLetters: true
                    }
                },
                messages: {
                    [namespace + "departmentName"]: {
                        required: "Please enter Department Name",
                        validLetters: "Department Name must start with a letter"
                    }
                },
                errorPlacement: function(error, element) {
                    error.insertAfter(element);
                }
            });
            
            $.validator.addMethod("validLetters", function(value, element) {
            	return this.optional(element) || /^[a-zA-Z]+[a-zA-Z0-9.\s]*$/.test(value);
            }, "Department Name must start with a letter");
        });
    }
    function setConfigsForDeleteDepartment(config){
    	namespace = config.namespace;
        console.log(config);
			let url = config.deleteDepartmentURL;
			url = url.replace('DEPARTMENT_MASTER_ID', config.departmentMasterId);
			if(confirm('Are you sure you want to delete ?')) 
				window.location.href = url;
    }
    AxDepartmentMasterWebPortlet.setConfigsForValidation = setConfigsForValidation;
    AxDepartmentMasterWebPortlet.setConfigsForDeleteDepartment = setConfigsForDeleteDepartment;
})($, (window.AxDepartmentMasterWebPortlet = window.AxDepartmentMasterWebPortlet || {}));
