package modele.unite.structure.batiment;

import modele.Modele;

public class Hdv extends Batiment {

    public Hdv(int x, int y, Modele m) {
        super(x, y,m);
        x_texture = 3;
        y_texture = 0;

        LARGEUR = 2;
        HAUTEUR = 2;
    }
}