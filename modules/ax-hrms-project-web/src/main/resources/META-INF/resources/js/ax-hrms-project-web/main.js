(function($, AxHrmsProjectWebPortlet) {
	
	let namespace;
    let listOfAssignee;
    let startDate;
    let projectName;
    let description;
    let projectStatus;
    let employees;
    let isBillable;
    function setConfigs(config){
    	
    	
    	namespace = config.namespace;
    	listOfAssignee = config.listOfAssignee;
    	projectName = config.projectName;
    	description = config.description;
    	projectStatus = config.projectStatus;
    	employees = config.employees;
    	isBillable = config.isBillable;
    	startDate = config.startDate;
    $(document).ready(function() {
    	
    	
    	$("#addProjectForm").validate({
	         rules: {
	        	 [namespace + projectName]: {
	                 required: true
	             },
	            
	             [namespace + description]: {
	                 required: true
	             },
	             
	             [namespace + employees] : {
	                 required: true
	             },
	             [namespace + projectStatus]: {
	                 required: true
	             },
	           
	             [namespace + startDate]: {
	                 required: true,
	                 date: true
	             },
	             [namespace + isBillable]: {
	                 required: true
	                
	             },
	             
	         },
	         messages: {
	        	 [namespace + projectName]: {
	                 required: "Please enter the Project name."
	             },
	            
	             [namespace + description]: {
	                 required: "Please enter the description."
	             },
	             [namespace + employees] : {
	                 required: "Please select an assignee."
	             },
	             [namespace + projectStatus]: {
	                 required: "Please select a Project status."
	             },
	           
	             [namespace + startDate]: {
	                 required: "Please enter the Start date.",
	                 date: "Please enter a valid date."
	             },
	             [namespace + isBillable]: {
	                 required: "Please select isBillable ."
	                 
	             }
	            
	         }
	     });
    	
    	
    	
        
        
        
        let listOfAssignee2 = listOfAssignee;
 	   console.log(listOfAssignee2);

			
     const managerSelect = $('#employees');
     const selectedOptionsContainerManager = $('#selectedOptionsContainerAttendees');
     const hiddenFieldManager = $('#employeesHidden');
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
             badge.text($('#employees option[value="' + value + '"]').text());

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
			$('#employees').val(assignee);
    	selectedValuesManager = assignee;
		}
     
     renderSelectedOptions();
     // Bind change event to select box
     managerSelect.change(updateSelectedOptions);
    });
    
    }
    AxHrmsProjectWebPortlet.setConfigs = setConfigs;
})(jQuery, (window.AxHrmsProjectWebPortlet = window.AxHrmsProjectWebPortlet || {}));
