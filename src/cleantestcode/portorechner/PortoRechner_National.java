package cleantestcode.portorechner;

public class PortoRechner_National {
	
	public static int berechnePortoNational(Brief brief) throws Exception {
		BriefTyp type = BriefTypErmittler.ermittleType(brief);
		int porto = ermittleEinfachesPortoFuer(type);
		int einschreibeZuschlag = ermittleEinschreibeZuschlag(brief);
		return porto + einschreibeZuschlag;
	}
	
	private static int ermittleEinfachesPortoFuer(BriefTyp type) {
		switch (type) {
			case StandardBrief : return 58;
			case KompaktBrief : return 90;
			case GrossBrief : return 145;
			default : return 58;
		}
	}
	
	private static int ermittleEinschreibeZuschlag(Brief brief) {
		return brief.einschreiben ? 160 : 0;
	}
}
