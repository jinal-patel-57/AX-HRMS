(function($, AXHrmsHrAppraisalFormTemplatesWebPortlet) {
    let namespace;
    let appraisalFormTemplateForm;
    let yearSelectElement;
    let fileName;
    let filePath;
    let configuration;

    function setConfigs(config){
        namespace = config.namespace;
        configuration = config;
        debugger;
        appraisalFormTemplateForm = $('#'+namespace+'appraisalFormTemplateForm');
        yearSelectElement = $('#'+namespace+'yearOfTemplate');

        appraisalFormTemplateForm.validate({
            rules: {
                [namespace+"templateName"]:{
                    required: true
                },
                [namespace + "level"]: {
                    required: true
                },
                [namespace + "formTemplateFile"]: {
                    required: true
                },
                [namespace + "yearOfTemplate"]: {
                    required: true
                }
            },
            messages: {
                [namespace+"templateName"]:{
                    required: "Please enter template name..."
                },
                [namespace + "level"]: {
                    required: "Please select template level"
                },
                [namespace + "formTemplateFile"]: {
                    required: "Please select form template file"
                },
                [namespace + "yearOfTemplate"]: {
                    required: "Please select year"
                }
            },
            errorPlacement: function (error, element) {
                error.insertAfter(element);
            }
        });

        appraisalFormTemplateForm.ready(function(){
            debugger;
            const currentYear = new Date().getFullYear();
            let tempYear = 0;

            for(tempYear = currentYear-2;tempYear <= currentYear+2;tempYear++){
                const yearOptionElement = $('<option>').attr('value',tempYear);
                if(config.year != "" && tempYear == Number(config.year))
                    yearOptionElement.prop('selected',true);
                yearOptionElement.append(String(tempYear));
                yearSelectElement.append(yearOptionElement);
            }
        });

    }
    function setConfigsForDeleteAppraisalFormTemplate(config){
        namespace = config.namespace;
        console.log(config);
        let url = config.deleteUrl;
        url = url.replace('APPRAISAL_FORM_TEMPLATE_ID', config.appraisalFormTemplateId);
        if(confirm('Are you sure you want to delete ?'))
            window.location.href = url;
    }

    function setFileData(config){
        debugger;

        namespace = config.namespace;
        console.log(config);
        fileName = config.fileName;
        filePath = config.filePath;
        debugger;

        // Get a reference to our file input
        const fileInput = document.querySelector("#"+namespace+"formTemplateFile");
        // Create a File object with content "Hello World!", name "myFile.txt", and type "text/plain"
        const myFile = new File([''], fileName,{});

        // Set custom file name and path (if needed)
        myFile.name = fileName; // Set custom file name
        myFile.webkitRelativePath = filePath; // Set custom file path

        // Create a DataTransfer object
        const dataTransfer = new DataTransfer();
        // Add the custom file to the DataTransfer object
        dataTransfer.items.add(myFile);

        // Set the files property of the file input element to the files contained in the DataTransfer object
        fileInput.files = dataTransfer.files;
    }

    AXHrmsHrAppraisalFormTemplatesWebPortlet.setConfigs = setConfigs;
    AXHrmsHrAppraisalFormTemplatesWebPortlet.setConfigsForDeleteAppraisalFormTemplate = setConfigsForDeleteAppraisalFormTemplate;
    AXHrmsHrAppraisalFormTemplatesWebPortlet.setFileData = setFileData;
})(jQuery, (window.AXHrmsHrAppraisalFormTemplatesWebPortlet = window.AXHrmsHrAppraisalFormTemplatesWebPortlet || {}));
