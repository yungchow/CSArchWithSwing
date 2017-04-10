package com.yc.emp.control;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.yc.domain.Emp;
import com.yc.emp.IDealerEmp;

public class EmpControl {

	public IDealerEmp de;
	public Vector noShowColumns;
	public Vector showColumns;

	public Vector findShowColumn() {
		return null;
	}

	public Vector findEmp() throws RemoteException {
		List list = null;
		try {
			IDealerEmp de = (IDealerEmp)Naming.lookup("rmi://localhost:8998/RHello");
			list = de.findEmp();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e){
			e.printStackTrace();
		}
		return new Vector(list);
	}
//	public static void main(String[] args) {
//		List<Emp> list = new ArrayList();
//		try {
//			IDealerEmp de = (IDealerEmp)Naming.lookup("rmi://localhost:8998/RHello");
//			list = de.findEmp();
//			for(Emp d:list){
//				System.out.println(d.getSkill());
//			}
//		} catch (NotBoundException e) {
//			e.printStackTrace();
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (RemoteException e){
//			e.printStackTrace();
//		}
//	}
}
