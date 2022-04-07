package modele.amelioration;

import modele.Modele;

import static modele.TypeBatiment.FERME;

//Classe qui definie les ameliorations de la ferme
//Extends Amelioration car la classe est une classe fille de Amelioration
public class FermeAm extends Amelioration{

    /**
     * Var : La quantite de Ressource
     */
    private int quantiteRessource;

    //Constructeur de la classe
    public FermeAm(Modele m, int niveau, Amelioration amNec) {
        super(m);
        typeBatiment = FERME;
        this.amNec = amNec;

        //En fonction du niveau les stats de ressource augmente (niveau 1 ou 2)
        switch (niveau) {
            //Ferme Niveau 1
            case 1:
                coutBois = 300;
                coutPierre = 300;
                coutPopulation = 5;
                dureeAmelioration = 30;

                niveauJoueur = 0;
                quantiteRessource = 800;
                break;
            //Ferme Niveau 2
            case 2:
                coutBois = 500;
                coutPierre = 500;
                coutPopulation = 9;
                dureeAmelioration = 50;

                niveauJoueur = 2;
                quantiteRessource = 1500;
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
        M.quantiteRessourceFerme = quantiteRessource;
        activer = true;
    }

    @Override
    public String getNom() {
        return "capacité Ferme " + quantiteRessource;
    }
}
