package cleantestcode.portorechner;

public class BriefTypErmittler {

	public static BriefTyp ermittleType(Brief brief) throws Exception {
		
		pruefeFormat(brief);
		
		if (istStandardbrief(brief)) {
			return BriefTyp.StandardBrief;
		}
		
		if (istKompaktbrief(brief)) {
			return BriefTyp.KompaktBrief;
		}
		
		if (istGrossbrief(brief)) {
			return BriefTyp.GrossBrief;
		}
		
		throw new Exception("Brief entspricht nicht der geforderten Norm");
	}

	private static boolean istGrossbrief(Brief brief) {
		return brief.hoehe < 51 
				&& brief.laenge < 354 
				&& brief.laenge > 99
				&& brief.breite < 251 
				&& brief.breite > 69
				&& brief.gewicht < 501;
	}

	private static boolean istKompaktbrief(Brief brief) {
		return brief.hoehe < 11 
				&& brief.laenge < 236 
				&& brief.laenge > 99
				&& brief.breite < 251 
				&& brief.breite > 69
				&& brief.gewicht < 51;
	}

	private static boolean istStandardbrief(Brief brief) {
		return brief.hoehe < 6 
				&& brief.laenge < 236 
				&& brief.laenge > 139
				&& brief.breite < 126 
				&& brief.breite > 89
				&& brief.gewicht < 21;
	}
	
	private static void pruefeFormat(Brief brief) throws Exception {
		boolean ok = brief.laenge >= 1.4 * brief.breite;
		if (!ok) {
			throw new Exception("Brief entspricht nicht der geforderten Norm: Die Länge muss mindestens das 1,4-fache der Breite betragen.");
		}
	}
	
}
