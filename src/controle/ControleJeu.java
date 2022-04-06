package controle;

import modele.Modele;
import modele.unite.Unite;
import modele.unite.entite.Entite;
import modele.unite.entite.villageois.Tache;
import modele.unite.entite.villageois.Villageois;
import modele.unite.structure.batiment.Ferme;
import modele.unite.structure.batiment.Maison;
import vue.Vue;
import modele.tuille.Tuille;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Classe qui va servir controler le jeu
//implements MouseListener car les controles sont fait où le click a été fait
public class ControleJeu implements MouseListener {

    //Declaration d'un modele
    private final Modele modele;

    //Constructeur de la classe
    public ControleJeu(Modele m, Vue v) {
        modele = m;
    }

    /**
     * Execute le code si dessous à chaque click
     * @param e
     */
    public void mouseClicked(MouseEvent e) {
        // si click gauche sur la jeuPanel
        if (SwingUtilities.isLeftMouseButton(e)) {
            //Recupere les coordonnees du click sur le panel a l'aide de getter
            int x = e.getX();
            int y = e.getY();
            if (modele.modeConstruction) {
                if (modele.grille.getTuille(y / Tuille.TAILLE_TUILLE, x / Tuille.TAILLE_TUILLE).solid == false) {
                    switch (modele.batimentAConstruire) {
                        case MAISON:
                            modele.uniteSelectionnee.uniteCible = new Maison(y / Tuille.TAILLE_TUILLE, x / Tuille.TAILLE_TUILLE, modele);
                            modele.bois -= Maison.COUT_BOIS;
                            modele.pierre -= Maison.COUT_PIERRE;
                            break;
                        case FERME:
                            modele.uniteSelectionnee.uniteCible = new Ferme(y / Tuille.TAILLE_TUILLE, x / Tuille.TAILLE_TUILLE, modele);
                            modele.bois -= Ferme.COUT_BOIS;
                            modele.pierre -= Ferme.COUT_PIERRE;
                            break;
                    }
                    ((Villageois) modele.uniteSelectionnee).setTache(Tache.CONSTRUIT);
                }
                modele.modeConstruction = false;
            } else {
                //Selectionne l'unite de la position x et y
                modele.select(y / Tuille.TAILLE_TUILLE, x / Tuille.TAILLE_TUILLE);
            }
        }
        // si click gauche sur infoPanel
        else if (SwingUtilities.isRightMouseButton(e)) {
            //Recupere les coordonnees du click sur le panel a l'aide de getter
            int x = e.getX();
            int y = e.getY();
            //Verifie que le unite selectionnee avec le click est un villageois
            if (modele.uniteSelectionnee instanceof Villageois) {
                //Selectionne l'unite de la position x et y
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