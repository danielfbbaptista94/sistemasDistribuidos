package main;

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorRMIServer {
	
	int      thisPort = 10000;
    String   thisAddress;
    Registry registry;

	public CalculatorRMIServer() {
		try {
			System.out.println("Server Running");
			ICalculator calc = new CalculatorImpl();
			
			thisAddress = (InetAddress.getLocalHost()).toString();
			
			registry = LocateRegistry.createRegistry(thisPort); 
			registry.rebind("rmiCalcService", calc);
			
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	public static void main(String[] args) {
		new CalculatorRMIServer();
	}
	
}
