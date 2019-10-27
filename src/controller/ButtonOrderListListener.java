/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import model.Table;
import view.MainFrame;

/**
 *
 * @author Olivier
 */
public class ButtonOrderListListener extends ButtonListener
{

    private MainFrame mainFrame;

    public ButtonOrderListListener(MainFrame mainFrame)
    {
        super();
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        this.button = ((JButton) event.getSource());

        String s = this.table.getValueAt(this.table.getSelectedRow(), 0).toString();
        String[] parts = s.split("Table");
        String s1 = parts[0];
        String numTable = parts[1];

        mainFrame.getListeCommandeTable().getjLabel1().setText("Table sélectionnée : Table " + numTable);
        mainFrame.showCurrentPanel("listeCommandeTable", "Liste des commandes", "tableListPanel");
        
        mainFrame.getGeneralPanel().setCurrentPanel(mainFrame.getListeCommandeTable());
        mainFrame.getGeneralPanel().setPreviousPanel("tableListPanel");
        mainFrame.getGeneralPanel().setPreviousPanelTitle("Liste de vos tables");

        Table t = mainFrame.getServeurManager().getTable(Integer.parseInt(numTable));
        
        mainFrame.getListeCommandeTable().remplirTableau(t);
    }

}
