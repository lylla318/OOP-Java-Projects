//Lylla Younes
//CS 2110
//net id: ley23
//PhD test class

/** An instance maintains info about the PhD of a person. */

public class PhD {
	private String name; // name of person with PhD, length > 0
	private int year; //year PhD was awarded
	private int month; /** month PhD was awarded, in 1..12, 
		with 1 meaning January, etc.*/
	private char gender; //gender of person, 'M' for male, 'F' for female
	private PhD first_ad; //person's first PhD advisor, null if unknown 
	private PhD second_ad; /**person's second PhD advisor, 
		null if unknown or if person had one advisor*/
	private int num_advisees; // number of person's PhD advisors
	
	/** Constructor 1: an instance with hour h and minute m.
     *  Precondition: n has at least 1 character, * m is in 1..12, 
     *  and g is 'M' for male or 'F' for female.*/
	
	public PhD(String n, char g, int y, int m){
		name = n;
		gender = g;
		year = y;
		month = m;
	}
	
	
	/** Constructor 2: a PhD with name n, gender g, PhD year y, PhD month m, first
	 * advisor ad, and no second advisor.
	 * Precondition: n has at least 1 char, g is 'F' for female or 'M' for male, m is in
	 * 1..12, and ad is not null.*/
	
	public PhD(String n, char g, int y, int m, PhD ad){
		name = n;
		gender = g;
		year = y;
		month = m;
		first_ad = ad;
	}
	
	/** Constructor 3: a PhD with name n, gender g, PhD year y, PhD month m, first
	 * advisor ad1, and second advisor ad2.
	 * Precondition: n has at least 1 char, g is 'F' for female or 'M' for male, m is in
	 * 1..12, ad1 and ad2 are not null, and ad1 and ad2 are different.*/
	
	public PhD(String n, char g, int y, int m, PhD ad, PhD ad2){
		name = n;
		gender = g;
		year = y;
		month = m;
		first_ad = ad;
		second_ad = ad2;	
	}
	
    
    /** = person's name */
    public String getName(){
    	return name;
    }
    
    /** = year this person got their PhD */
    public int getYear(){
    	return year;
    }
    
    /** = month this person got their PhD */
    public int getMonth(){
    	return month;
    }
    
    /** = Returns True if person is female, otherwise False */
    public boolean isFemale(){
    	return gender == 'F';
    }
    
    /** Returns this PhD's first advisor or null if unknown */
    public PhD getFirstAd(){
    	return first_ad;
    }
    
    /** Returns this PhD's second advisor or null if unknown or non-existent */
    public PhD getSecondAd(){
    	return second_ad; 
    }
    
    /** = month this person got their PhD */
    public int numAdvisees(){
    	return num_advisees;
    }
    

	/**Add p as this person's first PhD advisor.
	Precondition: this person's first advisor is unknown and p is not null.*/
	public void addAdvisor1(PhD p){
		assert p.getFirstAd() == null && p != null;
		first_ad = p;
		num_advisees = num_advisees + 1;
		
	}
	
	/**Add p as this persons second advisor.
	Precondition: This person's first advisor is known, their second advisor is
	unknown, p is not null, and p is different from this person's first advisor.*/
	
    public void addAdvisor2(PhD p){
    	assert p.getFirstAd() != null && p.getSecondAd() == null;
    	assert p != first_ad;
    	num_advisees = num_advisees + 1;
    }
    
    /** Return value of "this person got their PhD before p did."
     * Precondition: p is not null. */
    public boolean isOlderThan(PhD p){
    	assert p != null;
    	return this.getYear() < p.getYear() || (this.getYear() == p.getYear()
    			&& this.getMonth() < p.getMonth());
    }
    
    /**Return value of "this person and p are intellectual siblings.�
    Precondition: p is not null. */
    public boolean isPhDSibling(PhD p){
    	assert p != null;
    	return (this != p) && ((this.getFirstAd() == p.getFirstAd())
    			|| (this.getSecondAd() == p.getSecondAd()));
    }
 
    
    
}
