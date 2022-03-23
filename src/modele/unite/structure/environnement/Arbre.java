package modele.unite.structure.environnement;

import modele.Modele;
import modele.TypeRessource;
import modele.unite.structure.environnement.Environnement;
import vue.panel.InfoPanel;

public class Arbre extends Environnement {

    public Arbre(int x, int y, Modele m) {
        super(x, y,m);
        x_texture = 2;
        y_texture = 0;

        largeur = 1;
        hauteur = 1;

        typeRessource = TypeRessource.BOIS;
        quantiteRessource = 1000;
    }

    @Override
    public String getNom() {
        return "Arbre";
    }

}
