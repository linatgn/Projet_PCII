package modele.unite.entite.animaux.passif;

import modele.Modele;

public class Lapin extends Passif{
    public Lapin(int x, int y, Modele m) {
        super(x, y, m);
        x_texture = 6;
        y_texture = 1;

        largeur = 1;
        hauteur = 1;
    }
}
