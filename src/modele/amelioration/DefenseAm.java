package modele.amelioration;

import modele.Modele;
import modele.unite.entite.Entite;
import modele.unite.entite.villageois.Villageois;

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
                coutNourriture = 100;
                coutPierre = 100;
                defense = 2;
                dureeAmelioration = 20;

                niveauJoueur = 1;
                break;
            case 2:
                coutNourriture = 200;
                coutPierre = 200;
                defense = 3;
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
        for(Entite entite : M.listeEntite){
            if(entite instanceof Villageois){
                ((Villageois)entite).updateDefense();
            }
        }
        if(M.uniteSelectionnee instanceof Villageois)
            M.V.infoPanel.updateStatistique();
        activer = true;
    }

    @Override
    public String getNom() {
        return "Défense " + defense;
    }
}