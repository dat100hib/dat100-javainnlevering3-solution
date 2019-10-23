package no.hvl.dat100.jplab12.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab12.oppgave3.*;

public class SkrivFil {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

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
