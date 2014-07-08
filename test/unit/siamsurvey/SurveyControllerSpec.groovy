package siamsurvey



import grails.test.mixin.*
import spock.lang.*

@TestFor(SurveyController)
@Mock([Survey,SurveyService])
class SurveyControllerSpec extends Specification {

	def populateValidParams(params) {
		assert params != null
		params["name"] = 'Yamaha Survey'
	}

	void "Test the index action returns the correct model"() {
		when:"The index action is executed"
		controller.index()

		then:"The model is correct"
		!model.surveyInstanceList
		model.surveyInstanceCount == 0
	}

//	void "index action should return all surveys but not over 20 surveys"(){
//		given: "There are 5 surveys in the datastore."
//		5.times{index->
//			populateValidParams(params)
//			new Survey(params).save(flush:true)
//		}
//		when: "execute index action without any params"
//		controller.index()
//		then: "should return 5 surveys from total 5 surveys"
//		model.surveyInstanceList.size() == 5
//		model.surveyInstanceCount == 5
//		
//		when: "There are surveys more than 20 in the datastore."
//		30.times{index->
//			populateValidParams(params)
//			new Survey(params).save(flush:true)
//		}
//		and: "execute index action without any params and have more than 20 surveys"
//		controller.index()
//		then: "should return 20 surveys from total 35 surveys"
//		model.surveyInstanceList.size() == 20
//		model.surveyInstanceCount == 35
//		
//		
//	}
//	
//	void "index action should return correct number of surveys"(){
//		given: "There are 30 surveys in the datastore."
//		30.times{index->
//			populateValidParams(params)
//			new Survey(params).save(flush:true)
//		}
//		when: "execute index action without any params"
//		controller.index()
//		then: "should return 20 surveys from total 30 surveys"
//		model.surveyInstanceList.size() == 20
//		model.surveyInstanceCount == 30
//		
//		when: "execute index action with need just 19 surveys"
//		controller.index(19)
//		then: "should return 19 surveys from total 30 surveys"
//		model.surveyInstanceList.size() == 19
//		model.surveyInstanceCount == 30
//		
//	}
//
//	void "Test that the show action returns the correct model"() {
//		when:"The show action is executed with a null domain"
//		controller.show(null)
//
//		then:"A 404 error is returned"
//		response.status == 404
//
//		when:"A domain instance is passed to the show action"
//		populateValidParams(params)
//		def survey = new Survey(params)
//		controller.show(survey)
//
//		then:"A model is populated containing the domain instance"
//		model.surveyInstance == survey
//		model.surveyInstance.name == 'Yamaha Survey'
//	}
//
//	void "Test the create action returns the correct model"() {
//		when:"The create action is executed"
//		controller.create()
//
//		then:"The model is correctly created"
//		model.surveyInstance!= null
//	}
//
//	void "Save action should redirect create page and show errors if it try to save invalid domain"(){
//		when:"save action try to save domain without name"
//		def survey = new Survey()
//		controller.save(survey)
//
//		then:"should redirect create page and show errors"
//		view == 'create'
//		model.surveyInstance.errors != null
//	}
//
//	void "Save action correctly persists an instance"() {
//		when:"The save action is executed with a valid instance"
//		response.reset()
//		populateValidParams(params)
//		def survey = new Survey(params)
//		controller.save(survey)
//
//		then:"A redirect is issued to the show action"
//		response.redirectedUrl == '/survey/show/1'
//		controller.flash.message != null
//		Survey.count() == 1
//	}





	/*
	 void "Test that the edit action returns the correct model"() {
	 when:"The edit action is executed with a null domain"
	 controller.edit(null)
	 then:"A 404 error is returned"
	 response.status == 404
	 when:"A domain instance is passed to the edit action"
	 populateValidParams(params)
	 def survey = new Survey(params)
	 controller.edit(survey)
	 then:"A model is populated containing the domain instance"
	 model.surveyInstance == survey
	 }
	 void "Test the update action performs an update on a valid domain instance"() {
	 when:"Update is called for a domain instance that doesn't exist"
	 controller.update(null)
	 then:"A 404 error is returned"
	 response.redirectedUrl == '/survey/index'
	 flash.message != null
	 when:"An invalid domain instance is passed to the update action"
	 response.reset()
	 def survey = new Survey()
	 survey.validate()
	 controller.update(survey)
	 then:"The edit view is rendered again with the invalid instance"
	 view == 'edit'
	 model.surveyInstance == survey
	 when:"A valid domain instance is passed to the update action"
	 response.reset()
	 populateValidParams(params)
	 survey = new Survey(params).save(flush: true)
	 controller.update(survey)
	 then:"A redirect is issues to the show action"
	 response.redirectedUrl == "/survey/show/$survey.id"
	 flash.message != null
	 }
	 void "Test that the delete action deletes an instance if it exists"() {
	 when:"The delete action is called for a null instance"
	 controller.delete(null)
	 then:"A 404 is returned"
	 response.redirectedUrl == '/survey/index'
	 flash.message != null
	 when:"A domain instance is created"
	 response.reset()
	 populateValidParams(params)
	 def survey = new Survey(params).save(flush: true)
	 then:"It exists"
	 Survey.count() == 1
	 when:"The domain instance is passed to the delete action"
	 controller.delete(survey)
	 then:"The instance is deleted"
	 Survey.count() == 0
	 response.redirectedUrl == '/survey/index'
	 flash.message != null
	 }
	 */
}
