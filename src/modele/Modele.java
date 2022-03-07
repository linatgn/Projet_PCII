package modele;

import modele.tuille.Tuille;
import modele.unite.Unite;
import vue.Vue;

import modele.grille.Grille;

public class Modele {
    private final Vue V;

    public Grille grille;
    public static Unite[][] unites;
    public static Unite uniteSelectionee;

    public Modele(Vue v) {
        V = v;
        grille = new Grille();
        unites = new Unite[Grille.HAUTEUR][Grille.LARGEUR];
    }

    public static void select(int x, int y) {
        uniteSelectionee = unites[x][y];
        System.out.print("Select work !");
    }
    public static void cible() {
    }
/*
    public static void cible(unites) {
        if (uniteSelectionee == villageois) {
            if (unites == animal) {
//TODO methode attaque + pathfinder
            }
            else if (unites == ressource) {
//TODO methode recolte + pathfinder
            }
            }
            if (uniteSelectionee == hdv) {
//TODO new affichage dans le infoPanel
            }
            if (uniteSelectionee == batiment) {
//??
            }
//TODO IF LAC ETC.
        }
 */
}
