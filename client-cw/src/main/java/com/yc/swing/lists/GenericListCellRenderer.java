package com.yc.swing.lists;

import java.awt.*;
import javax.swing.*;
import java.lang.reflect.*;

public class GenericListCellRenderer extends DefaultListCellRenderer {
    protected String method;
    public GenericListCellRenderer(String method) {
        super();
        this.method = method;
    }
    
    
    public Component getListCellRendererComponent(JList list, Object value,
        int index, boolean isSelected, boolean cellHasFocus) {
        
        JLabel label = (JLabel)super.getListCellRendererComponent(
            list,value,index, isSelected, cellHasFocus);
        
        try {
            Method meth = value.getClass().getMethod(method,null);
            if(meth != null) {
                Object retval = meth.invoke(value,null);
                label.setText(""+retval);
            }
        } catch (Exception ex) {
            System.out.println("got an execption: " + ex);
            ex.printStackTrace();
        }
        
        return label;
        
    }
    

    public static void main(String[] args) {
        String[] data = { "Proton", "Neutron", "Electron" };
        JList list = new JList(data);
        
//        GenericListCellRenderer renderer = 
//            new GenericListCellRenderer("toString");
        GenericListCellRenderer renderer = 
            new GenericListCellRenderer("length");
//        GenericListCellRenderer renderer = 
//            new GenericListCellRenderer("hashCode");
        list.setCellRenderer(renderer);
        
        JFrame frame = new JFrame("Cell Renderer Hack");
        frame.getContentPane().add(list);
        frame.pack();
        frame.setVisible(true);
    }

}
