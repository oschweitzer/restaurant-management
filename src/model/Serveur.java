package model;

import java.util.ArrayList;

public class Serveur extends Personne
{

	private String code;
        private ArrayList<Table> tables;
        private Section section;
        
        public Serveur()
        {
            
        }
        
        public Serveur(String nom, String prenom, String adresse,String telephone, String courriel, String code, Section section, ArrayList<Table> tables)
        {
            this.setNom(nom);
            this.setPrenom(prenom);
            this.setAdresse(adresse);
            this.setCourriel(courriel);
            this.setTelephone(telephone);
            this.setCode(code);
            this.section = section;
            this.tables = tables;
        }

    /**
     * @return the code
     */
    public String getCode()
    {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code)
    {
        this.code = code;
    }

    /**
     * @return the sections
     */

    /**
     * @return the numSection
     */

    /**
     * @return the tables
     */
    public ArrayList<Table> getTables()
    {
        return tables;
    }

    /**
     * @param tables the tables to set
     */
    public void setTables(ArrayList<Table> tables)
    {
        this.tables = tables;
    }

    /**
     * @return the section
     */
    public Section getSection()
    {
        return section;
    }

    /**
     * @param section the section to set
     */
    public void setSection(Section section)
    {
        this.section = section;
    }

}
