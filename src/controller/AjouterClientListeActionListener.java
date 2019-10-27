/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Table;
import view.CommandePanel;

/**
 *
 * @author Jean-François
 */
public class AjouterClientListeActionListener implements ActionListener
{
    private Table m_Table;
    
    public AjouterClientListeActionListener(Table a_Table)
    {
        m_Table = a_Table;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        m_Table.ajouterClient();
    }
}
