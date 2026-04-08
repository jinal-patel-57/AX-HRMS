<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.ax.hrms.work.from.home.web.employee.dto.WFHRequestDto" %>

<!-- Set WFH DTO using JSTL instead of scriptlet -->
<c:set var="wfh" value="${requestScope.wfh}" />

<!-- BACK URL -->
<portlet:renderURL var="backURL">
    <portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<div class="card">
    <div class="card-header">
        <strong>
            View Work From Home Request
        </strong>
    </div>

    <div class="card-body">

        <!-- FIRST ROW -->
        <div class="row">

            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                <div class="form-group-view">
                    <div class="label-name">Employee Name</div>
                    <div class="label-content">${wfh.employeeName}</div>
                </div>
            </div>

            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                <div class="form-group-view">
                    <div class="label-name">Employee Official Mail ID</div>
                    <div class="label-content email">
                        ${wfh.employeeOfficialMailId}
                    </div>
                </div>
            </div>

            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                <div class="form-group-view">
                    <div class="label-name">Team IDs</div>
                    <div class="label-content email">
                        ${wfh.teamMailId} <br/>
                    </div>
                </div>
            </div>

        </div>

        <!-- SECOND ROW -->
        <div class="row">

            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                <div class="form-group-view">
                    <div class="label-name">Status</div>
                    <div class="label-content">${wfh.status}</div>
                </div>
            </div>
             <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                            <div class="form-group-view">
                                <div class="label-name">No. of Days</div>
                                <div class="label-content">${wfh.noOfDays}</div>
                            </div>
                        </div>

            <c:if test="${not empty wfh.reason}">
                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                    <div class="form-group-view">
                        <div class="label-name">Reason</div>
                        <div class="label-content">${wfh.reason}</div>
                    </div>
                </div>
            </c:if>

        </div>

        <!-- WFH SUMMARY SECTION (Exactly Like Leave Summary) -->

        <div class="row mt-3">
            <div class="col-12 col-md-6">
                <div class="card">
                    <div class="card-header">
                        <strong>
                            Work From Home Summary
                        </strong>
                    </div>

                    <div class="card-body">
                        <table class="table">
                            <thead>
                                <tr>
                                    <td>
                                        <p class="text-center my-0">
                                            <b>Date</b>
                                        </p>
                                    </td>
                                    <td>
                                        <p class="text-center my-0">
                                            <b>Day</b>
                                        </p>
                                    </td>
                                    <td>
                                        <p class="text-center my-0">
                                            <b>Day Type</b>
                                        </p>
                                    </td>
                                </tr>
                            </thead>

                            <tbody>

                                <c:forEach var="wfhDay" items="${wfh.wfhDayTypeList}">
                                    <tr>

                                        <!-- Date -->
                                        <td>
                                            <fmt:formatDate
                                                value="${wfhDay.workFromHomeDate}"
                                                pattern="dd-MMM-yyyy"
                                                var="formattedWFHDate"/>
                                            <p class="text-center my-0">
                                                ${formattedWFHDate}
                                            </p>
                                        </td>

                                        <!-- Day Type -->
                                        <td>
                                            <p class="text-center my-0">
                                                ${wfhDay.isHalfDay() ? "Half Day" : "Full Day"}
                                            </p>
                                        </td>

                                        <!-- Half Type -->
                                        <td>
                                            <p class="text-center my-0">
                                                <c:choose>
                                                    <c:when test="${wfhDay.isHalfDay()}">
                                                        ${wfhDay.isFirstHalf() ? "First Half" : "Second Half"}
                                                    </c:when>
                                                    <c:otherwise>
                                                        -
                                                    </c:otherwise>
                                                </c:choose>
                                            </p>
                                        </td>

                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
        </div>

    </div>

    <div class="card-footer text-right align-items-center">
        <a href="${backURL}" class="btn btn-outline-danger">
            Back
        </a>
    </div>
</div>
