package controle;

import modele.Modele;
import modele.TypeBatiment;
import modele.amelioration.Amelioration;
import modele.unite.structure.batiment.Ferme;
import modele.unite.structure.batiment.Maison;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Classe qui va servir controler les améliorations
//implements MouseListener car les améliorations sont fait où le click a été fait
public class ControleConstruction implements MouseListener {

    /**
     * Const : Declaration d'une amelioration
     */
    private final TypeBatiment BATIMENT;

    /**
     * Const : Panel s'occupant de l'affichage des ameliorations
     */
    private final JPanel CONSTRUCTION_PANEL;

    private final Modele M;

    //Constructeur de la classe
    public ControleConstruction(JPanel cp, TypeBatiment tp, Modele m) {
        BATIMENT = tp;
        CONSTRUCTION_PANEL = cp;
        M = m;
    }

    /**
     * Verifie si le click est un click gauche et execute le code suivant
     * @param e
     */
    public void mouseClicked(MouseEvent e) {
        // si click gauche sur la jeuPanel
        if (SwingUtilities.isLeftMouseButton(e)) {

            // si on a pas les ressources pour contruire le batiment, on fait rien
            switch (BATIMENT){
                case FERME -> {
                    if (M.bois < Ferme.COUT_BOIS || M.pierre < Ferme.COUT_PIERRE)
                        return;
                }
                case MAISON -> {
                    if (M.bois < Maison.COUT_BOIS || M.pierre < Maison.COUT_PIERRE)
                        return;
                }
            }

            // sinon on passe en mode construction
            M.batimentAConstruire = BATIMENT;
            M.modeConstruction = true;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * Execute le code ci-dessous lorsque la souris entre dans le panel
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        CONSTRUCTION_PANEL.setBackground(Color.WHITE);
    }


    /**
     * Execute le code ci-dessous lorsque la souris sort du panel
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {
        CONSTRUCTION_PANEL.setBackground(Color.GRAY);
    }
}
