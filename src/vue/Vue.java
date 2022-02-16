package vue;

import javax.swing.*;
import java.awt.*;

import vue.panel.InfoPanel;
import vue.panel.JeuPanel;
import vue.panel.RessourcePanel;

//Classe qui gere l'affichage du jeu
//Extends JPanel pour l'afficahge
public class Vue extends JFrame {

    //Declaration des Panel
    public static InfoPanel infoPanel;
    public static JeuPanel jeuPanel;
    public static RessourcePanel ressourcePanel;
    public static JFrame frame;
    private int width;
    private int height;
    private JPanel Infopanel;
    private JPanel RessourcePanel;
    private JLabel title;
    private JLabel title2;

    //Constructeur de la classe
    public Vue(int w, int h) {
        frame = new JFrame();
        width = w;
        height = h;

        Infopanel = new JPanel(new GridLayout(0,1));
        Infopanel.setBackground(Color.BLACK);
        title = new JLabel("Information");
        title.setForeground(Color.WHITE);

        RessourcePanel = new JPanel(new GridLayout(1,0));
        RessourcePanel.setBackground(Color.YELLOW);
        title2 = new JLabel("Ressource");
        title2.setForeground(Color.BLACK);
    }

    public void setUPGUI() {
        frame.setSize(width,height);
        frame.setTitle("Age of Empire de la Hess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Infopanel.add(title);
        frame.add(Infopanel, BorderLayout.EAST);

        RessourcePanel.add(title2);
        frame.add(RessourcePanel, BorderLayout.SOUTH);

    }



        /* ajout des panel
        infoPanel = new InfoPanel();
        jeuPanel = new JeuPanel();
        ressourcePanel = new RessourcePanel();



        fenetre.setContentPane(infoPanel);
        add(infoPanel);
        fenetre.pack();
        fenetre.setVisible(true);
        */

}