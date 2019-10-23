package no.hvl.dat100.jplab12.oppgave2;

import no.hvl.dat100.jplab12.oppgave1.*;

public class Bilde extends Innlegg {

	private String url;

	public Bilde() {
		super();
	}
	
	public Bilde(int id, String bruker, String dato, String url) {
		super(id, bruker, dato);
		this.url = url;
	}

	public Bilde(int id, String bruker, String dato, int likes, String url) {
		super(id, bruker, dato, likes);
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "BILDE" + "\n" + super.toString() + url + "\n";

	}

}
