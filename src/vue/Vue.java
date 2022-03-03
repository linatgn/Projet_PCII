package vue;

import javax.swing.*;
import java.awt.*;

import vue.panel.InfoPanel;
import vue.panel.JeuPanel;
import vue.panel.RessourcePanel;

import modele.Modele;

/**
 * Classe qui gere l'affichage du jeu
 * Extends JPanel pour l'afficahge
 */
public class Vue extends JFrame {
    private Modele M;

    //Declaration des Panel
    public InfoPanel infoPanel;
    public JeuPanel jeuPanel;
    public RessourcePanel ressourcePanel;

    public static final int LARGEUR = 1280;
    public static final int HAUTEUR = 720;

    /** Constructeur */
    public Vue() {
        M = new Modele(this);

        // Frame
        getContentPane().setPreferredSize(new Dimension(LARGEUR,HAUTEUR));
        setTitle("Age of Empire de la Hess");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(new BorderLayout());

        // Initialisation et positionnement des Panels.

        JPanel panelGauche = new JPanel();
        panelGauche.setLayout(new BorderLayout());

        ressourcePanel = new RessourcePanel();
        jeuPanel = new JeuPanel(M);
        infoPanel = new InfoPanel();

        panelGauche.add(ressourcePanel,BorderLayout.NORTH);
        panelGauche.add(jeuPanel,BorderLayout.SOUTH);
        panelGauche.setPreferredSize(new Dimension(LARGEUR-InfoPanel.LARGEUR,HAUTEUR));

        add(panelGauche,BorderLayout.WEST);
        add(infoPanel,BorderLayout.EAST);

        pack();
    }
}