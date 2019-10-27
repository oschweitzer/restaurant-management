package model;

import java.util.List;
import java.util.Observable;
import utilities.ObservableModification;

public abstract class Item extends Observable
{

    private int reference;

    private String nomItem;

    private double quantite;

    private int nbItemCommande;

    private double prix;

    private String description;

    private String commentaire;

    private int quantiteRestante;

    private Categorie categorie;
    
    protected List<ClientTable> clients;

    public boolean estDisponible()
    {
        return false;
    }

    public void ajouterClient(ClientTable a_Client)
    {
        //Ajoute le client a la liste
        clients.add(a_Client);

        ObservableModification modif = 
                new ObservableModification(ObservableModification.Modification.Ajouter, a_Client);

        //Met a jour la vue
        setChanged();
        notifyObservers(modif);
    }

    public void retirerClient(ClientTable a_Client)
    {
        //Retire le client a la liste
        clients.remove(a_Client);

        ObservableModification modif = 
                new ObservableModification(ObservableModification.Modification.Retirer, a_Client);

        //Met a jour la vue
        setChanged();
        notifyObservers(modif);
    }

    /**
     * @return the reference
     */
    public int getReference()
    {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(int reference)
    {
        this.reference = reference;
    }

    /**
     * @return the nomItem
     */
    public String getNomItem()
    {
        return nomItem;
    }

    /**
     * @param nomItem the nomItem to set
     */
    public void setNomItem(String nomItem)
    {
        this.nomItem = nomItem;
    }

    /**
     * @return the quantite
     */
    public double getQuantite()
    {
        return quantite;
    }

    /**
     * @param quantite the quantite to set
     */
    public void setQuantite(double quantite)
    {
        this.quantite = quantite;
    }

    /**
     * @return the nbItemCommande
     */
    public int getNbItemCommande()
    {
        return nbItemCommande;
    }

    /**
     * @param nbItemCommande the nbItemCommande to set
     */
    public void setNbItemCommande(int nbItemCommande)
    {
        this.nbItemCommande = nbItemCommande;
    }

    /**
     * @return the prix
     */
    public double getPrix()
    {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(double prix)
    {
        this.prix = prix;
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * @return the commentaire
     */
    public String getCommentaire()
    {
        return commentaire;
    }

    /**
     * @param commentaire the commentaire to set
     */
    public void setCommentaire(String commentaire)
    {
        this.commentaire = commentaire;
    }

    /**
     * @return the quantiteRestante
     */
    public int getQuantiteRestante()
    {
        return quantiteRestante;
    }

    /**
     * @param quantiteRestante the quantiteRestante to set
     */
    public void setQuantiteRestante(int quantiteRestante)
    {
        this.quantiteRestante = quantiteRestante;
    }

    /**
     * @return the categorie
     */
    public Categorie getCategorie()
    {
        return categorie;
    }

    /**
     * @param categorie the categorie to set
     */
    public void setCategorie(Categorie categorie)
    {
        this.categorie = categorie;
    }

    /**
     * @param 
     */
    public List<ClientTable> getClients()
    {
        return clients;
    }
}
