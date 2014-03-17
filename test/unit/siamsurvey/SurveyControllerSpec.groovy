package siamsurvey



import grails.test.mixin.*
import spock.lang.*

@TestFor(SurveyController)
@Mock(Survey)
class SurveyControllerSpec extends Specification {

    


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        params["name"] = 'Yamaha Survey'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.surveyInstanceList
            model.surveyInstanceCount == 0
    }

    
    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def survey = new Survey(params)
            controller.show(survey)

        then:"A model is populated containing the domain instance"
            model.surveyInstance == survey
            model.surveyInstance.name == 'Yamaha Survey'
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.surveyInstance!= null

    }

    void "Save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def survey = new Survey()
            controller.save(survey)

        then:"The create view is rendered again with the correct model"
            model.surveyInstance!= null
            view == 'create'

        and:"The save action is errored and rendered create again must show errors."
            model.surveyInstance.errors != null
/*
        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            survey = new Survey(params)

            controller.save(survey)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/survey/show/1'
            controller.flash.message != null
            Survey.count() == 1
    */
    }

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
