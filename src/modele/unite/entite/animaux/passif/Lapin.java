package modele.unite.entite.animaux.passif;

import modele.Modele;
import vue.panel.InfoPanel;

public class Lapin extends Passif{
    public Lapin(int x, int y, Modele m) {
        super(x, y, m);
        x_texture = 6;
        y_texture = 1;

        largeur = 1;
        hauteur = 1;

        quantiteRessource = 100;
    }

    @Override
    public String getNom() {
        return "Lapin";
    }
}
