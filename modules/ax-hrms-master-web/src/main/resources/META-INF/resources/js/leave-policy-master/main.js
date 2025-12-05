(function($, AxLeavePolicyMasterWebPortlet) {
    let namespace;
    let carryForwardChecked = false;
    
    function setConfigsForValidation(config) {
        namespace = config.namespace;
        
        $.validator.addMethod("validateAccrualRate", function(value, element) {
            return this.optional(element) || /^\d{1,3}(\.\d{0,3})?$/.test(value);
        }, "Total Leave of the Year should contain up to 3 digits.");

        $.validator.addMethod("validateYearOfPolicy", function(value, element) {
            // Check if value is exactly 4 digits and not exceeding 2023
            return this.optional(element) || (/^\d{4}$/).test(value);
        }, "Please Enter A valid Year");
        
        $(document).ready(function() {
            const form = $("#" + namespace + "leavePolicyForm");
            form.validate({
                rules: {
                    [namespace + "leavetypemasterid"]: {
                        required: true
                    },
                    
                    [namespace + "accrualrate"]: {
                    	 required: true,
                         digits: true, 
                         minlength: 1, 
                         maxlength: 3
                    },
                    [namespace + "maximumbalance"]: {
                        required: function(element) {
                            return $("#" + namespace + "iscarryforward").is(":checked");
                        },
                        min: function(element) {
                            if ($("#" + namespace + "iscarryforward").is(":checked")) {
                                return 0.01;
                            }
                        }
                    },
                    [namespace + "eligibleaftermonths"]: {
                    	required: true,
                        digits: true, 
                        minlength: 1, 
                        maxlength: 2 
                    },
                    [namespace + "yearOfPolicy"]: {
                        required: true,
                        validateYearOfPolicy: true
                    }
                },
                messages: {
                    [namespace + "leavetypemasterid"]: {
                        required: "Please select a leave type"
                    },
                    [namespace + "accrualrate"]: {
                    	required: "Please enter total leave of the year",
                        digits: "Please enter only digits",
                        minlength: "Please enter up to two digits",
                        maxlength: "Please enter up to two digits"
                    },
                    [namespace + "maximumbalance"]: {
                        required: "Please enter maximum balance",
                        min: "Please enter a value greater than 0 for maximum balance"
                    },
                    [namespace + "eligibleaftermonths"]: {
                    	required: "Please enter eligible after months",
                        digits: "Please enter only digits",
                        minlength: "Please enter up to two digits",
                        maxlength: "Please enter up to two digits"
                    }
                },
                errorPlacement: function(error, element) {
                    error.insertAfter(element);
                }
            });

            $("#" + namespace + "maximumbalance").prop("disabled", true);
            $("#" + namespace + "ischeckmax").prop("disabled", true);

            if (config.cf) {
                $("#" + namespace + "maximumbalance").prop("disabled", false);
                $("#" + namespace + "ischeckmax").prop("disabled", false);
            }

            $("#" + namespace + "iscarryforward").change(function() {
                const isChecked = $(this).is(":checked");

                $("#" + namespace + "maximumbalance").prop("disabled", !isChecked);
                $("#" + namespace + "ischeckmax").prop("disabled", !isChecked);

                if (isChecked) {
                    $("#" + namespace + "maximumbalance").rules("add", {
                        required: true,
                        min: 0.01,
                        messages: {
                            required: "Please enter maximum balance",
                            min: "Please enter a value greater than 0 for maximum balance"
                        }
                    });
                    $("#" + namespace + "maximumbalance").valid();
                } else {
                    $("#" + namespace + "maximumbalance").rules("remove");
                    $("#" + namespace + "maximumbalance").val('');
                    $("#" + namespace + "maximumbalance").removeClass("error");
                    $("#" + namespace + "maximumbalance").next("label.error").remove();
                    $("#" + namespace + "leavePolicyForm").valid();
                    $("#" + namespace + "ischeckmax").prop("checked", false);
                }
                carryForwardChecked = isChecked;
            });
        });
    }

    function setConfigsForDeleteLeavePolicyMaster(config) {
        namespace = config.namespace;
        let url = config.deleteLeavePolicyMasterURL;
        url = url.replace('LEAVE_POLICY_MASTER_ID', config.leavePolicyMasterid);
        if (confirm('Are you sure you want to delete?')) {
            window.location.href = url;
        }
    }

    AxLeavePolicyMasterWebPortlet.setConfigsForValidation = setConfigsForValidation;
    AxLeavePolicyMasterWebPortlet.setConfigsForDeleteLeavePolicyMaster = setConfigsForDeleteLeavePolicyMaster;
})($, (window.AxLeavePolicyMasterWebPortlet = window.AxLeavePolicyMasterWebPortlet || {}));
