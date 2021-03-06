/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import model.Section;
import model.Table;
import utilities.AlphaNumComparator;

/**
 * 
 * @author Olivier
 */
public class TableOpening extends JPanel
{

    private Controller controleur;
    private MainFrame mainFrame;
    

    /**
     * Creates new form OuvertureTable
     *
     * @param mainFrame
     */
    public TableOpening(MainFrame mainFrame)
    {
       this.mainFrame = mainFrame;

        mainFrame.getGeneralPanel().getjLabel1().setText("Ouverture d'une table");
        initComponents();
        
        
        freeTableComboBox.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               jSpinner1.setEnabled(true);
           }
       });
        getjSpinner1().setModel(new SpinnerNumberModel(0, 0, 100, 1));
        
        btnOuvrirTable.setToolTipText("Ajoute la table sélectionnée dans la liste de vos tables");
        btnSectionMezza.setToolTipText("Affiche la liste des tables disponibles pour la section Mezzanine");
        btnSectionSalle.setToolTipText("Affiche la liste des tables disponibles pour la section Salle");
        btnSectionTerrasse.setToolTipText("Affiche la liste des tables disponibles pour la section Terrasse");

    }

    public void initComboBox(Section section)
    {
        if (section != null)
        {
            HashSet<Table> tables = mainFrame.getServeurManager().getFreeTableFromSection(section);
            String[] data = new String[tables.size()];
            
            int i = 0;
            for(Table t : tables)
            {
                data[i] = "Table" + Integer.toString(t.getNumeroTable());
                i++;
            }
            
            SortedComboBoxModel<String> model = new SortedComboBoxModel<>(data, new AlphaNumComparator());
            freeTableComboBox.setModel(model);

        }
        else
        {
            JOptionPane.showMessageDialog(mainFrame,
                        "La section sélectionnée n'existe pas",
                        "Erreur de sélection de section",
                        JOptionPane.ERROR_MESSAGE);
        }
       
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMenu5 = new javax.swing.JMenu();
        jFrame1 = new javax.swing.JFrame();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnOuvrirTable = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        freeTableComboBox = new javax.swing.JComboBox<>();
        lblListTable = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel5 = new javax.swing.JPanel();
        btnSectionTerrasse = new javax.swing.JButton();
        btnSectionMezza = new javax.swing.JButton();
        btnSectionSalle = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu5.setText("HIO");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenu6.setText("jMenu6");

        jMenu7.setText("jMenu7");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton13.setText("jButton6");

        jButton17.setText("jButton6");

        jPanel1.setForeground(new java.awt.Color(240, 240, 240));

        btnOuvrirTable.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnOuvrirTable.setText("Ouvrir table");
        btnOuvrirTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOuvrirTable.setHideActionText(true);
        btnOuvrirTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOuvrirTable.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnOuvrirTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnOuvrirTable, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnOuvrirTable, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Veuillez sélectionner une section :");

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        freeTableComboBox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        freeTableComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        lblListTable.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblListTable.setText("Liste des tables de la section              ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(lblListTable, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(freeTableComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(268, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(freeTableComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblListTable))
                .addContainerGap())
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Nombre de clients pour cette table :");

        jSpinner1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jSpinner1.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSectionTerrasse.setBackground(new java.awt.Color(255, 204, 204));
        btnSectionTerrasse.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnSectionTerrasse.setText("Terrasse");
        btnSectionTerrasse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSectionTerrasse.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSectionTerrasseActionPerformed(evt);
            }
        });

        btnSectionMezza.setBackground(new java.awt.Color(204, 204, 255));
        btnSectionMezza.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnSectionMezza.setText("Mezzanine");
        btnSectionMezza.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSectionMezza.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSectionMezzaActionPerformed(evt);
            }
        });

        btnSectionSalle.setBackground(new java.awt.Color(204, 255, 204));
        btnSectionSalle.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnSectionSalle.setText("Salle");
        btnSectionSalle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSectionSalle.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSectionSalleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSectionSalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(435, 435, 435)
                .addComponent(btnSectionMezza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSectionTerrasse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSectionSalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSectionMezza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSectionTerrasse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(112, 112, 112)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1144, 1144, 1144)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(264, 264, 264)
                .addComponent(jLabel1)
                .addContainerGap(336, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOuvrirTableActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnOuvrirTableActionPerformed
    {//GEN-HEADEREND:event_btnOuvrirTableActionPerformed

        if (freeTableComboBox.getSelectedItem() != null)
        {
            if ("0".equals(this.getjSpinner1().getValue().toString()))
            {
                JOptionPane.showMessageDialog(mainFrame,
                        "Veuillez entrer un nombre de clients supérieur à zéro et inférieur à 100",
                        "Erreur de saisie",
                        JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                try
                {
                    Object o = freeTableComboBox.getSelectedItem();
                    Object objClient = this.getjSpinner1().getValue();
                    int nbClient = Integer.parseInt(objClient.toString());
                    this.controleur.ouvrirTable(o.toString(), nbClient);
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    e.getMessage();
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(mainFrame,
                    "Vous n'avez pas sélectionné de table à ouvrir, veuillez cocher une table et renseigner le nombre de clients de cette table",
                    "Erreur de saisie",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnOuvrirTableActionPerformed

    private void btnSectionMezzaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSectionMezzaActionPerformed
    {//GEN-HEADEREND:event_btnSectionMezzaActionPerformed
        this.initComboBox(mainFrame.getServeurManager().getSections().get(1));
        this.lblListTable.setText("Liste des tables de la section Mezzanine : ");
    }//GEN-LAST:event_btnSectionMezzaActionPerformed

    private void btnSectionTerrasseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSectionTerrasseActionPerformed
    {//GEN-HEADEREND:event_btnSectionTerrasseActionPerformed
        this.initComboBox(mainFrame.getServeurManager().getSections().get(2));
        this.lblListTable.setText("Liste des tables de la section Terrasse : ");

    }//GEN-LAST:event_btnSectionTerrasseActionPerformed

    private void btnSectionSalleActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSectionSalleActionPerformed
    {//GEN-HEADEREND:event_btnSectionSalleActionPerformed
        this.initComboBox(mainFrame.getServeurManager().getSections().get(0));
        this.lblListTable.setText("Liste des tables de la section Salle : ");

    }//GEN-LAST:event_btnSectionSalleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOuvrirTable;
    private javax.swing.JButton btnSectionMezza;
    private javax.swing.JButton btnSectionSalle;
    private javax.swing.JButton btnSectionTerrasse;
    private javax.swing.JComboBox<String> freeTableComboBox;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton17;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblListTable;
    // End of variables declaration//GEN-END:variables


    
    public void resetSpinner()
    {
        this.getjSpinner1().setValue(0);
        this.getjSpinner1().setEnabled(false);
    }

    /**
     * @return the jSpinner1
     */
    public javax.swing.JSpinner getjSpinner1()
    {
        return jSpinner1;
    }

    /**
     * @param jSpinner1 the jSpinner1 to set
     */
    public void setjSpinner1(javax.swing.JSpinner jSpinner1)
    {
        this.jSpinner1 = jSpinner1;
    }

    public void setListener(Controller newControleur)
    {
        this.controleur = newControleur;

    }

    /**
     * @return the freeTableComboBox
     */
    public javax.swing.JComboBox<String> getFreeTableComboBox()
    {
        return freeTableComboBox;
    }

    /**
     * @param freeTableComboBox the freeTableComboBox to set
     */
    public void setFreeTableComboBox(javax.swing.JComboBox<String> freeTableComboBox)
    {
        this.freeTableComboBox = freeTableComboBox;
    }
}
