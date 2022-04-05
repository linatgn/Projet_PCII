package controle;

import modele.Modele;
import modele.amelioration.Amelioration;
import vue.Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Classe qui va servir controler les améliorations
//implements MouseListener car les améliorations sont fait où le click a été fait
public class ControleAmelioration implements MouseListener {

    /**
     * Const : Declaration d'une amelioration
     */
    private final Amelioration AMELIORATION;

    /**
     * Const : Panel s'occupant de l'affichage des ameliorations
     */
    private final JPanel AMELIORATION_PANEL;


    //Constructeur de la classe
    public ControleAmelioration(JPanel ap, Amelioration a) {
        AMELIORATION = a;
        AMELIORATION_PANEL = ap;
    }

    /**
     * Verifie si le click est un click gauche et execute le code suivant
     * @param e
     */
    public void mouseClicked(MouseEvent e) {
        // si click gauche sur la jeuPanel
        if (SwingUtilities.isLeftMouseButton(e)) {
            //Verifie que l'amelioration est possible
            if(AMELIORATION.testCondition() && !AMELIORATION.timerLancer){
                //Lance un timer et set le panel de la couleur cyan
                AMELIORATION.lancerTimer();
                AMELIORATION_PANEL.setBackground(Color.CYAN);
            }
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
        //Verifie que le timer de l'amelioration n'est pas encore lance
        if(!AMELIORATION.timerLancer)
            //Modifie la couleur du panel en blanc
            AMELIORATION_PANEL.setBackground(Color.WHITE);
    }


    /**
     * Execute le code ci-dessous lorsque la souris sort du panel
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {
        //Verifie que le timer de l'amelioration n'est pas encore lance
        if(!AMELIORATION.timerLancer)
            //Modifie la couleur du panel en gris
            AMELIORATION_PANEL.setBackground(Color.GRAY);
    }
}
