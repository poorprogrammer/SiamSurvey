package siamsurvey

import grails.transaction.Transactional

@Transactional
class SurveyService {

    def createSurvey(params) {
		def survey = new Survey(params)
		if(survey.validate()){
			survey.save flush:true
		}
    	
		 
    }
	
	
	@Transactional(readOnly = true)
	def listSurvey(max) {
		if(max == null){
			max = 20
		}
		def surveys = Survey.list(max:max)
		return surveys
	}
	
	
	
}
