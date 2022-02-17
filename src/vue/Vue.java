package vue;

import javax.swing.*;
import java.awt.*;

import vue.panel.InfoPanel;
import vue.panel.JeuPanel;
import vue.panel.RessourcePanel;

/**
 * Classe qui gere l'affichage du jeu
 * Extends JPanel pour l'afficahge
 */
public class Vue extends JFrame {

    //Declaration des Panel
    public static InfoPanel infoPanel;
    public static JeuPanel jeuPanel;
    public static RessourcePanel ressourcePanel;

    public static final int LARGEUR = 1280;
    public static final int HAUTEUR = 720;

    //Constructeur de la classe

    public Vue() {
        // Frame
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));
        setTitle("Age of Empire de la Hess");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(new BorderLayout());

        // Panels

        JPanel panelGauche = new JPanel();
        panelGauche.setLayout(new BorderLayout());

        ressourcePanel = new RessourcePanel();
        jeuPanel = new JeuPanel();
        infoPanel = new InfoPanel();

        panelGauche.add(ressourcePanel,BorderLayout.NORTH);
        panelGauche.add(jeuPanel,BorderLayout.SOUTH);

        add(panelGauche,BorderLayout.WEST);
        add(infoPanel,BorderLayout.EAST);

        pack();
    }
}