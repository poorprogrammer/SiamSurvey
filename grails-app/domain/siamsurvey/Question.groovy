package siamsurvey

/**
 * Question
 * A domain class describes the data object and it's mapping to the database
 */
class Question {
	static mapWith = "mongo"
	/* Default (injected) attributes of GORM */
//	Long	id
//	Long	version
	
	String id
	String thaiName
	
	/* Automatic timestamping of GORM */
	Date	dateCreated
	Date	lastUpdated
	
	
	QuestionGroup questionGroup
	QuestionType questionType
	static embedded = ['questionGroup', 'questionType']
	
	
	static	belongsTo	= [Survey]	// tells GORM to cascade commands: e.g., delete this object if the "parent" is deleted.
//	static	hasOne		= []	// tells GORM to associate another domain object as an owner in a 1-1 mapping
//	static	hasMany		= []	// tells GORM to associate other domain objects for a 1-n or n-m mapping
//	static	mappedBy	= []	// specifies which property should be used in a mapping 
	
    static	mapping = {
    }
    
	static	constraints = {
		id()
		thaiName(blank:false,nullable:false)
		questionGroup(nullable:false)
		questionType(nullable:false)
    }
	
	/*
	 * Methods of the Domain Class
	 */
//	@Override	// Override toString for a nicer / more descriptive UI 
//	public String toString() {
//		return "${name}";
//	}
}
