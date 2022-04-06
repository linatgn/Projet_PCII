package modele.amelioration;

import modele.Modele;

import static modele.TypeBatiment.HDV;

//Classe qui definie les ameliorations de la vitesse de recolte
//Extends Amelioration car la classe est une classe fille de Amelioration
public class DefenseAm extends Amelioration{

    /**
     * Var : la vitesse de recolte
     */
    private int defense;

    //Constructeur de la classe
    public DefenseAm(Modele m, int niveau, Amelioration amNec) {
        super(m);
        typeBatiment = HDV;
        this.amNec = amNec;

        //En fonction du niveau les stats de cout de ressource augmente (niveau 1 ou 2)
        switch (niveau) {
            case 1:
                coutNourriture = 200;
                coutPierre = 100;
                defense = 1;
                dureeAmelioration = 20;

                niveauJoueur = 1;
                break;
            case 2:
                coutNourriture = 400;
                coutPierre = 200;
                defense = 2;
                dureeAmelioration = 40;

                niveauJoueur = 2;
                break;
        }
    }

    @Override
    public boolean testCondition() {
        //Verifie que la nourriture disponible est superieur au cout necessaire
        return (M.nourriture >= coutNourriture);
    }

    @Override
    public void activer() {
        M.defenseVillageois = defense;
        activer = true;
    }

    @Override
    public String getNom() {
        return "Defense " + defense;
    }
}