package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import utilities.ObservableModification;

public class Commande extends Observable
{
    private int numeroCommande;
    private Date heure;
    private ArrayList<Item> items;
    
    public Commande(int numeroCommande, Date heure)
    {
        this.numeroCommande = numeroCommande;
        this.heure = heure;
        this.items = new ArrayList<>();
    }

    public void ajouterItem(Item item)
    {
        this.items.add(item);
        
        ObservableModification modif = 
                new ObservableModification(ObservableModification.Modification.Ajouter, item);
        
        setChanged();
        notifyObservers(modif);
    }

    public void retirerItem(Item item)
    {
        this.items.remove(item);
        
        ObservableModification modif = 
                new ObservableModification(ObservableModification.Modification.Retirer, item);
        
        setChanged();
        notifyObservers(modif);
    }
    
    public void retirerItem(int item)
    {
        ObservableModification modif = 
                new ObservableModification(ObservableModification.Modification.Retirer, item);
        
        this.items.remove(item);
        
        setChanged();
        notifyObservers(modif);
    }

    /**
     * @return the numeroCommande
     */
    public int getNumeroCommande()
    {
        return numeroCommande;
    }

    /**
     * @param numeroCommande the numeroCommande to set
     */
    public void setNumeroCommande(int numeroCommande)
    {
        this.numeroCommande = numeroCommande;
    }

    /**
     * @return the heure
     */
    public Date getHeure()
    {
        return heure;
    }

    /**
     * @param heure the heure to set
     */
    public void setHeure(Date heure)
    {
        this.heure = heure;
    }

    /**
     * @return the items
     */
    public ArrayList<Item> getItems()
    {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(ArrayList<Item> items)
    {
        this.items = items;
    }

}
