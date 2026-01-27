<%@ include file="/init.jsp" %>

<portlet:renderURL var="viewDocumentTypeURL">
    <portlet:param name="mvcRenderCommanName" value="/" />
</portlet:renderURL>


<div class="card shadow-sm">
    <div class="card-header">
        <strong class="text-dark">
            <liferay-ui:message key="document-type-details" />
        </strong>
    </div>

    <div class="card-body">

        <div class="row mb-2">
            <div class="col-md-4 text-muted">
                <liferay-ui:message key="document-type-name" />
            </div>
            <div class="col-md-8 font-weight-semibold">
                ${documentType.getDocumentTypeName()}
            </div>
        </div>

        <div class="row mb-2">
            <div class="col-md-4 text-muted">
                <liferay-ui:message key="is-document-used-for-kyc" />
            </div>
            <div class="col-md-8">
                <c:choose>
                    <c:when test="${documentType.getIsDocumentUsedForKYC()}">
                        <span class="badge badge-success px-3 py-1">
                            <liferay-ui:message key="yes" />
                        </span>
                    </c:when>
                    <c:otherwise>
                        <span class="badge badge-secondary px-3 py-1">
                            <liferay-ui:message key="no" />
                        </span>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

    </div>

    <div class="card-footer text-right">
        <a href="${viewDocumentTypeURL}" class="btn btn-outline-danger">
            <liferay-ui:message key="back" />
        </a>
    </div>
</div>
