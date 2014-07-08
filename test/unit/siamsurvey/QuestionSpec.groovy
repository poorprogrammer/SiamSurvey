package siamsurvey

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Question)
@grails.test.mixin.Mock([QuestionGroup,QuestionType,Survey])
class QuestionSpec extends Specification {

	def setup() {
		
	}

	def cleanup() {
	}

	
	
	
	
	void "Should add question with question group and question type"() {
		given:"new questionGroup and put new Question in there"
		def survey = new Survey(name:"Thai Survey Name").save flush:true
		Survey.count() == 1
		def questionGroup = new QuestionGroup(thaiName:"group 1").save(flush:true)
		def questionType = new QuestionType(typeText:"RANKING").save(flush:true)
		when:"try to save question without question group"
		def question = new Question(thaiName:"question name",survey:survey)
		then:"must have question group"
		QuestionGroup.count() == 1
		QuestionType.count() == 1
		!question.validate()
		!question.save(flush:true)
		when:"assign group to question with type"
		question.questionGroup = questionGroup
		question.questionType = questionType
		def questionInstance = question.save flush:true
		then:"should success for saving"
		question.validate()
		Question.count() == 1
		questionInstance.questionType.typeText == questionType.typeText
		questionInstance.questionGroup.thaiName == questionGroup.thaiName
	}
	
	
	
	
	
	
}
