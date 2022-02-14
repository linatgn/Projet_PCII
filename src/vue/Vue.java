package vue;

import javax.swing.*;
import java.awt.*;

import vue.panel.InfoPanel;

//Classe qui gere l'affichage du jeu
//Extends JPanel pour l'afficahge
public class Vue extends JFrame {

    //Affichage de la fenetre de jeu et ajout du MouseListener
    //JFrame fenetre = new JFrame("Age Of Empire de La Hess");

    //Constructeur de la classe
    public Vue() {
        //Creation de la fenetre et ses dimensions
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1280, 720));
        //add(this);
        //fenetre.addMouseListener( new Control(this,this.etat));
        pack();
        setVisible(true);


    }

}