<%@ include file="/init.jsp" %>

<div class="card">
    <div class="card-header">
        <strong>Branch Details</strong>
    </div>

    <div class="card-body">
        <p><strong>Branch Name:</strong> ${branch.branchName}</p>
        <p><strong>Address:</strong> ${branch.address}</p>
        <p><strong>City:</strong> ${branch.city}</p>
        <p><strong>State:</strong> ${branch.state}</p>
        <p><strong>Country:</strong> ${branch.country}</p>
        <p><strong>Pincode:</strong> ${branch.pincode}</p>
    </div>

    <div class="card-footer text-right">
        <a href="<liferay-portlet:renderURL />"
           class="btn btn-outline-danger">
            Back
        </a>
    </div>
</div>
