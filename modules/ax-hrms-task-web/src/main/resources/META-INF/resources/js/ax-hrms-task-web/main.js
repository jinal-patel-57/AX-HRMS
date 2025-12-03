(function($, AxHrmsTaskWebPortlet) {
	
	let namespace;
	let addTaskURL;
	let homeURL;
	let taskName;
	let mainTask;
	let project;
	let description;
	let assignedTo;
	let projectTaskStatusMaster;
	let priority;
	let assignDate;
	let startDate;
	let completeDate;
	let dueDate;
	let review;
	let isManager;
	let estimatedHours;
	let startTime;
	let endTime;
	let duration;
	let status;
	let attachments;
	
    function setConfigs(config){
    	
    	
    	namespace = config.namespace;
    	addTaskURL = config.addTaskURL;
    	homeURL = config.homeURL;
    	 taskName  = config.taskName; 
    	 mainTask  = config.mainTask;
    	 project  = config.project;
    	 description = config.description;
    	 assignedTo = config.assignedTo;
    	 projectTaskStatusMaster = config.projectTaskStatusMaster;
    	 priority = config.priority;
    	 assignDate = config.assignDate;
    	 startDate = config.startDate;
    	 completeDate = config.completeDate;
    	 dueDate = config.dueDate;
    	 isManager = config.isManager;
    	 estimatedHours = config.estimatedHours;
    	
    	
    	
    	
    	
    	
    	
    	
    	
    $(document).ready(function() {
    	console.log("Enter in the main .js");
    	  var isSubTaskCheckbox = $("#isSubTask");
    	     var mainTaskSelect = $("#mainTask");
    	     var mainTaskContainer = $("#mainTaskContainer");
    	     

    	     // Function to toggle the disabled state of the main task select
    	     function toggleMainTask() {
    	         if (isSubTaskCheckbox.is(":checked")) {
    	             mainTaskSelect.prop("disabled", false);
    	             mainTaskSelect.prop("required", true); // Add required attribute for validation
    	             mainTaskContainer.addClass('required');
    	         } else {
    	             mainTaskSelect.prop("disabled", true);
    	             mainTaskSelect.prop("required", false); // Remove required attribute for validation
    	             mainTaskContainer.removeClass('required');
    	             mainTaskSelect.val(""); // Reset the select value
    	         }
    	     }

    	     // Initial check on page load
    	     toggleMainTask();

    	     // Add event listener to the checkbox
    	     isSubTaskCheckbox.change(toggleMainTask);
    	     
    	     console.log("manager : ",isManager);
    	     
    	    	 if(!isManager){
    	    		 console.log("is Manager ... : if")
    	    		 $("#taskName").prop("readOnly", true);
    	    		 $("#isSubTask").prop("disabled", true);
    	    		 $("#mainTask").prop("disabled", true);
    	    		 $("#project").prop("disabled", true);
    	    		 $("#description").prop("readOnly", true);
    	    		 $("#assignedTo").prop("disabled", true);
    	    		 $("#projectTaskStatusMaster").prop("disabled", true);
    	    		 $("#priority").prop("disabled", true);
    	    		 $("#isBillable").prop("disabled", true);
    	    		 $("#assignDate").prop("readOnly", true);
    	    		 $("#dueDate").prop("readOnly", true);
    	    		 $("#estimatedHours").prop("readOnly", true);
    	    		 
    	    		
    	    		 
    	    	 }else{
    	    		 $("#startDate").prop("disabled",true);
    	    		 $("#completeDate").prop("disabled",true);
    	    	 }
    	    	 
    	    	 
    	  
    	     // Initialize jQuery validation
    	     $("#addTaskForm").validate({
    	         rules: {
    	        	 [namespace + taskName]: {
    	                 required: true
    	             },
    	             [namespace + mainTask]: {
    	                 required: function() {
    	                     return isSubTaskCheckbox.is(":checked");
    	                 }
    	             },
    	             [namespace + project]: {
    	                 required: true
    	             },
    	             [namespace + description]: {
    	                 required: true,

    	             },
    	             [namespace + assignedTo] : {
    	                 required: true
    	             },
    	             [namespace + projectTaskStatusMaster]: {
    	                 required: true
    	             },
    	             [namespace + priority]: {
    	                 required: true
    	             },
    	             [namespace + assignDate]: {
    	                 required: true,
    	                 date: true
    	             },
    	             [namespace + dueDate]: {
    	                 required: true,
    	                 date: true
    	             },
    	             [namespace + estimatedHours]: {
    	            	 required: true,
    	            	 number: true,
    	                 min: 0
    	             },
             
    	         },
    	         messages: {
    	        	 [namespace + taskName]: {
    	                 required: "Please enter the task name."
    	             },
    	             [namespace + mainTask]: {
    	                 required: "Please select a main task."
    	             },
    	             [namespace + project]: {
    	                 required: "Please enter the project name."
    	             },
    	             [namespace + description]: {
    	                 required: "Please enter the description."
    	             },
    	             [namespace + assignedTo] : {
    	                 required: "Please select an assignee."
    	             },
    	             [namespace + projectTaskStatusMaster]: {
    	                 required: "Please select a task status."
    	             },
    	             [namespace + priority]: {
    	                 required: "Please select a priority."
    	             },
    	             [namespace + assignDate]: {
    	                 required: "Please enter the assign date.",
    	                 date: "Please enter a valid date."
    	             },
    	             [namespace + dueDate]: {
    	                 required: "Please enter the due date.",
    	                 date: "Please enter a valid date."
    	             },
    	             [namespace + estimatedHours]: {
    	            	 required: "Please enter the expected hours.",
    	                 number: "Please enter a valid number.",
    	                 min: "Expected hours must be a positive number."
    	             }
  	         }
    	     });
    	     
    	     
    	 });
 
    }
    
    
    
   
    function renderAddTaskPage(url){
    	let taskUrl = url;
    	let projectId = $('#project').val();
    	console.log("Text value is: "+projectId)
    	taskUrl = taskUrl.replace('PROJECTID', projectId);
    	window.location.href = taskUrl;
    }

    
    function setListTaskConfigs(config){
    	namespace = config.namespace;
    	listTaskURL = config.listTaskURL;
    	addTaskURL = config.addTaskURL;
    	homeURL = config.homeURL;

    		$('#project').change(function () {

    			
    			renderAddTaskPage(listTaskURL);
    			renderAddTaskPage(homeURL);
    		});
    		
    		$('#addTask').on('click',function(){
    			
    			renderAddTaskPage(addTaskURL);

    		});
		
    	};
    	
    	
    	

    
    function setDeleteConfigs(config){
    	namespace = config.namespace;
    	deleteTaskURL = config.deleteTaskURL;
    		let url = deleteTaskURL;
    		url = url.replace('TASKID', config.taskId);
    		url = url.replace('PROJECTID', config.projectId);
    		if(confirm('Are you sure you want to delete ?')) 
    			window.location.href = url;
   		
    		
    	}

    function setTimeConfigs(config){
    	namespace = config.namespace;
    	 description = config.description;
    	 startTime = config.startTime ;
    	 endTime = config.endTime;
    	 duration = config.duration;
    	 
    	 
    	

    	  $("#addTimeForm").validate({
 	         rules: {
 	        	
 	             [namespace + description]: {
 	                 required: true,

 	             },
 	            
 	             [namespace + startTime]: {
 	                 required: true,
 	                 date: true
 	             },
 	             [namespace + endTime]: {
 	                 required: true,
 	                 date: true
 	             },
 	             [namespace + duration]: {
 	            	 required: true,
 	            	 number: true,
 	                 min: 0
 	             },
          
 	         },
 	         messages: {
 	        	
 	             [namespace + description]: {
 	                 required: "Please enter the description."
 	             },
 	            
 	             [namespace + startTime]: {
 	                 required: "Please enter the Start Time.",
 	                 date: "Please enter a valid dateTime."
 	             },
 	             [namespace + endTime]: {
 	                 required: "Please enter the End Time.",
 	                 date: "Please enter a valid dateTime."
 	             },
 	             [namespace + duration]: {
 	            	 required: "Please enter the duration hours.",
 	                 number: "Please enter a valid number.",
 	                 min: "Duration hours must be a positive number."
 	             }
	         }
 	     });
 	     
 	 
    	 
    	 
       
    	 
    	
    	
    	
    }
    function setReviewConfigs(config){
    	console.log("in review")
    	namespace = config.namespace;
   	 review = config.review;
     $("#addReviewForm").validate({
         rules: {
        	 [namespace + review]: {
                 required: true
             }
           
     
         },
         messages: {
        	 [namespace + review]: {
                 required: "Please enter the Review."
             }
       }
     });
   	 
    }
    	
    
    
    
    
    
    
    AxHrmsTaskWebPortlet.setConfigs = setConfigs;
    AxHrmsTaskWebPortlet.setListTaskConfigs=setListTaskConfigs;
 	AxHrmsTaskWebPortlet.setDeleteConfigs=setDeleteConfigs;
 	AxHrmsTaskWebPortlet.setTimeConfigs=setTimeConfigs;
 	AxHrmsTaskWebPortlet.setReviewConfigs=setReviewConfigs;
})(jQuery, (window.AxHrmsTaskWebPortlet = window.AxHrmsTaskWebPortlet || {}));
