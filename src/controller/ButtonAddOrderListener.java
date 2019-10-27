/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import model.Table;
import view.CommandePanel;
import view.MainFrame;

/**
 *
 * @author Olivier
 */
public class ButtonAddOrderListener extends ButtonListener
{
    private MainFrame mainFrame;
    
    public ButtonAddOrderListener(MainFrame mainFrame)
    {
        super();
        this.mainFrame = mainFrame;
    }
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
        this.button = ((JButton) event.getSource());
        this.setTable(mainFrame.getTableListPanel().getTableau());
        String s = this.table.getValueAt(this.table.getSelectedRow(), 0).toString();
        String[] parts = s.split("Table");
        String s1 = parts[0];
        String numTable = parts[1];
        
        Table t = mainFrame.getServeurManager().getTableFromNumber(Integer.parseInt(numTable));
         
        CommandePanel cmdPanel = mainFrame.getCommandePanel();
        cmdPanel.UpdatePanel(t, null);
        
        mainFrame.showCurrentPanel("outilCommande", "<html> <div style='text-align: center;'>"
                                   + "Gestion de la Commande : "
                                   + "<br> <font color=\"black\"> "
                                   + "Table # " + t.getNumeroTable() 
                                   + "</font></html>", "tableListPanel");
        mainFrame.getGeneralPanel().setCurrentPanel(cmdPanel);
        mainFrame.getGeneralPanel().setPreviousPanel("tableListPanel");
        mainFrame.getGeneralPanel().setPreviousPanelTitle("Liste de vos tables");
    }   
}
