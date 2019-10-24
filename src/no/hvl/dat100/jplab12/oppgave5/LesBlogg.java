package no.hvl.dat100.jplab12.oppgave5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.*;
import no.hvl.dat100.jplab12.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String filnavn) {

		Blogg samling = null;

		try {

			File file = new File(MAPPE + filnavn);
			Scanner reader = new Scanner(file);

			String line;

			line = reader.nextLine();
			int antall = Integer.parseInt(line);

			samling = new Blogg(antall);
			Innlegg innlegg = null;

			while (reader.hasNextLine()) {
				line = reader.nextLine();

				int id = Integer.parseInt(reader.nextLine());
				String bruker = reader.nextLine();
				String dato = reader.nextLine();
				int likes = Integer.parseInt(reader.nextLine());
				String tekst = reader.nextLine();
				
				if (line.equals(BILDE)) {
					String bilde = reader.nextLine();
					innlegg = new Bilde(id,bruker,dato, likes,tekst, bilde);
				} else if (line.equals(TEKST)) {
					innlegg = new Tekst(id, bruker, dato, likes, tekst);
				} else {
					System.out.println("Feil i format");
				}

				samling.leggTil(innlegg);
			}

			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Feil med fil");
		}
		
		// TODO: handle format exception
		return samling;
	}
}
