package siamsurvey

import java.util.List;

class QuestionGroup {
	static mapWith = "mongo"
	
//	List questions
//    static hasMany = [ questions: Question ]
	
//    static belongsTo = [ surveyMaster : SurveyMaster ]

	String id
    String thaiName
    String englishName

//	int questionSize(){
//		def questionCount = 0
//		questions.each{
//			if(it.questionType.id.toString() == QuestionType.RANKING_SCORE){
//				questionCount = questionCount + it.questionListThai.size()
//			}else{
//				questionCount++
//			}
//		}
//		questionCount
//	}  
	
    static constraints = {
//		surveyMaster(nullable:true)
		id()
		thaiName(blank:false,nullable:false)
		englishName(blank:true,nullable:true)
    }
}
