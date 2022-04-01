package modele.unite.entite.villageois;

import modele.Modele;
import modele.grille.Grille;
import modele.unite.entite.Direction;
import modele.unite.entite.Entite;
import vue.panel.InfoPanel;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class Villageois extends Entite {

    public Villageois(int x, int y, Modele m) {
        super(x, y, m);
        x_texture = 6;
        y_texture = 0;

        largeur = 1;
        hauteur = 1;

        pv = m.pvVillageois;
        attaque = m.attaqueVillageois;
        defense = m.defenseVillageois;
    }
    @Override
    public String getNom() {
        return "Villageois";
    }

}
