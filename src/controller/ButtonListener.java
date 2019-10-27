/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author Olivier
 */
public abstract class ButtonListener implements ActionListener
{

    protected int column, row;
    protected JTable table;
    protected int nbre = 0;
    protected JButton button;

    public void setColumn(int col)
    {
        this.column = col;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public void setTable(JTable table)
    {
        this.table = table;
    }

    public JButton getButton()
    {
        return this.button;
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        this.button = ((JButton) event.getSource());
    }
}
