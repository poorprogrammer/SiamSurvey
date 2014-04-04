<%@ page import="siamsurvey.Respondent" %>



			<div class="${hasErrors(bean: respondentInstance, field: 'age', 'error')} required">
				<label for="age" class="control-label"><g:message code="respondent.age.label" default="Age" /><span class="required-indicator">*</span></label>
				<div>
					<g:field class="form-control" name="age" type="number" value="${respondentInstance.age}" required=""/>
					<span class="help-inline">${hasErrors(bean: respondentInstance, field: 'age', 'error')}</span>
				</div>
			</div>

			<div class="${hasErrors(bean: respondentInstance, field: 'name', 'error')} ">
				<label for="name" class="control-label"><g:message code="respondent.name.label" default="Name" /></label>
				<div>
					<g:textField class="form-control" name="name" value="${respondentInstance?.name}"/>
					<span class="help-inline">${hasErrors(bean: respondentInstance, field: 'name', 'error')}</span>
				</div>
			</div>

