package modele.unite.entite;

import modele.Modele;
import modele.TypeRessource;
import modele.tuille.Tuille;
import modele.unite.Unite;
import vue.panel.InfoPanel;

import java.util.ArrayList;

abstract public  class  Entite extends Unite {
    public int pv;
    public int attaque;
    public int defense;

    public ArrayList<Noeud> chemin;
    public Pathfinder path;


    public Entite(int x, int y, Modele m) {

        super(x, y, m);
    }


    /**
     * Methode qui calcule le chemin d'une entite pour aller d'un point a un autre grâce à
     * l'algorithme A*
     * @param x,y
     * @return void
     * La methode remplie un tableau de noeuds qui represente le chemin que doit prendre l'unite * * pour aller au point (x,y)
     */

    public void pathFinder(int x, int y) {

    }
}
