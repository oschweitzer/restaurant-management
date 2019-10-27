package model;

import java.util.ArrayList;
import java.util.Observable;
import utilities.ObservableModification;

public class Table extends Observable
{

    private int numeroTable;
    private int nbChaises;
    private boolean disponible;
    private ArrayList<ClientTable> clients;
    private ArrayList<Commande> commandes;

    public Table(int numeroTable, int nbChaises, boolean estDispo)
    {
        this.numeroTable = numeroTable;
        this.nbChaises = nbChaises;
        this.disponible = estDispo;
        this.clients = new ArrayList<>();
        this.commandes = new ArrayList<>();
    }

    public void transfererTable(String numServeur)
    {

    }

    public void fermerTable()
    {

    }
    
    public void ajouterClients(int nbClients)
    {
        for(int i =0;i<nbClients;i++)
        {
            ClientTable client = new ClientTable(i+1);
            this.clients.add(client);
            
            ObservableModification modif = 
                    new ObservableModification(ObservableModification.Modification.Ajouter, client);
            
            setChanged();
            notifyObservers(modif);
        }
    }
    
    public void ajouterClient()
    {
        ClientTable client = new ClientTable(clients.size()+1);
        this.clients.add(client);
        
        ObservableModification modif = 
                    new ObservableModification(ObservableModification.Modification.Ajouter, client);
            
        setChanged();
        notifyObservers(modif);
    }
    
    public void ajouterCommande(Commande commande)
    {
        this.commandes.add(commande);
    }


    /**
     * @return the numeroTable
     */
    public int getNumeroTable()
    {
        return numeroTable;
    }

    /**
     * @param numeroTable the numeroTable to set
     */
    public void setNumeroTable(int numeroTable)
    {
        this.numeroTable = numeroTable;
    }

    /**
     * @return the nbChaises
     */
    public int getNbChaises()
    {
        return nbChaises;
    }

    /**
     * @param nbChaises the nbChaises to set
     */
    public void setNbChaises(int nbChaises)
    {
        this.nbChaises = nbChaises;
    }

    /**
     * @return the estDisponible
     */
    public boolean isDisponible()
    {
        return disponible;
    }

    /**
     * @param disponible the estDisponible to set
     */
    public void setDisponible(boolean disponible)
    {
        this.disponible = disponible;
    }

    /**
     * @return the clients
     */
    public ArrayList<ClientTable> getClients()
    {
        return clients;
    }

    /**
     * @param clients the clients to set
     */
    public void setClients(ArrayList<ClientTable> clients)
    {
        this.clients = clients;
    }

    /**
     * @return the commandes
     */
    public ArrayList<Commande> getCommandes()
    {
        return commandes;
    }

    /**
     * @param commandes the commandes to set
     */
    public void setCommandes(ArrayList<Commande> commandes)
    {
        this.commandes = commandes;
    }
    
    public ArrayList<Item> getItemsByClient(ClientTable client)
    {
        ArrayList<Item> retVal = new ArrayList<Item>();

        for(Commande cmd : commandes)
        {
            for(Item itm : cmd.getItems())
            {
                if (itm.getClients().contains(client))
                    retVal.add(itm);
            }
        }
        return retVal;
    }

}
