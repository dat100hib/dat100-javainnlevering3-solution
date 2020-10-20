package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/tests/";

	public static boolean skriv(Blogg samling, String filnavn) {

		boolean skrevet = true;
		PrintWriter writer = null;

		try {
			writer = new PrintWriter(MAPPE + filnavn);

			writer.print(samling.toString());

			writer.close();

		} catch (FileNotFoundException e) {
			System.out.println("Could not open file: " + MAPPE + filnavn);
			skrevet = false;
		}

		return skrevet;
	}
}
