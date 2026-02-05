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
   // let policyYear;
    let role;

    function formatDateDDMMYYYY(date) {
        const dd = String(date.getDate()).padStart(2, '0');
        const mm = String(date.getMonth() + 1).padStart(2, '0');
        const yyyy = date.getFullYear();
        return dd + "-" + mm + "-" + yyyy;
    }


    function setConfigs(config){
        namespace = config.namespace;
        
        listOfAssignee = config.listOfAssignee;
        
         policyName= config.policyName;
         policyDescription= config.policyDescription;
         selectedType= config.selectedType;
         applicableDate= config.applicableDate;
         uploadDocument= config.uploadDocument;
        // policyYear= config.policyYear;
         role= config.role;
        
        
        addEditPolicyHrAdminForm = $('#'+namespace+'addEditPolicyHrAdminForm');
      //  yearSelectElement = document.getElementById('policyYear');


        // ================= NO SPECIAL CHARACTERS =================
        $.validator.addMethod("noSpecialChars", function (value, element) {
            return this.optional(element) || /^[a-zA-Z0-9\s]+$/.test(value);
        }, "Special characters are not allowed");

        // ================= FILE TYPE VALIDATION (PDF, DOC, DOCX ONLY) =================
        $.validator.addMethod("validFileType", function (value, element) {
            if (!value) return true; 
            
            const allowedExtensions = /(\.pdf|\.doc|\.docx)$/i;
            return allowedExtensions.test(value);
        }, "Please upload only PDF or DOC files");

        // ================= DATE VALIDATION (UP TO NEXT YEAR END) =================
      $.validator.addMethod(
          "validApplicableDate",
          function (value, element) {
              if (!value) return true;

              const selectedDate = new Date(value);

              const maxDate = new Date();
              maxDate.setFullYear(maxDate.getFullYear() + 1);
              maxDate.setMonth(11);
              maxDate.setDate(31);
              maxDate.setHours(0,0,0,0);

              selectedDate.setHours(0,0,0,0);

              return selectedDate <= maxDate;
          },
          function () {
              const maxDate = new Date();
              maxDate.setFullYear(maxDate.getFullYear() + 1);
              maxDate.setMonth(11);
              maxDate.setDate(31);

              return "Please enter a date on or before " + formatDateDDMMYYYY(maxDate);
          }
      );





      $("#addEditPolicyHrAdminForm").validate({

          rules: {

              // Policy Name
              [namespace + policyName]: {
                  required: true,
                  minlength: 3,
                  maxlength: 70,
                  noSpecialChars: true
              },

              // Policy Description
              [namespace + policyDescription]: {
                  required: true,
                  minlength: 5,
                  maxlength:70,
                  noSpecialChars: true
              },

              // Policy Type
              [namespace + selectedType]: {
                  required: true
              },

              // Applicable Date
              [namespace + applicableDate]: {
                  required: true,
                  validApplicableDate: true
              },

              // Upload Document
              [namespace + uploadDocument]: {
                  required: true,
                  validFileType: true
              },

              // Policy Year
//              [namespace + policyYear]: {
//                  required: true,
//                  digits: true
//              },

              // Role
              [namespace + role]: {
                  required: true
              },

              // Status (radio)
              [namespace + "status"]: {
                  required: true
              }
          },

          messages: {

              [namespace + policyName]: {
                  required: "Please enter policy name",
                  minlength: "Policy name must be at least 3 characters",
                  maxlength: "Policy name must be at less then 70 characters",
                  noSpecialChars: "Special characters are not allowed"
              },

              [namespace + policyDescription]: {
                  required: "Please enter policy description",
                  minlength: "Policy description must be at least 5 characters",
                  maxlength: "Policy description must be at less than or equal to 70 characters",
                  noSpecialChars: "Special characters are not allowed"
              },

              [namespace + selectedType]: {
                  required: "Please select policy type"
              },

              [namespace + applicableDate]: {
                  required: "Please select applicable date"

              },

              [namespace + uploadDocument]: {
                  required: "Please upload document",
                  validFileType: "Please upload only PDF or DOC files"
              },

//              [namespace + policyYear]: {
//                  required: "Please select year",
//                  digits: "Invalid year"
//              },

              [namespace + role]: {
                  required: "Please select role"
              },

              [namespace + "status"]: {
                  required: "Please select status"
              }
          },

         errorPlacement: function (error, element) {
                         error.addClass('text-danger');
                         if(element.attr("type") == "radio"){
                             error.appendTo(element.closest(".form-group"));
                         } else {
                             element.after(error);
                         }
                     }


      });

      $("#" + namespace + "addEditPolicyHrAdminForm")
          .find("input, select")
          .on("change blur keyup", function () {
              $(this).valid();
          });

      // PAST DATE WARNING
      $("#applicableDate").on("change blur", function () {
          const selectedValue = $(this).val();
          if (selectedValue) {
              const selectedDate = new Date(selectedValue);
              const today = new Date();
              
              selectedDate.setHours(0, 0, 0, 0);
              today.setHours(0, 0, 0, 0);
              
              if (selectedDate < today) {
                  $("#pastDateWarning").show();
              } else {
                  $("#pastDateWarning").hide();
              }
          } else {
              $("#pastDateWarning").hide();
          }
      });

      if ($("#applicableDate").val()) {
          $("#applicableDate").trigger("change");
      }


        addEditPolicyHrAdminForm.ready(function(){
        	console.log("Ruuning Me!!!!!!!!!!!!1");
//        	yearSelectElement = document.getElementById('policyYear');
        	
            const currentYear = new Date().getFullYear();
            let tempYear = 0;
            for(tempYear = currentYear-2;tempYear <= currentYear+2;tempYear++){
                
        	console.log(tempYear);
//            $('#policyYear').append('<option value="'+tempYear+'">'+tempYear+'</option>');;
            
            
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
              const badge = $('<div>').addClass('selected-option');

              const textSpan = $('<span>').text($('#role option[value="' + value + '"]').text());

              // Dismiss button
              const dismissBtn = $('<button>').text('x');

//              dismissBtn.click(function () {
//                  selectedValuesManager = selectedValuesManager.filter(function (val) {
//                      return val !== value;
//                  });
//                  renderSelectedOptions();
//              });

                dismissBtn.click(function () {

                    // 1️⃣ Remove from selected values array
                    selectedValuesManager = selectedValuesManager.filter(function (val) {
                        return val !== value;
                    });

                    // 2️⃣ Unselect from dropdown
                    $('#role option[value="' + value + '"]').prop('selected', false);

                    // 3️⃣ If no roles left → reset dropdown
                    if (selectedValuesManager.length === 0) {
                        $('#role').val('');
                    }

                    // 4️⃣ Re-render badges & update hidden field
                    renderSelectedOptions();

                    // 5️⃣ Trigger validation again
                    $('#role').valid();
                });


              badge.append(textSpan);
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

//    function setFileData(config){
////        debugger;
//
//        namespace = config.namespace;
//        console.log(config);
//        fileName = config.fileName;
//        filePath = config.filePath;
//
//        // Get a reference to our file input
//        const fileInput = document.querySelector("#"+namespace+"uploadDocument");
//        // Create a File object with content "Hello World!", name "myFile.txt", and type "text/plain"
//        const myFile = new File(['Hello World!'], fileName,{});
//
//        // Set custom file name and path (if needed)
//        myFile.name = fileName; // Set custom file name
//        myFile.webkitRelativePath = filePath; // Set custom file path
//
//        // Create a DataTransfer object
//        const dataTransfer = new DataTransfer();
//        // Add the custom file to the DataTransfer object
//        dataTransfer.items.add(myFile);
//
//        // Set the files property of the file input element to the files contained in the DataTransfer object
//        fileInput.files = dataTransfer.files;
//    }

function setFileData(config) {

    namespace = config.namespace;
    fileName = config.fileName;

    const fileInput = document.querySelector("#" + namespace + "uploadDocument");

    if (!fileInput || !fileName) {
        return;
    }

    const myFile = new File([''], fileName);

    const dataTransfer = new DataTransfer();
    dataTransfer.items.add(myFile);

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
