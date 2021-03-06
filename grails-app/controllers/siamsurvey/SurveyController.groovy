package siamsurvey



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SurveyController {

	def surveyService
		
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 20, 100)
        def surveys = surveyService.listSurvey(params.max)
		respond surveys, model:[surveyInstanceCount: surveys.getTotalCount()]
    }

    def show(Survey surveyInstance) {
        respond surveyInstance
    }

    def create(){
        def surveyInstance = new Survey()
        respond surveyInstance
    }

    @Transactional
    def save(Survey surveyInstance){
        if(!surveyInstance.validate()){
            respond surveyInstance.errors, view:'create'
        }
        surveyInstance.save flush:true
        flash.message = message(code: 'default.created.message', args: [message(code: 'surveyInstance.label', default: 'Survey'), surveyInstance.id])
        redirect action:'show', id:surveyInstance.id
    }

 /*
    

    @Transactional
    def save(Survey surveyInstance) {
        if (surveyInstance == null) {
            notFound()
            return
        }

        if (surveyInstance.hasErrors()) {
            respond surveyInstance.errors, view:'create'
            return
        }

        surveyInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'surveyInstance.label', default: 'Survey'), surveyInstance.id])
                redirect surveyInstance
            }
            '*' { respond surveyInstance, [status: CREATED] }
        }
    }

    def edit(Survey surveyInstance) {
        respond surveyInstance
    }

    @Transactional
    def update(Survey surveyInstance) {
        if (surveyInstance == null) {
            notFound()
            return
        }

        if (surveyInstance.hasErrors()) {
            respond surveyInstance.errors, view:'edit'
            return
        }

        surveyInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Survey.label', default: 'Survey'), surveyInstance.id])
                redirect surveyInstance
            }
            '*'{ respond surveyInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Survey surveyInstance) {

        if (surveyInstance == null) {
            notFound()
            return
        }

        surveyInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Survey.label', default: 'Survey'), surveyInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'surveyInstance.label', default: 'Survey'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    */
}
