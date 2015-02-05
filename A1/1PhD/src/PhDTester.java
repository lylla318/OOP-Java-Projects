//Lylla Younes
//CS 2110
//net id: ley23
//PhD test class

import static org.junit.Assert.*;

import org.junit.Test;


public class PhDTester {
	
	@Test
	//test first constructor
    public void testConstructor1(){
		PhD p = new PhD("Sue Younes", 'F', 1995, 2);
		// assertEquals(expected val, computed val);
		assertEquals("Sue Younes", p.getName());
		assertEquals(true, p.isFemale());
		assertEquals(1995, p.getYear());
		assertEquals(2, p.getMonth());
		
		PhD p2 = new PhD("Philipp Hanna", 'M', 2002, 12);
		assertEquals("Philipp Hanna", p2.getName());
		assertEquals(false, p2.isFemale());
		assertEquals(2002, p2.getYear());
		assertEquals(12, p.getMonth());
	}
	
	//testing setters
	public void testSetters(){
		PhD p3 = new PhD("Maheer Iqbal", 'M', 1993, 4);
		PhD p4 = new PhD("Bingyi Wang", 'F', 1996, 8);
		PhD p5 = new PhD("Amina Ayoub", 'F', 1982, 1);
		//assign first advisor to p3;
		p3.addAdvisor1(p4);
		//check that first advisor was assigned;
		assertEquals(p3.getFirstAd(), p4);
		assertEquals(p3.numAdvisees(),1);
		//assign second advisor to p3
		p3.addAdvisor2(p5);
		//check that second advisor was assigned;
		assertEquals(p3.getSecondAd(), p5);
		assertEquals(p3.numAdvisees(),2);
	}
	
	//testing second constructor
	public void testConstructor2(){
		PhD jabari = new PhD("Jabari Brown", 'M', 2014, 2);
		PhD ali = new PhD("Ali Bazzi", 'M', 1977, 5, jabari);
		// assertEquals(expected value, computed value);
		assertEquals("Ali Bazzi", ali.getName());
		assertEquals(false, ali.isFemale());
		assertEquals(1977, ali.getYear());
		assertEquals(5, ali.getMonth());
		assertEquals(jabari, ali.getFirstAd());
		assertEquals(1,ali.numAdvisees());
	}
	
	//testing first constructor
	public void testConstructor3(){
		PhD jess = new PhD("Jess Abramson", 'F', 2011, 4);
		PhD maria = new PhD("Maria Heiburg", 'F',2007, 10);
		PhD ali = new PhD("Ali Bazzi", 'M', 1977, 5, jess, maria);
		// assertEquals(expected value, computed value);
		assertEquals("Ali Bazzi", ali.getName());
		assertEquals(false, ali.isFemale());
		assertEquals(1977, ali.getYear());
		assertEquals(5, ali.getMonth());
		assertEquals(jess, ali.getFirstAd());
		assertEquals(maria, ali.getSecondAd());
		assertEquals(2,ali.numAdvisees());
	}
	
	
	public void testOlderThan(){
		PhD maria = new PhD("Maria Heiburg", 'F',2007, 10);
		PhD ali = new PhD("Ali Bazzi", 'M', 1977, 5);
		PhD celina = new PhD("Celina Scott", 'F', 2000, 2);
		PhD robert = new PhD("Robert Bettinger", 'M', 2000, 4);
		PhD jess = new PhD("Jess Abramson", 'F', 2007, 10);
		// test case with different years
		assertEquals(true, ali.isOlderThan(maria));
		// test case with same year and different months;
		assertEquals(false, robert.isOlderThan(celina));
		//test case with same month and year;
		assertEquals(false, jess.isOlderThan(maria));
		
		
	}
	
	public void testPhDSibling(){
		PhD jess = new PhD("Jess Abramson", 'F', 2011, 4);
		PhD maria = new PhD("Maria Heiburg", 'F',2007, 10);
		PhD ali = new PhD("Ali Bazzi", 'M', 1977, 5);
		PhD celina = new PhD("Celina Scott", 'F', 2000, 2, jess, maria);
		PhD robert = new PhD("Robert Bettinger", 'M', 2000, 4, jess, ali);
		PhD zakiya = new PhD("Zayika Williams-Wells", 'F', 1999, 5, robert, ali);
		PhD david = new PhD("David Folarin", 'M', 2017, 12, robert, maria);
		// test case where two people are siblings, first advisors in common;
		assertEquals(true, celina.isPhDSibling(robert));
		// test case where two people are siblings, second advisors in common;
		assertEquals(true, david.isPhDSibling(celina));
		// test case when two people are not siblings;
		assertEquals(false, zakiya.isPhDSibling(celina));
	}
	
	
}
