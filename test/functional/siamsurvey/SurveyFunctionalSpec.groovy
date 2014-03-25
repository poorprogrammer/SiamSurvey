package siamsurvey

import spec.lang.*
import siamsurvey.pages.*

class SurveyFunctionalSpec extends geb.spock.GebReportingSpec {
	def "there are no survey"() {
		when:
			to SurveyListPage
		then:
			heading == 'Survey List'
	}
	
	def "add one survey"(){
		when:"go to create page fill in create form"
			to SurveyCreatePage
		then:"redirect to list page"
		
		
	}
	
	
	
}