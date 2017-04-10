package com.yc.emp;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IDealerEmp extends Remote{
	public List findEmp() throws RemoteException;
}
