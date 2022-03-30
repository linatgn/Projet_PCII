package modele.unite.entite;

import modele.Modele;
import modele.TypeRessource;
import modele.tuille.Tuille;
import modele.unite.Unite;
import vue.panel.InfoPanel;

abstract public  class  Entite extends Unite {
    public int pv;
    public int attaque;
    public int defense;


    public Entite(int x, int y, Modele m) {
        super(x, y, m);

    }

    public boolean estaCote(Unite cible){
        //Test à gauche
        if((x>0 && cible.getX() == x-1) && (cible.getY() == y)){
            return true;
        }
        //Test en haut
        else if ((cible.getX() == x) && (y>0 && cible.getY() == y-1)){
            return true;
        }
        //Test à droite
        else if ((x<M.grille.LARGEUR && cible.getX() == x+1) && (cible.getY() == y)){
            return true;
        }
        //Test en bas
        else if ((cible.getX() == x) && (y<M.grille.HAUTEUR && cible.getY() == y+1)){
            return true;
        }
        return false;
    }
}
