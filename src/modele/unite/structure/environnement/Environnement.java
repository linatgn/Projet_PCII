package modele.unite.structure.environnement;


import modele.Modele;
import modele.unite.structure.Structure;
import vue.panel.InfoPanel;

/**
 *  classe parentes des batiments de la grille de jeu
 */
public abstract class Environnement extends Structure {

    public Environnement(int x, int y, Modele m){
        super(x,y,m);
    }
}