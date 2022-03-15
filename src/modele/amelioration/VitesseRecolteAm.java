package modele.amelioration;

import modele.Modele;
import modele.TypeBatiment.*;

import static modele.TypeBatiment.HDV;

public class VitesseRecolteAm extends Amelioration{

    private double vitesseRecolte;

    public VitesseRecolteAm(Modele m, int niveau, Amelioration amNec) {
        super(m);
        tb = HDV;
        this.amNec = amNec;

        this.niveau = niveau;

        switch (niveau) {
            case 1 -> {
                coutNourriture = 200;
                vitesseRecolte = 1.5;
                dureeAmelioration = 50;
            }
            case 2 -> {
                coutNourriture = 400;
                vitesseRecolte = 2;
                dureeAmelioration = 100;
            }
        }
    }

    @Override
    public boolean testCondition() {
        return (M.nourriture >= coutNourriture);
    }

    @Override
    public void activer()
    {
            M.nourriture -= coutNourriture;
            M.vitesseRecolte = vitesseRecolte;
            activer = true;
    }
}
