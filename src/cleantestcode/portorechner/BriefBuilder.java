package cleantestcode.portorechner;

public class BriefBuilder {

	public static BriefBuilder erstelleBrief() {
		return new BriefBuilder();
	}
	
	public static BriefBuilder erstelleStandardBrief() {
		return BriefBuilder.erstelleBrief().mitLaenge(140).mitBreite(90).mitHoehe(5).mitGewicht(20);
	}

	public static BriefBuilder erstelleKompaktBrief() {
		return BriefBuilder.erstelleBrief().mitLaenge(140).mitBreite(90).mitHoehe(5).mitGewicht(50);
	}
	
	public static BriefBuilder erstelleGrossBrief() {
		return BriefBuilder.erstelleBrief().mitLaenge(140).mitBreite(90).mitHoehe(15).mitGewicht(350);
	}
	
	private Brief brief;
	
	private BriefBuilder() {
		brief = new Brief();
	}
	
	public BriefBuilder mitLaenge(int laenge) {
		brief.laenge = laenge;
		return this;
	}

	public BriefBuilder mitBreite(int breite) {
		brief.breite = breite;
		return this;
	}

	public BriefBuilder mitHoehe(int hoehe) {
		brief.hoehe = hoehe;
		return this;
	}

	public BriefBuilder mitGewicht(int gewicht) {
		brief.gewicht = gewicht;
		return this;
	}
	
	public BriefBuilder mitEinschreiben() {
		brief.einschreiben = true;
		return this;
	}
	
	public BriefBuilder mitInternationalemZiel() {
		brief.international = true;
		return this;
	}

	public Brief build() {
		return brief;
	}
	
}
