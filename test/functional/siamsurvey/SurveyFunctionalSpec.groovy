package siamsurvey


import spec.lang.*
import siamsurvey.pages.*
import siamsurvey.remote.*

class SurveyFunctionalSpec extends geb.spock.GebReportingSpec {

	SurveyRemoteControl surveyRemote = new SurveyRemoteControl()

	def "there are no survey"() {
		when:
		to SurveyListPage
		then:
		heading == 'Survey List'
	}

	def "add one survey"(){
		given:"go to create page"
			def createPage = to SurveyCreatePage
		
		when:"create survey by fill in create form"
			def name = "Survey Name"
			def obj = "objective of this survey"
			SurveyShowPage surveyShowPage = createPage.createSurvey(name,obj)

		then:"redirect to list page"
//			surveyRemote.findByName("Survey Name") != null
			surveyShowPage.nameValue == "Survey Name"
			
	}
}