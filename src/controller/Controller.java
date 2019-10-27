/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Serveur;
import model.ServeurManager;
import model.Table;
import view.HomePanel;
import view.MainFrame;

/**
 *
 * @author Olivier
 */
public class Controller
{

    private ServeurManager serveurManager;
    private MainFrame mainFrame;

    /**
     *
     * @param serveurManager
     * @param newFrame
     */
    public Controller(ServeurManager serveurManager, MainFrame newFrame)
    {
        this.serveurManager = serveurManager;
        this.mainFrame = newFrame;
    }

    /**
     *
     * @param code
     */
    public void connexion(String code)
    {
        Serveur serveur = serveurManager.getServeurs().get(code); // on récupère le serveur à partir de son code entré

        if (serveur != null) // serveur est null si le code n'existe pas
        {
            serveurManager.setServeurConnected(serveur); // on connecte le serveur
            String previousPanel = mainFrame.getHomePanel().getPreviousPanel();
            String previousPanelTitle = mainFrame.getHomePanel().getPreviousPanelTitle();

            if (previousPanel != null && previousPanelTitle != null) // si ce n'est pas la première connexion
            {
                if (serveurManager.getPreviousConnected() != null)
                {
                    // Si le serveur qui se connecte est le même qu'avant
                    if (serveur.getCode().equals(serveurManager.getPreviousConnected().getCode()))
                    {
                        // on affiche le panneau où le serveur était
                        mainFrame.showCurrentPanel(previousPanel, previousPanelTitle, "tableListPanel");
//                        mainFrame.getGeneralPanel().setPreviousPanel("homePanel");
//                        mainFrame.getGeneralPanel().setPreviousPanelTitle("");

                    }
                    else
                    {
                        // On affiche la liste des tables du nouveau serveur
                        mainFrame.showCurrentPanel("tableListPanel", "Liste de vos tables", "homePanel");
                        mainFrame.getGeneralPanel().setCurrentPanel(mainFrame.getTableListPanel());
                        mainFrame.getGeneralPanel().setPreviousPanel("homePanel");
                        mainFrame.getGeneralPanel().setPreviousPanelTitle("");
                        
                        // On met à jour la liste des tables
                        mainFrame.getTableListPanel().remplirListeTables(serveur);
                    }
                }
                else
                {
                   // System.out.println("Pas de serveur connecté précédemment");
                }

            }
            else // première connexion
            {
                // On affiche la liste des tables du serveur
                mainFrame.showCurrentPanel("tableListPanel", "Liste de vos tables", "homePanel");
                mainFrame.getGeneralPanel().setCurrentPanel(mainFrame.getTableListPanel());
                mainFrame.getGeneralPanel().setPreviousPanel("homePanel");
                mainFrame.getGeneralPanel().setPreviousPanelTitle("");
            }

            mainFrame.getGeneralPanel().setVisible(true); // on affiche le panneau du haut
        }
        else
        {
            JOptionPane.showMessageDialog(mainFrame,
                    "Cet identifiant n'existe pas, veuillez entrer un identifiant valide",
                    "Erreur de connexion",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     *
     * @param p
     */
    public void deconnexion(JPanel p)
    {
        // on supprime le panneau de connexion déjà présent
        mainFrame.getContentPanel().remove(mainFrame.getHomePanel());
        HomePanel homePanel = new HomePanel(mainFrame); // on recréé un panneau de connexion

        homePanel.setListener(this);
        mainFrame.setHomePanel(homePanel);

        String[] currentPanel = mainFrame.getPanelName(p); // on récupère le nom et le titre du panneau courant
        String previousPanel = currentPanel[0];
        String previousPanelTitle = currentPanel[1];

        // on sauvegarde le panneau courant pour y revenir
        homePanel.setPreviousPanel(previousPanel);
        homePanel.setPreviousPanelTitle(previousPanelTitle);

        // on enregistre le serveur couramment connecté
        serveurManager.setPreviousConnected(serveurManager.getConnected());

        // on affiche la fenêtre de connexion
        mainFrame.getContentPanel().add(homePanel, "homePanel");
        mainFrame.showCurrentPanel("homePanel", "Connexion",previousPanel);
        mainFrame.getGeneralPanel().setVisible(false);
        mainFrame.getHomePanel().getjPasswordField1().setText("");
    }

    /**
     * 
     * @param currentPanel 
     */
    public void retour(JPanel currentPanel)
    {
        CardLayout cards = (CardLayout) mainFrame.getContentPanel().getLayout();
        if(currentPanel == mainFrame.getPanelFromName("tableListPanel"))
        {
            
             JOptionPane.showMessageDialog(mainFrame,
                    "Impossible de revenir à l'écran précédent.\n "
                            + "Si vous souhaitez revenir à l'écran de connexion, veuillez cliquer "
                            + "sur le bouton cadenas situé à droite",
                    "Retour impossible",
                    JOptionPane.ERROR_MESSAGE);
        }
        else
        {
          mainFrame.showCurrentPanel(mainFrame.getGeneralPanel().getPreviousPanel(), mainFrame.getGeneralPanel().getPreviousPanelTitle(), mainFrame.getPanelName(mainFrame.getGeneralPanel().getCurrentPanel())[0]);  
        }
        
        // TODO : prévenir utilisateur vers quelle fenêtre il va se diriger
    }

    /**
     *
     * @param table
     * @param nbClient
     */
    public void ouvrirTable(String table, int nbClient)
    {
        String[] parts = table.split("Table");
        String part1 = parts[0];
        String numTable = parts[1];

        if (serveurManager.getTableFromNumber(Integer.parseInt(numTable)) != null)
        {
            String message = "Etes-vous sûr de vouloir ouvrir la " + table + " pour " + nbClient + " clients ? \n"
                    + "Cette action vous ramenera à l'écran \"Liste de vos tables\"";
            String title = "Confirmation ouverture table";
            int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);

            if (reply == JOptionPane.YES_OPTION)
            {
                Table t = serveurManager.getTableFromNumber(Integer.parseInt(numTable));
                t.setDisponible(false);
                t.ajouterClients(nbClient);
                serveurManager.getConnected().getTables().add(t);
                serveurManager.setServeurConnected(serveurManager.getConnected());
                
                mainFrame.getOuvertureTable().resetSpinner();
                mainFrame.showCurrentPanel("tableListPanel", "Liste de vos tables", "ouvertureTable");
                mainFrame.getGeneralPanel().setPreviousPanel("ouvertureTable");
                mainFrame.getGeneralPanel().setPreviousPanelTitle("Ouverture d'une table");
                
            }
        }
        else
        {
            JOptionPane.showMessageDialog(mainFrame,
                    "Le numéro de table sélectionné n'existe pas",
                    "Erreur de sélection de table",
                    JOptionPane.ERROR_MESSAGE);
        }

        // TODO rajouter table dans liste table géré par serveur
    }

}
