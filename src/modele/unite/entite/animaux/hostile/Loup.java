package modele.unite.entite.animaux.hostile;

import modele.Modele;
import modele.unite.entite.villageois.Tache;
import vue.panel.InfoPanel;

public class Loup extends Hostile{

    public Loup(int x, int y, Modele m) {
        super(x, y, m);
        x_texture = 6;
        y_texture = 2;

        largeur = 1;
        hauteur = 1;

        quantiteRessource = 200;
        pv = 7;
        attaque = 3;
        defense = 0;
    }

    @Override
    public String getNom() {
        return "Loup";
    }
}
