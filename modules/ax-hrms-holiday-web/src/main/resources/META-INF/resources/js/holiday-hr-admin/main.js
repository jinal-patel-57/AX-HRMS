(function($, AxHrmsHolidayHrAdminWebPortlet) {
    let namespace;
    let holidayName;
    let holidayDesc;
    let holidayDate;
    let isFloater;
    
    function setConfigsForValidation(config){
        namespace = config.namespace;
        holidayName =  config.holidayName;
        holidayDate = config.holidayDate;
    	holidayDesc = config.holidayDesc;
    	isFloater  = config.isFloater;
        $(document).ready(function(){
        	
        	$("#addEditHolidayHrAdmin").validate({
        		rules:{

        			[namespace + holidayName]:{
        				required:true,
        				validLetters:true
        			},

					[namespace + holidayDesc]:{
        				required:true,
        				validLetters:true
        			},

					[namespace + holidayDate]:{
        				required:true,
        				validDate:true
        			},

					[namespace + isFloater]:{
        				required:true,
        				
        			}


        		},
        		messages:{

        			[namespace + holidayName]:{

        				required:"Enter Holiday name",
        				validLetters:"Enter letters only"
        			}
        		},
        		
        		messages:{

        			[namespace + holidayDesc]:{

        				required:"Enter Holiday Description",
        				validLetters:"Enter letters only"
        			}
        		},
        		
        		messages:{

        			[namespace + holidayDate]:{

        				required:"Enter Holiday Date",
        				validDate:"Enter Date"
        			}
        		},
        		
        		messages:{

        			[namespace + isFloater]:{

        				required:"Select Any one Option"
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
        	
        	 $.validator.addMethod("validDate", function(value, element) {
        	   
        	    function isWithinAllowedYears(year, currentYear) {
        	        return year >= currentYear - 2 && year <= currentYear + 1;
        	    }
        	    var selectedYear = new Date(value).getFullYear();
        	    var currentYear = new Date().getFullYear();
        	    var isValidYear = isWithinAllowedYears(selectedYear, currentYear);
        	    return this.optional(element) || isValidYear;
        	}, "Please enter a valid date within the current year and the two previous years");

        });
        
    }
    function setConfigsForDeleteHoliday(config){
        namespace = config.namespace;
        console.log(config);
            let url = config.deleteUrl;
            url = url.replace('HOLIDAYHRADMIN_ID', config.holidayId);
            url = url.replace('SELECTED_YEAR', config.selectedYear);
            let text = "Are you sure you want to delete this holiday?";
            if (confirm(text) == true) {
                window.location.href = url;
            } else {
                text = "You canceled!";
            }
    }
    
    
    function setConfigsForRenderHolidayWithYear(config){
        namespace = config.namespace;
        console.log(config);
        
            var url = config.renderUrl;
            console.log(url);
            url = url.replace('SELECTED_YEAR', config.selectedYear);
            console.log(url);

			window.location.href = url;
            
    }
    
    AxHrmsHolidayHrAdminWebPortlet.setConfigsForRenderHolidayWithYear = setConfigsForRenderHolidayWithYear;
    
    AxHrmsHolidayHrAdminWebPortlet.setConfigsForValidation = setConfigsForValidation;
    AxHrmsHolidayHrAdminWebPortlet.setConfigsForDeleteHoliday = setConfigsForDeleteHoliday;
})($, (window.AxHrmsHolidayHrAdminWebPortlet = window.AxHrmsHolidayHrAdminWebPortlet || {}));

