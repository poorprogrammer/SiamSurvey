
<%@ page import="siamsurvey.Respondent" %>
<!DOCTYPE html>
<html>

<head>
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'respondent.label', default: 'Respondent')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>

<section id="list-respondent" class="first">

	<table class="table table-bordered margin-top-medium">
		<thead>
			<tr>
			
				<g:sortableColumn property="age" title="${message(code: 'respondent.age.label', default: 'Age')}" />
			
				<g:sortableColumn property="dateCreated" title="${message(code: 'respondent.dateCreated.label', default: 'Date Created')}" />
			
				<g:sortableColumn property="lastUpdated" title="${message(code: 'respondent.lastUpdated.label', default: 'Last Updated')}" />
			
				<g:sortableColumn property="name" title="${message(code: 'respondent.name.label', default: 'Name')}" />
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${respondentInstanceList}" status="i" var="respondentInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td><g:link action="show" id="${respondentInstance.id}">${fieldValue(bean: respondentInstance, field: "age")}</g:link></td>
			
				<td><g:formatDate date="${respondentInstance.dateCreated}" /></td>
			
				<td><g:formatDate date="${respondentInstance.lastUpdated}" /></td>
			
				<td>${fieldValue(bean: respondentInstance, field: "name")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div>
		<bs:paginate total="${respondentInstanceCount}" />
	</div>
</section>

</body>

</html>
