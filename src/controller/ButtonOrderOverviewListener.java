/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Commande;
import model.Item;
import model.Table;
import view.MainFrame;

/**
 *
 * @author Olivier
 */
public class ButtonOrderOverviewListener extends ButtonListener
{
   private  MainFrame mainFrame;
   
    public ButtonOrderOverviewListener(MainFrame mainFrame)
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
        
        JOptionPane.showMessageDialog(mainFrame,
                afficherCommande(c),
                "Résumé commande",
                JOptionPane.PLAIN_MESSAGE);
        
    }
    
    public String afficherCommande(Commande c)
    {
        String s = "Numéro de commande : " + c.getNumeroCommande() + "\n"
                + "Date : " + c.getHeure() + "\n"
                + "\n";
        
        int j = 1;
        for(Item i : c.getItems())
        {
            s += "- Article " + j + " : " + i.getNomItem() + "\n";
            j++;
        }
        
        return s;
    }
    
}
