package vue.panel;



import modele.Modele;
import modele.grille.Grille;
import modele.tuille.Tuille;
import vue.Vue;

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

    private Modele M;
    private Vue V;

    public JeuPanel(Modele m, Vue v){
        //recuperation du modele
        M = m;
        V = v;

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
                Point textureCoord = new Point(M.grille.getTuille(i,j).x_texture,M.grille.getTuille(i,j).y_texture);
                textureCoord.x *= Tuille.TAILLE_TUILLE;
                textureCoord.y *= Tuille.TAILLE_TUILLE;

                // Initialisation de la sous image de la texture
                subImg = V.TILESET.getSubimage(
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
        for(int i=0; i<Grille.HAUTEUR; i++) {
            for (int j = 0; j < Grille.LARGEUR; j++) {

                if (M.unites[i][j] != null) {
                    // Recuperation de la position de la texture de l'unité

                    Point textureCoord = new Point(M.unites[i][j].x_texture, M.unites[i][j].y_texture);
                    textureCoord.x *= Tuille.TAILLE_TUILLE;
                    textureCoord.y *= Tuille.TAILLE_TUILLE;
                    //System.out.println(M.unites[i][j].x_texture + " " + M.unites[i][j].y_texture);

                    System.out.println(textureCoord);
                    // Initialisation de la sous image de la texture
                    subImg = V.TILESET.getSubimage(
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
}
