package modele.unite.entite;

import modele.Modele;
import modele.tuille.Tuille;
import modele.unite.Unite;

abstract public  class  Entite extends Unite {
    public int pt_vie;
    public int pt_attaque;
    public int pt_defense;

    public Entite(int x, int y, Modele m) {
        super(x, y, m);

    }

}










