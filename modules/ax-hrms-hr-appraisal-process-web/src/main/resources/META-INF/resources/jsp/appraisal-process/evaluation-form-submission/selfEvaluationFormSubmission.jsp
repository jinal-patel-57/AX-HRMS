<%@ include file="/init.jsp" %>
<portlet:actionURL var="uploadSelfEvaluationFormURL" name="/uploadSelfEvaluationForm" />


<div class="card">
    <div class="card-header">
        <strong>Self Evaluation Form Submission Panel</strong>
    </div>
    <c:if test="${!isEmployeeValid}">
        <div class="card-body">
            <div class="alert alert-danger" role="alert">
                You are not authoriesd to fill this form!
            </div>
        </div>
    </c:if>
    <c:if test="${isEmployeeValid}">
        <form action="${uploadSelfEvaluationFormURL}" id="selfForm" method="post"
              enctype="multipart/form-data">
            <div class="card-body">
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">Employee under review</div>
                            <div class="label-content">${appraisee}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                        <div class="form-group-view">
                            <div class="label-name">Deadline for form submission</div>
                            <div class="label-content">${deadline}</div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
                        <div class="form-group-view">
                            <label for="formFile" class="label-name">Upload Self Evaluation Form<span class="text-danger">*</span></label>
                            <input class="form-control label-content" type="file" id="file" name="<portlet:namespace/>file">
                        </div>
                    </div>

                    <input type="hidden" name="<portlet:namespace/>appraisalEvaluationFormStatusId"
                           value="${appraisalEvaluationFormStatusId}">
                </div>
            </div>
            <div class="card-footer text-right align-items-center">
                <button type="submit" class="btn btn-outline-success">Submit</button>
            </div>
        </form>
    </c:if>
</div>


