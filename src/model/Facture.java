package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Facture {

	private int numeroFacture;

	private Date date;

	private double montantHT;

	private final double TVQ =  9.975/100;

	private final double TPS = 5/100;
        
        private int tableNo;
        private int clientNo;
        private ArrayList<Item> items;

        public Facture(int tNo, int cNo)
        {
            tableNo = tNo;
            clientNo = cNo;
        }
	public double calculMontantHT() {
		return 0;
	}
        
        public double calculTPS() {
            return calculMontantHT() * TPS;
        }
        
        public double calculTVQ() {
            return calculMontantHT() * TVQ;
        }

	public double calculMontantTotal() {
            return  calculMontantHT() + calculTPS() + calculTVQ();
	}
        
	public void diviserItem(List clients) {

	}

	public void deplacerItem(ClientTable client) {

	}

	public void fusionnerFacture(Facture facture) {

	}
        
        public void setItem(ArrayList<Item> i)
        {
            items = i;
        }
        
        public ArrayList<Item> getItems()
        {
            return items;
        }
}