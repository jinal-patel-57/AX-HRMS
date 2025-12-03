<%@ include file="/init.jsp" %>
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:if test="${isOnBoarded}">
    <div class="alert alert-warning">You are not authorized to Access this page anymore!
    </div>
</c:if>


<head>
    <style>
        /*=== Start Tabing boostrape overwrite styling ===*/
        .nav-pills .nav-item .nav-link {
            padding: 16px 5px;
            font-size: 16px;
            font-weight: 400;
            line-height: 30px;
            letter-spacing: 0em;
            color: #666666;
            text-transform: capitalize;
            position: relative;
        }

        .nav-pills .nav-item {
            padding: 0 20px;
        }

        .nav-pills .nav-item .nav-link {
            line-height: 16px;
        }

        .nav-pills .nav-item .nav-link.active {
            color: #D03059;
            background: none;
        }

        .nav-pills .nav-item .nav-link.active:after {
            position: absolute;
            left: 0;
            width: 100%;
            bottom: -1px;
            height: 2px;
            background: #D03059;
            content: "";
        }

        .nav-pills.justify-content-center .nav-item {
            border-bottom: 1px solid #EEEEEE;
        }

        .nav-pills.justify-content-center .nav-item:first-child {
            padding-left: 0;
        }

        .nav-pills.justify-content-center .nav-item:last-child {
            padding-right: 0;
        }

        /*=== End Tabing boostrape overwrite styling===*/
    </style>
</head>


<c:if test="${!isOnBoarded}">
    <div id="employeeOnBorading">
        <div class="container mt-3">
            <!-- Navigation tabs -->
            <ul class="nav nav-pills" id="stepperNav" role="tablist">
                <li class="nav-item" role="presentation">
                    <button class="nav-link active" id="step1-tab" data-bs-toggle="tab" data-bs-target="#step1"
                            type="button" role="tab" aria-controls="step1" aria-selected="true">
                        <liferay-ui:message key="basic-details"/>
                    </button>
                </li>
                <li class="nav-item" role="presentation">
                    <button class="nav-link" id="step2-tab" data-bs-toggle="tab" data-bs-target="#step2" type="button"
                            role="tab" aria-controls="step2" aria-selected="false">
                        <liferay-ui:message key="address-details"/>
                    </button>
                </li>
                <li class="nav-item" role="presentation">
                    <button class="nav-link" id="step3-tab" data-bs-toggle="tab" data-bs-target="#step3" type="button"
                            role="tab" aria-controls="step3" aria-selected="false">
                        <liferay-ui:message key="education-details"/>
                    </button>
                </li>
                <li class="nav-item" role="presentation">
                    <button class="nav-link" id="step4-tab" data-bs-toggle="tab" data-bs-target="#step4" type="button"
                            role="tab" aria-controls="step4" aria-selected="false">
                        <liferay-ui:message key="experience-details"/>
                    </button>
                </li>
                <li class="nav-item" role="presentation">
                    <button class="nav-link" id="step5-tab" data-bs-toggle="tab" data-bs-target="#step5" type="button"
                            role="tab" aria-controls="step5" aria-selected="false">
                        <liferay-ui:message key="bank-accounts-details"/>
                    </button>
                </li>
                <li class="nav-item" role="presentation">
                    <button class="nav-link" id="step6-tab" data-bs-toggle="tab" data-bs-target="#step6" type="button"
                            role="tab" aria-controls="step6" aria-selected="false">
                        <liferay-ui:message key="uan-esic-details"/>
                    </button>
                </li>
                <li class="nav-item" role="presentation">
                    <button class="nav-link" id="step7-tab" data-bs-toggle="tab" data-bs-target="#step7" type="button"
                            role="tab" aria-controls="step7" aria-selected="false">
                        <liferay-ui:message key="nominee-details"/>
                    </button>
                </li>
            </ul>

            <div class="tab-content" id="stepperContent">
                <!-- Step 1 -->
                <div class=" tab-pane mt-4 fade show active" name="step1" id="step1" role="tabpanel"
                     aria-labelledby="step1-tab">
                    <div class="card">
                        <jsp:include page="/jsp/ax-hrms-employee-onboarding-employee/employeeBasicDetails.jsp"
                                     flush="true"/>
                    </div>

                </div>

                <!-- step 2 -->
                <div class=" tab-pane mt-4 fade" name="step2" id="step2" role="tabpanel" aria-labelledby="step2-tab">
                    <div class="card">
                        <jsp:include page="/jsp/ax-hrms-employee-onboarding-employee/employeeAddress.jsp" flush="true"/>
                    </div>
                </div>

                <!-- Step 3 -->
                <div class=" tab-pane mt-4 fade" id="step3" name="step3" role="tabpanel" aria-labelledby="step3-tab">
                    <div class="card">

                        <jsp:include page="/jsp/ax-hrms-employee-onboarding-employee/employeeEducation.jsp"
                                     flush="true"/>
                    </div>

                </div>

                <!-- Step 4 -->
                <div class=" tab-pane mt-4 fade" id="step4" name="step4" role="tabpanel" aria-labelledby="step4-tab">
                    <div class="card">

                        <jsp:include page="/jsp/ax-hrms-employee-onboarding-employee/employeeExperience.jsp"
                                     flush="true"/>
                            <%-- <jsp:include page="/jsp/ax-hrms-employee-onboarding-employee/test.jsp" flush="true"/> --%>
                    </div>
                </div>

                <!-- Step 5 -->
                <div class=" tab-pane mt-4 fade" id="step5" name="step5" role="tabpanel" aria-labelledby="step5-tab">
                    <div class="card">

                        <jsp:include page="/jsp/ax-hrms-employee-onboarding-employee/employeeBankDetails.jsp"
                                     flush="true"/>
                    </div>

                </div>

                <!-- Step 6 -->
                <div class=" tab-pane mt-4 fade" id="step6" name="step6" role="tabpanel" aria-labelledby="step6-tab">
                    <div class="card">

                        <jsp:include page="/jsp/ax-hrms-employee-onboarding-employee/employeeUanEsicDetails.jsp"
                                     flush="true"/>
                    </div>
                </div>

                <!-- Step 7 -->
                <div class=" tab-pane mt-4 fade" id="step7" name="step7" role="tabpanel" aria-labelledby="step7-tab">
                    <div class="card">

                        <jsp:include page="/jsp/ax-hrms-employee-onboarding-employee/employeeNomineeDetails.jsp"
                                     flush="true"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:if>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.20.0/jquery.validate.min.js"
        integrity="sha512-WMEKGZ7L5LWgaPeJtw9MBM4i5w5OSBlSjTjCtSnvFJGSVD26gE5+Td12qN5pvWXhuWaWcVwF++F7aqu9cvqP0A=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
    $(document).ready(function () {
        var config = new Object({}),
            namespace = '<portlet:namespace />';
        educationList = '${educationListSize}';
        profilePicName = '${profilePicName}';
        educationIndex = '${EdCurIndex}';
        experienceIndex = '${ExperienceCurIndex}';

        config.getEmployeeUrl = '${showEmployeeOnBoardingStatusUrl}';
        var getEmployeeUrl = config.getEmployeeUrl;
        config.namespace = namespace;
        config.educationList = educationList;

        AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForValidation(config);
        AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForAddressValidation(config);
        AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForEducationValidation(config);
        AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForExperienceValidation(config);
        AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForBankAccountValidation(config);
        AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForUanEsicValidation(config);
        AxHrmsEmployeeOnboardingEmployeeWebPortlet.setConfigsForNomineeValidation(config);
    });
</script>