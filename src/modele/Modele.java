package modele;

import modele.tuille.Tuille;
import modele.unite.Unite;
import vue.Vue;

import modele.grille.Grille;

public class Modele {
    private final Vue V;

    public Grille grille;
    public Unite unites[][];

    public Modele(Vue v){
        V = v;
        grille = new Grille();
        unites = new Unite[Grille.HAUTEUR][Grille.LARGEUR];
    }

}
