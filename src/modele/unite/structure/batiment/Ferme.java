package modele.unite.structure.batiment;

import modele.Modele;
import modele.TypeBatiment;

public class Ferme extends Batiment {

    public Ferme(int x, int y, Modele m) {
        super(x, y,m);
        x_texture = 5;
        y_texture = 2;

        largeur = 1;
        hauteur = 1;

        typeBatiment = TypeBatiment.FERME;
        quantiteRessource = m.quantiteRessourceFerme;
    }

    @Override
    public String getNom() {
        return "Ferme";
    }
}
