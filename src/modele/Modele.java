package modele;

import modele.unite.Unite;
import modele.unite.entite.villageois.Villageois;
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
        unites[6][6] = new Villageois(6,6, this);
        System.out.println(unites[6][6].x_texture);
    }

}
