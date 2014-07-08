package siamsurvey

class Survey implements Serializable{
	
	static mapWith = "mongo"
	
	private static final long serialVersionUID = 1L
	String thaiName;
	String objective;
	List questions;
	
	static	hasMany	= [questions:Question];
	
	static constraints = {
		objective nullable:true, blank:true;
	}

}
