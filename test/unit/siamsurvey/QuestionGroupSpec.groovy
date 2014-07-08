package siamsurvey

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(QuestionGroup)
class QuestionGroupSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Should have name on the survey"() {
		when:"New Question Group"
		def questionGroup = new QuestionGroup()
		then:"Should error wehn try to save without name"
		!questionGroup.validate()
		!questionGroup.save(flush:true) 
		
		when:"Assign thai name"
		questionGroup.thaiName = "thai name"
		def groupInstance = questionGroup.save(flush:true)
		then:
		groupInstance != null
		QuestionGroup.count() == 1 
		
    }
}
