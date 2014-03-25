package siamsurvey.pages

class SurveyCreatePage extends geb.Page {
  
  static url = "survey/create"

  static content = {
    
    heading { $("h1").text() }
    message { $("div.message").text() }
    
    surveyTable { $("div.content table", 0) }

  }

}
