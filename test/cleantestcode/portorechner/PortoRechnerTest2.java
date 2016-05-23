package cleantestcode.portorechner;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import cleantestcode.portorechner.Brief;
import cleantestcode.portorechner.PortoRechner;

public class PortoRechnerTest2 {

	static Brief brief;

	@BeforeClass
	public static void setupBrief() {
		brief = new Brief();
		brief.breite = 90;
		brief.laenge = 140;
		brief.hoehe = 5;
		brief.gewicht = 20;
	}

	@Test
	public void test1() throws Exception {
		int ergebnis = PortoRechner.berechnePorto(brief);
		Assert.assertEquals(58, ergebnis);
	}

	@Test
	public void test2() throws Exception {
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
	//	brief.laenge = 140;
	}

	@Test
	public void test3() throws Exception {
		brief.gewicht = 40;

		int ergebnis = PortoRechner.berechnePorto(brief);
		Assert.assertEquals(90, ergebnis);
	}

	@Test
	public void test4() throws Exception {
		brief.gewicht = 20;
		brief.hoehe = 7;

		int ergebnis = PortoRechner.berechnePorto(brief);
		Assert.assertEquals(90, ergebnis);

	}

	@Test
	public void test5() throws Exception {
		brief.international = true;
		brief.hoehe = 5;

		int ergebnis = PortoRechner.berechnePorto(brief);
		Assert.assertEquals(75, ergebnis);
	}

	@Test
	public void test6() throws Exception {
		brief.einschreiben = true;
		brief.international = false;

		int ergebnis = PortoRechner.berechnePorto(brief);
		Assert.assertEquals(218, ergebnis);
	}

}
