package modele.amelioration;

import modele.Modele;

import static modele.TypeBatiment.HDV;

public class NiveauAm extends Amelioration{

    private final int niveau;

    public NiveauAm(Modele m, int niveau, Amelioration amNec) {
        super(m);
        tb = HDV;
        this.amNec = amNec;

        this.niveau = niveau;
        switch (niveau) {
            case 1 -> {
                coutBois = 300;
                coutPierre = 300;
                coutNourriture = 300;
                coutPopulation = 5;
                dureeAmelioration = 100;
            }
            case 2 -> {
                coutBois = 500;
                coutPierre = 500;
                coutNourriture = 500;
                coutPopulation = 8;
                dureeAmelioration = 200;
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
        M.niveau = niveau;
        activer = true;
    }
}
