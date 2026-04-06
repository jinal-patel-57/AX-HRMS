(function ($, AxEmployeeLeaveManagement) {
    let namespace;
    let isContinuous;
    let remainingLeave;
    let isApplicableForFloater;
    let getFloaters;
    let getEmployeeLeavesData;
    let startDate = new Date();
    let endDate = new Date();
    let startDateContainer;
    let endDateContainer;
    let dateInputsContainer;
    let leaveType;
    let submitBtn;
    let endDateValue;
    let startDateValue;
    let reason;
    let floaterDaysContainer;
    let dayTypeSelectContainer;
    let remainingLeavesPar;
    let daysDiff=0;
    let leaveRequestForm;
    let employeeNames;
    let employeeId;


    function setConfigs(config){
        namespace = config.namespace;
        isContinuous = config.isContinuous;
        remainingLeave = config.remainingLeave;
        isApplicableForFloater = config.isApplicableForFloater;

        getFloaters = config.getFloaters;
        getEmployeeLeavesData = config.getEmployeeLeavesData;

        startDate = $('#'+namespace+'startDate');
        endDate = $('#'+namespace+'endDate');
        startDateContainer = $('#startDateContainer');
        endDateContainer = $('#endDateContainer');
        dateInputsContainer = $('#dateInputsContainer');
        reason = $('#'+namespace+'reason');
        leaveType = $('#'+namespace+'leaveType');
        submitBtn = $('#'+namespace+'submit');
        floaterDaysContainer = $('#floaterDaysContainer')
        dayTypeSelectContainer = $('.dayTypeSelectContainer');
        remainingLeavesPar = $('#remainingLeavesPar');
        leaveRequestForm = $('#'+namespace+'leaveRequestForm');
        employeeNames = $('#'+namespace+'employeeNames');
        employeeId = $('#'+namespace+'employeeId');





        function showStartDateContainer(){
            startDateContainer.show();
        }
        function showEndDateContainer(){
            endDateContainer.show()
        }
        function hideStartDateContainer(){
            startDateContainer.hide();
        }
        function hideEndDateContainer(){
            endDateContainer.hide();
        }
        function setBlankStartDate(){
            startDate.val('');
        }
        function setBlankEndDate(){
            endDate.val('');
        }
        function showDateInputContainer(){
            dateInputsContainer.show();
        }
        function hideDateInputContainer(){
            dateInputsContainer.hide();
        }
        function setBlankDateInputContainer(){
            dateInputsContainer.empty();
        }
        function setReadOnlyStartDate(){
            startDate.prop('readOnly',true);
        }
        function setReadOnlyEndDate(){
            endDate.prop('readOnly',true);
        }
        function setEditableStartDate(){
            startDate.prop('readOnly',false);
        }
        function setEditableEndDate(){
            endDate.prop('readOnly',false);
        }
        function hideReasonContainer() {
            reason.val('');
            reason.prop('readOnly', true);
            reason.closest('.form-group').hide(); // hides label + input
        }

        function showReasonContainer() {
            reason.prop('readOnly', false);
            reason.closest('.form-group').show();
        }
        function setDisabledSubmitBtn(){
            submitBtn.prop('disabled',true);
        }
        function setEnabledSubmitBtn(){
            submitBtn.prop('disabled',false);
        }
        function setReadOnlyReason(){
            reason.val(' ');
            reason.prop("readOnly",true);
        }
        function setEditableReason(){
            reason.val('');
            reason.prop("readOnly",false);
        }
        function hideDayTypeSelectContainer(){
            dayTypeSelectContainer.hide();
        }
        function showDayTypeSelectContainer(){
            dayTypeSelectContainer.show();
        }

function showMessage(message, type = 'warning') {

    let title = 'Message';
    let bodyClass = 'modal-info';

    if (type === 'error') {
        title = 'Error';
        bodyClass = 'modal-error';
    } else if (type === 'success') {
        title = 'Success';
        bodyClass = 'modal-success';
    } else if (type === 'warning') {
        title = 'Warning Message';
        bodyClass = 'modal-warning';
    }

    document.getElementById('customModalTitle').innerText = title;
    document.getElementById('customModalBody').innerHTML =
        '<div class="' + bodyClass + '">' + message + '</div>';

    document.getElementById('customMessageModal').style.display = 'flex';
}




function closeCustomModal() {
    document.getElementById('customMessageModal').style.display = 'none';
}


        function formatDateForInput(date) {
            date = new Date(date);
            const year = date.getFullYear();
            const month = String(date.getMonth() + 1).padStart(2, '0');
            const day = String(date.getDate()).padStart(2, '0');
            return `${year}-${month}-${day}`;
        }
        function dynamicDateCreator() {
            console.log("Run : dynamicDateCreator")
            daysDiff = 0;
            startDateValue = startDate.val();
            endDateValue = endDate.val();
            startDate.val(startDateValue);
            endDate.val(endDateValue);
            let diffDays = Number(Math.ceil((new Date(endDateValue) - new Date(startDateValue)) / (1000 * 60 * 60 * 24)));
            dateInputsContainer.empty();

            for (let i = 0; i <= diffDays; i++) {
                let date = new Date(startDateValue);
                date.setDate(new Date(startDateValue).getDate() + i);

                let day = ('0' + date.getDate()).slice(-2);
                let month = ('0' + (date.getMonth() + 1)).slice(-2);
                let year = date.getFullYear();
                let dateString = year + '-' + month + '-' + day;
                console.log(dateString);

                const dateContainer = $('<div>');
                dateContainer.attr('class',namespace+'day'+day+'Date d-flex align-items-center c-gap-4 mb-3');

                //Create div for inputed dates: Line to Line
                const dateDiv = $('<input>').attr('type', 'date');
                dateDiv.attr('class','form-control');
                dateDiv.attr('id',namespace+'day'+day+'Date');
                dateDiv.attr('name',namespace+'day'+day+'Date');
                dateDiv.attr('value',dateString);
                dateDiv.prop('readOnly',true);

                //Create Input element for select Half-day or Full-day
               let dayTypeSelectContainerDiv = null;

               if (!isApplicableForFloater) {

                   const halfTypeDiv = $('<input>').attr('type','checkbox');
                   halfTypeDiv.attr('name', namespace+'day'+day+'IsHalf');
                   halfTypeDiv.attr('id', namespace+'day'+day+'IsHalf');

                   const halfTypeLabel = $('<label>').text('Is Half leave');
                   halfTypeLabel
                       .addClass('my-0 ml-1')
                       .attr('for', namespace+'day'+day+'IsHalf');

                   dayTypeSelectContainerDiv = $('<div>')
                       .addClass('dayTypeSelectContainer d-flex align-items-center')
                       .append(halfTypeDiv)
                       .append(halfTypeLabel);
               }


                if (date.getDay() !== 0 && date.getDay() !== 6) {
//                    dateContainer.append(dateDiv);
//                    dateContainer.append(dayTypeSelectContainerDiv);
//                    dateInputsContainer.append(dateContainer);
                        dateContainer.append(dateDiv);

                        if (dayTypeSelectContainerDiv) {
                            dateContainer.append(dayTypeSelectContainerDiv);
                        }

                        dateInputsContainer.append(dateContainer);

                    daysDiff++;
                }
                dayTypeSelectContainer = $('.dayTypeSelectContainer');
            }
            if(daysDiff == 0){
                setDisabledSubmitBtn();
            }
            else{
                setEnabledSubmitBtn();
            }
        }

        function getLastValidEndDate(startDate,tempRemainingLeave){
            startDateValue = new Date(startDate);
            console.log("run : getLastValidEndDate")
            endDateValue = new Date(endDate.val());
            let tempEndDate = new Date(startDateValue);
            if(tempRemainingLeave > 0){
                tempEndDate.setDate(startDateValue.getDate() - 1);
                while(tempRemainingLeave > 0){
                    tempEndDate.setDate(tempEndDate.getDate() + 1);
                    if(tempEndDate.getDay() === 6 || tempEndDate.getDay() === 0)
                        continue;
                    else
                        tempRemainingLeave--;
                    if(new Date(tempEndDate).getTime() === new Date(endDateValue).getTime()){
                        break;
                    }
                }
            }
            return tempEndDate;
        }

        function validEndDateOrNot(){
            let startDateValue = new Date(startDate.val());
            let endDateValue = new Date(endDate.val());

            let endDateTime = new Date(endDateValue).getTime();

            if(startDate.val() != "" || endDate.val() != ""){
                let validEndDate;
                if(isContinuous)
                    validEndDate = getLastValidEndDate(startDateValue,Number(remainingLeave));
                else
                    validEndDate = getLastValidEndDate(startDateValue,Number(remainingLeave)/0.5);

                if(endDateTime > new Date(validEndDate).getTime()){
                    endDate.val('');
                    return false;
                }else{
                    return true;
                }
            }
            else{
//                showMessage("Please enter date");
            }
        }

        function wrongDateValidation(){
            startDateValue = startDate.val();
            endDateValue = endDate.val();
            startDate.val(startDateValue);
            endDate.val(endDateValue);

            if(endDate.val() != "" && startDate.val() != ""){
                if(new Date(endDateValue).getTime() < new Date(startDateValue).getTime()){
                    setDisabledSubmitBtn();
//                    showMessage("Start date must be before End date");
                    setBlankEndDate();
                }
            }else{
                setDisabledSubmitBtn();
//                showMessage("Enter both dates...");
            }
        }

        //For jQuery Validation start here
        leaveRequestForm.validate({
            rules: {
                [namespace+"employeeNames"]:{
                    required: true
                },
                [namespace + "leaveType"]: {
                    required: true
                },
              [namespace + "reason"]: {
                  required: true,
                  validLetters: true,
                  maxlength: 500,
                  minlength:10
              },
                [namespace + "startDate"]: {
                    required: true,
                    validDate: true
                },
                [namespace + "endDate"]: {
                    required: true,
                    validEndDate: true
                },
            },
            messages: {
                [namespace + "leaveType"]: {
                    required: "Select Leave type"
                },
                [namespace + "reason"]: {
                       required: "Please enter reason for leave",
                       validLetters: "Please Enter valid data for the reason.",
                       maxlength: "Reason cannot exceed 500 characters"
                   },
                                   [namespace + "startDate"]: {
                                       required: "Start Date is required.",
                                   },
                                   [namespace + "endDate"]: {
                                       required: "End Date is required.",
                                   },
            },
            errorElement: "div",
                errorClass: "invalid-feedback",

                highlight: function(element) {
                    $(element).addClass("is-invalid");
                },

                unhighlight: function(element) {
                    $(element).removeClass("is-invalid");
                },

                errorPlacement: function (error, element) {
                    if (element.next("small").length) {
                        error.insertAfter(element.next("small"));
                    } else {
                        error.insertAfter(element);
                    }
                }
        });

    $.validator.addMethod("validLetters", function (value, element) {
        value = value.trim();

        // Allow most readable characters but block HTML tags
        var regex = /^[^<>]*$/;

        return this.optional(element) || regex.test(value);
    }, "Please Enter valid data for the reason.");

jQuery.validator.addMethod("validEndDate", function (value, element) {

    let now = new Date();
    let endDate = new Date(value);

    endDate.setHours(0, 0, 0, 0);

    // WFH-style validation: up to December 31 of current year
    const currentYear = now.getFullYear();
    const currentYearEnd = new Date(currentYear, 11, 31);
    currentYearEnd.setHours(23, 59, 59, 999);


     const maxEndDate = new Date();
        maxEndDate.setFullYear(maxEndDate.getFullYear() + 1);
        maxEndDate.setHours(23, 59, 59, 999);


    // Check if end date is beyond current year
    if (endDate > maxEndDate) {
        $.validator.messages.validEndDate = 
            "The end date must not exceed one year from today’s date.";
        return false;

    }

    /* Start date comparison */
    let startDateVal = $('#' + namespace + 'startDate').val();
    if (startDateVal) {
        let startDate = new Date(startDateVal);
        startDate.setHours(0, 0, 0, 0);

        if (endDate < startDate) {
            $.validator.messages.validEndDate =
                "End date must be after start date.";
            return false;
        }
    }

    $.validator.messages.validEndDate = "Enter a valid end date.";
    return true;

}, "Enter a valid end date.");




        jQuery.validator.addMethod("validDate", function (value, element) {
            let now = new Date();
            let selectedDate = new Date(value);
            
            // Set the selected date's time to 00:00:00 to compare only dates, not times
            selectedDate.setHours(0, 0, 0, 0);

            // WFH-style validation: previous month to current month only
            const currentYear = now.getFullYear();
            const currentMonth = now.getMonth();
            
            // Get first day of previous month
            const previousMonthStart = new Date(currentYear, currentMonth - 1, 1);
            previousMonthStart.setHours(0, 0, 0, 0);
            
            // Get last day of current month
            const currentMonthEnd = new Date(currentYear, currentMonth + 1, 0);
            currentMonthEnd.setHours(23, 59, 59, 999);

             const maxDate = new Date();
                maxDate.setFullYear(maxDate.getFullYear() + 1);
                maxDate.setHours(23, 59, 59, 999);

            
            // Validate: date must be >= previous month start AND <= current month end
            return selectedDate >= previousMonthStart && selectedDate <= maxDate;
        }, "Start date must be within the previous month and up to 1 year from today.");
        //jQuery Validation end here

        // first event: When Window load first time
        $(window).on('load',function(){
            console.log("on Load : window")
            setBlankStartDate();
            setBlankEndDate();
            setReadOnlyStartDate();
            setReadOnlyEndDate();
            setBlankDateInputContainer();
            setDisabledSubmitBtn();
        });

        //On change leave type
        leaveType.on('change',function (){
            console.log("on change : leaveType")
            console.log(`change LeaveType: ${leaveType.val()}`);
            isContinuous = $(this).find(':selected').data('is-continuous');
            remainingLeave = $(this).find(':selected').data('remaining-leaves');
            isApplicableForFloater = $(this).find(':selected').data('is-applicable-floater');
            console.log("isContinuous: ",isContinuous," remainingLeave: ",remainingLeave," isApplicableForFloater: ",isApplicableForFloater);
            remainingLeavesPar.text('Available Balance: ' + remainingLeave);
            if(remainingLeave == "" || remainingLeave == undefined)
                remainingLeavesPar.text('')

            dateInputsContainer.empty();
            $('#floaterDateLabel').remove();
 

            if(remainingLeave != 0 && leaveType.val() !== ""){
                setEnabledSubmitBtn();
                setEditableStartDate();
                setEditableEndDate();
                setEditableReason();
            }
            else{
                if(leaveType.val() !== "")
                    showMessage("You do not have enough leave balance for this leave type.");
                setDisabledSubmitBtn();
                setReadOnlyStartDate();
                setReadOnlyEndDate();
            }

        let selectedLeaveTypeName =  $(this).find('option:selected').text().trim().toLowerCase();

            // After change Leave Type if leave type is floater then run this if...else...
            if(isApplicableForFloater && selectedLeaveTypeName === 'festival floater'){
                hideStartDateContainer();
                hideEndDateContainer();
                setReadOnlyReason();
//                setBlankStartDate();
                hideReasonContainer();
                setBlankEndDate();
                ajaxForFloaterHolidayList();
            }
            else{

                floaterDaysContainer.empty();
                setBlankStartDate();
                setBlankEndDate();
                showStartDateContainer();
                showEndDateContainer();
//                setEditableReason();
                    showReasonContainer();
            }

            // After change Leave Type if leave type is Continuous then run this if...else...
            if(isContinuous){
             if (isApplicableForFloater && selectedLeaveTypeName === 'personal floater') {
                            $('#startDateLabel').text('Date');
                        } else {
                            $('#startDateLabel').text('Start Date');
                        }
                hideEndDateContainer();
                showStartDateContainer();
                hideDateInputContainer();
            }else{
                showEndDateContainer();
            }
        });

        startDate.on('change',function(){
            setBlankEndDate();
            console.log("on change : start")


            if(isContinuous){
                startDateValue = startDate.val();
                startDate.val(startDateValue);
                endDateValue = new Date(getLastValidEndDate(startDateValue,Number(remainingLeave)));
                endDate.val(endDateValue.toISOString().split('T')[0]);
                dynamicDateCreator();
                console.log(startDate.val() + " "+ endDate.val())
            }
        });



        endDate.on('blur',function(){
            startDateValue = startDate.val();
            endDateValue = endDate.val();
            startDate.val(startDateValue);
            endDate.val(endDateValue);

            wrongDateValidation();

            if(startDate.val() != "" || endDate.val() != ""){
                if(validEndDateOrNot()){
                    setEnabledSubmitBtn();
                    daysDiff = 0;
                    if(startDate.val() !== "" && endDate.val() !== ""){
                        if(remainingLeave/0.5 >= daysDiff && !isContinuous){
                            dynamicDateCreator();
                            showDateInputContainer();
                            console.log("daysDiff is: "+daysDiff +" at: "+new Date().getTime())
                            debugger;
                            //  Floater logic (NEW)
                                            if(isApplicableForFloater){
                                                if(daysDiff > remainingLeave){
                                                    showMessage("Selected leave duration exceeds your remaining leave balance.");
                                                    setDisabledSubmitBtn();
                                                    dateInputsContainer.empty();
                                                    return;
                                                }
                                            }
                            if(remainingLeave/0.5 == daysDiff){
                                showMessage("You can mark all days as half-days for the selected range.","Warning");
                                setDisabledSubmitBtn();
                                dateInputsContainer.on('change', 'input[type="checkbox"]', function() {
                                    if(checkSelectedCheckboxNumbers() == daysDiff) {
                                        setEnabledSubmitBtn();
                                    }else{
                                        setDisabledSubmitBtn();
                                    }
                                });
                            }else if (remainingLeave/0.5 > daysDiff && !isContinuous) {
                                if((daysDiff/0.5) > (remainingLeave/0.5)){
                                    debugger;
                                    showMessage("You can select half days for this given range.");
                                    setDisabledSubmitBtn();
                                }

                                dateInputsContainer.on('change', 'input[type="checkbox"]', function() {
                                    if(checkSelectedCheckboxNumbers() >= ((daysDiff/0.5)-(remainingLeave/0.5))) {
                                        setEnabledSubmitBtn();
                                    }else{
                                        setDisabledSubmitBtn();
                                    }
                                });
                            }else{
                                setEnabledSubmitBtn();
                            }
                        }else{
                            showMassege("You do not have enough leave balance for this leave type.")
                        }
                    }
                }else {
                    showMessage("Selected leave duration exceeds your remaining leave balance.")
                    setDisabledSubmitBtn();
                    dateInputsContainer.empty();
                }
            }else{
//                showMessage("Please select the required leave dates.");
            }

        });

        function checkSelectedCheckboxNumbers() {
            let checkboxes = document.querySelectorAll("input[type=checkbox]");
            let total = Number(0);

            for (let i = 0; i < checkboxes.length; i++) {
                if (checkboxes[i].checked) {
                    total++;
                }
            }
            return total;
        }

        dateInputsContainer.on('change', 'input[type="checkbox"]', function() {

            let isChecked = $(this).is(':checked');
            let parentDiv = $(this).parent(); // Parent div of the checkbox

            // Check if the checkbox is checked
            if (isChecked) {
                let isFirstHalfCheckbox = '<div class="d-flex align-items-center c-gap-2 ml-4 '+$(this).attr('name').replace('IsHalf', 'halfType')+'"><div class="d-flex align-items-center c-gap-2"> <input class="form-check-input" type="radio" name="' + $(this).attr('name').replace('IsHalf', 'halfType') + '" id="' + $(this).attr('id').replace('IsHalf', 'IsFirstHalf') + '" value="firstHalf" checked/>' + '<label class="m-0" for="' + $(this).attr('id').replace('IsHalf', 'IsFirstHalf') + '"> First Half</label></div>';
                let isSecondHalfCheckbox = '<div class="d-flex align-items-center c-gap-2"> <input class="form-check-input" type="radio" name="' + $(this).attr('name').replace('IsHalf', 'halfType') + '" id="' + $(this).attr('id').replace('IsHalf', 'IsSecondHalf') + '" value="secondHalf"><label class="m-0" for="' + $(this).attr('id').replace('IsHalf', 'IsFirstHalf') + '"> Second Half</label></div></div>';
                parentDiv.append(isFirstHalfCheckbox  + isSecondHalfCheckbox);
            } else {
                $('.'+$(this).attr('name').replace('IsHalf', 'halfType')).remove();
            }

        });

        function ajaxForFloaterHolidayList(){
            $.ajax({
                url: getFloaters,
                type: 'POST',
                datatype: 'json',
                success: function (floaterData) {
                    const floaterDays = JSON.parse(floaterData).data;

                    // Create a new <select> element
                    const floaterSelectElement = $('<select>').attr('id', namespace+'floaterDays');
                    floaterSelectElement.attr('class','form-control custom-select mr-sm-2');
                    floaterSelectElement.attr('name', namespace+'floaterDays');

                    // Add options to the <select> element
                    floaterSelectElement.append('<option value="">--Select Floater Day--</option>');
                    $.each(floaterDays, function(i,item) {
                        floaterSelectElement.append( '<option value="'
                            + item.date
                            + '">'
                            + item.holidayName
                            + '</option>' );
                    });


                    // Add the new <select> element to the page
                    if(remainingLeave != 0.0)
                        floaterDaysContainer.empty().append('<label>Restricted Holiday<span class="text-danger">*</span></label>').append(floaterSelectElement);

                    // Add validation rule dynamically
                    floaterSelectElement.rules("add", {
                        required: true,
                        messages: {
                            required: "Please select a restricted holiday."
                        }
                    });

                    hideEndDateContainer();
                    hideStartDateContainer();
                    hideDateInputContainer();
                    
                    // Attach an event handler to the dynamic select element
                    floaterSelectElement.on('change', function() {
                    	if (!isApplicableForFloater) {
                            let floaterField = $('#' + namespace + 'floaterDays');
                            if (floaterField.length) {
                                floaterField.rules("remove");
                            }
                        }

                        let floaterDate = $('#'+namespace+'floaterDays').val();

                        if(floaterDate != ""){
                        	if (!$('#floaterDateLabel').length) {
                                $('<label>', {
                                    id: 'floaterDateLabel',
                                    text: 'Date'
                                }).insertBefore(dateInputsContainer);
                            }
                            startDate.val(formatDateForInput(new Date(floaterDate)));
                            endDate.val(formatDateForInput(new Date(floaterDate)));
                            showDateInputContainer();
                        }else{
 	                       
                            setBlankStartDate();
                            setBlankEndDate();
                        }

                        if(validEndDateOrNot()) {

                            dynamicDateCreator();
                            dayTypeSelectContainer.hide();
                            hideDayTypeSelectContainer();
                            showDateInputContainer();
                        }
                    });
                },
                error: function (xhr, status, error) {
                    console.log("Something wrong !!! when call Floater Ajax....");
                }
            });
        }

//        function teamIdMultiSelect(){
//            localStorage.clear();
//
//            let getTeamIds = () => {
//                return JSON.parse(localStorage.getItem('selectedOptions'));
//            }
//
//            let teamIdStrings = "";
//            let setTeamIdString = () => {
//                let teamIds = getTeamIds();
//                if (teamIds !== null) {
//                    teamIdStrings = teamIds.join(',');
//                }
//                else
//                    teamIdStrings = "";
//            }
//            let setTeamIdInParams = () => {
//                setTeamIdString();
//                let teamIdElement = document.getElementById(namespace+"teamId");
//                teamIdElement.value = teamIdStrings;
//            }
//
//            $(document).ready(function() {
//                const mySelect = $('#mySelect');
//                const selectedOptionsContainer = $('#selectedOptionsContainer');
//                let selectedValues = JSON.parse(localStorage.getItem('selectedOptions') || '[]');
//
//                function updateSelectedOptions() {
//
//                    const isAlreadyInArray = selectedValues.includes($(this).val());
//                    console.log($(this).val());
//
//                    mySelect.find('option:selected').each(function() {
//                        if(!isAlreadyInArray && $(this).val() !== ""){
//                            selectedValues.push($(this).val());
//                        }
//                    });
//                    localStorage.setItem('selectedOptions', JSON.stringify(selectedValues));
//                    renderSelectedOptions();
//                }
//
//                function getTeamIdString(){
//                    return teamIdString;
//                }
//
//                // ⭐⭐⭐ THIS FUNCTION IS UPDATED ⭐⭐⭐
//                function renderSelectedOptions() {
//                    selectedOptionsContainer.empty(); // Clear previous options
//
//                    selectedValues = JSON.parse(localStorage.getItem('selectedOptions') || '[]');
//
//                    for (const value of selectedValues) {
//
//                        const selectedOptionElement = $('<div>').addClass('selected-option');
//
//                        // ⭐ NEW CODE: Get option TEXT instead of value
//                        const text = $('#mySelect option[value="' + value + '"]').text();
//
//                        const span = $('<span>').text(text); // show text instead of ID
//
//                        const closeButton = $('<button>').text('x'); // Close icon
//
//                        closeButton.click(function() {
//                            const index = selectedValues.indexOf(value);
//                            selectedValues.splice(index, 1);
//                            localStorage.setItem('selectedOptions', JSON.stringify(selectedValues));
//                            console.log(JSON.stringify(selectedValues));
//                            renderSelectedOptions();
//                            if(selectedValues.length == 0) {
//                                localStorage.clear();
//                            }
//                            setTeamIdInParams();
//                        });
//
//                        selectedOptionElement.append(span, closeButton);
//                        selectedOptionsContainer.append(selectedOptionElement);
//                    }
//                }
//                // ⭐⭐⭐ END UPDATED renderSelectedOptions() ⭐⭐⭐
//
//                // Bind events
//                mySelect.change(updateSelectedOptions);
//                window.onload = renderSelectedOptions;
//                mySelect.change(setTeamIdInParams);
//            });
//        }

        function teamIdMultiSelect(){

            let getTeamIds = () => {
                return JSON.parse(localStorage.getItem('selectedOptions') || '[]');
            };

            let setTeamIdInParams = () => {
                let teamIds = getTeamIds();
                let teamIdElement = document.getElementById(namespace+"teamId");
                teamIdElement.value = teamIds.join(',');
            };

            $(document).ready(function() {
                  localStorage.removeItem('selectedOptions');

                const mySelect = $('#mySelect');
                const selectedOptionsContainer = $('#selectedOptionsContainer');

                let selectedValues = getTeamIds();

                function renderSelectedOptions() {

                    selectedOptionsContainer.empty();

                    selectedValues = getTeamIds();

                    selectedValues.forEach(function(value){

                        const selectedOptionElement = $('<div>').addClass('selected-option');

                        const text = $('#mySelect option[value="' + value + '"]').text();

                        const span = $('<span>').text(text);

                        const closeButton = $('<button type="button">').text('x');

                        closeButton.click(function(){

                            selectedValues = selectedValues.filter(v => v !== value);

                            localStorage.setItem('selectedOptions', JSON.stringify(selectedValues));

                            renderSelectedOptions();
                            setTeamIdInParams();
                        });

                        selectedOptionElement.append(span, closeButton);
                        selectedOptionsContainer.append(selectedOptionElement);
                    });
                }

                function updateSelectedOptions() {

                    let value = $(this).val();

                    if(value && !selectedValues.includes(value)){
                        selectedValues.push(value);
                        localStorage.setItem('selectedOptions', JSON.stringify(selectedValues));
                        renderSelectedOptions();
                        setTeamIdInParams();
                    }

                    $(this).val('');
                }

                mySelect.off('change').on('change', updateSelectedOptions);

                renderSelectedOptions();
                setTeamIdInParams();
            });
        }

        teamIdMultiSelect();


        //When Hr Select Employee then this ajax call
        employeeNames.change(function () {
            let changedEmployeeId = employeeNames.val();
            employeeId.val(changedEmployeeId);

            $.ajax({
                url: getEmployeeLeavesData,
                type: 'POST',
                datatype: 'json',
                data:{
                    [namespace+'employeeId']: employeeId.val()
                },
                success: function (employeeLeaveTypeDetails) {
                    const resObj = JSON.parse(employeeLeaveTypeDetails);
                    const employeeLeaveTypeData = resObj.data;

                    leaveType.empty();

                    leaveType.append('<option>--Select Leave Type--</option>');
                    $.each(employeeLeaveTypeData, function(i,item) {
                        console.log(item);
                        leaveType.append( '<option value="'
                            + item.leaveTypeId
                            + '" data-remaining-leaves="'
                            +parseFloat(item.noOfRemainingLeaves)
                            +'" data-is-continuous="'
                            +item.isContinuous
                            +'" data-is-applicable-floater="'
                            +item.applicableFloater
                            +'">'
                            +item.leaveType
                            + '</option>' );

                    });
                },
                error: function (xhr, status, error) {
                    console.log("Something wrong !!! when call Ajax....");
                }
            });
        });

    }
    function setConfigsForCancelLeaveRequest(config) {
        namespace = config.namespace;
        console.log(config);
        let url = config.cancelUrl;
        url = url.replace('LEAVE_REQUEST_ID', config.leaveRequestId);
         window.location.href = url;
    }

    AxEmployeeLeaveManagement.setConfigs = setConfigs;
    AxEmployeeLeaveManagement.setConfigsForCancelLeaveRequest = setConfigsForCancelLeaveRequest;

})($, (window.AxEmployeeLeaveManagement = window.AxEmployeeLeaveManagement || {}));