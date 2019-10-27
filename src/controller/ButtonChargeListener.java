/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import view.MainFrame;

/**
 *
 * @author Olivier
 */
public class ButtonChargeListener extends ButtonListener
{
    private MainFrame mainFrame;
    
    public ButtonChargeListener(MainFrame mainFrame)
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
        String numTable = parts[1];
       
        mainFrame.facturerTable(Integer.parseInt(numTable), "tableListPanel");
        
        mainFrame.showCurrentPanel("facturation", "Facturation", "Liste de vos tables");
        
        mainFrame.getGeneralPanel().setCurrentPanel(mainFrame.getFacturation());
        mainFrame.getGeneralPanel().setPreviousPanel("tableListPanel");
        mainFrame.getGeneralPanel().setPreviousPanelTitle("Liste de vos tables");

    }
    
}
