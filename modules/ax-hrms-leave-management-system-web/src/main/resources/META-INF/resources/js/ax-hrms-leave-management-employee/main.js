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
        function showMessage(newMessage) {
            Liferay.Util.openToast({
                title: 'Info',
                message: newMessage,
                type: 'info',
                autoClose: 10000
            });
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

                //Create div for inputed dates: Line to Line
                const dateDiv = $('<input>').attr('type', 'date');
                dateDiv.attr('class','form-control');
                dateDiv.attr('id',namespace+'day'+day+'Date');
                dateDiv.attr('name',namespace+'day'+day+'Date');
                dateDiv.attr('value',dateString);
                dateDiv.prop('readOnly',true);

                //Create Input element for select Half-day or Full-day
                const halfTypeDiv = $('<input>').attr('type','checkbox');
                halfTypeDiv.attr('name',namespace+'day'+day+'IsHalf');
                halfTypeDiv.attr('id',namespace+'day'+day+'IsHalf');

                const dayTypeSelectContainerDiv = $('<div>').attr('id','dayTypeSelectContainer');
                dayTypeSelectContainerDiv.attr('class','dayTypeSelectContainer');
                dayTypeSelectContainer = $('#dayTypeSelectContainer');

                dayTypeSelectContainerDiv.append(halfTypeDiv);
                dayTypeSelectContainerDiv.append("Is Half leave");

                if (date.getDay() !== 0 && date.getDay() !== 6) {
                    dateInputsContainer.append(dateDiv);
                    dateInputsContainer.append(dayTypeSelectContainerDiv);
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
                showMessage("Please enter date");
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
                    showMessage("Start date must be before End date");
                    setBlankEndDate();
                }
            }else{
                setDisabledSubmitBtn();
                showMessage("Enter both dates...");
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
                    validLetters: true
                },
                [namespace + "startDate"]: {
                    required: true,
                    validDate: true
                },
                [namespace + "endDate"]: {
                    required: true,
                    validDate: true
                },
            },
            messages: {
                [namespace + "leaveType"]: {
                    required: "Select Leave type"
                },
                [namespace + "reason"]: {
                    required: "Enter Reason For leave",
                    validLetters: "Enter Valid Letters"
                }
            },
            errorPlacement: function (error, element) {
                error.insertAfter(element);
            }
        });

        $.validator.addMethod("validLetters", function (value, element) {
            return this.optional(element) || /^[a-zA-Z0-9.\s]+$/.test(value);
        }, "Please enter letters only");

        jQuery.validator.addMethod("validDate", function (value, element) {
            let now = new Date();
            let selectedDate = new Date(value);
            let firstDateOfMonth = undefined;
            // Set the selected date's time to 00:00:00 to compare only dates, not times
            selectedDate.setHours(0, 0, 0, 0);

            // Get the first date of the current month
            if($('#'+namespace+'hrStatus').val())
                firstDateOfMonth = new Date(now.getFullYear(), now.getMonth()-1, 1);
            else
                firstDateOfMonth = new Date(now.getFullYear(), now.getMonth(), 1);
            // Compare the selected date with the first date of the current month
            return selectedDate >= firstDateOfMonth;
        }, "Enter a valid date (on or before the first day of the month).");
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
            remainingLeavesPar.text('Remaining leaves: ' + remainingLeave);
            if(remainingLeave == "" || remainingLeave == undefined)
                remainingLeavesPar.text('')

            dateInputsContainer.empty();

            if(remainingLeave != 0 && leaveType.val() !== ""){
                setEnabledSubmitBtn();
                setEditableStartDate();
                setEditableEndDate();
                setEditableReason();
            }
            else{
                if(leaveType.val() !== "")
                    showMessage("Not enough leave balance");
                setDisabledSubmitBtn();
                setReadOnlyStartDate();
                setReadOnlyEndDate();
            }

            // After change Leave Type if leave type is floater then run this if...else...
            if(isApplicableForFloater){
                hideStartDateContainer();
                hideEndDateContainer();
                setReadOnlyReason();
                setBlankStartDate();
                setBlankEndDate();
                ajaxForFloaterHolidayList();
            }
            else{
                floaterDaysContainer.empty();
                setBlankStartDate();
                setBlankEndDate();
                showStartDateContainer();
                showEndDateContainer();
                setEditableReason();
            }

            // After change Leave Type if leave type is Continuous then run this if...else...
            if(isContinuous){
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

        endDate.on('change',function(){
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
                            if(remainingLeave/0.5 == daysDiff){
                                showMessage("You can select all half days for the given range.");
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
                            showMassege("Not enough leave balance")
                        }
                    }
                }else {
                    showMessage("your selected days is higher than your leave balance")
                    setDisabledSubmitBtn();
                    dateInputsContainer.empty();
                }
            }else{
                showMessage("Please select require Dates");
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
                let isFirstHalfCheckbox = '<div class="'+$(this).attr('name').replace('IsHalf', 'halfType')+'"><input type="radio" name="' + $(this).attr('name').replace('IsHalf', 'halfType') + '" id="' + $(this).attr('id').replace('IsHalf', 'IsFirstHalf') + '" value="firstHalf" checked/> First Half';
                let isSecondHalfCheckbox = '<input type="radio" name="' + $(this).attr('name').replace('IsHalf', 'halfType') + '" id="' + $(this).attr('id').replace('IsHalf', 'IsSecondHalf') + '" value="secondHalf"> Second Half</div>';
                parentDiv.append(isFirstHalfCheckbox + '<br>' + isSecondHalfCheckbox);
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
                    floaterSelectElement.attr('class','custom-select mr-sm-2');

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
                        floaterDaysContainer.empty().append(floaterSelectElement);

                    hideEndDateContainer();
                    hideStartDateContainer();
                    hideDateInputContainer();

                    // Attach an event handler to the dynamic select element
                    floaterSelectElement.on('change', function() {
                        let floaterDate = $('#'+namespace+'floaterDays').val();

                        if(floaterDate != ""){
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

        //Multiple Team id select if inform with team
        function teamIdMultiSelect(){
            localStorage.clear();

            let getTeamIds = () => {
                return JSON.parse(localStorage.getItem('selectedOptions'));
            }

            let teamIdStrings = "";
            let setTeamIdString = () => {
                let teamIds = getTeamIds();
                if (teamIds !== null) {
                    teamIdStrings = teamIds.join(',');
                }
                else
                    teamIdStrings = "";
            }
            let setTeamIdInParams = () => {
                setTeamIdString();
                let teamIdElement = document.getElementById(namespace+"teamId");
                teamIdElement.value = teamIdStrings;
            }

            $(document).ready(function() {
                const mySelect = $('#mySelect');
                const selectedOptionsContainer = $('#selectedOptionsContainer');
                let selectedValues = JSON.parse(localStorage.getItem('selectedOptions') || '[]');
                function updateSelectedOptions() {

                    const isAlreadyInArray = selectedValues.includes($(this).val());
                    console.log($(this).val());

                    mySelect.find('option:selected').each(function() {
                        if(!isAlreadyInArray && $(this).val() !== ""){
                            selectedValues.push($(this).val());
                        }
                    });
                    localStorage.setItem('selectedOptions', JSON.stringify(selectedValues));
                    renderSelectedOptions();
                }

                function getTeamIdString(){
                    return teamIdString;
                }

                function renderSelectedOptions() {
                    selectedOptionsContainer.empty(); // Clear previous options

                    selectedValues = JSON.parse(localStorage.getItem('selectedOptions') || '[]');

                    for (const value of selectedValues) {
                        const selectedOptionElement = $('<div>').addClass('selected-option');
                        const span = $('<span>').text(value);
                        const closeButton = $('<button>').text('*'); // Close icon (multiply sign)

                        closeButton.click(function() {
                            const index = selectedValues.indexOf(value);
                            selectedValues.splice(index, 1);
                            localStorage.setItem('selectedOptions', JSON.stringify(selectedValues));
                            console.log(JSON.stringify(selectedValues));
                            renderSelectedOptions();
                            if(selectedValues.length == 0) {
                                localStorage.clear();
                            }
                            setTeamIdInParams();
                        });
                        selectedOptionElement.append(span, closeButton);
                        selectedOptionsContainer.append(selectedOptionElement);
                    }
                }

                // Bind `change` event to capture multiple selections
                mySelect.change(updateSelectedOptions);
                window.onload = renderSelectedOptions;
                mySelect.change(setTeamIdInParams);// Render initial options from localStorage
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
        if (confirm('Are you sure you want to Cancel ?'))
            window.location.href = url;
    }

    AxEmployeeLeaveManagement.setConfigs = setConfigs;
    AxEmployeeLeaveManagement.setConfigsForCancelLeaveRequest = setConfigsForCancelLeaveRequest;

})($, (window.AxEmployeeLeaveManagement = window.AxEmployeeLeaveManagement || {}));