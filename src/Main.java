import vue.Vue;
import vue.panel.InfoPanel;
import vue.panel.JeuPanel;
import vue.panel.RessourcePanel;

import javax.swing.*;
import java.awt.*;

public class Main{

    public static void main(String [] args) {
        JFrame fen = new JFrame("Une fenetre Swing");
        fen.setSize(400,200);

        JPanel pan = new JPanel();
        fen.setContentPane(pan);
        fen.setVisible(true);
        pan.setBackground(Color.red);
        Vue vue = new Vue();
    }

}