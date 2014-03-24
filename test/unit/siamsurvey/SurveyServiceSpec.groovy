package siamsurvey

import grails.test.mixin.*
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(SurveyService)
@Mock(Survey)
class SurveyServiceSpec extends Specification {

	def params = [:]
	def populateValidParams(params) {

		assert params != null
		params["name"] = 'Yamaha Survey'
	}

	def setup() {
	}

	def cleanup() {
	}

	void "test create Survey via Survey service"() {
		when: "try to save survey through service"
		populateValidParams(params)
		service.createSurvey(params)

		then: "should have data persisted to data store"
		Survey.count() == 1
	}
}
