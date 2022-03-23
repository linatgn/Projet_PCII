package modele.unite.structure.batiment;

import modele.Modele;
import modele.TypeBatiment;
import vue.panel.InfoPanel;

public class Maison extends Batiment {

    public Maison(int x, int y, Modele m) {
        super(x, y,m);
        x_texture = 3;
        y_texture = 2;

        largeur = 1;
        hauteur = 1;

        typeBatiment = TypeBatiment.MAISON;
    }

    @Override
    public String getNom() {
        return "Maison";
    }
}