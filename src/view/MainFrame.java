/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.ClientTable;
import model.Facture;
import model.ServeurManager;
import model.Table;

/**
 *
 * @author Olivier
 */
public class MainFrame extends JFrame
{

    private HomePanel homePanel;
    private TableList tableListPanel;
    private GeneralPanel generalPanel;
    private TableOpening ouvertureTable;
    private JPanel contentPane;
    private ServeurManager serveurManager;

    private TableOrderList listeCommandeTable;
    private CommandePanel commandePanel;
    private Invoicing facturation;


    /**
     * Creates new form MainFrame
     */
    public MainFrame()
    {
        this.setTitle("Interface Refuge des brasseurs"); // Titre de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // on met la fenêtre en plein écran
        initComponents(); // fonction qui créer les éléments de la fenêtre (code issu du Designer de fenêtre)
        
        generalPanel = new GeneralPanel();
        
        // on ajoute une montre avec l'heure et la date
        String date = new SimpleDateFormat("dd/MM/yyyy", Locale.CANADA).format(new Date());
        javax.swing.Timer t = new javax.swing.Timer(1000, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
                // on affiche la montre dans le panneau du haut
                getGeneralPanel().getjLabel2().setText(date + " - " + df.format(Calendar.getInstance().getTime()));
            }
            
        });
        t.start();
        
        // panel de la fenêtre
        JPanel p = new JPanel();
        p.setBackground(new Color(240,240,240));
        p.setLayout(new BorderLayout());

        setContentPane(p);
        
        // on créé le panneau central
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240,240,240));

        contentPane.setBorder(BorderFactory.createLineBorder(Color.gray,5));

        contentPane.setLayout(new CardLayout(0, 0));

        // on ajoute la page de connexion
        homePanel = new HomePanel(this);
        contentPane.add(homePanel,"homePanel");
        
        // on ajoute la fenêtre contenant la liste des tables du serveur connecté
        tableListPanel = new TableList(this);
        contentPane.add(tableListPanel,"tableListPanel");
        
        // on ajoute la fenêtre contenant la liste des tables pouvant être ouverte
        ouvertureTable = new TableOpening(this);
        contentPane.add(ouvertureTable, "ouvertureTable");
        
        listeCommandeTable = new TableOrderList(this);
        contentPane.add(listeCommandeTable, "listeCommandeTable");
        
        // on ajoute la fenêtre pour réaliser les commandes
        commandePanel = new CommandePanel(this);
        contentPane.add(commandePanel, "outilCommande");
        
        facturation = new Invoicing(this);
        contentPane.add(facturation, "facturation");
        
        p.add(generalPanel, BorderLayout.PAGE_START); // on ajoute le panneau du haut
        p.add(contentPane, BorderLayout.CENTER); // on ajoute le panneau central
    }

    /**
     * Associe un controleur à la fenêtre pour utiliser l'architecture MVC
     * @param controleur objet permettant la gestion des événements sur la fenêtre
     */
    protected void setControleur(Controller controleur)
    {
        getHomePanel().setListener(controleur);
        getOuvertureTable().setListener(controleur);
        getGeneralPanel().setListener(controleur);
    }

    /**
     * Fonction permettant de trouver le nom et le titre du panel passé en paramètre
     * @param p Panel à partir duquel on souhaite connaître son nom et son titre
     * @return 
     */
    public String[] getPanelName(JPanel p)
    {
        // TODO rajouter les nouveaux panel 
        
        // Position 0 dans s : le nom du panel
        // Position 1 dans s : le titre de la fenêtre
        String[] s = new String[2];
        if(p instanceof HomePanel)
        {
            s[0] = "homePanel";
            s[1]  = "";
        }
        else if(p instanceof TableOpening)
        {
            s[0]  = "ouvertureTable";
            s[1] = "Ouverture d'une table";
        }
        else if(p instanceof TableList)
        {
            s[0]  = "tableListPanel";
            s[1] = "Liste de vos tables";
        }
        else if(p instanceof TableOrderList)
        {
            s[0]  = "listeCommandeTable";
            s[1] = "Liste des commandes";
        }
        else if(p instanceof CommandePanel)
        {
            s[0]  = "outilCommande";
            s[1] = "Gestion de la Commande";
        }
        else if(p instanceof Invoicing)
        {
            s[0]  = "facturation";
            s[1] = "Facturation";
        }
        return s;
    }
    
    /**
     * Permet de récupérer le JPanel à partir du nom de ce dernier
     * @param name Nom du JPanel dans la fenêtre principale
     * @return 
     */
    public JPanel getPanelFromName(String name)
    {
        JPanel p = null;
        
        // TODO rajouter les nouveaux panel 

        switch (name)
        {
            case "tableListPanel":
                p = this.getTableListPanel();
                break;
            case "ouvertureTable":
                p = this.getOuvertureTable();
                break;
            case "listeCommandeTable":
                p = this.getListeCommandeTable();
                break;
            case "outilCommande":
                p = this.getCommandePanel();
            case "facturation":
                p = this.getFacturation();
            default:
                break;
        }
        
        return p;
    }
    
    public void facturerTable(int tableNo, String previousPanel )
    {        
        Table t = getServeurManager().getTableFromNumber(tableNo);
        
        ArrayList<Facture> factureList = new  ArrayList<Facture>();

        for(ClientTable client : t.getClients())
        {
            Facture fac = new Facture(tableNo, client.getNumClientTable());
            fac.setItem(t.getItemsByClient(client));
            factureList.add(fac);
        }
        
        facturation.updateFacture(factureList);
        showCurrentPanel("invoicingPanel", "Facturation Table "+t.getNumeroTable(), previousPanel);
    }
    
    public Invoicing getFacturation()
    {
        return this.facturation;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 983, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 769, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(()
                -> 
                {
                    MainFrame mainFrame = new MainFrame();
                    
                    mainFrame.setServeurManager(new ServeurManager());
                    Controller controleur = new Controller(mainFrame.getServeurManager(), mainFrame);
                    mainFrame.setControleur(controleur);
                    
                    
                    mainFrame.getServeurManager().addObserver(mainFrame.getTableListPanel());
                    
                    mainFrame.setVisible(true);
        });
    }

    /**
     * Méthode permettant d'afficher le panel souhaité
     * @param panelToShow
     * @param frameName 
     */
    public void showCurrentPanel(String panelToShow, String frameName, String previousPanel)
    {
        CardLayout currentLayout = (CardLayout) (contentPane.getLayout());
        currentLayout.show(contentPane, panelToShow);
        this.getGeneralPanel().changeFrameName(frameName);
        
        this.getGeneralPanel().setCurrentPanel(this.getPanelFromName(panelToShow));
        
        
        if(previousPanel != null)
        {
            this.getGeneralPanel().setPreviousPanel(previousPanel);
        }
            

    }
    
    /**
     * 
     * @return 
     */
    public JPanel getContentPanel()
    {
        return this.contentPane;
    }
    
    /**
     * 
     * @param contentPanel 
     */
    public void setContentPanel(JPanel contentPanel)
    {
        this.contentPane = contentPanel;
    }

    /**
     * @return the homePanel
     */
    public HomePanel getHomePanel()
    {
        return homePanel;
    }

    /**
     * @param homePanel the homePanel to set
     */
    public void setHomePanel(HomePanel homePanel)
    {
        this.homePanel = homePanel;
    }

    /**
     * @return the tableListPanel
     */
    public TableList getTableListPanel()
    {
        return tableListPanel;
    }

    /**
     * @param tableListPanel the tableListPanel to set
     */
    public void setTableListPanel(TableList tableListPanel)
    {
        this.tableListPanel = tableListPanel;
    }
    
    /**
     * @param commandePanel the commandePanel to set
     */
    public CommandePanel getCommandePanel()
    {
        return this.commandePanel;
    }

    /**
     * @return the generalPanel
     */
    public GeneralPanel getGeneralPanel()
    {
        return generalPanel;
    }

    /**
     * @param generalPanel the generalPanel to set
     */
    public void setGeneralPanel(GeneralPanel generalPanel)
    {
        this.generalPanel = generalPanel;
    }

    /**
     * @return the serveurManager
     */
    public ServeurManager getServeurManager()
    {
        return serveurManager;
    }

    /**
     * @param serveurManager the serveurManager to set
     */
    public void setServeurManager(ServeurManager serveurManager)
    {
        this.serveurManager = serveurManager;
    }
    
    /**
     * 
     * @return 
     */
    public TableOpening getOuvertureTable()
    {
        return ouvertureTable;
    }
    
    /**
     * 
     * @param ouvertureTable 
     */
    public void setServeurManager(TableOpening ouvertureTable)
    {
        this.ouvertureTable = ouvertureTable;
    }
    
    /**
     * 
     * @return 
     */
    public TableOrderList getListeCommandeTable()
    {
        return this.listeCommandeTable;
    }
    
    /**
     * 
     * @param list 
     */
    public void setListeCommadeTable(TableOrderList list)
    {
        this.listeCommandeTable = list;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
