/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Olivier
 */
class JTableModel extends AbstractTableModel
{

    private Object[][] data;
    private String[] title;

    //Constructeur
    public JTableModel(Object[][] data, String[] title)
    {
        this.data = data;
        this.title = title;
    }

    //Retourne le titre de la colonne à l'indice spécifié
    public String getColumnName(int col)
    {
        return this.title[col];
    }

    //Retourne le nombre de colonnes
    public int getColumnCount()
    {
        return this.title.length;
    }

    //Retourne le nombre de lignes
    public int getRowCount()
    {
        return this.data.length;
    }

    //Retourne la valeur à l'emplacement spécifié
    public Object getValueAt(int row, int col)
    {
        return this.data[row][col];
    }

    //Définit la valeur à l'emplacement spécifié
    public void setValueAt(Object value, int row, int col)
    {
 
    }

    //Retourne la classe de la donnée de la colonne
    public Class getColumnClass(int col)
    {
        //On retourne le type de la cellule à la colonne demandée
        //On se moque de la ligne puisque les données sont les mêmes
        //On choisit donc la première ligne
            return this.data[0][col].getClass();
    }


    public boolean isCellEditable(int row, int col)
    {
        if(this.getColumnName(col).equals("Numéro tables ouvertes") )
        {
            return false;
        }
        return true;
    }

}
