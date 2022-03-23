package modele.unite.entite.animaux;

import modele.Modele;
import modele.TypeRessource;
import modele.unite.entite.Entite;
import vue.panel.InfoPanel;

abstract public  class Animaux extends Entite {

    public Animaux(int x, int y, Modele m) {
        super(x, y, m);

        typeRessource = TypeRessource.NOURRITURE;
    }

}
