package no.hvl.dat100.jplab12.oppgave3;

public class PersonSamling {

	private int nesteledig;
	Innlegg[] persontabell;
	private int LENGDE = 20;

	public PersonSamling() {
		nesteledig = 0;
		persontabell = new Innlegg[LENGDE];
	}

	public PersonSamling(int lengde) {
		nesteledig = 0;
		persontabell = new Innlegg[lengde];
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return persontabell;
	}
	
	public int finnPerson(Innlegg p) {

		int index = -1;
		int i = 0;
		while (i < nesteledig && index < 0) {
			if (persontabell[i].erLik(p)) {
				index = i;
			} else {
				i++;
			}
		}

		return index;
	}

	public boolean finnes(Innlegg p) {
		return (finnPerson(p) >= 0);
	}

	public String toString() {
		String text = Integer.toString(nesteledig) + "\n";

		for (int i = 0; i < nesteledig; i++) {
			text = text + persontabell[i].toString();
		}

		return text;
	}

	public void utvid() {
		Innlegg[] nytabell = new Innlegg[2 * persontabell.length];

		for (int i = 0; i < nesteledig; i++) {
			nytabell[i] = persontabell[i];
		}

		persontabell = nytabell;
	}

	public boolean ledigPlass() {
		return (nesteledig < persontabell.length);
	}

	public boolean leggTil(Innlegg p) {

		boolean lagttil = false;
		
		if (!finnes(p) && ledigPlass()) {
			persontabell[nesteledig] = p;
			nesteledig++;
			lagttil = true;
		}
		
		return lagttil;
	}
	
	public boolean leggTilUtvid(Innlegg p) {

		boolean lagttil = false;
		
		if (!finnes(p)) {

			if (!ledigPlass()) {
				utvid();
			}

			persontabell[nesteledig] = p;
			nesteledig++;
			lagttil = true;
		}
		
		return lagttil;
	}
	
	public void slett(Innlegg p) {
		
		int index = finnPerson(p);
		
		if (index>=0) {
			persontabell[index] = persontabell[nesteledig-1];
			persontabell[nesteledig-1] = null;
			nesteledig--;
		}
	}
}