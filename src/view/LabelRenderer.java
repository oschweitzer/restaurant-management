/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Olivier
 */
public class LabelRenderer extends JLabel implements TableCellRenderer
{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        this.setText((value != null) ? value.toString() : "");
        this.setFont(new Font("Tahoma", 2, 24));
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        return this;
    }
    
}
