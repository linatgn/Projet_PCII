package modele.unite.entite;

import java.util.LinkedList;

import modele.Modele;
import modele.TypeRessource;
import modele.tuille.Tuille;
import modele.unite.Unite;
import modele.unite.entite.animaux.Animaux;
import modele.unite.structure.Recoltable;
import vue.panel.InfoPanel;

abstract public  class  Entite extends Unite {
    public int pv;
    public int attaque;
    public int defense;

    protected LinkedList<Direction> chemin;


    public Entite(int x, int y, Modele m) {
        super(x, y, m);
        chemin = new LinkedList<>();

    }

    public void attaque(Entite cible) {
        System.out.println(cible + " " + "est attaqué");
    }
}
