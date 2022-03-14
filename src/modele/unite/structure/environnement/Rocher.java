package modele.unite.structure.environnement;

import modele.Modele;
import modele.unite.structure.environnement.Environnement;

public class Rocher extends Environnement {

    public Rocher(int x, int y, Modele m) {
        super(x, y,m);
        x_texture = 2;
        y_texture = 1;

        largeur = 1;
        hauteur = 1;
    }
}
