package cleantestcode.portorechner;

import static cleantestcode.portorechner.PortoRechner_International.berechnePortoInternational;
import static cleantestcode.portorechner.PortoRechner_National.berechnePortoNational;

public class PortoRechner_Alternative_Flow {

	public static int berechnePorto(Brief brief) throws Exception {
		if (brief.international) {
			return berechnePortoInternational(brief);
		} 
		return berechnePortoNational(brief);
	}
}
