package siamsurvey
import grails.gorm.PagedResultList;

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

	void "Should return 0 if does not have any survey in the datastore"(){
		when: "execute listSurvey with doesn't any params"
		def surveys = service.listSurvey()
		then: "should not be null"
		surveys != null
		surveys.class == PagedResultList.class
		then: "should retrun 0 survey if it doesn't have any survey in datastore."
		surveys.size() == 0
	}

	void "Should return 1 survey if there is one survey in the datastore."(){
		when: "There is survey in the datastore"
		def survey = new Survey(name:"TestName",objective:"obj...")
		survey.save()
		and: "execute listSurvey in service"
		def surveys = service.listSurvey()
		then: "should not be null"
		surveys != null
		and:"should return 1 survey"
		surveys.size() == Survey.count()
	}

	void "Should return 2 surveys if there is two surveys in the datastore."(){
		when: "There are 2 survey in the datastore"
		2.times {new Survey(name:"Yamaha").save(flush:true)}
		and: "execute listSurvey in service"
		def surveys = service.listSurvey()
		then: "should not be null"
		surveys != null
		and:"should return 2 survey"
		surveys.size() == Survey.count()
	}

	void "Should return all surveys"(){
		given:"There are 20 surveys in the datastore."
		20.times{index->
			new Survey(name:"Survey : $index").save(flush:true)
		}
		when: "execute listSurvey action"
		def surveys = service.listSurvey()
		then: "should return 20 surveys"
		surveys.size() == Survey.count()
	}
	
	void "Should return all surveys but not 20 surveys at a time"(){
		given:"There are 21 surveys in the datastore."
		21.times{index->
			new Survey(name:"Survey : $index").save(flush:true)
		}
		when: "execute listSurvey action without params"
		def surveys = service.listSurvey()
		then: "should return only 20 surveys"
		Survey.count() == 21
		surveys.size() == 20
		
	}
	
	void "Should return NUMBER surveys but not 20 surveys at a time"(){
		given:"There are 30 surveys in the datastore."
		30.times{index->
			new Survey(name:"Survey : $index").save(flush:true)
		}
		when: "execute listSurvey action 5 parameter "
		def surveys = service.listSurvey(5)
		then: "should return only 5 surveys"
		Survey.count() == 30
		surveys.size() == 5
		
		when: "execute listSurvey action 20 parameter "
		surveys = service.listSurvey(20)
		then: "should return 20 surveys"
		Survey.count() == 30
		surveys.size() == 20
		and: "total survey should be 30 surveys"
		surveys.getTotalCount() == 30
		
	}
	
}
