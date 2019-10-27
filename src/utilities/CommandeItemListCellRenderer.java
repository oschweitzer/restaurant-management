/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import view.CommandeItemPanel;

/**
 *
 * @author Jean-François
 */
public class CommandeItemListCellRenderer extends JLabel implements ListCellRenderer
{    
    public CommandeItemListCellRenderer()
    {
        setOpaque(true);
        setPreferredSize(new Dimension(400, 400));
    }

    @Override
    public Component getListCellRendererComponent(JList a_List, Object a_Value, int a_Index, boolean a_IsSelected, boolean a_CellHasFocus) 
    {
        return ((CommandeItemListEntry) a_Value).GetPanel();
    }    
}
