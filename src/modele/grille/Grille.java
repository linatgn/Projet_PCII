package modele.grille;

import modele.unite.structure.batiment.Batiment;
import modele.tuille.*;

/**
 * tableau 2D gerant la liste des tuilles du jeu
 */
public class Grille {

    public static int LARGEUR = 64;
    public static int HAUTEUR = 43;

    public Tuille[][] tuilles;

    /** Constructeur */
    public Grille() {

        // Initialisation des tuilles
        tuilles = new Tuille[HAUTEUR][LARGEUR];
        for(int i=0; i<HAUTEUR; i++) {
            for(int j=0; j<LARGEUR; j++){
                if(i==0)
                    tuilles[i][j] = new Sable(i,j);
                else
                    tuilles[i][j] = new Sable(i,j);
            }
        }

    }

    public Tuille getTuille(int i, int j){

        return tuilles[i][j];

    }

}