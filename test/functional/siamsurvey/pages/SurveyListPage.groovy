package siamsurvey.pages

class SurveyListPage extends geb.Page {
  
  static url = "survey/index"

  static content = {
    
    heading { $("h1").text() }
    message { $("div.message").text() }
    
    surveyTable { $("div.content table", 0) }

  }

}
