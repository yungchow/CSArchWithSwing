package com.yc.swing.panels;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JButton;

//import javazoom.jl.player.Player;

import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class AudioPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;

	/**
	 * This is the default constructor
	 */
	public AudioPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(801, 900);
		this.setLayout(null);
		this.add(getJButton(), null);
		this.add(getJButton1(), null);
		this.add(getJButton2(), null);
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(90, 62, 159, 48));
			jButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
//			        try {
//			            BufferedInputStream buffer = new BufferedInputStream(
//			                    new FileInputStream(filename));
//			            player = new Player(buffer);
//			            player.play();
//			        } catch (Exception e) {
//			            System.out.println(e);
//			        }
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(316, 61, 159, 48));
		}
		return jButton1;
	}

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(554, 61, 159, 48));
		}
		return jButton2;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
