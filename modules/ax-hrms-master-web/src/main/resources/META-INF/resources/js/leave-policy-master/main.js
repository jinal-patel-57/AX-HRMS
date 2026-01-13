(function ($, AxLeavePolicyMasterWebPortlet) {

    let namespace;

    function setConfigsForValidation(config) {

        namespace = config.namespace;

        $(document).ready(function () {
        	
        	function allowOnlyDigits(e) {
			    if (
			        e.keyCode === 8  || // backspace
			        e.keyCode === 46 || // delete
			        e.keyCode === 9  || // tab
			        e.keyCode === 27 || // escape
			        e.keyCode === 13 || // enter
			        (e.keyCode >= 35 && e.keyCode <= 39) // home, end, arrows
			    ) {
			        return;
			    }
			
			    if (
			        (e.keyCode < 48 || e.keyCode > 57) && // top row
			        (e.keyCode < 96 || e.keyCode > 105)   // numpad
			    ) {
			        e.preventDefault();
			    }
			}
        	
        	$("#" + namespace + "fromYear, #" + namespace + "toYear").on("keydown", allowOnlyDigits);
        	$("#" + namespace + "fromYear, #" + namespace + "toYear").on("input", function () {
		        this.value = this.value.replace(/\D/g, '');
	        });
	        $("#" + namespace + "fromYear, #" + namespace + "toYear").on("input", function () {
		        if (this.value.length > 4) {
		            this.value = this.value.substring(0, 4);
		        }
		    });
        	
        	// Year range validator
			$.validator.addMethod(
			    "yearRange",
			    function (value) {
			        var year = parseInt(value, 10);
			        return year >= 2000 && year <= 2100;
			    },
			    "Year must be between 2000 and 2100"
			);
			
			// To Year > From Year validator
			$.validator.addMethod(
			    "toYearGreater",
			    function (value, element, params) {
			        var fromYear = $("#" + params).val();
			        if (!fromYear || !value) {
			            return true;
			        }
			        return parseInt(value, 10) > parseInt(fromYear, 10);
			    },
			    "To Year must be greater than From Year"
			);
			
			// At least one checkbox selected
			$.validator.addMethod(
			    "atLeastOneLeaveType",
			    function () {
			        return $('input[name="' + namespace + 'leaveTypeIds"]:checked').length > 0;
			    },
			    "Please select at least one leave type"
			);
			
			$.validator.addMethod(
			    "digitsOnly",
			    function (value, element) {
			        return this.optional(element) || /^\d+$/.test(value);
			    },
			    "Only digits are allowed"
			);
			
			var fmCloneLeavePolicy = $("#fmCloneLeavePolicy");

			fmCloneLeavePolicy.validate({
			    rules: {
			        [namespace + "fromYear"]: {
			            required: true,
			            digitsOnly: true,
			            yearRange: true
			        },
			        [namespace + "toYear"]: {
			            required: true,
			            digitsOnly: true,
			            yearRange: true,
			            toYearGreater: namespace + "fromYear"
			        },
			        [namespace + "leaveTypeIds"]: {
			            atLeastOneLeaveType: true
			        }
			    },
			    messages: {
			        [namespace + "fromYear"]: {
			            required: "From Year is required",
			            digitsOnly: "Enter valid 4 digits year"
			        },
			        [namespace + "toYear"]: {
			            required: "To Year is required",
			            digitsOnly: "Enter valid 4 digits year"
			        }
			    },
			    errorPlacement: function (error, element) {
			    	error.addClass("text-danger");
			        if (element.attr("name") === namespace + "leaveTypeIds") {
			        	//var insertAfterLabel = $('input[name="' + namespace + 'leaveTypeIds"]').last()[0].getAttribute('id');
			        	//console.log('insert after label -- ' + insertAfterLabel);
			            error.insertAfter(
			            	//$('label[for="'+ insertAfterLabel +'"]')
			            	$('#leaveTypeMasters')
			            );
			        } else {
			            error.insertAfter(element);
			        }
			    },
			    onkeyup: function (element) {
                    $(element).valid();
                },
	            onfocusout: function (element) {
	                $(element).valid();
	            },
	
	            submitHandler: function (form) {
	                form.submit();
	            }
			});
			
			//fmCloneLeavePolicy.on('keyup change', function () {
			  //  fmCloneLeavePolicy.valid();
			//});			

            const form = $("#" + namespace + "leavePolicyForm");
            if (!form.length) {
                return;
            }
            
            // Custom validators – SAME place & pattern as working reference
            $.validator.addMethod(
                "validateAccrualRate",
                function (value, element) {
                    return this.optional(element) || /^\d{1,3}$/.test(value);
                },
                "Total Leave of the Year should contain up to 3 digits."
            );

            $.validator.addMethod(
                "validateYearOfPolicy",
                function (value, element) {
                    return this.optional(element) || /^\d{4}$/.test(value);
                },
                "Please Enter A valid Year"
            );

            $.validator.addMethod(
                "validLeavePolicyDescription",
                function (value, element) {
                    value = value.trim();
                    return this.optional(element) ||
                        /^[A-Za-z0-9\s.,&()-]+$/.test(value);
                },
                "Only letters, numbers, spaces and . , & ( ) - are allowed"
            );

            // Destroy old validator if exists
            if (form.data("validator")) {
                form.validate().destroy();
            }

            form.validate({

                rules: {
                    [namespace + "leavetypemasterid"]: {
                        required: true
                    },

                    [namespace + "accrualrate"]: {
                        required: true,
                        digits: true,
                        maxlength: 3
                    },

                    [namespace + "eligibleaftermonths"]: {
                        required: true,
                        digits: true,
                        maxlength: 2
                    },

                    [namespace + "yearOfPolicy"]: {
                        required: true,
                        validateYearOfPolicy: true
                    },

                    [namespace + "description"]: {

                        minlength: 2,
                        maxlength: 75,
                        validLeavePolicyDescription: true
                    }
                },

                messages: {
                    [namespace + "leavetypemasterid"]: {
                        required: "Please select a leave type"
                    },

                    [namespace + "accrualrate"]: {
                        required: "Please enter total leave of the year",
                        digits: "Please enter only digits",
                        maxlength: "Please enter up to three digits"
                    },

                    [namespace + "eligibleaftermonths"]: {
                        required: "Please enter eligible after months",
                        digits: "Please enter only digits",
                        maxlength: "Please enter up to two digits"
                    },

                    [namespace + "description"]: {

                        minlength: "Description must be at least 2 characters",
                        maxlength: "Description cannot exceed 75 characters",
                        validLeavePolicyDescription:
                            "Only letters, numbers, spaces and . , & ( ) - are allowed"
                    }
                },
                errorPlacement: function (error, element) {
                	error.addClass("text-danger");
                    error.insertAfter(element);
                },

                highlight: function (element) {
                    $(element).addClass("is-invalid");
                },

                unhighlight: function (element) {
                    $(element).removeClass("is-invalid");
                },
                onkeyup: function (element) {
                    $(element).valid();
                },
	            onfocusout: function (element) {
	                $(element).valid();
	            },
	
	            submitHandler: function (form) {
	                form.submit();
	            }
            });
        });
    }

    function setConfigsForDeleteLeavePolicyMaster(config) {
        let url = config.deleteLeavePolicyMasterURL;
        url = url.replace("LEAVE_POLICY_MASTER_ID", config.leavePolicyMasterid);
        if (confirm("Are you sure you want to delete?")) {
            window.location.href = url;
        }
    }

    AxLeavePolicyMasterWebPortlet.setConfigsForValidation =
        setConfigsForValidation;

    AxLeavePolicyMasterWebPortlet.setConfigsForDeleteLeavePolicyMaster =
        setConfigsForDeleteLeavePolicyMaster;

})(jQuery,
   (window.AxLeavePolicyMasterWebPortlet =
       window.AxLeavePolicyMasterWebPortlet || {}));
