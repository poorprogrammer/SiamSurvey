package siamsurvey.pages

class SurveyShowPage extends geb.Page {
  
  static url = "survey/show"

  static content = {
    
    heading { $("h1").text() }
    message { $("div.message").text() }
    
	nameValueElement(wait: true) { $("span#surveyName") }
//    surveyTable { $("div.content table", 0) }
  }

  def getNameValue(){
	  return nameValueElement.text()
  }
  
  
}
