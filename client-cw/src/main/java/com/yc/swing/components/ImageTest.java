package com.yc.swing.components;

import javax.swing.*;
import java.awt.event.*;

public class ImageTest {

    public static void main(String[] args) {
        ImagePanel panel = new ImagePanel(new ImageIcon("./src/main/resources/image/swing/component/01/background.png").getImage());

        
        ImageLabel label = new ImageLabel(new ImageIcon("./src/main/resources/image/swing/component/01/reactor.png"));
        label.setLocation(29,37);
        panel.add(label);
        
        final ImageButton button = new ImageButton("./src/main/resources/image/swing/component/01/button.png");
        button.setPressedIcon(new ImageIcon("./src/main/resources/image/swing/component/01/button-down.png"));
        button.setRolloverIcon(new ImageIcon("./src/main/resources/image/swing/component/01/button-over.png"));
        button.setSelectedIcon(new ImageIcon("./src/main/resources/image/swing/component/01/button-sel.png"));
        button.setRolloverSelectedIcon(new ImageIcon("./src/main/resources/image/swing/component/01/button-sel-over.png"));
        button.setDisabledIcon(new ImageIcon("./src/main/resources/image/swing/component/01/button-disabled.png"));
        button.setDisabledSelectedIcon(new ImageIcon("./src/main/resources/image/swing/component/01/button-disabled-selected.png"));
        button.setLocation(60,74);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button.setSelected(!button.isSelected());
                System.out.println("selecting");
            }
        });
        //button.setSelected(true);
        //button.setDisabled(false);
        panel.add(button);
        
        
        final JCheckBox checkbox = new JCheckBox("Disable");
        checkbox.setLocation(70,150);
        checkbox.setOpaque(false);
        checkbox.setSize(checkbox.getPreferredSize());
        panel.add(checkbox);
        checkbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button.setEnabled(!checkbox.isSelected());
            }
        });
        
        

        JFrame frame = new JFrame("Image Components");
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
