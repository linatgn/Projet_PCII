package modele.amelioration;

import modele.Modele;

import static modele.TypeBatiment.HDV;

public class StockageVillageoisAm extends Amelioration{

    private int stockage;

    public StockageVillageoisAm(Modele m, int niveau, Amelioration amNec) {
        super(m);
        typeBatiment = HDV;
        this.amNec = amNec;

        switch (niveau) {
            case 1:
                coutBois = 300;
                coutPierre = 300;
                coutNourriture = 300;
                dureeAmelioration = 30;

                niveauJoueur = 1;
                stockage = 15;
                break;
            case 2:
                coutBois = 500;
                coutPierre = 500;
                coutNourriture = 500;
                dureeAmelioration = 50;

                niveauJoueur = 2;
                stockage = 20;
                break;
        }
    }


    @Override
    public boolean testCondition() {
        return (M.bois >= coutBois &&
                M.pierre >= coutPierre &&
                M.nourriture >= coutNourriture);
    }

    @Override
    public void activer() {

        M.stockageVillagois = stockage;
        activer = true;
    }

    @Override
    public String getNom() {
        return "capacité Villageois " + stockage;
    }
}