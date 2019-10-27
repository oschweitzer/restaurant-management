/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.Arrays;
import java.util.List;
import model.ArticlePromotionel;
import model.Boisson;
import model.Item;
import model.Nourriture;

/**
 *
 * @author Jean-François
 */
public class ItemUtils 
{
    public static List<String> Boisson = Arrays.asList( "Sarcophage", 
                                                        "Planque",
                                                        "Bunker",
                                                        "Caverne",
                                                        "Arbuste",
                                                        "Tanière",
                                                        "L'Assoiffé",
                                                        "L'infusée",
                                                        "Ale de Hardy",
                                                        "La célébrante",
                                                        "Saison impériale"  );
    
    public static List<String> Nourriture = Arrays.asList(  "Nachos",
                                                            "Hot-dog européen et frite",
                                                            "Grilled cheese deux fromages",
                                                            "Grilled cheese ultime",
                                                            "Smoked meat",
                                                            "Burger de bison",
                                                            "Poutine Régulière",
                                                            "Poutine Bacon",
                                                            "Poutine Saucisse",
                                                            "Poutine Smoked Meat",
                                                            "Poutine Bison",
                                                            "Combo ailes-bâtonnets-frites",
                                                            "Pizza smoked meat",
                                                            "Salade maison",
                                                            "Bacon à la bière",
                                                            "Beignets aux pommes à la bière",
                                                            "Bâtonnets de fromage mozzarella maison",
                                                            "Ailes de poulet",
                                                            "Beignets aux pommes à la bière",
                                                            "Sundae caramel aux noix caramélisées" );
    
    public static List<String> ArticlesPromotionnels = Arrays.asList(  "Casquette",
                                                                       "Verre",
                                                                       "Frisbee" );
    
    public static Item String2Item(String a_ItemName)
    {
        if(Boisson.contains(a_ItemName))
        {
            return new Boisson(a_ItemName);
        }
        else if(Nourriture.contains(a_ItemName))
        {
            return new Nourriture(a_ItemName);
        }
        else if(ArticlesPromotionnels.contains(a_ItemName))
        {
            return new ArticlePromotionel(a_ItemName);
        }
        
        return null;
    }
}