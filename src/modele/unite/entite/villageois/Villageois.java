package modele.unite.entite.villageois;

import modele.Modele;
import modele.unite.entite.Entite;

public class Villageois extends Entite {

    public Villageois(int x, int y, Modele m) {
        super(x, y, m);
        x_texture = 6;
        y_texture = 0;

        System.out.println(x_texture);
    }

}

