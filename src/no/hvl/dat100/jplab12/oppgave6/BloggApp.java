package no.hvl.dat100.jplab12.oppgave6;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import no.hvl.dat100.jplab12.oppgave3.Blogg;

public class BloggApp {

	public static String toHTML() {
		
		return "<html> Got it </html>";
	}
	
	private ServerSocket welcomeSocket;
	
	public BloggApp(ServerSocket welcomeSocket) {
		this.welcomeSocket = welcomeSocket;
	}
	
	public void process() {
		
		try {
			
			System.out.println("SERVER ACCEPTING");
			
			Socket connectionSocket = welcomeSocket.accept();

			BufferedReader inFromClient = new BufferedReader(
					new InputStreamReader(connectionSocket.getInputStream()));
			
			DataOutputStream outToClient = 
					new DataOutputStream(connectionSocket.getOutputStream());

			String text = inFromClient.readLine();
			
			System.out.println("SERVER RECEIVED: " + text);
			
			String htmlbody = toHTML(); 
			
			String header = "HTTP/1.1 200 OK\n" + 
					  "Server: Java HTTP Server from SSaurel : 1.0\n" + 
					  "Date: " + (new Date()) + "\n" + 
					  "Content-type: " + "text/html" + "\n" + 
			          "Content-length: " + htmlbody.length() + "\n" + 
			          "\n";
			          
			String outtext = header + htmlbody;
			
			System.out.println("SERVER SENDING: " + outtext);
			
			outToClient.write(outtext.getBytes());
			outToClient.flush();
			
			outToClient.close();
			inFromClient.close();
			
			try {
				Thread.sleep(3000);
				}
				catch (InterruptedException e) {}
			connectionSocket.close();
			
		} catch (IOException ex) {
			
			System.out.println("TCPServer: " + ex.getMessage());
			ex.printStackTrace();
			System.exit(1);
			
		}
	}
}
