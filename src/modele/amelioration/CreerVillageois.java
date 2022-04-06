package modele.amelioration;

import modele.Modele;
import modele.unite.entite.villageois.Villageois;

import static modele.TypeBatiment.HDV;

//Ammelioration qui sert a creer un villageois
//Extends Amelioration car la classe est une classe fille de Amelioration
public class CreerVillageois extends Amelioration{

    //Constructeur de la classe
    public CreerVillageois(Modele m, int niveau, Amelioration amNec) {
        super(m);
        typeBatiment = HDV;
        this.amNec = amNec;
        coutNourriture = M.coutVillageois;

        switch (niveau) {
            case 1:
                dureeAmelioration = 20;

                niveauJoueur = 0;
                break;
        }
    }

    @Override
    public boolean testCondition() {
        //Verifie que les ressources du joueur sont superieurs ou egales au ressources necessaires
        return(
                M.nourriture >= coutNourriture &&
                M.population < M.maxPopulation);
    }

    @Override
    public void activer() {
        if(M.grille.getTuille(M.hdv.getX()-1,M.hdv.getY()).solid)
            M.nourriture += coutNourriture;
        else{
            new Villageois(M.hdv.getX()-1,M.hdv.getY(),M);
        }

        timerAmelioration = 0;
        timerLancer = false;
    }

    @Override
    public String getNom() {
        return "Villageois";
    }
}
