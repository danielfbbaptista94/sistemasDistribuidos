package main;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class CalculatorClientUDP {

	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		DatagramSocket clientSocket = new DatagramSocket();
		
		InetAddress IP = InetAddress.getByName("localhost");
		
		byte[] sendData = new byte[1024];
	    byte[] receiveData = new byte[1024];
	    
	    while(true) {
	    	System.out.println("Digite na sequencia: ");
	    	System.out.println("numero1 operador numero2");
	    	
	    	String input = scanner.nextLine();
	    	sendData = input.getBytes();
	    	
//	    	Enviando
	    	DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IP, 9876);
	    	clientSocket.send(sendPacket);
	    	
	    	if (input.equals("exit"))
	    			break;
	    	
//	    	Recebendo
	    	DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	        clientSocket.receive(receivePacket);
	        
	        String modifiedSentence = new String(receivePacket.getData());
	        System.out.println("FROM SERVER:" + modifiedSentence);
	    }
	    clientSocket.close();

	}

}
