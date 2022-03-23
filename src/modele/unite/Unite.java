package modele.unite;

import modele.Modele;
import modele.TypeRessource;
import vue.panel.InfoPanel;

abstract public class Unite {
    protected int x;
    protected int y;

    protected final Modele M;

    public int x_texture;
    public int y_texture;

    public int largeur;
    public int hauteur;

    public TypeRessource typeRessource; // type de la ressource stocké par l'entite
    public int quantiteRessource;

    public Unite(int x, int y, Modele m){
        this.x = x;
        this.y = y;
        this.M = m;
    }
    public boolean deplacer(Direction d) {
        switch (d) {
            case HAUT:
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

            case BAS:
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

                case DROITE:
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
            case GAUCHE:
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

    abstract public String getNom();
}
