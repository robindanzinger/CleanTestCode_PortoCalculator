package cleantestcode.portorechner;

public class PortoRechner_International {

	public static int berechnePortoInternational(Brief brief) throws Exception {
		BriefTyp type = BriefTypErmittler.ermittleType(brief);
		int porto = ermittleEinfachesPortoFuer(type);
		int einschreibeZuschlag = ermittleEinschreibeZuschlag(brief);
		return porto + einschreibeZuschlag;
	}

	private static int ermittleEinfachesPortoFuer(BriefTyp type) {
		switch (type) {
			case StandardBrief : return 75;
			case KompaktBrief : return 150;
			case GrossBrief : return 345;
			default : return 75;
		}
	}

	private static int ermittleEinschreibeZuschlag(Brief brief) {
		return brief.einschreiben ? 205 : 0;
	}
	
}
