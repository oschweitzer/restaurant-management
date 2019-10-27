/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import AccordionMenu.AccordionLeafItem;
import AccordionMenu.AccordionMenu;
import utilities.ItemUtils;
import view.CommandePanel;

/**
 *
 * @author Jean-François
 */
public class AjouterItemACommandeActionListener implements ActionListener 
{
    private AccordionMenu m_ItemsMenu;
    private CommandePanel m_CommandePanel;
    
    public AjouterItemACommandeActionListener(AccordionMenu a_ItemsMenu, CommandePanel a_Panel)
    {
        m_ItemsMenu = a_ItemsMenu;
        m_CommandePanel = a_Panel;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        List<AccordionLeafItem> selection = m_ItemsMenu.GetLeafSelection();
        for(AccordionLeafItem item : selection)
        {
            String name = item.getText();
            m_CommandePanel.GetCurrentCommande().ajouterItem(ItemUtils.String2Item(name));
        }
        
        m_ItemsMenu.ResetLeafsSelection();
    }
}