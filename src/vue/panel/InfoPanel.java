package vue.panel;
import vue.Vue;

import javax.swing.*;
import java.awt.*;



public class InfoPanel extends JPanel{
    /**
     * Const : Largeur de l'affichage
     */
    public static final int LARGEUR = 256;

    /**
     * Const : Hauteur de l'affichage
     */
    public static final int HAUTEUR = 1280;

    public InfoPanel(){

        // Panel
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));

        // background
        setBackground(Color.BLACK);

        // Title
        JLabel title = new JLabel("Information");
        title.setForeground(Color.WHITE);
        add(title);
    }



}
