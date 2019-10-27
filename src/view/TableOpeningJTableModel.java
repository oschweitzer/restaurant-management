/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Olivier
 */
public class TableOpeningJTableModel extends DefaultTableModel
{
    public TableOpeningJTableModel(Object[][] data, Object[] columnName)
    {
        super(data, columnName);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return getValueAt(0, columnIndex).getClass();
    }
    
    public void clear()
    {
        this.dataVector.removeAllElements();
    }
    
    @Override
    public boolean isCellEditable(int row, int column)
    {
       if(this.getColumnName(column).equals("Tables disponibles") )
    {
        return false;
    }
    return true;
    }
    

}
