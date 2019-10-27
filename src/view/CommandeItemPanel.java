/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AjouterClientPourItemActionListener;
import controller.RetirerClientPourItemActionListener;
import controller.RetirerItemCommandeActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import model.ClientTable;
import model.Item;
import utilities.ObservableModification;
import static javax.swing.BorderFactory.createTitledBorder;

/**
 *
 * @author Jean-François
 */
public class CommandeItemPanel extends JPanel implements Observer
{   
    //Reference du titre
    private Item m_Item;
    
    //Reference au panel de commande
    private CommandePanel m_CommandePanel;
       
    //Reference au tableau
    private JTable m_Table;
    
    //Modele utilise pour construire le tableau de clients
    private DefaultTableModel m_TableModel;
    
    //Liste de clients
    private List<ClientTable> m_Clients;
        
    public CommandeItemPanel(CommandePanel a_Panel, Item a_Item)
    {
        m_Item = a_Item;
        m_CommandePanel = a_Panel;
        
        setLayout(new BorderLayout());        
        
        //Dimensions hardcodees...!
        setPreferredSize(new Dimension(100, 200));
               
        //Encadre le panel (Gestalt)
        setBorder(createTitledBorder(null, 
                                     null, 
                                     TitledBorder.CENTER, 
                                     TitledBorder.DEFAULT_POSITION, 
                                     new Font("Tahoma", Font.PLAIN, 24))); 
                
        //Cree l'entete avec le nom de l'article et le bouton pour retirer l'element
        CreerEntete(m_Item.getNomItem());
        
        //Cree la liste des clients qui ont commande l'article
        CreerTableauClients();
        
        //Cree boutons d'ajout et retrait de clients
        AjouterBoutons();
        
        //S'enregistre pour obtenir les modifications sur l'Item
        m_Item.addObserver(this);
    }
    
    private void CreerEntete(String a_ItemName)
    {
        //Panel qui contient les elements de l'entete
        JPanel header = new JPanel(new BorderLayout());

        //Nom de l'article
        JLabel titre = new JLabel(a_ItemName,  SwingConstants.CENTER);
        titre.setFont(new Font("Times New Roman", Font.BOLD, 27));
        header.add(titre, BorderLayout.CENTER);
        
        //Bouton pour retirer l'article de la liste
        JButton retirerBtn = new JButton("Retirer Item");
        retirerBtn.addActionListener(new RetirerItemCommandeActionListener(m_CommandePanel, this));
        retirerBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        
        header.add(retirerBtn, BorderLayout.EAST);  
        add(header, BorderLayout.NORTH);
    }
    
    private void CreerTableauClients()
    {
        m_Clients = new ArrayList<ClientTable>();
        
        //Panel contenant la liste des clients qui ont commande l'article
        JPanel clientListPanel = new JPanel(new BorderLayout());
       
        //Tableau pour afficher client et quantite
        m_TableModel = new DefaultTableModel();
        m_TableModel.addColumn("Clients");
        m_TableModel.addColumn("Quantite");
        m_TableModel.addColumn("Commentaires");
        
        m_Table = new JTable(m_TableModel);
        
        m_Table.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        m_Table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 18));

        JScrollPane pane = new JScrollPane(m_Table);
        
        clientListPanel.add(pane, BorderLayout.CENTER);
        add(clientListPanel, BorderLayout.CENTER);   
    }
    
    private void AjouterBoutons()
    {
        JButton addClient = new JButton("Associer Client");
        JButton removeClient = new JButton("Dissocier Client");
        
        addClient.addActionListener(new AjouterClientPourItemActionListener(m_Item, m_CommandePanel));
        removeClient.addActionListener(new RetirerClientPourItemActionListener(m_Item, this));
        
        addClient.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        removeClient.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        
        buttonPanel.add(addClient);
        buttonPanel.add(removeClient);
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(buttonPanel, BorderLayout.EAST);
        
        add(panel, BorderLayout.SOUTH);
    }
    
    public void AjouterClient(ClientTable a_Client)
    {
        String name = "Client #" + a_Client.getNumClientTable();
                
        if(!m_Clients.contains(a_Client))
        {
            m_Clients.add(a_Client);
            m_TableModel.addRow(new Object[]{name, 1});
        }
        else
        {   
            for(int i = 0; i < m_TableModel.getRowCount(); ++i)
            {
                if(m_TableModel.getValueAt(i, 0).equals(name))
                {
                    int value = (int)m_TableModel.getValueAt(i, 1);
                    m_TableModel.setValueAt(++value, i, 1); 
                }
            }
        } 
    }
    
    public void RetirerClient(ClientTable a_Client)
    {
        m_Clients.remove(a_Client);
        for(int i = 0; i < m_TableModel.getRowCount(); ++i)
        {
            String clientName = m_TableModel.getValueAt(i, 0).toString();
            if(clientName.equals("Client #" + a_Client.getNumClientTable()))
            {
                m_TableModel.removeRow(i);
                break;
            }
        }
    }
    
    public List<ClientTable> GetClientsSelectionnes()
    {
        int[] indices = m_Table.getSelectedRows();
        
        List<ClientTable> clients = new ArrayList<ClientTable>();
        for(int i = 0; i < indices.length; ++i)
        {
            String name = (String)m_TableModel.getValueAt(indices[i], 0);
            int id = Integer.parseInt(name.replaceAll("[\\D]", ""));
            
            for(ClientTable client : m_Clients)
            {
                if(client.getNumClientTable() == id)
                {
                    clients.add(client);
                }
            }
        }
        
        return clients;
    }
        
    public String GetNomItem()
    {
        return m_Item.getNomItem();
    }
    
    public Item GetItem()
    {
        return m_Item;
    }

    @Override
    public void update(Observable o, Object arg) 
    {
        ObservableModification modif = (ObservableModification) arg;
        if(modif != null)
        {
            if(modif.GetModification() == ObservableModification.Modification.Ajouter)
            {
                AjouterClient((ClientTable) modif.GetObjects());
            }
            else if(modif.GetModification() == ObservableModification.Modification.Retirer)
            {
                RetirerClient((ClientTable) modif.GetObjects());
            }
        }
    }
}