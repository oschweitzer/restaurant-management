/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Jean-François
 */
public class ClientListCellRenderer extends JLabel implements ListCellRenderer
{
    private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
    
    public ClientListCellRenderer()
    {
        setOpaque(true);
        setIconTextGap(LEFT);
        setPreferredSize(new Dimension(100, 100));
    }
    
    @Override
    public Component getListCellRendererComponent(JList a_List, Object a_Value, int a_Index, boolean a_IsSelected, boolean a_CellHasFocus) 
    {
        ClientListEntry entry = (ClientListEntry) a_Value;
        if(entry != null)
        {
            //Texte, exemple : Client# 3
            setText(entry.GetTitle());
            setFont(new Font("Times New Roman", Font.BOLD, 18));
            setIcon(entry.GetImage());
            
            if(a_IsSelected)
            {
                setBackground(Color.blue);
            }
            else
            {
                //Alterne les couleurs pour creer une fermeture
                if(a_Index % 2 == 0)
                {
                    setBackground(Color.decode("#f0f0f4"));
                }
                else
                {
                    setBackground(Color.decode("#e2e2e9"));
                }
            }
        }
        
        return this;
    }

    
}
