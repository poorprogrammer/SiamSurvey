
<%@ page import="siamsurvey.Survey" %>
<!DOCTYPE html>
<html>

<head>
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'survey.label', default: 'Survey')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>

<section id="list-survey" class="first">

	<table class="table table-bordered margin-top-medium">
		<thead>
			<tr>
			
				<g:sortableColumn property="objective" title="${message(code: 'survey.objective.label', default: 'Objective')}" />
			
				<g:sortableColumn property="thaiName" title="${message(code: 'survey.thaiName.label', default: 'Thai Name')}" />
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${surveyInstanceList}" status="i" var="surveyInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td><g:link action="show" id="${surveyInstance.id}">${fieldValue(bean: surveyInstance, field: "objective")}</g:link></td>
			
				<td>${fieldValue(bean: surveyInstance, field: "thaiName")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div>
		<bs:paginate total="${surveyInstanceCount}" />
	</div>
</section>

</body>

</html>
