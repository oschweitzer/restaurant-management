package model;

import java.util.ArrayList;

public class ArticlePromotionel extends Item 
{
    public ArticlePromotionel(String nom)
    {
        this.setNomItem(nom);
        this.clients = new ArrayList<ClientTable>();
    }
}
