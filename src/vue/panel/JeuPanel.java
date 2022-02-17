package vue.panel;



import javax.swing.*;
import java.awt.*;


public class JeuPanel extends JPanel {

    /**
     * Const : Largeur de l'affichage
     */
    public static final int LARGEUR = 1280-256;

    /**
     * Const : Hauteur de l'affichage
     */
    public static final int HAUTEUR = 720-32;

    public JeuPanel(){

        // Panel
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));

        //background
        setBackground(Color.BLUE);

        //title
        JLabel title = new JLabel("Jeu");
        title.setForeground(Color.BLACK);
        add(title);
    }
}
