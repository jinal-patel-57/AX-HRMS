<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.liferay.portal.kernel.util.*" %>

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

    <form id="wfhForm" action="${saveWFHURL}" method="post">
        <div class="card-body">

            <c:if test="${isEdit}">
                <input type="hidden"
                       name="<portlet:namespace/>workFromHomeRequestId"
                       value="<%= wfh.getWorkFromHomeRequestId() %>"/>
            </c:if>

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

            <div class="form-group">
                <label>Reason <span class="text-danger">*</span></label>
                <textarea class="form-control"
                          id="reason"
                          name="<portlet:namespace/>reason"
                          rows="3"
                          ><%= isEdit ? wfh.getReason() : "" %></textarea>
                <small class="text-danger" id="reasonError"></small>
            </div>

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


    const reasonError = document.getElementById("reasonError");
    const startError = document.getElementById("startError");
    const endError = document.getElementById("endError");

    let startTouched = false;
    let endTouched = false;

    const today = new Date();

    // 1st of previous month
    const prevMonthStart = new Date(today.getFullYear(), today.getMonth() - 1, 1);

    // 31st December of current year
    const yearEnd = new Date(today.getFullYear(), 11, 31);

    function isWeekend(dateStr) {
        if (!dateStr) return false;
        const day = new Date(dateStr + "T00:00:00").getDay(); // 0 = Sun, 6 = Sat
        return day === 0 || day === 6;
    }

    function nextMonday(dateStr) {
        const d = new Date(dateStr + "T00:00:00");
        const day = d.getDay();
        // Saturday → +2, Sunday → +1
        const daysToAdd = day === 6 ? 2 : 1;
        d.setDate(d.getDate() + daysToAdd);
        return d.toLocaleDateString("en-CA"); // returns YYYY-MM-DD
    }

    function applyWFHDateRestriction(element) {
        if (!element) return;

        const minDate = prevMonthStart.toLocaleDateString("en-CA");
        const maxDate = yearEnd.toLocaleDateString("en-CA");

        element.setAttribute("min", minDate);
        element.setAttribute("max", maxDate);
        element.min = minDate;
        element.max = maxDate;

        // Prevent manual invalid year typing
        element.addEventListener("input", function () {
            const val = this.value;
            if (val) {
                const parts = val.split("-");
                if (parts[0] && parts[0].length > 4) {
                    parts[0] = parts[0].substring(0, 4);
                    this.value = parts.join("-");
                }
            }
        });
    }

    // Apply restriction to both date fields
    applyWFHDateRestriction(startDate);
    applyWFHDateRestriction(endDate);



    function validateReason() {
        const value = reason.value.trim();
        const len = value.length;

        if (!value) {
            reasonError.innerText = "Reason is required.";
            return false;
        } else if (len < 10) {
            reasonError.innerText = "Reason must be at least 10 characters.";
            return false;
        } else if (len > 250) {
            reasonError.innerText = "Reason must not exceed 250 characters.";
            return false;
        }

        reasonError.innerText = "";
        return true;
    }

    function validateDates(showAll = false) {
        let valid = true;

        if (startTouched || showAll) {
            if (!startDate.value) {
                startError.innerText = "Start Date is required.";
                valid = false;
            } else if (isWeekend(startDate.value)) {
                startError.innerText =
                    "Start Date cannot be a weekend. Please choose a weekday.";
                valid = false;
            } else {
                startError.innerText = "";
            }
        }

        if (endTouched || showAll) {
            if (!endDate.value) {
                endError.innerText = "End Date is required.";
                valid = false;
            } else if (isWeekend(endDate.value)) {
                endError.innerText =
                    "End Date cannot be a weekend. Please choose a weekday.";
                valid = false;
            } else if (
                startDate.value &&
                new Date(endDate.value + "T00:00:00") <
                    new Date(startDate.value + "T00:00:00")
            ) {
                endError.innerText = "End Date must be after Start Date.";
                valid = false;
            } else {
                endError.innerText = "";
            }
        }

        return valid;
    }


    reason.addEventListener("blur", validateReason);

    startDate.addEventListener("blur", function () {
        startTouched = true;
        validateDates();
    });

    endDate.addEventListener("blur", function () {
        endTouched = true;
        validateDates();
    });

    form.addEventListener("submit", function (event) {
        event.preventDefault();

        startTouched = true;
        endTouched = true;

       const isTeamValid = validateWFHTeam();
        const isReasonValid = validateReason();
        const isDateValid = validateDates(true);

        if (isTeamValid && isReasonValid && isDateValid) {
            submitBtn.disabled = true;
            form.submit();
        }
    });

function wfhTeamMultiSelect(){

    const namespace = '<portlet:namespace />';
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
        }

        $(this).val('');
    }

    wfhSelect.off('change').on('change', updateSelectedOptions);

    // Validation
    window.validateWFHTeam = function(){
        if(wfhSelectedValues.length === 0){
            $('#teamError').text("Please select at least one team member.");
            return false;
        }
        $('#teamError').text("");
        return true;
    };

    renderSelectedOptions();
    setTeamIdInParams();
}

wfhTeamMultiSelect();

});
</script>