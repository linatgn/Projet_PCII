package vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import controle.ControleJeu;
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
    /**
     * Tileset du jeu
     */
    public static BufferedImage TILESET;

    private ControleJeu controleJeu;

    /** Constructeur */
    public Vue() {
        M = new Modele(this);

        //chargement du tileset
        try{
            TILESET = ImageIO.read(new File("tileset.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Frame
        getContentPane().setPreferredSize(new Dimension(LARGEUR,HAUTEUR));
        setTitle("Age of Empire de la Hess");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(new BorderLayout());

        // ajout Listener
        controleJeu = new ControleJeu(M, this);

        // Initialisation et positionnement des Panels.

        JPanel panelGauche = new JPanel();
        panelGauche.setLayout(new BorderLayout());

        ressourcePanel = new RessourcePanel(M,this);
        jeuPanel = new JeuPanel(M,this);
        infoPanel = new InfoPanel(M,this);

        jeuPanel.addMouseListener(controleJeu);

        panelGauche.add(ressourcePanel,BorderLayout.NORTH);
        panelGauche.add(jeuPanel,BorderLayout.SOUTH);
        panelGauche.setPreferredSize(new Dimension(LARGEUR-InfoPanel.LARGEUR,HAUTEUR));

        add(panelGauche,BorderLayout.WEST);
        add(infoPanel,BorderLayout.EAST);


        pack();


        M.start();
    }

    public void affichageFinPartie(){
        JOptionPane.showMessageDialog(this,"Tout vos villageois sont morts", "FIN DE PARTIE ",JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    }
}