package com.yc.emp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.yc.cst.ticket_column;
import com.yc.domain.Emp;


public class DynamicShowModel extends DefaultTableModel{
	
	private Vector columns = null;
	
	private Object[] columnName = getColumnsName();

	public void setData(List list) {
		dataVector.clear();
		dataVector.addAll(list);
		this.fireTableDataChanged();
	}

	private Object[] getColumnsName() {
		columns = getColums();
		return columns.toArray();
	}

	private Vector getColums() {
		return ticket_column.showColumns;
	}

	public Object getValueAt(int row,int column){
		Emp entity = (Emp)dataVector.get(row);
		String columnValue = "";
		for(int i=0;i<columnName.length;i++){
			if(column == i){
				columnValue = columnName[i].toString();
				break;
			}
		}
		if("ID".equals(columnValue)){
			return entity.getId();
		}
		if("NAME".equals(columnValue)){
			return entity.getName();
		}
		if("GENDER".equals(columnValue)){
			return entity.getGender();
		}
		if("AGE".equals(columnValue)){
			return entity.getAge();
		}
		if("SKILL".equals(columnValue))
			return entity.getSkill();
		if("JOB".equals(columnValue))
			return entity.getJob();
		return "";
	}


	public List getData() {
		return new ArrayList(dataVector);
	}
	
	public int getColumnCount(){
		return columnName.length;
	}
	
	public void reset(){
		dataVector.removeAllElements();
	}
	
	public String getColumnName(int column){
		return columnName[column].toString();
	}
	
	public int getRowCount(){
		return dataVector.size();
	}
	
	public boolean isCellEditable(int rowIndex,int columnIndex){
		return false;
	}

}
