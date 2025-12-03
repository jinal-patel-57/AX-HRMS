<%@ include file="init.jsp"%>
<style>
.container {
	margin: 25px;
}

/* .field {
	margin: 20px;
} */
</style>

<div class="container">
	<div class="field">
 		<aui:input label="Probation Duration (In Months)" type="text"
			name="subject" value="<%=(String) request.getAttribute("probationPeriod")%>" localized="true">
		</aui:input>
	</div>
</div>
