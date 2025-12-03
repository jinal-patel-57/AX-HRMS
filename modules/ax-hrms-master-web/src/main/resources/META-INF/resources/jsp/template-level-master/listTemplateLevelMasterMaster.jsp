<%@ include file="/init.jsp" %>

<portlet:renderURL var="addTemplateLevelMasterURL">
  <portlet:param name="mvcPath" value="/jsp/template-level-master/addEditTemplateLevelMasterMaster.jsp" />
</portlet:renderURL>

<liferay-ui:error key="error-already-exist" message="template-level-error-already-exist" />
<liferay-ui:success key="success" message="template-level-success" />
<liferay-ui:success key="success-delete" message="template-level-delete" />
<liferay-ui:success key="success-edit" message="template-level-edit" />


<div class="card">
  <div class="card-header d-flex align-items-center justify-content-end">   <a href="${addTemplateLevelMasterURL}" class="btn btn-primary btn-sm"><liferay-ui:message key="add-template-level"/></a>
</div>
  <div class="card-body mb-0">

<!-- start -->
<liferay-portlet:renderURL varImpl="iteratorURL" />

<liferay-ui:search-container
deltaConfigurable="${true}" total="${count}"  searchContainer="${templateLevelMasterSC}"  delta="4" emptyResultsMessage="No Template Level Masters found!!, Please add one to Se it here." >
  <liferay-ui:search-container-results
    results="${templateLevelMasterSC.results}" />

  <liferay-ui:search-container-row className="com.ax.hrms.master.model.TemplateLevelMaster"
    modelVar="templateLevelMaster" keyProperty="templateLevelMasterId">
   
    <liferay-ui:search-container-column-text name="template-level-name"
      value="${templateLevelMaster.levelName}" />


    <liferay-ui:search-container-column-text name="actions" cssClass="text-center">


    <portlet:renderURL var="templateLevelMasterEditForm" >
      	<portlet:param name="mvcRenderCommandName" value="/fetchTemplateLevelMaster" />
        <portlet:param name="templateLevelMasterId"
          value="${templateLevelMaster.templateLevelMasterId}" />
      </portlet:renderURL>

      <portlet:renderURL var="templateLevelMasterView">
      	<portlet:param name="mvcRenderCommandName" value="/viewTemplateLevelMaster"/>
        <portlet:param name="templateLevelMasterId"
          value="${templateLevelMaster.templateLevelMasterId}" />
      </portlet:renderURL>

      
      <portlet:actionURL name="/deleteTemplateLevelMaster" var="templateLevelMasterDelete">
        <portlet:param name="templateLevelMasterId"  value="${templateLevelMaster.templateLevelMasterId}"  />
        <portlet:param name="iteratorURL"  value="${iteratorURL}"  />
      </portlet:actionURL>

      <div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a href="${templateLevelMasterView }" class="dropdown-item "><i class="icon-eye-open"></i> <liferay-ui:message
						key="view-button" /></a>
						</li>
						<li>
						<a href="${templateLevelMasterEditForm }" class=" dropdown-item"><i class="icon-edit"></i> <liferay-ui:message
						key="edit-button" /></a>
						</li>
						<li>
						<a class="dropdown-item" href="${templateLevelMasterDelete}"
					onclick="return confirm('You Are going to delete ${templateLevelMaster.levelName}')"><i class="icon-trash"></i> <liferay-ui:message
						key="delete-button" />
						</a></li>
					</ul>
				</div>
				
      
    </liferay-ui:search-container-column-text>
  </liferay-ui:search-container-row>

  <liferay-ui:search-iterator paginate="${true}" markupView="lexicon" searchContainer="${templateLevelMasterSC}" />
</liferay-ui:search-container>

<!-- end -->

</div>
</div>

