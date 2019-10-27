/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Olivier
 */
public class JTableComponent extends DefaultTableCellRenderer
{

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        if (value instanceof JButton)
        {
            ((JButton) value).setBackground(new Color(240,240,240));
            ((JButton) value).setCursor(new Cursor(Cursor.HAND_CURSOR));
            return (JButton) value;
        } //Lignes ajoutées
        else if (value instanceof JLabel)
        {
            return (JLabel) value;
        } else
        {
            return this;
        }
    }
}
