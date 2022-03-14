package modele;

import modele.unite.structure.batiment.Ferme;
import modele.unite.Unite;
import modele.unite.structure.batiment.Hdv;
import modele.unite.structure.batiment.Maison;
import modele.unite.structure.environnement.Arbre;
import modele.unite.structure.environnement.Rocher;
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
        unites[0][0] = new Ferme(0,0,this);
        unites[Grille.HAUTEUR/2][Grille.LARGEUR/2] = new Hdv(Grille.HAUTEUR/2,Grille.LARGEUR/2,this);
        unites[1][1] = new Maison(1,1,this);
        unites[2][2] = new Rocher(2,2,this);
        unites[3][3] = new Arbre(3,3,this);
    }

}
