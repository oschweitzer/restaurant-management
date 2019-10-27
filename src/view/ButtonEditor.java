/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ButtonListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author Olivier
 */
public class ButtonEditor extends DefaultCellEditor
{

    protected JButton button;
    private ButtonListener bListener;

    public ButtonEditor(JCheckBox checkBox, ButtonListener btnListener)
    {
        //Par défaut, ce type d'objet travaille avec un JCheckBox
        super(checkBox);
        this.bListener = btnListener;
        //On crée à nouveau notre bouton
        button = new JButton();
        button.setOpaque(true);
        button.setBackground(Color.LIGHT_GRAY);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //On lui attribue un listener
        button.addActionListener(btnListener);
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
    {
        //On définit le numéro de ligne à notre listener
        bListener.setRow(row);
        //Idem pour le numéro de colonne
        bListener.setColumn(column);
        //On passe aussi en paramètre le tableau pour des actions potentielles
        bListener.setTable(table);
        //On réaffecte le libellé au bouton
        
       button.setText((value == null) ? "" : value.toString());
       button.setFont(new Font("Times New Roman", 0, 24));  
       button.setBackground(Color.LIGHT_GRAY);
       button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //On renvoie le bouton
        return button;
    }

    /**
     * @return the bListener
     */
    public ButtonListener getbListener()
    {
        return bListener;
    }

    /**
     * @param bListener the bListener to set
     */
    public void setbListener(ButtonListener bListener)
    {
        this.bListener = bListener;
    }
}
