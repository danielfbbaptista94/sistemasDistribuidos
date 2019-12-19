package main;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.StringTokenizer;



public class CalculatorServerUDP {
	
	public static void main(String[] args) throws IOException {
		
		double resultado;
		int portClient;
		DatagramSocket serverSocket = new DatagramSocket(9876);

		byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        
        DatagramPacket receivePacket = null; 
        DatagramPacket sendPacket = null;
        
        while(true) {
        	receivePacket = new DatagramPacket(receiveData, receiveData.length);
        	serverSocket.receive(receivePacket);
        	
        	String input = new String(receivePacket.getData());
        	input = input.trim();
        	System.out.println("RECEIVED: " + input);
        	
        	InetAddress IP = receivePacket.getAddress();
        	
        	if (input.equals("exit")) 
        		break;
        	
        	StringTokenizer st = new StringTokenizer(input); 
        	  
            int numero1 = Integer.parseInt(st.nextToken()); 
            String operador = st.nextToken(); 
            int numero2 = Integer.parseInt(st.nextToken());
            
            if (operador.equals("+")) {
            	resultado = numero1 + numero2;
            } else if (operador.equals("-")) {
            	resultado = numero1 - numero2;
            } else if (operador.equals("*")) {
            	resultado = numero1 * numero2;
            } else if (operador.equals("/")) {
            	resultado = numero1 / numero2;
            } else {
            	resultado = numero1 % numero2;	
            }
        	
            System.out.println("Enviando Resultado...");
            String result = Double.toString(resultado);
            
            sendData = result.getBytes();
            portClient = receivePacket.getPort();
            
//          ENVIANDO
            sendPacket = new DatagramPacket(sendData, sendData.length, IP, portClient);
            serverSocket.send(sendPacket);
        }
	}
	
}
