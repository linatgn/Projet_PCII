package vue;


import javax.swing.*;
import java.awt.*;

//Classe qui gere l'affichage du jeu
//Extends JPanel pour l'afficahge
public class Vue extends JPanel {


    //Affichage de la fenetre de jeu et ajout du MouseListener
    JFrame fenetre = new JFrame("Age Of Empire de La Hess");

    //Constructeur de la classe
    public Vue() {
        //Creation de la fenetre et ses dimensions
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 400));
        fenetre.add(this);
        //fenetre.addMouseListener( new Control(this,this.etat));
        fenetre.pack();
        fenetre.setVisible(true);


    }

}