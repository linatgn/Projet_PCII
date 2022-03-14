package modele.unite.structure.batiment;

import modele.Modele;

public class Ferme extends Batiment {

    public Ferme(int x, int y, Modele m) {
        super(x, y,m);
        x_texture = 5;
        y_texture = 2;

        largeur = 1;
        hauteur = 1;
    }
}
