(function($, AxHrmsPolicyProcessManagementHrAdminWebPortlet) {
    let namespace;
    let addEditPolicyHrAdminForm;
    let yearSelectElement;
    let fileName;
    let policyName;
    let policyDescription;
    let selectedType;
    let applicableDate;
    let uploadDocument;
    let policyYear;
    let role;

    function setConfigs(config){
        namespace = config.namespace;
        
        listOfAssignee = config.listOfAssignee;
        
         policyName= config.policyName;
         policyDescription= config.policyDescription;
         selectedType= config.selectedType;
         applicableDate= config.applicableDate;
         uploadDocument= config.uploadDocument;
         policyYear= config.policyYear;
         role= config.role;
        
        
        addEditPolicyHrAdminForm = $('#'+namespace+'addEditPolicyHrAdminForm');
        yearSelectElement = document.getElementById('policyYear');

        $("#addEditPolicyHrAdminForm").validate({
            rules: {
                [namespace + policyName]:{
                    required: true
//                    validLetters:true
                },

                [namespace + policyDescription]:{
                    required:true,
//                    validLetters:true
                },
                [namespace + selectedType]:{
                    required:true,
                },

                [namespace + applicableDate]:{
                    required:true,
//                    validDate:true
                },
                [namespace + uploadDocument]: {
                    required: true
                },
                [namespace + policyYear]: {
                    required: true
                },
                [namespace + role]: {
                	required: true
                }
            },
            messages: {
                [namespace + policyName]:{
                    required: "Please enter policy name..."
                },

                [namespace + policyDescription]:{
                    required: "Please enter policy Description name..."
                },

                [namespace + applicableDate]:{
                    required: "Please enter Applicable Date name..."
                },
                [namespace + selectedType]: {
                    required: "Please select Policy Type"
                },
                [namespace + uploadDocument]: {
                    required: "Please upload document"
                },
                [namespace + policyYear]: {
                    required: "Please select year"
                },
                [namespace + role]: {
                	required: "Please select role"
                }
            },
            errorPlacement: function (error, element) {
                error.insertAfter(element);
            }
        });


        addEditPolicyHrAdminForm.ready(function(){
        	console.log("Ruuning Me!!!!!!!!!!!!1");
        	yearSelectElement = document.getElementById('policyYear');
        	
            const currentYear = new Date().getFullYear();
            let tempYear = 0;
            for(tempYear = currentYear-2;tempYear <= currentYear+2;tempYear++){
                
        	console.log(tempYear);
            $('#policyYear').append('<option value="'+tempYear+'">'+tempYear+'</option>');;
            
            
            }
        });
        
        
        let listOfAssignee2 = listOfAssignee;
  	   console.log(listOfAssignee2);
  	   console.log("H_________________")
 			
      const managerSelect = $('#role');
      const selectedOptionsContainerManager = $('#selectedOptionsContainer');
      const hiddenFieldManager = $('#roleHidden');
      let selectedValuesManager = [];

      // Function to update selected options
      function updateSelectedOptions() {
          const selectedOption = $(this).val();
          if (selectedOption && !selectedValuesManager.includes(selectedOption)) { // Check for duplicates
          	selectedValuesManager.push(selectedOption);
              renderSelectedOptions();
          }
      }

      // Function to render selected options as dismissible badges
      function renderSelectedOptions() {
          selectedOptionsContainerManager.empty(); // Clear previous options
          hiddenFieldManager.val(selectedValuesManager.join(',')); // Update hidden field value

          // Create dismissible badges for each selected option
          selectedValuesManager.forEach(function (value) {
              const badge = $('<span>').addClass('selected-option btn btn-sm btn-outline-secondary mr-2 mt-1');
              badge.text($('#role option[value="' + value + '"]').text());

              // Dismiss button
              const dismissBtn = $('<span>').addClass('badge badge-secondary ml-2').text('X');

              dismissBtn.click(function () {
                  selectedValuesManager = selectedValuesManager.filter(function (val) {
                      return val !== value;
                  });
                  renderSelectedOptions();
              });

              badge.append(dismissBtn);
              selectedOptionsContainerManager.append(badge);
          });
      }
     	let assignee = (listOfAssignee2.split(","));
 		if(assignee!=''){
 			$('#role').val(assignee);
     	selectedValuesManager = assignee;
 		}
      
      renderSelectedOptions();
      // Bind change event to select box
      managerSelect.change(updateSelectedOptions);

    }

    function setFileData(config){
//        debugger;

        namespace = config.namespace;
        console.log(config);
        fileName = config.fileName;
        filePath = config.filePath;

        // Get a reference to our file input
        const fileInput = document.querySelector("#"+namespace+"uploadDocument");
        // Create a File object with content "Hello World!", name "myFile.txt", and type "text/plain"
        const myFile = new File(['Hello World!'], fileName,{});

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

    function setConfigsForDeletePolicy(config){
        namespace = config.namespace;
        console.log(config);
            let url = config.deleteUrl;
            url = url.replace('POLICY_ID', config.policyId);
            url = url.replace('SELECTED_YEAR', config.selectedYear);
            let text = "Are you sure you want to delete this Policy?";
            if (confirm(text) == true) {
                window.location.href = url;
            } else {
                text = "You canceled!";
            }
    }
    
    
    function setConfigsForRenderPolicyWithYear(config){
        namespace = config.namespace;
        console.log(config);
        
            var url = config.renderUrl;
            console.log(url);
            url = url.replace('SELECTED_YEAR', config.selectedYear);
            console.log(url);

			window.location.href = url;
            
    }

AxHrmsPolicyProcessManagementHrAdminWebPortlet.setConfigsForRenderPolicyWithYear = setConfigsForRenderPolicyWithYear;

    AxHrmsPolicyProcessManagementHrAdminWebPortlet.setConfigsForDeletePolicy = setConfigsForDeletePolicy;
    
    AxHrmsPolicyProcessManagementHrAdminWebPortlet.setConfigs = setConfigs;
   
    AxHrmsPolicyProcessManagementHrAdminWebPortlet.setFileData = setFileData;
})($, (window.AxHrmsPolicyProcessManagementHrAdminWebPortlet = window.AxHrmsPolicyProcessManagementHrAdminWebPortlet || {}));
