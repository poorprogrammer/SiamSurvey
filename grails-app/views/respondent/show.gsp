
<%@ page import="siamsurvey.Respondent" %>
<!DOCTYPE html>
<html>

<head>
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'respondent.label', default: 'Respondent')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-respondent" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="respondent.age.label" default="Age" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: respondentInstance, field: "age")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="respondent.dateCreated.label" default="Date Created" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${respondentInstance?.dateCreated}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="respondent.lastUpdated.label" default="Last Updated" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${respondentInstance?.lastUpdated}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="respondent.name.label" default="Name" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: respondentInstance, field: "name")}</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
