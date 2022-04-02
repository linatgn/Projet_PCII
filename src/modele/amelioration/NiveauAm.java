package modele.amelioration;

import modele.Modele;
import static modele.TypeBatiment.HDV;

//Classe qui a definir les niveaux de l'ameliorations de la ferme
//Extends Amelioration car la classe est une classe fille de Amelioration
public class NiveauAm extends Amelioration{

    /**
     * Var : le nouveau niveau du joueur ou autre
     */
    private int nouveauNiveau;

    //Cosntructeur de la classe
    public NiveauAm(Modele m, int niveau, Amelioration amNec) {
        super(m);
        typeBatiment = HDV;
        this.amNec = amNec;

        //En fonction du niveau les stats de ressource augmente (niveau 1 ou 2)
        switch (niveau) {
            case 0:
                coutBois = 300;
                coutPierre = 300;
                coutNourriture = 300;
                coutPopulation = 5;
                dureeAmelioration = 30;

                nouveauNiveau = 1;
                break;
            case 1:
                coutBois = 500;
                coutPierre = 500;
                coutNourriture = 500;
                coutPopulation = 8;
                dureeAmelioration = 50;

                nouveauNiveau = 2;
                break;
        }
    }

    @Override
    public boolean testCondition() {
        //Verifie que les ressources du joueur sont superieurs ou egalent au ressources necessaires
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
