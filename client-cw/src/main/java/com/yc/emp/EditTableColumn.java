package com.yc.emp;

import java.awt.Rectangle;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;

import com.yc.cst.ticket_column;
import com.yc.emp.control.EmpControl;
import com.yc.emp.model.DynamicShowModel;
import com.yc.util.ContainerUtil;
import com.yc.util.IconUtil;
import java.awt.Dimension;
import javax.swing.JTextField;

public class EditTableColumn extends JDialog{


	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JList jList1 = null;
	private JList jList2 = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JButton jButton3 = null;
	private JButton jButton4 = null;
	private JButton jButton5 = null;
	private JButton jButton6 = null;
	private JButton jButton7 = null;

	private EmpFinderDig parent ;
	private Vector leftColumnVector = new Vector(); // @jve:decl-index=0:
	private Vector rightColumnVector = new Vector(); // @jve:decl-index=0:
	/**
	 * This is the default constructor
	 */
	public EditTableColumn(EmpFinderDig parent) {
		super(parent);
		this.parent = parent;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setIconImage(IconUtil.setIcon().getImage());
		this.setSize(550, 341);
		this.setContentPane(getJContentPane());
		ContainerUtil cu = new ContainerUtil(this);
		cu.showInCenter();
		this.setTitle("Everything else is secondary");
		setJListData();
	}

	private void setJListData() {
		leftColumnVector = ticket_column.noShowColumns;
		rightColumnVector = ticket_column.showColumns;
		jList1.setListData(leftColumnVector);
		jList2.setListData(rightColumnVector);
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
			jContentPane.add(getJPanel1(), null);
			jContentPane.add(getJList1(), null);
			jContentPane.add(getJList2(), null);
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
			jPanel.setLayout(null);
			jPanel.setBounds(new Rectangle(152, 90, 80, 115));
			jPanel.add(getJButton(), null);
			jPanel.add(getJButton1(), null);
			jPanel.add(getJButton2(), null);
			jPanel.add(getJButton3(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jPanel1.setBounds(new Rectangle(385, 90, 80, 115));
			jPanel1.add(getJButton4(), null);
			jPanel1.add(getJButton5(), null);
			jPanel1.add(getJButton6(), null);
			jPanel1.add(getJButton7(), null);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jList1
	 * 
	 * @return javax.swing.JList
	 */
	private JList getJList1() {
		if (jList1 == null) {
			jList1 = new JList();
			jList1.setBounds(new Rectangle(31, 17, 101, 248));
		}
		return jList1;
	}

	/**
	 * This method initializes jList2
	 * 
	 * @return javax.swing.JList
	 */
	private JList getJList2() {
		if (jList2 == null) {
			jList2 = new JList();
			jList2.setBounds(new Rectangle(256, 17, 101, 248));
		}
		return jList2;
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(9, 5, 60, 20));
			jButton.setText(">>");
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
			jButton1.setBounds(new Rectangle(9, 33, 59, 20));
			jButton1.setText(">");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					rightMove(jList1.getSelectedIndex());
				}
			});
		}
		return jButton1;
	}

	protected void rightMove(int index) {
			rightColumnVector.add(leftColumnVector.remove(index));
			setData(jList1,leftColumnVector);
			setData(jList2,rightColumnVector);
	}

	private void setData(JList jlist,Vector list) {
		jlist.removeAll();
		jlist.setListData(list);
	}

	/**
	 * This method initializes jButton2
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(9, 60, 59, 20));
			jButton2.setText("<");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					leftMove(jList1.getSelectedIndex());
				}
			});
		}
		return jButton2;
	}

	protected void leftMove(int index) {
		leftColumnVector.add(rightColumnVector.remove(index));
		setData(jList1,leftColumnVector);
		setData(jList2,rightColumnVector);
	}

	/**
	 * This method initializes jButton3
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setBounds(new Rectangle(9, 88, 59, 20));
			jButton3.setText("<<");
		}
		return jButton3;
	}

	/**
	 * This method initializes jButton4
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setBounds(new Rectangle(7, 6, 62, 21));
			jButton4.setText("上移");
		}
		return jButton4;
	}

	/**
	 * This method initializes jButton5
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton5() {
		if (jButton5 == null) {
			jButton5 = new JButton();
			jButton5.setBounds(new Rectangle(7, 31, 62, 21));
			jButton5.setText("下移");
		}
		return jButton5;
	}

	/**
	 * This method initializes jButton6
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton6() {
		if (jButton6 == null) {
			jButton6 = new JButton();
			jButton6.setBounds(new Rectangle(7, 57, 61, 21));
			jButton6.setText("保存");
			jButton6.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					modifyShowColumnEntity();
					List list = parent.model.getData();
					DynamicShowModel _model = new DynamicShowModel();
					parent.model = _model;
					if (list != null) {
						parent.model.setData(list);
					}
					parent.getJTable().setModel(parent.model);
					TableHeaderManage.setColumnWidth(parent.getJTable(),
							parent.model);
					dispose();
				}
			});
		}
		return jButton6;
	}

	protected void modifyShowColumnEntity() {
		ticket_column.noShowColumns = leftColumnVector;
		ticket_column.showColumns = rightColumnVector;
	}

	private Vector getShowColumn() {
		return rightColumnVector;
	}

	private Vector getNoShowColumns() {
		return leftColumnVector;
	}

	/**
	 * This method initializes jButton7
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton7() {
		if (jButton7 == null) {
			jButton7 = new JButton();
			jButton7.setBounds(new Rectangle(7, 85, 61, 21));
			jButton7.setText("关闭");
		}
		return jButton7;
	}


}  //  @jve:decl-index=0:visual-constraint="120,47"
