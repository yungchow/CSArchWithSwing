package com.yc.util;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ContainerUtil {
	
	public static Font defaultFont = new Font("Dialog",Font.PLAIN,12);
	
	private Container c = null;
	
	public ContainerUtil(Container c){
		this.c = c;
	}
	
	public void setContainer(Container c){
		this.c = c;
	}
	
	/**
	 * 将窗口显示在中间
	 */
	public void showInCenter(){
		Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
		c.setLocation((d.width-c.getSize().width)/2,(d.height-c.getSize().height)/2);
	}
	
	/**
	 * 弹出信息框
	 */
	public static void showMessage(Container parentContainer,String message){
		JOptionPane.showMessageDialog(parentContainer, message);
	}
	
	/**
	 * 弹出错误信息框
	 */
	public static void showErrorMessage(Container parentContainer,String message){
		JOptionPane.showMessageDialog(parentContainer, message,"警告",JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * 验证文本框
	 */
	public static boolean isNotNullValid(Container parentContainer,JTextField jTextField,String message){
		if("".equals(jTextField.getText().trim())){
			showErrorMessage(parentContainer,message);
			jTextField.setFocusable(true);
			return false;
		}
		return true;
	}
	
	/**
	 * 确认对话框
	 */
	public static boolean isConfirm(Container parentContainer,String title,String message){
		int i = JOptionPane.showConfirmDialog(parentContainer, message,title,JOptionPane.OK_CANCEL_OPTION);
		if(i == 0)
			return true;
		else
			return false;
	}
}
