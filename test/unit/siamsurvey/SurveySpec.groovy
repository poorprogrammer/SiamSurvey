package siamsurvey

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Survey)
class SurveySpec extends Specification {

	def setup() {
		
	}

	def cleanup() {
	}

	def "Murvey must have a name, it must not be blank or null value"(){ 
		when:
			def survey = new Survey(name:surveyName);
			
		then: 
			!survey.validate()
			!survey.save()

		where:
			surveyName << [null,""]
	}

	



}
