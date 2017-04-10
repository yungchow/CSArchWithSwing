package com.yc.emp;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.JTableHeader;

import com.yc.emp.control.EmpControl;
import com.yc.emp.model.DynamicShowModel;
import com.yc.util.IconUtil;

public class EmpFinderDig extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JLabel jLabel = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	public DynamicShowModel model = null;
	public EmpControl action = new EmpControl();
	private Font font = null;

	/**
	 * This is the default constructor
	 */
	public EmpFinderDig(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setIconImage(IconUtil.setIcon().getImage());
		this.setSize(800,700);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Emp Finder");
		this.setVisible(true);
		query();
	}

	private void query() {
		if(model == null){
			model = new DynamicShowModel();
		}
		
		Vector list = null;
		try {
			list = action.findEmp();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list != null)
			model.setData(list);
		getJTable().setModel(model);
	
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getLabel(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
		}
		return jContentPane;
	}

	private JLabel getLabel() {
		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			if(jLabel == null){
//			InputStream is = EmpFinderDig.class.getResourceAsStream("./src/main/resources/font/fontawesome-webfont.ttf");
//			 Font font = Font.createFont(Font.TRUETYPE_FONT, is);
//             font = font.deriveFont(Font.PLAIN, 24f);
 			jLabel = new JLabel();
			jLabel.setFont(new Font("Courier New", Font.ITALIC, 15));
			jLabel.setBounds(new Rectangle(146, 168, 469, 54));
			jLabel.setText("Have The Courage To Follow Your Heart And Intuiton");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jLabel;
		}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.gridx = 0;
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.setBounds(new Rectangle(106, 316, 567, 269));
			jPanel.add(getJScrollPane(), gridBagConstraints);
		}
		return jPanel;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	public JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();
			jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			if(model == null){
				model = new DynamicShowModel();
			}
			jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			JTableHeader header = jTable.getTableHeader();
			header.setReorderingAllowed(false);
		}
		return jTable;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton("查询");
			jButton.setBounds(new Rectangle(224, 269, 107, 29));
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
			jButton1 = new JButton("列数设定");
			jButton1.setBounds(new Rectangle(420, 269, 107, 29));
		}
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				EditTableColumn table = new EditTableColumn(EmpFinderDig.this);
				table.setVisible(true);
			}
		});
		return jButton1;
	}
	
}
