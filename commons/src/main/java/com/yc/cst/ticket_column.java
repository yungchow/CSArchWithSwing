package com.yc.cst;

import java.util.Vector;

public class ticket_column {
	private static String COL_ID = "ID";
	private static String COL_NAME = "NAME";
	private static String COL_GENDER = "GENDER";
	private static String COL_SKILL = "SKILL";
	private static String COL_AGE = "AGE";
	private static String COL_JOB = "JOB";
	public static Vector showColumns = new Vector();
	public static Vector noShowColumns = new Vector();
	
	static{
		noShowColumns.add(COL_ID); 
		noShowColumns.add(COL_GENDER); 
		showColumns.add(COL_NAME); 
		showColumns.add(COL_AGE); 
		showColumns.add(COL_JOB); 
		showColumns.add(COL_SKILL); 
	}
}
