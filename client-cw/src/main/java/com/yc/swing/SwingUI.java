package com.yc.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import com.yc.swing.components.ImageButton;
import com.yc.swing.components.ImageLabel;
import com.yc.swing.components.ImageBorder;
import com.yc.swing.components.CalendarHack;
import com.yc.swing.components.ColorSelectionPanel;
import com.yc.swing.components.DropDownComponent;
import com.yc.swing.components.RichJLabel;
import com.yc.swing.components.ScrollPaneWatermark;
import com.yc.swing.components.VenetianPane;
import com.yc.swing.components.WatermarkTextField;
import com.yc.swing.panels.ListAndCombosPanel;
import com.yc.swing.panels.TablePanel;
import com.yc.util.IconUtil;
import com.yc.util.ImagePath;

public class SwingUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JToolBar jToolBar = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenuItem jMenuItem = null;
	private JTabbedPane jTabbedPane = null;
	private JScrollPane jScrollPane = null;
	private JScrollPane jScrollPane1 = null;
	private JScrollPane jScrollPane2 = null;
	private JScrollPane jScrollPane4 = null;
	private JPanel jPanel = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;
	private JButton jButton = null;
//	private JPanel jPanel1 = null;
	private JButton jButton1 = null;
	private JCheckBox jCheckBox = null;
	private JLabel jLabel8 = null;
	private JPanel jPanel2 = null;
	private JLabel richLabel = null;
	private JLabel jLabel9 = null;
	private JLabel jLabel10 = null;
	private JPanel borderPanel = null;
//	private JPanel jPanel3 = null;
	private JTextField jTextField = null;
	private JScrollPane jScrollPane3 = null;
	private JTabbedPane jTabbedPane1 = null;
	private JPanel jPanel11 = null;
	private JButton status = null;
	private JPanel colorSelectionPanel = null;
	private ScrollPaneWatermark watermark = null;  //  @jve:decl-index=0:visual-constraint="10,1242"
	private JTextArea ta = null;  //  @jve:decl-index=0:visual-constraint="115,1047"
	private DropDownComponent dropdown = null;
	/**
	 * This is the default constructor
	 */
	public SwingUI() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setIconImage(IconUtil.setIcon().getImage());
		this.setSize(950, 1400);
//		this.setJMenuBar(getJMenuBar());
		this.setPreferredSize(new Dimension(950,950));
		this.setContentPane(getJContentPane());
		this.setTitle("可能是最炫酷的SWING");
		this.setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BoxLayout(jContentPane,BoxLayout.Y_AXIS));
//			jContentPane.add(getJJMenuBar(),null);
			jContentPane.add(getJToolBar(), null);
			jContentPane.add(getJTabbedPane(),null);
		}
		return jContentPane;
	}

	private JTabbedPane getJTabbedPane() {
		if(jTabbedPane == null){
			jTabbedPane = new JTabbedPane();
			jTabbedPane.addTab("Components", null, getJScrollPane(), null);
			jTabbedPane.addTab("Lists", null, getJScrollPane1(), null);
			jTabbedPane.addTab("Tables", null, getJScrollPane2(), null);
//			jTabbedPane.addTab("Audio", null,getScrollPanl3(),null);
		}
		return jTabbedPane;
	}

	private JScrollPane getScrollPanl3() {
		if(jScrollPane4 == null){
			jScrollPane4 = new JScrollPane();
			jScrollPane4.add(getJPanel3());
			jScrollPane4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		}
		return jScrollPane4;
	}

	private JPanel getJPanel3() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method initializes jToolBar	
	 * 	
	 * @return javax.swing.JToolBar	
	 */
	private JToolBar getJToolBar() {
		if (jToolBar == null) {
			jToolBar = new JToolBar("tools");
			jToolBar.add(new JButton("seize"));
			jToolBar.add(new JButton("everything"));
			jToolBar.add(new JButton("you"));
			jToolBar.add(new JButton("ever"));
			jToolBar.add(new JButton("wanted"));
		}
		return jToolBar;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
//			jJMenuBar.add(getJMenu());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
//	private JMenu getJMenu() {
//		if (jMenu == null) {
//			jMenu = new JMenu();
//			jMenu.add(getJMenuItem());
//		}
//		return jMenu;
//	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
//	private JMenuItem getJMenuItem() {
//		if (jMenuItem == null) {
//			jMenuItem = new JMenuItem("Font");
//		}
//		return jMenuItem;
//	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJPanel());
			jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(new ListAndCombosPanel());
			jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes jScrollPane2	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setViewportView(new TablePanel());
			jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		}
		return jScrollPane2;
	}
	
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints81 = new GridBagConstraints();
			gridBagConstraints81.gridx = 1;
			gridBagConstraints81.gridy = 7;
			gridBagConstraints81.insets = new Insets(0, 200, 100, 0);
			gridBagConstraints81.anchor = GridBagConstraints.WEST;
			gridBagConstraints81.gridwidth = 3;
			GridBagConstraints gridBagConstraints71 = new GridBagConstraints();
			gridBagConstraints71.fill = GridBagConstraints.BOTH;
			gridBagConstraints71.insets = new Insets(0, 200, 30, 150);
			gridBagConstraints71.anchor = GridBagConstraints.WEST;
			gridBagConstraints71.gridy = 6;
			gridBagConstraints71.weightx = 0.7;
			gridBagConstraints71.weighty = 1.0;
			gridBagConstraints71.gridwidth = 3;
			gridBagConstraints71.gridx = 1;
			GridBagConstraints gridBagConstraints61 = new GridBagConstraints();
			gridBagConstraints61.fill = GridBagConstraints.BOTH;
			gridBagConstraints61.gridy = 5;
			gridBagConstraints61.weightx = 0.7;
			gridBagConstraints61.weighty = 0.0;
			gridBagConstraints61.gridwidth = 3;
			gridBagConstraints61.insets = new Insets(0, 200, 30, 150);
			gridBagConstraints61.anchor = GridBagConstraints.WEST;
			gridBagConstraints61.gridx = 1;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.fill = GridBagConstraints.BOTH;
			gridBagConstraints5.gridy = 4;
			gridBagConstraints5.weightx = 0.6;
			gridBagConstraints5.gridwidth = 3;
			gridBagConstraints5.insets = new Insets(0, 200, 30, 150);
			gridBagConstraints5.gridx = 1;
			GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
			gridBagConstraints41.gridx = 3;
			gridBagConstraints41.weightx = 0.3;
			gridBagConstraints41.insets = new Insets(0, 0, 30, 150);
			gridBagConstraints41.gridy = 1;
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.gridx = 2;
			gridBagConstraints31.weightx = 0.3;
			gridBagConstraints31.anchor = GridBagConstraints.WEST;
			gridBagConstraints31.insets = new Insets(0, 0, 30, 0);
			gridBagConstraints31.gridy = 1;
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.gridx = 2;
			gridBagConstraints15.gridwidth = 2;
			gridBagConstraints15.weightx = 0.4;
			gridBagConstraints15.insets = new Insets(0, 0, 0, 150);
			gridBagConstraints15.gridy = 0;
			jLabel8 = new ImageLabel(new ImageIcon(ImagePath.COMPONENTS+"01/reactor.png"));
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.gridx = 1;
			gridBagConstraints14.gridwidth = 3;
			gridBagConstraints14.gridy = 3;
			gridBagConstraints14.insets = new Insets(0, 0, 30, 0);
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 1;
			gridBagConstraints13.gridwidth = 3;
			gridBagConstraints13.anchor = GridBagConstraints.CENTER;
			gridBagConstraints13.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints13.insets = new Insets(0, 200, 30, 150);
			gridBagConstraints13.gridy = 2;
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 1;
			gridBagConstraints12.weightx = 0.4;
			gridBagConstraints12.insets = new Insets(0, 200, 30, 0);
			gridBagConstraints12.anchor = GridBagConstraints.WEST;
			gridBagConstraints12.gridy = 1;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 1;
			gridBagConstraints11.weightx = 0.4;
			gridBagConstraints11.weighty = 0.0;
			gridBagConstraints11.anchor = GridBagConstraints.WEST;
			gridBagConstraints11.fill = GridBagConstraints.NONE;
			gridBagConstraints11.insets = new Insets(70, 200, 30, 0);
			gridBagConstraints11.gridy = 0;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 0;
			gridBagConstraints8.insets = new Insets(0, 100, 100, 0);
			gridBagConstraints8.anchor = GridBagConstraints.CENTER;
			gridBagConstraints8.weighty = 0.2;
			gridBagConstraints8.gridy = 7;
			jLabel7 = new JLabel();
			jLabel7.setText("Color Chooser");
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 0;
			gridBagConstraints7.insets = new Insets(0, 100, 30, 0);
			gridBagConstraints7.anchor = GridBagConstraints.CENTER;
			gridBagConstraints7.weighty = 0.2;
			gridBagConstraints7.weightx = 0.3;
			gridBagConstraints7.gridy = 6;
			jLabel6 = new JLabel();
			jLabel6.setText("Transitions Tab");
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.insets = new Insets(0, 100, 30, 0);
			gridBagConstraints6.anchor = GridBagConstraints.CENTER;
			gridBagConstraints6.weighty = 0.0;
			gridBagConstraints6.weightx = 0.3;
			gridBagConstraints6.gridy = 5;
			jLabel5 = new JLabel();
			jLabel5.setText("Watermark ScrollPane");
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.insets = new Insets(0, 100, 30, 0);
			gridBagConstraints4.anchor = GridBagConstraints.CENTER;
			gridBagConstraints4.weighty = 0.1;
			gridBagConstraints4.weightx = 0.4;
			gridBagConstraints4.gridy = 4;
			jLabel4 = new JLabel();
			jLabel4.setText("Image TextField");
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.insets = new Insets(0, 100, 30, 0);
			gridBagConstraints3.anchor = GridBagConstraints.CENTER;
			gridBagConstraints3.weighty = 0.1;
			gridBagConstraints3.gridy = 3;
			jLabel3 = new JLabel();
			jLabel3.setText("Canlendar");
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.insets = new Insets(0, 100, 30, 0);
			gridBagConstraints2.anchor = GridBagConstraints.CENTER;
			gridBagConstraints2.weighty = 0.1;
			gridBagConstraints2.weightx = 0.2;
			gridBagConstraints2.gridy = 2;
			jLabel2 = new JLabel();
			jLabel2.setText("Image Border");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.anchor = GridBagConstraints.CENTER;
			gridBagConstraints1.ipadx = 0;
			gridBagConstraints1.insets = new Insets(0, 100, 30, 0);
			gridBagConstraints1.weighty = 0.1;
			gridBagConstraints1.weightx = 0.3;
			gridBagConstraints1.gridy = 1;
			jLabel1 = new JLabel();
			jLabel1.setText("Rich JLabel");
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.insets = new Insets(0, 100, 30, 0);
			gridBagConstraints.anchor = GridBagConstraints.CENTER;
			gridBagConstraints.fill = GridBagConstraints.NONE;
			gridBagConstraints.weightx = 0.2;
			gridBagConstraints.weighty = 0.1;
			gridBagConstraints.gridy = 0;
			jLabel = new JLabel();
			jLabel.setText("Image JComponents");
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(jLabel, gridBagConstraints);
			jPanel.add(jLabel1, gridBagConstraints1);
			jPanel.add(jLabel2, gridBagConstraints2);
			jPanel.add(jLabel3, gridBagConstraints3);
			jPanel.add(jLabel4, gridBagConstraints4);
			jPanel.add(jLabel5, gridBagConstraints6);
			jPanel.add(jLabel6, gridBagConstraints7);
			jPanel.add(jLabel7, gridBagConstraints8);
			jPanel.add(getJButton(), gridBagConstraints11);
			jPanel.add(getJLabel(), gridBagConstraints12);
			jPanel.add(getJPanel1(), gridBagConstraints13);
			jPanel.add(getJPanel2(), gridBagConstraints14);
			jPanel.add(jLabel8, gridBagConstraints15);
			jPanel.add(getJLabel1(), gridBagConstraints31);
			jPanel.add(getJLabel2(), gridBagConstraints41);
			jPanel.add(getJTextField(), gridBagConstraints5);
			jPanel.add(getJScrollPane3(), gridBagConstraints61);
			jPanel.add(getJTabbedPane1(), gridBagConstraints71);
			jPanel.add(getJPanel11(), gridBagConstraints81);
		}
		return jPanel;
	}
	
	private JPanel getJPanel2() {
		if(jPanel2 == null){
			jPanel2 = new JPanel();
			CalendarHack ch = new CalendarHack();
	        ch.setDate(new Date());
	        jPanel2.add(ch);
		}
		return jPanel2;
	}

	private Component getJPanel1() {
		if(borderPanel == null){
			borderPanel = new JPanel();
	        ImageBorder image_border = new ImageBorder(
	                new ImageIcon(ImagePath.COMPONENTS+"02/upper_left.png").getImage(),
	                new ImageIcon(ImagePath.COMPONENTS+"02/upper.png").getImage(),
	                new ImageIcon(ImagePath.COMPONENTS+"02/upper_right.png").getImage(),

	                new ImageIcon(ImagePath.COMPONENTS+"02/left_center.png").getImage(),
	                new ImageIcon(ImagePath.COMPONENTS+"02/right_center.png").getImage(),

	                new ImageIcon(ImagePath.COMPONENTS+"02/bottom_left.png").getImage(),
	                new ImageIcon(ImagePath.COMPONENTS+"02/bottom_center.png").getImage(),
	                new ImageIcon(ImagePath.COMPONENTS+"02/bottom_right.png").getImage()
	                );
			borderPanel.setBorder(image_border);
		}
		return borderPanel;
	}

	private JLabel getJLabel2() {
		if(jLabel9 == null){
			jLabel9 = new RichJLabel("Beautiful",0);
			((RichJLabel) jLabel9).setLeftShadow(5,5,Color.white);
			((RichJLabel) jLabel9).setRightShadow(-3,-3, new Color(0xccccff));
			jLabel9.setForeground(new Color(0x8888ff));
			jLabel9.setFont(jLabel9.getFont().deriveFont(40f));
		}
		return jLabel9;
	}

	private Component getJLabel1() {
		if(jLabel10 == null){
			jLabel10 = new RichJLabel("BYE",0);
			((RichJLabel) jLabel10).setLeftShadow(1,1,Color.white);
			((RichJLabel) jLabel10).setRightShadow(1,1,Color.white);
			jLabel10.setForeground(Color.blue);
			jLabel10.setFont(jLabel10.getFont().deriveFont(40f));
		}
		return jLabel10;
	}

	private JLabel getJLabel() {
		if(richLabel == null){
			richLabel = new RichJLabel("BYE",0);
			((RichJLabel) richLabel).setLeftShadow(1,1,Color.white);
			((RichJLabel) richLabel).setRightShadow(2,3,Color.black);
			richLabel.setForeground(Color.gray);
			richLabel.setFont(richLabel.getFont().deriveFont(40f));
		}
		return richLabel;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new ImageButton(ImagePath.COMPONENTS+"01/button.png");
			jButton.setPressedIcon(new ImageIcon(ImagePath.COMPONENTS+"01/button-down.png"));
			jButton.setRolloverIcon(new ImageIcon(ImagePath.COMPONENTS+"01/button-over.png"));
			jButton.setSelectedIcon(new ImageIcon(ImagePath.COMPONENTS+"01/button-sel.png"));
			jButton.setRolloverSelectedIcon(new ImageIcon(ImagePath.COMPONENTS+"01/button-sel-over.png"));
			jButton.setDisabledIcon(new ImageIcon(ImagePath.COMPONENTS+"01/button-disabled.png"));
			jButton.setDisabledSelectedIcon(new ImageIcon(ImagePath.COMPONENTS+"01/button-disabled-selected.png"));
			jButton.setLocation(60,74);
			jButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	jButton.setSelected(!jButton.isSelected());
	            }
	        });
		}
		return jButton;
	}


	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			try {
				jTextField  = new WatermarkTextField(new File(ImagePath.COMPONENTS+"04/red.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			jTextField.setText("NeverMore");
		}
		return jTextField;
	}

	/**
	 * This method initializes jScrollPane3	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane3() {
		if (jScrollPane3 == null) {
			jScrollPane3 = new JScrollPane();
			jScrollPane3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	        ta = new JTextArea();
	        watermark = new ScrollPaneWatermark();
	        try {
				ta.setText(ScrollPaneWatermark.fileToString(new File(ImagePath.Text_PATH+"alice.txt")));
				ta.setSize(new Dimension(760, 461));
		        ta.setLineWrap(true);
		        ta.setWrapStyleWord(true);
		        watermark.setBackgroundTexture(new File(ImagePath.COMPONENTS+"05/clouds.jpg").toURL());
		        watermark.setSize(new Dimension(760, 63));
		        watermark.setForegroundBadge(new File(ImagePath.COMPONENTS+"05/flyingsaucer.png").toURL());
		        watermark.setView(ta);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        jScrollPane3.setViewport(watermark);
		}
		return jScrollPane3;
	}

	/**
	 * This method initializes jTabbedPane1	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane1() {
		if (jTabbedPane1 == null) {
			jTabbedPane1 = new VenetianPane();
			jTabbedPane1.addTab("NO.1",new JButton());
			jTabbedPane1.addTab("NO.2",new JButton());
		}
		return jTabbedPane1;
	}

	/**
	 * This method initializes jPanel11	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel11() {
		if (jPanel11 == null) {
			jPanel11 = new JPanel();
			jPanel11.setLayout(new GridBagLayout());
			status = new JButton("Choose");
	        colorSelectionPanel = new ColorSelectionPanel();
	        dropdown = new DropDownComponent(status,colorSelectionPanel);
	        colorSelectionPanel.addPropertyChangeListener("selectedColor",new PropertyChangeListener() {
	            public void propertyChange(PropertyChangeEvent evt) {
	                dropdown.hidePopup();
	                status.setBackground((Color)evt.getNewValue());
	            }
	        });
	        jPanel11.add(dropdown);
		}
		return jPanel11;
	}

	public static void main(String[] args) {
		SwingUI ui = new SwingUI();
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
