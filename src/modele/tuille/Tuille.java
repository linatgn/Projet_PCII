package modele.tuille;

import modele.grille.Grille;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *  classe parentes des tuilles de la grille de jeu
 */
public class Tuille {
    public static int TAILLE_TUILLE = 16;



    public int x;
    public int y;

    public int x_texture;
    public int y_texture;

    public boolean solid;

    /**
     *
     * @param x
     * @param y
     *
     * Constructeur d'une tuille
     */
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