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

    JFrame fenetre = new JFrame("Age Of Empire de La Hess");

    //Constructeur de la classe
    public Vue(){

        //Creation de la fenetre et ses dimensions
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setPreferredSize(new Dimension(1280, 720));


        // ajout des panel
        infoPanel = new InfoPanel();
        jeuPanel = new JeuPanel();
        ressourcePanel = new RessourcePanel();



        fenetre.setContentPane(infoPanel);
        add(infoPanel);
        fenetre.pack();
        fenetre.setVisible(true);


    }

}