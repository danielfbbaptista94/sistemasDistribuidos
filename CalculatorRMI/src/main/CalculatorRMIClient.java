package main;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorRMIClient {
	
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		ICalculator calc;
		Registry registry;
		String serverAddress = "localhost";
	    String serverPort= "10000";
		
		try {
			registry = LocateRegistry.getRegistry(
		               serverAddress, Integer.parseInt(serverPort)
	           );
			calc = (ICalculator) (registry.lookup("rmiCalcService"));
			
			System.out.println(calc.somar(2, 2));
			System.out.println(calc.subtrair(5, 2));
			System.out.println(calc.multiplicar(6, 5));
			System.out.println(calc.dividir(10, 5));
			
		} catch (Exception e) {
			System.out.println("Error Client: " + e);
		}
		
	}
	
}
