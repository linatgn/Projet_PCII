package modele.unite.structure.batiment;

import modele.Modele;

public class Maison extends Batiment {

    public Maison(int x, int y, Modele m) {
        super(x, y,m);
        x_texture = 3;
        y_texture = 2;

        largeur = 1;
        hauteur = 1;
    }
}