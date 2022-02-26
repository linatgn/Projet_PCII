package modele.grille;

import modele.tuille.*;
import vue.panel.JeuPanel;

import java.awt.*;

/**
 * tableau 2D gerant la liste des tuilles du jeu
 */
public class Grille {

    public static int LARGEUR = 10;
    public static int HAUTEUR = 10;

    private Tuille[][] tuilles;

    /** Constructeur */
    public Grille() {

        // Initialisation des tuilles
        tuilles = new Tuille[HAUTEUR][LARGEUR];
        for(int i=0; i<HAUTEUR; i++) {
            for(int j=0; j<LARGEUR; j++){
                tuilles[i][j] = new Sable(i,j);
            }
        }
    }

    public Point getTuilleTexturePosition(int i, int j){
       return new Point(tuilles[i][j].x_texture,tuilles[i][j].y_texture);
    }
}