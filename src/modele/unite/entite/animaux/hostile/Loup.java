package modele.unite.entite.animaux.hostile;

import modele.Modele;

//Classe qui definie les loups
//Extends Hostile car la classe est une classe fille de Hostile
public class Loup extends Hostile{

    //Constructeur de la classe
    public Loup(int x, int y, Modele m) {
        super(x, y, m);
        x_texture = 6;
        y_texture = 2;

        largeur = 1;
        hauteur = 1;

        pv = 7;
        attaque = 2;
        defense = 0;
        quantiteRessource = 200;

    }

    @Override
    public String getNom() {
        return "Loup";
    }
}
