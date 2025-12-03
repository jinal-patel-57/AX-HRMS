<%@ include file="/init.jsp" %>
<%@page import="com.ax.hrms.master.model.AppraisalStatusMaster" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:renderURL var="appraisalStatusForm">
  <portlet:param name="mvcPath" value="/jsp/appraisal-status-master/addEditAppraisalStatusMaster.jsp" />
</portlet:renderURL>

<liferay-ui:error key="error-already-exist" message="Appraisal Status Already Exist!" />
<liferay-ui:success key="success" message="Appraisal Status Successfully Added!" />
<liferay-ui:success key="success-delete" message="Appraisal Status Successfully Deleted!" />
<liferay-ui:success key="success-edit" message="Appraisal Status Successfully Edited!" />

<div class="card">
  <div class="card-header d-flex align-items-center justify-content-end"><a href="${appraisalStatusForm}" class="btn btn-primary btn-sm"><liferay-ui:message key="add-appraisal-status"/></a></div>
  <div class="card-body mb-0">


<!-- start -->
<liferay-portlet:renderURL varImpl="iteratorURL" />

<liferay-ui:search-container
deltaConfigurable="${true}" total="${count}"  searchContainer="${apprisalStatusMasterSC}"  delta="4" emptyResultsMessage="No Appraisal Status found!!, Please add a Status to Se it here." >
  <liferay-ui:search-container-results
    results="${apprisalStatusMasterSC.results}" />

  <liferay-ui:search-container-row className="com.ax.hrms.master.model.AppraisalStatusMaster"
    modelVar="appraisalStatusMaster" keyProperty="appraisalStatusMasterId">
   
    <liferay-ui:search-container-column-text name="appraisal-status"
      value="${appraisalStatusMaster.status}" />

    <liferay-ui:search-container-column-text name="actions" cssClass="text-center">
      <portlet:renderURL var="appraisalStatusEditForm" >
      	<portlet:param name="mvcRenderCommandName" value="/fetchAppraisalStatusMaster" />

        <portlet:param name="appraisalStatusMasterId"
          value="${appraisalStatusMaster.appraisalStatusMasterId}" />
      </portlet:renderURL>

      <portlet:renderURL var="appraisalStatusMasterView">
      	<portlet:param name="mvcRenderCommandName" value="/viewAppraisalStatusMaster"/>
        <portlet:param name="appraisalStatusMasterId"
          value="${appraisalStatusMaster.appraisalStatusMasterId}" />
      </portlet:renderURL>

      <portlet:actionURL name="/deleteAppraisalStatusMasterDetails" var="appraisalStatusMasterDelete">
        <portlet:param name="appraisalStatusMasterId"  value="${appraisalStatusMaster.appraisalStatusMasterId}"  />
        <portlet:param name="iteratorURL"  value="${iteratorURL}"  />
      </portlet:actionURL>


      
      
       <div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a href="${appraisalStatusMasterView }" class="dropdown-item "><i class="icon-eye-open"></i> <liferay-ui:message
						key="view-button" /></a>
						</li>
						<li>
						<a href="${appraisalStatusEditForm }" class=" dropdown-item"><i class="icon-edit"></i> <liferay-ui:message
						key="edit-button" /></a>
						</li>
						<li>
						<a class="dropdown-item"
					href="${appraisalStatusMasterDelete}"
        onclick="return confirm('You Are going to delete ${appraisalStatusMaster.status}')"><i class="icon-trash"></i> <liferay-ui:message
						key="delete-button" />
						</a></li>
					</ul>
				</div>
      
      
      
    </liferay-ui:search-container-column-text>
  </liferay-ui:search-container-row>

  <liferay-ui:search-iterator paginate="${true}" markupView="lexicon" searchContainer="${apprisalStatusMasterSC}" />
</liferay-ui:search-container>

<!-- end -->
</div>
</div>

