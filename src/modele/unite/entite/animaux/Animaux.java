package modele.unite.entite.animaux;

import modele.Modele;
import modele.TypeRessource;
import modele.unite.entite.Direction;
import modele.unite.entite.Entite;
import modele.unite.entite.villageois.Tache;
import vue.panel.InfoPanel;

import java.util.Random;

//Classe qui definie les animaux
//Extends Entite car la classe est une classe fille de Entite
abstract public  class Animaux extends Entite {

    /**
     *
     */
    protected int x_spawn;

    /**
     *
     */
    protected int y_spawn;

    /**
     * Var : Distance maximale à laquelle un animal peut se deplacer en faisant rien
     */
    protected int maxZone;

    //Constructeur de la classe
    public Animaux(int x, int y, Modele m) {
        super(x, y, m);

        typeRessource = TypeRessource.NOURRITURE;

        tache = Tache.RIEN;

        x_spawn = x;
        y_spawn = y;

        maxZone = 4;
    }

    public void update() {
        switch(tache) {
            case RIEN:
                deplacementAleatoire();
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

    public double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((Math.pow(x2 - x1, 2)) + (Math.pow(y2 - y1, 2)));
    }
}
