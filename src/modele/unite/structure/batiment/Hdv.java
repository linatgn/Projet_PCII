package modele.unite.structure.batiment;

import modele.Modele;
import modele.TypeBatiment;
import vue.panel.InfoPanel;

public class Hdv extends Batiment {

    public Hdv(int x, int y, Modele m) {
        super(x, y,m);
        x_texture = 3;
        y_texture = 0;

        largeur = 2;
        hauteur = 2;

        enConstruction = false;

        typeBatiment = TypeBatiment.HDV;
    }

    @Override
    protected void activerBatiment() {
    }

    @Override
    public String getNom() {
        return "HDV";
    }
}