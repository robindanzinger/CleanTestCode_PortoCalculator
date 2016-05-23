package cleantestcode.portorechner;

import org.junit.Assert;
import org.junit.Test;

import cleantestcode.portorechner.Brief;
import cleantestcode.portorechner.PortoRechner;

public class PortoRechnerTest5 {

	@Test
	public void Brief_140x90x5mm_20g_kostet_58() throws Exception {
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
	public void Brief_90x90x5mm_20g_wirft_eine_exception() throws Exception {
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
	public void Brief_140x90x5mm_40g_kostet_90() throws Exception {
		Brief brief = new Brief();
		brief.breite = 90;
		brief.laenge = 140;
		brief.hoehe = 5;
		brief.gewicht = 40;

		int ergebnis = PortoRechner.berechnePorto(brief);
		Assert.assertEquals(90, ergebnis);
	}

	@Test
	public void Brief_140x90x7mm_20g_kostet_90() throws Exception {
		Brief brief = new Brief();
		brief.breite = 90;
		brief.laenge = 140;
		brief.gewicht = 20;
		brief.hoehe = 7;

		int ergebnis = PortoRechner.berechnePorto(brief);
		Assert.assertEquals(90, ergebnis);
	}

	@Test
	public void Brief_140x90x5mm_20g_mit_internationalem_Ziel_kostet_75() throws Exception {
		Brief brief = new Brief();
		brief.breite = 90;
		brief.laenge = 140;
		brief.hoehe = 7;
		brief.gewicht = 20;
		brief.international = true;

		int ergebnis = PortoRechner.berechnePorto(brief);
		Assert.assertEquals(70, ergebnis);
	}

	@Test
	public void Brief_140x90x5mm_20g_mit_Einschreiben_kostet_218() throws Exception {
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
