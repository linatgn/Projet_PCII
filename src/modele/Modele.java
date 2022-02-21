package modele;

import vue.Vue;

import modele.grille.Grille;

public class Modele {
    private final Vue V;

    public Grille grille;

    public Modele(Vue v){
        V = v;
        grille = new Grille();

    }

}
