package siamsurvey.remote
import grails.plugin.remotecontrol.RemoteControl
import siamsurvey.*
class SurveyRemoteControl {

	RemoteControl remote = new RemoteControl()

	//	Survey createSurvey(String name, String objective) {
	//		remote {
	//			Survey survey = new Survey(
	//					name: name,
	//					objective: objective
	//					)
	//
	//			survey.save()
	//		}
	//	}

	Survey findByName(String name) {
		remote {  Survey.findByName(name)  }
	}
	//
	//	void deleteAllIdeas() {
	//		remote {
	//			Idea.list().each { it.delete() }
	//		}
	//	}
}
