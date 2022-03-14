package modele.unite;

import modele.Modele;
import modele.unite.entite.Direction;

abstract public class Unite {
    protected int x;
    protected int y;

    protected final Modele M;

    public int x_texture;
    public int y_texture;


    public int LARGEUR;
    public int HAUTEUR;


    public Unite(int x, int y, Modele m){
        this.x = x;
        this.y = y;
        this.M = m;
    }
    public boolean deplacer(Direction d) {
        switch (d) {
            case haut:
                if (M.grille.getTuille(x - 1, y).solid)
                    return false;
                else {

                    // Deplacement dans unites
                    M.unites[x - 1][y] = this;
                    M.unites[x][y] = null;

                    // Modification des tuilles
                    M.grille.getTuille(x - 1, y).solid = true;
                    M.grille.getTuille(x, y).solid = false;

                    // mise a jour des coordonnées dans l'unite
                    x = x - 1;
                    return true;
                }

            case bas:
                if(M.grille.getTuille(x+1,y).solid )
                    return false;
                else{
                    // Deplacement dans unites
                    M.unites[x + 1][y] = this;
                    M.unites[x][y] = null;

                    // Modification des tuilles
                    M.grille.getTuille(x + 1, y).solid = true;
                    M.grille.getTuille(x, y).solid = false;

                    // mise a jour des coordonnées dans l'unite
                    x = x + 1;
                    return true;
                }

                case droite:
                if(M.grille.getTuille(x,y+1).solid )
                    return false;
                else{
                    // Deplacement dans unites
                    M.unites[x][y+1] = this;
                    M.unites[x][y] = null;

                    // Modification des tuilles
                    M.grille.getTuille(x, y+1).solid = true;
                    M.grille.getTuille(x, y).solid = false;

                    // mise a jour des coordonnées dans l'unite
                    y=y+1;
                    return true;
                }
            case gauche:
                if(M.grille.getTuille(x,y-1).solid )
                    return false;
                else{
                    // Deplacement dans unites
                    M.unites[x][y-1] = this;
                    M.unites[x][y] = null;

                    // Modification des tuilles
                    M.grille.getTuille(x, y-1).solid = true;
                    M.grille.getTuille(x, y).solid = false;

                    // mise a jour des coordonnées dans l'unite
                    y = y-1;
                    return true;

                }
        }
        return false;

    }
}
