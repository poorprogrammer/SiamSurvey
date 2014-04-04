package siamsurvey


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

/**
 * RespondentController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
@Transactional(readOnly = true)
class RespondentController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Respondent.list(params), model:[respondentInstanceCount: Respondent.count()]
    }

	def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Respondent.list(params), model:[respondentInstanceCount: Respondent.count()]
    }

    def show(Respondent respondentInstance) {
        respond respondentInstance
    }

    def create() {
        respond new Respondent(params)
    }

    @Transactional
    def save(Respondent respondentInstance) {
        if (respondentInstance == null) {
            notFound()
            return
        }

        if (respondentInstance.hasErrors()) {
            respond respondentInstance.errors, view:'create'
            return
        }

        respondentInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'respondentInstance.label', default: 'Respondent'), respondentInstance.id])
                redirect respondentInstance
            }
            '*' { respond respondentInstance, [status: CREATED] }
        }
    }

    def edit(Respondent respondentInstance) {
        respond respondentInstance
    }

    @Transactional
    def update(Respondent respondentInstance) {
        if (respondentInstance == null) {
            notFound()
            return
        }

        if (respondentInstance.hasErrors()) {
            respond respondentInstance.errors, view:'edit'
            return
        }

        respondentInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Respondent.label', default: 'Respondent'), respondentInstance.id])
                redirect respondentInstance
            }
            '*'{ respond respondentInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Respondent respondentInstance) {

        if (respondentInstance == null) {
            notFound()
            return
        }

        respondentInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Respondent.label', default: 'Respondent'), respondentInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'respondentInstance.label', default: 'Respondent'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
