package dns;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientDNS {
	public static void main(String[] args) {

		try {

			// Create an object of DatagramSocket for the client.
			DatagramSocket clientSocket = new DatagramSocket();

			// Get the IP address of server from the local host.
			InetAddress serverIP = InetAddress.getByName("localhost");

			// Create Array of bytes to send client's request and receive server's response.
			byte requestByte[] = null;
			byte responseByte[] = new byte[13000];
			// Take Input from console.
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);

			// Loop while user not enters "close"
			while (true) {
				System.out.println("Send Request to Server or 'close' to close the connection");

				// Take Input from console.
				String input = scanner.nextLine();

				// Break the loop if the client enters "close".
				if (input.equalsIgnoreCase("close")) {
					System.out.println("Connection is closed");
					clientSocket.close();
					break;

				}

				// Convert the String input into the byte array.
				requestByte = input.getBytes();

				// Create a client packet for sending the client's request to the server.
				DatagramPacket clientPacket = new DatagramPacket(requestByte, requestByte.length, serverIP, 4000);
				// Send the client's packet to the server.
				clientSocket.send(clientPacket);

				// Create a server packet for receiving the server's response.
				DatagramPacket serverPacket = new DatagramPacket(responseByte, responseByte.length);
				// Receive the server's response from the server packet.
				clientSocket.receive(serverPacket);

				// Convert Data byte to string
				String response = new String(serverPacket.getData());
				System.out.println(response.trim());

				// Clear the buffer after every message.
				requestByte = null;
				responseByte = new byte[13000];

			}
		} catch (Exception e) {
			System.out.println("Connection with server is terminated.");
		}

	}

}
