package siamsurvey

import grails.transaction.Transactional

@Transactional
class SurveyService {

    def createSurvey(params) {
    	new Survey(params).save flush:true
    }
}
