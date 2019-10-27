/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import model.ClientTable;
import model.Item;
import view.CommandeItemPanel;

/**
 *
 * @author Jean-François
 */
public class RetirerClientPourItemActionListener implements ActionListener
{
    private Item m_Item;
    private CommandeItemPanel m_Panel;
    
    public RetirerClientPourItemActionListener(Item a_Item, CommandeItemPanel a_Panel)
    {
        m_Item = a_Item;
        m_Panel = a_Panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        List<ClientTable> clients = m_Panel.GetClientsSelectionnes();
        for(ClientTable client : clients)
        {
            m_Item.retirerClient(client);
        }
    }    
}