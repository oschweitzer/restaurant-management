package model;

import java.util.ArrayList;

public class Nourriture extends Item 
{
    public Nourriture(String nom)
    {
        this.setNomItem(nom);
        this.clients = new ArrayList<ClientTable>();
    }
}
