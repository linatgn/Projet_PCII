package modele.unite.entite.animaux.hostile;

import modele.Modele;
import modele.unite.Unite;
import modele.unite.entite.Direction;
import modele.unite.entite.Entite;
import modele.unite.entite.animaux.Animaux;
import modele.unite.entite.animaux.passif.Lapin;
import modele.unite.entite.villageois.Tache;
import modele.unite.entite.villageois.Villageois;
import vue.panel.InfoPanel;

import java.util.Random;

abstract public class Hostile extends Animaux {

    protected int distanceAgro;
    protected int maxZoneAgro;  //Distance max avant de perdre l'aggro.
    protected Unite uniteCiblee;

    public Hostile(int x, int y, Modele m) {
        super(x, y, m);

        distanceAgro = 3;
        maxZoneAgro = 10;
    }

    public void update() {
        switch(tache) {
            case RIEN:
                if (!trouverCible()) {
                    deplacementAleatoire();
                }
                break;
            case ATTAQUE:
                //attaquer cible unitée
                break;
        }
    }

    public void deplacementAleatoire() {
        int i = new Random().nextInt(99);
        if (i >= 90) {
            int nx = 0, ny = 0;
            i = new Random().nextInt(4);
            switch(i) {
                case 0:
                    nx = x - 1;
                    ny = y;
                    if (distance(nx, ny, x_spawn, y_spawn) < maxZone) {
                        deplacer(Direction.HAUT);
                    }
                    break;
                case 1:
                    nx = x + 1;
                    ny = y;
                    if (distance(nx, ny, x_spawn, y_spawn) < maxZone) {
                        deplacer(Direction.BAS);
                    }
                    break;
                case 2:
                    nx = x;
                    ny = y + 1;
                    if (distance(nx, ny, x_spawn, y_spawn) < maxZone) {
                        deplacer(Direction.DROITE);
                    }
                    break;
                case 3:
                    nx = x;
                    ny = y - 1;
                    if (distance(nx, ny, x_spawn, y_spawn) < maxZone) {
                        deplacer(Direction.GAUCHE);
                    }
                    break;
            }
        }
    }

    public boolean trouverCible() {
        for(int i = 0; i < M.listeEntite.size(); i++) {
            if (M.listeEntite.get(i) instanceof Villageois || M.listeEntite.get(i) instanceof Lapin) {
                if (distance(M.listeEntite.get(i).getX(), M.listeEntite.get(i).getY(), x, y) <= distanceAgro) {
                    uniteCible = M.listeEntite.get(i);
                    tache = Tache.ATTAQUE;
                    System.out.println(M.listeEntite.get(i) + " a pris l'aggro du loup !" );
                    return true;
                }
                System.out.println(M.listeEntite.get(i) + " a PERDU l'aggro du loup !" );
            }
        }
        return false;
    }

}
