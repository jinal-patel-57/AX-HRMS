(function($, AxWishTypeMasterWebPortlet) {
    let namespace;
    
    function setConfigsForValidation(config){
        namespace = config.namespace;
        $(document).ready(function(){
        	
        	$("#addEditWishTypeMaster").validate({
        		rules:{

        			[namespace+"wishType"]:{

        				required:true,
        				validLetters:true
        			}
        		},
        		messages:{

        			[namespace+"wishType"]:{

        				required:"Enter wish Type name",
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
    function setConfigsForDeleteWishTypeMaster(config){
        namespace = config.namespace;
        console.log(config);
            let url = config.deleteUrl;
            url = url.replace('WISHTYPE_MASTER_ID', config.wishTypeMasterId);
            let text = "Are you sure you want to delete this wish type?";
            if (confirm(text) == true) {
                window.location.href = url;
            } else {
                text = "You canceled!";
            }
    }
    
    AxWishTypeMasterWebPortlet.setConfigsForValidation = setConfigsForValidation;
    AxWishTypeMasterWebPortlet.setConfigsForDeleteWishTypeMaster = setConfigsForDeleteWishTypeMaster;
})($, (window.AxWishTypeMasterWebPortlet = window.AxWishTypeMasterWebPortlet || {}));
