<%@ include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<liferay-portlet:renderURL var="backURL" />

				<%-- Compensatory Request Detail View --%>
				<c:if test="${not empty compensatoryData}">
					<div class="card mt-3">
						<div class="card-header">
							<strong><liferay-ui:message
									key="compensatory-off-details" /></strong>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
									<div class="form-group-view">
										<div class="label-name">
											<liferay-ui:message key="employee-name" />
										</div>
										<div class="label-content">${compensatoryData.employeeName}</div>
									</div>
								</div>
								<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
									<div class="form-group-view">
										<div class="label-name">
											<liferay-ui:message key="manager-name" />
										</div>
										<div class="label-content">${compensatoryData.managerName}</div>
									</div>
								</div>
								<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
									<div class="form-group-view">
										<div class="label-name">
											<liferay-ui:message key="date-of-compensation" />
										</div>
										<div class="label-content">
											${compensatoryData.dateOfCompensation}
										</div>
									</div>
								</div>
								<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
									<div class="form-group-view">
										<div class="label-name">
											<liferay-ui:message key="status" />
										</div>
										<div class="label-content">${compensatoryData.status}</div>
									</div>
								</div>
								<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
									<div class="form-group-view">
										<div class="label-name">
											<liferay-ui:message key="start-time" />
										</div>
										<div class="label-content">${compensatoryData.startTime}</div>
									</div>
								</div>
								<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
									<div class="form-group-view">
										<div class="label-name">
											<liferay-ui:message key="end-time" />
										</div>
										<div class="label-content">${compensatoryData.endTime}</div>
									</div>
								</div>
								<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
									<div class="form-group-view">
										<div class="label-name">
											<liferay-ui:message key="requested-compensation-type" />
										</div>
										<div class="label-content">${compensatoryData.requestedCompensationType}</div>
									</div>
								</div>
								<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
									<div class="form-group-view">
										<div class="label-name">
											<liferay-ui:message key="approved-compensation-type" />
										</div>
										<div class="label-content">${compensatoryData.approvedCompensationType}</div>
									</div>
								</div>
								<div class="col-lg-12 col-md-4 col-sm-6 col-xs-12">
									<div class="form-group-view">
										<div class="label-name">
											<liferay-ui:message key="description" />
										</div>
										<div class="label-content">${compensatoryData.description}</div>
									</div>
								</div>
							</div>


							            <c:if test="${not empty compensatoryData and not empty compensatoryData.comment}">
                            	            <div class="col-md-6 col-12">
                            	                <div class="card">
                            	                    <div class="card-header">
                            	                        <strong>
                            	                            Comment
                            	                        </strong>
                            	                    </div>
                            	                    <div class="card-body">
                            	                        <table class="table">
                            	                            <thead>
                            	                            <tr>
                            	                                <th scope="col"><liferay-ui:message key="comment"/></th>
                            	                                <th scope="col"><liferay-ui:message key="By"/></th>
                            	                            </tr>
                            	                            </thead>
                            	                            <tbody>
                            	                            	<tr>
                            	                            		<td>${empty compensatoryData ? '' : compensatoryData.comment}</td>
                            	                            		<td>${empty compensatoryData ? '' : compensatoryData.commentedBy}</td>
                            	                            	</tr>
                            	                            </tbody>
                            	                         </table>
                            	                     </div>
                            	                 </div>
                            	             </div>
                                         </c:if>

						</div>
						<div class="card-footer text-right mb-0">
							<a href="${backURL}" class="btn  btn-outline-danger"> <liferay-ui:message
									key="back" />
							</a>
						</div>
					</div>
				</c:if>

