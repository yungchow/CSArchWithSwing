package com.yc.swing.table;

import java.awt.*;
import javax.swing.*;

public class TestColumnSelectableJTable extends Object {

    private static final  Object[][] items= {
        {"Monday", "Cheeseburgers", "French Fries", "Peaches"},
        {"Tuesday", "Catfish", "Rice", "Starfruit"},
        {"Wednesday", "Tortellini", "Garlic Bread", "Pears"},
        {"Thursday", "Chicken", "Potatoes", "Strawberries"},
        {"Friday", "Pizza", null, "Fruit Cocktail"}
    };

    private static final Object[] headers = {
        "Day", "Main course", "Side dish", "Fruit"
    };

    public static void main (String[] args) {
        JFrame f = new JFrame ("Selectable columns");
        ColumnSelectableJTable table = 
            new ColumnSelectableJTable(items, headers);
        JScrollPane scroller =
            new JScrollPane (table,
                             ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                             ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        f.getContentPane().add (scroller);
        f.pack();
        f.setVisible(true);
    }



}
