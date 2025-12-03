var globalNamespace;
var checkAppraisalFormTemplateAvailabilityURL;
var getDesignationListURL;
var schedule_meeting_form_modal;
var submitScheduleMeetingForm;
var send_self_evaluation_form_modal;
var send_peer_evaluation_form_modal;
var send_manager_evaluation_form_modal;
var update_meeting_form_modal;
var update_employee_ctc_form_modal;
var updateEmployeeCtcForm;
var updateScheduledMeetingForm;
var submitManagerEvaluationForm;
var submitPeerEvaluationForm;
var submitSelfEvaluationForm;
var open_add_appraisal_popup;
var submitAddEmployeeForm;

(function ($, AXHrmsHrAppraisalFormTemplatesWebPortlet) {
    let namespace;

    function setConfigs(config) {
        namespace = config.namespace;
        globalNamespace = namespace;
        checkAppraisalFormTemplateAvailabilityURL = config.checkAppraisalFormTemplateAvailabilityURL;
        getDesignationListURL = config.getDesignationListURL;

        $(document).ready(function () {
            const peerSelect = $('#peerSelect');
            const selectedOptionsContainer = $('#selectedOptionsContainer');
            const hiddenField = $('#peerList');
            let selectedValues = [];

            renderSelectedOptions();

            // Function to update selected options
            function updateSelectedOptions() {
                const selectedOption = $(this).val();
                if (selectedOption && !selectedValues.includes(selectedOption)) { // Check for duplicates
                    selectedValues.push(selectedOption);
                    renderSelectedOptions();
                }
            }

            // Function to render selected options as dismissible badges
            function renderSelectedOptions() {
                selectedOptionsContainer.empty(); // Clear previous options
                hiddenField.val(selectedValues.join(',')); // Update hidden field value

                // Create dismissible badges for each selected option
                selectedValues.forEach(function (value) {
                    const badge = $('<span>').addClass('selected-option btn btn-sm btn-outline-secondary mr-2 mt-1');
                    badge.text($('#peerSelect option[value="' + value + '"]').text());

                    // Dismiss button
                    const dismissBtn = $('<span>').addClass('badge badge-secondary ml-2').text('X');

                    dismissBtn.click(function () {
                        selectedValues = selectedValues.filter(function (val) {
                            return val !== value;
                        });
                        renderSelectedOptions();
                    });

                    badge.append(dismissBtn);
                    selectedOptionsContainer.append(badge);
                });
            }

            // Bind change event to select box
            peerSelect.change(updateSelectedOptions);
        });


        $(document).ready(function () {
            const managerSelect = $('#managerSelect');
            const selectedOptionsContainerManager = $('#selectedOptionsContainerManager');
            const hiddenFieldManager = $('#managerList');
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
                    badge.text($('#managerSelect option[value="' + value + '"]').text());

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

            // Bind change event to select box
            managerSelect.change(updateSelectedOptions);
        });

        $(document).ready(function () {
            const meetingSelect = $('#meetingSelect');
            const selectedOptionsContainerManager = $('#selectedOptionsContainerAttendees');
            const hiddenFieldManager = $('#attendeeList');
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
                    badge.text($('#meetingSelect option[value="' + value + '"]').text());

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

            // Bind change event to select box
            meetingSelect.change(updateSelectedOptions);
        });




        // Add custom validation method to check if date is in the future
        $.validator.addMethod('futureDate', function (value, element) {
            var today = new Date();
            var selectedDate = new Date(value);
            return selectedDate >= today;
        }, 'Please select a future date.');

        // Validate the form
        $("#scheduleMeetingForm").validate({
            rules: {
                [namespace + "meetingDate"]: {
                    required: true,
                    notBeforeToday: true,
                    notAfterEndOfMonth: true
                },
                [namespace + "meetingTime"]: {
                    required: true
                },
                [namespace + "teamIdSelectBox"]: {
                    required: true
                }
            },
            messages: {
                [namespace + "meetingDate"]: {
                    required: "Please select a date for the meeting.",
                    notBeforeToday: "Please select a date equal to or after today.",
                    notAfterEndOfMonth: "Please select a date within this month!"
                },
                [namespace + "meetingTime"]: {
                    required: "Please select a time for the meeting."
                },
                [namespace + "teamIdSelectBox"]: {
                    required: "Please select at least one attendee."
                }
            },
            errorPlacement: function (error, element) {
                error.insertAfter(element);
            }
        });

        // Validation for Self Form
        $('#selfForm').validate({
            rules: {
                [namespace + "submissionDate"]: {
                    required: true,
                    notBeforeToday: true,
                    notAfterEndOfMonth: true
                }
            },
            messages: {
                [namespace + "submissionDate"]: {
                    required: "Please select a date",
                    notBeforeToday: "Please select a date equal to or after today.",
                    notAfterEndOfMonth: "Please select a date within this month!"
                }
            },
            errorPlacement: function (error, element) {
                error.insertAfter(element);
            }
        });
        // Validation for Peer Form
        $('#peerForm').validate({
            rules: {
                [namespace + "submissionDate"]: {
                    required: true,
                    notBeforeToday: true,
                    notAfterEndOfMonth: true
                }
            },
            messages: {
                [namespace + "submissionDate"]: {
                    required: "Please select a date",
                    notBeforeToday: "Please select a date equal to or after today.",
                    notAfterEndOfMonth: "Please select a date within this month!"
                }
            },
            errorPlacement: function (error, element) {
                error.insertAfter(element);
            }
        });

        // Validation for Manager Form
        $('#managerForm').validate({
            rules: {
                [namespace + "submissionDate"]: {
                    required: true,
                    notBeforeToday: true,
                    notAfterEndOfMonth: true
                }
            },
            messages: {
                [namespace + "submissionDate"]: {
                    required: "Please select a date",
                    notBeforeToday: "Please select a date equal to or after today.",
                    notAfterEndOfMonth: "Please select a date within this month!"
                }
            },
            errorPlacement: function (error, element) {
                error.insertAfter(element);
            }
        });




        $("#updateEmployeeCtc").validate({
            rules: {
                [namespace + "updatedDesignation"]: {
                    required: true,
                },
                [namespace + "updateGrossSalaryPM"]: {
                    required: true,
                    numericality: true

                },
                [namespace + "updateGrossSalaryPA"]: {
                    required: true,
                    numericality: true
                },
                [namespace + "documentName"]: {
                    required: true
                },
                [namespace + "uploadDocument"]: {
                    required: true
                },
                [namespace + "comments"]: {
                    required: true,
                    maxCharThousand: true
                }
            },
            messages: {
                [namespace + "updatedDesignation"]: {
                    required: "Please Select Designation to Update.",
                },
                [namespace + "updateGrossSalaryPM"]: {
                    required: "Please Enter Gross Salary PM."
                },
                [namespace + "updateGrossSalaryPA"]: {
                    required: "Please Enter Gross Salary PA."
                },
                [namespace + "documentName"]: {
                    required: "Please Enter a File Name."
                },
                [namespace + "uploadDocument"]: {
                    required: "Please Upload a Employee Document."
                },
                [namespace + "comments"]: {
                    required: "Please Enter comments.",
                }
            },
            errorPlacement: function (error, element) {
                error.insertAfter(element);
            }
        });

        // validation for add Employee Apprasial From
        $('#addEmployeeForm').validate({
        	rules: {
        		 [namespace + "employee"]: {
                     required: true
                 }
        	},
        	messages: {
        		 [namespace + "employee"]: {
                     required: "Please select Employee."
                 }
             },
        	
        });

        // Custom validation methods
        $.validator.addMethod("maxCharThousand", function (value, element) {
            return this.optional(element) || value.length <= 1000;
        }, "Please enter no more than 1000 characters.");

        $.validator.addMethod(
            "numericality",
            function (value, element) {
                return this.optional(element) || /^\d*\.?\d+$/.test(value);
            },
            "Please Use Decimals."
        );
        $.validator.addMethod('notBeforeToday', function (value, element) {
            var today = new Date();
            var selectedDate = new Date(value);
            return selectedDate >= today;
        }, 'Please select a date after today.');

        $.validator.addMethod('notAfterEndOfMonth', function (value, element) {
            var today = new Date();
            var year = today.getFullYear();
            var month = today.getMonth() + 1; // JavaScript months are 0-based
            var endOfMonth = new Date(year, month, 0).toISOString().split('T')[0]; return value <= endOfMonth;
        }, 'Please select a date before the end of the current month.');



        send_peer_evaluation_form_modal = function (appraisalProcessId) {
            var today = new Date().toISOString().split('T')[0];
            document.getElementById("submissionDate").min = today;
            $('#apidpeer').val(appraisalProcessId);
            $.ajax({
                url: checkAppraisalFormTemplateAvailabilityURL,
                type: "POST",
                data: {
                    [globalNamespace + 'levelName']: "Peer"
                },
                success: function (response, textStatus, jqXHR) {
                    const respObj = JSON.parse(response);
                    if (respObj.status == 'success' && respObj.data) {
                        $('#peerModal').modal('show');
                    }
                    else {
                        showMessage("There is no template form availabe for PEER evaluation in current year. Please Add One to Procced !");
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                }
            });

        }

        submitPeerEvaluationForm = function () {
            if ($('#peerForm').valid()) {
                $('#peerModal').modal('hide');
                $('#peerForm').submit();
            }
            else {
                return false;
            }
        }



        updateEmployeeCtcForm = function () {
            if ($('#updateEmployeeCtc').valid()) {
                $('#updateEmployeeCTC').modal('hide');
                $('#updateEmployeeCtc').submit();
            }
            else {
                return false;
            }
        }
        updateScheduledMeetingForm = function () {
            if ($('#updateMeetingForm').valid()) {
                $('#updateMeetingModal').modal('hide');
                $('#updateMeetingForm').submit();
            }
            else {
                return false;
            }
        }



        submitScheduleMeetingForm =  function () {
            if ($('#scheduleMeetingForm').valid()) {
                $('#scheduleMeetingModal').modal('hide');
                $('#scheduleMeetingForm').submit();
            }
            else {
                return false;
            }
        }

        submitSelfEvaluationForm  =  function () {
            if ($("#selfForm").valid()) {
                $('#selfModal').modal('hide');
                $('#selfForm').submit();
            }
            else {
                return false;
            }
        }

        
        submitManagerEvaluationForm = function () {
            if ($('#managerForm').valid()) {
                $('#managerModal').modal('hide');
                $('#managerForm').submit();
            }
            else {
                return false;
            }
        }


        send_self_evaluation_form_modal =function (appraisalProcessId) {
            $('#apid').val(appraisalProcessId);
            var today = new Date().toISOString().split('T')[0];
            document.getElementById("submissionDate").min = today;
            $.ajax({
                url: checkAppraisalFormTemplateAvailabilityURL,
                type: "POST",
                data: {
                    [globalNamespace + 'levelName']: "Self"
                },
                success: function (response, textStatus, jqXHR) {
                    const respObj = JSON.parse(response);
                    if (respObj.status == 'success' && respObj.data) {
                        $('#selfModal').modal('show');
                    }
                    else {
                        showMessage("There is no template form availabe for SELF evaluation in current year. Please Add One to Procced !");
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                }
            });

        }

        
        send_manager_evaluation_form_modal = function (appraisalProcessId) {
            var today = new Date().toISOString().split('T')[0];
            document.getElementById("submissionDate").min = today;
            $('#apidManager').val(appraisalProcessId);
            $.ajax({
                url: checkAppraisalFormTemplateAvailabilityURL,
                type: "POST",
                data: {
                    [globalNamespace + 'levelName']: "Manager"
                },
                success: function (response, textStatus, jqXHR) {
                    const respObj = JSON.parse(response);
                    if (respObj.status == 'success' && respObj.data) {
                        $('#managerModal').modal('show');
                    }
                    else {
                        showMessage("There is no template form availabe for MANAGER evaluation in current year. Please Add One to Procced !");
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                }
            });

        }

        schedule_meeting_form_modal = function (appraisalProcessId) {
            var today = new Date().toISOString().split('T')[0];
            document.getElementById("submissionDate").min = today;
            $('#apidScheduleMeeting').val(appraisalProcessId);
            $('#scheduleMeetingModal').modal('show');
        }

        update_employee_ctc_form_modal = function (fullName, designation, appraisalProcessId) {
            fetch_designations();
            $('#employeeName').val(fullName);
            $('#updateCtcAppraisalProcessId').val(appraisalProcessId);
            $('#currentDesignation').val(designation);
            $('#updateEmployeeCTC').modal('show');
        }

        function fetch_designations() {
            $.ajax({
                url: getDesignationListURL,
                type: "POST",
                data: {
                },
                success: function (response, textStatus, jqXHR) {
                    if (response) {
                        const respObj = JSON.parse(response);
                        if (respObj.status == 'success') {
                            const designations = respObj.data;
                            var stateEle = $('#updatedDesignation').empty();
                            $.each(designations, function (i, item) {
                                stateEle.append('<option value="' + i + '">' + item + '</option>');
                            });
                        }
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {

                }
            });
        }

        update_meeting_form_modal = function (meetingId, meetingDate, meetingTime, attendeeList, apid) {
            var today = new Date().toISOString().split('T')[0];
            let als = [];
            selectedValuesUpdatedAttendees = [];
            als = attendeeList.split(',');
            als.forEach(element => {
                if (!selectedValuesUpdatedAttendees.includes(element)) { // Check for duplicates
                    selectedValuesUpdatedAttendees.push(element);
                    renderSelectedOptions();
                }
            });
            document.getElementById("submissionDate").min = today;
            $('#meetingId').val(meetingId);
            $('#updateMeetingTime').val(meetingTime);
            $('#updateMeetingDate').val(meetingDate);
            $('#updateMeetingAppraisalProcessId').val(apid);
            $('#updateMeetingModal').modal('show');
        }

        function showMessage(newMessage) {
            Liferay.Util.openToast({
                title: 'Warning',
                message: newMessage,
                type: 'warning',
                autoClose: 10000
            });
        }



        const updatedMeetingSelect = $('#updatedMeetingSelect');
        const selectedOptionsContainerManager = $('#selectedOptionsContainerUpdatedAttendees');
        const hiddenFieldManager = $('#updatedAttendeeList');
        let selectedValuesManager = [];
        let selectedValuesUpdatedAttendees = [];



        function updateSelectedOptions() {
            const selectedOption = $(this).val();
            if (selectedOption && !selectedValuesUpdatedAttendees.includes(selectedOption)) { // Check for duplicates
                selectedValuesUpdatedAttendees.push(selectedOption);
                renderSelectedOptions();
            }
        }

        // Function to render selected options as dismissible badges
        function renderSelectedOptions() {
            selectedOptionsContainerManager.empty(); // Clear previous options
            hiddenFieldManager.val(selectedValuesUpdatedAttendees.join(',')); // Update hidden field value

            // Create dismissible badges for each selected option
            selectedValuesUpdatedAttendees.forEach(function (value) {
                const badge = $('<span>').addClass('selected-option btn btn-sm btn-outline-secondary mr-2 mt-1');
                badge.text($('#meetingSelect option[value="' + value + '"]').text());

                // Dismiss button
                const dismissBtn = $('<span>').addClass('badge badge-secondary ml-2').text('X');

                dismissBtn.click(function () {
                    selectedValuesUpdatedAttendees = selectedValuesUpdatedAttendees.filter(function (val) {
                        return val !== value;
                    });
                     renderSelectedOptions();
                });

                badge.append(dismissBtn);
                selectedOptionsContainerManager.append(badge);
            });
        }
        // Bind change event to select box
        updatedMeetingSelect.change(updateSelectedOptions);

        open_add_appraisal_popup = function(){
        	console.log("Working");
        	$('#addEmployeeModel').modal('show');
 
        }
        
        submitAddEmployeeForm = function () {
        	if ($('#addEmployeeForm').valid()) {
        		$('#addEmployeeModel').modal('hide');
        		$('#empid').val($('#apprasialEmployee').val());
        		debugger;
        		$('#addEmployeeForm').submit();
        	}
        	else {
        		return false;
        	}
        }
        
    }
     
     
    
   


    AXHrmsHrAppraisalFormTemplatesWebPortlet.setConfigs = setConfigs;

})(jQuery, (window.AXHrmsHrAppraisalFormTemplatesWebPortlet = window.AXHrmsHrAppraisalFormTemplatesWebPortlet || {}));


// UPDATE MEETING JS ENDS



// submitScheduleMeetingForm()