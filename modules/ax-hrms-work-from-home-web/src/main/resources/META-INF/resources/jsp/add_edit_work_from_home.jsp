<%@ include file="/init.jsp" %>

<portlet:actionURL name="/addEditWFHAction" var="addEditWFHURL" />
<portlet:renderURL var="wfhListURL">
    <portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>

<div class="card">
    <div class="card-header">
        <strong>Add Work From Home</strong>
    </div>

    <form action="${addEditWFHURL}" method="post">

        <div class="card-body">

            <div class="form-group">
                <label>Team Mail ID</label>
                <input type="text" class="form-control"
                       name="<portlet:namespace/>teamMailId" required />
            </div>

            <div class="form-group">
                <label>Reason</label>
                <input type="text" class="form-control"
                       name="<portlet:namespace/>reason" required />
            </div>

            <div class="form-group">
                <label>Start Date</label>
                <input type="date" class="form-control"
                       name="<portlet:namespace/>startDate" required />
            </div>

            <div class="form-group">
                <label>End Date</label>
                <input type="date" class="form-control"
                       name="<portlet:namespace/>endDate" required />
            </div>

        </div>

        <div class="card-footer text-right">
            <a href="${wfhListURL}" class="btn btn-outline-danger">Back</a>
            <button class="btn btn-outline-success" type="submit">Submit</button>
        </div>
    </form>
</div>
