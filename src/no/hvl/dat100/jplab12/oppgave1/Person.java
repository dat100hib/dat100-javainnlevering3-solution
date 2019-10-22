package no.hvl.dat100.jplab12.oppgave1;

public abstract class Person {

	private String etternamn;
	private String fornamn;
	private long fodselsnummer;
	
	public Person() {
		super();
	}

	public Person(String etternamn, String fornamn, long fodselsnummer) {
		this.fodselsnummer = fodselsnummer;
		this.etternamn = etternamn;
		this.fornamn = fornamn;
	}

	
	public String getEtternamn() {
		return etternamn;
	}

	public void setEtternamn(String etternamn) {
		this.etternamn = etternamn;
	}

	public String getFornamn() {
		return fornamn;
	}

	public void setFornamn(String fornamn) {
		this.fornamn = fornamn;
	}
	
	public void setFodselsnummer(long fodselsnummer) {
		this.fodselsnummer = fodselsnummer;
	}
	
	public long getFodselsnummer() {
		return fodselsnummer;
	}
	
	public boolean erLik(Person person) {
		return (fodselsnummer == person.getFodselsnummer());
	}
	
	public boolean erKvinne() {
		return ((fodselsnummer / 100 )% 2) != 0;
	}
	
	public boolean erMann() {
		return (!erKvinne());	
	}
	
	@Override
	public String toString() {
		return fodselsnummer + "\n" +
			   etternamn + "\n" +
			   fornamn + "\n";
	}
}
