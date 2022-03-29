package modele.unite.structure.batiment;

import modele.Modele;
import modele.TypeBatiment;
import modele.unite.structure.Structure;
import vue.panel.InfoPanel;

/**
 *  classe parentes des batiments de la grille de jeu
 */
public abstract class Batiment extends Structure {

    public TypeBatiment typeBatiment;
    private boolean enConstruction;

    public Batiment(int x, int y, Modele m){
        super(x,y,m);
        this.x = x;
        this.y = y;
        enConstruction = true;
    }

    public boolean getEnConstruction() {
        return enConstruction;
    }
}
