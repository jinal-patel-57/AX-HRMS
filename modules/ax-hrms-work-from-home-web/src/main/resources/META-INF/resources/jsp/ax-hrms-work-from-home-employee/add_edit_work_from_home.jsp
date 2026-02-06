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
                       required />
                <small class="text-danger" id="emailError"></small>
            </div>

            <div class="form-group">
                <label>Reason <span class="text-danger">*</span></label>
                <textarea class="form-control"
                          id="reason"
                          name="<portlet:namespace/>reason"
                          rows="3"
                          required><%= isEdit ? wfh.getReason() : "" %></textarea>
                <small class="text-danger" id="reasonError"></small>
            </div>

            <div class="form-group">
                <label>Start Date <span class="text-danger">*</span></label>
                <input type="date"
                       id="startDate"
                       class="form-control"
                       name="<portlet:namespace/>startDate"
                       value="<%= isEdit ? df.format(wfh.getStartDate()) : "" %>"
                       required />
                <small class="text-danger" id="startError"></small>
            </div>

            <div class="form-group">
                <label>End Date <span class="text-danger">*</span></label>
                <input type="date"
                       id="endDate"
                       class="form-control"
                       name="<portlet:namespace/>endDate"
                       value="<%= isEdit ? df.format(wfh.getEndDate()) : "" %>"
                       required />
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

        if (!email.value.trim()) {
            emailError.innerText = "Team Mail ID is required.";
            return false;
        }

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

        // START DATE
        if ((startTouched || showAll) && !startDate.value) {
            startError.innerText = "Start Date is required.";
            valid = false;
        } else {
            startError.innerText = "";
        }

        // END DATE
        if (endTouched || showAll) {
            if (!endDate.value) {
                endError.innerText = "End Date is required.";
                valid = false;
            } else if (
                startDate.value &&
                new Date(endDate.value) < new Date(startDate.value)
            ) {
                endError.innerText = "End Date must be after Start Date.";
                valid = false;
            } else {
                endError.innerText = "";
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
</script>

