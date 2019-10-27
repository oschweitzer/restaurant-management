package model;

import java.util.ArrayList;


public class Section {

	private int numeroSection;
        private String nomSection;
	private boolean estOuvert;
        private ArrayList<Table> tables;
        
        public Section(int numeroSection, String nomSection, boolean estOuvert, ArrayList<Table> tables)
        {
            this.numeroSection = numeroSection;
            this.nomSection = nomSection;
            this.estOuvert = estOuvert;
            this.tables = tables;
        }

    /**
     * @return the numeroSection
     */
    public int getNumeroSection()
    {
        return numeroSection;
    }

    /**
     * @param numeroSection the numeroSection to set
     */
    public void setNumeroSection(int numeroSection)
    {
        this.numeroSection = numeroSection;
    }

    /**
     * @return the estOuvert
     */
    public boolean isEstOuvert()
    {
        return estOuvert;
    }

    /**
     * @param estOuvert the estOuvert to set
     */
    public void setEstOuvert(boolean estOuvert)
    {
        this.estOuvert = estOuvert;
    }

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
     * @return the nomSection
     */
    public String getNomSection()
    {
        return nomSection;
    }

    /**
     * @param nomSection the nomSection to set
     */
    public void setNomSection(String nomSection)
    {
        this.nomSection = nomSection;
    }

}
