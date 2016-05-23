package cleantestcode.portorechner;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import cleantestcode.portorechner.Brief;
import cleantestcode.portorechner.BriefBuilder;
import cleantestcode.portorechner.BriefTyp;
import cleantestcode.portorechner.BriefTypErmittler;

public class BriefTypErmittlerTest {

	@Test
	public void Brief_140x90x5mm_soll_ein_Standardbrief_sein() throws Exception {
		Brief brief = BriefBuilder.erstelleBrief().mitLaenge(140).mitBreite(90).mitHoehe(5).build();
		BriefTyp erwarteterType = BriefTyp.StandardBrief;
		BriefTyp ermittelterType = BriefTypErmittler.ermittleType(brief);
		Assert.assertEquals(erwarteterType, ermittelterType);
	}

	@Test
	public void Brief_140x90x6mm_soll_ein_Kompaktbrief_sein() {
		fail("Not yet implemented");
	}
	
	@Test
	public void Brief_140x90x10mm_soll_ein_Kompaktbrief_sein() {
		fail("Not yet implemented");
	}

	@Test
	public void Brief_140x90x11mm_soll_ein_Grossbrief_sein() {
		fail("Not yet implemented");
	}

	@Test
	public void Brief_140x90x5mm_und_schwerer_als_20g_soll_ein_Kompaktbrief_sein() {
		fail("Not yet implemented");
	}

	@Test
	public void soll_Fehler_werfen_wenn_Laenge_nicht_das_1_komma_4_fache_der_Breite_betraegt() {
		fail("Not yet implemented");
	}
	
}
