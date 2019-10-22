package no.hvl.dat100.jplab12.oppgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Filer {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jpl9/";

	private static String STUDENT = "STUDENT";
	private static String LAERER = "LAERER";

	public boolean skriv(PersonSamling samling, String filnavn) {

		boolean skrevet = true;
		PrintWriter writer = null;

		try {
			writer = new PrintWriter(MAPPE + filnavn);

			writer.print(samling.toString());

			writer.close();

		} catch (FileNotFoundException e) {
			skrevet = false;
		}

		return skrevet;
	}

	public PersonSamling les(String filnavn) {

		PersonSamling samling = null;

		try {

			File file = new File(MAPPE + filnavn);
			Scanner reader = new Scanner(file);

			String line;

			line = reader.nextLine();
			int antall = Integer.parseInt(line);

			samling = new PersonSamling(antall);
			Person person = null;

			while (reader.hasNextLine()) {
				line = reader.nextLine();

				long fodselsnummer = Long.parseLong(reader.nextLine());
				String etternamn = reader.nextLine();
				String fornamn = reader.nextLine();

				if (line.equals(STUDENT)) {
					int studentnummer = Integer.parseInt(reader.nextLine());
					String klasse = reader.nextLine();
					person = new Student(etternamn, fornamn, fodselsnummer, studentnummer, klasse);
				} else if (line.equals(LAERER)) {
					int lonn = Integer.parseInt(reader.nextLine());
					int kontonummer = Integer.parseInt(reader.nextLine());
					person = new Laerer(etternamn, fornamn, fodselsnummer, lonn, kontonummer);
				} else {
					System.out.println("Feil i format");
				}

				samling.leggTil(person);
			}

			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Feil med fil");
		}
		return samling;
	}
}
