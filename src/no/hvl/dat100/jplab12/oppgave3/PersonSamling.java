package no.hvl.dat100.jplab12.oppgave3;

public class PersonSamling {

	private int nesteledig;
	Person[] persontabell;
	private int LENGDE = 20;

	public PersonSamling() {
		nesteledig = 0;
		persontabell = new Person[LENGDE];
	}

	public PersonSamling(int lengde) {
		nesteledig = 0;
		persontabell = new Person[lengde];
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Person[] getSamling() {
		return persontabell;
	}
	
	public int finnPerson(Person p) {

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

	public boolean finnes(Person p) {
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
		Person[] nytabell = new Person[2 * persontabell.length];

		for (int i = 0; i < nesteledig; i++) {
			nytabell[i] = persontabell[i];
		}

		persontabell = nytabell;
	}

	public boolean ledigPlass() {
		return (nesteledig < persontabell.length);
	}

	public boolean leggTil(Person p) {

		boolean lagttil = false;
		
		if (!finnes(p) && ledigPlass()) {
			persontabell[nesteledig] = p;
			nesteledig++;
			lagttil = true;
		}
		
		return lagttil;
	}
	
	public boolean leggTilUtvid(Person p) {

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
	
	public void slett(Person p) {
		
		int index = finnPerson(p);
		
		if (index>=0) {
			persontabell[index] = persontabell[nesteledig-1];
			persontabell[nesteledig-1] = null;
			nesteledig--;
		}
	}
}