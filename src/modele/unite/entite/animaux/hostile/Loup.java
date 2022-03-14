package modele.unite.entite.animaux.hostile;

import modele.Modele;

public class Loup extends Hostile{
    public Loup(int x, int y, Modele m) {
        super(x, y, m);
        x_texture = 6;
        y_texture = 2;

        largeur = 1;
        hauteur = 1;
    }
}
