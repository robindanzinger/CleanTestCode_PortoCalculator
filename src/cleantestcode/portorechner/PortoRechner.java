package cleantestcode.portorechner;

public class PortoRechner {

	public static int berechnePorto(Brief brief) throws Exception {
		BriefTyp type = BriefTypErmittler.ermittleType(brief);
		int porto = brief.international ? ermittlePortoInternationalFuer(type) : ermittlePortoFuer(type);
		int einschreibeZuschlag = ermittleEinschreibeZuschlag(brief);
		return porto + einschreibeZuschlag;
	}

	public static int ermittlePortoFuer(BriefTyp type) {
		switch (type) {
			case StandardBrief : return 58;
			case KompaktBrief : return 90;
			case GrossBrief : return 145;
			default : return 58;
		}
	}
	
	public static int ermittlePortoInternationalFuer(BriefTyp type) {
		switch (type) {
			case StandardBrief : return 75;
			case KompaktBrief : return 150;
			case GrossBrief : return 345;
			default : return 75;
		}
	}
			
	public static int ermittleEinschreibeZuschlag(Brief brief) {
		if (brief.einschreiben && brief.international) {
			return 205;
		}
		if (brief.einschreiben) {
			return 160;
		}
		return 0;
	}

}
