/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import model.Commande;
import model.Table;
import view.CommandePanel;
import view.MainFrame;

/**
 *
 * @author Olivier
 */
public class ButtonModifyOrderListener extends ButtonListener
{

    private MainFrame mainFrame;

    public ButtonModifyOrderListener(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        this.button = ((JButton) event.getSource());

        String s = this.table.getValueAt(this.table.getSelectedRow(), 0).toString();
        String[] parts = s.split("Commande ");
        String s1 = parts[0];
        String numCommande = parts[1];

        String t = mainFrame.getListeCommandeTable().getjLabel1().getText();
        String[] parts2 = t.split("Table sélectionnée : Table ");
        String p1 = parts2[0];
        String numTable = parts2[1];

        Table tab = mainFrame.getServeurManager().getTable(Integer.parseInt(numTable));
        Commande c = mainFrame.getServeurManager().getCommandeFromTable(tab, Integer.parseInt(numCommande));

        CommandePanel cmdPanel = mainFrame.getCommandePanel();
        cmdPanel.UpdatePanel(tab, c);

        mainFrame.showCurrentPanel("outilCommande", "<html> <div style='text-align: center;'>"
                                   + "Gestion de la Commande : "
                                   + "<br> <font color=\"black\"> "
                                   + "Table # " + tab.getNumeroTable() 
                                   + "</font></html>", "tableListPanel");
        mainFrame.getGeneralPanel().setCurrentPanel(cmdPanel);
        mainFrame.getGeneralPanel().setPreviousPanel("tableListPanel");
        mainFrame.getGeneralPanel().setPreviousPanelTitle("Liste de vos tables");
    }
}
