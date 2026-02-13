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
                <label>Team Mail ID <span class="text-danger">*</span></label>
                <input type="text"
                       id="email"
                       name="<portlet:namespace/>teamMailId"
                       class="form-control"
                       value="<%= isEdit ? wfh.getTeamMailId() : "" %>"
                        />
                <small class=" text-muted">
                    Multiple email IDs can be entered, separated by commas.
                </small>

                <small class="text-danger d-block mt-1" id="emailError"></small>
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

    const email = document.getElementById("email");
    const reason = document.getElementById("reason");
    const startDate = document.getElementById("startDate");
    const endDate = document.getElementById("endDate");
    const submitBtn = document.getElementById("submitBtn");

    const emailError = document.getElementById("emailError");
    const reasonError = document.getElementById("reasonError");
    const startError = document.getElementById("startError");
    const endError = document.getElementById("endError");

    let startTouched = false;
    let endTouched = false;








    /* ---------------- EMAIL VALIDATION ---------------- */
    function validateEmail() {

        const value = email.value.trim();

        if (!value) {
            emailError.innerText = "Team Mail ID is required.";
            return false;
        }

        // Split by comma
        const emails = value.split(",");

        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        const uniqueEmails = new Set();
        let invalidFound = false;

        emails.forEach(function (mail) {
            const trimmed = mail.trim().toLowerCase();

            if (!trimmed) {
                invalidFound = true;
                return;
            }

            if (!emailRegex.test(trimmed)) {
                invalidFound = true;
                return;
            }

            uniqueEmails.add(trimmed);
        });

        if (invalidFound) {
            emailError.innerText =
                "Please enter valid email addresses separated by commas.";
            return false;
        }

        // Remove duplicates & normalize value
        email.value = Array.from(uniqueEmails).join(",");

        emailError.innerText = "";
        return true;
    }

    /* ---------------- REASON VALIDATION ---------------- */
    function validateReason() {
        const len = reason.value.trim().length;

        if (!reason.value.trim()) {
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

    /* ---------------- DATE VALIDATION ---------------- */
    function validateDates(showAll = false) {
        let valid = true;
        const today = new Date();

        // Validate Start Date
        if (startTouched || showAll) {
            if (!startDate.value) {
                startError.innerText = "Start Date is required.";
                valid = false;
            } else {
                const date = new Date(startDate.value);
                const prevMonth = new Date(today.getFullYear(), today.getMonth() - 1, 1);
                const currMonthEnd = new Date(today.getFullYear(), today.getMonth() + 1, 0);
                
                if (date < prevMonth) {
                    startError.innerText = "Start date cannot be earlier than the previous month";
                    valid = false;
                } else if (date > currMonthEnd) {
                    startError.innerText = "Start date cannot be in future months beyond the current month";
                    valid = false;
                } else {
                    startError.innerText = "";
                }
            }
        }

        // Validate End Date
        if (endTouched || showAll) {
            if (!endDate.value) {
                endError.innerText = "End Date is required.";
                valid = false;
            } else {
                const date = new Date(endDate.value);
                const yearEnd = new Date(today.getFullYear(), 11, 31);
                
                if (date > yearEnd) {
                    endError.innerText = "End date cannot be beyond December 31 of the current year";
                    valid = false;
                } else if (startDate.value && date < new Date(startDate.value)) {
                    endError.innerText = "End Date must be after Start Date";
                    valid = false;
                } else {
                    endError.innerText = "";
                }
            }
        }

        return valid;
    }

    /* ---------------- EVENT LISTENERS ---------------- */
    email.addEventListener("blur", validateEmail);
    reason.addEventListener("blur", validateReason);

    startDate.addEventListener("blur", function () {
        startTouched = true;
        validateDates();
    });

    startDate.addEventListener("change", function () {
        validateDates(); // do NOT force end date error
    });

    endDate.addEventListener("blur", function () {
        endTouched = true;
        validateDates();
    });

    endDate.addEventListener("change", function () {
        endTouched = true;
        validateDates();
    });

    /* ---------------- FINAL SUBMIT ----------------
    form.addEventListener("submit", function (event) {

        startTouched = true;
        endTouched = true;

        const isEmailValid = validateEmail();
        const isReasonValid = validateReason();
        const isDateValid = validateDates(true);

        if (!isEmailValid || !isReasonValid || !isDateValid) {
            event.preventDefault();
        }
    });*/


    form.addEventListener("submit", function (event) {

        event.preventDefault();

        startTouched = true;
        endTouched = true;

        const isEmailValid = validateEmail();
        const isReasonValid = validateReason();
        const isDateValid = validateDates(true);

        if (isEmailValid && isReasonValid && isDateValid) {
            submitBtn.disabled = true;
            submitBtn.innerText = "Submitting...";
            form.submit();
        }
    });


  /*  form.addEventListener("submit", function (event) {

        event.preventDefault();

        startTouched = true;
        endTouched = true;

        const isEmailValid = validateEmail();
        const isReasonValid = validateReason();
        const isDateValid = validateDates(true);

        if (isEmailValid && isReasonValid && isDateValid) {
            form.submit(); // manual submit
        }
    }); */
});



 $(document).ready(function () {

 // Apply WFH-specific date restrictions
 function applyWFHDateRestriction(element, isStartDate) {
     if (!element) return;

     const today = new Date();
     const currentYear = today.getFullYear();
     const currentMonth = today.getMonth();
     
     if (isStartDate) {
         // Start Date: Previous month to current month
         const previousMonthStart = new Date(currentYear, currentMonth - 1, 1);
         const currentMonthEnd = new Date(currentYear, currentMonth + 1, 0);
         
         const minDate = previousMonthStart.toISOString().split('T')[0];
         const maxDate = currentMonthEnd.toISOString().split('T')[0];
         
         element.setAttribute('min', minDate);
         element.setAttribute('max', maxDate);
     } else {
         // End Date: Any date up to December 31 of current year
         const minDate = new Date(currentYear, 0, 1).toISOString().split('T')[0];
         const maxDate = `${currentYear}-12-31`;
         
         element.setAttribute('min', minDate);
         element.setAttribute('max', maxDate);
     }

     // Prevent manual year input exceeding 4 digits
     element.addEventListener('input', function () {
         const val = this.value;
         if (val) {
             const parts = val.split('-');
             if (parts[0] && parts[0].length > 4) {
                 parts[0] = parts[0].substring(0, 4);
                 this.value = parts.join('-');
             }
         }
     });
 }

  const startDate = document.getElementById("startDate");
     const endDate = document.getElementById("endDate");

                 if (startDate) {
                     applyWFHDateRestriction(startDate, true); // true = is start date
                 }
                 if (endDate) {
                     applyWFHDateRestriction(endDate, false); // false = is end date
                 }



 });
</script>

