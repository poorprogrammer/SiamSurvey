package siamsurvey



import grails.test.mixin.*
import spock.lang.*

@TestFor(RespondentController)
@Mock(Respondent)
class RespondentControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        params["name"] = 'someValidName'
		params["age"] = 21
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.respondentInstanceList
            model.respondentInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.respondentInstance!= null
    }

//    void "Test the save action correctly persists an instance"() {
//
//        when:"The save action is executed with an invalid instance"
//            def respondent = new Respondent()
//            respondent.validate()
//            controller.save(respondent)
//
//        then:"The create view is rendered again with the correct model"
//            model.respondentInstance!= null
//            view == 'create'
//
//        when:"The save action is executed with a valid instance"
//            response.reset()
//            populateValidParams(params)
//            respondent = new Respondent(params)
//
//            controller.save(respondent)
//
//        then:"A redirect is issued to the show action"
//            response.redirectedUrl == '/respondent/show/1'
//            controller.flash.message != null
//            Respondent.count() == 1
//    }
//
//    void "Test that the show action returns the correct model"() {
//        when:"The show action is executed with a null domain"
//            controller.show(null)
//
//        then:"A 404 error is returned"
//            response.status == 404
//
//        when:"A domain instance is passed to the show action"
//            populateValidParams(params)
//            def respondent = new Respondent(params)
//            controller.show(respondent)
//
//        then:"A model is populated containing the domain instance"
//            model.respondentInstance == respondent
//    }
//
//    void "Test that the edit action returns the correct model"() {
//        when:"The edit action is executed with a null domain"
//            controller.edit(null)
//
//        then:"A 404 error is returned"
//            response.status == 404
//
//        when:"A domain instance is passed to the edit action"
//            populateValidParams(params)
//            def respondent = new Respondent(params)
//            controller.edit(respondent)
//
//        then:"A model is populated containing the domain instance"
//            model.respondentInstance == respondent
//    }
//
//    void "Test the update action performs an update on a valid domain instance"() {
//        when:"Update is called for a domain instance that doesn't exist"
//            controller.update(null)
//
//        then:"A 404 error is returned"
//            response.redirectedUrl == '/respondent/index'
//            flash.message != null
//
//
//        when:"An invalid domain instance is passed to the update action"
//            response.reset()
//            def respondent = new Respondent()
//            respondent.validate()
//            controller.update(respondent)
//
//        then:"The edit view is rendered again with the invalid instance"
//            view == 'edit'
//            model.respondentInstance == respondent
//
//        when:"A valid domain instance is passed to the update action"
//            response.reset()
//            populateValidParams(params)
//            respondent = new Respondent(params).save(flush: true)
//            controller.update(respondent)
//
//        then:"A redirect is issues to the show action"
//            response.redirectedUrl == "/respondent/show/$respondent.id"
//            flash.message != null
//    }
//
//    void "Test that the delete action deletes an instance if it exists"() {
//        when:"The delete action is called for a null instance"
//            controller.delete(null)
//
//        then:"A 404 is returned"
//            response.redirectedUrl == '/respondent/index'
//            flash.message != null
//
//        when:"A domain instance is created"
//            response.reset()
//            populateValidParams(params)
//            def respondent = new Respondent(params).save(flush: true)
//
//        then:"It exists"
//            Respondent.count() == 1
//
//        when:"The domain instance is passed to the delete action"
//            controller.delete(respondent)
//
//        then:"The instance is deleted"
//            Respondent.count() == 0
//            response.redirectedUrl == '/respondent/index'
//            flash.message != null
//    }
}
