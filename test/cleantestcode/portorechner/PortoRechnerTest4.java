package cleantestcode.portorechner;

import org.junit.Assert;
import org.junit.Test;

import cleantestcode.portorechner.Brief;
import cleantestcode.portorechner.PortoRechner;

public class PortoRechnerTest4 {

	@Test
	public void testBerechnePortoMit140x90x5Und20g() throws Exception {
		// Arrange
		Brief brief = new Brief();
		brief.breite = 90;
		brief.laenge = 140;
		brief.hoehe = 5;
		brief.gewicht = 20;

		// Act
		int ergebnis = PortoRechner.berechnePorto(brief);
	
		// Assert
		Assert.assertEquals(58, ergebnis);
	}

	@Test
	public void testBerechnePortoMit90x90x5Und20g() throws Exception {
		Brief brief = new Brief();
		brief.breite = 90;
		brief.hoehe = 5;
		brief.gewicht = 20;
		brief.laenge = 90;

		try {
			PortoRechner.berechnePorto(brief);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(
					"Brief entspricht nicht der geforderten Norm: Die Länge muss mindestens das 1,4-fache der Breite betragen.",
					e.getMessage());
			// ok
		}
	}

	@Test
	public void testBerechnePortoMit140x90x5Und40g() throws Exception {
		Brief brief = new Brief();
		brief.breite = 90;
		brief.laenge = 140;
		brief.hoehe = 5;
		brief.gewicht = 40;

		int ergebnis = PortoRechner.berechnePorto(brief);
		Assert.assertEquals(90, ergebnis);
	}

	@Test
	public void testBerechnePortoMit140x90x7Und20g() throws Exception {
		Brief brief = new Brief();
		brief.breite = 90;
		brief.laenge = 140;
		brief.gewicht = 20;
		brief.hoehe = 7;

		int ergebnis = PortoRechner.berechnePorto(brief);
		Assert.assertEquals(90, ergebnis);

	}

	@Test
	public void testBerechnePortoMit140x90x5Und20gUndInternational() throws Exception {
		Brief brief = new Brief();
		brief.breite = 90;
		brief.laenge = 140;
		brief.hoehe = 5;
		brief.gewicht = 20;
		brief.international = true;

		int ergebnis = PortoRechner.berechnePorto(brief);
		Assert.assertEquals(70, ergebnis);
	}

	@Test
	public void testBerechnePortoMit140x90x5Und20gUndEinschreiben() throws Exception {
		Brief brief = new Brief();
		brief.breite = 90;
		brief.laenge = 140;
		brief.hoehe = 5;
		brief.gewicht = 20;
		brief.einschreiben = true;

		int ergebnis = PortoRechner.berechnePorto(brief);
		Assert.assertEquals(218, ergebnis);
	}
}
