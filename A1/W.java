/** Maintain info about a worker */
public class W {
    private String lastName; //worker's last name
    private int ssn; // worker's social security number
    private W boss; // worker's boss (null if none)

    /** Constructor: worker with last name n,  SSN s,
     * boss boss (null if none).
     * Precondition:  n not null,  s in 0..999999999 with
     *                no leading zeros.*/
    public W(String n, int s, W b) {
        lastName= n;
        ssn= 0;
        boss= b;   
    }

    /** = worker's last name */
    public String getLname() {
        return lastName;
    }

    /** = last 4 SSN digits */
    public String getSsn() {
        String s= "000000000" + ssn;
        return s.substring(s.length() - 4);
    }

    /** = worker's boss (null if none) */
    public W getBoss() {
        return boss;
    }

    /** Set boss to b.
     * @param b is the boss */
    public void setBoss(W b) {
        boss= b;
    }

    /** = "this person is c's boss."
    Precondition: c is not null. */
    public  boolean isBoss(W c) {
        return this == c.boss;
    }
    
    /** = "b is c's boss."
    Precondition: c is not null. */
    public static boolean isBoss(W b, W c) {
        return b == c.boss;
    }

// <boolean exp> ? <exp1> : <exp2>
    /** = representation of this Worker, with boss'es last name
          (if it exists). */
    public  @Override String toString() {
        return getLname() + " " + getSsn() + " " + 
          (boss == null ? "null" : boss.getLname());
    }
    
    /** application, to demo features of class W */
    public static void main(String[] pars) {
        System.out.println("pars[0]: " + pars[0]);
        System.out.println("pars[1]: " + pars[1]);

        W ws= new W("Saxena", 687356, null);
        System.out.println("ws's toString produces " + ws);

        W wg= new W("Gries", 94, null);
        System.out.println("wg's toString produces " + wg);
    }
}
