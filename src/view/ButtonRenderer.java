/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.JButton;

/**
 *
 * @author Olivier
 */
public class ButtonRenderer extends JButton implements TableCellRenderer
{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isFocus, int row, int col)
    {
        this.setBackground(Color.lightGray);

        this.setText((value != null) ? value.toString() : "");
        this.setFont(new Font("Times New Roman", 0, 24)); 
        this.setOpaque(true);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //On retourne notre bouton
        return this;
    }
}
