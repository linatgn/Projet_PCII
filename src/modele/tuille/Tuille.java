package modele.tuille;

import modele.grille.Grille;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


//Classe parentes qui definie les tuilles de la grille de jeu
public class Tuille {

    /**
     *
     */
    public static int TAILLE_TUILLE = 16;

    /**
     * Var : Position x de la tuille sur le tableau de tuille
     */
    public int x;

    /**
     * Var : Position y de la tuille sur le tableau de tuille
     */
    public int y;

    /**
     * Var : Position x d'une tuille sur le tailset
     */
    public int x_texture;

    /**
     * Var : Position y d'une tuille sur le tailset
     */
    public int y_texture;

    /**
     * Var : Tuille solide ou non
     */
    public boolean solid;

    //Construteur de la classe
    public Tuille(int x, int y){
        this.x = x;
        this.y = y;
    }

    /* public static Tuille ofGridPosition(int gridX, int gridY) {
        return new Tuille(gridX * TAILLE_TUILLE + TAILLE_TUILLE / 2, gridY * TAILLE_TUILLE + TAILLE_TUILLE / 2);
    }

    public int gridX() {
        return (int) (x / TAILLE_TUILLE);
    }

    public int gridY() {
        return (int) (y / TAILLE_TUILLE);
    }
     */
}