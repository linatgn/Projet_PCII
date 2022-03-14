package modele;

import modele.timer.Timer;
import modele.tuille.Herbe;
import modele.unite.Unite;
import vue.Vue;

import modele.grille.Grille;

public class Modele {
    private final Vue V;
    private int i = 0;

    public Grille grille;
    public Unite unites[][];

    public final Timer timer = new Timer(this);

    public Modele(Vue v){
        V = v;
        grille = new Grille();
        unites = new Unite[Grille.HAUTEUR][Grille.LARGEUR];
    }

    public void start(){
        timer.run();
    }

    public void update(){
        V.jeuPanel.revalidate();
        V.jeuPanel.repaint();
        i++;
    }
}
