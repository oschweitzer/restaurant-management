package model;

import java.util.ArrayList;

public class Boisson extends Item
{
    public Boisson()
    {
        
    }
    
    public Boisson(String nom)
    {
        this.setNomItem(nom);
        this.clients = new ArrayList<ClientTable>();
    }
    
    public Boisson(int reference, String nom, String description, double prix, Categorie cat)
    {
        this.setReference(reference);
        this.setNomItem(nom);
        this.setDescription(description);
        this.setPrix(prix);
        this.setCategorie(cat);
    }
}
