package modele.unite.entite.animaux;

import modele.Modele;
import modele.TypeRessource;
import modele.unite.entite.Direction;
import modele.unite.entite.Entite;
import modele.unite.entite.villageois.Tache;
import vue.panel.InfoPanel;

import java.util.Random;

abstract public  class Animaux extends Entite {

    int x_spawn;
    int y_spawn;

    Tache tache;

    public Animaux(int x, int y, Modele m) {
        super(x, y, m);

        typeRessource = TypeRessource.NOURRITURE;

        tache = Tache.RIEN;

        x_spawn = x;
        y_spawn = y;
    }

    public void update() {
        switch(tache) {
            case RIEN:
                int i = new Random().nextInt(99);
                if (i >= 90) {
                    int nx = 0, ny = 0;
                    i = new Random().nextInt(4);
                    switch(i) {
                        case 0:
                            nx = x - 1;
                            ny = y;
                            if (distance(nx, ny, x_spawn, y_spawn) < 4) {
                                deplacer(Direction.HAUT);
                            }
                            break;
                        case 1:
                            nx = x + 1;
                            ny = y;
                            if (distance(nx, ny, x_spawn, y_spawn) < 4) {
                                deplacer(Direction.BAS);
                            }
                            break;
                        case 2:
                            nx = x;
                            ny = y + 1;
                            if (distance(nx, ny, x_spawn, y_spawn) < 4) {
                                deplacer(Direction.DROITE);
                            }
                            break;
                        case 3:
                            nx = x;
                            ny = y - 1;
                            if (distance(nx, ny, x_spawn, y_spawn) < 4) {
                                deplacer(Direction.GAUCHE);
                            }
                            break;
                    }
                }
                break;
        }
    }

    public double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((Math.pow(x2 - x1, 2)) + (Math.pow(y2 - y1, 2)));
    }
}
