package modele.unite.entite;

import modele.grille.Grille;
import modele.tuille.Tuille;

public class Noeud implements Comparable<Noeud>  {

    private int distanceParcourue;
    private int heuristique;
    private int gridX;
    private int gridY;
    private int distanceTotale;
    private Noeud parent;

    public Noeud(int distanceParcourue, int heuristique, int gridX, int gridY) {
        this.distanceParcourue = distanceParcourue;
        this.heuristique = heuristique;
        this.gridX = gridX;
        this.gridY = gridY;
    }

    @Override
    public int compareTo(Noeud cout) {
        return Integer.compare(this.distanceTotale, cout.distanceTotale);
    }

    /*public Tuille getPosition() {
        return Tuille.ofGridPosition(gridX, gridY);
    }
     */
}
