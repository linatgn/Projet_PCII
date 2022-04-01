package controle;

import modele.Modele;
import modele.unite.Unite;
import modele.unite.entite.villageois.Villageois;
import vue.Vue;
import modele.tuille.Tuille;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ControleJeu implements MouseListener {

    private final Modele modele;

    public ControleJeu(Modele m, Vue v) {
        modele = m;
    }
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {   // si click gauche sur la jeuPanel
            int x = e.getX();
            int y = e.getY();

            modele.select(y /Tuille.TAILLE_TUILLE, x /Tuille.TAILLE_TUILLE);
        }
        else if (SwingUtilities.isRightMouseButton(e)) {   // si click gauche sur infoPanel
            int x = e.getX();
            int y = e.getY();

            if (modele.uniteSelectionnee instanceof Villageois) {
                ((Villageois)modele.uniteSelectionnee).cible(y /Tuille.TAILLE_TUILLE,x /Tuille.TAILLE_TUILLE);
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