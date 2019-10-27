/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import javax.swing.JPanel;

/**
 *
 * @author Olivier
 */
public abstract class ApplicationPanel extends JPanel
{

    protected Controller controleur;
    protected MainFrame mainFrame;
    protected String previousPanel;
    protected String previousPanelTitle;

    /**
     * @return the controleur
     */
    public Controller getControleur()
    {
        return controleur;
    }

    /**
     * @param controleur the controleur to set
     */
    public void setControleur(Controller controleur)
    {
        this.controleur = controleur;
    }

    /**
     * @return the mainFrame
     */
    public MainFrame getMainFrame()
    {
        return mainFrame;
    }

    /**
     * @param mainFrame the mainFrame to set
     */
    public void setMainFrame(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
    }

    /**
     * @return the previousPanel
     */
    public String getPreviousPanel()
    {
        return previousPanel;
    }

    /**
     * @param previousPanel the previousPanel to set
     */
    public void setPreviousPanel(String previousPanel)
    {
        this.previousPanel = previousPanel;
    }

    /**
     * @return the previousPanelTitle
     */
    public String getPreviousPanelTitle()
    {
        return previousPanelTitle;
    }

    /**
     * @param previousPanelTitle the previousPanelTitle to set
     */
    public void setPreviousPanelTitle(String previousPanelTitle)
    {
        this.previousPanelTitle = previousPanelTitle;
    }
}
