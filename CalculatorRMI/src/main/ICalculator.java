package main;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculator extends Remote {
	
	public long somar(long num1, long num2) throws RemoteException;
	
	public long subtrair(long num1, long num2) throws RemoteException;
	
	public long multiplicar(long num1, long num2) throws RemoteException;
	
	public long dividir(long num1, long num2) throws RemoteException;

}
