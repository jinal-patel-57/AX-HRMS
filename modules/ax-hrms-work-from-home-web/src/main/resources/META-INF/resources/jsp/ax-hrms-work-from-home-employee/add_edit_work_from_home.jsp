<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    boolean isEdit = (request.getAttribute("wfh") != null);
    com.ax.hrms.model.WorkFromHome wfh =
            (com.ax.hrms.model.WorkFromHome) request.getAttribute("wfh");


    request.setAttribute("isEdit", isEdit);


    java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
%>

<!-- SESSION ERROR MESSAGES -->
<liferay-ui:error key="start-date-invalid" message="Start Date cannot be empty"/>
<liferay-ui:error key="end-date-invalid" message="End Date cannot be empty"/>
<liferay-ui:error key="end-before-start" message="End Date must be after Start Date"/>
<liferay-ui:error key="email-invalid" message="Please enter a valid Team Mail ID"/>
<liferay-ui:error key="reason-min-char-invalid" message="Reason must be at least 10 characters"/>
<liferay-ui:error key="reason-max-char-invalid" message="Reason must be less than 250 characters"/>
<liferay-ui:error key="empty-fields" message="Please fill all required fields"/>

<!-- SUCCESS MESSAGE -->
<liferay-ui:success key="wfh-added" message="Work From Home request added successfully!" />
<liferay-ui:success key="wfh-updated" message="Work From Home request updated successfully!" />

<!-- FORM ACTION -->
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

            <!-- TEAM MAIL ID -->
            <div class="form-group">
                <label>Team Mail ID <span class="text-danger">*</span></label>
                <input type="email"
                       id="email"
                       name="<portlet:namespace/>teamMailId"
                       class="form-control"
                       value="<%= isEdit ? wfh.getTeamMailId() : "" %>"
                       required />
                <small class="text-danger" id="emailError"></small>
            </div>

            <!-- REASON -->
            <div class="form-group">
                <label>Reason <span class="text-danger">*</span></label>
                <textarea class="form-control"
                          id="reason"
                          name="<portlet:namespace/>reason"
                          rows="3"
                          required><%= isEdit ? wfh.getReason() : "" %></textarea>
                <small class="text-danger" id="reasonError"></small>
            </div>

            <!-- START DATE -->
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

            <!-- END DATE -->
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

        <!-- FOOTER BUTTONS -->
        <div class="card-footer text-right">
            <portlet:renderURL var="backURL">
               <portlet:param name="mvcRenderCommandName" value="/" />
            </portlet:renderURL>

            <a href="${backURL}" class="btn btn-outline-danger">Back</a>
            <button class="btn btn-outline-success" type="submit">
                <%= isEdit ? "Update" : "Submit" %>
            </button>
        </div>
    </form>
</div>

<!-- FRONTEND JAVASCRIPT VALIDATION -->
<script>
    document.addEventListener("DOMContentLoaded", function () {

        const email = document.getElementById("email");
        const reason = document.getElementById("reason");
        const startDate = document.getElementById("startDate");
        const endDate = document.getElementById("endDate");

        // Prevent past date selection
        const today = new Date().toISOString().split("T")[0];
        startDate.min = today;
        endDate.min = today;

        // ---------------- EMAIL VALIDATION ----------------
        email.addEventListener("blur", function () {
            const pattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!pattern.test(email.value)) {
                document.getElementById("emailError").innerText = "Invalid email format.";
            } else {
                document.getElementById("emailError").innerText = "";
            }
        });

        // ---------------- REASON VALIDATION ----------------
        reason.addEventListener("blur", function () {
            if (reason.value.length < 10) {
                document.getElementById("reasonError").innerText = "Minimum 10 characters required.";
            } else if (reason.value.length > 250) {
                document.getElementById("reasonError").innerText = "Maximum 250 characters allowed.";
            } else {
                document.getElementById("reasonError").innerText = "";
            }
        });

        // ---------------- DATE VALIDATION ----------------
        function validateDates() {
            const start = new Date(startDate.value);
            const end = new Date(endDate.value);

            if (!startDate.value) {
                document.getElementById("startError").innerText = "Start Date is required.";
            } else {
                document.getElementById("startError").innerText = "";
            }

            if (!endDate.value) {
                document.getElementById("endError").innerText = "End Date is required.";
            } else if (end < start) {
                document.getElementById("endError").innerText = "End Date must be after Start Date.";
            } else {
                document.getElementById("endError").innerText = "";
            }
        }

        startDate.addEventListener("blur", validateDates);
        endDate.addEventListener("blur", validateDates);

        // FINAL FORM VALIDATION BEFORE SUBMIT
        document.getElementById("wfhForm").addEventListener("submit", function (event) {
            validateDates();

            if (
                document.getElementById("emailError").innerText ||
                document.getElementById("reasonError").innerText ||
                document.getElementById("startError").innerText ||
                document.getElementById("endError").innerText
            ) {
                event.preventDefault();
            }
        });

    });
</script>
