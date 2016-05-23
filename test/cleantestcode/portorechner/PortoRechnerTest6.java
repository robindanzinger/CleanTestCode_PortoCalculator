package cleantestcode.portorechner;


import org.junit.Assert;
import org.junit.Test;

import cleantestcode.portorechner.Brief;
import cleantestcode.portorechner.BriefBuilder;
import cleantestcode.portorechner.PortoRechner;

public class PortoRechnerTest6 {
	
	@Test
	public void Standardbrief_soll_58_Cent_kosten() throws Exception {
		// Arrange
		Brief standardBrief = BriefBuilder.erstelleStandardBrief().build();
		int erwartetesPorto = 58;
		
		// Act
		int berechnetesPorto = PortoRechner.berechnePorto(standardBrief);
		
		// Assert
		Assert.assertEquals(erwartetesPorto, berechnetesPorto);
	}

	@Test
	public void Standardbrief_mit_Einschreiben_soll_218_Cent_kosten() throws Exception {
		Brief standardbrief = BriefBuilder.erstelleStandardBrief().mitEinschreiben().build();	
		int erwartetesPorto = 218;
		int berechnetesPorto = PortoRechner.berechnePorto(standardbrief);
		Assert.assertEquals(erwartetesPorto, berechnetesPorto);
	}

	@Test
	public void Kompaktbrief_soll_90_Cent_kosten() throws Exception {
		Brief kompaktbrief = BriefBuilder.erstelleKompaktBrief().build();
		int erwartetesPorto = 80;
		int berechnetesPorto = PortoRechner.berechnePorto(kompaktbrief);
		Assert.assertEquals(erwartetesPorto, berechnetesPorto);
	}
	
	@Test
	public void Grossbrief_soll_145_Cent_kosten() throws Exception {
		Brief grossbrief = BriefBuilder.erstelleGrossBrief().build();
		int erwartetesPorto = 145;
		int berechnetesPorto = PortoRechner.berechnePorto(grossbrief);
		Assert.assertEquals(erwartetesPorto, berechnetesPorto);
	}

	@Test
	public void Internationaler_Standardbrief_soll_75_Cent_kosten() throws Exception {
		Brief internationalerStandardBrief = BriefBuilder.erstelleStandardBrief().mitInternationalemZiel().build();
		int erwartetesPorto = 75;
		int berechnetesPorto = PortoRechner.berechnePorto(internationalerStandardBrief);
		Assert.assertEquals(erwartetesPorto, berechnetesPorto);
	}
	
	@Test
	public void Ungueltiges_Briefformat_soll_einen_Fehler_werfen() throws Exception {
		Brief grossbrief = BriefBuilder.erstelleBrief().mitBreite(90).mitLaenge(90).build();
		String erwarteteFehlermeldung = "Brief entspricht nicht der geforderten Norm: Die Länge muss mindestens das 1,4-fache der Breite betragen.";
		try {
			PortoRechner.berechnePorto(grossbrief);
			Assert.fail();
		}
		catch (Exception e) {
			Assert.assertEquals(erwarteteFehlermeldung, e.getMessage());
		}
	}
}
