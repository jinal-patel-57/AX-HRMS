<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<portlet:actionURL name="/addEditEmployeeEducationURL" var="addEditEmployeeEducationURL"/>
<form id="educationStepperForm" action="${addEditEmployeeEducationURL}" method="post">
    <div class="card-header">
        <strong>
            <liferay-ui:message key="education-details"/>
        </strong>
    </div>
    <div class="card-body">
        <c:if test="${employeeDetail.employeeType == 'intern' || employeeDetail.employeeType == 'contractor'}">
            <div class="alert alert-info">
                You are not required to fill this data! You can proceed with the further process!
            </div>
        </c:if>
        <c:if test="${employeeDetail.employeeType != 'intern' && employeeDetail.employeeType != 'contractor'}">

            <div id="education-section-container">
                <c:if test="${educationListSize <= 0 }">
                    <div class="education-section" id="initial-education-section">
                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-4 col-sm-12 mb-3">
                                        <div class="form-group">
                                            <label for="levelName1" class="form-label"> <liferay-ui:message
                                                    key="level-name"/><span class="text-danger">*</span>
                                            </label>
                                            <!-- Dropdown menu for Select a Education Level Name selection -->
                                            <select id="<portlet:namespace/>levelName1"
                                                    name="<portlet:namespace/>levelName1"
                                                    class="form-select">
                                                <option value="">Select a Education Level Name</option>
                                                <c:forEach var="educationLevelMaster"
                                                           items="${educationLevelMastersList}">
                                                    <option value="${educationLevelMaster.educationLevelMasterId}">
                                                            ${educationLevelMaster.levelName}</option>
                                                    <!-- Use countryId as the value attribute -->
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-4 col-sm-12 mb-3">
                                        <div class="form-group">

                                            <label for="institution1" class="form-label"> <liferay-ui:message
                                                    key="institution"/><span class="text-danger">*</span>
                                            </label> <input type="text" class="form-control"
                                                            id="<portlet:namespace />institution1"
                                                            name="<portlet:namespace />institution1"
                                                            maxlength="250"/>
                                        </div>
                                    </div>
                                    <div class="col-md-4 col-sm-12 mb-3">
                                        <div class="form-group">

                                            <label for="degree1" class="form-label"> <liferay-ui:message key="degree"/><span class="text-danger">*</span>
                                            </label> <input type="text" class="form-control"
                                                            id="<portlet:namespace />degree1"
                                                            name="<portlet:namespace />degree1" maxlength="75"/>
                                        </div>

                                    </div>

                                    <div class="col-md-4 col-sm-12 mb-3">
                                        <div class="form-group">

                                            <label for="startDate1" class="form-label"> <liferay-ui:message
                                                    key="start-date"/><span class="text-danger">*</span>
                                            </label> <input type="date" class="form-control"
                                                            id="<portlet:namespace />startDate1"
                                                            name="<portlet:namespace />startDate1"
                                        />
                                        </div>

                                    </div>
                                    <div class="col-md-4 col-sm-12 mb-3">
                                        <div class="form-group">

                                            <label for="endDate1" class="form-label"> <liferay-ui:message
                                                    key="end-date"/><span class="text-danger">*</span>
                                            </label> <input type="date" class="form-control"
                                                            id="<portlet:namespace />endDate1"
                                                            name="<portlet:namespace />endDate1"/>
                                        </div>
                                    </div>
                                    <div class="col-md-4 col-sm-12 mb-3">
                                        <div class="form-group">

                                            <label for="passingYear1" class="form-label"> <liferay-ui:message
                                                    key="passing-year"/><span class="text-danger">*</span>
                                            </label> <input type="text" class="form-control"
                                                            id="<portlet:namespace />passingYear1"
                                                            name="<portlet:namespace />passingYear1"
                                                            maxlength="4"/>
                                        </div>
                                    </div>
                                    <input type="hidden" id="educationCurrentIndex"
                                           name="<portlet:namespace/>educationCurrentIndex"
                                           value="1"/>
                                    <input type="hidden" id="firstVisitEducation"
                                           name="<portlet:namespace/>firstVisitEducation"
                                           value="true"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>
                <c:if test="${educationListSize > 0 }">
                    <c:forEach items="${educationList}" var="educationItem" varStatus="status">
                        <div class="education-section" id="initial-education-section">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-4 col-sm-12 mb-3">
                                            <div class="form-group">
                                                <label for="levelName1" class="form-label"> <liferay-ui:message
                                                        key="level-name"/><span class="text-danger">*</span>
                                                </label>
                                                <!-- Dropdown menu for Select a Education Level Name selection -->
                                                <select id="<portlet:namespace/>levelName${status.index+1}"
                                                        name="<portlet:namespace/>levelName${status.index+1}"
                                                        class="form-select">
                                                    <option value="">Select a Education Level Name</option>
                                                    <c:forEach var="educationLevelMaster"
                                                               items="${educationLevelMastersList}">
                                                        <option value="${educationLevelMaster.educationLevelMasterId}" ${educationItem.levelId == educationLevelMaster.educationLevelMasterId ? 'selected' : ''}>
                                                                ${educationLevelMaster.levelName}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-4 col-sm-12 mb-3">
                                            <div class="form-group">

                                                <label for="institution1" class="form-label"> <liferay-ui:message
                                                        key="institution"/><span class="text-danger">*</span>
                                                </label> <input type="text" class="form-control"
                                                                value="${educationItem.institution}"
                                                                id="<portlet:namespace />institution${status.index+1}"
                                                                name="<portlet:namespace />institution${status.index+1}"
                                                                maxlength="250"/>
                                            </div>
                                        </div>
                                        <div class="col-md-4 col-sm-12 mb-3">
                                            <div class="form-group">

                                                <label for="degree1" class="form-label"> <liferay-ui:message
                                                        key="degree"/><span class="text-danger">*</span>
                                                </label> <input type="text" class="form-control"
                                                                id="<portlet:namespace />degree${status.index+1}"
                                                                name="<portlet:namespace />degree${status.index+1}"
                                                                maxlength="75" value="${educationItem.degree}"/>
                                            </div>

                                        </div>

                                        <div class="col-md-4 col-sm-12 mb-3">
                                            <div class="form-group">

                                                <label for="startDate1" class="form-label"> <liferay-ui:message
                                                        key="start-date"/><span class="text-danger">*</span>
                                                </label> <input type="date" class="form-control"
                                                                id="<portlet:namespace />startDate${status.index+1}"
                                                                name="<portlet:namespace />startDate${status.index+1}"
                                                                value="<fmt:formatDate value='${educationItem.startDate}' pattern='yyyy-MM-dd'/>"
                                            />
                                            </div>
                                        </div>
                                        <div class="col-md-4 col-sm-12 mb-3">
                                            <div class="form-group">

                                                <label for="endDate1" class="form-label"> <liferay-ui:message
                                                        key="end-date"/><span class="text-danger">*</span>
                                                </label> <input type="date" class="form-control"
                                                                id="<portlet:namespace />endDate${status.index+1}"
                                                                name="<portlet:namespace />endDate${status.index+1}"
                                                                value="<fmt:formatDate value='${educationItem.endDate}' pattern='yyyy-MM-dd'/>"
                                            />
                                            </div>
                                        </div>
                                        <div class="col-md-4 col-sm-12 mb-3">
                                            <div class="form-group">

                                                <label for="passingYear1" class="form-label"> <liferay-ui:message
                                                        key="passing-year"/><span class="text-danger">*</span>
                                                </label> <input type="text" class="form-control"
                                                                id="<portlet:namespace />passingYear${status.index+1}"
                                                                name="<portlet:namespace />passingYear${status.index+1}"
                                                                maxlength="4"
                                                                value="${educationItem.passingYear}"/>
                                            </div>
                                        </div>

                                        <portlet:actionURL var="deleteEmployeeEducationURL"
                                                           name="/deleteEmployeeEducationURL">
                                            <portlet:param name="educationId" value="${educationItem.educationId}"/>
                                        </portlet:actionURL>


                                        <input type="hidden" id="educationCurrentIndex"
                                               name="<portlet:namespace/>educationCurrentIndex"
                                               value="${status.index+1}"/>
                                        <input type="hidden" id="firstVisitEducation"
                                               name="<portlet:namespace/>firstVisitEducation"
                                               value="true"/>
                                    </div>
                                </div>
                                <div class="card-footer text-right">
                                    <a href="${deleteEmployeeEducationURL}" id="delete-education-action-link"
                                       class="btn btn-outline-danger delete-section"><i class="icon-trash"></i></a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
            </div>

        <!-- Plus button to add new section -->
        <button class="btn btn-outline-success" type="button" id="add-education-section"><i class="icon-plus"></i>
        </button>
        </c:if>
        <input type="hidden" name="<portlet:namespace/>employeeId" value="${employeeId}">

        <!-- Navigation buttons -->

    </div>
    <div class="card-footer text-right align-items-center">
        <c:if test="${employeeDetail.employeeType != 'intern' && employeeDetail.employeeType != 'contractor'}">
            <button class="btn btn-outline-primary previous-button" type="button">Previous</button>
            <button class="btn btn-outline-primary next-button next-button-education-details" type="button">Next</button>
        </c:if>

        <c:if test="${employeeDetail.employeeType == 'intern' || employeeDetail.employeeType == 'contractor'}">
            <button class="btn btn-outline-success" type="button" id="add-education-section" hidden="hidden"><i class="icon-plus"></i>
            </button>
            <button class="btn btn-outline-primary previous-button" type="button">Previous</button>
            <button id="noactionbtnEducation" class="btn btn-outline-primary  next-button-education-details-no-action" type="button">Next</button>
        </c:if>

    </div>
</form>