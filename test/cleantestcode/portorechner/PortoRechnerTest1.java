package cleantestcode.portorechner;


import org.junit.Assert;
import org.junit.Test;

import cleantestcode.portorechner.Brief;
import cleantestcode.portorechner.PortoRechner;

public class PortoRechnerTest1 {
	
	// WAS IST AN DIESEM TESTCODE UNSCHÖN?
	
	@Test
	public void test() throws Exception {
		Brief b = new Brief();
		b.breite = 90;
		b.laenge = 140;
		b.hoehe = 5;
		b.gewicht = 20;
		
		int ergebnis = PortoRechner.berechnePorto(b);
		Assert.assertEquals(58, ergebnis);

		b.laenge = 90;
		
		try {
			ergebnis = PortoRechner.berechnePorto(b);			
			Assert.fail();
		}
		catch (Exception e) {
			Assert.assertEquals("Brief entspricht nicht der geforderten Norm: Die Länge muss mindestens das 1,4-fache der Breite betragen.", e.getMessage());
			//ok
		}
		
		b.laenge = 140;
		b.hoehe = 7;
		
		ergebnis = PortoRechner.berechnePorto(b);
		Assert.assertEquals(90, ergebnis);

		b.hoehe = 5;
		b.gewicht = 40;
		
		ergebnis = PortoRechner.berechnePorto(b);
		Assert.assertEquals(90, ergebnis);

		b.gewicht = 20;
		b.international = true;
		
		ergebnis = PortoRechner.berechnePorto(b);
		Assert.assertEquals(90, ergebnis);

		b.einschreiben = true;
		
		ergebnis = PortoRechner.berechnePorto(b);
		Assert.assertEquals(280, ergebnis);

		b.international = false;
		
		ergebnis = PortoRechner.berechnePorto(b);
		Assert.assertEquals(218, ergebnis);
		
	}

}
