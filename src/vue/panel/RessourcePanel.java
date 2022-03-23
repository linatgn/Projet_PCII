package vue.panel;


import javax.swing.*;
import java.awt.*;

public class RessourcePanel extends JPanel{

    /**
     * Const : Largeur de l'affichage
     */
    public static final int LARGEUR = 1280-256;

    /**
     * Const : Hauteur de l'affichage
     */
    public static final int HAUTEUR = 32;

    public RessourcePanel(){

        // Panel
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));

        //background
        setBackground(Color.YELLOW);

        //title
        JLabel title = new JLabel("Ressource");
        title.setForeground(Color.BLACK);
        add(title);

        System.out.println(getLayout());
    }

    /*
    @Override
    public void paint(Graphics g) {
    }

     */
}
