package modele.unite.entite;

import modele.Modele;
import modele.TypeRessource;
import modele.tuille.Tuille;
import modele.unite.Unite;
import vue.panel.InfoPanel;

abstract public  class  Entite extends Unite {
    public int pv;
    public int attaque;
    public int defense;


    public Entite(int x, int y, Modele m) {
        super(x, y, m);

    }
}
