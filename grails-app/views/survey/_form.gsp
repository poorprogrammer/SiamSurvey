<%@ page import="siamsurvey.Survey" %>



<div class="fieldcontain ${hasErrors(bean: surveyInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="survey.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${surveyInstance?.name}"/>
</div>

