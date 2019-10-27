/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Observable;

/**
 *
 * @author Olivier
 */
public class ServeurManager extends Observable
{

    private Serveur connected;
    private Serveur previousConnected;
    private HashMap<String, Serveur> serveurs;
    private ArrayList<Section> sections;

    public ServeurManager()
    {
        this.connected = null;
        this.previousConnected = null;
        serveurs = new HashMap<>();
        loadData();
    }

    /**
     * Création de la base de données (tables, sections, serveurs)
     */
    private void loadData()
    {
        // Tables de la Section1
        Table t1 = new Table(1, 5, false);
        Table t2 = new Table(2, 3, false);
        Table t3 = new Table(3, 4, true);
        Table t4 = new Table(4, 4, false);
        Table t5 = new Table(5, 7, true);
        Table t6 = new Table(6, 10, false);
        
        Commande c1 = new Commande(123432, new Date());
        c1.ajouterItem(new Boisson(12, "Bière blonde", "", 5.50, Categorie.Biere));
        t2.ajouterCommande(c1);

        // Liste des tables de la Section1
        ArrayList<Table> tables1 = new ArrayList<>();
        tables1.add(t1);
        tables1.add(t2);
        tables1.add(t3);
        tables1.add(t4);
        tables1.add(t5);
        tables1.add(t6);

        // Liste des tables du Serveur 1
        ArrayList<Table> tablesServeur1 = new ArrayList<>();
        tablesServeur1.add(t1);
        tablesServeur1.add(t2);
        tablesServeur1.add(t4);
        tablesServeur1.add(t6);

        // Tables de la Section2
        Table t7 = new Table(7, 2, true);
        Table t8 = new Table(8, 2, false);
        Table t9 = new Table(9, 4, true);
        Table t10 = new Table(10, 5, false);
        Table t11 = new Table(11, 3, true);
        Table t12 = new Table(12, 3, false);

        // Liste des tables de la Section2
        ArrayList<Table> tables2 = new ArrayList<>();
        tables2.add(t7);
        tables2.add(t8);
        tables2.add(t9);
        tables2.add(t10);
        tables2.add(t11);
        tables2.add(t12);

        // Liste des tables du Serveur2
        ArrayList<Table> tablesServeur2 = new ArrayList<>();
        tablesServeur2.add(t8);
        tablesServeur2.add(t10);
        tablesServeur2.add(t12);

        // Tables de la Section3
        Table t13 = new Table(13, 4, false);
        Table t14 = new Table(14, 4, false);
        Table t15 = new Table(15, 4, false);
        Table t16 = new Table(16, 4, true);
        Table t17 = new Table(17, 4, true);
        Table t18 = new Table(18, 4, true);

        // Liste des tables de la Section3
        ArrayList<Table> tables3 = new ArrayList<>();
        tables3.add(t13);
        tables3.add(t14);
        tables3.add(t15);
        tables3.add(t16);
        tables3.add(t17);
        tables3.add(t18);

        // Liste des tables du Serveur3
        ArrayList<Table> tablesServeur3 = new ArrayList<>();
               
        tablesServeur3.add(t13);
        tablesServeur3.add(t14);
        tablesServeur3.add(t15);
        

        Section sect1 = new Section(1, "Salle", true, tables1);
        Section sect2 = new Section(2, "Mezzanine", true, tables2);
        Section sect3 = new Section(3, "Terrasse", false, tables3);
        sections = new ArrayList<>();

        sections.add(sect1);
        sections.add(sect2);
        sections.add(sect3);

        Serveur s1 = new Serveur("Smith", "John", "", "", "", "123456", sect1, tablesServeur1);
        Serveur s2 = new Serveur("Doe", "Jane", "", "", "", "azerty", sect2, tablesServeur2);
        Serveur s3 = new Serveur("Zedong", "Mao", "", "", "", "admin", sect3, tablesServeur3);

        serveurs.put(s1.getCode(), s1);
        serveurs.put(s2.getCode(), s2);
        serveurs.put(s3.getCode(), s3);
    }
    
    public void ajoutTableServeur(Table t)
    {
        
    }

    /**
     * @return the serveurs
     */
    public HashMap<String, Serveur> getServeurs()
    {
        return serveurs;
    }

    /**
     * @param serveurs the serveurs to set
     */
    public void setServeurs(HashMap<String, Serveur> serveurs)
    {
        this.serveurs = serveurs;
    }

    /**
     * 
     * @param serveur 
     */
    public void setServeurConnected(Serveur serveur)
    {
        this.setConnected(serveur);
        setChanged();
        notifyObservers(getConnected());

    }
    
    public Table getTable(int numTable)
    {
        Table table = null;
        
        for(Section s : sections)
        {
            for(Table ta : s.getTables())
            {
                if(ta.getNumeroTable() == numTable)
                {
                    table = ta;
                }
            }
        }
        
        return table;
    }
    
    public Commande getCommandeFromTable(Table t, int numCommande)
    {
        Commande c = null;
        
        for(Commande com : t.getCommandes())
        {
            if(com.getNumeroCommande() == numCommande)
            {
                c = com;
            }
        }
        
        return c;
    }
   

    /**
     * @return the connected
     */
    public Serveur getConnected()
    {
        return connected;
    }

    /**
     * @param connected the connected to set
     */
    public void setConnected(Serveur connected)
    {
        this.connected = connected;
    }
    
    public Table getTableFromNumber(int num)
    {
        Table t = null;
        for(Section section : this.getSections())
        {
            for(Table table : section.getTables())
            {
                if(table.getNumeroTable() == num)
                {
                    t = table;
                }
            }
        }
        
        return t;
    }

    /**
     * 
     * @param section
     * @return 
     */
    public HashSet getFreeTableFromSection(Section section)
    {
        HashSet freeTable = new HashSet();

        for(Table table : section.getTables())
        {
            if(table.isDisponible())
            {
                freeTable.add(table);
            }
        }

        return freeTable;
    }

    /**
     * @return the sections
     */
    public ArrayList<Section> getSections()
    {
        return sections;
    }

    /**
     * @param sections the sections to set
     */
    public void setSections(ArrayList<Section> sections)
    {
        this.sections = sections;
    }

    /**
     * @return the previousConnected
     */
    public Serveur getPreviousConnected()
    {
        return previousConnected;
    }

    /**
     * @param previousConnected the previousConnected to set
     */
    public void setPreviousConnected(Serveur previousConnected)
    {
        this.previousConnected = previousConnected;
    }
}
