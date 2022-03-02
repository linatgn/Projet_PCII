package modele.tuille;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *  classe parentes des tuilles de la grille de jeu
 */
abstract public class Tuille {
    public static int TAILLE_TUILLE = 16;

    /**
     * Tileset du jeu
     */
    public static BufferedImage TILESET;

    public int x;
    public int y;

    public int x_texture;
    public int y_texture;

    public boolean solid;

    /**
     *  Charge le tileset en memoire
     */
    public static void loadTileset(){
        try{
            TILESET = ImageIO.read(new File("tileset.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
}
