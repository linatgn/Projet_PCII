package modele.unite.entite.animaux.hostile;

import modele.Modele;
import modele.unite.Unite;
import modele.unite.entite.Entite;
import modele.unite.entite.animaux.Animaux;
import modele.unite.entite.animaux.passif.Lapin;
import modele.unite.entite.villageois.Tache;
import modele.unite.entite.villageois.Villageois;

//Classe qui definie les animaux hostiles
//Extends Animaux car la classe est une classe fille de Animaux
abstract public class Hostile extends Animaux {

    /**
     * Var : Distance actuel du focus
     */
    protected int distanceFocus;

    /**
     * Var : Distance max avant de perdre le focus
     */
    protected int maxZoneFocus;

    /**
     * Var : L'unite que le loup cible
     */
    protected Entite uniteCiblee;

    //Constructeur de la classe
    public Hostile(int x, int y, Modele m) {
        super(x, y, m);

        distanceFocus = 3;
        maxZoneFocus = 10;
    }

    /**
     * Update le comportement de l'animal en fonction de la tache
     */
    public void update() {
        //Verifie la tache attribue a l'animal
        switch(tache) {
            case RIEN:
                //Verifie que il y'a aucune cible a trouver
                if (!trouverCible()) {
                    deplacementAleatoire();
                }
                break;
            case ATTAQUE:
                attaquer((Entite) uniteCible);
                if(distance(x_spawn,y_spawn,x,y) > distanceFocus)
                    tache = Tache.RETOUR;
                break;
            case RETOUR:
                if(chemin.isEmpty())
                    calculerChemin(x_spawn,y_spawn);
                else if(!deplacer(chemin.pop()))
                    calculerChemin(x_spawn,y_spawn);
        }
    }

    /**
     * Focus un lapin parmis la liste des Entite qui sont dans une distance de max de distanceFocus
     * @return true si les conditions sont respecté, false sinon
     */
    public boolean trouverCible() {
        for(int i = 0; i < M.listeEntite.size(); i++) {
            //Verifie que l'entite est un villageois ou un lapin
            if (M.listeEntite.get(i) instanceof Villageois || M.listeEntite.get(i) instanceof Lapin) {
                //Verifie que l'entite cible est dans la distanceFocus
                if (distance(M.listeEntite.get(i).getX(), M.listeEntite.get(i).getY(), x, y) <= distanceFocus) {
                    uniteCible = M.listeEntite.get(i);
                    tache = Tache.ATTAQUE;
                    System.out.println(M.listeEntite.get(i) + " a pris le focus du loup !" );
                    return true;
                }
            }
        }
        return false;
    }

}
