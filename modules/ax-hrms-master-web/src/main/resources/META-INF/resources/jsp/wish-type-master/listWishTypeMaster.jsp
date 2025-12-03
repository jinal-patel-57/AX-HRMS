<%@ include file="/init.jsp" %>

<portlet:renderURL var="addWishTypeURL">
	<portlet:param name="mvcPath" value="/jsp/wish-type-master/addEditWishTypeMaster.jsp" />
</portlet:renderURL>


<div class="card">
  <div class="card-header d-flex align-items-center justify-content-end"><a href="${addWishTypeURL}" class="btn  btn-primary btn-sm">
		<liferay-ui:message key="addWishType" />
	</a></div>
  <div class="card-body mb-0">
<liferay-ui:error key="wish-type-exists" message="wish-type-name-is-already-exist" />

<liferay-ui:success key="wish-type-deleted" message="wish-type-has-been-deleted-successfully" />

<liferay-ui:success key="wish-type-added" message="wish-type-has-been-successfully-added" />
<liferay-ui:success key="wish-type-updated" message="wish-type-has-been-successfully-updated" />

<!-- Start -->


<liferay-portlet:renderURL varImpl="iteratorURL" />

<liferay-ui:search-container total="${totalWishType}" delta= "3" emptyResultsMessage="No-Wish Type-found" iteratorURL="${iteratorURL}">
    <liferay-ui:search-container-results results="${getWishType}" />

    <liferay-ui:search-container-row className="com.ax.hrms.master.model.WishTypeMaster" modelVar="wishTypeMaster" keyProperty="WishTypeMaster">
        <liferay-ui:search-container-column-text name="Wish Type Name" value="${wishTypeMaster.getWishType()}" />
        																				

        <liferay-ui:search-container-column-text name="Actions" cssClass="text-center">

			<portlet:renderURL var="viewWishTypeURL">
					<portlet:param name="mvcRenderCommandName" value="/viewWishType"/>
					<portlet:param name="wishTypeMasterId" value="${wishTypeMaster.wishTypeMasterId}"/>		            
			</portlet:renderURL>


			<portlet:renderURL var="updateWishTypeURL">
				<portlet:param name="mvcRenderCommandName" value="/fetchWishType"/>
				<portlet:param name="wishTypeMasterId" value="${wishTypeMaster.wishTypeMasterId}"/>		            
			</portlet:renderURL>
	        
	        <portlet:actionURL var="deleteWishTypeURL" name="/deleteWishType">
				<portlet:param name="wishTypeMasterId" value="${wishTypeMaster.wishTypeMasterId}" />
			</portlet:actionURL>
            
            
            <div class="dropdown ">
					<button class="btn fa fa-ellipsis-v dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<i class="icon-ellipsis-vertical"></i>
					</button>
					<ul class="dropdown-menu">
						<li>
						<a href="${viewWishTypeURL }" class="dropdown-item "><i class="icon-eye-open"></i> <liferay-ui:message
						key="view-button" /></a>
						</li>
						<li>
						<a href="${updateWishTypeURL }" class=" dropdown-item"><i class="icon-edit"></i> <liferay-ui:message
						key="edit-button" /></a>
						</li>
						<li>
						<a class="dropdown-item"
					onclick="deleteWishTypeByMasterId('${wishTypeMaster.wishTypeMasterId}')"><i class="icon-trash"></i> <liferay-ui:message
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

function deleteWishTypeByMasterId(wishTypeMasterId) {		
    var config = {
        namespace: '<portlet:namespace />',
        deleteUrl: '${deleteWishTypeURL}',
        wishTypeMasterId: wishTypeMasterId
    };
    AxWishTypeMasterWebPortlet.setConfigsForDeleteWishTypeMaster(config);
}

function goBack() {
    window.history.back();
}

</script>
