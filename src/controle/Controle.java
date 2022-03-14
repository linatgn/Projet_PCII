package controle;

import modele.Modele;
import vue.Vue;
import modele.tuille.Tuille;
import modele.grille.Grille;
import vue.panel.JeuPanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Controle implements MouseListener {

    private final Modele modele;
    private Vue vue;

    public Controle(Modele m, Vue v) {
        modele = m;
        vue = v;
    }
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {   // si click gauche sur la jeuPanel
            int x = e.getX();
            int y = e.getY();
            System.out.println(vue.jeuPanel.getX() + " <= " + x + " && " +
                    x + " <= " + vue.jeuPanel.getX() + " + " + vue.jeuPanel.LARGEUR + " && " +
                    " ET " + vue.jeuPanel.getY() + " <= " + y + " && " +
                    y + " <= " + vue.jeuPanel.getY() + " + " + vue.jeuPanel.HAUTEUR);

            System.out.println((vue.jeuPanel.getX() <= x) + " && " +
                    (x   <=   vue.jeuPanel.getX() + vue.jeuPanel.LARGEUR) + " && " +
                    " ET " + (vue.jeuPanel.getY() <= y) + " && " +
                    (y <= vue.jeuPanel.getY() + vue.jeuPanel.HAUTEUR));
            if (vue.jeuPanel.getX()  <= x &&
                    x <= vue.jeuPanel.getX() + vue.jeuPanel.LARGEUR &&
                    vue.jeuPanel.getY() <= y &&
                    y <= vue.jeuPanel.getY() + vue.jeuPanel.HAUTEUR)
            {
                //Modele.select(x, y);
                System.out.println("Clique gauche!" + " " + (x - vue.jeuPanel.getX())/Tuille.TAILLE_TUILLE + " " + (y - vue.jeuPanel.getY())/Tuille.TAILLE_TUILLE);

            }
        }
        else if (SwingUtilities.isRightMouseButton(e)) {   // si click gauche sur infoPanel
            int x = e.getX();
            int y = e.getY();

            if (0 <= x/Tuille.TAILLE_TUILLE && x <= Grille.LARGEUR && 0 <= y/Tuille.TAILLE_TUILLE && y <= Grille.HAUTEUR) {
                Modele.cible();   //cible TO DO
                System.out.print("Clique droit!" + " " + x + " " + y);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
