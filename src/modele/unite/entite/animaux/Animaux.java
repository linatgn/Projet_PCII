package modele.unite.entite.animaux;

import modele.Modele;
import modele.TypeRessource;
import modele.unite.entite.Entite;
import modele.unite.entite.villageois.Tache;
import vue.panel.InfoPanel;

import java.util.Random;

abstract public  class Animaux extends Entite {

    int xS;
    int yS;

    int nx;
    int ny;

    Tache tache;

    public Animaux(int x, int y, Modele m) {
        super(x, y, m);

        typeRessource = TypeRessource.NOURRITURE;

        tache = Tache.RIEN;


        nx = 0;
        ny = 0;

        xS = xS;
        yS = yS;
    }

    public void update() {
        switch(tache) {

            case RIEN:
                int i = new Random().nextInt(95);
                if (i >= 95 && siDistance()) {
                    i = new Random().nextInt(5);
                    switch(i) {
                        case 0:
                            nx = x - 1;
                            ny = y;
                            break;
                        case 1:
                            nx = x + 1;
                            ny = y;
                            break;
                        case 2:
                            nx = x;
                            ny = y - 1;
                            break;
                        case 3:
                            nx = x;
                            ny = y + 1;
                            break;
                    }
                }
                break;
        }
    }

    public boolean siDistance() {
        if (Math.sqrt((Math.pow(nx - xS, 2)) + (Math.pow(ny - yS, 2))) < 4) {
            return true;
        }
        else {
            return false;
        }
    }
}
