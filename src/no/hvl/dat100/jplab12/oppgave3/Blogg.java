package no.hvl.dat100.jplab12.oppgave3;

import no.hvl.dat100.jplab12.oppgave1.*;

public class Blogg {

	private int nesteledig;
	private Innlegg[] innleggtabell;
	private static int LENGDE = 20;

	public Blogg() {
		nesteledig = 0;
		innleggtabell = new Innlegg[LENGDE];
	}

	public Blogg(int lengde) {
		nesteledig = 0;
		innleggtabell = new Innlegg[lengde];
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {

		int index = -1;
		int i = 0;
		while (i < nesteledig && index < 0) {
			if (innleggtabell[i].erLik(innlegg)) {
				index = i;
			} else {
				i++;
			}
		}

		return index;
	}

	public boolean finnes(Innlegg innlegg) {
		return (finnInnlegg(innlegg) >= 0);
	}

	public boolean ledigPlass() {
		return (nesteledig < innleggtabell.length);
	}
	
	public boolean leggTil(Innlegg innlegg) {

		boolean lagttil = false;
		
		if (!finnes(innlegg) && ledigPlass()) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			lagttil = true;
		}
		
		return lagttil;
	}
	
	public String toString() {
		String text = Integer.toString(nesteledig) + "\n";

		for (int i = 0; i < nesteledig; i++) {
			text = text + innleggtabell[i].toString();
		}

		return text;
	}

	public void utvid() {
		Innlegg[] nytabell = new Innlegg[2 * innleggtabell.length];

		for (int i = 0; i < nesteledig; i++) {
			nytabell[i] = innleggtabell[i];
		}

		innleggtabell = nytabell;
	}
	public boolean leggTilUtvid(Innlegg innlegg) {

		boolean lagttil = false;
		
		if (!finnes(innlegg)) {

			if (!ledigPlass()) {
				utvid();
			}

			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			lagttil = true;
		}
		
		return lagttil;
	}
	
	public void slett(Innlegg innlegg) {
		
		int index = finnInnlegg(innlegg);
		
		if (index>=0) {
			innleggtabell[index] = innleggtabell[nesteledig-1];
			innleggtabell[nesteledig-1] = null;
			nesteledig--;
		}
	}
	
	public int[] search(String keyword) {
		
		// TODO: get list of all entries from a given user
		return null;
	}
}