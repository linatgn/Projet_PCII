package modele.grille;

import modele.unite.structure.batiment.Batiment;
import modele.tuille.*;


//tableau 2D gerant la liste des tuilles du jeu
public class Grille {

    /**
     * Var : Largeur de la grille
     */
    public static int LARGEUR = 64;

    /**
     * Var : Hauteur de la grille
     */
    public static int HAUTEUR = 43;

    /**
     * Var : Tableau de tuilles 2D
     */
    public Tuille[][] tuilles;

    //Constructeur de la classe
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

    /**
     * Getter de la variable Hauteur
     * @return la hauteur
     */
    public static int getHAUTEUR() {
        return HAUTEUR;
    }

    /**
     * Getter de la variable Largeur
     * @return la largeur
     */
    public static int getLARGEUR() {
        return LARGEUR;
    }

    /**
     * Getter de la variable Tuiller
     * @param i le nombre de lignes
     * @param j le bombre de collones
     * @return le tableau a 2 dimensions Tuilles
     */
    public Tuille getTuille(int i, int j){
        return tuilles[i][j];
    }

}