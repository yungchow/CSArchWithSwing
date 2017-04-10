package com.yc.swing.panels;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.yc.swing.lists.AnimatedJList;
import com.yc.swing.lists.FilterHistoryJList;
import com.yc.swing.lists.PolymorphicJList;
import com.yc.swing.lists.ReorderableJList;

import java.awt.GridBagConstraints;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;

public class ListAndCombosPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private JPanel jPanel3 = null;
	private FilterHistoryJList filterHistoryJList = null;
	private ReorderableJList reorderJList = null;
	private AnimatedJList animatedJList = null;

	/**
	 * This is the default constructor
	 */
	public ListAndCombosPanel() {
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
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.gridx = 0;
		gridBagConstraints2.gridy = 1;
		gridBagConstraints2.weightx = 0.5;
		gridBagConstraints2.weighty = 0.5;
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.gridx = 1;
		gridBagConstraints1.gridy = 0;
		gridBagConstraints1.weightx = 0.5;
		gridBagConstraints1.weighty = 0.5;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.5;
		this.setSize(800, 800);
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
			jPanel = new JPanel(new BorderLayout());
			jPanel.setSize(350, 500);
			filterHistoryJList = getFilterHistoryJlist();
            JScrollPane pane =
                new JScrollPane (filterHistoryJList,
                                 ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                                 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            jPanel.add(pane,BorderLayout.CENTER);
            jPanel.add(filterHistoryJList.getFilterField(),BorderLayout.NORTH);
            getFilterHistoryJlist().requestFocus();
		}
		return jPanel;
	}

	private FilterHistoryJList getFilterHistoryJlist() {
		if(filterHistoryJList == null){
			filterHistoryJList = new FilterHistoryJList();
	        String[] listItems = {
	                "Chris", "Joshua", "Daniel", "Michael",
	                "Don", "Kimi", "Kelly", "Keagan"
	            };
    		for (int i=0; i<listItems.length; i++)
            	filterHistoryJList.addItem (listItems[i]);
		}
		return filterHistoryJList;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setSize(350, 500);
	        JScrollPane scroller =
	            new JScrollPane (getReorderJList(),
	                            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
	                            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	        jPanel1.add(scroller);
		}
		return jPanel1;
	}

	private ReorderableJList getReorderJList() {
		if(reorderJList == null){
			reorderJList = new ReorderableJList ();
			DefaultListModel defModel = new DefaultListModel();
			reorderJList.setModel (defModel);
			String[] listItems = {
			    "Chris", "Joshua", "Daniel", "Michael",
			    "Don", "Kimi", "Kelly", "Keagan"
			};
			Iterator it = Arrays.asList(listItems).iterator();
			while (it.hasNext())
			    defModel.addElement (it.next());
		}
		return reorderJList;
	}

	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setSize(350, 500);
	        File dir = new File (".");
//	        if (args.length > 0)
//	            dir = new File (args[0]);
	        JList list = new PolymorphicJList (dir);
	        JScrollPane pain =
	            new JScrollPane (list,
	                             ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
	                             ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	        jPanel2.add(pain);
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
			jPanel3.setSize(350, 5000);
	        JScrollPane scroller =
	            new JScrollPane (getAnimatedJList(),
	                            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
	                            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	        jPanel3.add(scroller);
		}
		return jPanel3;
	}

	private JList getAnimatedJList() {
		if(animatedJList == null){
			animatedJList = new AnimatedJList();
			DefaultListModel defModel = new DefaultListModel();
			animatedJList.setModel (defModel);
			String[] listItems = {
			    "Chris", "Joshua", "Daniel", "Michael",
			    "Don", "Kimi", "Kelly", "Keagan"
			};
			Iterator it = Arrays.asList(listItems).iterator();
			while (it.hasNext())
			    defModel.addElement (it.next());
		}
		return animatedJList;
	}

}
