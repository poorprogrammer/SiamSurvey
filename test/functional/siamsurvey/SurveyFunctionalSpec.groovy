package siamsurvey

import spec.lang.*
import siamsurvey.pages.*

class SurveyFunctionalSpec extends geb.spock.GebReportingSpec {
	def "there are no people"() {
		when:
			to SurveyListPage
		then:
			heading == 'Survey List'
	}
}