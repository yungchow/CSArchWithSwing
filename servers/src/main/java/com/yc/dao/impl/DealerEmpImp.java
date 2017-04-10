package com.yc.dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yc.domain.Emp;
import com.yc.emp.IDealerEmp;
import com.yc.jdbc.DBUtil;

public class DealerEmpImp extends UnicastRemoteObject implements IDealerEmp{

	public DealerEmpImp() throws RemoteException {
		super();
	}

	@Override
	public List findEmp() {
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT * FROM emp_zr";
		List<Emp> list = new ArrayList<Emp>();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			Emp emp = null;
			while(rs.next()){
				emp = new Emp();
				emp.setAge(rs.getInt("AGE"));
				emp.setGender(rs.getString("GENDER"));
				emp.setId(rs.getInt("ID"));
				emp.setJob(rs.getString("JOB"));
				emp.setName(rs.getString("NAME"));
				emp.setSkill(rs.getString("SKILL"));
				list.add(emp);
			}
	        rs.close();
	        pst.close();
	        conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
