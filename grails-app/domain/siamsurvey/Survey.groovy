package siamsurvey

class Survey implements Serializable{
	private static final long serialVersionUID = 1L
	String name
	String objective
	
	static constraints = {
    	
		objective nullable:true, blank:true 
    }

}
