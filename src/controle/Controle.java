package controle;

import modele.Modele;
import vue.Vue;
import modele.tuille.Tuille;
import modele.grille.Grille;

import javax.swing.*;
import java.awt.event.MouseEvent;


public class Controle {

    private final Modele modele;
    private Vue vue;

    public Controle(Modele m, Vue v) {
        modele = m;
        vue = v;
    }
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            int x = e.getX();
            int y = e.getY();

// si click gauche sur la jeuPanel

            if (0 <= x/Tuille.TAILLE_TUILLE && x <= Grille.LARGEUR && 0 <= y/Tuille.TAILLE_TUILLE && y <= Grille.HAUTEUR) {
                Modele.select(x,y);
                System.out.print("Clique gauche!" + " " + x + " " + y);

            }

// si click gauche sur infoPanel

        }
        else if (SwingUtilities.isRightMouseButton(e)) {
            int x = e.getX();
            int y = e.getY();
            if (0 <= x/Tuille.TAILLE_TUILLE && x <= Grille.LARGEUR && 0 <= y/Tuille.TAILLE_TUILLE && y <= Grille.HAUTEUR) {
                Modele.cible();   //cible TO DO
                System.out.print("Clique droit!" + " " + x + " " + y);
            }
        }
    }
}
