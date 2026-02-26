<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.liferay.portal.kernel.util.*" %>

<style>
#wfhDateInputsContainer .form-control {
    width: 48%;
}

</style>

<%
    boolean isEdit = (request.getAttribute("wfh") != null);
    com.ax.hrms.model.WorkFromHomeRequest wfh =
            (com.ax.hrms.model.WorkFromHomeRequest) request.getAttribute("wfh");


    request.setAttribute("isEdit", isEdit);


    java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
%>

<%
String currentURL = PortalUtil.getCurrentURL(request);
%>

<portlet:actionURL name="executeMigration" var="executeMigrationURL">
        <portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:actionURL>
<!-- SESSION ERROR MESSAGES -->
<liferay-ui:error key="start-date-invalid" message="Start Date cannot be empty"/>
<liferay-ui:error key="end-date-invalid" message="End Date cannot be empty"/>
<liferay-ui:error key="end-before-start" message="End Date must be after Start Date"/>
<liferay-ui:error key="email-invalid" message="Please enter a valid Team Mail ID"/>
<liferay-ui:error key="reason-min-char-invalid" message="Reason must be at least 10 characters"/>
<liferay-ui:error key="reason-max-char-invalid" message="Reason must be less than 250 characters"/>
<liferay-ui:error key="empty-fields" message="Please fill all required fields"/>
<liferay-ui:error key="email-invalid" message="One or more email addresses are invalid." />

<liferay-ui:success key="wfh-added" message="Work From Home request added successfully!" />
<liferay-ui:success key="wfh-updated" message="Work From Home request updated successfully!" />

<portlet:actionURL name="/addEditWFH" var="saveWFHURL" />

<div class="card mt-3">
    <div class="card-header">
        <strong><%= isEdit ? "Edit Work From Home Request" : "Add Work From Home Request" %></strong>
    </div>

    <form id="wfhForm" action="${saveWFHURL}" method="post" >
        <div class="card-body">
		   <div class="row">

            <c:if test="${isEdit}">
                <input type="hidden"
                       name="<portlet:namespace/>workFromHomeRequestId"
                       value="<%= wfh.getWorkFromHomeRequestId() %>"/>
            </c:if>
			
			<div class="col-12">
				<div class="form-group">
				  <label>Team <span class="text-danger">*</span></label>

				  <select id="mySelect" name="<portlet:namespace />wfhTeamIdSelectBox"
						  class="form-control custom-select mr-sm-2">

					  <option value="">Select Employee</option>

					  <c:forEach var="employeeDetailsList" items="${employeeDetailsList}">
						  <option value="${employeeDetailsList.getOfficialEmail()}">
							  ${employeeDetailsList.employeeCode} -
							  ${employeeDetailsList.getFirstName()}
							  ${employeeDetailsList.getLastName()}
						  </option>
					  </c:forEach>

				  </select>

				  <input type="hidden"
						 id="<portlet:namespace />teamId"
						 name="<portlet:namespace />teamId"/>

				  <div id="selectedOptionsContainer" class="selected-options mt-2"></div>

				  <small class="text-danger d-block mt-1" id="teamError"></small>
				</div>
			</div>

			<div class="col-12">
				<div class="form-group">
					<label>Reason <span class="text-danger">*</span></label>
					<textarea class="form-control"
							  id="reason"
							  name="<portlet:namespace/>reason"
							  rows="3"
							  ><%= isEdit ? wfh.getReason() : "" %></textarea>
					<small class="text-danger" id="reasonError"></small>
				</div>
			</div>

			<div class="col-sm-12 col-md-6 col-lg-6">
				<div class="form-group">
					<label>Start Date <span class="text-danger">*</span></label>
					<input type="date"
						   id="startDate"
						   class="form-control"
						   name="<portlet:namespace/>startDate"
						   value="<%= isEdit ? df.format(wfh.getStartDate()) : "" %>"
						   />
					<small class="text-danger" id="startError"></small>
				</div>
			</div>

			<div class="col-sm-12 col-md-6 col-lg-6">
				<div class="form-group">
					<label>End Date <span class="text-danger">*</span></label>
					<input type="date"
						   id="endDate"
						   class="form-control"
						   name="<portlet:namespace/>endDate"
						   value="<%= isEdit ? df.format(wfh.getEndDate()) : "" %>"
							/>
					<small class="text-danger" id="endError"></small>
				</div>
			</div>
			<div class="col-sm-12 col-md-8 col-lg-8">
				<div class="form-group">
					<div id="wfhDateInputsContainer" style="display:none;"></div>
				</div>
			</div>
		  </div>
        </div>

        <div class="card-footer text-right">
            <portlet:renderURL var="backURL">
               <portlet:param name="mvcRenderCommandName" value="/" />
            </portlet:renderURL>

            <a href="${backURL}" class="btn btn-outline-danger">Back</a>
            <button class="btn btn-outline-success" type="submit" id="submitBtn">
                <%= isEdit ? "Update" : "Submit" %>
            </button>
        </div>
    </form>
</div>
<script>
document.addEventListener("DOMContentLoaded", function () {

    const form = document.getElementById("wfhForm");


    const reason = document.getElementById("reason");
    const startDate = document.getElementById("startDate");
    const endDate = document.getElementById("endDate");
    const submitBtn = document.getElementById("submitBtn");
    const namespace = '<portlet:namespace />';
    const dateInputsContainer = $('#wfhDateInputsContainer');


    const reasonError = document.getElementById("reasonError");
    const startError = document.getElementById("startError");
    const endError = document.getElementById("endError");




const today = new Date();
const prevMonthStart = new Date(today.getFullYear(), today.getMonth() - 1, 1);
const yearEnd = new Date(today.getFullYear(), 11, 31);

function formatDate(date) {
    const year = date.getFullYear();
    const month = ('0' + (date.getMonth() + 1)).slice(-2);
    const day = ('0' + date.getDate()).slice(-2);
    return year + '-' + month + '-' + day;
}

$("#startDate, #endDate").attr({
    min: formatDate(prevMonthStart),
    max: formatDate(yearEnd)
});




$.validator.addMethod("noWeekend", function(value) {
    if (!value) return true;
    const day = new Date(value + "T00:00:00").getDay();
    return day !== 0 && day !== 6;
}, "Saturday and Sunday are not allowed.");

$.validator.addMethod("greaterThanStart", function(value) {
    const start = $("#startDate").val();
    if (!start || !value) return true;
    return new Date(value) >= new Date(start);
}, "End Date must be after Start Date.");

function validateTeamField() {
    let teamValue = $("#" + ns + "teamId").val();

    if (!teamValue || teamValue.trim() === "") {
        $("#teamError").text("Please select at least one team member.");
        return false;
    } else {
        $("#teamError").text("");
        return true;
    }
}
$.validator.addMethod("validReason", function(value, element) {
    return this.optional(element) ||
        /^(?=.*[a-zA-Z])[a-zA-Z0-9\s.,'()\/-]+$/.test(value);
}, "Reason must contain at least one letter and no special characters.");


const ns = '<portlet:namespace />';

$("#wfhForm").validate({

  ignore: [],

    rules: {
        [ns + "reason"]: {
            required: true,
            minlength: 10,
            maxlength: 250,
            validReason: true
        },
        [ns + "startDate"]: {
            required: true,
            noWeekend: true
        },
        [ns + "endDate"]: {
            required: true,
            noWeekend: true,
            greaterThanStart: true
        },
        [ns + "teamId"]: {
            required: true
        }
    },

    messages: {
        [ns + "teamId"]: {
            required: "Please select at least one team member."
        }
    },

    errorElement: "small",
    errorClass: "text-danger",
     onkeyup: false,


    errorPlacement: function(error, element) {


            error.insertAfter(element);

    },

    highlight: function(element) {
        $(element).addClass("is-invalid");
    },

    unhighlight: function(element) {
        $(element).removeClass("is-invalid");
    },

   submitHandler: function(form) {

       let isTeamValid = validateTeamField();

       if (!isTeamValid) {
           return false;
       }

       submitBtn.disabled = true;
       form.submit();
   }
});


let startDateTouched = false;
let endDateTouched = false;

$("#startDate").on("focus", function () {
    startDateTouched = true;
});

$("#endDate").on("focus", function () {
    endDateTouched = true;
});

$("#startDate, #endDate").on("blur", function () {

    let startValid = true;
    let endValid = true;

    if (startDateTouched) {
        startValid = $("#startDate").valid();
    }

    if (endDateTouched) {
        endValid = $("#endDate").valid();
    }

    // Generate only if both fields touched and valid
    if (
        startDateTouched &&
        endDateTouched &&
        startValid &&
        endValid &&
        $("#startDate").val() &&
        $("#endDate").val()
    ) {
        dynamicDateCreator();
    } else {
        dateInputsContainer.empty();
        dateInputsContainer.hide();
    }
});




function wfhTeamMultiSelect(){


    const storageKey = namespace + "wfhSelectedOptions";

    let getTeamIds = () => {
        return JSON.parse(localStorage.getItem(storageKey) || '[]');
    };

    let setTeamIdInParams = () => {
        let teamIds = getTeamIds();
        let teamIdElement = document.getElementById(namespace + "teamId");
        teamIdElement.value = teamIds.join(',');

    };

    localStorage.removeItem(storageKey);

    const wfhSelect = $('#mySelect');
    const wfhContainer = $('#selectedOptionsContainer');

    let wfhSelectedValues = getTeamIds();

    function renderSelectedOptions() {

        wfhContainer.empty();

        wfhSelectedValues = getTeamIds();

        wfhSelectedValues.forEach(function(value){

            const selectedOptionElement = $('<div>').addClass('selected-option');

            const text = $('#mySelect option[value="' + value + '"]').text();

            const span = $('<span>').text(text);

            const closeButton = $('<button type="button">').text('x');

            closeButton.click(function(){

                wfhSelectedValues = wfhSelectedValues.filter(v => v !== value);

                localStorage.setItem(storageKey, JSON.stringify(wfhSelectedValues));

                renderSelectedOptions();
                setTeamIdInParams();
                 $("#" + namespace + "teamId").valid();
            });

            selectedOptionElement.append(span, closeButton);
            wfhContainer.append(selectedOptionElement);
        });
    }

    function updateSelectedOptions() {

        let value = $(this).val();

        if(value && !wfhSelectedValues.includes(value)){
            wfhSelectedValues.push(value);
            localStorage.setItem(storageKey, JSON.stringify(wfhSelectedValues));
            renderSelectedOptions();
            setTeamIdInParams();

             $("#" + namespace + "teamId").valid();
        }

        $(this).val('');
    }

    wfhSelect.off('change').on('change', updateSelectedOptions);




    renderSelectedOptions();
    setTeamIdInParams();
}

wfhTeamMultiSelect();





function dynamicDateCreator() {

    let startDateValue = $('#startDate').val();
    let endDateValue = $('#endDate').val();

    if (!startDateValue || !endDateValue) return;

    dateInputsContainer.empty();

    let start = new Date(startDateValue + "T00:00:00");
    let end = new Date(endDateValue + "T00:00:00");

    let current = new Date(start);

    while (current <= end) {

        let day = ('0' + current.getDate()).slice(-2);
        let month = ('0' + (current.getMonth() + 1)).slice(-2);
        let year = current.getFullYear();
        let dateString = year + '-' + month + '-' + day;

        if (current.getDay() !== 0 && current.getDay() !== 6) {

            const dateContainer = $('<div>')
                .addClass('d-flex align-items-center c-gap-4 mb-3');

            const dateDiv = $('<input>')
                .attr('type', 'date')
                .addClass('form-control')
                .val(dateString)
                .prop('readOnly', true)
                .attr('name', namespace + 'wfhDate');

            const checkboxName = namespace + 'day' + dateString.replaceAll('-', '') + 'IsHalf';

            const halfCheckbox = $('<input>')
                .attr('type', 'checkbox')
                .attr('name', checkboxName);

            const halfLabel = $('<label>')
                .text(' Is Half Day')
                .addClass('my-0 ml-1');

            const wrapper = $('<div>')
                .addClass('dayTypeSelectContainer d-flex align-items-center')
                .append(halfCheckbox)
                .append(halfLabel);

            dateContainer.append(dateDiv);
            dateContainer.append(wrapper);

            dateInputsContainer.append(dateContainer);
        }

        current.setDate(current.getDate() + 1);
    }

    dateInputsContainer.show();
}

dateInputsContainer.on('change', 'input[type="checkbox"]', function () {

    let isChecked = $(this).is(':checked');
    let parentDiv = $(this).parent();

    if (isChecked) {

        let isFirstHalf = '<div class="d-flex align-items-center c-gap-2 ml-4 '
            + $(this).attr('name').replace('IsHalf', 'halfType') + '">'
            + '<div class="d-flex align-items-center c-gap-2">'
            + '<input class="form-check-input" type="radio" name="'
            + $(this).attr('name').replace('IsHalf', 'halfType')
            + '" value="firstHalf" checked/>'
            + '<label class="m-0"> First Half</label></div>';

        let isSecondHalf = '<div class="d-flex align-items-center c-gap-2">'
            + '<input class="form-check-input" type="radio" name="'
            + $(this).attr('name').replace('IsHalf', 'halfType')
            + '" value="secondHalf"/>'
            + '<label class="m-0"> Second Half</label></div></div>';

        parentDiv.append(isFirstHalf + isSecondHalf);

    } else {
        $('.' + $(this).attr('name').replace('IsHalf', 'halfType')).remove();
    }
});




});
</script>