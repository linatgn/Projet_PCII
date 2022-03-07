package modele.unite;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

abstract public  class  Entite {
    public int pt_vie = 50;
    public int pt_attaque = 0;
    public int pt_defense = 0;

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

    public Entite(int point,int attaque,int defense) {
        pt_vie = point;
        pt_attaque = attaque;
        pt_defense = defense;

    }

}