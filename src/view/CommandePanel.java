/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AjouterClientListeActionListener;
import controller.AjouterItemACommandeActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import model.ClientTable;
import model.Commande;
import model.Item;
import AccordionMenu.AccordionMenu;
import controller.EnvoyerCommandeActionListener;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Iterator;
import java.util.Map.Entry;
import model.Table;
import utilities.ClientListEntry;
import utilities.ClientListCellRenderer;
import utilities.ItemUtils;
import utilities.ObservableModification;

/**
 *
 * @author Jean-François
 */
public class CommandePanel extends JPanel implements Observer 
{
    //Reference au MainFrame
    private MainFrame m_Frame;
    
    //Menu pour les articles
    private AccordionMenu m_Menu;
    
    //Panel qui contient l'ensemble des CommandesItemPanel
    private JPanel m_CommandesPanel;
    
    //Pour des fins de performance, on "cache" les articles present dans la commande
    private HashMap<String, CommandeItemPanel> m_ItemsEnCommande = new HashMap<String, CommandeItemPanel>();
      
    //Liste des clients affiches dans le paneau de droite
    private JList m_ClientList = new JList();
    
    //Commande courrante
    private Commande m_CurrentCommande;
    
    //Total de commandes
    private int m_CommandeCounter;
    
    //Gestion de la liste des clients
    private DefaultListModel <ClientListEntry> m_ListModel = new DefaultListModel<ClientListEntry>();
    
    /**
     * Creates new form CommandePanel
     */
    public CommandePanel(MainFrame a_Frame) 
    {
        m_Frame = a_Frame;
        m_CommandeCounter = 0;
        
        initComponents();
        
        //Cree la liste des articles en vente
        CreerListeArticles();
        
        //Initialise la liste des clients pour la table
        InitClientList();
        
        //Initialise la liste ou est affichee la commande en cours
        InitCommandeList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        Bottom_Panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        EnvoyerCmd_Button = new javax.swing.JButton();
        Center_Panel = new javax.swing.JPanel();
        Articles_Panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        AjouterItem_Btn = new javax.swing.JButton();
        Commandes_Panel = new javax.swing.JPanel();
        CommandesList_ScrollPanel = new javax.swing.JScrollPane();
        Clients_Panel = new javax.swing.JPanel();
        ClientList_ScrollPanel = new javax.swing.JScrollPane();
        AddClient_Button = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        Bottom_Panel.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        EnvoyerCmd_Button.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        EnvoyerCmd_Button.setText("Envoyer Commande");
        jPanel1.add(EnvoyerCmd_Button);

        Bottom_Panel.add(jPanel1, java.awt.BorderLayout.EAST);

        add(Bottom_Panel, java.awt.BorderLayout.PAGE_END);

        Center_Panel.setLayout(new java.awt.GridLayout(1, 3));

        Articles_Panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Articles en vente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 28))); // NOI18N
        Articles_Panel.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        AjouterItem_Btn.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        AjouterItem_Btn.setText("Ajouter Items >>");
        AjouterItem_Btn.setToolTipText("Ajouter les items selectionnées à la commande en cours");
        AjouterItem_Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AjouterItem_Btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(AjouterItem_Btn);
        AjouterItem_Btn.getAccessibleContext().setAccessibleName("AjouterItems");

        Articles_Panel.add(jPanel2, java.awt.BorderLayout.EAST);

        Center_Panel.add(Articles_Panel);

        Commandes_Panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commande en cours", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 28))); // NOI18N
        Commandes_Panel.setLayout(new java.awt.BorderLayout());
        Commandes_Panel.add(CommandesList_ScrollPanel, java.awt.BorderLayout.CENTER);

        Center_Panel.add(Commandes_Panel);

        Clients_Panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Clients sur Table\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 28))); // NOI18N
        Clients_Panel.setLayout(new java.awt.BorderLayout());
        Clients_Panel.add(ClientList_ScrollPanel, java.awt.BorderLayout.CENTER);

        AddClient_Button.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        AddClient_Button.setText("Ajouter Client à Table");
        AddClient_Button.setToolTipText("Ajouter un client à la table");
        Clients_Panel.add(AddClient_Button, java.awt.BorderLayout.SOUTH);
        AddClient_Button.getAccessibleContext().setAccessibleName("AjouterClient");

        Center_Panel.add(Clients_Panel);

        add(Center_Panel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddClient_Button;
    private javax.swing.JButton AjouterItem_Btn;
    private javax.swing.JPanel Articles_Panel;
    private javax.swing.JPanel Bottom_Panel;
    private javax.swing.JPanel Center_Panel;
    private javax.swing.JScrollPane ClientList_ScrollPanel;
    private javax.swing.JPanel Clients_Panel;
    private javax.swing.JScrollPane CommandesList_ScrollPanel;
    private javax.swing.JPanel Commandes_Panel;
    private javax.swing.JButton EnvoyerCmd_Button;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    private void InitClientList()
    {      
        m_ClientList = new JList(m_ListModel);
        m_ClientList.setCellRenderer(new ClientListCellRenderer());
        m_ClientList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);        

        ClientList_ScrollPanel.setViewportView(m_ClientList);
    }
    
    public void InitCommandeList()
    {
        m_CommandesPanel = new JPanel();
        m_CommandesPanel.setLayout(new BoxLayout(m_CommandesPanel, BoxLayout.Y_AXIS));
        CommandesList_ScrollPanel.setViewportView(m_CommandesPanel);
        
        EnvoyerCmd_Button.addActionListener(new EnvoyerCommandeActionListener(m_Frame, this));
    }
    
    public void CreerListeArticles()
    {
        StringBuilder sb = new StringBuilder();
        
        //Ajoute les bieres
        sb.append("Bières,menu1:");
        for(int i = 0; i < ItemUtils.Boisson.size(); ++i)
        {
            sb.append(ItemUtils.Boisson.get(i)).append(",submenu1.").append(i).append(";");
        }
        sb.append("!");
        
        //Ajoute la nourriture
        sb.append("Nourriture,menu2:");
        for(int i = 0; i < ItemUtils.Nourriture.size(); ++i)
        {
            sb.append(ItemUtils.Nourriture.get(i)).append(",submenu2.").append(i).append(";");
        }
        sb.append("!");
        
        //Ajoute la articles promo
        sb.append("Articles Promotionnels,menu3:");
        for(int i = 0; i < ItemUtils.ArticlesPromotionnels.size(); ++i)
        {
            sb.append(ItemUtils.ArticlesPromotionnels.get(i)).append(",submenu3.").append(i).append(";");
        }       
        
        //Creation du menu accordeon
        m_Menu = new AccordionMenu (sb.toString());
        
        m_Menu.setBackground(Color.decode("#e2e2e9"));
        
        AjouterItem_Btn.addActionListener(new AjouterItemACommandeActionListener(m_Menu, this));
        Articles_Panel.add(m_Menu, BorderLayout.CENTER);
    }
    
    public void UpdatePanel(Table a_Table, Commande a_Commande)
    {
        ClearPanel();
        
        if(a_Commande != null)
        {
            m_CurrentCommande = a_Commande;
                    
            //On modifie une commande existante, on recharge donc les infomations sur la commande
            for(Item item : a_Commande.getItems())
            {
                AjouterItem(item);
            }
        }  
        else
        {           
            m_CurrentCommande = new Commande(++m_CommandeCounter, new Date());
            a_Table.ajouterCommande(m_CurrentCommande);
        }
                
        //Ajouter les clients a la liste
        for(ClientTable client : a_Table.getClients())
        {
            AjouterClient(client);
        }
        
        //Ajoute un listener sur le bouton pour ajouter des clients a la table
        AddClient_Button.addActionListener(new AjouterClientListeActionListener(a_Table));
        
        //S'abonne pour obtenir les modifications sur le nombre personne a la table
        a_Table.addObserver(this);
        
        //S'abonne pour obtenir les modifications sur la commande
        m_CurrentCommande.addObserver(this);
    }
        
    public void AjouterClient(ClientTable a_Client)
    {
        m_ListModel.addElement(new ClientListEntry(a_Client));
    }
    
    public List<ClientTable> GetClientsSelectionnes()
    {
        int[] indices = m_ClientList.getSelectedIndices();
        
        List<ClientTable> clients = new ArrayList<ClientTable>();
        for(int i = 0; i < indices.length; ++i)
        {
            clients.add(m_ListModel.get(indices[i]).GetClient());
        }
        
        return clients;
    }
    
    public void ClearPanel()
    {
        //Clear les clients
        m_ListModel.removeAllElements();
        for(ActionListener list : AddClient_Button.getActionListeners())
        {
            AddClient_Button.removeActionListener(list);
        }

        //Vide le panel 
        Iterator it = m_ItemsEnCommande.entrySet().iterator();
        while(it.hasNext())
        {
            Entry e = (Entry)it.next();
            m_CommandesPanel.remove((CommandeItemPanel)e.getValue());
        }
        
        m_ItemsEnCommande.clear();
    }
   
    public void AjouterItem(Item a_Item)
    {
        //Ajoute un panel a la vue
        CommandeItemPanel item = new CommandeItemPanel(this, a_Item);
        m_CommandesPanel.add(item);
        
        //Dans le cas ou l'on restaure l'affichage d'une commande, 
        //on ajoute les clients ayant commande l'article
        if(a_Item.getClients() != null &&
           a_Item.getClients().size() > 0)
        {
            for(ClientTable client : a_Item.getClients())
            {
                item.AjouterClient(client);
            }
        }
        
        //Refresh la vue
        m_CommandesPanel.revalidate();
        m_Frame.repaint();
        
        //Cache les donnees
        m_ItemsEnCommande.put(a_Item.getNomItem(), item);
    }
    
    public void RetirerItem(Item a_Item)
    {
        //Retire le panel
        m_CommandesPanel.remove(m_ItemsEnCommande.get(a_Item.getNomItem()));
        
        //Refresh la vue
        m_CommandesPanel.revalidate();
        m_Frame.repaint();
        
        //Cache les donnees
        m_ItemsEnCommande.remove(a_Item.getNomItem());
    }
        
    @Override
    public void update(Observable o, Object arg)
    {
        ObservableModification modif = (ObservableModification) arg;
        if(modif != null)
        {          
            if(o instanceof Commande)
            {
                if(modif.GetModification() == ObservableModification.Modification.Ajouter)
                {
                    AjouterItem((Item)modif.GetObjects());
                }
                else if(modif.GetModification() == ObservableModification.Modification.Retirer)
                {
                    RetirerItem((Item)modif.GetObjects());
                }
            }
            
            if(o instanceof Table)
            {
                if(modif.GetModification() == ObservableModification.Modification.Ajouter)
                {
                    AjouterClient((ClientTable)modif.GetObjects());
                }
            }
        }
    }
    
    public Commande GetCurrentCommande()
    {
        return m_CurrentCommande;
    }
}