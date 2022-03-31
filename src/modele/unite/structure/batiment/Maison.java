package modele.unite.structure.batiment;

import modele.Modele;
import modele.TypeBatiment;
import vue.panel.InfoPanel;

public class Maison extends Batiment {

    public Maison(int x, int y, Modele m) {
        super(x, y,m);

        largeur = 1;
        hauteur = 1;

        tickRequis = 20;

        typeBatiment = TypeBatiment.MAISON;
    }

    @Override
    protected void activerBatiment() {
        M.maxPopulation += 2;

        x_texture = 3;
        y_texture = 2;

        super.activerBatiment();
    }

    @Override
    public String getNom() {
        return "Maison";
    }


}