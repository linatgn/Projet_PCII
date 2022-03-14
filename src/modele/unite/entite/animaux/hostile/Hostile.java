package modele.unite.entite.animaux.hostile;

import modele.Modele;
import modele.unite.entite.animaux.Animaux;

abstract class Hostile extends Animaux {

    public Hostile(int x, int y, Modele m) {
        super(x, y, m);
    }
}
