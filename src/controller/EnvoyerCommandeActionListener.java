/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.CommandePanel;
import view.MainFrame;

/**
 *
 * @author Jean-François
 */
public class EnvoyerCommandeActionListener implements ActionListener
{
    private MainFrame m_MainFrame;
    private CommandePanel m_Panel;
    
    public EnvoyerCommandeActionListener(MainFrame a_MainFrame, CommandePanel a_CommandePanel)
    {
        m_MainFrame = a_MainFrame;
        m_Panel = a_CommandePanel;
    }
   
    @Override
    public void actionPerformed(ActionEvent e) 
    {       
        String title = "Confirmation de l'envoi de la commande";
        String message = "Etes-vous sûr de vouloir envoyer la commande ?";
        int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);

        if (reply == JOptionPane.YES_OPTION)
        {
            m_MainFrame.showCurrentPanel(m_MainFrame.getGeneralPanel().getPreviousPanel(), m_MainFrame.getGeneralPanel().getPreviousPanelTitle(), m_MainFrame.getPanelName(m_MainFrame.getGeneralPanel().getCurrentPanel())[0]);     
            m_Panel.ClearPanel();
        }
    }
}