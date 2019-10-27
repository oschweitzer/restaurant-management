/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

/**
 *
 * @author Olivier
 */
public class HomePanel extends ApplicationPanel
{

    /**
     * Creates new form HomePanel
     *
     * @param mainFrame
     */
    public HomePanel(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
        mainFrame.getGeneralPanel().setVisible(false);
        this.previousPanel = null;
        this.previousPanelTitle = null;

        initComponents();
        jButton1.setToolTipText("Accès à la liste de vos table");

        mainFrame.addWindowListener(new WindowAdapter()
        {
            public void windowOpened(WindowEvent e)
            {
                jPasswordField1.requestFocus();
                jPasswordField1.setText("");
            }

        });
    }

    public void setListener(Controller newControleur)
    {
        this.controleur = newControleur;

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

        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jPasswordField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField1.setText("jPasswordField1");
        jPasswordField1.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseClicked(MouseEvent e)
            {
                getjPasswordField1().setText("");
            }
        });

        jPasswordField1.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    controleur.connexion(new String(getjPasswordField1().getPassword()));
                }
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Entrez votre identifiant :");

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jButton1.setText("Connexion");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(501, 501, 501)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jLabel1, jPasswordField1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(581, 581, 581))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed

        controleur.connexion(new String(getjPasswordField1().getPassword()));
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the jPasswordField1
     */
    public javax.swing.JPasswordField getjPasswordField1()
    {
        return jPasswordField1;
    }

    /**
     * @param jPasswordField1 the jPasswordField1 to set
     */
    public void setjPasswordField1(javax.swing.JPasswordField jPasswordField1)
    {
        this.jPasswordField1 = jPasswordField1;
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