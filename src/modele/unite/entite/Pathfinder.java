package modele.unite.entite;

import modele.grille.Grille;
import modele.tuille.Tuille;
import vue.panel.JeuPanel;


import java.util.*;

public class Pathfinder {

   /*  public static List<Tuille> findPath(Tuille depart, Tuille arrive, JeuPanel jeuPanel) {
        final PriorityQueue<Noeud> open = new PriorityQueue<>();
        final Set<Noeud> closed = new HashSet<>();
        final Noeud[][] nodeMap = new Noeud[Grille.getTuille2().length][Grille.getTuille2()[0].length];
        Noeud actuel;

        for (int x = 0; x < nodeMap.length; x++) {
            for (int y = 0; y < nodeMap[0].length; y++) {
                int heuristique = Math.abs(x - arrive.gridX()) + Math.abs(y - arrive.gridY());
                Noeud node = new Noeud(10, heuristique, x, y);
                nodeMap[x][y] = node;
                System.out.println(node + " " + depart + " " + arrive);
            }
        }
        return List.of(depart);
    }

    */
}