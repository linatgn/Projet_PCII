package controle;

import modele.Modele;
import modele.amelioration.Amelioration;
import vue.Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ControleAmelioration implements MouseListener {

    private final Amelioration AMELIORATION;
    private final JPanel AMELIORATION_PANEL;


    public ControleAmelioration(JPanel ap, Amelioration a) {
        AMELIORATION = a;
        AMELIORATION_PANEL = ap;
    }
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {   // si click gauche sur la jeuPanel
            if(AMELIORATION.testCondition()){
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

    @Override
    public void mouseEntered(MouseEvent e) {
        if(!AMELIORATION.timerLancer)
            AMELIORATION_PANEL.setBackground(Color.WHITE);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(!AMELIORATION.timerLancer)
            AMELIORATION_PANEL.setBackground(Color.GRAY);
    }
}
