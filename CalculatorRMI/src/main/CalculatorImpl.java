package main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements ICalculator {

	protected CalculatorImpl() throws RemoteException {
		super();
	}

	@Override
	public long somar(long num1, long num2) throws RemoteException {
		return num1 + num2;
	}

	@Override
	public long subtrair(long num1, long num2) throws RemoteException {
		return num1 - num2;
	}

	@Override
	public long multiplicar(long num1, long num2) throws RemoteException {
		return num1 * num2;
	}

	@Override
	public long dividir(long num1, long num2) throws RemoteException {
		return num1 / num2;
	}

}
