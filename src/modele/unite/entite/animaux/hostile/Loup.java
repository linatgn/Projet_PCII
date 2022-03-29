package modele.unite.entite.animaux.hostile;

import modele.Modele;
import modele.unite.entite.villageois.Tache;
import vue.panel.InfoPanel;

public class Loup extends Hostile{

    Tache tache;

    public Loup(int x, int y, Modele m) {
        super(x, y, m);
        x_texture = 6;
        y_texture = 2;

        largeur = 1;
        hauteur = 1;

        quantiteRessource = 200;

        tache = Tache.RIEN;
    }

    @Override
    public String getNom() {
        return "Loup";
    }

    public void update() {
        switch(tache) {
            case ATTAQUE:
                tache = Tache.ATTAQUE;
                break;
        }
    }
}
