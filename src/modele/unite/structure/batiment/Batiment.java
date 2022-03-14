package modele.unite.structure.batiment;

import modele.Modele;
import modele.unite.structure.Structure;

/**
 *  classe parentes des batiments de la grille de jeu
 */
public class Batiment extends Structure {


    /**
     *
     * @param x
     * @param y
     *
     * Constructeur d'une tuille
     */
    public Batiment(int x, int y, Modele m){
        super(x,y,m);
        this.x = x;
        this.y = y;
    }
}
