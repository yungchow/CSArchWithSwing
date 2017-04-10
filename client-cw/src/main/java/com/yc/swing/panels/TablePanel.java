package com.yc.swing.panels;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.yc.swing.table.ColumnResizer;
import com.yc.swing.table.ColumnSelectableJTable;
import com.yc.swing.table.DnDJTree;
import com.yc.swing.table.ExcelExporter;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class TablePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private JPanel jPanel3 = null;
	
    final static Object[][] TABLE_DATA = {
        {new Integer(1), "ONJava", "http://www.onjava.com/"}, 
        {new Integer(2), "Joshy's Site", "http://www.joshy.org/"}, 
        {new Integer(3), "Anime Weekend Atlanta", "http://www.awa-con.com/"},
        {new Integer(4), "QTJ book", 
           "http://www.oreilly.com/catalog/quicktimejvaadn/"}
    };
    

    final static String[] COLUMN_NAMES = {
        "Count", "Name", "URL"
    };

	/**
	 * This is the default constructor
	 */
	public TablePanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		gridBagConstraints3.gridx = 1;
		gridBagConstraints3.gridy = 1;
		gridBagConstraints3.weightx = 0.5;
		gridBagConstraints3.weighty = 0.5;
		gridBagConstraints3.insets = new Insets(100, 100, 100, 100);
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.gridx = 0;
		gridBagConstraints2.gridy = 1;
		gridBagConstraints2.weightx = 0.5;
		gridBagConstraints2.weighty = 0.5;
		gridBagConstraints2.insets = new Insets(100, 100, 100, 100);
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.gridx = 1;
		gridBagConstraints1.gridy = 0;
		gridBagConstraints1.weightx = 0.5;
		gridBagConstraints1.weighty = 0.5;
		gridBagConstraints1.insets = new Insets(100, 100, 100, 100);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.5;
		gridBagConstraints.insets = new Insets(100, 100, 100, 100);
		this.setSize(900, 900);
		this.setLayout(new GridBagLayout());
		this.add(getJPanel(), gridBagConstraints);
		this.add(getJPanel1(), gridBagConstraints1);
		this.add(getJPanel2(), gridBagConstraints2);
		this.add(getJPanel3(), gridBagConstraints3);
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			try {
	            UIManager.setLookAndFeel (
	                  UIManager.getCrossPlatformLookAndFeelClassName());
	        } catch (Exception e) { e.printStackTrace();}

	        DefaultTableModel mod =
	            new DefaultTableModel (TABLE_DATA, COLUMN_NAMES);
	        JTable table = new JTable (mod);
	        JScrollPane pane =
	            new JScrollPane (table,
	                             ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
	                             ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	        jPanel.add(pane);
	        // now get smart about col widths
	        final JTable fTable = table;
	        SwingUtilities.invokeLater(new Runnable() {
	                public void run() {
	                    ColumnResizer.adjustColumnPreferredWidths (fTable);
	                    fTable.revalidate();
	                }
	            });
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
			jPanel1.setLayout(new BorderLayout());
	        DefaultTableModel model = new DefaultTableModel(TABLE_DATA,COLUMN_NAMES);
	        final JTable table = new JTable(model);
	        JScrollPane scroll = new JScrollPane(table);

	        JButton export = new JButton("Export");
	        export.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                try {
	                    ExcelExporter exp = new ExcelExporter();
	                    exp.exportTable(table, new File("results.xls"));
	                } catch (IOException ex) {
	                    ex.printStackTrace();
	                }
	            }
	        });
	        jPanel1.add(BorderLayout.CENTER,scroll);
	        jPanel1.add(BorderLayout.SOUTH,export);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			ColumnSelectableJTable table = 
		            new ColumnSelectableJTable(TABLE_DATA, COLUMN_NAMES);
	        JScrollPane scroller =
	            new JScrollPane (table,
	                             ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
	                             ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		    jPanel2.add(scroller);    
		}
		return jPanel2;
	}

	/**
	 * This method initializes jPanel3	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			jPanel3 = new JPanel();
			JTree tree = new DnDJTree();
	        DefaultMutableTreeNode root = new DefaultMutableTreeNode("People");
	        DefaultMutableTreeNode set1 = new DefaultMutableTreeNode("Set 1");
	        DefaultMutableTreeNode set2 = new DefaultMutableTreeNode("Set 2");
	        DefaultMutableTreeNode set3 = new DefaultMutableTreeNode("Set 3");
	        set1.add (new DefaultMutableTreeNode ("Chris"));
	        set1.add (new DefaultMutableTreeNode ("Kelly"));
	        set1.add (new DefaultMutableTreeNode ("Keagan"));
	        set2.add (new DefaultMutableTreeNode ("Joshua"));
	        set2.add (new DefaultMutableTreeNode ("Kimi"));
	        set3.add (new DefaultMutableTreeNode ("Michael"));
	        set3.add (new DefaultMutableTreeNode ("Don"));
	        set3.add (new DefaultMutableTreeNode ("Daniel"));
	        root.add (set1);
	        root.add (set2);
	        set2.add (set3);
	        DefaultTreeModel mod = new DefaultTreeModel (root);
	        tree.setModel (mod);
	        // expand all
	        for (int i=0; i<tree.getRowCount(); i++)
	            tree.expandRow (i);
	        // show tree
	        JScrollPane scroller =
	            new JScrollPane (tree,
	                            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
	                            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	        jPanel3.add(scroller);
		}
		return jPanel3;
	}

}
