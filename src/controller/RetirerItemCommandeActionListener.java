/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CommandeItemPanel;
import view.CommandePanel;

/**
 *
 * @author Jean-François
 */
public class RetirerItemCommandeActionListener implements ActionListener 
{
    CommandeItemPanel m_ItemPanel;
    CommandePanel m_CommandePanel;
    
    public RetirerItemCommandeActionListener(CommandePanel a_CommandePanel, CommandeItemPanel a_ItemPanel)
    {
        m_ItemPanel = a_ItemPanel;
        m_CommandePanel = a_CommandePanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {        
        m_CommandePanel.GetCurrentCommande().retirerItem(m_ItemPanel.GetItem());
    } 
}
