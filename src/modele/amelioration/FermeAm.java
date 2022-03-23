package modele.amelioration;

import modele.Modele;

import static modele.TypeBatiment.FERME;

public class FermeAm extends Amelioration{

    private int quantiteRessource;

    public FermeAm(Modele m, int niveau, Amelioration amNec) {
        super(m);
        typeBatiment = FERME;
        this.amNec = amNec;

        switch (niveau) {
            case 1 -> {
                coutBois = 300;
                coutPierre = 300;
                coutNourriture = 300;
                coutPopulation = 5;
                dureeAmelioration = 30;

                niveauJoueur = 1;
                quantiteRessource = 500;
            }
            case 2 -> {
                coutBois = 500;
                coutPierre = 500;
                coutNourriture = 500;
                coutPopulation = 8;
                dureeAmelioration = 50;

                niveauJoueur = 2;
                quantiteRessource = 8000;
            }
        }
    }

    @Override
    public boolean testCondition() {
        return (M.bois >= coutBois &&
                M.pierre >= coutPierre &&
                M.nourriture >= coutNourriture &&
                M.population >= coutPopulation);
    }

    @Override
    public void activer() {

        M.bois -= coutBois;
        M.pierre -= coutPierre;
        M.nourriture -= coutNourriture;
        M.quantiteRessourceFerme = quantiteRessource;
        activer = true;
    }

    @Override
    public String getNom() {
        return "capacité Ferme " + quantiteRessource;
    }
}
