package com.yc.login;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import com.yc.domain.Message;
import com.yc.util.Common;
import com.yc.util.Constants;
import com.yc.util.IconUtil;

public class LoginDig extends JDialog{


	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JLabel jLabel = null;
	private JTextField jTextField = null;
	private JLabel jLabel1 = null;
	private JTextField jTextField1 = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private Client client = null;
	private ActionListener LoginDigAction = new AbstractAction(){

		@Override
		public void actionPerformed(ActionEvent e) {
			login();
		}
		
	};
	
	/**
	 * This is the default constructor
	 */
	public LoginDig(Client client) {
		super();
		this.client = client;
		initialize();
		
		//注册快捷键
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,false);
		this.getRootPane().registerKeyboardAction(LoginDigAction, enter, JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
	}
	
	public static LoginDig getInstance(Client client) {
		LoginDig inst = new LoginDig(client);
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
		return inst;
	}
	

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setIconImage(IconUtil.setIcon().getImage());
		this.setLocationRelativeTo(null);
		Common.Beautylize();
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("THINKING");
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(44, 74, 77, 29));
			jLabel1.setText("密码");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(44, 30, 77, 29));
			jLabel.setText("用户名");
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.add(jLabel, null);
			jPanel.add(getJTextField(), null);
			jPanel.add(jLabel1, null);
			jPanel.add(getJTextField1(), null);
			jPanel.add(getJButton(), null);
			jPanel.add(getJButton1(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(150, 30, 105, 29));
		}
		return jTextField;
	}

	/**
	 * This method initializes jTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(150, 75, 105, 29));
		}
		return jTextField1;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton("登陆");
			jButton.setBounds(new Rectangle(52, 118, 90, 30));
		}
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		return jButton;
	}

	protected void login() {
		String name = jTextField.getText();
		String pwd = jTextField1.getText();
		String str = name + Constants.LEFT_SLASH + pwd;
		client.sendMsg(new Message(Constants.LOGIN_MSG, str));
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton("退出");
			jButton1.setBounds(new Rectangle(151, 118, 90, 30));
		}
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		return jButton1;
	}

}
