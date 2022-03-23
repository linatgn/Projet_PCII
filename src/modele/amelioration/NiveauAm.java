package modele.amelioration;

import modele.Modele;

import static modele.TypeBatiment.HDV;

public class NiveauAm extends Amelioration{

    private int nouveauNiveau;

    public NiveauAm(Modele m, int niveau, Amelioration amNec) {
        super(m);
        typeBatiment = HDV;
        this.amNec = amNec;

        switch (niveau) {
            case 0 -> {
                coutBois = 300;
                coutPierre = 300;
                coutNourriture = 300;
                coutPopulation = 5;
                dureeAmelioration = 30;

                nouveauNiveau = 1;
            }
            case 1 -> {
                coutBois = 500;
                coutPierre = 500;
                coutNourriture = 500;
                coutPopulation = 8;
                dureeAmelioration = 50;

                nouveauNiveau = 2;
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
        M.niveau = nouveauNiveau;
        activer = true;
    }

    @Override
    public String getNom() {
        return "Niveau " + nouveauNiveau;
    }
}
