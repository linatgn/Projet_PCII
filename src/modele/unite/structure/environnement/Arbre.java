package modele.unite.structure.environnement;

import modele.Modele;
import modele.unite.structure.environnement.Environnement;

public class Arbre extends Environnement {

    public Arbre(int x, int y, Modele m) {
        super(x, y,m);
        x_texture = 2;
        y_texture = 0;

        largeur = 1;
        hauteur = 1;
    }
}
