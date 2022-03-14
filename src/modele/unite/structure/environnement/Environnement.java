package modele.unite.structure.environnement;


import modele.Modele;
import modele.unite.structure.Structure;

/**
 *  classe parentes des batiments de la grille de jeu
 */
public class Environnement extends Structure {
    /**
     *
     * @param x
     * @param y
     *
     * Constructeur d'une tuille
     */
    public Environnement(int x, int y, Modele m){
        super(x,y,m);
        this.x = x;
        this.y = y;
    }
}