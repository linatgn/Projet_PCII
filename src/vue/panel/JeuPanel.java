package vue.panel;



import modele.grille.Grille;
import modele.tuille.Sable;
import modele.tuille.Tuille;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class JeuPanel extends JPanel {

    /**
     * Const : Largeur de l'affichage
     */
    public static final int LARGEUR = 1280-256;

    /**
     * Const : Hauteur de l'affichage
     */
    public static final int HAUTEUR = 720;

    private Grille grille;

    public JeuPanel(Grille G){
        //recuperation de la grille de jeu
        grille = G;

        // Chargement du tileset pour l'affichage des tuilles
        Tuille.loadTileset();

        // Panel
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage subImg;
        Graphics2D g2d = (Graphics2D) g.create();

        for(int i=0; i<grille.HAUTEUR; i++) {
            for(int j=0; j<grille.LARGEUR; j++){
                Point textureCoord = grille.getTuilleTexturePosition(i,j);
                textureCoord.x *= Tuille.TAILLE_TUILLE;
                textureCoord.y *= Tuille.TAILLE_TUILLE;

                subImg = Tuille.TILESET.getSubimage(
                        textureCoord.y,
                        textureCoord.x,
                        Tuille.TAILLE_TUILLE,
                        Tuille.TAILLE_TUILLE);
                g2d.drawImage(subImg,
                        null,
                        i * Tuille.TAILLE_TUILLE,
                        j * Tuille.TAILLE_TUILLE);
            }
        }
    }
}
