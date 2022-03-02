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
    public static final int HAUTEUR = 688;

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

        // Affichage des tuilles

        for(int i=0; i<Grille.HAUTEUR; i++) {
            for(int j=0; j<Grille.LARGEUR; j++){

                // Recuperation de la position de la texture de la tuille
                Point textureCoord = grille.getTuilleTexturePosition(i,j);
                textureCoord.x *= Tuille.TAILLE_TUILLE;
                textureCoord.y *= Tuille.TAILLE_TUILLE;

                // Initialisation de la sous image de la texture
                subImg = Tuille.TILESET.getSubimage(
                        textureCoord.y,
                        textureCoord.x,
                        Tuille.TAILLE_TUILLE,
                        Tuille.TAILLE_TUILLE);

                // Affichage de la sous image
                g2d.drawImage(subImg,
                        null,
                        j * Tuille.TAILLE_TUILLE,
                        i * Tuille.TAILLE_TUILLE);
            }
        }
    }
}
