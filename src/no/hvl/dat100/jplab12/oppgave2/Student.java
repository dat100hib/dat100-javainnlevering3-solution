package no.hvl.dat100.jplab12.oppgave2;

public class Student extends Person {

	private int studentnummer;
	private String klasse;

	public Student() {
		super();
	}
	
	public Student(String etternamn, String fornamn, long fodselsnummer, int studentnummer, String klasse) {
		super(etternamn, fornamn, fodselsnummer);
		this.studentnummer = studentnummer;
		this.klasse = klasse;
	}

	
	public int getStudentnummer() {
		return studentnummer;
	}


	public void setStudentnummer(int studentnummer) {
		this.studentnummer = studentnummer;
	}


	public String getKlasse() {
		return klasse;
	}


	public void setKlasse(String klasse) {
		this.klasse = klasse;
	}


	@Override
	public String toString() {
		return "STUDENT" + "\n" + super.toString() + studentnummer + "\n" + klasse + "\n";

	}

}
