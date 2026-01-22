<%@ include file="/init.jsp"%>

<portlet:renderURL var="branchForm">
     <portlet:param name="mvcRenderCommandName" value="/fetchBranchDetails"/>
</portlet:renderURL>

<liferay-ui:success key="branch-added" message="Branch added successfully." />
<liferay-ui:success key="branch-updated" message="Branch updated successfully." />
<liferay-ui:success key="branch-deleted" message="Branch deleted successfully." />

<liferay-portlet:renderURL varImpl="iteratorURL" />

<div class="card">
    <div class="card-header text-right">
        <a href="${branchForm}" class="btn btn-primary btn-sm">
            Add Branch
        </a>
    </div>

    <div class="card-body">
       <liferay-ui:search-container
           total="${branchCount}"
           iteratorURL="${iteratorURL}"
           delta="20"
           emptyResultsMessage="No Branch Found">

           <liferay-ui:search-container-results
               results="${branchList}" />

           <liferay-ui:search-container-row
               className="com.ax.hrms.master.branch.web.dto.BranchDto"
               modelVar="branch"
               keyProperty="branchMasterId">

                <liferay-ui:search-container-column-text
                    name="Branch Name"
                    value="${branch.branchName}" />

                <liferay-ui:search-container-column-text
                    name="Address"
                    value="${branch.address}" />
                <liferay-ui:search-container-column-text
                    name="City"
                    value="${branch.city}" />
                <liferay-ui:search-container-column-text
                    name="State"
                    value="${branch.state}" />
                <liferay-ui:search-container-column-text
                    name="Country"
                    value="${branch.country}" />

                <liferay-ui:search-container-column-text
                    name="Actions"
                    cssClass="text-center">

                    <portlet:renderURL var="viewURL">
                        <portlet:param name="mvcRenderCommandName"
                                       value="/viewBranchDetails" />
                        <portlet:param name="branchMasterId"
                                       value="${branch.branchMasterId}" />
                    </portlet:renderURL>

                    <portlet:renderURL var="editURL">
                        <portlet:param name="mvcRenderCommandName"
                                       value="/fetchBranchDetails" />
                        <portlet:param name="branchMasterId"
                                       value="${branch.branchMasterId}" />
                    </portlet:renderURL>

                    <portlet:actionURL var="deleteURL"
                        name="/deleteBranch">
                        <portlet:param name="branchMasterId"
                                       value="BRANCH_ID" />
                    </portlet:actionURL>

                    <div class="dropdown">
                      <button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" ><i class="icon-ellipsis-vertical"></i>
                      					</button>
                        <ul class="dropdown-menu">
                            <li>
                                <a class="dropdown-item" href="${viewURL}">
                                    View
                                </a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="${editURL}">
                                    Edit
                                </a>
                            </li>
                            <li>
                                <a class="dropdown-item"
                                   onclick="deleteBranch('${branch.branchMasterId}')">
                                    Delete
                                </a>
                            </li>
                        </ul>
                    </div>

                </liferay-ui:search-container-column-text>

            </liferay-ui:search-container-row>

            <liferay-ui:search-iterator />
        </liferay-ui:search-container>
    </div>
</div>

<script>
function deleteBranch(branchId) {
    AxBranchMasterWebPortlet.setConfigsForDelete({
        branchId: branchId,
        deleteURL: '${deleteURL}'
    });
}
</script>
