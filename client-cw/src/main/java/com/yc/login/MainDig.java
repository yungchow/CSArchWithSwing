package com.yc.login;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.yc.emp.EmpFinderDig;
import com.yc.swing.SwingUI;
import com.yc.util.IconUtil;
import com.yc.util.ImagePanel;

public class MainDig extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;  //  @jve:decl-index=0:visual-constraint="127,66"
	private JPanel jPanel = null;
	private JMenuBar jJMenuBar = null;
	private JMenu menu = null;
	private JMenu menu1 = null;
	private JMenu menu2 = null;
	private JMenu menu3 = null;
	private JMenu menu4 = null;
	private JMenuItem item = null;
	private JMenuItem item1 = null;
	private Client client;


	/**
	 * This is the default constructor
	 */
	public MainDig(Client client) {
		super();
		this.client = client;
		initialize();
	}
	
	public static MainDig getInstance(Client client) {
		MainDig inst = new MainDig(client);
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
		inst.requestFocus();
		return inst;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setIconImage(IconUtil.setIcon().getImage());
		this.setContentPane(getJContentPane());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setTitle("Stay Hungry,Stay Foolish");
		this.setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
//			jContentPane = new JPanel();
			jContentPane = new ImagePanel("./src/main/resources/image/st.png");
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel(), BorderLayout.NORTH);
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
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(getJJMenuBar());
		}
		return jPanel;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenu());
			jJMenuBar.add(getJMenu1());
			jJMenuBar.add(getJMenu2());
			jJMenuBar.add(getJMenu3());
			jJMenuBar.add(getJMenu4());
		}
		return jJMenuBar;
	}

	private JMenu getJMenu() {
		if(menu == null){
			menu = new JMenu("Introduction");
			menu.add(getJMenuItemIntro());
		}
		return menu;
	}
	
	private JMenuItem getJMenuItemIntro() {
		if(item1 == null){
			item1 = new JMenuItem("Swing");
		}
		item1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SwingUI swing = new SwingUI();
			}
		});
		return item1;
	}

	private JMenu getJMenu1() {
		if(menu1 == null){
			menu1 = new JMenu("Edit");
		}
		return menu1;
	}
	
	private JMenu getJMenu2() {
		if(menu2 == null){
			menu2 = new JMenu("Search");
			menu2.add(getJMenuItemSearch());
		}
		return menu2;
	}
	
	private JMenuItem getJMenuItemSearch() {
		if(item == null){
			item = new JMenuItem("Emp");
		}
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EmpFinderDig dig = new EmpFinderDig(MainDig.this);
			}
		});
		return item;
	}

	private JMenu getJMenu3() {
		if(menu3 == null){
			menu3 = new JMenu("Window");
		}
		return menu3;
	}
	
	private JMenu getJMenu4() {
		if(menu4 == null){
			menu4 = new JMenu("Help");
		}
		return menu4;
	}

}
