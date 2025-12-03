<%@ include file="/init.jsp" %>

<portlet:renderURL var="addEditEducationLevelUrl">
	<portlet:param name="mvcPath" value="/jsp/education-level-master/addEditEducationLevelMaster.jsp" />
</portlet:renderURL>



<liferay-ui:error key="education-level-exists" message="education-level-name-is-already-exist" />

<liferay-ui:success key="education-level-deleted" message="education-level-has-been-deleted-successfully" />

<liferay-ui:success key="education-level-added" message="education-level-has-been-successfully-added" />
<liferay-ui:success key="education-level-updated" message="education-level-has-been-successfully-updated" />

<!-- Start -->

<div class="card">
  <div class="card-header d-flex align-items-center justify-content-end"><a href="${addEditEducationLevelUrl}" class="btn  btn-primary btn-sm ">
        <liferay-ui:message key="add-education-level" />    
    </a></div>
  <div class="card-body mb-0">

<liferay-portlet:renderURL varImpl="iteratorURL" />

<liferay-ui:search-container total="${totalEducationLevel}" delta= "3" emptyResultsMessage="no-Education Level-found" iteratorURL="${iteratorURL}">
    <liferay-ui:search-container-results results="${getEducationLevel}" />
       
    <liferay-ui:search-container-row className="com.ax.hrms.master.model.EducationLevelMaster" modelVar="educationLevelMaster" keyProperty="educationLevelMasterId">
        <liferay-ui:search-container-column-text name="Education Level Name" value="${educationLevelMaster.getLevelName()}" />
        																				

        <liferay-ui:search-container-column-text name="Actions" cssClass="text-center">

			<portlet:renderURL var="viewEducationLevelURL">
					<portlet:param name="mvcRenderCommandName" value="/viewEducationLevel"/>
					<portlet:param name="educationLevelMasterId" value="${educationLevelMaster.educationLevelMasterId}"/>		            
			</portlet:renderURL>


			<portlet:renderURL var="updateEducationLevelURL">
				<portlet:param name="mvcRenderCommandName" value="/fetchEducationLevel"/>
				<portlet:param name="educationLevelMasterId" value="${educationLevelMaster.educationLevelMasterId}"/>		            
			</portlet:renderURL>
	        
	        <portlet:actionURL var="deleteEducationLevelURL" name="/deleteEducationLevel">
				<portlet:param name="educationLevelMasterId" value="EDUCATIONLEVEL_MASTER_ID" />
			</portlet:actionURL>
            
            <div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a href="${viewEducationLevelURL }" class="dropdown-item "><i class="icon-eye-open"></i> <liferay-ui:message
						key="view-button" /></a>
						</li>
						<li>
						<a href="${updateEducationLevelURL }" class=" dropdown-item"><i class="icon-edit"></i> <liferay-ui:message
						key="edit-button" /></a>
						</li>
						<li>
						<a class="dropdown-item"
					onclick="deleteEducationLevelByMasterId('${educationLevelMaster.educationLevelMasterId}')"><i class="icon-trash"></i> <liferay-ui:message
						key="delete-button" />
						</a></li>
					</ul>
				</div>
            
            
            
            
        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator markupView="lexicon" paginate="true" />
</liferay-ui:search-container>

</div>
</div>




<!-- end -->

<script>

function deleteEducationLevelByMasterId(educationLevelMasterId) {		
    var config = {
        namespace: '<portlet:namespace />',
        deleteUrl: '${deleteEducationLevelURL}',
        educationLevelMasterId: educationLevelMasterId
    };
    AxEducationLevelMasterWebPortlet.setConfigsForDeleteEducationLevelMaster(config);
}
</script>
