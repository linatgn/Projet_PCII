package modele.amelioration;

import modele.Modele;
import modele.TypeBatiment.*;

import static modele.TypeBatiment.HDV;

public class VitesseRecolteAm extends Amelioration{

    private double vitesseRecolte;

    public VitesseRecolteAm(Modele m, int niveau, Amelioration amNec) {
        super(m);
        typeBatiment = HDV;
        this.amNec = amNec;

        switch (niveau) {
            case 1:
                coutNourriture = 200;
                vitesseRecolte = 1.5;
                dureeAmelioration = 20;

                niveauJoueur = 1;
                break;
            case 2:
                coutNourriture = 400;
                vitesseRecolte = 2;
                dureeAmelioration = 40;

                niveauJoueur = 2;
                break;
        }

    }

    @Override
    public boolean testCondition() {
        return (M.nourriture >= coutNourriture);
    }

    @Override
    public void activer()
    {
        M.vitesseRecolte = vitesseRecolte;
        activer = true;
    }

    @Override
    public String getNom() {
        return "Vitesse de Recolte x" + vitesseRecolte;
    }
}