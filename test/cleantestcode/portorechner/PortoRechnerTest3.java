package cleantestcode.portorechner;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cleantestcode.portorechner.Brief;
import cleantestcode.portorechner.PortoRechner;

public class PortoRechnerTest3 {
	
	Brief brief;
	
	@Before
	public void setupBrief() {
		brief = new Brief();
		brief.breite = 90;
		brief.laenge = 140;
		brief.hoehe = 5;
		brief.gewicht = 20;
	}
	
	@Test
	public void testBerechnePorto1() throws Exception {
		int ergebnis = PortoRechner.berechnePorto(brief);
		Assert.assertEquals(58, ergebnis);
	}
	
	@Test
	public void testBerechnePorto2() throws Exception {		

		try {
			PortoRechner.berechnePorto(brief);			
			Assert.fail();
		}
		catch (Exception e) {
			Assert.assertEquals("Brief entspricht nicht der geforderten Norm: Die Länge muss mindestens das 1,4-fache der Breite betragen.", e.getMessage());
			//ok
		}
	}
	
	@Test
	public void testBerechnePorto3() throws Exception {
		brief.gewicht = 40;
		
		int ergebnis = PortoRechner.berechnePorto(brief);
		Assert.assertEquals(90, ergebnis);
	}
	@Test
	public void testBerechnePorto4() throws Exception {
		brief.gewicht = 20;
		brief.hoehe = 7;
		
		int ergebnis = PortoRechner.berechnePorto(brief);
		Assert.assertEquals(90, ergebnis);

	}
	@Test
	public void testBerechnePorto5() throws Exception {
		brief.international = true;
		
		int ergebnis = PortoRechner.berechnePorto(brief);
		Assert.assertEquals(75, ergebnis);
	}
	@Test
	public void testBerechnePorto6() throws Exception {
		brief.einschreiben = true;
		
		int ergebnis = PortoRechner.berechnePorto(brief);
		Assert.assertEquals(218, ergebnis);
	}
}
