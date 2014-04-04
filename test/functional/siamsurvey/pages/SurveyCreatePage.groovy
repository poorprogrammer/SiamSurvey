package siamsurvey.pages

class SurveyCreatePage extends geb.Page {
  
  static url = "survey/create"

  static content = {
    heading { $("h1").text() }
    message { $("div.message").text() }
	
	nameInput(wait: true) { $("input#name") }
	createButton(wait: true, to: SurveyShowPage) { $("input#create") }
	
  }

  SurveyShowPage createSurvey(String name, String obj){
  	nameInput.value(name)
	createButton.click() 
	return browser.page  
  }
  
  
}
