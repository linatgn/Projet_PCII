package modele.unite.entite.villageois;

import modele.Modele;
import modele.unite.Unite;
import modele.unite.entite.Entite;
import modele.unite.entite.animaux.Animaux;
import modele.unite.structure.Recoltable;

public class Villageois extends Entite {
    Tache tache;

    public Villageois(int x, int y, Modele m) {
        super(x, y, m);
        x_texture = 6;
        y_texture = 0;

        largeur = 1;
        hauteur = 1;

        tache = Tache.RIEN;

        System.out.println(x_texture);
    }

    public void recolte(int x,  int y) {

    }


    public void cible(Unite unite) {
        if (unite instanceof Recoltable) {
            tache = Tache.RECOLTE;
        }
        else if (unite instanceof Animaux) {
            tache = Tache.ATTAQUE;
        }
        else if (unite == null) {
            tache = Tache.DEPLACE;
        }
        //System.out.println("Ceci est un arbre TEST" + " " + unite );
    }

    public void update() {

    }

}

