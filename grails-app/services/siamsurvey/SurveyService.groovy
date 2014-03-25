package siamsurvey

import grails.transaction.Transactional

@Transactional
class SurveyService {

    def createSurvey(params) {
    	new Survey(params).save flush:true
    }
	
	def listSurvey(max) {
		if(max == null){
			max = 20
		}
		def surveys = Survey.list(max:max)
		return surveys
	}
	
	
	
}
