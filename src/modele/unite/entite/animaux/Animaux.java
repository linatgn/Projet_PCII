package modele.unite.entite.animaux;

import modele.Modele;
import modele.TypeRessource;
import modele.unite.entite.Direction;
import modele.unite.entite.Entite;
import modele.unite.entite.Tache;

import java.util.Random;

//Classe qui definie les animaux
//Extends Entite car la classe est une classe fille de Entite
abstract public  class Animaux extends Entite {

    /**
     * Coordonee x de l'apparition de l'animal
     */
    protected int x_spawn;

    /**
     * Coordonee y de l'apparition de l'animal
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

    /**
     * Update le comportement et le deplacement des animaux
     */
    public void update() {
        switch(tache) {
            case RIEN:
                deplacementAleatoire();
                break;
        }
    }

    /**
     * Effectue un deplacement aleatoire
     */
    public void deplacementAleatoire() {
        int i = new Random().nextInt(99);
        if (i >= 90) {
            int nx = 0, ny = 0;
            i = new Random().nextInt(4);
            switch(i) {
                //Deplacement aleatoire vers le haut
                case 0:
                    nx = x - 1;
                    ny = y;
                    if (distance(nx, ny, x_spawn, y_spawn) < maxZone) {
                        deplacer(Direction.HAUT);
                    }
                    break;
                //Deplacement aleatoire vers le bas
                case 1:
                    nx = x + 1;
                    ny = y;
                    if (distance(nx, ny, x_spawn, y_spawn) < maxZone) {
                        deplacer(Direction.BAS);
                    }
                    break;
                //Deplacement aleatoire vers la droite
                case 2:
                    nx = x;
                    ny = y + 1;
                    if (distance(nx, ny, x_spawn, y_spawn) < maxZone) {
                        deplacer(Direction.DROITE);
                    }
                    break;
                //Deplacement aleatoire vers la gauche
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

    /**
     * Renvoie la distance entre deux points
     * @param x1 Coordonee x du premier point
     * @param y1 Coordonee y du premier point
     * @param x2 Coordonee x du second point
     * @param y2 Coordonee y du second point
     * @return distance
     */
    public double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((Math.pow(x2 - x1, 2)) + (Math.pow(y2 - y1, 2)));
    }
}
