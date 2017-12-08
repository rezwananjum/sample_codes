package com.myjava.threads;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class RockPaperScissorsServer {

	private static Integer port = 5555;

	private static String Msg = "--- Join To War Field --- \n";

	private static boolean validPort(Integer x) {
		return x >= 2000 && x <= 65535 ? true : false;
	}

	private static int getPort() {

		Integer a;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("Join Any War Field>>range 2000 to 65535 or\n");
			System.out.print("Enter \"0\" "
					+ " Continue With The Default War Field (" + server.port + "): ");
			a = sc.nextInt();

		} while (a != 0 && !server.validPort(a));

		sc.close();

		return a == 0 ? server.port : a;
	}

	
	
	public static void main(String args[]) throws Exception {

		String resCl_1 = "";
		String resCl_2 = "";
		String inputCl_1;
		String inputCl_2;
		System.out.println(server.Msg);
		server.port = server.getPort();
		ServerSocket ws = new ServerSocket(server.port);
		
		
		
		
		System.out.println( + ws.getLocalPort() +"th"+ "War field is Open."
				+ "Waiting for Players.. ");

		while (!ws.isClosed()) {

			// Player one
			Socket client_1 = ws.accept();
			if (client_1.isConnected()) {
				System.out.println("\nPlayer one (" + 
			
		(client_1.getLocalAddress().toString()).substring(1) + ":"
		+ client_1.getLocalPort() + ") has joined ... waiting for player two ...");
			}
			DataOutputStream outClient_1 = new DataOutputStream(client_1.getOutputStream());
			BufferedReader inClient_1 = new BufferedReader(
					new InputStreamReader(client_1.getInputStream())
					);

			// Player two
			Socket client_2 = ws.accept();
			if (client_2.isConnected()) {
				System.out.println("Player two (" + (
						client_2.getLocalAddress().toString()).substring(1) + ":"
						+ client_1.getLocalPort() + ") has joined ... lets start ...");
			}
			
			DataOutputStream outClient_2 = new DataOutputStream(
					client_2.getOutputStream());
			
			BufferedReader inClient_2 = new BufferedReader(
					new InputStreamReader(client_2.getInputStream()));

			// Get client inputs
			inputCl_1 = inClient_1.readLine();
			inputCl_2 = inClient_2.readLine();

			if (inputCl_1.equals(inputCl_2)) {
				resCl_1 = "Draw";
				resCl_2 = "Draw";
				System.out.println("Draw.");
			}
			
			//1
			
			else if (inputCl_1.equals("S") && inputCl_2.equals("R")) {
				resCl_1 = "You lose";
				resCl_2 = "You win";
				System.out.println("Player2 wins.");
			}
			//2
			else if (inputCl_1.equals("R") && inputCl_2.equals("P")) {
				resCl_1 = "You lose";
				resCl_2 = "You win";
				System.out.println("Player2 wins.");
			}
			//3
			else if (inputCl_1.equals("P") && inputCl_2.equals("S")) {
				resCl_1 = "You lose";
				resCl_2 = "You win";
				System.out.println("Player2 wins.");
			}
			else if (inputCl_1.equals("P") && inputCl_2.equals("R")) {
				resCl_1 = "You win";
				resCl_2 = "You lose";
				System.out.println("Player1 wins.");
			}
			//4
			else if (inputCl_1.equals("S") && inputCl_2.equals("P")) {
				resCl_1 = "You win";
				resCl_2 = "You lose";
				System.out.println("Player1 wins.");
			}
			//5
			else if (inputCl_1.equals("P") && inputCl_2.equals("R")) {
				resCl_1 = "You win";
				resCl_2 = "You lose";
				System.out.println("Player1 wins.");
			}
			//6
			else if (inputCl_1.equals("R") && inputCl_2.equals("S")) {
				resCl_1 = "You win";
				resCl_2 = "You lose";
				System.out.println("Player1 wins.");

			}
			
			outClient_1.writeBytes(resCl_1.toUpperCase());
			outClient_2.writeBytes(resCl_2.toUpperCase());
			client_1.close();
			client_2.close();

			System.out.println("\nWaiting For New Players ...\n");

		}
	}

}
