(function($, documentTypeMasterWebPortlet) {
    let namespace;
    let documentTypeName;
    
    function setConfigs(config){
        namespace = config.namespace;
        documentTypeName = config.documentTypeName;

        $(document).ready(function(){
            console.log('namespace + documentTypeName', namespace + documentTypeName);
            $("#documentTypeForm").validate({
                rules:{
                    [namespace + documentTypeName]: {
                        required:true,
                        lettersAndDigitsOnly:true 
                    }
                },
                messages:{
                    [namespace + documentTypeName]: {
                        required:"Enter Document Type Name",
                        lettersAndDigitsOnly:"The first character must be a letter, and only letters and digits are allowed"
                    }
                },
                errorPlacement:function(error,element){
                    error.insertAfter(element);
                }
            });

            $.validator.addMethod("lettersAndDigitsOnly", function(value, element) {
                // Check if the first character is a letter
                if (!/^[a-zA-Z]/.test(value.charAt(0))) {
                    return false; // Return false if the first character is not a letter
                }

                // Check if the value contains only letters and digits
                return /^[a-zA-Z0-9\s]+$/.test(value);
            }, function(value, element) {
                if (/^[0-9]/.test(value)) {
                    return "The first character must be a letter";
                } else {
                    return "Don't use special characters.";
                }
            });

        });
    }

    function setConfigsForDeleteDocumentType(config){
        namespace = config.namespace;
        console.log(config);
        let url = config.deleteUrl;
        url = url.replace('DOCUMENT_TYPE_MASTER_ID', config.documentTypeMasterId);
        if(confirm('Are you sure you want to delete ?')) 
            window.location.href = url;
    }
    
    documentTypeMasterWebPortlet.setConfigs = setConfigs;
    documentTypeMasterWebPortlet.setConfigsForDeleteDocumentType = setConfigsForDeleteDocumentType;
})(jQuery, (window.documentTypeMasterWebPortlet = window.documentTypeMasterWebPortlet || {}));
