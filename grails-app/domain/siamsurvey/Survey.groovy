package siamsurvey

class Survey {
	String name
	String objective
	
	static constraints = {
    	name()
		objective nullable:true, blank:true 
    }

}
