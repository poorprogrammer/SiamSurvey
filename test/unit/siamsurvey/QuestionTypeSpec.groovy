package siamsurvey

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(QuestionType)
class QuestionTypeSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Should have type text"() {
		when:
		def type = new QuestionType()
		then:
		!type.validate()
		!type.save(flush:true)
		
		when:
		type.typeText = "RANKING"
		then:
		type.save(flush:true)
		QuestionType.count() == 1
    }
}
