<%@ include file="/init.jsp" %>


<liferay-portlet:renderURL var="pipProgramFormURL">
    <portlet:param name="mvcRenderCommandName" value="/pipProgramForm"/>
</liferay-portlet:renderURL>

<liferay-ui:error key="error-already-exist" message="Appraisal Status Already Exist!"/>
<liferay-ui:success key="success" message="Appraisal Status Successfully Added!"/>
<liferay-ui:success key="success-delete" message="Appraisal Status Successfully Deleted!"/>
<liferay-ui:success key="success-edit" message="Appraisal Status Successfully Edited!"/>

<div class="card">
    <div class="card-header  d-flex justify-content-between align-items-center">
        <strong>
            PIP Program Employees
        </strong>
        <a href="${pipProgramFormURL}" class="btn btn-primary"><liferay-ui:message key="add-pip-employee"/></a>
    </div>
    <div class="card-body">
        <!-- start -->
        <liferay-portlet:renderURL varImpl="iteratorURL"/>

        <liferay-ui:search-container deltaConfigurable="${true}" total="${count}" searchContainer="${pipProgramSC}"
                                     delta="4">
            <liferay-ui:search-container-results results="${pipProgramSC.results}"/>

            <liferay-ui:search-container-row className="com.ax.hrms.pip.program.web.dto.PipProgramEmployeeDto"
                                             modelVar="pipProgram" keyProperty="pipProgramId">
                <liferay-ui:search-container-column-text name="employee-name" value="${pipProgram.getEmployeeName()}"/>
                <liferay-ui:search-container-column-text name="start-date" value="${pipProgram.getStartDate()}"/>
                <liferay-ui:search-container-column-text name="end-date" value="${pipProgram.getEndDate()}"/>
                <liferay-ui:search-container-column-text name="status" value="${pipProgram.getStatus()}"/>
                <liferay-ui:search-container-column-text name="meeting-date" value="${pipProgram.getMeetingDate()}"/>
                <liferay-ui:search-container-column-text name="no-of-months" value="${pipProgram.getNoOfMonths()}"/>

                <liferay-ui:search-container-column-text name="actions">
                    <c:if test="${pipProgram.getStatus() == 'Active' || pipProgram.getStatus() == 'Extended'}">

                        <liferay-portlet:actionURL var="endPipProgramURL" name="/endPipProgram">
                            <portlet:param name="pipProgramId" value="${pipProgram.pipProgramId}"/>
                        </liferay-portlet:actionURL>
                        <liferay-portlet:actionURL var="terminatePipEmployeeURL" name="/terminatePipEmployee">
                            <portlet:param name="pipProgramId" value="${pipProgram.pipProgramId}"/>
                        </liferay-portlet:actionURL>
                        <liferay-portlet:renderURL var="extendPipProgramFormURL">
                            <portlet:param name="mvcRenderCommandName" value="/extendPipProgram"/>
                            <portlet:param name="pipProgramId" value="${pipProgram.pipProgramId}"/>
                        </liferay-portlet:renderURL>
                        <liferay-portlet:renderURL var="demotePipEmployeeURL">
                            <portlet:param name="mvcRenderCommandName" value="/demotePipEmployee"/>
                            <portlet:param name="pipProgramId" value="${pipProgram.pipProgramId}"/>
                        </liferay-portlet:renderURL>


                        <div class="dropdown">
                            <button class="btn fa fa-ellipsis-v dropdown-toggle"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="icon-ellipsis-vertical"></i>
                            </button>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="${terminatePipEmployeeURL}"
                                       onclick="return confirm('You Are going to terminate ${appraisalStatusMaster.status}')"
                                       class="dropdown-item"><i class="icon-minus-sign"></i> Terminate</a>
                                </li>
                                <li>
                                    <a href="${endPipProgramURL}"
                                       onclick="return confirm('You sure you want to end PIP?')"
                                       class="dropdown-item"><i class="icon-signout"></i> End
                                        PIP</a>
                                </li>
                                <li>
                                    <a href="${demotePipEmployeeURL}" class="dropdown-item"><i
                                            class="icon-sort-by-attributes-alt"></i> Demote</a>
                                </li>
                                <c:if test="${pipProgram.getStatus() != 'Extended'}">
                                    <li>
                                        <a href="${extendPipProgramFormURL}"
                                           class="dropdown-item"><i class="icon-refresh"></i> Extend</a>
                                    </li>
                                </c:if>
                            </ul>
                        </div>


                    </c:if>
                </liferay-ui:search-container-column-text>
            </liferay-ui:search-container-row>
            <liferay-ui:search-iterator paginate="${true}" markupView="lexicon" searchContainer="${pipProgramSC}"/>
        </liferay-ui:search-container>

    </div>
</div>

<script>
    $(document).ready(function () {
        var config = new Object({}),
            namespace = '<portlet:namespace />';

        config.namespace = namespace;

        AxPipProgramWebPortlet.setConfigs(config);
    });
</script>

