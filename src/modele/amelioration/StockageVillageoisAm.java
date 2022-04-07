package modele.amelioration;

import modele.Modele;

import static modele.TypeBatiment.HDV;

//Classe qui definie les ameliorations de stockage des villageois
//Extends Amelioration car la classe est une classe fille de Amelioration
public class StockageVillageoisAm extends Amelioration{

    /**
     * Var :
     */
    private int stockage;

    //Constructeur de la classe
    public StockageVillageoisAm(Modele m, int niveau, Amelioration amNec) {
        super(m);
        typeBatiment = HDV;
        this.amNec = amNec;

        //En fonction du niveau les ressources necessaires a l'augmentation augmentent (niveau 1 ou 2)
        switch (niveau) {
            case 1:
                coutBois = 100;
                coutPierre = 100;
                dureeAmelioration = 30;

                niveauJoueur = 1;
                stockage = 15;
                break;
            case 2:
                coutBois = 200;
                coutPierre = 200;
                dureeAmelioration = 50;

                niveauJoueur = 2;
                stockage = 20;
                break;
        }
    }


    @Override
    public boolean testCondition() {
        //Verifie que les ressources du joueur sont superieurs ou egalent au ressources necessaires
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